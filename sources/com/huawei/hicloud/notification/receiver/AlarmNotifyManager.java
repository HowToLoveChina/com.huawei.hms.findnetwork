package com.huawei.hicloud.notification.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.notification.log.NotifyLogger;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AlarmNotifyManager {
    private static final String COMMON_ACTION = "com.huawei.hicloud.action.COMMON_NOTIFY";
    private static final String TAG = "AlarmNotifyManager";
    private static List<CommonNotifyCallBack> callbacks = new ArrayList();

    public List<CommonNotifyCallBack> getCallbacks() {
        return callbacks;
    }

    public void registerCallback(CommonNotifyCallBack commonNotifyCallBack) {
        if (commonNotifyCallBack != null) {
            NotifyLogger.m29913d(TAG, "registerCallback = " + commonNotifyCallBack.getClass().getSimpleName());
            callbacks.add(commonNotifyCallBack);
        }
    }

    public void setAlarmForQueryV3Config(Context context, CommonNotifyCallBack commonNotifyCallBack) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        registerCallback(commonNotifyCallBack);
        NotifyLogger.m29915i(TAG, "set alarm for get pushToken");
        Intent intent = new Intent(context, (Class<?>) CommonNotifyReceiver.class);
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_QUERYCONFIG);
        intent.setAction("com.huawei.hicloud.action.COMMON_NOTIFY");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 1073741824);
        long jM62369o0 = C10028c.m62183d0(context).m62369o0();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax = jM62369o0 < jCurrentTimeMillis ? Math.max(0L, 86400000 - (jCurrentTimeMillis - jM62369o0)) : 86400000L;
        NotifyLogger.m29915i(TAG, "alarm schedule Time = " + jMax);
        alarmManager.set(0, System.currentTimeMillis() + jMax, broadcast);
    }

    public void unRegisterCallback(CommonNotifyCallBack commonNotifyCallBack) {
        if (commonNotifyCallBack != null) {
            NotifyLogger.m29913d(TAG, "unRegisterCallback = " + commonNotifyCallBack.getClass().getSimpleName());
            callbacks.remove(commonNotifyCallBack);
        }
    }
}
