package com.huawei.hicloud.request.notify.bean;

/* loaded from: classes6.dex */
public class DynamicDataResponse {
    DynamicDataInfo data;
    String sceneId;
    String srcChannel;
    String title;

    public DynamicDataInfo getData() {
        return this.data;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public String getTitle() {
        return this.title;
    }

    public void setData(DynamicDataInfo dynamicDataInfo) {
        this.data = dynamicDataInfo;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
