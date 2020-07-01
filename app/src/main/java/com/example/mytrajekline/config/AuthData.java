package com.example.mytrajekline.config;
import android.content.Context;
import android.content.SharedPreferences;

public class AuthData {
    private static AuthData mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "sharedlogin";
    private static final String id_user = "kodeauth";
    private static final String nama = "kodeuser";
    private AuthData(Context context){
        mCtx = context;
    }
    public static synchronized AuthData getInstance(Context context){
        if (mInstance == null){
            mInstance = new AuthData(context);
        }
        return mInstance;
    }
    //fungsi auth data ini bertujuan untuk menyimpan data auth login. fungsi ini sama seperti fungsi session di web
    public boolean setdatauser(String xid_user, String xnama){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(id_user, xid_user);
        editor.putString(nama, xnama);
        editor.apply();

        return true;
    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(id_user, null) != null) {
            return true;
        }
        return false;
    }

    public String getId_user() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString(id_user, null);
    }
    public String getNama() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(nama, null);
    }
    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}


