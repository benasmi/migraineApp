package com.solution.migraine.migrainenova;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private RadioButton first_question_positive_button;
    private RadioButton first_question_negative_button;

    private RadioButton second_question_positive_button;
    private RadioButton second_question_negative_button;

    private RadioButton third_question_positive_button;
    private RadioButton third_question_negative_button;

    private AppCompatButton button_submit;

    private TextView textView_diagnosis;
    private ImageView arrow_back;

    private View.OnClickListener radioButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(areAllQuestionsAnswered()){
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }else{
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    };

    private boolean areAllQuestionsAnswered() {
        return (first_question_negative_button.isChecked() || first_question_positive_button.isChecked()) &&
                (second_question_negative_button.isChecked() || second_question_positive_button.isChecked()) &&
                (third_question_negative_button.isChecked() || third_question_positive_button.isChecked());
    }

    private int positiveCount(){
        int numberCount = 0;
        if(first_question_positive_button.isChecked()){
            numberCount++;
        }
        if(second_question_positive_button.isChecked()){
            numberCount++;
        }
        if(third_question_positive_button.isChecked()){
            numberCount++;
        }

        return numberCount;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());

        initializeViews();

        first_question_negative_button.setOnClickListener(radioButtonListener);
        first_question_positive_button.setOnClickListener(radioButtonListener);
        second_question_negative_button.setOnClickListener(radioButtonListener);
        second_question_positive_button.setOnClickListener(radioButtonListener);
        third_question_negative_button.setOnClickListener(radioButtonListener);
        third_question_positive_button.setOnClickListener(radioButtonListener);

    }

    private void initializeViews(){
        first_question_positive_button = (RadioButton) findViewById(R.id.first_question_positive_button);
        first_question_negative_button = (RadioButton) findViewById(R.id.first_question_negative_button);
        second_question_positive_button = (RadioButton) findViewById(R.id.second_question_positive_button);
        second_question_negative_button = (RadioButton) findViewById(R.id.second_question_negative_button);
        third_question_positive_button = (RadioButton) findViewById(R.id.third_question_positive_button);
        third_question_negative_button = (RadioButton) findViewById(R.id.third_question_negative_button);
        button_submit = (AppCompatButton) findViewById(R.id.button_submit);
        textView_diagnosis = (TextView) findViewById(R.id.text_diagnosis);
        arrow_back = (ImageView) findViewById(R.id.arrow_back);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizActivity.this.finish();
            }
        });

    }

    public void getResults(View view) {
        if(areAllQuestionsAnswered()){
            textView_diagnosis.setVisibility(View.VISIBLE);

            if(positiveCount()==3){
                textView_diagnosis.setText("Jūs sergate Migrena, kreipkitės į savo gydytoją dėl gydymo ir formos patikslinimo.");
            }else if(positiveCount()==2){
                textView_diagnosis.setText("Dėl papildomo diagnozės patikslinimo reikia atlikti tyrimus, kuriuos Jums pasiulys Šeimos Gydytojas.");
            }else if(positiveCount()==1 || positiveCount()==0){
                textView_diagnosis.setText("Jūs nesergate migrena.");
            }

        }else{
            textView_diagnosis.setVisibility(View.GONE);
        }
    }
}
