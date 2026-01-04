package com.huawei.openalliance.p169ad.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* renamed from: com.huawei.openalliance.ad.utils.cp */
/* loaded from: classes2.dex */
public abstract class AbstractC7796cp {

    /* renamed from: a */
    private static final byte[] f36023a = new byte[0];

    /* renamed from: b */
    private static final byte[] f36024b = new byte[0];

    /* renamed from: c */
    private static SoftReference<byte[]> f36025c;

    /* renamed from: com.huawei.openalliance.ad.utils.cp$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f36027b;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            aVar.m48108f(str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cp$a */
    public static class a {

        /* renamed from: g */
        private static final byte[] f36028g = new byte[0];

        /* renamed from: h */
        private static a f36029h;

        /* renamed from: a */
        private SharedPreferences f36030a;

        /* renamed from: b */
        private SharedPreferences f36031b;

        /* renamed from: c */
        private SharedPreferences f36032c;

        /* renamed from: d */
        private final byte[] f36033d = new byte[0];

        /* renamed from: e */
        private final byte[] f36034e = new byte[0];

        /* renamed from: f */
        private final byte[] f36035f = new byte[0];

        /* renamed from: i */
        private Context f36036i;

        private a(Context context) {
            this.f36030a = null;
            this.f36031b = null;
            this.f36032c = null;
            try {
                this.f36036i = context.getApplicationContext();
                Context contextM48571i = C7845x.m48571i(context);
                this.f36030a = contextM48571i.getSharedPreferences("hiad_sp_story_book_file", 4);
                this.f36031b = contextM48571i.getSharedPreferences("hiad_sp_bed_rock_file", 4);
                this.f36032c = contextM48571i.getSharedPreferences("hiad_sp_red_stone_file", 4);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("SecretUtil", "get SharedPreference error: %s", th2.getClass().getSimpleName());
            }
        }

