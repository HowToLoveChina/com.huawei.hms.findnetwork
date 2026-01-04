package com.huawei.updatesdk.p177a.p178a.p179b;

import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.huawei.updatesdk.a.a.b.a */
/* loaded from: classes9.dex */
public final class C8775a {

    /* renamed from: b */
    private static final C8775a f45065b = new C8775a();

    /* renamed from: a */
    private final Queue<byte[]> f45066a = new ArrayDeque(0);

    private C8775a() {
    }

    /* renamed from: b */
    public static C8775a m56011b() {
        return f45065b;
    }

    /* renamed from: a */
    public void m56013a(byte[] bArr) {
        if (bArr.length == 65536) {
            synchronized (this.f45066a) {
                m56012b(bArr);
            }
        }
    }

    /* renamed from: b */
    private void m56012b(byte[] bArr) {
        if (this.f45066a.size() >= 32 || this.f45066a.offer(bArr)) {
            return;
        }
        C8777a.m56026a("ByteArrayPool", "releaseBytes false");
    }

    /* renamed from: a */
    public byte[] m56014a() {
        byte[] bArrPoll;
        synchronized (this.f45066a) {
            bArrPoll = this.f45066a.poll();
        }
        return bArrPoll == null ? new byte[65536] : bArrPoll;
    }
}
