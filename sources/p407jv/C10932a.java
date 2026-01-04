package p407jv;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import java.util.Locale;
import lv.InterfaceC11350a;
import mv.C11531d;

/* renamed from: jv.a */
/* loaded from: classes9.dex */
public class C10932a {

    /* renamed from: c */
    public static int f51841c = -1;

    /* renamed from: a */
    public final InterfaceC11350a f51842a;

    /* renamed from: b */
    public boolean f51843b = true;

    public C10932a(InterfaceC11350a interfaceC11350a) {
        this.f51842a = interfaceC11350a;
    }

    /* renamed from: g */
    public static void m66049g(int i10) {
        f51841c = i10;
    }

    /* renamed from: a */
    public final String m66050a() {
        return Locale.getDefault().getCountry();
    }

    /* renamed from: b */
    public final String m66051b() {
        return C11531d.m68820a("ro.product.locale", "");
    }

    /* renamed from: c */
    public final String m66052c() {
        return C11531d.m68820a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
    }

    /* renamed from: d */
    public boolean m66053d(Context context) {
        if (!this.f51843b) {
            this.f51842a.mo7652i("BIChecker", "oobe check is off, report is on");
            return false;
        }
        if (!m66055f()) {
            this.f51842a.mo7652i("BIChecker", "not huawei device, report is on");
            return false;
        }
        if (context == null) {
            return true;
        }
        if (m66054e()) {
            return f51841c == 0;
        }
        this.f51842a.mo7652i("BIChecker", "not ChinaROM");
        try {
            m66049g(Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state"));
            this.f51842a.mo7652i("BIChecker", "hw_app_analytics_state value is " + f51841c);
            return f51841c != 1;
        } catch (Settings.SettingNotFoundException unused) {
            this.f51842a.mo7652i("BIChecker", "Get OOBE failed");
            return true;
        }
    }

    /* renamed from: e */
    public final boolean m66054e() {
        String strM66052c = m66052c();
        if (!TextUtils.isEmpty(strM66052c)) {
            return "cn".equalsIgnoreCase(strM66052c);
        }
        String strM66051b = m66051b();
        if (!TextUtils.isEmpty(strM66051b)) {
            return strM66051b.toLowerCase(Locale.US).contains("cn");
        }
        String strM66050a = m66050a();
        if (TextUtils.isEmpty(strM66050a)) {
            return false;
        }
        return "cn".equalsIgnoreCase(strM66050a);
    }

    /* renamed from: f */
    public final boolean m66055f() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* renamed from: h */
    public void m66056h() {
        this.f51843b = false;
    }
}
