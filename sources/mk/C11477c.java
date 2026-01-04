package mk;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import lk.C11306c;
import lk.C11307d;
import p399jk.AbstractC10896a;

/* renamed from: mk.c */
/* loaded from: classes6.dex */
public class C11477c {
    /* renamed from: a */
    public static String m68631a(String str) {
        try {
            byte[] bArrM67872a = C11307d.m67872a("hicloud_aes_alias_256", C11306c.m67869a(str), 256);
            return bArrM67872a != null ? new String(bArrM67872a, Constants.UTF_8) : "";
        } catch (Exception unused) {
            AbstractC10896a.m65886e("STUtils", "256 Decrypt exception");
            return "";
        }
    }

    /* renamed from: b */
    public static String m68632b(String str, StringBuilder sb2) {
        try {
            byte[] bArrM67873b = C11307d.m67873b("hicloud_aes_alias_256", C11306c.m67869a(str), 256, sb2);
            return bArrM67873b != null ? new String(bArrM67873b, Constants.UTF_8) : "";
        } catch (Exception unused) {
            AbstractC10896a.m65886e("STUtils", "256 Decrypt exception");
            return "";
        }
    }

    /* renamed from: c */
    public static String m68633c(String str) {
        try {
            byte[] bArrM67872a = C11307d.m67872a("hicloud_aes_alias", C11306c.m67869a(str), 128);
            if (bArrM67872a != null) {
                return new String(bArrM67872a, Constants.UTF_8);
            }
            return null;
        } catch (Exception unused) {
            AbstractC10896a.m65886e("STUtils", "Decrypt exception");
            return null;
        }
    }

    /* renamed from: d */
    public static String m68634d(String str) {
        try {
            return C11306c.m67870b(C11307d.m67874c("hicloud_aes_alias_256", m68637g(str), 256));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("STUtils", "256 Encrypt exception: " + e10.toString());
            return "";
        }
    }

    /* renamed from: e */
    public static String m68635e(String str, StringBuilder sb2) {
        try {
            return C11306c.m67870b(C11307d.m67875d("hicloud_aes_alias_256", m68637g(str), 256, sb2));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("STUtils", "256 Encrypt exception: " + e10.toString());
            return "";
        }
    }

    /* renamed from: f */
    public static String m68636f(String str) {
        try {
            return C11306c.m67870b(C11307d.m67874c("hicloud_aes_alias", m68637g(str), 128));
        } catch (Exception unused) {
            AbstractC10896a.m65886e("STUtils", "Encrypt exception");
            return null;
        }
    }

    /* renamed from: g */
    public static byte[] m68637g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
