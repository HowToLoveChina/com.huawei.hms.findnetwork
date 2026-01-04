package p212d0;

import android.icu.util.ULocale;
import java.util.Locale;

/* renamed from: d0.b */
/* loaded from: classes.dex */
public final class C8970b {

    /* renamed from: d0.b$a */
    public static class a {
        /* renamed from: a */
        public static ULocale m56768a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        /* renamed from: b */
        public static ULocale m56769b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        /* renamed from: c */
        public static String m56770c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    /* renamed from: a */
    public static String m56767a(Locale locale) {
        return a.m56770c(a.m56768a(a.m56769b(locale)));
    }
}
