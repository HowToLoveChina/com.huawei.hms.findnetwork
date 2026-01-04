package com.huawei.android.hicloud.cloudbackup.p076db.temp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
class AlumsTempDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_ALBUMS = "CREATE TABLE IF NOT EXISTS albums (albumId TEXT NOT NULL,tempId INTEGER NOT NULL,albumName TEXT NOT NULL,albumType INTEGER,displayName TEXT NOT NULL,relativePath TEXT NOT NULL,switchStatus INTEGER NOT NULL,outside INTEGER,PRIMARY KEY(tempId));";
    private static final String TAG = "AlumsTempDBHelper";

    public AlumsTempDBHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(CREATE_TABLE_ALBUMS);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
