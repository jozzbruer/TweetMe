package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.TweetAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class TweetsListFragment extends Fragment implements TweetAdapter.TweetAdapterListener {

    public interface TweetSelectedListener{
        // handle tweet selection
        public void onTweetSelected(Tweet tweet);
    }
    TweetAdapter tweetAdapter;
    ArrayList<Tweet> tweets;
    RecyclerView rvTweets;
    // Inflation happens inside onCreateView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout

        View view = inflater.inflate(R.layout.fragments_tweets_list,container,false);
        rvTweets = view.findViewById(R.id.rvTweet);

        //
        tweets = new ArrayList<>();
        tweetAdapter = new TweetAdapter(tweets,this);

        rvTweets.setLayoutManager(new LinearLayoutManager(getContext()));

        rvTweets.setAdapter(tweetAdapter);

        return view;
    }

    public void addItems(JSONArray response){
        for(int i=0; i<response.length(); i++){
            try {
                Tweet tweet = Tweet.fromJSON(response.getJSONObject(i));
                tweets.add(tweet);
                tweetAdapter.notifyItemInserted(tweets.size() - 1);

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemSelected(View view, int position) {
        Tweet tweet = tweets.get(position);
        ((TweetSelectedListener) getActivity()).onTweetSelected(tweet);
    }
}
