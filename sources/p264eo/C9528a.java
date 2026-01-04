package p264eo;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: eo.a */
/* loaded from: classes6.dex */
public class C9528a extends AbstractC4994a {

    /* renamed from: a */
    public String f47363a;

    /* renamed from: b */
    public boolean f47364b;

    /* renamed from: c */
    public String f47365c;

    /* renamed from: d */
    public int f47366d;

    /* renamed from: e */
    public String f47367e;

    public C9528a(String str, String str2, String str3, String str4, boolean z10, int i10, String str5) {
        super(str2, str4, "POST");
        this.f47365c = str;
        this.f47363a = str3;
        this.f47364b = z10;
        this.f47366d = i10;
        this.f47367e = str5;
    }

    /* renamed from: a */
    public final String m59521a() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String hostAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (inetAddressNextElement != null && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                        break;
                    }
                }
            }
            return hostAddress;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f47363a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.m71574a("Device", Build.MODEL);
        aVar.m71574a("Country", C13452e.m80781L().m80921h0());
        aVar.m71574a("Lang", C0234s.m1631i());
        aVar.m71574a("ClientVersion", C1443a.f6213a);
        aVar.m71574a("Accept-Language", C0234s.m1631i());
        aVar.m71574a("AuthType", C13843a.m83075a("com.huawei.hidisk"));
        aVar.m71574a("SiteId", String.valueOf(C13452e.m80781L().m80947n0()));
        if (this.f47364b) {
            aVar.m71574a("x-hw-source-agent", "H5");
        }
        aVar.m71574a("x-hw-device-name", C11829c.f54755a);
        aVar.m71574a("x-hw-userid", C13452e.m80781L().m80971t0());
        aVar.m71574a("ClientIP", m59521a());
        aVar.m71574a("x-hw-backup-version", "1");
        aVar.m71574a("x-hw-user-svrplace", C13452e.m80781L().m80921h0());
        aVar.m71574a("x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
        C11839m.m70686d("AppMashupCallback", "pushContext " + this.f47367e);
        if (!TextUtils.isEmpty(this.f47367e)) {
            aVar.m71574a("x-hw-context", this.f47367e);
        }
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        String strM80931j0 = C13452e.m80781L().m80931j0();
        int i10 = this.f47366d;
        if (i10 == 1) {
            aVar.m71574a("x-hw-auth-version", "1");
            aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a(C11829c.m70565c(strM80970t, strM80954p, "com.huawei.hidisk", strM80931j0, this.f47365c).getBytes("utf-8")), "utf-8"));
        } else if (i10 == 2) {
            aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f47365c);
        }
    }
}
