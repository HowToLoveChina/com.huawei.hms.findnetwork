package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class ShareInfo implements Serializable {

    /* renamed from: a */
    private String f33668a;

    /* renamed from: b */
    private String f33669b;

    /* renamed from: c */
    private String f33670c;

    /* renamed from: d */
    private String f33671d;

    @OuterVisible
    public ShareInfo() {
    }

    public ShareInfo(com.huawei.openalliance.p169ad.beans.metadata.ShareInfo shareInfo) {
        if (shareInfo != null) {
            this.f33668a = shareInfo.m40442a();
            this.f33669b = AbstractC7806cz.m48168c(shareInfo.m40444b());
            this.f33670c = AbstractC7806cz.m48168c(shareInfo.m40446c());
            this.f33671d = shareInfo.m40448d();
        }
    }

    @OuterVisible
    public String getDescription() {
        return this.f33670c;
    }

    @OuterVisible
    public String getIconUrl() {
        return this.f33668a;
    }

    @OuterVisible
    public String getShareUrl() {
        return this.f33671d;
    }

    @OuterVisible
    public String getTitle() {
        return this.f33669b;
    }
}
