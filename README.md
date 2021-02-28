## PlayEffectView 

简介:音频播放效果


## 截图
![0](https://github.com/yuxiangxin/PlayEffectView/blob/master/ext/demo.gif)

## APP体验
[下载](https://github.com/yuxiangxin/PlayEffectView/blob/master/ext/demp.apk)

## 使用
拷贝[代码](https://github.com/yuxiangxin/PlayEffectView/blob/master/app/src/main/java/me/yu/playeffectview/PlayEffectView.java)至项目中

    //播放动画值,可以通过调整此数组值达到调整动画效果
    private float[] mAnimValues1 = {0.3F, 0.6F, 0.2F, 0.8F};
    private float[] mAnimValues2 = {0.8F, 0.1F, 0.6F, 0.9F};
    private float[] mAnimValues3 = {0.4F, 0.9F, 0.5F, 0.1F};
    private float[] mAnimValues4 = {0.6F, 0.3F, 0.8F, 0.2F};

布局中使用

    <me.yu.playeffectview.PlayEffectView
        android:id="@+id/play_effect_v"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginTop="12dp"
        android:background="#c0dbe7" />
 
代码中

    public void start (View view) {
        mPlayEffectView.start();
    }

    public void stop (View view) {
        mPlayEffectView.stop();
    }

