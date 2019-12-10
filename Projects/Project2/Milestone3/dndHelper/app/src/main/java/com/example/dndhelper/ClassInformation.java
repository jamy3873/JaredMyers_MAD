package com.example.dndhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String className = intent.getStringExtra("SelectedClass");
        loadClassInfo(className);

    }

    private void loadClassInfo(String className) {
        ArrayList<String> skills = loadSkills(className);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,skills);
        skillList.setAdapter(adapter);
        switch (className) {
            case "Rouge":
                nameText.setText(className);
                alignment.setText("Neutral");
                hitDie.setText("d8");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.rouge);
                break;
            case "Barbarian":
                nameText.setText(className);
                alignment.setText("Nonlawful");
                hitDie.setText("d10");
                ranks.setText("2");
                classImage.setImageResource(R.drawable.barbarian);

                break;
            case "Paladin":
                nameText.setText(className);
                alignment.setText("Lawful Good");
                hitDie.setText("6");
                ranks.setText("4");
                classImage.setImageResource(R.drawable.paladin);
                break;
            case "Sorcerer":
                nameText.setText(className);
                alignment.setText("Any");
                hitDie.setText("d6");
                ranks.setText("2");
                classImage.setImageResource(R.drawable.sorcerer);
                break;
            case "Bard":
                nameText.setText(className);
                alignment.setText("Any");
                hitDie.setText("d8");
                ranks.setText("6");
                classImage.setImageResource(R.drawable.bard);
                break;
        }
    }

    private ArrayList<String> loadSkills(String className) {
        ArrayList<String> skills = new ArrayList<>();
        switch (className) {
            case "Rouge":
                skills.add("Acrobatics");
                skills.add("Athletics");
                skills.add("Deception");
                skills.add("Insight");
                skills.add("Intimidation");
                skills.add("Investigation");
                skills.add("Perception");
                skills.add("Performance");
                skills.add("Persuasion");
                skills.add("Slight of Hand");
                skills.add("Stealth");
                break;
            case "Barbarian":
                skills.add("Animal Handling");
                skills.add("Athletics");
                skills.add("Intimidation");
                skills.add("Nature");
                skills.add("Perception");
                skills.add("Survival");
                break;
            case "Paladin":
                skills.add("Athletics");
                skills.add("Insight");
                skills.add("Intimidation");
                skills.add("Medicine");
                skills.add("Persuasion");
                skills.add("Religion");
                break;
            case "Sorcerer":
                skills.add("Arcana");
                skills.add("Deception");
                skills.add("Insight");
                skills.add("Intimidation");
                skills.add("Persuasion");
                skills.add("Religion");
                break;
            case "Bard":
                skills.add("Acrobatics");
                skills.add("Craft");
                skills.add("Diplomacy");
                skills.add("Perception");
                skills.add("Sleight of Hand");
                skills.add("Stealth");

                break;
        }
        return skills;
    }
}
