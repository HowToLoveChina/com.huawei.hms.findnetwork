package p013ah;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import p015ak.C0213f;
import p015ak.C0241z;
import p521og.C11877j;
import p521og.C11881n;
import p525ok.C11908a;
import p575qe.C12347f;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: ah.e */
/* loaded from: classes4.dex */
public abstract class AbstractC0200e {
    /* renamed from: a */
    public static String m1102a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static SecureRandom m1103b() {
        SecureRandom secureRandom;
        try {
            secureRandom = C11908a.m71442a();
        } catch (NoSuchAlgorithmException unused) {
            C13981a.m83988e("RSACoder", "createSecureRandom NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }

    /* renamed from: c */
    public static byte[] m1104c(String str) {
        return C11881n.m71352b(str);
    }

    /* renamed from: d */
    public static boolean m1105d(String str, String str2, String str3, String str4, String str5) {
        try {
            String str6 = str + str4 + "unbinding" + C11881n.m71347J(str2);
            return "v11".equals(str5) ? m1113l(str6.getBytes(StandardCharsets.UTF_8), m1110i(), str3) : m1112k(str6.getBytes(StandardCharsets.UTF_8), m1108g(), str3);
        } catch (Exception unused) {
            C13981a.m83988e("RSACoder", "doCheck error");
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m1106e(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            String string = "";
            if ("v7".equals(str2) || "v8".equals(str2) || "v11".equals(str2)) {
                if (context == null) {
                    context = C12347f.m74285n().m74301m();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb2.append(str3);
                sb2.append(AbstractC12139d.m72766e(context).getUserID());
                sb2.append(AbstractC12139d.m72766e(context).getDeviceTicket());
                if (!TextUtils.isEmpty(str5)) {
                    sb2.append(str5);
                }
                string = sb2.toString();
            }
            return "v11".equals(str2) ? m1113l(string.getBytes(StandardCharsets.UTF_8), m1110i(), str4) : m1112k(string.getBytes(StandardCharsets.UTF_8), m1108g(), str4);
        } catch (Exception e10) {
            C13981a.m83988e("RSACoder", "doPushMessageCheck error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public static String m1107f() {
        byte[] bArr = new byte[16];
        m1103b().nextBytes(bArr);
        return m1102a(bArr);
    }

    /* renamed from: g */
    public static String m1108g() {
        return C11877j.m71305t(C0213f.m1377a());
    }

    /* renamed from: h */
    public static PublicKey m1109h(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(m1104c(str)));
    }

    /* renamed from: i */
    public static String m1110i() {
        return C11877j.m71308u(C0213f.m1377a());
    }

    /* renamed from: j */
    public static byte[] m1111j(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Illegal Argument in hex to bytes");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 2;
            bArr[i10 / 2] = (byte) C0241z.m1687e(SafeString.substring(str, i10, i11), 16, 0);
            i10 = i11;
        }
        return bArr;
    }

    /* renamed from: k */
    public static boolean m1112k(byte[] bArr, String str, String str2) throws Exception {
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initVerify(m1109h(str));
        signature.update(bArr);
        return signature.verify(m1111j(str2));
    }

    /* renamed from: l */
    public static boolean m1113l(byte[] bArr, String str, String str2) throws Exception {
        Signature signature = Signature.getInstance("SHA256WithRSA/PSS");
        signature.initVerify(m1109h(str));
        signature.update(bArr);
        return signature.verify(m1111j(str2));
    }
}
