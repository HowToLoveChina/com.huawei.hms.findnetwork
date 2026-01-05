package p816yn;

import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;

/* renamed from: yn.a */
/* loaded from: classes6.dex */
public class C14028a extends AbstractC4994a {

    /* renamed from: a */
    public String f62796a;

    public C14028a(String str, String str2, String str3, String str4) {
        super(str, str3, str4);
        this.f62796a = str2;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f62796a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException {
        return HttpResponseBuilder.m71595s().m71637z();
    }
}
