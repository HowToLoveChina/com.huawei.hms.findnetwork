package p727w3;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12690m;

/* renamed from: w3.c */
/* loaded from: classes.dex */
public final class C13524c implements InterfaceC12690m {

    /* renamed from: c */
    public static final String f60881c = "c";

    /* renamed from: a */
    public final String f60882a;

    /* renamed from: b */
    public KeyStore f60883b;

    /* renamed from: w3.c$b */
    public static final class b {

        /* renamed from: a */
        public String f60884a = null;

        /* renamed from: b */
        public KeyStore f60885b;

        public b() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
            this.f60885b = null;
            if (!C13524c.m81395f()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f60885b = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }

        /* renamed from: a */
        public C13524c m81398a() {
            return new C13524c(this);
        }

        /* renamed from: b */
        public b m81399b(KeyStore keyStore) {
            if (keyStore == null) {
                throw new IllegalArgumentException("val cannot be null");
            }
            this.f60885b = keyStore;
            return this;
        }
    }

    /* renamed from: d */
    public static void m81394d(String str) throws GeneralSecurityException {
        if (new C13524c().m81397e(str)) {
            throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
        }
        String strM166b = C0043w.m166b("android-keystore://", str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strM166b, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    /* renamed from: f */
    public static boolean m81395f() {
        return true;
    }

    /* renamed from: g */
    public static InterfaceC12678a m81396g(InterfaceC12678a interfaceC12678a) throws GeneralSecurityException {
        byte[] bArrM161c = C0041u.m161c(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrM161c, interfaceC12678a.mo89b(interfaceC12678a.mo88a(bArrM161c, bArr), bArr))) {
            return interfaceC12678a;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    @Override // p631s3.InterfaceC12690m
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean mo76354a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.f60882a     // Catch: java.lang.Throwable -> Le
            r1 = 1
            if (r0 == 0) goto L10
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L10
            monitor-exit(r2)
            return r1
        Le:
            r3 = move-exception
            goto L26
        L10:
            java.lang.String r0 = r2.f60882a     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L23
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L23
            goto L24
        L23:
            r1 = 0
        L24:
            monitor-exit(r2)
            return r1
        L26:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p727w3.C13524c.mo76354a(java.lang.String):boolean");
    }

    @Override // p631s3.InterfaceC12690m
    /* renamed from: b */
    public synchronized InterfaceC12678a mo76355b(String str) throws GeneralSecurityException {
        try {
            String str2 = this.f60882a;
            if (str2 != null && !str2.equals(str)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.f60882a, str));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return m81396g(new C13523b(C0043w.m166b("android-keystore://", str), this.f60883b));
    }

    /* renamed from: e */
    public synchronized boolean m81397e(String str) throws GeneralSecurityException {
        String strM166b;
        strM166b = C0043w.m166b("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            Log.w(f60881c, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f60883b = keyStore;
                keyStore.load(null);
            } catch (IOException e10) {
                throw new GeneralSecurityException(e10);
            } catch (InterruptedException unused2) {
            }
            return this.f60883b.containsAlias(strM166b);
        }
        return this.f60883b.containsAlias(strM166b);
    }

    public C13524c() throws GeneralSecurityException {
        this(new b());
    }

    public C13524c(b bVar) {
        this.f60882a = bVar.f60884a;
        this.f60883b = bVar.f60885b;
    }
}
