package com.baidu.location.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.location.p065a.C1534f;

/* loaded from: classes.dex */
public class ScreenMan {

    /* renamed from: c */
    private static ScreenMan f6681c;

    /* renamed from: a */
    private boolean f6682a = false;

    /* renamed from: b */
    private ScanBroadCast f6683b = null;

    public class ScanBroadCast extends BroadcastReceiver {
        public ScanBroadCast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            try {
                if (TextUtils.equals("android.intent.action.SCREEN_ON", action)) {
                    ScreenMan.this.f6682a = false;
                    str = "ACTION_SCREEN_ON";
                } else {
                    if (!TextUtils.equals("android.intent.action.SCREEN_OFF", action)) {
                        return;
                    }
                    ScreenMan.this.f6682a = true;
                    str = "ACTION_SCREEN_OFF";
                }
                C1536a.m8739a(str);
            } catch (Exception e10) {
                if (C1534f.f6655a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private ScreenMan() {
    }

    /* renamed from: a */
    public static synchronized ScreenMan m8733a() {
        try {
            if (f6681c == null) {
                f6681c = new ScreenMan();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f6681c;
    }

    /* renamed from: b */
    public void m8736b(Context context) {
        ScanBroadCast scanBroadCast = this.f6683b;
        if (scanBroadCast != null) {
            try {
                context.unregisterReceiver(scanBroadCast);
            } catch (Exception e10) {
                if (C1534f.f6655a) {
                    e10.printStackTrace();
                }
            }
        }
        this.f6683b = null;
    }

    /* renamed from: a */
    public void m8735a(Context context) {
        this.f6683b = new ScanBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        try {
            context.registerReceiver(this.f6683b, intentFilter);
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public boolean m8737b() {
        return this.f6682a;
    }
}
