package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class Friend extends UserId implements IMessageEntity {

    @Packed
    private String displayName;

    @Packed
    private String imageUrl;

    @Packed
    private String phoneDigest;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPhoneDigest() {
        return this.phoneDigest;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setPhoneDigest(String str) {
        this.phoneDigest = str;
    }
}
