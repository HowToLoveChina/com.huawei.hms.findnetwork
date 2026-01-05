package p747wo;

import android.net.Uri;
import android.util.Base64;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p709vj.C13452e;

/* renamed from: wo.a */
/* loaded from: classes6.dex */
public class C13623a extends AbstractC4994a {

    /* renamed from: a */
    public String f61288a;

    /* renamed from: b */
    public String f61289b;

    public C13623a(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.f61288a = str;
        this.f61289b = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f61289b.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, new String(Base64.encode((C13452e.m80781L().m80970t() + ":" + C13452e.m80781L().m80954p() + ":com.huawei.hidisk:" + C13452e.m80781L().m80931j0() + ":" + Uri.encode(this.f61288a)).getBytes("utf-8"), 2), "utf-8"));
        aVar.addHeader("encversion", "1");
    }
}
