package com.huawei.hms.network.embedded;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.l7 */
/* loaded from: classes8.dex */
public final class C5997l7 {

    /* renamed from: a */
    public final C6048p6 f27385a;

    /* renamed from: b */
    public final List<C6167y8> f27386b = new ArrayList();

    /* renamed from: c */
    public int f27387c = 0;

    public C5997l7(C6048p6 c6048p6) {
        this.f27385a = c6048p6;
    }

    @Deprecated
    /* renamed from: d */
    private C6167y8 m34662d() {
        if (this.f27386b.isEmpty()) {
            return null;
        }
        if (this.f27387c >= this.f27386b.size()) {
            this.f27387c = 0;
        }
        int size = this.f27386b.size();
        for (int i10 = this.f27387c; i10 < size; i10++) {
            C6167y8 c6167y8 = this.f27386b.get(i10);
            if (c6167y8.f29166p.size() < c6167y8.f29165o && !c6167y8.f29161k) {
                this.f27387c++;
                return c6167y8;
            }
        }
        for (int i11 = 0; i11 < this.f27387c; i11++) {
            C6167y8 c6167y82 = this.f27386b.get(i11);
            if (c6167y82.f29166p.size() < c6167y82.f29165o && !c6167y82.f29161k) {
                this.f27387c++;
                return c6167y82;
            }
        }
        return null;
    }

    /* renamed from: e */
    private C6167y8 m34663e() {
        C6167y8 c6167y8 = null;
        int i10 = Integer.MAX_VALUE;
        for (C6167y8 c6167y82 : this.f27386b) {
            int size = c6167y82.f29166p.size();
            if (size < c6167y82.f29165o && !c6167y82.f29161k && size < i10) {
                c6167y8 = c6167y82;
                i10 = size;
            }
        }
        return c6167y8;
    }

    /* renamed from: a */
    public C6048p6 m34664a() {
        return this.f27385a;
    }

    /* renamed from: b */
    public C6167y8 m34666b() {
        return m34663e();
    }

    /* renamed from: c */
    public boolean m34668c() {
        return this.f27386b.isEmpty();
    }

    /* renamed from: a */
    public void m34665a(C6167y8 c6167y8) {
        if (this.f27386b.contains(c6167y8)) {
            return;
        }
        this.f27386b.add(c6167y8);
    }

    /* renamed from: b */
    public void m34667b(C6167y8 c6167y8) {
        this.f27386b.remove(c6167y8);
    }
}
