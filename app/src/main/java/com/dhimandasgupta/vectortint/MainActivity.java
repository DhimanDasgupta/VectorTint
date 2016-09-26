package com.dhimandasgupta.vectortint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        super.onDestroy();
    }

    @OnClick(R.id.activity_main_scale_tint_button)
    void onScaleTintButtonClicked() {
        startActivity(new Intent(this, ScaleTintActivity.class));
    }

    @OnClick(R.id.activity_main_animated_drawable_button)
    void onAnimatedDrawableButtonClicked() {
        startActivity(new Intent(this, AnimatedActivity.class));
    }
}
