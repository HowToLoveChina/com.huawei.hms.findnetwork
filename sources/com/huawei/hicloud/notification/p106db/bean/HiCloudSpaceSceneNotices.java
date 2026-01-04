package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class HiCloudSpaceSceneNotices {

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22651id;

    @SerializedName("sceneNotices")
    private SceneNotices sceneNotices;

    @SerializedName("version")
    private String version;

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22651id;
    }

    public SceneNotices getSceneNotices() {
        return this.sceneNotices;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22651id = str;
    }

    public void setSceneNotices(SceneNotices sceneNotices) {
        this.sceneNotices = sceneNotices;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
