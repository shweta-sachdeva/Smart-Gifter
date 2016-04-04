package com.smartgifter.controller;

/*
 * Created by mohit on 3/26/2016.*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;


/**
 * Created by mohit on 3/14/2016.
 */

public class FriendListActivity extends Activity {

    ListView listView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        listView = (ListView)findViewById(R.id.listView);

        Intent i = getIntent();
        String []friendNames = i.getStringArrayExtra("friendNames");
        long []friendUserId = i.getLongArrayExtra("friendUserId");

        listView.setAdapter(new CustomListViewAdapter(this,friendNames,friendUserId));

//        Button fbLogout = (Button)findViewById(R.id.facebookLogout);
//        fbLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginManager.getInstance().logOut();
//                Intent intent = new Intent(FriendListActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}



