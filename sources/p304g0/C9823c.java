package p304g0;

import android.view.accessibility.AccessibilityManager;

/* renamed from: g0.c */
/* loaded from: classes.dex */
public final class C9823c {

    /* renamed from: g0.c$a */
    public static class a {
        /* renamed from: a */
        public static boolean m61032a(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new c(bVar));
        }

        /* renamed from: b */
        public static boolean m61033b(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new c(bVar));
        }
    }

    /* renamed from: g0.c$b */
    public interface b {
        void onTouchExplorationStateChanged(boolean z10);
    }

    /* renamed from: g0.c$c */
    public static final class c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a */
        public final b f48270a;

        public c(b bVar) {
            this.f48270a = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f48270a.equals(((c) obj).f48270a);
            }
            return false;
        }

        public int hashCode() {
            return this.f48270a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z10) {
            this.f48270a.onTouchExplorationStateChanged(z10);
        }
    }

    /* renamed from: a */
    public static boolean m61030a(AccessibilityManager accessibilityManager, b bVar) {
        return a.m61032a(accessibilityManager, bVar);
    }

    /* renamed from: b */
    public static boolean m61031b(AccessibilityManager accessibilityManager, b bVar) {
        return a.m61033b(accessibilityManager, bVar);
    }
}
