package yu.demo.ui_playeffectview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private PlayEffectView mPlayEffectView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayEffectView = (PlayEffectView) findViewById(R.id.play_effect_v);
    }

    public void start (View view) {
        mPlayEffectView.start();
    }

    public void stop (View view) {
        mPlayEffectView.stop();
    }
}
