package com.huawei.hicloud.notification.p106db.bean;

/* loaded from: classes6.dex */
public class ExtraNotifyConfig {
    private ExtraNoticeConfiguration configuration;
    private String date;
    private int priority;
    private String version;

    public ExtraNoticeConfiguration getConfiguration() {
        return this.configuration;
    }

    public String getDate() {
        return this.date;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfiguration(ExtraNoticeConfiguration extraNoticeConfiguration) {
        this.configuration = extraNoticeConfiguration;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
