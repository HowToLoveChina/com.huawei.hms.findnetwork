package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.ads.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.hms.ads.identifier.h */
/* loaded from: classes8.dex */
public abstract class AbstractC5074h {

    /* renamed from: a */
    private static final byte[] f23198a = new byte[0];

    /* renamed from: b */
    private static final byte[] f23199b = new byte[0];

    /* renamed from: c */
    private static SoftReference<byte[]> f23200c;

    /* renamed from: com.huawei.hms.ads.identifier.h$a */
    public static class a {

        /* renamed from: a */
        private static final Long f23203a = 120000L;

        /* renamed from: h */
        private static final byte[] f23204h = new byte[0];

        /* renamed from: i */
        private static volatile a f23205i;

        /* renamed from: b */
        private SharedPreferences f23206b;

        /* renamed from: c */
        private SharedPreferences f23207c;

        /* renamed from: d */
        private SharedPreferences f23208d;

        /* renamed from: e */
        private final byte[] f23209e = new byte[0];

        /* renamed from: f */
        private final byte[] f23210f = new byte[0];

        /* renamed from: g */
        private final byte[] f23211g = new byte[0];

        /* renamed from: j */
        private Context f23212j;

        private a(Context context) {
            this.f23206b = null;
            this.f23207c = null;
            this.f23208d = null;
            try {
                this.f23212j = context.getApplicationContext();
                Context contextM30316a = AbstractC5076j.m30316a(context);
                this.f23206b = contextM30316a.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.f23207c = contextM30316a.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.f23208d = contextM30316a.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th2) {
                Log.w("Aes128", "get SharedPreference error: " + th2.getClass().getSimpleName());
            }
        }

