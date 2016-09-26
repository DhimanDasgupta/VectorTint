package com.dhimandasgupta.vectortint;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ScaleTintActivity extends AppCompatActivity implements OnSeekBarChangeListener, OnPreDrawListener {
    Unbinder mUnbinder;

    @BindView(R.id.activity_scale_tint_seek_bar)
    AppCompatSeekBar mSeekBar;

    @BindView(R.id.activity_scale_tint_image_view)
    AppCompatImageView mImageView;

    private int mImageMaxEachSide;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_tint);

        mUnbinder = ButterKnife.bind(this);

        mSeekBar.setOnSeekBarChangeListener(this);

        mImageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        super.onDestroy();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        final int currentSize = mImageMaxEachSide * progress / seekBar.getMax();

        mImageView.getLayoutParams().width = currentSize;
        mImageView.getLayoutParams().height = currentSize;

        mImageView.requestLayout();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onPreDraw() {
        final int imageMaxWidth = mImageView.getWidth();
        final int imageMaxHeight = mImageView.getHeight();

        mImageMaxEachSide = imageMaxWidth < imageMaxHeight ? imageMaxWidth : imageMaxHeight;

        mImageView.getViewTreeObserver().removeOnPreDrawListener(this);

        return true;
    }

    @OnClick(R.id.activity_scale_tint_red_button)
    void onRedClicked() {
        tintColor(Color.RED);
    }

    @OnClick(R.id.activity_scale_tint_green_button)
    void onGreenClicked() {
        tintColor(Color.GREEN);
    }

    @OnClick(R.id.activity_scale_tint_blue_button)
    void onBlueClicked() {
        tintColor(Color.BLUE);
    }

    @OnClick(R.id.activity_scale_tint_gray_button)
    void onGrayClicked() {
        tintColor(Color.GRAY);
    }

    @OnClick(R.id.activity_scale_tint_magenta_button)
    void onMagentaClicked() {
        tintColor(Color.MAGENTA);
    }

    @OnClick(R.id.activity_scale_tint_cyan_button)
    void onCyanClicked() {
        tintColor(Color.CYAN);
    }

    @OnClick(R.id.activity_scale_tint_black_button)
    void onBlackClicked() {
        tintColor(Color.BLACK);
    }

    private void tintColor(@ColorInt int color) {
        final Drawable drawable = mImageView.getDrawable();
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        wrappedDrawable = wrappedDrawable.mutate();
        DrawableCompat.setTint(wrappedDrawable, color);
    }
}
