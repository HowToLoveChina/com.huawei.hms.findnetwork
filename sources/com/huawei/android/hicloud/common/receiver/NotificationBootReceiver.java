package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.HNConstants;
import p034bc.C1163c;
import p037bp.C1270a;
import p232dp.InterfaceC9287f;
import p336he.C10155f;
import p514o9.C11839m;
import p572qb.C12314i0;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class NotificationBootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        C11839m.m70688i("NotificationBootReceiver", "NotificationBootReceiver onReceive : " + action);
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            C10155f.m63276b(context);
            C1163c.m7262a(context);
            if (C13452e.m80781L().m80842P0()) {
                HiCloudNotification.getInstance().execute(HNConstants.NotifyType.SCENE_BOOT);
            } else {
                C11839m.m70688i("NotificationBootReceiver", "not login, not check notify");
            }
            InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
            if (interfaceC9287f != null) {
                interfaceC9287f.mo58579v(context.getApplicationContext());
            }
            C12314i0.m74036h().activeCloud("");
        }
    }
}
