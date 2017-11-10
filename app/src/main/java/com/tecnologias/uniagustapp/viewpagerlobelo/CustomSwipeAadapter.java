package com.tecnologias.uniagustapp.viewpagerlobelo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ivan.lobelo on 11/9/2017.
 */

public class CustomSwipeAadapter extends PagerAdapter {

    private int[] image_resource = {R.drawable.img01,R.drawable.img02,R.drawable.img03};
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomSwipeAadapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView) item_view.findViewById(R.id.image_count);

        imageView.setImageResource(image_resource[position]);
        textView.setText("Imagen : "+(position+1));
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }


}
