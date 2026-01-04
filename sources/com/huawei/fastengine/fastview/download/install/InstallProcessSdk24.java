package com.huawei.fastengine.fastview.download.install;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class InstallProcessSdk24 {
    public static final int INSTALL_FAILED = 0;
    public static final int NO_SUPPORT = -1;
    public static final int SUPPORT = 1;
    private static final String TAG = "InstallProcessSdk24";
    private static int hiappUid = -1;

    private static void closeIO(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                FastViewLogUtils.m28724e(TAG, e10.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                FastViewLogUtils.m28724e(TAG, e11.toString());
            }
        }
    }

    public static int getApplicationUid(Context context) {
        if (hiappUid == -1) {
            try {
                hiappUid = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).uid;
            } catch (Exception unused) {
                Log.e(TAG, "can not get uid NameNotFoundException");
            }
        }
        return hiappUid;
    }

    public static Intent getNomalInstallIntent(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        if (!(context instanceof Activity)) {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        intent.addFlags(1);
        try {
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fastapp.engine.fileProvider", new File(str)), "application/vnd.android.package-archive");
        } catch (IllegalArgumentException e10) {
            FastViewLogUtils.m28724e(TAG, e10.toString());
        }
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e8  */
    @android.annotation.TargetApi(24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int installPackage(android.content.Context r17, java.lang.String r18, java.lang.String r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.fastengine.fastview.download.install.InstallProcessSdk24.installPackage(android.content.Context, java.lang.String, java.lang.String):int");
    }
}
