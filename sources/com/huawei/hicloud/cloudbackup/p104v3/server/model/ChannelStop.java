package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class ChannelStop extends C11707b {

    /* renamed from: id */
    @InterfaceC4648p
    private String f22587id;

    public String getId() {
        return this.f22587id;
    }

    public ChannelStop setId(String str) {
        this.f22587id = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ChannelStop set(String str, Object obj) {
        return (ChannelStop) super.set(str, obj);
    }
}
