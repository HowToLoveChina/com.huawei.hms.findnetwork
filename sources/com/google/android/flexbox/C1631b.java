package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.flexbox.b */
/* loaded from: classes.dex */
public class C1631b {

    /* renamed from: e */
    public int f7289e;

    /* renamed from: f */
    public int f7290f;

    /* renamed from: g */
    public int f7291g;

    /* renamed from: h */
    public int f7292h;

    /* renamed from: i */
    public int f7293i;

    /* renamed from: j */
    public float f7294j;

    /* renamed from: k */
    public float f7295k;

    /* renamed from: l */
    public int f7296l;

    /* renamed from: m */
    public int f7297m;

    /* renamed from: o */
    public int f7299o;

    /* renamed from: p */
    public int f7300p;

    /* renamed from: q */
    public boolean f7301q;

    /* renamed from: r */
    public boolean f7302r;

    /* renamed from: a */
    public int f7285a = Integer.MAX_VALUE;

    /* renamed from: b */
    public int f7286b = Integer.MAX_VALUE;

    /* renamed from: c */
    public int f7287c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f7288d = Integer.MIN_VALUE;

    /* renamed from: n */
    public List<Integer> f7298n = new ArrayList();

    /* renamed from: a */
    public int m9410a() {
        return this.f7291g;
    }

    /* renamed from: b */
    public int m9411b() {
        return this.f7292h;
    }

    /* renamed from: c */
    public int m9412c() {
        return this.f7292h - this.f7293i;
    }

    /* renamed from: d */
    public void m9413d(View view, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f7285a = Math.min(this.f7285a, (view.getLeft() - flexItem.mo9250B()) - i10);
        this.f7286b = Math.min(this.f7286b, (view.getTop() - flexItem.mo9251D()) - i11);
        this.f7287c = Math.max(this.f7287c, view.getRight() + flexItem.mo9255Z() + i12);
        this.f7288d = Math.max(this.f7288d, view.getBottom() + flexItem.mo9263z() + i13);
    }
}
