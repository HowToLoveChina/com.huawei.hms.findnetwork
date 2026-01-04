package com.huawei.hicloud.notification.util;

import com.huawei.hicloud.notification.log.NotifyLogger;
import gp.C10028c;
import java.lang.Throwable;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public abstract class AbstractCheckAppStatus<T extends Throwable> {
    private static final String TAG = "CheckAppStatus";

    public static boolean isAppStatusAbnormal() {
        return (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) || C13452e.m80781L().m80927i1() || C13452e.m80781L().m80917g1() || C13452e.m80781L().m80912f1();
    }

    public void checkAll() throws Throwable {
        if (C13452e.m80781L().m80912f1()) {
            NotifyLogger.m29914e(TAG, "site not match");
            onSiteNotMatch();
            return;
        }
        if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
            NotifyLogger.m29914e(TAG, "forced upgrade");
            onForcedUpgrade();
        } else if (C13452e.m80781L().m80927i1()) {
            NotifyLogger.m29914e(TAG, "sync risk effective");
            onSyncRiskEffective();
        } else if (C13452e.m80781L().m80917g1()) {
            NotifyLogger.m29914e(TAG, "st invalid by server");
            onStInvalidByServer();
        }
    }

    public void checkAllSendToFile() throws Throwable {
        checkAllSendToFileWithAvoid(true, true, true, true);
    }

    public void checkAllSendToFileWithAvoid(boolean... zArr) throws Throwable {
        if (zArr.length != 4) {
            NotifyLogger.m29914e(TAG, "checkAllSendToFileWithAvoid err.");
            return;
        }
        if (C13452e.m80781L().m80912f1() && zArr[0]) {
            NotifyLogger.m29914e(TAG, "site not match");
            C13452e.m80781L().m80980v1();
            onSiteNotMatch();
            return;
        }
        if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1() && zArr[1]) {
            NotifyLogger.m29914e(TAG, "forced upgrade");
            C13452e.m80781L().m80980v1();
            onForcedUpgrade();
        } else if (C13452e.m80781L().m80927i1() && zArr[2]) {
            NotifyLogger.m29914e(TAG, "sync risk effective");
            C13452e.m80781L().m80984w1(true);
            onSyncRiskEffective();
        } else if (C13452e.m80781L().m80917g1() && zArr[3]) {
            NotifyLogger.m29914e(TAG, "st invalid by server");
            C13452e.m80781L().m80980v1();
            onStInvalidByServer();
        }
    }

    public void checkSiteNotMatch() throws Throwable {
        if (C13452e.m80781L().m80912f1()) {
            NotifyLogger.m29914e(TAG, "site not match");
            onSiteNotMatch();
        }
    }

    public void checkStInvalidByServer() throws Throwable {
        if (C13452e.m80781L().m80917g1()) {
            NotifyLogger.m29914e(TAG, "st invalid by server");
            onStInvalidByServer();
        }
    }

    public void checkSyncRisk() throws Throwable {
        if (C13452e.m80781L().m80927i1()) {
            NotifyLogger.m29914e(TAG, "sync risk effective");
            onSyncRiskEffective();
        }
    }

    public void checkUpgrade() throws Throwable {
        if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
            NotifyLogger.m29914e(TAG, "forced upgrade");
            onForcedUpgrade();
        }
    }

    public abstract void onForcedUpgrade() throws Throwable;

    public abstract void onSiteNotMatch() throws Throwable;

    public abstract void onStInvalidByServer() throws Throwable;

    public abstract void onSyncRiskEffective() throws Throwable;
}
