package p417k4;

import java.util.Arrays;

/* renamed from: k4.b */
/* loaded from: classes.dex */
public final class C10983b {

    /* renamed from: b */
    public static final C10983b f52043b = new C10983b(0);

    /* renamed from: c */
    public static final C10983b f52044c = new C10983b(1);

    /* renamed from: d */
    public static final C10983b f52045d = new C10983b(2);

    /* renamed from: e */
    public static final C10983b f52046e = new C10983b(3);

    /* renamed from: f */
    public static final C10983b f52047f = new C10983b(4);

    /* renamed from: a */
    public final int f52048a;

    public C10983b(int i10) {
        this.f52048a = i10;
    }

    /* renamed from: a */
    public final int m66349a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C10983b.class == obj.getClass() && this.f52048a == ((C10983b) obj).f52048a;
    }

    public int hashCode() {
        return m66349a(Integer.valueOf(this.f52048a));
    }
}
