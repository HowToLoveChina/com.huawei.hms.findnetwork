package com.huawei.location.lite.common.chain;

import as.C1016d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.location.lite.common.chain.d */
/* loaded from: classes8.dex */
public class C6780d implements InterfaceC6781e {

    /* renamed from: a */
    public List<InterfaceC6778b> f31354a;

    /* renamed from: b */
    public C6782f f31355b;

    /* renamed from: c */
    public InterfaceC6781e f31356c;

    /* renamed from: d */
    public Data f31357d;

    /* renamed from: e */
    public boolean f31358e;

    /* renamed from: f */
    public CountDownLatch f31359f;

    /* renamed from: com.huawei.location.lite.common.chain.d$b */
    public static final class b {

        /* renamed from: a */
        public List<InterfaceC6778b> f31360a = new ArrayList();

        /* renamed from: b */
        public C6782f f31361b;

        /* renamed from: c */
        public b m38422c(InterfaceC6778b interfaceC6778b) {
            if (interfaceC6778b == null) {
                throw new IllegalArgumentException("task == null");
            }
            if (this.f31360a == null) {
                this.f31360a = new ArrayList();
            }
            this.f31360a.add(interfaceC6778b);
            return this;
        }

        /* renamed from: d */
        public C6780d m38423d() {
            return new C6780d(this);
        }

        /* renamed from: e */
        public b m38424e(C6782f c6782f) {
            this.f31361b = c6782f;
            return this;
        }
    }

    public C6780d(b bVar) {
        this.f31354a = Collections.unmodifiableList(bVar.f31360a);
        C6782f c6782f = bVar.f31361b;
        this.f31355b = c6782f;
        this.f31356c = c6782f.m38429e();
        this.f31355b.m38436l(this);
        this.f31359f = new CountDownLatch(1);
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6781e
    /* renamed from: a */
    public void mo38415a(Data data) {
        this.f31357d = data;
        this.f31358e = false;
        if (this.f31355b.m38431g()) {
            this.f31356c.mo38415a(data);
        }
        this.f31359f.countDown();
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6781e
    /* renamed from: b */
    public void mo38416b(Data data) {
        this.f31357d = data;
        this.f31358e = true;
        if (this.f31355b.m38431g()) {
            this.f31356c.mo38416b(data);
        }
        this.f31359f.countDown();
    }

    /* renamed from: c */
    public final void m38417c() throws C6783g {
        try {
            C1016d.m6186f("TaskChain", "tasks is start,tid:" + this.f31355b.m38430f());
            new C6779c(this.f31354a, this.f31355b).mo38413b(false);
            if (this.f31359f.await(this.f31355b.m38426b(), TimeUnit.MILLISECONDS)) {
                C1016d.m6186f("TaskChain", "tasks is success,tid:" + this.f31355b.m38430f());
            } else {
                C1016d.m6190j("TaskChain", "tasks is timeOut,tid:" + this.f31355b.m38430f());
                this.f31355b.m38433i(true);
                throw new C6783g("task timeout");
            }
        } catch (InterruptedException unused) {
            throw new C6783g("task interrupted");
        }
    }

    /* renamed from: d */
    public final void m38418d() throws C6783g {
        m38417c();
        if (this.f31358e) {
            this.f31356c.mo38416b(this.f31357d);
        } else {
            this.f31356c.mo38415a(this.f31357d);
        }
    }

    /* renamed from: e */
    public void m38419e() throws C6783g {
        if (this.f31354a.isEmpty()) {
            return;
        }
        if (this.f31355b.m38431g()) {
            m38417c();
        } else {
            m38418d();
        }
    }
}
