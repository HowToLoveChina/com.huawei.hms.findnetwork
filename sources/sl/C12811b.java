package sl;

import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: sl.b */
/* loaded from: classes6.dex */
public class C12811b extends AbstractC11478a<C12810a> {
    public C12811b() {
        this(true);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12810a c12810a) {
        return new String[]{c12810a.m76850a(), c12810a.m76851b(), c12810a.m76865p(), c12810a.m76864o(), String.valueOf(c12810a.m76862m()), String.valueOf(c12810a.m76861l()), String.valueOf(c12810a.m76852c()), c12810a.m76859j(), c12810a.m76860k(), String.valueOf(c12810a.m76858i()), String.valueOf(c12810a.m76863n()), c12810a.m76853d(), c12810a.m76854e(), c12810a.m76855f(), c12810a.m76856g(), c12810a.m76857h()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12810a getObject(Cursor cursor) {
        C12810a c12810a = new C12810a();
        c12810a.m76866q(cursor.getString(0)).m76867r(cursor.getString(1)).m76849F(cursor.getString(2)).m76848E(cursor.getString(3)).m76846C(cursor.getInt(4)).m76845B(cursor.getLong(5)).m76868s(cursor.getInt(6)).m76875z(cursor.getString(7)).m76844A(cursor.getString(8)).m76874y(cursor.getInt(9)).m76847D(cursor.getInt(10)).m76869t(cursor.getString(11)).m76870u(cursor.getString(12)).m76871v(cursor.getString(13)).m76872w(cursor.getString(14)).m76873x(cursor.getString(15));
        return c12810a;
    }

    public void batchReplace(List<C12810a> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into t_restore_attachment_status(appId, assetId, versionId, usage, status, size, count, hash1, hash2, flag, uid, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: c */
    public void m76878c() {
        try {
            execSQL("create table if not exists t_restore_attachment_status(appId text not null,assetId text not null,versionId text not null,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,uid integer not null default 0,data1 text, data2 text, data3 text, data4 text, data5 text,UNIQUE(appId, assetId));");
            if (!isTableExist("app_attachment_status")) {
                C11839m.m70688i("AttachmentStatusOperator", "onUpgradeAppTwin old table not exist");
            } else {
                execSQL("replace into t_restore_attachment_status select appId, assetId, versionId, usage, status, size, count, hash1, hash2, flag, 0 as uid, data1, data2, data3, data4, data5 from app_attachment_status");
                drop("app_attachment_status");
            }
        } catch (C9721b e10) {
            C11839m.m70687e("AttachmentStatusOperator", "onUpgradeAppTwin error: " + e10.getMessage());
        }
    }

    public void clear() {
        try {
            delete("t_restore_attachment_status", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("AttachmentStatusOperator", "clear attachment status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public C12810a m76879d(String str, String str2) {
        List arrayList = new ArrayList();
        try {
            arrayList = query("select appId, assetId, versionId, usage, status, size, count, hash1, hash2, flag, uid, data1, data2, data3, data4, data5 from t_restore_attachment_status where appId = ? and usage = ?;", new String[]{str, str2});
        } catch (C9721b e10) {
            C11839m.m70689w("AttachmentStatusOperator", "query attachment status by usage error: " + e10.toString());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (C12810a) arrayList.get(0);
    }

    /* renamed from: e */
    public C12810a m76880e(String str, String str2, int i10) {
        List arrayList = new ArrayList();
        try {
            arrayList = query("select appId, assetId, versionId, usage, status, size, count, hash1, hash2, flag, uid, data1, data2, data3, data4, data5 from t_restore_attachment_status where appId = ? and usage = ? and uid = ?;", new String[]{str, str2, String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("AttachmentStatusOperator", "query attachment status by usage error: " + e10.toString());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (C12810a) arrayList.get(0);
    }

    /* renamed from: f */
    public void m76881f(String str, String str2, int i10, int i11) {
        try {
            execSQL("update t_restore_attachment_status set status = ? where appId = ? and usage = ? and uid = ?;", new String[]{String.valueOf(i10), str, str2, String.valueOf(i11)});
        } catch (C9721b e10) {
            C11839m.m70689w("AttachmentStatusOperator", "update attachment status error." + e10.getMessage());
        }
    }

    public C12811b(boolean z10) {
        super(C13216j.m79427l(C13216j.c.STATUS, null));
        if (!z10 || isTableExist("t_restore_attachment_status")) {
            return;
        }
        try {
            C11839m.m70688i("AttachmentStatusOperator", "table not exist, create table");
            execSQL("create table if not exists t_restore_attachment_status(appId text not null,assetId text not null,versionId text not null,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,uid integer not null default 0,data1 text, data2 text, data3 text, data4 text, data5 text,UNIQUE(appId, assetId));");
        } catch (C9721b e10) {
            C11839m.m70687e("AttachmentStatusOperator", "create table error: " + e10.getMessage());
        }
    }
}
