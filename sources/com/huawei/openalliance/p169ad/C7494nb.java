package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.nb */
/* loaded from: classes8.dex */
public class C7494nb extends AbstractC7524ns {
    public C7494nb(InterfaceC7146gc interfaceC7146gc, InterfaceC7182hl interfaceC7182hl) {
        super(interfaceC7146gc, interfaceC7182hl);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7524ns
    /* renamed from: a */
    public void mo45920a() {
        long jLongValue = ((Long) AbstractC7810dc.m48269a(new Callable<Long>() { // from class: com.huawei.openalliance.ad.nb.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long call() {
                return Long.valueOf(C7494nb.this.f34952a.mo43341aH());
            }
        }, 300L)).longValue();
        int iIntValue = ((Integer) AbstractC7810dc.m48269a(new Callable<Integer>() { // from class: com.huawei.openalliance.ad.nb.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(C7494nb.this.f34952a.mo43339aF());
            }
        }, 2000)).intValue();
        m46205b(jLongValue);
        m46203a(iIntValue);
    }
}
