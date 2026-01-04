package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.metadata.AdEvent;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AnalysisReportReq extends EventReportReq {
    public AnalysisReportReq(List<AdEvent> list) {
        super(list);
    }

    @Override // com.huawei.openalliance.p169ad.beans.server.EventReportReq, com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.ANALYSIS_CONTENT_SERVER_REQ_URI;
    }
}
