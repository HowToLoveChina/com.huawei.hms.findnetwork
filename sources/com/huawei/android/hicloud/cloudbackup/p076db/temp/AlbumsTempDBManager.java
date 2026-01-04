package com.huawei.android.hicloud.cloudbackup.p076db.temp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class AlbumsTempDBManager {
    private static final String TAG = "AlbumsTempDBManager";
    private static volatile AlumsTempDBHelper dbHelper;
    private static Context mContext;
    private static String mPath;

    public static synchronized SQLiteDatabase getDB() {
        try {
            try {
                if (dbHelper == null) {
                    initDataBase(mContext, mPath);
                }
            } catch (SecurityException e10) {
                C11839m.m70687e(TAG, "getDB() error, " + e10.getMessage());
                C11839m.m70687e(TAG, "db is null");
                return null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return dbHelper != null ? dbHelper.getWritableDatabase() : null;
    }

    public static synchronized void initDataBase(Context context, String str) {
        if (context == null) {
            C11839m.m70687e(TAG, "context is null!");
            return;
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            C11839m.m70686d(TAG, "initDataBase start!");
            mContext = context;
            mPath = str;
            dbHelper = new AlumsTempDBHelper(mContext, str);
            return;
        }
        C11839m.m70687e(TAG, "invalid dbpath!");
    }
}
