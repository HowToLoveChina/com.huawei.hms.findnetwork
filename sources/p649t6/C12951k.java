package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import p547p7.C12117e;
import p569q7.C12290a;

/* renamed from: t6.k */
/* loaded from: classes2.dex */
public class C12951k extends AbstractC12949i<C12117e> {
    public C12951k() {
        super(C12290a.m73844b());
    }

    /* renamed from: i */
    public void m77863i(ArrayList<C12117e> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<C12117e> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77866l(it.next()));
        }
        m77848b("INSERT OR IGNORE INTO t_refund(mediaId,assetID,sha256,hashId,originalPath,smallThumbnailPath,largeThumbnailPath,thumbnailRefund,useOriginalPath,fileType) VALUES(?,?,?,?,?,?,?,?,?,?)", arrayList2);
    }

    /* renamed from: j */
    public void m77864j() throws SQLException {
        m77847a("DELETE FROM t_refund", null);
    }

    /* renamed from: k */
    public void m77865k(long j10) throws SQLException {
        m77847a("DELETE FROM t_refund WHERE id = ? ", new String[]{String.valueOf(j10)});
    }

    /* renamed from: l */
    public final String[] m77866l(C12117e c12117e) {
        return new String[]{c12117e.m72610f(), StringUtil.emptyIfBlank(c12117e.m72605a()), StringUtil.emptyIfBlank(c12117e.m72612h()), StringUtil.emptyIfBlank(c12117e.m72607c()), StringUtil.emptyIfBlank(c12117e.m72611g()), StringUtil.emptyIfBlank(c12117e.m72613i()), StringUtil.emptyIfBlank(c12117e.m72609e()), StringUtil.emptyIfBlank(String.valueOf(c12117e.m72614j() ? 1 : 0)), StringUtil.emptyIfBlank(String.valueOf(c12117e.m72615k() ? 1 : 0)), StringUtil.emptyIfBlank(String.valueOf(c12117e.m72606b()))};
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C12117e mo77732c(Cursor cursor) {
        return new C12117e().m72621q(cursor.getLong(0)).m72626v(cursor.getString(1)).m72617m(cursor.getString(2)).m72628x(cursor.getString(3)).m72620p(cursor.getString(4)).m72627w(cursor.getString(5)).m72629y(cursor.getString(6)).m72624t(cursor.getString(7)).m72622r(cursor.getInt(8) == 1).m72623s(cursor.getInt(9) == 1).m72619o(Integer.valueOf(cursor.getInt(10)));
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C12117e mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: o */
    public ArrayList<C12117e> m77869o() throws Throwable {
        ArrayList<C12117e> arrayListM77851g = m77851g("SELECT * FROM t_refund", null);
        return arrayListM77851g == null ? new ArrayList<>() : arrayListM77851g;
    }
}
