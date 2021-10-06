package com.depot_air.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.depot_air.R;

public class OnboardingAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public OnboardingAdapter(Context context) {
        this.context = context;
    }

    int[] images = {
            R.drawable.ecommerce, R.drawable.vision, R.drawable.discount
    };

    int[] headings = {
            R.string.first_slide_title,R.string.second_slide_title,R.string.third_slide_title
    };

    int[] descs = {
        R.string.first_slide_desc,
        R.string.second_slide_desc,
        R.string.third_slide_desc
    };


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView = v.findViewById(R.id.slider_image);
        TextView heading = v.findViewById(R.id.slider_heading);
        TextView desc = v.findViewById(R.id.slider_desc);

        Glide.with(context).load(images[position]).error(R.drawable.ic_launcher_foreground).into(imageView);
        heading.setText(headings[position]);
        desc.setText(descs[position]);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
