package com.example.halloween_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView outputText;
    EditText candyText;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candyText = findViewById(R.id.editText);
        outputText = findViewById(R.id.textView);

        image = findViewById(R.id.imageView);
        image.setVisibility(View.INVISIBLE);
    }

    public void freeCandy(View view){
        String candyString = "";
        if (candyText != null){
            candyString = candyText.getText().toString();
        }

        outputText.setText(candyString + " are my favorite too!");
        outputText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        image.setVisibility(View.VISIBLE);
        image.setImageResource(R.drawable.candy);
    }
}
