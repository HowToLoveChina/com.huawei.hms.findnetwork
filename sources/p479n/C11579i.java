package p479n;

import java.util.Arrays;
import java.util.HashSet;

/* renamed from: n.i */
/* loaded from: classes.dex */
public class C11579i implements Comparable<C11579i> {

    /* renamed from: r */
    public static int f53697r = 1;

    /* renamed from: a */
    public boolean f53698a;

    /* renamed from: b */
    public String f53699b;

    /* renamed from: f */
    public float f53703f;

    /* renamed from: j */
    public a f53707j;

    /* renamed from: c */
    public int f53700c = -1;

    /* renamed from: d */
    public int f53701d = -1;

    /* renamed from: e */
    public int f53702e = 0;

    /* renamed from: g */
    public boolean f53704g = false;

    /* renamed from: h */
    public float[] f53705h = new float[9];

    /* renamed from: i */
    public float[] f53706i = new float[9];

    /* renamed from: k */
    public C11572b[] f53708k = new C11572b[16];

    /* renamed from: l */
    public int f53709l = 0;

    /* renamed from: m */
    public int f53710m = 0;

    /* renamed from: n */
    public boolean f53711n = false;

    /* renamed from: o */
    public int f53712o = -1;

    /* renamed from: p */
    public float f53713p = 0.0f;

    /* renamed from: q */
    public HashSet<C11572b> f53714q = null;

    /* renamed from: n.i$a */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C11579i(a aVar, String str) {
        this.f53707j = aVar;
    }

    /* renamed from: e */
    public static void m69128e() {
        f53697r++;
    }

    /* renamed from: a */
    public final void m69129a(C11572b c11572b) {
        int i10 = 0;
        while (true) {
            int i11 = this.f53709l;
            if (i10 >= i11) {
                C11572b[] c11572bArr = this.f53708k;
                if (i11 >= c11572bArr.length) {
                    this.f53708k = (C11572b[]) Arrays.copyOf(c11572bArr, c11572bArr.length * 2);
                }
                C11572b[] c11572bArr2 = this.f53708k;
                int i12 = this.f53709l;
                c11572bArr2[i12] = c11572b;
                this.f53709l = i12 + 1;
                return;
            }
            if (this.f53708k[i10] == c11572b) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C11579i c11579i) {
        return this.f53700c - c11579i.f53700c;
    }

    /* renamed from: f */
    public final void m69131f(C11572b c11572b) {
        int i10 = this.f53709l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f53708k[i11] == c11572b) {
                while (i11 < i10 - 1) {
                    C11572b[] c11572bArr = this.f53708k;
                    int i12 = i11 + 1;
                    c11572bArr[i11] = c11572bArr[i12];
                    i11 = i12;
                }
                this.f53709l--;
                return;
            }
            i11++;
        }
    }

    /* renamed from: h */
    public void m69132h() {
        this.f53699b = null;
        this.f53707j = a.UNKNOWN;
        this.f53702e = 0;
        this.f53700c = -1;
        this.f53701d = -1;
        this.f53703f = 0.0f;
        this.f53704g = false;
        this.f53711n = false;
        this.f53712o = -1;
        this.f53713p = 0.0f;
        int i10 = this.f53709l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f53708k[i11] = null;
        }
        this.f53709l = 0;
        this.f53710m = 0;
        this.f53698a = false;
        Arrays.fill(this.f53706i, 0.0f);
    }

    /* renamed from: i */
    public void m69133i(C11574d c11574d, float f10) {
        this.f53703f = f10;
        this.f53704g = true;
        this.f53711n = false;
        this.f53712o = -1;
        this.f53713p = 0.0f;
        int i10 = this.f53709l;
        this.f53701d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f53708k[i11].m69055A(c11574d, this, false);
        }
        this.f53709l = 0;
    }

    /* renamed from: k */
    public void m69134k(a aVar, String str) {
        this.f53707j = aVar;
    }

    /* renamed from: p */
    public final void m69135p(C11574d c11574d, C11572b c11572b) {
        int i10 = this.f53709l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f53708k[i11].mo69056B(c11574d, c11572b, false);
        }
        this.f53709l = 0;
    }

    public String toString() {
        if (this.f53699b != null) {
            return "" + this.f53699b;
        }
        return "" + this.f53700c;
    }
}
