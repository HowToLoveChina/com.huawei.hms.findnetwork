package com.huawei.uikit.hwcolumnsystem.widget;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

/* loaded from: classes7.dex */
abstract class bqmxo {

    /* renamed from: f */
    protected static final String f41986f = "HwColumnDelegate";

    /* renamed from: g */
    private static final float f41987g = 1.0E-6f;

    /* renamed from: h */
    private static final int f41988h = 0;

    /* renamed from: i */
    private static final int f41989i = 1;

    /* renamed from: j */
    private static final int f41990j = 2;

    /* renamed from: k */
    private static final int f41991k = 2;

    /* renamed from: a */
    protected int f41992a;

    /* renamed from: b */
    protected int f41993b;

    /* renamed from: c */
    protected int f41994c = 1;

    /* renamed from: d */
    private float f41995d;

    /* renamed from: e */
    private float f41996e;

    public bqmxo(Context context) {
    }

    /* renamed from: p */
    private void m54187p() {
        float f10 = this.f41995d;
        float f11 = this.f41992a;
        if (f10 < f11) {
            this.f41994c = 0;
        } else if (f10 < f11 || f10 >= this.f41993b) {
            this.f41994c = 2;
        } else {
            this.f41994c = 1;
        }
    }

    /* renamed from: a */
    public int m54188a(int i10) {
        return m54189a(i10, this.f41996e);
    }

    /* renamed from: a */
    public abstract Pair<Integer, Integer> mo54150a(float f10);

    /* renamed from: a */
    public abstract Pair<Integer, String> mo54151a(int i10, String[] strArr, float f10);

    /* renamed from: a */
    public abstract bzrwd mo54152a();

    /* renamed from: a */
    public abstract bzrwd mo54153a(int i10, int i11, int i12);

    /* renamed from: a */
    public abstract bzrwd mo54154a(int i10, Pair<Integer, Integer> pair, int i11, int i12, float f10);

    /* renamed from: b */
    public abstract int mo54155b(int i10, int i11, int i12);

    /* renamed from: b */
    public abstract bzrwd mo54156b();

    /* renamed from: b */
    public void m54192b(int i10, float f10) {
        if (Float.compare(f10, 0.0f) != 0) {
            this.f41996e = f10;
            this.f41995d = i10 / f10;
            m54187p();
        }
    }

    /* renamed from: b */
    public abstract boolean mo54157b(int i10);

    /* renamed from: c */
    public abstract bzrwd mo54158c();

    /* renamed from: c */
    public abstract bzrwd mo54159c(int i10, int i11, int i12);

    /* renamed from: d */
    public abstract bzrwd mo54160d();

    /* renamed from: d */
    public abstract bzrwd mo54161d(int i10, int i11, int i12);

    /* renamed from: e */
    public abstract bzrwd mo54162e();

    /* renamed from: f */
    public abstract bzrwd mo54163f();

    /* renamed from: g */
    public abstract bzrwd mo54164g();

    /* renamed from: h */
    public abstract bzrwd mo54165h();

    /* renamed from: i */
    public abstract bzrwd mo54166i();

    /* renamed from: j */
    public abstract bzrwd mo54167j();

    /* renamed from: k */
    public abstract bzrwd mo54168k();

    /* renamed from: l */
    public abstract bzrwd mo54169l();

    /* renamed from: m */
    public abstract bzrwd mo54170m();

    /* renamed from: n */
    public abstract bzrwd mo54171n();

    /* renamed from: o */
    public abstract int mo54172o();

    /* renamed from: a */
    public int m54189a(int i10, float f10) {
        if (Float.compare(f10, 0.0f) != 0) {
            return (int) (i10 * f10);
        }
        throw new IllegalStateException("HwColumnDelegate constructor did not call superclass implementation");
    }

    /* renamed from: a */
    public boolean m54191a(float f10, float f11) {
        return Math.abs(f10 - f11) < f41987g;
    }

    /* renamed from: a */
    public void m54190a(int[] iArr) {
        int i10;
        if (iArr != null && iArr.length >= 2) {
            int i11 = iArr[0];
            if (i11 <= 0 || (i10 = iArr[1]) <= 0) {
                throw new IllegalArgumentException("Break points value cannot be zero!");
            }
            if (i11 == i10) {
                Log.w(f41986f, "Break points cannot be the same.");
                return;
            }
            this.f41992a = Math.min(i11, i10);
            this.f41993b = Math.max(iArr[0], iArr[1]);
            m54187p();
            return;
        }
        throw new IllegalArgumentException("Break points cannot be null or length less than 2!");
    }
}
