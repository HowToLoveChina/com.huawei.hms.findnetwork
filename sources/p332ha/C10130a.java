package p332ha;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p031b7.C1120a;

/* renamed from: ha.a */
/* loaded from: classes3.dex */
public class C10130a {

    /* renamed from: a */
    public static volatile SQLiteDatabase f49378a;

    /* renamed from: a */
    public static void m63052a() {
        C1120a.m6677i("AssetDBManager", "clear asset db and files");
        Context contextM1378b = C0213f.m1378b();
        C10132c.m63105c(contextM1378b).m63106b(m63054c());
        m63053b(C10278a.m63441g(contextM1378b.getExternalFilesDir(""), ".core_asset"));
        m63053b(C10278a.m63441g(contextM1378b.getFilesDir(), ".core_asset"));
    }

    /* renamed from: b */
    public static boolean m63053b(File file) {
        File[] fileArrM63440f;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                m63053b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    public static synchronized SQLiteDatabase m63054c() {
        if (f49378a == null) {
            try {
                f49378a = C10132c.m63105c(C0213f.m1378b()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C1120a.m6676e("AssetDBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f49378a;
    }
}
