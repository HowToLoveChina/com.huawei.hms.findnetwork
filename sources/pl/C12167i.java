package pl;

import android.database.Cursor;
import fk.C9721b;
import java.util.Collections;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: pl.i */
/* loaded from: classes6.dex */
public class C12167i extends AbstractC11478a<C12166h> {
    public C12167i(String str, String str2, int i10, int i11) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
    }

    /* renamed from: b */
    private void m73158b() throws C9721b {
        execSQL("CREATE TABLE IF NOT EXISTS t_recovery_meta_info (id INTEGER PRIMARY KEY AUTOINCREMENT,file_id TEXT,app_id TEXT,cipher TEXT,fek_mac TEXT,hash1 TEXT,hash2 TEXT,assert_id TEXT,version_id TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(file_id));");
    }

    /* renamed from: a */
    public void m73159a() {
        try {
            m73158b();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupRecoveryMetaOperator", "create table error: " + e10.getMessage());
        }
    }

    public void batchReplace(List<C12166h> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into t_recovery_meta_info(file_id,app_id,cipher,fek_mac,hash1,hash2,assert_id,version_id,data1,data2,data3,data4,data5,data6) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12166h c12166h) {
        return new String[]{c12166h.m73144m(), c12166h.m73134b(), c12166h.m73136d(), c12166h.m73143l(), c12166h.m73145n(), c12166h.m73146o(), c12166h.m73135c(), c12166h.m73147p(), c12166h.m73137e(), c12166h.m73138f(), c12166h.m73139g(), c12166h.m73140h(), c12166h.m73141j(), c12166h.m73142k()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C12166h getObject(Cursor cursor) {
        C12166h c12166h = new C12166h();
        c12166h.m73130A(cursor.getString(cursor.getColumnIndex("file_id")));
        c12166h.m73148q(cursor.getString(cursor.getColumnIndex("app_id")));
        c12166h.m73150s(cursor.getString(cursor.getColumnIndex("cipher")));
        c12166h.m73157z(cursor.getString(cursor.getColumnIndex("fek_mac")));
        c12166h.m73131B(cursor.getString(cursor.getColumnIndex("hash1")));
        c12166h.m73132C(cursor.getString(cursor.getColumnIndex("hash2")));
        c12166h.m73149r(cursor.getString(cursor.getColumnIndex("assert_id")));
        c12166h.m73133D(cursor.getString(cursor.getColumnIndex("version_id")));
        c12166h.m73151t(cursor.getString(cursor.getColumnIndex("data1")));
        c12166h.m73152u(cursor.getString(cursor.getColumnIndex("data2")));
        c12166h.m73153v(cursor.getString(cursor.getColumnIndex("data3")));
        c12166h.m73154w(cursor.getString(cursor.getColumnIndex("data4")));
        c12166h.m73155x(cursor.getString(cursor.getColumnIndex("data5")));
        c12166h.m73156y(cursor.getString(cursor.getColumnIndex("data6")));
        return c12166h;
    }

    /* renamed from: e */
    public boolean m73162e() {
        return isTableExist("t_recovery_meta_info");
    }

    /* renamed from: f */
    public void m73163f(C12166h c12166h) throws C9721b {
        batchReplace(Collections.singletonList(c12166h));
    }
}
