package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;
import androidx.core.widget.C0669j;
import androidx.core.widget.C0670k;
import p273f0.C9588c;
import p273f0.C9603h0;
import p273f0.InterfaceC9592d0;
import p353i0.C10382a;
import p353i0.C10384c;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements InterfaceC9592d0 {

    /* renamed from: a */
    public final C0518c f1895a;

    /* renamed from: b */
    public final C0540o f1896b;

    /* renamed from: c */
    public final C0539n f1897c;

    /* renamed from: d */
    public final C0670k f1898d;

    /* renamed from: e */
    public final C0526g f1899e;

    /* renamed from: f */
    public C0446a f1900f;

    /* renamed from: androidx.appcompat.widget.AppCompatEditText$a */
    public class C0446a {
        public C0446a() {
        }

        /* renamed from: a */
        public TextClassifier m2628a() {
            return AppCompatEditText.super.getTextClassifier();
        }

        /* renamed from: b */
        public void m2629b(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    private C0446a getSuperCaller() {
        if (this.f1900f == null) {
            this.f1900f = new C0446a();
        }
        return this.f1900f;
    }

    @Override // p273f0.InterfaceC9592d0
    /* renamed from: a */
    public C9588c mo2626a(C9588c c9588c) {
        return this.f1898d.mo4115a(this, c9588c);
    }

    /* renamed from: d */
    public void m2627d(C0526g c0526g) {
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
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1896b;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return C0669j.m4082p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1896b.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1896b.m3082k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().m2628a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrM59838D;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1896b.m3089r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionM3032a = C0530i.m3032a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionM3032a != null && Build.VERSION.SDK_INT <= 30 && (strArrM59838D = C9603h0.m59838D(this)) != null) {
            C10382a.m63832c(editorInfo, strArrM59838D);
            inputConnectionM3032a = C10384c.m63841c(this, inputConnectionM3032a, editorInfo);
        }
        return this.f1899e.m2992d(inputConnectionM3032a, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (C0536l.m3058a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        if (C0536l.m3059b(this, i10)) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1896b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1896b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0669j.m4083q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1899e.m2993e(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1899e.m2989a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1895a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1896b.m3094w(colorStateList);
        this.f1896b.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1896b.m3095x(mode);
        this.f1896b.m3074b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0540o c0540o = this.f1896b;
        if (c0540o != null) {
            c0540o.m3088q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().m2629b(textClassifier);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.f1895a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1896b = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0540o.m3074b();
        this.f1897c = new C0539n(this);
        this.f1898d = new C0670k();
        C0526g c0526g = new C0526g(this);
        this.f1899e = c0526g;
        c0526g.m2991c(attributeSet, i10);
        m2627d(c0526g);
    }
}
