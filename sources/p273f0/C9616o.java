package p273f0;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* renamed from: f0.o */
/* loaded from: classes.dex */
public class C9616o {

    /* renamed from: f0.o$a */
    public interface a {
        /* renamed from: s */
        boolean mo2216s(KeyEvent keyEvent);
    }

    /* renamed from: a */
    public static boolean m60120a(View view, KeyEvent keyEvent) {
        return C9603h0.m59887i(view, keyEvent);
    }

    @SuppressLint({"LambdaLast"})
    /* renamed from: b */
    public static boolean m60121b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return aVar.mo2216s(keyEvent);
    }
}
