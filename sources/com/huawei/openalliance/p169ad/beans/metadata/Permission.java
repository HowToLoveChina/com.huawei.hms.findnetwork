package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class Permission {
    private String groupDesc;
    private String permissionLabel;

    /* renamed from: a */
    public String m40384a() {
        return this.permissionLabel;
    }

    /* renamed from: b */
    public String m40386b() {
        return this.groupDesc;
    }

    /* renamed from: a */
    public void m40385a(String str) {
        this.permissionLabel = str;
    }

    /* renamed from: b */
    public void m40387b(String str) {
        this.groupDesc = str;
    }
}
