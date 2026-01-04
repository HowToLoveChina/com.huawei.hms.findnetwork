package com.huawei.fastengine.fastview.util;

import com.huawei.fastengine.internal.FastSdkLoader;

/* loaded from: classes5.dex */
public class QuickAppFrescoConfig {
    public static final String META_KEY_FEATURE = "com.huawei.fastapp.feature.level";
    private static int maxFrescoMemoryCacheSize;

    public static void clearFrescoMemoryCache() {
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader != null) {
            fastSdkLoader.clearFrescoMemoryCache();
        }
    }

    public static int getMaxFrescoMemoryCacheSize() {
        return maxFrescoMemoryCacheSize;
    }

    public static void setMaxFrescoMemoryCacheSize(int i10) {
        maxFrescoMemoryCacheSize = i10;
    }
}
