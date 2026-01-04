package com.huawei.android.p069cg.request.response;

import com.huawei.android.p069cg.p072vo.ShareInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ShareQueryResponse extends BaseResponse {
    private ArrayList<ShareInfo> ownShareList;
    private ArrayList<ShareInfo> recShareList;

    public ArrayList<ShareInfo> getOwnShareList() {
        return this.ownShareList;
    }

    public ArrayList<ShareInfo> getRecShareList() {
        return this.recShareList;
    }

    public void setOwnShareList(ArrayList<ShareInfo> arrayList) {
        this.ownShareList = arrayList;
    }

    public void setRecShareList(ArrayList<ShareInfo> arrayList) {
        this.recShareList = arrayList;
    }
}
