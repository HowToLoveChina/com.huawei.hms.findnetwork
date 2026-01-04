package p709vj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.LastMemberInfo;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import hu.C10343b;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0211e;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0227m;
import p015ak.C0228m0;
import p399jk.AbstractC10896a;
import p616rk.C12515a;
import p618rm.C12540b1;
import p664u0.C13108a;
import p681uj.C13191h;
import p745wm.C13621b;
import tn.InterfaceC13043a;

@SuppressLint({"ApplySharedPref"})
/* renamed from: vj.e */
/* loaded from: classes5.dex */
public class C13452e {

    /* renamed from: i0 */
    public static final Object f60561i0 = new Object();

    /* renamed from: j0 */
    @SuppressLint({"StaticFieldLeak"})
    public static C13452e f60562j0;

    /* renamed from: A */
    public String f60563A;

    /* renamed from: B */
    public long f60564B;

    /* renamed from: D */
    public String f60566D;

    /* renamed from: E */
    public String f60567E;

    /* renamed from: F */
    public String f60568F;

    /* renamed from: G */
    public String f60569G;

    /* renamed from: H */
    public String f60570H;

    /* renamed from: I */
    public long f60571I;

    /* renamed from: J */
    public long f60572J;

    /* renamed from: K */
    public String f60573K;

    /* renamed from: L */
    public String f60574L;

    /* renamed from: M */
    public boolean f60575M;

    /* renamed from: N */
    public long f60576N;

    /* renamed from: O */
    public boolean f60577O;

    /* renamed from: P */
    public boolean f60578P;

    /* renamed from: Q */
    public String f60579Q;

    /* renamed from: R */
    public String f60580R;

    /* renamed from: S */
    public String f60581S;

    /* renamed from: T */
    public String f60582T;

    /* renamed from: U */
    public int f60583U;

    /* renamed from: V */
    public int f60584V;

    /* renamed from: W */
    public long f60585W;

    /* renamed from: X */
    public String f60586X;

    /* renamed from: Y */
    public String f60587Y;

    /* renamed from: Z */
    public boolean f60588Z;

    /* renamed from: a */
    public SharedPreferences f60589a;

    /* renamed from: b */
    public Context f60591b;

    /* renamed from: c */
    public String f60593c;

    /* renamed from: d */
    public String f60595d;

    /* renamed from: e */
    public String f60597e;

    /* renamed from: f */
    public String f60599f;

    /* renamed from: g */
    public String f60601g;

    /* renamed from: g0 */
    public String f60602g0;

    /* renamed from: h */
    public String f60603h;

    /* renamed from: i */
    public String f60605i;

    /* renamed from: j */
    public String f60606j;

    /* renamed from: l */
    public String f60608l;

    /* renamed from: m */
    public int f60609m;

    /* renamed from: n */
    public int f60610n;

    /* renamed from: o */
    public String f60611o;

    /* renamed from: p */
    public String f60612p;

    /* renamed from: q */
    public String f60613q;

    /* renamed from: r */
    public String f60614r;

    /* renamed from: s */
    public String f60615s;

    /* renamed from: t */
    public String f60616t;

    /* renamed from: u */
    public String f60617u;

    /* renamed from: w */
    public InterfaceC13455h f60619w;

    /* renamed from: x */
    public InterfaceC13043a f60620x;

    /* renamed from: y */
    public String f60621y;

    /* renamed from: z */
    public long f60622z;

    /* renamed from: k */
    public int f60607k = 0;

    /* renamed from: v */
    public String f60618v = "";

    /* renamed from: C */
    public boolean f60565C = true;

    /* renamed from: a0 */
    public int f60590a0 = -1;

    /* renamed from: b0 */
    public long f60592b0 = -1;

    /* renamed from: c0 */
    public boolean f60594c0 = false;

    /* renamed from: d0 */
    public boolean f60596d0 = true;

    /* renamed from: e0 */
    public int f60598e0 = -1;

    /* renamed from: f0 */
    public int f60600f0 = -1;

    /* renamed from: h0 */
    public boolean f60604h0 = false;

    public C13452e(Context context) {
        this.f60591b = context;
        this.f60589a = C0214f0.m1382b(context, "account_info", 0);
    }

    /* renamed from: L */
    public static C13452e m80781L() {
        C13452e c13452e;
        synchronized (f60561i0) {
            try {
                C13452e c13452e2 = f60562j0;
                if (c13452e2 == null || c13452e2.f60591b == null || c13452e2.f60589a == null) {
                    f60562j0 = new C13452e(C0213f.m1377a());
                }
                c13452e = f60562j0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13452e;
    }

    /* renamed from: A */
    public boolean m80782A() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("free_package_available", false);
        }
        return false;
    }

