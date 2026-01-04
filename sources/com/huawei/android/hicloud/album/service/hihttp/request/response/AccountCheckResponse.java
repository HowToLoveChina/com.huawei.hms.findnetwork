package com.huawei.android.hicloud.album.service.hihttp.request.response;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class AccountCheckResponse extends BaseResponse {
    private HashMap<String, String> accUidMap;

    public HashMap<String, String> getAccUidMap() {
        return this.accUidMap;
    }

    public void setAccUidMap(HashMap<String, String> map) {
        this.accUidMap = map;
    }
}
