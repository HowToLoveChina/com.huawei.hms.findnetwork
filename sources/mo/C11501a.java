package mo;

import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p015ak.C0234s;
import p514o9.C11829c;
import p709vj.C13452e;

/* renamed from: mo.a */
/* loaded from: classes6.dex */
public class C11501a extends AbstractC4994a {

    /* renamed from: a */
    public String f53400a;

    /* renamed from: b */
    public String f53401b;

    public C11501a(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.f53400a = str;
        this.f53401b = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f53401b.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader("Connection", "close");
        aVar.addHeader("Accept-Language", C0234s.m1627e());
        aVar.addHeader("x-hw-backup-version", "1");
        C11829c.m70559a(aVar);
        String strM70565c = C11829c.m70565c(C13452e.m80781L().m80970t(), C13452e.m80781L().m80954p(), "com.huawei.hidisk", C13452e.m80781L().m80931j0(), this.f53400a);
        String str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
        if (!C10028c.m62182c0().m62420y1()) {
            str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
            if ("BackupReq".equals(this.svc)) {
                aVar.addHeader("encversion", "0");
            } else {
                aVar.addHeader("encversion", "1");
            }
        }
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, str);
    }
}
