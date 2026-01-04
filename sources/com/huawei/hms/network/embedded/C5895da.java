package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.da */
/* loaded from: classes8.dex */
public final class C5895da extends IOException {

    /* renamed from: a */
    public final EnumC6077r9 f26668a;

    public C5895da(EnumC6077r9 enumC6077r9) {
        super("stream was reset: " + enumC6077r9);
        this.f26668a = enumC6077r9;
    }
}
