package com.huawei.android.remotecontrol.sharing.bean;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class SharingMemberItem {
    public static final int MEMBER_TYPE_FAMILY = 1;
    public static final int MEMBER_TYPE_FRIENDS = 2;
    private String accountName;
    private String aliasName;
    private String iconUrl;
    private boolean isSharingOpen;
    private int memberType;
    private long remainingTime = -1;
    private long shareInterval;
    private long shareStartTime;
    private String userId;

    public SharingMemberItem(String str, String str2, int i10) {
        this.accountName = str;
        this.userId = str2;
        this.memberType = i10;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAliasName() {
        return TextUtils.isEmpty(this.aliasName) ? this.accountName : this.aliasName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public long getShareInterval() {
        return this.shareInterval;
    }

    public long getShareStartTime() {
        return this.shareStartTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isSharingOpen() {
        return this.isSharingOpen;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setMemberType(int i10) {
        this.memberType = i10;
    }

    public void setRemainingTime(long j10) {
        this.remainingTime = j10;
    }

    public void setShareInterval(long j10) {
        this.shareInterval = j10;
    }

    public void setShareStartTime(long j10) {
        this.shareStartTime = j10;
    }

    public void setSharingOpen(boolean z10) {
        this.isSharingOpen = z10;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public SharingMemberItem() {
    }
}
