import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package '@codeooze/react-native-in-app-review' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const ReactNativeInAppReview = NativeModules.ReactNativeInAppReview  ? NativeModules.ReactNativeInAppReview  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function openInAppReview(): Promise<any> {
  return ReactNativeInAppReview.openInAppReview();
}