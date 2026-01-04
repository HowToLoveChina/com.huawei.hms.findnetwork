package com.huawei.uikit.hwspinner.widget;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.widget.C0666g;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;

/* loaded from: classes5.dex */
public class HwDropDownListView extends ListView {

    /* renamed from: g */
    private static final String f44106g = "setSelectedPositionInt";

    /* renamed from: a */
    private boolean f44107a;

    /* renamed from: b */
    private boolean f44108b;

    /* renamed from: c */
    private C0666g f44109c;

    /* renamed from: d */
    private boolean f44110d;

    /* renamed from: e */
    private int f44111e;

    /* renamed from: f */
    private int f44112f;

    public HwDropDownListView(Context context, boolean z10) {
        this(context, z10, R.attr.dropDownListViewStyle);
    }

    /* renamed from: a */
    private void m55488a() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        setPressed(false);
        HwReflectUtil.callMethod(this, "updateSelectorState", null, null, AbsListView.class);
        Object object = HwReflectUtil.getObject(this, "mMotionPosition", AbsListView.class);
        if (object instanceof Integer) {
            this.f44111e = ((Integer) object).intValue();
        }
        View childAt = getChildAt(this.f44111e - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    /* renamed from: b */
    private void m55490b() throws NoSuchMethodException, SecurityException {
        HwReflectUtil.callMethod(this, "setShowHoverEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE}, AbsListView.class);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f44108b || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f44108b || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f44108b || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (isHovered() && isFocused()) {
            return false;
        }
        return (this.f44108b && this.f44107a) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        super.layoutChildren();
    }

    public int measureHeightOfChildren(int i10, int i11) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        int count = adapter.getCount();
        View view = null;
        int i12 = 0;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = adapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i13, view, this);
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                    view.setLayoutParams(layoutParams);
                }
                int i14 = layoutParams.height;
                view.measure(i10, i14 <= 0 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
                view.forceLayout();
                int dividerHeight = (getDividerHeight() <= 0 || getDivider() == null) ? 0 : getDividerHeight();
                if (i13 > 0) {
                    measuredHeight += dividerHeight;
                }
                measuredHeight += view.getMeasuredHeight();
                if (measuredHeight >= i11) {
                    return i11;
                }
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onForwardedEvent(android.view.MotionEvent r9, int r10) throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L13
            r3 = 2
            if (r0 == r3) goto L11
            r10 = 3
            if (r0 == r10) goto L1a
        Le:
            r3 = r1
            r10 = r2
            goto L49
        L11:
            r3 = r1
            goto L14
        L13:
            r3 = r2
        L14:
            int r10 = r9.findPointerIndex(r10)
            if (r10 >= 0) goto L1d
        L1a:
            r10 = r2
            r3 = r10
            goto L49
        L1d:
            float r4 = r9.getX(r10)
            int r4 = (int) r4
            float r10 = r9.getY(r10)
            int r10 = (int) r10
            int r5 = r8.pointToPosition(r4, r10)
            r6 = -1
            if (r5 != r6) goto L30
            r10 = r1
            goto L49
        L30:
            int r3 = r8.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r8.getChildAt(r3)
            float r4 = (float) r4
            float r10 = (float) r10
            r8.m55489a(r3, r5, r4, r10)
            if (r0 != r1) goto Le
            long r6 = r8.getItemIdAtPosition(r5)
            r8.performItemClick(r3, r5, r6)
            goto Le
        L49:
            if (r3 == 0) goto L4d
            if (r10 == 0) goto L50
        L4d:
            r8.m55488a()
        L50:
            if (r3 == 0) goto L67
            androidx.core.widget.g r10 = r8.f44109c
            if (r10 != 0) goto L5d
            androidx.core.widget.g r10 = new androidx.core.widget.g
            r10.<init>(r8)
            r8.f44109c = r10
        L5d:
            androidx.core.widget.g r10 = r8.f44109c
            r10.m4010m(r1)
            androidx.core.widget.g r10 = r8.f44109c
            r10.onTouch(r8, r9)
        L67:
            androidx.core.widget.g r8 = r8.f44109c
            if (r8 == 0) goto L6e
            r8.m4010m(r2)
        L6e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwspinner.widget.HwDropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return true;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f44107a = z10;
    }

    public void setTint(int i10) {
        if (i10 != 0) {
            this.f44112f = i10;
        }
    }

    public HwDropDownListView(Context context, boolean z10, int i10) throws NoSuchMethodException, SecurityException {
        super(context, null, i10);
        this.f44107a = false;
        this.f44111e = 0;
        this.f44108b = z10;
        setDefaultFocusHighlightEnabled(false);
        m55490b();
        setCacheColorHint(0);
    }

    /* renamed from: a */
    private void m55489a(View view, int i10, float f10, float f11) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        drawableHotspotChanged(f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        Object object = HwReflectUtil.getObject(this, "mDataChanged", AdapterView.class);
        if (object instanceof Boolean) {
            this.f44110d = ((Boolean) object).booleanValue();
        }
        if (this.f44110d) {
            layoutChildren();
        }
        Object object2 = HwReflectUtil.getObject(this, "mMotionPosition", AbsListView.class);
        if (object2 instanceof Integer) {
            this.f44111e = ((Integer) object2).intValue();
        }
        View childAt = getChildAt(this.f44111e - getFirstVisiblePosition());
        if (childAt != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f44111e = i10;
        view.drawableHotspotChanged(f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        Class cls = Integer.TYPE;
        HwReflectUtil.callMethod(this, f44106g, new Class[]{cls}, new Object[]{Integer.valueOf(i10)}, AdapterView.class);
        Class cls2 = Float.TYPE;
        HwReflectUtil.callMethod(this, "positionSelectorLikeTouch", new Class[]{cls, View.class, cls2, cls2}, new Object[]{Integer.valueOf(i10), view, Float.valueOf(f10), Float.valueOf(f11)}, AbsListView.class);
        refreshDrawableState();
    }
}
