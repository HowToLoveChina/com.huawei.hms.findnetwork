package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDeleteAllBackupReq extends CBSBaseReq {
    private List<String> typeList;

    public CBSDeleteAllBackupReq(List<String> list, int i10, String str) {
        super(i10, str);
        this.typeList = list;
    }

    public List<String> getTypeList() {
        return this.typeList;
    }

    public void setTypeList(List<String> list) {
        this.typeList = list;
    }
}
