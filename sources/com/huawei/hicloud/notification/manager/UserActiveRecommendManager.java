package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.task.ActiveRecommendCheckTask;
import com.huawei.hicloud.notification.task.ActiveRecommendTimer;
import com.huawei.hicloud.notification.util.IStockActiveInvoker;
import java.util.LinkedHashMap;
import p616rk.C12515a;
import vn.C13469a;

/* loaded from: classes6.dex */
public class UserActiveRecommendManager {
    private static final String TAG = "UserActiveRecommendManager";
    private IStockActiveInvoker activeInvoker;

    public static class Holder {
        private static UserActiveRecommendManager instance = new UserActiveRecommendManager();

        private Holder() {
        }
    }

    public static UserActiveRecommendManager getInstance() {
        return Holder.instance;
    }

    public void activeCloud(String str) {
        NotifyLogger.m29915i(TAG, "activeCloud");
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else {
            iStockActiveInvoker.activeCloud(str);
        }
    }

    public void clearNotification() {
        NotifyLogger.m29915i(TAG, "activeCloud");
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else {
            iStockActiveInvoker.clearNotification();
        }
    }

    public void finishActivity() {
        NotifyLogger.m29915i(TAG, "finishActivity");
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else {
            iStockActiveInvoker.finishActivity();
        }
    }

    public IStockActiveInvoker getActiveInvoker() {
        return this.activeInvoker;
    }

    public void recommend() {
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else if (!iStockActiveInvoker.canNotify(0)) {
            NotifyLogger.m29915i(TAG, "not satisfy reminder condition");
        } else {
            C12515a.m75110o().m75172d(new ActiveRecommendCheckTask());
        }
    }

    public void report(String str) {
        C13469a.m81112f().m81113a(str, new LinkedHashMap<>());
        C13469a.m81112f().m81114b("PVC", str, "1", "49", new LinkedHashMap<>());
    }

    public void sendNotification() {
        NotifyLogger.m29915i(TAG, "sendNotification");
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else {
            iStockActiveInvoker.trySendNotification();
        }
    }

    public void setActiveInvoker(IStockActiveInvoker iStockActiveInvoker) {
        this.activeInvoker = iStockActiveInvoker;
    }

    public void showDialog() {
        NotifyLogger.m29915i(TAG, "showDialog");
        IStockActiveInvoker iStockActiveInvoker = this.activeInvoker;
        if (iStockActiveInvoker == null) {
            NotifyLogger.m29914e(TAG, "activeInvoker is null");
        } else {
            iStockActiveInvoker.tryShowPopup();
        }
    }

    public void startHomeCheck() {
        NotifyLogger.m29915i(TAG, "start home check");
        new ActiveRecommendTimer().execute();
    }

    private UserActiveRecommendManager() {
    }
}
