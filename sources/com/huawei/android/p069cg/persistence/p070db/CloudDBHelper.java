package com.huawei.android.p069cg.persistence.p070db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p031b7.C1120a;

/* loaded from: classes2.dex */
public final class CloudDBHelper extends SQLiteOpenHelper {
    public CloudDBHelper(Context context) {
        super(context, "CloudAlbumV2.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public final void m14551b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS albumV2Cache (id TEXT PRIMARY KEY, albumName Text, albumVersion Text, flversion TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS albumV2Cursor (id TEXT, offset INTEGER, nextCursor TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6675d("CloudDBHelper", "Create CloudDatabase!");
        m14551b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C1120a.m6675d("CloudDBHelper", "Update CloudDatabase!");
    }
}
