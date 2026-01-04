package p423ka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: ka.b */
/* loaded from: classes3.dex */
public class C11022b {

    /* renamed from: a */
    public static volatile SQLiteDatabase f52101a;

    /* renamed from: a */
    public static Context m66459a() {
        return C0213f.m1379c();
    }

    /* renamed from: b */
    public static synchronized SQLiteDatabase m66460b() {
        if (f52101a == null) {
            try {
                f52101a = C11021a.m66458b(m66459a()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C11839m.m70687e("AssetDBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f52101a;
    }
}
