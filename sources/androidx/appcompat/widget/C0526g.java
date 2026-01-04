package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import p480n0.C11581a;

/* renamed from: androidx.appcompat.widget.g */
/* loaded from: classes.dex */
public class C0526g {

    /* renamed from: a */
    public final EditText f2331a;

    /* renamed from: b */
    public final C11581a f2332b;

    public C0526g(EditText editText) {
        this.f2331a = editText;
        this.f2332b = new C11581a(editText, false);
    }

    /* renamed from: a */
    public KeyListener m2989a(KeyListener keyListener) {
        return m2990b(keyListener) ? this.f2332b.m69144a(keyListener) : keyListener;
    }

    /* renamed from: b */
    public boolean m2990b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* renamed from: c */
    public void m2991c(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f2331a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m2993e(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: d */
    public InputConnection m2992d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f2332b.m69145b(inputConnection, editorInfo);
    }

    /* renamed from: e */
    public void m2993e(boolean z10) {
        this.f2332b.m69146c(z10);
    }
}
