package com.huawei.location.vdr.control;

import android.os.Build;
import android.text.TextUtils;
import as.C1016d;
import es.C9554s;
import p296ft.C9771b;
import p296ft.C9772c;

/* loaded from: classes8.dex */
public class VDRControl {
    private static final String TAG = "VDRControl";
    private static final String VDR_ENABLE = "1";
    public static final String VDR_GNSS_OPTION = "vdrEnable";
    private VDRConfig config;

    public VDRControl() {
        VDRConfig vDRConfig = new VDRConfig();
        this.config = vDRConfig;
        vDRConfig.m38533a();
    }

    public boolean isSpeedSupport(int i10) {
        VDRConfig vDRConfig = this.config;
        return vDRConfig != null && vDRConfig.m38535c(i10);
    }

    public boolean isSupport(String str) {
        if (this.config == null) {
            this.config = new VDRConfig();
        }
        return this.config.m38534b() && this.config.m38536d(str) && this.config.m38537e(C9772c.m60807b(C9554s.m59651f()), C9771b.m60805a(Build.VERSION.SDK_INT));
    }

    public boolean isVdrRequest(String str) {
        C1016d.m6186f(TAG, "isVdrRequest:" + str);
        return TextUtils.equals("1", str);
    }
}
