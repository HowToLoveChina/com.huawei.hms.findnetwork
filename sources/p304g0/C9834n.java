package p304g0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: g0.n */
/* loaded from: classes.dex */
public class C9834n {

    /* renamed from: g0.n$a */
    public static class a {
        /* renamed from: a */
        public static int m61138a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        /* renamed from: b */
        public static int m61139b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        /* renamed from: c */
        public static void m61140c(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollX(i10);
        }

        /* renamed from: d */
        public static void m61141d(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollY(i10);
        }
    }

    /* renamed from: g0.n$b */
    public static class b {
        /* renamed from: a */
        public static void m61142a(AccessibilityRecord accessibilityRecord, View view, int i10) {
            accessibilityRecord.setSource(view, i10);
        }
    }

    /* renamed from: a */
    public static void m61135a(AccessibilityRecord accessibilityRecord, int i10) {
        a.m61140c(accessibilityRecord, i10);
    }

    /* renamed from: b */
    public static void m61136b(AccessibilityRecord accessibilityRecord, int i10) {
        a.m61141d(accessibilityRecord, i10);
    }

    /* renamed from: c */
    public static void m61137c(AccessibilityRecord accessibilityRecord, View view, int i10) {
        b.m61142a(accessibilityRecord, view, i10);
    }
}
