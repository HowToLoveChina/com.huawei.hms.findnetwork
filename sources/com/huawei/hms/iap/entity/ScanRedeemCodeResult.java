package com.huawei.hms.iap.entity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class ScanRedeemCodeResult extends Result {
    private static final String TAG = "ScanRedeemCodeResult";
    private Intent mIntent;

    public ScanRedeemCodeResult(Intent intent) {
        this.mIntent = intent;
    }

    public void startActivityForResult(Activity activity, int i10) {
        if (activity == null) {
            HMSLog.m36986e(TAG, "startActivityForResult but activity is null");
            return;
        }
        try {
            activity.startActivityForResult(this.mIntent, i10);
        } catch (ActivityNotFoundException unused) {
            HMSLog.m36986e(TAG, "startActivityForResult occur ActivityNotFoundException");
        }
    }
}
