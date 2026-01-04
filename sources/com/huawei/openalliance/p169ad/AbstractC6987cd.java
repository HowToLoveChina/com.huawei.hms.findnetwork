package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7815dh;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.cd */
/* loaded from: classes8.dex */
public abstract class AbstractC6987cd extends C6986cc {
    public AbstractC6987cd(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public String m41194t() {
        String strM41192b = m41192b("ro.build.version.emui");
        this.f32107b.m47979d(strM41192b);
        return strM41192b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public String m41195u() {
        String strM41192b = m41192b("ro.build.version.magic");
        this.f32107b.m47987f(strM41192b);
        return strM41192b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public String m41196v() {
        String strM41192b = m41192b(mo41197s());
        this.f32107b.m47983e(strM41192b);
        return strM41192b;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: d */
    public boolean mo41175d() {
        String strM48289a = AbstractC7811dd.m48289a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP);
        if (!TextUtils.isEmpty(strM48289a)) {
            return "cn".equalsIgnoreCase(strM48289a);
        }
        String strM48289a2 = AbstractC7811dd.m48289a("ro.product.locale");
        if (!TextUtils.isEmpty(strM48289a2)) {
            return strM48289a2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String strM48322d = AbstractC7811dd.m48322d();
        if (TextUtils.isEmpty(strM48322d)) {
            return false;
        }
        return "cn".equalsIgnoreCase(strM48322d);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: e */
    public String mo41176e() {
        String strM47985f = this.f32107b.m47985f();
        if (TextUtils.isEmpty(strM47985f)) {
            strM47985f = m41194t();
        } else if (AbstractC7815dh.m48358a("getEmuiVersionName")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.cd.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC6987cd.this.m41194t();
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47985f)) {
            return null;
        }
        return strM47985f;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: f */
    public String mo41177f() {
        String strM47989g = this.f32107b.m47989g();
        if (TextUtils.isEmpty(strM47989g)) {
            strM47989g = m41196v();
        } else if (AbstractC7815dh.m48358a("getHosVersionName")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.cd.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC6987cd.this.m41196v();
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47989g)) {
            return null;
        }
        return strM47989g;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: g */
    public boolean mo41178g() {
        return !TextUtils.isEmpty(mo41177f());
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: i */
    public String mo41180i() {
        String strM47992h = this.f32107b.m47992h();
        if (TextUtils.isEmpty(strM47992h)) {
            strM47992h = m41195u();
        } else if (AbstractC7815dh.m48358a("getMagicuiVersionName")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.cd.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC6987cd.this.m41195u();
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47992h)) {
            return null;
        }
        return strM47992h;
    }

    /* renamed from: s */
    public abstract String mo41197s();

    /* renamed from: b */
    private String m41192b(String str) {
        String strM48289a = AbstractC7811dd.m48289a(str);
        return strM48289a == null ? Constants.NOT_FOUND : strM48289a;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41171a(Context context) {
        try {
            int i10 = Settings.Secure.getInt(context.getContentResolver(), "display_notch_status");
            AbstractC7185ho.m43818a("BaseHwnDeviceImpl", "isNotchEnable, displayNotch: %s", Integer.valueOf(i10));
            return i10 == 0;
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("BaseHwnDeviceImpl", "isNotchEnable err:" + th2.getClass().getSimpleName());
            return this.mo41169a((View) null) > 0;
        }
    }
}
