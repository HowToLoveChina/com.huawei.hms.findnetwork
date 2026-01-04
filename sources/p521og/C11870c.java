package p521og;

import android.text.TextUtils;
import java.util.regex.Pattern;
import p809yg.C13981a;

/* renamed from: og.c */
/* loaded from: classes4.dex */
public class C11870c {
    /* renamed from: a */
    public static String m71153a(String str) {
        return m71156d(str) ? str : "";
    }

    /* renamed from: b */
    public static String m71154b(String str, int i10) {
        return m71156d(str) ? str : i10 == 3003 ? "" : " ";
    }

    /* renamed from: c */
    public static String m71155c(String str) {
        return (!m71156d(str) || "empty".equals(str)) ? "" : str;
    }

    /* renamed from: d */
    public static boolean m71156d(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("FindPatternUtils", "dt is empty");
            return false;
        }
        try {
            return Pattern.matches("^[-+A-Za-z0-9_.@]+$", str);
        } catch (Exception unused) {
            C13981a.m83988e("FindPatternUtils", "getDeviceImeiCode error!");
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m71157e(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("FindPatternUtils", "socIdOrigin is empty");
            return false;
        }
        if (!str.matches("(0+)")) {
            return true;
        }
        C13981a.m83989i("FindPatternUtils", "socIdOrigin is all-zero");
        return false;
    }
}
