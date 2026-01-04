package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Member extends C11707b {

    @InterfaceC4648p
    private List<String> kinships;

    @InterfaceC4648p
    private Integer number;

    public List<String> getKinships() {
        return this.kinships;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setKinships(List<String> list) {
        this.kinships = list;
    }

    public void setNumber(Integer num) {
        this.number = num;
    }
}
