package com.huawei.android.remotecontrol.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import bf.C1175a;
import com.huawei.android.remotecontrol.track.C4443e;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import org.json.JSONException;
import p015ak.C0209d;
import p394jf.AbstractC10816d;
import p394jf.C10813a;
import p394jf.C10814b;
import p394jf.C10818f;
import p521og.C11877j;
import p638sf.C12795b;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class UnlockScreenReceiverBroadcast extends BroadcastReceiver {

    public static class HandleResponseCallback implements Handler.Callback {

        /* renamed from: a */
        public final Context f19852a;

        public HandleResponseCallback(Context context) {
            this.f19852a = context;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            C10813a.m65855g(message, this.f19852a);
            return true;
        }
    }

    /* renamed from: a */
    public static void m26253a(Context context, boolean z10) {
        if (!C0209d.m1203Q1(context)) {
            C13981a.m83990w("UnlockScreenReceiver", "lostMode in StartUp, return");
            return;
        }
        if (!C1175a.m7389k(context)) {
            C10818f.m65874a().m65879f(context, false);
            C10818f.m65874a().m65880g(false);
            return;
        }
        if (!C11877j.m71236U(context)) {
            C10818f.m65874a().m65879f(context, false);
            C10818f.m65874a().m65880g(false);
            return;
        }
        C10818f.m65874a().m65880g(true);
        if (z10) {
            C10814b.m65858a().m65861d(context);
        }
        AbstractC10816d.m65869e(context, false);
        AbstractC10816d.m65870f(context, "");
        new C10813a(context, new HandleResponseCallback(context)).m65856d();
        C4443e.m26985i(context);
        C12795b.m76765a(context);
        C13981a.m83989i("UnlockScreenReceiver", "send remote lock changed broadcast");
        context.sendBroadcast(new Intent("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED"), "com.huawei.remotocontrol.permission.REMOTECALL");
        C11877j.m71203D0(context, false);
        C11877j.m71201C0(context, -1);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C13981a.m83988e("UnlockScreenReceiver", " onReceive intent is null");
            return;
        }
        String action = new HiCloudSafeIntent(intent).getAction();
        if (action == null) {
            C13981a.m83988e("UnlockScreenReceiver", " onReceive action is null");
        } else if (!"android.intent.action.USER_PRESENT".equals(action)) {
            C13981a.m83989i("UnlockScreenReceiver", "UnlockScreenReceiver onReceive action else");
        } else {
            C13981a.m83989i("UnlockScreenReceiver", "UnlockScreenReceiver onReceive action:android.intent.action.USER_PRESENT");
            m26253a(context, false);
        }
    }
}
