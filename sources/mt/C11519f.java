package mt;

import java.util.Objects;

/* renamed from: mt.f */
/* loaded from: classes5.dex */
public class C11519f {

    /* renamed from: a */
    public String f53441a;

    /* renamed from: b */
    public String f53442b;

    /* renamed from: c */
    public long f53443c;

    /* renamed from: d */
    public int f53444d;

    public C11519f(String str, String str2, long j10, int i10) {
        this.f53441a = str;
        this.f53442b = str2;
        this.f53443c = j10;
        this.f53444d = i10;
    }

    /* renamed from: a */
    public int m68738a() {
        return this.f53444d;
    }

    /* renamed from: b */
    public long m68739b() {
        return this.f53443c;
    }

    /* renamed from: c */
    public void m68740c(int i10) {
        this.f53444d = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11519f)) {
            return false;
        }
        C11519f c11519f = (C11519f) obj;
        boolean[] zArr = new boolean[2];
        zArr[0] = this.f53443c == c11519f.f53443c && this.f53444d == c11519f.f53444d;
        boolean z10 = Objects.equals(this.f53441a, c11519f.f53441a) && Objects.equals(this.f53442b, c11519f.f53442b);
        zArr[1] = z10;
        return zArr[0] && z10;
    }

    public int hashCode() {
        return Objects.hash(this.f53441a, this.f53442b, Long.valueOf(this.f53443c), Integer.valueOf(this.f53444d));
    }

    public String toString() {
        return "BlueToothRecord{name='" + this.f53441a + "', mac='" + this.f53442b + "', timeStamp=" + this.f53443c + ", rssi=" + this.f53444d + '}';
    }

    public C11519f(long j10, int i10) {
        this("null", "null", j10, i10);
    }
}
