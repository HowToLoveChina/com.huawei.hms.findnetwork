package com.huawei.hms.findnetwork.sdk;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.findnetwork.sdk.n0 */
/* loaded from: classes8.dex */
public class C5382n0 {

    /* renamed from: a */
    public ByteBuffer f24808a;

    /* renamed from: b */
    public final AtomicBoolean f24809b = new AtomicBoolean(true);

    /* renamed from: c */
    public int f24810c;

    /* renamed from: a */
    public void m32036a(int i10) {
        this.f24810c = i10;
    }

    /* renamed from: b */
    public int m32040b() {
        return this.f24810c;
    }

    /* renamed from: c */
    public AtomicBoolean m32041c() {
        return this.f24809b;
    }

    /* renamed from: a */
    public void m32037a(boolean z10) {
        this.f24809b.set(z10);
    }

    /* renamed from: a */
    public void m32038a(byte[] bArr) {
        this.f24808a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public byte[] m32039a() {
        ByteBuffer byteBuffer = this.f24808a;
        return byteBuffer == null ? new byte[0] : byteBuffer.array();
    }
}
