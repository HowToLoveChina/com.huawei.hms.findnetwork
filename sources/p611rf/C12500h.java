package p611rf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4348f;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p292fn.C9733f;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11870c;
import p521og.C11881n;
import p575qe.C12347f;
import p616rk.C12515a;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: rf.h */
/* loaded from: classes4.dex */
public class C12500h {

    /* renamed from: a */
    public String f57561a;

    /* renamed from: b */
    public int f57562b;

    /* renamed from: c */
    public String f57563c;

    /* renamed from: d */
    public String f57564d;

    /* renamed from: e */
    public Context f57565e;

    /* renamed from: f */
    public Handler.Callback f57566f;

    /* renamed from: g */
    public boolean f57567g;

    /* renamed from: h */
    public int f57568h;

    /* renamed from: i */
    public boolean f57569i = false;

    /* renamed from: j */
    public int f57570j = 5;

    /* renamed from: k */
    public String[] f57571k = {"00:00:00"};

    /* renamed from: l */
    public String[] f57572l = {"00:03:00"};

    /* renamed from: m */
    public boolean f57573m;

    /* renamed from: rf.h$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, InterruptedException {
            boolean z10 = 1 == C12500h.this.f57568h;
            if (z10) {
                C12500h.this.m75048r();
                if (C11881n.m71340C(C12500h.this.f57571k, C12500h.this.f57572l)) {
                    C12500h.this.m75044n();
                }
            }
            String strM75046p = C12500h.this.m75046p();
            int i10 = C12500h.this.f57568h == 4 ? 3109 : SNSCode.Status.GET_USER_UNREAD_MSG_FAIL;
            String strM76774a = C12797b.m76774a(String.valueOf(i10));
            C4348f c4348f = new C4348f(C12500h.this.f57565e, "", strM76774a, strM75046p, i10, C12500h.this.f57561a, String.valueOf(C12500h.this.f57562b), C12500h.this.f57569i, null);
            C13981a.m83987d("QueryDeviceActive", "doQuery, siteError:" + C12500h.this.f57567g + ", traceId: " + strM76774a + ", sceneCode: " + C12500h.this.f57568h);
            RequestModeConfig.getInstance().setMode(Integer.valueOf(i10), z10 ^ true);
            C4346d.m26227f(SNSCode.Status.GET_USER_UNREAD_MSG_FAIL, strM75046p, C12500h.this.f57566f, C12500h.this.f57565e, strM76774a, c4348f);
        }
    }

    public C12500h(String str, int i10, Handler.Callback callback, boolean z10, int i11) {
        Context contextM74301m = C12347f.m74285n().m74301m();
        this.f57565e = contextM74301m;
        this.f57561a = str;
        this.f57562b = i10;
        this.f57563c = AbstractC12139d.m72766e(contextM74301m).getServiceToken();
        this.f57566f = callback;
        this.f57564d = AbstractC12139d.m72766e(this.f57565e).getDeviceTicket();
        this.f57567g = z10;
        this.f57568h = i11;
    }

    /* renamed from: m */
    public final void m75043m(JSONObject jSONObject) throws JSONException {
        if (this.f57568h == 4) {
            C13981a.m83989i("QueryDeviceActive", "query other device");
            return;
        }
        try {
            JSONArray jSONArrayM71116o = C11866p.m71116o();
            if (jSONArrayM71116o != null) {
                C13981a.m83989i("QueryDeviceActive", "encaseQueryInfo add socId");
                if (this.f57573m) {
                    String strM7394p = C1175a.m7394p();
                    if (C11870c.m71157e(strM7394p)) {
                        jSONObject.put("socIdOrigin", strM7394p);
                    }
                } else if (jSONArrayM71116o.length() != 0 && !TextUtils.isEmpty(jSONArrayM71116o.toString())) {
                    jSONObject.put("socID", jSONArrayM71116o);
                }
                if (TextUtils.isEmpty(this.f57561a) || TextUtils.isEmpty(this.f57564d)) {
                    this.f57569i = true;
                }
                if (!TextUtils.isEmpty(this.f57561a) && !C11870c.m71156d(this.f57561a)) {
                    C13981a.m83988e("QueryDeviceActive", "doQueryDeviceActive, deviceId is not string");
                    this.f57569i = true;
                }
                C11860j.m71002J0("SCENE_CODE_QUERY_SOC_ID", "QueryActiveStatus", "sceneCode is query socId", "");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("QueryDeviceActive", "addSocIdInfo exception");
        }
    }

    /* renamed from: n */
    public final void m75044n() throws InterruptedException {
        int iNextInt = new Random().nextInt(this.f57570j * 60);
        C13981a.m83989i("QueryDeviceActive", "doDelay: " + iNextInt);
        if (iNextInt > 0) {
            try {
                Thread.sleep(iNextInt * 1000);
            } catch (InterruptedException unused) {
                C13981a.m83988e("QueryDeviceActive", "doDelay InterruptedException");
            }
        }
    }

    /* renamed from: o */
    public void m75045o() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: p */
    public final String m75046p() throws JSONException {
        int i10;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceID", this.f57561a);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f57562b);
            jSONObject.put("serviceToken", C11870c.m71155c(this.f57563c));
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f57564d));
            jSONObject.put("appType", 2);
            jSONObject.put("version", "v11");
            m75043m(jSONObject);
            if (C11860j.m71031Y()) {
                String countryCode = AbstractC12139d.m72766e(this.f57565e).getCountryCode();
                String strM80942m = C13452e.m80781L().m80942m();
                C13981a.m83987d("QueryDeviceActive", "localCountryCode: " + countryCode + ", countryCode: " + strM80942m);
                i10 = !TextUtils.equals(strM80942m, countryCode) ? 1 : 0;
            } else {
                i10 = 0;
            }
            jSONObject.put("visitType", i10);
            C13981a.m83989i("QueryDeviceActive", "visitType: " + i10);
            if (this.f57568h == 4) {
                jSONObject.put("queryType", 1);
            } else {
                jSONObject.put("queryType", 0);
            }
            jSONObject.put("params", m75047q());
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("QueryDeviceActive", "encaseDeviceInfo failed! JSONException");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: q */
    public final JSONArray m75047q() {
        JSONArray jSONArray = new JSONArray();
        switch (this.f57568h) {
            case 1:
                jSONArray.put(NetworkService.Constants.CONFIG_SERVICE);
                jSONArray.put("perDeviceList");
                jSONArray.put("offlineStatus");
                jSONArray.put("cmacKey");
                jSONArray.put("locationRouter");
                jSONArray.put("publicKey");
                return jSONArray;
            case 2:
                jSONArray.put(NetworkService.Constants.CONFIG_SERVICE);
                jSONArray.put("perDeviceList");
                jSONArray.put("active");
                jSONArray.put("offlineStatus");
                jSONArray.put("cmacKey");
                jSONArray.put("LocationShareStatus");
                jSONArray.put("locationRouter");
                jSONArray.put("activationLockCredential");
                jSONArray.put("publicKey");
                return jSONArray;
            case 3:
                jSONArray.put(NetworkService.Constants.CONFIG_SERVICE);
                jSONArray.put("active");
                jSONArray.put("unbandingCode");
                jSONArray.put("xyFlag");
                jSONArray.put("accountInfo");
                jSONArray.put("publicKey");
                return jSONArray;
            case 4:
                jSONArray.put("active");
                return jSONArray;
            case 5:
            case 9:
                jSONArray.put("active");
                jSONArray.put(NetworkService.Constants.CONFIG_SERVICE);
                jSONArray.put("xyFlag");
                jSONArray.put("accountInfo");
                jSONArray.put("unbandingCode");
                jSONArray.put("lostPatternFlag");
                jSONArray.put("pkExist");
                jSONArray.put("deviceId");
                jSONArray.put("parentUid");
                jSONArray.put("parentAccountName");
                jSONArray.put(HwPayConstant.KEY_SITE_ID);
                jSONArray.put("domainName");
                jSONArray.put(JsbMapKeyNames.H5_USER_ID);
                jSONArray.put(JsbMapKeyNames.H5_DEVICE_TYPE);
                jSONArray.put("locationRouter");
                jSONArray.put("activationLockCredential");
                jSONArray.put("publicKey");
                return jSONArray;
            case 6:
                jSONArray.put("lockScrChallenge");
                return jSONArray;
            case 7:
                jSONArray.put("active");
                jSONArray.put("parentUid");
                jSONArray.put("parentAccountName");
                jSONArray.put(HwPayConstant.KEY_SITE_ID);
                jSONArray.put("deviceId");
                jSONArray.put(JsbMapKeyNames.H5_USER_ID);
                jSONArray.put(JsbMapKeyNames.H5_DEVICE_TYPE);
                jSONArray.put("accountInfo");
                jSONArray.put("activationLockCredential");
                return jSONArray;
            case 8:
                jSONArray.put("active");
                jSONArray.put(JsbMapKeyNames.H5_USER_ID);
                jSONArray.put("activationLockCredential");
                return jSONArray;
            default:
                return jSONArray;
        }
    }

