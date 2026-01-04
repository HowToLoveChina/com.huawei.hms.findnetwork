package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.NotifyWay;
import java.util.List;

/* loaded from: classes6.dex */
public class FreqControlBean {

    @SerializedName("switch")
    private boolean enableSwitch;

    @SerializedName("frequencyItemList")
    private FrequencyItem[] frequencyItemList;

    @SerializedName("frequencyList")
    private FrequencyBean[] frequencyList;

    /* renamed from: id */
    @SerializedName("id")
    private String f22623id;

    @SerializedName("name")
    private String name;

    @SerializedName("remind_ways")
    private List<NotifyWay> remindWays;

    @SerializedName("sceneNoticeText")
    private SceneNoticeText sceneNoticeText;

    @SerializedName("userGroupExtIDs")
    private List<String> userGroupExtIDs;

    public FrequencyItem[] getFrequencyItemList() {
        return this.frequencyItemList;
    }

    public FrequencyBean[] getFrequencyList() {
        return this.frequencyList;
    }

    public String getId() {
        return this.f22623id;
    }

    public String getName() {
        return this.name;
    }

    public List<NotifyWay> getRemindWays() {
        return this.remindWays;
    }

    public SceneNoticeText getSceneNoticeText() {
        return this.sceneNoticeText;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public boolean isEnableSwitch() {
        return this.enableSwitch;
    }

    public void setEnableSwitch(boolean z10) {
        this.enableSwitch = z10;
    }

    public void setFrequencyItemList(FrequencyItem[] frequencyItemArr) {
        this.frequencyItemList = frequencyItemArr;
    }

    public void setFrequencyList(FrequencyBean[] frequencyBeanArr) {
        this.frequencyList = frequencyBeanArr;
    }

    public void setId(String str) {
        this.f22623id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRemindWays(List<NotifyWay> list) {
        this.remindWays = list;
    }

    public void setSceneNoticeText(SceneNoticeText sceneNoticeText) {
        this.sceneNoticeText = sceneNoticeText;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }
}
