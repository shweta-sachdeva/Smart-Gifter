package com.smartgifter.controller;

/**
 * Created by mohit on 3/26/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.smartgifter.model.FacebookUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends Activity {

    CallbackManager callbackManager;
    final java.util.ArrayList<JSONObject> friendListJSONObject = new java.util.ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        /*
            if the app is already logged in with your fb account, show the HomeScreen,
            else do the login
         */
        if(isLogin()){
            /*
            CALL HOME SCREEN ACTIVITY HERE
             */
            /*Intent i = new Intent(MainActivity.this,SampleDrawerActivity.class);
            startActivity(i);*/
        }

        else {
            doFacebookLogin();
        }
        System.out.println("jkadshkhsajdhadjhsjdhsahdhkh");
        //finish();
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent i) {
        callbackManager.onActivityResult(reqCode, resCode, i);
    }

    public boolean isLogin() {
        AccessToken accessToken = getAccessToken();
        if (accessToken == null) {
            return false;
        }
        return !accessToken.isExpired();
    }

    public AccessToken getAccessToken() {
        return AccessToken.getCurrentAccessToken();
    }

    public void doFacebookLogin(){
        final LoginButton loginButton = (LoginButton) findViewById(R.id.fb_login_button);

        loginButton.setReadPermissions("user_friends", "read_custom_friendlists", "user_posts");

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                System.out.println("Success*****************************");
                System.out.println("Access Token  : " + loginResult.getAccessToken().getToken());
                //sampleGraphRequest(loginResult.getAccessToken());
                System.out.println("idhar");
                //feeds(loginResult.getAccessToken());
                friendList(loginResult.getAccessToken());


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

/*private void feeds(AccessToken accessToken){
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/home",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
            *//*
*/
/* handle the result *//*
*/
/*
                       try{
                           JSONArray feedArray = response.getJSONObject().getJSONArray("data");
                           for(int i=0; i<feedArray.length();i++){
                               Log.d("info","feed "+(i+1)+" :"+ feedArray.get(i));
                           }
                           //Log.d("debug","feed 0: "+feedArray.get(0));
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                    }
                }
        ).executeAsync();
    }*/

    private void friendList(final AccessToken accessToken){


        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/friends",
                null,
                com.facebook.HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {

                       try {
                           JSONArray friendList = response.getJSONObject().getJSONArray("data");
                           System.out.println("friendList Size:********"+friendList.length());


                           ArrayList<FacebookUser> friends = new ArrayList<FacebookUser>(friendList.length());

                           String []friendNames = new String[friendList.length()];
                           long []friendUserId = new long[friendList.length()];

                           for(int i=0;i<friendList.length();i++){
                               JSONObject object = friendList.getJSONObject(i);
                               FacebookUser friend = new FacebookUser();
                               friendNames[i] = object.getString("name");
                               friendUserId[i] = object.getLong("id");
                               friend.setUserProfileName(object.getString("name"));
                               friend.setUserId(object.getLong("id"));
                               friends.add(friend);
                               //friendNames[i] = object.getString("name");
                           }

                           Log.d("debug","friendNames: "+friendNames);
                           Log.d("debug","friendUserId: "+friendUserId);
                           //getProfilePic(friends, accessToken);

                           System.out.println("ithey");
                           System.out.println("String array length: " + friends.size());
                           Intent i = new Intent(MainActivity.this,FriendListActivity.class);
                           i.putExtra("friendNames",friendNames);
                           i.putExtra("friendUserId",friendUserId);
                           startActivity(i);
                       }
                       catch(JSONException excception){
                            System.out.println("exception");
                       }
                    }
                }
        ).executeAsync();

    }


    private void sampleGraphRequest(final AccessToken accessToken ){
           GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        // Application code
                        try{
                            Iterator<String> iterator = object.keys();
                            while(iterator.hasNext()){
                                String key = iterator.next();
                                String value = object.getString(key);
                                System.out.println(key +": "+value);
                            }
                        }
                        catch(JSONException exception){
                            System.err.println("xception");
                        }
                        //friendList(accessToken);
                        System.out.println("Hererererere");
                    }
                    });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }
}
