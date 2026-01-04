package com.huawei.hicloud.service;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.model.response.SMSLoginResp;
import com.huawei.hicloud.model.response.SMSRefreshResp;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0228m0;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p758x0.C13675b;
import p758x0.SharedPreferencesC13674a;
import tn.InterfaceC13043a;

/* renamed from: com.huawei.hicloud.service.e0 */
/* loaded from: classes.dex */
public class C5009e0 {

    /* renamed from: e */
    public static volatile SharedPreferences f22862e;

    /* renamed from: f */
    public static final C5009e0 f22863f = new C5009e0();

    /* renamed from: a */
    public String f22864a = "";

    /* renamed from: b */
    public String f22865b;

    /* renamed from: c */
    public long f22866c;

    /* renamed from: d */
    public long f22867d;

    /* renamed from: e */
    public static C5009e0 m30044e() {
        if (f22862e == null) {
            synchronized (C5009e0.class) {
                if (f22862e == null) {
                    try {
                        f22862e = SharedPreferencesC13674a.m82258a(AccountConstant.ATInfo.SP_NAME, C13675b.m82273c(C13675b.f61594a), C0213f.m1377a(), SharedPreferencesC13674a.d.AES256_SIV, SharedPreferencesC13674a.e.AES256_GCM);
                        BaseLogger.m28733i("SMSAtManager", "getInstance create atSp");
                    } catch (Exception e10) {
                        BaseLogger.m28735w("SMSAtManager", "getInstance exception: " + e10.getMessage());
                        f22862e = null;
                    }
                }
            }
        }
        return f22863f;
    }

