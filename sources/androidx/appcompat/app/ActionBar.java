package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import p303g.AbstractC9814b;

/* loaded from: classes.dex */
public abstract class ActionBar {

    /* renamed from: androidx.appcompat.app.ActionBar$a */
    public interface InterfaceC0345a {
        /* renamed from: a */
        void m1989a(boolean z10);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.ActionBar$b */
    public static abstract class AbstractC0346b {
        /* renamed from: a */
        public abstract CharSequence m1990a();

        /* renamed from: b */
        public abstract View m1991b();

        /* renamed from: c */
        public abstract Drawable m1992c();

        /* renamed from: d */
        public abstract CharSequence m1993d();

        /* renamed from: e */
        public abstract void m1994e();
    }

    /* renamed from: g */
    public boolean m1974g() {
        return false;
    }

    /* renamed from: h */
    public abstract boolean mo1975h();

    /* renamed from: i */
    public abstract void mo1976i(boolean z10);

    /* renamed from: j */
    public abstract int mo1977j();

    /* renamed from: k */
    public abstract Context mo1978k();

    /* renamed from: l */
    public boolean m1979l() {
        return false;
    }

    /* renamed from: m */
    public abstract void mo1980m(Configuration configuration);

    /* renamed from: n */
    public void m1981n() {
    }

    /* renamed from: o */
    public abstract boolean mo1982o(int i10, KeyEvent keyEvent);

    /* renamed from: p */
    public boolean m1983p(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: q */
    public boolean m1984q() {
        return false;
    }

    /* renamed from: r */
    public abstract void mo1985r(boolean z10);

    /* renamed from: s */
    public abstract void mo1986s(boolean z10);

    /* renamed from: t */
    public abstract void mo1987t(CharSequence charSequence);

    /* renamed from: u */
    public abstract AbstractC9814b mo1988u(AbstractC9814b.a aVar);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f1145a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1145a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f1145a = typedArrayObtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f1145a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f1145a = 0;
            this.f1145a = layoutParams.f1145a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1145a = 0;
        }
    }
}
