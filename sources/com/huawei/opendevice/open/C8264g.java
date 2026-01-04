package com.huawei.opendevice.open;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.CountryConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import java.util.Locale;

/* renamed from: com.huawei.opendevice.open.g */
/* loaded from: classes2.dex */
public class C8264g {

    /* renamed from: a */
    public static boolean f38491a = false;

    /* renamed from: b */
    public static String f38492b = "UNKNOWN";

    /* renamed from: c */
    public static String f38493c = "";

    /* renamed from: d */
    public static String f38494d = "";

    /* renamed from: e */
    public static String f38495e = "";

    /* renamed from: f */
    public static String f38496f = "";

    /* renamed from: g */
    public static InterfaceC8263f f38497g;

    /* renamed from: h */
    public static C8262e f38498h;

    /* renamed from: com.huawei.opendevice.open.g$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f38499a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC8260c f38500b;

        public a(Context context, InterfaceC8260c interfaceC8260c) {
            this.f38499a = context;
            this.f38500b = interfaceC8260c;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2;
            Context context;
            String str;
            String str2;
            String str3;
            AbstractC7185ho.m43821b("PrivacyUrlUtil", "config privacy statement url, isChina: %s.", Boolean.valueOf(C8264g.f38491a));
            C8264g.m51617l(this.f38499a);
            if (C8264g.f38491a) {
                sb2 = new StringBuilder();
                context = this.f38499a;
                str = "hiad_privacyPath";
            } else {
                sb2 = new StringBuilder();
                context = this.f38499a;
                str = "hiad_thirdPrivacyOverseaPath";
            }
            sb2.append(AbstractC7806cz.m48151a(context, str));
            sb2.append(C8264g.f38492b);
            String string = sb2.toString();
            C8264g.f38494d += string;
            if (TextUtils.isEmpty(C8264g.f38493c)) {
                AbstractC7185ho.m43820b("PrivacyUrlUtil", "grs url return null or empty, use local defalut url.");
                str2 = C8264g.f38494d;
            } else {
                str2 = C8264g.f38493c + string;
            }
            String unused = C8264g.f38493c = str2;
            C8264g.f38498h.m51596d("privacy" + C8264g.f38492b);
            if (C8264g.f38491a) {
                C8264g.f38498h.m51596d("privacyThirdCN");
                str3 = "20230927";
            } else {
                str3 = "20221229";
            }
            C8264g.m51619n(C8264g.m51621p(this.f38499a, C8264g.f38493c, str3), this.f38500b);
        }
    }

    /* renamed from: com.huawei.opendevice.open.g$b */
    public static class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f38501a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC8260c f38502b;

