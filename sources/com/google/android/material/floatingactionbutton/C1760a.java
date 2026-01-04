package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.C1779j;
import java.util.ArrayList;
import java.util.Iterator;
import p027b3.C1105c;
import p215d3.C8997a;
import p243e0.C9373h;
import p273f0.C9603h0;
import p307g3.C9876b;
import p325h3.InterfaceC10090b;
import p356i3.C10427h;
import p356i3.C10428i;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p666u2.C13110a;
import p666u2.C13111b;
import p666u2.C13115f;
import p666u2.C13116g;
import p666u2.C13117h;
import p757x.C13669a;

/* renamed from: com.google.android.material.floatingactionbutton.a */
/* loaded from: classes.dex */
public class C1760a {

    /* renamed from: D */
    public static final TimeInterpolator f8129D = C13110a.f59599c;

    /* renamed from: E */
    public static final int[] f8130E = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: F */
    public static final int[] f8131F = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: G */
    public static final int[] f8132G = {R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: H */
    public static final int[] f8133H = {R.attr.state_hovered, R.attr.state_enabled};

    /* renamed from: I */
    public static final int[] f8134I = {R.attr.state_enabled};

    /* renamed from: J */
    public static final int[] f8135J = new int[0];

    /* renamed from: C */
    public ViewTreeObserver.OnPreDrawListener f8138C;

    /* renamed from: a */
    public C10432m f8139a;

    /* renamed from: b */
    public C10427h f8140b;

    /* renamed from: c */
    public Drawable f8141c;

    /* renamed from: d */
    public C1105c f8142d;

    /* renamed from: e */
    public Drawable f8143e;

    /* renamed from: f */
    public boolean f8144f;

    /* renamed from: h */
    public float f8146h;

    /* renamed from: i */
    public float f8147i;

    /* renamed from: j */
    public float f8148j;

    /* renamed from: k */
    public int f8149k;

    /* renamed from: l */
    public final C1779j f8150l;

    /* renamed from: m */
    public Animator f8151m;

    /* renamed from: n */
    public C13117h f8152n;

    /* renamed from: o */
    public C13117h f8153o;

    /* renamed from: p */
    public float f8154p;

    /* renamed from: r */
    public int f8156r;

    /* renamed from: t */
    public ArrayList<Animator.AnimatorListener> f8158t;

    /* renamed from: u */
    public ArrayList<Animator.AnimatorListener> f8159u;

    /* renamed from: v */
    public ArrayList<i> f8160v;

    /* renamed from: w */
    public final FloatingActionButton f8161w;

    /* renamed from: x */
    public final InterfaceC10090b f8162x;

    /* renamed from: g */
    public boolean f8145g = true;

    /* renamed from: q */
    public float f8155q = 1.0f;

    /* renamed from: s */
    public int f8157s = 0;

    /* renamed from: y */
    public final Rect f8163y = new Rect();

    /* renamed from: z */
    public final RectF f8164z = new RectF();

    /* renamed from: A */
    public final RectF f8136A = new RectF();

    /* renamed from: B */
    public final Matrix f8137B = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.a$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f8165a;

        /* renamed from: b */
        public final /* synthetic */ boolean f8166b;

        /* renamed from: c */
        public final /* synthetic */ j f8167c;

        public a(boolean z10, j jVar) {
            this.f8166b = z10;
            this.f8167c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8165a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1760a.this.f8157s = 0;
            C1760a.this.f8151m = null;
            if (this.f8165a) {
                return;
            }
            FloatingActionButton floatingActionButton = C1760a.this.f8161w;
            boolean z10 = this.f8166b;
            floatingActionButton.m10567b(z10 ? 8 : 4, z10);
            j jVar = this.f8167c;
            if (jVar != null) {
                jVar.mo10483b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1760a.this.f8161w.m10567b(0, this.f8166b);
            C1760a.this.f8157s = 1;
            C1760a.this.f8151m = animator;
            this.f8165a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$b */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f8169a;

        /* renamed from: b */
        public final /* synthetic */ j f8170b;

        public b(boolean z10, j jVar) {
            this.f8169a = z10;
            this.f8170b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1760a.this.f8157s = 0;
            C1760a.this.f8151m = null;
            j jVar = this.f8170b;
            if (jVar != null) {
                jVar.mo10482a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1760a.this.f8161w.m10567b(0, this.f8169a);
            C1760a.this.f8157s = 2;
            C1760a.this.f8151m = animator;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$c */
    public class c extends C13116g {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            C1760a.this.f8155q = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$d */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ float f8173a;

        /* renamed from: b */
        public final /* synthetic */ float f8174b;

        /* renamed from: c */
        public final /* synthetic */ float f8175c;

        /* renamed from: d */
        public final /* synthetic */ float f8176d;

        /* renamed from: e */
        public final /* synthetic */ float f8177e;

        /* renamed from: f */
        public final /* synthetic */ float f8178f;

        /* renamed from: g */
        public final /* synthetic */ float f8179g;

        /* renamed from: h */
        public final /* synthetic */ Matrix f8180h;

        public d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f8173a = f10;
            this.f8174b = f11;
            this.f8175c = f12;
            this.f8176d = f13;
            this.f8177e = f14;
            this.f8178f = f15;
            this.f8179g = f16;
            this.f8180h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C1760a.this.f8161w.setAlpha(C13110a.m78885b(this.f8173a, this.f8174b, 0.0f, 0.2f, fFloatValue));
            C1760a.this.f8161w.setScaleX(C13110a.m78884a(this.f8175c, this.f8176d, fFloatValue));
            C1760a.this.f8161w.setScaleY(C13110a.m78884a(this.f8177e, this.f8176d, fFloatValue));
            C1760a.this.f8155q = C13110a.m78884a(this.f8178f, this.f8179g, fFloatValue);
            C1760a.this.m10521h(C13110a.m78884a(this.f8178f, this.f8179g, fFloatValue), this.f8180h);
            C1760a.this.f8161w.setImageMatrix(this.f8180h);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$e */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            C1760a.this.m10495G();
            return true;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$f */
    public class f extends l {
        public f() {
            super(C1760a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.l
        /* renamed from: a */
        public float mo10537a() {
            return 0.0f;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$g */
    public class g extends l {
        public g() {
            super(C1760a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.l
        /* renamed from: a */
        public float mo10537a() {
            C1760a c1760a = C1760a.this;
            return c1760a.f8146h + c1760a.f8147i;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$h */
    public class h extends l {
        public h() {
            super(C1760a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.l
        /* renamed from: a */
        public float mo10537a() {
            C1760a c1760a = C1760a.this;
            return c1760a.f8146h + c1760a.f8148j;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$i */
    public interface i {
        /* renamed from: a */
        void mo10486a();

        /* renamed from: b */
        void mo10487b();
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$j */
    public interface j {
        /* renamed from: a */
        void mo10482a();

        /* renamed from: b */
        void mo10483b();
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$k */
    public class k extends l {
        public k() {
            super(C1760a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.l
        /* renamed from: a */
        public float mo10537a() {
            return C1760a.this.f8146h;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$l */
    public abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public boolean f8187a;

        /* renamed from: b */
        public float f8188b;

        /* renamed from: c */
        public float f8189c;

        public l() {
        }

        /* renamed from: a */
        public abstract float mo10537a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1760a.this.m10518f0((int) this.f8189c);
            this.f8187a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f8187a) {
                C10427h c10427h = C1760a.this.f8140b;
                this.f8188b = c10427h == null ? 0.0f : c10427h.m64032w();
                this.f8189c = mo10537a();
                this.f8187a = true;
            }
            C1760a c1760a = C1760a.this;
            float f10 = this.f8188b;
            c1760a.m10518f0((int) (f10 + ((this.f8189c - f10) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ l(C1760a c1760a, a aVar) {
            this();
        }
    }

    public C1760a(FloatingActionButton floatingActionButton, InterfaceC10090b interfaceC10090b) {
        this.f8161w = floatingActionButton;
        this.f8162x = interfaceC10090b;
        C1779j c1779j = new C1779j();
        this.f8150l = c1779j;
        c1779j.m10742a(f8130E, m10524k(new h()));
        c1779j.m10742a(f8131F, m10524k(new g()));
        c1779j.m10742a(f8132G, m10524k(new g()));
        c1779j.m10742a(f8133H, m10524k(new g()));
        c1779j.m10742a(f8134I, m10524k(new k()));
        c1779j.m10742a(f8135J, m10524k(new f()));
        this.f8154p = floatingActionButton.getRotation();
    }

    /* renamed from: A */
    public void m10492A() {
        C10427h c10427h = this.f8140b;
        if (c10427h != null) {
            C10428i.m64044f(this.f8161w, c10427h);
        }
        if (mo6577J()) {
            this.f8161w.getViewTreeObserver().addOnPreDrawListener(m10529q());
        }
    }

    /* renamed from: B */
    public void mo6574B() {
        throw null;
    }

    /* renamed from: C */
    public void m10493C() {
        ViewTreeObserver viewTreeObserver = this.f8161w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f8138C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f8138C = null;
        }
    }

    /* renamed from: D */
    public void mo6575D(int[] iArr) {
        throw null;
    }

    /* renamed from: E */
    public void mo6576E(float f10, float f11, float f12) {
        throw null;
    }

    /* renamed from: F */
    public void m10494F(Rect rect) {
        C9373h.m58746g(this.f8143e, "Didn't initialize content background");
        if (!mo6579Y()) {
            this.f8162x.setBackgroundDrawable(this.f8143e);
        } else {
            this.f8162x.setBackgroundDrawable(new InsetDrawable(this.f8143e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    /* renamed from: G */
    public void m10495G() {
        float rotation = this.f8161w.getRotation();
        if (this.f8154p != rotation) {
            this.f8154p = rotation;
            mo6580c0();
        }
    }

    /* renamed from: H */
    public void m10496H() {
        ArrayList<i> arrayList = this.f8160v;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo10487b();
            }
        }
    }

    /* renamed from: I */
    public void m10497I() {
        ArrayList<i> arrayList = this.f8160v;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo10486a();
            }
        }
    }

    /* renamed from: J */
    public boolean mo6577J() {
        throw null;
    }

    /* renamed from: K */
    public void m10498K(ColorStateList colorStateList) {
        C10427h c10427h = this.f8140b;
        if (c10427h != null) {
            c10427h.setTintList(colorStateList);
        }
        C1105c c1105c = this.f8142d;
        if (c1105c != null) {
            c1105c.m6570c(colorStateList);
        }
    }

    /* renamed from: L */
    public void m10499L(PorterDuff.Mode mode) {
        C10427h c10427h = this.f8140b;
        if (c10427h != null) {
            c10427h.setTintMode(mode);
        }
    }

    /* renamed from: M */
    public final void m10500M(float f10) {
        if (this.f8146h != f10) {
            this.f8146h = f10;
            mo6576E(f10, this.f8147i, this.f8148j);
        }
    }

    /* renamed from: N */
    public void m10501N(boolean z10) {
        this.f8144f = z10;
    }

    /* renamed from: O */
    public final void m10502O(C13117h c13117h) {
        this.f8153o = c13117h;
    }

    /* renamed from: P */
    public final void m10503P(float f10) {
        if (this.f8147i != f10) {
            this.f8147i = f10;
            mo6576E(this.f8146h, f10, this.f8148j);
        }
    }

    /* renamed from: Q */
    public final void m10504Q(float f10) {
        this.f8155q = f10;
        Matrix matrix = this.f8137B;
        m10521h(f10, matrix);
        this.f8161w.setImageMatrix(matrix);
    }

    /* renamed from: R */
    public final void m10505R(int i10) {
        if (this.f8156r != i10) {
            this.f8156r = i10;
            m10514d0();
        }
    }

    /* renamed from: S */
    public void m10506S(int i10) {
        this.f8149k = i10;
    }

    /* renamed from: T */
    public final void m10507T(float f10) {
        if (this.f8148j != f10) {
            this.f8148j = f10;
            mo6576E(this.f8146h, this.f8147i, f10);
        }
    }

    /* renamed from: U */
    public void mo6578U(ColorStateList colorStateList) {
        Drawable drawable = this.f8141c;
        if (drawable != null) {
            C13669a.m82228i(drawable, C9876b.m61325d(colorStateList));
        }
    }

    /* renamed from: V */
    public void m10508V(boolean z10) {
        this.f8145g = z10;
        m10516e0();
    }

    /* renamed from: W */
    public final void m10509W(C10432m c10432m) {
        this.f8139a = c10432m;
        C10427h c10427h = this.f8140b;
        if (c10427h != null) {
            c10427h.setShapeAppearanceModel(c10432m);
        }
        Object obj = this.f8141c;
        if (obj instanceof InterfaceC10435p) {
            ((InterfaceC10435p) obj).setShapeAppearanceModel(c10432m);
        }
        C1105c c1105c = this.f8142d;
        if (c1105c != null) {
            c1105c.m6573f(c10432m);
        }
    }

    /* renamed from: X */
    public final void m10510X(C13117h c13117h) {
        this.f8152n = c13117h;
    }

    /* renamed from: Y */
    public boolean mo6579Y() {
        throw null;
    }

    /* renamed from: Z */
    public final boolean m10511Z() {
        return C9603h0.m59864T(this.f8161w) && !this.f8161w.isInEditMode();
    }

    /* renamed from: a0 */
    public final boolean m10512a0() {
        return !this.f8144f || this.f8161w.getSizeDimension() >= this.f8149k;
    }

    /* renamed from: b0 */
    public void m10513b0(j jVar, boolean z10) {
        if (m10535y()) {
            return;
        }
        Animator animator = this.f8151m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = this.f8152n == null;
        if (!m10511Z()) {
            this.f8161w.m10567b(0, z10);
            this.f8161w.setAlpha(1.0f);
            this.f8161w.setScaleY(1.0f);
            this.f8161w.setScaleX(1.0f);
            m10504Q(1.0f);
            if (jVar != null) {
                jVar.mo10482a();
                return;
            }
            return;
        }
        if (this.f8161w.getVisibility() != 0) {
            this.f8161w.setAlpha(0.0f);
            this.f8161w.setScaleY(z11 ? 0.4f : 0.0f);
            this.f8161w.setScaleX(z11 ? 0.4f : 0.0f);
            m10504Q(z11 ? 0.4f : 0.0f);
        }
        C13117h c13117h = this.f8152n;
        AnimatorSet animatorSetM10522i = c13117h != null ? m10522i(c13117h, 1.0f, 1.0f, 1.0f) : m10523j(1.0f, 1.0f, 1.0f);
        animatorSetM10522i.addListener(new b(z10, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f8158t;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetM10522i.addListener(it.next());
            }
        }
        animatorSetM10522i.start();
    }

    /* renamed from: c0 */
    public void mo6580c0() {
        throw null;
    }

    /* renamed from: d0 */
    public final void m10514d0() {
        m10504Q(this.f8155q);
    }

    /* renamed from: e */
    public void m10515e(Animator.AnimatorListener animatorListener) {
        if (this.f8159u == null) {
            this.f8159u = new ArrayList<>();
        }
        this.f8159u.add(animatorListener);
    }

    /* renamed from: e0 */
    public final void m10516e0() {
        Rect rect = this.f8163y;
        mo6585r(rect);
        m10494F(rect);
        this.f8162x.mo10484a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: f */
    public void m10517f(Animator.AnimatorListener animatorListener) {
        if (this.f8158t == null) {
            this.f8158t = new ArrayList<>();
        }
        this.f8158t.add(animatorListener);
    }

    /* renamed from: f0 */
    public void m10518f0(float f10) {
        C10427h c10427h = this.f8140b;
        if (c10427h != null) {
            c10427h.m64001a0(f10);
        }
    }

    /* renamed from: g */
    public void m10519g(i iVar) {
        if (this.f8160v == null) {
            this.f8160v = new ArrayList<>();
        }
        this.f8160v.add(iVar);
    }

    /* renamed from: g0 */
    public final void m10520g0(ObjectAnimator objectAnimator) {
    }

    /* renamed from: h */
    public final void m10521h(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f8161w.getDrawable() == null || this.f8156r == 0) {
            return;
        }
        RectF rectF = this.f8164z;
        RectF rectF2 = this.f8136A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f8156r;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f8156r;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    /* renamed from: i */
    public final AnimatorSet m10522i(C13117h c13117h, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f8161w, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        c13117h.m78903h("opacity").m78911a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f8161w, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        c13117h.m78903h("scale").m78911a(objectAnimatorOfFloat2);
        m10520g0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f8161w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        c13117h.m78903h("scale").m78911a(objectAnimatorOfFloat3);
        m10520g0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        m10521h(f12, this.f8137B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f8161w, new C13115f(), new c(), new Matrix(this.f8137B));
        c13117h.m78903h("iconScale").m78911a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        C13111b.m78887a(animatorSet, arrayList);
        return animatorSet;
    }

    /* renamed from: j */
    public final AnimatorSet m10523j(float f10, float f11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(this.f8161w.getAlpha(), f10, this.f8161w.getScaleX(), f11, this.f8161w.getScaleY(), this.f8155q, f12, new Matrix(this.f8137B)));
        arrayList.add(valueAnimatorOfFloat);
        C13111b.m78887a(animatorSet, arrayList);
        animatorSet.setDuration(C8997a.m56855d(this.f8161w.getContext(), R$attr.motionDurationLong1, this.f8161w.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(C8997a.m56856e(this.f8161w.getContext(), R$attr.motionEasingStandard, C13110a.f59598b));
        return animatorSet;
    }

    /* renamed from: k */
    public final ValueAnimator m10524k(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f8129D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* renamed from: l */
    public final Drawable m10525l() {
        return this.f8143e;
    }

    /* renamed from: m */
    public float mo6584m() {
        throw null;
    }

    /* renamed from: n */
    public boolean m10526n() {
        return this.f8144f;
    }

    /* renamed from: o */
    public final C13117h m10527o() {
        return this.f8153o;
    }

    /* renamed from: p */
    public float m10528p() {
        return this.f8147i;
    }

    /* renamed from: q */
    public final ViewTreeObserver.OnPreDrawListener m10529q() {
        if (this.f8138C == null) {
            this.f8138C = new e();
        }
        return this.f8138C;
    }

    /* renamed from: r */
    public void mo6585r(Rect rect) {
        int sizeDimension = this.f8144f ? (this.f8149k - this.f8161w.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.f8145g ? mo6584m() + this.f8148j : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    /* renamed from: s */
    public float m10530s() {
        return this.f8148j;
    }

    /* renamed from: t */
    public final C10432m m10531t() {
        return this.f8139a;
    }

    /* renamed from: u */
    public final C13117h m10532u() {
        return this.f8152n;
    }

    /* renamed from: v */
    public void m10533v(j jVar, boolean z10) {
        if (m10534x()) {
            return;
        }
        Animator animator = this.f8151m;
        if (animator != null) {
            animator.cancel();
        }
        if (!m10511Z()) {
            this.f8161w.m10567b(z10 ? 8 : 4, z10);
            if (jVar != null) {
                jVar.mo10483b();
                return;
            }
            return;
        }
        C13117h c13117h = this.f8153o;
        AnimatorSet animatorSetM10522i = c13117h != null ? m10522i(c13117h, 0.0f, 0.0f, 0.0f) : m10523j(0.0f, 0.4f, 0.4f);
        animatorSetM10522i.addListener(new a(z10, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f8159u;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetM10522i.addListener(it.next());
            }
        }
        animatorSetM10522i.start();
    }

    /* renamed from: w */
    public void mo6586w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        throw null;
    }

    /* renamed from: x */
    public boolean m10534x() {
        return this.f8161w.getVisibility() == 0 ? this.f8157s == 1 : this.f8157s != 2;
    }

    /* renamed from: y */
    public boolean m10535y() {
        return this.f8161w.getVisibility() != 0 ? this.f8157s == 2 : this.f8157s != 1;
    }

    /* renamed from: z */
    public void mo6587z() {
        throw null;
    }
}
