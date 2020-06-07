package com.example.dailydiaryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dailydiaryapp.DiaryContract.*;
import androidx.annotation.Nullable;

public class DiaryDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "all_diaries.db";
    public static final int DATABASE_VERSION = 1;

    public DiaryDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_DIARY_LIST_TABLE = "CREATE TABLE " +
                DiaryEntry.TABLE_NAME + " (" +
                DiaryEntry.COLUMN_DATE + " TEXT PRIMARY KEY, " +
                DiaryEntry.COLUMN_TITLE + " TEXT, " +
                DiaryEntry.COLUMN_DESCRIPTION + " TEXT" +
                ");";
        db.execSQL(SQL_CREATE_DIARY_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DiaryEntry.TABLE_NAME);
        onCreate(db);
    }
}
