package p267ev;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;
import p238dv.EnumC9315e;
import p374iv.C10623b;

/* renamed from: ev.c */
/* loaded from: classes9.dex */
public class C9564c implements InterfaceC9569h {

    /* renamed from: a */
    public final Key f47482a;

    /* renamed from: b */
    public final AlgorithmParameterSpec f47483b;

    /* renamed from: c */
    public final C9568g f47484c;

    /* renamed from: d */
    public final EnumC9315e f47485d;

    /* renamed from: ev.c$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f47486a;

        static {
            int[] iArr = new int[EnumC9566e.values().length];
            f47486a = iArr;
            try {
                iArr[EnumC9566e.ECDSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47486a[EnumC9566e.RSA_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47486a[EnumC9566e.RSA_SHA256_PSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47486a[EnumC9566e.HMAC_SHA256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C9564c(EnumC9315e enumC9315e, Key key, C9568g c9568g, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f47485d = enumC9315e;
        this.f47482a = key;
        this.f47483b = algorithmParameterSpec;
        this.f47484c = c9568g;
    }

    /* renamed from: a */
    public final boolean m59689a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m59690b() throws C10623b, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            String strM59695e = this.f47484c.m59696a().m59695e();
            EnumC9315e enumC9315e = this.f47485d;
            Signature signature = enumC9315e == EnumC9315e.ANDROID_KEYSTORE ? Signature.getInstance(strM59695e) : Signature.getInstance(strM59695e, enumC9315e.m58644e());
            AlgorithmParameterSpec algorithmParameterSpec = this.f47483b;
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            Key key = this.f47482a;
            if (!(key instanceof PublicKey)) {
                throw new C10623b("verify key not public key");
            }
            signature.initVerify((PublicKey) key);
            signature.update(this.f47484c.m59697b());
            return signature.verify(this.f47484c.m59698c());
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException e10) {
            throw new C10623b("Fail to decrypt: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public final boolean m59691c() throws C10623b, IllegalStateException, InvalidKeyException {
        try {
            String strM59695e = this.f47484c.m59696a().m59695e();
            EnumC9315e enumC9315e = this.f47485d;
            Mac mac = enumC9315e == EnumC9315e.ANDROID_KEYSTORE ? Mac.getInstance(strM59695e) : Mac.getInstance(strM59695e, enumC9315e.m58644e());
            mac.init(this.f47482a);
            mac.update(this.f47484c.m59697b());
            return m59689a(this.f47484c.m59698c(), mac.doFinal());
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException e10) {
            throw new C10623b("Fail to sign : " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public final boolean m59692d() throws C10623b {
        int i10 = a.f47486a[this.f47484c.m59696a().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return m59690b();
        }
        if (i10 == 4) {
            return m59691c();
        }
        throw new C10623b("unsupported sign alg : " + this.f47484c.m59696a().m59695e());
    }

    @Override // p267ev.InterfaceC9569h
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C9564c fromData(byte[] bArr) throws C10623b {
        this.f47484c.m59700e(bArr);
        return this;
    }

    @Override // p267ev.InterfaceC9569h
    public boolean verify(byte[] bArr) throws C10623b {
        this.f47484c.m59701f(bArr);
        return m59692d();
    }
}
