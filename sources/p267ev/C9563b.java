package p267ev;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;
import mv.SafeBytes;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;

/* renamed from: ev.b */
/* loaded from: classes9.dex */
public class C9563b implements InterfaceC9567f {

    /* renamed from: a */
    public final Key f47477a;

    /* renamed from: b */
    public final AlgorithmParameterSpec f47478b;

    /* renamed from: c */
    public final C9568g f47479c;

    /* renamed from: d */
    public final enumKeyStore f47480d;

    /* renamed from: ev.b$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f47481a;

        static {
            int[] iArr = new int[EnumC9566e.values().length];
            f47481a = iArr;
            try {
                iArr[EnumC9566e.ECDSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47481a[EnumC9566e.RSA_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47481a[EnumC9566e.RSA_SHA256_PSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47481a[EnumC9566e.HMAC_SHA256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C9563b(enumKeyStore enumKeyStore, Key key, C9568g c9568g, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f47480d = enumKeyStore;
        this.f47477a = key;
        this.f47478b = algorithmParameterSpec;
        this.f47479c = c9568g;
    }

    /* renamed from: a */
    public final void m59684a() throws Exception_C10623b, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            String strM59695e = this.f47479c.m59696a().m59695e();
            enumKeyStore enumKeyStore = this.f47480d;
            Signature signature = enumKeyStore == enumKeyStore.ANDROID_KEYSTORE ? Signature.getInstance(strM59695e) : Signature.getInstance(strM59695e, enumKeyStore.m58644e());
            AlgorithmParameterSpec algorithmParameterSpec = this.f47478b;
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            Key key = this.f47477a;
            if (!(key instanceof PrivateKey)) {
                throw new Exception_C10623b("sign key not private key");
            }
            signature.initSign((PrivateKey) key);
            signature.update(this.f47479c.m59697b());
            this.f47479c.m59701f(signature.sign());
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException e10) {
            throw new Exception_C10623b("Fail to sign : " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public final void m59685b() throws Exception_C10623b, IllegalStateException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        int i10 = a.f47481a[this.f47479c.m59696a().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            m59684a();
        } else {
            if (i10 == 4) {
                m59686c();
                return;
            }
            throw new Exception_C10623b("unsupported sign alg : " + this.f47479c.m59696a().m59695e());
        }
    }

    /* renamed from: c */
    public final void m59686c() throws Exception_C10623b, IllegalStateException, InvalidKeyException {
        try {
            String strM59695e = this.f47479c.m59696a().m59695e();
            enumKeyStore enumKeyStore = this.f47480d;
            Mac mac = enumKeyStore == enumKeyStore.ANDROID_KEYSTORE ? Mac.getInstance(strM59695e) : Mac.getInstance(strM59695e, enumKeyStore.m58644e());
            mac.init(this.f47477a);
            mac.update(this.f47479c.m59697b());
            this.f47479c.m59701f(mac.doFinal());
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException e10) {
            throw new Exception_C10623b("Fail to sign : " + e10.getMessage());
        }
    }

    @Override // p267ev.InterfaceC9567f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C9563b from(String str) throws Exception_C10623b {
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // p267ev.InterfaceC9567f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C9563b from(byte[] bArr) throws Exception_C10623b {
        this.f47479c.m59700e(SafeBytes.doClone(bArr));
        return this;
    }

    @Override // p267ev.InterfaceC9567f
    public byte[] sign() throws Exception_C10623b, IllegalStateException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        m59685b();
        return this.f47479c.m59698c();
    }
}
