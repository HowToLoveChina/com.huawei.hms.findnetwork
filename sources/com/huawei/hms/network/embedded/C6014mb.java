package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.hms.network.embedded.mb */
/* loaded from: classes8.dex */
public final class C6014mb extends AbstractC5949hb {

    /* renamed from: b */
    public final MessageDigest f27531b;

    /* renamed from: c */
    public final Mac f27532c;

    public C6014mb(InterfaceC6183zb interfaceC6183zb, C5910eb c5910eb, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        super(interfaceC6183zb);
        try {
            Mac mac = Mac.getInstance(str);
            this.f27532c = mac;
            mac.init(new SecretKeySpec(c5910eb.mo34195m(), str));
            this.f27531b = null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C6014mb m34868a(InterfaceC6183zb interfaceC6183zb) {
        return new C6014mb(interfaceC6183zb, "MD5");
    }

    /* renamed from: b */
    public static C6014mb m34870b(InterfaceC6183zb interfaceC6183zb) {
        return new C6014mb(interfaceC6183zb, "SHA-1");
    }

    /* renamed from: c */
    public final C5910eb m34873c() {
        MessageDigest messageDigest = this.f27531b;
        return C5910eb.m34158e(messageDigest != null ? messageDigest.digest() : this.f27532c.doFinal());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5949hb, com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws IllegalStateException, IOException {
        long j11 = super.read(c5868bb, j10);
        if (j11 != -1) {
            long j12 = c5868bb.f26524b;
            long j13 = j12 - j11;
            C6131vb c6131vb = c5868bb.f26523a;
            while (j12 > j13) {
                c6131vb = c6131vb.f28804g;
                j12 -= c6131vb.f28800c - c6131vb.f28799b;
            }
            while (j12 < c5868bb.f26524b) {
                int i10 = (int) ((c6131vb.f28799b + j13) - j12);
                MessageDigest messageDigest = this.f27531b;
                if (messageDigest != null) {
                    messageDigest.update(c6131vb.f28798a, i10, c6131vb.f28800c - i10);
                } else {
                    this.f27532c.update(c6131vb.f28798a, i10, c6131vb.f28800c - i10);
                }
                j13 = (c6131vb.f28800c - c6131vb.f28799b) + j12;
                c6131vb = c6131vb.f28803f;
                j12 = j13;
            }
        }
        return j11;
    }

    public C6014mb(InterfaceC6183zb interfaceC6183zb, String str) {
        super(interfaceC6183zb);
        try {
            this.f27531b = MessageDigest.getInstance(str);
            this.f27532c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C6014mb m34869a(InterfaceC6183zb interfaceC6183zb, C5910eb c5910eb) {
        return new C6014mb(interfaceC6183zb, c5910eb, "HmacSHA1");
    }

    /* renamed from: b */
    public static C6014mb m34871b(InterfaceC6183zb interfaceC6183zb, C5910eb c5910eb) {
        return new C6014mb(interfaceC6183zb, c5910eb, "HmacSHA256");
    }

    /* renamed from: c */
    public static C6014mb m34872c(InterfaceC6183zb interfaceC6183zb) {
        return new C6014mb(interfaceC6183zb, "SHA-256");
    }
}
