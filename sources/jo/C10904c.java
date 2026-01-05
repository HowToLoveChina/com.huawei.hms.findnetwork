package jo;

import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import mk.C11475a;
import okhttp3.HttpRequestBuilder;
import p514o9.C11829c;
import p709vj.C13452e;

/* renamed from: jo.c */
/* loaded from: classes6.dex */
public class C10904c extends C10902a {
    public C10904c(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // jo.C10902a, com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        String strM80966s = C13452e.m80781L().m80966s();
        String strM80950o = C13452e.m80781L().m80950o();
        C9720a.m60653b(strM80966s, "deviceType is null");
        C9720a.m60653b(strM80950o, "deviceId is null");
        aVar.m71583j("x-hw-device-type");
        aVar.addHeader("x-hw-device-type", strM80966s);
        aVar.m71583j("x-hw-device-id");
        aVar.addHeader("x-hw-device-id", strM80950o);
        String strM70565c = C11829c.m70565c(strM80966s, strM80950o, "com.huawei.hidisk", C13452e.m80781L().m80931j0(), this.f51747a);
        String str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
        if (!C10028c.m62182c0().m62420y1()) {
            str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
            aVar.m71583j("encversion");
            aVar.addHeader("encversion", "1");
        }
        aVar.m71583j(FeedbackWebConstants.AUTHORIZATION);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, str);
    }
}
