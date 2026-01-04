package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.bm */
/* loaded from: classes8.dex */
public enum EnumC6969bm {
    CUSTOM(-1),
    UNKNOWN(0),
    ANY(1),
    LAND(2),
    PORTRAIT(3),
    SQUARE(4);


    /* renamed from: g */
    private int f32029g;

    EnumC6969bm(int i10) {
        this.f32029g = i10;
    }

    /* renamed from: a */
    public int m41048a() {
        return this.f32029g;
    }

    /* renamed from: a */
    public boolean m41049a(int i10) {
        for (int i11 = 0; i11 < values().length; i11++) {
            if (i10 == values()[i11].m41048a()) {
                return true;
            }
        }
        return false;
    }
}