    /* renamed from: A0 */
    public boolean m80783A0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null && sharedPreferences.getBoolean("has_clear_old_sync_risk_flag", false);
    }

    /* renamed from: A1 */
    public void m80784A1(String str) {
        String strM68636f = C11477c.m68636f(str);
        m80855S1(strM68636f);
        this.f60589a.edit().putString("account_name", strM68636f).commit();
        this.f60601g = str;
    }

    /* renamed from: A2 */
    public void m80785A2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("notify_backup_upgrade_flag", str).commit();
        }
    }

    /* renamed from: B */
    public boolean m80786B() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("get_free_package_status", false);
        }
        return false;
    }

    /* renamed from: B0 */
    public boolean m80787B0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null && sharedPreferences.getBoolean("has_clear_st_old_invalid_flag", false);
    }

    /* renamed from: B1 */
    public void m80788B1(String str) {
        this.f60589a.edit().putString("accountType", str).commit();
        this.f60605i = str;
    }

    /* renamed from: B2 */
    public void m80789B2(String str) {
        this.f60617u = str;
    }

    /* renamed from: C */
    public String m80790C() {
        if (TextUtils.isEmpty(this.f60566D)) {
            this.f60566D = this.f60589a.getString("CACHED_GRADE_CODE", "");
        }
        return this.f60566D;
    }

    /* renamed from: C0 */
    public boolean m80791C0() {
        return m80887a1() && m80830M0();
    }

    /* renamed from: C1 */
    public void m80792C1(String str) {
        this.f60589a.edit().putString("accountAgeRange", str).commit();
        this.f60606j = str;
    }

    /* renamed from: C2 */
    public void m80793C2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("omExpandHeader", str).commit();
        }
    }

    /* renamed from: D */
    public long m80794D() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60572J = sharedPreferences.getLong("GRADE_CODE_UPDATE_TIME", 0L);
        }
        return this.f60572J;
    }

    /* renamed from: D0 */
    public boolean m80795D0() {
        String strM80910f = m80910f();
        return !TextUtils.isEmpty(strM80910f) && (strM80910f.equals(String.valueOf(1)) || strM80910f.equals(String.valueOf(2)));
    }

    /* renamed from: D1 */
    public void m80796D1(long j10) {
        if (this.f60585W == 0 || j10 == 0) {
            SharedPreferences sharedPreferences = this.f60589a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putLong("at_suppression_begin_time", j10).commit();
            }
            this.f60585W = j10;
        }
    }

    /* renamed from: D2 */
    public void m80797D2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isOnlyPetalOne2Pg", z10).commit();
        }
    }

    /* renamed from: E */
    public int m80798E() {
        SharedPreferences sharedPreferences;
        int i10 = this.f60598e0;
        return (i10 == -1 && (sharedPreferences = this.f60589a) != null) ? sharedPreferences.getInt("gradeState", -1) : i10;
    }

    /* renamed from: E0 */
    public boolean m80799E0() {
        String strM80910f = m80910f();
        return !TextUtils.isEmpty(strM80910f) && strM80910f.equals(String.valueOf(2));
    }

    /* renamed from: E1 */
    public void m80800E1(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("at_suppression_duration", i10).commit();
        }
        this.f60584V = i10;
    }

    /* renamed from: E2 */
    public void m80801E2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("other_operation_has_shown", z10).commit();
        }
    }

    /* renamed from: F */
    public int m80802F() {
        int i10 = this.f60590a0;
        if (i10 != -1) {
            return i10;
        }
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("gradeType", -1);
        }
        return -1;
    }

    /* renamed from: F0 */
    public Boolean m80803F0() {
        return "CN".equals(m80942m()) ? Boolean.TRUE : Boolean.FALSE;
    }

    /* renamed from: F1 */
    public void m80804F1(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("at_suppression_end_time", str).commit();
        }
        this.f60582T = str;
    }

    /* renamed from: F2 */
    public void m80805F2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("other_operation_has_shown_version_code", str).commit();
            this.f60574L = str;
        }
    }

    /* renamed from: G */
    public String m80806G() {
        if (TextUtils.isEmpty(this.f60573K)) {
            this.f60573K = this.f60589a.getString("head_photo_Url", "");
        }
        return this.f60573K;
    }

    /* renamed from: G0 */
    public boolean m80807G0(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    /* renamed from: G1 */
    public void m80808G1(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("at_suppression_rate", i10).commit();
        }
        this.f60583U = i10;
    }

    /* renamed from: G2 */
    public void m80809G2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("register_time_zone", str).commit();
        }
        this.f60586X = str;
    }

    /* renamed from: H */
    public InterfaceC13043a m80810H() {
        return this.f60620x;
    }

    /* renamed from: H0 */
    public boolean m80811H0() {
        return m80802F() == 9;
    }

    /* renamed from: H1 */
    public void m80812H1(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("at_suppression_start_time", str).commit();
        }
        this.f60581S = str;
    }

    /* renamed from: H2 */
    public void m80813H2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("key_register_user_status", str).commit();
        }
        this.f60587Y = str;
    }

    /* renamed from: I */
    public String m80814I() {
        return this.f60567E;
    }

    /* renamed from: I0 */
    public boolean m80815I0() {
        return m80946n() == 0;
    }

    /* renamed from: I1 */
    public void m80816I1(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isAutoPay", z10).commit();
        }
    }

    /* renamed from: I2 */
    public void m80817I2(long j10) {
        this.f60592b0 = j10;
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("serverTime", j10).commit();
        }
    }

    /* renamed from: J */
    public String m80818J() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("honor_new_version_msg_flag", null);
        }
        return null;
    }

    /* renamed from: J0 */
    public boolean m80819J0() {
        return m80946n() == 1;
    }

    /* renamed from: J1 */
    public void m80820J1(boolean z10) {
        this.f60565C = z10;
    }

    /* renamed from: J2 */
    public void m80821J2(String str) {
        this.f60589a.edit().putString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, str).commit();
        this.f60621y = str;
    }

    /* renamed from: K */
    public long m80822K() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60576N = sharedPreferences.getLong("hwid_provider_query_time", 0L);
        }
        return this.f60576N;
    }

    /* renamed from: K0 */
    public boolean m80823K0() {
        return m80946n() == 2;
    }

    /* renamed from: K1 */
    public void m80824K1(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("wish_list", z10);
        editorEdit.putLong("wish_list_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    /* renamed from: K2 */
    public void m80825K2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("SERVICE_COUNTRY_UPDATE_TIME", j10).commit();
        }
        this.f60622z = j10;
    }

    /* renamed from: L0 */
    public boolean m80826L0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences == null) {
            return false;
        }
        boolean z10 = sharedPreferences.getBoolean("enable_auth_code", false);
        AbstractC10896a.m65887i("AccountSetting", "isEnableAuthCode =" + z10);
        return z10;
    }

    /* renamed from: L1 */
    public void m80827L1(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("wish_list_right", z10);
        editorEdit.apply();
    }

    /* renamed from: L2 */
    public void m80828L2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("key_silence_device_last_query_time", j10).commit();
        }
    }

    /* renamed from: M */
    public boolean m80829M() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60577O = sharedPreferences.getBoolean("is_family_share_member", false);
        }
        return this.f60577O;
    }

    /* renamed from: M0 */
    public boolean m80830M0() {
        return C13191h.m79248a().m79250c(m80781L().m80790C());
    }

    /* renamed from: M1 */
    public void m80831M1(String str) {
        AbstractC10896a.m65887i("AccountSetting", "setCountryCode is " + str);
        this.f60589a.edit().putString("contry_code", str).commit();
        this.f60614r = str;
    }

    /* renamed from: M2 */
    public void m80832M2(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("key_silence_device_number", i10).commit();
        }
    }

    /* renamed from: N */
    public boolean m80833N() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60578P = sharedPreferences.getBoolean("is_support_exchange_menu", false);
        }
        return this.f60578P;
    }

    /* renamed from: N0 */
    public boolean m80834N0(String str) {
        return C13191h.m79248a().m79250c(str);
    }

    /* renamed from: N1 */
    public void m80835N1(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("data_over_due_days", i10).commit();
        }
    }

    /* renamed from: N2 */
    public void m80836N2(int i10) {
        this.f60589a.edit().putInt("siteChangeNoticeCount", i10).commit();
        this.f60609m = i10;
    }

    /* renamed from: O */
    public LastMemberInfo m80837O() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return (LastMemberInfo) C12540b1.m75483a(sharedPreferences.getString("lastMemberInfo", this.f60602g0), LastMemberInfo.class);
        }
        return null;
    }

    /* renamed from: O0 */
    public boolean m80838O0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("hasPetalOne2Pg", false);
        }
        return false;
    }

    /* renamed from: O1 */
    public void m80839O1(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("dataPeriod", i10).commit();
        }
        this.f60600f0 = i10;
    }

    /* renamed from: O2 */
    public void m80840O2(int i10) {
        this.f60589a.edit().putInt("site_id", i10).commit();
        this.f60607k = i10;
    }

    /* renamed from: P */
    public String m80841P() {
        String string;
        String str = this.f60613q;
        if ((str == null || str.isEmpty()) && (string = this.f60589a.getString("login_user_name", null)) != null && !string.isEmpty()) {
            String strM68633c = C11477c.m68633c(string);
            this.f60613q = strM68633c;
            if (TextUtils.isEmpty(strM68633c)) {
                AbstractC10896a.m65887i("AccountSetting", "encrypt encryptedLoginUserName not empty ,but decode by keystore is empty");
            }
        }
        return this.f60613q;
    }

    /* renamed from: P0 */
    public boolean m80842P0() {
        return !TextUtils.isEmpty(m80971t0());
    }

    /* renamed from: P1 */
    public void m80843P1(String str) {
        this.f60589a.edit().putString(C6148x2.DEVICE_ID, C11477c.m68636f(str)).commit();
        this.f60597e = str;
    }

    /* renamed from: P2 */
    public void m80844P2(String str) {
        this.f60589a.edit().putString("siteInfo", str).commit();
        this.f60608l = str;
    }

    /* renamed from: Q */
    public String m80845Q() {
        if (TextUtils.isEmpty(this.f60568F)) {
            this.f60568F = this.f60589a.getString("CACHED_RIGHT_CODE_LIST", "");
        }
        return this.f60568F;
    }

    /* renamed from: Q0 */
    public boolean m80846Q0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60575M = sharedPreferences.getBoolean("login_status_error", false);
        }
        return this.f60575M;
    }

    /* renamed from: Q1 */
    public void m80847Q1(String str) {
        this.f60599f = str;
    }

    /* renamed from: Q2 */
    public void m80848Q2(String str) {
        this.f60589a.edit().putString("siteMatchStatus", str).commit();
        this.f60611o = str;
    }

    /* renamed from: R */
    public boolean m80849R() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isMemberFromRegretDay", false);
        }
        return false;
    }

    /* renamed from: R0 */
    public boolean m80850R0() {
        return !TextUtils.isEmpty(this.f60589a.getString("user_id", null));
    }

    /* renamed from: R1 */
    public void m80851R1(String str) {
        this.f60589a.edit().putString("device_type", str).commit();
        this.f60612p = str;
    }

    /* renamed from: R2 */
    public void m80852R2(int i10) {
        this.f60589a.edit().putInt("siteOfflineNoticeCount", i10).commit();
        this.f60610n = i10;
    }

    /* renamed from: S */
    public long m80853S() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("memberRemainDays", -1L);
        }
        return -1L;
    }

    /* renamed from: S0 */
    public boolean m80854S0() {
        return this.f60594c0;
    }

    /* renamed from: S1 */
    public void m80855S1(String str) {
        this.f60603h = str;
    }

    /* renamed from: S2 */
    public void m80856S2(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("spaceShareEnable", i10).commit();
        }
    }

    /* renamed from: T */
    public String m80857T() {
        if (TextUtils.isEmpty(this.f60570H)) {
            this.f60570H = this.f60589a.getString("NEW_BM_GRAY_USER_TAGS_KEY", "");
        }
        return this.f60570H;
    }

    /* renamed from: T0 */
    public boolean m80858T0() {
        return m80887a1() && m80907e1();
    }

    /* renamed from: T1 */
    public void m80859T1(Boolean bool) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("enable_auth_code", bool.booleanValue()).commit();
            AbstractC10896a.m65887i("AccountSetting", "setEnableAuthCode =" + bool);
        }
    }

    /* renamed from: T2 */
    public final void m80860T2(String str) {
        this.f60589a.edit().putString("CACHED_GRADE_CODE", str).commit();
        this.f60566D = str;
        if (this.f60567E == null) {
            m80918g2(str);
        }
    }

    /* renamed from: U */
    public String m80861U() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("NEW_VERSION_MSG_ADD", null);
        }
        return null;
    }

    /* renamed from: U0 */
    public boolean m80862U0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return System.currentTimeMillis() - sharedPreferences.getLong("fromRegretDayTime", 0L) < 86400000;
        }
        return false;
    }

    /* renamed from: U1 */
    public void m80863U1(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("exchange_menu_text", str).commit();
        }
        this.f60579Q = str;
    }

    /* renamed from: U2 */
    public void m80864U2(String str) {
        String strM68636f = C11477c.m68636f(str);
        if (!TextUtils.isEmpty(strM68636f)) {
            this.f60589a.edit().putString("user_id", strM68636f).commit();
        }
        this.f60593c = str;
        m80872W2();
    }

    /* renamed from: V */
    public long m80865V() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60564B = sharedPreferences.getLong("query_no_provider_err_time", 0L);
        }
        return this.f60564B;
    }

    /* renamed from: V0 */
    public boolean m80866V0() {
        if (this.f60589a == null || TextUtils.isEmpty(m80781L().m80971t0())) {
            return false;
        }
        return System.currentTimeMillis() - this.f60589a.getLong("last_fix_invalid_flag_time", 0L) > 86400000;
    }

    /* renamed from: V1 */
    public void m80867V1(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("exchange_menu_text_lan", str).commit();
        }
        this.f60580R = str;
    }

    /* renamed from: V2 */
    public void m80868V2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("user_id_invalid", z10).commit();
        }
    }

    /* renamed from: W */
    public String m80869W() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("notify_backup_upgrade_flag", null);
        }
        return null;
    }

    /* renamed from: W0 */
    public boolean m80870W0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("needShowNewBMIntroduction", false);
        }
        return false;
    }

    /* renamed from: W1 */
    public void m80871W1(boolean z10) {
        this.f60596d0 = z10;
    }

    /* renamed from: W2 */
    public void m80872W2() {
        AbstractC10896a.m65885d("AccountSetting", " setUserIdSha256 start");
        String strM80971t0 = m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            AbstractC10896a.m65887i("AccountSetting", " setUserIdSha256 userid is empty");
        } else {
            this.f60589a.edit().putString("user_id_sha256", C0227m.m1593f(strM80971t0)).commit();
        }
    }

    /* renamed from: X */
    public String m80873X() {
        return this.f60617u;
    }

    /* renamed from: X0 */
    public String m80874X0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null ? sharedPreferences.getString("bmNewUserGuidPage", "") : "";
    }

    /* renamed from: X1 */
    public void m80875X1(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("free_package_available", z10).commit();
        }
    }

    /* renamed from: X2 */
    public final void m80876X2(String str) {
        this.f60589a.edit().putString("USER_TAGS_KEY", str).commit();
        this.f60569G = str;
    }

    /* renamed from: Y */
    public String m80877Y() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("omExpandHeader", null);
        }
        return null;
    }

    /* renamed from: Y0 */
    public String m80878Y0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null ? sharedPreferences.getString("bmFreeUserGuidPage", "") : "";
    }

    /* renamed from: Y1 */
    public void m80879Y1(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("get_free_package_status", z10).commit();
        }
    }

    /* renamed from: Y2 */
    public final void m80880Y2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("USER_TAGS_UPDATE_TIME", j10).commit();
        }
        this.f60571I = j10;
    }

    /* renamed from: Z */
    public boolean m80881Z() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("other_operation_has_shown", false);
        }
        return false;
    }

    /* renamed from: Z0 */
    public String m80882Z0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null ? sharedPreferences.getString("bmPaidUserGuidPage", "") : "";
    }

    /* renamed from: Z1 */
    public void m80883Z1(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("fromRegretDayTime", j10).commit();
        }
    }

    /* renamed from: Z2 */
    public void m80884Z2(String str) {
        this.f60589a.edit().putString("user_type", str).commit();
        this.f60618v = str;
    }

    /* renamed from: a */
    public void m80885a() {
        m80918g2(null);
        if (this.f60589a == null) {
            return;
        }
        AbstractC10896a.m65887i("AccountSetting", "clearAccountSP");
        this.f60589a.edit().clear().commit();
        this.f60593c = null;
        this.f60595d = null;
        this.f60597e = null;
        this.f60601g = null;
        this.f60603h = null;
        this.f60605i = null;
        this.f60607k = 0;
        this.f60612p = null;
        this.f60613q = null;
        this.f60614r = null;
        this.f60616t = null;
        this.f60609m = 0;
        this.f60610n = 0;
        this.f60611o = null;
        this.f60569G = null;
        this.f60566D = null;
        this.f60599f = null;
        this.f60581S = "";
        this.f60582T = "";
        this.f60588Z = false;
        this.f60578P = false;
        this.f60579Q = "";
        this.f60580R = "";
        this.f60583U = -1;
        this.f60584V = -1;
        this.f60585W = 0L;
        C13448a.m80777c().m80778a();
        C0209d.m1294p2(C0213f.m1377a(), "account_sp_clear", 1);
    }

    /* renamed from: a0 */
    public String m80886a0() {
        if (this.f60589a == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.f60574L)) {
            this.f60574L = this.f60589a.getString("other_operation_has_shown_version_code", "");
        }
        return this.f60574L;
    }

    /* renamed from: a1 */
    public boolean m80887a1() {
        if (this.f60588Z) {
            return true;
        }
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("is_bm_type", false);
        }
        return false;
    }

    /* renamed from: a2 */
    public final void m80888a2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("GRADE_CODE_UPDATE_TIME", j10).commit();
        }
        this.f60572J = j10;
    }

    /* renamed from: a3 */
    public void m80889a3() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("wish_list_right_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    /* renamed from: b */
    public void m80890b() {
        C0214f0.m1382b(this.f60591b, "account_info", 0).edit().remove("restore_status").commit();
    }

    /* renamed from: b0 */
    public String m80891b0() {
        return this.f60615s;
    }

    /* renamed from: b1 */
    public boolean m80892b1() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("newUser", false);
        }
        return false;
    }

    /* renamed from: b2 */
    public void m80893b2(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("gradeState", i10).commit();
        }
        this.f60598e0 = i10;
    }

    /* renamed from: b3 */
    public void m80894b3(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("has_clear_old_sync_risk_flag", z10).commit();
        }
    }

    /* renamed from: c */
    public String m80895c() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60563A = sharedPreferences.getString("account_brand", "");
        }
        return this.f60563A;
    }

    /* renamed from: c0 */
    public String m80896c0() {
        return this.f60589a.getString("user_id", null);
    }

    /* renamed from: c1 */
    public boolean m80897c1() {
        return !m80887a1() && m80830M0();
    }

    /* renamed from: c2 */
    public void m80898c2(int i10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("gradeType", i10).commit();
        }
        this.f60590a0 = i10;
    }

    /* renamed from: c3 */
    public void m80899c3(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("has_clear_st_old_invalid_flag", z10).commit();
        }
    }

    /* renamed from: d */
    public String m80900d() {
        String string;
        String str = this.f60601g;
        if ((str == null || str.isEmpty()) && (string = this.f60589a.getString("account_name", null)) != null && !string.isEmpty()) {
            if (this.f60565C) {
                String strM68633c = C11477c.m68633c(string);
                this.f60601g = strM68633c;
                if (TextUtils.isEmpty(strM68633c)) {
                    AbstractC10896a.m65887i("AccountSetting", "accountName is old, aild login");
                    InterfaceC13455h interfaceC13455h = this.f60619w;
                    if (interfaceC13455h != null) {
                        interfaceC13455h.mo81000b(this.f60591b);
                    } else {
                        AbstractC10896a.m65886e("AccountSetting", "mAccountManagerHelper is null");
                    }
                }
            } else {
                AbstractC10896a.m65886e("AccountSetting", "cbc KeyStore not available");
            }
        }
        return this.f60601g;
    }

    /* renamed from: d0 */
    public String m80901d0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60586X = sharedPreferences.getString("register_time_zone", "");
        }
        return this.f60586X;
    }

    /* renamed from: d1 */
    public boolean m80902d1() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isOnlyPetalOne2Pg", false);
        }
        return false;
    }

    /* renamed from: d2 */
    public void m80903d2(String str) {
        this.f60570H = str;
        this.f60589a.edit().putString("NEW_BM_GRAY_USER_TAGS_KEY", str).commit();
    }

    /* renamed from: d3 */
    public void m80904d3(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_fix_invalid_flag_time", j10).commit();
        }
    }

    /* renamed from: e */
    public String m80905e() {
        String str = this.f60605i;
        if (str == null || str.isEmpty()) {
            this.f60605i = this.f60589a.getString("accountType", null);
        }
        return this.f60605i;
    }

    /* renamed from: e0 */
    public String m80906e0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60587Y = sharedPreferences.getString("key_register_user_status", "");
        }
        return this.f60587Y;
    }

    /* renamed from: e1 */
    public boolean m80907e1() {
        return !m80830M0();
    }

    /* renamed from: e2 */
    public void m80908e2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("hasPetalOne2Pg", z10).commit();
        }
    }

    /* renamed from: e3 */
    public void m80909e3(float f10) {
        C0214f0.m1382b(this.f60591b, "account_info", 0).edit().putFloat("restore_progress", f10).commit();
    }

    /* renamed from: f */
    public String m80910f() {
        String str = this.f60606j;
        if (str == null || str.isEmpty()) {
            this.f60606j = this.f60589a.getString("accountAgeRange", "-1");
        }
        return this.f60606j;
    }

    /* renamed from: f0 */
    public float m80911f0() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f60591b, "account_info", 0);
        try {
            return sharedPreferencesM1382b.getFloat("restore_progress", 0.0f);
        } catch (Exception unused) {
            AbstractC10896a.m65888w("AccountSetting", "getRestoreProgress error.");
            return sharedPreferencesM1382b.getInt("restore_progress", 0);
        }
    }

    /* renamed from: f1 */
    public boolean m80912f1() {
        return (this.f60589a == null || TextUtils.isEmpty(m80955p0())) ? false : true;
    }

    /* renamed from: f2 */
    public void m80913f2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("head_photo_Url", str).commit();
        }
        this.f60573K = str;
    }

    /* renamed from: f3 */
    public void m80914f3(int i10) {
        AbstractC10896a.m65885d("AccountSetting", "writeRestoreStatus status = " + i10);
        C0214f0.m1382b(this.f60591b, "account_info", 0).edit().putInt("restore_status", i10).commit();
    }

    /* renamed from: g */
    public long m80915g() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60585W = sharedPreferences.getLong("at_suppression_begin_time", 0L);
        }
        return this.f60585W;
    }

    /* renamed from: g0 */
    public int m80916g0() {
        return C0214f0.m1382b(this.f60591b, "account_info", 0).getInt("restore_status", 0);
    }

    /* renamed from: g1 */
    public boolean m80917g1() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null && sharedPreferences.getBoolean("st_invalid_by_server", false);
    }

    /* renamed from: g2 */
    public void m80918g2(String str) {
        this.f60567E = str;
    }

    /* renamed from: g3 */
    public void m80919g3(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("st_invalid_by_server", z10).commit();
        }
    }

    /* renamed from: h */
    public int m80920h() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60584V = sharedPreferences.getInt("at_suppression_duration", -1);
        }
        return this.f60584V;
    }

    /* renamed from: h0 */
    public String m80921h0() {
        if (TextUtils.isEmpty(this.f60621y)) {
            this.f60621y = this.f60589a.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        }
        return this.f60621y;
    }

    @Deprecated
    /* renamed from: h1 */
    public boolean m80922h1() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null && sharedPreferences.getBoolean("st_invalid_flag", false);
    }

    /* renamed from: h2 */
    public void m80923h2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("honor_new_version_msg_flag", str).commit();
        }
    }

    @Deprecated
    /* renamed from: h3 */
    public void m80924h3(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("st_invalid_flag", z10).commit();
        }
    }

    /* renamed from: i */
    public String m80925i() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60582T = sharedPreferences.getString("at_suppression_end_time", "");
        }
        return this.f60582T;
    }

    /* renamed from: i0 */
    public long m80926i0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60622z = sharedPreferences.getLong("SERVICE_COUNTRY_UPDATE_TIME", 0L);
        }
        return this.f60622z;
    }

    /* renamed from: i1 */
    public boolean m80927i1() {
        return (this.f60589a == null || TextUtils.isEmpty(m80967s0())) ? false : true;
    }

    /* renamed from: i2 */
    public void m80928i2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("hwid_provider_query_time", j10).commit();
        }
        this.f60576N = j10;
    }

    /* renamed from: i3 */
    public void m80929i3(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sync_risk_effective", str).commit();
        }
    }

    /* renamed from: j */
    public int m80930j() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60583U = sharedPreferences.getInt("at_suppression_rate", -1);
        }
        return this.f60583U;
    }

    /* renamed from: j0 */
    public String m80931j0() {
        return "";
    }

    /* renamed from: j1 */
    public boolean m80932j1() {
        return m80927i1() || m80917g1();
    }

    /* renamed from: j2 */
    public void m80933j2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("is_family_share_member", z10).commit();
        }
        this.f60577O = z10;
    }

    /* renamed from: k */
    public String m80934k() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60581S = sharedPreferences.getString("at_suppression_start_time", "");
        }
        return this.f60581S;
    }

    /* renamed from: k0 */
    public long m80935k0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("key_silence_device_last_query_time", 0L);
        }
        return 0L;
    }

    /* renamed from: k1 */
    public boolean m80936k1() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("user_id_invalid", false);
        }
        return false;
    }

    /* renamed from: k2 */
    public void m80937k2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("is_support_exchange_menu", z10).commit();
        }
        this.f60578P = z10;
    }

    /* renamed from: l */
    public final boolean m80938l() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("function_item_switch", true);
        }
        return true;
    }

    /* renamed from: l0 */
    public long m80939l0() {
        if (this.f60589a != null) {
            return r2.getInt("key_silence_device_number", 0);
        }
        return 0L;
    }

    /* renamed from: l1 */
    public void m80940l1(String str) {
        AbstractC10896a.m65887i("AccountSetting", "refresh gradeCode Cache, gradeCode is: " + str);
        m80860T2(str);
        m80888a2(System.currentTimeMillis());
    }

    /* renamed from: l2 */
    public void m80941l2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("lastMemberInfo", str).commit();
        }
    }

    /* renamed from: m */
    public String m80942m() {
        String str = this.f60614r;
        if (str == null || str.isEmpty()) {
            this.f60614r = this.f60589a.getString("contry_code", null);
        }
        return this.f60614r;
    }

    /* renamed from: m0 */
    public int m80943m0() {
        if (this.f60609m == 0) {
            this.f60609m = this.f60589a.getInt("siteChangeNoticeCount", 0);
        }
        return this.f60609m;
    }

    /* renamed from: m1 */
    public void m80944m1(String str) {
        AbstractC10896a.m65887i("AccountSetting", "refresh memGradeRightList Cache");
        m80957p2(str);
    }

    /* renamed from: m2 */
    public void m80945m2(boolean z10) {
        this.f60589a.edit().putBoolean("login_status_error", z10).commit();
        this.f60575M = z10;
    }

    /* renamed from: n */
    public int m80946n() {
        SharedPreferences sharedPreferences;
        int i10 = this.f60600f0;
        return (i10 == -1 && (sharedPreferences = this.f60589a) != null) ? sharedPreferences.getInt("dataPeriod", -1) : i10;
    }

    /* renamed from: n0 */
    public int m80947n0() {
        if (this.f60607k == 0) {
            this.f60607k = this.f60589a.getInt("site_id", 0);
        }
        return this.f60607k;
    }

    /* renamed from: n1 */
    public void m80948n1(String str) {
        AbstractC10896a.m65887i("AccountSetting", "refresh userTagsStr Cache, userTagsStr is: " + str);
        m80876X2(str);
        m80880Y2(System.currentTimeMillis());
    }

    /* renamed from: n2 */
    public void m80949n2(String str) {
        String strM68636f = C11477c.m68636f(str);
        if (TextUtils.isEmpty(strM68636f)) {
            return;
        }
        this.f60589a.edit().putString("login_user_name", strM68636f).commit();
        this.f60613q = str;
    }

    /* renamed from: o */
    public String m80950o() {
        String string;
        String str = this.f60597e;
        if ((str == null || str.isEmpty()) && (string = this.f60589a.getString(C6148x2.DEVICE_ID, null)) != null) {
            if (this.f60565C) {
                String strM68633c = C11477c.m68633c(string);
                this.f60597e = strM68633c;
                if (TextUtils.isEmpty(strM68633c)) {
                    AbstractC10896a.m65887i("AccountSetting", "deviceId is old, aild login");
                    InterfaceC13455h interfaceC13455h = this.f60619w;
                    if (interfaceC13455h != null) {
                        interfaceC13455h.mo81000b(this.f60591b);
                    } else {
                        AbstractC10896a.m65886e("AccountSetting", "mAccountManagerHelper is null");
                    }
                }
            } else {
                AbstractC10896a.m65886e("AccountSetting", "cbc KeyStore not available");
            }
        }
        return this.f60597e;
    }

    /* renamed from: o0 */
    public String m80951o0() {
        if (TextUtils.isEmpty(this.f60608l)) {
            this.f60608l = this.f60589a.getString("siteInfo", "");
        }
        return this.f60608l;
    }

    /* renamed from: o1 */
    public void m80952o1(InterfaceC13455h interfaceC13455h) {
        this.f60619w = interfaceC13455h;
    }

    /* renamed from: o2 */
    public void m80953o2(boolean z10) {
        this.f60594c0 = z10;
    }

    /* renamed from: p */
    public String m80954p() {
        return (C0211e.m1344c().m1347d() || m80938l()) ? TextUtils.isEmpty(this.f60599f) ? m80950o() : this.f60599f : C0228m0.m1597b().m1599c();
    }

    /* renamed from: p0 */
    public String m80955p0() {
        if (TextUtils.isEmpty(this.f60611o)) {
            this.f60611o = this.f60589a.getString("siteMatchStatus", "");
        }
        return this.f60611o;
    }

    /* renamed from: p1 */
    public void m80956p1(InterfaceC13043a interfaceC13043a) {
        this.f60620x = interfaceC13043a;
    }

    /* renamed from: p2 */
    public final void m80957p2(String str) {
        this.f60589a.edit().putString("CACHED_RIGHT_CODE_LIST", str).commit();
        this.f60568F = str;
    }

    /* renamed from: q */
    public String m80958q() {
        return this.f60599f;
    }

    /* renamed from: q0 */
    public int m80959q0() {
        if (this.f60610n == 0) {
            this.f60610n = this.f60589a.getInt("siteOfflineNoticeCount", 0);
        }
        return this.f60610n;
    }

    /* renamed from: q1 */
    public void m80960q1(Bundle bundle) {
        AbstractC10896a.m65885d("AccountSetting", "saveAccountAgeRangeSP");
        if (bundle == null) {
            AbstractC10896a.m65886e("AccountSetting", "saveAccountAgeRangeSP bundle is null");
            return;
        }
        String strM63694p = new C10343b(bundle).m63694p(com.huawei.hms.support.feature.result.CommonConstant.KEY_AGE_RANGE);
        if (strM63694p == null || TextUtils.isEmpty(strM63694p)) {
            AbstractC10896a.m65886e("AccountSetting", "AgeRange from account is empty");
        } else {
            if (m80910f().equals(strM63694p)) {
                return;
            }
            AbstractC10896a.m65887i("AccountSetting", "start setAgeRange");
            m80792C1(strM63694p);
        }
    }

    /* renamed from: q2 */
    public void m80961q2(long j10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("memberRemainDays", j10).commit();
        }
    }

    /* renamed from: r */
    public String m80962r() {
        String string;
        String str = this.f60616t;
        if ((str == null || str.isEmpty()) && (string = this.f60589a.getString("device_name_custom", null)) != null && !string.isEmpty()) {
            if (this.f60565C) {
                String strM68633c = C11477c.m68633c(string);
                this.f60616t = strM68633c;
                if (TextUtils.isEmpty(strM68633c)) {
                    AbstractC10896a.m65887i("AccountSetting", "deviceName is old, aild login");
                    InterfaceC13455h interfaceC13455h = this.f60619w;
                    if (interfaceC13455h != null) {
                        interfaceC13455h.mo81000b(this.f60591b);
                    } else {
                        AbstractC10896a.m65886e("AccountSetting", "mAccountManagerHelper is null");
                    }
                }
            } else {
                AbstractC10896a.m65886e("AccountSetting", "cbc KeyStore not available");
            }
        }
        return this.f60616t;
    }

    /* renamed from: r0 */
    public int m80963r0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("spaceShareEnable", 0);
        }
        return 0;
    }

    /* renamed from: r1 */
    public void m80964r1(Bundle bundle) {
        AbstractC10896a.m65885d("AccountSetting", "saveAccountCountryCode");
        if (bundle == null) {
            AbstractC10896a.m65886e("AccountSetting", "saveAccountCountryCode bundle is null");
            return;
        }
        String strM63694p = new C10343b(bundle).m63694p("countryCode");
        if (strM63694p == null || TextUtils.isEmpty(strM63694p)) {
            AbstractC10896a.m65886e("AccountSetting", "countryCode from account is empty");
        } else {
            m80831M1(strM63694p);
        }
    }

    /* renamed from: r2 */
    public void m80965r2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("needShowNewBMIntroduction", z10).commit();
        }
    }

    /* renamed from: s */
    public String m80966s() {
        String str = this.f60612p;
        if (str == null || str.isEmpty()) {
            this.f60612p = this.f60589a.getString("device_type", null);
        }
        return this.f60612p;
    }

    /* renamed from: s0 */
    public String m80967s0() {
        SharedPreferences sharedPreferences = this.f60589a;
        return sharedPreferences != null ? sharedPreferences.getString("sync_risk_effective", "") : "";
    }

    /* renamed from: s1 */
    public void m80968s1(Bundle bundle) {
        if (bundle == null) {
            AbstractC10896a.m65887i("AccountSetting", "saveAccountSP bundle is null");
            return;
        }
        C10343b c10343b = new C10343b(bundle);
        m80851R1(c10343b.m63694p(JsbMapKeyNames.H5_DEVICE_TYPE));
        m80843P1(c10343b.m63694p("deviceID"));
        m80864U2(c10343b.m63694p(JsbMapKeyNames.H5_USER_ID));
        m80949n2(c10343b.m63694p(com.huawei.hms.support.feature.result.CommonConstant.KEY_DISPLAY_NAME));
        m80831M1(c10343b.m63694p("countryCode"));
        m80821J2(c10343b.m63694p(com.huawei.hms.support.feature.result.CommonConstant.KEY_SERVICE_COUNTRY_CODE));
        m80788B1(c10343b.m63694p("accountType"));
        m80784A1(c10343b.m63694p("accountName"));
        m80840O2(Integer.parseInt(c10343b.m63694p(HwPayConstant.KEY_SITE_ID)));
        m80991y0();
    }

    /* renamed from: s2 */
    public void m80969s2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("bmNewUserGuidPage", str).commit();
        }
    }

    /* renamed from: t */
    public String m80970t() {
        return (C0211e.m1344c().m1347d() || m80938l()) ? !TextUtils.isEmpty(this.f60599f) ? "11" : m80966s() : "6";
    }

    /* renamed from: t0 */
    public String m80971t0() {
        String str = this.f60593c;
        if (str == null || str.isEmpty()) {
            String strM80975u0 = m80975u0();
            if (strM80975u0 == null || strM80975u0.isEmpty()) {
                BaseLogger.m28735w("AccountSetting", "user_id in sp is empty");
            } else {
                String strM68633c = C11477c.m68633c(strM80975u0);
                this.f60593c = strM68633c;
                if (TextUtils.isEmpty(strM68633c)) {
                    BaseLogger.m28735w("AccountSetting", "can not decrypt userId by keystore");
                    return strM80975u0;
                }
            }
        }
        return this.f60593c;
    }

    /* renamed from: t1 */
    public void m80972t1() {
        AbstractC10896a.m65887i("AccountSetting", "Send auth fail broadcast");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: t2 */
    public void m80973t2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("bmFreeUserGuidPage", str).commit();
        }
    }

    /* renamed from: u */
    public int m80974u() {
        try {
            return Integer.parseInt(m80970t());
        } catch (NumberFormatException unused) {
            BaseLogger.m28735w("AccountSetting", "format deviceType fail");
            return 0;
        }
    }

    /* renamed from: u0 */
    public String m80975u0() {
        return this.f60589a.getString("user_id", null);
    }

    /* renamed from: u1 */
    public void m80976u1() {
        AbstractC10896a.m65887i("AccountSetting", "Send forced upgrade broadcast");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.UPGRADE_NOTICE"));
    }

    /* renamed from: u2 */
    public void m80977u2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("bmPaidUserGuidPage", str).commit();
        }
    }

    /* renamed from: v */
    public int m80978v() {
        try {
            return Integer.parseInt(m80966s());
        } catch (NumberFormatException unused) {
            BaseLogger.m28735w("AccountSetting", "format deviceType fail");
            return 0;
        }
    }

    /* renamed from: v0 */
    public String m80979v0() {
        if (TextUtils.isEmpty(this.f60569G)) {
            this.f60569G = this.f60589a.getString("USER_TAGS_KEY", "");
        }
        return this.f60569G;
    }

    /* renamed from: v1 */
    public void m80980v1() {
        AbstractC10896a.m65887i("AccountSetting", "forced Upgrade or ST invalid or SiteNotMatch, send broadcast to FileManager");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_FILEMANAGER_PAUSE"));
    }

    /* renamed from: v2 */
    public void m80981v2(boolean z10) {
        this.f60604h0 = z10;
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isMemberFromRegretDay", z10).commit();
        }
    }

    /* renamed from: w */
    public String m80982w() {
        return this.f60603h;
    }

    /* renamed from: w0 */
    public long m80983w0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60571I = sharedPreferences.getLong("USER_TAGS_UPDATE_TIME", 0L);
        }
        return this.f60571I;
    }

    /* renamed from: w1 */
    public void m80984w1(boolean z10) {
        AbstractC10896a.m65887i("AccountSetting", "ST invalid, send broadcast to FileManager");
        Intent intent = new Intent("com.huawei.hicloud.intent.action.ACTION_FILEMANAGER_PAUSE");
        intent.putExtra("sync_risk_effective", z10);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: w2 */
    public void m80985w2(boolean z10) {
        this.f60588Z = z10;
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("is_bm_type", z10).commit();
        }
    }

    /* renamed from: x */
    public String m80986x() {
        return this.f60589a.getString(C6148x2.DEVICE_ID, null);
    }

    /* renamed from: x0 */
    public String m80987x0() {
        String string = this.f60589a.getString("user_type", "");
        this.f60618v = string;
        return string;
    }

    /* renamed from: x1 */
    public void m80988x1(String str) {
        AbstractC10896a.m65887i("AccountSetting", "Send refresh sp urls broadcast, source: " + str);
        Intent intent = new Intent("com.huawei.hicloud.REFRESH_URLS_SP_ACTION");
        intent.putExtra("source", str);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: x2 */
    public void m80989x2(boolean z10) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("newUser", z10).commit();
        }
    }

    /* renamed from: y */
    public String m80990y() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60579Q = sharedPreferences.getString("exchange_menu_text", "");
        }
        return this.f60579Q;
    }

    /* renamed from: y0 */
    public void m80991y0() {
        String strM80966s = m80966s();
        String strM80950o = m80950o();
        if ("0".equals(strM80966s) && !TextUtils.isEmpty(strM80950o) && m80803F0().booleanValue()) {
            C12515a.m75110o().m75172d(new C13621b(strM80950o));
        }
    }

    /* renamed from: y1 */
    public void m80992y1() {
        AbstractC10896a.m65887i("AccountSetting", "Send sync risk broadcast");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.SYNC_RISK"));
    }

    /* renamed from: y2 */
    public void m80993y2(String str) {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("NEW_VERSION_MSG_ADD", str).commit();
        }
    }

    /* renamed from: z */
    public String m80994z() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            this.f60580R = sharedPreferences.getString("exchange_menu_text_lan", "");
        }
        return this.f60580R;
    }

    /* renamed from: z0 */
    public boolean m80995z0() {
        SharedPreferences sharedPreferences = this.f60589a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("wish_list_right", false);
        }
        return false;
    }

    /* renamed from: z1 */
    public void m80996z1(String str) {
        this.f60589a.edit().putString("account_brand", str).commit();
        this.f60563A = str;
    }

    /* renamed from: z2 */
    public void m80997z2(long j10) {
        this.f60589a.edit().putLong("query_no_provider_err_time", j10).commit();
        this.f60564B = j10;
    }
}
