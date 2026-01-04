package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.NetworkService;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.network.ai.h0 */
/* loaded from: classes8.dex */
public class C5801h0 {

    /* renamed from: a */
    public boolean f25883a;

    /* renamed from: b */
    public C5797f0 f25884b;

    /* renamed from: c */
    public C5799g0 f25885c;

    /* renamed from: com.huawei.hms.network.ai.h0$b */
    public static class b {

        /* renamed from: a */
        public static final C5801h0 f25886a = new C5801h0();
    }

    public C5801h0() {
        boolean z10 = false;
        this.f25883a = false;
        this.f25885c = new C5799g0();
        if (AIPolicyService.isAiEnable() && StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue(NetworkService.Constants.AI_IPSORT_SWITCH)), false)) {
            z10 = true;
        }
        this.f25883a = z10;
        if (z10) {
            this.f25884b = new C5797f0(this.f25885c);
        }
    }

    /* renamed from: b */
    public static C5801h0 m33347b() {
        return b.f25886a;
    }

    /* renamed from: a */
    public int m33348a(InetAddress inetAddress, InetAddress inetAddress2) {
        if (this.f25883a) {
            return this.f25884b.m33329a(inetAddress, inetAddress2);
        }
        return -1;
    }

    public /* synthetic */ C5801h0(a aVar) {
        this();
    }

    /* renamed from: a */
    public List<List<InetAddress>> m33349a(List<List<InetAddress>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<InetAddress>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m33351b(it.next()));
        }
        return arrayList;
    }

    /* renamed from: b */
    public List<InetAddress> m33351b(List<InetAddress> list) {
        return (!this.f25883a || list == null || list.isEmpty()) ? list : this.f25884b.m33332c(list);
    }

    /* renamed from: a */
    public void m33350a() {
        C5792d.m33287c().m33292a(C5788b.f25734d, this.f25885c);
        if (this.f25883a) {
            C5800h.m33340d().m33344a(C5788b.f25734d, this.f25884b);
        }
    }
}
