package p301fy;

import java.util.Objects;

/* renamed from: fy.w */
/* loaded from: classes9.dex */
public class C9805w {

    /* renamed from: a */
    public final EnumC9804v f48218a;

    /* renamed from: b */
    public final Object f48219b;

    public C9805w(EnumC9804v enumC9804v, Object obj) {
        this.f48218a = enumC9804v;
        this.f48219b = obj;
        if (obj == null || C9791i.m60868b(enumC9804v).m60863d(obj)) {
            return;
        }
        throw new IllegalArgumentException("The " + enumC9804v + " method doesn't support options of type " + obj.getClass());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C9805w c9805w = (C9805w) obj;
        return Objects.equals(this.f48218a, c9805w.f48218a) && Objects.equals(this.f48219b, c9805w.f48219b);
    }

    public int hashCode() {
        EnumC9804v enumC9804v = this.f48218a;
        if (enumC9804v == null) {
            return 0;
        }
        return enumC9804v.hashCode();
    }
}
