package com.huawei.android.backup.common.p068db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import p566q4.C12286e;

/* loaded from: classes.dex */
public abstract class Operator<V> {

    /* renamed from: a */
    public SQLiteDatabase f9513a;

    public Operator(Context context) {
        this.f9513a = C12286e.m73818a(context);
    }

    /* renamed from: a */
    public abstract V mo12587a(Cursor cursor);

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[PHI: r2 r5
  0x005f: PHI (r2v4 android.database.Cursor) = (r2v27 android.database.Cursor), (r2v28 android.database.Cursor), (r2v29 android.database.Cursor) binds: [B:33:0x005d, B:38:0x006b, B:40:0x0071] A[DONT_GENERATE, DONT_INLINE]
  0x005f: PHI (r5v6 java.util.ArrayList<V>) = (r5v4 java.util.ArrayList<V>), (r5v5 java.util.ArrayList<V>), (r5v8 java.util.ArrayList<V>) binds: [B:33:0x005d, B:38:0x006b, B:40:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.ArrayList<V>] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<V> m12588b(java.lang.String r4, java.lang.String[] r5) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "Operator"
            android.database.sqlite.SQLiteDatabase r1 = r3.f9513a
            r2 = 0
            if (r1 == 0) goto L7b
            boolean r1 = r1.isOpen()
            if (r1 != 0) goto Lf
            goto L7b
        Lf:
            android.database.sqlite.SQLiteDatabase r1 = r3.f9513a     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.lang.IllegalStateException -> L54 android.database.sqlite.SQLiteException -> L56
            android.database.Cursor r4 = r1.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.lang.IllegalStateException -> L54 android.database.sqlite.SQLiteException -> L56
            if (r4 == 0) goto L4a
            int r5 = r4.getCount()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L44 java.lang.IllegalStateException -> L46 android.database.sqlite.SQLiteException -> L48
            if (r5 <= 0) goto L4a
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L44 java.lang.IllegalStateException -> L46 android.database.sqlite.SQLiteException -> L48
            if (r5 == 0) goto L4a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L44 java.lang.IllegalStateException -> L46 android.database.sqlite.SQLiteException -> L48
            int r1 = r4.getCount()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L44 java.lang.IllegalStateException -> L46 android.database.sqlite.SQLiteException -> L48
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L44 java.lang.IllegalStateException -> L46 android.database.sqlite.SQLiteException -> L48
        L2c:
            java.lang.Object r1 = r3.mo12587a(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.IllegalStateException -> L40 android.database.sqlite.SQLiteException -> L42
            r5.add(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.IllegalStateException -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r4.moveToNext()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.IllegalStateException -> L40 android.database.sqlite.SQLiteException -> L42
            if (r1 != 0) goto L2c
            r2 = r5
            goto L4a
        L3b:
            r3 = move-exception
            r2 = r4
            goto L75
        L3e:
            r2 = r4
            goto L58
        L40:
            r2 = r4
            goto L64
        L42:
            r2 = r4
            goto L6c
        L44:
            r5 = r2
            goto L3e
        L46:
            r5 = r2
            goto L40
        L48:
            r5 = r2
            goto L42
        L4a:
            if (r4 == 0) goto L74
            r4.close()
            goto L74
        L50:
            r3 = move-exception
            goto L75
        L52:
            r5 = r2
            goto L58
        L54:
            r5 = r2
            goto L64
        L56:
            r5 = r2
            goto L6c
        L58:
            java.lang.String r3 = "database error ! Exception happen"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r3)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L62
        L5f:
            r2.close()
        L62:
            r2 = r5
            goto L74
        L64:
            java.lang.String r3 = "database error ! IllegalStateException happen"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r3)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L62
            goto L5f
        L6c:
            java.lang.String r3 = "database error ! SQLiteException happen"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r3)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L62
            goto L5f
        L74:
            return r2
        L75:
            if (r2 == 0) goto L7a
            r2.close()
        L7a:
            throw r3
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.common.p068db.Operator.m12588b(java.lang.String, java.lang.String[]):java.util.ArrayList");
    }
}
