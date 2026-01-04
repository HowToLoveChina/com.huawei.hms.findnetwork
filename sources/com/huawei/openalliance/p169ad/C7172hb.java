package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;

/* renamed from: com.huawei.openalliance.ad.hb */
/* loaded from: classes8.dex */
public class C7172hb {

    /* renamed from: a */
    private static final byte[] f33012a = new byte[0];

    /* renamed from: b */
    private static C7172hb f33013b;

    /* renamed from: c */
    private Context f33014c;

    /* renamed from: d */
    private BroadcastReceiver f33015d;

    /* renamed from: com.huawei.openalliance.ad.hb$a */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("com.huawei.hms.pps.action.LINKED_AD_STATUS_CHANGED".equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra("linked_ad_played_in_linked", false);
                    int intExtra = intent.getIntExtra("linked_ad_play_progress", 0);
                    AbstractC7185ho.m43820b("LinkedAdStatusHandler", "LinkedAdBroadcastReceiver playProgress " + intExtra);
                    C7169gz c7169gz = new C7169gz();
                    c7169gz.m43661b(booleanExtra);
                    c7169gz.m43652a(intExtra);
                    C7171ha.m43673a(c7169gz);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("LinkedAdStatusHandler", "LinkedAdBroadcastReceiver error: %s", th2.getClass().getSimpleName());
            }
        }
    }

    private C7172hb(Context context) {
        if (context != null) {
            this.f33014c = context.getApplicationContext();
        }
    }

    /* renamed from: b */
    private static synchronized C7172hb m43679b(Context context) {
        C7172hb c7172hb;
        synchronized (f33012a) {
            try {
                if (f33013b == null) {
                    f33013b = new C7172hb(context);
                }
                c7172hb = f33013b;
            } finally {
            }
        }
        return c7172hb;
    }

    /* renamed from: a */
    public static C7172hb m43677a(Context context) {
        return m43679b(context);
    }

    /* renamed from: b */
    public void m43682b() {
        if (this.f33015d != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.hb.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC7185ho.m43820b("LinkedAdStatusHandler", "unregisterPpsReceiver");
                        C7172hb.this.f33014c.unregisterReceiver(C7172hb.this.f33015d);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m43680a() {
        m43681a(new a());
    }

    /* renamed from: a */
    public void m43681a(final BroadcastReceiver broadcastReceiver) {
        AbstractC7185ho.m43817a("LinkedAdStatusHandler", "registerPpsReceiver ");
        if (this.f33015d != null) {
            m43682b();
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.hb.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.LINKED_AD_STATUS_CHANGED");
                intentFilter.addAction("com.huawei.hms.pps.action.AD_DETAIL_CLOSED");
                C7172hb.this.f33015d = broadcastReceiver;
                AbstractC7741ao.m47537a(C7172hb.this.f33014c, C7172hb.this.f33015d, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
                AbstractC7185ho.m43820b("LinkedAdStatusHandler", "registerPpsReceiver");
            }
        });
    }
}
