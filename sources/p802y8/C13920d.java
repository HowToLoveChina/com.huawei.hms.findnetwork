package p802y8;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0228m0;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p846zj.C14306d;
import sx.C12875e;

/* renamed from: y8.d */
/* loaded from: classes2.dex */
public class C13920d extends AbstractC4994a {

    /* renamed from: a */
    public String f62312a;

    public C13920d(String str, String str2, String str3) {
        super(str, "", str2);
        this.f62312a = str3;
    }

    /* renamed from: a */
    private String m83457a() {
        try {
            return C13195l.m79272J().m79344y("WishRequest", "");
        } catch (C13194k | C13199p e10) {
            C11839m.m70687e("WishRequestCallback", "getAccessToken exception:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    private String m83458b(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: c */
    public final String m83459c() {
        return "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)";
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return "POST".equals(this.method) ? AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f62312a.getBytes(StandardCharsets.UTF_8)) : "DELETE".equals(this.method) ? C12875e.f58644e : C12875e.f58644e;
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        String str = C11842p.m70762R0() ? "pad" : "phone";
        int iM1225Y = C0209d.m1225Y(C0213f.m1377a());
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, "Bearer " + m83457a());
        aVar.addHeader(JsbMapKeyNames.H5_USER_ID, m83458b(strM80971t0));
        aVar.addHeader("User-Agent", m83459c());
        aVar.addHeader("x-hw-trace-id", this.traceID);
        aVar.addHeader("x-hw-terminal", Build.MODEL);
        aVar.addHeader("x-hw-os", C0209d.m1315v());
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
        aVar.addHeader("x-hw-device-category", str);
        aVar.addHeader("x-hw-device-name", C11829c.f54755a);
        aVar.addHeader("x-hw-device-type", m83458b(strM80970t));
        aVar.addHeader("x-hw-device-id", m83458b(strM80954p));
        aVar.addHeader("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-app-package-name", "com.huawei.hidisk");
        aVar.addHeader("x-hw-app-version", C1443a.f6213a);
        aVar.addHeader("x-hw-app-id", "10055832");
        aVar.addHeader("x-hw-network", C0209d.m1228Z(iM1225Y));
        aVar.addHeader("x-hw-client-mode", "frontend");
        C14306d.m85213n(aVar);
    }
}
