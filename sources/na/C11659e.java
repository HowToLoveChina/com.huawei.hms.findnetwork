package na;

import com.huawei.android.hicloud.drive.clouddisk.model.SliceObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: na.e */
/* loaded from: classes3.dex */
public class C11659e {

    /* renamed from: a */
    public int f54081a;

    /* renamed from: b */
    public List<SliceObject> f54082b;

    /* renamed from: c */
    public long f54083c;

    /* renamed from: d */
    public int f54084d;

    /* renamed from: e */
    public Map<String, C11656b> f54085e;

    /* renamed from: f */
    public List<C11656b> f54086f;

    /* renamed from: g */
    public List<C11660f> f54087g;

    public C11659e(List<SliceObject> list, int i10, long j10, int i11) {
        this.f54082b = list;
        this.f54081a = i10;
        this.f54083c = j10;
        this.f54084d = i11;
        list.sort(new Comparator() { // from class: na.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11659e.m69623j((SliceObject) obj, (SliceObject) obj2);
            }
        });
        this.f54087g = new ArrayList();
        this.f54085e = new HashMap();
        this.f54086f = new ArrayList();
    }

    /* renamed from: i */
    public static /* synthetic */ int m69622i(C11660f c11660f, C11660f c11660f2) {
        return (int) (c11660f.m69638g() - c11660f2.m69638g());
    }

    /* renamed from: j */
    public static /* synthetic */ int m69623j(SliceObject sliceObject, SliceObject sliceObject2) {
        return sliceObject.getNumber().intValue() - sliceObject2.getNumber().intValue();
    }

    /* renamed from: c */
    public void m69624c() {
        this.f54087g.sort(new Comparator() { // from class: na.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11659e.m69622i((C11660f) obj, (C11660f) obj2);
            }
        });
        for (C11660f c11660f : this.f54087g) {
            String id2 = c11660f.m69639h().getId();
            int iIntValue = c11660f.m69639h().getLength().intValue();
            if (c11660f.m69641j()) {
                c11660f.m69643l(0);
                c11660f.m69649r(c11660f.m69640i());
                c11660f.m69642k(Math.min((int) m69625d(c11660f.m69640i() + c11660f.m69635d() + 32), iIntValue));
            } else {
                c11660f.m69643l((int) m69626e(c11660f.m69640i()));
                int iM69640i = (c11660f.m69640i() / 16) * 16;
                int iM69640i2 = (((c11660f.m69640i() + c11660f.m69635d()) / 16) * 16) + 16;
                c11660f.m69649r(c11660f.m69640i() - iM69640i);
                c11660f.m69642k(Math.min((iM69640i2 - iM69640i) + 48, iIntValue));
            }
            if (this.f54085e.containsKey(id2)) {
                this.f54085e.get(id2).m69608a(c11660f);
                c11660f.m69646o(this.f54085e.get(id2));
            } else {
                C11656b c11656b = new C11656b(c11660f.m69639h(), c11660f.m69637f());
                c11656b.m69618k(c11660f.m69637f() * this.f54081a);
                c11656b.m69617j(c11660f.m69634c());
                c11656b.m69608a(c11660f);
                this.f54085e.put(id2, c11656b);
                this.f54086f.add(c11656b);
                c11660f.m69646o(c11656b);
            }
        }
    }

    /* renamed from: d */
    public final long m69625d(long j10) {
        return ((j10 / 16) * 16) + 16;
    }

    /* renamed from: e */
    public final long m69626e(long j10) {
        return ((j10 / 16) * 16) - 16;
    }

    /* renamed from: f */
    public int m69627f() {
        return this.f54084d;
    }

    /* renamed from: g */
    public List<C11656b> m69628g() {
        return this.f54086f;
    }

    /* renamed from: h */
    public int m69629h() {
        return this.f54081a;
    }

    /* renamed from: k */
    public void m69630k(long j10, int i10) {
        int i11 = this.f54081a;
        int i12 = (int) (j10 / i11);
        long j11 = i12;
        long j12 = j10 - (i11 * j11);
        if (i10 + j12 <= i11) {
            C11660f c11660f = new C11660f(j10, (int) j12, i10);
            c11660f.m69648q(this.f54082b.get(i12));
            c11660f.m69645n(this.f54084d);
            c11660f.m69647p(i12);
            if (j12 <= 16) {
                c11660f.m69644m(true);
            } else {
                c11660f.m69644m(false);
            }
            this.f54087g.add(c11660f);
            return;
        }
        int i13 = (int) j12;
        C11660f c11660f2 = new C11660f(j10, i13, i11 - i13);
        c11660f2.m69647p(i12);
        c11660f2.m69644m(true);
        c11660f2.m69648q(this.f54082b.get(i12));
        c11660f2.m69645n(this.f54084d);
        this.f54087g.add(c11660f2);
        int i14 = this.f54081a;
        C11660f c11660f3 = new C11660f((j11 + 1) * i14, 0, i10 - (i14 - i13));
        int i15 = i12 + 1;
        c11660f3.m69647p(i15);
        c11660f3.m69644m(true);
        c11660f3.m69648q(this.f54082b.get(i15));
        c11660f3.m69645n(this.f54084d);
        this.f54087g.add(c11660f3);
    }

    /* renamed from: l */
    public List<C11660f> m69631l(long j10, int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.f54087g.size(); i11++) {
            C11660f c11660f = this.f54087g.get(i11);
            if (c11660f.m69638g() < j10 && c11660f.m69638g() + c11660f.m69635d() > j10) {
                arrayList.add(this.f54087g.get(i11));
            }
            if (c11660f.m69638g() >= j10 && c11660f.m69638g() < i10 + j10) {
                arrayList.add(this.f54087g.get(i11));
            }
        }
        return arrayList;
    }
}
