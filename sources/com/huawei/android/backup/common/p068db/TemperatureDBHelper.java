package com.huawei.android.backup.common.p068db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class TemperatureDBHelper extends SQLiteOpenHelper {
    public TemperatureDBHelper(Context context) {
        super(context, "temperature.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE temperature (_id INTEGER PRIMARY KEY,deviceType INTEGER,temperature INTEGER,record_time TIMESTAMP)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
