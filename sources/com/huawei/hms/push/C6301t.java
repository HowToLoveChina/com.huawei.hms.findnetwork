package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;
import java.net.URISyntaxException;

/* renamed from: com.huawei.hms.push.t */
/* loaded from: classes8.dex */
public class C6301t {
    /* renamed from: a */
    public static void m36601a(Context context, Intent intent) {
        try {
            if (context == null || intent == null) {
                HMSLog.m36983d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
                return;
            }
            String action = intent.getAction();
            if (!"com.huawei.intent.action.PUSH".equals(action) && !"com.huawei.push.msg.NOTIFY_MSG".equals(action) && !"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
            if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                m36604a(context, intent, byteArrayExtra, byteArrayExtra2);
                return;
            }
            HMSLog.m36988i("PushSelfShowLog", "self show info or token is null.");
        } catch (RuntimeException e10) {
            HMSLog.m36987e("PushSelfShowLog", "onReceive RuntimeException.", e10);
        } catch (Exception unused) {
            HMSLog.m36983d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    /* renamed from: a */
    private static void m36604a(Context context, Intent intent, byte[] bArr, byte[] bArr2) throws URISyntaxException {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.m36988i("PushSelfShowLog", "get notifyId:" + intExtra);
        C6296o c6296o = new C6296o(bArr, bArr2);
        if (!c6296o.m36589y()) {
            HMSLog.m36983d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.m36988i("PushSelfShowLog", "onReceive the msg id = " + c6296o.m36581o() + ",and cmd is " + c6296o.m36574h() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            m36602a(context, intent, c6296o);
        } else {
            m36603a(context, intent, stringExtra, c6296o, intExtra);
        }
    }

    /* renamed from: a */
    private static void m36602a(Context context, Intent intent, C6296o c6296o) {
        HMSLog.m36988i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + c6296o.m36574h());
        if (C6302u.m36609a(c6296o.m36574h())) {
            new C6297p(context, c6296o).start();
        }
    }

    /* renamed from: a */
    private static void m36603a(Context context, Intent intent, String str, C6296o c6296o, int i10) throws URISyntaxException {
        HMSLog.m36983d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if ("1".equals(str)) {
            new C6302u(context, c6296o).m36611c();
            PluginUtil.onNotificationClicked(context, c6296o.m36581o(), c6296o.m36568b());
        } else if ("2".equals(str)) {
            C6293l.m36536a(context, c6296o.m36581o(), c6296o.m36568b(), "2");
        } else {
            HMSLog.m36983d("PushSelfShowLog", "other event");
        }
    }
}
