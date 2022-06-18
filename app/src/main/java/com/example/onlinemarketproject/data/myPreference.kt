package com.example.onlinemarketproject.data

import android.content.Context
import android.content.SharedPreferences

object myPreference {

   lateinit var pref:SharedPreferences


        fun init(context: Context) {
            pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE)
        }

    fun addIdItem(id:Int){
        val editor = pref.edit()
        editor.putInt("id",id)
        editor.apply()
    }

    fun getItem():Int{
        var myId=pref.getInt("id",0)
        return myId

    }
}

/*
public class PreferenceUtil {
  private static SharedPreferences pref;

  public static void init(Context context) {
    pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE);
  }}
 */