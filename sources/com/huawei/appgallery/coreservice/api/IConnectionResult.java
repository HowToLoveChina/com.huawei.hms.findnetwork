package com.huawei.appgallery.coreservice.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

/* loaded from: classes4.dex */
public interface IConnectionResult {
    String getErrorMessage();

    PendingIntent getResolution();

    int getStatusCode();

    boolean hasResolution();

    void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException;
}
