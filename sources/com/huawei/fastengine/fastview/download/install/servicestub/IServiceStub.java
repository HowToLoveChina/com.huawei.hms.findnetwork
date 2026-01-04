package com.huawei.fastengine.fastview.download.install.servicestub;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import java.io.File;

/* loaded from: classes5.dex */
public interface IServiceStub {
    void changePackageStatus(int i10, String str);

    void delAppForAllUserSuccess(String str);

    int getActivityLimitMax();

    Handler getDefaultPackageHandler();

    String getDownloadStatusAction();

    String getMainActivityUrl();

    void installSuccessRefreshState(String str);

    void jumpSearchActivity(Context context);

    void jumpSearchActivity(Context context, String str);

    void jumpSearchActivity(Context context, String str, String str2);

    void jumpSearchActivity(Context context, boolean z10);

    void jumpSearchActivity(Context context, boolean z10, String str, boolean z11);

    void onAccountlogin(Context context);

    void onAccountlogout(Context context);

    void onApkFileDeleted(String str);

    Cursor queryUpdateNum(String[] strArr, String str, String[] strArr2, String str2);

    int queryUpdateNumFromDB();

    boolean renameTo(File file, File file2);

    void resetPrizeDownloadAwardNotice();

    void selfUpgradeExecption();

    void sendPackageServiceStatus(String str, int i10, int i11);

    void triggerTabChange(String str);

    void updateLaunchAppTime(String str);
}
