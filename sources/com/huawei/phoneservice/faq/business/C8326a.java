package com.huawei.phoneservice.faq.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.business.a */
/* loaded from: classes4.dex */
public final class C8326a {

    /* renamed from: a */
    public static C8326a f38730a;

    /* renamed from: b */
    public static InterfaceC8327b f38731b = new a();

    /* renamed from: com.huawei.phoneservice.faq.business.a$a */
    public class a implements InterfaceC8327b {

        /* renamed from: a */
        public final List<InterfaceC8328c> f38732a = new ArrayList();

        @Override // com.huawei.phoneservice.faq.business.InterfaceC8327b
        /* renamed from: a */
        public void mo51897a(int i10) {
            synchronized (this.f38732a) {
                try {
                    Iterator<InterfaceC8328c> it = this.f38732a.iterator();
                    while (it.hasNext()) {
                        it.next().mo51900a(i10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.phoneservice.faq.business.InterfaceC8327b
        /* renamed from: b */
        public synchronized void mo51899b(InterfaceC8328c interfaceC8328c) {
            synchronized (this.f38732a) {
                if (interfaceC8328c == null) {
                    return;
                }
                if (!this.f38732a.contains(interfaceC8328c)) {
                    this.f38732a.add(interfaceC8328c);
                }
            }
        }

        @Override // com.huawei.phoneservice.faq.business.InterfaceC8327b
        /* renamed from: a */
        public void mo51898a(InterfaceC8328c interfaceC8328c) {
            synchronized (this.f38732a) {
                this.f38732a.remove(interfaceC8328c);
            }
        }
    }

    /* renamed from: a */
    public static synchronized C8326a m51894a() {
        try {
            if (f38730a == null) {
                f38730a = new C8326a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f38730a;
    }

    /* renamed from: b */
    public static InterfaceC8327b m51895b() {
        return f38731b;
    }

    /* renamed from: c */
    public void m51896c() {
        f38731b.mo51897a(0);
    }
}
