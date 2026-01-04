package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import com.huawei.hms.network.embedded.C6051p9;
import java.util.ArrayList;
import java.util.List;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9614n;
import p273f0.C9625s0;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;
import p413k0.C10970c;
import p723w.C13504c;
import p757x.C13669a;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: L */
    public static final int[] f3524L = {R.attr.colorPrimaryDark};

    /* renamed from: M */
    public static final int[] f3525M = {R.attr.layout_gravity};

    /* renamed from: N */
    public static final boolean f3526N = true;

    /* renamed from: O */
    public static final boolean f3527O = true;

    /* renamed from: P */
    public static boolean f3528P = true;

    /* renamed from: A */
    public CharSequence f3529A;

    /* renamed from: B */
    public Object f3530B;

    /* renamed from: C */
    public boolean f3531C;

    /* renamed from: D */
    public Drawable f3532D;

    /* renamed from: E */
    public Drawable f3533E;

    /* renamed from: F */
    public Drawable f3534F;

    /* renamed from: G */
    public Drawable f3535G;

    /* renamed from: H */
    public final ArrayList<View> f3536H;

    /* renamed from: I */
    public Rect f3537I;

    /* renamed from: J */
    public Matrix f3538J;

    /* renamed from: K */
    public final InterfaceC9835o f3539K;

    /* renamed from: a */
    public final C0677d f3540a;

    /* renamed from: b */
    public float f3541b;

    /* renamed from: c */
    public int f3542c;

    /* renamed from: d */
    public int f3543d;

    /* renamed from: e */
    public float f3544e;

    /* renamed from: f */
    public Paint f3545f;

    /* renamed from: g */
    public final C10970c f3546g;

    /* renamed from: h */
    public final C10970c f3547h;

    /* renamed from: i */
    public final C0679f f3548i;

    /* renamed from: j */
    public final C0679f f3549j;

    /* renamed from: k */
    public int f3550k;

    /* renamed from: l */
    public boolean f3551l;

    /* renamed from: m */
    public boolean f3552m;

    /* renamed from: n */
    public int f3553n;

    /* renamed from: o */
    public int f3554o;

    /* renamed from: p */
    public int f3555p;

    /* renamed from: q */
    public int f3556q;

    /* renamed from: r */
    public boolean f3557r;

    /* renamed from: s */
    public InterfaceC0678e f3558s;

    /* renamed from: t */
    public List<InterfaceC0678e> f3559t;

    /* renamed from: u */
    public float f3560u;

    /* renamed from: v */
    public float f3561v;

    /* renamed from: w */
    public Drawable f3562w;

    /* renamed from: x */
    public Drawable f3563x;

    /* renamed from: y */
    public Drawable f3564y;

    /* renamed from: z */
    public CharSequence f3565z;

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$a */
    public class C0674a implements InterfaceC9835o {
        public C0674a() {
        }

        @Override // p304g0.InterfaceC9835o
        /* renamed from: a */
        public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
            if (!DrawerLayout.this.m4123A(view) || DrawerLayout.this.m4156p(view) == 2) {
                return false;
            }
            DrawerLayout.this.m4144d(view);
            return true;
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$b */
    public class ViewOnApplyWindowInsetsListenerC0675b implements View.OnApplyWindowInsetsListener {
        public ViewOnApplyWindowInsetsListenerC0675b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).m4135M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$c */
    public class C0676c extends C9582a {

        /* renamed from: b */
        public final Rect f3577b = new Rect();

        public C0676c() {
        }

        /* renamed from: a */
        public final void m4168a(C9832l c9832l, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.m4122y(childAt)) {
                    c9832l.m61075c(childAt);
                }
            }
        }

        /* renamed from: b */
        public final void m4169b(C9832l c9832l, C9832l c9832l2) {
            Rect rect = this.f3577b;
            c9832l2.m61090k(rect);
            c9832l.m61061Q(rect);
            c9832l.m61118y0(c9832l2.m61055H());
            c9832l.m61089j0(c9832l2.m61101q());
            c9832l.m61065U(c9832l2.m61094m());
            c9832l.m61069Y(c9832l2.m61097o());
            c9832l.m61074b0(c9832l2.m61119z());
            c9832l.m61080e0(c9832l2.m61049B());
            c9832l.m61059O(c9832l2.m61111v());
            c9832l.m61104r0(c9832l2.m61053F());
            c9832l.m61071a(c9832l2.m61086i());
        }

        @Override // p273f0.C9582a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewM4154n = DrawerLayout.this.m4154n();
            if (viewM4154n == null) {
                return true;
            }
            CharSequence charSequenceM4157q = DrawerLayout.this.m4157q(DrawerLayout.this.m4158r(viewM4154n));
            if (charSequenceM4157q == null) {
                return true;
            }
            text.add(charSequenceM4157q);
            return true;
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            if (DrawerLayout.f3526N) {
                super.onInitializeAccessibilityNodeInfo(view, c9832l);
            } else {
                C9832l c9832lM61045K = C9832l.m61045K(c9832l);
                super.onInitializeAccessibilityNodeInfo(view, c9832lM61045K);
                c9832l.m61108t0(view);
                Object objM59844G = C9603h0.m59844G(view);
                if (objM59844G instanceof View) {
                    c9832l.m61093l0((View) objM59844G);
                }
                m4169b(c9832l, c9832lM61045K);
                c9832lM61045K.m61057M();
                m4168a(c9832l, (ViewGroup) view);
            }
            c9832l.m61065U("androidx.drawerlayout.widget.DrawerLayout");
            c9832l.m61078d0(false);
            c9832l.m61080e0(false);
            c9832l.m61058N(C9832l.a.f48295e);
            c9832l.m61058N(C9832l.a.f48296f);
        }

        @Override // p273f0.C9582a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f3526N || DrawerLayout.m4122y(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d */
    public static final class C0677d extends C9582a {
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            if (DrawerLayout.m4122y(view)) {
                return;
            }
            c9832l.m61093l0(null);
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$e */
    public interface InterfaceC0678e {
        /* renamed from: a */
        void m4170a(View view);

        /* renamed from: b */
        void m4171b(View view);

        /* renamed from: c */
        void m4172c(int i10);

        /* renamed from: d */
        void m4173d(View view, float f10);
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$f */
    public class C0679f extends C10970c.c {

        /* renamed from: a */
        public final int f3579a;

        /* renamed from: b */
        public C10970c f3580b;

        /* renamed from: c */
        public final Runnable f3581c = new a();

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$f$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0679f.this.m4186o();
            }
        }

        public C0679f(int i10) {
            this.f3579a = i10;
        }

        @Override // p413k0.C10970c.c
        /* renamed from: a */
        public int mo4174a(View view, int i10, int i11) {
            if (DrawerLayout.this.m4143c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i10, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i10, width));
        }

        @Override // p413k0.C10970c.c
        /* renamed from: b */
        public int mo4175b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: d */
        public int mo4176d(View view) {
            if (DrawerLayout.this.m4124B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // p413k0.C10970c.c
        /* renamed from: f */
        public void mo4177f(int i10, int i11) {
            View viewM4152l = (i10 & 1) == 1 ? DrawerLayout.this.m4152l(3) : DrawerLayout.this.m4152l(5);
            if (viewM4152l == null || DrawerLayout.this.m4156p(viewM4152l) != 0) {
                return;
            }
            this.f3580b.m66271b(viewM4152l, i11);
        }

        @Override // p413k0.C10970c.c
        /* renamed from: g */
        public boolean mo4178g(int i10) {
            return false;
        }

        @Override // p413k0.C10970c.c
        /* renamed from: h */
        public void mo4179h(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f3581c, 160L);
        }

        @Override // p413k0.C10970c.c
        /* renamed from: i */
        public void mo4180i(View view, int i10) {
            ((LayoutParams) view.getLayoutParams()).f3568c = false;
            m4185n();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: j */
        public void mo4181j(int i10) {
            DrawerLayout.this.m4140R(i10, this.f3580b.m66289v());
        }

        @Override // p413k0.C10970c.c
        /* renamed from: k */
        public void mo4182k(View view, int i10, int i11, int i12, int i13) {
            float width = (DrawerLayout.this.m4143c(view, 3) ? i10 + r3 : DrawerLayout.this.getWidth() - i10) / view.getWidth();
            DrawerLayout.this.m4137O(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: l */
        public void mo4183l(View view, float f10, float f11) {
            int i10;
            float fM4159s = DrawerLayout.this.m4159s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.m4143c(view, 3)) {
                i10 = (f10 > 0.0f || (f10 == 0.0f && fM4159s > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && fM4159s > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f3580b.m66266O(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: m */
        public boolean mo4184m(View view, int i10) {
            return DrawerLayout.this.m4124B(view) && DrawerLayout.this.m4143c(view, this.f3579a) && DrawerLayout.this.m4156p(view) == 0;
        }

        /* renamed from: n */
        public final void m4185n() {
            View viewM4152l = DrawerLayout.this.m4152l(this.f3579a == 3 ? 5 : 3);
            if (viewM4152l != null) {
                DrawerLayout.this.m4144d(viewM4152l);
            }
        }

        /* renamed from: o */
        public void m4186o() {
            View viewM4152l;
            int width;
            int iM66291x = this.f3580b.m66291x();
            boolean z10 = this.f3579a == 3;
            if (z10) {
                viewM4152l = DrawerLayout.this.m4152l(3);
                width = (viewM4152l != null ? -viewM4152l.getWidth() : 0) + iM66291x;
            } else {
                viewM4152l = DrawerLayout.this.m4152l(5);
                width = DrawerLayout.this.getWidth() - iM66291x;
            }
            if (viewM4152l != null) {
                if (((!z10 || viewM4152l.getLeft() >= width) && (z10 || viewM4152l.getLeft() <= width)) || DrawerLayout.this.m4156p(viewM4152l) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewM4152l.getLayoutParams();
                this.f3580b.m66268Q(viewM4152l, width, viewM4152l.getTop());
                layoutParams.f3568c = true;
                DrawerLayout.this.invalidate();
                m4185n();
                DrawerLayout.this.m4142b();
            }
        }

        /* renamed from: p */
        public void m4187p() {
            DrawerLayout.this.removeCallbacks(this.f3581c);
        }

        /* renamed from: q */
        public void m4188q(C10970c c10970c) {
            this.f3580b = c10970c;
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    /* renamed from: u */
    public static String m4120u(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    /* renamed from: v */
    public static boolean m4121v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* renamed from: y */
    public static boolean m4122y(View view) {
        return (C9603h0.m59919y(view) == 4 || C9603h0.m59919y(view) == 2) ? false : true;
    }

    /* renamed from: A */
    public boolean m4123A(View view) {
        if (m4124B(view)) {
            return (((LayoutParams) view.getLayoutParams()).f3569d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: B */
    public boolean m4124B(View view) {
        int iM60102b = C9614n.m60102b(((LayoutParams) view.getLayoutParams()).f3566a, C9603h0.m59832A(view));
        return ((iM60102b & 3) == 0 && (iM60102b & 5) == 0) ? false : true;
    }

    /* renamed from: C */
    public boolean m4125C(View view) {
        if (m4124B(view)) {
            return ((LayoutParams) view.getLayoutParams()).f3567b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: D */
    public final boolean m4126D(float f10, float f11, View view) {
        if (this.f3537I == null) {
            this.f3537I = new Rect();
        }
        view.getHitRect(this.f3537I);
        return this.f3537I.contains((int) f10, (int) f11);
    }

    /* renamed from: E */
    public final void m4127E(Drawable drawable, int i10) {
        if (drawable == null || !C13669a.m82222c(drawable)) {
            return;
        }
        C13669a.m82226g(drawable, i10);
    }

    /* renamed from: F */
    public void m4128F(View view, float f10) {
        float fM4159s = m4159s(view);
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (fM4159s * width));
        if (!m4143c(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        m4137O(view, f10);
    }

    /* renamed from: G */
    public void m4129G(View view) {
        m4130H(view, true);
    }

    /* renamed from: H */
    public void m4130H(View view, boolean z10) {
        if (!m4124B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f3552m) {
            layoutParams.f3567b = 1.0f;
            layoutParams.f3569d = 1;
            m4139Q(view, true);
            m4138P(view);
        } else if (z10) {
            layoutParams.f3569d |= 2;
            if (m4143c(view, 3)) {
                this.f3546g.m66268Q(view, 0, view.getTop());
            } else {
                this.f3547h.m66268Q(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            m4128F(view, 1.0f);
            m4140R(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* renamed from: I */
    public void m4131I(InterfaceC0678e interfaceC0678e) {
        List<InterfaceC0678e> list;
        if (interfaceC0678e == null || (list = this.f3559t) == null) {
            return;
        }
        list.remove(interfaceC0678e);
    }

    /* renamed from: J */
    public final Drawable m4132J() {
        int iM59832A = C9603h0.m59832A(this);
        if (iM59832A == 0) {
            Drawable drawable = this.f3532D;
            if (drawable != null) {
                m4127E(drawable, iM59832A);
                return this.f3532D;
            }
        } else {
            Drawable drawable2 = this.f3533E;
            if (drawable2 != null) {
                m4127E(drawable2, iM59832A);
                return this.f3533E;
            }
        }
        return this.f3534F;
    }

    /* renamed from: K */
    public final Drawable m4133K() {
        int iM59832A = C9603h0.m59832A(this);
        if (iM59832A == 0) {
            Drawable drawable = this.f3533E;
            if (drawable != null) {
                m4127E(drawable, iM59832A);
                return this.f3533E;
            }
        } else {
            Drawable drawable2 = this.f3532D;
            if (drawable2 != null) {
                m4127E(drawable2, iM59832A);
                return this.f3532D;
            }
        }
        return this.f3535G;
    }

    /* renamed from: L */
    public final void m4134L() {
        if (f3527O) {
            return;
        }
        this.f3563x = m4132J();
        this.f3564y = m4133K();
    }

    /* renamed from: M */
    public void m4135M(Object obj, boolean z10) {
        this.f3530B = obj;
        this.f3531C = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    /* renamed from: N */
    public void m4136N(int i10, int i11) {
        View viewM4152l;
        int iM60102b = C9614n.m60102b(i11, C9603h0.m59832A(this));
        if (i11 == 3) {
            this.f3553n = i10;
        } else if (i11 == 5) {
            this.f3554o = i10;
        } else if (i11 == 8388611) {
            this.f3555p = i10;
        } else if (i11 == 8388613) {
            this.f3556q = i10;
        }
        if (i10 != 0) {
            (iM60102b == 3 ? this.f3546g : this.f3547h).m66270a();
        }
        if (i10 != 1) {
            if (i10 == 2 && (viewM4152l = m4152l(iM60102b)) != null) {
                m4129G(viewM4152l);
                return;
            }
            return;
        }
        View viewM4152l2 = m4152l(iM60102b);
        if (viewM4152l2 != null) {
            m4144d(viewM4152l2);
        }
    }

    /* renamed from: O */
    public void m4137O(View view, float f10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f10 == layoutParams.f3567b) {
            return;
        }
        layoutParams.f3567b = f10;
        m4150j(view, f10);
    }

    /* renamed from: P */
    public final void m4138P(View view) {
        C9832l.a aVar = C9832l.a.f48315y;
        C9603h0.m59890j0(view, aVar.m61122b());
        if (!m4123A(view) || m4156p(view) == 2) {
            return;
        }
        C9603h0.m59894l0(view, aVar, null, this.f3539K);
    }

    /* renamed from: Q */
    public final void m4139Q(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((z10 || m4124B(childAt)) && !(z10 && childAt == view)) {
                C9603h0.m59833A0(childAt, 4);
            } else {
                C9603h0.m59833A0(childAt, 1);
            }
        }
    }

    /* renamed from: R */
    public void m4140R(int i10, View view) {
        int i11;
        int iM66252A = this.f3546g.m66252A();
        int iM66252A2 = this.f3547h.m66252A();
        if (iM66252A == 1 || iM66252A2 == 1) {
            i11 = 1;
        } else {
            i11 = 2;
            if (iM66252A != 2 && iM66252A2 != 2) {
                i11 = 0;
            }
        }
        if (view != null && i10 == 0) {
            float f10 = ((LayoutParams) view.getLayoutParams()).f3567b;
            if (f10 == 0.0f) {
                m4148h(view);
            } else if (f10 == 1.0f) {
                m4149i(view);
            }
        }
        if (i11 != this.f3550k) {
            this.f3550k = i11;
            List<InterfaceC0678e> list = this.f3559t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3559t.get(size).m4172c(i11);
                }
            }
        }
    }

    /* renamed from: a */
    public void m4141a(InterfaceC0678e interfaceC0678e) {
        if (interfaceC0678e == null) {
            return;
        }
        if (this.f3559t == null) {
            this.f3559t = new ArrayList();
        }
        this.f3559t.add(interfaceC0678e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (!m4124B(childAt)) {
                this.f3536H.add(childAt);
            } else if (m4123A(childAt)) {
                childAt.addFocusables(arrayList, i10, i11);
                z10 = true;
            }
        }
        if (!z10) {
            int size = this.f3536H.size();
            for (int i13 = 0; i13 < size; i13++) {
                View view = this.f3536H.get(i13);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i10, i11);
                }
            }
        }
        this.f3536H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (m4153m() != null || m4124B(view)) {
            C9603h0.m59833A0(view, 4);
        } else {
            C9603h0.m59833A0(view, 1);
        }
        if (f3526N) {
            return;
        }
        C9603h0.m59902p0(view, this.f3540a);
    }

    /* renamed from: b */
    public void m4142b() {
        if (this.f3557r) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f3557r = true;
    }

    /* renamed from: c */
    public boolean m4143c(View view, int i10) {
        return (m4158r(view) & i10) == i10;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i10).getLayoutParams()).f3567b);
        }
        this.f3544e = fMax;
        boolean zM66282m = this.f3546g.m66282m(true);
        boolean zM66282m2 = this.f3547h.m66282m(true);
        if (zM66282m || zM66282m2) {
            C9603h0.m59884g0(this);
        }
    }

    /* renamed from: d */
    public void m4144d(View view) {
        m4145e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f3544e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (m4126D(x10, y10, childAt) && !m4163z(childAt) && m4151k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        int height = getHeight();
        boolean zM4163z = m4163z(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i10 = 0;
        if (zM4163z) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view && childAt.getVisibility() == 0 && m4121v(childAt) && m4124B(childAt) && childAt.getHeight() >= height) {
                    if (m4143c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i11) {
                            i11 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        float f10 = this.f3544e;
        if (f10 > 0.0f && zM4163z) {
            this.f3545f.setColor((this.f3543d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f10)) << 24));
            canvas.drawRect(i10, 0.0f, width, getHeight(), this.f3545f);
        } else if (this.f3563x != null && m4143c(view, 3)) {
            int intrinsicWidth = this.f3563x.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f3546g.m66291x(), 1.0f));
            this.f3563x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f3563x.setAlpha((int) (fMax * 255.0f));
            this.f3563x.draw(canvas);
        } else if (this.f3564y != null && m4143c(view, 5)) {
            int intrinsicWidth2 = this.f3564y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f3547h.m66291x(), 1.0f));
            this.f3564y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f3564y.setAlpha((int) (fMax2 * 255.0f));
            this.f3564y.draw(canvas);
        }
        return zDrawChild;
    }

    /* renamed from: e */
    public void m4145e(View view, boolean z10) {
        if (!m4124B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f3552m) {
            layoutParams.f3567b = 0.0f;
            layoutParams.f3569d = 0;
        } else if (z10) {
            layoutParams.f3569d |= 4;
            if (m4143c(view, 3)) {
                this.f3546g.m66268Q(view, -view.getWidth(), view.getTop());
            } else {
                this.f3547h.m66268Q(view, getWidth(), view.getTop());
            }
        } else {
            m4128F(view, 0.0f);
            m4140R(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* renamed from: f */
    public void m4146f() {
        m4147g(false);
    }

    /* renamed from: g */
    public void m4147g(boolean z10) {
        int childCount = getChildCount();
        boolean zM66268Q = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m4124B(childAt) && (!z10 || layoutParams.f3568c)) {
                zM66268Q |= m4143c(childAt, 3) ? this.f3546g.m66268Q(childAt, -childAt.getWidth(), childAt.getTop()) : this.f3547h.m66268Q(childAt, getWidth(), childAt.getTop());
                layoutParams.f3568c = false;
            }
        }
        this.f3548i.m4187p();
        this.f3549j.m4187p();
        if (zM66268Q) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f3527O) {
            return this.f3541b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f3562w;
    }

    /* renamed from: h */
    public void m4148h(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3569d & 1) == 1) {
            layoutParams.f3569d = 0;
            List<InterfaceC0678e> list = this.f3559t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3559t.get(size).m4171b(view);
                }
            }
            m4139Q(view, false);
            m4138P(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    /* renamed from: i */
    public void m4149i(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3569d & 1) == 0) {
            layoutParams.f3569d = 1;
            List<InterfaceC0678e> list = this.f3559t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3559t.get(size).m4170a(view);
                }
            }
            m4139Q(view, true);
            m4138P(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: j */
    public void m4150j(View view, float f10) {
        List<InterfaceC0678e> list = this.f3559t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3559t.get(size).m4173d(view, f10);
            }
        }
    }

    /* renamed from: k */
    public final boolean m4151k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventM4160t = m4160t(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventM4160t);
            motionEventM4160t.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    /* renamed from: l */
    public View m4152l(int i10) {
        int iM60102b = C9614n.m60102b(i10, C9603h0.m59832A(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((m4158r(childAt) & 7) == iM60102b) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: m */
    public View m4153m() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((LayoutParams) childAt.getLayoutParams()).f3569d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: n */
    public View m4154n() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (m4124B(childAt) && m4125C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: o */
    public int m4155o(int i10) {
        int iM59832A = C9603h0.m59832A(this);
        if (i10 == 3) {
            int i11 = this.f3553n;
            if (i11 != 3) {
                return i11;
            }
            int i12 = iM59832A == 0 ? this.f3555p : this.f3556q;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        }
        if (i10 == 5) {
            int i13 = this.f3554o;
            if (i13 != 3) {
                return i13;
            }
            int i14 = iM59832A == 0 ? this.f3556q : this.f3555p;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        }
        if (i10 == 8388611) {
            int i15 = this.f3555p;
            if (i15 != 3) {
                return i15;
            }
            int i16 = iM59832A == 0 ? this.f3553n : this.f3554o;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        }
        if (i10 != 8388613) {
            return 0;
        }
        int i17 = this.f3556q;
        if (i17 != 3) {
            return i17;
        }
        int i18 = iM59832A == 0 ? this.f3554o : this.f3553n;
        if (i18 != 3) {
            return i18;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3552m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3552m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3531C || this.f3562w == null) {
            return;
        }
        Object obj = this.f3530B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f3562w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f3562w.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            k0.c r1 = r6.f3546g
            boolean r1 = r1.m66267P(r7)
            k0.c r2 = r6.f3547h
            boolean r2 = r2.m66267P(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            k0.c r7 = r6.f3546g
            boolean r7 = r7.m66273d(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f3548i
            r7.m4187p()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f3549j
            r7.m4187p()
            goto L36
        L31:
            r6.m4147g(r2)
            r6.f3557r = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3560u = r0
            r6.f3561v = r7
            float r4 = r6.f3544e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            k0.c r4 = r6.f3546g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.m66287t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.m4163z(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.f3557r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.m4161w()
            if (r7 != 0) goto L70
            boolean r6 = r6.f3557r
            if (r6 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !m4162x()) {
            return super.onKeyDown(i10, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View viewM4154n = m4154n();
        if (viewM4154n != null && m4156p(viewM4154n) == 0) {
            m4146f();
        }
        return viewM4154n != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        boolean z11 = true;
        this.f3551l = true;
        int i15 = i12 - i10;
        int childCount = getChildCount();
        int i16 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m4163z(childAt)) {
                    int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i17, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i17, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m4143c(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (layoutParams.f3567b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i15 - r11) / f12;
                        i14 = i15 - ((int) (layoutParams.f3567b * f12));
                    }
                    boolean z12 = f10 != layoutParams.f3567b ? z11 : false;
                    int i18 = layoutParams.f3566a & 112;
                    if (i18 == 16) {
                        int i19 = i13 - i11;
                        int i20 = (i19 - measuredHeight) / 2;
                        int i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i20 < i21) {
                            i20 = i21;
                        } else {
                            int i22 = i20 + measuredHeight;
                            int i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i22 > i19 - i23) {
                                i20 = (i19 - i23) - measuredHeight;
                            }
                        }
                        childAt.layout(i14, i20, measuredWidth + i14, measuredHeight + i20);
                    } else if (i18 != 80) {
                        int i24 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i14, i24, measuredWidth + i14, measuredHeight + i24);
                    } else {
                        int i25 = i13 - i11;
                        childAt.layout(i14, (i25 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i14, i25 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z12) {
                        m4137O(childAt, f10);
                    }
                    int i26 = layoutParams.f3567b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i26) {
                        childAt.setVisibility(i26);
                    }
                }
            }
            i16++;
            z11 = true;
        }
        if (f3528P && (rootWindowInsets = getRootWindowInsets()) != null) {
            C13504c c13504cM60156h = C9625s0.m60147v(rootWindowInsets).m60156h();
            C10970c c10970c = this.f3546g;
            c10970c.m66263L(Math.max(c10970c.m66290w(), c13504cM60156h.f60770a));
            C10970c c10970c2 = this.f3547h;
            c10970c2.m66263L(Math.max(c10970c2.m66290w(), c13504cM60156h.f60772c));
        }
        this.f3551l = false;
        this.f3552m = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z10 = this.f3530B != null && C9603h0.m59917x(this);
        int iM59832A = C9603h0.m59832A(this);
        int childCount = getChildCount();
        boolean z11 = false;
        boolean z12 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z10) {
                    int iM60102b = C9614n.m60102b(layoutParams.f3566a, iM59832A);
                    if (C9603h0.m59917x(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.f3530B;
                        if (iM60102b == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iM60102b == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.f3530B;
                        if (iM60102b == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iM60102b == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (m4163z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!m4124B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i12 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f3527O) {
                        float fM59913v = C9603h0.m59913v(childAt);
                        float f10 = this.f3541b;
                        if (fM59913v != f10) {
                            C9603h0.m59918x0(childAt, f10);
                        }
                    }
                    int iM4158r = m4158r(childAt) & 7;
                    boolean z13 = iM4158r == 3;
                    if ((z13 && z11) || (!z13 && z12)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m4120u(iM4158r) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z13) {
                        z11 = true;
                    } else {
                        z12 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f3542c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewM4152l;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.f3570d;
        if (i10 != 0 && (viewM4152l = m4152l(i10)) != null) {
            m4129G(viewM4152l);
        }
        int i11 = savedState.f3571e;
        if (i11 != 3) {
            m4136N(i11, 3);
        }
        int i12 = savedState.f3572f;
        if (i12 != 3) {
            m4136N(i12, 5);
        }
        int i13 = savedState.f3573g;
        if (i13 != 3) {
            m4136N(i13, 8388611);
        }
        int i14 = savedState.f3574h;
        if (i14 != 3) {
            m4136N(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        m4134L();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int i11 = layoutParams.f3569d;
            boolean z10 = i11 == 1;
            boolean z11 = i11 == 2;
            if (z10 || z11) {
                savedState.f3570d = layoutParams.f3566a;
                break;
            }
        }
        savedState.f3571e = this.f3553n;
        savedState.f3572f = this.f3554o;
        savedState.f3573g = this.f3555p;
        savedState.f3574h = this.f3556q;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            k0.c r0 = r6.f3546g
            r0.m66257F(r7)
            k0.c r0 = r6.f3547h
            r0.m66257F(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.m4147g(r2)
            r6.f3557r = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            k0.c r3 = r6.f3546g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.m66287t(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.m4163z(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.f3560u
            float r0 = r0 - r3
            float r3 = r6.f3561v
            float r7 = r7 - r3
            k0.c r3 = r6.f3546g
            int r3 = r3.m66293z()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.m4153m()
            if (r7 == 0) goto L5a
            int r7 = r6.m4156p(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.m4147g(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3560u = r0
            r6.f3561v = r7
            r6.f3557r = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public int m4156p(View view) {
        if (m4124B(view)) {
            return m4155o(((LayoutParams) view.getLayoutParams()).f3566a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: q */
    public CharSequence m4157q(int i10) {
        int iM60102b = C9614n.m60102b(i10, C9603h0.m59832A(this));
        if (iM60102b == 3) {
            return this.f3565z;
        }
        if (iM60102b == 5) {
            return this.f3529A;
        }
        return null;
    }

    /* renamed from: r */
    public int m4158r(View view) {
        return C9614n.m60102b(((LayoutParams) view.getLayoutParams()).f3566a, C9603h0.m59832A(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            m4147g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3551l) {
            return;
        }
        super.requestLayout();
    }

    /* renamed from: s */
    public float m4159s(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3567b;
    }

    public void setDrawerElevation(float f10) {
        this.f3541b = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (m4124B(childAt)) {
                C9603h0.m59918x0(childAt, this.f3541b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0678e interfaceC0678e) {
        InterfaceC0678e interfaceC0678e2 = this.f3558s;
        if (interfaceC0678e2 != null) {
            m4131I(interfaceC0678e2);
        }
        if (interfaceC0678e != null) {
            m4141a(interfaceC0678e);
        }
        this.f3558s = interfaceC0678e;
    }

    public void setDrawerLockMode(int i10) {
        m4136N(i10, 3);
        m4136N(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f3543d = i10;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f3562w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.f3562w = new ColorDrawable(i10);
        invalidate();
    }

    /* renamed from: t */
    public final MotionEvent m4160t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f3538J == null) {
                this.f3538J = new Matrix();
            }
            matrix.invert(this.f3538J);
            motionEventObtain.transform(this.f3538J);
        }
        return motionEventObtain;
    }

    /* renamed from: w */
    public final boolean m4161w() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((LayoutParams) getChildAt(i10).getLayoutParams()).f3568c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public final boolean m4162x() {
        return m4154n() != null;
    }

    /* renamed from: z */
    public boolean m4163z(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3566a == 0;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3540a = new C0677d();
        this.f3543d = -1728053248;
        this.f3545f = new Paint();
        this.f3552m = true;
        this.f3553n = 3;
        this.f3554o = 3;
        this.f3555p = 3;
        this.f3556q = 3;
        this.f3532D = null;
        this.f3533E = null;
        this.f3534F = null;
        this.f3535G = null;
        this.f3539K = new C0674a();
        setDescendantFocusability(C6051p9.f27764p);
        float f10 = getResources().getDisplayMetrics().density;
        this.f3542c = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        C0679f c0679f = new C0679f(3);
        this.f3548i = c0679f;
        C0679f c0679f2 = new C0679f(5);
        this.f3549j = c0679f2;
        C10970c c10970cM66250n = C10970c.m66250n(this, 1.0f, c0679f);
        this.f3546g = c10970cM66250n;
        c10970cM66250n.m66264M(1);
        c10970cM66250n.m66265N(f11);
        c0679f.m4188q(c10970cM66250n);
        C10970c c10970cM66250n2 = C10970c.m66250n(this, 1.0f, c0679f2);
        this.f3547h = c10970cM66250n2;
        c10970cM66250n2.m66264M(2);
        c10970cM66250n2.m66265N(f11);
        c0679f2.m4188q(c10970cM66250n2);
        setFocusableInTouchMode(true);
        C9603h0.m59833A0(this, 1);
        C9603h0.m59902p0(this, new C0676c());
        setMotionEventSplittingEnabled(false);
        if (C9603h0.m59917x(this)) {
            setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0675b());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f3524L);
            try {
                this.f3562w = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i10, 0);
        try {
            int i11 = R$styleable.DrawerLayout_elevation;
            if (typedArrayObtainStyledAttributes2.hasValue(i11)) {
                this.f3541b = typedArrayObtainStyledAttributes2.getDimension(i11, 0.0f);
            } else {
                this.f3541b = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f3536H = new ArrayList<>();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i10) {
        this.f3562w = i10 != 0 ? ContextCompat.getDrawable(getContext(), i10) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f3566a;

        /* renamed from: b */
        public float f3567b;

        /* renamed from: c */
        public boolean f3568c;

        /* renamed from: d */
        public int f3569d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3566a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3525M);
            this.f3566a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f3566a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f3566a = 0;
            this.f3566a = layoutParams.f3566a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3566a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3566a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0673a();

        /* renamed from: d */
        public int f3570d;

        /* renamed from: e */
        public int f3571e;

        /* renamed from: f */
        public int f3572f;

        /* renamed from: g */
        public int f3573g;

        /* renamed from: h */
        public int f3574h;

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$a */
        public class C0673a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3570d = 0;
            this.f3570d = parcel.readInt();
            this.f3571e = parcel.readInt();
            this.f3572f = parcel.readInt();
            this.f3573g = parcel.readInt();
            this.f3574h = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3570d);
            parcel.writeInt(this.f3571e);
            parcel.writeInt(this.f3572f);
            parcel.writeInt(this.f3573g);
            parcel.writeInt(this.f3574h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f3570d = 0;
        }
    }
}
