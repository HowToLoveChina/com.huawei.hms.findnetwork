package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public final class ChangesNotifyRequest extends C11707b {

    @InterfaceC4648p
    private String changeContent;

    @InterfaceC4648p
    private String channelId;

    @InterfaceC4648p
    private String resourceState;

    public String getChangeContent() {
        return this.changeContent;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getResourceState() {
        return this.resourceState;
    }

    public ChangesNotifyRequest setChangeContent(String str) {
        this.changeContent = str;
        return this;
    }

    public ChangesNotifyRequest setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public ChangesNotifyRequest setResourceState(String str) {
        this.resourceState = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ChangesNotifyRequest set(String str, Object obj) {
        return (ChangesNotifyRequest) super.set(str, obj);
    }
}
