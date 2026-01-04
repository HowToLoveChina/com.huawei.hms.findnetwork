package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class UserData implements IMessageEntity {

    @Packed
    private String account;

    @Packed
    private String displayName;

    @Packed
    private int gender;

    @Packed
    private String imageURL;

    @Packed
    private String region;

    @Packed
    private String signature;

    @Packed
    private long userId;

    public String getAccount() {
        return this.account;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getGender() {
        return this.gender;
    }

    public String getImageUrl() {
        return this.imageURL;
    }

    public String getRegion() {
        return this.region;
    }

    public String getSignature() {
        return this.signature;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setGender(int i10) {
        this.gender = i10;
    }

    public void setImageUrl(String str) {
        this.imageURL = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUserId(long j10) {
        this.userId = j10;
    }
}
