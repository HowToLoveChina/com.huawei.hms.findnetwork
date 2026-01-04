package p480n0;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.C0697n;

/* renamed from: n0.b */
/* loaded from: classes.dex */
public final class C11582b extends Editable.Factory {

    /* renamed from: a */
    public static final Object f53740a = new Object();

    /* renamed from: b */
    public static volatile Editable.Factory f53741b;

    /* renamed from: c */
    public static Class<?> f53742c;

    @SuppressLint({"PrivateApi"})
    public C11582b() {
        try {
            f53742c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C11582b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f53741b == null) {
            synchronized (f53740a) {
                try {
                    if (f53741b == null) {
                        f53741b = new C11582b();
                    }
                } finally {
                }
            }
        }
        return f53741b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f53742c;
        return cls != null ? C0697n.m4307c(cls, charSequence) : super.newEditable(charSequence);
    }
}
