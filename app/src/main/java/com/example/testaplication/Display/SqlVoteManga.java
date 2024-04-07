package com.example.testaplication.Display;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SqlVoteManga extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vote3.db";
    private static final int DATABASE_VERSION = 1;

    // Define your table and column names
    private static final String TABLE_NAME = "TotalVote";
    private static final String COLUMN_MANGA = "manga";
    private static final String COLUMN_VOTE = "vote";

    // Create the table creation SQL statement
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_MANGA + " TEXT, "
            + COLUMN_VOTE + " DOUBLE "
            + ")";

    public SqlVoteManga(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    public void insertVote(String managa,int vote){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        contentValues.put(COLUMN_MANGA,managa);
        contentValues.put(COLUMN_VOTE,vote);
        db.insert(TABLE_NAME,null,contentValues);
    }
    public double totalVote(String manga) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT AVG(" + COLUMN_VOTE + ") FROM " + TABLE_NAME + " WHERE " + COLUMN_MANGA + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{manga});
        double total = 0.0;
        if (cursor.moveToFirst()) {
            total = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return total;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
