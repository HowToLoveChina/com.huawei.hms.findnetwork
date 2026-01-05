package jo;

import android.net.Uri;
import android.os.Build;
import ck.C1443a;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import mk.C11475a;
import okhttp3.HttpRequestBuilder;
import p015ak.C0209d;
import p015ak.C0228m0;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: jo.b */
/* loaded from: classes6.dex */
public class C10903b extends C10902a {
    public C10903b(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // jo.C10902a, com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws IOException {
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a(("::::" + Uri.encode(this.f51747a)).getBytes("utf-8")), "utf-8"));
        aVar.addHeader("version", C1443a.f6213a);
        aVar.addHeader("x-hw-terminal", Build.MODEL);
        aVar.addHeader("x-hw-os", C0209d.m1315v());
        aVar.addHeader("x-hw-auth-version", "1");
        aVar.addHeader("x-hw-trace-id", this.traceID);
        aVar.addHeader("x-hw-account-brand-id", C14306d.m85201b());
        aVar.addHeader("x-hw-device-type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
        aVar.addHeader("x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
        aVar.addHeader("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
    }
}
