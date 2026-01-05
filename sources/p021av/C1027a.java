package p021av;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import mv.SafeBytes;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;
import p374iv.Exception_C10624c;
import p856zu.C14381b;
import p856zu.C14383d;
import p856zu.EnDecryptAlgorithm;
import p856zu.enumEncryptAlgorithm;
import p856zu.InterfaceC14382c;
import p856zu.interfaceEnDecryptKey;
import p856zu.interfaceEnDecrypt;

/* renamed from: av.a */
/* loaded from: classes9.dex */
public class C1027a implements interfaceEnDecrypt {

    /* renamed from: a */
    public final enumEncryptAlgorithm m_algorithm;

    /* renamed from: b */
    public final enumKeyStore m_keystore;

    /* renamed from: c */
    public final Key m_key;

    /* renamed from: d */
    public final AlgorithmParameterSpec m_algorithm_parameterspec;

    /* renamed from: av.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5092a;

        static {
            int[] iArr = new int[enumEncryptAlgorithm.values().length];
            f5092a = iArr;
            try {
                iArr[enumEncryptAlgorithm.AES_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5092a[enumEncryptAlgorithm.AES_CBC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5092a[enumEncryptAlgorithm.KEY_STORE_AES_CBC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ C1027a(enumKeyStore enumKeyStore, enumEncryptAlgorithm enumEncryptAlgorithm, Key key, AlgorithmParameterSpec algorithmParameterSpec, a aVar) {
        this(enumKeyStore, enumEncryptAlgorithm, key, algorithmParameterSpec);
    }

    @Override // p856zu.interfaceEnDecrypt
    public InterfaceC14382c getDecryptHandler() throws Exception_C10623b {
        C14381b c14381b = new C14381b();
        c14381b.setAlgorithm(this.m_algorithm);
        return new C14383d(this.m_keystore, this.m_key, c14381b, this.m_algorithm_parameterspec);
    }

    @Override // p856zu.interfaceEnDecrypt
    public interfaceEnDecryptKey getEncryptHandler() throws Exception_C10623b {
        C14381b c14381b = new C14381b();
        c14381b.setAlgorithm(this.m_algorithm);
        return new EnDecryptAlgorithm(this.m_keystore, this.m_key, c14381b, this.m_algorithm_parameterspec);
    }

    public C1027a(enumKeyStore enumKeyStore, enumEncryptAlgorithm enumEncryptAlgorithm, Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.m_keystore = enumKeyStore;
        this.m_algorithm = enumEncryptAlgorithm;
        this.m_key = key;
        this.m_algorithm_parameterspec = algorithmParameterSpec;
    }

    /* renamed from: av.a$b */
    public static class b {

        /* renamed from: a */
        public enumEncryptAlgorithm f5093a;

        /* renamed from: b */
        public Key m_key;

        /* renamed from: c */
        public AlgorithmParameterSpec f5095c;

        /* renamed from: d */
        public final enumKeyStore f5096d;

        public b() {
            this.f5093a = enumEncryptAlgorithm.getAlgorithm("AES");
            this.f5096d = enumKeyStore.ANDROID_KEYSTORE;
        }

        /* renamed from: a */
        public C1027a m6221a() throws Exception_C10623b {
            AlgorithmParameterSpec algorithmParameterSpec;
            Key key = this.m_key;
            if (key == null || (algorithmParameterSpec = this.f5095c) == null) {
                throw new Exception_C10623b("key | parameterSpec cannot be null");
            }
            return new C1027a(this.f5096d, this.f5093a, key, algorithmParameterSpec, null);
        }

        /* renamed from: b */
        public b m6222b(enumEncryptAlgorithm enumEncryptAlgorithm) {
            this.f5093a = enumEncryptAlgorithm;
            return this;
        }

        /* renamed from: c */
        public b m6223c(byte[] bArr) throws Exception_C10623b {
            int i10 = a.f5092a[this.f5093a.ordinal()];
            if (i10 == 1) {
                this.f5095c = new GCMParameterSpec(128, SafeBytes.doClone(bArr));
            } else {
                if (i10 != 2 && i10 != 3) {
                    throw new Exception_C10623b("unsupported cipher alg");
                }
                this.f5095c = new IvParameterSpec(SafeBytes.doClone(bArr));
            }
            return this;
        }

        /* renamed from: d */
        public b setKey(Key key) {
            this.m_key = key;
            return this;
        }

        /* renamed from: e */
        public b getKey(String str) throws Exception_C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f5096d.m58643b());
                keyStore.load(null);
                this.m_key = keyStore.getKey(str, null);
                return this;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e10) {
                throw new Exception_C10624c("keystore get key with alias failed, " + e10.getMessage());
            }
        }

        public b(enumKeyStore enumKeyStore) {
            this.f5093a = enumEncryptAlgorithm.getAlgorithm("AES");
            this.f5096d = enumKeyStore;
        }
    }
}
