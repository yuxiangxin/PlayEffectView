## PlayEffectView 

音频播放效果

##截图
![0](.\ext\demo.gif)

## APP体验下载
[下载](.\ext\demo.mp4)
##使用    
	
布局中使用

    <yu.demo.ui_playeffectview.PlayEffectView
        android:id="@+id/play_effect_v"
        android:layout_width="30dp"
        android:layout_height="30dp"
        />	
 
代码中

    public void start (View view) {
        mPlayEffectView.start();
    }

    public void stop (View view) {
        mPlayEffectView.stop();
    }

>PlayView
