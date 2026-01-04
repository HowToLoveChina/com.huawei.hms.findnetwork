package com.huawei.android.hicloud.drive.clouddisk.expand;

import android.content.Context;
import android.os.Environment;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public abstract class MediaBase {
    public static final String SERVICE_DIR = ".core_syncDrv";
    private static final String TAG = "MediaBase";

    private File getRootCacheDir() {
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? getContext().getExternalFilesDir("") : getContext().getFilesDir();
    }

    public File getBaseCacheDir() {
        File fileM63441g = C10278a.m63441g(getRootCacheDir(), SERVICE_DIR);
        if (!fileM63441g.exists() && fileM63441g.mkdirs()) {
            C11839m.m70688i(TAG, "external parent create success.");
        }
        return fileM63441g;
    }

    public Context getContext() {
        return C0213f.m1377a();
    }
}
