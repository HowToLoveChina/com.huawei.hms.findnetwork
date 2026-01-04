package com.huawei.hicloud.messagecenter.bean;

import com.huawei.hicloud.bean.NotifyWay;
import java.util.Map;

/* loaded from: classes6.dex */
public class ClientMessageBody {
    private String category;
    private String cfgInstanceId;
    private String cfgKey;
    private String cfgResourceId;
    private String context;
    private String notifyId;
    private long notifyTime;
    private String notifyType;
    private NotifyWay[] notifyWays;
    private Map<String, String> params;
    private int priority;
    private long readValidityTime;
    private long remainValidityTime;
    private String userData;
    private long validityTime;

    public String getCategory() {
        return this.category;
    }

    public String getCfgInstanceId() {
        return this.cfgInstanceId;
    }

    public String getCfgKey() {
        return this.cfgKey;
    }

    public String getCfgResourceId() {
        return this.cfgResourceId;
    }

    public String getContext() {
        return this.context;
    }

    public String getNotifyId() {
        return this.notifyId;
    }

    public long getNotifyTime() {
        return this.notifyTime;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public NotifyWay[] getNotifyWays() {
        return this.notifyWays;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getReadValidityTime() {
        return this.readValidityTime;
    }

    public long getRemainValidityTime() {
        return this.remainValidityTime;
    }

    public String getUserData() {
        return this.userData;
    }

    public long getValidityTime() {
        return this.validityTime;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCfgInstanceId(String str) {
        this.cfgInstanceId = str;
    }

    public void setCfgKey(String str) {
        this.cfgKey = str;
    }

    public void setCfgResourceId(String str) {
        this.cfgResourceId = str;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setNotifyId(String str) {
        this.notifyId = str;
    }

    public void setNotifyTime(long j10) {
        this.notifyTime = j10;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyWays(NotifyWay[] notifyWayArr) {
        this.notifyWays = notifyWayArr;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setReadValidityTime(long j10) {
        this.readValidityTime = j10;
    }

    public void setRemainValidityTime(long j10) {
        this.remainValidityTime = j10;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public void setValidityTime(long j10) {
        this.validityTime = j10;
    }
}
