package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;
import p547p7.C12113a;
import p569q7.C12290a;

/* renamed from: t6.f */
/* loaded from: classes2.dex */
public class C12946f extends AbstractC12949i<C12113a> {
    public C12946f() {
        super(C12290a.m73844b());
    }

    /* renamed from: i */
    public void m77776i(ArrayList<C12113a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<C12113a> it = arrayList.iterator();
        while (it.hasNext()) {
            C12113a next = it.next();
            if (next != null) {
                arrayList2.add(m77780m(next));
            }
        }
        m77848b("INSERT OR IGNORE INTO t_hide(mediaId,albumId,fileName,hashId,sha256) VALUES(?,?,?,?,?)", arrayList2);
    }

    /* renamed from: j */
    public void m77777j(ArrayList<C12113a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<C12113a> it = arrayList.iterator();
        while (it.hasNext()) {
            C12113a next = it.next();
            if (next != null) {
                arrayList2.add(m77781n(next));
            }
        }
        m77848b("UPDATE t_hide SET albumId = ? WHERE mediaId = ? AND albumId != ?", arrayList2);
    }

    /* renamed from: k */
    public void m77778k() throws SQLException {
        if (C12290a.m73844b() == null) {
            C1120a.m6678w("HideOperator", "deleteAll, db is null.");
        } else {
            m77847a("DELETE FROM t_hide", null);
        }
    }

    /* renamed from: l */
    public void m77779l(String str) throws SQLException {
        m77847a("DELETE FROM t_hide WHERE mediaId = ?", new String[]{str});
    }

    /* renamed from: m */
    public final String[] m77780m(C12113a c12113a) {
        return new String[]{StringUtil.emptyIfBlank(c12113a.m72551d()), StringUtil.emptyIfBlank(c12113a.m72548a()), StringUtil.emptyIfBlank(c12113a.m72549b()), StringUtil.emptyIfBlank(c12113a.m72550c()), StringUtil.emptyIfBlank(c12113a.m72552e())};
    }

    /* renamed from: n */
    public final String[] m77781n(C12113a c12113a) {
        return new String[]{StringUtil.emptyIfBlank(c12113a.m72548a()), StringUtil.emptyIfBlank(c12113a.m72551d()), StringUtil.emptyIfBlank(c12113a.m72548a())};
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C12113a mo77732c(Cursor cursor) {
        C12113a c12113a = new C12113a();
        c12113a.m72556i(cursor.getString(0));
        c12113a.m72553f(cursor.getString(1));
        c12113a.m72554g(cursor.getString(2));
        c12113a.m72555h(cursor.getString(3));
        c12113a.m72557j(cursor.getString(4));
        return c12113a;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C12113a mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: q */
    public ArrayList<String> m77784q() throws Throwable {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT DISTINCT albumId FROM t_hide", null);
        if (arrayListM77850f == null) {
            return arrayList;
        }
        Iterator<String[]> it = arrayListM77850f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next()[0]);
        }
        return arrayList;
    }

    /* renamed from: r */
    public ArrayList<C12113a> m77785r(String str, String str2, String str3, String str4) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<C12113a> arrayListM77851g = m77851g("SELECT * FROM t_hide WHERE albumId = ? AND fileName = ? AND hashId = ? AND (sha256 = '' or sha256 = ?)", new String[]{str, str2, str3, str4});
        if (arrayListM77851g == null) {
            arrayListM77851g = new ArrayList<>();
        }
        C1120a.m6675d("HideOperator", "queryByHashId, queryTime=" + Math.abs(System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayListM77851g;
    }

    /* renamed from: s */
    public ArrayList<C12113a> m77786s(String str) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<C12113a> arrayListM77851g = m77851g("SELECT * FROM t_hide WHERE mediaId = ?", new String[]{str});
        if (arrayListM77851g == null) {
            arrayListM77851g = new ArrayList<>();
        }
        C1120a.m6675d("HideOperator", "queryByMediaId, queryTime=" + Math.abs(System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayListM77851g;
    }
}
