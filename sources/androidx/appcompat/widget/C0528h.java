package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import p480n0.C11586f;

/* renamed from: androidx.appcompat.widget.h */
/* loaded from: classes.dex */
public class C0528h {

    /* renamed from: a */
    public final TextView f2334a;

    /* renamed from: b */
    public final C11586f f2335b;

    public C0528h(TextView textView) {
        this.f2334a = textView;
        this.f2335b = new C11586f(textView, false);
    }

    /* renamed from: a */
    public InputFilter[] m2994a(InputFilter[] inputFilterArr) {
        return this.f2335b.m69157a(inputFilterArr);
    }

    /* renamed from: b */
    public boolean m2995b() {
        return this.f2335b.m69158b();
    }

    /* renamed from: c */
    public void m2996c(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f2334a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m2998e(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: d */
    public void m2997d(boolean z10) {
        this.f2335b.m69159c(z10);
    }

    /* renamed from: e */
    public void m2998e(boolean z10) {
        this.f2335b.m69160d(z10);
    }

    /* renamed from: f */
    public TransformationMethod m2999f(TransformationMethod transformationMethod) {
        return this.f2335b.m69161e(transformationMethod);
    }
}
