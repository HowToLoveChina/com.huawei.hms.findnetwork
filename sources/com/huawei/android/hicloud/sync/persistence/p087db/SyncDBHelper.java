package com.huawei.android.hicloud.sync.persistence.p087db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public final class SyncDBHelper extends SQLiteOpenHelper {
    public SyncDBHelper(Context context) {
        super(context, "sync.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    /* renamed from: b */
    public final void m17699b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ctag (ctag_name TEXT  PRIMARY KEY,ctag_value TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS etag (luid TEXT NOT NULL,type TEXT NOT NULL,etag TEXT NOT NULL,uuid TEXT,guid TEXT NOT NULL,hash TEXT,UNIQUE(luid,type));");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_etag_guid ON etag(guid);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (itemid TEXT NOT NULL,type TEXT NOT NULL,hash TEXT NOT NULL,name TEXT NOT NULL,UNIQUE(itemid,type,name));");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_file_url ON file(name);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file_info  (service TEXT NOT NULL, type TEXT NOT NULL, luid TEXT, uuid TEXT NOT NULL, name TEXT, file_type TEXT, create_time TEXT NOT NULL,UNIQUE(service, type, luid, name));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS status_info (key TEXT PRIMARY KEY,value TEXT NOT NULL, time TEXT);");
    }

    /* renamed from: c */
    public final void m17700c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ctag;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS etag;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file_info;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS status_info;");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("SyncDBHelper", "onCreate");
        m17699b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70689w("SyncDBHelper", "onDowngrade, oldVersion: " + i10 + ", newVersion: " + i11);
        m17700c(sQLiteDatabase);
        m17699b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70688i("SyncDBHelper", "onUpgrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 < 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file_info  (service TEXT NOT NULL, type TEXT NOT NULL, luid TEXT, uuid TEXT NOT NULL, name TEXT, file_type TEXT, create_time TEXT NOT NULL,UNIQUE(service, type, luid, name));");
        }
        if (i10 < 3) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS status_info (key TEXT PRIMARY KEY,value TEXT NOT NULL, time TEXT);");
        }
    }
}
