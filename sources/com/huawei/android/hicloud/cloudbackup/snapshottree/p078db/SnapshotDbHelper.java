package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotDBScript;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class SnapshotDbHelper extends SQLiteOpenHelper {
    private static final String TAG = "SnapshotDbHelper";

    public SnapshotDbHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d(TAG, "onCreate");
        try {
            sQLiteDatabase.execSQL(SnapshotDBScript.CREATE_TABLE_BACKUPRECORD_META);
            sQLiteDatabase.execSQL(SnapshotDBScript.CREATE_INDEX_TABLE_BACKUPRECORD_META);
        } catch (SQLException e10) {
            C11839m.m70687e(TAG, "onCreate error " + e10.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 > i11) {
            C11839m.m70686d(TAG, "onDowngrade");
        } else {
            C11839m.m70686d(TAG, "old version litter than new version, no need downgrade.");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            C11839m.m70686d(TAG, "onUpgrade");
        } else {
            C11839m.m70686d(TAG, "old version greater than new version, no need upgrade.");
        }
    }
}
