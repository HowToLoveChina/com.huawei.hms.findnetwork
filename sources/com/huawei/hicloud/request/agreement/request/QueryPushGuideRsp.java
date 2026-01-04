package com.huawei.hicloud.request.agreement.request;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class QueryPushGuideRsp extends BaseRsp {

    @SerializedName("consentRecordList")
    private List<ConsentRecordWithStatus> mRecordWithStatusArrayList;

    public List<ConsentRecordWithStatus> getRecordWithStatusArrayList() {
        return this.mRecordWithStatusArrayList;
    }

    public void setRecordWithStatusArrayList(List<ConsentRecordWithStatus> list) {
        this.mRecordWithStatusArrayList = list;
    }
}
