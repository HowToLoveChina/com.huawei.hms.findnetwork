package com.huawei.android.hicloud.common;

import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.TileService;
import com.huawei.android.hicloud.p088ui.activity.NewHiSyncSettingActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0216g0;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class QuickSettingService extends TileService {
    @Override // android.service.quicksettings.TileService, android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            C11839m.m70688i("QuickSettingService", "quick setting onBind.");
            return super.onBind(intent);
        } catch (Exception e10) {
            C11839m.m70687e("QuickSettingService", "quick setting onBind error: " + e10.getMessage());
            return null;
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        C11839m.m70688i("QuickSettingService", "quick setting start hidisk.");
        try {
            Intent intent = new Intent();
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setClass(this, NewHiSyncSettingActivity.class);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.setAction("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE");
            C0216g0.m1402e(this).m1406D(intent, "SOURCE_OTHER_APP", "SOURCE_ID_QUICK_SETTING");
            startActivityAndCollapse(intent);
        } catch (Exception e10) {
            C11839m.m70688i("QuickSettingService", "quick setting error: " + e10.toString());
        }
    }
}
