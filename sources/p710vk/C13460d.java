package p710vk;

import android.net.Uri;
import android.os.Build;
import ck.C1443a;
import com.huawei.hicloud.okhttp.callback.AbstractC4975a;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import mk.C11475a;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0209d;
import p015ak.C0228m0;
import p015ak.C0234s;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: vk.d */
/* loaded from: classes6.dex */
public class C13460d extends AbstractC4975a<String> {

    /* renamed from: a */
    public String f60633a;

    /* renamed from: b */
    public String f60634b;

    public C13460d(String str, String str2) {
        this.f60633a = str;
        this.f60634b = str2;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        String strM80931j0 = C13452e.m80781L().m80931j0();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80942m = C13452e.m80781L().m80942m();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        C9720a.m60653b(strM80971t0, "userId is null");
        C9720a.m60653b(strM80942m, "countryCode is null");
        C9720a.m60653b(strM80970t, "deviceType is null");
        C9720a.m60653b(strM80954p, "deviceId is null login stats is " + C13452e.m80781L().m80842P0());
        aVar.m71574a(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        aVar.m71574a("x-hw-country-code", strM80942m);
        aVar.m71574a("x-hw-device-type", strM80970t);
        aVar.m71574a("x-hw-device-id", strM80954p);
        aVar.m71574a("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.m71574a("x-hw-os-brand", C0209d.m1276l0());
        String str = C1443a.f6213a;
        aVar.m71574a("version", str);
        aVar.m71574a("x-hw-terminal", Build.MODEL);
        aVar.m71574a("x-hw-os", C0209d.m1315v());
        aVar.m71574a("x-hw-trace-id", this.f60634b);
        aVar.m71574a("x-hw-app-version", str);
        aVar.m71574a("Accept-Language", C0234s.m1627e());
        aVar.m71574a("x-hw-auth-version", "1");
        C14306d.m85213n(aVar);
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a((strM80970t + ":" + strM80954p + ":com.huawei.hidisk:" + strM80931j0 + ":" + Uri.encode(this.f60633a)).getBytes("utf-8")), "utf-8"));
        aVar.m71574a("x-hw-account-brand-id", C14306d.m85201b());
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public String onResponse(C11922g0 c11922g0) throws IOException {
        return c11922g0.m71595s().m71637z();
    }
}
