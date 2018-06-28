package com.solution.migraine.migrainenova;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionaireMIDAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire_midas);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());


    }

    private void initializeViews(){

    }
}
