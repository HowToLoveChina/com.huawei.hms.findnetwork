package com.huawei.android.hicloud.p081cs.bean;

import com.huawei.hicloud.request.opengw.bean.Result;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PropResult {
    private List<Properties> successList = new ArrayList();
    private List<Result.ErrMsg> failList = new ArrayList();

    public List<Result.ErrMsg> getFailList() {
        return this.failList;
    }

    public List<Properties> getSuccessList() {
        return this.successList;
    }

    public void setFailList(List<Result.ErrMsg> list) {
        this.failList = list;
    }

    public void setSuccessList(List<Properties> list) {
        this.successList = list;
    }
}
