package com.huawei.animation.physical2;

/* renamed from: com.huawei.animation.physical2.c */
/* loaded from: classes4.dex */
public class C4554c implements InterfaceC4553b<Float> {

    /* renamed from: a */
    public float f20916a;

    public C4554c() {
        this(0.0f);
    }

    @Override // com.huawei.animation.physical2.InterfaceC4553b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float mo27975a(Float f10, int i10) {
        return Float.valueOf((float) (Math.pow(i10 + 1, (-this.f20916a) * 0.18f) * f10.floatValue()));
    }

    public C4554c(float f10) {
        this.f20916a = f10;
    }
}
