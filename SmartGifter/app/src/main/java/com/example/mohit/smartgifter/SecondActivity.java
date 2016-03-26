/*
package com.example.mohit.smartgifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

*/
/**
 * Created by mohit on 3/14/2016.
 *//*

public class SecondActivity extends Activity {

    ListView listView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Log.d("Chandak", "in second activity");
        System.out.println("in second activity");
        listView = (ListView) findViewById(R.id.list);

        Intent i = getIntent();

        String [] friendNames = i.getStringArrayExtra("friendNames");
        friendNames[0]=friendNames[0]+"jjjjj";
        System.out.println("Friend Array length: "+friendNames.length);
        //TextView view = (TextView)findViewById(R.id.textView);
        //view.setText(friendNames[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, friendNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override


            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

}

*/
