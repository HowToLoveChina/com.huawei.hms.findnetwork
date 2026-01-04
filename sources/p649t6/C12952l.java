package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.cloud.base.util.C4644l;
import java.util.ArrayList;
import p547p7.C12118f;
import p569q7.C12290a;

/* renamed from: t6.l */
/* loaded from: classes2.dex */
public class C12952l extends AbstractC12949i<C12118f> {
    public C12952l() {
        super(C12290a.m73844b());
    }

    /* renamed from: i */
    public void m77870i(String str) throws SQLException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m77847a("DELETE FROM t_thumb_fix WHERE mediaId = ? ", new String[]{str});
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C12118f mo77732c(Cursor cursor) {
        return new C12118f().m72643n(cursor.getString(0)).m72646q(Long.valueOf(cursor.getLong(1))).m72640k(Integer.valueOf(cursor.getInt(2))).m72642m(cursor.getString(3)).m72641l(cursor.getString(4));
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C12118f mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: l */
    public void m77873l(C12118f c12118f) throws SQLException {
        if (c12118f == null || TextUtils.isEmpty(c12118f.m72634e()) || c12118f.m72637h() == null || c12118f.m72632c() == null) {
            return;
        }
        m77847a("INSERT OR IGNORE INTO t_thumb_fix(mediaId,size,fileType) VALUES(?,?,?)", new String[]{c12118f.m72634e(), String.valueOf(c12118f.m72637h()), String.valueOf(c12118f.m72632c())});
    }

    /* renamed from: m */
    public ArrayList<C12118f> m77874m() throws Throwable {
        ArrayList<C12118f> arrayListM77851g = m77851g("SELECT * FROM t_thumb_fix", null);
        return arrayListM77851g == null ? new ArrayList<>() : arrayListM77851g;
    }

    /* renamed from: n */
    public void m77875n(String str, String str2) throws SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        m77847a("UPDATE t_thumb_fix SET lastFailTime = ?,lastFailMsg = ? WHERE mediaId = ? ", new String[]{new C4644l(System.currentTimeMillis()).toString(), str2, str});
    }
}
