package com.leolang.imagepicker;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.pizidea.imagepicker.AndroidImagePicker;
import com.pizidea.imagepicker.bean.ImageItem;
import com.pizidea.imagepicker.ui.activity.ImagesGridActivity;

import java.util.List;

/**
 * Created by langneng on 16/8/5.
 */
public class ImagePickerModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mReactContext;
    private static final String TAG = "ImagePickerModule";
//    private ArrayList<String> selectedImages = new ArrayList<String>();
    private WritableArray selectedImages;

    public ImagePickerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ImagePickerModule";
    }

    @ReactMethod
    public void multiImagePicker(boolean isShowCamera,Callback errorCallback, final Callback successCallback){
        Log.e(TAG, "langneng android multiImagePicker has been called image-picker-react-native.");
        selectedImages = new WritableNativeArray();
        AndroidImagePicker.getInstance().pickMulti(getCurrentActivity(),isShowCamera,new AndroidImagePicker.OnImagePickCompleteListener(){

            @Override
            public void onImagePickComplete(List<ImageItem> items) {
                Log.e(TAG, "langneng items:" + items);
                  for(int i= 0;i<items.size();i++){
                      Log.e(TAG, "langneng selected image:" + items.get(i).path);
//                      selectedImages.add(items.get(i).path);
                      selectedImages.pushString(items.get(i).path);
                      Log.e(TAG, "langneng selectedImages:"+selectedImages);
                  }
                successCallback.invoke(selectedImages);

            }
        });
    }

    @ReactMethod
    public void finishMultiImagePicker(){
        Log.e(TAG,"langneng finishMultiImagePicker");
        ImagesGridActivity.instance.finish();
    }
}
