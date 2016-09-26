package com.dhimandasgupta.vectortint;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.widget.CompoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

public class AnimatedActivity extends AppCompatActivity {
    private Unbinder mUnbinder;

    @BindView(R.id.activity_animated_image_view)
    AppCompatImageView mImageView;

    @BindView(R.id.activity_animated_check_box)
    AppCompatCheckBox mCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated);

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @OnCheckedChanged(R.id.activity_animated_check_box)
    void onCheckChanged(CompoundButton button, boolean checked) {
        if (checked) {
            startLaugh();
        } else {
            stopLaugh();
        }
    }

    private void startLaugh() {
        final Drawable drawable = mImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        mCheckBox.setText("Stop Laughing");
    }

    private void stopLaugh() {
        final Drawable drawable = mImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }

        mCheckBox.setText("Start Laughing");
    }
}
