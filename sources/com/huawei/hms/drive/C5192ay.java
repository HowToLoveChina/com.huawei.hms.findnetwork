package com.huawei.hms.drive;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.drive.ay */
/* loaded from: classes8.dex */
public final class C5192ay {

    /* renamed from: a */
    private final C5173af f23796a;

    /* renamed from: b */
    private final List<C5227cd> f23797b = new ArrayList();

    /* renamed from: c */
    private int f23798c = 0;

    public C5192ay(C5173af c5173af) {
        this.f23796a = c5173af;
    }

    /* renamed from: d */
    private C5227cd m30944d() {
        C5227cd c5227cd = null;
        int i10 = Integer.MAX_VALUE;
        for (C5227cd c5227cd2 : this.f23797b) {
            int size = c5227cd2.f24139f.size();
            if (size < c5227cd2.f24138e && !c5227cd2.f24135b && size < i10) {
                c5227cd = c5227cd2;
                i10 = size;
            }
        }
        return c5227cd;
    }

    /* renamed from: a */
    public C5173af m30945a() {
        return this.f23796a;
    }

    /* renamed from: b */
    public void m30947b(C5227cd c5227cd) {
        this.f23797b.remove(c5227cd);
    }

    /* renamed from: c */
    public C5227cd m30949c() {
        return m30944d();
    }

    /* renamed from: a */
    public void m30946a(C5227cd c5227cd) {
        if (this.f23797b.contains(c5227cd)) {
            return;
        }
        this.f23797b.add(c5227cd);
    }

    /* renamed from: b */
    public boolean m30948b() {
        return this.f23797b.isEmpty();
    }
}
