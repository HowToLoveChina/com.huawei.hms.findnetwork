package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.huawei.hiar.ARImageMetadata;
import p273f0.C9603h0;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;
import p413k0.C10970c;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public C10970c f7503a;

    /* renamed from: b */
    public InterfaceC1657c f7504b;

    /* renamed from: c */
    public boolean f7505c;

    /* renamed from: e */
    public boolean f7507e;

    /* renamed from: d */
    public float f7506d = 0.0f;

    /* renamed from: f */
    public int f7508f = 2;

    /* renamed from: g */
    public float f7509g = 0.5f;

    /* renamed from: h */
    public float f7510h = 0.0f;

    /* renamed from: i */
    public float f7511i = 0.5f;

    /* renamed from: j */
    public final C10970c.c f7512j = new C1655a();

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$a */
    public class C1655a extends C10970c.c {

        /* renamed from: a */
        public int f7513a;

        /* renamed from: b */
        public int f7514b = -1;

        public C1655a() {
        }

        @Override // p413k0.C10970c.c
        /* renamed from: a */
        public int mo4174a(View view, int i10, int i11) {
            int width;
            int width2;
            int width3;
            boolean z10 = C9603h0.m59832A(view) == 1;
            int i12 = SwipeDismissBehavior.this.f7508f;
            if (i12 == 0) {
                if (z10) {
                    width = this.f7513a - view.getWidth();
                    width2 = this.f7513a;
                } else {
                    width = this.f7513a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 != 1) {
                width = this.f7513a - view.getWidth();
                width2 = this.f7513a + view.getWidth();
            } else if (z10) {
                width = this.f7513a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f7513a - view.getWidth();
                width2 = this.f7513a;
            }
            return SwipeDismissBehavior.m9715G(width, i10, width2);
        }

        @Override // p413k0.C10970c.c
        /* renamed from: b */
        public int mo4175b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: d */
        public int mo4176d(View view) {
            return view.getWidth();
        }

        @Override // p413k0.C10970c.c
        /* renamed from: i */
        public void mo4180i(View view, int i10) {
            this.f7514b = i10;
            this.f7513a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // p413k0.C10970c.c
        /* renamed from: j */
        public void mo4181j(int i10) {
            InterfaceC1657c interfaceC1657c = SwipeDismissBehavior.this.f7504b;
            if (interfaceC1657c != null) {
                interfaceC1657c.mo9726b(i10);
            }
        }

        @Override // p413k0.C10970c.c
        /* renamed from: k */
        public void mo4182k(View view, int i10, int i11, int i12, int i13) {
            float width = this.f7513a + (view.getWidth() * SwipeDismissBehavior.this.f7510h);
            float width2 = this.f7513a + (view.getWidth() * SwipeDismissBehavior.this.f7511i);
            float f10 = i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m9714F(0.0f, 1.0f - SwipeDismissBehavior.m9716I(width, width2, f10), 1.0f));
            }
        }

        @Override // p413k0.C10970c.c
        /* renamed from: l */
        public void mo4183l(View view, float f10, float f11) {
            int i10;
            boolean z10;
            InterfaceC1657c interfaceC1657c;
            this.f7514b = -1;
            int width = view.getWidth();
            if (m9724n(view, f10)) {
                int left = view.getLeft();
                int i11 = this.f7513a;
                i10 = left < i11 ? i11 - width : i11 + width;
                z10 = true;
            } else {
                i10 = this.f7513a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f7503a.m66266O(i10, view.getTop())) {
                C9603h0.m59886h0(view, new RunnableC1658d(view, z10));
            } else {
                if (!z10 || (interfaceC1657c = SwipeDismissBehavior.this.f7504b) == null) {
                    return;
                }
                interfaceC1657c.mo9725a(view);
            }
        }

        @Override // p413k0.C10970c.c
        /* renamed from: m */
        public boolean mo4184m(View view, int i10) {
            int i11 = this.f7514b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.mo9717E(view);
        }

        /* renamed from: n */
        public final boolean m9724n(View view, float f10) {
            if (f10 == 0.0f) {
                return Math.abs(view.getLeft() - this.f7513a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f7509g);
            }
            boolean z10 = C9603h0.m59832A(view) == 1;
            int i10 = SwipeDismissBehavior.this.f7508f;
            if (i10 == 2) {
                return true;
            }
            if (i10 == 0) {
                if (z10) {
                    if (f10 >= 0.0f) {
                        return false;
                    }
                } else if (f10 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            if (z10) {
                if (f10 <= 0.0f) {
                    return false;
                }
            } else if (f10 >= 0.0f) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$b */
    public class C1656b implements InterfaceC9835o {
        public C1656b() {
        }

        @Override // p304g0.InterfaceC9835o
        /* renamed from: a */
        public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
            if (!SwipeDismissBehavior.this.mo9717E(view)) {
                return false;
            }
            boolean z10 = C9603h0.m59832A(view) == 1;
            int i10 = SwipeDismissBehavior.this.f7508f;
            C9603h0.m59870Z(view, (!(i10 == 0 && z10) && (i10 != 1 || z10)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            InterfaceC1657c interfaceC1657c = SwipeDismissBehavior.this.f7504b;
            if (interfaceC1657c != null) {
                interfaceC1657c.mo9725a(view);
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$c */
    public interface InterfaceC1657c {
        /* renamed from: a */
        void mo9725a(View view);

        /* renamed from: b */
        void mo9726b(int i10);
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$d */
    public class RunnableC1658d implements Runnable {

        /* renamed from: a */
        public final View f7517a;

        /* renamed from: b */
        public final boolean f7518b;

        public RunnableC1658d(View view, boolean z10) {
            this.f7517a = view;
            this.f7518b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC1657c interfaceC1657c;
            C10970c c10970c = SwipeDismissBehavior.this.f7503a;
            if (c10970c != null && c10970c.m66282m(true)) {
                C9603h0.m59886h0(this.f7517a, this);
            } else {
                if (!this.f7518b || (interfaceC1657c = SwipeDismissBehavior.this.f7504b) == null) {
                    return;
                }
                interfaceC1657c.mo9725a(this.f7517a);
            }
        }
    }

    /* renamed from: F */
    public static float m9714F(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    /* renamed from: G */
    public static int m9715G(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    /* renamed from: I */
    public static float m9716I(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: D */
    public boolean mo3726D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        C10970c c10970c = this.f7503a;
        if (c10970c == null) {
            return false;
        }
        c10970c.m66257F(motionEvent);
        return true;
    }

    /* renamed from: E */
    public boolean mo9717E(View view) {
        return true;
    }

    /* renamed from: H */
    public final void m9718H(ViewGroup viewGroup) {
        if (this.f7503a == null) {
            this.f7503a = this.f7507e ? C10970c.m66250n(viewGroup, this.f7506d, this.f7512j) : C10970c.m66251o(viewGroup, this.f7512j);
        }
    }

    /* renamed from: J */
    public void m9719J(float f10) {
        this.f7511i = m9714F(0.0f, f10, 1.0f);
    }

    /* renamed from: K */
    public void m9720K(InterfaceC1657c interfaceC1657c) {
        this.f7504b = interfaceC1657c;
    }

    /* renamed from: L */
    public void m9721L(float f10) {
        this.f7510h = m9714F(0.0f, f10, 1.0f);
    }

    /* renamed from: M */
    public void m9722M(int i10) {
        this.f7508f = i10;
    }

    /* renamed from: N */
    public final void m9723N(View view) {
        C9603h0.m59890j0(view, ARImageMetadata.SHADING_MODE);
        if (mo9717E(view)) {
            C9603h0.m59894l0(view, C9832l.a.f48315y, null, new C1656b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: k */
    public boolean mo3737k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean zM3691F = this.f7505c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zM3691F = coordinatorLayout.m3691F(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f7505c = zM3691F;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f7505c = false;
        }
        if (!zM3691F) {
            return false;
        }
        m9718H(coordinatorLayout);
        return this.f7503a.m66267P(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: l */
    public boolean mo3738l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean zMo3738l = super.mo3738l(coordinatorLayout, v10, i10);
        if (C9603h0.m59919y(v10) == 0) {
            C9603h0.m59833A0(v10, 1);
            m9723N(v10);
        }
        return zMo3738l;
    }
}
