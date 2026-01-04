package p673u9;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.huawei.android.hicloud.p081cs.p082db.DBManager;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* renamed from: u9.b */
/* loaded from: classes3.dex */
public abstract class AbstractC13137b<V> {

    /* renamed from: a */
    public SQLiteDatabase f59635a = DBManager.m16249b();

    /* renamed from: a */
    public void m79017a(String str) throws C9721b, SQLException {
        SQLiteDatabase sQLiteDatabase = this.f59635a;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("Operator", "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C11839m.m70687e("Operator", "exec sql exception!" + e10.getMessage());
            throw new C9721b(4007, "execSQL error. " + e10.getMessage(), "execSQL");
        }
    }

    /* renamed from: b */
    public void m79018b(String str, Object[] objArr) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("Operator", "invalid sql!");
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f59635a;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("Operator", "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL(str, objArr);
        } catch (Exception e10) {
            C11839m.m70687e("Operator", "exec sql and args exception!");
            throw new C9721b(4007, "execSQL error. " + e10.getMessage(), "execSQL");
        }
    }

    /* renamed from: c */
    public void m79019c(String str, List<String[]> list) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f59635a;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("Operator", "db is null.");
            return;
        }
        if (str != null) {
            try {
                if (list == null) {
                    return;
                }
                try {
                    sQLiteDatabase.beginTransaction();
                    SQLiteStatement sQLiteStatementCompileStatement = this.f59635a.compileStatement(str);
                    for (String[] strArr : list) {
                        sQLiteStatementCompileStatement.clearBindings();
                        sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                        sQLiteStatementCompileStatement.execute();
                    }
                    this.f59635a.setTransactionSuccessful();
                    this.f59635a.endTransaction();
                } catch (Exception e10) {
                    C11839m.m70687e("Operator", "catch exception when execSQL4Batch!" + e10.getMessage());
                    throw new C9721b(4007, "execSQL error. " + e10.getMessage(), "execSQL4Batch");
                }
            } catch (Throwable th2) {
                this.f59635a.endTransaction();
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public abstract V mo79010d(Cursor cursor);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List<V>] */
    /* renamed from: e */
    public List<V> m79020e(String str, String[] strArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.f59635a;
        ArrayList arrayList = (List<V>) null;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("Operator", "db is null.");
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
                                arrayList.add(mo79010d(cursorRawQuery));
                            } while (cursorRawQuery.moveToNext());
                        }
                    } catch (Exception e10) {
                        e = e10;
                        arrayList = (List<V>) cursorRawQuery;
                        C11839m.m70687e("Operator", "catch exception when queryResult4Vo" + e.getMessage());
                        throw new C9721b(4007, "execSQL error. " + e.getMessage(), "queryResult4Vo");
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
}
