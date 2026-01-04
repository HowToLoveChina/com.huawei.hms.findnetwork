package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements InterfaceC0794j {

    /* renamed from: b */
    public static int f1091b;

    /* renamed from: c */
    public static Field f1092c;

    /* renamed from: d */
    public static Field f1093d;

    /* renamed from: e */
    public static Field f1094e;

    /* renamed from: a */
    public Activity f1095a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* renamed from: e */
    public static void m1932e() throws NoSuchFieldException, SecurityException {
        try {
            f1091b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f1093d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f1094e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f1092c = declaredField3;
            declaredField3.setAccessible(true);
            f1091b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (bVar != AbstractC0791h.b.ON_DESTROY) {
            return;
        }
        if (f1091b == 0) {
            m1932e();
        }
        if (f1091b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1095a.getSystemService("input_method");
            try {
                Object obj = f1092c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f1093d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f1094e.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (ClassCastException unused3) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
