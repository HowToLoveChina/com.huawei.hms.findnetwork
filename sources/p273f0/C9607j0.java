package p273f0;

import android.content.Context;
import android.view.ViewConfiguration;

/* renamed from: f0.j0 */
/* loaded from: classes.dex */
public final class C9607j0 {

    /* renamed from: f0.j0$a */
    public static class a {
        /* renamed from: a */
        public static float m60065a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        /* renamed from: b */
        public static float m60066b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* renamed from: f0.j0$b */
    public static class b {
        /* renamed from: a */
        public static int m60067a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        /* renamed from: b */
        public static boolean m60068b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* renamed from: a */
    public static float m60062a(ViewConfiguration viewConfiguration, Context context) {
        return a.m60065a(viewConfiguration);
    }

    /* renamed from: b */
    public static float m60063b(ViewConfiguration viewConfiguration, Context context) {
        return a.m60066b(viewConfiguration);
    }

    /* renamed from: c */
    public static boolean m60064c(ViewConfiguration viewConfiguration, Context context) {
        return b.m60068b(viewConfiguration);
    }
}
