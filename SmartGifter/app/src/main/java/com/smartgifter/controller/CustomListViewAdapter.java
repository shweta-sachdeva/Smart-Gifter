package com.smartgifter.controller;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by mohit on 3/26/2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    String friendNames[];
    long friendUserId[];
    Context context;
    private static LayoutInflater inflater=null;
    public CustomListViewAdapter(FriendListActivity friendListActivity, String friendNames[], long[] friendUserId){

        context = friendListActivity;
        this.friendNames = friendNames;
        this.friendUserId = friendUserId;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return friendNames.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView textView;
        ProfilePictureView profilePictureView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.friend_list,null);
        holder.textView = (TextView) rowView.findViewById(R.id.friendName);
        holder.profilePictureView = (ProfilePictureView) rowView.findViewById(R.id.friendProfilePicture);

        holder.textView.setText(friendNames[position]);

        holder.profilePictureView.setProfileId(String.valueOf(friendUserId[position]));

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + friendNames[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;

    }
}
