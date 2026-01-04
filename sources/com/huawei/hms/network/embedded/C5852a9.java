package com.huawei.hms.network.embedded;

import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.network.embedded.a9 */
/* loaded from: classes8.dex */
public final class C5852a9 {

    /* renamed from: a */
    public final Set<C6153x7> f26370a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m33827a(C6153x7 c6153x7) {
        this.f26370a.remove(c6153x7);
    }

    /* renamed from: b */
    public synchronized void m33828b(C6153x7 c6153x7) {
        this.f26370a.add(c6153x7);
    }

    /* renamed from: c */
    public synchronized boolean m33829c(C6153x7 c6153x7) {
        return this.f26370a.contains(c6153x7);
    }
}
