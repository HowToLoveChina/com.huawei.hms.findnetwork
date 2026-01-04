package p618rm;

import android.database.Cursor;
import android.net.Uri;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import tl.C13029h;
import tl.C13030i;

/* renamed from: rm.s1 */
/* loaded from: classes6.dex */
public class C12591s1 {

    /* renamed from: e */
    public static C12591s1 f57974e;

    /* renamed from: a */
    public boolean f57975a = false;

    /* renamed from: b */
    public boolean f57976b = false;

    /* renamed from: c */
    public boolean f57977c = false;

    /* renamed from: d */
    public boolean f57978d;

    /* renamed from: a */
    public static synchronized C12591s1 m75931a() {
        try {
            if (f57974e == null) {
                f57974e = new C12591s1();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f57974e;
    }

    /* renamed from: b */
    public int m75932b() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(4);
            if (c13029hM78495f == null) {
                return -1;
            }
            C11839m.m70688i("RefurbishUtil", "refurbish is running: " + c13029hM78495f.m78441G());
            return c13029hM78495f.m78441G();
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return -1;
        }
    }

    /* renamed from: c */
    public final String m75933c() {
        Uri uri = Uri.parse("content://smart_provider/smartabilityset");
        String string = "";
        if (!C0209d.m1227Y1(C0213f.m1377a(), uri)) {
            C11839m.m70687e("RefurbishUtil", "getSmartAbility is not Target App or System App");
            return "";
        }
        try {
            Cursor cursorQuery = C0213f.m1377a().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("SystemRenovationProgress"));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70687e("RefurbishUtil", "get smart ability error: " + e10.getMessage());
        }
        C11839m.m70688i("RefurbishUtil", "get smart ability: " + string);
        return string;
    }

    /* renamed from: d */
    public boolean m75934d() {
        return this.f57977c;
    }

    /* renamed from: e */
    public boolean m75935e() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(2);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                return false;
            }
            C11839m.m70688i("RefurbishUtil", "auto backup is running.");
            return true;
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: f */
    public boolean m75936f() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(1);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4 || "001_3113".equals(c13029hM78495f.m78474q())) {
                return false;
            }
            C11839m.m70688i("RefurbishUtil", "manual backup is running.");
            return true;
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: g */
    public boolean m75937g() {
        return this.f57975a;
    }

    /* renamed from: h */
    public boolean m75938h() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(3);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                return false;
            }
            return c13029hM78495f.m78478s().contains(CloudRestoreTask.MYHUAWEI_TAG);
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: i */
    public boolean m75939i() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(3);
            if (c13029hM78495f != null) {
                return c13029hM78495f.m78478s().contains(CloudRestoreTask.REFURBISHMENT_TAG);
            }
            return false;
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: j */
    public boolean m75940j() {
        return this.f57978d;
    }

    /* renamed from: k */
    public boolean m75941k() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(4);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                return false;
            }
            C11839m.m70688i("RefurbishUtil", "refurbish is running.");
            return true;
        } catch (C9721b e10) {
            C11839m.m70687e("RefurbishUtil", "query backup tags error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: l */
    public boolean m75942l() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f2 = null;
        try {
            c13029hM78495f = c13030i.m78495f(4);
            try {
                c13029hM78495f2 = c13030i.m78495f(3);
            } catch (Exception e10) {
                e = e10;
                C11839m.m70687e("RefurbishUtil", "isRefurbishingPause error " + e.toString());
                if (c13029hM78495f == null) {
                }
                return c13029hM78495f2 == null ? false : false;
            }
        } catch (Exception e11) {
            e = e11;
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null && c13029hM78495f.m78441G() != 4) {
            C11839m.m70688i("RefurbishUtil", "refurbish backup is running.");
            return true;
        }
        if (c13029hM78495f2 == null && c13029hM78495f2.m78441G() != 4) {
            return c13029hM78495f2.m78478s().contains(CloudRestoreTask.MYHUAWEI_TAG);
        }
    }

    /* renamed from: m */
    public boolean m75943m() {
        return this.f57976b;
    }

    /* renamed from: n */
    public boolean m75944n() {
        return "base".equals(m75933c());
    }

    /* renamed from: o */
    public void m75945o(boolean z10) {
        this.f57977c = z10;
    }

    /* renamed from: p */
    public void m75946p(boolean z10) {
        this.f57975a = z10;
    }

    /* renamed from: q */
    public void m75947q(boolean z10) {
        this.f57978d = z10;
    }

    /* renamed from: r */
    public void m75948r() {
        this.f57976b = "base".equals(m75933c());
    }
}
