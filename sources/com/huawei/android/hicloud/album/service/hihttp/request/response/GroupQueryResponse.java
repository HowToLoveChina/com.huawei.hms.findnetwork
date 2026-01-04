package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GroupQueryResponse extends BaseResponse {
    private ArrayList<ShareAlbumData> groupList;

    public ArrayList<ShareAlbumData> getGroupList() {
        return this.groupList;
    }

    public void setGroupList(ArrayList<ShareAlbumData> arrayList) {
        this.groupList = arrayList;
    }
}
