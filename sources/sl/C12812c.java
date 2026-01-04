package sl;

import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: sl.c */
/* loaded from: classes6.dex */
public class C12812c extends AbstractC11478a<C12810a> {
    public C12812c() {
        this(true);
    }

    /* renamed from: a */
    public void m76882a(List<String[]> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("CloudBackupAttachmentOperator", "batch delete attachment status." + Arrays.toString(list.toArray()));
        execute("delete from t_app_backup_attachment_status where appId = ? and uid = ?;", list);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12810a c12810a) {
        return new String[]{c12810a.m76850a(), String.valueOf(c12810a.m76863n()), c12810a.m76851b(), c12810a.m76865p(), c12810a.m76864o(), String.valueOf(c12810a.m76862m()), String.valueOf(c12810a.m76861l()), String.valueOf(c12810a.m76852c()), c12810a.m76859j(), c12810a.m76860k(), String.valueOf(c12810a.m76858i()), c12810a.m76853d(), c12810a.m76854e(), c12810a.m76855f(), c12810a.m76856g(), c12810a.m76857h()};
    }

    public void batchReplace(List<C12810a> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("CloudBackupAttachmentOperator", "batch replace attachment status." + Arrays.toString(list.toArray()));
        batch("replace into t_app_backup_attachment_status(appId, uid, assetId, versionId, usage, status, size, count, hash1, hash2, flag, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C12810a getObject(Cursor cursor) {
        C12810a c12810a = new C12810a();
        c12810a.m76866q(cursor.getString(0)).m76847D(cursor.getInt(1)).m76867r(cursor.getString(2)).m76849F(cursor.getString(3)).m76848E(cursor.getString(4)).m76846C(cursor.getInt(5)).m76845B(cursor.getLong(6)).m76868s(cursor.getInt(7)).m76875z(cursor.getString(8)).m76844A(cursor.getString(9)).m76874y(cursor.getInt(10)).m76869t(cursor.getString(11)).m76870u(cursor.getString(12)).m76871v(cursor.getString(13)).m76872w(cursor.getString(14)).m76873x(cursor.getString(15));
        return c12810a;
    }

    public void clear() {
        try {
            delete("t_app_backup_attachment_status", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupAttachmentOperator", "clear attachment status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m76885d() {
        try {
            execSQL("create table if not exists t_app_backup_attachment_status(appId text not null,uid integer not null default 0,assetId text,versionId text,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid, usage));");
            if (!isTableExist("app_backup_attachment_status")) {
                C11839m.m70688i("CloudBackupAttachmentOperator", "onUpgradeAppTwin old table not exist");
            } else {
                execSQL("replace into t_app_backup_attachment_status select appId, 0 as uid, assetId, versionId, usage, status, size, count, hash1, hash2, flag, data1, data2, data3, data4, data5 from app_backup_attachment_status");
                drop("app_backup_attachment_status");
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupAttachmentOperator", "onUpgradeAppTwin error: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public C12810a m76886e(String str, String str2, int i10) {
        try {
            List<C12810a> listQuery = query("select appId, uid, assetId, versionId, usage, status, size, count, hash1, hash2, flag, data1, data2, data3, data4, data5 from t_app_backup_attachment_status where appId = ? and usage = ? and uid = ?;", new String[]{str, str2, String.valueOf(i10)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupAttachmentOperator", "query attachment status by usage error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: f */
    public List<C12810a> m76887f(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select appId, uid, assetId, versionId, usage, status, size, count, hash1, hash2, flag, data1, data2, data3, data4, data5 from t_app_backup_attachment_status where appId = ?;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupAttachmentOperator", "query attachment status by appId error: " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: g */
    public void m76888g(C12810a c12810a) throws C9721b {
        String[] columns = getColumns(c12810a);
        C11839m.m70686d("CloudBackupAttachmentOperator", "replace attachment status." + Arrays.toString(columns));
        execSQL("replace into t_app_backup_attachment_status(appId, uid, assetId, versionId, usage, status, size, count, hash1, hash2, flag, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", columns);
    }

    public C12812c(boolean z10) {
        super(C13216j.m79427l(C13216j.c.STATUS, null));
        if (!z10 || isTableExist("t_app_backup_attachment_status")) {
            return;
        }
        try {
            C11839m.m70688i("CloudBackupAttachmentOperator", "table not exist, create table");
            execSQL("create table if not exists t_app_backup_attachment_status(appId text not null,uid integer not null default 0,assetId text,versionId text,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid, usage));");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupAttachmentOperator", "create table error: " + e10.getMessage());
        }
    }
}