    /* renamed from: l */
    public static void m30045l(String str, String str2) {
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07056"), str2, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u(String.valueOf(2));
            c11060cM66626a.m66635A(str);
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060cM66626a, null);
        }
    }

    /* renamed from: a */
    public void m30046a(String str) {
        if (TextUtils.isEmpty(str)) {
            BaseLogger.m28733i("SMSAtManager", "clearAtExpireTime oldAccessToken is empty!");
            return;
        }
        if (str.equals(this.f22865b)) {
            BaseLogger.m28733i("SMSAtManager", "clearAtExpireTime this Token is already invalid!");
            return;
        }
        m30045l(AccountConstant.Cmd.CLEAR_AT_EXPIRE_TIME, AccountConstant.Cmd.CLEAR_AT_EXPIRE_TIME);
        this.f22865b = str;
        this.f22866c = 0L;
        if (f22862e == null) {
            BaseLogger.m28731e("SMSAtManager", "encryptSMSLoginInfo error, atSp is null");
        } else {
            f22862e.edit().putLong("atExpireTime", 0L).commit();
            BaseLogger.m28733i("SMSAtManager", "clearAtExpireTime ");
        }
    }

    /* renamed from: b */
    public void m30047b(String str) {
        if (f22862e != null) {
            this.f22865b = "";
            this.f22864a = "";
            f22862e.edit().clear().commit();
            BaseLogger.m28733i("SMSAtManager", "clearSMSInfo ");
        } else {
            BaseLogger.m28731e("SMSAtManager", "clearSMSInfo error, atSp is null");
        }
        m30045l("clearSMSInfo_entryType=" + str, AccountConstant.Cmd.CLEAR_SMS_INFO);
    }

    /* renamed from: c */
    public void m30048c(SMSLoginResp sMSLoginResp) {
        String strM68634d;
        String accessToken = sMSLoginResp.getAccessToken();
        if (TextUtils.isEmpty(accessToken)) {
            strM68634d = "";
        } else {
            this.f22864a = accessToken;
            strM68634d = C11477c.m68634d(accessToken);
        }
        long atExpireTime = sMSLoginResp.getAtExpireTime();
        this.f22866c = atExpireTime;
        String strM68634d2 = C11477c.m68634d(sMSLoginResp.getSessionID());
        long sessionExpireTime = sMSLoginResp.getSessionExpireTime();
        this.f22867d = sessionExpireTime;
        String strM68634d3 = C11477c.m68634d(sMSLoginResp.getSinKey());
        BaseLogger.m28733i("SMSAtManager", "encryptSMSLoginInfo success");
        if (f22862e != null) {
            f22862e.edit().putString("accessToken", strM68634d).commit();
            f22862e.edit().putLong("atExpireTime", atExpireTime).commit();
            f22862e.edit().putString("sessionId", strM68634d2).commit();
            f22862e.edit().putLong("sessionExpireTime", sessionExpireTime).commit();
            f22862e.edit().putString("sinKey", strM68634d3).commit();
        } else {
            BaseLogger.m28731e("SMSAtManager", "encryptSMSLoginInfo error, atSp is null");
        }
        m30045l("encryptSMSLoginInfo  atExpireTime =" + atExpireTime + ";sessionExpireTime =" + sessionExpireTime + ";encryptAccessToken isEmpty =" + TextUtils.isEmpty(strM68634d) + ";sessionId isEmpty =" + TextUtils.isEmpty(strM68634d2) + " ;sinKey isEmpty =" + TextUtils.isEmpty(strM68634d3), AccountConstant.Cmd.ENCRYPT_SMS_LOGIN_INFO);
    }

    /* renamed from: d */
    public void m30049d(SMSRefreshResp sMSRefreshResp) {
        if (sMSRefreshResp == null) {
            BaseLogger.m28731e("SMSAtManager", "encryptSMSRefreshInfo error, smsRefreshResp is null");
            return;
        }
        String accessToken = sMSRefreshResp.getAccessToken();
        if (TextUtils.isEmpty(accessToken)) {
            BaseLogger.m28731e("SMSAtManager", "encryptSMSRefreshInfo error, accessToken is null");
            return;
        }
        this.f22864a = accessToken;
        BaseLogger.m28733i("SMSAtManager", "encryptSMSRefreshInfo success");
        String strM68634d = C11477c.m68634d(accessToken);
        long atExpireTime = sMSRefreshResp.getAtExpireTime();
        this.f22866c = atExpireTime;
        if (f22862e == null) {
            BaseLogger.m28731e("SMSAtManager", "encryptSMSRefreshInfo error, atSp is null");
        } else {
            f22862e.edit().putString("accessToken", strM68634d).commit();
            f22862e.edit().putLong("atExpireTime", atExpireTime).commit();
        }
    }

    /* renamed from: f */
    public String m30050f() {
        if (!TextUtils.isEmpty(this.f22864a)) {
            return this.f22864a;
        }
        if (f22862e != null) {
            String string = f22862e.getString("accessToken", "");
            if (!TextUtils.isEmpty(string)) {
                String strM68631a = C11477c.m68631a(string);
                if (!TextUtils.isEmpty(strM68631a)) {
                    this.f22864a = strM68631a;
                    return strM68631a;
                }
            }
        } else {
            BaseLogger.m28731e("SMSAtManager", "getSMSAccessToken error, atSp is null or isAtExpired");
        }
        BaseLogger.m28735w("SMSAtManager", "accessToken is null");
        return "";
    }

    /* renamed from: g */
    public String m30051g() {
        if (f22862e != null) {
            String string = f22862e.getString("sessionId", "");
            return !TextUtils.isEmpty(string) ? C11477c.m68631a(string) : "";
        }
        BaseLogger.m28731e("SMSAtManager", "getSMSSessionId error, atSp is null");
        return "";
    }

    /* renamed from: h */
    public String m30052h() {
        if (f22862e != null) {
            String string = f22862e.getString("sinKey", "");
            return !TextUtils.isEmpty(string) ? C11477c.m68631a(string) : "";
        }
        BaseLogger.m28731e("SMSAtManager", "getSMSSinKey error, atSp is null");
        return "";
    }

    /* renamed from: i */
    public String m30053i() {
        StringBuilder sb2 = new StringBuilder();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        if (strM80970t.equals("6")) {
            strM80954p = C0228m0.m1597b().m1599c();
        } else if (strM80970t.equals("9")) {
            strM80954p = C0209d.m1324x0();
        } else if (strM80970t.equals("11")) {
            strM80954p = C13452e.m80781L().m80954p();
        }
        String strM30052h = m30052h();
        long jCurrentTimeMillis = System.currentTimeMillis();
        sb2.append(jCurrentTimeMillis);
        sb2.append(strM80971t0);
        sb2.append("10055832");
        sb2.append(strM80954p);
        String strM1595h = C0227m.m1595h(sb2.toString(), strM30052h);
        if (TextUtils.isEmpty(strM1595h)) {
            BaseLogger.m28735w("SMSAtManager", "hash is null");
            m30045l("getSignature hash is null", AccountConstant.Cmd.GET_SIGNATURE);
            return "";
        }
        return "v1:" + jCurrentTimeMillis + ":" + strM1595h;
    }

    /* renamed from: j */
    public boolean m30054j() {
        if (f22862e != null) {
            this.f22866c = f22862e.getLong("atExpireTime", 0L);
        }
        long jCurrentTimeMillis = this.f22866c - System.currentTimeMillis();
        BaseLogger.m28733i("SMSAtManager", "atExpireTimeCache = " + this.f22866c + " , intervalTime = " + jCurrentTimeMillis);
        if (jCurrentTimeMillis <= 300000) {
            return true;
        }
        BaseLogger.m28729d("SMSAtManager", "isAtExpired is false");
        return false;
    }

    /* renamed from: k */
    public boolean m30055k() {
        if (f22862e != null) {
            this.f22867d = f22862e.getLong("sessionExpireTime", 0L);
        } else {
            BaseLogger.m28731e("SMSAtManager", "isSessinIdExpired error, atSp is null");
        }
        long jCurrentTimeMillis = this.f22867d - System.currentTimeMillis();
        BaseLogger.m28733i("SMSAtManager", "sessionExpireTimeCache = " + this.f22867d + " , intervalTime = " + jCurrentTimeMillis);
        if (jCurrentTimeMillis <= 300000) {
            return true;
        }
        BaseLogger.m28729d("SMSAtManager", "isSessinIdExpired is false");
        return false;
    }
}
