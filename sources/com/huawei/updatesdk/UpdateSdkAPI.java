package com.huawei.updatesdk;

import android.content.Context;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.C8872g;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;

/* loaded from: classes9.dex */
public final class UpdateSdkAPI {
    public static void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z10, boolean z11) {
        C8872g.m56479a(context, checkUpdateCallBack, z10, z11);
    }

    public static void checkAppUpdateByAppInfo(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        C8872g.m56477a(context, checkUpdateCallBack, appInfoAdapter);
    }

    public static void checkAppUpdateForHMSKit(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        C8872g.m56485b(context, updateParams, checkUpdateCallBack);
    }

    public static void checkClientOTAUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z10, int i10, boolean z11) {
        C8872g.m56478a(context, checkUpdateCallBack, z10, i10, z11);
    }

    public static void checkTargetAppUpdate(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        C8872g.m56482a(context, str, checkUpdateCallBack);
    }

    public static void releaseCallBack() {
        C8872g.m56472a();
    }

    @Deprecated
    public static void setAppStorePkgName(String str) {
    }

    public static void setServiceZone(String str) {
        C8872g.m56483a(str);
    }

    public static void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z10) {
        C8872g.m56475a(context, apkUpgradeInfo, z10);
    }

    public static void showUpdateDialogByAppInfo(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        C8872g.m56474a(context, apkUpgradeInfo, appInfoAdapter);
    }

    public static void checkAppUpdate(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        C8872g.m56480a(context, updateParams, checkUpdateCallBack);
    }
}
