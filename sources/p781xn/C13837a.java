package p781xn;

import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0228m0;
import p399jk.AbstractC10896a;

/* renamed from: xn.a */
/* loaded from: classes6.dex */
public class C13837a extends C13838b {
    public C13837a(JSONObject jSONObject) {
        super(jSONObject);
        AbstractC10896a.m65885d("UBAAnalyzeAnonymousCallback", "UBAAnalyzeAnonymousCallback");
    }

    @Override // p781xn.C13838b, com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        AbstractC10896a.m65885d("UBAAnalyzeAnonymousCallback", "UBAAnalyzeAnonymousCallback--create");
        return super.create();
    }

    @Override // p781xn.C13838b, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) {
        super.prepare(aVar);
        aVar.addHeader("x-hw-device-id", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-device-type", C0209d.m1209S1("6"));
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) {
        AbstractC10896a.m65885d("UBAAnalyzeAnonymousCallback", "UBAAnalyzeAnonymousCallback--onResponse");
        return super.onResponse(HttpResponseBuilder);
    }
}
