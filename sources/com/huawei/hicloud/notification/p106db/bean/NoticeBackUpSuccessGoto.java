package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NoticeBackUpSuccessGoto {
    private static final String TAG = "NoticeBackUpSuccessGoto";

    @SerializedName("enableDataBackup")
    private Integer enableDataBackup;

    @SerializedName("noti_type")
    private String notiType;

    @SerializedName("noti_uri")
    private String notiUri;

    @SerializedName("user_type")
    private String userType;

    public Integer getEnableDataBackup() {
        return this.enableDataBackup;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public String getNotiUri() {
        return this.notiUri;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setEnableDataBackup(Integer num) {
        this.enableDataBackup = num;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setNotiUri(String str) {
        this.notiUri = str;
    }

    public void setUserType(String str) {
        this.userType = str;
    }
}
