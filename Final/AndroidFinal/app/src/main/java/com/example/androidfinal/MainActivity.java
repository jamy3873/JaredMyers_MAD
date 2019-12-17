package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Burrito theBurrito;
    private EditText nameText;
    private ToggleButton toggleButton;
    private RadioGroup radio;
    private RadioButton radio1;
    private RadioButton radio2;
    private Spinner spinner;
    private Switch glutenSwitch;
    private TextView description;
    private Button buildButton;
    private Button findButton;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name);
        toggleButton = findViewById(R.id.toggleButton);
        radio = findViewById(R.id.radioGroup);
        radio1 = findViewById(R.id.radioButton);
        radio2 = findViewById(R.id.radioButton2);
        spinner = findViewById(R.id.spinner);
        glutenSwitch = findViewById(R.id.gluten);
        description = findViewById(R.id.description);
        buildButton = findViewById(R.id.buildButton);
        findButton = findViewById(R.id.findButton);
        image = findViewById(R.id.imageView);


        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildBurrito(v);
            }
        };
        buildButton.setOnClickListener(onClick);
        onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBurrito(v);
            }
        };
        findButton.setOnClickListener(onClick);
    }

    public void buildBurrito(View view) {
        //Get Values
        Burrito myBurrito = new Burrito();
        myBurrito.location = spinner.getSelectedItem().toString();
        myBurrito.username = nameText.getText().toString();
        myBurrito.veggie = toggleButton.isChecked();

        if(myBurrito.veggie){
            myBurrito.protein = "veggie";
        }
        else{
            myBurrito.protein = "meat";
        }

        int radioID = radio.getCheckedRadioButtonId();
        if(radioID==radio1.getId()){
            myBurrito.food = "burrito";
            image.setImageResource(R.drawable.burrito);
            image.setVisibility(View.VISIBLE);
        }
        else if(radioID==radio2.getId()){
            myBurrito.food = "taco";
            image.setImageResource(R.drawable.taco);
            image.setVisibility(View.VISIBLE);

        }
        boolean gluten = glutenSwitch.isChecked();
        if(gluten){
            myBurrito.glutes = "gluten free";
        }

        //Check and display toast
        if (radioID==-1 || myBurrito.username==null){
            Toast.makeText(this,"Please fill out more info",Toast.LENGTH_SHORT).show();
            return;
        }

        //Fill description and change image
        String text = myBurrito.username + " wants a " + myBurrito.glutes + " " + myBurrito.protein + " " + myBurrito.food + " from " + myBurrito.location;
        description.setText(text);
        theBurrito = myBurrito;
    }

    public void findBurrito(View view) {
        if(theBurrito != null){
            Intent intent = new Intent(this,Suggestion.class);
            intent.putExtra("location",theBurrito.location);
            startActivity(intent);

        }
        else{
            Toast.makeText(this,"Make burrito first",Toast.LENGTH_SHORT).show();

        }
    }
}
