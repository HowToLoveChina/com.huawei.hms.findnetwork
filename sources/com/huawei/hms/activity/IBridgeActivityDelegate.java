package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* loaded from: classes8.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i10, int i11, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i10, KeyEvent keyEvent);
}
