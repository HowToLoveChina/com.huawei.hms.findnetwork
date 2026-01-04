package p413k0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import p273f0.C9603h0;

/* renamed from: k0.c */
/* loaded from: classes.dex */
public class C10970c {

    /* renamed from: x */
    public static final Interpolator f51971x = new a();

    /* renamed from: a */
    public int f51972a;

    /* renamed from: b */
    public int f51973b;

    /* renamed from: d */
    public float[] f51975d;

    /* renamed from: e */
    public float[] f51976e;

    /* renamed from: f */
    public float[] f51977f;

    /* renamed from: g */
    public float[] f51978g;

    /* renamed from: h */
    public int[] f51979h;

    /* renamed from: i */
    public int[] f51980i;

    /* renamed from: j */
    public int[] f51981j;

    /* renamed from: k */
    public int f51982k;

    /* renamed from: l */
    public VelocityTracker f51983l;

    /* renamed from: m */
    public float f51984m;

    /* renamed from: n */
    public float f51985n;

    /* renamed from: o */
    public int f51986o;

    /* renamed from: p */
    public final int f51987p;

    /* renamed from: q */
    public int f51988q;

    /* renamed from: r */
    public OverScroller f51989r;

    /* renamed from: s */
    public final c f51990s;

    /* renamed from: t */
    public View f51991t;

    /* renamed from: u */
    public boolean f51992u;

    /* renamed from: v */
    public final ViewGroup f51993v;

    /* renamed from: c */
    public int f51974c = -1;

    /* renamed from: w */
    public final Runnable f51994w = new b();

