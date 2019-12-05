package com.example.dndhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private static final String CHARACTER_FILE = "C:\\Users\\jared\\Documents\\MobileAppDev\\JaredMyers_MAD\\Projects\\Project2\\Milestone3\\dndHelper\\app\\src\\main\\assets\\AllCharacters.json";

    private ListView listView;
    private Button testButton;
    public ArrayList<String> names = initCharList();

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.character_list);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), ClassInformation.class);
                intent.putExtra("SelectedClass",names.get(position));
                startActivity(intent);
            }
        });

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

    private ArrayList<String> initCharList() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rouge");
        names.add("Barbarian");
        names.add("Paladin");
        names.add("Sorcerer");
        names.add("Bard");
        return names;
    }
}
