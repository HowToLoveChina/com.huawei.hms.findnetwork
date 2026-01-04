package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1788s;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C6051p9;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p273f0.C9603h0;
import p276f3.C9649c;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;
import p356i3.C10427h;
import p356i3.C10432m;
import p413k0.C10970c;
import p827z.C14059a;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: d0 */
    public static final int f7581d0 = R$style.Widget_Design_BottomSheet_Modal;

    /* renamed from: A */
    public ValueAnimator f7582A;

    /* renamed from: B */
    public int f7583B;

    /* renamed from: C */
    public int f7584C;

    /* renamed from: D */
    public int f7585D;

    /* renamed from: E */
    public float f7586E;

    /* renamed from: F */
    public int f7587F;

    /* renamed from: G */
    public float f7588G;

    /* renamed from: H */
    public boolean f7589H;

    /* renamed from: I */
    public boolean f7590I;

    /* renamed from: J */
    public boolean f7591J;

    /* renamed from: K */
    public int f7592K;

    /* renamed from: L */
    public int f7593L;

    /* renamed from: M */
    public C10970c f7594M;

    /* renamed from: N */
    public boolean f7595N;

    /* renamed from: O */
    public int f7596O;

    /* renamed from: P */
    public boolean f7597P;

    /* renamed from: Q */
    public int f7598Q;

    /* renamed from: R */
    public int f7599R;

    /* renamed from: S */
    public int f7600S;

    /* renamed from: T */
    public WeakReference<V> f7601T;

    /* renamed from: U */
    public WeakReference<View> f7602U;

    /* renamed from: V */
    public final ArrayList<AbstractC1681f> f7603V;

    /* renamed from: W */
    public VelocityTracker f7604W;

    /* renamed from: X */
    public int f7605X;

    /* renamed from: Y */
    public int f7606Y;

    /* renamed from: Z */
    public boolean f7607Z;

    /* renamed from: a */
    public int f7608a;

    /* renamed from: a0 */
    public Map<View, Integer> f7609a0;

    /* renamed from: b */
    public boolean f7610b;

    /* renamed from: b0 */
    public int f7611b0;

    /* renamed from: c */
    public boolean f7612c;

    /* renamed from: c0 */
    public final C10970c.c f7613c0;

    /* renamed from: d */
    public float f7614d;

    /* renamed from: e */
    public int f7615e;

    /* renamed from: f */
    public boolean f7616f;

    /* renamed from: g */
    public int f7617g;

    /* renamed from: h */
    public int f7618h;

    /* renamed from: i */
    public C10427h f7619i;

    /* renamed from: j */
    public ColorStateList f7620j;

    /* renamed from: k */
    public int f7621k;

    /* renamed from: l */
    public int f7622l;

    /* renamed from: m */
    public int f7623m;

    /* renamed from: n */
    public boolean f7624n;

    /* renamed from: o */
    public boolean f7625o;

    /* renamed from: p */
    public boolean f7626p;

    /* renamed from: q */
    public boolean f7627q;

    /* renamed from: r */
    public boolean f7628r;

    /* renamed from: s */
    public boolean f7629s;

    /* renamed from: t */
    public boolean f7630t;

    /* renamed from: u */
    public boolean f7631u;

    /* renamed from: v */
    public int f7632v;

    /* renamed from: w */
    public int f7633w;

    /* renamed from: x */
    public C10432m f7634x;

    /* renamed from: y */
    public boolean f7635y;

    /* renamed from: z */
    public final BottomSheetBehavior<V>.C1682g f7636z;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$a */
    public class RunnableC1676a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f7642a;

        /* renamed from: b */
        public final /* synthetic */ int f7643b;

        public RunnableC1676a(View view, int i10) {
            this.f7642a = view;
            this.f7643b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.m9851O0(this.f7642a, this.f7643b, false);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$b */
    public class C1677b implements ValueAnimator.AnimatorUpdateListener {
        public C1677b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f7619i != null) {
                BottomSheetBehavior.this.f7619i.m64003c0(fFloatValue);
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$c */
    public class C1678c implements C1788s.e {

        /* renamed from: a */
        public final /* synthetic */ boolean f7646a;

        public C1678c(boolean z10) {
            this.f7646a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x00a4  */
        @Override // com.google.android.material.internal.C1788s.e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public p273f0.C9625s0 mo9794a(android.view.View r11, p273f0.C9625s0 r12, com.google.android.material.internal.C1788s.f r13) {
            /*
                r10 = this;
                int r0 = p273f0.C9625s0.l.m60205c()
                w.c r0 = r12.m60154f(r0)
                int r1 = p273f0.C9625s0.l.m60204b()
                w.c r1 = r12.m60154f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f60771b
                com.google.android.material.bottomsheet.BottomSheetBehavior.m9828N(r2, r3)
                boolean r2 = com.google.android.material.internal.C1788s.m10788i(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9829O(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.m60157i()
                com.google.android.material.bottomsheet.BottomSheetBehavior.m9831Q(r3, r6)
                int r3 = r13.f8418d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9830P(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9832R(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.f8417c
                goto L50
            L4e:
                int r4 = r13.f8415a
            L50:
                int r6 = r0.f60770a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9833S(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.f8415a
                goto L62
            L60:
                int r13 = r13.f8417c
            L62:
                int r2 = r0.f60772c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9834T(r2)
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f60770a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r6
                goto L81
            L80:
                r2 = r7
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9835U(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f60772c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                goto L93
            L92:
                r6 = r2
            L93:
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9820F(r2)
                if (r2 == 0) goto La4
                int r2 = r13.topMargin
                int r0 = r0.f60771b
                if (r2 == r0) goto La4
                r13.topMargin = r0
                goto La6
            La4:
                if (r6 == 0) goto La9
            La6:
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f7646a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f60773d
                com.google.android.material.bottomsheet.BottomSheetBehavior.m9821G(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.m9829O(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.f7646a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.m9822H(r10, r7)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C1678c.mo9794a(android.view.View, f0.s0, com.google.android.material.internal.s$f):f0.s0");
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$d */
    public class C1679d extends C10970c.c {

        /* renamed from: a */
        public long f7648a;

        public C1679d() {
        }

        @Override // p413k0.C10970c.c
        /* renamed from: a */
        public int mo4174a(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: b */
        public int mo4175b(View view, int i10, int i11) {
            int iM9867h0 = BottomSheetBehavior.this.m9867h0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return C14059a.m84263b(i10, iM9867h0, bottomSheetBehavior.f7589H ? bottomSheetBehavior.f7600S : bottomSheetBehavior.f7587F);
        }

        @Override // p413k0.C10970c.c
        /* renamed from: e */
        public int mo9889e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f7589H ? bottomSheetBehavior.f7600S : bottomSheetBehavior.f7587F;
        }

        @Override // p413k0.C10970c.c
        /* renamed from: j */
        public void mo4181j(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.f7591J) {
                BottomSheetBehavior.this.m9844H0(1);
            }
        }

        @Override // p413k0.C10970c.c
        /* renamed from: k */
        public void mo4182k(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.m9864d0(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0010  */
        @Override // p413k0.C10970c.c
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo4183l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C1679d.mo4183l(android.view.View, float, float):void");
        }

        @Override // p413k0.C10970c.c
        /* renamed from: m */
        public boolean mo4184m(View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.f7592K;
            if (i11 == 1 || bottomSheetBehavior.f7607Z) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f7605X == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.f7602U;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f7648a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.f7601T;
            return weakReference2 != null && weakReference2.get() == view;
        }

        /* renamed from: n */
        public final boolean m9890n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.f7600S + bottomSheetBehavior.m9867h0()) / 2;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$e */
    public class C1680e implements InterfaceC9835o {

        /* renamed from: a */
        public final /* synthetic */ int f7650a;

        public C1680e(int i10) {
            this.f7650a = i10;
        }

        @Override // p304g0.InterfaceC9835o
        /* renamed from: a */
        public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
            BottomSheetBehavior.this.m9843G0(this.f7650a);
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$f */
    public static abstract class AbstractC1681f {
        /* renamed from: a */
        public void mo9891a(View view) {
        }

        /* renamed from: b */
        public abstract void mo9892b(View view, float f10);

        /* renamed from: c */
        public abstract void mo9893c(View view, int i10);
    }

    public BottomSheetBehavior() {
        this.f7608a = 0;
        this.f7610b = true;
        this.f7612c = false;
        this.f7621k = -1;
        this.f7622l = -1;
        this.f7636z = new C1682g(this, null);
        this.f7586E = 0.5f;
        this.f7588G = -1.0f;
        this.f7591J = true;
        this.f7592K = 4;
        this.f7593L = 4;
        this.f7603V = new ArrayList<>();
        this.f7611b0 = -1;
        this.f7613c0 = new C1679d();
    }

    /* renamed from: f0 */
    public static <V extends View> BottomSheetBehavior<V> m9836f0(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.C0594e)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorM3761f = ((CoordinatorLayout.C0594e) layoutParams).m3761f();
        if (behaviorM3761f instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behaviorM3761f;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: A */
    public boolean mo3723A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.f7596O = 0;
        this.f7597P = false;
        return (i10 & 2) != 0;
    }

    /* renamed from: A0 */
    public void m9837A0(int i10) {
        this.f7622l = i10;
    }

    /* renamed from: B0 */
    public void m9838B0(int i10) {
        this.f7621k = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3725C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.m9867h0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.m9844H0(r0)
            return
        Lf:
            boolean r3 = r2.m9874o0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f7602U
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.f7597P
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.f7596O
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f7610b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.f7585D
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.f7589H
            if (r3 == 0) goto L49
            float r3 = r2.m9871l0()
            boolean r3 = r2.m9848L0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.f7596O
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f7610b
            if (r1 == 0) goto L68
            int r5 = r2.f7584C
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f7587F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.f7585D
            if (r3 >= r1) goto L7e
            int r1 = r2.f7587F
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.m9849M0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f7587F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f7610b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.f7585D
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f7587F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.m9851O0(r4, r0, r3)
            r2.f7597P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.mo3725C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    /* renamed from: C0 */
    public void m9839C0(int i10) {
        m9840D0(i10, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: D */
    public boolean mo3726D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f7592K == 1 && actionMasked == 0) {
            return true;
        }
        if (m9847K0()) {
            this.f7594M.m66257F(motionEvent);
        }
        if (actionMasked == 0) {
            m9877r0();
        }
        if (this.f7604W == null) {
            this.f7604W = VelocityTracker.obtain();
        }
        this.f7604W.addMovement(motionEvent);
        if (m9847K0() && actionMasked == 2 && !this.f7595N && Math.abs(this.f7606Y - motionEvent.getY()) > this.f7594M.m66293z()) {
            this.f7594M.m66271b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f7595N;
    }

    /* renamed from: D0 */
    public final void m9840D0(int i10, boolean z10) {
        if (i10 == -1) {
            if (this.f7616f) {
                return;
            } else {
                this.f7616f = true;
            }
        } else {
            if (!this.f7616f && this.f7615e == i10) {
                return;
            }
            this.f7616f = false;
            this.f7615e = Math.max(0, i10);
        }
        m9855S0(z10);
    }

    /* renamed from: E0 */
    public void m9841E0(int i10) {
        this.f7608a = i10;
    }

    /* renamed from: F0 */
    public void m9842F0(boolean z10) {
        this.f7590I = z10;
    }

    /* renamed from: G0 */
    public void m9843G0(int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!this.f7589H && i10 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i10);
            return;
        }
        int i11 = (i10 == 6 && this.f7610b && m9870k0(i10) <= this.f7584C) ? 3 : i10;
        WeakReference<V> weakReference = this.f7601T;
        if (weakReference == null || weakReference.get() == null) {
            m9844H0(i10);
        } else {
            V v10 = this.f7601T.get();
            m9879t0(v10, new RunnableC1676a(v10, i11));
        }
    }

    /* renamed from: H0 */
    public void m9844H0(int i10) {
        V v10;
        if (this.f7592K == i10) {
            return;
        }
        this.f7592K = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.f7589H && i10 == 5)) {
            this.f7593L = i10;
        }
        WeakReference<V> weakReference = this.f7601T;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            m9854R0(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            m9854R0(false);
        }
        m9853Q0(i10);
        for (int i11 = 0; i11 < this.f7603V.size(); i11++) {
            this.f7603V.get(i11).mo9893c(v10, i10);
        }
        m9852P0();
    }

    /* renamed from: I0 */
    public final void m9845I0(View view) {
        boolean z10 = (m9872m0() || this.f7616f) ? false : true;
        if (this.f7625o || this.f7626p || this.f7627q || this.f7629s || this.f7630t || this.f7631u || z10) {
            C1788s.m10781b(view, new C1678c(z10));
        }
    }

    /* renamed from: J0 */
    public boolean m9846J0(long j10, float f10) {
        return false;
    }

    /* renamed from: K0 */
    public final boolean m9847K0() {
        return this.f7594M != null && (this.f7591J || this.f7592K == 1);
    }

    /* renamed from: L0 */
    public boolean m9848L0(View view, float f10) {
        if (this.f7590I) {
            return true;
        }
        if (view.getTop() < this.f7587F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f10 * 0.1f)) - ((float) this.f7587F)) / ((float) m9860Z()) > 0.5f;
    }

    /* renamed from: M0 */
    public boolean m9849M0() {
        return false;
    }

    /* renamed from: N0 */
    public boolean m9850N0() {
        return true;
    }

    /* renamed from: O0 */
    public final void m9851O0(View view, int i10, boolean z10) {
        int iM9870k0 = m9870k0(i10);
        C10970c c10970c = this.f7594M;
        if (c10970c == null || (!z10 ? c10970c.m66268Q(view, view.getLeft(), iM9870k0) : c10970c.m66266O(view.getLeft(), iM9870k0))) {
            m9844H0(i10);
            return;
        }
        m9844H0(2);
        m9853Q0(i10);
        this.f7636z.m9896c(i10);
    }

    /* renamed from: P0 */
    public final void m9852P0() {
        V v10;
        WeakReference<V> weakReference = this.f7601T;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        C9603h0.m59890j0(v10, ARImageMetadata.LENS_APERTURE);
        C9603h0.m59890j0(v10, C6051p9.f27764p);
        C9603h0.m59890j0(v10, ARImageMetadata.SHADING_MODE);
        int i10 = this.f7611b0;
        if (i10 != -1) {
            C9603h0.m59890j0(v10, i10);
        }
        if (!this.f7610b && this.f7592K != 6) {
            this.f7611b0 = m9856V(v10, R$string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.f7589H && this.f7592K != 5) {
            m9876q0(v10, C9832l.a.f48315y, 5);
        }
        int i11 = this.f7592K;
        if (i11 == 3) {
            m9876q0(v10, C9832l.a.f48314x, this.f7610b ? 4 : 6);
            return;
        }
        if (i11 == 4) {
            m9876q0(v10, C9832l.a.f48313w, this.f7610b ? 3 : 6);
        } else {
            if (i11 != 6) {
                return;
            }
            m9876q0(v10, C9832l.a.f48314x, 4);
            m9876q0(v10, C9832l.a.f48313w, 3);
        }
    }

    /* renamed from: Q0 */
    public final void m9853Q0(int i10) {
        ValueAnimator valueAnimator;
        if (i10 == 2) {
            return;
        }
        boolean z10 = i10 == 3;
        if (this.f7635y != z10) {
            this.f7635y = z10;
            if (this.f7619i == null || (valueAnimator = this.f7582A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f7582A.reverse();
                return;
            }
            float f10 = z10 ? 0.0f : 1.0f;
            this.f7582A.setFloatValues(1.0f - f10, f10);
            this.f7582A.start();
        }
    }

    /* renamed from: R0 */
    public final void m9854R0(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f7601T;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f7609a0 != null) {
                    return;
                } else {
                    this.f7609a0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.f7601T.get()) {
                    if (z10) {
                        this.f7609a0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f7612c) {
                            C9603h0.m59833A0(childAt, 4);
                        }
                    } else if (this.f7612c && (map = this.f7609a0) != null && map.containsKey(childAt)) {
                        C9603h0.m59833A0(childAt, this.f7609a0.get(childAt).intValue());
                    }
                }
            }
            if (!z10) {
                this.f7609a0 = null;
            } else if (this.f7612c) {
                this.f7601T.get().sendAccessibilityEvent(8);
            }
        }
    }

    /* renamed from: S0 */
    public final void m9855S0(boolean z10) {
        V v10;
        if (this.f7601T != null) {
            m9858X();
            if (this.f7592K != 4 || (v10 = this.f7601T.get()) == null) {
                return;
            }
            if (z10) {
                m9843G0(4);
            } else {
                v10.requestLayout();
            }
        }
    }

    /* renamed from: V */
    public final int m9856V(V v10, int i10, int i11) {
        return C9603h0.m59875c(v10, v10.getResources().getString(i10), m9861a0(i11));
    }

    /* renamed from: W */
    public void m9857W(AbstractC1681f abstractC1681f) {
        if (this.f7603V.contains(abstractC1681f)) {
            return;
        }
        this.f7603V.add(abstractC1681f);
    }

    /* renamed from: X */
    public final void m9858X() {
        int iM9860Z = m9860Z();
        if (this.f7610b) {
            this.f7587F = Math.max(this.f7600S - iM9860Z, this.f7584C);
        } else {
            this.f7587F = this.f7600S - iM9860Z;
        }
    }

    /* renamed from: Y */
    public final void m9859Y() {
        this.f7585D = (int) (this.f7600S * (1.0f - this.f7586E));
    }

    /* renamed from: Z */
    public final int m9860Z() {
        int iMin;
        int i10;
        int i11;
        if (this.f7616f) {
            iMin = Math.min(Math.max(this.f7617g, this.f7600S - ((this.f7599R * 9) / 16)), this.f7598Q);
            i10 = this.f7632v;
        } else {
            if (!this.f7624n && !this.f7625o && (i11 = this.f7623m) > 0) {
                return Math.max(this.f7615e, i11 + this.f7618h);
            }
            iMin = this.f7615e;
            i10 = this.f7632v;
        }
        return iMin + i10;
    }

    /* renamed from: a0 */
    public final InterfaceC9835o m9861a0(int i10) {
        return new C1680e(i10);
    }

    /* renamed from: b0 */
    public final void m9862b0(Context context) {
        if (this.f7634x == null) {
            return;
        }
        C10427h c10427h = new C10427h(this.f7634x);
        this.f7619i = c10427h;
        c10427h.m63992Q(context);
        ColorStateList colorStateList = this.f7620j;
        if (colorStateList != null) {
            this.f7619i.m64002b0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f7619i.setTint(typedValue.data);
    }

    /* renamed from: c0 */
    public final void m9863c0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7582A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f7582A.addUpdateListener(new C1677b());
    }

    /* renamed from: d0 */
    public void m9864d0(int i10) {
        float f10;
        float fM9867h0;
        V v10 = this.f7601T.get();
        if (v10 == null || this.f7603V.isEmpty()) {
            return;
        }
        int i11 = this.f7587F;
        if (i10 > i11 || i11 == m9867h0()) {
            int i12 = this.f7587F;
            f10 = i12 - i10;
            fM9867h0 = this.f7600S - i12;
        } else {
            int i13 = this.f7587F;
            f10 = i13 - i10;
            fM9867h0 = i13 - m9867h0();
        }
        float f11 = f10 / fM9867h0;
        for (int i14 = 0; i14 < this.f7603V.size(); i14++) {
            this.f7603V.get(i14).mo9892b(v10, f11);
        }
    }

    /* renamed from: e0 */
    public View m9865e0(View view) {
        if (C9603h0.m59865U(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View viewM9865e0 = m9865e0(viewGroup.getChildAt(i10));
            if (viewM9865e0 != null) {
                return viewM9865e0;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: g */
    public void mo3733g(CoordinatorLayout.C0594e c0594e) {
        super.mo3733g(c0594e);
        this.f7601T = null;
        this.f7594M = null;
    }

    /* renamed from: g0 */
    public final int m9866g0(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    /* renamed from: h0 */
    public int m9867h0() {
        if (this.f7610b) {
            return this.f7584C;
        }
        return Math.max(this.f7583B, this.f7628r ? 0 : this.f7633w);
    }

    /* renamed from: i0 */
    public C10427h m9868i0() {
        return this.f7619i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: j */
    public void mo3736j() {
        super.mo3736j();
        this.f7601T = null;
        this.f7594M = null;
    }

    /* renamed from: j0 */
    public int m9869j0() {
        return this.f7592K;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: k */
    public boolean mo3737k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        C10970c c10970c;
        if (!v10.isShown() || !this.f7591J) {
            this.f7595N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m9877r0();
        }
        if (this.f7604W == null) {
            this.f7604W = VelocityTracker.obtain();
        }
        this.f7604W.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f7606Y = (int) motionEvent.getY();
            if (this.f7592K != 2) {
                WeakReference<View> weakReference = this.f7602U;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.m3691F(view, x10, this.f7606Y)) {
                    this.f7605X = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f7607Z = true;
                }
            }
            this.f7595N = this.f7605X == -1 && !coordinatorLayout.m3691F(v10, x10, this.f7606Y);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f7607Z = false;
            this.f7605X = -1;
            if (this.f7595N) {
                this.f7595N = false;
                return false;
            }
        }
        if (!this.f7595N && (c10970c = this.f7594M) != null && c10970c.m66267P(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f7602U;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.f7595N || this.f7592K == 1 || coordinatorLayout.m3691F(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f7594M == null || Math.abs(((float) this.f7606Y) - motionEvent.getY()) <= ((float) this.f7594M.m66293z())) ? false : true;
    }

    /* renamed from: k0 */
    public final int m9870k0(int i10) {
        if (i10 == 3) {
            return m9867h0();
        }
        if (i10 == 4) {
            return this.f7587F;
        }
        if (i10 == 5) {
            return this.f7600S;
        }
        if (i10 == 6) {
            return this.f7585D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: l */
    public boolean mo3738l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        if (C9603h0.m59917x(coordinatorLayout) && !C9603h0.m59917x(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.f7601T == null) {
            this.f7617g = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            m9845I0(v10);
            this.f7601T = new WeakReference<>(v10);
            C10427h c10427h = this.f7619i;
            if (c10427h != null) {
                C9603h0.m59910t0(v10, c10427h);
                C10427h c10427h2 = this.f7619i;
                float fM59913v = this.f7588G;
                if (fM59913v == -1.0f) {
                    fM59913v = C9603h0.m59913v(v10);
                }
                c10427h2.m64001a0(fM59913v);
                boolean z10 = this.f7592K == 3;
                this.f7635y = z10;
                this.f7619i.m64003c0(z10 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.f7620j;
                if (colorStateList != null) {
                    C9603h0.m59912u0(v10, colorStateList);
                }
            }
            m9852P0();
            if (C9603h0.m59919y(v10) == 0) {
                C9603h0.m59833A0(v10, 1);
            }
        }
        if (this.f7594M == null) {
            this.f7594M = C10970c.m66251o(coordinatorLayout, this.f7613c0);
        }
        int top = v10.getTop();
        coordinatorLayout.m3698M(v10, i10);
        this.f7599R = coordinatorLayout.getWidth();
        this.f7600S = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.f7598Q = height;
        int i11 = this.f7600S;
        int i12 = i11 - height;
        int i13 = this.f7633w;
        if (i12 < i13) {
            if (this.f7628r) {
                this.f7598Q = i11;
            } else {
                this.f7598Q = i11 - i13;
            }
        }
        this.f7584C = Math.max(0, i11 - this.f7598Q);
        m9859Y();
        m9858X();
        int i14 = this.f7592K;
        if (i14 == 3) {
            C9603h0.m59872a0(v10, m9867h0());
        } else if (i14 == 6) {
            C9603h0.m59872a0(v10, this.f7585D);
        } else if (this.f7589H && i14 == 5) {
            C9603h0.m59872a0(v10, this.f7600S);
        } else if (i14 == 4) {
            C9603h0.m59872a0(v10, this.f7587F);
        } else if (i14 == 1 || i14 == 2) {
            C9603h0.m59872a0(v10, top - v10.getTop());
        }
        this.f7602U = new WeakReference<>(m9865e0(v10));
        for (int i15 = 0; i15 < this.f7603V.size(); i15++) {
            this.f7603V.get(i15).mo9891a(v10);
        }
        return true;
    }

    /* renamed from: l0 */
    public final float m9871l0() {
        VelocityTracker velocityTracker = this.f7604W;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f7614d);
        return this.f7604W.getYVelocity(this.f7605X);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: m */
    public boolean mo3739m(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(m9866g0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f7621k, marginLayoutParams.width), m9866g0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f7622l, marginLayoutParams.height));
        return true;
    }

    /* renamed from: m0 */
    public boolean m9872m0() {
        return this.f7624n;
    }

    /* renamed from: n0 */
    public final boolean m9873n0(V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && C9603h0.m59863S(v10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: o */
    public boolean mo3741o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (m9874o0() && (weakReference = this.f7602U) != null && view == weakReference.get()) {
            return this.f7592K != 3 || super.mo3741o(coordinatorLayout, v10, view, f10, f11);
        }
        return false;
    }

    /* renamed from: o0 */
    public boolean m9874o0() {
        return true;
    }

    /* renamed from: p0 */
    public void m9875p0(AbstractC1681f abstractC1681f) {
        this.f7603V.remove(abstractC1681f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: q */
    public void mo3743q(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f7602U;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!m9874o0() || view == view2) {
            int top = v10.getTop();
            int i13 = top - i11;
            if (i11 > 0) {
                if (i13 < m9867h0()) {
                    int iM9867h0 = top - m9867h0();
                    iArr[1] = iM9867h0;
                    C9603h0.m59872a0(v10, -iM9867h0);
                    m9844H0(3);
                } else {
                    if (!this.f7591J) {
                        return;
                    }
                    iArr[1] = i11;
                    C9603h0.m59872a0(v10, -i11);
                    m9844H0(1);
                }
            } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                int i14 = this.f7587F;
                if (i13 > i14 && !this.f7589H) {
                    int i15 = top - i14;
                    iArr[1] = i15;
                    C9603h0.m59872a0(v10, -i15);
                    m9844H0(4);
                } else {
                    if (!this.f7591J) {
                        return;
                    }
                    iArr[1] = i11;
                    C9603h0.m59872a0(v10, -i11);
                    m9844H0(1);
                }
            }
            m9864d0(v10.getTop());
            this.f7596O = i11;
            this.f7597P = true;
        }
    }

    /* renamed from: q0 */
    public final void m9876q0(V v10, C9832l.a aVar, int i10) {
        C9603h0.m59894l0(v10, aVar, null, m9861a0(i10));
    }

    /* renamed from: r0 */
    public final void m9877r0() {
        this.f7605X = -1;
        VelocityTracker velocityTracker = this.f7604W;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7604W = null;
        }
    }

    /* renamed from: s0 */
    public final void m9878s0(SavedState savedState) {
        int i10 = this.f7608a;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.f7615e = savedState.f7638e;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.f7610b = savedState.f7639f;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.f7589H = savedState.f7640g;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.f7590I = savedState.f7641h;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: t */
    public void mo3746t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }

    /* renamed from: t0 */
    public final void m9879t0(V v10, Runnable runnable) {
        if (m9873n0(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: u0 */
    public void m9880u0(boolean z10) {
        this.f7591J = z10;
    }

    /* renamed from: v0 */
    public void m9881v0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f7583B = i10;
    }

    /* renamed from: w0 */
    public void m9882w0(boolean z10) {
        if (this.f7610b == z10) {
            return;
        }
        this.f7610b = z10;
        if (this.f7601T != null) {
            m9858X();
        }
        m9844H0((this.f7610b && this.f7592K == 6) ? 3 : this.f7592K);
        m9852P0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: x */
    public void mo3750x(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo3750x(coordinatorLayout, v10, savedState.getSuperState());
        m9878s0(savedState);
        int i10 = savedState.f7637d;
        if (i10 == 1 || i10 == 2) {
            this.f7592K = 4;
            this.f7593L = 4;
        } else {
            this.f7592K = i10;
            this.f7593L = i10;
        }
    }

    /* renamed from: x0 */
    public void m9883x0(boolean z10) {
        this.f7624n = z10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: y */
    public Parcelable mo3751y(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.mo3751y(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    /* renamed from: y0 */
    public void m9884y0(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f7586E = f10;
        if (this.f7601T != null) {
            m9859Y();
        }
    }

    /* renamed from: z0 */
    public void m9885z0(boolean z10) {
        if (this.f7589H != z10) {
            this.f7589H = z10;
            if (!z10 && this.f7592K == 5) {
                m9843G0(4);
            }
            m9852P0();
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$g */
    public class C1682g {

        /* renamed from: a */
        public int f7652a;

        /* renamed from: b */
        public boolean f7653b;

        /* renamed from: c */
        public final Runnable f7654c;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$g$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1682g.this.f7653b = false;
                C10970c c10970c = BottomSheetBehavior.this.f7594M;
                if (c10970c != null && c10970c.m66282m(true)) {
                    C1682g c1682g = C1682g.this;
                    c1682g.m9896c(c1682g.f7652a);
                    return;
                }
                C1682g c1682g2 = C1682g.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f7592K == 2) {
                    bottomSheetBehavior.m9844H0(c1682g2.f7652a);
                }
            }
        }

        public C1682g() {
            this.f7654c = new a();
        }

        /* renamed from: c */
        public void m9896c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.f7601T;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f7652a = i10;
            if (this.f7653b) {
                return;
            }
            C9603h0.m59886h0(BottomSheetBehavior.this.f7601T.get(), this.f7654c);
            this.f7653b = true;
        }

        public /* synthetic */ C1682g(BottomSheetBehavior bottomSheetBehavior, RunnableC1676a runnableC1676a) {
            this();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1675a();

        /* renamed from: d */
        public final int f7637d;

        /* renamed from: e */
        public int f7638e;

        /* renamed from: f */
        public boolean f7639f;

        /* renamed from: g */
        public boolean f7640g;

        /* renamed from: h */
        public boolean f7641h;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$a */
        public class C1675a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.f7637d = parcel.readInt();
            this.f7638e = parcel.readInt();
            this.f7639f = parcel.readInt() == 1;
            this.f7640g = parcel.readInt() == 1;
            this.f7641h = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7637d);
            parcel.writeInt(this.f7638e);
            parcel.writeInt(this.f7639f ? 1 : 0);
            parcel.writeInt(this.f7640g ? 1 : 0);
            parcel.writeInt(this.f7641h ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f7637d = bottomSheetBehavior.f7592K;
            this.f7638e = bottomSheetBehavior.f7615e;
            this.f7639f = bottomSheetBehavior.f7610b;
            this.f7640g = bottomSheetBehavior.f7589H;
            this.f7641h = bottomSheetBehavior.f7590I;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i10;
        super(context, attributeSet);
        this.f7608a = 0;
        this.f7610b = true;
        this.f7612c = false;
        this.f7621k = -1;
        this.f7622l = -1;
        this.f7636z = new C1682g(this, null);
        this.f7586E = 0.5f;
        this.f7588G = -1.0f;
        this.f7591J = true;
        this.f7592K = 4;
        this.f7593L = 4;
        this.f7603V = new ArrayList<>();
        this.f7611b0 = -1;
        this.f7613c0 = new C1679d();
        this.f7618h = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        int i11 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f7620j = C9649c.m60265a(context, typedArrayObtainStyledAttributes, i11);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f7634x = C10432m.m64049e(context, attributeSet, R$attr.bottomSheetStyle, f7581d0).m64093m();
        }
        m9862b0(context);
        m9863c0();
        this.f7588G = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = R$styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            m9838B0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = R$styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            m9837A0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i14);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            m9839C0(i10);
        } else {
            m9839C0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        m9885z0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        m9883x0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        m9882w0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        m9842F0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        m9880u0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        m9841E0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        m9884y0(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i15);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            m9881v0(typedValuePeekValue2.data);
        } else {
            m9881v0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        this.f7625o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f7626p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f7627q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f7628r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f7629s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f7630t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f7631u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f7614d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
