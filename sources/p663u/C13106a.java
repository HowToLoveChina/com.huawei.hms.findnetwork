package p663u;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p243e0.C9371f;
import p243e0.InterfaceC9370e;
import p438l.C11213g;

/* renamed from: u.a */
/* loaded from: classes.dex */
public final class C13106a<T> {

    /* renamed from: a */
    public final InterfaceC9370e<ArrayList<T>> f59577a = new C9371f(10);

    /* renamed from: b */
    public final C11213g<T, ArrayList<T>> f59578b = new C11213g<>();

    /* renamed from: c */
    public final ArrayList<T> f59579c = new ArrayList<>();

    /* renamed from: d */
    public final HashSet<T> f59580d = new HashSet<>();

    /* renamed from: a */
    public void m78864a(T t10, T t11) {
        if (!this.f59578b.containsKey(t10) || !this.f59578b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListM78869f = this.f59578b.get(t10);
        if (arrayListM78869f == null) {
            arrayListM78869f = m78869f();
            this.f59578b.put(t10, arrayListM78869f);
        }
        arrayListM78869f.add(t11);
    }

    /* renamed from: b */
    public void m78865b(T t10) {
        if (this.f59578b.containsKey(t10)) {
            return;
        }
        this.f59578b.put(t10, null);
    }

    /* renamed from: c */
    public void m78866c() {
        int size = this.f59578b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM67335m = this.f59578b.m67335m(i10);
            if (arrayListM67335m != null) {
                m78874k(arrayListM67335m);
            }
        }
        this.f59578b.clear();
    }

    /* renamed from: d */
    public boolean m78867d(T t10) {
        return this.f59578b.containsKey(t10);
    }

    /* renamed from: e */
    public final void m78868e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (hashSet.contains(t10)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t10);
        ArrayList<T> arrayList2 = this.f59578b.get(t10);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                m78868e(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(t10);
        arrayList.add(t10);
    }

    /* renamed from: f */
    public final ArrayList<T> m78869f() {
        ArrayList<T> arrayListMo58738b = this.f59577a.mo58738b();
        return arrayListMo58738b == null ? new ArrayList<>() : arrayListMo58738b;
    }

    /* renamed from: g */
    public List m78870g(T t10) {
        return this.f59578b.get(t10);
    }

    /* renamed from: h */
    public List<T> m78871h(T t10) {
        int size = this.f59578b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM67335m = this.f59578b.m67335m(i10);
            if (arrayListM67335m != null && arrayListM67335m.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f59578b.m67331i(i10));
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    public ArrayList<T> m78872i() {
        this.f59579c.clear();
        this.f59580d.clear();
        int size = this.f59578b.size();
        for (int i10 = 0; i10 < size; i10++) {
            m78868e(this.f59578b.m67331i(i10), this.f59579c, this.f59580d);
        }
        return this.f59579c;
    }

    /* renamed from: j */
    public boolean m78873j(T t10) {
        int size = this.f59578b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM67335m = this.f59578b.m67335m(i10);
            if (arrayListM67335m != null && arrayListM67335m.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public final void m78874k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f59577a.mo58737a(arrayList);
    }
}
