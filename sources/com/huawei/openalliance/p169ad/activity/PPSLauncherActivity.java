package com.huawei.openalliance.p169ad.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes8.dex */
public class PPSLauncherActivity extends AbstractActivityC6906f {
    /* renamed from: a */
    private void m38737a() {
        new C6928i(this).mo39217c(getPackageName());
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb2;
        Intent launchIntentForPackage;
        super.onCreate(bundle);
        try {
            try {
                if (m38738a(this)) {
                    AbstractC7185ho.m43820b("PPSLauncher", " app is active.");
                    launchIntentForPackage = new Intent();
                    launchIntentForPackage.setComponent(new ComponentName(getPackageName(), PPSBridgeActivity.class.getName()));
                    launchIntentForPackage.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                } else {
                    AbstractC7185ho.m43820b("PPSLauncher", " app is not active. start launch app");
                    launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                }
                startActivity(launchIntentForPackage);
                m38737a();
                try {
                    finish();
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = new StringBuilder();
                    sb2.append("finish activity error:");
                    sb2.append(th.getClass().getName());
                    AbstractC7185ho.m43820b("PPSLauncher", sb2.toString());
                }
            } catch (Exception e10) {
                AbstractC7185ho.m43820b("PPSLauncher", "intent is not supported:" + e10.getClass().getName());
                try {
                    finish();
                } catch (Throwable th3) {
                    th = th3;
                    sb2 = new StringBuilder();
                    sb2.append("finish activity error:");
                    sb2.append(th.getClass().getName());
                    AbstractC7185ho.m43820b("PPSLauncher", sb2.toString());
                }
            }
        } catch (Throwable th4) {
            try {
                finish();
            } catch (Throwable th5) {
                AbstractC7185ho.m43820b("PPSLauncher", "finish activity error:" + th5.getClass().getName());
            }
            throw th4;
        }
    }

    /* renamed from: a */
    public boolean m38738a(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
            AbstractC7185ho.m43818a("PPSLauncher", "topActivity=%s", runningTaskInfo.topActivity.getClassName());
            AbstractC7185ho.m43818a("PPSLauncher", "taskInfo.numActivities=%d", Integer.valueOf(runningTaskInfo.numActivities));
            if (runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(PPSLauncherActivity.class.getName()) && runningTaskInfo.numActivities < 2) {
                return false;
            }
            if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
