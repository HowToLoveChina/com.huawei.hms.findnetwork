package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.R$styleable;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;

/* renamed from: com.google.android.material.internal.s */
/* loaded from: classes.dex */
public class C1788s {

    /* renamed from: com.google.android.material.internal.s$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f8408a;

        public a(View view) {
            this.f8408a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f8408a.getContext().getSystemService("input_method")).showSoftInput(this.f8408a, 1);
        }
    }

    /* renamed from: com.google.android.material.internal.s$b */
    public class b implements e {

        /* renamed from: a */
        public final /* synthetic */ boolean f8409a;

        /* renamed from: b */
        public final /* synthetic */ boolean f8410b;

        /* renamed from: c */
        public final /* synthetic */ boolean f8411c;

        /* renamed from: d */
        public final /* synthetic */ e f8412d;

        public b(boolean z10, boolean z11, boolean z12, e eVar) {
            this.f8409a = z10;
            this.f8410b = z11;
            this.f8411c = z12;
            this.f8412d = eVar;
        }

        @Override // com.google.android.material.internal.C1788s.e
        /* renamed from: a */
        public C9625s0 mo9794a(View view, C9625s0 c9625s0, f fVar) {
            if (this.f8409a) {
                fVar.f8418d += c9625s0.m60157i();
            }
            boolean zM10788i = C1788s.m10788i(view);
            if (this.f8410b) {
                if (zM10788i) {
                    fVar.f8417c += c9625s0.m60158j();
                } else {
                    fVar.f8415a += c9625s0.m60158j();
                }
            }
            if (this.f8411c) {
                if (zM10788i) {
                    fVar.f8415a += c9625s0.m60159k();
                } else {
                    fVar.f8417c += c9625s0.m60159k();
                }
            }
            fVar.m10792a(view);
            e eVar = this.f8412d;
            return eVar != null ? eVar.mo9794a(view, c9625s0, fVar) : c9625s0;
        }
    }

    /* renamed from: com.google.android.material.internal.s$c */
    public class c implements InterfaceC9586b0 {

        /* renamed from: a */
        public final /* synthetic */ e f8413a;

        /* renamed from: b */
        public final /* synthetic */ f f8414b;

        public c(e eVar, f fVar) {
            this.f8413a = eVar;
            this.f8414b = fVar;
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            return this.f8413a.mo9794a(view, c9625s0, new f(this.f8414b));
        }
    }

    /* renamed from: com.google.android.material.internal.s$d */
    public class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            C9603h0.m59896m0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.google.android.material.internal.s$e */
    public interface e {
        /* renamed from: a */
        C9625s0 mo9794a(View view, C9625s0 c9625s0, f fVar);
    }

    /* renamed from: a */
    public static void m10780a(View view, AttributeSet attributeSet, int i10, int i11, e eVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i10, i11);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        m10781b(view, new b(z10, z11, z12, eVar));
    }

    /* renamed from: b */
    public static void m10781b(View view, e eVar) {
        C9603h0.m59837C0(view, new c(eVar, new f(C9603h0.m59842F(view), view.getPaddingTop(), C9603h0.m59840E(view), view.getPaddingBottom())));
        m10790k(view);
    }

    /* renamed from: c */
    public static float m10782c(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    /* renamed from: d */
    public static Integer m10783d(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    /* renamed from: e */
    public static ViewGroup m10784e(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    /* renamed from: f */
    public static InterfaceC1787r m10785f(View view) {
        return m10786g(m10784e(view));
    }

    /* renamed from: g */
    public static InterfaceC1787r m10786g(View view) {
        if (view == null) {
            return null;
        }
        return new C1786q(view);
    }

    /* renamed from: h */
    public static float m10787h(View view) {
        float fM59913v = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fM59913v += C9603h0.m59913v((View) parent);
        }
        return fM59913v;
    }

    /* renamed from: i */
    public static boolean m10788i(View view) {
        return C9603h0.m59832A(view) == 1;
    }

    /* renamed from: j */
    public static PorterDuff.Mode m10789j(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: k */
    public static void m10790k(View view) {
        if (C9603h0.m59863S(view)) {
            C9603h0.m59896m0(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    /* renamed from: l */
    public static void m10791l(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* renamed from: com.google.android.material.internal.s$f */
    public static class f {

        /* renamed from: a */
        public int f8415a;

        /* renamed from: b */
        public int f8416b;

        /* renamed from: c */
        public int f8417c;

        /* renamed from: d */
        public int f8418d;

        public f(int i10, int i11, int i12, int i13) {
            this.f8415a = i10;
            this.f8416b = i11;
            this.f8417c = i12;
            this.f8418d = i13;
        }

        /* renamed from: a */
        public void m10792a(View view) {
            C9603h0.m59839D0(view, this.f8415a, this.f8416b, this.f8417c, this.f8418d);
        }

        public f(f fVar) {
            this.f8415a = fVar.f8415a;
            this.f8416b = fVar.f8416b;
            this.f8417c = fVar.f8417c;
            this.f8418d = fVar.f8418d;
        }
    }
}
