package p512o7;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import p015ak.C0213f;
import p031b7.C1120a;

/* renamed from: o7.a */
/* loaded from: classes2.dex */
public class C11824a {

    /* renamed from: a */
    public static volatile SQLiteDatabase f54731a;

    /* renamed from: a */
    public static void m70444a() {
        C1120a.m6677i("AlbumClientDBManager", "clear album client db");
        C11825b.m70446c(C0213f.m1378b()).m70447b(m70445b());
    }

    /* renamed from: b */
    public static synchronized SQLiteDatabase m70445b() {
        if (f54731a == null) {
            try {
                f54731a = C11825b.m70446c(C0213f.m1378b()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C1120a.m6676e("AlbumClientDBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f54731a;
    }
}
