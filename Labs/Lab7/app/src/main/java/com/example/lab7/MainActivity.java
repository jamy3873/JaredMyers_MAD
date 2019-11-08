package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView movieSelection;
    private ToggleButton toggle;
    private Spinner spinner;
    private RadioGroup movieLength;
    private CheckBox ratingPG;
    private CheckBox ratingPG13;
    private CheckBox ratingR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieSelection = findViewById(R.id.movieSelection);
        toggle = findViewById(R.id.movieToggle);
        spinner = findViewById(R.id.genreSpinner);
        movieLength = findViewById(R.id.radioGroup);
        ratingPG = findViewById(R.id.checkBox1);
        ratingPG13 = findViewById(R.id.checkBox2);
        ratingR = findViewById(R.id.checkBox3);
    }

    public void findMovie(View view){
        //Check toggle button (time period)
        boolean oldMovie = toggle.isChecked();
        //Check spinner value (genre)
        String movieGenre = String.valueOf(spinner.getSelectedItem());
        //Check radio button (length)
        int length_id = movieLength.getCheckedRadioButtonId();
        //Check boxes (rating)
        boolean ratePG = ratingPG.isChecked();
        boolean ratePG13 = ratingPG13.isChecked();
        boolean rateR = ratingR.isChecked();

        //Initialize movie string
        String myMovie = "";

        if (length_id == -1){
            //Toast warning message
            Context context = getApplicationContext();
            CharSequence text = "Please select a preferred movie length";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);

            toast.show();
        }
        else{
            if (oldMovie){ //Old Movies
                switch (movieGenre){
                    case "Action":
                        if (rateR){
                            myMovie = "Diehard";
                        }
                        else {
                            myMovie = "Indiana Jones";
                        }
                        break;
                    case "Comedy":
                        if (length_id == R.id.radioButton1){ //Short Movie
                            myMovie = "Airplane";
                        }
                        else {
                            if (rateR){
                                myMovie = "Caddyshack";
                            }
                            else {
                                myMovie = "Dumb and Dumber";
                            }
                        }
                        break;
                    case "Romance":
                        if (length_id == R.id.radioButton3){ //Long Movie
                            myMovie = "Titanic";
                        }
                        else {
                            myMovie = "Sleepless in Seattle";
                        }
                        break;
                    default:
                        myMovie = "Star Wars";
                        break;
                }
            }
            else{ //New Movies
                switch (movieGenre){
                    case "Action":
                        if (rateR){
                            myMovie = "Terminator: Dark Fate";
                        }
                        else {
                            myMovie = "Gemini Man";
                        }
                        break;
                    case "Comedy":
                        if (rateR){
                            myMovie = "Deadpool";
                        }
                        else {
                            myMovie = "The Lego Movie";
                        }
                        break;
                    case "Romance":
                        myMovie = "Looking For Alaska";
                        break;
                    default:
                        myMovie = "Star Wars";
                        break;
                }
            }
        }

        if (!myMovie.contentEquals("")){
            movieSelection.setText("You should watch " + myMovie);
        }
    }
}
