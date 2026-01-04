package com.huawei.android.hicloud.drive.clouddisk.p084db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public final class SyncDiskDBHelper extends SQLiteOpenHelper {
    public SyncDiskDBHelper(Context context) {
        super(context, "syncdisk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public final void m16346b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS diskBigFile (fileId TEXT PRIMARY KEY, fileName TEXT, fileSize TEXT, fileMd5 TEXT, modifyTime TEXT, fileParent TEXT, fileParentName TEXT, fileCategory TEXT, thumbnailPath TEXT, isCloudExist TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS diskDuplicateFile (fileId TEXT PRIMARY KEY, fileName TEXT, fileSize TEXT, fileMd5 TEXT, modifyTime TEXT, fileParent TEXT, fileParentName TEXT, fileCategory TEXT, thumbnailPath TEXT, isCloudExist TEXT);");
    }

    /* renamed from: c */
    public final void m16347c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS diskBigFile;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS diskDuplicateFile;");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("SyncDiskDBHelper", "onCreate");
        m16346b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70689w("SyncDiskDBHelper", "onDowngrade, oldVersion: " + i10 + ", newVersion: " + i11);
        m16347c(sQLiteDatabase);
        m16346b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70688i("SyncDiskDBHelper", "onUpgrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 < 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS diskBigFile (fileId TEXT PRIMARY KEY, fileName TEXT, fileSize TEXT, fileMd5 TEXT, modifyTime TEXT, fileParent TEXT, fileParentName TEXT, fileCategory TEXT, thumbnailPath TEXT, isCloudExist TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS diskDuplicateFile (fileId TEXT PRIMARY KEY, fileName TEXT, fileSize TEXT, fileMd5 TEXT, modifyTime TEXT, fileParent TEXT, fileParentName TEXT, fileCategory TEXT, thumbnailPath TEXT, isCloudExist TEXT);");
        }
    }
}
