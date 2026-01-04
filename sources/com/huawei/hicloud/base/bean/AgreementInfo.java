package com.huawei.hicloud.base.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class AgreementInfo implements Serializable {
    private static final long serialVersionUID = 8269553321878001945L;
    private int agrType;
    private long branchId;
    private String contentTag;
    private String country;
    private boolean isAgree;
    private String language;
    private long latestVersion;
    private boolean needSign;
    private long signTime;
    private long version;

    public AgreementInfo(int i10, String str, String str2, boolean z10) {
        this.agrType = i10;
        this.country = str;
        this.language = str2;
        this.isAgree = z10;
    }

    public int getAgrType() {
        return this.agrType;
    }

    public long getBranchId() {
        return this.branchId;
    }

    public String getContentTag() {
        return this.contentTag;
    }

    public String getCountry() {
        return this.country;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public long getSignTime() {
        return this.signTime;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean isAgree() {
        return this.isAgree;
    }

    public boolean isNeedSign() {
        return this.needSign;
    }

    public void setAgrType(int i10) {
        this.agrType = i10;
    }

    public void setAgree(boolean z10) {
        this.isAgree = z10;
    }

    public void setBranchId(long j10) {
        this.branchId = j10;
    }

    public void setContentTag(String str) {
        this.contentTag = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLatestVersion(long j10) {
        this.latestVersion = j10;
    }

    public void setNeedSign(boolean z10) {
        this.needSign = z10;
    }

    public void setSignTime(long j10) {
        this.signTime = j10;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
