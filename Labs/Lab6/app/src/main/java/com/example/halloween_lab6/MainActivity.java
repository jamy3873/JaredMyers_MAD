package com.example.halloween_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
        image.setVisibility(View.INVISIBLE);
    }

    public void freeCandy(View view){
        EditText candyText = findViewById(R.id.editText);
        String candyString = candyText.getText().toString();

        TextView outputText = findViewById(R.id.textView);
        outputText.setText(candyString + " are my favorite too!");

        image.setVisibility(View.VISIBLE);
    }
}
