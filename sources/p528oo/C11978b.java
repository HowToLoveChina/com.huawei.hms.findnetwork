package p528oo;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import fk.C9721b;
import p015ak.C0213f;
import p429kk.C11060c;
import p514o9.C11839m;
import p555po.C12201a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p746wn.C13622a;
import ro.C12612a;

/* renamed from: oo.b */
/* loaded from: classes6.dex */
public class C11978b {

    /* renamed from: a */
    public Gson f55751a;

    /* renamed from: oo.b$b */
    public static class b {

        /* renamed from: a */
        public static C11978b f55752a = new C11978b();
    }

    /* renamed from: a */
    public static C11978b m72090a() {
        return b.f55752a;
    }

    /* renamed from: b */
    public final String m72091b(String str, String str2, String str3) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str, str2, str3);
        } catch (C13194k e10) {
            C11839m.m70687e("FileProxyService", "onAccessTokenWithId error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str3);
            }
            throw new C9721b(1201, e10.toString(), str3);
        } catch (C13199p e11) {
            C11839m.m70687e("FileProxyService", "onAccessTokenWithId error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str3);
        }
    }

    /* renamed from: c */
    public String m72092c(C11060c c11060c, String str, String str2, String str3, String str4, String str5) throws C9721b {
        try {
            return (String) C12612a.m76110j(str2, new C11977a(str, str3, c11060c.m66661q(), str4, str5), 50, 3, null, true);
        } catch (C9721b e10) {
            C11839m.m70687e("FileProxyService", "request CException error: " + e10.getMessage());
            throw e10;
        } catch (Exception e11) {
            C11839m.m70687e("FileProxyService", "request error: " + e11.getMessage());
            throw new C9721b(4001, e11.getMessage(), "FileProxyService");
        }
    }

    /* renamed from: d */
    public boolean m72093d(C11060c c11060c, C12201a c12201a, String str) {
        if (c11060c == null) {
            C11839m.m70687e("FileProxyService", "requestCheckDifferenceFile error, stat is null");
            return false;
        }
        if (c12201a != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return m72094e(c11060c, c12201a, str, 0);
                }
            } catch (Exception e10) {
                c11060c.m66665u("1");
                c11060c.m66635A(e10.getMessage());
                C11839m.m70687e("FileProxyService", "requestCheckDifferenceFile error, message = " + e10.getMessage());
                return false;
            } finally {
                C13622a.m81968n(C0213f.m1377a(), c11060c);
            }
        }
        c11060c.m66665u("1");
        c11060c.m66635A("requestCheckDifferenceFile error, params invalid");
        return false;
    }

    /* renamed from: e */
    public final boolean m72094e(C11060c c11060c, C12201a c12201a, String str, int i10) {
        String str2 = "";
        if (c11060c == null || c12201a == null || TextUtils.isEmpty(str)) {
            C11839m.m70687e("FileProxyService", "requestCheckDifferenceFile error, params invalid");
            return false;
        }
        if (i10 > 1) {
            C11839m.m70687e("FileProxyService", "requestCheckDifferenceFile error, retryCount = " + i10);
            return false;
        }
        try {
            String strM72091b = m72091b("", "CloudBackup2", "");
            try {
                String json = this.f55751a.toJson(c12201a);
                C11839m.m70686d("FileProxyService", "requestCheckDifferenceFile , requestBody = " + json);
                m72092c(c11060c, json, str, "/proxy/v1/differencefile/check", "POST", strM72091b);
                C11839m.m70688i("FileProxyService", "requestCheckDifferenceFile success");
                c11060c.m66665u("010_200");
                c11060c.m66635A("ok");
                return true;
            } catch (C9721b e10) {
                e = e10;
                str2 = strM72091b;
                c11060c.m66665u(String.valueOf(e.m60659c()));
                c11060c.m66635A(e.getMessage());
                if (401 == e.m60663g()) {
                    C13195l.m79272J().m79325o0(str2);
                    return m72094e(c11060c, c12201a, str, i10 + 1);
                }
                if (504 == e.m60663g()) {
                    return m72094e(c11060c, c12201a, str, i10 + 1);
                }
                C11839m.m70687e("FileProxyService", "requestCheckDifferenceFile error, code = " + e.m60659c() + " status = " + e.m60663g() + " message = " + e.getMessage());
                return false;
            }
        } catch (C9721b e11) {
            e = e11;
        }
    }

    public C11978b() {
        this.f55751a = new Gson();
    }
}
