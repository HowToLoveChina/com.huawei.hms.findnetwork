package com.huawei.hicloud.notification.manager;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import java.util.List;

/* loaded from: classes6.dex */
public class BackupSpaceInsuffWindowNoticeBean {

    @SerializedName("configuration")
    private List<BackupSpaceInsuffNoticeV5Configuration> configuration;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22666id;

    @SerializedName("version")
    private String version;

    public List<BackupSpaceInsuffNoticeV5Configuration> getConfiguration() {
        return this.configuration;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22666id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfiguration(List<BackupSpaceInsuffNoticeV5Configuration> list) {
        this.configuration = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22666id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "BackupSpaceInsuffWindowNoticeBean{date='" + this.date + "', version='" + this.version + "', id='" + this.f22666id + "', configuration=" + this.configuration + '}';
    }
}
