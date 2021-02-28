package me.yu.playeffectview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PlayEffectView mPlayEffectView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayEffectView = findViewById(R.id.play_effect_v);
    }

    public void start (View view) {
        mPlayEffectView.start();
    }

    public void stop (View view) {
        mPlayEffectView.stop();
    }
}
