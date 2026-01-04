package com.huawei.location.gwi.listener;

import android.location.Location;

/* loaded from: classes8.dex */
public interface ICarVdrLocationListener {
    void onLocationChanged(Location location);

    void onVdrError(int i10, String str);
}
