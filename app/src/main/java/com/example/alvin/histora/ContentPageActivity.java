package com.example.alvin.histora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//Central Contents Page / StartPage

public class ContentPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);

        //create clickable list with topics

        String [] mTopicList = {"Pre-Raffles (Before 1819)", "Founding of Modern Singapore (1819)", "Early Growth (1819-1826)",
                "Straits Settlements (1826-1867)", "Straits Settlements Crown Colony (1867-1942)",
                "Battle for Singapore and Japanese Occupation (1942-1945)", "Postwar (1945-1955)", "Self-Governance (1955-1963)",
                "Merger With Malaysia (1963-1965)", "Independence (1965-Present)"};

        ListView mContentsList = (ListView) findViewById(R.id.content_list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTopicList);
        mContentsList.setAdapter(adapter);

        mContentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContentPageActivity.this, ContentActivity.class);
                intent.putExtra("Topic", position);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content_page, menu);
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
