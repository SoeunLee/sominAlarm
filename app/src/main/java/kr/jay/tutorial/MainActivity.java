package kr.jay.tutorial;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img_siba;
    protected Button btn_off;
    protected Button btn_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_off = (Button)findViewById(R.id.btn_off);
        btn_re = (Button)findViewById(R.id.btn_re);

        img_siba = (ImageView)findViewById(R.id.img);
        img_siba.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)img_siba.getBackground()).start();
            }
        });
    }
}