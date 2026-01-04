package pa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import p515oa.C11844a;

/* renamed from: pa.b */
/* loaded from: classes3.dex */
public abstract class AbstractC12124b<V> {

    /* renamed from: a */
    public SQLiteDatabase f56237a = C11844a.m70902a();

    /* renamed from: a */
    public void m72701a(String str, String[] strArr) throws Exception {
        if (strArr != null) {
            this.f56237a.execSQL(str, strArr);
        } else {
            this.f56237a.execSQL(str);
        }
    }

    /* renamed from: b */
    public void m72702b(String str, ArrayList<String[]> arrayList) throws Exception {
        if (str == null || arrayList == null) {
            return;
        }
        try {
            this.f56237a.beginTransaction();
            SQLiteStatement sQLiteStatementCompileStatement = this.f56237a.compileStatement(str);
            Iterator<String[]> it = arrayList.iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindAllArgsAsStrings(next);
                sQLiteStatementCompileStatement.execute();
            }
            this.f56237a.setTransactionSuccessful();
            this.f56237a.endTransaction();
        } catch (Throwable th2) {
            this.f56237a.endTransaction();
            throw th2;
        }
    }

    /* renamed from: c */
    public abstract V mo72688c(Cursor cursor);

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[DONT_GENERATE, PHI: r0 r1
  0x0031: PHI (r0v1 java.util.ArrayList<V>) = (r0v3 java.util.ArrayList<V>), (r0v4 java.util.ArrayList<V>) binds: [B:20:0x003c, B:17:0x002f] A[DONT_GENERATE, DONT_INLINE]
  0x0031: PHI (r1v3 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v5 android.database.Cursor) binds: [B:20:0x003c, B:17:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<V> m72703d(java.lang.String r4, java.lang.String[] r5) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r4 != 0) goto L8
            return r0
        L8:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r3.f56237a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L35
            android.database.Cursor r1 = r2.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L35
            if (r1 == 0) goto L2f
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L35
            if (r4 == 0) goto L2f
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L35
            r4.<init>()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L35
        L1c:
            java.lang.Object r5 = r3.mo72688c(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r4.add(r5)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            boolean r5 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            if (r5 != 0) goto L1c
            r0 = r4
            goto L2f
        L2b:
            r3 = move-exception
            goto L40
        L2d:
            r0 = r4
            goto L35
        L2f:
            if (r1 == 0) goto L3f
        L31:
            r1.close()
            goto L3f
        L35:
            java.lang.String r3 = "Operator"
            java.lang.String r4 = "queryResult4Vo exception"
            p514o9.C11839m.m70687e(r3, r4)     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L3f
            goto L31
        L3f:
            return r0
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.AbstractC12124b.m72703d(java.lang.String, java.lang.String[]):java.util.ArrayList");
    }
}
