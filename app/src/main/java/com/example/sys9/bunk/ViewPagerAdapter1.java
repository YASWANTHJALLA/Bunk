package com.example.sys9.bunk;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewPagerAdapter1 extends PagerAdapter {

    int[]  image;
    LayoutInflater layoutInflater;
    Context context;

    public ViewPagerAdapter1(DotIndicator mainActivity , int[] img){

        this.context = mainActivity;
        this.image = img;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == ((RelativeLayout)object);
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        ImageView image1;
        layoutInflater = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View itemview = layoutInflater.inflate( R.layout.item,container,false );
        image1 = (ImageView) itemview.findViewById( R.id.img1 );
        image1.setImageResource( image[position] );

        ((ViewPager)container).addView( itemview );
        return itemview;

      /*  ((ViewPager)container).addView( itemview );*/

        /*return itemview;*/


    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        ((ViewPager)container).removeView( (RelativeLayout)object );
    }
}
