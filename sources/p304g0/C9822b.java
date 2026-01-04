package p304g0;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: g0.b */
/* loaded from: classes.dex */
public final class C9822b {

    /* renamed from: g0.b$a */
    public static class a {
        /* renamed from: a */
        public static int m61028a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        /* renamed from: b */
        public static void m61029b(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    /* renamed from: a */
    public static int m61026a(AccessibilityEvent accessibilityEvent) {
        return a.m61028a(accessibilityEvent);
    }

    /* renamed from: b */
    public static void m61027b(AccessibilityEvent accessibilityEvent, int i10) {
        a.m61029b(accessibilityEvent, i10);
    }
}
