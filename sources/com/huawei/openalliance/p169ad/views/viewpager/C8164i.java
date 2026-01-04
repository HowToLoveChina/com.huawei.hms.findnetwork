package com.huawei.openalliance.p169ad.views.viewpager;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.i */
/* loaded from: classes2.dex */
public class C8164i extends ViewGroup.LayoutParams {

    /* renamed from: a */
    static final int[] f38253a = {R.attr.layout_gravity};

    /* renamed from: b */
    public boolean f38254b;

    /* renamed from: c */
    public int f38255c;

    /* renamed from: d */
    float f38256d;

    /* renamed from: e */
    boolean f38257e;

    /* renamed from: f */
    int f38258f;

    /* renamed from: g */
    int f38259g;

    public C8164i() {
        super(-1, -1);
        this.f38256d = 0.0f;
    }

    public C8164i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38256d = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f38253a);
        this.f38255c = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
    }
}
