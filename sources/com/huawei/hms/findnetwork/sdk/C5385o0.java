package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.hms.findnetwork.sdk.o0 */
/* loaded from: classes8.dex */
public class C5385o0 {

    /* renamed from: a */
    public final List<C5382n0> f24811a = new ArrayList();

    /* renamed from: b */
    public final int f24812b;

    /* renamed from: c */
    public int f24813c;

    public C5385o0(int i10) {
        this.f24812b = i10;
    }

    /* renamed from: a */
    public final C5382n0 m32042a(int i10) {
        C5382n0 c5382n0 = new C5382n0();
        c5382n0.m32038a(new byte[this.f24813c]);
        c5382n0.m32037a(true);
        c5382n0.m32036a(i10);
        return c5382n0;
    }

    /* renamed from: b */
    public int m32045b() {
        return this.f24813c;
    }

    /* renamed from: c */
    public synchronized C5382n0 m32047c() {
        for (C5382n0 c5382n0 : this.f24811a) {
            if (c5382n0.m32041c().compareAndSet(true, false)) {
                return c5382n0;
            }
        }
        if (this.f24811a.size() >= this.f24812b) {
            return null;
        }
        C5382n0 c5382n0M32042a = m32042a(this.f24811a.size());
        this.f24811a.add(c5382n0M32042a);
        c5382n0M32042a.m32037a(false);
        return c5382n0M32042a;
    }

    /* renamed from: a */
    public synchronized void m32043a() {
        this.f24811a.clear();
    }

    /* renamed from: b */
    public void m32046b(int i10) {
        this.f24813c = i10;
    }

    /* renamed from: a */
    public synchronized void m32044a(C5382n0 c5382n0) {
        if (c5382n0 == null) {
            HmsFindSDKLog.m32127i("RecordByteArrayPool", "record byte array can not be null.");
            return;
        }
        if (this.f24811a.size() > c5382n0.m32040b()) {
            C5382n0 c5382n02 = this.f24811a.get(c5382n0.m32040b());
            Arrays.fill(c5382n02.m32039a(), (byte) 0);
            c5382n02.m32041c().set(true);
        } else {
            HmsFindSDKLog.m32127i("RecordByteArrayPool", "pool size is less than byte array's id, size is: " + this.f24811a.size() + "id is:" + c5382n0.m32040b());
        }
    }
}
