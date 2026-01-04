package pt;

import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.ToLongFunction;
import mt.C11518e;
import mt.C11521h;
import p533ot.C12026a;
import p590qt.C12410r;
import p623rt.C12624a;
import p689ut.C13252e;
import tt.C13069b;

/* renamed from: pt.h */
/* loaded from: classes5.dex */
public class C12218h {

    /* renamed from: pt.h$a */
    public enum a {
        FILTER_DYNAMIC,
        FILTER_STATIC
    }

    /* renamed from: e */
    public static /* synthetic */ int m73391e(Integer num, Integer num2) {
        return Integer.compare(num2.intValue(), num.intValue());
    }

    /* renamed from: f */
    public static int m73392f(List<List<C11518e>> list, a aVar) {
        int iM73394h = m73394h(list);
        if (iM73394h >= 0) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "getLatestCluster");
            return iM73394h;
        }
        int iM73397k = m73397k(list);
        if (iM73397k >= 0) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "detected latest cluster and is visited once");
            return iM73397k;
        }
        if (aVar == a.FILTER_DYNAMIC) {
            return m73399m(list);
        }
        return -1;
    }

    /* renamed from: g */
    public static /* synthetic */ int m73393g(C11521h c11521h, C11521h c11521h2) {
        return Long.compare(((C11518e) c11521h2.m68764b()).m68730j().m68739b(), ((C11518e) c11521h.m68764b()).m68730j().m68739b());
    }

    /* renamed from: h */
    public static int m73394h(List<List<C11518e>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(new C11521h(Integer.valueOf(i10), Long.valueOf(m73396j(list.get(i10)))));
        }
        arrayList.sort(new Comparator() { // from class: pt.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12218h.m73395i((C11521h) obj, (C11521h) obj2);
            }
        });
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "cluster timestamp: %s", arrayList));
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            if (((Long) ((C11521h) arrayList.get(0)).m68764b()).longValue() - ((Long) ((C11521h) arrayList.get(size)).m68764b()).longValue() > 1800000) {
                arrayList2.add(((C11521h) arrayList.get(size)).m68763a());
                arrayList.remove(size);
            }
        }
        if (arrayList.size() == 1) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "saved cluster: %d", ((C11521h) arrayList.get(0)).m68763a()));
            return ((Integer) ((C11521h) arrayList.get(0)).m68763a()).intValue();
        }
        arrayList2.sort(new Comparator() { // from class: pt.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12218h.m73391e((Integer) obj, (Integer) obj2);
            }
        });
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "delete cluster: %s", arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            list.remove(((Integer) it.next()).intValue());
        }
        return -1;
    }

    /* renamed from: i */
    public static /* synthetic */ int m73395i(C11521h c11521h, C11521h c11521h2) {
        return Long.compare(((Long) c11521h2.m68764b()).longValue(), ((Long) c11521h.m68764b()).longValue());
    }

    /* renamed from: j */
    public static long m73396j(List<C11518e> list) {
        return list.stream().mapToLong(new ToLongFunction() { // from class: pt.g
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return C12218h.m73400n((C11518e) obj);
            }
        }).max().orElse(0L);
    }

    /* renamed from: k */
    public static int m73397k(List<List<C11518e>> list) {
        int[] iArrM73398l = m73398l(list);
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "Latest points belong to:%s", Arrays.toString(iArrM73398l)));
        int[] iArr = new int[list.size()];
        Arrays.fill(iArr, 0);
        for (int length = iArrM73398l.length - 1; length >= 0; length--) {
            int i10 = iArrM73398l[length];
            if (i10 != -1 && (length == iArrM73398l.length - 1 || i10 != iArrM73398l[length + 1])) {
                iArr[i10] = iArr[i10] + 1;
            }
        }
        int i11 = iArrM73398l[0];
        if (iArr[i11] == 1 && i11 == iArrM73398l[1]) {
            return i11;
        }
        return -1;
    }

    /* renamed from: l */
    public static int[] m73398l(List<List<C11518e>> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Iterator<C11518e> it = list.get(i10).iterator();
            while (it.hasNext()) {
                arrayList.add(new C11521h(Integer.valueOf(i10), it.next()));
            }
        }
        arrayList.sort(new Comparator() { // from class: pt.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12218h.m73393g((C11521h) obj, (C11521h) obj2);
            }
        });
        int[] iArr = new int[arrayList.size()];
        Arrays.fill(iArr, -1);
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                break;
            }
            iArr[i11] = ((Integer) ((C11521h) arrayList.get(i11)).m68763a()).intValue();
            if (i11 == arrayList.size() - 1) {
                break;
            }
            C11518e c11518e = (C11518e) ((C11521h) arrayList.get(i11)).m68764b();
            i11++;
            if (Math.sqrt(C12026a.m72157b(c11518e, (C11518e) ((C11521h) arrayList.get(i11)).m68764b())) > 400.0d) {
                C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "getLatestPointsCluster, only check latest %d points due to moving", Integer.valueOf(i11)));
                break;
            }
            if (((C11518e) ((C11521h) arrayList.get(0)).m68764b()).m68730j().m68739b() - ((C11518e) ((C11521h) arrayList.get(i11)).m68764b()).m68730j().m68739b() > AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL) {
                C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "getLatestPointsCluster, only check latest %d points due to long time", Integer.valueOf(i11)));
                break;
            }
        }
        return iArr;
    }

    /* renamed from: m */
    public static int m73399m(List<List<C11518e>> list) {
        int i10 = -1;
        int size = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11).size() > size) {
                size = list.get(i11).size();
                i10 = i11;
            }
        }
        return i10;
    }

    /* renamed from: n */
    public static /* synthetic */ long m73400n(C11518e c11518e) {
        return c11518e.m68730j().m68739b();
    }

    /* renamed from: o */
    public static void m73401o(List<C11518e> list, a aVar) throws C13069b {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or is empty");
            return;
        }
        double d10 = aVar == a.FILTER_DYNAMIC ? 400.0d : 60.0d;
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Begin cluster stage " + aVar);
        List listM76145e = new C12624a(d10, 1).m76145e(list);
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Cluster size is " + listM76145e.size());
        for (int i10 = 0; i10 < listM76145e.size(); i10++) {
            C13252e.m79642i("Id in cluster " + i10, (List) listM76145e.get(i10));
        }
        if (listM76145e.size() == 1) {
            list.clear();
            list.addAll((Collection) listM76145e.get(0));
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Choose the only one cluster");
            return;
        }
        if (listM76145e.size() <= 1) {
            C11518e.m68727t(list);
            C11518e c11518e = list.get(list.size() - 1);
            list.clear();
            list.add(c11518e);
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Cluster failed, return latest info.");
            return;
        }
        int iM73392f = m73392f(listM76145e, aVar);
        list.clear();
        if (iM73392f < 0) {
            Iterator it = listM76145e.iterator();
            while (it.hasNext()) {
                list.addAll((List) it.next());
            }
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Choosing algorithm failed. Bypass.");
            return;
        }
        list.addAll((Collection) listM76145e.get(iM73392f));
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Choose cluster " + iM73392f);
    }
}
