package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import androidx.core.widget.C0669j;
import p211d.C8968a;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a */
    public final C0520d f1891a;

    /* renamed from: b */
    public final C0518c f1892b;

    /* renamed from: c */
    public final C0540o f1893c;

    /* renamed from: d */
    public C0528h f1894d;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f1894d == null) {
            this.f1894d = new C0528h(this);
        }
        return this.f1894d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0540o c0540o = this.f1893c;
        if (c0540o != null) {
            c0540o.m3074b();
        }
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            c0520d.m2929a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return C0669j.m4082p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            return c0520d.m2930b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            return c0520d.m2931c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1893c.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1893c.m3082k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0530i.m3032a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            c0520d.m2933e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1893c;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1893c;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0669j.m4083q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().m2998e(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1892b;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            c0520d.m2934f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0520d c0520d = this.f1891a;
        if (c0520d != null) {
            c0520d.m2935g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1893c.m3094w(colorStateList);
        this.f1893c.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1893c.m3095x(mode);
        this.f1893c.m3074b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0540o c0540o = this.f1893c;
        if (c0540o != null) {
            c0540o.m3088q(context, i10);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0540o c0540o = new C0540o(this);
        this.f1893c = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0540o.m3074b();
        C0518c c0518c = new C0518c(this);
        this.f1892b = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0520d c0520d = new C0520d(this);
        this.f1891a = c0520d;
        c0520d.m2932d(attributeSet, i10);
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(C8968a.m56743b(getContext(), i10));
    }
}
