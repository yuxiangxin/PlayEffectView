package me.yu.playeffectview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;

import java.util.ArrayList;

/**
 * Created by yuxiangxin on 18/2/25
 * 描述: 音频播放效果
 */
public class PlayEffectView extends View {
    private static final String TAG = "PlayEffectView";
    private Paint mPaint;
    private float mLineWidth;
    private int mWidth, mHeight;
    private int mColor = Color.RED;
    private static final int sDuration = 2000;
    private final float[] mNextAnimValues = {0.3F, 0.6F, 0.2F, 0.8F};
    private static final float[] sAnimValues1 = {0.3F, 0.6F, 0.2F, 0.8F};
    private static final float[] sAnimValues2 = {0.8F, 0.1F, 0.6F, 0.9F};
    private static final float[] sAnimValues3 = {0.4F, 0.9F, 0.5F, 0.1F};
    private static final float[] sAnimValues4 = {0.6F, 0.3F, 0.8F, 0.2F};
    private AnimatorSet mAnimatorSet;

    public PlayEffectView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setColor (int color) {
        mColor = color;
        mPaint.setColor(color);
        invalidate();
    }

    private void init () {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
        mAnimatorSet = new AnimatorSet();
    }

    @Override
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mNextAnimValues.length; i++) {
            float left = 2 * i * mLineWidth;
            float right = mLineWidth + left;
            canvas.drawRect(left, mHeight - (mNextAnimValues[i] * mHeight), right, mHeight, mPaint);
        }
        Log.v(TAG, "onDraw");
    }

    @Override
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mLineWidth = (float) mWidth / (mNextAnimValues.length * 2 - 1);
    }

    private Animator createAnimator (final int position, final float... value) {
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(value);
        valueAnimator.setDuration(sDuration);
        valueAnimator.setInterpolator(new CycleInterpolator(0.2f));
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate (ValueAnimator animation) {
                mNextAnimValues[position] = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        return valueAnimator;
    }

    public void start () {
        ArrayList<Animator> animators = new ArrayList<>();
        animators.add(createAnimator(0, sAnimValues1));
        animators.add(createAnimator(1, sAnimValues2));
        animators.add(createAnimator(2, sAnimValues3));
        animators.add(createAnimator(3, sAnimValues4));
        mAnimatorSet.playTogether(animators);
        if (!mAnimatorSet.isRunning()) {
            mAnimatorSet.start();
        }
    }

    public void stop () {
        if (mAnimatorSet != null && mAnimatorSet.isRunning()) {
            mAnimatorSet.cancel();
            invalidate();
        }

    }

    public void setPlay (boolean playing) {
        if (playing) {
            start();
        } else {
            stop();
        }
    }
}