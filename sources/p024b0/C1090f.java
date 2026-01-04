package p024b0;

import android.os.LocaleList;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;
import p212d0.C8970b;

/* renamed from: b0.f */
/* loaded from: classes.dex */
public final class C1090f {

    /* renamed from: b */
    public static final C1090f f5209b = m6474a(new Locale[0]);

    /* renamed from: a */
    public final InterfaceC1091g f5210a;

    /* renamed from: b0.f$a */
    public static class a {

        /* renamed from: a */
        public static final Locale[] f5211a = {new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE, "XA"), new Locale(Constants.AR_CACHE, "XB")};

        /* renamed from: a */
        public static Locale m6482a(String str) {
            return Locale.forLanguageTag(str);
        }

        /* renamed from: b */
        public static boolean m6483b(Locale locale) {
            for (Locale locale2 : f5211a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: c */
        public static boolean m6484c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || m6483b(locale) || m6483b(locale2)) {
                return false;
            }
            String strM56767a = C8970b.m56767a(locale);
            if (!strM56767a.isEmpty()) {
                return strM56767a.equals(C8970b.m56767a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    /* renamed from: b0.f$b */
    public static class b {
        /* renamed from: a */
        public static LocaleList m6485a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        /* renamed from: b */
        public static LocaleList m6486b() {
            return LocaleList.getAdjustedDefault();
        }

        /* renamed from: c */
        public static LocaleList m6487c() {
            return LocaleList.getDefault();
        }
    }

    public C1090f(InterfaceC1091g interfaceC1091g) {
        this.f5210a = interfaceC1091g;
    }

    /* renamed from: a */
    public static C1090f m6474a(Locale... localeArr) {
        return m6477h(b.m6485a(localeArr));
    }

    /* renamed from: b */
    public static C1090f m6475b(String str) {
        if (str == null || str.isEmpty()) {
            return m6476d();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.m6482a(strArrSplit[i10]);
        }
        return m6474a(localeArr);
    }

    /* renamed from: d */
    public static C1090f m6476d() {
        return f5209b;
    }

    /* renamed from: h */
    public static C1090f m6477h(LocaleList localeList) {
        return new C1090f(new C1092h(localeList));
    }

    /* renamed from: c */
    public Locale m6478c(int i10) {
        return this.f5210a.get(i10);
    }

    /* renamed from: e */
    public boolean m6479e() {
        return this.f5210a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1090f) && this.f5210a.equals(((C1090f) obj).f5210a);
    }

    /* renamed from: f */
    public int m6480f() {
        return this.f5210a.size();
    }

    /* renamed from: g */
    public String m6481g() {
        return this.f5210a.mo6488a();
    }

    public int hashCode() {
        return this.f5210a.hashCode();
    }

    public String toString() {
        return this.f5210a.toString();
    }
}
