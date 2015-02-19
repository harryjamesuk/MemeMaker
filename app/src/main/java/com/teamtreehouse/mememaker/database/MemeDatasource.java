package com.teamtreehouse.mememaker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.teamtreehouse.mememaker.models.Meme;
import com.teamtreehouse.mememaker.models.MemeAnnotation;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Evan Anger on 8/17/14.
 */
public class MemeDatasource {

    private Context mContext;
    private MemeSQLiteHelper mMemeSqlLiteHelper;

    public MemeDatasource(Context context) {
        mContext = context;
        mMemeSqlLiteHelper = new MemeSQLiteHelper(context);
        SQLiteDatabase database = mMemeSqlLiteHelper.getReadableDatabase();
        database.close();
    }

    private SQLiteDatabase open() {
        return mMemeSqlLiteHelper.getWritableDatabase();
    }

    private void close(SQLiteDatabase database) {
        database.close();
    }

    public void create(Meme meme) {
        SQLiteDatabase database = open();
        database.beginTransaction();
        // Implementation details
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }
}
