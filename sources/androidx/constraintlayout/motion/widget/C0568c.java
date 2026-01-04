package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.C0566a;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import p504o.C11770c;
import p504o.C11771d;
import p642t.AbstractC12899d;
import p642t.C12896a;
import p642t.C12902g;
import p642t.C12908m;

/* renamed from: androidx.constraintlayout.motion.widget.c */
/* loaded from: classes.dex */
public class C0568c {

    /* renamed from: a */
    public int f2771a;

    /* renamed from: e */
    public int f2775e;

    /* renamed from: f */
    public C12902g f2776f;

    /* renamed from: g */
    public C0585c.a f2777g;

    /* renamed from: j */
    public int f2780j;

    /* renamed from: k */
    public String f2781k;

    /* renamed from: o */
    public Context f2785o;

    /* renamed from: b */
    public int f2772b = -1;

    /* renamed from: c */
    public boolean f2773c = false;

    /* renamed from: d */
    public int f2774d = 0;

    /* renamed from: h */
    public int f2778h = -1;

    /* renamed from: i */
    public int f2779i = -1;

    /* renamed from: l */
    public int f2782l = 0;

    /* renamed from: m */
    public String f2783m = null;

    /* renamed from: n */
    public int f2784n = -1;

    /* renamed from: p */
    public int f2786p = -1;

    /* renamed from: q */
    public int f2787q = -1;

    /* renamed from: r */
    public int f2788r = -1;

    /* renamed from: s */
    public int f2789s = -1;

    /* renamed from: t */
    public int f2790t = -1;

    /* renamed from: u */
    public int f2791u = -1;

    /* renamed from: v */
    public int f2792v = -1;

    /* renamed from: androidx.constraintlayout.motion.widget.c$a */
    public class a implements Interpolator {

        /* renamed from: a */
        public final /* synthetic */ C11770c f2793a;

        public a(C11770c c11770c) {
            this.f2793a = c11770c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f2793a.mo70117a(f10);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.c$b */
    public static class b {

        /* renamed from: a */
        public final int f2795a;

        /* renamed from: b */
        public final int f2796b;

        /* renamed from: c */
        public long f2797c;

        /* renamed from: d */
        public C12908m f2798d;

        /* renamed from: e */
        public int f2799e;

        /* renamed from: f */
        public int f2800f;

        /* renamed from: h */
        public C0569d f2802h;

        /* renamed from: i */
        public Interpolator f2803i;

        /* renamed from: k */
        public float f2805k;

        /* renamed from: l */
        public float f2806l;

        /* renamed from: m */
        public long f2807m;

        /* renamed from: o */
        public boolean f2809o;

        /* renamed from: g */
        public C11771d f2801g = new C11771d();

        /* renamed from: j */
        public boolean f2804j = false;

        /* renamed from: n */
        public Rect f2808n = new Rect();

        public b(C0569d c0569d, C12908m c12908m, int i10, int i11, int i12, Interpolator interpolator, int i13, int i14) {
            this.f2809o = false;
            this.f2802h = c0569d;
            this.f2798d = c12908m;
            this.f2799e = i10;
            this.f2800f = i11;
            long jNanoTime = System.nanoTime();
            this.f2797c = jNanoTime;
            this.f2807m = jNanoTime;
            this.f2802h.m3517b(this);
            this.f2803i = interpolator;
            this.f2795a = i13;
            this.f2796b = i14;
            if (i12 == 3) {
                this.f2809o = true;
            }
            this.f2806l = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            m3511a();
        }

        /* renamed from: a */
        public void m3511a() {
            if (this.f2804j) {
                m3513c();
            } else {
                m3512b();
            }
        }

        /* renamed from: b */
        public void m3512b() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f2807m;
            this.f2807m = jNanoTime;
            float f10 = this.f2805k + (((float) (j10 * 1.0E-6d)) * this.f2806l);
            this.f2805k = f10;
            if (f10 >= 1.0f) {
                this.f2805k = 1.0f;
            }
            Interpolator interpolator = this.f2803i;
            float interpolation = interpolator == null ? this.f2805k : interpolator.getInterpolation(this.f2805k);
            C12908m c12908m = this.f2798d;
            boolean zM77513x = c12908m.m77513x(c12908m.f58833b, interpolation, jNanoTime, this.f2801g);
            if (this.f2805k >= 1.0f) {
                if (this.f2795a != -1) {
                    this.f2798d.m77511v().setTag(this.f2795a, Long.valueOf(System.nanoTime()));
                }
                if (this.f2796b != -1) {
                    this.f2798d.m77511v().setTag(this.f2796b, null);
                }
                if (!this.f2809o) {
                    this.f2802h.m3522g(this);
                }
            }
            if (this.f2805k < 1.0f || zM77513x) {
                this.f2802h.m3520e();
            }
        }

        /* renamed from: c */
        public void m3513c() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f2807m;
            this.f2807m = jNanoTime;
            float f10 = this.f2805k - (((float) (j10 * 1.0E-6d)) * this.f2806l);
            this.f2805k = f10;
            if (f10 < 0.0f) {
                this.f2805k = 0.0f;
            }
            Interpolator interpolator = this.f2803i;
            float interpolation = interpolator == null ? this.f2805k : interpolator.getInterpolation(this.f2805k);
            C12908m c12908m = this.f2798d;
            boolean zM77513x = c12908m.m77513x(c12908m.f58833b, interpolation, jNanoTime, this.f2801g);
            if (this.f2805k <= 0.0f) {
                if (this.f2795a != -1) {
                    this.f2798d.m77511v().setTag(this.f2795a, Long.valueOf(System.nanoTime()));
                }
                if (this.f2796b != -1) {
                    this.f2798d.m77511v().setTag(this.f2796b, null);
                }
                this.f2802h.m3522g(this);
            }
            if (this.f2805k > 0.0f || zM77513x) {
                this.f2802h.m3520e();
            }
        }

