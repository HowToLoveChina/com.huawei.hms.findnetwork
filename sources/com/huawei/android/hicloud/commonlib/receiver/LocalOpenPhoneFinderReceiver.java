package com.huawei.android.hicloud.commonlib.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.sync.R$string;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;

/* loaded from: classes3.dex */
public class LocalOpenPhoneFinderReceiver extends BroadcastReceiver {

    /* renamed from: e */
    public static volatile LocalOpenPhoneFinderReceiver f12038e;

    /* renamed from: f */
    public static final Object f12039f = new Object();

    /* renamed from: a */
    public boolean f12040a = false;

    /* renamed from: b */
    public Context f12041b = C0213f.m1377a();

    /* renamed from: c */
    public Handler f12042c;

    /* renamed from: d */
    public int f12043d;

    private LocalOpenPhoneFinderReceiver() {
    }

    /* renamed from: a */
    public static LocalOpenPhoneFinderReceiver m15903a() {
        if (f12038e == null) {
            synchronized (f12039f) {
                try {
                    if (f12038e == null) {
                        f12038e = new LocalOpenPhoneFinderReceiver();
                    }
                } finally {
                }
            }
        }
        return f12038e;
    }

    /* renamed from: b */
    public void m15904b(boolean z10) {
        Context context;
        int i10;
        if (this.f12041b == null) {
            return;
        }
        if (!z10) {
            if (C11842p.m70762R0()) {
                context = this.f12041b;
                i10 = R$string.open_phonefinder_failure_toast_pad;
            } else {
                context = this.f12041b;
                i10 = R$string.open_phonefinder_failure_toast;
            }
            Toast.makeText(this.f12041b, context.getString(i10), 0).show();
        }
        if (this.f12042c != null && this.f12043d != -1) {
            C11839m.m70688i("LocalOpenPhoneFinderReceiver", "processResult removeMessages");
            this.f12042c.removeMessages(this.f12043d);
        }
        if (this.f12042c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1004;
            Bundle bundle = new Bundle();
            bundle.putBoolean("phonefinder_result", z10);
            messageObtain.setData(bundle);
            this.f12042c.sendMessage(messageObtain);
        }
        m15906d(this.f12041b);
    }

    /* renamed from: c */
    public void m15905c(Handler handler, int i10) {
        if (this.f12040a) {
            return;
        }
        C11839m.m70688i("LocalOpenPhoneFinderReceiver", "registerReceiver");
        this.f12042c = handler;
        this.f12043d = i10;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
        C13108a.m78878b(this.f12041b.getApplicationContext()).m78880c(this, intentFilter);
        this.f12040a = true;
    }

    /* renamed from: d */
    public void m15906d(Context context) {
        if (this.f12040a) {
            C11839m.m70688i("LocalOpenPhoneFinderReceiver", "unRegister");
            C13108a.m78878b(context.getApplicationContext()).m78883f(this);
            this.f12040a = false;
            this.f12042c = null;
            this.f12043d = -1;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.getAction() == null) {
            C11839m.m70687e("LocalOpenPhoneFinderReceiver", "HiSyncReceiver action is null");
            return;
        }
        if (this.f12041b == null) {
            return;
        }
        try {
            String action = hiCloudSafeIntent.getAction();
            C11839m.m70688i("LocalOpenPhoneFinderReceiver", "LocalOpenPhoneFinderReceiver action: " + action);
            if ("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action)) {
                boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("phonefinder_result", false);
                C11839m.m70688i("LocalOpenPhoneFinderReceiver", "receive open phone finder result, result: " + booleanExtra);
                m15904b(booleanExtra);
            }
        } catch (Exception unused) {
            C11839m.m70688i("LocalOpenPhoneFinderReceiver", "LocalOpenPhoneFinderReceiver, onReceive intent getdata error");
        }
    }
}
