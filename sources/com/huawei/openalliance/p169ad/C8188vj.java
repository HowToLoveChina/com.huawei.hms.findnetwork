package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z;

/* renamed from: com.huawei.openalliance.ad.vj */
/* loaded from: classes8.dex */
public class C8188vj implements InterfaceC8133z {

    /* renamed from: a */
    private final InterfaceC8118k f38416a;

    public C8188vj(InterfaceC8118k interfaceC8118k) {
        this.f38416a = interfaceC8118k;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
    /* renamed from: a */
    public void mo38700a() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.vj.1
            @Override // java.lang.Runnable
            public void run() {
                C8188vj.this.f38416a.mo49491c(true);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
    /* renamed from: a */
    public void mo38701a(final int i10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.vj.2
            @Override // java.lang.Runnable
            public void run() {
                if (i10 == 100) {
                    C8188vj.this.f38416a.mo49491c(false);
                }
            }
        });
    }
}
