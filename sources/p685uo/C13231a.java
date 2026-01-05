package p685uo;

import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import p336he.C10156g;

/* renamed from: uo.a */
/* loaded from: classes6.dex */
public class C13231a extends AbstractC4994a {

    /* renamed from: a */
    public String f59901a;

    /* renamed from: b */
    public String f59902b;

    /* renamed from: c */
    public boolean f59903c;

    /* renamed from: d */
    public boolean f59904d;

    /* renamed from: e */
    public String f59905e;

    /* renamed from: f */
    public String f59906f;

    public C13231a(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, String str7) {
        super(str2, str4, str5);
        this.f59901a = str;
        this.f59902b = str3;
        this.f59904d = z10;
        this.f59905e = str6;
        this.f59906f = str7;
    }

    /* renamed from: a */
    public void m79604a(boolean z10) {
        this.f59903c = z10;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        MimeClass MimeClassM71445d = MimeClass.m71445d(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED);
        HashMap map = new HashMap();
        map.put("nsp_fmt", "JSON");
        map.put("nsp_ver", "1.0");
        map.put("access_token", this.f59901a);
        map.put("nsp_svc", this.svc);
        StringBuilder sb2 = new StringBuilder();
        if (!StringUtil.isBlank(this.f59902b)) {
            sb2.append(this.f59902b);
            sb2.append('&');
        }
        for (Map.Entry entry : map.entrySet()) {
            sb2.append(URLEncoder.encode((String) entry.getKey(), Constants.UTF_8));
            sb2.append('=');
            if (entry.getValue() != null) {
                sb2.append(URLEncoder.encode((String) entry.getValue(), Constants.UTF_8));
            }
            sb2.append('&');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return AbstractC11920f0.create(MimeClassM71445d, sb2.toString().getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f59901a);
        String str = Build.MODEL;
        aVar.addHeader("x-hw-terminal", str);
        aVar.addHeader("User-Agent", "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + str + "; HUAWEI" + str + ") HMS/2.6.3.306 (10055832)");
        if (this.f59906f != null) {
            BaseLogger.m28729d("OpenGWCallback", "prepare omExpandHeader is :" + this.f59906f);
            try {
                Map map = (Map) new Gson().fromJson(this.f59906f, Map.class);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        aVar.addHeader(entry.getKey().toString(), new JSONObject(entry.getValue().toString()).toString());
                    }
                }
            } catch (JsonSyntaxException | JSONException e10) {
                BaseLogger.m28731e("OpenGWCallback", "prepare JsonSyntaxException e :" + e10.getMessage());
            }
        }
        if (this.f59904d) {
            C10156g.m63308e(aVar, this.f59905e);
        }
        if (this.f59903c) {
            aVar.addHeader("x-hw-client-mode", "frontend");
        }
    }
}