        public b(Context context, InterfaceC8260c interfaceC8260c) {
            this.f38501a = context;
            this.f38502b = interfaceC8260c;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2;
            String str;
            String str2;
            AbstractC7185ho.m43821b("PrivacyUrlUtil", "config whyThisAdStatement url, isChina: %s", Boolean.valueOf(C8264g.f38491a));
            C8264g.m51617l(this.f38501a);
            String strM48151a = AbstractC7806cz.m48151a(this.f38501a, "haid_third_ad_info");
            if (C8264g.f38491a) {
                sb2 = new StringBuilder();
                sb2.append(strM48151a);
                str = Constants.THIRD_AD_INFO_CN;
            } else {
                sb2 = new StringBuilder();
                sb2.append(strM48151a);
                str = Constants.THIRD_AD_INFO_OVERSEA;
            }
            sb2.append(str);
            String string = sb2.toString();
            C8264g.f38496f += string;
            if (TextUtils.isEmpty(C8264g.f38495e)) {
                AbstractC7185ho.m43820b("PrivacyUrlUtil", "grs url return null or empty, use local defalut url.");
                str2 = C8264g.f38496f;
            } else {
                str2 = C8264g.f38495e + string;
            }
            String unused = C8264g.f38495e = str2;
            C8264g.m51619n(C8264g.m51624s(this.f38501a, C8264g.f38495e, "20221229"), this.f38502b);
        }
    }

    /* renamed from: a */
    public static String m51606a(Context context, String str) {
        String str2;
        if (CountryConfig.isDR1(str, null)) {
            str2 = "haid_h5_content_server_CN";
        } else if (CountryConfig.isDR2(str, null)) {
            str2 = "haid_h5_content_server_HK";
        } else if (CountryConfig.isDR3(str, null)) {
            str2 = "haid_h5_content_server_EU";
        } else if (CountryConfig.isDR4(str, null)) {
            str2 = "haid_h5_content_server_RU";
        } else {
            AbstractC7185ho.m43823c("PrivacyUrlUtil", "getH5LocalUrl error, countryCode not belong to any site.");
            str2 = "haid_h5_content_server";
        }
        return AbstractC7806cz.m48151a(context, str2);
    }

    /* renamed from: e */
    public static void m51610e(Context context, InterfaceC8260c interfaceC8260c) {
        AbstractC7834m.m48481b(new a(context, interfaceC8260c));
    }

    /* renamed from: f */
    public static void m51611f(InterfaceC8263f interfaceC8263f) {
        f38497g = interfaceC8263f;
    }

    /* renamed from: l */
    public static void m51617l(Context context) {
        String str;
        boolean zMo41175d = C6982bz.m41148a(context).mo41175d();
        f38491a = zMo41175d;
        if (zMo41175d) {
            str = "CN";
        } else {
            String strM39390a = new CountryCodeBean(context).m39390a();
            f38492b = strM39390a;
            str = "UNKNOWN".equalsIgnoreCase(strM39390a) ? "EU" : f38492b;
        }
        f38492b = str;
        C7787cg.m47900a(context).m48031z(f38492b);
        f38498h = new C8262e();
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        f38493c = interfaceC7146gcM43316b.mo43324a(context, "amsServer");
        f38495e = interfaceC7146gcM43316b.mo43324a(context, "h5Server");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PrivacyUrlUtil", "base url for %s is: %s; h5Server is: %s", "amsServer", AbstractC7819dl.m48375a(f38493c), AbstractC7819dl.m48375a(f38495e));
        }
        f38494d = AbstractC7806cz.m48151a(context, "hiad_privacyServer");
        f38496f = m51606a(context, f38492b);
    }

    /* renamed from: m */
    public static void m51618m(Context context, InterfaceC8260c interfaceC8260c) {
        AbstractC7834m.m48481b(new b(context, interfaceC8260c));
    }

    /* renamed from: n */
    public static void m51619n(String str, InterfaceC8260c interfaceC8260c) {
        if (TextUtils.isEmpty(str)) {
            interfaceC8260c.mo51589g();
        } else {
            AbstractC7185ho.m43821b("PrivacyUrlUtil", "statement url= %s", AbstractC7819dl.m48375a(str));
            interfaceC8260c.mo51585a(str);
        }
        InterfaceC8263f interfaceC8263f = f38497g;
        if (interfaceC8263f != null) {
            interfaceC8263f.mo51584a(f38498h);
        }
    }

    /* renamed from: p */
    public static String m51621p(Context context, String str, String str2) {
        String str3 = Locale.getDefault().getLanguage().toLowerCase(Locale.getDefault()) + "-" + Locale.getDefault().getCountry().toLowerCase(Locale.getDefault());
        String strM48344t = AbstractC7811dd.m48344t(context);
        f38498h.m51603k(str2);
        f38498h.m51599g(str3);
        f38498h.m51601i(strM48344t);
        return str + Constants.LANGUAGE + str3 + Constants.BRANCH_ID + "0" + Constants.VERSION + str2 + Constants.CONTENT_TAG + "default";
    }

    /* renamed from: s */
    public static String m51624s(Context context, String str, String str2) {
        String str3 = Locale.getDefault().getLanguage().toLowerCase(Locale.getDefault()) + "-" + Locale.getDefault().getCountry().toLowerCase(Locale.getDefault());
        String strM48344t = AbstractC7811dd.m48344t(context);
        f38498h.m51603k(str2);
        f38498h.m51599g(str3);
        f38498h.m51601i(strM48344t);
        return str + Constants.LANGUAGE + str3 + Constants.VERSION + str2 + Constants.SCRIPT + strM48344t;
    }
}
