package com.huawei.openalliance.p169ad.views.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class FlowLayoutView extends ViewGroup {

    /* renamed from: a */
    private C8095e f37642a;

    /* renamed from: b */
    private int f37643b;

    /* renamed from: c */
    private int f37644c;

    /* renamed from: d */
    private int f37645d;

    /* renamed from: e */
    private int f37646e;

    /* renamed from: f */
    private final List<C8095e> f37647f;

    public FlowLayoutView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m50135a() {
        if (this.f37642a == null) {
            this.f37642a = new C8095e();
        }
    }

    /* renamed from: b */
    private void m50136b() {
        this.f37647f.clear();
        this.f37642a = new C8095e();
        this.f37646e = 0;
    }

    /* renamed from: c */
    private void m50137c() {
        int i10 = this.f37646e;
        if (i10 > 0) {
            this.f37642a.m50161a(i10 - this.f37643b);
        }
        C8095e c8095e = this.f37642a;
        if (c8095e != null) {
            this.f37647f.add(c8095e);
        }
        this.f37646e = 0;
        this.f37642a = new C8095e();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = (getMeasuredWidth() - paddingLeft) - paddingTop;
        for (C8095e c8095e : this.f37647f) {
            c8095e.m50162a(this.f37645d, getLeft(), paddingLeft, paddingTop, measuredWidth, this.f37643b);
            paddingTop = this.f37644c + c8095e.m50160a() + paddingTop;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i11) - getPaddingBottom()) - getPaddingTop();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        m50136b();
        m50135a();
        int childCount = getChildCount();
        int iM50160a = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? Integer.MIN_VALUE : mode), View.MeasureSpec.makeMeasureSpec(size2, mode2 != 1073741824 ? mode2 : Integer.MIN_VALUE));
            int measuredWidth = childAt.getMeasuredWidth();
            if (this.f37646e + measuredWidth > size) {
                m50137c();
            }
            int i13 = this.f37646e + this.f37643b + measuredWidth;
            this.f37646e = i13;
            this.f37642a.m50161a(i13);
            this.f37642a.m50163a(childAt);
        }
        C8095e c8095e = this.f37642a;
        if (c8095e != null && !this.f37647f.contains(c8095e)) {
            m50137c();
        }
        Iterator<C8095e> it = this.f37647f.iterator();
        while (it.hasNext()) {
            iM50160a += it.next().m50160a();
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.resolveSize(iM50160a + (this.f37644c * (this.f37647f.size() - 1)) + getPaddingBottom() + getPaddingTop(), i11));
    }

    public void setDefaultDisplayMode(int i10) {
        this.f37645d = i10;
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37645d = 1;
        this.f37643b = AbstractC7741ao.m47535a(context, 8.0f);
        this.f37644c = AbstractC7741ao.m47535a(context, 8.0f);
        this.f37647f = new ArrayList();
        this.f37646e = 0;
    }
}
