package com.example.androidfinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Suggestion extends AppCompatActivity {
    private TextView suggestionText;
    private String websiteURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        suggestionText = findViewById(R.id.suggest);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        loadText(location);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(websiteURL));
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadText(String location){
        String restaurant = "";
        switch (location){
            case "The Hill":
                restaurant = "Illegal Pete's";
                websiteURL = "http://illegalpetes.com/";
                break;
            case "29th Street":
                restaurant = "Chipotle";
                websiteURL = "https://www.chipotle.com/";
                break;
            case "Pearl Street":
                restaurant = "Bartaco";
                websiteURL = "https://bartaco.com/";
                break;
        }
        suggestionText.setText("You should try " + restaurant);
    }
}
