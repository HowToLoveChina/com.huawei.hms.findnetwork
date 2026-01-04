package p015ak;

import p399jk.AbstractC10896a;

/* renamed from: ak.e */
/* loaded from: classes6.dex */
public class C0211e {

    /* renamed from: a */
    public InterfaceC0231p f794a;

    /* renamed from: ak.e$b */
    public static class b {

        /* renamed from: a */
        public static C0211e f795a = new C0211e();
    }

    /* renamed from: c */
    public static C0211e m1344c() {
        return b.f795a;
    }

    /* renamed from: a */
    public void m1345a() {
        InterfaceC0231p interfaceC0231p = this.f794a;
        if (interfaceC0231p == null) {
            AbstractC10896a.m65886e("CommonModuleInvokerManager", "applyCloudSyncPowerKit invoker is null");
        } else {
            interfaceC0231p.mo1615b();
        }
    }

    /* renamed from: b */
    public InterfaceC0231p m1346b() {
        return this.f794a;
    }

    /* renamed from: d */
    public boolean m1347d() {
        InterfaceC0231p interfaceC0231p = this.f794a;
        if (interfaceC0231p != null) {
            return interfaceC0231p.mo1616c();
        }
        AbstractC10896a.m65886e("CommonModuleInvokerManager", "invoker is null");
        return false;
    }

    /* renamed from: e */
    public void m1348e() {
        InterfaceC0231p interfaceC0231p = this.f794a;
        if (interfaceC0231p == null) {
            AbstractC10896a.m65886e("CommonModuleInvokerManager", "removeCloudSyncPowerKit invoker is null");
        } else {
            interfaceC0231p.mo1614a();
        }
    }

    /* renamed from: f */
    public void m1349f(InterfaceC0231p interfaceC0231p) {
        this.f794a = interfaceC0231p;
    }

    public C0211e() {
    }
}
