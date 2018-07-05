package com.solution.migraine.migrainenova;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private RadioButton RB_first_question_positive_button;
    private RadioButton RB_first_question_negative_button;

    private RadioButton RB_second_question_positive_button;
    private RadioButton RB_second_question_negative_button;

    private RadioButton RB_third_question_positive_button;
    private RadioButton RB_third_question_negative_button;

    private AppCompatButton button_submit;
    private TextView txt_diagnosis;

    private View.OnClickListener radioButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Checking whether user has checked all boxes, and toggling button accordingly
            if(areAllQuestionsAnswered()){
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }else{
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    };

    /**
     * Checks whether or not user has made all the choices required for
     * conclusion
     * @return Boolean, which represents whether or not user has made all choices required
     */
    private boolean areAllQuestionsAnswered() {
        return (RB_first_question_negative_button.isChecked() || RB_first_question_positive_button.isChecked()) &&
                (RB_second_question_negative_button.isChecked() || RB_second_question_positive_button.isChecked()) &&
                (RB_third_question_negative_button.isChecked() || RB_third_question_positive_button.isChecked());
    }

    /**
     * @return The number of questions user has answered positive
     */
    private int positiveCount(){
        int numberCount = 0;
        if(RB_first_question_positive_button.isChecked()){
            numberCount++;
        }
        if(RB_second_question_positive_button.isChecked()){
            numberCount++;
        }
        if(RB_third_question_positive_button.isChecked()){
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

        RB_first_question_negative_button.setOnClickListener(radioButtonListener);
        RB_first_question_positive_button.setOnClickListener(radioButtonListener);
        RB_second_question_negative_button.setOnClickListener(radioButtonListener);
        RB_second_question_positive_button.setOnClickListener(radioButtonListener);
        RB_third_question_negative_button.setOnClickListener(radioButtonListener);
        RB_third_question_positive_button.setOnClickListener(radioButtonListener);

    }

    private void initializeViews(){
        RB_first_question_positive_button = (RadioButton) findViewById(R.id.first_question_positive_button);
        RB_first_question_negative_button = (RadioButton) findViewById(R.id.first_question_negative_button);
        RB_second_question_positive_button = (RadioButton) findViewById(R.id.second_question_positive_button);
        RB_second_question_negative_button = (RadioButton) findViewById(R.id.second_question_negative_button);
        RB_third_question_positive_button = (RadioButton) findViewById(R.id.third_question_positive_button);
        RB_third_question_negative_button = (RadioButton) findViewById(R.id.third_question_negative_button);
        button_submit = (AppCompatButton) findViewById(R.id.button_submit);
        txt_diagnosis = (TextView) findViewById(R.id.text_diagnosis);
    }

    /**
     * Concluding user's diagnosis
     * @param view The view, which was pressed
     */
    public void getResults(View view) {
        if(areAllQuestionsAnswered()){
            //Making the diagnosis textview visible
            txt_diagnosis.setVisibility(View.VISIBLE);

            if(positiveCount()==3){
                txt_diagnosis.setText(R.string.migraine_diagnosis_3);
            }else if(positiveCount()==2){
                txt_diagnosis.setText(R.string.migraine_diagnosis_2);
            }else if(positiveCount()==1 || positiveCount()==0){
                txt_diagnosis.setText(R.string.migraine_diagnosis_1);
            }

        }else{
            txt_diagnosis.setVisibility(View.GONE);
        }
    }

    public void backPressed(View view) {
        finish();
    }
}
