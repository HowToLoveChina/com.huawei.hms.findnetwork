package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import java.util.List;

/* loaded from: classes6.dex */
public class BackupOptionSize {
    private String appId;
    private long empirical;
    private long increase;
    private long max;
    private List<String> mediaPath;
    private int switchState;

    public String getAppId() {
        return this.appId;
    }

    public long getEmpirical() {
        return this.empirical;
    }

    public long getIncrease() {
        return this.increase;
    }

    public long getMax() {
        return this.max;
    }

    public List<String> getMediaPath() {
        return this.mediaPath;
    }

    public int getSwitchState() {
        return this.switchState;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setEmpirical(long j10) {
        this.empirical = j10;
    }

    public void setIncrease(long j10) {
        this.increase = j10;
    }

    public void setMax(long j10) {
        this.max = j10;
    }

    public void setMediaPath(List<String> list) {
        this.mediaPath = list;
    }

    public void setSwitchState(int i10) {
        this.switchState = i10;
    }
}
