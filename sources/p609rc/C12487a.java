package p609rc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.sync.persistence.p087db.SyncDBHelper;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: rc.a */
/* loaded from: classes3.dex */
public final class C12487a {

    /* renamed from: a */
    public static volatile SyncDBHelper f57493a;

    /* renamed from: b */
    public static volatile SQLiteDatabase f57494b;

    /* renamed from: c */
    public static Context f57495c;

    /* renamed from: a */
    public static synchronized SQLiteDatabase m74965a() {
        try {
            if (f57494b == null) {
                try {
                    if (f57493a == null) {
                        m74966b(f57495c);
                    }
                    f57494b = f57493a.getWritableDatabase();
                } catch (SQLiteException e10) {
                    C11839m.m70687e("SyncDBManager", "getDB() error: " + e10.toString());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f57494b;
    }

    /* renamed from: b */
    public static synchronized void m74966b(Context context) {
        C11839m.m70686d("SyncDBManager", "initDataBase start!");
        f57495c = C0214f0.m1381a(context, "sync.db");
        if (f57493a == null) {
            f57493a = new SyncDBHelper(f57495c);
        }
    }
}
