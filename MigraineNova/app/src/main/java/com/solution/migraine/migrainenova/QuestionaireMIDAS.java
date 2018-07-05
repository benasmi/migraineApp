package com.solution.migraine.migrainenova;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class QuestionaireMIDAS extends AppCompatActivity {

    private ImageView img_arrow_back;
    private EditText first_question_ans;
    private EditText second_question_ans;
    private EditText third_question_ans;
    private EditText fourth_question_ans;
    private EditText fifth_question_ans;
    private EditText sixth_question_ans;
    private TextView results;
    private ExpandableRelativeLayout expandable_layout_results;

    private AppCompatButton button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire_midas);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());
        initializeViews();
    }

    private void initializeViews(){
        img_arrow_back = (ImageView) findViewById(R.id.arrow_back);
        img_arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionaireMIDAS.this.finish();
            }
        });

        first_question_ans = (EditText) findViewById(R.id.first_question_ans);
        second_question_ans = (EditText) findViewById(R.id.second_question_ans);
        third_question_ans = (EditText) findViewById(R.id.third_question_ans);
        fourth_question_ans = (EditText) findViewById(R.id.fourth_question_ans);
        fifth_question_ans = (EditText) findViewById(R.id.fifth_question_ans);
        sixth_question_ans = (EditText) findViewById(R.id.sixth_question_ans);
        button_submit = (AppCompatButton) findViewById(R.id.button_submit);

        expandable_layout_results = (ExpandableRelativeLayout) findViewById(R.id.expandable_layout_midas_results);

        first_question_ans.addTextChangedListener(editTextWatcher);
        second_question_ans.addTextChangedListener(editTextWatcher);
        third_question_ans.addTextChangedListener(editTextWatcher);
        fourth_question_ans.addTextChangedListener(editTextWatcher);
        fifth_question_ans.addTextChangedListener(editTextWatcher);
        sixth_question_ans.addTextChangedListener(editTextWatcher);

        results = (TextView) findViewById(R.id.results);
    }

    private boolean areAllFieldsFilled(){
        return  !first_question_ans.getText().toString().isEmpty() &&
                !second_question_ans.getText().toString().isEmpty() &&
                !third_question_ans.getText().toString().isEmpty() &&
                !fourth_question_ans.getText().toString().isEmpty() &&
                !fifth_question_ans.getText().toString().isEmpty() &&
                !sixth_question_ans.getText().toString().isEmpty();
    }

    public void getResults(View view) {
        if(areAllFieldsFilled()){

            int totalDays = 0;
            totalDays+=Integer.valueOf(first_question_ans.getText().toString());
            totalDays+=Integer.valueOf(second_question_ans.getText().toString());
            totalDays+=Integer.valueOf(third_question_ans.getText().toString());
            totalDays+=Integer.valueOf(fourth_question_ans.getText().toString());
            totalDays+=Integer.valueOf(fifth_question_ans.getText().toString());
            totalDays+=Integer.valueOf(sixth_question_ans.getText().toString());

            String result = "";

            if(totalDays > 21){
                result = "IV laipsnis. Labai didelė įtaka gyvenimo kokybei. Tikslinga svarstyti profilaktinio gydymo skyrimą.";
            }else if(totalDays > 0 && totalDays <= 5){
                result = "I laipsnis. Labai maža įtaka kasdieniai veiklai. Profilaktinis gydymas nedįdinkuotinas";
            }else if(totalDays > 5 && totalDays <= 10){
                result = "II laipsnis. Maža įtaka kasdienei veiklai. Profilaktinis gydymas gali būti svarstytinas esant galvos skausmui susijusiam su mėnesinių ciklu.";
            }else if(totalDays > 10 && totalDays <= 20){
                result = "III laipsnis Vidutine įtaka kasdienei veiklai. Profilaktinis gydymas gali būti svarstytinas esant galvos skausmui susijusiam su mėnesinių ciklu. ";
            }

            results.setText(result);
            results.setVisibility(View.VISIBLE);
            if(!expandable_layout_results.isExpanded()){
                expandable_layout_results.expand();
            }

        }else{
            results.setVisibility(View.GONE);
            if(expandable_layout_results.isExpanded()){
                expandable_layout_results.collapse();
            }
        }

    }

    public void backPressed(View view) {
        finish();
    }

    private TextWatcher editTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(areAllFieldsFilled()){
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }else{
                button_submit.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    };

}
