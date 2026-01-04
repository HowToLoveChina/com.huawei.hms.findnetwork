package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Objects;

/* loaded from: classes2.dex */
public class BackupModuleInfo {
    String appId;

    public BackupModuleInfo(String str) {
        this.appId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.appId, ((BackupModuleInfo) obj).appId);
    }

    public String getAppId() {
        return this.appId;
    }

    public int hashCode() {
        return Objects.hash(this.appId);
    }

    public String toString() {
        return "[appId:" + this.appId + "]";
    }
}
