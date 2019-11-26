package com.example.lab8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class MoodActivity extends AppCompatActivity {
    private String currentMood;
    private String moodActivity;
    private String moodURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        currentMood = intent.getStringExtra("mood");
        moodActivity = intent.getStringExtra("activity");
        moodURL = intent.getStringExtra("website");

        TextView messageView = findViewById(R.id.textViewMood);
        TextView suggestion = findViewById(R.id.textViewActivity);
        messageView.setText("You are feeling " + currentMood.toLowerCase());
        suggestion.setText("Why not try " + moodActivity.toLowerCase() + "?");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(moodURL));
        startActivity(intent);
    }
}
