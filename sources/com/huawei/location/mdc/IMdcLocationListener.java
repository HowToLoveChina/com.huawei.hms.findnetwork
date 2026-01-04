package com.huawei.location.mdc;

import android.location.Location;

/* loaded from: classes8.dex */
public interface IMdcLocationListener {
    String getUuid();

    void onMdcLocationChanged(Location location);

    void onMdcStatusChanged(boolean z10);
}
