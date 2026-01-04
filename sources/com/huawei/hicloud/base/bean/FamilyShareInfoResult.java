package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class FamilyShareInfoResult extends RetResult {
    private int canSpaceShareEnable;
    private int familyShareEnable;
    private int purchased;
    private int spaceShareEnable;
    private long spaceShareTime;
    private int familyShareRole = 0;
    private int spaceShareRole = 0;
    private long spaceShareOwner = -1;
    private int limitationTip = -1;
    private int shareLimit = -1;

    public int getCanSpaceShareEnable() {
        return this.canSpaceShareEnable;
    }

    public int getFamilyShareEnable() {
        return this.familyShareEnable;
    }

    public int getFamilyShareRole() {
        return this.familyShareRole;
    }

    public int getLimitationTip() {
        return this.limitationTip;
    }

    public int getPurchased() {
        return this.purchased;
    }

    public int getShareLimit() {
        return this.shareLimit;
    }

    public int getSpaceShareEnable() {
        return this.spaceShareEnable;
    }

    public long getSpaceShareOwner() {
        return this.spaceShareOwner;
    }

    public int getSpaceShareRole() {
        return this.spaceShareRole;
    }

    public long getSpaceShareTime() {
        return this.spaceShareTime;
    }

    public void setCanSpaceShareEnable(int i10) {
        this.canSpaceShareEnable = i10;
    }

    public void setFamilyShareEnable(int i10) {
        this.familyShareEnable = i10;
    }

    public void setFamilyShareRole(int i10) {
        this.familyShareRole = i10;
    }

    public void setLimitationTip(int i10) {
        this.limitationTip = i10;
    }

    public void setPurchased(int i10) {
        this.purchased = i10;
    }

    public void setShareLimit(int i10) {
        this.shareLimit = i10;
    }

    public void setSpaceShareEnable(int i10) {
        this.spaceShareEnable = i10;
    }

    public void setSpaceShareOwner(long j10) {
        this.spaceShareOwner = j10;
    }

    public void setSpaceShareRole(int i10) {
        this.spaceShareRole = i10;
    }

    public void setSpaceShareTime(long j10) {
        this.spaceShareTime = j10;
    }

    public String toString() {
        return "FamilyShareInfoResult{familyShareEnable=" + this.familyShareEnable + ", familyShareRole=" + this.familyShareRole + ", spaceShareEnable=" + this.spaceShareEnable + ", spaceShareRole=" + this.spaceShareRole + ", spaceShareOwner=" + this.spaceShareOwner + ", spaceShareTime=" + this.spaceShareTime + ", purchased=" + this.purchased + ", canSpaceShareEnable=" + this.canSpaceShareEnable + '}';
    }
}
