package com.huawei.openalliance.p169ad.download;

/* renamed from: com.huawei.openalliance.ad.download.e */
/* loaded from: classes2.dex */
public enum EnumC7062e {
    IDLE(0),
    WAITING(1),
    DOWNLOADING(2),
    DOWNLOADED(3),
    FAILED(4),
    INSTALLING(5),
    INSTALLED(6),
    WAITING_FOR_WIFI(7);


    /* renamed from: i */
    private int f32526i;

    EnumC7062e(int i10) {
        this.f32526i = i10;
    }

    /* renamed from: a */
    public int m42596a() {
        return this.f32526i;
    }

    /* renamed from: a */
    public static EnumC7062e m42595a(int i10) {
        for (EnumC7062e enumC7062e : values()) {
            if (enumC7062e.m42596a() == i10) {
                return enumC7062e;
            }
        }
        return IDLE;
    }
}
