package com.huawei.hicloud.notification.p106db.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class MemberShareDetail implements Serializable {
    private static final long serialVersionUID = -6347169411118052785L;
    private String buttonText;
    private String mainText;
    private String notifyType;
    private String title;

    public String getButtonText() {
        return this.buttonText;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
