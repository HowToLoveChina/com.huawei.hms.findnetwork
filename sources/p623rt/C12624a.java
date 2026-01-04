package p623rt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p623rt.InterfaceC12625b;
import tt.C13069b;
import tt.C13070c;

/* renamed from: rt.a */
/* loaded from: classes5.dex */
public class C12624a<T extends InterfaceC12625b> {

    /* renamed from: a */
    public final double f58060a;

    /* renamed from: b */
    public final int f58061b;

    /* renamed from: c */
    public final InterfaceC12626c f58062c;

    public C12624a(double d10, int i10) throws C13069b {
        this(d10, i10, new C13070c());
    }

    /* renamed from: a */
    public final double m76141a(InterfaceC12625b interfaceC12625b, InterfaceC12625b interfaceC12625b2) {
        return this.f58062c.mo76146a(interfaceC12625b.mo68729a(), interfaceC12625b2.mo68729a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final List<T> m76142b(List<T> list, Map<InterfaceC12625b, Integer> map, List<T> list2, T t10, List<T> list3) {
        list2.add(t10);
        map.put(t10, 0);
        ArrayList arrayList = new ArrayList(list3);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            InterfaceC12625b interfaceC12625b = arrayList.get(i10);
            if (!map.containsKey(interfaceC12625b)) {
                List<T> listM76143c = m76143c(interfaceC12625b, list);
                if (listM76143c.size() >= this.f58061b) {
                    m76144d(arrayList, listM76143c);
                }
            }
            if (!map.containsKey(interfaceC12625b) || map.get(interfaceC12625b).intValue() != 0) {
                map.put(interfaceC12625b, 0);
                list2.add(interfaceC12625b);
            }
        }
        return list2;
    }

    /* renamed from: c */
    public final List<T> m76143c(T t10, List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T t11 : list) {
            if (t10 != t11 && m76141a(t11, t10) <= this.f58060a) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public final void m76144d(List<T> list, List<T> list2) {
        HashSet hashSet = new HashSet(list);
        for (T t10 : list2) {
            if (!hashSet.contains(t10)) {
                list.add(t10);
            }
        }
    }

    /* renamed from: e */
    public List<List<T>> m76145e(List<T> list) throws C13069b {
        if (list == null) {
            throw new C13069b();
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (T t10 : list) {
            if (!map.containsKey(t10)) {
                List<T> listM76143c = m76143c(t10, list);
                if (listM76143c.size() >= this.f58061b) {
                    arrayList.add(m76142b(list, map, new ArrayList(), t10, listM76143c));
                } else {
                    map.put(t10, 0);
                }
            }
        }
        return arrayList;
    }

    public C12624a(double d10, int i10, InterfaceC12626c interfaceC12626c) throws C13069b {
        if (d10 < 0.0d) {
            throw new C13069b("DBSCANClusterer %f", Double.valueOf(d10));
        }
        if (i10 < 0) {
            throw new C13069b("DBSCANClusterer %d", Integer.valueOf(i10));
        }
        this.f58060a = d10;
        this.f58061b = i10;
        this.f58062c = interfaceC12626c;
    }
}
