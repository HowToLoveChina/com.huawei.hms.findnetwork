package com.huawei.hms.ads.identifier;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.hms.ads.identifier.d */
/* loaded from: classes8.dex */
public class C5070d extends BroadcastReceiver {

    /* renamed from: a */
    private static volatile C5070d f23194a;

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public static void m30260a(Context context) {
        if (context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.opendevice.open.action.REAL_OAID_RESET");
        if (f23194a == null) {
            f23194a = new C5070d();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(f23194a, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null, 2);
        } else {
            context.registerReceiver(f23194a, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
        }
    }

    /* renamed from: b */
    public static void m30261b(Context context) {
        try {
            if (f23194a != null) {
                Log.i("OaidChangedReceiver", "unregister receiver");
                context.unregisterReceiver(f23194a);
                f23194a = null;
            }
        } catch (Throwable unused) {
            Log.w("OaidChangedReceiver", "unregisterReceiver exception");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !"com.huawei.opendevice.open.action.REAL_OAID_RESET".equals(intent.getAction())) {
            return;
        }
        AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.d.1
            @Override // java.lang.Runnable
            public void run() {
                Log.d("OaidChangedReceiver", "receive oaid reset broadcast");
                final Context context2 = AdsIdentifierSdk.getContext();
                if (context2 == null) {
                    Log.w("OaidChangedReceiver", "context is null");
                } else {
                    C5069c.m30252a(context2, new InterfaceC5071e() { // from class: com.huawei.hms.ads.identifier.d.1.1
                        @Override // com.huawei.hms.ads.identifier.InterfaceC5071e
                        /* renamed from: a */
                        public void mo30262a() {
                            try {
                                Intent intent2 = new Intent("com.huawei.opendevice.open.action.OAID_RESET");
                                intent2.setPackage(C5072f.m30263a(context2));
                                context2.sendBroadcast(intent2, "com.huawei.hms.permission.signatureOrSystem");
                            } catch (Throwable unused) {
                                Log.w("OaidChangedReceiver", "send broCast fail");
                            }
                        }
                    });
                }
            }
        });
    }
}
