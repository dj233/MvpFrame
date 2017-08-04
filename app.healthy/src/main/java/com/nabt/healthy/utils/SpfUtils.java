package com.nabt.healthy.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpfUtils {


    public static boolean isDuTurn(Context context){
        SharedPreferences sp = context.getSharedPreferences("CONFIG", Context.MODE_PRIVATE);
        return sp.getBoolean("isDuTurn",false);
    }

    public static void markDuTurn(Context context, boolean duTurn){
        SharedPreferences sp = context.getSharedPreferences("CONFIG",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isDuTurn", duTurn);
        editor.commit();
    }
}
