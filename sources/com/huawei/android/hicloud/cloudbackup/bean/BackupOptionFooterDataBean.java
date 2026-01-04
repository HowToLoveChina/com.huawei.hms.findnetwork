package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class BackupOptionFooterDataBean {
    private FooterType showTipsType = FooterType.NOT_SHOW;

    public enum FooterType {
        NOT_SHOW,
        EXCLUDE_TIP,
        SYNC_EXCLUSIVE_TIP
    }

    public FooterType getShowTipsType() {
        return this.showTipsType;
    }

    public void setShowTipsType(FooterType footerType) {
        this.showTipsType = footerType;
    }
}
