package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TagInfoResult extends BaseResponse {
    private String cursor;
    private ArrayList<SmartTagData> tagList;

    public String getCursor() {
        return this.cursor;
    }

    public ArrayList<SmartTagData> getTagList() {
        return this.tagList;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setTagList(ArrayList<SmartTagData> arrayList) {
        this.tagList = arrayList;
    }
}
