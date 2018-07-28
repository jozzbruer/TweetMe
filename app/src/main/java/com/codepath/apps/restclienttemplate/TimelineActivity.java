package com.codepath.apps.restclienttemplate;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codepath.apps.restclienttemplate.fragments.TweetsListFragment;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {


    TweetsListFragment tweetsListFragment;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                populateTimeline();
//            }
//        });


        tweetsListFragment = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragement_timeline);


//        rvTweets.setOnScrollListener(new RecyclerView.OnScrollListener() {
////            @Override
////            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
////                if (!recyclerView.canScrollVertically(1)){
////                    if (tweets.size()>0){
////                        loadMore(tweets.get(tweets.size()-1).uid);
////                    }
////                    else {
////                        populateTimeline();
////                    }
////
////                }
////            }
////        });
    }

//    private void loadMore(Long id) {
//        client.loadMore(new JsonHttpResponseHandler(){
//
//                            @Override
//                            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                                for (int i=0;i< response.length();i++){
//                                    try {
//                                        Tweet tweet = Tweet.fromJSON(response.getJSONObject(i));
//                                        tweets.add(tweet);
//                                        tweetAdapter.notifyItemInserted(tweets.size() - 1);
//                                    }
//                                    catch (JSONException e){
//                                        e.printStackTrace();
//                                    }
//                                }
//
//                            }
//                        },
//                id);
//    }

}
