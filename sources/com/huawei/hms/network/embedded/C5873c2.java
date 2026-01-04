package com.huawei.hms.network.embedded;

import org.chromium.net.CronetEngine;

/* renamed from: com.huawei.hms.network.embedded.c2 */
/* loaded from: classes8.dex */
public class C5873c2 {

    /* renamed from: a */
    public CronetEngine f26561a;

    /* renamed from: b */
    public boolean f26562b = false;

    public CronetEngine getCronetEngine() {
        return this.f26561a;
    }

    public boolean isEnableConnectionMigrated() {
        return this.f26562b;
    }

    public void setCronetEngine(CronetEngine cronetEngine) {
        this.f26561a = cronetEngine;
    }

    public void setEnableConnectionMigrated(boolean z10) {
        this.f26562b = z10;
    }
}
