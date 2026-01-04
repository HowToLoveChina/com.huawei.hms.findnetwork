package com.huawei.hicloud.notification.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public class CommonNotifyReceiver extends BroadcastReceiver {
    public static final String COMMAND_CANCAL = "notify_cancel";
    public static final String COMMAND_KEY = "command";
    public static final String COMMAND_QUERYCONFIG = "query_config";
    public static final String COMMON_ACTION = "com.huawei.hicloud.action.COMMON_NOTIFY";
    public static final String TAG = "CommonNotifyReceiver";

    private void notifyCallback(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        AlarmNotifyManager alarmNotifyManager = new AlarmNotifyManager();
        for (CommonNotifyCallBack commonNotifyCallBack : alarmNotifyManager.getCallbacks()) {
            if (commonNotifyCallBack.onReciveNotify(context, hiCloudSafeIntent)) {
                alarmNotifyManager.unRegisterCallback(commonNotifyCallBack);
            }
        }
    }

    private void notifyGalleryNoticeClicked(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context != null) {
            Bundle extras = hiCloudSafeIntent.getExtras();
            Intent intent = new Intent(NotifyConstants.Report.ACTION_GALLERY_NOTICE_CLICK);
            if (extras != null) {
                intent.putExtras(extras);
            }
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    private void notifyOpenFrontAppClicked(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context != null) {
            Bundle extras = hiCloudSafeIntent.getExtras();
            Intent intent = new Intent("com.huawei.hicloud.intent.action.ACTION_FRONT_APP_OPEN");
            if (extras != null) {
                intent.putExtras(extras);
            }
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    private void notifyOpenFrontDoubleAppClicked(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context != null) {
            Bundle extras = hiCloudSafeIntent.getExtras();
            Intent intent = new Intent("com.huawei.cloud.FRONT_APP_CILCK_NOTIFICATION");
            if (extras != null) {
                intent.putExtras(extras);
            }
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    private void notifyOperateMsgNoticeClicked(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context != null) {
            MessageCenterManager.getInstance().processNotifyClickEvent(hiCloudSafeIntent);
            String stringExtra = hiCloudSafeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_TYPE);
            String stringExtra2 = hiCloudSafeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_URI);
            Intent intent = new Intent("com.huawei.cloud.OPERATE_MSG_CILCK_NOTIFICATION");
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, stringExtra);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, stringExtra2);
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    private void notifySiteChangedLaterClicked(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context != null) {
            Bundle extras = hiCloudSafeIntent.getExtras();
            Intent intent = new Intent(NotifyConstants.Report.ACTION_SITE_CHANGE_LATER_NOTICE_CLICK);
            if (extras != null) {
                intent.putExtras(extras);
            }
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (COMMON_ACTION.equals(hiCloudSafeIntent.getAction())) {
            int intExtra = hiCloudSafeIntent.getIntExtra("requestId", 0);
            if (intExtra == 10002) {
                NotifyLogger.m29915i(TAG, "receive Gallery Notice click broadcast");
                notifyGalleryNoticeClicked(context, hiCloudSafeIntent);
                return;
            }
            if (intExtra == 10003) {
                NotifyLogger.m29915i(TAG, "receive site change later click broadcast");
                notifySiteChangedLaterClicked(context, hiCloudSafeIntent);
                return;
            }
            if (intExtra == 10004) {
                NotifyLogger.m29915i(TAG, "receive front app open Notice click broadcast");
                notifyOpenFrontAppClicked(context, hiCloudSafeIntent);
            } else if (intExtra == 10006) {
                NotifyLogger.m29915i(TAG, "receive double front app open Notice click broadcast");
                notifyOpenFrontDoubleAppClicked(context, hiCloudSafeIntent);
            } else if (intExtra != 10005) {
                notifyCallback(context, hiCloudSafeIntent);
            } else {
                NotifyLogger.m29915i(TAG, "receive operate msg open Notice click broadcast");
                notifyOperateMsgNoticeClicked(context, hiCloudSafeIntent);
            }
        }
    }
}
