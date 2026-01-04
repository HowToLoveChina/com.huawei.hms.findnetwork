package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import gp.C10028c;
import java.text.ParseException;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p459lp.C11326d;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class UnReadNumManager {
    public static final int SPACE_EXPERIENCE_NO_RED_POINT = 0;
    public static final int SPACE_EXPERIENCE_RED_POINT = 1;
    private static final String TAG = "UnReadNumManager";

    public static class BgTask extends AbstractC12367d {
        private BgTask() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            if (UnReadNumManager.needAvoidByLocal()) {
                NotifyLogger.m29915i(UnReadNumManager.TAG, "needAvoidByLocal, not query");
            } else {
                UnReadNumManager.avoidSurge();
                UnReadNumManager.getInstance().refreshSnsNumBg();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SNS_MSG_NUM;
        }
    }

    public static class Holder {
        private static UnReadNumManager instance = new UnReadNumManager();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void avoidSurge() throws InterruptedException {
        int iNextInt = new Random().nextInt(300);
        NotifyLogger.m29915i(TAG, "checkDelay delay: " + iNextInt);
        if (iNextInt > 0) {
            try {
                Thread.sleep(iNextInt * 1000);
            } catch (InterruptedException unused) {
                AbstractC10896a.m65886e(TAG, "checkDelay InterruptedException");
            }
        }
    }

    public static UnReadNumManager getInstance() {
        return Holder.instance;
    }

    public static boolean needAvoidByLocal() throws ParseException {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            NotifyLogger.m29915i(TAG, "hiCloudSysParamMap is null, no need delay");
            return false;
        }
        String snsSuppressStartTimeList = hiCloudSysParamMapM60758q.getSnsSuppressStartTimeList();
        String snsSuppressEndTimeList = hiCloudSysParamMapM60758q.getSnsSuppressEndTimeList();
        if (TextUtils.isEmpty(snsSuppressStartTimeList) || TextUtils.isEmpty(snsSuppressEndTimeList)) {
            NotifyLogger.m29915i(TAG, "suppressTimeList is null, no need delay");
            return false;
        }
        try {
            boolean zM1289o1 = C0209d.m1289o1(C11326d.m68051m(new JSONArray(snsSuppressStartTimeList)), C11326d.m68051m(new JSONArray(snsSuppressEndTimeList)));
            NotifyLogger.m29914e(TAG, "isInDelayTime: " + zM1289o1);
            return zM1289o1;
        } catch (JSONException e10) {
            NotifyLogger.m29914e(TAG, "needDelay catch exception: " + e10.toString());
            return false;
        }
    }

    public void executeSnsNumTask() {
        if (!C13452e.m80781L().m80842P0()) {
            NotifyLogger.m29915i(TAG, "executeSnsNumTask not login");
        } else if (HiCLoudStockActiveManager.getInstance().isActiveCloudAuto()) {
            NotifyLogger.m29915i(TAG, "auto active");
        } else {
            C12515a.m75110o().m75175e(new BgTask(), true);
        }
    }

    public long getLastTime() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C10028c.m62183d0(contextM1377a).m62399u0();
        }
        NotifyLogger.m29914e(TAG, "getLastTime context null");
        return 0L;
    }

    public void refreshLauncherIcon(int i10) {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "refreshLauncherIcon context null");
                return;
            }
            if (C0209d.m1173G1(contextM1377a)) {
                NotifyLogger.m29914e(TAG, "isPrivacyUser, can not show red dot");
                i10 = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", "com.huawei.hidisk");
            bundle.putString("class", "com.huawei.android.hicloud.ui.activity.NewHiSyncSettingAliasActivity");
            bundle.putInt("badgenumber", i10);
            contextM1377a.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "refreshLauncherIcon exception:" + e10.toString());
        }
    }

    public void refreshLauncherIconInTask(final int i10) {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.manager.UnReadNumManager.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                UnReadNumManager.getInstance().refreshLauncherIcon(i10);
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public AbstractRunnableC12516b.a getEnum() {
                return AbstractRunnableC12516b.a.SNS_MSG_NUM;
            }
        }, false);
    }

    public void refreshSnsNumBg() {
        if (C0213f.m1377a() == null) {
            NotifyLogger.m29914e(TAG, "refreshLauncherIcon context null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - getLastTime();
        NotifyLogger.m29915i(TAG, "refreshSnsNumBg  gap=" + jCurrentTimeMillis);
        if (jCurrentTimeMillis <= 1800000) {
            NotifyLogger.m29915i(TAG, "refreshSnsNumBg time limit");
            return;
        }
        getInstance().refreshLauncherIcon(MessageCenterManager.getInstance().getBadgeCount());
        setLastTime(System.currentTimeMillis());
    }

    public void setLastTime(long j10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "setLastTime context null");
        } else {
            C10028c.m62183d0(contextM1377a).m62347j3(j10);
        }
    }

    private UnReadNumManager() {
    }

    public void refreshLauncherIconInTask() {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.manager.UnReadNumManager.2
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                UnReadNumManager.getInstance().refreshLauncherIcon(MessageCenterManager.getInstance().getBadgeCount());
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public AbstractRunnableC12516b.a getEnum() {
                return AbstractRunnableC12516b.a.SNS_MSG_NUM;
            }
        }, false);
    }
}
