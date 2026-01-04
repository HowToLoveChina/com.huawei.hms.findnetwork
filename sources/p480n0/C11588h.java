package p480n0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.C0688e;

/* renamed from: n0.h */
/* loaded from: classes.dex */
public class C11588h implements TransformationMethod {

    /* renamed from: a */
    public final TransformationMethod f53763a;

    public C11588h(TransformationMethod transformationMethod) {
        this.f53763a = transformationMethod;
    }

    /* renamed from: a */
    public TransformationMethod m69180a() {
        return this.f53763a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f53763a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || C0688e.m4221b().m4227d() != 1) ? charSequence : C0688e.m4221b().m4234o(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f53763a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
