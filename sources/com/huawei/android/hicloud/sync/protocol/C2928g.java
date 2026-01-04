package com.huawei.android.hicloud.sync.protocol;

import android.telephony.TelephonyManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import mk.C11475a;
import p015ak.C0213f;
import p514o9.C11829c;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.protocol.g */
/* loaded from: classes3.dex */
public class C2928g extends AbstractC2923b {
    public C2928g(String str, String str2, String str3, String str4, int i10) {
        super(str, str2, str3, str4, i10);
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
    public String addAuthHeader() {
        TelephonyManager telephonyManager = (TelephonyManager) C0213f.m1377a().getSystemService("phone");
        int phoneType = telephonyManager != null ? telephonyManager.getPhoneType() : 0;
        String strM80970t = C13452e.m80781L().m80970t();
        if ("9".equals(strM80970t)) {
            strM80970t = "9";
        } else if (phoneType == 1) {
            strM80970t = "IMEI";
        } else if (!"11".equals(strM80970t)) {
            strM80970t = "MEID";
        }
        String strM70565c = C11829c.m70565c(strM80970t, C13452e.m80781L().m80954p(), "com.huawei.hidisk", C13452e.m80781L().m80931j0(), this.accessToken);
        Charset charset = StandardCharsets.UTF_8;
        return new String(C11475a.m68618a(strM70565c.getBytes(charset)), charset);
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
    public String addLockTokenToHeader() {
        return "";
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
    public void onReceiveLockToken(String str) {
    }
}
