package p301fy;

import java.util.BitSet;

/* renamed from: fy.e */
/* loaded from: classes9.dex */
public final class C9787e {

    /* renamed from: a */
    public long f48123a;

    /* renamed from: c */
    public BitSet f48125c;

    /* renamed from: d */
    public long[] f48126d;

    /* renamed from: f */
    public C9808z f48128f;

    /* renamed from: h */
    public C9807y f48130h;

    /* renamed from: b */
    public long[] f48124b = new long[0];

    /* renamed from: e */
    public C9793k[] f48127e = C9793k.f48144j;

    /* renamed from: g */
    public C9797o[] f48129g = C9797o.f48155s;

    /* renamed from: a */
    public static String m60864a(long[] jArr) {
        return jArr == null ? "(null)" : Integer.toString(jArr.length);
    }

    /* renamed from: b */
    public static String m60865b(Object[] objArr) {
        return objArr == null ? "(null)" : Integer.toString(objArr.length);
    }

    public String toString() {
        return "Archive with packed streams starting at offset " + this.f48123a + ", " + m60864a(this.f48124b) + " pack sizes, " + m60864a(this.f48126d) + " CRCs, " + m60865b(this.f48127e) + " folders, " + m60865b(this.f48129g) + " files and " + this.f48130h;
    }
}
