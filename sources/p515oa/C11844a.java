package p515oa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.drive.clouddisk.p084db.SyncDiskDBHelper;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: oa.a */
/* loaded from: classes3.dex */
public final class C11844a {

    /* renamed from: a */
    public static volatile SyncDiskDBHelper f54845a;

    /* renamed from: b */
    public static volatile SQLiteDatabase f54846b;

    /* renamed from: c */
    public static Context f54847c;

    /* renamed from: a */
    public static synchronized SQLiteDatabase m70902a() {
        try {
            if (f54846b == null) {
                try {
                    if (f54845a == null) {
                        m70903b(f54847c);
                    }
                    f54846b = f54845a.getWritableDatabase();
                } catch (SQLiteException e10) {
                    C11839m.m70687e("SyncDiskDBManager", "getDB() error: " + e10.toString());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54846b;
    }

    /* renamed from: b */
    public static synchronized void m70903b(Context context) {
        C11839m.m70686d("SyncDiskDBManager", "initDataBase start!");
        f54847c = C0214f0.m1381a(context, "syncdisk.db");
        if (f54845a == null) {
            f54845a = new SyncDiskDBHelper(f54847c);
        }
    }
}
