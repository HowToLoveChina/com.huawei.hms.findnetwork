package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotDBScript;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11839m;
import p682ul.C13216j;

/* loaded from: classes2.dex */
public class SnapshotDBManager {
    private static final int COLUMN_INDEX_FIRST = 1;
    private static final int COLUMN_INDEX_SECOND = 2;
    private static final int COLUMN_INDEX_ZERO = 0;
    public static final String PREFIX_DATABASE_NAME = "snapshot";
    public static final String SUFFIX_DATABASE_NAME = ".db";
    private static final String TAG = "SnapshotDBManager";
    public static final String UNDRELINE_DATABASE_NAME = "_";
    private static final String WRITE_AHEAD_LOGGING_MODE_WAL = "wal";
    private static volatile Map<String, SQLiteDatabase> dbMap = new HashMap();

    private SnapshotDBManager() {
    }

    public static synchronized void closeDB(String str) {
        try {
            SQLiteDatabase sQLiteDatabase = dbMap.get(str);
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                flushDBCache(str);
                sQLiteDatabase.close();
            }
            dbMap.remove(str);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void flushDBCache(String str) {
        SQLiteDatabase sQLiteDatabase = dbMap.get(str);
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(SnapshotDBScript.PRAGMA_JOURNAL_MODE, null);
            if (cursorRawQuery.moveToFirst() && WRITE_AHEAD_LOGGING_MODE_WAL.equalsIgnoreCase(cursorRawQuery.getString(0))) {
                cursorRawQuery = sQLiteDatabase.rawQuery(SnapshotDBScript.PRAGMA_WAL_CHECKPOINT, null);
                if (cursorRawQuery.moveToFirst()) {
                    C11839m.m70688i(TAG, "flushDB  WAL cache , walBusy = " + cursorRawQuery.getInt(0) + ", walLog = " + cursorRawQuery.getInt(1) + ", walCheckpointed = " + cursorRawQuery.getInt(2));
                }
            }
            cursorRawQuery.close();
        } catch (SQLException e10) {
            C11839m.m70687e(TAG, "flushDBCache error, " + e10.getMessage());
        }
    }

    public static synchronized SQLiteDatabase getDB(String str) {
        SQLiteDatabase writableDatabase;
        String dBName = getDBName(str);
        writableDatabase = dbMap.get(str);
        if (writableDatabase == null || !writableDatabase.isOpen()) {
            try {
                writableDatabase = new SnapshotDbHelper(C0213f.m1378b(), dBName).getWritableDatabase();
                dbMap.put(str, writableDatabase);
            } catch (SQLiteException e10) {
                C11839m.m70687e(TAG, "getDB() error, " + e10.getMessage());
            }
        }
        return writableDatabase;
    }

    public static String getDBName(String str) {
        return "snapshot_" + str + SUFFIX_DATABASE_NAME;
    }

    public static synchronized boolean integrityCheck(String str) {
        return C13216j.m79430o(getDB(str));
    }
}
