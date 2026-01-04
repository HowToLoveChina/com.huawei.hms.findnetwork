package com.huawei.hicloud.request.agreement.request;

import gp.C10028c;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class SignInfo {
    public static final String HWCLOUDDRIVE = "hwclouddrive ";
    private short agrType;
    private String country;
    private boolean isAgree;
    private String language;
    private long latestVersion;
    private boolean needSign;
    private long signTime;
    private long version;
    private final String clientVersion = C10028c.m62183d0(C0213f.m1377a()).m62263Q0("agr_sign_local_version", "hwclouddrive 16.0.0.300");
    private final long clientSignTime = C10028c.m62183d0(C0213f.m1377a()).m62247N("agr_sign_time");

    public SignInfo() {
    }

    public short getAgrType() {
        return this.agrType;
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

    public void setAgrType(short s10) {
        this.agrType = s10;
    }

    public void setAgree(boolean z10) {
        this.isAgree = z10;
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

    public SignInfo(short s10, String str, String str2, boolean z10) {
        this.agrType = s10;
        this.country = str;
        this.language = str2;
        this.isAgree = z10;
    }
}
