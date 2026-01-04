package cr;

import android.os.SystemClock;
import android.telephony.CellInfo;
import as.C1016d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: cr.a */
/* loaded from: classes8.dex */
public final class C8944a {

    /* renamed from: c */
    public static boolean f45443c;

    /* renamed from: a */
    public final long f45444a;

    /* renamed from: b */
    public final CellInfo f45445b;

    static {
        C1016d.m6186f("CellWrapper", "nano time delay:" + (SystemClock.elapsedRealtimeNanos() - System.nanoTime()));
        f45443c = true;
    }

    public C8944a(CellInfo cellInfo, long j10) {
        this.f45445b = cellInfo;
        this.f45444a = j10;
    }

    /* renamed from: c */
    public static LinkedList m56664c(List list) {
        long j10;
        if (!f45443c || list.isEmpty()) {
            j10 = 0;
        } else {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long jNanoTime = System.nanoTime();
            j10 = jElapsedRealtimeNanos - jNanoTime;
            if (j10 > 100000000000L) {
                C1016d.m6181a("CellWrapper", "detect nano");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((CellInfo) it.next()).getTimeStamp() > jNanoTime) {
                        C1016d.m6186f("CellWrapper", "close nano detect");
                        f45443c = false;
                        break;
                    }
                }
                if (f45443c) {
                    C1016d.m6181a("CellWrapper", "use nano. diff:" + j10);
                }
            } else {
                C1016d.m6181a("CellWrapper", "not detect nano. diff:" + j10);
            }
            j10 = 0;
        }
        LinkedList linkedList = new LinkedList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            linkedList.add(new C8944a((CellInfo) it2.next(), j10));
        }
        return linkedList;
    }

    /* renamed from: a */
    public final CellInfo m56665a() {
        return this.f45445b;
    }

    /* renamed from: b */
    public final long m56666b() {
        return this.f45445b.getTimeStamp() + this.f45444a;
    }
}
