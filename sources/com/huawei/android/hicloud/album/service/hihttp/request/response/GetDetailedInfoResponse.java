package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GetDetailedInfoResponse extends BaseResponse {
    private ArrayList<FailRet> failList;
    private ArrayList<FileData> successList;

    public ArrayList<FailRet> getFailList() {
        return this.failList;
    }

    public ArrayList<FileData> getSuccessList() {
        return this.successList;
    }

    public void setFailList(ArrayList<FailRet> arrayList) {
        this.failList = arrayList;
    }

    public void setSuccessList(ArrayList<FileData> arrayList) {
        this.successList = arrayList;
    }

    public String toString() {
        return "GetDetailedInfoResponse{successList=" + this.successList + ", failList=" + this.failList + '}';
    }
}
