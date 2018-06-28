package com.solution.migraine.migrainenova;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txt_categories;
    private ImageView img_shoping_cart;

    private AppCompatButton btn_migraine_diagnostics;
    private AppCompatButton btn_migraine_difficulty;
    private AppCompatButton btn_migraine_diary;
    private AppCompatButton btn_migraine_treatment;

    private SharedPreferences user_sharedPreferences;
    private boolean userHasPremium = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.changeNotifBarColor(Color.parseColor("#6200EE"),getWindow());
        initializeViews();
        animations();

        user_sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE);
        userHasPremium = user_sharedPreferences.getBoolean("premium", false);

    }


    private void initializeViews(){

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        txt_categories = (TextView) findViewById(R.id.toolbar_title);
        img_shoping_cart = (ImageView) findViewById(R.id.img_shoping_cart);

        btn_migraine_diagnostics = (AppCompatButton) findViewById(R.id.btn_migraine_diagnostics);
        btn_migraine_difficulty = (AppCompatButton) findViewById(R.id.btn_migraine_difficulty);
        btn_migraine_treatment = (AppCompatButton) findViewById(R.id.btn_migraine_treatment);
        btn_migraine_diary = (AppCompatButton) findViewById(R.id.btn_migraine_diary);



    }


    private void animations(){

        Animation toolbar_title_anim = AnimationUtils.loadAnimation(this,R.anim.top_down_title);
        Animation toolbar_shoping_cart = AnimationUtils.loadAnimation(this,R.anim.top_down_cart);
        Animation fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        Animation fade_in_delay = AnimationUtils.loadAnimation(this,R.anim.fade_in_delay);

        txt_categories.startAnimation(toolbar_title_anim);
        img_shoping_cart.startAnimation(toolbar_shoping_cart);

        btn_migraine_diagnostics.startAnimation(fade_in);
        btn_migraine_difficulty.startAnimation(fade_in);
        btn_migraine_treatment.startAnimation(fade_in);
        btn_migraine_diary.startAnimation(fade_in);

    }


    public void btn_diagnostics(View view) {


    }

    public void btn_difficulty(View view) {


    }

    public void btn_treatment(View view) {
        if(!userHasPremium) {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Šiam veiksmui atlikti reikalinga pilna versija!")
                    .setConfirmText("Buy premium!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .setCancelText("Cancel")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
    }

    public void btn_diary(View view) {
        if(!userHasPremium) {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Šiam veiksmui atlikti reikalinga pilna versija!")
                    .setConfirmText("Buy premium!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .setCancelText("Cancel")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
    }
}
