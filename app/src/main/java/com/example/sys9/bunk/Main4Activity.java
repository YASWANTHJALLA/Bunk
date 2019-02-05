package com.example.sys9.bunk;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


    ImageView timg4;
    ImageView timg5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );



        tabLayout = (TabLayout)findViewById( R.id.tablayout_id );
//   appBarLayout = (AppBarLayout)findViewById( R.id.appbar_id );
        viewPager = (ViewPager)findViewById( R.id.viewpager_id );

        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager() );
        adapter.AddFragment( new Chat() ,"");
        adapter.AddFragment( new Status() , "" );
        adapter.AddFragment( new Calls() ,"");

        viewPager.setAdapter( adapter );
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt( 0 ).setIcon( R.drawable.ic_group_black_24dp);
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.ic_image_black_24dp );
        tabLayout.getTabAt( 2 ).setIcon( R.drawable.ic_call_black_24dp );


        timg4 = findViewById( R.id.timg4 );
        timg4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Main4Activity.this , Accounts.class );
                startActivity( i );
            }
        } );



        timg5=findViewById( R.id.timg5 );
        timg5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main4Activity.this ,Offers.class  );
                startActivity( i );
            }
        } );

    }
}