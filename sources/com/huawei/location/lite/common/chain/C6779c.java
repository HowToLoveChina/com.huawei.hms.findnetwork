package com.huawei.location.lite.common.chain;

import as.C1016d;
import com.huawei.location.lite.common.chain.AbstractC6777a;
import com.huawei.location.lite.common.chain.InterfaceC6778b;
import java.util.List;

/* renamed from: com.huawei.location.lite.common.chain.c */
/* loaded from: classes8.dex */
public class C6779c implements InterfaceC6778b.a {

    /* renamed from: a */
    public List<InterfaceC6778b> f31351a;

    /* renamed from: b */
    public int f31352b = -1;

    /* renamed from: c */
    public C6782f f31353c;

    public C6779c(List<InterfaceC6778b> list, C6782f c6782f) {
        this.f31351a = list;
        this.f31353c = c6782f;
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6778b.a
    /* renamed from: a */
    public C6782f mo38412a() {
        return this.f31353c;
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6778b.a
    /* renamed from: b */
    public AbstractC6777a mo38413b(boolean z10) {
        if (!z10) {
            this.f31352b++;
        }
        this.f31351a.get(this.f31352b).mo38411a(this);
        C1016d.m6186f("TaskChain", "tasks tid:" + mo38412a().m38430f());
        return mo38412a().m38428d();
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6778b.a
    /* renamed from: c */
    public int mo38414c() {
        if (this.f31353c.m38428d() instanceof AbstractC6777a.a) {
            return 101;
        }
        return this.f31352b == this.f31351a.size() + (-1) ? 100 : 103;
    }
}
