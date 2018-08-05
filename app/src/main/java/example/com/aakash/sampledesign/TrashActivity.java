package example.com.aakash.sampledesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by aakash on 04August,2018
 */
public class TrashActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdapter slideShowAdapter;
    CircleIndicator circleIndicator;
    Handler handler;
    Runnable runnable;
    Timer timer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        circleIndicator=findViewById(R.id.circle_indicator);
        viewPager=findViewById(R.id.viewpager_id);
        slideShowAdapter= new SlideShowAdapter(this);
        viewPager.setAdapter(slideShowAdapter);
        circleIndicator.setViewPager(viewPager);

        handler= new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                int i= viewPager.getCurrentItem();

                if (i==slideShowAdapter.images.length-1){
                    i=0;
                    viewPager.setCurrentItem(i, true);
                }else{
                i++;
                viewPager.setCurrentItem(i, true);
               // handler.postDelayed(this,4000);

            }

        }
            };
        //handler.post(runnable);
        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },5000,4000);
    }
}
