package p611rf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import eg.AbstractC9478g;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p520of.C11860j;
import p521og.C11870c;
import p521og.C11873f;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;
import ug.C13172b;

/* renamed from: rf.g */
/* loaded from: classes4.dex */
public class C12499g {

    /* renamed from: a */
    public String f57544a;

    /* renamed from: b */
    public String f57545b;

    /* renamed from: c */
    public String f57546c;

    /* renamed from: d */
    public int f57547d;

    /* renamed from: e */
    public String f57548e;

    /* renamed from: f */
    public String f57549f;

    /* renamed from: g */
    public String f57550g;

    /* renamed from: h */
    public Handler.Callback f57551h;

    /* renamed from: i */
    public int f57552i;

    /* renamed from: j */
    public String f57553j;

    /* renamed from: k */
    public Context f57554k;

    /* renamed from: l */
    public int f57555l;

    /* renamed from: m */
    public String f57556m;

    /* renamed from: n */
    public int f57557n;

    /* renamed from: o */
    public String f57558o;

    /* renamed from: p */
    public LinkedHashMap<String, String> f57559p = new LinkedHashMap<>();

    /* renamed from: rf.g$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            String strM76774a;
            C13981a.m83989i("NormalRegistration", "NormalRegistration doRegist,active:" + C12499g.this.f57552i);
            String strM75026g = C12499g.this.m75026g();
            if (C12499g.this.f57552i == 1) {
                strM76774a = C11873f.m71178f().m71182d().get("activetrue");
                C11873f.m71178f().m71179a(true);
            } else {
                strM76774a = C12797b.m76774a("01012");
                C11873f.m71178f().m71182d().put("activefalse", strM76774a);
            }
            String str = strM76774a;
            RequestModeConfig.getInstance().setMode(Integer.valueOf(SNSCode.Status.GET_GROUP_LIST_FAIL), true);
            C4346d.m26226e(SNSCode.Status.GET_GROUP_LIST_FAIL, strM75026g, C12499g.this.f57551h, C12499g.this.f57554k, str);
            C12796a c12796a = new C12796a();
            String str2 = 1 == C12499g.this.f57552i ? "01011" : "01012";
            c12796a.m76772e(C12499g.this.f57554k, "NormalRegistration", str2, "success", str2, str2, str, "report request active", C12499g.this.f57559p);
        }
    }

    public C12499g(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, int i11, Handler.Callback callback, Context context, int i12, String str8, String str9) {
        this.f57544a = str;
        this.f57545b = str2;
        this.f57546c = str3;
        this.f57547d = i10;
        this.f57548e = str4;
        this.f57549f = str5;
        this.f57550g = str6;
        this.f57551h = callback;
        this.f57552i = i11;
        this.f57553j = str7;
        this.f57554k = context;
        this.f57555l = i12;
        this.f57556m = str8;
        this.f57558o = str9;
    }

    /* renamed from: f */
    public void m75025f() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: g */
    public final String m75026g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f57544a;
            if (str != null) {
                jSONObject.put("pushToken", str);
            } else {
                C13981a.m83989i("NormalRegistration", "encaseRegistInfo->devicetoken is null");
            }
            jSONObject.put("deviceID", this.f57545b);
            if (1 == this.f57552i) {
                jSONObject.put("deviceID_Alias", this.f57546c);
                jSONObject.put("accountName", AbstractC12139d.m72766e(this.f57554k).getAccountName());
                if (!TextUtils.isEmpty(this.f57550g) && C0209d.m1301r1(this.f57554k)) {
                    jSONObject.put("pk", this.f57550g);
                    C13981a.m83989i("NormalRegistration", "has publicKey");
                    this.f57559p.put("has publicKey", FaqConstants.DISABLE_HA_REPORT);
                }
                if (!C1175a.m7385g(true)) {
                    if (!TextUtils.isEmpty(this.f57558o)) {
                        jSONObject.put("lockVer", this.f57558o);
                        this.f57559p.put("lockVersion", this.f57558o);
                    }
                    int iM71003K = C11860j.m71003K();
                    jSONObject.put("antiRollBackFlag", iM71003K);
                    this.f57559p.put("rollbackFlag", String.valueOf(iM71003K));
                    C13981a.m83989i("NormalRegistration", "rollbackFlag:" + iM71003K + ",lockVersion:" + this.f57558o);
                }
            }
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f57547d);
            jSONObject.put("serviceToken", C11870c.m71155c(this.f57548e));
            jSONObject.put("version", this.f57549f);
            jSONObject.put("active", this.f57552i);
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f57556m));
            String str2 = this.f57553j;
            if (str2 == null || str2.isEmpty()) {
                C13981a.m83988e("NormalRegistration", "encaseRegistInfo->simSn is null or empty");
            } else {
                jSONObject.put("simSn", this.f57553j);
            }
            Context context = this.f57554k;
            if (context == null || !"com.huawei.hidisk".equals(context.getPackageName())) {
                Context context2 = this.f57554k;
                if (context2 == null || !"com.huawei.android.ds".equals(context2.getPackageName())) {
                    jSONObject.put("appType", 1);
                } else {
                    jSONObject.put("appType", 0);
                }
            } else {
                jSONObject.put("appType", 2);
            }
            jSONObject.put("capability", m75027h());
            jSONObject.put("accountType", AbstractC12139d.m72766e(this.f57554k).getAccountType());
            JSONArray jSONArrayM75030k = m75030k();
            jSONObject.put("socID", jSONArrayM75030k);
            this.f57559p.put("socid size", jSONArrayM75030k == null ? "null" : String.valueOf(jSONArrayM75030k.length()));
            jSONObject.put("sceneId", this.f57557n);
            m75029j(this.f57552i, jSONObject);
            m75028i(jSONObject);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C13981a.m83988e("NormalRegistration", "encaseDeviceInfo failed! Exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public final JSONArray m75027h() {
        JSONArray jSONArray = new JSONArray();
        if (C13172b.m79212h(1, this.f57555l)) {
            jSONArray.put("alarm");
        }
        if (C13172b.m79212h(0, this.f57555l)) {
            jSONArray.put("locate");
        }
        if (C13172b.m79212h(2, this.f57555l)) {
            jSONArray.put("clear");
        }
        if (C13172b.m79212h(3, this.f57555l)) {
            jSONArray.put("lockScreen");
        }
        if (C13172b.m79212h(5, this.f57555l)) {
            jSONArray.put("lockSdcard");
        }
        if (C13172b.m79212h(6, this.f57555l)) {
            jSONArray.put("lostPattern");
        }
        if (C13172b.m79212h(8, this.f57555l)) {
            jSONArray.put("endpointCrypted");
        }
        if (C13172b.m79212h(7, this.f57555l)) {
            jSONArray.put("trackreport");
        }
        return jSONArray;
    }

    /* renamed from: i */
    public final void m75028i(JSONObject jSONObject) throws JSONException {
        int iM71005L = C11860j.m71005L();
        C13981a.m83989i("NormalRegistration", "phone finder client action:" + iM71005L);
        jSONObject.put("clientAction", iM71005L);
    }

    /* renamed from: j */
    public final void m75029j(int i10, JSONObject jSONObject) throws JSONException {
        if (i10 == 1) {
            return;
        }
        int iM71011O = C11860j.m71011O();
        C13981a.m83989i("NormalRegistration", "phone finder close type:" + iM71011O);
        jSONObject.put("inActiveType", iM71011O);
    }

    /* renamed from: k */
    public final JSONArray m75030k() {
        boolean zM7385g = C1175a.m7385g(1 == this.f57552i);
        C13981a.m83989i("NormalRegistration", "processSocIdAndSceneId has auth flag:" + zM7385g);
        this.f57559p.put("hasAuthFlag", String.valueOf(zM7385g));
        JSONArray jSONArrayM7393o = zM7385g ? null : C1175a.m7393o();
        if (this.f57552i == 0) {
            JSONArray jSONArray = TextUtils.isEmpty(this.f57558o) ? null : jSONArrayM7393o;
            this.f57557n = (jSONArray == null || jSONArray.length() == 0) ? 3 : 4;
            return jSONArray;
        }
        if (jSONArrayM7393o == null || TextUtils.isEmpty(jSONArrayM7393o.toString())) {
            this.f57557n = 0;
            return null;
        }
        this.f57557n = 1;
        return jSONArrayM7393o;
    }
}
