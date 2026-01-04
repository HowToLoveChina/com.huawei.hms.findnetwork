package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class QueryPresentResp extends Response {
    private List<PresentLog> presentLogs;

    public List<PresentLog> getPresentLogs() {
        return this.presentLogs;
    }

    public void setPresentLogs(List<PresentLog> list) {
        this.presentLogs = list;
    }
}
