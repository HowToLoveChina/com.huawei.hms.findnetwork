package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l0 */
/* loaded from: classes8.dex */
public class C5547l0 {

    /* renamed from: a */
    private String f25244a;

    /* renamed from: b */
    private String f25245b;

    /* renamed from: c */
    private String f25246c;

    /* renamed from: d */
    private List<C5518b1> f25247d;

    /* renamed from: e */
    private String f25248e;

    public C5547l0(String str, String str2, String str3, List<C5518b1> list, String str4) {
        this.f25244a = str;
        this.f25245b = str2;
        this.f25246c = str3;
        this.f25247d = list;
        this.f25248e = str4;
    }

    /* renamed from: a */
    private String m32620a(String str, String str2) {
        String str3;
        String strM32431f = AbstractC5515a1.m32431f(str, str2);
        if (TextUtils.isEmpty(strM32431f)) {
            C5571v.m32787a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", strM32431f);
    }

    /* renamed from: b */
    private void m32622b() {
        if (C5520c0.m32466a(AbstractC5562q0.m32718i(), "backup_event", FeedbackConst.Mail.LOG_MAX_LENGTH)) {
            C5571v.m32794d("hmsSdk", "backup file reach max limited size, delete it");
            C5522d.m32478a(AbstractC5562q0.m32718i(), "backup_event", new String[0]);
            return;
        }
        JSONArray jSONArrayM32623c = m32623c();
        String strM32661a = AbstractC5554n1.m32661a(this.f25244a, this.f25245b, this.f25248e);
        C5571v.m32792c("hmsSdk", "Update data cached into backup,spKey: " + strM32661a);
        C5522d.m32481b(AbstractC5562q0.m32718i(), "backup_event", strM32661a, jSONArrayM32623c.toString());
    }

    /* renamed from: c */
    private JSONArray m32623c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<C5518b1> it = this.f25247d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m32458d());
            } catch (JSONException unused) {
                C5571v.m32792c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    private C5536h1 m32624d() {
        return C5543k.m32597a(this.f25247d, this.f25244a, this.f25245b, this.f25248e, this.f25246c);
    }

    /* renamed from: a */
    public void m32625a() {
        InterfaceRunnableC5531g c5524d1;
        C5517b0 c5517b0M32449c;
        String str;
        String strM32620a = m32620a(this.f25244a, this.f25245b);
        if (!TextUtils.isEmpty(strM32620a) || "preins".equals(this.f25245b)) {
            if (!"_hms_config_tag".equals(this.f25244a) && !"_openness_config_tag".equals(this.f25244a)) {
                m32622b();
            }
            C5536h1 c5536h1M32624d = m32624d();
            if (c5536h1M32624d != null) {
                byte[] bArrM32621a = m32621a(c5536h1M32624d);
                if (bArrM32621a.length == 0) {
                    str = "request body is empty";
                } else {
                    c5524d1 = new C5528f(bArrM32621a, strM32620a, this.f25244a, this.f25245b, this.f25248e, this.f25247d);
                    c5517b0M32449c = C5517b0.m32448b();
                }
            } else {
                c5524d1 = new C5524d1(this.f25247d, this.f25244a, this.f25248e, this.f25245b);
                c5517b0M32449c = C5517b0.m32449c();
            }
            c5517b0M32449c.m32450a(c5524d1);
            return;
        }
        str = "collectUrl is empty";
        C5571v.m32796e("hmsSdk", str);
    }

    /* renamed from: a */
    private byte[] m32621a(C5536h1 c5536h1) {
        String str;
        try {
            JSONObject jSONObjectMo32451a = c5536h1.mo32451a();
            if (jSONObjectMo32451a != null) {
                return C5545k1.m32613a(jSONObjectMo32451a.toString().getBytes(Constants.UTF_8));
            }
            C5571v.m32796e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            C5571v.m32796e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            C5571v.m32796e("hmsSdk", str);
            return new byte[0];
        }
    }
}
