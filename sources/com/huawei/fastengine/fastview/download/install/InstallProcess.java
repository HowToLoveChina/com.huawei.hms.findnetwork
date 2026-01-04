package com.huawei.fastengine.fastview.download.install;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.huawei.fastengine.fastview.download.utils.PackageManagerUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;

/* loaded from: classes5.dex */
public abstract class InstallProcess {
    private static final String TAG = "InstallProcess";

    public static Intent getNomalInstallIntent(Context context, String str) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        intent.setAction("android.intent.action.INSTALL_PACKAGE");
        intent.setData(Uri.fromFile(new File(str)));
        return intent;
    }

    private static boolean innerInstall(Context context, ManagerTask managerTask) {
        Log.i(PackageManagerConstants.TAG, " innerInstall begin:");
        if (installApk(context, managerTask)) {
            return true;
        }
        Log.e(PackageManagerConstants.TAG, " inner install failed!!!!");
        return false;
    }

    private static boolean installApk(Context context, ManagerTask managerTask) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        try {
            if (PackageManagerUtils.systemApp(context) && innerInstall(context, managerTask, 2, packageManager)) {
                return false;
            }
            Log.i(TAG, " inner install end!");
            return true;
        } catch (IllegalArgumentException unused) {
            str = " installPackage IllegalArgumentException ";
            Log.e(TAG, str);
            return false;
        } catch (Throwable unused2) {
            str = " inner install exception: ";
            Log.e(TAG, str);
            return false;
        }
    }

    public static void installProcess(Context context, ManagerTask managerTask) {
        Log.d(TAG, "install installProcess: start" + PackageManagerUtils.systemApp(context));
        Log.d(TAG, "install installProcess: Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        if (PackageManagerUtils.systemApp(context)) {
            boolean zInnerInstall = innerInstall(context, managerTask);
            Log.d(TAG, "install systemApp innerResult: " + zInnerInstall);
            if (zInnerInstall) {
                return;
            }
        }
        systemInstall(context, managerTask);
    }

    private static void systemInstall(Context context, ManagerTask managerTask) {
        Log.i(TAG, " system install:" + managerTask.getPackageName());
        File file = new File(managerTask.getPath());
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            Log.e(TAG, " system install failed,file not existed filePath:");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) PackageInstallerActivity.class);
        intent.putExtra(PackageInstallerActivity.INSTALL_PATH, managerTask.getPath());
        intent.putExtra(PackageInstallerActivity.INSTALL_PACKAGENAME, managerTask.getPackageName());
        intent.putExtra(PackageInstallerActivity.INSTALL_EXISTING, false);
        intent.putExtra(PackageInstallerActivity.INSTALL_CHANGE_PATH_TIMES, 0);
        intent.setFlags(402653184);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.e(TAG, " can not start install !");
        }
    }

    private static boolean innerInstall(Context context, ManagerTask managerTask, int i10, PackageManager packageManager) throws Throwable {
        int iInstallPackage = InstallProcessSdk24.installPackage(context, managerTask.getPackageName(), managerTask.getPath());
        if (-1 == iInstallPackage) {
            Log.e(TAG, " can not inner install!pkg:");
            return true;
        }
        if (iInstallPackage == 0) {
            Log.e(TAG, "sdk24 install failed,IOExecption.");
            return false;
        }
        FastViewLogUtils.m28722d(TAG, "Other cases.");
        return false;
    }
}
