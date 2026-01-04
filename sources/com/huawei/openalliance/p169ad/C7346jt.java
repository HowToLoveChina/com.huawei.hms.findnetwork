package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.jt */
/* loaded from: classes8.dex */
public class C7346jt implements InterfaceC7368ko {
    @Override // com.huawei.openalliance.p169ad.InterfaceC7368ko
    /* renamed from: a */
    public void mo45412a(final Object obj) {
        if (obj == null) {
            return;
        }
        final String name = Thread.currentThread().getName();
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jt.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43821b("HiAdResponseDataLogger", "upper thread name: %s response data: %s ", name, AbstractC7758be.m47750c(obj));
            }
        });
    }
}
