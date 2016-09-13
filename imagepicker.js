/**
 * Created by langneng on 16/8/17.
 */

var AndroidImagePicker = require('NativeModules').ImagePickerModule;

var ImagePicker ={
      multiImagePicker:function(isShowCamera,errorCallback,successCallback){
         console.log("langneng multiImagePicker");
         AndroidImagePicker.multiImagePicker(isShowCamera,errorCallback,successCallback);
      },

      finishMultiImagePicker:function(){
         console.log("langneng finishMultiImagePicker");
         AndroidImagePicker.finishMultiImagePicker();
      }
};

module.exports = ImagePicker;
