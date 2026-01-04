package p701v6;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0228m0;
import p031b7.C1120a;
import p031b7.C1122c;
import p336he.C10160k;
import p514o9.C11829c;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: v6.c */
/* loaded from: classes2.dex */
public class C13356c {

    /* renamed from: a */
    public String f60208a;

    /* renamed from: b */
    public String f60209b;

    /* renamed from: e */
    public C11912b0 f60212e;

    /* renamed from: k */
    public boolean f60218k;

    /* renamed from: c */
    public int f60210c = 0;

    /* renamed from: d */
    public String f60211d = "";

    /* renamed from: f */
    public C11918e0 f60213f = null;

    /* renamed from: g */
    public C11922g0 f60214g = null;

    /* renamed from: h */
    public InterfaceC11919f f60215h = null;

    /* renamed from: i */
    public String f60216i = "";

    /* renamed from: j */
    public Boolean f60217j = Boolean.FALSE;

    /* renamed from: v6.c$a */
    public class a implements DnsKprUtil.InterfaceC4895e {
        public a() {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public void run(C11918e0.a aVar, InterfaceC11921g interfaceC11921g) {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public C11922g0 run(C11918e0.a aVar, String str) throws IOException {
            C13356c.this.f60213f = aVar.m71575b();
            return C13356c.this.f60212e.m71495z(aVar.m71575b()).execute();
        }
    }

    public C13356c(String str, long j10, long j11, String str2) {
        this.f60212e = null;
        this.f60208a = str;
        this.f60209b = str2;
        this.f60212e = C13358e.m80141d(2);
        if (j10 == 0 || j10 >= j11) {
            return;
        }
        m80136j(j10, j11 - 1);
    }

    /* renamed from: c */
    public void m80129c() {
        this.f60217j = Boolean.TRUE;
        InterfaceC11919f interfaceC11919f = this.f60215h;
        if (interfaceC11919f != null) {
            interfaceC11919f.cancel();
        }
    }

    /* renamed from: d */
    public void m80130d() {
        C11922g0 c11922g0 = this.f60214g;
        if (c11922g0 != null) {
            c11922g0.close();
        }
    }

    /* renamed from: e */
    public String m80131e() {
        return this.f60216i;
    }

    /* renamed from: f */
    public int m80132f() {
        return this.f60210c;
    }

    /* renamed from: g */
    public String m80133g() {
        return this.f60211d;
    }

    /* renamed from: h */
    public boolean m80134h(C11918e0.a aVar) {
        String strM80970t = C13452e.m80781L().m80970t();
        if (TextUtils.isEmpty(strM80970t)) {
            return false;
        }
        String str = strM80970t + ":" + C13452e.m80781L().m80954p() + ":" + C13452e.m80781L().m80931j0() + ":0";
        String str2 = "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)";
        C1120a.m6675d("FileDownloadRequestByHttp2", "isNeedAT: " + this.f60218k);
        if (this.f60218k) {
            try {
                aVar.m71578e(FeedbackWebConstants.AUTHORIZATION, "Bearer " + C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "OkHttpDownload", ""));
            } catch (C13194k e10) {
                C1120a.m6676e("FileDownloadRequestByHttp2", "HmsException  " + e10.getMessage());
            } catch (C13199p e11) {
                C1120a.m6676e("FileDownloadRequestByHttp2", "HmsSTInvalidException: " + e11.getMessage());
            }
        } else {
            aVar.m71578e(FeedbackWebConstants.AUTHORIZATION, C1122c.m6773e(str));
        }
        C11918e0.a aVarM71578e = aVar.m71578e("SiteId", "" + C13452e.m80781L().m80947n0()).m71578e(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        String str3 = C1443a.f6213a;
        aVarM71578e.m71578e("version", str3).m71578e("AuthType", C1122c.m6773e("com.huawei.hidisk")).m71578e("User-Agent", str2);
        aVar.m71578e("Cflg", "1");
        aVar.m71578e("x-hw-os", C1122c.m6749X0());
        aVar.m71578e("x-hw-terminal", C1122c.m6701H0());
        if (!TextUtils.isEmpty(this.f60209b)) {
            aVar.m71578e("x-hw-trace-id", this.f60209b);
        }
        aVar.m71578e("x-hw-unique-trace-id", C10160k.m63341b("04015"));
        if (!TextUtils.isEmpty(this.f60216i)) {
            aVar.m71578e("Range", this.f60216i);
        }
        aVar.m71578e("x-hw-device-type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
        aVar.m71578e("x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
        aVar.m71578e("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.m71578e("x-hw-os-brand", C0209d.m1276l0());
        aVar.m71578e("x-hw-3rdapp-packagename", C13843a.m83054F(C0213f.m1377a()));
        aVar.m71578e("x-hw-3rdapp-version", C1122c.m6833t0(C0213f.m1377a()));
        aVar.m71578e("x-hw-app-version", str3);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        p336he.C10156g.m63311h(r11.f60214g);
        r11.f60210c = r11.f60214g.m71597u();
        r11.f60211d = r11.f60214g.m71602z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
    
        if ((r11.f60210c / 100) != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
    
        return r11.f60214g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        p031b7.C1120a.m6676e("FileDownloadRequestByHttp2", "throw ReportException:Unexpected code:" + r11.f60210c);
        m80130d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c3, code lost:
    
        throw new p701v6.C13359f(java.lang.String.valueOf(r11.f60210c), r11.f60211d);
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.C11922g0 m80135i(java.lang.String r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p701v6.C13356c.m80135i(java.lang.String):okhttp3.g0");
    }

    /* renamed from: j */
    public void m80136j(long j10, long j11) {
        StringBuffer stringBuffer = new StringBuffer("bytes=");
        stringBuffer.append(j10);
        stringBuffer.append('-');
        stringBuffer.append(j11);
        this.f60216i = stringBuffer.toString();
    }

    /* renamed from: k */
    public void m80137k(boolean z10) {
        this.f60218k = z10;
    }
}
