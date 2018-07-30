package com.codepath.apps.restclienttemplate;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.apps.restclienttemplate.fragments.UserTimelineFragment;
import com.codepath.apps.restclienttemplate.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ProfileActivity extends AppCompatActivity {
    private TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String screenName = getIntent().getStringExtra("screen_name");
        // Create the user fragment
        UserTimelineFragment userTimelineFragment = UserTimelineFragment.newInstance(screenName);
        // Display the user timeline fragment inside the container (Dynamiclly)
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // make change
        fragmentTransaction.replace(R.id.flContainer,userTimelineFragment);
        // commit
        fragmentTransaction.commit();

        client = TwitterApp.getRestClient(this);
        client.getUserInfo(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // Deserialize the User object
                    User user = User.fromJSON(response);
                    // Set the title of the ActionBar base on the user information
                    getSupportActionBar().setTitle(user.screenName);
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        });

    }
}
