package p273f0;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;
import p243e0.C9368c;

/* renamed from: f0.l */
/* loaded from: classes.dex */
public final class C9610l {

    /* renamed from: a */
    public final DisplayCutout f47721a;

    /* renamed from: f0.l$a */
    public static class a {
        /* renamed from: a */
        public static DisplayCutout m60079a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        /* renamed from: b */
        public static List<Rect> m60080b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        /* renamed from: c */
        public static int m60081c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        /* renamed from: d */
        public static int m60082d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        /* renamed from: e */
        public static int m60083e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        /* renamed from: f */
        public static int m60084f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C9610l(DisplayCutout displayCutout) {
        this.f47721a = displayCutout;
    }

    /* renamed from: e */
    public static C9610l m60074e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C9610l(displayCutout);
    }

    /* renamed from: a */
    public int m60075a() {
        return a.m60081c(this.f47721a);
    }

    /* renamed from: b */
    public int m60076b() {
        return a.m60082d(this.f47721a);
    }

    /* renamed from: c */
    public int m60077c() {
        return a.m60083e(this.f47721a);
    }

    /* renamed from: d */
    public int m60078d() {
        return a.m60084f(this.f47721a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C9610l.class != obj.getClass()) {
            return false;
        }
        return C9368c.m58729a(this.f47721a, ((C9610l) obj).f47721a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f47721a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f47721a + "}";
    }
}
