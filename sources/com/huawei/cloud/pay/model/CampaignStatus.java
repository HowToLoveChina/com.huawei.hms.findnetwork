package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class CampaignStatus implements Serializable {
    private static final long serialVersionUID = -4024925127818243972L;
    private String acceptRightTime;
    private String cId;
    private long capacity;

    @SerializedName("display")
    private List<DlTask> display;

    @SerializedName("displayRules")
    private List<DispRule> displayRules;
    private int duration;
    private String expiredTime;
    private int launchNo;
    private int quota;
    private int timeUnit;

    public String getAcceptRightTime() {
        return this.acceptRightTime;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public List<DlTask> getDisplay() {
        return this.display;
    }

    public List<DispRule> getDisplayRules() {
        return this.displayRules;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getExpiredTime() {
        return this.expiredTime;
    }

    public int getLaunchNo() {
        return this.launchNo;
    }

    public int getQuota() {
        return this.quota;
    }

    public int getTimeUnit() {
        return this.timeUnit;
    }

    public String getcId() {
        return this.cId;
    }

    public void setAcceptRightTime(String str) {
        this.acceptRightTime = str;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setDisplay(List<DlTask> list) {
        this.display = list;
    }

    public void setDisplayRules(List<DispRule> list) {
        this.displayRules = list;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setExpiredTime(String str) {
        this.expiredTime = str;
    }

    public void setLaunchNo(int i10) {
        this.launchNo = i10;
    }

    public void setQuota(int i10) {
        this.quota = i10;
    }

    public void setTimeUnit(int i10) {
        this.timeUnit = i10;
    }

    public void setcId(String str) {
        this.cId = str;
    }
}
