package p723w;

import android.graphics.Insets;
import android.graphics.Rect;

/* renamed from: w.c */
/* loaded from: classes.dex */
public final class C13504c {

    /* renamed from: e */
    public static final C13504c f60769e = new C13504c(0, 0, 0, 0);

    /* renamed from: a */
    public final int f60770a;

    /* renamed from: b */
    public final int f60771b;

    /* renamed from: c */
    public final int f60772c;

    /* renamed from: d */
    public final int f60773d;

    /* renamed from: w.c$a */
    public static class a {
        /* renamed from: a */
        public static Insets m81232a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public C13504c(int i10, int i11, int i12, int i13) {
        this.f60770a = i10;
        this.f60771b = i11;
        this.f60772c = i12;
        this.f60773d = i13;
    }

    /* renamed from: a */
    public static C13504c m81227a(C13504c c13504c, C13504c c13504c2) {
        return m81228b(Math.max(c13504c.f60770a, c13504c2.f60770a), Math.max(c13504c.f60771b, c13504c2.f60771b), Math.max(c13504c.f60772c, c13504c2.f60772c), Math.max(c13504c.f60773d, c13504c2.f60773d));
    }

    /* renamed from: b */
    public static C13504c m81228b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f60769e : new C13504c(i10, i11, i12, i13);
    }

    /* renamed from: c */
    public static C13504c m81229c(Rect rect) {
        return m81228b(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: d */
    public static C13504c m81230d(Insets insets) {
        return m81228b(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* renamed from: e */
    public Insets m81231e() {
        return a.m81232a(this.f60770a, this.f60771b, this.f60772c, this.f60773d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C13504c.class != obj.getClass()) {
            return false;
        }
        C13504c c13504c = (C13504c) obj;
        return this.f60773d == c13504c.f60773d && this.f60770a == c13504c.f60770a && this.f60772c == c13504c.f60772c && this.f60771b == c13504c.f60771b;
    }

    public int hashCode() {
        return (((((this.f60770a * 31) + this.f60771b) * 31) + this.f60772c) * 31) + this.f60773d;
    }

    public String toString() {
        return "Insets{left=" + this.f60770a + ", top=" + this.f60771b + ", right=" + this.f60772c + ", bottom=" + this.f60773d + '}';
    }
}
