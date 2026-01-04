package is;

import android.location.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: is.e */
/* loaded from: classes8.dex */
public final class C10608e implements Serializable {

    /* renamed from: a */
    public String f50994a;

    /* renamed from: b */
    public int f50995b;

    /* renamed from: c */
    public long f50996c;

    /* renamed from: d */
    public List<Location> f50997d;

    public C10608e() {
    }

    public C10608e(String str, int i10, long j10, ArrayList arrayList) {
        this.f50994a = str;
        this.f50995b = i10;
        this.f50996c = j10;
        this.f50997d = arrayList;
    }

    /* renamed from: b */
    public final int m65032b() {
        return this.f50995b;
    }

    /* renamed from: c */
    public final String m65033c() {
        return this.f50994a;
    }

    /* renamed from: d */
    public final long m65034d() {
        return this.f50996c;
    }

    /* renamed from: e */
    public final List<Location> m65035e() {
        return this.f50997d;
    }

    /* renamed from: f */
    public final void m65036f(long j10) {
        this.f50996c = j10;
    }

    /* renamed from: g */
    public final void m65037g(String str) {
        this.f50994a = str;
    }

    /* renamed from: h */
    public final void m65038h(List<Location> list) {
        List<Location> list2 = this.f50997d;
        if (list2 == null) {
            this.f50997d = list;
        } else {
            list2.addAll(list);
        }
    }
}
