package com.huawei.cloud.pay.model;

import p454lj.C11296s;

/* loaded from: classes5.dex */
public class UpdateUserBMInfoReq extends Request {
    int bmType;
    boolean confirmDataObtain;
    long hmsVer;
    int userType;

    public interface UserType {
        public static final int NEW_USER = 0;
        public static final int OLD_USER = 1;
    }

    public UpdateUserBMInfoReq(boolean z10, boolean z11) {
        super("updateUserBMInfo");
        this.bmType = 1;
        this.hmsVer = C11296s.m67834r();
        this.userType = !z10 ? 1 : 0;
        this.confirmDataObtain = z11;
    }
}
