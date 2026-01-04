package com.huawei.android.hicloud.drive.clouddisk.expand.p085db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class DriveDatabaseHelper extends SQLiteOpenHelper {
    private static final String CLEAR_RESTORE = "delete from t_restore_status";
    private static final String CLEAR_TABLE_RESTORE = "delete from t_restore_status";
    private static final String CREATE_INDEX_RESTORE = "create index if not exists idx_hmac on t_restore_status(hmac)";
    private static final String CREATE_TABLE_RESTORE = "create table if not exists t_restore_status (hmac text not null, path text not null, num integer default 0, object text not null, synckey text not null, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (hmac, path, num asc));";
    private static final String DATABASE_NAME = "drive.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DROP_TABLE_RESTORE = "drop table if exists t_restore_status";
    private static final String TAG = "DriveDatabaseHelper";
    private static DriveDatabaseHelper driveDatabaseHelper;

    private DriveDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static synchronized DriveDatabaseHelper getInstance(Context context) {
        try {
            if (driveDatabaseHelper == null) {
                driveDatabaseHelper = new DriveDatabaseHelper(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return driveDatabaseHelper;
    }

    public void clear(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d(TAG, "DriveDatabaseHelper clear.");
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL("delete from t_restore_status");
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "exec clear sql Exception：" + e10.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d(TAG, "DriveDatabaseHelper onCreate.");
        sQLiteDatabase.execSQL(CREATE_TABLE_RESTORE);
        sQLiteDatabase.execSQL(CREATE_INDEX_RESTORE);
    }

    public void onDestroy() throws SQLException {
        try {
            driveDatabaseHelper.getWritableDatabase().execSQL("delete from t_restore_status");
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "DriveDatabaseHelper onDestroy error." + e10.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C11839m.m70686d(TAG, "DriveDatabaseHelper onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70686d(TAG, "DriveDatabaseHelper onUpgrade.");
        sQLiteDatabase.execSQL(DROP_TABLE_RESTORE);
        sQLiteDatabase.execSQL(CREATE_TABLE_RESTORE);
        sQLiteDatabase.execSQL(CREATE_INDEX_RESTORE);
    }
}
