package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public abstract class BaseOperator<V> {
    private static final String TAG = "BaseOperator";

    /* renamed from: db */
    private SQLiteDatabase f11796db;

    public BaseOperator(String str) {
        this.f11796db = SnapshotDBManager.getDB(str);
    }

    public void execSQL(String str) throws C9721b, SQLException {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql exception!" + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "execSQL");
        }
    }

    public void execSQL4Batch(String str, List<String[]> list) throws C9721b {
        Exception e10;
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "db is null.");
            return;
        }
        if (str == null || list == null) {
            return;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.f11796db.compileStatement(str);
                for (String[] strArr : list) {
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                    sQLiteStatementCompileStatement.execute();
                }
                this.f11796db.setTransactionSuccessful();
                try {
                    SQLiteDatabase sQLiteDatabase2 = this.f11796db;
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                        this.f11796db.endTransaction();
                    }
                    e10 = null;
                } catch (Exception e11) {
                    e10 = e11;
                    C11839m.m70687e(TAG, "catch exception when endTransaction!" + e10.getMessage());
                }
            } catch (Exception e12) {
                C11839m.m70687e(TAG, "catch exception when execSQL4Batch!" + e12.getMessage());
                try {
                    SQLiteDatabase sQLiteDatabase3 = this.f11796db;
                    if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                        this.f11796db.endTransaction();
                    }
                } catch (Exception e13) {
                    C11839m.m70687e(TAG, "catch exception when endTransaction!" + e13.getMessage());
                }
                e10 = e12;
            }
            if (e10 == null) {
                return;
            }
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "execSQL4Batch");
        } catch (Throwable th2) {
            try {
                SQLiteDatabase sQLiteDatabase4 = this.f11796db;
                if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                    this.f11796db.endTransaction();
                }
            } catch (Exception e14) {
                C11839m.m70687e(TAG, "catch exception when endTransaction!" + e14.getMessage());
            }
            throw th2;
        }
    }

    public List<Pair<String, String>> getAttachedDbs() {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.getAttachedDbs();
        }
        C11839m.m70689w(TAG, "getAttachedDbs db is null.");
        return null;
    }

    public SQLiteDatabase getDb() {
        return this.f11796db;
    }

    public abstract V getVo(Cursor cursor);

    public long queryResult(String str, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        long j10 = 0;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "queryResult4Vo db is null");
            return 0L;
        }
        if (str == null) {
            return 0L;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    j10 = cursorRawQuery.getLong(0);
                }
                return j10;
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "catch exception when queryResult" + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "queryResult");
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public List<String> queryResult4List(String str, String[] strArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        Cursor cursor = null;
        arrayList = null;
        ArrayList arrayList = null;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "queryResult4Map db is null.");
            return null;
        }
        try {
            if (str == null) {
                return null;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                String string = cursorRawQuery.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursorRawQuery.moveToNext());
                        }
                    } catch (Exception e10) {
                        e = e10;
                        C11839m.m70687e(TAG, "catch exception when queryResult4Map" + e.getMessage());
                        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e.getMessage(), "queryResult4Map");
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List<V>] */
    public List<V> queryResult4Vo(String str, String[] strArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        ArrayList arrayList = (List<V>) null;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "queryResult4Vo db is null.");
            return null;
        }
        if (str == null) {
            return null;
        }
        try {
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                arrayList.add(getVo(cursorRawQuery));
                            } while (cursorRawQuery.moveToNext());
                        }
                    } catch (Exception e10) {
                        e = e10;
                        arrayList = (List<V>) cursorRawQuery;
                        C11839m.m70687e(TAG, "catch exception when queryResult4Vo" + e.getMessage());
                        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e.getMessage(), "queryResult4Vo");
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList = cursorRawQuery;
                        if (arrayList != 0) {
                            arrayList.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return (List<V>) arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "rawQuery database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery database is null.", "rawQuery");
        }
        try {
            return sQLiteDatabase.rawQuery(str, strArr);
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "rawQuery error: " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery error." + e10.getMessage(), "rawQuery");
        }
    }

    public void setDb(SQLiteDatabase sQLiteDatabase) {
        this.f11796db = sQLiteDatabase;
    }

    public void execSQL(String str, Object[] objArr) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "invalid sql!");
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f11796db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str, objArr);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql and args exception!");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "execSQL");
        }
    }
}
