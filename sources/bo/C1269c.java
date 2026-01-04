package bo;

import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;

/* renamed from: bo.c */
/* loaded from: classes6.dex */
public class C1269c extends AbstractC4994a {

    /* renamed from: a */
    public final String f5702a;

    /* renamed from: b */
    public final String f5703b;

    public C1269c(String str, String str2, String str3, String str4) {
        super(str2, str4, "GET");
        this.f5703b = str;
        this.f5702a = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f5702a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f5703b);
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(C11922g0 c11922g0) throws C9721b, IOException {
        String strM71637z = c11922g0.m71595s().m71637z();
        parseErrorByRsp(strM71637z);
        return strM71637z;
    }
}
