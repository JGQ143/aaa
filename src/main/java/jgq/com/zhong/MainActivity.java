package jgq.com.zhong;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count=3;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 200){
                if (count<0){
                    Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                textview.setText(count--+"s");
                handler.sendEmptyMessageDelayed(200,1000);
            }
        }
    };

    private TextView textview;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textview);

        image = findViewById(R.id.imageview);

        handler.sendEmptyMessage(200);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);

        alphaAnimation.setRepeatCount(0);

        alphaAnimation.setRepeatMode(Animation.REVERSE);

        alphaAnimation.setDuration(3000);

        image.setAnimation(alphaAnimation);

    }
}
