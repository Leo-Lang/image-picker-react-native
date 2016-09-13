#image-picker-react-native

该组件基于 https://github.com/easonline/AndroidImagePicker 封装成 react native 版本，并在实现上做了一些改动

## Installation

```
npm i --save image-picker-react-native
```

**on Android:**

####1. `android/settings.gradle`:: Add the following snippet

```
include ":image-picker-react-native"
project(':image-picker-react-native').projectDir = new File(rootProject.projectDir,'../node_modules/image-picker-react-native/android/imagepickermodule')
```

####2. `android/app/build.gradle`: Add in dependencies block.

```
compile project(':image-picker-react-native')
```

####3. in your `MainActivity` (or equivalent) the ImagePickerPackage needs to be added. Add the import at the top:

```
import com.leolang.imagepicker.ImagePickerPackage;
```
####4. In order for React Native to use the package, add it the packages inside of the class
```
@Override
protected List<ReactPackage> getPackages() {
  return Arrays.<ReactPackage>asList(
	new MainReactPackage(),
	...
	new ImagePickerPackage()
  );
}

```
## Usage
###js

```
import ImagePicker from 'ImagePicker';


```





##sample
   
###android/app & index.android.js