/*
 *
 *  * Copyright (C) 2015 Eason.Lai (easonline7@gmail.com)
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.pizidea.imagepicker.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leolang.imagepicker.R;
import com.pizidea.imagepicker.AndroidImagePicker;
import com.pizidea.imagepicker.ui.AvatarCropFragment;


/**
 * 截取头像
 */
public class ImageCropActivity extends FragmentActivity implements View.OnClickListener{

    private TextView btnReChoose;
    private TextView btnOk;
    private ImageView ivShow;

    AvatarCropFragment mFragment;

    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        btnOk = (TextView) findViewById(R.id.btn_pic_ok);
        btnReChoose = (TextView) findViewById(R.id.btn_pic_rechoose);
        ivShow = (ImageView) findViewById(R.id.iv_show);
        btnOk.setOnClickListener(this);
        btnReChoose.setOnClickListener(this);

        imagePath = getIntent().getStringExtra(AndroidImagePicker.KEY_PIC_PATH);
        mFragment = new AvatarCropFragment();
        Bundle data = new Bundle();
        data.putString(AndroidImagePicker.KEY_PIC_PATH,imagePath);
        mFragment.setArguments(data);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mFragment)
                .commit();

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_pic_ok){
            Bitmap bmp = mFragment.getCropBitmap(AndroidImagePicker.getInstance().cropSize);
            finish();
            AndroidImagePicker.getInstance().notifyImageCropComplete(bmp,0);
        }else if(v.getId() == R.id.btn_pic_rechoose){
            finish();
        }

    }


}
