package p259ej;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11842p;
import p709vj.C13452e;

/* renamed from: ej.c */
/* loaded from: classes5.dex */
public class C9498c extends AbstractC4994a {

    /* renamed from: a */
    public String f47316a;

    /* renamed from: b */
    public String f47317b;

    public C9498c(String str, String str2, String str3, String str4, String str5) {
        super(str2, str4, str5);
        this.f47317b = str;
        this.f47316a = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f47316a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(C11922g0 c11922g0) throws C9721b, IOException {
        if (c11922g0 == null) {
            throw new C9721b(4000, "response is null");
        }
        String strM71637z = c11922g0.m71595s().m71637z();
        parseErrorByRsp(strM71637z);
        return strM71637z;
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, NoSuchMethodException, IOException, SecurityException {
        super.prepare(aVar);
        aVar.m71574a("x-hw-app-id", "10055832");
        StringBuilder sb2 = new StringBuilder("com.huawei.hidisk/");
        sb2.append("16.0.0.300");
        sb2.append(" (Linux; HarmonyOS ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append("; ");
        sb2.append(Build.MODEL);
        sb2.append("; ");
        String str = C11829c.f54755a;
        sb2.append(str);
        sb2.append(") HMS/");
        sb2.append("2.6.3.306 (");
        sb2.append("10055832)");
        String string = sb2.toString();
        int iM1225Y = C0209d.m1225Y(C0213f.m1377a());
        String strM1324x0 = C0209d.m1324x0();
        aVar.m71574a("User-Agent", string);
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f47317b);
        aVar.m71574a("x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
        aVar.m71574a("x-hw-device-name", str);
        aVar.m71574a("x-hw-app-package-name", "com.huawei.hidisk");
        aVar.m71574a("x-hw-network", C0209d.m1228Z(iM1225Y));
        if (TextUtils.isEmpty(strM1324x0)) {
            strM1324x0 = "";
        }
        aVar.m71574a("x-hw-deviceUDID", strM1324x0);
        aVar.m71574a("x-hw-app-version", C1443a.f6213a);
        aVar.m71574a("x-hw-callmode", "auto");
        aVar.m71574a("Accept-Language", C0234s.m1631i());
        aVar.m71574a("x-hw-service-country", C13452e.m80781L().m80921h0());
        C9720a.m60653b(C13452e.m80781L().m80921h0(), "serviceCountryCode is null");
    }
}
