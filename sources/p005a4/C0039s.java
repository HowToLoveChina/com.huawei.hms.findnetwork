package p005a4;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import p797y3.InterfaceC13908a;

/* renamed from: a4.s */
/* loaded from: classes.dex */
public final class C0039s implements InterfaceC13908a {

    /* renamed from: a */
    public final ThreadLocal<Mac> f99a;

    /* renamed from: b */
    public final String f100b;

    /* renamed from: c */
    public final Key f101c;

    /* renamed from: d */
    public final int f102d;

    /* renamed from: a4.s$a */
    public class a extends ThreadLocal<Mac> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mac initialValue() throws InvalidKeyException {
            try {
                Mac macM134a = C0033m.f87g.m134a(C0039s.this.f100b);
                macM134a.init(C0039s.this.f101c);
                return macM134a;
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public C0039s(String str, Key key) throws GeneralSecurityException {
        a aVar = new a();
        this.f99a = aVar;
        this.f100b = str;
        this.f101c = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                this.f102d = 20;
                break;
            case "HMACSHA256":
                this.f102d = 32;
                break;
            case "HMACSHA384":
                this.f102d = 48;
                break;
            case "HMACSHA512":
                this.f102d = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        aVar.get();
    }

    @Override // p797y3.InterfaceC13908a
    /* renamed from: a */
    public byte[] mo152a(byte[] bArr, int i10) throws IllegalStateException, GeneralSecurityException {
        if (i10 > this.f102d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.f99a.get().update(bArr);
        return Arrays.copyOf(this.f99a.get().doFinal(), i10);
    }
}
