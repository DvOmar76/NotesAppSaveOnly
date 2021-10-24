package com.example.notesappsaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"Notes",null,1) {
   val sqLiteDatabase:SQLiteDatabase=writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {

      if (p0 != null) p0.execSQL("create table Notes(note text)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun saveNote(note:String): Long {
        val cv=ContentValues()
        cv.put("note",note)
        return sqLiteDatabase.insert("Notes",null,cv)
    }
}