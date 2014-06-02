package com.belajar.picassoexample;


import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
   private Context mContext;
   int imageTotal = 9;
   public static final String IMAGE_URL = "http://192.168.1.6/android/res/picasso/";

   // Constructor
   public ImageAdapter(Context c) {
      mContext = c;
   }

   public int getCount() {
      return imageTotal;
   }

   public Object getItem(int position) {
      return null;
   }

   public long getItemId(int position) {
      return 0;
   }

   // create a new ImageView for each item referenced by the Adapter
   public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView;
      if (convertView == null) {
      imageView = new ImageView(mContext);
      imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
      imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      imageView.setPadding(8, 8, 8, 8);
      } else {
      imageView = (ImageView) convertView;
      }

      Picasso.with(mContext)
		.load(IMAGE_URL + position +".png")
		.placeholder(R.drawable.loader).error(R.drawable.ic_launcher).fit()
		.centerCrop().into(imageView);
      return imageView;
   }
}