    /* renamed from: r */
    public final void m75048r() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C13981a.m83988e("QueryDeviceActive", "parse peak time, param map is empty");
            return;
        }
        String phoneCentralTime = hiCloudSysParamMapM60757p.getPhoneCentralTime();
        if (TextUtils.isEmpty(phoneCentralTime)) {
            C13981a.m83988e("QueryDeviceActive", "phone central time string is empty");
            return;
        }
        String strTrim = phoneCentralTime.trim();
        C13981a.m83987d("QueryDeviceActive", "doDelay timeString: " + strTrim);
        this.f57570j = hiCloudSysParamMapM60757p.getPhoneCentralRandomMin();
        C13981a.m83989i("QueryDeviceActive", "doDelay delayBound: " + this.f57570j);
        String[] strArrSplit = strTrim.split(",");
        this.f57571k = new String[strArrSplit.length];
        this.f57572l = new String[strArrSplit.length];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault());
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                String[] strArrSplit2 = strArrSplit[i10].split("/");
                String str = strArrSplit2[0] + ":00";
                String str2 = simpleDateFormat.format(new Date(simpleDateFormat.parse(str).getTime() + (((strArrSplit2.length < 2 || strArrSplit2[1].isEmpty()) ? 5 : C0241z.m1685c(strArrSplit2[1])) * 60000)));
                this.f57571k[i10] = str;
                this.f57572l[i10] = str2;
            } catch (Exception e10) {
                C13981a.m83988e("QueryDeviceActive", "parsePeakTime exception: " + e10.getMessage());
                return;
            }
        }
    }

    /* renamed from: s */
    public void m75049s(boolean z10) {
        this.f57573m = z10;
    }
}
