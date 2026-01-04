package p367ig;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* renamed from: ig.e */
/* loaded from: classes4.dex */
public class C10500e extends PasswordTransformationMethod {
    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new C10498c(charSequence);
    }
}
