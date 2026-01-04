package p273f0;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* renamed from: f0.r0 */
/* loaded from: classes.dex */
public final class C9623r0 {

    /* renamed from: f0.r0$a */
    public static class a {
        /* renamed from: a */
        public static void m60137a(Window window, boolean z10) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* renamed from: f0.r0$b */
    public static class b {
        /* renamed from: a */
        public static void m60138a(Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    /* renamed from: a */
    public static C9593d1 m60135a(Window window, View view) {
        return new C9593d1(window, view);
    }

    /* renamed from: b */
    public static void m60136b(Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.m60138a(window, z10);
        } else {
            a.m60137a(window, z10);
        }
    }
}
