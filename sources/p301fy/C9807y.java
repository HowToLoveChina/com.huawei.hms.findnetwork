package p301fy;

/* renamed from: fy.y */
/* loaded from: classes9.dex */
public final class C9807y {

    /* renamed from: a */
    public final int[] f48223a;

    /* renamed from: b */
    public final long[] f48224b;

    /* renamed from: c */
    public final int[] f48225c;

    /* renamed from: d */
    public final int[] f48226d;

    public C9807y(int[] iArr, long[] jArr, int[] iArr2, int[] iArr3) {
        this.f48223a = iArr;
        this.f48224b = jArr;
        this.f48225c = iArr2;
        this.f48226d = iArr3;
    }

    public String toString() {
        return "StreamMap with indices of " + this.f48223a.length + " folders, offsets of " + this.f48224b.length + " packed streams, first files of " + this.f48225c.length + " folders and folder indices for " + this.f48226d.length + " files";
    }
}