        /* renamed from: d */
        public void m3514d(int i10, float f10, float f11) {
            if (i10 == 1) {
                if (this.f2804j) {
                    return;
                }
                m3515e(true);
            } else {
                if (i10 != 2) {
                    return;
                }
                this.f2798d.m77511v().getHitRect(this.f2808n);
                if (this.f2808n.contains((int) f10, (int) f11) || this.f2804j) {
                    return;
                }
                m3515e(true);
            }
        }

        /* renamed from: e */
        public void m3515e(boolean z10) {
            int i10;
            this.f2804j = z10;
            if (z10 && (i10 = this.f2800f) != -1) {
                this.f2806l = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            }
            this.f2802h.m3520e();
            this.f2807m = System.nanoTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0568c(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.C0568c.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: b */
    public void m3498b(C0569d c0569d, MotionLayout motionLayout, View view) {
        C12908m c12908m = new C12908m(view);
        c12908m.m77482B(view);
        this.f2776f.m77409a(c12908m);
        c12908m.m77489I(motionLayout.getWidth(), motionLayout.getHeight(), this.f2778h, System.nanoTime());
        new b(c0569d, c12908m, this.f2778h, this.f2779i, this.f2772b, m3502f(motionLayout.getContext()), this.f2786p, this.f2787q);
    }

    /* renamed from: c */
    public void m3499c(C0569d c0569d, MotionLayout motionLayout, int i10, C0585c c0585c, final View... viewArr) {
        if (this.f2773c) {
            return;
        }
        int i11 = this.f2775e;
        if (i11 == 2) {
            m3498b(c0569d, motionLayout, viewArr[0]);
            return;
        }
        if (i11 == 1) {
            for (int i12 : motionLayout.getConstraintSetIds()) {
                if (i12 != i10) {
                    C0585c c0585cM3313T = motionLayout.m3313T(i12);
                    for (View view : viewArr) {
                        C0585c.a aVarM3644w = c0585cM3313T.m3644w(view.getId());
                        C0585c.a aVar = this.f2777g;
                        if (aVar != null) {
                            aVar.m3651d(aVarM3644w);
                            aVarM3644w.f3111g.putAll(this.f2777g.f3111g);
                        }
                    }
                }
            }
        }
        C0585c c0585c2 = new C0585c();
        c0585c2.m3638q(c0585c);
        for (View view2 : viewArr) {
            C0585c.a aVarM3644w2 = c0585c2.m3644w(view2.getId());
            C0585c.a aVar2 = this.f2777g;
            if (aVar2 != null) {
                aVar2.m3651d(aVarM3644w2);
                aVarM3644w2.f3111g.putAll(this.f2777g.f3111g);
            }
        }
        motionLayout.m3336q0(i10, c0585c2);
        int i13 = R$id.view_transition;
        motionLayout.m3336q0(i13, c0585c);
        motionLayout.setState(i13, -1, -1);
        C0566a.b bVar = new C0566a.b(-1, motionLayout.f2588a, i13, i10);
        for (View view3 : viewArr) {
            m3510n(bVar, view3);
        }
        motionLayout.setTransition(bVar);
        motionLayout.m3330k0(new Runnable() { // from class: t.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f58879a.m3506j(viewArr);
            }
        });
    }

    /* renamed from: d */
    public boolean m3500d(View view) {
        int i10 = this.f2788r;
        boolean z10 = i10 == -1 || view.getTag(i10) != null;
        int i11 = this.f2789s;
        return z10 && (i11 == -1 || view.getTag(i11) == null);
    }

    /* renamed from: e */
    public int m3501e() {
        return this.f2771a;
    }

    /* renamed from: f */
    public Interpolator m3502f(Context context) {
        int i10 = this.f2782l;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f2784n);
        }
        if (i10 == -1) {
            return new a(C11770c.m70116c(this.f2783m));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    /* renamed from: g */
    public int m3503g() {
        return this.f2790t;
    }

    /* renamed from: h */
    public int m3504h() {
        return this.f2791u;
    }

    /* renamed from: i */
    public int m3505i() {
        return this.f2772b;
    }

    /* renamed from: j */
    public final /* synthetic */ void m3506j(View[] viewArr) {
        if (this.f2786p != -1) {
            for (View view : viewArr) {
                view.setTag(this.f2786p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f2787q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f2787q, null);
            }
        }
    }

    /* renamed from: k */
    public boolean m3507k(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f2780j == -1 && this.f2781k == null) || !m3500d(view)) {
            return false;
        }
        if (view.getId() == this.f2780j) {
            return true;
        }
        return this.f2781k != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).f2981c0) != null && str.matches(this.f2781k);
    }

    /* renamed from: l */
    public final void m3508l(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f2771a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2771a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.f2560E0) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2780j);
                    this.f2780j = resourceId;
                    if (resourceId == -1) {
                        this.f2781k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f2781k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f2780j = typedArrayObtainStyledAttributes.getResourceId(index, this.f2780j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f2772b = typedArrayObtainStyledAttributes.getInt(index, this.f2772b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f2773c = typedArrayObtainStyledAttributes.getBoolean(index, this.f2773c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f2774d = typedArrayObtainStyledAttributes.getInt(index, this.f2774d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f2778h = typedArrayObtainStyledAttributes.getInt(index, this.f2778h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f2779i = typedArrayObtainStyledAttributes.getInt(index, this.f2779i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.f2775e = typedArrayObtainStyledAttributes.getInt(index, this.f2775e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f2784n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f2782l = -2;
                    }
                } else if (i11 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2783m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f2782l = -1;
                    } else {
                        this.f2784n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f2782l = -2;
                    }
                } else {
                    this.f2782l = typedArrayObtainStyledAttributes.getInteger(index, this.f2782l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f2786p = typedArrayObtainStyledAttributes.getResourceId(index, this.f2786p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f2787q = typedArrayObtainStyledAttributes.getResourceId(index, this.f2787q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.f2788r = typedArrayObtainStyledAttributes.getResourceId(index, this.f2788r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f2789s = typedArrayObtainStyledAttributes.getResourceId(index, this.f2789s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f2791u = typedArrayObtainStyledAttributes.getResourceId(index, this.f2791u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f2790t = typedArrayObtainStyledAttributes.getInteger(index, this.f2790t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: m */
    public boolean m3509m(int i10) {
        int i11 = this.f2772b;
        return i11 == 1 ? i10 == 0 : i11 == 2 ? i10 == 1 : i11 == 3 && i10 == 0;
    }

    /* renamed from: n */
    public final void m3510n(C0566a.b bVar, View view) {
        int i10 = this.f2778h;
        if (i10 != -1) {
            bVar.m3455E(i10);
        }
        bVar.m3458H(this.f2774d);
        bVar.m3456F(this.f2782l, this.f2783m, this.f2784n);
        int id2 = view.getId();
        C12902g c12902g = this.f2776f;
        if (c12902g != null) {
            ArrayList<AbstractC12899d> arrayListM77412d = c12902g.m77412d(-1);
            C12902g c12902g2 = new C12902g();
            Iterator<AbstractC12899d> it = arrayListM77412d.iterator();
            while (it.hasNext()) {
                c12902g2.m77411c(it.next().clone().m77330i(id2));
            }
            bVar.m3459t(c12902g2);
        }
    }

    public String toString() {
        return "ViewTransition(" + C12896a.m77317c(this.f2785o, this.f2771a) + ")";
    }
}
