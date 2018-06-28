package com.solution.migraine.migrainenova;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class QuestionaireMIDAS extends AppCompatActivity {

    private ImageView img_arrow_back;
    private EditText first_question_ans;
    private EditText second_question_ans;
    private EditText third_question_ans;
    private EditText fourth_question_ans;
    private EditText fifth_question_ans;
    private EditText sixth_question_ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire_midas);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());


    }

    private void initializeViews(){
        img_arrow_back = (ImageView) findViewById(R.id.arrow_back);
        img_arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionaireMIDAS.this.finish();
            }
        });



    }
}
