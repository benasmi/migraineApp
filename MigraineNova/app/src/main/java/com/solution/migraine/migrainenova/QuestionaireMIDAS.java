package com.solution.migraine.migrainenova;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class QuestionaireMIDAS extends AppCompatActivity {

    private EditText et_first_question_ans;
    private EditText et_second_question_ans;
    private EditText et_third_question_ans;
    private EditText et_fourth_question_ans;
    private EditText et_fifth_question_ans;
    private EditText et_sixth_question_ans;

    private TextView txt_results;
    private ExpandableRelativeLayout expandable_layout_results;
    private AppCompatButton btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire_midas);

        //Changing the notification bar color programatically
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());

        initializeViews();
    }

    private void initializeViews(){
        et_first_question_ans = (EditText) findViewById(R.id.first_question_ans);
        et_second_question_ans = (EditText) findViewById(R.id.second_question_ans);
        et_third_question_ans = (EditText) findViewById(R.id.third_question_ans);
        et_fourth_question_ans = (EditText) findViewById(R.id.fourth_question_ans);
        et_fifth_question_ans = (EditText) findViewById(R.id.fifth_question_ans);
        et_sixth_question_ans = (EditText) findViewById(R.id.sixth_question_ans);

        et_first_question_ans.addTextChangedListener(editTextWatcher);
        et_second_question_ans.addTextChangedListener(editTextWatcher);
        et_third_question_ans.addTextChangedListener(editTextWatcher);
        et_fourth_question_ans.addTextChangedListener(editTextWatcher);
        et_fifth_question_ans.addTextChangedListener(editTextWatcher);
        et_sixth_question_ans.addTextChangedListener(editTextWatcher);

        btn_submit = (AppCompatButton) findViewById(R.id.button_submit);
        expandable_layout_results = (ExpandableRelativeLayout) findViewById(R.id.expandable_layout_midas_results);
        txt_results = (TextView) findViewById(R.id.results);
    }

    /**
     * Checks whether or not all editTexts have texts in them.
     * @return A boolean, which represents whether all editTexts are filled or not.
     */
    private boolean areAllFieldsFilled(){
        return  !et_first_question_ans.getText().toString().isEmpty() &&
                !et_second_question_ans.getText().toString().isEmpty() &&
                !et_third_question_ans.getText().toString().isEmpty() &&
                !et_fourth_question_ans.getText().toString().isEmpty() &&
                !et_fifth_question_ans.getText().toString().isEmpty() &&
                !et_sixth_question_ans.getText().toString().isEmpty();
    }


    public void getResults(View view) {
        if(areAllFieldsFilled()){

            //Calculating the total amount of days user presumably had headaches.
            int totalDays = 0;
            totalDays+=Integer.valueOf(et_first_question_ans.getText().toString());
            totalDays+=Integer.valueOf(et_second_question_ans.getText().toString());
            totalDays+=Integer.valueOf(et_third_question_ans.getText().toString());
            totalDays+=Integer.valueOf(et_fourth_question_ans.getText().toString());
            totalDays+=Integer.valueOf(et_fifth_question_ans.getText().toString());
            totalDays+=Integer.valueOf(et_sixth_question_ans.getText().toString());

            //Concluding the diagnosis based on day count.
            String result = "";
            if(totalDays > 21){
                result = getString(R.string.fourth_degree_migraine);
            }else if(totalDays > 0 && totalDays <= 5){
                result = getString(R.string.first_degree_migraine);
            }else if(totalDays > 5 && totalDays <= 10){
                result = getString(R.string.second_degree_migraine);
            }else if(totalDays > 10 && totalDays <= 20){
                result = getString(R.string.third_degree_migraine);
            }

            //Displaying the diagnosis
            txt_results.setText(result);
            if(!expandable_layout_results.isExpanded()){
                expandable_layout_results.expand();
            }

        }else{
            //Hiding the diagnosis
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

            //Checking whether all fields are filled, and toggling the button accordingly.
            if(areAllFieldsFilled()){
                btn_submit.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }else{
                btn_submit.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    };

}