        /* renamed from: a */
        public static a m48096a(Context context) {
            a aVar;
            synchronized (f36028g) {
                try {
                    if (f36029h == null) {
                        f36029h = new a(context);
                    }
                    aVar = f36029h;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }

        /* renamed from: b */
        public String m48099b() {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    String string = sharedPreferences.getString("catch_a_cat", null);
                    if (string == null) {
                        string = AbstractC7740an.m47531a(AbstractC7796cp.m48080a());
                        m48100b(string);
                    }
                    return string;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public String m48101c() {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return "";
                    }
                    return sharedPreferences.getString("pub_store_door", "");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: d */
        public String m48103d() {
            synchronized (this.f36034e) {
                try {
                    SharedPreferences sharedPreferences = this.f36032c;
                    if (sharedPreferences == null) {
                        return "";
                    }
                    String string = sharedPreferences.getString("read_first_chapter", "");
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    return AbstractC7827f.m48400b(string, AbstractC7796cp.m48089b(this.f36036i));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: e */
        public String m48105e() {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return "";
                    }
                    return sharedPreferences.getString("pub_store_door_ks", "");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: f */
        public String m48107f() {
            String string;
            synchronized (this.f36035f) {
                string = this.f36030a.getString("aes_work_key1", "");
            }
            return string;
        }

        /* renamed from: a */
        public String m48097a() {
            synchronized (this.f36033d) {
                try {
                    SharedPreferences sharedPreferences = this.f36031b;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    return sharedPreferences.getString("get_a_book", null);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: b */
        public void m48100b(String str) {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public void m48102c(String str) {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("pub_store_door", str).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: d */
        public void m48104d(String str) {
            synchronized (this.f36034e) {
                try {
                    if (this.f36032c == null) {
                        return;
                    }
                    this.f36032c.edit().putString("read_first_chapter", AbstractC7827f.m48394a(str, AbstractC7796cp.m48089b(this.f36036i))).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: e */
        public void m48106e(String str) {
            synchronized (this.f36035f) {
                try {
                    SharedPreferences sharedPreferences = this.f36030a;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("pub_store_door_ks", str).apply();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: f */
        public void m48108f(String str) {
            synchronized (this.f36035f) {
                this.f36030a.edit().putString("aes_work_key1", str).apply();
            }
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: a */
        public void m48098a(String str) {
            synchronized (this.f36033d) {
                try {
                    SharedPreferences sharedPreferences = this.f36031b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    private static String m48077a(Context context, a aVar) {
        String strM47531a = AbstractC7740an.m47531a(m48088b());
        aVar.m48098a(AbstractC7827f.m48394a(strM47531a, m48092d(context)));
        return strM47531a;
    }

    /* renamed from: b */
    private static String m48087b(int i10) {
        try {
            SecureRandom secureRandomM48090c = m48090c();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append(Integer.toHexString(secureRandomM48090c.nextInt(16)));
            }
            return sb2.toString();
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SecretUtil", "generate aes key1 err:" + th2.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: c */
    private static SecureRandom m48090c() throws NoSuchAlgorithmException {
        SecureRandom instanceStrong;
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (Exception e10) {
            AbstractC7185ho.m43824c("SecretUtil", "getInstanceStrong, exception: %s", e10.getClass().getSimpleName());
            instanceStrong = null;
        }
        return instanceStrong == null ? new SecureRandom() : instanceStrong;
    }

    /* renamed from: d */
    private static byte[] m48092d(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        a aVarM48096a = a.m48096a(context);
        try {
            return m48086a(AbstractC7740an.m47531a(m48091c(context)).toCharArray(), AbstractC7740an.m47532a(aVarM48096a.m48099b()));
        } catch (NoSuchAlgorithmException unused) {
            str = "get userRootKey NoSuchAlgorithmException";
            AbstractC7185ho.m43823c("SecretUtil", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "get userRootKey InvalidKeySpecException";
            AbstractC7185ho.m43823c("SecretUtil", str);
            return null;
        }
    }

    /* renamed from: e */
    private static String m48093e(Context context) {
        String strM48077a;
        if (context == null) {
            return "";
        }
        synchronized (f36023a) {
            try {
                a aVarM48096a = a.m48096a(context);
                String strM48097a = aVarM48096a.m48097a();
                if (strM48097a != null) {
                    String strM48400b = AbstractC7827f.m48400b(strM48097a, m48092d(context));
                    strM48077a = TextUtils.isEmpty(strM48400b) ? m48077a(context, aVarM48096a) : strM48400b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM48077a;
    }

    /* renamed from: f */
    private static byte[] m48094f(Context context) {
        AbstractC7185ho.m43820b("SecretUtil", "regenerateWorkKey");
        a.m48096a(context).m48098a("");
        return AbstractC7740an.m47532a(m48093e(context));
    }

    /* renamed from: g */
    private static String m48095g(Context context) {
        a aVarM48096a = a.m48096a(context);
        String strM48107f = aVarM48096a.m48107f();
        if (!AbstractC7806cz.m48165b(strM48107f)) {
            return strM48107f;
        }
        String strM48087b = m48087b(64);
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.cp.1

            /* renamed from: b */
            final /* synthetic */ String f36027b;

            public AnonymousClass1(String strM48087b2) {
                str = strM48087b2;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.m48108f(str);
            }
        });
        return strM48087b2;
    }

    /* renamed from: a */
    public static String m48078a(String str, String str2) {
        String strM48400b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f36024b) {
            try {
                try {
                    strM48400b = AbstractC7827f.m48400b(str, AbstractC7740an.m47533b(str2));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("SecretUtil", "decrypt oaid ex: %s", th2.getClass().getSimpleName());
                    return null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return strM48400b;
    }

    /* renamed from: b */
    public static byte[] m48088b() {
        return m48081a(16);
    }

    /* renamed from: c */
    private static byte[] m48091c(Context context) {
        return m48083a(context, m48095g(context));
    }

    /* renamed from: a */
    public static boolean m48079a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        return upperCase.contains("CBC") || upperCase.contains("LOW") || upperCase.contains("MD5") || upperCase.contains("EXP") || upperCase.contains("SRP") || upperCase.contains("DSS") || upperCase.contains("PSK") || upperCase.contains("RC4") || upperCase.contains("DES") || upperCase.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV") || upperCase.contains("TEA") || upperCase.contains("SHA0") || upperCase.contains("MD2") || upperCase.contains("MD4") || upperCase.contains("RIPEMD") || upperCase.contains("DESX") || upperCase.contains("DES40") || upperCase.contains("RC2") || upperCase.contains("ANON") || upperCase.contains("NULL") || upperCase.contains("TLS_RSA");
    }

    /* renamed from: b */
    public static byte[] m48089b(Context context) {
        byte[] bArr;
        byte[] bArrM48094f;
        synchronized (f36023a) {
            SoftReference<byte[]> softReference = f36025c;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    bArrM48094f = AbstractC7740an.m47533b(m48093e(context));
                } catch (UnsupportedEncodingException unused) {
                    AbstractC7185ho.m43823c("SecretUtil", "getWorkKeyBytes UnsupportedEncodingException");
                    bArrM48094f = m48094f(context);
                    bArr = bArrM48094f;
                    f36025c = new SoftReference<>(bArr);
                    return bArr;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43823c("SecretUtil", "getWorkKeyBytes " + th2.getClass().getSimpleName());
                    bArrM48094f = m48094f(context);
                    bArr = bArrM48094f;
                    f36025c = new SoftReference<>(bArr);
                    return bArr;
                }
                bArr = bArrM48094f;
                f36025c = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m48080a() {
        return m48081a(16);
    }

    /* renamed from: a */
    public static byte[] m48081a(int i10) {
        byte[] bArr = new byte[i10];
        m48090c().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m48082a(Context context) {
        return m48083a(context, AbstractC7805cy.m48140a());
    }

    /* renamed from: a */
    private static byte[] m48083a(Context context, String str) {
        return m48084a(str, context.getString(C6849R.string.hiad_str_2), context.getString(C6849R.string.hiad_str_3));
    }

    /* renamed from: a */
    private static byte[] m48084a(String str, String str2, String str3) {
        byte[] bArrM47532a = AbstractC7740an.m47532a(str);
        byte[] bArrM47532a2 = AbstractC7740an.m47532a(str2);
        return m48085a(m48085a(bArrM47532a, bArrM47532a2), AbstractC7740an.m47532a(str3));
    }

    /* renamed from: a */
    private static byte[] m48085a(byte[] bArr, byte[] bArr2) {
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
    public static byte[] m48086a(char[] cArr, byte[] bArr) {
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }
}
