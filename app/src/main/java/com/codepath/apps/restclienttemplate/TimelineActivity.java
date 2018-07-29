package com.codepath.apps.restclienttemplate;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import 	android.support.design.widget.TabLayout;

import com.codepath.apps.restclienttemplate.fragments.TweetsPagerAdapter;

public class TimelineActivity extends AppCompatActivity {

    //SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

       // swipeRefreshLayout = findViewById(R.id.swipeRefresh);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                populateTimeline();
//            }
//        });

        // Get viewPager
        ViewPager viewPager = (ViewPager)  findViewById(R.id.viewpager);

        // Set the adapter for the pager
        viewPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager(),TimelineActivity.this));

        // setup the TabLayout
        TabLayout tabLayout =  findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

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
