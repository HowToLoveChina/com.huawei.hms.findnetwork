package com.huawei.hms.network.embedded;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.LimitQueue;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import java.util.LinkedHashSet;

/* renamed from: com.huawei.hms.network.embedded.t4 */
/* loaded from: classes8.dex */
public class C6098t4 extends AbstractC6072r4<InterfaceC5876c5, String> {

    /* renamed from: b */
    public static final String f28389b = "NetworkInfoCache";

    /* renamed from: c */
    public static volatile C6098t4 f28390c = new C6098t4();

    /* renamed from: a */
    public LimitQueue<InterfaceC5876c5> f28391a = new LimitQueue<>(8);

    public static C6098t4 getInstance() {
        return f28390c;
    }

    /* renamed from: a */
    public C5862b5 m35408a(long j10) {
        C5862b5 c5862b5 = new C5862b5();
        c5862b5.m33856a(NetworkUtil.getCurrentNetworkType());
        c5862b5.m33858a(NetworkUtil.getNetworkStatus(ContextHolder.getResourceContext()));
        c5862b5.m33857a(j10);
        return c5862b5;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public InterfaceC5876c5 getPeekLastInfo() {
        InterfaceC5876c5 interfaceC5876c5PeekLast = this.f28391a.peekLast();
        if (interfaceC5876c5PeekLast != null) {
            return interfaceC5876c5PeekLast;
        }
        Logger.m32143v(f28389b, "the networkInfoMetrics is null,and return new object");
        return new C5862b5();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public int obtainNetworkQuality(long j10, long j11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (int i10 = 0; i10 < this.f28391a.size(); i10++) {
            InterfaceC5876c5 interfaceC5876c5 = this.f28391a.get(i10);
            if (interfaceC5876c5 != null && j10 <= interfaceC5876c5.mo33859b() && interfaceC5876c5.mo33859b() <= j11) {
                linkedHashSet.add(Integer.valueOf(interfaceC5876c5.mo33860c()));
                linkedHashSet2.add(interfaceC5876c5.mo33855a());
            }
        }
        if (linkedHashSet.isEmpty()) {
            return !linkedHashSet2.isEmpty() ? 2 : 0;
        }
        return 1;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    /* renamed from: a */
    public void updateCacheInfo(String str) {
        C5862b5 c5862b5M35408a = m35408a(SystemClock.elapsedRealtime());
        InterfaceC5876c5 interfaceC5876c5PeekLast = this.f28391a.peekLast();
        if (interfaceC5876c5PeekLast != null && interfaceC5876c5PeekLast.mo33860c() == c5862b5M35408a.mo33860c() && interfaceC5876c5PeekLast.mo33855a() == c5862b5M35408a.mo33855a()) {
            Logger.m32143v(f28389b, "the network change don't meet interval!");
        } else {
            this.f28391a.add(c5862b5M35408a);
        }
    }
}
