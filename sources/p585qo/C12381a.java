package p585qo;

import android.text.TextUtils;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p709vj.C13452e;

/* renamed from: qo.a */
/* loaded from: classes6.dex */
public class C12381a extends AbstractC4994a {

    /* renamed from: a */
    public String f57201a;

    /* renamed from: b */
    public String f57202b;

    /* renamed from: c */
    public String f57203c;

    public C12381a(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.f57201a = str;
        this.f57203c = str3;
    }

    /* renamed from: a */
    public void m74444a(String str) {
        this.f57202b = str;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f57203c.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a((C13452e.m80781L().m80970t() + ":" + C13452e.m80781L().m80954p() + ":com.huawei.hidisk:" + C13452e.m80781L().m80931j0() + ":" + this.f57201a).getBytes("utf-8")), "utf-8"));
        if (TextUtils.isEmpty(this.f57202b)) {
            return;
        }
        aVar.addHeader("Lock-Token", this.f57202b);
    }
}
