package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class UserList extends C11707b {

    @InterfaceC4648p
    private List<User> userList;

    public List<User> getUserList() {
        return this.userList;
    }

    public UserList setUserList(List<User> list) {
        this.userList = list;
        return this;
    }
}
