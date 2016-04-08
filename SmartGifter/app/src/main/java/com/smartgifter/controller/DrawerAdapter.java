package com.smartgifter.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shweta Sachdeva on 4/5/2016.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];
    private String name;
    private int profile;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        int holderId;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView name;


        public ViewHolder(View itemView,int ViewType) {
            super(itemView);

            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                holderId = 1;
            }
            else{

                name = (TextView) itemView.findViewById(R.id.name);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                holderId = 0;
            }
        }
    }


    DrawerAdapter(String mNavTitles[],int mIcons[],String name, int profile){
        this.mNavTitles = mNavTitles;
        this.mIcons = mIcons;
        this.name = name;
        this.profile = profile;
    }

    @Override
    public DrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false); //Inflating the layout
            ViewHolder vhItem = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view
            return vhItem;

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false); //Inflating the layout
            ViewHolder vhHeader = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view
            return vhHeader;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(DrawerAdapter.ViewHolder holder, int position) {

        if(holder.holderId ==1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        }
        else{
            holder.profile.setImageResource(profile);
            holder.name.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}
