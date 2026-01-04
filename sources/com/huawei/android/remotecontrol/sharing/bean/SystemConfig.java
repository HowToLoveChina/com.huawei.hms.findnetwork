package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class SystemConfig {

    @SerializedName("maxFromFriendNum")
    private String maxFromFriendNum;

    @SerializedName("maxFromShareFriendNum")
    private String maxFromShareFriendNum;

    @SerializedName("maxShareToFriendNum")
    private String maxShareToFriendNum;

    @SerializedName("maxToFriendNum")
    private String maxToFriendNum;

    @SerializedName("perDeviceSummary")
    private ArrayList<PerDeviceSummary> perDeviceSummary;

    @SerializedName("releaseTee")
    private boolean releaseTee;

    @SerializedName("serverTime")
    private long serverTime;

    @SerializedName("teeDeviceTypeWhite")
    private boolean teeDeviceTypeWhite;

    @SerializedName("trackTeeTime")
    private int trackTeeTime;

    public String getMaxFromFriendNum() {
        return this.maxFromFriendNum;
    }

    public String getMaxFromShareFriendNum() {
        return this.maxFromShareFriendNum;
    }

    public String getMaxShareToFriendNum() {
        return this.maxShareToFriendNum;
    }

    public String getMaxToFriendNum() {
        return this.maxToFriendNum;
    }

    public ArrayList<PerDeviceSummary> getPerDeviceSummary() {
        return this.perDeviceSummary;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getTrackTeeTime() {
        return this.trackTeeTime;
    }

    public boolean isReleaseTee() {
        return this.releaseTee;
    }

    public boolean isTeeDeviceTypeWhite() {
        return this.teeDeviceTypeWhite;
    }

    public void setMaxFromFriendNum(String str) {
        this.maxFromFriendNum = str;
    }

    public void setMaxFromShareFriendNum(String str) {
        this.maxFromShareFriendNum = str;
    }

    public void setMaxShareToFriendNum(String str) {
        this.maxShareToFriendNum = str;
    }

    public void setMaxToFriendNum(String str) {
        this.maxToFriendNum = str;
    }

    public void setPerDeviceSummary(ArrayList<PerDeviceSummary> arrayList) {
        this.perDeviceSummary = arrayList;
    }

    public void setReleaseTee(boolean z10) {
        this.releaseTee = z10;
    }

    public void setServerTime(long j10) {
        this.serverTime = j10;
    }

    public void setTeeDeviceTypeWhite(boolean z10) {
        this.teeDeviceTypeWhite = z10;
    }

    public void setTrackTeeTime(int i10) {
        this.trackTeeTime = i10;
    }
}
