package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.AbstractC4672b;

/* renamed from: com.huawei.dynamicanimation.j */
/* loaded from: classes5.dex */
public class C4680j extends C4681k {

    /* renamed from: i */
    public final AbstractC4672b.o f21560i;

    /* renamed from: j */
    public float f21561j;

    public C4680j(float f10, float f11) {
        super(f10, f11, C4681k.DEFAULT_VALUE_THRESHOLD);
        this.f21561j = 0.0f;
        this.f21560i = new AbstractC4672b.o();
    }

    /* renamed from: d */
    public C4680j m28690d() {
        this.f21561j = 0.0f;
        AbstractC4672b.o oVar = this.f21560i;
        oVar.f21539a = 0.0f;
        oVar.f21540b = 0.0f;
        return this;
    }

    /* renamed from: e */
    public AbstractC4672b.o m28691e(long j10) {
        float f10 = this.f21561j + j10;
        this.f21561j = f10;
        float f11 = f10 / 1000.0f;
        this.f21560i.f21539a = getPosition(f11);
        this.f21560i.f21540b = getVelocity(f11);
        return this.f21560i;
    }
}
