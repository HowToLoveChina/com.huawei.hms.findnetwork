package com.huawei.hiar;

import android.content.Context;
import com.huawei.hiar.annotations.UsedByNative;

@UsedByNative("HuaweiArapk.cpp")
/* loaded from: classes5.dex */
public class HuaweiArApkJniAdapter {
    private HuaweiArApkJniAdapter() {
    }

    @UsedByNative("HuaweiArapk.cpp")
    public static boolean isInstalledAndCompatible(Context context) {
        return HuaweiArApkBase.m29080a().mo29081b(context);
    }
}
