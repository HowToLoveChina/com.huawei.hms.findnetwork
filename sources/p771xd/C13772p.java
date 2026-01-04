package p771xd;

import java.util.ArrayList;
import p514o9.C11839m;

/* renamed from: xd.p */
/* loaded from: classes3.dex */
public class C13772p {

    /* renamed from: a */
    public ArrayList<Integer> f61873a;

    /* renamed from: b */
    public ArrayList<Integer> f61874b;

    public C13772p(int i10) {
        this.f61873a = new ArrayList<>(i10);
        this.f61874b = new ArrayList<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f61873a.add(0);
            this.f61874b.add(0);
        }
    }

    /* renamed from: a */
    public void m82683a() {
        for (int i10 = 0; i10 < this.f61873a.size(); i10++) {
            this.f61873a.set(i10, 0);
            this.f61874b.set(i10, 0);
        }
    }

    /* renamed from: b */
    public ArrayList<Integer> m82684b() {
        return this.f61873a;
    }

    /* renamed from: c */
    public ArrayList<Integer> m82685c() {
        return this.f61874b;
    }

    /* renamed from: d */
    public boolean m82686d(C13772p c13772p) {
        if (c13772p == null) {
            C11839m.m70687e("StorageBarLevel", "isDataEqual storageBarLevel is null");
            return false;
        }
        ArrayList<Integer> arrayListM82684b = c13772p.m82684b();
        if (arrayListM82684b == null || arrayListM82684b.size() != this.f61873a.size()) {
            C11839m.m70687e("StorageBarLevel", "isDataEqual Array do not match rule");
            return false;
        }
        for (int i10 = 0; i10 < this.f61873a.size(); i10++) {
            if (arrayListM82684b.get(i10) == null) {
                C11839m.m70687e("StorageBarLevel", "isDataEqual Array get null");
                return false;
            }
            if (!this.f61873a.get(i10).equals(arrayListM82684b.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public void m82687e(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.size() != this.f61873a.size() || arrayList2.size() != this.f61874b.size() || arrayList.size() != arrayList2.size()) {
            C11839m.m70687e("StorageBarLevel", "ArrayList size do not match");
            return;
        }
        for (int i10 = 0; i10 < this.f61873a.size() && arrayList.get(i10) != null && arrayList2.get(i10) != null; i10++) {
            this.f61873a.set(i10, arrayList.get(i10));
            this.f61874b.set(i10, arrayList2.get(i10));
        }
    }

    /* renamed from: f */
    public void m82688f(C13772p c13772p) {
        if (c13772p == null || c13772p.m82684b() == null || c13772p.m82685c() == null) {
            C11839m.m70687e("StorageBarLevel", "setLevel, parameter is null");
        } else {
            m82687e(c13772p.m82684b(), c13772p.m82685c());
        }
    }
}
