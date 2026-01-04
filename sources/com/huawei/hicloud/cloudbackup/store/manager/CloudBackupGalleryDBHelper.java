package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupGalleryDBHelper extends SQLiteOpenHelper {
    public CloudBackupGalleryDBHelper(Context context) {
        super(context, AlbumsTempScript.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists albums (albumId text not null,tempId integer not null,albumName text not null,albumType integer,displayName text not null,relativePath text not null,switchStatus integer not null,outside integer,primary key(tempId));");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupGalleryDBHelper", "cloud backup gallery database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists albums;");
            sQLiteDatabase.execSQL("create table if not exists albums (albumId text not null,tempId integer not null,albumName text not null,albumType integer,displayName text not null,relativePath text not null,switchStatus integer not null,outside integer,primary key(tempId));");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            C11839m.m70688i("CloudBackupGalleryDBHelper", "cloud backup gallery database upgrade. oldVersion = " + i10);
        }
    }
}
