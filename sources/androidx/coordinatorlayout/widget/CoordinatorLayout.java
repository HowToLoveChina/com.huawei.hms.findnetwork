package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p243e0.C9368c;
import p243e0.C9372g;
import p243e0.InterfaceC9370e;
import p273f0.C9583a0;
import p273f0.C9603h0;
import p273f0.C9614n;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p273f0.InterfaceC9636y;
import p273f0.InterfaceC9638z;
import p663u.C13106a;
import p663u.C13107b;
import p757x.C13669a;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC9636y, InterfaceC9638z {

    /* renamed from: u */
    public static final String f3246u;

    /* renamed from: v */
    public static final Class<?>[] f3247v;

    /* renamed from: w */
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> f3248w;

    /* renamed from: x */
    public static final Comparator<View> f3249x;

    /* renamed from: y */
    public static final InterfaceC9370e<Rect> f3250y;

    /* renamed from: a */
    public final List<View> f3251a;

    /* renamed from: b */
    public final C13106a<View> f3252b;

    /* renamed from: c */
    public final List<View> f3253c;

    /* renamed from: d */
    public final List<View> f3254d;

    /* renamed from: e */
    public Paint f3255e;

    /* renamed from: f */
    public final int[] f3256f;

    /* renamed from: g */
    public final int[] f3257g;

    /* renamed from: h */
    public boolean f3258h;

    /* renamed from: i */
    public boolean f3259i;

    /* renamed from: j */
    public int[] f3260j;

    /* renamed from: k */
    public View f3261k;

    /* renamed from: l */
    public View f3262l;

    /* renamed from: m */
    public ViewTreeObserverOnPreDrawListenerC0595f f3263m;

    /* renamed from: n */
    public boolean f3264n;

    /* renamed from: o */
    public C9625s0 f3265o;

    /* renamed from: p */
    public boolean f3266p;

    /* renamed from: q */
    public Drawable f3267q;

    /* renamed from: r */
    public ViewGroup.OnHierarchyChangeListener f3268r;

    /* renamed from: s */
    public InterfaceC9586b0 f3269s;

    /* renamed from: t */
    public final C9583a0 f3270t;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        /* renamed from: A */
        public boolean mo3723A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return m3752z(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        @Deprecated
        /* renamed from: B */
        public void m3724B(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        /* renamed from: C */
        public void mo3725C(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
            if (i10 == 0) {
                m3724B(coordinatorLayout, v10, view);
            }
        }

        /* renamed from: D */
        public boolean mo3726D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: a */
        public boolean m3727a(CoordinatorLayout coordinatorLayout, V v10) {
            return m3730d(coordinatorLayout, v10) > 0.0f;
        }

        /* renamed from: b */
        public boolean mo3728b(CoordinatorLayout coordinatorLayout, V v10, Rect rect) {
            return false;
        }

        /* renamed from: c */
        public int m3729c(CoordinatorLayout coordinatorLayout, V v10) {
            return -16777216;
        }

        /* renamed from: d */
        public float m3730d(CoordinatorLayout coordinatorLayout, V v10) {
            return 0.0f;
        }

        /* renamed from: e */
        public boolean mo3731e(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        /* renamed from: f */
        public C9625s0 m3732f(CoordinatorLayout coordinatorLayout, V v10, C9625s0 c9625s0) {
            return c9625s0;
        }

        /* renamed from: g */
        public void mo3733g(C0594e c0594e) {
        }

        /* renamed from: h */
        public boolean mo3734h(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        /* renamed from: i */
        public void mo3735i(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        /* renamed from: j */
        public void mo3736j() {
        }

        /* renamed from: k */
        public boolean mo3737k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: l */
        public boolean mo3738l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
            return false;
        }

        /* renamed from: m */
        public boolean mo3739m(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        /* renamed from: n */
        public boolean m3740n(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
            return false;
        }

        /* renamed from: o */
        public boolean mo3741o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        /* renamed from: p */
        public void m3742p(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        }

        /* renamed from: q */
        public void mo3743q(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                m3742p(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        /* renamed from: r */
        public void m3744r(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        /* renamed from: s */
        public void m3745s(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                m3744r(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        /* renamed from: t */
        public void mo3746t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            m3745s(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        @Deprecated
        /* renamed from: u */
        public void m3747u(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        }

        /* renamed from: v */
        public void m3748v(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                m3747u(coordinatorLayout, v10, view, view2, i10);
            }
        }

        /* renamed from: w */
        public boolean mo3749w(CoordinatorLayout coordinatorLayout, V v10, Rect rect, boolean z10) {
            return false;
        }

        /* renamed from: x */
        public void mo3750x(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        }

        /* renamed from: y */
        public Parcelable mo3751y(CoordinatorLayout coordinatorLayout, V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        /* renamed from: z */
        public boolean m3752z(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$a */
    public class C0590a implements InterfaceC9586b0 {
        public C0590a() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            return CoordinatorLayout.this.m3707a0(c9625s0);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$b */
    public interface InterfaceC0591b {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$c */
    public @interface InterfaceC0592c {
        Class<? extends Behavior> value();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$d */
    public class ViewGroupOnHierarchyChangeListenerC0593d implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroupOnHierarchyChangeListenerC0593d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f3268r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.m3697L(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f3268r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$f */
    public class ViewTreeObserverOnPreDrawListenerC0595f implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC0595f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.m3697L(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$g */
    public static class C0596g implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float fM59856M = C9603h0.m59856M(view);
            float fM59856M2 = C9603h0.m59856M(view2);
            if (fM59856M > fM59856M2) {
                return -1;
            }
            return fM59856M < fM59856M2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f3246u = r02 != null ? r02.getName() : null;
        f3249x = new C0596g();
        f3247v = new Class[]{Context.class, AttributeSet.class};
        f3248w = new ThreadLocal<>();
        f3250y = new C9372g(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: O */
    public static Behavior m3679O(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f3246u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f3248w;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f3247v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    /* renamed from: S */
    public static void m3680S(Rect rect) {
        rect.setEmpty();
        f3250y.mo58737a(rect);
    }

    /* renamed from: V */
    public static int m3681V(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    /* renamed from: W */
    public static int m3682W(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    /* renamed from: X */
    public static int m3683X(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    /* renamed from: e */
    public static Rect m3684e() {
        Rect rectMo58738b = f3250y.mo58738b();
        return rectMo58738b == null ? new Rect() : rectMo58738b;
    }

    /* renamed from: g */
    private static int m3685g(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    /* renamed from: A */
    public final int m3686A(int i10) {
        int[] iArr = this.f3260j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    /* renamed from: B */
    public void m3687B(View view, Rect rect) {
        rect.set(((C0594e) view.getLayoutParams()).m3763h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    public C0594e m3688C(View view) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        if (!c0594e.f3275b) {
            if (view instanceof InterfaceC0591b) {
                Behavior behavior = ((InterfaceC0591b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c0594e.m3770o(behavior);
                c0594e.f3275b = true;
            } else {
                InterfaceC0592c interfaceC0592c = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    interfaceC0592c = (InterfaceC0592c) superclass.getAnnotation(InterfaceC0592c.class);
                    if (interfaceC0592c != null) {
                        break;
                    }
                }
                if (interfaceC0592c != null) {
                    try {
                        c0594e.m3770o(interfaceC0592c.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0592c.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
                c0594e.f3275b = true;
            }
        }
        return c0594e;
    }

    /* renamed from: D */
    public final void m3689D(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        Comparator<View> comparator = f3249x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    /* renamed from: E */
    public final boolean m3690E(View view) {
        return this.f3252b.m78873j(view);
    }

    /* renamed from: F */
    public boolean m3691F(View view, int i10, int i11) {
        Rect rectM3684e = m3684e();
        m3720x(view, rectM3684e);
        try {
            return rectM3684e.contains(i10, i11);
        } finally {
            m3680S(rectM3684e);
        }
    }

    /* renamed from: G */
    public final void m3692G(View view, int i10) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        Rect rectM3684e = m3684e();
        rectM3684e.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0594e).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0594e).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin);
        if (this.f3265o != null && C9603h0.m59917x(this) && !C9603h0.m59917x(view)) {
            rectM3684e.left += this.f3265o.m60158j();
            rectM3684e.top += this.f3265o.m60160l();
            rectM3684e.right -= this.f3265o.m60159k();
            rectM3684e.bottom -= this.f3265o.m60157i();
        }
        Rect rectM3684e2 = m3684e();
        C9614n.m60101a(m3682W(c0594e.f3276c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectM3684e, rectM3684e2, i10);
        view.layout(rectM3684e2.left, rectM3684e2.top, rectM3684e2.right, rectM3684e2.bottom);
        m3680S(rectM3684e);
        m3680S(rectM3684e2);
    }

    /* renamed from: H */
    public final void m3693H(View view, View view2, int i10) {
        Rect rectM3684e = m3684e();
        Rect rectM3684e2 = m3684e();
        try {
            m3720x(view2, rectM3684e);
            m3721y(view, i10, rectM3684e, rectM3684e2);
            view.layout(rectM3684e2.left, rectM3684e2.top, rectM3684e2.right, rectM3684e2.bottom);
        } finally {
            m3680S(rectM3684e);
            m3680S(rectM3684e2);
        }
    }

    /* renamed from: I */
    public final void m3694I(View view, int i10, int i11) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        int iM60102b = C9614n.m60102b(m3683X(c0594e.f3276c), i11);
        int i12 = iM60102b & 7;
        int i13 = iM60102b & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int iM3686A = m3686A(i10) - measuredWidth;
        if (i12 == 1) {
            iM3686A += measuredWidth / 2;
        } else if (i12 == 5) {
            iM3686A += measuredWidth;
        }
        int i14 = i13 != 16 ? i13 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0594e).leftMargin, Math.min(iM3686A, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0594e).topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    /* renamed from: J */
    public final void m3695J(View view, Rect rect, int i10) {
        boolean z10;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (C9603h0.m59864T(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0594e c0594e = (C0594e) view.getLayoutParams();
            Behavior behaviorM3761f = c0594e.m3761f();
            Rect rectM3684e = m3684e();
            Rect rectM3684e2 = m3684e();
            rectM3684e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorM3761f == null || !behaviorM3761f.mo3728b(this, view, rectM3684e)) {
                rectM3684e.set(rectM3684e2);
            } else if (!rectM3684e2.contains(rectM3684e)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectM3684e.toShortString() + " | Bounds:" + rectM3684e2.toShortString());
            }
            m3680S(rectM3684e2);
            if (rectM3684e.isEmpty()) {
                m3680S(rectM3684e);
                return;
            }
            int iM60102b = C9614n.m60102b(c0594e.f3281h, i10);
            boolean z11 = true;
            if ((iM60102b & 48) != 48 || (i15 = (rectM3684e.top - ((ViewGroup.MarginLayoutParams) c0594e).topMargin) - c0594e.f3283j) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                m3706Z(view, i16 - i15);
                z10 = true;
            }
            if ((iM60102b & 80) == 80 && (height = ((getHeight() - rectM3684e.bottom) - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin) + c0594e.f3283j) < (i14 = rect.bottom)) {
                m3706Z(view, height - i14);
            } else if (!z10) {
                m3706Z(view, 0);
            }
            if ((iM60102b & 3) != 3 || (i12 = (rectM3684e.left - ((ViewGroup.MarginLayoutParams) c0594e).leftMargin) - c0594e.f3282i) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                m3705Y(view, i13 - i12);
            }
            if ((iM60102b & 5) == 5 && (width = ((getWidth() - rectM3684e.right) - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin) + c0594e.f3282i) < (i11 = rect.right)) {
                m3705Y(view, width - i11);
            } else if (!z11) {
                m3705Y(view, 0);
            }
            m3680S(rectM3684e);
        }
    }

    /* renamed from: K */
    public void m3696K(View view, int i10) {
        Behavior behaviorM3761f;
        C0594e c0594e = (C0594e) view.getLayoutParams();
        if (c0594e.f3284k != null) {
            Rect rectM3684e = m3684e();
            Rect rectM3684e2 = m3684e();
            Rect rectM3684e3 = m3684e();
            m3720x(c0594e.f3284k, rectM3684e);
            m3717u(view, false, rectM3684e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m3722z(view, i10, rectM3684e, rectM3684e3, c0594e, measuredWidth, measuredHeight);
            boolean z10 = (rectM3684e3.left == rectM3684e2.left && rectM3684e3.top == rectM3684e2.top) ? false : true;
            m3710h(c0594e, rectM3684e3, measuredWidth, measuredHeight);
            int i11 = rectM3684e3.left - rectM3684e2.left;
            int i12 = rectM3684e3.top - rectM3684e2.top;
            if (i11 != 0) {
                C9603h0.m59870Z(view, i11);
            }
            if (i12 != 0) {
                C9603h0.m59872a0(view, i12);
            }
            if (z10 && (behaviorM3761f = c0594e.m3761f()) != null) {
                behaviorM3761f.mo3734h(this, view, c0594e.f3284k);
            }
            m3680S(rectM3684e);
            m3680S(rectM3684e2);
            m3680S(rectM3684e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x00ca  */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3697L(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.m3697L(int):void");
    }

    /* renamed from: M */
    public void m3698M(View view, int i10) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        if (c0594e.m3756a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = c0594e.f3284k;
        if (view2 != null) {
            m3693H(view, view2, i10);
            return;
        }
        int i11 = c0594e.f3278e;
        if (i11 >= 0) {
            m3694I(view, i11, i10);
        } else {
            m3692G(view, i10);
        }
    }

    /* renamed from: N */
    public void m3699N(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    /* renamed from: P */
    public final boolean m3700P(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f3253c;
        m3689D(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zMo3737k = false;
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = list.get(i11);
            C0594e c0594e = (C0594e) view.getLayoutParams();
            Behavior behaviorM3761f = c0594e.m3761f();
            if (!(zMo3737k || z10) || actionMasked == 0) {
                if (!zMo3737k && behaviorM3761f != null) {
                    if (i10 == 0) {
                        zMo3737k = behaviorM3761f.mo3737k(this, view, motionEvent);
                    } else if (i10 == 1) {
                        zMo3737k = behaviorM3761f.mo3726D(this, view, motionEvent);
                    }
                    if (zMo3737k) {
                        this.f3261k = view;
                    }
                }
                boolean zM3758c = c0594e.m3758c();
                boolean zM3764i = c0594e.m3764i(this, view);
                z10 = zM3764i && !zM3758c;
                if (zM3764i && !z10) {
                    break;
                }
            } else if (behaviorM3761f != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i10 == 0) {
                    behaviorM3761f.mo3737k(this, view, motionEventObtain);
                } else if (i10 == 1) {
                    behaviorM3761f.mo3726D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zMo3737k;
    }

    /* renamed from: Q */
    public final void m3701Q() {
        this.f3251a.clear();
        this.f3252b.m78866c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            C0594e c0594eM3688C = m3688C(childAt);
            c0594eM3688C.m3759d(this, childAt);
            this.f3252b.m78865b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (c0594eM3688C.m3757b(this, childAt, childAt2)) {
                        if (!this.f3252b.m78867d(childAt2)) {
                            this.f3252b.m78865b(childAt2);
                        }
                        this.f3252b.m78864a(childAt2, childAt);
                    }
                }
            }
        }
        this.f3251a.addAll(this.f3252b.m78872i());
        Collections.reverse(this.f3251a);
    }

    /* renamed from: R */
    public void m3702R(View view, Rect rect) {
        ((C0594e) view.getLayoutParams()).m3772q(rect);
    }

    /* renamed from: T */
    public void m3703T() {
        if (this.f3259i && this.f3263m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f3263m);
        }
        this.f3264n = false;
    }

    /* renamed from: U */
    public final void m3704U(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            Behavior behaviorM3761f = ((C0594e) childAt.getLayoutParams()).m3761f();
            if (behaviorM3761f != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    behaviorM3761f.mo3737k(this, childAt, motionEventObtain);
                } else {
                    behaviorM3761f.mo3726D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((C0594e) getChildAt(i11).getLayoutParams()).m3768m();
        }
        this.f3261k = null;
        this.f3258h = false;
    }

    /* renamed from: Y */
    public final void m3705Y(View view, int i10) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        int i11 = c0594e.f3282i;
        if (i11 != i10) {
            C9603h0.m59870Z(view, i10 - i11);
            c0594e.f3282i = i10;
        }
    }

    /* renamed from: Z */
    public final void m3706Z(View view, int i10) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        int i11 = c0594e.f3283j;
        if (i11 != i10) {
            C9603h0.m59872a0(view, i10 - i11);
            c0594e.f3283j = i10;
        }
    }

    /* renamed from: a0 */
    public final C9625s0 m3707a0(C9625s0 c9625s0) {
        if (C9368c.m58729a(this.f3265o, c9625s0)) {
            return c9625s0;
        }
        this.f3265o = c9625s0;
        boolean z10 = false;
        boolean z11 = c9625s0 != null && c9625s0.m60160l() > 0;
        this.f3266p = z11;
        if (!z11 && getBackground() == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        C9625s0 c9625s0M3711i = m3711i(c9625s0);
        requestLayout();
        return c9625s0M3711i;
    }

    /* renamed from: b0 */
    public final void m3708b0() {
        if (!C9603h0.m59917x(this)) {
            C9603h0.m59837C0(this, null);
            return;
        }
        if (this.f3269s == null) {
            this.f3269s = new C0590a();
        }
        C9603h0.m59837C0(this, this.f3269s);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0594e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        Behavior behavior = c0594e.f3274a;
        if (behavior != null) {
            float fM3730d = behavior.m3730d(this, view);
            if (fM3730d > 0.0f) {
                if (this.f3255e == null) {
                    this.f3255e = new Paint();
                }
                this.f3255e.setColor(c0594e.f3274a.m3729c(this, view));
                this.f3255e.setAlpha(m3685g(Math.round(fM3730d * 255.0f), 0, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f3255e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3267q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidate();
        }
    }

    /* renamed from: f */
    public void m3709f() {
        if (this.f3259i) {
            if (this.f3263m == null) {
                this.f3263m = new ViewTreeObserverOnPreDrawListenerC0595f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f3263m);
        }
        this.f3264n = true;
    }

    public final List<View> getDependencySortedChildren() {
        m3701Q();
        return Collections.unmodifiableList(this.f3251a);
    }

    public final C9625s0 getLastWindowInsets() {
        return this.f3265o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3270t.m59783a();
    }

    public Drawable getStatusBarBackground() {
        return this.f3267q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* renamed from: h */
    public final void m3710h(C0594e c0594e, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0594e).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0594e).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin));
        rect.set(iMax, iMax2, i10 + iMax, i11 + iMax2);
    }

    /* renamed from: i */
    public final C9625s0 m3711i(C9625s0 c9625s0) {
        Behavior behaviorM3761f;
        if (c9625s0.m60163p()) {
            return c9625s0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (C9603h0.m59917x(childAt) && (behaviorM3761f = ((C0594e) childAt.getLayoutParams()).m3761f()) != null) {
                c9625s0 = behaviorM3761f.m3732f(this, childAt, c9625s0);
                if (c9625s0.m60163p()) {
                    break;
                }
            }
        }
        return c9625s0;
    }

    @Override // p273f0.InterfaceC9638z
    /* renamed from: j */
    public void mo2545j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        Behavior behaviorM3761f;
        boolean z10;
        int iMin;
        int childCount = getChildCount();
        boolean z11 = false;
        int iMax = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                C0594e c0594e = (C0594e) childAt.getLayoutParams();
                if (c0594e.m3765j(i14) && (behaviorM3761f = c0594e.m3761f()) != null) {
                    int[] iArr2 = this.f3256f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorM3761f.mo3746t(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f3256f;
                    iMax = i12 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i13 > 0) {
                        z10 = true;
                        iMin = Math.max(i15, this.f3256f[1]);
                    } else {
                        z10 = true;
                        iMin = Math.min(i15, this.f3256f[1]);
                    }
                    i15 = iMin;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i15;
        if (z11) {
            m3697L(1);
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: k */
    public void mo2546k(View view, int i10, int i11, int i12, int i13, int i14) {
        mo2545j(view, i10, i11, i12, i13, 0, this.f3257g);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: l */
    public boolean mo2547l(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C0594e c0594e = (C0594e) childAt.getLayoutParams();
                Behavior behaviorM3761f = c0594e.m3761f();
                if (behaviorM3761f != null) {
                    boolean zMo3723A = behaviorM3761f.mo3723A(this, childAt, view, view2, i10, i11);
                    z10 |= zMo3723A;
                    c0594e.m3773r(i11, zMo3723A);
                } else {
                    c0594e.m3773r(i11, false);
                }
            }
        }
        return z10;
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: m */
    public void mo2548m(View view, View view2, int i10, int i11) {
        Behavior behaviorM3761f;
        this.f3270t.m59785c(view, view2, i10, i11);
        this.f3262l = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            C0594e c0594e = (C0594e) childAt.getLayoutParams();
            if (c0594e.m3765j(i11) && (behaviorM3761f = c0594e.m3761f()) != null) {
                behaviorM3761f.m3748v(this, childAt, view, view2, i10, i11);
            }
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: n */
    public void mo2549n(View view, int i10) {
        this.f3270t.m59786d(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            C0594e c0594e = (C0594e) childAt.getLayoutParams();
            if (c0594e.m3765j(i10)) {
                Behavior behaviorM3761f = c0594e.m3761f();
                if (behaviorM3761f != null) {
                    behaviorM3761f.mo3725C(this, childAt, view, i10);
                }
                c0594e.m3767l(i10);
                c0594e.m3766k();
            }
        }
        this.f3262l = null;
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: o */
    public void mo2550o(View view, int i10, int i11, int[] iArr, int i12) {
        Behavior behaviorM3761f;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0594e c0594e = (C0594e) childAt.getLayoutParams();
                if (c0594e.m3765j(i12) && (behaviorM3761f = c0594e.m3761f()) != null) {
                    int[] iArr2 = this.f3256f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorM3761f.mo3743q(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f3256f;
                    iMax = i10 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f3256f;
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            m3697L(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m3704U(false);
        if (this.f3264n) {
            if (this.f3263m == null) {
                this.f3263m = new ViewTreeObserverOnPreDrawListenerC0595f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f3263m);
        }
        if (this.f3265o == null && C9603h0.m59917x(this)) {
            C9603h0.m59896m0(this);
        }
        this.f3259i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3704U(false);
        if (this.f3264n && this.f3263m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f3263m);
        }
        View view = this.f3262l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f3259i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3266p || this.f3267q == null) {
            return;
        }
        C9625s0 c9625s0 = this.f3265o;
        int iM60160l = c9625s0 != null ? c9625s0.m60160l() : 0;
        if (iM60160l > 0) {
            this.f3267q.setBounds(0, 0, getWidth(), iM60160l);
            this.f3267q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m3704U(true);
        }
        boolean zM3700P = m3700P(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m3704U(true);
        }
        return zM3700P;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Behavior behaviorM3761f;
        int iM59832A = C9603h0.m59832A(this);
        int size = this.f3251a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f3251a.get(i14);
            if (view.getVisibility() != 8 && ((behaviorM3761f = ((C0594e) view.getLayoutParams()).m3761f()) == null || !behaviorM3761f.mo3738l(this, view, iM59832A))) {
                m3698M(view, iM59832A);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00fd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        Behavior behaviorM3761f;
        int childCount = getChildCount();
        boolean zM3740n = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                C0594e c0594e = (C0594e) childAt.getLayoutParams();
                if (c0594e.m3765j(0) && (behaviorM3761f = c0594e.m3761f()) != null) {
                    zM3740n |= behaviorM3761f.m3740n(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (zM3740n) {
            m3697L(1);
        }
        return zM3740n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        Behavior behaviorM3761f;
        int childCount = getChildCount();
        boolean zMo3741o = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                C0594e c0594e = (C0594e) childAt.getLayoutParams();
                if (c0594e.m3765j(0) && (behaviorM3761f = c0594e.m3761f()) != null) {
                    zMo3741o |= behaviorM3761f.mo3741o(this, childAt, view, f10, f11);
                }
            }
        }
        return zMo3741o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        mo2550o(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        mo2546k(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        mo2548m(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f3271d;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior behaviorM3761f = m3688C(childAt).m3761f();
            if (id2 != -1 && behaviorM3761f != null && (parcelable2 = sparseArray.get(id2)) != null) {
                behaviorM3761f.mo3750x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableMo3751y;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior behaviorM3761f = ((C0594e) childAt.getLayoutParams()).m3761f();
            if (id2 != -1 && behaviorM3761f != null && (parcelableMo3751y = behaviorM3761f.mo3751y(this, childAt)) != null) {
                sparseArray.append(id2, parcelableMo3751y);
            }
        }
        savedState.f3271d = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return mo2547l(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        mo2549n(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:34:0x0024, B:29:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f3261k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.m3700P(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f3261k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0594e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.m3761f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f3261k
            boolean r6 = r6.mo3726D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f3261k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.m3704U(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public void m3712p(View view) {
        List listM78870g = this.f3252b.m78870g(view);
        if (listM78870g == null || listM78870g.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < listM78870g.size(); i10++) {
            View view2 = (View) listM78870g.get(i10);
            Behavior behaviorM3761f = ((C0594e) view2.getLayoutParams()).m3761f();
            if (behaviorM3761f != null) {
                behaviorM3761f.mo3734h(this, view2, view);
            }
        }
    }

    /* renamed from: q */
    public void m3713q() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (m3690E(getChildAt(i10))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 != this.f3264n) {
            if (z10) {
                m3709f();
            } else {
                m3703T();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: r */
    public C0594e generateDefaultLayoutParams() {
        return new C0594e(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        Behavior behaviorM3761f = ((C0594e) view.getLayoutParams()).m3761f();
        if (behaviorM3761f == null || !behaviorM3761f.mo3749w(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f3258h) {
            return;
        }
        m3704U(false);
        this.f3258h = true;
    }

    @Override // android.view.ViewGroup
    /* renamed from: s */
    public C0594e generateLayoutParams(AttributeSet attributeSet) {
        return new C0594e(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        m3708b0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f3268r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f3267q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f3267q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f3267q.setState(getDrawableState());
                }
                C13669a.m82226g(this.f3267q, C9603h0.m59832A(this));
                this.f3267q.setVisible(getVisibility() == 0, false);
                this.f3267q.setCallback(this);
            }
            C9603h0.m59884g0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? ContextCompat.getDrawable(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f3267q;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.f3267q.setVisible(z10, false);
    }

    @Override // android.view.ViewGroup
    /* renamed from: t */
    public C0594e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0594e ? new C0594e((C0594e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0594e((ViewGroup.MarginLayoutParams) layoutParams) : new C0594e(layoutParams);
    }

    /* renamed from: u */
    public void m3717u(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            m3720x(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: v */
    public List<View> m3718v(View view) {
        List<View> listM78871h = this.f3252b.m78871h(view);
        this.f3254d.clear();
        if (listM78871h != null) {
            this.f3254d.addAll(listM78871h);
        }
        return this.f3254d;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3267q;
    }

    /* renamed from: w */
    public List<View> m3719w(View view) {
        List listM78870g = this.f3252b.m78870g(view);
        this.f3254d.clear();
        if (listM78870g != null) {
            this.f3254d.addAll(listM78870g);
        }
        return this.f3254d;
    }

    /* renamed from: x */
    public void m3720x(View view, Rect rect) {
        C13107b.m78875a(this, view, rect);
    }

    /* renamed from: y */
    public void m3721y(View view, int i10, Rect rect, Rect rect2) {
        C0594e c0594e = (C0594e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m3722z(view, i10, rect, rect2, c0594e, measuredWidth, measuredHeight);
        m3710h(c0594e, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: z */
    public final void m3722z(View view, int i10, Rect rect, Rect rect2, C0594e c0594e, int i11, int i12) {
        int iM60102b = C9614n.m60102b(m3681V(c0594e.f3276c), i10);
        int iM60102b2 = C9614n.m60102b(m3682W(c0594e.f3277d), i10);
        int i13 = iM60102b & 7;
        int i14 = iM60102b & 112;
        int i15 = iM60102b2 & 7;
        int i16 = iM60102b2 & 112;
        int iWidth = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            iWidth -= i11 / 2;
        } else if (i13 != 5) {
            iWidth -= i11;
        }
        if (i14 == 16) {
            iHeight -= i12 / 2;
        } else if (i14 != 80) {
            iHeight -= i12;
        }
        rect2.set(iWidth, iHeight, i11 + iWidth, i12 + iHeight);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i10);
        this.f3251a = new ArrayList();
        this.f3252b = new C13106a<>();
        this.f3253c = new ArrayList();
        this.f3254d = new ArrayList();
        this.f3256f = new int[2];
        this.f3257g = new int[2];
        this.f3270t = new C9583a0(this);
        if (i10 == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i10, 0);
        }
        if (i10 == 0) {
            saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f3260j = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f3260j.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f3260j[i11] = (int) (r12[i11] * f10);
            }
        }
        this.f3267q = typedArrayObtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        m3708b0();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0593d());
        if (C9603h0.m59919y(this) == 0) {
            C9603h0.m59833A0(this, 1);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0589a();

        /* renamed from: d */
        public SparseArray<Parcelable> f3271d;

        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$a */
        public static class C0589a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i10 = parcel.readInt();
            int[] iArr = new int[i10];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f3271d = new SparseArray<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f3271d.append(iArr[i11], parcelableArray[i11]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f3271d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = this.f3271d.keyAt(i11);
                parcelableArr[i11] = this.f3271d.valueAt(i11);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$e */
    public static class C0594e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public Behavior f3274a;

        /* renamed from: b */
        public boolean f3275b;

        /* renamed from: c */
        public int f3276c;

        /* renamed from: d */
        public int f3277d;

        /* renamed from: e */
        public int f3278e;

        /* renamed from: f */
        public int f3279f;

        /* renamed from: g */
        public int f3280g;

        /* renamed from: h */
        public int f3281h;

        /* renamed from: i */
        public int f3282i;

        /* renamed from: j */
        public int f3283j;

        /* renamed from: k */
        public View f3284k;

        /* renamed from: l */
        public View f3285l;

        /* renamed from: m */
        public boolean f3286m;

        /* renamed from: n */
        public boolean f3287n;

        /* renamed from: o */
        public boolean f3288o;

        /* renamed from: p */
        public boolean f3289p;

        /* renamed from: q */
        public final Rect f3290q;

        /* renamed from: r */
        public Object f3291r;

        public C0594e(int i10, int i11) {
            super(i10, i11);
            this.f3275b = false;
            this.f3276c = 0;
            this.f3277d = 0;
            this.f3278e = -1;
            this.f3279f = -1;
            this.f3280g = 0;
            this.f3281h = 0;
            this.f3290q = new Rect();
        }

        /* renamed from: a */
        public boolean m3756a() {
            return this.f3284k == null && this.f3279f != -1;
        }

        /* renamed from: b */
        public boolean m3757b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.f3285l || m3774s(view2, C9603h0.m59832A(coordinatorLayout)) || ((behavior = this.f3274a) != null && behavior.mo3731e(coordinatorLayout, view, view2));
        }

        /* renamed from: c */
        public boolean m3758c() {
            if (this.f3274a == null) {
                this.f3286m = false;
            }
            return this.f3286m;
        }

        /* renamed from: d */
        public View m3759d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f3279f == -1) {
                this.f3285l = null;
                this.f3284k = null;
                return null;
            }
            if (this.f3284k == null || !m3775t(view, coordinatorLayout)) {
                m3769n(view, coordinatorLayout);
            }
            return this.f3284k;
        }

        /* renamed from: e */
        public int m3760e() {
            return this.f3279f;
        }

        /* renamed from: f */
        public Behavior m3761f() {
            return this.f3274a;
        }

        /* renamed from: g */
        public boolean m3762g() {
            return this.f3289p;
        }

        /* renamed from: h */
        public Rect m3763h() {
            return this.f3290q;
        }

        /* renamed from: i */
        public boolean m3764i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10 = this.f3286m;
            if (z10) {
                return true;
            }
            Behavior behavior = this.f3274a;
            boolean zM3727a = (behavior != null ? behavior.m3727a(coordinatorLayout, view) : false) | z10;
            this.f3286m = zM3727a;
            return zM3727a;
        }

        /* renamed from: j */
        public boolean m3765j(int i10) {
            if (i10 == 0) {
                return this.f3287n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f3288o;
        }

        /* renamed from: k */
        public void m3766k() {
            this.f3289p = false;
        }

        /* renamed from: l */
        public void m3767l(int i10) {
            m3773r(i10, false);
        }

        /* renamed from: m */
        public void m3768m() {
            this.f3286m = false;
        }

        /* renamed from: n */
        public final void m3769n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f3279f);
            this.f3284k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f3285l = null;
                    this.f3284k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f3279f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f3285l = null;
                this.f3284k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f3285l = null;
                    this.f3284k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f3285l = viewFindViewById;
        }

        /* renamed from: o */
        public void m3770o(Behavior behavior) {
            Behavior behavior2 = this.f3274a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.mo3736j();
                }
                this.f3274a = behavior;
                this.f3291r = null;
                this.f3275b = true;
                if (behavior != null) {
                    behavior.mo3733g(this);
                }
            }
        }

        /* renamed from: p */
        public void m3771p(boolean z10) {
            this.f3289p = z10;
        }

        /* renamed from: q */
        public void m3772q(Rect rect) {
            this.f3290q.set(rect);
        }

        /* renamed from: r */
        public void m3773r(int i10, boolean z10) {
            if (i10 == 0) {
                this.f3287n = z10;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f3288o = z10;
            }
        }

        /* renamed from: s */
        public final boolean m3774s(View view, int i10) {
            int iM60102b = C9614n.m60102b(((C0594e) view.getLayoutParams()).f3280g, i10);
            return iM60102b != 0 && (C9614n.m60102b(this.f3281h, i10) & iM60102b) == iM60102b;
        }

        /* renamed from: t */
        public final boolean m3775t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f3284k.getId() != this.f3279f) {
                return false;
            }
            View view2 = this.f3284k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f3285l = null;
                    this.f3284k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f3285l = view2;
            return true;
        }

        public C0594e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3275b = false;
            this.f3276c = 0;
            this.f3277d = 0;
            this.f3278e = -1;
            this.f3279f = -1;
            this.f3280g = 0;
            this.f3281h = 0;
            this.f3290q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f3276c = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f3279f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f3277d = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f3278e = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f3280g = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f3281h = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
            this.f3275b = zHasValue;
            if (zHasValue) {
                this.f3274a = CoordinatorLayout.m3679O(context, attributeSet, typedArrayObtainStyledAttributes.getString(i10));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.f3274a;
            if (behavior != null) {
                behavior.mo3733g(this);
            }
        }

        public C0594e(C0594e c0594e) {
            super((ViewGroup.MarginLayoutParams) c0594e);
            this.f3275b = false;
            this.f3276c = 0;
            this.f3277d = 0;
            this.f3278e = -1;
            this.f3279f = -1;
            this.f3280g = 0;
            this.f3281h = 0;
            this.f3290q = new Rect();
        }

        public C0594e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3275b = false;
            this.f3276c = 0;
            this.f3277d = 0;
            this.f3278e = -1;
            this.f3279f = -1;
            this.f3280g = 0;
            this.f3281h = 0;
            this.f3290q = new Rect();
        }

        public C0594e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3275b = false;
            this.f3276c = 0;
            this.f3277d = 0;
            this.f3278e = -1;
            this.f3279f = -1;
            this.f3280g = 0;
            this.f3281h = 0;
            this.f3290q = new Rect();
        }
    }
}
