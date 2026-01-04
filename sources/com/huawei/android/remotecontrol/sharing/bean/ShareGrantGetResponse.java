package com.huawei.android.remotecontrol.sharing.bean;

import com.huawei.android.remotecontrol.http.BaseResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class ShareGrantGetResponse extends BaseResponse {
    private List<ShareGrantInfo> shareGrantInfoList;

    public ShareGrantGetResponse(int i10, String str) {
        super(i10, str);
    }

    public List<ShareGrantInfo> getShareGrantInfoList() {
        return this.shareGrantInfoList;
    }

    public void setShareGrantInfoList(List<ShareGrantInfo> list) {
        this.shareGrantInfoList = list;
    }
}
