package com.example.malakdianadewi.moneymanager;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.Html;
import android.view.Window;
import android.widget.Button;
import android.support.v7.app.ActionBar;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AboutUs extends AppCompatActivity {
 //mendeklarasikan variable global
    private ViewPager mSlideViewPager;
    protected LinearLayout mDotLayout;
    private TextView[] mDots;
    private  SliderAdapter sliderAdapter;
    private Button mBackBtn, mNextBtn, mMapsBtn,back;
    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        //mengenalkan button sesuai id
        mSlideViewPager = (ViewPager) findViewById(R.id.sLideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotLayout);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mMapsBtn = (Button) findViewById(R.id.mapsBtn);
        back = (Button) findViewById(R.id.back);

        //membuat objek dari slideadapter
        sliderAdapter = new SliderAdapter(this);


        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1); //berpindah ke slide sebelumya
            }
        });
        mNextBtn.setOnClickListener(new View.OnClickListener() { //pindah ke slide selanjutnya
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        mMapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),MapsActivity.class); //membuka maps
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), menu.class); //kembali ke halaman utama
                startActivity(i);
            }
        });
    }

    //membuat titik slide
    public  void addDotsIndicator(int position){
        mDots = new TextView[3];

        for (int i=0; i< mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(30);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparantWhite));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.putih));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            //mengatur tampilan button, back ,next, findus sesuai slide saat ini
            mCurrentPage=i;
            if(i==0){
                //slide pertama menampilkan tombol next
                mNextBtn.setEnabled(true);
                mNextBtn.setVisibility(View.VISIBLE);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mMapsBtn.setEnabled(false);
                mMapsBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");

            }else if(i== mDots.length -1){
                //slide terakhir menampilkan back dan find us
                mNextBtn.setEnabled(false);
                mNextBtn.setVisibility(View.INVISIBLE);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mMapsBtn.setEnabled(true);
                mMapsBtn.setVisibility(View.VISIBLE);
                mBackBtn.setText("Back");
                mMapsBtn.setText("Find Us");
            }else{

                // slide kedua menampilkan back dan next
                mNextBtn.setEnabled(true);
                mNextBtn.setVisibility(View.VISIBLE);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mMapsBtn.setEnabled(false);
                mMapsBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
