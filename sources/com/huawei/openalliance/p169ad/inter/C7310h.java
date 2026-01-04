package com.huawei.openalliance.p169ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7759bf;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.inter.h */
/* loaded from: classes2.dex */
public class C7310h extends BroadcastReceiver {

    /* renamed from: a */
    private static volatile C7310h f33964a;

    /* renamed from: com.huawei.openalliance.ad.inter.h$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f33965a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Constants.KIT_PRELOAD_ACTION);
                if (C7310h.f33964a == null) {
                    C7310h unused = C7310h.f33964a = new C7310h();
                }
                AbstractC7741ao.m47537a(context, C7310h.f33964a, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (Constants.KIT_PRELOAD_ACTION.equalsIgnoreCase(new SafeIntent(intent).getAction())) {
                AbstractC7185ho.m43817a("KitPreloadReceiver", "onReceive kit preload");
                AbstractC7759bf.m47762a(context.getApplicationContext());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("KitPreloadReceiver", "onReceive Exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m45025a(Context context) {
        AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.inter.h.1

            /* renamed from: a */
            final /* synthetic */ Context f33965a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(Constants.KIT_PRELOAD_ACTION);
                    if (C7310h.f33964a == null) {
                        C7310h unused = C7310h.f33964a = new C7310h();
                    }
                    AbstractC7741ao.m47537a(context, C7310h.f33964a, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
                }
            }
        });
    }
}
