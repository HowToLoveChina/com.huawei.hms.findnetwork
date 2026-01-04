package p027b3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.InterfaceC1761b;
import java.util.ArrayList;
import java.util.List;
import p243e0.C9373h;
import p666u2.C13110a;
import p666u2.C13111b;
import p666u2.C13117h;

/* renamed from: b3.b */
/* loaded from: classes.dex */
public abstract class AbstractC1104b implements InterfaceC1761b {

    /* renamed from: a */
    public final Context f5236a;

    /* renamed from: b */
    public final ExtendedFloatingActionButton f5237b;

    /* renamed from: c */
    public final ArrayList<Animator.AnimatorListener> f5238c = new ArrayList<>();

    /* renamed from: d */
    public final C1103a f5239d;

    /* renamed from: e */
    public C13117h f5240e;

    /* renamed from: f */
    public C13117h f5241f;

    /* renamed from: b3.b$a */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(C13110a.m78884a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.f8082G.getColorForState(extendedFloatingActionButton.getDrawableState(), AbstractC1104b.this.f5237b.f8082G.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f10) {
            int colorForState = extendedFloatingActionButton.f8082G.getColorForState(extendedFloatingActionButton.getDrawableState(), AbstractC1104b.this.f5237b.f8082G.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (C13110a.m78884a(0.0f, Color.alpha(colorForState) / 255.0f, f10.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f10.floatValue() == 1.0f) {
                extendedFloatingActionButton.m10430B(extendedFloatingActionButton.f8082G);
            } else {
                extendedFloatingActionButton.m10430B(colorStateListValueOf);
            }
        }
    }

    public AbstractC1104b(ExtendedFloatingActionButton extendedFloatingActionButton, C1103a c1103a) {
        this.f5237b = extendedFloatingActionButton;
        this.f5236a = extendedFloatingActionButton.getContext();
        this.f5239d = c1103a;
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: a */
    public void mo6558a() {
        this.f5239d.m6555b();
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: d */
    public C13117h mo6559d() {
        return this.f5241f;
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: f */
    public void mo6560f() {
        this.f5239d.m6555b();
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: g */
    public final void mo6561g(C13117h c13117h) {
        this.f5241f = c13117h;
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: h */
    public AnimatorSet mo6562h() {
        return m6564l(m6565m());
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    /* renamed from: i */
    public final List<Animator.AnimatorListener> mo6563i() {
        return this.f5238c;
    }

    /* renamed from: l */
    public AnimatorSet m6564l(C13117h c13117h) {
        ArrayList arrayList = new ArrayList();
        if (c13117h.m78905j("opacity")) {
            arrayList.add(c13117h.m78901f("opacity", this.f5237b, View.ALPHA));
        }
        if (c13117h.m78905j("scale")) {
            arrayList.add(c13117h.m78901f("scale", this.f5237b, View.SCALE_Y));
            arrayList.add(c13117h.m78901f("scale", this.f5237b, View.SCALE_X));
        }
        if (c13117h.m78905j("width")) {
            arrayList.add(c13117h.m78901f("width", this.f5237b, ExtendedFloatingActionButton.f8072I));
        }
        if (c13117h.m78905j("height")) {
            arrayList.add(c13117h.m78901f("height", this.f5237b, ExtendedFloatingActionButton.f8073J));
        }
        if (c13117h.m78905j("paddingStart")) {
            arrayList.add(c13117h.m78901f("paddingStart", this.f5237b, ExtendedFloatingActionButton.f8074K));
        }
        if (c13117h.m78905j("paddingEnd")) {
            arrayList.add(c13117h.m78901f("paddingEnd", this.f5237b, ExtendedFloatingActionButton.f8075L));
        }
        if (c13117h.m78905j("labelOpacity")) {
            arrayList.add(c13117h.m78901f("labelOpacity", this.f5237b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        C13111b.m78887a(animatorSet, arrayList);
        return animatorSet;
    }

    /* renamed from: m */
    public final C13117h m6565m() {
        C13117h c13117h = this.f5241f;
        if (c13117h != null) {
            return c13117h;
        }
        if (this.f5240e == null) {
            this.f5240e = C13117h.m78898d(this.f5236a, mo10451b());
        }
        return (C13117h) C9373h.m58745f(this.f5240e);
    }

    @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
    public void onAnimationStart(Animator animator) {
        this.f5239d.m6556c(animator);
    }
}
