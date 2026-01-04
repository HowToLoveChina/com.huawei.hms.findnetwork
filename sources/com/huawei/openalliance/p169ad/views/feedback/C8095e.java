package com.huawei.openalliance.p169ad.views.feedback;

import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.views.feedback.e */
/* loaded from: classes2.dex */
public class C8095e {

    /* renamed from: b */
    private int f37662b;

    /* renamed from: a */
    private final List<View> f37661a = new ArrayList();

    /* renamed from: c */
    private int f37663c = 0;

    /* renamed from: a */
    public int m50160a() {
        return this.f37662b;
    }

    /* renamed from: a */
    public void m50161a(int i10) {
        this.f37663c = i10;
    }

    /* renamed from: a */
    public void m50162a(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (AbstractC7760bg.m47767a(this.f37661a)) {
            return;
        }
        if (i10 == -1) {
            int measuredWidth = i12 + (i14 - this.f37663c) + i11 + i15;
            for (int size = this.f37661a.size() - 1; size >= 0; size--) {
                this.f37661a.get(size).layout(measuredWidth, i13, this.f37661a.get(size).getMeasuredWidth() + measuredWidth, this.f37661a.get(size).getMeasuredHeight() + i13);
                measuredWidth += this.f37661a.get(size).getMeasuredWidth() + i15;
            }
            return;
        }
        if (i10 == 0) {
            int size2 = ((((this.f37661a.size() - 1) * i15) + i14) - this.f37663c) / (this.f37661a.size() + 1);
            for (View view : this.f37661a) {
                int i16 = i12 + size2;
                view.layout(i16, i13, view.getMeasuredWidth() + i16, view.getMeasuredHeight() + i13);
                i12 = i16 + view.getMeasuredWidth();
            }
            return;
        }
        if (i10 != 1) {
            AbstractC7185ho.m43820b("FlowLayoutLine", "lineMode error");
            return;
        }
        for (View view2 : this.f37661a) {
            view2.layout(i12, i13, view2.getMeasuredWidth() + i12, view2.getMeasuredHeight() + i13);
            i12 += view2.getMeasuredWidth() + i15;
        }
    }

    /* renamed from: a */
    public void m50163a(View view) {
        this.f37661a.add(view);
        if (this.f37662b < view.getMeasuredHeight()) {
            this.f37662b = view.getMeasuredHeight();
        }
    }
}
