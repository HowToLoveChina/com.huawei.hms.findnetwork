package com.huawei.hms.videokit.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.utils.HMSPackageManager;

/* renamed from: com.huawei.hms.videokit.player.g */
/* loaded from: classes8.dex */
class C6558g {

    /* renamed from: a */
    private Context f30459a;

    /* renamed from: b */
    private b f30460b;

    /* renamed from: com.huawei.hms.videokit.player.g$b */
    public static class b extends BroadcastReceiver {
        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent == null) {
                    C6550c1.m37265d("PackageBroadcastReceiver", "onReceive intent is null.");
                    return;
                }
                String dataString = intent.getDataString();
                C6550c1.m37256a("PackageBroadcastReceiver", "onReceive:" + dataString + " action:" + intent.getAction());
                if (C6600t0.m37683c(dataString) || !dataString.equals(HMSPackageManager.getInstance(context).getHMSPackageName())) {
                    return;
                }
                C6550c1.m37264c("PackageBroadcastReceiver", "onReceive");
                WisePlayerFactory.m37123k();
            } catch (Exception e10) {
                C6550c1.m37258a("PackageBroadcastReceiver", "onReceive:", e10);
            }
        }
    }

    public C6558g(Context context) {
        this.f30459a = context;
    }

    /* renamed from: a */
    public void m37366a() {
        C6550c1.m37264c("PackageBroadcastReceiver", "registerReceiver");
        this.f30460b = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        this.f30459a.registerReceiver(this.f30460b, intentFilter);
    }

    /* renamed from: b */
    public void m37367b() {
        if (this.f30460b != null) {
            C6550c1.m37264c("PackageBroadcastReceiver", "unRegisterReceiver");
            this.f30459a.unregisterReceiver(this.f30460b);
            this.f30460b = null;
        }
    }
}
