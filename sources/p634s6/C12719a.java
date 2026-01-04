package p634s6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.p069cg.persistence.p070db.CloudDBHelper;
import p015ak.C0214f0;
import p031b7.C1120a;

/* renamed from: s6.a */
/* loaded from: classes2.dex */
public final class C12719a {

    /* renamed from: a */
    public static volatile CloudDBHelper f58286a;

    /* renamed from: b */
    public static volatile SQLiteDatabase f58287b;

    /* renamed from: c */
    public static Context f58288c;

    /* JADX WARN: Removed duplicated region for block: B:53:0x005a A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {, blocks: (B:36:0x0003, B:38:0x0007, B:40:0x000b, B:48:0x0033, B:50:0x0037, B:45:0x0016, B:53:0x005a, B:52:0x0040), top: B:58:0x0003, inners: #2 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.database.sqlite.SQLiteDatabase m76540a() {
        /*
            java.lang.Class<s6.a> r0 = p634s6.C12719a.class
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = p634s6.C12719a.f58287b     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L5a
            com.huawei.android.cg.persistence.db.CloudDBHelper r1 = p634s6.C12719a.f58286a     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            if (r1 != 0) goto L33
            android.content.Context r1 = p015ak.C0213f.m1377a()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
            m76541b(r1)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
            goto L33
        L13:
            r1 = move-exception
            goto L5e
        L15:
            r1 = move-exception
            java.lang.String r2 = "CloudDBManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            java.lang.String r4 = "getDB() init error:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            r3.append(r1)     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            p031b7.C1120a.m6676e(r2, r1)     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            goto L33
        L31:
            r1 = move-exception
            goto L40
        L33:
            com.huawei.android.cg.persistence.db.CloudDBHelper r1 = p634s6.C12719a.f58286a     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            if (r1 == 0) goto L5a
            com.huawei.android.cg.persistence.db.CloudDBHelper r1 = p634s6.C12719a.f58286a     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            p634s6.C12719a.f58287b = r1     // Catch: java.lang.Throwable -> L13 android.database.sqlite.SQLiteException -> L31
            goto L5a
        L40:
            java.lang.String r2 = "CloudDBManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r3.<init>()     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "getDB() error:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L13
            r3.append(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L13
            p031b7.C1120a.m6676e(r2, r1)     // Catch: java.lang.Throwable -> L13
        L5a:
            android.database.sqlite.SQLiteDatabase r1 = p634s6.C12719a.f58287b     // Catch: java.lang.Throwable -> L13
            monitor-exit(r0)
            return r1
        L5e:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p634s6.C12719a.m76540a():android.database.sqlite.SQLiteDatabase");
    }

    /* renamed from: b */
    public static synchronized void m76541b(Context context) {
        C1120a.m6677i("CloudDBManager", "initDataBase start!");
        f58288c = C0214f0.m1381a(context, "CloudAlbumV2.db");
        f58286a = new CloudDBHelper(f58288c);
    }
}
