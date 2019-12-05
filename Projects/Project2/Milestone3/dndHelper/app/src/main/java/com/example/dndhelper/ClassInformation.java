package com.example.dndhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class ClassInformation extends AppCompatActivity {
    private TextView nameText;
    private TextView alignment;
    private TextView hitDie;
    private TextView ranks;
    private ImageView classImage;
    private ListView skillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_information);

        nameText = findViewById(R.id.className);
        alignment = findViewById(R.id.myAlign);
        hitDie = findViewById(R.id.hitDie);
        ranks = findViewById(R.id.myRanks);
        skillList = findViewById(R.id.skillList);
        classImage = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String className = intent.getStringExtra("SelectedClass");
        loadClassInfo(className);
        Toast.makeText(this,className,Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/search?q=dice+roller"));
        startActivity(intent);
    }

    private void loadClassInfo(String className) {
        switch (className) {
            case "Rouge":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("d20");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.rouge);
                break;
            case "Barbarian":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("12");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.barbarian);
                break;
            case "Paladin":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("6");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.paladin);
                break;
            case "Sorcerer":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("8");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.sorcerer);
                break;
            case "Bard":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("10");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.bard);
                break;
        }
    }

    private void loadSkills() {

    }
}
