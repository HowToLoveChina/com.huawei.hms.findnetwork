package p611rf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p521og.C11870c;
import p616rk.C12515a;
import p809yg.C13981a;

/* renamed from: rf.d */
/* loaded from: classes4.dex */
public class C12496d {

    /* renamed from: a */
    public String f57528a;

    /* renamed from: b */
    public int f57529b;

    /* renamed from: c */
    public String f57530c;

    /* renamed from: d */
    public String f57531d;

    /* renamed from: e */
    public String f57532e;

    /* renamed from: f */
    public Context f57533f;

    /* renamed from: g */
    public int f57534g;

    /* renamed from: h */
    public Handler.Callback f57535h;

    /* renamed from: rf.d$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            String strM75003f = C12496d.this.m75003f();
            RequestModeConfig.getInstance().setMode(Integer.valueOf(C12496d.this.f57534g), false);
            C4346d.m26226e(C12496d.this.f57534g, strM75003f, C12496d.this.f57535h, C12496d.this.f57533f, null);
        }
    }

    public C12496d(String str, int i10, String str2, String str3, String str4, Handler.Callback callback, Context context, int i11) {
        this.f57528a = str;
        this.f57529b = i10;
        this.f57530c = str2;
        this.f57535h = callback;
        this.f57533f = context;
        this.f57532e = str4;
        this.f57531d = str3;
        this.f57534g = i11;
    }

    /* renamed from: e */
    public void m75002e() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: f */
    public final String m75003f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            int i10 = this.f57534g;
            if (3015 == i10) {
                jSONObject.put("operation", "challengeReport");
            } else if (3016 == i10) {
                jSONObject.put("operation", "unbinding");
            } else if (3019 == i10) {
                jSONObject.put("operation", "unbindingReport");
            }
            Context context = this.f57533f;
            if (context == null || !"com.huawei.android.findmyphone".equals(context.getPackageName())) {
                Context context2 = this.f57533f;
                if (context2 == null || !"com.huawei.hidisk".equals(context2.getPackageName())) {
                    Context context3 = this.f57533f;
                    if (context3 == null || !"com.huawei.android.remotecontrol".equals(context3.getPackageName())) {
                        jSONObject.put("appType", 0);
                    } else {
                        jSONObject.put("appType", 1);
                    }
                } else {
                    jSONObject.put("appType", 2);
                }
            } else {
                jSONObject.put("appType", 3);
            }
            jSONObject.put("deviceId", this.f57528a);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f57529b);
            if (3015 == this.f57534g) {
                jSONObject.put("challenge", this.f57531d);
            }
            jSONObject.put("serviceToken", C11870c.m71155c(this.f57530c));
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f57532e));
            jSONObject.put("version", "v11");
            m75004g(jSONObject);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("ChallengeReport", "encaseChallengeReportInfo failed! JSONException");
            return null;
        }
    }

    /* renamed from: g */
    public final void m75004g(JSONObject jSONObject) throws JSONException {
        try {
            if (C1175a.m7385g(false)) {
                C13981a.m83989i("ChallengeReport", "has auth flag");
                return;
            }
            JSONArray jSONArrayM7393o = C1175a.m7393o();
            if (jSONArrayM7393o != null && !TextUtils.isEmpty(jSONArrayM7393o.toString())) {
                jSONObject.put("socID", jSONArrayM7393o);
                return;
            }
            C13981a.m83988e("ChallengeReport", "socId is empty");
        } catch (JSONException unused) {
            C13981a.m83988e("ChallengeReport", "processSocId exception");
        }
    }
}
