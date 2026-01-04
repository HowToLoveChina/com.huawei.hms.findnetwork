package com.huawei.hms.hwid;

import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.hms.hwid.l */
/* loaded from: classes8.dex */
public class C5614l extends C5615m {
    public C5614l(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return Constants.HMS_VERSION_CODE_40000300;
    }
}
