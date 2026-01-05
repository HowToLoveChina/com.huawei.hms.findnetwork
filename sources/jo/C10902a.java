package jo;

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
import p015ak.C0209d;
import p015ak.C0234s;
import p514o9.C11829c;
import p709vj.C13452e;

/* renamed from: jo.a */
/* loaded from: classes6.dex */
public class C10902a extends AbstractC4994a {

    /* renamed from: a */
    public String f51747a;

    /* renamed from: b */
    public String f51748b;

    /* renamed from: c */
    public String f51749c;

    /* renamed from: d */
    public String f51750d;

    /* renamed from: e */
    public boolean f51751e;

    /* renamed from: f */
    public String f51752f;

    /* renamed from: g */
    public boolean f51753g;

    public C10902a(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.f51751e = false;
        this.f51747a = str;
        this.f51752f = str3;
    }

    /* renamed from: a */
    public boolean m65923a() {
        return this.f51753g;
    }

    /* renamed from: b */
    public void m65924b(String str, String str2, String str3) {
        this.f51748b = str;
        this.f51749c = str2;
        this.f51750d = str3;
        this.f51751e = true;
    }

    /* renamed from: c */
    public void m65925c(boolean z10) {
        this.f51753g = z10;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f51752f.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader("x-hw-client-capacity", "1");
        aVar.addHeader("x-hw-user-svrplace", C13452e.m80781L().m80921h0());
        aVar.addHeader("Accept-Language", C0234s.m1627e());
        aVar.addHeader("x-hw-backup-version", "1");
        if (m65923a()) {
            aVar.addHeader("x-hw-refurbishment", String.valueOf(true));
        }
        C11829c.m70559a(aVar);
        if (!this.f51751e) {
            this.f51748b = C13452e.m80781L().m80970t();
            this.f51749c = C13452e.m80781L().m80954p();
            this.f51750d = C13452e.m80781L().m80931j0();
        }
        String strM70565c = C11829c.m70565c(this.f51748b, this.f51749c, "com.huawei.hidisk", this.f51750d, this.f51747a);
        String str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
        if (!C10028c.m62182c0().m62420y1()) {
            str = new String(C11475a.m68618a(strM70565c.getBytes("utf-8")), "utf-8");
            aVar.addHeader("encversion", "1");
        }
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, str);
        C0209d.m1231a(aVar);
    }
}
