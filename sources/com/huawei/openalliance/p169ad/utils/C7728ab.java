package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.constant.ErrorCode;

/* renamed from: com.huawei.openalliance.ad.utils.ab */
/* loaded from: classes2.dex */
public class C7728ab {
    /* renamed from: a */
    public static int m47430a(int i10, int i11) {
        if (i11 != 204) {
            return i11;
        }
        if (i10 == 7) {
            return ErrorCode.ERROR_REWARD_AD_NO;
        }
        if (i10 == 12) {
            return 1100;
        }
        if (i10 != 60) {
            return ErrorCode.ERROR_NATIVE_AD_NO;
        }
        return 800;
    }
}
