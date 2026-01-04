package p027b3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.C1760a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import p243e0.C9373h;
import p307g3.C9876b;
import p325h3.InterfaceC10090b;
import p356i3.C10427h;
import p356i3.C10432m;

/* renamed from: b3.d */
/* loaded from: classes.dex */
public class C1106d extends C1760a {

    /* renamed from: b3.d$a */
    public static class a extends C10427h {
        public a(C10432m c10432m) {
            super(c10432m);
        }

        @Override // p356i3.C10427h, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public C1106d(FloatingActionButton floatingActionButton, InterfaceC10090b interfaceC10090b) {
        super(floatingActionButton, interfaceC10090b);
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: B */
    public void mo6574B() {
        m10516e0();
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: D */
    public void mo6575D(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: E */
    public void mo6576E(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(C1760a.f8130E, m6582i0(f10, f12));
        stateListAnimator.addState(C1760a.f8131F, m6582i0(f10, f11));
        stateListAnimator.addState(C1760a.f8132G, m6582i0(f10, f11));
        stateListAnimator.addState(C1760a.f8133H, m6582i0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f8161w, "elevation", f10).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f8161w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(C1760a.f8129D);
        stateListAnimator.addState(C1760a.f8134I, animatorSet);
        stateListAnimator.addState(C1760a.f8135J, m6582i0(0.0f, 0.0f));
        this.f8161w.setStateListAnimator(stateListAnimator);
        if (mo6579Y()) {
            m10516e0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: J */
    public boolean mo6577J() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: U */
    public void mo6578U(ColorStateList colorStateList) {
        Drawable drawable = this.f8141c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(C9876b.m61325d(colorStateList));
        } else {
            super.mo6578U(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: Y */
    public boolean mo6579Y() {
        return this.f8162x.mo10485b() || !m10512a0();
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: c0 */
    public void mo6580c0() {
    }

    /* renamed from: h0 */
    public C1105c m6581h0(int i10, ColorStateList colorStateList) {
        Context context = this.f8161w.getContext();
        C1105c c1105c = new C1105c((C10432m) C9373h.m58745f(this.f8139a));
        c1105c.m6572e(ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color));
        c1105c.m6571d(i10);
        c1105c.m6570c(colorStateList);
        return c1105c;
    }

    /* renamed from: i0 */
    public final Animator m6582i0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f8161w, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f8161w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(C1760a.f8129D);
        return animatorSet;
    }

    /* renamed from: j0 */
    public C10427h m6583j0() {
        return new a((C10432m) C9373h.m58745f(this.f8139a));
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: m */
    public float mo6584m() {
        return this.f8161w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: r */
    public void mo6585r(Rect rect) {
        if (this.f8162x.mo10485b()) {
            super.mo6585r(rect);
        } else if (m10512a0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f8149k - this.f8161w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: w */
    public void mo6586w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable layerDrawable;
        C10427h c10427hM6583j0 = m6583j0();
        this.f8140b = c10427hM6583j0;
        c10427hM6583j0.setTintList(colorStateList);
        if (mode != null) {
            this.f8140b.setTintMode(mode);
        }
        this.f8140b.m63992Q(this.f8161w.getContext());
        if (i10 > 0) {
            this.f8142d = m6581h0(i10, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) C9373h.m58745f(this.f8142d), (Drawable) C9373h.m58745f(this.f8140b)});
        } else {
            this.f8142d = null;
            layerDrawable = this.f8140b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(C9876b.m61325d(colorStateList2), layerDrawable, null);
        this.f8141c = rippleDrawable;
        this.f8143e = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.C1760a
    /* renamed from: z */
    public void mo6587z() {
    }
}
