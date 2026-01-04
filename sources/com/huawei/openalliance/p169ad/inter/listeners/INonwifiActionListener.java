package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

@OuterVisible
/* loaded from: classes2.dex */
public interface INonwifiActionListener {
    @OuterVisible
    boolean onAppDownload(AppInfo appInfo, long j10);

    @OuterVisible
    boolean onVideoPlay(long j10);
}
