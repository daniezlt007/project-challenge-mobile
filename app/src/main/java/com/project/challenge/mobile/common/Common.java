package com.project.challenge.mobile.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.project.challenge.mobile.model.User;
import com.project.challenge.mobile.model.UserResponse;

public class Common {

    public static User userCurrent;
    public static UserResponse userCurrentResponse;

    public static boolean isConnectedInternet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
        if(info != null){
            for (int i = 0; i < info.length; i++) {
                if(info[i].getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }

}
