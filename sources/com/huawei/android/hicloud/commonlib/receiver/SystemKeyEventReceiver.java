package com.huawei.android.hicloud.commonlib.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class SystemKeyEventReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public boolean f12044a = false;

    /* renamed from: b */
    public String f12045b;

    public SystemKeyEventReceiver(String str) {
        this.f12045b = str;
    }

    /* renamed from: a */
    public final void m15907a(Context context, IntentFilter intentFilter) {
        if (this.f12044a) {
            return;
        }
        this.f12044a = true;
        context.registerReceiver(this, intentFilter);
    }

    /* renamed from: b */
    public final void m15908b() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("extra_current_activity", this.f12045b);
        C13230i.m79504I().m79567R("event_click_home", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_click_home", "1", "100", linkedHashMapM79497A);
    }

    /* renamed from: c */
    public final void m15909c(Context context) {
        if (this.f12044a) {
            this.f12044a = false;
            context.unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70687e("SystemKeyEventReceiver", "intent or context is empty");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(safeIntent.getAction())) {
            String stringExtra = safeIntent.getStringExtra("reason");
            if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                C11839m.m70686d("SystemKeyEventReceiver", "SystemKeyEventReceiver, receive event, reason: " + stringExtra + ", current activity: " + this.f12045b);
                m15908b();
            }
        }
    }
}
