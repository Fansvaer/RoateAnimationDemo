package com.renxin.cheku.roateanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgTwo;

    private Rotate3dAnimation openAnimation;
    private int centerX;
    private int centerY;
    private int depthZ = 400;
    private int duration = 600;
    private Rotate3dAnimation closeAnimation;
    private int positio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgTwo = findViewById(R.id.image_two);
        mImgTwo.setImageResource(R.drawable.timg);
    }

    public void click(View v) {
        centerX = mImgTwo.getWidth() / 2;
        centerY = mImgTwo.getHeight() / 2;
        if (closeAnimation == null) {
            initCloseAnim();
        }
        if (closeAnimation.hasStarted() && !closeAnimation.hasEnded()) {
            return;
        }
        mImgTwo.startAnimation(closeAnimation);
    }

    private void initOpenAnim() {
        openAnimation = new Rotate3dAnimation(270, 360, centerX, centerY, depthZ, true);
        openAnimation.setDuration(duration);
        openAnimation.setFillAfter(true);
        openAnimation.setInterpolator(new AccelerateInterpolator());
        openAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                mLogoIv.setVisibility(View.GONE);
//                mDescTv.setVisibility(View.VISIBLE);
//
//                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(270, 360, centerX, centerY, depthZ, false);
//                rotateAnimation.setDuration(duration);
//                rotateAnimation.setFillAfter(true);
//                rotateAnimation.setInterpolator(new DecelerateInterpolator());
//                mContentRl.startAnimation(rotateAnimation);
            }
        });
    }

    private void initCloseAnim() {
        closeAnimation = new Rotate3dAnimation(360, 270, centerX, centerY, depthZ, true);
        closeAnimation.setDuration(duration);
        closeAnimation.setFillAfter(true);
        closeAnimation.setInterpolator(new AccelerateInterpolator());
        closeAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImgTwo.setVisibility(View.VISIBLE);
                if (positio == 0) {
                    mImgTwo.setImageResource(R.drawable.cat);
                    positio = 1;
                } else {
                    mImgTwo.setImageResource(R.drawable.timg);
                    positio = 0;
                }
                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(90, 0, centerX, centerY, depthZ, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                mImgTwo.startAnimation(rotateAnimation);
            }
        });
    }
}
