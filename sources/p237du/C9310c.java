package p237du;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10049c;
import gu.C10053g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: du.c */
/* loaded from: classes5.dex */
public final class C9310c {

    /* renamed from: a */
    public static final String f46672a = "SHA";

    /* renamed from: b */
    public static final String[] f46673b = {"SHA-256", "SHA-384", "SHA-512"};

    /* renamed from: a */
    public static boolean m58617a(String str) {
        for (String str2 : f46673b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m58618b(String str) {
        return m58619c(str, "SHA-256");
    }

    /* renamed from: c */
    public static String m58619c(String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C10053g.m62491c(f46672a, "content or algorithm is null.");
            return "";
        }
        if (!m58617a(str2)) {
            C10053g.m62491c(f46672a, "algorithm is not safe or legal");
            return "";
        }
        try {
            bytes = str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            bytes = new byte[0];
            C10053g.m62491c(f46672a, "Error in generate SHA UnsupportedEncodingException");
        }
        return C10049c.m62476a(m58620d(bytes, str2));
    }

    /* renamed from: d */
    public static byte[] m58620d(byte[] bArr, String str) throws NoSuchAlgorithmException {
        if (bArr == null || TextUtils.isEmpty(str)) {
            C10053g.m62491c(f46672a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!m58617a(str)) {
            C10053g.m62491c(f46672a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            C10053g.m62491c(f46672a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    /* renamed from: e */
    public static boolean m58621e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m58618b(str));
    }
}
