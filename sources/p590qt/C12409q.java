package p590qt;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import mt.C11518e;
import mt.C11522i;
import p533ot.C12026a;

/* renamed from: qt.q */
/* loaded from: classes5.dex */
public class C12409q {
    /* renamed from: b */
    public static boolean m74518b(List<C11518e> list, List<C11518e> list2) {
        if (list.isEmpty() || list2.isEmpty() || list2.contains(list.get(list.size() - 1))) {
            return false;
        }
        List list3 = (List) list2.stream().map(new Function() { // from class: qt.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12409q.m74522f((C11518e) obj);
            }
        }).collect(Collectors.toList());
        return ((Long) Collections.max(list3)).longValue() - ((Long) Collections.min(list3)).longValue() <= 600000;
    }

    /* renamed from: c */
    public static boolean m74519c(List<C11518e> list, C11522i c11522i) {
        if (list.isEmpty()) {
            return false;
        }
        C11518e c11518e = list.get(list.size() - 1);
        return (((c11518e.m68730j().m68739b() - c11522i.m68774j()) > 1800000L ? 1 : ((c11518e.m68730j().m68739b() - c11522i.m68774j()) == 1800000L ? 0 : -1)) > 0 && (Math.sqrt(C12026a.m72158c(c11518e, c11522i)) > 100.0d ? 1 : (Math.sqrt(C12026a.m72158c(c11518e, c11522i)) == 100.0d ? 0 : -1)) > 0) && ((c11518e.m68731k() > 0.8d ? 1 : (c11518e.m68731k() == 0.8d ? 0 : -1)) > 0 && c11518e.m68734n().m68748h() == 3);
    }

    /* renamed from: d */
    public static boolean m74520d(List<C11518e> list, C11522i c11522i) {
        if (list.size() < 2) {
            return false;
        }
        for (int i10 = 1; i10 <= 2; i10++) {
            if (Math.sqrt(C12026a.m72158c(list.get(list.size() - i10), c11522i)) <= 200.0d) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m74521e(List<C11518e> list, List<C11518e> list2, C11522i c11522i) {
        if (m74519c(list, c11522i)) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Tag is moved due to a high reliable point.");
            return true;
        }
        if (m74520d(list, c11522i)) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Tag is moved due to two high distance point.");
            return true;
        }
        if (!m74518b(list, list2)) {
            return false;
        }
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Tag is moved due to an outlier and filtered infos have short time interval.");
        return true;
    }

    /* renamed from: f */
    public static /* synthetic */ Long m74522f(C11518e c11518e) {
        return Long.valueOf(c11518e.m68730j().m68739b());
    }
}
