package p016an;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import zm.C14345c;

/* renamed from: an.c */
/* loaded from: classes6.dex */
public abstract class AbstractC0315c<V> {
    private static final String TAG = "CommonOperator";

    /* renamed from: db */
    private SQLiteDatabase f1064db = C14345c.m85526a();

    public void execSQL(String str) throws C9721b, SQLException {
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C1461a.m8358e(TAG, "exec sql exception!" + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "execSQL");
        }
    }

    public void execSQL4Batch(String str, List<String[]> list) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db is null.");
            return;
        }
        if (str != null) {
            try {
                if (list == null) {
                    return;
                }
                try {
                    sQLiteDatabase.beginTransaction();
                    SQLiteStatement sQLiteStatementCompileStatement = this.f1064db.compileStatement(str);
                    for (String[] strArr : list) {
                        sQLiteStatementCompileStatement.clearBindings();
                        sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                        sQLiteStatementCompileStatement.execute();
                    }
                    this.f1064db.setTransactionSuccessful();
                    this.f1064db.endTransaction();
                } catch (Exception e10) {
                    C1461a.m8358e(TAG, "execSQL4Batch exception:" + e10.getMessage());
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e10.getMessage(), "execSQL4Batch");
                }
            } catch (Throwable th2) {
                this.f1064db.endTransaction();
                throw th2;
            }
        }
    }

    public SQLiteDatabase getDb() {
        return this.f1064db;
    }

    public abstract V getVo(Cursor cursor);

    public long queryCount(String str) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db null.");
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "db null");
        }
        if (str == null) {
            C1461a.m8360w(TAG, "sql null.");
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "sql null");
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(str, null);
                return (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) ? 0L : Long.parseLong(cursorRawQuery.getString(0));
            } catch (Exception e10) {
                C1461a.m8358e(TAG, "queryCount exception" + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e10.getMessage(), "queryCount");
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public List<String> queryGroup(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(str, null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C1461a.m8358e(TAG, "queryGroup exception" + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e10.getMessage(), "queryGroup");
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
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
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        ArrayList arrayList = (List<V>) null;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db null.");
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
                        C1461a.m8358e(TAG, "queryResult4Vo exception" + e.getMessage());
                        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e.getMessage(), "queryResult4Vo");
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

    public List<String> queryStringList(String str, String[] strArr) throws C9721b {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db null.");
            return arrayList;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C1461a.m8358e(TAG, "queryStringList exception");
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e10.getMessage(), "queryStringList");
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public void execSQL(String str, Object[] objArr) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str)) {
            C1461a.m8360w(TAG, "empty sql!");
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f1064db;
        if (sQLiteDatabase == null) {
            C1461a.m8360w(TAG, "db null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str, objArr);
        } catch (Exception e10) {
            C1461a.m8358e(TAG, "execSQL exception!");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL exception. " + e10.getMessage(), "execSQL");
        }
    }
}
