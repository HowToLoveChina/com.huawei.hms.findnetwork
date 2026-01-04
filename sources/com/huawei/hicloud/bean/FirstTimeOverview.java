package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class FirstTimeOverview {

    @SerializedName("notifyInterval")
    int notifyInterval;

    @SerializedName("notifyTimes")
    int notifyTimes;

    @SerializedName("reachChannels")
    ArrayList<String> reachChannels;

    @SerializedName("trigger")
    String trigger;

    @SerializedName("service")
    String service = "";

    @SerializedName("url")
    String url = "";

    @SerializedName("sceneId")
    String sceneId = "";

    @SerializedName("title")
    String titleKey = "";

    @SerializedName("content")
    String contentKey = "";

    public String getContentKey() {
        return this.contentKey;
    }

    public int getNotifyInterval() {
        return this.notifyInterval;
    }

    public int getNotifyTimes() {
        return this.notifyTimes;
    }

    public ArrayList<String> getReachChannels() {
        return this.reachChannels;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getService() {
        return this.service;
    }

    public String getTitleKey() {
        return this.titleKey;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContentKey(String str) {
        this.contentKey = str;
    }

    public void setNotifyInterval(int i10) {
        this.notifyInterval = i10;
    }

    public void setNotifyTimes(int i10) {
        this.notifyTimes = i10;
    }

    public void setReachChannels(ArrayList<String> arrayList) {
        this.reachChannels = arrayList;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setTitleKey(String str) {
        this.titleKey = str;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
