package com.nbt.uitls;

import android.content.Context;
import android.content.SharedPreferences;

public class SpfUtils {
    private static SpfUtils _inst;
    private SpfUtils(){}

    private SharedPreferences spf;
    private SharedPreferences.Editor editor;

    public static SpfUtils $(){
        if(_inst == null){
            synchronized (SpfUtils.class){
                _inst = new SpfUtils();
            }
        }
        return _inst;
    }

    public void init(Context context){
        spf = context.getSharedPreferences(context.getPackageName(),Context.MODE_APPEND);
        editor = spf.edit();
    }

    public void saveTxtJokeLastPage(int page){
        editor.putInt("TxtLastPage",page).commit();
    }

    public int getTxtJokeLastPage(){
        return spf.getInt("TxtLastPage",1);
    }

    public void savePicJokeLastPage(int page){
        editor.putInt("PicLastPage",page).commit();
    }

    public int getPicJokeLastPage(){
        return spf.getInt("PicLastPage",1);
    }
}
