package com.kuangch.blurdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fivehundredpx.android.blur.BlurringView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView num;
    private BlurringView blurringView;
    private DecimalFormat decimalFormat;
    private int[] imgs;
    private View img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blurringView = (BlurringView) findViewById(R.id.blurring_view);
        View blurredView = findViewById(R.id.blurred_view);
        blurringView.setBlurredView(blurredView);

        imgs = new int[]{R.mipmap.img,R.mipmap.img2,R.mipmap.img4,R.mipmap.img3,R.mipmap.img5};

        img = findViewById(R.id.img);

        //num = (TextView)findViewById(R.id.num);
        //decimalFormat = new DecimalFormat("#.00");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //double number = (Math.random() * 100);
                            //num.setTextColor(colors[(int) (Math.random() * 5)]);
                            //num.setText(decimalFormat.format(number));

                            img.setBackgroundResource(imgs[(int)(Math.random() * 5)]);
                            blurringView.invalidate();
                        }
                    });
                    SystemClock.sleep(1000/24);
                }
            }
        }).start();
    }
}
