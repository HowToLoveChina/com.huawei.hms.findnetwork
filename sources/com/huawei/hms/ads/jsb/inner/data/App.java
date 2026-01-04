package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

@DataKeep
/* loaded from: classes8.dex */
public class App {
    private String afDlBtnText;
    private String appDesc;
    private String appName;
    private String dlBtnText;
    private String iconUrl;
    private String packageName;
    private String reservedPkgName;

    public App(AppInfo appInfo) {
        if (appInfo != null) {
            this.appName = AbstractC7806cz.m48170d(appInfo.getAppName());
            this.iconUrl = appInfo.getIconUrl();
            this.appDesc = AbstractC7806cz.m48170d(appInfo.getAppDesc());
            this.packageName = appInfo.getPackageName();
            this.dlBtnText = AbstractC7806cz.m48170d(appInfo.m44409k());
            this.afDlBtnText = AbstractC7806cz.m48170d(appInfo.m44412l());
            this.reservedPkgName = appInfo.m44358J();
        }
    }
}
