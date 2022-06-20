package com.example.onlinemarketproject.data

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast




object myPreference {

   lateinit var pref:SharedPreferences
   lateinit var editor: SharedPreferences.Editor


        fun init(context: Context) {
            pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE)
            editor = pref.edit()
        }

    fun addIdItem(id:Int){

        editor.putInt("$id",id)
        editor.apply()
    }

    fun getItem():Int{
        var myId=pref.getInt("id",0)
        return myId

    }

//    fun adding(id:Int){
//
//        val set = pref.getStringSet("yourKey", HashSet())
//        set!!.add(id)
//
//        editor.putStringSet("yourKey", set)
//        editor.commit()
//
//
//    }
}

/*
public class PreferenceUtil {
  private static SharedPreferences pref;

  public static void init(Context context) {
    pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE);
  }}
 */