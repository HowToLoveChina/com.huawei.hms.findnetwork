package com.huawei.location.lite.common.chain;

import as.C1016d;
import com.huawei.location.lite.common.chain.AbstractC6777a;
import com.huawei.location.lite.common.chain.InterfaceC6778b;
import java.util.UUID;

/* renamed from: com.huawei.location.lite.common.chain.f */
/* loaded from: classes8.dex */
public class C6782f {

    /* renamed from: a */
    public Data f31362a;

    /* renamed from: b */
    public AbstractC6777a f31363b;

    /* renamed from: c */
    public InterfaceC6781e f31364c;

    /* renamed from: d */
    public int f31365d = 120000;

    /* renamed from: e */
    public boolean f31366e = false;

    /* renamed from: f */
    public boolean f31367f = false;

    /* renamed from: g */
    public String f31368g = UUID.randomUUID().toString();

    /* renamed from: a */
    public Data m38425a() {
        return this.f31362a;
    }

    /* renamed from: b */
    public int m38426b() {
        return this.f31365d;
    }

    /* renamed from: c */
    public Data m38427c() {
        AbstractC6777a abstractC6777a;
        AbstractC6777a abstractC6777a2 = this.f31363b;
        if (abstractC6777a2 instanceof AbstractC6777a.b) {
            abstractC6777a = (AbstractC6777a.b) abstractC6777a2;
        } else {
            if (!(abstractC6777a2 instanceof AbstractC6777a.a)) {
                return this.f31362a;
            }
            abstractC6777a = (AbstractC6777a.a) abstractC6777a2;
        }
        return abstractC6777a.m38410c();
    }

    /* renamed from: d */
    public AbstractC6777a m38428d() {
        return this.f31363b;
    }

    /* renamed from: e */
    public InterfaceC6781e m38429e() {
        return this.f31364c;
    }

    /* renamed from: f */
    public String m38430f() {
        return this.f31368g;
    }

    /* renamed from: g */
    public boolean m38431g() {
        return this.f31366e;
    }

    /* renamed from: h */
    public void m38432h(Data data) {
        this.f31362a = data;
    }

    /* renamed from: i */
    public void m38433i(boolean z10) {
        this.f31367f = z10;
    }

    /* renamed from: j */
    public void m38434j(int i10) {
        this.f31365d = i10;
    }

    /* renamed from: k */
    public void m38435k(AbstractC6777a abstractC6777a, InterfaceC6778b.a aVar) {
        InterfaceC6781e interfaceC6781e;
        boolean z10;
        this.f31363b = abstractC6777a;
        if (this.f31367f || this.f31364c == null) {
            C1016d.m6190j("TaskRequest", "request is time out,tid:" + this.f31368g);
        }
        switch (aVar.mo38414c()) {
            case 100:
                this.f31364c.mo38416b(abstractC6777a.m38410c());
                break;
            case 101:
                interfaceC6781e = this.f31364c;
                interfaceC6781e.mo38415a(abstractC6777a.m38410c());
                break;
            case 102:
                z10 = true;
                aVar.mo38413b(z10);
                break;
            case 103:
                z10 = false;
                aVar.mo38413b(z10);
                break;
            default:
                interfaceC6781e = this.f31364c;
                abstractC6777a = AbstractC6777a.m38407a();
                interfaceC6781e.mo38415a(abstractC6777a.m38410c());
                break;
        }
    }

    /* renamed from: l */
    public void m38436l(InterfaceC6781e interfaceC6781e) {
        this.f31364c = interfaceC6781e;
    }
}
