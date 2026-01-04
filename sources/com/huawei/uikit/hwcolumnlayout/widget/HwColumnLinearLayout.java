package com.huawei.uikit.hwcolumnlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.uikit.hwcolumnlayout.C8707R;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwColumnLinearLayout extends LinearLayout implements HwColumnLayoutable {

    /* renamed from: g */
    private static final int f41757g = 1;

    /* renamed from: h */
    private static final int f41758h = Integer.MIN_VALUE;

    /* renamed from: i */
    private static final int f41759i = 1;

    /* renamed from: j */
    private static final int f41760j = 17;

    /* renamed from: a */
    private int f41761a;

    /* renamed from: b */
    private HwColumnSystem f41762b;

    /* renamed from: c */
    private boolean f41763c;

    /* renamed from: d */
    private int f41764d;

    /* renamed from: e */
    private int f41765e;

    /* renamed from: f */
    private float f41766f;

    public HwColumnLinearLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private boolean m54117a(int i10, int i11, float f10) {
        return i10 > 0 && i11 > 0 && f10 > 0.0f;
    }

    /* renamed from: b */
    private void m54119b(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41762b.setColumnType(this.f41761a);
        this.f41762b.updateConfigation(context, this.f41764d, this.f41765e, this.f41766f);
    }

    /* renamed from: c */
    private void m54120c(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41762b.setColumnType(this.f41761a, false);
        this.f41762b.updateConfigation(context, true);
    }

    public static HwColumnLinearLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwColumnLinearLayout.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwColumnLinearLayout.class);
        if (objInstantiate instanceof HwColumnLinearLayout) {
            return (HwColumnLinearLayout) objInstantiate;
        }
        return null;
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m54117a(i10, i11, f10)) {
            if (this.f41763c) {
                this.f41763c = false;
                m54115a(getContext());
                m54116a(this);
                return;
            }
            return;
        }
        this.f41763c = true;
        this.f41764d = i10;
        this.f41765e = i11;
        this.f41766f = f10;
        m54115a(getContext());
        m54116a(this);
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public int getColumnType() {
        int i10 = this.f41761a;
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 18) {
            return 17;
        }
        return i10;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f41762b.setConfigurationChanged(true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m54118b();
        if (this.f41761a == Integer.MIN_VALUE) {
            super.onMeasure(i10, i11);
            return;
        }
        m54115a(getContext());
        int i12 = this.f41761a;
        if (i12 == 1 || i12 == 17) {
            m54114a();
        }
        int size = View.MeasureSpec.getSize(i10);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(m54113a(size), View.MeasureSpec.getMode(i10)), i11);
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void setColumnType(int i10) {
        this.f41761a = i10;
        m54116a(this);
    }

    public HwColumnLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m54115a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f41763c) {
            m54119b(getContext());
        } else {
            m54120c(getContext());
        }
        this.f41762b.setConfigurationChanged(false);
    }

    public HwColumnLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41763c = false;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        this.f41762b = hwColumnSystem;
        hwColumnSystem.setConfigurationChanged(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8707R.styleable.HwColumnLinearLayout);
        this.f41761a = typedArrayObtainStyledAttributes.getInt(C8707R.styleable.HwColumnLinearLayout_hwColumnType, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m54118b() {
        int childCount = getChildCount();
        int i10 = this.f41761a;
        if (i10 == 1) {
            if (childCount > 1) {
                this.f41761a = 2;
                return;
            } else if (childCount == 1) {
                this.f41761a = 1;
                return;
            } else {
                this.f41761a = Integer.MIN_VALUE;
                return;
            }
        }
        if (i10 == 17) {
            if (childCount > 1) {
                this.f41761a = 18;
            } else if (childCount == 1) {
                this.f41761a = 17;
            } else {
                this.f41761a = Integer.MIN_VALUE;
            }
        }
    }

    /* renamed from: a */
    private void m54114a() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setMinimumWidth(this.f41762b.getMinColumnWidth());
        }
    }

    /* renamed from: a */
    private int m54113a(int i10) {
        int maxColumnWidth = this.f41762b.getMaxColumnWidth();
        return (maxColumnWidth < 0 || maxColumnWidth > i10) ? i10 : maxColumnWidth;
    }

    /* renamed from: a */
    private void m54116a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            viewGroup.requestLayout();
            viewGroup.invalidate();
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                m54116a((ViewGroup) childAt);
            } else if (childAt != null) {
                childAt.requestLayout();
                childAt.invalidate();
            }
        }
    }
}
