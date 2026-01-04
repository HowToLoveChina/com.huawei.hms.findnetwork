package com.huawei.location.crowdsourcing;

import android.os.SystemClock;
import as.C1016d;
import br.InterfaceC1273a;
import com.huawei.location.crowdsourcing.Config;
import cr.C8944a;
import es.C9548m;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p234dr.C9298d;
import p234dr.InterfaceC9297c;

/* renamed from: com.huawei.location.crowdsourcing.h */
/* loaded from: classes8.dex */
public final class C6752h implements InterfaceC1273a {

    /* renamed from: a */
    public long f31301a;

    /* renamed from: b */
    public List<C8944a> f31302b = new LinkedList();

    /* renamed from: d */
    public static void m38351d(LinkedList linkedList) {
        final long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        final long jM38296b = Config.C6744b.f31261a.m38296b();
        InterfaceC9297c interfaceC9297c = new InterfaceC9297c() { // from class: com.huawei.location.crowdsourcing.g
            @Override // p234dr.InterfaceC9297c
            /* renamed from: a */
            public final boolean mo38339a(Object obj) {
                return C6752h.m38352e(jElapsedRealtimeNanos, jM38296b, (C8944a) obj);
            }
        };
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (interfaceC9297c.mo38339a(it.next())) {
                it.remove();
            }
        }
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m38352e(long j10, long j11, C8944a c8944a) {
        long jAbs = Math.abs(c8944a.m56666b() - j10);
        if (jAbs <= j11) {
            return false;
        }
        C1016d.m6181a("CellCollector", "remove expired(ns). timeDiff:" + jAbs);
        return true;
    }

    @Override // br.InterfaceC1273a
    /* renamed from: a */
    public final void mo7544a() {
        C1016d.m6190j("CellCollector", "Stop");
    }

    /* renamed from: c */
    public final List<C8944a> m38353c() {
        LinkedList linkedListM56664c;
        Config config = Config.C6744b.f31261a;
        if (!config.m38316v()) {
            C1016d.m6181a("CellCollector", "no need get cell");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.f31301a) < config.m38311q()) {
            C1016d.m6181a("CellCollector", "collect interval check failed");
            return null;
        }
        if (C9548m.m59619b(C6747c.m38332b(), "android.permission.ACCESS_FINE_LOCATION")) {
            linkedListM56664c = C8944a.m56664c(C9298d.m58597b(C6747c.m38332b()));
        } else {
            C1016d.m6183c("CellCollector", "check permission failed");
            linkedListM56664c = new LinkedList();
        }
        m38351d(linkedListM56664c);
        if (linkedListM56664c.isEmpty()) {
            C1016d.m6181a("CellCollector", "no available cell info");
            return null;
        }
        this.f31302b = linkedListM56664c;
        C1016d.m6181a("CellCollector", "cell list size." + linkedListM56664c.size());
        this.f31301a = jCurrentTimeMillis;
        config.m38305k();
        return this.f31302b;
    }
}
