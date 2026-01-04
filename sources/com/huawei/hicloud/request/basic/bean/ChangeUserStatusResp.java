package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hidisk.common.util.javautil.StringUtil;

/* loaded from: classes6.dex */
public class ChangeUserStatusResp extends BasicBaseResp {
    private static final String ACTIVE_STATUS = "A";
    private String newUserStatus;
    private String oldUserStatus;
    private long validToTile;

    public String getNewUserStatus() {
        return this.newUserStatus;
    }

    public String getOldUserStatus() {
        return this.oldUserStatus;
    }

    public long getValidToTile() {
        return this.validToTile;
    }

    public Boolean isActiveSuccess() {
        return Boolean.valueOf(StringUtil.equals("A", this.newUserStatus));
    }

    public void setNewUserStatus(String str) {
        this.newUserStatus = str;
    }

    public void setOldUserStatus(String str) {
        this.oldUserStatus = str;
    }

    public void setValidToTile(long j10) {
        this.validToTile = j10;
    }
}
