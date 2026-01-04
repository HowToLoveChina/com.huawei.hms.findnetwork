package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.ReportFragment;
import p024b0.C1085a;
import p273f0.C9616o;
import p438l.C11213g;

/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements InterfaceC0796l, C9616o.a {

    /* renamed from: a */
    public C11213g<Class<Object>, Object> f3293a = new C11213g<>();

    /* renamed from: b */
    public C0797m f3294b = new C0797m(this);

    /* renamed from: C */
    public static boolean m3777C(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        str.hashCode();
        switch (str) {
            case "--translation":
                return Build.VERSION.SDK_INT >= 31;
            case "--dump-dumpable":
            case "--list-dumpables":
                return C1085a.m6463c();
            case "--contentcapture":
            case "--autofill":
                return true;
            default:
                return false;
        }
    }

    /* renamed from: B */
    public final boolean m3778B(String[] strArr) {
        return !m3777C(strArr);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C9616o.m60120a(decorView, keyEvent)) {
            return C9616o.m60121b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C9616o.m60120a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        return this.f3294b;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.m4903f(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f3294b.m4964j(AbstractC0791h.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // p273f0.C9616o.a
    /* renamed from: s */
    public boolean mo2216s(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
