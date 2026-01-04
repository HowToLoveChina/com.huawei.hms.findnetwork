package com.huawei.android.p069cg.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p015ak.C0209d;
import p031b7.C1120a;
import p546p6.C12096i;
import p546p6.C12097j;
import p568q6.C12288a;

/* loaded from: classes2.dex */
public class DownloadingNotifyClickReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        if (intent == null) {
            C1120a.m6678w("DownloadingNotifyClickReceiver", "intent is null.");
            return;
        }
        if (TextUtils.isEmpty(new HiCloudSafeIntent(intent).getAction())) {
            C1120a.m6678w("DownloadingNotifyClickReceiver", "action is null");
            return;
        }
        if (intent.getAction().equals("com.huawei.android.cg.notification.gallerydownloadnotification.cancel")) {
            C12096i.m72418I().m72464n();
            C12288a.m73827d().m73830c();
            return;
        }
        if (intent.getAction().equals("com.huawei.android.cg.notification.gallerydownloadnotification.pause")) {
            if (C0209d.m1226Y0()) {
                C1120a.m6678w("DownloadingNotifyClickReceiver", "click OPERATION_PAUSE_CODE too fast");
                return;
            } else if (!C0209d.m1208S0(context)) {
                C12097j.m72480b().m72489j();
                return;
            } else {
                C12096i.m72418I().m72452V();
                C12288a.m73827d().m73835i();
                return;
            }
        }
        if (intent.getAction().equals("com.huawei.android.cg.notification.gallerydownloadnotification.continue")) {
            if (C0209d.m1226Y0()) {
                C1120a.m6678w("DownloadingNotifyClickReceiver", "click OPERATION_CONTINUE_CODE too fast");
            } else if (!C0209d.m1208S0(context)) {
                C12097j.m72480b().m72489j();
            } else {
                C12096i.m72418I().m72457a0();
                C12288a.m73827d().m73834h();
            }
        }
    }
}
