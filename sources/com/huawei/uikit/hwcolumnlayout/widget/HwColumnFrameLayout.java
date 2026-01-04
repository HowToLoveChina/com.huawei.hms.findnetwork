package com.huawei.uikit.hwcolumnlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.uikit.hwcolumnlayout.C8707R;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwColumnFrameLayout extends FrameLayout implements HwColumnLayoutable {
    public static final int BUBBLE_TYPE = 4;
    public static final int BUTTON_TYPE = 1;
    public static final int CARD_BUTTON_TYPE = 17;
    public static final int CARD_TYPE = 3;
    public static final int CONTENT_TYPE = 0;

    /* renamed from: i */
    private static final String f41742i = "HwColumnFrameLayout";

    /* renamed from: j */
    private static final int f41743j = 1;

    /* renamed from: k */
    private static final int f41744k = 2;

    /* renamed from: l */
    private static final int f41745l = 18;

    /* renamed from: m */
    private static final int f41746m = 2;

    /* renamed from: n */
    private static final int f41747n = Integer.MIN_VALUE;

    /* renamed from: o */
    private static final int f41748o = 1;

    /* renamed from: a */
    private int f41749a;

    /* renamed from: b */
    private int f41750b;

    /* renamed from: c */
    private int f41751c;

    /* renamed from: d */
    private int f41752d;

    /* renamed from: e */
    private int f41753e;

    /* renamed from: f */
    private float f41754f;

    /* renamed from: g */
    private HwColumnSystem f41755g;

    /* renamed from: h */
    private boolean f41756h;

    public HwColumnFrameLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private boolean m54110a(int i10, int i11, float f10) {
        return i10 > 0 && i11 > 0 && Float.compare(f10, 0.0f) > 0;
    }

    /* renamed from: b */
    private void m54111b(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41755g.setColumnType(this.f41750b);
        this.f41755g.updateConfigation(context, this.f41752d, this.f41753e, this.f41754f);
        this.f41749a = this.f41755g.getSuggestWidth();
        this.f41751c = this.f41755g.getMaxColumnWidth();
    }

    /* renamed from: c */
    private void m54112c(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41755g.setColumnType(this.f41750b, false);
        this.f41755g.updateConfigation(context, true);
        this.f41749a = this.f41755g.getSuggestWidth();
        this.f41751c = this.f41755g.getMaxColumnWidth();
    }

    public static HwColumnFrameLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwColumnFrameLayout.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwColumnFrameLayout.class);
        if (objInstantiate instanceof HwColumnFrameLayout) {
            return (HwColumnFrameLayout) objInstantiate;
        }
        return null;
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m54110a(i10, i11, f10)) {
            if (this.f41756h) {
                this.f41756h = false;
                m54108a(getContext());
                m54109a(this);
                return;
            }
            return;
        }
        this.f41756h = true;
        this.f41752d = i10;
        this.f41753e = i11;
        this.f41754f = f10;
        m54108a(getContext());
        m54109a(this);
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public int getColumnType() {
        int i10 = this.f41750b;
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
        this.f41755g.setConfigurationChanged(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r1 = android.view.View.MeasureSpec.getSize(r5)
            int r2 = r4.f41750b
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
            r4.m54108a(r2)
            int r2 = r4.f41749a
            if (r2 >= r1) goto L3d
            if (r2 <= 0) goto L3d
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            goto L3d
        L33:
            int r1 = r4.m54107a(r5, r6, r1)
            if (r1 <= 0) goto L3d
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
        L3d:
            super.onMeasure(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwcolumnlayout.widget.HwColumnFrameLayout.onMeasure(int, int):void");
    }

    @Override // com.huawei.uikit.hwcolumnlayout.widget.HwColumnLayoutable
    public void setColumnType(int i10) {
        this.f41750b = i10;
        m54109a(this);
    }

    public HwColumnFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m54109a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            viewGroup.requestLayout();
            viewGroup.invalidate();
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                m54109a((ViewGroup) childAt);
            } else if (childAt != null) {
                childAt.requestLayout();
                childAt.invalidate();
            }
        }
    }

    public HwColumnFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41749a = Integer.MIN_VALUE;
        this.f41750b = Integer.MIN_VALUE;
        this.f41751c = Integer.MIN_VALUE;
        this.f41756h = false;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        this.f41755g = hwColumnSystem;
        hwColumnSystem.setConfigurationChanged(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8707R.styleable.HwColumnFrameLayout);
        this.f41750b = typedArrayObtainStyledAttributes.getInteger(C8707R.styleable.HwColumnFrameLayout_hwColumnType, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m54108a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.f41756h) {
            m54112c(getContext());
        } else {
            Log.i(f41742i, "mIsColumnConfigured is false");
            m54111b(getContext());
        }
        this.f41755g.setConfigurationChanged(false);
    }

    /* renamed from: a */
    private int m54107a(int i10, int i11, int i12) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        int i13 = 0;
        if (childCount == 1) {
            m54108a(getContext());
            View childAt = getChildAt(0);
            childAt.setMinimumWidth(this.f41749a);
            measureChild(childAt, i10, i11);
            int measuredWidth = childAt.getMeasuredWidth();
            int i14 = this.f41749a;
            if ((measuredWidth < i14 && i14 < i12) || (measuredWidth > (i14 = this.f41751c) && i14 < i12)) {
                i13 = i14;
            } else if (measuredWidth < i12) {
                i13 = measuredWidth;
            } else {
                Log.e(f41742i, "invalid width");
            }
        }
        if (childCount != 2) {
            return i13;
        }
        if (this.f41750b == 1) {
            this.f41750b = 2;
        } else {
            this.f41750b = 18;
        }
        m54108a(getContext());
        int i15 = this.f41749a;
        return i15 < i12 ? i15 : i13;
    }
}
