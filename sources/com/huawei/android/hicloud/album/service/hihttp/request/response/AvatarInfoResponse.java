package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.AvatarInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AvatarInfoResponse extends BaseResponse {
    private ArrayList<AvatarInfo> userList;

    public ArrayList<AvatarInfo> getUserList() {
        return this.userList;
    }

    public void setUserList(ArrayList<AvatarInfo> arrayList) {
        this.userList = arrayList;
    }
}
