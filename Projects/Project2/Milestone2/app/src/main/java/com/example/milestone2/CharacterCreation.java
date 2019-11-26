package com.example.milestone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CharacterCreation extends AppCompatActivity {
    private EditText myName;
    private Spinner myClassSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        myName = findViewById(R.id.editText);
        myClassSpinner = findViewById(R.id.spinner);
        saveButton = findViewById(R.id.button);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCharacter();
            }
        };

        saveButton.setOnClickListener(onClickListener);
    }

    protected void saveCharacter() {
        String name = myName.getText().toString();
        String clas = myClassSpinner.getSelectedItem().toString();
        CharProfile c = new CharProfile(name,clas);

        Bundle bundle = new Bundle();
        bundle.putSerializable("newChar",c);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
