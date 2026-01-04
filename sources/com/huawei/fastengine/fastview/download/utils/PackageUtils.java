package com.huawei.fastengine.fastview.download.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public final class PackageUtils {
    private static final int GAMEBOX_SUPPORT_VERSION = 10008001;
    public static final String HWGAMEBOX_PACKAGE_NAME = "com.huawei.gamebox";
    public static final String TAG = "PackageUtils";
    private static final int URL_SUPPORT_VERSION = 10002001;

    public static boolean isEngineInstalled(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(Config.getPackageName(), 64);
            if (packageInfo.versionCode >= URL_SUPPORT_VERSION) {
                FastViewLogUtils.m28728w(TAG, "Fastapp Engine is installed!");
                return true;
            }
            FastViewLogUtils.m28728w(TAG, "Fastapp Engine's versionCode isn't supported! " + packageInfo.versionCode);
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            FastViewLogUtils.m28728w(TAG, "Fastapp Engine is not installed!");
            return false;
        }
    }

    public static boolean isEngineInstalledIngoreVersion(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            if (packageManager.getPackageInfo(Config.getPackageName(), 64).versionCode > 0) {
                FastViewLogUtils.m28726i(TAG, "Fastapp Engine is installed ");
                return true;
            }
            FastViewLogUtils.m28724e(TAG, "Fastapp Engine versionCode is incorrect!");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, "Fastapp Engine is not installed!");
            return false;
        }
    }

    public static boolean isEngineInstalledforGameBox(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(Config.getPackageName(), 64);
            if (packageInfo.versionCode >= GAMEBOX_SUPPORT_VERSION) {
                FastViewLogUtils.m28728w(TAG, "Fastapp Engine is installed!");
                return true;
            }
            FastViewLogUtils.m28728w(TAG, "Fastapp Engine's versionCode isn't supported! " + packageInfo.versionCode);
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            FastViewLogUtils.m28728w(TAG, "Fastapp Engine is not installed!");
            return false;
        }
    }

    public static boolean isInstallByPackage(Context context, String str) throws PackageManager.NameNotFoundException {
        String str2;
        String str3 = context.getApplicationInfo().packageName;
        if (HWGAMEBOX_PACKAGE_NAME.equals(str3)) {
            return isEngineInstalledforGameBox(context);
        }
        FastViewLogUtils.m28726i(TAG, "Package callPacksgename " + str3);
        try {
            context.getPackageManager().getPackageInfo(str, 16384);
            FastViewLogUtils.m28726i(TAG, "Package is installed : " + str);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "isInstallByPackage NameNotFoundException:";
            FastViewLogUtils.m28724e(TAG, str2);
            FastViewLogUtils.m28726i(TAG, "Package is not installed : " + str);
            return false;
        } catch (UnsupportedOperationException unused2) {
            str2 = "isInstallByPackage UnsupportedOperationException:";
            FastViewLogUtils.m28724e(TAG, str2);
            FastViewLogUtils.m28726i(TAG, "Package is not installed : " + str);
            return false;
        } catch (Exception unused3) {
            str2 = "isInstallByPackage Exception:";
            FastViewLogUtils.m28724e(TAG, str2);
            FastViewLogUtils.m28726i(TAG, "Package is not installed : " + str);
            return false;
        }
    }
}
