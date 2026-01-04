package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class ServiceInfo implements IMessageEntity {

    @Packed
    private String packageName;

    @Packed
    private String sceneName;

    @Packed
    private int status;

    public String getPackageName() {
        return this.packageName;
    }

    public String getSceneName() {
        return this.sceneName;
    }

    public int getStatus() {
        return this.status;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSceneName(String str) {
        this.sceneName = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
