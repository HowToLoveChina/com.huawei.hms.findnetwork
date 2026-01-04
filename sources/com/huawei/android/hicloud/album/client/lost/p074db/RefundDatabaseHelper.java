package com.huawei.android.hicloud.album.client.lost.p074db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p031b7.C1120a;

/* loaded from: classes2.dex */
public class RefundDatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static RefundDatabaseHelper f11501a;

    public RefundDatabaseHelper(Context context) {
        super(context, "album_refund.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* renamed from: d */
    public static synchronized RefundDatabaseHelper m15024d(Context context) {
        try {
            if (f11501a == null) {
                f11501a = new RefundDatabaseHelper(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f11501a;
    }

    /* renamed from: b */
    public void m15025b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6677i("RefundDatabaseHelper", "RefundDatabaseHelper clear.");
        if (sQLiteDatabase == null) {
            C1120a.m6678w("RefundDatabaseHelper", "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL("delete from t_refund");
            sQLiteDatabase.execSQL("delete from t_thumb_fix");
        } catch (Exception e10) {
            C1120a.m6678w("RefundDatabaseHelper", "exec clear sql Exception：" + e10.toString());
        }
    }

    /* renamed from: c */
    public final void m15026c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m15027e(sQLiteDatabase, 0, 4);
    }

    /* renamed from: e */
    public final void m15027e(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        boolean z10 = i10 >= 0 && i11 >= 0;
        boolean z11 = i11 == 4;
        boolean z12 = i10 < i11;
        if (!z10 || !z11 || !z12) {
            C1120a.m6676e("RefundDatabaseHelper", "updateDb illegal db version");
            return;
        }
        if (i10 < 1) {
            sQLiteDatabase.execSQL("create table if not exists t_refund (id INTEGER PRIMARY KEY AUTOINCREMENT,mediaId TEXT, assetID TEXT, sha256 TEXT, hashId TEXT, originalPath TEXT, smallThumbnailPath TEXT, largeThumbnailPath TEXT, thumbnailRefund INTEGER, useOriginalPath INTEGER, fileType INTEGER);");
        }
        if (i10 < 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_hide (mediaId TEXT PRIMARY KEY NOT NULL, albumId TEXT, fileName TEXT, hashId TEXT, sha256 TEXT);");
        }
        if (i10 < 3) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_hide_change (albumId TEXT PRIMARY KEY NOT NULL);");
        }
        if (i10 < 4) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_thumb_fix (mediaId TEXT PRIMARY KEY NOT NULL, size LONG, fileType INTEGER, lastFailTime TEXT, lastFailMsg TEXT);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6677i("RefundDatabaseHelper", "DatabaseHelper onCreate.");
        m15026c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1120a.m6677i("RefundDatabaseHelper", "DatabaseHelper onUpgrade.");
        m15027e(sQLiteDatabase, i10, i11);
    }
}
