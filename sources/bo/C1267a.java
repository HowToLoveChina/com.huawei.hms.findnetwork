package bo;

import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.net.URLEncoder;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import p514o9.C11839m;

/* renamed from: bo.a */
/* loaded from: classes6.dex */
public class C1267a extends AbstractC4994a {

    /* renamed from: a */
    public String f5700a;

    /* renamed from: b */
    public String f5701b;

    public C1267a(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.f5701b = str;
        this.f5700a = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        C11910a0 c11910a0M71445d = C11910a0.m71445d(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nsp_svc=");
        sb2.append(URLEncoder.encode(this.svc, Constants.UTF_8));
        sb2.append("&access_token=");
        sb2.append(URLEncoder.encode(this.f5701b, Constants.UTF_8));
        sb2.append("&request=");
        sb2.append(URLEncoder.encode(this.f5700a, Constants.UTF_8));
        C11839m.m70686d("AgreementServiceCallback", "doOutput:" + sb2.toString());
        return AbstractC11920f0.create(c11910a0M71445d, sb2.toString().getBytes(Constants.UTF_8));
    }
}
