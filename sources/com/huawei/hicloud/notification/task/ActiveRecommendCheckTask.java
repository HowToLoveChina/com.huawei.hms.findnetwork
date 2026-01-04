package com.huawei.hicloud.notification.task;

import android.content.Context;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import p015ak.C0209d;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class ActiveRecommendCheckTask extends AbstractC12367d {
    private static final String TAG = "ActiveRecommendCheckTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "ActiveRecommendCheckTask context null");
            return;
        }
        if (!C0209d.m1194N1(contextM1377a) || !C0209d.m1246d2(contextM1377a)) {
            NotifyLogger.m29915i(TAG, "screen off");
            UserActiveRecommendManager.getInstance().sendNotification();
            UserActiveRecommendManager.getInstance().startHomeCheck();
        } else if (C0209d.m1265i1(contextM1377a)) {
            NotifyLogger.m29915i(TAG, "in home");
            UserActiveRecommendManager.getInstance().showDialog();
        } else {
            NotifyLogger.m29915i(TAG, "not in home");
            UserActiveRecommendManager.getInstance().startHomeCheck();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.STOCK_ACTIVE;
    }
}
