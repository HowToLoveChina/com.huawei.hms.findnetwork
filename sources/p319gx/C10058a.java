package p319gx;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: gx.a */
/* loaded from: classes9.dex */
public class C10058a implements InterfaceC10061d {

    /* renamed from: a */
    public Mac f49058a;

    /* renamed from: b */
    public int f49059b;

    /* renamed from: c */
    public String f49060c;

    /* renamed from: d */
    public ByteArrayOutputStream f49061d = new ByteArrayOutputStream(4096);

    public C10058a(String str) throws NoSuchAlgorithmException {
        this.f49060c = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.f49058a = mac;
            this.f49059b = mac.getMacLength();
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // p319gx.InterfaceC10061d
    /* renamed from: a */
    public byte[] mo62526a(byte[] bArr) throws IllegalStateException {
        if (this.f49061d.size() > 0) {
            m62531f(0);
        }
        return this.f49058a.doFinal(bArr);
    }

    @Override // p319gx.InterfaceC10061d
    /* renamed from: b */
    public int mo62527b() {
        return this.f49059b;
    }

    @Override // p319gx.InterfaceC10061d
    /* renamed from: c */
    public void mo62528c(byte[] bArr) throws InvalidKeyException {
        try {
            this.f49058a.init(new SecretKeySpec(bArr, this.f49060c));
        } catch (InvalidKeyException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: d */
    public byte[] m62529d() {
        return m62530e(0);
    }

    /* renamed from: e */
    public byte[] m62530e(int i10) throws IllegalStateException {
        if (this.f49061d.size() > 0) {
            m62531f(i10);
        }
        return this.f49058a.doFinal();
    }

    /* renamed from: f */
    public final void m62531f(int i10) throws IllegalStateException {
        byte[] byteArray = this.f49061d.toByteArray();
        int length = byteArray.length - i10;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 16;
            this.f49058a.update(byteArray, i11, i12 <= length ? 16 : length - i11);
            i11 = i12;
        }
        this.f49061d.reset();
    }

    /* renamed from: g */
    public void m62532g(byte[] bArr, int i10, int i11) {
        try {
            if (this.f49061d.size() + i11 > 4096) {
                m62531f(0);
            }
            this.f49061d.write(bArr, i10, i11);
        } catch (IllegalStateException e10) {
            throw new RuntimeException(e10);
        }
    }
}
