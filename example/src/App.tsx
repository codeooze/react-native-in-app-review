import React from 'react';
import { openInAppReview } from '@codeooze/react-native-in-app-review';
import { View, StyleSheet, Text, Alert, Button } from 'react-native';

const App = () => {

  const showInAppReview = () => {

    openInAppReview()
      .then((response) => {
          //success
          Alert.alert(response)
      })
      .catch((error) => {
          //failure
          Alert.alert(error.message)
      })

  }

  return (
    <View style={styles.Container} >
      <Button 
        title={'Show in app review'}
        onPress={showInAppReview}
      />
      <Text style={styles.Text} >@codeooze/react-native-in-app-review</Text>
    </View>
  )
};

export default App;

const styles = StyleSheet.create({
  Container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },
  Text: {
    color: '#000',
    fontSize: 18,
    marginTop: 10
  }
})