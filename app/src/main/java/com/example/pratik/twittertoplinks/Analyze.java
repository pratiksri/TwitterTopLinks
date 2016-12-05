package com.example.pratik.twittertoplinks;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Analyze extends AppCompatActivity {
    TextView tv;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        tv = (TextView)findViewById(R.id.textView1);
        ArrayList<String>tweets = new ArrayList<String>();
        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        Cursor c = db.getAll();
        while (c.moveToNext())
        {
            tweets.add(c.getString(1));
        }

        for(int i=0;i<tweets.size();i++)
        {
            String temp = tweets.get(i);
            if(temp.contains("http"))
            {
                count++;
            }
        }
        tv.setText(Integer.toString(count));
    }
}
