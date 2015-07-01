package com.example.alvin.histora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;


public class ContentActivity extends Activity {

    int mTopicID;
    Button mQuizButton;

    //Use 1 single activity, but change the content view according to the topic selected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mTopicID = intent.getIntExtra("Topic", 0);
        if (mTopicID == 0) {
            setContentView(R.layout.activity_content1);
        } else if (mTopicID == 1) {
            setContentView(R.layout.activity_content2);
        } else if (mTopicID == 2) {
            setContentView(R.layout.activity_content3);
        } else if (mTopicID == 3) {
            setContentView(R.layout.activity_content4);
        } else if (mTopicID == 4) {
            setContentView(R.layout.activity_content5);
        } else if (mTopicID == 5) {
            setContentView(R.layout.activity_content6);
        } else if (mTopicID == 6) {
            setContentView(R.layout.activity_content7);
        } else if (mTopicID == 7) {
            setContentView(R.layout.activity_content8);
        } else if (mTopicID == 8) {
            setContentView(R.layout.activity_content9);
        } else if (mTopicID == 9) {
            setContentView(R.layout.activity_content10);
        }

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "EiIiZ1BUDDUUizBU4YACJhZLZtvefeqhaNYNKICl", "gsJdOLPpuyJ3VEmO68R40ZAThNSKWViXUB6ufIeu");

        mQuizButton = (Button) findViewById(R.id.quiz_button);
        mQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, QuizActivity.class);
                intent.putExtra("Topic", mTopicID);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
