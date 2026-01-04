package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.C6284c;
import com.huawei.hms.push.C6290i;
import com.huawei.hms.push.C6301t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

/* loaded from: classes8.dex */
public class HmsMsgService extends Service {

    /* renamed from: com.huawei.hms.support.api.push.service.HmsMsgService$a */
    public static class HandlerC6352a extends Handler {

        /* renamed from: a */
        private Context f29878a;

        public HandlerC6352a(Context context) {
            this.f29878a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (Objects.equals(this.f29878a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f29878a).getHMSPackageName()) && data != null) {
                PackageManagerHelper.PackageStates hMSPackageStates = HMSPackageManager.getInstance(this.f29878a).getHMSPackageStates();
                PackageManagerHelper.PackageStates packageStates = PackageManagerHelper.PackageStates.ENABLED;
                if (hMSPackageStates == packageStates) {
                    if (HMSPackageManager.getInstance(this.f29878a).getHMSPackageStates() != packageStates) {
                        HMSLog.m36988i("HmsMsgService", "service not start by hms");
                    } else {
                        HMSLog.m36988i("HmsMsgService", "chose push type");
                        if (Objects.equals(C6284c.m36506b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                            if (ResourceLoaderUtil.getmContext() == null) {
                                ResourceLoaderUtil.setmContext(this.f29878a.getApplicationContext());
                            }
                            HMSLog.m36988i("HmsMsgService", "invokeSelfShow");
                            HmsMsgService.m36714c(this.f29878a, data);
                        } else if (Objects.equals(C6284c.m36506b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                            HMSLog.m36988i("HmsMsgService", "sendBroadcastToHms");
                            HmsMsgService.m36715d(this.f29878a, data);
                        }
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m36714c(Context context, Bundle bundle) {
        if (!C6290i.m36530a(context)) {
            HMSLog.m36988i("HmsMsgService", context.getPackageName() + " disable display notification.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", C6284c.m36505a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", C6284c.m36505a(bundle, "selfshow_token"));
        intent.setPackage(C6284c.m36507c(bundle, "push_package"));
        C6301t.m36601a(context, intent);
        HMSLog.m36988i("HmsMsgService", "invokeSelfShow done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m36715d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", C6284c.m36505a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, C6284c.m36505a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", C6284c.m36507c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(C6284c.m36507c(bundle, "push_package"));
            context.sendBroadcast(intent, context.getPackageName() + ".permission.PROCESS_PUSH_MSG");
            HMSLog.m36988i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.m36988i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.m36988i("HmsMsgService", "send broadcast Exception");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m36988i("HmsMsgService", "onBind");
        return new Messenger(new HandlerC6352a(this)).getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        HMSLog.m36988i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
