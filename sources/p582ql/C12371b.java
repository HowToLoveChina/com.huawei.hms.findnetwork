package p582ql;

import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: ql.b */
/* loaded from: classes6.dex */
public class C12371b extends AbstractC11478a<C12370a> {
    public C12371b(String str, String str2, int i10, int i11) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12370a c12370a) {
        return new String[]{String.valueOf(c12370a.m74389a()), String.valueOf(c12370a.m74401m()), String.valueOf(c12370a.m74398j()), String.valueOf(c12370a.m74399k()), String.valueOf(c12370a.m74400l()), String.valueOf(c12370a.m74390b()), String.valueOf(c12370a.m74397i()), String.valueOf(c12370a.m74391c()), String.valueOf(c12370a.m74392d()), String.valueOf(c12370a.m74393e()), String.valueOf(c12370a.m74394f()), String.valueOf(c12370a.m74395g()), String.valueOf(c12370a.m74396h())};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12370a getObject(Cursor cursor) {
        C12370a c12370a = new C12370a();
        c12370a.m74402n(cursor.getString(0));
        c12370a.m74414z(cursor.getString(1));
        c12370a.m74411w(cursor.getInt(2));
        c12370a.m74412x(cursor.getInt(3));
        c12370a.m74413y(cursor.getInt(4));
        c12370a.m74403o(cursor.getInt(5));
        c12370a.m74410v(cursor.getString(6));
        c12370a.m74404p(cursor.getString(7));
        c12370a.m74405q(cursor.getString(8));
        c12370a.m74406r(cursor.getString(9));
        c12370a.m74407s(cursor.getString(10));
        c12370a.m74408t(cursor.getString(11));
        c12370a.m74409u(cursor.getString(12));
        return c12370a;
    }

    /* renamed from: c */
    public void m74417c(ArrayList<C12370a> arrayList) throws C9721b {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                batch("REPLACE INTO t_backup_module_info (app_id,uri,is_need_backup_uri,is_need_count_uri,prepare_count,count,error_info,data1,data2,data3,data4,data5,data6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayList);
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupModuleInfoOperator", "replace table error. " + e10.getMessage());
            }
        }
    }

    public void clear() {
        try {
            delete("t_backup_module_info", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupModuleInfoOperator", "delete table error. " + e10.getMessage());
        }
    }
}
