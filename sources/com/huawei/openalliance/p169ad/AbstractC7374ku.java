package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.ku */
/* loaded from: classes8.dex */
public abstract class AbstractC7374ku<R> implements InterfaceC7382lb<R> {

    /* renamed from: a */
    private long f34297a;

    @Override // com.huawei.openalliance.p169ad.InterfaceC7382lb
    /* renamed from: a */
    public long mo45459a() {
        return this.f34297a;
    }

    /* renamed from: a */
    public abstract R mo45461a(String str);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7382lb
    /* renamed from: a */
    public R mo45460a(int i10, InputStream inputStream, long j10, InterfaceC7368ko interfaceC7368ko) throws IOException {
        String strM48141a = AbstractC7805cy.m48141a(inputStream);
        this.f34297a = System.currentTimeMillis();
        R rMo45461a = mo45461a(strM48141a);
        if (interfaceC7368ko != null) {
            interfaceC7368ko.mo45412a(rMo45461a);
        }
        return rMo45461a;
    }
}
