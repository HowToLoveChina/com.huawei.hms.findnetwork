package com.huawei.hms.drive;

import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.drive.cf */
/* loaded from: classes8.dex */
final class C5229cf {

    /* renamed from: a */
    private final Set<C5205bj> f24167a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m31348a(C5205bj c5205bj) {
        this.f24167a.add(c5205bj);
    }

    /* renamed from: b */
    public synchronized void m31349b(C5205bj c5205bj) {
        this.f24167a.remove(c5205bj);
    }

    /* renamed from: c */
    public synchronized boolean m31350c(C5205bj c5205bj) {
        return this.f24167a.contains(c5205bj);
    }
}
