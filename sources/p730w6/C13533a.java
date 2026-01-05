package p730w6;

import android.os.Build;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.hicloud.okhttp.request.AbstractC4977a;
import com.huawei.hms.network.embedded.C6055q0;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.Map;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0234s;
import p031b7.C1122c;
import p514o9.C11829c;
import p514o9.C11839m;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: w6.a */
/* loaded from: classes2.dex */
public class C13533a extends AbstractC4977a {

    /* renamed from: a */
    public String f60898a;

    /* renamed from: b */
    public String f60899b;

    /* renamed from: c */
    public Map<String, String> f60900c;

    public C13533a(Map<String, String> map, String str, String str2, String str3) {
        super(null, str3, "POST");
        this.f60898a = str2;
        this.f60899b = str;
        this.f60900c = map;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.f60898a.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.okhttp.request.AbstractC4977a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        String str;
        super.prepare(aVar);
        aVar.addHeader("Connection", "close");
        aVar.addHeader("Accept-Language", C0234s.m1627e());
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        String strM80931j0 = C13452e.m80781L().m80931j0();
        String str2 = Build.MODEL;
        StringBuilder sb2 = new StringBuilder(strM80970t);
        sb2.append(":");
        sb2.append(strM80954p);
        sb2.append(":");
        sb2.append("com.huawei.hidisk");
        sb2.append(":");
        sb2.append("");
        C11829c.m70562b(sb2, this.f60899b);
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            C11829c.m70559a(aVar);
        }
        String string = sb2.toString();
        if (C10028c.m62182c0().m62420y1()) {
            str = new String(C11475a.m68618a(string.getBytes("utf-8")), "utf-8");
            aVar.addHeader("Cflg", "1");
        } else {
            str = new String(C11475a.m68618a((strM80970t + ":" + strM80954p + ":" + strM80931j0 + ":" + str2 + ":" + this.f60899b).getBytes("utf-8")), "utf-8");
        }
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, str);
        aVar.addHeader("AuthType", C1122c.m6773e("com.huawei.hidisk"));
        Map<String, String> map = this.f60900c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.addHeader(entry.getKey(), entry.getValue());
            }
        }
        aVar.addHeader("x-hw-3rdapp-packagename", C13843a.m83054F(C0213f.m1377a()));
        aVar.addHeader("x-hw-3rdapp-version", C1122c.m6833t0(C0213f.m1377a()));
    }

    @Override // com.huawei.hicloud.okhttp.request.AbstractC4977a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws JSONException, C9721b, IOException {
        String strM71637z = HttpResponseBuilder.m71595s().m71637z();
        parseErrorByRsp(strM71637z);
        try {
            JSONObject jSONObject = new JSONObject(strM71637z);
            if (803 == jSONObject.getInt("code")) {
                jSONObject.put("RetryAfterInHeader", HttpResponseBuilder.m71599w(C6055q0.f27799f));
                return jSONObject.toString();
            }
        } catch (JSONException unused) {
            C11839m.m70689w("CloudPhotoCallback", "JSONException");
        }
        return strM71637z;
    }
}
