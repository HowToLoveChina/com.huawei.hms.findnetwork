package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* renamed from: L */
    public static final String[] f4819L = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: K */
    public int f4820K;

    /* renamed from: androidx.transition.Visibility$a */
    public class C0926a extends C0955p {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f4821a;

        /* renamed from: b */
        public final /* synthetic */ View f4822b;

        /* renamed from: c */
        public final /* synthetic */ View f4823c;

        public C0926a(ViewGroup viewGroup, View view, View view2) {
            this.f4821a = viewGroup;
            this.f4822b = view;
            this.f4823c = view2;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
            C0964y.m5845b(this.f4821a).mo5843d(this.f4822b);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            this.f4823c.setTag(R$id.save_overlay_view, null);
            C0964y.m5845b(this.f4821a).mo5843d(this.f4822b);
            transition.mo5721V(this);
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
            if (this.f4822b.getParent() == null) {
                C0964y.m5845b(this.f4821a).mo5842c(this.f4822b);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    /* renamed from: androidx.transition.Visibility$b */
    public static class C0927b extends AnimatorListenerAdapter implements Transition.InterfaceC0923f {

        /* renamed from: a */
        public final View f4825a;

        /* renamed from: b */
        public final int f4826b;

        /* renamed from: c */
        public final ViewGroup f4827c;

        /* renamed from: d */
        public final boolean f4828d;

        /* renamed from: e */
        public boolean f4829e;

        /* renamed from: f */
        public boolean f4830f = false;

        public C0927b(View view, int i10, boolean z10) {
            this.f4825a = view;
            this.f4826b = i10;
            this.f4827c = (ViewGroup) view.getParent();
            this.f4828d = z10;
            m5777g(true);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: a */
        public void mo5755a(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
            m5777g(false);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            m5776f();
            transition.mo5721V(this);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: d */
        public void mo5638d(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
            m5777g(true);
        }

        /* renamed from: f */
        public final void m5776f() {
            if (!this.f4830f) {
                C0932b0.m5792i(this.f4825a, this.f4826b);
                ViewGroup viewGroup = this.f4827c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m5777g(false);
        }

        /* renamed from: g */
        public final void m5777g(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f4828d || this.f4829e == z10 || (viewGroup = this.f4827c) == null) {
                return;
            }
            this.f4829e = z10;
            C0964y.m5846c(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4830f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m5776f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f4830f) {
                return;
            }
            C0932b0.m5792i(this.f4825a, this.f4826b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f4830f) {
                return;
            }
            C0932b0.m5792i(this.f4825a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: androidx.transition.Visibility$c */
    public static class C0928c {

        /* renamed from: a */
        public boolean f4831a;

        /* renamed from: b */
        public boolean f4832b;

        /* renamed from: c */
        public int f4833c;

        /* renamed from: d */
        public int f4834d;

        /* renamed from: e */
        public ViewGroup f4835e;

        /* renamed from: f */
        public ViewGroup f4836f;
    }

    public Visibility() {
        this.f4820K = 3;
    }

    /* renamed from: j0 */
    private void m5770j0(C0959t c0959t) {
        c0959t.f4888a.put("android:visibility:visibility", Integer.valueOf(c0959t.f4889b.getVisibility()));
        c0959t.f4888a.put("android:visibility:parent", c0959t.f4889b.getParent());
        int[] iArr = new int[2];
        c0959t.f4889b.getLocationOnScreen(iArr);
        c0959t.f4888a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4819L;
    }

    @Override // androidx.transition.Transition
    /* renamed from: J */
    public boolean mo5712J(C0959t c0959t, C0959t c0959t2) {
        if (c0959t == null && c0959t2 == null) {
            return false;
        }
        if (c0959t != null && c0959t2 != null && c0959t2.f4888a.containsKey("android:visibility:visibility") != c0959t.f4888a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C0928c c0928cM5772l0 = m5772l0(c0959t, c0959t2);
        if (c0928cM5772l0.f4831a) {
            return c0928cM5772l0.f4833c == 0 || c0928cM5772l0.f4834d == 0;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5770j0(c0959t);
    }

    /* renamed from: k0 */
    public int m5771k0() {
        return this.f4820K;
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5770j0(c0959t);
    }

    /* renamed from: l0 */
    public final C0928c m5772l0(C0959t c0959t, C0959t c0959t2) {
        C0928c c0928c = new C0928c();
        c0928c.f4831a = false;
        c0928c.f4832b = false;
        if (c0959t == null || !c0959t.f4888a.containsKey("android:visibility:visibility")) {
            c0928c.f4833c = -1;
            c0928c.f4835e = null;
        } else {
            c0928c.f4833c = ((Integer) c0959t.f4888a.get("android:visibility:visibility")).intValue();
            c0928c.f4835e = (ViewGroup) c0959t.f4888a.get("android:visibility:parent");
        }
        if (c0959t2 == null || !c0959t2.f4888a.containsKey("android:visibility:visibility")) {
            c0928c.f4834d = -1;
            c0928c.f4836f = null;
        } else {
            c0928c.f4834d = ((Integer) c0959t2.f4888a.get("android:visibility:visibility")).intValue();
            c0928c.f4836f = (ViewGroup) c0959t2.f4888a.get("android:visibility:parent");
        }
        if (c0959t != null && c0959t2 != null) {
            int i10 = c0928c.f4833c;
            int i11 = c0928c.f4834d;
            if (i10 == i11 && c0928c.f4835e == c0928c.f4836f) {
                return c0928c;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    c0928c.f4832b = false;
                    c0928c.f4831a = true;
                } else if (i11 == 0) {
                    c0928c.f4832b = true;
                    c0928c.f4831a = true;
                }
            } else if (c0928c.f4836f == null) {
                c0928c.f4832b = false;
                c0928c.f4831a = true;
            } else if (c0928c.f4835e == null) {
                c0928c.f4832b = true;
                c0928c.f4831a = true;
            }
        } else if (c0959t == null && c0928c.f4834d == 0) {
            c0928c.f4832b = true;
            c0928c.f4831a = true;
        } else if (c0959t2 == null && c0928c.f4833c == 0) {
            c0928c.f4832b = false;
            c0928c.f4831a = true;
        }
        return c0928c;
    }

    /* renamed from: m0 */
    public Animator mo5674m0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        return null;
    }

    /* renamed from: n0 */
    public Animator m5773n0(ViewGroup viewGroup, C0959t c0959t, int i10, C0959t c0959t2, int i11) {
        if ((this.f4820K & 1) != 1 || c0959t2 == null) {
            return null;
        }
        if (c0959t == null) {
            View view = (View) c0959t2.f4889b.getParent();
            if (m5772l0(m5750w(view, false), m5711H(view, false)).f4831a) {
                return null;
            }
        }
        return mo5674m0(viewGroup, c0959t2.f4889b, c0959t, c0959t2);
    }

    /* renamed from: o0 */
    public Animator mo5675o0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        return null;
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        C0928c c0928cM5772l0 = m5772l0(c0959t, c0959t2);
        if (!c0928cM5772l0.f4831a) {
            return null;
        }
        if (c0928cM5772l0.f4835e == null && c0928cM5772l0.f4836f == null) {
            return null;
        }
        return c0928cM5772l0.f4832b ? m5773n0(viewGroup, c0959t, c0928cM5772l0.f4833c, c0959t2, c0928cM5772l0.f4834d) : m5774p0(viewGroup, c0959t, c0928cM5772l0.f4833c, c0959t2, c0928cM5772l0.f4834d);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073 A[PHI: r8
  0x0073: PHI (r8v3 android.view.View) = 
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v6 android.view.View)
 binds: [B:26:0x0048, B:31:0x0057, B:37:0x0082, B:39:0x0085, B:41:0x008b, B:43:0x008f, B:34:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: p0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator m5774p0(android.view.ViewGroup r18, androidx.transition.C0959t r19, int r20, androidx.transition.C0959t r21, int r22) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.m5774p0(android.view.ViewGroup, androidx.transition.t, int, androidx.transition.t, int):android.animation.Animator");
    }

    /* renamed from: q0 */
    public void m5775q0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f4820K = i10;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4820K = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4868e);
        int namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (namedInt != 0) {
            m5775q0(namedInt);
        }
    }
}
