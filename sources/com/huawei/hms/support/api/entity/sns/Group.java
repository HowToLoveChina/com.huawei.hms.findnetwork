package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class Group implements IMessageEntity {

    @Packed
    private long groupId;

    @Packed
    private int groupType;

    @Packed
    private String imagePath;

    @Packed
    private long managerUid;

    @Packed
    private String name;

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public long getManagerUid() {
        return this.managerUid;
    }

    public String getName() {
        return this.name;
    }

    public void setGroupId(long j10) {
        this.groupId = j10;
    }

    public void setGroupType(int i10) {
        this.groupType = i10;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setManagerUid(long j10) {
        this.managerUid = j10;
    }

    public void setName(String str) {
        this.name = str;
    }
}
