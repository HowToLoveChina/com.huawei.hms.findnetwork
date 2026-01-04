package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudRestoreMetadataDBHelper extends SQLiteOpenHelper {
    public CloudRestoreMetadataDBHelper(Context context) {
        super(context, "cloudbackup_metadata.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists app_restore_metainfo (appId text not null, fpath text not null, fname text not null, fsize integer not null, fileType integer not null, hash1 text not null, hash2 text, hmac text, status integer not null default 0, ftime integer not null, tarFile text, encoded integer not null, data1 text, data2 text, data3 text, data4 text, data5 text, unique(appId, fpath));");
        sQLiteDatabase.execSQL("create index if not exists idx_appId on app_restore_metainfo(appId);");
        sQLiteDatabase.execSQL("create table if not exists t_restore_asset_slice (id text not null, number integer not null, hash text not null, objectId text not null, start integer default 0, length integer default 0, status integer default 0, path text, taskId integer default -1, data1 text, data2 text, data3 text, data4 text, data5 text, unique(objectId, path));");
        sQLiteDatabase.execSQL("create index if not exists idx_objectId on t_restore_asset_slice(objectId);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupMetadataDBHelper", "cloud backup metadata database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists app_restore_metainfo;");
            sQLiteDatabase.execSQL("drop table if exists t_restore_asset_slice;");
            sQLiteDatabase.execSQL("create table if not exists app_restore_metainfo (appId text not null, fpath text not null, fname text not null, fsize integer not null, fileType integer not null, hash1 text not null, hash2 text, hmac text, status integer not null default 0, ftime integer not null, tarFile text, encoded integer not null, data1 text, data2 text, data3 text, data4 text, data5 text, unique(appId, fpath));");
            sQLiteDatabase.execSQL("create index if not exists idx_appId on app_restore_metainfo(appId);");
            sQLiteDatabase.execSQL("create index if not exists idx_objectId on t_restore_asset_slice(objectId);");
            sQLiteDatabase.execSQL("create index if not exists idx_objectId on t_restore_asset_slice(objectId);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 < 2) {
            sQLiteDatabase.execSQL("create table if not exists t_restore_asset_slice (id text not null, number integer not null, hash text not null, objectId text not null, start integer default 0, length integer default 0, status integer default 0, path text, taskId integer default -1, data1 text, data2 text, data3 text, data4 text, data5 text, unique(objectId, path));");
            sQLiteDatabase.execSQL("create index if not exists idx_objectId on t_restore_asset_slice(objectId);");
        }
    }
}
