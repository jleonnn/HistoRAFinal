package com.example.alvin.histora;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class ScorePageActivity extends ActionBarActivity {

    TextView mScoreTextView;
    int mScore;
    ArrayList<ParseObject> mScoreList = new ArrayList();
    ListView mScoreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if(e == null){
                    for (ParseObject obj: parseObjects){
                        mScoreList.add(obj);
                    }
                } else {
                    Log.d("Error", "Crap");
                }
            }
        });

        Intent intent = getIntent();
        mScore = intent.getIntExtra("score", 0);
        mScoreTextView = (TextView) findViewById(R.id.score_text_view);
        mScoreTextView.setText("Your Score is: " + mScore);

        mScoreListView = (ListView) findViewById(R.id.score_list);
        ArrayAdapter adapter = new MyArrayAdapter(this, android.R.layout.simple_list_item_1, mScoreList);
        mScoreListView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score_page, menu);
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

    private class MyArrayAdapter extends ArrayAdapter<ParseObject> {

        private int mResource;
        private ArrayList<ParseObject> mHighScoreList;

        public MyArrayAdapter(Context context, int resource, ArrayList<ParseObject> highScoreList){
            super(context, resource, highScoreList);
            mResource = resource;
            mHighScoreList = highScoreList;
        }

        @Override
        public View getView(int position, View row, ViewGroup parent){

            if(row == null){
                row = getLayoutInflater().inflate(mResource, parent, false);
            }

            TextView mNameTextView = (TextView) row.findViewById(R.id.list_username);
            TextView mSubjectTextView = (TextView) row.findViewById(R.id.list_score);
            mNameTextView.setText(mHighScoreList.get(position).getString("playerName"));
            mSubjectTextView.setText(mHighScoreList.get(position).getInt("score"));

            return row;
        }
    }
}
