package com.huawei.android.hicloud.sync.protocol;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import mk.C11475a;
import p514o9.C11829c;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.protocol.k */
/* loaded from: classes3.dex */
public abstract class AbstractC2932k extends AbstractC2923b {
    public AbstractC2932k(String str, String str2, String str3, String str4, int i10) {
        super(str, str2, str3, str4, i10);
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
    public String addAuthHeader() {
        String strM80970t = C13452e.m80781L().m80970t();
        if (TextUtils.isEmpty(strM80970t)) {
            strM80970t = "0";
        }
        String strM70565c = C11829c.m70565c(strM80970t, C13452e.m80781L().m80954p(), "com.huawei.hidisk", C13452e.m80781L().m80931j0(), this.accessToken);
        Charset charset = StandardCharsets.UTF_8;
        return new String(C11475a.m68618a(strM70565c.getBytes(charset)), charset);
    }
}
