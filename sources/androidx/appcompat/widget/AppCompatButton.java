package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;
import androidx.core.widget.C0669j;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: a */
    public final C0518c f1884a;

    /* renamed from: b */
    public final C0540o f1885b;

    /* renamed from: c */
    public C0528h f1886c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f1886c == null) {
            this.f1886c = new C0528h(this);
        }
        return this.f1886c;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (C0535k0.f2369b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            return c0540o.m3076e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (C0535k0.f2369b) {
            return super.getAutoSizeMinTextSize();
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            return c0540o.m3077f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (C0535k0.f2369b) {
            return super.getAutoSizeStepGranularity();
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            return c0540o.m3078g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (C0535k0.f2369b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0540o c0540o = this.f1885b;
        return c0540o != null ? c0540o.m3079h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (C0535k0.f2369b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            return c0540o.m3080i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return C0669j.m4082p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1885b.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1885b.m3082k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3086o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        C0540o c0540o = this.f1885b;
        if (c0540o == null || C0535k0.f2369b || !c0540o.m3083l()) {
            return;
        }
        this.f1885b.m3075c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (C0535k0.f2369b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3091t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (C0535k0.f2369b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3092u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (C0535k0.f2369b) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3093v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0669j.m4083q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().m2998e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m2994a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3090s(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1884a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1885b.m3094w(colorStateList);
        this.f1885b.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1885b.m3095x(mode);
        this.f1885b.m3074b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3088q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (C0535k0.f2369b) {
            super.setTextSize(i10, f10);
            return;
        }
        C0540o c0540o = this.f1885b;
        if (c0540o != null) {
            c0540o.m3070A(i10, f10);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.f1884a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1885b = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0540o.m3074b();
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
    }
}
