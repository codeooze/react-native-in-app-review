package com.codeoozereactnativeinappreview

import android.app.Activity
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.Task
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory


class ReactNativeInAppReviewModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "ReactNativeInAppReview"
    }

    private fun isGooglePlayServicesAvailable(): Boolean {
      val GMS: GoogleApiAvailability = GoogleApiAvailability.getInstance()
      val isGMS: Int = GMS.isGooglePlayServicesAvailable(reactApplicationContext)
      return isGMS == ConnectionResult.SUCCESS
    }

    @ReactMethod
      fun openInAppReview(promise: Promise) {

        if(isGooglePlayServicesAvailable()) {

          val manager = ReviewManagerFactory.create(reactApplicationContext)
          val request: Task<ReviewInfo> = manager.requestReviewFlow()

          request.addOnCompleteListener { task ->
            if (task.isSuccessful()) {
              val reviewInfo: ReviewInfo = task.getResult()
              val currentActivity: Activity? = currentActivity
              if (currentActivity == null) {
                promise.reject("Activity not found")
                return@addOnCompleteListener
              }
              val flow: Task<Void> = manager.launchReviewFlow(currentActivity, reviewInfo)
              flow.addOnCompleteListener { reviewFlow ->
                if(reviewFlow.isSuccessful()) {
                  promise.resolve("Success")
                } else {
                  promise.reject("Something went wrong")
                }
              }
            } else {
              val errMessage: Exception = task.exception as Exception
              promise.reject(errMessage)
            }
          }
        } else {
          promise.reject("Google Play Services Not Found")
        }

      }

    }
