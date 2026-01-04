package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class SplitAppSetting {
    private Integer backup;
    private String bundleName;
    private Integer restore;

    public Integer getBackup() {
        Integer num = this.backup;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public Integer getRestore() {
        Integer num = this.restore;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public void setBackup(Integer num) {
        this.backup = num;
    }

    public void setBundleName(String str) {
        this.bundleName = str;
    }

    public void setRestore(Integer num) {
        this.restore = num;
    }
}
