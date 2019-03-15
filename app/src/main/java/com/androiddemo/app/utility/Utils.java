package com.androiddemo.app.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by suryabalarajan on 03/07/2019.
 */
public class Utils {

    //This is a method to Check if the device internet connection is currently on
    public boolean isNetworkAvailable(Context mContext) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }
}
