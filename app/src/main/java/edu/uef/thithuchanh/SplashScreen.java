package edu.uef.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView app_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imageView);
        app_name = findViewById(R.id.textView2);

        imageView.setAnimation(topAnim);
        app_name.setAnimation(bottomAnim);
        addEvent();
    }

    private void addEvent() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair(imageView, "splash_image");
                pairs[1] = new Pair(imageView, "splash_text");
                Intent i = new Intent(SplashScreen.this, MainActivity.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
                startActivity(i,options.toBundle());
            }
        }, 3000);
    }
}