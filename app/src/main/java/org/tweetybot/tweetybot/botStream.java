package org.tweetybot.tweetybot;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class botStream extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String UserName = intent.getExtras().getString("twitterUserName");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_stream);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(UserName)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

    public void changeSettings(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, botSettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, botStream.class);
        startActivity(intent);
    }
}

