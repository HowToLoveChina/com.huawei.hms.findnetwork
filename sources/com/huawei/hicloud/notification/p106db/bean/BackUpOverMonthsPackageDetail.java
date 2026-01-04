package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;

/* loaded from: classes6.dex */
public class BackUpOverMonthsPackageDetail {

    @SerializedName(BackUpOverMonthRecordConstants.Report.CLEARABLE_SPACE)
    private String clearableSpace;

    @SerializedName(BackUpOverMonthRecordConstants.Report.RESIDUAL_SPACE)
    private String residualSpace;

    public String getClearableSpace() {
        return this.clearableSpace;
    }

    public String getResidualSpace() {
        return this.residualSpace;
    }

    public void setClearableSpace(String str) {
        this.clearableSpace = str;
    }

    public void setResidualSpace(String str) {
        this.residualSpace = str;
    }
}
