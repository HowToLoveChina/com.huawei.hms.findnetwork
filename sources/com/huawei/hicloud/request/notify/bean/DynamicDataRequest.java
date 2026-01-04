package com.huawei.hicloud.request.notify.bean;

/* loaded from: classes6.dex */
public class DynamicDataRequest extends NotifyBaseReq {
    String countryCode;
    String lang;
    String sceneId;
    String srcChannel;

    public DynamicDataRequest(String str) {
        super(str);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getLang() {
        return this.lang;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }
}
