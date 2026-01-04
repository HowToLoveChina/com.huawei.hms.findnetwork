package p856zu;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import mv.C11528a;
import p238dv.EnumC9315e;
import p374iv.C10623b;

/* renamed from: zu.e */
/* loaded from: classes9.dex */
public class C14384e implements InterfaceC14385f {

    /* renamed from: a */
    public final Key f63759a;

    /* renamed from: b */
    public final AlgorithmParameterSpec f63760b;

    /* renamed from: c */
    public final C14381b f63761c;

    /* renamed from: d */
    public final EnumC9315e f63762d;

    public C14384e(EnumC9315e enumC9315e, Key key, C14381b c14381b, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f63762d = enumC9315e;
        this.f63759a = key;
        this.f63760b = algorithmParameterSpec;
        this.f63761c = c14381b;
    }

    /* renamed from: a */
    public final void m85616a() throws C10623b, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            String strM85607f = this.f63761c.m85608a().m85607f();
            EnumC9315e enumC9315e = this.f63762d;
            Cipher cipher = enumC9315e == EnumC9315e.ANDROID_KEYSTORE ? Cipher.getInstance(strM85607f) : Cipher.getInstance(strM85607f, enumC9315e.m58644e());
            cipher.init(1, this.f63759a, this.f63760b);
            C14381b c14381b = this.f63761c;
            c14381b.m85612e(cipher.doFinal(c14381b.m85610c()));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            throw new C10623b("Fail to encrypt: " + e10.getMessage());
        }
    }

    @Override // p856zu.InterfaceC14385f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14384e from(byte[] bArr) throws C10623b {
        this.f63761c.m85613f(C11528a.m68812a(bArr));
        return this;
    }

    @Override // p856zu.InterfaceC14385f
    /* renamed from: to */
    public byte[] mo56622to() throws C10623b, InvalidKeyException, InvalidAlgorithmParameterException {
        m85616a();
        return this.f63761c.m85609b();
    }
}
