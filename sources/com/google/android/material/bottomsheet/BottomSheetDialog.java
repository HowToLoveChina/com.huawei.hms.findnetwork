package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.huawei.hiar.ARImageMetadata;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p304g0.C9832l;
import p356i3.C10427h;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: e */
    public BottomSheetBehavior<FrameLayout> f7657e;

    /* renamed from: f */
    public FrameLayout f7658f;

    /* renamed from: g */
    public CoordinatorLayout f7659g;

    /* renamed from: h */
    public FrameLayout f7660h;

    /* renamed from: i */
    public boolean f7661i;

    /* renamed from: j */
    public boolean f7662j;

    /* renamed from: k */
    public boolean f7663k;

    /* renamed from: l */
    public boolean f7664l;

    /* renamed from: m */
    public BottomSheetBehavior.AbstractC1681f f7665m;

    /* renamed from: n */
    public boolean f7666n;

    /* renamed from: o */
    public BottomSheetBehavior.AbstractC1681f f7667o;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$a */
    public class C1683a implements InterfaceC9586b0 {
        public C1683a() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            if (BottomSheetDialog.this.f7665m != null) {
                BottomSheetDialog.this.f7657e.m9875p0(BottomSheetDialog.this.f7665m);
            }
            if (c9625s0 != null) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                bottomSheetDialog.f7665m = new C1688f(bottomSheetDialog.f7660h, c9625s0, null);
                BottomSheetDialog.this.f7657e.m9857W(BottomSheetDialog.this.f7665m);
            }
            return c9625s0;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$b */
    public class ViewOnClickListenerC1684b implements View.OnClickListener {
        public ViewOnClickListenerC1684b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (bottomSheetDialog.f7662j && bottomSheetDialog.isShowing() && BottomSheetDialog.this.m9905u()) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$c */
    public class C1685c extends C9582a {
        public C1685c() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            if (!BottomSheetDialog.this.f7662j) {
                c9832l.m61072a0(false);
            } else {
                c9832l.m61071a(ARImageMetadata.SHADING_MODE);
                c9832l.m61072a0(true);
            }
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f7662j) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$d */
    public class ViewOnTouchListenerC1686d implements View.OnTouchListener {
        public ViewOnTouchListenerC1686d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$e */
    public class C1687e extends BottomSheetBehavior.AbstractC1681f {
        public C1687e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.AbstractC1681f
        /* renamed from: b */
        public void mo9892b(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.AbstractC1681f
        /* renamed from: c */
        public void mo9893c(View view, int i10) {
            if (i10 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$f */
    public static class C1688f extends BottomSheetBehavior.AbstractC1681f {

        /* renamed from: a */
        public final boolean f7673a;

        /* renamed from: b */
        public final boolean f7674b;

        /* renamed from: c */
        public final C9625s0 f7675c;

        public /* synthetic */ C1688f(View view, C9625s0 c9625s0, C1683a c1683a) {
            this(view, c9625s0);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.AbstractC1681f
        /* renamed from: a */
        public void mo9891a(View view) {
            m9907d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.AbstractC1681f
        /* renamed from: b */
        public void mo9892b(View view, float f10) {
            m9907d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.AbstractC1681f
        /* renamed from: c */
        public void mo9893c(View view, int i10) {
            m9907d(view);
        }

        /* renamed from: d */
        public final void m9907d(View view) {
            if (view.getTop() < this.f7675c.m60160l()) {
                BottomSheetDialog.m9902t(view, this.f7673a);
                view.setPadding(view.getPaddingLeft(), this.f7675c.m60160l() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.m9902t(view, this.f7674b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public C1688f(View view, C9625s0 c9625s0) {
            this.f7675c = c9625s0;
            boolean z10 = (view.getSystemUiVisibility() & 8192) != 0;
            this.f7674b = z10;
            C10427h c10427hM9868i0 = BottomSheetBehavior.m9836f0(view).m9868i0();
            ColorStateList colorStateListM64033x = c10427hM9868i0 != null ? c10427hM9868i0.m64033x() : C9603h0.m59905r(view);
            if (colorStateListM64033x != null) {
                this.f7673a = C13689a.m82292f(colorStateListM64033x.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f7673a = C13689a.m82292f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f7673a = z10;
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        this.f7666n = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    /* renamed from: k */
    public static int m9897k(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    /* renamed from: t */
    public static void m9902t(View view, boolean z10) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM9904s = m9904s();
        if (!this.f7661i || bottomSheetBehaviorM9904s.m9869j0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorM9904s.m9843G0(5);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.f7666n && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f7658f;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f7659g;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            if (z10) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f7657e;
        if (bottomSheetBehavior == null || bottomSheetBehavior.m9869j0() != 5) {
            return;
        }
        this.f7657e.m9843G0(4);
    }

    /* renamed from: r */
    public final FrameLayout m9903r() {
        if (this.f7658f == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f7658f = frameLayout;
            this.f7659g = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f7658f.findViewById(R$id.design_bottom_sheet);
            this.f7660h = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM9836f0 = BottomSheetBehavior.m9836f0(frameLayout2);
            this.f7657e = bottomSheetBehaviorM9836f0;
            bottomSheetBehaviorM9836f0.m9857W(this.f7667o);
            this.f7657e.m9885z0(this.f7662j);
        }
        return this.f7658f;
    }

    /* renamed from: s */
    public BottomSheetBehavior<FrameLayout> m9904s() {
        if (this.f7657e == null) {
            m9903r();
        }
        return this.f7657e;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f7662j != z10) {
            this.f7662j = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f7657e;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.m9885z0(z10);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f7662j) {
            this.f7662j = true;
        }
        this.f7663k = z10;
        this.f7664l = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(m9906v(i10, null, null));
    }

    /* renamed from: u */
    public boolean m9905u() {
        if (!this.f7664l) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.f7663k = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f7664l = true;
        }
        return this.f7663k;
    }

    /* renamed from: v */
    public final View m9906v(int i10, View view, ViewGroup.LayoutParams layoutParams) {
        m9903r();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f7658f.findViewById(R$id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f7666n) {
            C9603h0.m59837C0(this.f7660h, new C1683a());
        }
        this.f7660h.removeAllViews();
        if (layoutParams == null) {
            this.f7660h.addView(view);
        } else {
            this.f7660h.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new ViewOnClickListenerC1684b());
        C9603h0.m59902p0(this.f7660h, new C1685c());
        this.f7660h.setOnTouchListener(new ViewOnTouchListenerC1686d());
        return this.f7658f;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(m9906v(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m9906v(0, view, layoutParams));
    }

    public BottomSheetDialog(Context context, int i10) {
        super(context, m9897k(context, i10));
        this.f7662j = true;
        this.f7663k = true;
        this.f7667o = new C1687e();
        m2191m(1);
        this.f7666n = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