    /* renamed from: k0.c$a */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* renamed from: k0.c$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C10970c.this.m66262K(0);
        }
    }

    /* renamed from: k0.c$c */
    public static abstract class c {
        /* renamed from: a */
        public abstract int mo4174a(View view, int i10, int i11);

        /* renamed from: b */
        public abstract int mo4175b(View view, int i10, int i11);

        /* renamed from: c */
        public int m66294c(int i10) {
            return i10;
        }

        /* renamed from: d */
        public int mo4176d(View view) {
            return 0;
        }

        /* renamed from: e */
        public int mo9889e(View view) {
            return 0;
        }

        /* renamed from: f */
        public void mo4177f(int i10, int i11) {
        }

        /* renamed from: g */
        public boolean mo4178g(int i10) {
            return false;
        }

        /* renamed from: h */
        public void mo4179h(int i10, int i11) {
        }

        /* renamed from: i */
        public void mo4180i(View view, int i10) {
        }

        /* renamed from: j */
        public abstract void mo4181j(int i10);

        /* renamed from: k */
        public abstract void mo4182k(View view, int i10, int i11, int i12, int i13);

        /* renamed from: l */
        public abstract void mo4183l(View view, float f10, float f11);

        /* renamed from: m */
        public abstract boolean mo4184m(View view, int i10);
    }

    public C10970c(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f51993v = viewGroup;
        this.f51990s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f51987p = i10;
        this.f51986o = i10;
        this.f51973b = viewConfiguration.getScaledTouchSlop();
        this.f51984m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f51985n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f51989r = new OverScroller(context, f51971x);
    }

    /* renamed from: n */
    public static C10970c m66250n(ViewGroup viewGroup, float f10, c cVar) {
        C10970c c10970cM66251o = m66251o(viewGroup, cVar);
        c10970cM66251o.f51973b = (int) (c10970cM66251o.f51973b * (1.0f / f10));
        return c10970cM66251o;
    }

    /* renamed from: o */
    public static C10970c m66251o(ViewGroup viewGroup, c cVar) {
        return new C10970c(viewGroup.getContext(), viewGroup, cVar);
    }

    /* renamed from: A */
    public int m66252A() {
        return this.f51972a;
    }

    /* renamed from: B */
    public boolean m66253B(int i10, int i11) {
        return m66256E(this.f51991t, i10, i11);
    }

    /* renamed from: C */
    public boolean m66254C(int i10) {
        return (this.f51982k & (1 << i10)) != 0;
    }

    /* renamed from: D */
    public final boolean m66255D(int i10) {
        if (m66254C(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: E */
    public boolean m66256E(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    /* renamed from: F */
    public void m66257F(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m66270a();
        }
        if (this.f51983l == null) {
            this.f51983l = VelocityTracker.obtain();
        }
        this.f51983l.addMovement(motionEvent);
        int i10 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewM66287t = m66287t((int) x10, (int) y10);
            m66260I(x10, y10, pointerId);
            m66269R(viewM66287t, pointerId);
            int i11 = this.f51979h[pointerId];
            int i12 = this.f51988q;
            if ((i11 & i12) != 0) {
                this.f51990s.mo4179h(i11 & i12, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f51972a == 1) {
                m66258G();
            }
            m66270a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f51972a == 1) {
                if (m66255D(this.f51974c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f51974c);
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float y11 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f51977f;
                    int i13 = this.f51974c;
                    int i14 = (int) (x11 - fArr[i13]);
                    int i15 = (int) (y11 - this.f51978g[i13]);
                    m66285r(this.f51991t.getLeft() + i14, this.f51991t.getTop() + i15, i14, i15);
                    m66261J(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i10 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i10);
                if (m66255D(pointerId2)) {
                    float x12 = motionEvent.getX(i10);
                    float y12 = motionEvent.getY(i10);
                    float f10 = x12 - this.f51975d[pointerId2];
                    float f11 = y12 - this.f51976e[pointerId2];
                    m66259H(f10, f11, pointerId2);
                    if (this.f51972a != 1) {
                        View viewM66287t2 = m66287t((int) x12, (int) y12);
                        if (m66275f(viewM66287t2, f10, f11) && m66269R(viewM66287t2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i10++;
            }
            m66261J(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f51972a == 1) {
                m66283p(0.0f, 0.0f);
            }
            m66270a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            m66260I(x13, y13, pointerId3);
            if (this.f51972a != 0) {
                if (m66253B((int) x13, (int) y13)) {
                    m66269R(this.f51991t, pointerId3);
                    return;
                }
                return;
            } else {
                m66269R(m66287t((int) x13, (int) y13), pointerId3);
                int i16 = this.f51979h[pointerId3];
                int i17 = this.f51988q;
                if ((i16 & i17) != 0) {
                    this.f51990s.mo4179h(i16 & i17, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f51972a == 1 && pointerId4 == this.f51974c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i10 >= pointerCount2) {
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i10);
                if (pointerId5 != this.f51974c) {
                    View viewM66287t3 = m66287t((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                    View view = this.f51991t;
                    if (viewM66287t3 == view && m66269R(view, pointerId5)) {
                        if (this.f51974c == -1) {
                            break;
                        }
                    }
                }
                i10++;
            }
            m66258G();
        }
        m66279j(pointerId4);
    }

    /* renamed from: G */
    public final void m66258G() {
        this.f51983l.computeCurrentVelocity(1000, this.f51984m);
        m66283p(m66276g(this.f51983l.getXVelocity(this.f51974c), this.f51985n, this.f51984m), m66276g(this.f51983l.getYVelocity(this.f51974c), this.f51985n, this.f51984m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [k0.c$c] */
    /* renamed from: H */
    public final void m66259H(float f10, float f11, int i10) {
        boolean zM66272c = m66272c(f10, f11, i10, 1);
        boolean z10 = zM66272c;
        if (m66272c(f11, f10, i10, 4)) {
            z10 = (zM66272c ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (m66272c(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (m66272c(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f51980i;
            iArr[i10] = iArr[i10] | r02;
            this.f51990s.mo4177f(r02, i10);
        }
    }

    /* renamed from: I */
    public final void m66260I(float f10, float f11, int i10) {
        m66286s(i10);
        float[] fArr = this.f51975d;
        this.f51977f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f51976e;
        this.f51978g[i10] = f11;
        fArr2[i10] = f11;
        this.f51979h[i10] = m66292y((int) f10, (int) f11);
        this.f51982k |= 1 << i10;
    }

    /* renamed from: J */
    public final void m66261J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (m66255D(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f51977f[pointerId] = x10;
                this.f51978g[pointerId] = y10;
            }
        }
    }

    /* renamed from: K */
    public void m66262K(int i10) {
        this.f51993v.removeCallbacks(this.f51994w);
        if (this.f51972a != i10) {
            this.f51972a = i10;
            this.f51990s.mo4181j(i10);
            if (this.f51972a == 0) {
                this.f51991t = null;
            }
        }
    }

    /* renamed from: L */
    public void m66263L(int i10) {
        this.f51986o = i10;
    }

    /* renamed from: M */
    public void m66264M(int i10) {
        this.f51988q = i10;
    }

    /* renamed from: N */
    public void m66265N(float f10) {
        this.f51985n = f10;
    }

    /* renamed from: O */
    public boolean m66266O(int i10, int i11) {
        if (this.f51992u) {
            return m66288u(i10, i11, (int) this.f51983l.getXVelocity(this.f51974c), (int) this.f51983l.getYVelocity(this.f51974c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m66267P(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p413k0.C10970c.m66267P(android.view.MotionEvent):boolean");
    }

    /* renamed from: Q */
    public boolean m66268Q(View view, int i10, int i11) {
        this.f51991t = view;
        this.f51974c = -1;
        boolean zM66288u = m66288u(i10, i11, 0, 0);
        if (!zM66288u && this.f51972a == 0 && this.f51991t != null) {
            this.f51991t = null;
        }
        return zM66288u;
    }

    /* renamed from: R */
    public boolean m66269R(View view, int i10) {
        if (view == this.f51991t && this.f51974c == i10) {
            return true;
        }
        if (view == null || !this.f51990s.mo4184m(view, i10)) {
            return false;
        }
        this.f51974c = i10;
        m66271b(view, i10);
        return true;
    }

    /* renamed from: a */
    public void m66270a() {
        this.f51974c = -1;
        m66278i();
        VelocityTracker velocityTracker = this.f51983l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f51983l = null;
        }
    }

    /* renamed from: b */
    public void m66271b(View view, int i10) {
        if (view.getParent() == this.f51993v) {
            this.f51991t = view;
            this.f51974c = i10;
            this.f51990s.mo4180i(view, i10);
            m66262K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f51993v + ")");
    }

    /* renamed from: c */
    public final boolean m66272c(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f51979h[i10] & i11) != i11 || (this.f51988q & i11) == 0 || (this.f51981j[i10] & i11) == i11 || (this.f51980i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f51973b;
        if (fAbs <= i12 && fAbs2 <= i12) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f51990s.mo4178g(i11)) {
            return (this.f51980i[i10] & i11) == 0 && fAbs > ((float) this.f51973b);
        }
        int[] iArr = this.f51981j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    /* renamed from: d */
    public boolean m66273d(int i10) {
        int length = this.f51975d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (m66274e(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public boolean m66274e(int i10, int i11) {
        if (!m66254C(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f51977f[i11] - this.f51975d[i11];
        float f11 = this.f51978g[i11] - this.f51976e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f51973b) : z11 && Math.abs(f11) > ((float) this.f51973b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i12 = this.f51973b;
        return f12 > ((float) (i12 * i12));
    }

    /* renamed from: f */
    public final boolean m66275f(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f51990s.mo4176d(view) > 0;
        boolean z11 = this.f51990s.mo9889e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f51973b) : z11 && Math.abs(f11) > ((float) this.f51973b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f51973b;
        return f12 > ((float) (i10 * i10));
    }

    /* renamed from: g */
    public final float m66276g(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        return fAbs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    /* renamed from: h */
    public final int m66277h(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        return iAbs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    /* renamed from: i */
    public final void m66278i() {
        float[] fArr = this.f51975d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f51976e, 0.0f);
        Arrays.fill(this.f51977f, 0.0f);
        Arrays.fill(this.f51978g, 0.0f);
        Arrays.fill(this.f51979h, 0);
        Arrays.fill(this.f51980i, 0);
        Arrays.fill(this.f51981j, 0);
        this.f51982k = 0;
    }

    /* renamed from: j */
    public final void m66279j(int i10) {
        if (this.f51975d == null || !m66254C(i10)) {
            return;
        }
        this.f51975d[i10] = 0.0f;
        this.f51976e[i10] = 0.0f;
        this.f51977f[i10] = 0.0f;
        this.f51978g[i10] = 0.0f;
        this.f51979h[i10] = 0;
        this.f51980i[i10] = 0;
        this.f51981j[i10] = 0;
        this.f51982k = (~(1 << i10)) & this.f51982k;
    }

    /* renamed from: k */
    public final int m66280k(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f51993v.getWidth();
        float f10 = width / 2;
        float fM66284q = f10 + (m66284q(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fM66284q / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: l */
    public final int m66281l(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int iM66277h = m66277h(i12, (int) this.f51985n, (int) this.f51984m);
        int iM66277h2 = m66277h(i13, (int) this.f51985n, (int) this.f51984m);
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        int iAbs3 = Math.abs(iM66277h);
        int iAbs4 = Math.abs(iM66277h2);
        int i14 = iAbs3 + iAbs4;
        int i15 = iAbs + iAbs2;
        if (iM66277h != 0) {
            f10 = iAbs3;
            f11 = i14;
        } else {
            f10 = iAbs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (iM66277h2 != 0) {
            f12 = iAbs4;
            f13 = i14;
        } else {
            f12 = iAbs2;
            f13 = i15;
        }
        return (int) ((m66280k(i10, iM66277h, this.f51990s.mo4176d(view)) * f14) + (m66280k(i11, iM66277h2, this.f51990s.mo9889e(view)) * (f12 / f13)));
    }

    /* renamed from: m */
    public boolean m66282m(boolean z10) {
        if (this.f51972a == 2) {
            boolean zComputeScrollOffset = this.f51989r.computeScrollOffset();
            int currX = this.f51989r.getCurrX();
            int currY = this.f51989r.getCurrY();
            int left = currX - this.f51991t.getLeft();
            int top = currY - this.f51991t.getTop();
            if (left != 0) {
                C9603h0.m59870Z(this.f51991t, left);
            }
            if (top != 0) {
                C9603h0.m59872a0(this.f51991t, top);
            }
            if (left != 0 || top != 0) {
                this.f51990s.mo4182k(this.f51991t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f51989r.getFinalX() && currY == this.f51989r.getFinalY()) {
                this.f51989r.abortAnimation();
            } else if (!zComputeScrollOffset) {
            }
            if (z10) {
                this.f51993v.post(this.f51994w);
            } else {
                m66262K(0);
            }
        }
        return this.f51972a == 2;
    }

    /* renamed from: p */
    public final void m66283p(float f10, float f11) {
        this.f51992u = true;
        this.f51990s.mo4183l(this.f51991t, f10, f11);
        this.f51992u = false;
        if (this.f51972a == 1) {
            m66262K(0);
        }
    }

    /* renamed from: q */
    public final float m66284q(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    /* renamed from: r */
    public final void m66285r(int i10, int i11, int i12, int i13) {
        int left = this.f51991t.getLeft();
        int top = this.f51991t.getTop();
        if (i12 != 0) {
            i10 = this.f51990s.mo4174a(this.f51991t, i10, i12);
            C9603h0.m59870Z(this.f51991t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f51990s.mo4175b(this.f51991t, i11, i13);
            C9603h0.m59872a0(this.f51991t, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f51990s.mo4182k(this.f51991t, i14, i15, i14 - left, i15 - top);
    }

    /* renamed from: s */
    public final void m66286s(int i10) {
        float[] fArr = this.f51975d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f51976e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f51977f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f51978g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f51979h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f51980i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f51981j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f51975d = fArr2;
            this.f51976e = fArr3;
            this.f51977f = fArr4;
            this.f51978g = fArr5;
            this.f51979h = iArr;
            this.f51980i = iArr2;
            this.f51981j = iArr3;
        }
    }

    /* renamed from: t */
    public View m66287t(int i10, int i11) {
        for (int childCount = this.f51993v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f51993v.getChildAt(this.f51990s.m66294c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: u */
    public final boolean m66288u(int i10, int i11, int i12, int i13) {
        int left = this.f51991t.getLeft();
        int top = this.f51991t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f51989r.abortAnimation();
            m66262K(0);
            return false;
        }
        this.f51989r.startScroll(left, top, i14, i15, m66281l(this.f51991t, i14, i15, i12, i13));
        m66262K(2);
        return true;
    }

    /* renamed from: v */
    public View m66289v() {
        return this.f51991t;
    }

    /* renamed from: w */
    public int m66290w() {
        return this.f51987p;
    }

    /* renamed from: x */
    public int m66291x() {
        return this.f51986o;
    }

    /* renamed from: y */
    public final int m66292y(int i10, int i11) {
        int i12 = i10 < this.f51993v.getLeft() + this.f51986o ? 1 : 0;
        if (i11 < this.f51993v.getTop() + this.f51986o) {
            i12 |= 4;
        }
        if (i10 > this.f51993v.getRight() - this.f51986o) {
            i12 |= 2;
        }
        return i11 > this.f51993v.getBottom() - this.f51986o ? i12 | 8 : i12;
    }

    /* renamed from: z */
    public int m66293z() {
        return this.f51973b;
    }
}
