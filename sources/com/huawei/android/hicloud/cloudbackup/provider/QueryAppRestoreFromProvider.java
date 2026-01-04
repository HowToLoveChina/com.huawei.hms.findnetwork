package com.huawei.android.hicloud.cloudbackup.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class QueryAppRestoreFromProvider {
    private static final String CALL_DOWNLOAD_APPORDER_MATHOD = "callDownloadAppOrder";
    private static final String CHECK_RESTOERICON_KEY = "supportCloudbackup";
    private static final String CHECK_SUPPORT_CLOUDBACKUP = "checkSupportCloudbackup";
    private static final String HIHONOR_LAUNCH_AUTHORITY = "content://com.hihonor.android.launcher.settings";
    private static final String HUAWEI_LAUNCH_PACKAGE_NAME = "com.huawei.android.launcher";
    private static final String LAUNCH_AUTHORITY = "content://com.huawei.android.launcher.settings";
    private static final String NOTIFY_START_RESTORE = "callSetCloudRestoreState";
    private static final String ORDER_APPS_KEY = "orderApps";
    private static final String QUERY_APP_RESTORE_PATH = "/badge/";
    private static final String TAG = "QueryAppRestoreFromProvider";
    private static final Uri QUERY_APP_RESTORE_URI = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
    private static final Uri HIHONOR_QUERY_APP_RESTORE_URI = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");

    private static Bundle callProviderByMethod(Context context, String str, Bundle bundle) {
        if (C0209d.m1184K0(context, HUAWEI_LAUNCH_PACKAGE_NAME)) {
            Uri uri = QUERY_APP_RESTORE_URI;
            if (C0209d.m1227Y1(context, uri)) {
                return C0209d.m1243d(context, uri, str, null, bundle);
            }
            C11839m.m70687e(TAG, "error occur because inspection found uri do not source from system app");
            return null;
        }
        Uri uri2 = HIHONOR_QUERY_APP_RESTORE_URI;
        if (C0209d.m1227Y1(context, uri2)) {
            return C0209d.m1243d(context, uri2, str, null, bundle);
        }
        C11839m.m70687e(TAG, "error occur because inspection found uri do not source from system app");
        return null;
    }

    public static boolean checkPrioritRestoreIcon(Context context) {
        Bundle bundleCallProviderByMethod;
        if (context == null || (bundleCallProviderByMethod = callProviderByMethod(context, CHECK_SUPPORT_CLOUDBACKUP, null)) == null) {
            return false;
        }
        return bundleCallProviderByMethod.getBoolean(CHECK_RESTOERICON_KEY);
    }

    public static boolean notifyRestoreLauncherStart(Context context) {
        if (context == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("cloudRestoreState", true);
        callProviderByMethod(context, NOTIFY_START_RESTORE, bundle);
        return true;
    }

    public static List<String> queryRestoreAppsOrders(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "context is null");
            return null;
        }
        Bundle bundleCallProviderByMethod = callProviderByMethod(context, CALL_DOWNLOAD_APPORDER_MATHOD, new Bundle());
        if (bundleCallProviderByMethod != null) {
            return bundleCallProviderByMethod.getStringArrayList(ORDER_APPS_KEY);
        }
        C11839m.m70689w(TAG, "result is null");
        return null;
    }
}
