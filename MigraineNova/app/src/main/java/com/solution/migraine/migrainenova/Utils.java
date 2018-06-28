package com.solution.migraine.migrainenova;

import android.os.Build;
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

}
