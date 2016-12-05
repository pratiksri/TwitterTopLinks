package com.example.pratik.twittertoplinks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

public class Options extends AppCompatActivity {
    int count =0;
    Button enter;
    EditText value;

    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        TwitterSession session = Twitter.getSessionManager().getActiveSession();
        user = session.getUserName();
        enter = (Button)findViewById(R.id.button6);
        value = (EditText)findViewById(R.id.editText);
    }

    public void show_tweets(View v)
    {
        Intent intent = new Intent(this,Timeline.class);
        Bundle b = new Bundle();
        b.putString("uname",user);
        intent.putExtras(b);
        startActivity(intent);

    }

    public void analysis(View v)
    {
        Intent intent = new Intent(this,Analyze.class);
        intent.putExtra("uname",user);
        startActivity(intent);
    }

    public void search(View v)
    {
        count++;
        if(count%2!=0)
        {
            enter.setVisibility(v.VISIBLE);
            value.setVisibility(v.VISIBLE);
        }
        else
        {
            enter.setVisibility(v.INVISIBLE);
            value.setVisibility(v.INVISIBLE);
        }
    }

    public void enter_word(View v )
    {
        String word = value.getText().toString();
        Intent intent = new Intent(this,MainSearch.class);
        Bundle b1 = new Bundle();
        b1.putString("word",word);
        intent.putExtras(b1);
        startActivity(intent);
    }
}
