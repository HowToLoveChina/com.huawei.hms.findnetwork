package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.core.widget.C0666g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p024b0.C1085a;
import p242e.C9365a;
import p273f0.C9615n0;
import p757x.C13669a;

/* loaded from: classes.dex */
class DropDownListView extends ListView {

    /* renamed from: a */
    public final Rect f1969a;

    /* renamed from: b */
    public int f1970b;

    /* renamed from: c */
    public int f1971c;

    /* renamed from: d */
    public int f1972d;

    /* renamed from: e */
    public int f1973e;

    /* renamed from: f */
    public int f1974f;

    /* renamed from: g */
    public C0464d f1975g;

    /* renamed from: h */
    public boolean f1976h;

    /* renamed from: i */
    public boolean f1977i;

    /* renamed from: j */
    public boolean f1978j;

    /* renamed from: k */
    public C9615n0 f1979k;

    /* renamed from: l */
    public C0666g f1980l;

    /* renamed from: m */
    public RunnableC0466f f1981m;

    /* renamed from: androidx.appcompat.widget.DropDownListView$a */
    public static class C0461a {
        /* renamed from: a */
        public static void m2692a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    /* renamed from: androidx.appcompat.widget.DropDownListView$b */
    public static class C0462b {

        /* renamed from: a */
        public static Method f1982a;

        /* renamed from: b */
        public static Method f1983b;

        /* renamed from: c */
        public static Method f1984c;

        /* renamed from: d */
        public static boolean f1985d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1982a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1983b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1984c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1985d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        /* renamed from: a */
        public static boolean m2693a() {
            return f1985d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        /* renamed from: b */
        public static void m2694b(DropDownListView dropDownListView, int i10, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f1982a.invoke(dropDownListView, Integer.valueOf(i10), view, Boolean.FALSE, -1, -1);
                f1983b.invoke(dropDownListView, Integer.valueOf(i10));
                f1984c.invoke(dropDownListView, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.DropDownListView$c */
    public static class C0463c {
        /* renamed from: a */
        public static boolean m2695a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        /* renamed from: b */
        public static void m2696b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    /* renamed from: androidx.appcompat.widget.DropDownListView$d */
    public static class C0464d extends C9365a {

        /* renamed from: b */
        public boolean f1986b;

        public C0464d(Drawable drawable) {
            super(drawable);
            this.f1986b = true;
        }

        /* renamed from: b */
        public void m2697b(boolean z10) {
            this.f1986b = z10;
        }

        @Override // p242e.C9365a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1986b) {
                super.draw(canvas);
            }
        }

        @Override // p242e.C9365a, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f1986b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // p242e.C9365a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1986b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // p242e.C9365a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1986b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p242e.C9365a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1986b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.DropDownListView$e */
    public static class C0465e {

        /* renamed from: a */
        public static final Field f1987a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            f1987a = declaredField;
        }

        /* renamed from: a */
        public static boolean m2698a(AbsListView absListView) {
            Field field = f1987a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        /* renamed from: b */
        public static void m2699b(AbsListView absListView, boolean z10) throws IllegalAccessException, IllegalArgumentException {
            Field field = f1987a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z10));
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.DropDownListView$f */
    public class RunnableC0466f implements Runnable {
        public RunnableC0466f() {
        }

        /* renamed from: a */
        public void m2700a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1981m = null;
            dropDownListView.removeCallbacks(this);
        }

        /* renamed from: c */
        public void m2701c() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1981m = null;
            dropDownListView.drawableStateChanged();
        }
    }

    public DropDownListView(Context context, boolean z10) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1969a = new Rect();
        this.f1970b = 0;
        this.f1971c = 0;
        this.f1972d = 0;
        this.f1973e = 0;
        this.f1977i = z10;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z10) {
        C0464d c0464d = this.f1975g;
        if (c0464d != null) {
            c0464d.m2697b(z10);
        }
    }

    /* renamed from: a */
    public final void m2679a() {
        this.f1978j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1974f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C9615n0 c9615n0 = this.f1979k;
        if (c9615n0 != null) {
            c9615n0.m60109c();
            this.f1979k = null;
        }
    }

