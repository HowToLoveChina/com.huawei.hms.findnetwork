package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GroupMem extends UserId implements IMessageEntity {

    @Packed
    private String displayName;

    @Packed
    private String imagePath;

    @Packed
    private String joinTime;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getJoinTime() {
        return this.joinTime;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setJoinTime(String str) {
        this.joinTime = str;
    }
}
