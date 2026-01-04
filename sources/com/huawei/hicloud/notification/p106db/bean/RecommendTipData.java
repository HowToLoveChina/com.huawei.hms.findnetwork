package com.huawei.hicloud.notification.p106db.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class RecommendTipData implements Serializable {
    private static final long serialVersionUID = -2517438730301381670L;
    private String dialogPopTimesThreshold;
    private int dialogViewDetailsNum;
    private String displayClearCard;
    private String displayHelp;
    private String helpUrl;
    private int notificationId;
    private String tipId;

    public String getDialogPopTimesThreshold() {
        return this.dialogPopTimesThreshold;
    }

    public int getDialogViewDetailsNum() {
        return this.dialogViewDetailsNum;
    }

    public String getDisplayClearCard() {
        return this.displayClearCard;
    }

    public String getDisplayHelp() {
        return this.displayHelp;
    }

    public String getHelpUrl() {
        return this.helpUrl;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public String getTipId() {
        return this.tipId;
    }

    public void setDialogPopTimesThreshold(String str) {
        this.dialogPopTimesThreshold = str;
    }

    public void setDialogViewDetailsNum(int i10) {
        this.dialogViewDetailsNum = i10;
    }

    public void setDisplayClearCard(String str) {
        this.displayClearCard = str;
    }

    public void setDisplayHelp(String str) {
        this.displayHelp = str;
    }

    public void setHelpUrl(String str) {
        this.helpUrl = str;
    }

    public void setNotificationId(int i10) {
        this.notificationId = i10;
    }

    public void setTipId(String str) {
        this.tipId = str;
    }
}
