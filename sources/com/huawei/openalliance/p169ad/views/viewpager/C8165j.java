package com.huawei.openalliance.p169ad.views.viewpager;

import android.view.View;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.j */
/* loaded from: classes2.dex */
class C8165j implements Serializable, Comparator<View> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        C8164i c8164i = (C8164i) view.getLayoutParams();
        C8164i c8164i2 = (C8164i) view2.getLayoutParams();
        boolean z10 = c8164i.f38254b;
        return z10 != c8164i2.f38254b ? z10 ? 1 : -1 : c8164i.f38258f - c8164i2.f38258f;
    }
}
