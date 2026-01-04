package tl;

import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: tl.l */
/* loaded from: classes6.dex */
public class C13033l extends AbstractC11478a<C13032k> {
    public C13033l() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
    }

    private String formatSql(String str) {
        return String.format(Locale.ENGLISH, str, getTableName());
    }

    /* renamed from: a */
    public void m78543a(int i10) {
        try {
            execSQL(formatSql("delete from %s where id = ?;"), new String[]{String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupStateOperator", "replace backup_tags error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C13032k c13032k) {
        return new String[]{String.valueOf(c13032k.m78527k()), String.valueOf(c13032k.m78532p()), String.valueOf(c13032k.m78529m()), String.valueOf(c13032k.m78531o()), String.valueOf(c13032k.m78533q()), String.valueOf(c13032k.m78526j()), String.valueOf(c13032k.m78530n()), String.valueOf(c13032k.m78525i()), c13032k.m78517a(), String.valueOf(c13032k.m78534r()), String.valueOf(c13032k.m78518b()), String.valueOf(c13032k.m78519c()), String.valueOf(c13032k.m78535s()), String.valueOf(c13032k.m78520d()), String.valueOf(c13032k.m78521e()), String.valueOf(c13032k.m78522f()), String.valueOf(c13032k.m78523g()), c13032k.m78524h()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C13032k getObject(Cursor cursor) {
        C13032k c13032k = new C13032k();
        c13032k.m78509F(cursor.getInt(0));
        c13032k.m78514K(cursor.getInt(1));
        c13032k.m78511H(cursor.getFloat(2));
        c13032k.m78513J(cursor.getLong(3));
        c13032k.m78515L(cursor.getLong(4));
        c13032k.m78507D(cursor.getLong(5));
        c13032k.m78512I(cursor.getInt(6));
        c13032k.m78506C(cursor.getString(7));
        c13032k.m78537u(cursor.getString(8));
        c13032k.m78516M(cursor.getString(9));
        c13032k.m78538v(cursor.getString(10));
        c13032k.m78539w(cursor.getString(11));
        c13032k.m78510G(cursor.getInt(12));
        c13032k.m78540x(cursor.getString(13));
        c13032k.m78541y(cursor.getString(14));
        c13032k.m78542z(cursor.getString(15));
        c13032k.m78504A(cursor.getString(16));
        c13032k.m78505B(cursor.getString(17));
        return c13032k;
    }

    public void clear() {
        try {
            execSQL(formatSql("delete from %s;"));
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupStateOperator", "clear backup_tags error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public C13032k m78546d(int i10) {
        try {
            List<C13032k> listQuery = query(formatSql("select id, state, progress, startTime, updateTime, endTime, returnCode, deviceId, backupDeviceId, version, backupId, currentModule, isNextShow, data1, data2, data3, data4, data5 from %s where id = ?"), new String[]{String.valueOf(i10)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupStateOperator", "query backup_tags error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: e */
    public void m78547e(C13032k c13032k) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c13032k);
        try {
            batch(formatSql("replace into %s(id, state, progress, startTime, updateTime, endTime, returnCode, deviceId, backupDeviceId, version, backupId, currentModule, isNextShow, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"), arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupStateOperator", "replace error." + e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m78548f(int i10, int i11) {
        try {
            execSQL(formatSql("update %s set isNextShow = ? where id = ?"), new String[]{String.valueOf(i11), String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupStateOperator", "update restore status error." + e10.getMessage());
        }
    }

    public String getTableName() {
        return "t_cloudbackup_state";
    }
}
