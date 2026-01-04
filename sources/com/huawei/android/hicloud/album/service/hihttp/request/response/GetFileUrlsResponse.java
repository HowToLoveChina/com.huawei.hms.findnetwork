package com.huawei.android.hicloud.album.service.hihttp.request.response;

import java.util.Map;

/* loaded from: classes2.dex */
public class GetFileUrlsResponse extends BaseResponse {
    private Map<String, String> urlList;

    public Map getUrlList() {
        return this.urlList;
    }

    public void setUrlList(Map map) {
        this.urlList = map;
    }
}
