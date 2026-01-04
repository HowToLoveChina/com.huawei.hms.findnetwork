package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.hms.network.embedded.lb */
/* loaded from: classes8.dex */
public final class C6001lb extends AbstractC5936gb {

    /* renamed from: b */
    public final MessageDigest f27451b;

    /* renamed from: c */
    public final Mac f27452c;

    public C6001lb(InterfaceC6170yb interfaceC6170yb, C5910eb c5910eb, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        super(interfaceC6170yb);
        try {
            Mac mac = Mac.getInstance(str);
            this.f27452c = mac;
            mac.init(new SecretKeySpec(c5910eb.mo34195m(), str));
            this.f27451b = null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C6001lb m34720a(InterfaceC6170yb interfaceC6170yb) {
        return new C6001lb(interfaceC6170yb, "MD5");
    }

    /* renamed from: b */
    public static C6001lb m34722b(InterfaceC6170yb interfaceC6170yb) {
        return new C6001lb(interfaceC6170yb, "SHA-1");
    }

    /* renamed from: c */
    public static C6001lb m34724c(InterfaceC6170yb interfaceC6170yb) {
        return new C6001lb(interfaceC6170yb, "SHA-256");
    }

    /* renamed from: d */
    public static C6001lb m34726d(InterfaceC6170yb interfaceC6170yb) {
        return new C6001lb(interfaceC6170yb, "SHA-512");
    }

    /* renamed from: f */
    public final C5910eb m34727f() {
        MessageDigest messageDigest = this.f27451b;
        return C5910eb.m34158e(messageDigest != null ? messageDigest.digest() : this.f27452c.doFinal());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IllegalStateException, IOException {
        C5883cc.m34088a(c5868bb.f26524b, 0L, j10);
        C6131vb c6131vb = c5868bb.f26523a;
        long j11 = 0;
        while (j11 < j10) {
            int iMin = (int) Math.min(j10 - j11, c6131vb.f28800c - c6131vb.f28799b);
            MessageDigest messageDigest = this.f27451b;
            if (messageDigest != null) {
                messageDigest.update(c6131vb.f28798a, c6131vb.f28799b, iMin);
            } else {
                this.f27452c.update(c6131vb.f28798a, c6131vb.f28799b, iMin);
            }
            j11 += iMin;
            c6131vb = c6131vb.f28803f;
        }
        super.write(c5868bb, j10);
    }

    public C6001lb(InterfaceC6170yb interfaceC6170yb, String str) {
        super(interfaceC6170yb);
        try {
            this.f27451b = MessageDigest.getInstance(str);
            this.f27452c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C6001lb m34721a(InterfaceC6170yb interfaceC6170yb, C5910eb c5910eb) {
        return new C6001lb(interfaceC6170yb, c5910eb, "HmacSHA1");
    }

    /* renamed from: b */
    public static C6001lb m34723b(InterfaceC6170yb interfaceC6170yb, C5910eb c5910eb) {
        return new C6001lb(interfaceC6170yb, c5910eb, "HmacSHA256");
    }

    /* renamed from: c */
    public static C6001lb m34725c(InterfaceC6170yb interfaceC6170yb, C5910eb c5910eb) {
        return new C6001lb(interfaceC6170yb, c5910eb, "HmacSHA512");
    }
}
