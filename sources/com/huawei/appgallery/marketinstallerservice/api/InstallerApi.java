package com.huawei.appgallery.marketinstallerservice.api;

import android.app.Activity;
import android.content.Context;
import mh.InterfaceC11470c;
import p522oh.C11883b;
import th.C13012a;

/* loaded from: classes4.dex */
public class InstallerApi {
    public static void getMarketInfo(Context context, BaseParamSpec baseParamSpec, InstallCallback installCallback) {
        InterfaceC11470c interfaceC11470c = (InterfaceC11470c) C11883b.m71377a(InterfaceC11470c.class);
        if (interfaceC11470c != null) {
            interfaceC11470c.mo68598b(context, baseParamSpec, installCallback);
        } else {
            C13012a.m78317c("InstallerApi", "getMarketInfo impl error!");
        }
    }

    public static void installMarket(Activity activity, InstallParamSpec installParamSpec, InstallCallback installCallback) {
        InterfaceC11470c interfaceC11470c = (InterfaceC11470c) C11883b.m71377a(InterfaceC11470c.class);
        if (interfaceC11470c != null) {
            interfaceC11470c.mo68597a(activity, installParamSpec, installCallback);
        } else {
            C13012a.m78317c("InstallerApi", "installMarket impl error!");
        }
    }
}
