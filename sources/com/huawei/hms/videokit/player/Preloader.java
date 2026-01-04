package com.huawei.hms.videokit.player;

import com.huawei.hms.videokit.player.bean.Proxy;

/* loaded from: classes8.dex */
public interface Preloader {
    int addCache(CacheInfo cacheInfo);

    int addCache(CacheInfo cacheInfo, int i10);

    int initCache(String str, int i10);

    int pauseAllTasks();

    int removeAllCache();

    int removeAllTasks();

    int resumeAllTasks();

    void setProxy(Proxy proxy);
}
