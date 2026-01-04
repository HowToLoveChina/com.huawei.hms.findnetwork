package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ShareQueryResponse extends BaseResponse {
    private ArrayList<ShareAlbumData> ownShareList;
    private ArrayList<ShareAlbumData> recShareList;

    public ArrayList<ShareAlbumData> getOwnShareList() {
        return this.ownShareList;
    }

    public ArrayList<ShareAlbumData> getRecShareList() {
        return this.recShareList;
    }

    public void setOwnShareList(ArrayList<ShareAlbumData> arrayList) {
        this.ownShareList = arrayList;
    }

    public void setRecShareList(ArrayList<ShareAlbumData> arrayList) {
        this.recShareList = arrayList;
    }
}
