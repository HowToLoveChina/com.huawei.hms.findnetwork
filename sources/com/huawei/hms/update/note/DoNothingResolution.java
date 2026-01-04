package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class DoNothingResolution implements IBridgeActivityDelegate {
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("DoNothingResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
        } else {
            activity.setResult(30);
            activity.finish();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution onBridgeActivityDestroy>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution onBridgeConfigurationChanged>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("DoNothingResolution", "<DoNothingResolution onKeyUp>");
    }
}
