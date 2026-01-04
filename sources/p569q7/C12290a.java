package p569q7;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.album.client.lost.p074db.RefundDatabaseHelper;
import p015ak.C0213f;
import p031b7.C1120a;

/* renamed from: q7.a */
/* loaded from: classes2.dex */
public class C12290a {

    /* renamed from: a */
    public static volatile SQLiteDatabase f56936a;

    /* renamed from: a */
    public static void m73843a() {
        C1120a.m6677i("RefundDBManager", "clear asset db and files");
        RefundDatabaseHelper.m15024d(C0213f.m1378b()).m15025b(m73844b());
    }

    /* renamed from: b */
    public static synchronized SQLiteDatabase m73844b() {
        if (f56936a == null) {
            try {
                f56936a = RefundDatabaseHelper.m15024d(C0213f.m1378b()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C1120a.m6676e("RefundDBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f56936a;
    }
}
