package com.huawei.animation.physical2;

import bh.C1243a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.animation.physical2.a */
/* loaded from: classes4.dex */
public class C4552a {

    /* renamed from: a */
    public InterfaceC4553b<Float> f20912a;

    /* renamed from: d */
    public float f20915d;

    /* renamed from: c */
    public int f20914c = 0;

    /* renamed from: b */
    public List<C1243a> f20913b = new ArrayList();

    public C4552a(InterfaceC4553b<Float> interfaceC4553b) {
        this.f20912a = interfaceC4553b;
    }

    /* renamed from: a */
    public static C4552a m27972a(int i10, int i11, float f10, InterfaceC4553b<Float> interfaceC4553b) {
        if (i10 <= 0 || interfaceC4553b == null) {
            throw new IllegalArgumentException("illegal parameter");
        }
        C4552a c4552a = new C4552a(interfaceC4553b);
        c4552a.f20912a = interfaceC4553b;
        c4552a.f20915d = f10;
        for (int i12 = 0; i12 < i10; i12++) {
            c4552a.f20913b.add(new C1243a(i11, interfaceC4553b.mo27975a(Float.valueOf(c4552a.f20915d), i12).floatValue()));
        }
        return c4552a;
    }

    /* renamed from: b */
    public float m27973b(int i10, float f10) {
        if (i10 < 0 || i10 >= this.f20913b.size() || this.f20913b.get(i10) == null) {
            throw new IllegalArgumentException("parameter out of range");
        }
        return this.f20913b.get(i10).m7443a(f10);
    }

    /* renamed from: c */
    public void m27974c(int i10) {
        if (i10 == this.f20914c) {
            return;
        }
        this.f20914c = i10;
        for (int i11 = 0; i11 < this.f20913b.size(); i11++) {
            C1243a c1243a = this.f20913b.get(i11);
            if (c1243a != null) {
                c1243a.m7444b(this.f20912a.mo27975a(Float.valueOf(this.f20915d), Math.abs(i11 - i10)).floatValue());
            }
        }
    }
}
