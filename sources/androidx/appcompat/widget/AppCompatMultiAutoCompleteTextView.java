package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import p211d.C8968a;

/* loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView {

    /* renamed from: d */
    public static final int[] f1905d = {R.attr.popupBackground};

    /* renamed from: a */
    public final C0518c f1906a;

    /* renamed from: b */
    public final C0540o f1907b;

    /* renamed from: c */
    public final C0526g f1908c;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m2630a(C0526g c0526g) {
        KeyListener keyListener = getKeyListener();
        if (c0526g.m2990b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerM2989a = c0526g.m2989a(keyListener);
            if (keyListenerM2989a == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerM2989a);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1907b;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1907b.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1907b.m3082k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1908c.m2992d(C0530i.m3032a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1907b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1907b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(C8968a.m56743b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1908c.m2993e(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1908c.m2989a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1906a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1907b.m3094w(colorStateList);
        this.f1907b.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1907b.m3095x(mode);
        this.f1907b.m3074b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0540o c0540o = this.f1907b;
        if (c0540o != null) {
            c0540o.m3088q(context, i10);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0523e0 c0523e0M2946v = C0523e0.m2946v(getContext(), attributeSet, f1905d, i10, 0);
        if (c0523e0M2946v.m2965s(0)) {
            setDropDownBackgroundDrawable(c0523e0M2946v.m2953g(0));
        }
        c0523e0M2946v.m2966w();
        C0518c c0518c = new C0518c(this);
        this.f1906a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1907b = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0540o.m3074b();
        C0526g c0526g = new C0526g(this);
        this.f1908c = c0526g;
        c0526g.m2991c(attributeSet, i10);
        m2630a(c0526g);
    }
}
