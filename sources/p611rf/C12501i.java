package p611rf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4348f;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11870c;
import p575qe.C12347f;
import p577qg.C12354d;
import p616rk.C12515a;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: rf.i */
/* loaded from: classes4.dex */
public class C12501i {

    /* renamed from: a */
    public int f57575a;

    /* renamed from: c */
    public Handler.Callback f57577c;

    /* renamed from: d */
    public String f57578d;

    /* renamed from: h */
    public boolean f57582h;

    /* renamed from: b */
    public Context f57576b = C12347f.m74285n().m74301m();

    /* renamed from: f */
    public String f57580f = C13452e.m80781L().m80950o();

    /* renamed from: e */
    public String f57579e = C13452e.m80781L().m80966s();

    /* renamed from: g */
    public String f57581g = AbstractC12139d.m72766e(this.f57576b).getDeviceTicket();

    /* renamed from: rf.i$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("QueryDeviceActiveCredential", "doQueryActiveCredential");
            String strM76774a = C12797b.m76774a(String.valueOf(3113));
            String strM75058i = C12501i.this.m75058i();
            if (!TextUtils.isEmpty(strM75058i)) {
                C4348f c4348f = new C4348f(C12501i.this.f57576b, "", strM76774a, strM75058i, 3113, C12501i.this.f57580f, String.valueOf(C12501i.this.f57579e), true, C12501i.this.f57578d, true);
                RequestModeConfig.getInstance().setMode(3113, true);
                C4346d.m26227f(3113, strM75058i, C12501i.this.f57577c, C12501i.this.f57576b, strM76774a, c4348f);
            } else {
                C13981a.m83988e("QueryDeviceActiveCredential", "doQueryActiveCredential, data is empty");
                C12354d.m74358x("fail", "doQueryActiveCredential, data is empty. isShowDialog: " + C12501i.this.f57582h);
                C12354d.m74329E(1005, "");
            }
        }
    }

    public C12501i(int i10, String str, boolean z10, Handler.Callback callback) {
        this.f57575a = i10;
        this.f57578d = str;
        this.f57582h = z10;
        this.f57577c = callback;
    }

    /* renamed from: h */
    public void m75057h() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: i */
    public final String m75058i() throws JSONException {
        int i10;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "v11");
            jSONObject.put("appType", 2);
            if (C11860j.m71031Y()) {
                String countryCode = AbstractC12139d.m72766e(this.f57576b).getCountryCode();
                String strM80942m = C13452e.m80781L().m80942m();
                C13981a.m83987d("QueryDeviceActiveCredential", "localCountryCode: " + countryCode + ", countryCode: " + strM80942m);
                i10 = !TextUtils.equals(strM80942m, countryCode) ? 1 : 0;
            } else {
                i10 = 0;
            }
            jSONObject.put("visitType", i10);
            C13981a.m83989i("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, visitType: " + i10);
            if (this.f57575a == 1) {
                JSONArray jSONArrayM71116o = C11866p.m71116o();
                if (jSONArrayM71116o == null || jSONArrayM71116o.length() == 0 || TextUtils.isEmpty(jSONArrayM71116o.toString())) {
                    C13981a.m83988e("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, socId is null");
                    C12354d.m74358x("fail", "QueryDeviceActiveCredential, socId is empty. isShowDialog: " + this.f57582h);
                    return null;
                }
                C13981a.m83989i("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, socId not null");
                jSONObject.put("socID", jSONArrayM71116o);
            }
            if (this.f57575a == 2) {
                String strM7394p = C1175a.m7394p();
                if (!C11870c.m71157e(strM7394p)) {
                    C13981a.m83988e("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, socIdOrigin is empty. isShowDialog: " + this.f57582h);
                    if (this.f57582h) {
                        C12354d.m74334J();
                    }
                    C12354d.m74358x("fail", "QueryDeviceActiveCredential, socIdOrigin is empty. isShowDialog: " + this.f57582h);
                    return null;
                }
                C13981a.m83989i("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, socIdOrigin not null");
                jSONObject.put("socIdOrigin", strM7394p);
            }
            C13981a.m83989i("QueryDeviceActiveCredential", "QueryDeviceActiveCredential, sceneCode: " + this.f57575a);
            jSONObject.put("params", m75059j());
            return jSONObject.toString();
        } catch (JSONException e10) {
            C13981a.m83988e("QueryDeviceActiveCredential", "encaseBodyData JSONException: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: j */
    public final JSONArray m75059j() {
        JSONArray jSONArray = new JSONArray();
        int i10 = this.f57575a;
        if (i10 == 1) {
            jSONArray.put("active");
            jSONArray.put("activationLockCredential");
            jSONArray.put("bypassTimes");
            jSONArray.put(JsbMapKeyNames.H5_USER_ID);
            jSONArray.put("parentUid");
            jSONArray.put("deviceId");
            jSONArray.put(JsbMapKeyNames.H5_DEVICE_TYPE);
            jSONArray.put(HwPayConstant.KEY_SITE_ID);
            jSONArray.put("domainName");
            jSONArray.put("parentAccountName");
            jSONArray.put("accountInfo");
        } else if (i10 == 2) {
            jSONArray.put("active");
            jSONArray.put("activationLockCredential");
            jSONArray.put(JsbMapKeyNames.H5_USER_ID);
            jSONArray.put("accountName");
            jSONArray.put("bypassTimes");
            jSONArray.put(HwPayConstant.KEY_SITE_ID);
            jSONArray.put("domainName");
        }
        return jSONArray;
    }
}
