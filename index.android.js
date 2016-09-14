/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

 import ImagePicker from 'image-picker-react-native';

class ImagePickerLeo extends Component {
  componentDidMount(){
      ImagePicker.multiImagePicker(false, (errorMsg) => {
          console.log("multiImagePicker errorMsg:" + errorMsg);
      }, (selectedUrls) => {
          console.log("langneng RKAlbum multiImagePicker success");
          console.log("langneng RKAlbum selectedUrls:" + selectedUrls);
          ImagePicker.finishMultiImagePicker();
      });
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('ImagePickerLeo', () => ImagePickerLeo);
