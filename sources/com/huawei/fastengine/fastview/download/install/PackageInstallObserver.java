package com.huawei.fastengine.fastview.download.install;

import android.content.p017pm.IPackageInstallObserver;
import android.os.RemoteException;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class PackageInstallObserver extends IPackageInstallObserver.Stub {
    private static final String TAG = "PackageInstallObserver";
    private ManagerTask task;

    public PackageInstallObserver(ManagerTask managerTask) {
        this.task = managerTask;
    }

    @Override // android.content.p017pm.IPackageInstallObserver
    public void packageInstalled(String str, int i10) throws RemoteException {
        FastViewLogUtils.m28726i(PackageManagerConstants.TAG, "PackageInstallObserver installPkg:" + this.task.getPackageName() + " package install callback:packageName:" + str + ",returnCode:" + i10 + ",changePath:false");
    }
}
