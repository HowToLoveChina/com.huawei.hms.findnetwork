package p521og;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mk.C11477c;
import p015ak.C0241z;
import p525ok.C11908a;
import p575qe.C12347f;
import p612rg.C12509b;
import p809yg.C13981a;

/* renamed from: og.b */
/* loaded from: classes4.dex */
public class C11869b {
    /* renamed from: a */
    public static String m71134a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m71135b(PhoneFinderEncryptData phoneFinderEncryptData, byte[] bArr) {
        try {
            return m71141h(phoneFinderEncryptData.getData(), m71151r(m71141h(phoneFinderEncryptData.getDek(), bArr)));
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptAesGcm Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m71136c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc,st is empty");
            return null;
        }
        try {
            String strM68633c = C11477c.m68633c(str);
            if (!TextUtils.isEmpty(strM68633c)) {
                return strM68633c;
            }
            C13981a.m83990w("EncryptionUtils", "decodeStr is empty,use old decrypt way");
            byte[] bArrM75101a = C12509b.m75101a(str, m71149p(context), 0);
            if (bArrM75101a != null) {
                return new String(bArrM75101a, Constants.UTF_8);
            }
            return null;
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc Exception" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static String m71137d(Context context, String str) {
        String strM68633c;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc,st is empty");
            return null;
        }
        try {
            strM68633c = C11477c.m68633c(str);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc Exception" + e10.getMessage());
        }
        if (TextUtils.isEmpty(strM68633c)) {
            return null;
        }
        return strM68633c;
    }

    /* renamed from: e */
    public static String m71138e(PhoneFinderEncryptData phoneFinderEncryptData, byte[] bArr) {
        try {
            return m71140g(phoneFinderEncryptData.getData(), m71151r(m71140g(phoneFinderEncryptData.getDek(), bArr)));
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public static String m71139f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("EncryptionUtils", "decryptCbcWithoutKeyStore,st is empty");
            return null;
        }
        try {
            byte[] bArrM75101a = C12509b.m75101a(str, m71149p(context), 0);
            if (bArrM75101a != null) {
                return new String(bArrM75101a, Constants.UTF_8);
            }
            return null;
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static String m71140g(String str, byte[] bArr) {
        try {
            return new String(m71147n(2, bArr, m71151r(str.substring(0, 32))).doFinal(m71151r(str.substring(32))), Constants.UTF_8);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptData Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public static String m71141h(String str, byte[] bArr) {
        try {
            byte[] bArrM71151r = m71151r(str);
            return new String(m71148o(2, bArr, m71152s(bArrM71151r, 0, 12)).doFinal(m71152s(bArrM71151r, 12, bArrM71151r.length)), Constants.UTF_8);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptDataByAesGcm Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    public static String m71142i(Context context, String str) {
        return m71143j(context, str);
    }

    /* renamed from: j */
    public static String m71143j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("EncryptionUtils", "st is empty");
            return null;
        }
        try {
            return C11477c.m68636f(str);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public static PhoneFinderEncryptData m71144k(String str, byte[] bArr) {
        try {
            PhoneFinderEncryptData phoneFinderEncryptData = new PhoneFinderEncryptData();
            byte[] bArrM71443b = C11908a.m71443b(16);
            byte[] bArrM71443b2 = C11908a.m71443b(16);
            phoneFinderEncryptData.setData(m71146m(str, bArrM71443b, bArrM71443b2));
            phoneFinderEncryptData.setDek(m71146m(m71134a(bArrM71443b), bArr, bArrM71443b2));
            return phoneFinderEncryptData;
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: l */
    public static String m71145l(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("EncryptionUtils", "encryptCbcWithoutKeyStore,st is empty");
            return null;
        }
        try {
            return C12509b.m75102b(m71150q(str), 0, m71149p(context), 0);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public static String m71146m(String str, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException {
        try {
            return m71134a(bArr2) + m71134a(m71147n(1, bArr, bArr2).doFinal(m71150q(str)));
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: n */
    public static Cipher m71147n(int i10, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    /* renamed from: o */
    public static Cipher m71148o(int i10, byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        C13981a.m83987d("EncryptionUtils", "decrypt:SDK_INT more than 28");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    /* renamed from: p */
    public static byte[] m71149p(Context context) {
        return C11881n.m71352b(C11877j.m71290o(C12347f.m74285n().m74301m()));
    }

    /* renamed from: q */
    public static byte[] m71150q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* renamed from: r */
    public static byte[] m71151r(String str) {
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            throw new IllegalArgumentException("Illegal Argument in hex to bytes");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 2;
            bArr[i10 / 2] = (byte) C0241z.m1687e(str.substring(i10, i11), 16, 0);
            i10 = i11;
        }
        return bArr;
    }

    /* renamed from: s */
    public static byte[] m71152s(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return bArr2;
    }
}
