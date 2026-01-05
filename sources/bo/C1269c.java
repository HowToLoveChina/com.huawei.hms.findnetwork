package bo;

import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;

/* renamed from: bo.c */
/* loaded from: classes6.dex */
public class C1269c extends AbstractC4994a {

    /* renamed from: a */
    public final String m_method;

    /* renamed from: b */
    public final String m_bearer;

    public C1269c(String str, String str2, String method, String str4) {
        super(str2, str4, "GET");
        this.m_bearer = str;
        this.m_method = method;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.m_method.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.m_bearer);
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException {
        String strM71637z = HttpResponseBuilder.m71595s().m71637z();
        parseErrorByRsp(strM71637z);
        return strM71637z;
    }
}
