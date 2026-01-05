package p781xn;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import okhttp3.AbstractC11920f0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import org.json.JSONObject;
import p015ak.C0209d;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p681uj.C13195l;
import p709vj.C13452e;

/* renamed from: xn.c */
/* loaded from: classes6.dex */
public class C13839c extends C13838b {
    public C13839c(JSONObject jSONObject) {
        super(jSONObject);
        AbstractC10896a.m65885d("UBAAnalyzeCallback", "UBAAnalyzeCallback");
    }

    @Override // p781xn.C13838b, com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        return super.create();
    }

    @Override // p781xn.C13838b, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) throws NoSuchMethodException, SecurityException, UnsupportedEncodingException {
        String strM80971t0;
        String string;
        String str;
        super.prepare(aVar);
        String strM1324x0 = C0209d.m1324x0();
        if (C13452e.m80781L().m80842P0()) {
            strM80971t0 = C13452e.m80781L().m80971t0();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C13452e.m80781L().m80970t());
            sb2.append(":");
            sb2.append(C13452e.m80781L().m80954p());
            sb2.append(":");
            try {
                HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
                String strEncode = "";
                if (hiCloudSysParamMapM60758q != null && hiCloudSysParamMapM60758q.getEnhanceAtAuthentication() == 1) {
                    strEncode = URLEncoder.encode(C13195l.m79272J().m79344y("UbaAnalyze", ""), Constants.UTF_8);
                }
                sb2.append("com.huawei.hidisk");
                sb2.append(":");
                sb2.append(C13452e.m80781L().m80931j0());
                sb2.append(":");
                sb2.append(strEncode);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyzeCallback", "in generateRequest, Exception error: " + e10.toString());
                UBAAnalyze.m29991n0("Exception", e10.toString());
            }
            string = sb2.toString();
            str = "1";
        } else {
            strM80971t0 = null;
            string = null;
            str = null;
        }
        if (!TextUtils.isEmpty(strM80971t0)) {
            aVar.addHeader("X-AccountID", strM80971t0);
            UBAAnalyze.m29991n0("X-AccountID", strM80971t0);
        }
        if (!TextUtils.isEmpty(strM1324x0)) {
            aVar.addHeader("X-UDID", strM1324x0);
            UBAAnalyze.m29991n0("X-UDID", strM1324x0);
        }
        if (string != null) {
            aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, Base64.encodeToString(string.getBytes(StandardCharsets.UTF_8), 2));
            aVar.addHeader("x-hw-auth-version", str);
        }
        aVar.addHeader("x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
        aVar.addHeader("x-hw-device-type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) {
        return super.onResponse(HttpResponseBuilder);
    }
}
