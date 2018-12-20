package com.example.malakdianadewi.moneymanager;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
/**
 * Created by Malak Diana Dewi on 13/12/2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context){
        this.context = context;
    }


//menyimpan url untuk picaso untuk ditampilkan pada slide view
    public String[] slide_image={
            "https://img.icons8.com/color/1600/avatar.png",
            "https://cdn.iconscout.com/icon/free/png-256/avatar-369-456321.png",
            "http://2.bp.blogspot.com/-47EoU2cz1cg/UNSDP2ESFEI/AAAAAAAAISU/xwkN6d7TWHo/s320/LOGO+POLITEKNIK+NEGERI+MALANG.png"
    };

    //menyimpan text untuk ditampilkan pada slide view
    public String[] slide_headings={
            "Ferdiana R.C",
            "Malak Diana D.",
            "POLINEMA"
    };

    //menyimpan text untuk ditampilkan pada slide view
    public  String[] slide_descs = {
            "Jika Anda benar-benar bisa menghitung uang Anda, maka Anda bukan orang kaya.",
            "Waktu lebih berarti daripada uang. Anda dapat mendapatkan lebih banyak uang, tetapi Anda tidak dapat mendapatkan lebih banyak waktu.",
            "Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return  view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription= (TextView) view.findViewById(R.id.slide_desc);
        //untuk menampilkan image dari url sesuai posisi
        Picasso.with(context).load(slide_image[position]).placeholder(R.drawable.profil).error(R.drawable.warning).into(slideImageView);
        //untuk mengatur isi teksview dari array yang telah disimpan
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
