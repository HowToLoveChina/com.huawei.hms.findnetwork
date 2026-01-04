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
import mv.C11528a;
import p238dv.EnumC9315e;
import p374iv.C10623b;
import p374iv.C10624c;
import p856zu.C14381b;
import p856zu.C14383d;
import p856zu.C14384e;
import p856zu.EnumC14380a;
import p856zu.InterfaceC14382c;
import p856zu.InterfaceC14385f;
import p856zu.InterfaceC14386g;

/* renamed from: av.a */
/* loaded from: classes9.dex */
public class C1027a implements InterfaceC14386g {

    /* renamed from: a */
    public final EnumC14380a f5088a;

    /* renamed from: b */
    public final EnumC9315e f5089b;

    /* renamed from: c */
    public final Key f5090c;

    /* renamed from: d */
    public final AlgorithmParameterSpec f5091d;

    /* renamed from: av.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5092a;

        static {
            int[] iArr = new int[EnumC14380a.values().length];
            f5092a = iArr;
            try {
                iArr[EnumC14380a.AES_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5092a[EnumC14380a.AES_CBC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5092a[EnumC14380a.KEY_STORE_AES_CBC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ C1027a(EnumC9315e enumC9315e, EnumC14380a enumC14380a, Key key, AlgorithmParameterSpec algorithmParameterSpec, a aVar) {
        this(enumC9315e, enumC14380a, key, algorithmParameterSpec);
    }

    @Override // p856zu.InterfaceC14386g
    public InterfaceC14382c getDecryptHandler() throws C10623b {
        C14381b c14381b = new C14381b();
        c14381b.m85611d(this.f5088a);
        return new C14383d(this.f5089b, this.f5090c, c14381b, this.f5091d);
    }

    @Override // p856zu.InterfaceC14386g
    public InterfaceC14385f getEncryptHandler() throws C10623b {
        C14381b c14381b = new C14381b();
        c14381b.m85611d(this.f5088a);
        return new C14384e(this.f5089b, this.f5090c, c14381b, this.f5091d);
    }

    public C1027a(EnumC9315e enumC9315e, EnumC14380a enumC14380a, Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f5089b = enumC9315e;
        this.f5088a = enumC14380a;
        this.f5090c = key;
        this.f5091d = algorithmParameterSpec;
    }

    /* renamed from: av.a$b */
    public static class b {

        /* renamed from: a */
        public EnumC14380a f5093a;

        /* renamed from: b */
        public Key f5094b;

        /* renamed from: c */
        public AlgorithmParameterSpec f5095c;

        /* renamed from: d */
        public final EnumC9315e f5096d;

        public b() {
            this.f5093a = EnumC14380a.m85605e("AES");
            this.f5096d = EnumC9315e.ANDROID_KEYSTORE;
        }

        /* renamed from: a */
        public C1027a m6221a() throws C10623b {
            AlgorithmParameterSpec algorithmParameterSpec;
            Key key = this.f5094b;
            if (key == null || (algorithmParameterSpec = this.f5095c) == null) {
                throw new C10623b("key | parameterSpec cannot be null");
            }
            return new C1027a(this.f5096d, this.f5093a, key, algorithmParameterSpec, null);
        }

        /* renamed from: b */
        public b m6222b(EnumC14380a enumC14380a) {
            this.f5093a = enumC14380a;
            return this;
        }

        /* renamed from: c */
        public b m6223c(byte[] bArr) throws C10623b {
            int i10 = a.f5092a[this.f5093a.ordinal()];
            if (i10 == 1) {
                this.f5095c = new GCMParameterSpec(128, C11528a.m68812a(bArr));
            } else {
                if (i10 != 2 && i10 != 3) {
                    throw new C10623b("unsupported cipher alg");
                }
                this.f5095c = new IvParameterSpec(C11528a.m68812a(bArr));
            }
            return this;
        }

        /* renamed from: d */
        public b m6224d(Key key) {
            this.f5094b = key;
            return this;
        }

        /* renamed from: e */
        public b m6225e(String str) throws C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f5096d.m58643b());
                keyStore.load(null);
                this.f5094b = keyStore.getKey(str, null);
                return this;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e10) {
                throw new C10624c("keystore get key with alias failed, " + e10.getMessage());
            }
        }

        public b(EnumC9315e enumC9315e) {
            this.f5093a = EnumC14380a.m85605e("AES");
            this.f5096d = enumC9315e;
        }
    }
}
