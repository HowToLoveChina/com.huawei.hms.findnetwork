package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BabyInfo extends C11707b {

    @InterfaceC4648p
    private C4644l birthday;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String sex;

    public C4644l getBirthday() {
        return this.birthday;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSex() {
        return this.sex;
    }

    public BabyInfo setBirthday(C4644l c4644l) {
        this.birthday = c4644l;
        return this;
    }

    public BabyInfo setRemark(String str) {
        this.remark = str;
        return this;
    }

    public BabyInfo setSex(String str) {
        this.sex = str;
        return this;
    }
}
