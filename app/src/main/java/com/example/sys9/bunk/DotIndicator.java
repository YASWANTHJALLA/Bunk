package com.example.sys9.bunk;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


import me.relex.circleindicator.CircleIndicator;

public class DotIndicator extends AppCompatActivity {

    EditText number;
    Button submit;
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] images;
    private static int currentpage = 0;
    private static int numpages = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dot_indicator );

        images = new int[]{R.drawable.download,
                R.drawable.download2,
                R.drawable.download5,
                R.drawable.images1,
                R.drawable.login};

        EditText editText = findViewById( R.id.number );
        submit = findViewById( R.id.sub );

        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),Main2Activity.class );
                startActivity( i );
            }
        } );


        viewPager = (ViewPager) findViewById( R.id.pager );
        adapter = new ViewPagerAdapter1( DotIndicator.this, images );
        viewPager.setAdapter( adapter );

        CircleIndicator indicator = (CircleIndicator) findViewById( R.id.indicator );
        indicator.setViewPager( viewPager );

        viewPager.setOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                currentpage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount = images.length;
                    if (currentpage == 0) {
                        viewPager.setCurrentItem( pagecount - 1, false );
                    } else if (currentpage == pagecount - 1) {
                        viewPager.setCurrentItem( 0, false );
                    }
                }
            }
        } );
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentpage == numpages) {
                    currentpage = 0;
                }
                viewPager.setCurrentItem( currentpage++, true );
            }
        };

        Timer swipe = new Timer();
        swipe.schedule( new TimerTask() {
            @Override
            public void run() {
                handler.post( update );
            }
        }, 1500, 1500 );
    }
}

