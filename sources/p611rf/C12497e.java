package p611rf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p520of.C11860j;
import p521og.C11870c;
import p521og.C11873f;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;

/* renamed from: rf.e */
/* loaded from: classes4.dex */
public class C12497e {

    /* renamed from: a */
    public final boolean f57537a;

    /* renamed from: b */
    public final String f57538b;

    /* renamed from: c */
    public final Handler.Callback f57539c;

    /* renamed from: d */
    public final Context f57540d = C12347f.m74285n().m74301m();

    /* renamed from: e */
    public LinkedHashMap<String, String> f57541e = new LinkedHashMap<>();

    /* renamed from: rf.e$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            String strM76774a = C12797b.m76774a("01012");
            C13981a.m83989i("DeNormalRegistrationV3", "deRegister, traceID:" + strM76774a);
            String strM75012h = C12497e.this.m75012h();
            C11873f.m71178f().m71182d().put("activefalse", strM76774a);
            RequestModeConfig.getInstance().setMode(Integer.valueOf(SNSCode.Status.GET_GROUP_LIST_FAIL), true);
            C4346d.m26226e(SNSCode.Status.GET_GROUP_LIST_FAIL, strM75012h, C12497e.this.f57539c, C12497e.this.f57540d, strM76774a);
            C12796a c12796a = new C12796a();
            C12497e.this.f57541e.put("is vt", String.valueOf(C12497e.this.f57537a));
            C12497e.this.f57541e.put("vtOrChallenge is empty", String.valueOf(TextUtils.isEmpty(C12497e.this.f57538b)));
            c12796a.m76772e(C12497e.this.f57540d, "DeNormalRegistrationV3", "01012", "success", "01012", "01012", strM76774a, "report request inactiveV3", C12497e.this.f57541e);
        }
    }

    public C12497e(boolean z10, String str, Handler.Callback callback) {
        this.f57537a = z10;
        this.f57538b = str;
        this.f57539c = callback;
    }

    /* renamed from: g */
    public void m75011g() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: h */
    public final String m75012h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String deviceID = AbstractC12139d.m72766e(this.f57540d).getDeviceID();
        String deviceType = AbstractC12139d.m72766e(this.f57540d).getDeviceType();
        String serviceToken = AbstractC12139d.m72766e(this.f57540d).getServiceToken();
        String deviceTicket = AbstractC12139d.m72766e(this.f57540d).getDeviceTicket();
        String accountType = AbstractC12139d.m72766e(this.f57540d).getAccountType();
        try {
            jSONObject.put("deviceID", deviceID);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, deviceType);
            jSONObject.put("serviceToken", C11870c.m71155c(serviceToken));
            jSONObject.put("version", "v11");
            jSONObject.put("active", 0);
            jSONObject.put("deviceTicket", C11870c.m71153a(deviceTicket));
            if ("com.huawei.hidisk".equals(this.f57540d.getPackageName())) {
                jSONObject.put("appType", 2);
            } else if ("com.huawei.android.ds".equals(this.f57540d.getPackageName())) {
                jSONObject.put("appType", 0);
            } else {
                jSONObject.put("appType", 1);
            }
            jSONObject.put("accountType", accountType);
            int iM71011O = C11860j.m71011O();
            C13981a.m83989i("DeNormalRegistrationV3", "phone finder close type:" + iM71011O);
            jSONObject.put("inActiveType", iM71011O);
            int iM71005L = C11860j.m71005L();
            C13981a.m83989i("DeNormalRegistrationV3", "phone finder client action:" + iM71005L);
            if (iM71005L == 500 || iM71005L == 501) {
                iM71005L = -1;
            }
            jSONObject.put("clientAction", iM71005L);
            if (this.f57537a) {
                jSONObject.put("verifyToken", this.f57538b);
                C13981a.m83989i("DeNormalRegistrationV3", "is vt");
            } else {
                jSONObject.put("lockScrNumSign", this.f57538b);
            }
            jSONObject.put("socID", m75013i());
            return jSONObject.toString();
        } catch (JSONException e10) {
            C13981a.m83988e("DeNormalRegistrationV3", "encaseDeviceInfo failed! Exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    public final JSONArray m75013i() {
        boolean zM7385g = C1175a.m7385g(false);
        C13981a.m83989i("DeNormalRegistrationV3", "getSocId has auth flag:" + zM7385g);
        this.f57541e.put("hasAuthFlag", String.valueOf(zM7385g));
        JSONArray jSONArrayM7393o = zM7385g ? null : C1175a.m7393o();
        if (jSONArrayM7393o == null || TextUtils.isEmpty(jSONArrayM7393o.toString())) {
            this.f57541e.put("socid length:", "null");
            return null;
        }
        String strValueOf = String.valueOf(jSONArrayM7393o.length());
        C13981a.m83989i("DeNormalRegistrationV3", "getSocId size:" + strValueOf);
        this.f57541e.put("socid length:", strValueOf);
        return jSONArrayM7393o;
    }
}
