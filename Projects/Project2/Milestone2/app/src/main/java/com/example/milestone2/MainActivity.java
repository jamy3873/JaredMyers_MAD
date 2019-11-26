package com.example.milestone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.milestone2.ui.main.Frag1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    public Map<String,CharProfile> charDict = new HashMap<>();
    public ArrayList<CharProfile> characters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCharacters();

        listView = findViewById(R.id.list_view);
        ArrayList<String> names = initializeList();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                CharProfile myChar = charDict.get(selectedItem);
                loadCharacter(myChar);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCharacter();
            }
        });



    }

    private void createCharacters() {
        ArrayList<String> n = new ArrayList<>();
        n.add("Jared");
        n.add("Jordan");
        n.add("Ty");
        for(String name : n) {
            CharProfile c = new CharProfile(name,"Rouge");
            charDict.put(c.characterName,c);
            characters.add(c);
        }

    }

    private void loadCharacter(CharProfile c) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("myChar",c);
        Intent intent = new Intent(this,CharacterSheet.class);
        //intent.putExtras(bundle);
        startActivity(intent);
    }

    private void newCharacter() {
        Intent intent = new Intent(this,CharacterCreation.class);
        startActivity(intent);
    }

    private ArrayList<String> initializeList() {
        ArrayList<String> list = new ArrayList<>();

        for(CharProfile c : characters) {
            list.add(c.characterName);
        }

        return list;
    }
}
