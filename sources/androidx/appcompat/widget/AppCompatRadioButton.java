package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
import p211d.C8968a;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton {

    /* renamed from: a */
    public final C0522e f1911a;

    /* renamed from: b */
    public final C0518c f1912b;

    /* renamed from: c */
    public final C0540o f1913c;

    /* renamed from: d */
    public C0528h f1914d;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f1914d == null) {
            this.f1914d = new C0528h(this);
        }
        return this.f1914d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1913c;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0522e c0522e = this.f1911a;
        return c0522e != null ? c0522e.m2937b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0522e c0522e = this.f1911a;
        if (c0522e != null) {
            return c0522e.m2938c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0522e c0522e = this.f1911a;
        if (c0522e != null) {
            return c0522e.m2939d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1913c.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1913c.m3082k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0522e c0522e = this.f1911a;
        if (c0522e != null) {
            c0522e.m2941f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1913c;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1913c;
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
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1912b;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0522e c0522e = this.f1911a;
        if (c0522e != null) {
            c0522e.m2942g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0522e c0522e = this.f1911a;
        if (c0522e != null) {
            c0522e.m2943h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1913c.m3094w(colorStateList);
        this.f1913c.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1913c.m3095x(mode);
        this.f1913c.m3074b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0522e c0522e = new C0522e(this);
        this.f1911a = c0522e;
        c0522e.m2940e(attributeSet, i10);
        C0518c c0518c = new C0518c(this);
        this.f1912b = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1913c = c0540o;
        c0540o.m3084m(attributeSet, i10);
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C8968a.m56743b(getContext(), i10));
    }
}
