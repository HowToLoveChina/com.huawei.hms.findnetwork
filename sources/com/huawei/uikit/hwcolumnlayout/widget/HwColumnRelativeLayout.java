package com.huawei.uikit.hwcolumnlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.uikit.hwcolumnlayout.C8707R;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwColumnRelativeLayout extends RelativeLayout implements HwColumnLayoutable {
    public static final int BUBBLE_TYPE = 4;
    public static final int BUTTON_TYPE = 1;
    public static final int CARD_BUTTON_TYPE = 17;
    public static final int CARD_TYPE = 3;
    public static final int CONTENT_TYPE = 0;

    /* renamed from: i */
    private static final int f41767i = 2;

    /* renamed from: j */
    private static final int f41768j = 18;

    /* renamed from: k */
    private static final int f41769k = Integer.MIN_VALUE;

    /* renamed from: l */
    private static final String f41770l = "HwColumnFrameLayout";

    /* renamed from: m */
    private static final int f41771m = 1;

    /* renamed from: n */
    private static final int f41772n = 1;

    /* renamed from: o */
    private static final int f41773o = 2;

    /* renamed from: a */
    private int f41774a;

    /* renamed from: b */
    private int f41775b;

    /* renamed from: c */
    private int f41776c;

    /* renamed from: d */
    private HwColumnSystem f41777d;

    /* renamed from: e */
    private boolean f41778e;

    /* renamed from: f */
    private int f41779f;

    /* renamed from: g */
    private int f41780g;

    /* renamed from: h */
    private float f41781h;

    public HwColumnRelativeLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private boolean m54124a(int i10, int i11, float f10) {
        return i10 > 0 && i11 > 0 && f10 > 0.0f;
    }

    /* renamed from: b */
    private void m54125b(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41777d.setColumnType(this.f41774a);
        this.f41777d.updateConfigation(context, this.f41779f, this.f41780g, this.f41781h);
        this.f41775b = this.f41777d.getSuggestWidth();
        this.f41776c = this.f41777d.getMaxColumnWidth();
    }

    /* renamed from: c */
    private void m54126c(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41777d.setColumnType(this.f41774a, false);
        this.f41777d.updateConfigation(context, true);
        this.f41775b = this.f41777d.getSuggestWidth();
        this.f41776c = this.f41777d.getMaxColumnWidth();
    }

    public static HwColumnRelativeLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwColumnRelativeLayout.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwColumnRelativeLayout.class);
        if (objInstantiate instanceof HwColumnRelativeLayout) {
            return (HwColumnRelativeLayout) objInstantiate;
        }
        Log.d(f41770l, "return is null");
        return null;
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m54124a(i10, i11, f10)) {
            if (this.f41778e) {
                this.f41778e = false;
                m54122a(getContext());
                m54123a(this);
                return;
            }
            return;
        }
        this.f41778e = true;
        this.f41779f = i10;
        this.f41780g = i11;
        this.f41781h = f10;
        m54122a(getContext());
        m54123a(this);
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public int getColumnType() {
        int i10 = this.f41774a;
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
        this.f41777d.setConfigurationChanged(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r1 = android.view.View.MeasureSpec.getSize(r5)
            int r2 = r4.f41774a
            r3 = 17
            if (r2 == r3) goto L33
            r3 = 18
            if (r2 == r3) goto L21
            if (r2 == 0) goto L21
            r3 = 1
            if (r2 == r3) goto L33
            r3 = 2
            if (r2 == r3) goto L21
            r3 = 3
            if (r2 == r3) goto L21
            r3 = 4
            if (r2 == r3) goto L21
            goto L3d
        L21:
            android.content.Context r2 = r4.getContext()
            r4.m54122a(r2)
            int r2 = r4.f41775b
            if (r2 >= r1) goto L3d
            if (r2 <= 0) goto L3d
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            goto L3d
        L33:
            int r1 = r4.m54121a(r5, r6, r1)
            if (r1 <= 0) goto L3d
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
        L3d:
            super.onMeasure(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwcolumnlayout.widget.HwColumnRelativeLayout.onMeasure(int, int):void");
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void setColumnType(int i10) {
        this.f41774a = i10;
        m54123a(this);
    }

    public HwColumnRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m54123a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            viewGroup.requestLayout();
            viewGroup.invalidate();
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                m54123a((ViewGroup) childAt);
            } else if (childAt != null) {
                childAt.requestLayout();
                childAt.invalidate();
            }
        }
    }

    public HwColumnRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41774a = Integer.MIN_VALUE;
        this.f41775b = Integer.MIN_VALUE;
        this.f41776c = Integer.MIN_VALUE;
        this.f41778e = false;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        this.f41777d = hwColumnSystem;
        hwColumnSystem.setConfigurationChanged(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8707R.styleable.HwColumnRelativeLayout);
        this.f41774a = typedArrayObtainStyledAttributes.getInteger(C8707R.styleable.HwColumnFrameLayout_hwColumnType, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m54122a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.f41778e) {
            m54126c(getContext());
        } else {
            Log.d(f41770l, "mIsColumnConfigured is false.");
            m54125b(getContext());
        }
        this.f41777d.setConfigurationChanged(false);
    }

    /* renamed from: a */
    private int m54121a(int i10, int i11, int i12) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        int i13 = 0;
        if (childCount == 1) {
            m54122a(getContext());
            View childAt = getChildAt(0);
            childAt.setMinimumWidth(this.f41775b);
            measureChild(childAt, i10, i11);
            int measuredWidth = childAt.getMeasuredWidth();
            int i14 = this.f41775b;
            if ((measuredWidth < i14 && i14 < i12) || (measuredWidth > (i14 = this.f41776c) && i14 < i12)) {
                i13 = i14;
            } else if (measuredWidth < i12) {
                i13 = measuredWidth;
            } else {
                Log.e(f41770l, "invalid width");
            }
        }
        if (childCount != 2) {
            return i13;
        }
        if (this.f41774a == 1) {
            this.f41774a = 2;
        } else {
            this.f41774a = 18;
        }
        m54122a(getContext());
        int i15 = this.f41775b;
        return i15 < i12 ? i15 : i13;
    }
}
