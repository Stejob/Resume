package com.example.myresume.utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.example.myresume.R;
import com.example.myresume.views.activities.MainActivity;
import com.example.myresume.views.activities.SplashActivity;

public class Utils{

    public static void showInternetDialog (Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getResources().getString(R.string.check_internet_connection))
                .setCancelable(false)
                .setPositiveButton(context.getResources().getString(R.string.ok),
                        (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }

    public static boolean isInternetConnected (Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            return true;
        return false;
    }


}
