package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {

    /* renamed from: a */
    public final C0518c f1955a;

    /* renamed from: b */
    public final C0540o f1956b;

    /* renamed from: c */
    public C0528h f1957c;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f1957c == null) {
            this.f1957c = new C0528h(this);
        }
        return this.f1957c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1956b;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1956b.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1956b.m3082k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1956b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1956b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().m2998e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m2994a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1955a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1956b.m3094w(colorStateList);
        this.f1956b.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1956b.m3095x(mode);
        this.f1956b.m3074b();
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.f1955a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1956b = c0540o;
        c0540o.m3084m(attributeSet, i10);
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
    }
}