        /* renamed from: a */
        public static a m30300a(Context context) {
            a aVar;
            if (f23205i != null) {
                return f23205i;
            }
            synchronized (f23204h) {
                try {
                    if (f23205i == null) {
                        f23205i = new a(context);
                    }
                    aVar = f23205i;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }

        /* renamed from: b */
        public void m30304b() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public void m30306c(String str) {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: d */
        public void m30308d() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putInt("exemption_count_record", 0).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: e */
        public void m30310e() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    this.f23206b.edit().putInt("exemption_count_record", sharedPreferences.getInt("exemption_count_record", 0) + 1).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: f */
        public boolean m30311f() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return false;
                    }
                    return sharedPreferences.getInt("exemption_count_record", 0) < this.f23206b.getInt("exemption_count", 3);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: g */
        public String m30312g() {
            synchronized (this.f23209e) {
                try {
                    SharedPreferences sharedPreferences = this.f23207c;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    return sharedPreferences.getString("get_a_book", null);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: h */
        public String m30313h() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    String string = sharedPreferences.getString("catch_a_cat", null);
                    if (string == null) {
                        string = C5073g.m30268a(AbstractC5074h.m30273a());
                        m30306c(string);
                    }
                    return string;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: i */
        public String m30314i() {
            String string;
            synchronized (this.f23211g) {
                string = this.f23206b.getString("read_second_chapter", "");
            }
            return string;
        }

        /* renamed from: a */
        public String m30301a() {
            synchronized (this.f23210f) {
                try {
                    SharedPreferences sharedPreferences = this.f23208d;
                    if (sharedPreferences == null) {
                        return "";
                    }
                    String string = sharedPreferences.getString("read_first_chapter", "");
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    return AbstractC5074h.m30271a(string, AbstractC5074h.m30275a(this.f23212j));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: b */
        public void m30305b(String str) {
            synchronized (this.f23209e) {
                try {
                    SharedPreferences sharedPreferences = this.f23207c;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public boolean m30307c() {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return false;
                    }
                    long j10 = sharedPreferences.getLong("read_first_chapter_time", -1L);
                    if (j10 < 0) {
                        return false;
                    }
                    return j10 + f23203a.longValue() > System.currentTimeMillis();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: d */
        public void m30309d(String str) {
            synchronized (this.f23211g) {
                this.f23206b.edit().putString("read_second_chapter", str).apply();
            }
        }

        /* renamed from: a */
        public void m30302a(int i10) {
            synchronized (this.f23211g) {
                try {
                    SharedPreferences sharedPreferences = this.f23206b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putInt("exemption_count", i10).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: a */
        public void m30303a(String str) {
            synchronized (this.f23210f) {
                try {
                    if (this.f23208d == null) {
                        return;
                    }
                    this.f23208d.edit().putString("read_first_chapter", AbstractC5074h.m30285b(str, AbstractC5074h.m30275a(this.f23212j))).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    private static String m30269a(Context context, a aVar) {
        String strM30268a = C5073g.m30268a(m30287b());
        aVar.m30305b(m30285b(strM30268a, m30297d(context)));
        return strM30268a;
    }

    /* renamed from: b */
    private static String m30283b(int i10) {
        try {
            SecureRandom secureRandomM30291c = m30291c();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append(Integer.toHexString(secureRandomM30291c.nextInt(16)));
            }
            return sb2.toString();
        } catch (Throwable th2) {
            Log.w("Aes128", "generate aes key1 err:" + th2.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: c */
    private static String m30289c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        Log.i("Aes128", "IV is invalid.");
        return "";
    }

    /* renamed from: d */
    private static String m30294d(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    /* renamed from: e */
    private static byte[] m30298e(Context context) {
        return m30276a(context, m30299f(context));
    }

    /* renamed from: f */
    private static String m30299f(Context context) {
        final a aVarM30300a = a.m30300a(context);
        String strM30314i = aVarM30300a.m30314i();
        if (!TextUtils.isEmpty(strM30314i)) {
            return strM30314i;
        }
        final String strM30283b = m30283b(64);
        AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.h.1
            @Override // java.lang.Runnable
            public void run() {
                aVarM30300a.m30309d(strM30283b);
            }
        });
        return strM30283b;
    }

    /* renamed from: a */
    public static String m30270a(String str, String str2) {
        String strM30271a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f23198a) {
            try {
                try {
                    strM30271a = m30271a(str, m30288b(str2));
                } catch (Throwable th2) {
                    Log.w("Aes128", "decrypt oaid ex: " + th2.getClass().getSimpleName());
                    return null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return strM30271a;
    }

    /* renamed from: b */
    private static String m30284b(Context context) {
        String strM30269a;
        if (context == null) {
            return "";
        }
        synchronized (f23199b) {
            try {
                a aVarM30300a = a.m30300a(context);
                String strM30312g = aVarM30300a.m30312g();
                if (strM30312g != null) {
                    String strM30271a = m30271a(strM30312g, m30297d(context));
                    strM30269a = TextUtils.isEmpty(strM30271a) ? m30269a(context, aVarM30300a) : strM30271a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM30269a;
    }

    /* renamed from: c */
    private static String m30290c(String str, byte[] bArr) {
        byte[] bArrM30274a;
        byte[] bArrM30279a;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !m30296d() || (bArrM30279a = m30279a(str, bArr, (bArrM30274a = m30274a(12)))) == null || bArrM30279a.length == 0) {
            return "";
        }
        return C5073g.m30268a(bArrM30274a) + C5073g.m30268a(bArrM30279a);
    }

    /* renamed from: d */
    private static String m30295d(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && m30296d()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                String strM30289c = m30289c(str);
                String strM30294d = m30294d(str);
                if (TextUtils.isEmpty(strM30289c) || TextUtils.isEmpty(strM30294d)) {
                    Log.i("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, m30292c(m30277a(strM30289c)));
                return new String(cipher.doFinal(m30277a(strM30294d)), Constants.UTF_8);
            } catch (UnsupportedEncodingException | GeneralSecurityException e10) {
                Log.e("Aes128", "GCM decrypt data exception: " + e10.getMessage());
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m30271a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (m30296d()) {
                    return m30295d(str, bArr);
                }
            } catch (Throwable th2) {
                Log.w("Aes128", "fail to decrypt: " + th2.getClass().getSimpleName());
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m30285b(String str, byte[] bArr) {
        StringBuilder sb2;
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                if (m30296d()) {
                    return m30290c(str, bArr);
                }
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(e.getClass().getSimpleName());
                Log.w("Aes128", sb2.toString());
                return "";
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(e.getClass().getSimpleName());
                Log.w("Aes128", sb2.toString());
                return "";
            }
        }
        return "";
    }

    /* renamed from: c */
    private static SecureRandom m30291c() throws NoSuchAlgorithmException {
        SecureRandom instanceStrong;
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (Exception e10) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e10.getClass().getSimpleName());
            instanceStrong = null;
        }
        return instanceStrong == null ? new SecureRandom() : instanceStrong;
    }

    /* renamed from: d */
    private static boolean m30296d() {
        return true;
    }

    /* renamed from: a */
    private static boolean m30272a(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    /* renamed from: b */
    private static boolean m30286b(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    /* renamed from: c */
    private static AlgorithmParameterSpec m30292c(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    /* renamed from: d */
    private static byte[] m30297d(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        a aVarM30300a = a.m30300a(context);
        try {
            return m30282a(C5073g.m30268a(m30298e(context)).toCharArray(), m30277a(aVarM30300a.m30313h()));
        } catch (NoSuchAlgorithmException unused) {
            str = "get userRootKey NoSuchAlgorithmException";
            Log.w("Aes128", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "get userRootKey InvalidKeySpecException";
            Log.w("Aes128", str);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m30273a() {
        return m30274a(16);
    }

    /* renamed from: b */
    public static byte[] m30287b() {
        return m30274a(16);
    }

    /* renamed from: c */
    private static byte[] m30293c(Context context) {
        Log.i("Aes128", "regenerateWorkKey");
        a.m30300a(context).m30305b("");
        return m30277a(m30284b(context));
    }

    /* renamed from: a */
    public static byte[] m30274a(int i10) {
        byte[] bArr = new byte[i10];
        m30291c().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m30288b(String str) throws NumberFormatException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes(Constants.UTF_8);
        for (int i10 = 0; i10 < length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0x");
            int i11 = i10 * 2;
            sb2.append(new String(new byte[]{bytes[i11]}, Constants.UTF_8));
            bArr[i10] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i11 + 1]}, Constants.UTF_8)).byteValue());
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m30275a(Context context) {
        byte[] bArr;
        byte[] bArrM30293c;
        synchronized (f23199b) {
            SoftReference<byte[]> softReference = f23200c;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    bArrM30293c = m30288b(m30284b(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    bArrM30293c = m30293c(context);
                    bArr = bArrM30293c;
                    f23200c = new SoftReference<>(bArr);
                    return bArr;
                } catch (Throwable th2) {
                    Log.w("Aes128", "getWorkKeyBytes " + th2.getClass().getSimpleName());
                    bArrM30293c = m30293c(context);
                    bArr = bArrM30293c;
                    f23200c = new SoftReference<>(bArr);
                    return bArr;
                }
                bArr = bArrM30293c;
                f23200c = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m30276a(Context context, String str) {
        return m30278a(str, context.getString(R$string.identifier_hiad_str_2), context.getString(R$string.identifier_hiad_str_3));
    }

    /* renamed from: a */
    public static byte[] m30277a(String str) {
        byte[] bArr = new byte[0];
        try {
            return m30288b(str);
        } catch (Throwable th2) {
            Log.e("Aes128", "hex string 2 byte: " + th2.getClass().getSimpleName());
            return bArr;
        }
    }

    /* renamed from: a */
    private static byte[] m30278a(String str, String str2, String str3) {
        byte[] bArrM30277a = m30277a(str);
        byte[] bArrM30277a2 = m30277a(str2);
        return m30280a(m30280a(bArrM30277a, bArrM30277a2), m30277a(str3));
    }

    /* renamed from: a */
    private static byte[] m30279a(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && m30286b(bArr) && m30272a(bArr2) && m30296d()) {
            try {
                return m30281a(str.getBytes(Constants.UTF_8), bArr, bArr2);
            } catch (UnsupportedEncodingException e10) {
                Log.e("Aes128", "GCM encrypt data error" + e10.getMessage());
            }
        } else {
            Log.i("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }

    /* renamed from: a */
    private static byte[] m30280a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= bArr2.length) {
            bArr2 = bArr;
            bArr = bArr2;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length];
        int i10 = 0;
        while (i10 < length2) {
            bArr3[i10] = (byte) (bArr2[i10] ^ bArr[i10]);
            i10++;
        }
        while (i10 < bArr.length) {
            bArr3[i10] = bArr[i10];
            i10++;
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m30281a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "encrypt, contentBytes invalid.";
        } else if (bArr2 == null || bArr2.length < 16) {
            str = "encrypt, keyBytes invalid.";
        } else if (!m30296d()) {
            str = "encrypt, osVersion too low.";
        } else if (bArr3 == null || bArr3.length < 12) {
            str = "encrypt, random invalid.";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, m30292c(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e10) {
                Log.e("Aes128", "GCM encrypt data error" + e10.getMessage());
            }
        }
        Log.i("Aes128", str);
        return new byte[0];
    }

    /* renamed from: a */
    public static byte[] m30282a(char[] cArr, byte[] bArr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }
}
