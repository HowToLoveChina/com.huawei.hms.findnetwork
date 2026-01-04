package na;

import com.huawei.android.hicloud.drive.clouddisk.model.SliceObject;
import java.util.Objects;

/* renamed from: na.f */
/* loaded from: classes3.dex */
public class C11660f {

    /* renamed from: a */
    public long f54088a;

    /* renamed from: b */
    public int f54089b;

    /* renamed from: c */
    public int f54090c;

    /* renamed from: d */
    public int f54091d;

    /* renamed from: e */
    public int f54092e;

    /* renamed from: f */
    public int f54093f;

    /* renamed from: g */
    public boolean f54094g;

    /* renamed from: h */
    public int f54095h;

    /* renamed from: i */
    public int f54096i;

    /* renamed from: j */
    public SliceObject f54097j;

    /* renamed from: k */
    public C11656b f54098k;

    public C11660f(long j10, int i10, int i11) {
        this.f54088a = j10;
        this.f54089b = i10;
        this.f54090c = i11;
    }

    /* renamed from: a */
    public int m69632a() {
        return this.f54092e;
    }

    /* renamed from: b */
    public int m69633b() {
        return this.f54091d;
    }

    /* renamed from: c */
    public int m69634c() {
        return this.f54095h;
    }

    /* renamed from: d */
    public int m69635d() {
        return this.f54090c;
    }

    /* renamed from: e */
    public C11656b m69636e() {
        return this.f54098k;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C11660f)) {
            return false;
        }
        C11660f c11660f = (C11660f) obj;
        return this.f54088a == c11660f.m69638g() && this.f54090c == c11660f.m69635d();
    }

    /* renamed from: f */
    public int m69637f() {
        return this.f54096i;
    }

    /* renamed from: g */
    public long m69638g() {
        return this.f54088a;
    }

    /* renamed from: h */
    public SliceObject m69639h() {
        return this.f54097j;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f54088a), Integer.valueOf(this.f54090c));
    }

    /* renamed from: i */
    public int m69640i() {
        return this.f54089b;
    }

    /* renamed from: j */
    public boolean m69641j() {
        return this.f54094g;
    }

    /* renamed from: k */
    public void m69642k(int i10) {
        this.f54092e = i10;
    }

    /* renamed from: l */
    public void m69643l(int i10) {
        this.f54091d = i10;
    }

    /* renamed from: m */
    public void m69644m(boolean z10) {
        this.f54094g = z10;
    }

    /* renamed from: n */
    public void m69645n(int i10) {
        this.f54095h = i10;
    }

    /* renamed from: o */
    public void m69646o(C11656b c11656b) {
        this.f54098k = c11656b;
    }

    /* renamed from: p */
    public void m69647p(int i10) {
        this.f54096i = i10;
    }

    /* renamed from: q */
    public void m69648q(SliceObject sliceObject) {
        this.f54097j = sliceObject;
    }

    /* renamed from: r */
    public void m69649r(int i10) {
        this.f54093f = i10;
    }

    public String toString() {
        return "position:" + this.f54088a + ",layerSeq:" + this.f54095h + ",number:" + this.f54096i + ",start:" + this.f54089b + ",length:" + this.f54090c;
    }
}