    /* renamed from: b */
    public final void m2680b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    /* renamed from: c */
    public final void m2681c(Canvas canvas) {
        Drawable selector;
        if (this.f1969a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1969a);
        selector.draw(canvas);
    }

    /* renamed from: d */
    public int mo2682d(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        View view = null;
        while (i15 < count) {
            int itemViewType = adapter.getItemViewType(i15);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i15, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i18 = layoutParams.height;
            view.measure(i10, i18 > 0 ? View.MeasureSpec.makeMeasureSpec(i18, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i15 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i13) {
                return (i14 < 0 || i15 <= i14 || i17 <= 0 || measuredHeight == i13) ? i13 : i17;
            }
            if (i14 >= 0 && i15 >= i14) {
                i17 = measuredHeight;
            }
            i15++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        m2681c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1981m != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m2691m();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo2683e(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m2687i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.m2680b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.m2679a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.g r9 = r7.f1980l
            if (r9 != 0) goto L5a
            androidx.core.widget.g r9 = new androidx.core.widget.g
            r9.<init>(r7)
            r7.f1980l = r9
        L5a:
            androidx.core.widget.g r9 = r7.f1980l
            r9.m4010m(r1)
            androidx.core.widget.g r9 = r7.f1980l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.g r7 = r7.f1980l
            if (r7 == 0) goto L6c
            r7.m4010m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.mo2683e(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: f */
    public final void m2684f(int i10, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f1969a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1970b;
        rect.top -= this.f1971c;
        rect.right += this.f1972d;
        rect.bottom += this.f1973e;
        boolean zM2688j = m2688j();
        if (view.isEnabled() != zM2688j) {
            m2689k(!zM2688j);
            if (i10 != -1) {
                refreshDrawableState();
            }
        }
    }

    /* renamed from: g */
    public final void m2685g(int i10, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z10 = (selector == null || i10 == -1) ? false : true;
        if (z10) {
            selector.setVisible(false, false);
        }
        m2684f(i10, view);
        if (z10) {
            Rect rect = this.f1969a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            C13669a.m82224e(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* renamed from: h */
    public final void m2686h(int i10, View view, float f10, float f11) throws IllegalAccessException, IllegalArgumentException {
        m2685g(i10, view);
        Drawable selector = getSelector();
        if (selector == null || i10 == -1) {
            return;
        }
        C13669a.m82224e(selector, f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1977i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1977i || super.hasWindowFocus();
    }

    /* renamed from: i */
    public final void m2687i(View view, int i10, float f10, float f11) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f1978j = true;
        C0461a.m2692a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.f1974f;
        if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1974f = i10;
        C0461a.m2692a(view, f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m2686h(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1977i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1977i && this.f1976h) || super.isInTouchMode();
    }

    /* renamed from: j */
    public final boolean m2688j() {
        return C1085a.m6463c() ? C0463c.m2695a(this) : C0465e.m2698a(this);
    }

    /* renamed from: k */
    public final void m2689k(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (C1085a.m6463c()) {
            C0463c.m2696b(this, z10);
        } else {
            C0465e.m2699b(this, z10);
        }
    }

    /* renamed from: l */
    public final boolean m2690l() {
        return this.f1978j;
    }

    /* renamed from: m */
    public final void m2691m() {
        Drawable selector = getSelector();
        if (selector != null && m2690l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1981m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1981m == null) {
            RunnableC0466f runnableC0466f = new RunnableC0466f();
            this.f1981m = runnableC0466f;
            runnableC0466f.m2701c();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !C0462b.m2693a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        C0462b.m2694b(this, iPointToPosition, childAt);
                    }
                }
                m2691m();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1974f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0466f runnableC0466f = this.f1981m;
        if (runnableC0466f != null) {
            runnableC0466f.m2700a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f1976h = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0464d c0464d = drawable != null ? new C0464d(drawable) : null;
        this.f1975g = c0464d;
        super.setSelector(c0464d);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1970b = rect.left;
        this.f1971c = rect.top;
        this.f1972d = rect.right;
        this.f1973e = rect.bottom;
    }
}
