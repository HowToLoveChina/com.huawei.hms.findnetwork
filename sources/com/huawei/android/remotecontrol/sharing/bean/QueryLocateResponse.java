package com.huawei.android.remotecontrol.sharing.bean;

import com.huawei.android.remotecontrol.http.BaseResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class QueryLocateResponse extends BaseResponse {
    private List<CptLocateInfo> cptLocateInfoList;
    private LocateInfo info;

    public QueryLocateResponse(int i10, String str) {
        super(i10, str);
    }

    public List<CptLocateInfo> getCptLocateInfoList() {
        return this.cptLocateInfoList;
    }

    public LocateInfo getInfo() {
        return this.info;
    }

    public void setCptLocateInfoList(List<CptLocateInfo> list) {
        this.cptLocateInfoList = list;
    }

    public void setInfo(LocateInfo locateInfo) {
        this.info = locateInfo;
    }
}
