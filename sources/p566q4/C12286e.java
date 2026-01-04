package p566q4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.backup.common.p068db.TemperatureDBHelper;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: q4.e */
/* loaded from: classes.dex */
public final class C12286e {

    /* renamed from: a */
    public static volatile TemperatureDBHelper f56922a;

    /* renamed from: b */
    public static volatile SQLiteDatabase f56923b;

    /* renamed from: c */
    public static Context f56924c;

    /* renamed from: d */
    public static final Object f56925d = new Object();

    /* renamed from: a */
    public static SQLiteDatabase m73818a(Context context) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f56925d) {
            try {
                if (f56923b == null) {
                    try {
                        if (f56922a == null) {
                            m73819b(context);
                        }
                        if (f56922a != null) {
                            f56923b = f56922a.getWritableDatabase();
                        }
                    } catch (SQLiteException unused) {
                        C2111d.m12648d("TemperatureDBManager", "getDB() error");
                    }
                }
                sQLiteDatabase = f56923b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sQLiteDatabase;
    }

    /* renamed from: b */
    public static void m73819b(Context context) {
        synchronized (f56925d) {
            f56924c = context;
            f56922a = new TemperatureDBHelper(f56924c);
        }
    }
}
