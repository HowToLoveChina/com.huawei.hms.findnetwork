package com.huawei.hicloud.request.notify.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class ExposureReportRequest extends NotifyBaseReq {
    List<ExposureReportData> data;

    public ExposureReportRequest(String str) {
        super(str);
    }

    public List<ExposureReportData> getData() {
        return this.data;
    }

    public void setData(List<ExposureReportData> list) {
        this.data = list;
    }
}
