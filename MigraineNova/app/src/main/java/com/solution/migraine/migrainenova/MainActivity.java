package com.solution.migraine.migrainenova;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private TextView txt_categories;
    private ImageView img_shoping_cart;

    private AppCompatButton btn_migraine_diagnostics;
    private AppCompatButton btn_migraine_difficulty;
    private AppCompatButton btn_migraine_diary;
    private AppCompatButton btn_migraine_treatment;

    private AppCompatButton btn_question_1;
    private AppCompatButton btn_question_2;
    private AppCompatButton btn_question_3;

    private boolean userHasPremium = false;

    //TODO: Move this variable to a class, which would manage database stuff.
    public static final String SHARED_PREFS_USER = "USER_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());
        initializeViews();
        startAnimations();

        //Checking whether user has full version purchased or not
        userHasPremium = getSharedPreferences(MainActivity.SHARED_PREFS_USER, MODE_PRIVATE).getBoolean("premium", false);
    }


    private void initializeViews(){
        txt_categories = (TextView) findViewById(R.id.toolbar_title);
        img_shoping_cart = (ImageView) findViewById(R.id.img_shoping_cart);

        btn_migraine_diagnostics = (AppCompatButton) findViewById(R.id.btn_migraine_diagnostics);
        btn_migraine_difficulty = (AppCompatButton) findViewById(R.id.btn_migraine_difficulty);
        btn_migraine_treatment = (AppCompatButton) findViewById(R.id.btn_migraine_treatment);
        btn_migraine_diary = (AppCompatButton) findViewById(R.id.btn_migraine_diary);

        btn_question_1 = (AppCompatButton) findViewById(R.id.question_1_btn);
        btn_question_2 = (AppCompatButton) findViewById(R.id.question_2_btn);
        btn_question_3 = (AppCompatButton) findViewById(R.id.question_3_btn);
    }


    private void startAnimations(){

        Animation toolbar_title_anim = AnimationUtils.loadAnimation(this,R.anim.top_down_title);
        Animation toolbar_shoping_cart = AnimationUtils.loadAnimation(this,R.anim.top_down_cart);
        Animation fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        txt_categories.startAnimation(toolbar_title_anim);
        img_shoping_cart.startAnimation(toolbar_shoping_cart);

        btn_migraine_diagnostics.startAnimation(fade_in);
        btn_migraine_difficulty.startAnimation(fade_in);
        btn_migraine_treatment.startAnimation(fade_in);
        btn_migraine_diary.startAnimation(fade_in);
        btn_question_1.startAnimation(fade_in);
        btn_question_2.startAnimation(fade_in);
        btn_question_3.startAnimation(fade_in);

    }

    @Override
    public void onBackPressed() {
        //Putting app in background
        moveTaskToBack(true);
    }

    public void btn_diagnostics(View view) {
        startActivity(new Intent(this, QuizActivity.class));

    }

    public void btn_difficulty(View view) {
        startActivity(new Intent(this, QuestionaireMIDAS.class));

    }

    public void btn_treatment(View view) {
        if(!userHasPremium) {
            premiumAlert();
        }
    }

    public void btn_diary(View view) {
        if(!userHasPremium) {
            premiumAlert();
        }
    }

    private void premiumAlert(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(getString(R.string.premium_alert_title_text))
                .setContentText(getString(R.string.premium_alert_content_text))
                .setConfirmText(getString(R.string.premium_alert_confirmation_text))
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .setCancelText(getString(R.string.cancel))
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    public void question_1(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(getResources().getString(R.string.question_1_URL)));
        startActivity(i);
    }
    public void question_2(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(getResources().getString(R.string.question_2_URL)));
        startActivity(i);
    }
    public void question_3(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(getResources().getString(R.string.question_3_URL)));
        startActivity(i);
    }
}
