package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class SPFileHandleInfo {
    private String handleCmd;
    private boolean hasReciviedGiftRight;
    private long spaceCapacity;
    private float spaceDuration;
    private int spaceTimeUnit;

    public String getHandleCmd() {
        return this.handleCmd;
    }

    public long getSpaceCapacity() {
        return this.spaceCapacity;
    }

    public float getSpaceDuration() {
        return this.spaceDuration;
    }

    public int getSpaceTimeUnit() {
        return this.spaceTimeUnit;
    }

    public boolean isHasReciviedGiftRight() {
        return this.hasReciviedGiftRight;
    }

    public void setHandleCmd(String str) {
        this.handleCmd = str;
    }

    public void setHasReciviedGiftRight(boolean z10) {
        this.hasReciviedGiftRight = z10;
    }

    public void setSpaceCapacity(long j10) {
        this.spaceCapacity = j10;
    }

    public void setSpaceDuration(float f10) {
        this.spaceDuration = f10;
    }

    public void setSpaceTimeUnit(int i10) {
        this.spaceTimeUnit = i10;
    }
}
