package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class HiCloudSpacePositionMgr {

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22650id;

    @SerializedName("spacePositionMgr")
    private SpacePositionMgr spacePositionMgr;

    @SerializedName("version")
    private String version;

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22650id;
    }

    public SpacePositionMgr getSpacePositionMgr() {
        return this.spacePositionMgr;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22650id = str;
    }

    public void setSpacePositionMgr(SpacePositionMgr spacePositionMgr) {
        this.spacePositionMgr = spacePositionMgr;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
