package p225dd;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: dd.a */
/* loaded from: classes3.dex */
public class C9065a {

    /* renamed from: a */
    public static volatile SQLiteDatabase f45780a;

    /* renamed from: a */
    public static synchronized SQLiteDatabase m57166a() {
        if (f45780a == null) {
            try {
                f45780a = C9070f.m57240b(C0213f.m1378b()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C11839m.m70687e("CloudSyncAssetDBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f45780a;
    }
}
