package p259ej;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p054cj.C1442a;
import p514o9.C11829c;
import p514o9.C11842p;
import p709vj.C13452e;

/* renamed from: ej.b */
/* loaded from: classes5.dex */
public class C9497b extends AbstractC4994a {

    /* renamed from: a */
    public String f47312a;

    /* renamed from: b */
    public String f47313b;

    /* renamed from: c */
    public String f47314c;

    /* renamed from: d */
    public String f47315d;

    public C9497b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(str3, str5, str6);
        this.f47313b = str;
        this.f47314c = str2;
        this.f47312a = str4;
        this.f47315d = str7;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f47312a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, NoSuchMethodException, IOException, SecurityException {
        super.prepare(aVar);
        aVar.m71574a("x-hw-app-id", "10055832");
        StringBuilder sb2 = new StringBuilder("com.huawei.hidisk/");
        sb2.append("16.0.0.300");
        sb2.append(" (Linux; HarmonyOS ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append("; ");
        sb2.append(Build.MODEL);
        sb2.append("; ");
        String str = C11829c.f54755a;
        sb2.append(str);
        sb2.append(") HMS/");
        sb2.append("2.6.3.306 (");
        sb2.append("10055832)");
        aVar.m71574a("User-Agent", sb2.toString());
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f47313b);
        aVar.m71574a("x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
        aVar.m71574a("x-hw-device-name", str);
        aVar.m71574a("x-hw-app-package-name", "com.huawei.hidisk");
        aVar.m71574a("x-hw-network", C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
        String strM1324x0 = C0209d.m1324x0();
        if (TextUtils.isEmpty(strM1324x0)) {
            strM1324x0 = "";
        }
        aVar.m71574a("x-hw-deviceUDID", strM1324x0);
        aVar.m71574a("x-hw-app-version", C1443a.f6213a);
        aVar.m71574a("x-hw-callmode", "auto");
        aVar.m71574a("x-hw-risktoken", this.f47314c);
        aVar.m71574a("Accept-Language", C0234s.m1631i());
        aVar.m71574a("x-hw-service-country", C13452e.m80781L().m80921h0());
        if (this.f47315d != null) {
            C1442a.m8288d("CampaignCallback", "prepare omExpandHeader is :" + this.f47315d);
            try {
                Map map = (Map) new Gson().fromJson(this.f47315d, Map.class);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        aVar.m71574a(entry.getKey().toString(), new JSONObject(entry.getValue().toString()).toString());
                    }
                }
            } catch (JsonSyntaxException | JSONException e10) {
                C1442a.m8288d("CampaignCallback", "prepare JsonSyntaxException e :" + e10.getMessage());
            }
        }
        C9720a.m60653b(C13452e.m80781L().m80921h0(), "serviceCountryCode is null");
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(C11922g0 c11922g0) throws C9721b, IOException, NumberFormatException {
        String strM71637z = c11922g0.m71595s().m71637z();
        String strM71599w = c11922g0.m71599w("NSP_STATUS");
        if (strM71599w != null && !strM71599w.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(this.svc);
            sb2.append(" nsp status = ");
            sb2.append(strM71599w);
            sb2.append("=>");
            try {
                int i10 = Integer.parseInt(strM71599w);
                if (i10 != 0) {
                    sb2.append(strM71637z);
                    throw new C9721b(4000, i10, sb2.toString(), this.svc);
                }
            } catch (NumberFormatException unused) {
                sb2.append(strM71637z);
                throw new C9721b(4000, -1, sb2.toString(), this.svc);
            }
        }
        parseErrorByRsp(strM71637z);
        return strM71637z;
    }
}
