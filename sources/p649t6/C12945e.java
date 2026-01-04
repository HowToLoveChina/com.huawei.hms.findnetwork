package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;
import p547p7.C12114b;
import p569q7.C12290a;

/* renamed from: t6.e */
/* loaded from: classes2.dex */
public class C12945e extends AbstractC12949i<C12114b> {
    public C12945e() {
        super(C12290a.m73844b());
    }

    /* renamed from: i */
    public void m77770i(ArrayList<C12114b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<C12114b> it = arrayList.iterator();
        while (it.hasNext()) {
            C12114b next = it.next();
            if (next != null) {
                arrayList2.add(m77772k(next));
            }
        }
        m77848b("INSERT OR IGNORE INTO t_hide_change(albumId) VALUES(?)", arrayList2);
    }

    /* renamed from: j */
    public void m77771j() throws SQLException {
        if (C12290a.m73844b() == null) {
            C1120a.m6678w("HideChangeOperator", "deleteAll, db is null.");
        } else {
            m77847a("DELETE FROM t_hide_change", null);
        }
    }

    /* renamed from: k */
    public final String[] m77772k(C12114b c12114b) {
        return new String[]{StringUtil.emptyIfBlank(c12114b.m72558a())};
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C12114b mo77732c(Cursor cursor) {
        C12114b c12114b = new C12114b();
        c12114b.m72559b(cursor.getString(0));
        return c12114b;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C12114b mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: n */
    public ArrayList<String> m77775n() throws Throwable {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT albumId FROM t_hide_change", null);
        if (arrayListM77850f == null) {
            return arrayList;
        }
        Iterator<String[]> it = arrayListM77850f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next()[0]);
        }
        return arrayList;
    }
}
