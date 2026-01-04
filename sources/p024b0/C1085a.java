package p024b0;

import android.os.Build;
import java.util.Locale;

/* renamed from: b0.a */
/* loaded from: classes.dex */
public class C1085a {
    /* renamed from: a */
    public static boolean m6461a(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m6462b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: c */
    public static boolean m6463c() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 33 || (i10 >= 32 && m6461a("Tiramisu", Build.VERSION.CODENAME));
    }
}
