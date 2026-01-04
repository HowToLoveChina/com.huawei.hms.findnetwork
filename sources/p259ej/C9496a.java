package p259ej;

import android.os.Build;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p054cj.C1442a;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: ej.a */
/* loaded from: classes5.dex */
public class C9496a extends AbstractC4994a {

    /* renamed from: a */
    public String f47307a;

    /* renamed from: b */
    public String f47308b;

    /* renamed from: c */
    public boolean f47309c;

    /* renamed from: d */
    public String f47310d;

    /* renamed from: e */
    public String f47311e;

    public C9496a(String str, String str2, String str3, String str4, boolean z10, String str5) {
        super(str2, str4, "POST");
        this.f47308b = str;
        this.f47307a = str3;
        this.f47309c = z10;
        this.f47310d = str2;
        this.f47311e = str5;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f47307a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.m71574a(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1631i());
        aVar.m71574a("Accept-Language", C0234s.m1631i());
        aVar.m71574a("ClientVersion", C1443a.f6213a);
        aVar.m71574a("Device", Build.MODEL);
        aVar.m71574a("AuthType", C13843a.m83075a("com.huawei.hidisk"));
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, C13843a.m83077b(C13452e.m80781L().m80970t() + ":" + C13452e.m80781L().m80954p() + ":" + C13452e.m80781L().m80931j0() + ":0:" + this.f47308b, Constants.UTF_8));
        aVar.m71574a("TokenType", "2");
        aVar.m71574a("Country", C13452e.m80781L().m80921h0());
        if (this.f47311e != null) {
            C1442a.m8288d("BusinessCallback", "prepare omExpandHeader is :" + this.f47311e);
            try {
                Map map = (Map) new Gson().fromJson(this.f47311e, Map.class);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        aVar.m71574a(entry.getKey().toString(), new JSONObject(entry.getValue().toString()).toString());
                    }
                }
            } catch (JsonSyntaxException | JSONException e10) {
                C1442a.m8289e("BusinessCallback", "prepare JsonSyntaxException e :" + e10.getMessage());
            }
        }
        if (this.f47309c) {
            aVar.m71574a("x-hw-source-agent", "H5");
            aVar.m71574a("x-hw-cmd", this.f47310d);
        }
        aVar.m71574a("x-hw-framework-type", "0");
        if (this.f47310d.equals("queryO2OActivity")) {
            aVar.m71574a("x-hw-network", C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
            aVar.m71574a("x-hw-app-package-name", "com.huawei.hidisk");
        }
    }
}
