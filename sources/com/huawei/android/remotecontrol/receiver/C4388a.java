package com.huawei.android.remotecontrol.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.reflect.InvocationTargetException;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11875h;
import p521og.C11877j;
import p575qe.C12347f;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: com.huawei.android.remotecontrol.receiver.a */
/* loaded from: classes4.dex */
public class C4388a {

    /* renamed from: b */
    public static final C4388a f20064b = new C4388a();

    /* renamed from: a */
    public b f20065a = new b();

    /* renamed from: com.huawei.android.remotecontrol.receiver.a$b */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            String action;
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (context.getPackageName().equals(C4452n.m27023c(context)) && (action = hiCloudSafeIntent.getAction()) != null) {
                C13981a.m83989i("PhoneFinderOffReceiver", "PhoneFinderOffReceiver action = " + action);
                if ("com.huawei.remotecontrol.OFF_REMOTE".equals(action)) {
                    if (C11866p.m71106e()) {
                        C13981a.m83988e("PhoneFinderOffReceiver", "current device active");
                        C11860j.m71002J0("receiver unlock push", "QueryActiveStatus", action, "");
                        return;
                    }
                    C4388a.this.m26500d();
                    C1175a.m7398t(false, context);
                    C11875h.m71193d(context);
                    C12347f.m74285n().m74300l(context);
                    C13108a.m78878b(context).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL"));
                    C11860j.m71008M0(false, false);
                    return;
                }
                if ("com.huawei.remotecontrol.WRITEFRPINFO".equals(action)) {
                    if (hiCloudSafeIntent.getStringExtra("message") == null) {
                        C13981a.m83988e("PhoneFinderOffReceiver", " message is null");
                        return;
                    }
                    String stringExtra = hiCloudSafeIntent.getStringExtra("message");
                    String stringExtra2 = hiCloudSafeIntent.getStringExtra("cmd");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        AbstractC12139d.m72775n(context, stringExtra);
                    } else {
                        AbstractC12139d.m72774m(context, stringExtra, stringExtra2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static C4388a m26498b() {
        return f20064b;
    }

    /* renamed from: c */
    public void m26499c(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.remotecontrol.OFF_REMOTE");
        intentFilter.addAction("com.huawei.remotecontrol.WRITEFRPINFO");
        context.registerReceiver(this.f20065a, intentFilter, "com.huawei.remotocontrol.permission.REMOTECALL", null);
    }

    /* renamed from: d */
    public final void m26500d() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        String strM71252b0 = C11877j.m71252b0(contextM74301m);
        C13981a.m83989i("PhoneFinderOffReceiver", "unRegisterPushToken");
        if (TextUtils.isEmpty(strM71252b0)) {
            C13981a.m83990w("PhoneFinderOffReceiver", "unRegisterPushToken token is empty.");
        } else {
            C11877j.m71274i1(contextM74301m, Boolean.FALSE);
        }
    }
}
