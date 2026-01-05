package p528oo;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p015ak.C0209d;
import p336he.C10156g;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: oo.a */
/* loaded from: classes6.dex */
public class C11977a extends AbstractC4994a {

    /* renamed from: a */
    public String f55749a;

    /* renamed from: b */
    public String f55750b;

    public C11977a(String str, String str2, String str3, String str4, String str5) {
        super(str2, str3, str4);
        this.f55749a = str;
        this.f55750b = str5;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f55749a.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        String str = C1443a.f6213a;
        aVar.addHeader("version", str);
        aVar.addHeader("x-hw-app-id", "10055832");
        aVar.addHeader("x-hw-app-version", str);
        aVar.addHeader("x-hw-terminal", Build.MODEL);
        aVar.addHeader("x-hw-os", C0209d.m1315v());
        aVar.addHeader("x-hw-trace-id", this.traceID);
        if (!TextUtils.isEmpty(this.f55750b)) {
            aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f55750b);
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "userId is null");
        aVar.addHeader("unionID", strM80971t0);
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
        C10156g.m63308e(aVar, "drive");
        C14306d.m85213n(aVar);
    }
}
