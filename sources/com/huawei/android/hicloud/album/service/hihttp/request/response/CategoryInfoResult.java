package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class CategoryInfoResult extends BaseResponse {
    private ArrayList<SmartAlbumData> categoryList;

    public ArrayList<SmartAlbumData> getCategoryList() {
        return this.categoryList;
    }

    public void setCategoryList(ArrayList<SmartAlbumData> arrayList) {
        this.categoryList = arrayList;
    }
}
