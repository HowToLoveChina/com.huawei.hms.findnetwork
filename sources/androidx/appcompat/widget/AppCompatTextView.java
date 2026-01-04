package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.C0669j;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p211d.C8968a;
import p212d0.C8971c;
import p723w.C13507f;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView {

    /* renamed from: a */
    public final C0518c f1946a;

    /* renamed from: b */
    public final C0540o f1947b;

    /* renamed from: c */
    public final C0539n f1948c;

    /* renamed from: d */
    public C0528h f1949d;

    /* renamed from: e */
    public boolean f1950e;

    /* renamed from: f */
    public InterfaceC0457a f1951f;

    /* renamed from: g */
    public Future<C8971c> f1952g;

    /* renamed from: androidx.appcompat.widget.AppCompatTextView$a */
    public interface InterfaceC0457a {
        /* renamed from: a */
        void mo2664a(int[] iArr, int i10);

        /* renamed from: b */
        int[] mo2665b();

        /* renamed from: c */
        TextClassifier mo2666c();

        /* renamed from: d */
        int mo2667d();

        /* renamed from: e */
        void mo2668e(TextClassifier textClassifier);

        /* renamed from: f */
        void mo2669f(int i10);

        /* renamed from: g */
        void mo2670g(int i10, int i11, int i12, int i13);

        /* renamed from: h */
        int mo2671h();

        /* renamed from: i */
        int mo2672i();

        /* renamed from: j */
        void mo2673j(int i10);

        /* renamed from: k */
        int mo2674k();

        /* renamed from: l */
        void mo2675l(int i10);
    }

    /* renamed from: androidx.appcompat.widget.AppCompatTextView$b */
    public class C0458b implements InterfaceC0457a {
        public C0458b() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: a */
        public void mo2664a(int[] iArr, int i10) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: b */
        public int[] mo2665b() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: c */
        public TextClassifier mo2666c() {
            return AppCompatTextView.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: d */
        public int mo2667d() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: e */
        public void mo2668e(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: g */
        public void mo2670g(int i10, int i11, int i12, int i13) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: h */
        public int mo2671h() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: i */
        public int mo2672i() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: k */
        public int mo2674k() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: l */
        public void mo2675l(int i10) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i10);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatTextView$c */
    public class C0459c extends C0458b {
        public C0459c() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: f */
        public void mo2669f(int i10) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.InterfaceC0457a
        /* renamed from: j */
        public void mo2673j(int i10) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i10);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f1949d == null) {
            this.f1949d = new C0528h(this);
        }
        return this.f1949d;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3074b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (C0535k0.f2369b) {
            return getSuperCaller().mo2667d();
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            return c0540o.m3076e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (C0535k0.f2369b) {
            return getSuperCaller().mo2672i();
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            return c0540o.m3077f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (C0535k0.f2369b) {
            return getSuperCaller().mo2674k();
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            return c0540o.m3078g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (C0535k0.f2369b) {
            return getSuperCaller().mo2665b();
        }
        C0540o c0540o = this.f1947b;
        return c0540o != null ? c0540o.m3079h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (C0535k0.f2369b) {
            return getSuperCaller().mo2671h() == 1 ? 1 : 0;
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            return c0540o.m3080i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return C0669j.m4082p(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return C0669j.m4068b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return C0669j.m4069c(this);
    }

    public InterfaceC0457a getSuperCaller() {
        if (this.f1951f == null) {
            this.f1951f = new C0459c();
        }
        return this.f1951f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1947b.m3081j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1947b.m3082k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m2663q();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().mo2666c();
    }

    public C8971c.a getTextMetricsParamsCompat() {
        return C0669j.m4072f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1947b.m3089r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return C0530i.m3032a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3086o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        m2663q();
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        C0540o c0540o = this.f1947b;
        if (c0540o == null || C0535k0.f2369b || !c0540o.m3083l()) {
            return;
        }
        this.f1947b.m3075c();
    }

    /* renamed from: q */
    public final void m2663q() {
        Future<C8971c> future = this.f1952g;
        if (future != null) {
            try {
                this.f1952g = null;
                C0669j.m4079m(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (C0535k0.f2369b) {
            getSuperCaller().mo2670g(i10, i11, i12, i13);
            return;
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3091t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (C0535k0.f2369b) {
            getSuperCaller().mo2664a(iArr, i10);
            return;
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3092u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (C0535k0.f2369b) {
            getSuperCaller().mo2675l(i10);
            return;
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3093v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0540o c0540o = this.f1947b;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m2994a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i10) {
        getSuperCaller().mo2673j(i10);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i10) {
        getSuperCaller().mo2669f(i10);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10) {
        C0669j.m4078l(this, i10);
    }

    public void setPrecomputedText(C8971c c8971c) {
        C0669j.m4079m(this, c8971c);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1946a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1947b.m3094w(colorStateList);
        this.f1947b.m3074b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1947b.m3095x(mode);
        this.f1947b.m3074b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3088q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().mo2668e(textClassifier);
    }

    public void setTextFuture(Future<C8971c> future) {
        this.f1952g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C8971c.a aVar) {
        C0669j.m4081o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (C0535k0.f2369b) {
            super.setTextSize(i10, f10);
            return;
        }
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3070A(i10, f10);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i10) {
        if (this.f1950e) {
            return;
        }
        Typeface typefaceM81246a = (typeface == null || i10 <= 0) ? null : C13507f.m81246a(getContext(), typeface, i10);
        this.f1950e = true;
        if (typefaceM81246a != null) {
            typeface = typefaceM81246a;
        }
        try {
            super.setTypeface(typeface, i10);
        } finally {
            this.f1950e = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        this.f1950e = false;
        this.f1951f = null;
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.f1946a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0540o c0540o = new C0540o(this);
        this.f1947b = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0540o.m3074b();
        this.f1948c = new C0539n(this);
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i10 != 0 ? C8968a.m56743b(context, i10) : null, i11 != 0 ? C8968a.m56743b(context, i11) : null, i12 != 0 ? C8968a.m56743b(context, i12) : null, i13 != 0 ? C8968a.m56743b(context, i13) : null);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i10 != 0 ? C8968a.m56743b(context, i10) : null, i11 != 0 ? C8968a.m56743b(context, i11) : null, i12 != 0 ? C8968a.m56743b(context, i12) : null, i13 != 0 ? C8968a.m56743b(context, i13) : null);
        C0540o c0540o = this.f1947b;
        if (c0540o != null) {
            c0540o.m3087p();
        }
    }
}
