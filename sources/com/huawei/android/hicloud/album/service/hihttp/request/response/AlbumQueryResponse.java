package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;

/* loaded from: classes2.dex */
public class AlbumQueryResponse extends BaseResponse {
    private GeneralAlbumData[] albumList;
    private String cursor;

    public GeneralAlbumData[] getAlbumList() {
        return this.albumList;
    }

    public String getCursor() {
        return this.cursor;
    }

    public void setAlbumList(GeneralAlbumData[] generalAlbumDataArr) {
        this.albumList = generalAlbumDataArr;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }
}
