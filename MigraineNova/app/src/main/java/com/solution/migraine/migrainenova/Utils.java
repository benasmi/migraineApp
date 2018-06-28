package com.solution.migraine.migrainenova;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Benas on 6/28/2018.
 */

public class Utils {

    public static void changeNotifBarColor(int color, Window window){

        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }

    }

    public static void buildAlertDialogPrompt(Context context, String title, String message, String positiveButtonText, String negativeButtonText , @Nullable DialogInterface.OnClickListener positiveButtonListener, @Nullable DialogInterface.OnClickListener negativeButtonListener){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, R.style.AppThemeDialog);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveButtonListener != null ? positiveButtonListener : new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(negativeButtonText, negativeButtonListener != null ? negativeButtonListener : new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
