package com.huawei.openalliance.p169ad.views.gif;

import android.graphics.Bitmap;

/* renamed from: com.huawei.openalliance.ad.views.gif.c */
/* loaded from: classes2.dex */
class C8102c {

    /* renamed from: a */
    int f37751a;

    /* renamed from: b */
    Bitmap f37752b;

    /* renamed from: c */
    int f37753c;

    public C8102c() {
    }

    public C8102c(int i10, Bitmap bitmap, int i11) {
        this.f37751a = i10;
        this.f37752b = bitmap;
        this.f37753c = i11;
    }

    /* renamed from: a */
    public C8102c m50251a() {
        C8102c c8102c = new C8102c();
        c8102c.f37751a = this.f37751a;
        c8102c.f37753c = this.f37753c;
        return c8102c;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.f37751a + ", delay=" + this.f37753c + '}';
    }
}
