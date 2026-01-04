package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.p106db.bean.SpaceInsufficientNoticeConfiguration;

/* loaded from: classes6.dex */
public class SpaceNoticeV4Bean {
    private SpaceInsufficientNoticeConfiguration configuration;
    private String date;

    /* renamed from: id */
    private String f22668id;
    private String version;

    public SpaceInsufficientNoticeConfiguration getConfiguration() {
        return this.configuration;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22668id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfiguration(SpaceInsufficientNoticeConfiguration spaceInsufficientNoticeConfiguration) {
        this.configuration = spaceInsufficientNoticeConfiguration;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22668id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
