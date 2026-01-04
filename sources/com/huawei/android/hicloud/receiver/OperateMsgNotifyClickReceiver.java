package com.huawei.android.hicloud.receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.huawei.hicloud.base.common.CommonBaseBroadcastReceiver;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.sync.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class OperateMsgNotifyClickReceiver extends CommonBaseBroadcastReceiver {
    /* renamed from: c */
    public final void m17076c(Context context, String str) {
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.setData(uri);
        if (!MessageCenterManager.getInstance().checkIntentAvailable(intent)) {
            Toast.makeText(context, context.getString(R$string.no_app_toast), 0).show();
            NotifyLogger.m29914e("OperateMsgNotifyClickReceiver", "gotoKa error, resolve intent fail");
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            NotifyLogger.m29914e("OperateMsgNotifyClickReceiver", "gotoKa start activity error: " + e10.toString());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70687e("OperateMsgNotifyClickReceiver", "intent or context is empty");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if ("com.huawei.cloud.OPERATE_MSG_CILCK_NOTIFICATION".equals(safeIntent.getAction())) {
            String stringExtra = safeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_TYPE);
            String stringExtra2 = safeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_URI);
            if (NotifyConstants.HICLOUD_KA.equals(stringExtra)) {
                m17076c(context, stringExtra2);
            }
        }
    }
}
