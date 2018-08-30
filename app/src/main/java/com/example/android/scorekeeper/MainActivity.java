package com.example.android.scorekeeper;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String SCORE_TEAM_A = "teamascore";
    private static final String SCORE_TEAM_B = "teambscore";
    private static final String OFFSIDES_TEAM_A = "teamaoffsides";
    private static final String OFFSIDES_TEAM_B = "teamboffsides";
    private static final String CORNERS_TEAM_A = "teamacorners";
    private static final String CORNERS_TEAM_B = "teambcorners";
    private static final String FOULS_TEAM_A = "teamafouls";
    private static final String FOULS_TEAM_B = "teambfouls";
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int offsidesTeamA = 0;
    int offsidesTeamB = 0;
    int cornersTeamA = 0;
    int cornersTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    private ImageView image1, image2;
    private Spinner spinner1, spinner2;
    private TypedArray imgs1, imgs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Gets in all the values saved in Bundle on onSaveInstanceState methode.
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A, 0);
            scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B, 0);
            offsidesTeamA = savedInstanceState.getInt(OFFSIDES_TEAM_A, 0);
            offsidesTeamB = savedInstanceState.getInt(OFFSIDES_TEAM_B, 0);
            cornersTeamA = savedInstanceState.getInt(CORNERS_TEAM_A, 0);
            cornersTeamB = savedInstanceState.getInt(CORNERS_TEAM_B, 0);
            foulsTeamA = savedInstanceState.getInt(FOULS_TEAM_A, 0);
            foulsTeamB = savedInstanceState.getInt(FOULS_TEAM_B, 0);
            displayScoreForTeamA(scoreTeamA);
            displayScoreForTeamB(scoreTeamB);
            displayOffsidesForTeamA(offsidesTeamA);
            displayOffsidesForTeamB(offsidesTeamB);
            displayCornersForTeamA(cornersTeamA);
            displayCornersForTeamB(cornersTeamB);
            displayFoulsForTeamA(foulsTeamA);
            displayFoulsForTeamB(foulsTeamB);
        }


        //*Spinner1

        String[] teams;
        teams = getResources().getStringArray(R.array.team_array);
        imgs1 = getResources().obtainTypedArray(R.array.logo_echipe);

        image1 = (ImageView) findViewById(R.id.logo_a);
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teams);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                image1.setImageResource(imgs1.getResourceId(
                        spinner1.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        //*Spinner2
        teams = getResources().getStringArray(R.array.team_array);
        imgs2 = getResources().obtainTypedArray(R.array.logo_echipe);

        image2 = (ImageView) findViewById(R.id.logo_b);
        spinner2 = (Spinner) findViewById(R.id.spinner2);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                image2.setImageResource(imgs2.getResourceId(
                        spinner2.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    //* Add a goal for Team A.
    public void addOneForTeamA(View v) {

        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
    }

    /* Display score for team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    //* Add an offside for Team A.
    public void addOffsideForTeamA(View v) {

        offsidesTeamA = offsidesTeamA + 1;
        displayOffsidesForTeamA(offsidesTeamA);
    }

    /* Display offsides for team A.
     */
    public void displayOffsidesForTeamA(int offside) {
        TextView offsideView = (TextView) findViewById(R.id.team_a_offsides);
        offsideView.setText(String.valueOf(offside));
    }

    //* Add a corner for Team A.
    public void addCornerForTeamA(View v) {

        cornersTeamA = cornersTeamA + 1;
        displayCornersForTeamA(cornersTeamA);
    }

    /* Display corners for team A.
     */
    public void displayCornersForTeamA(int corner) {
        TextView cornerView = (TextView) findViewById(R.id.team_a_corners);
        cornerView.setText(String.valueOf(corner));
    }

    //* Add a foul for Team A.
    public void addFoulForTeamA(View v) {

        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    /* Display fouls for team A.
     */
    public void displayFoulsForTeamA(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(foul));
    }

    //* Add a goal for Teama B.
    public void addOneForTeamB(View v) {

        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
    }

    /* Display score for team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    //* Add an offside for Teama B.

    public void addOffsideForTeamB(View v) {

        offsidesTeamB = offsidesTeamB + 1;
        displayOffsidesForTeamB(offsidesTeamB);
    }

    /* Display offsides for team B.
     */
    public void displayOffsidesForTeamB(int offside) {
        TextView offsideView = (TextView) findViewById(R.id.team_b_offsides);
        offsideView.setText(String.valueOf(offside));
    }

    //* Add a corner for Teama B.
    public void addCornerForTeamB(View v) {

        cornersTeamB = cornersTeamB + 1;
        displayCornersForTeamB(cornersTeamB);
    }

    /* Display corners for team B.
     */
    public void displayCornersForTeamB(int corner) {
        TextView cornerView = (TextView) findViewById(R.id.team_b_corners);
        cornerView.setText(String.valueOf(corner));
    }

    //* Add a foul for Teama B.
    public void addFoulForTeamB(View v) {

        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB);
    }

    /* Display fouls for team B.
     */
    public void displayFoulsForTeamB(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(String.valueOf(foul));
    }

    //* Override the onSaveInstanceState method, this will write the variables values to the Bundle

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(SCORE_TEAM_A, scoreTeamA);
        savedInstanceState.putInt(SCORE_TEAM_B, scoreTeamB);
        savedInstanceState.putInt(OFFSIDES_TEAM_A, offsidesTeamA);
        savedInstanceState.putInt(OFFSIDES_TEAM_B, offsidesTeamB);
        savedInstanceState.putInt(CORNERS_TEAM_A, cornersTeamA);
        savedInstanceState.putInt(CORNERS_TEAM_B, cornersTeamB);
        savedInstanceState.putInt(FOULS_TEAM_A, foulsTeamA);
        savedInstanceState.putInt(FOULS_TEAM_B, foulsTeamB);
    }

    /* Reset all values fr both teams.

     */
    public void resetAll(View V) {
        scoreTeamA = 0;
        displayScoreForTeamA(scoreTeamA);
        scoreTeamB = 0;
        displayScoreForTeamB(scoreTeamB);
        offsidesTeamA = 0;
        displayOffsidesForTeamA(offsidesTeamA);
        offsidesTeamB = 0;
        displayOffsidesForTeamB(offsidesTeamB);
        cornersTeamA = 0;
        displayCornersForTeamA(cornersTeamA);
        cornersTeamB = 0;
        displayCornersForTeamB(cornersTeamB);
        foulsTeamA = 0;
        displayFoulsForTeamA(foulsTeamA);
        foulsTeamB = 0;
        displayFoulsForTeamB(foulsTeamB);

    }
}



