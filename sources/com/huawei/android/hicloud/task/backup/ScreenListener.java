package com.huawei.android.hicloud.task.backup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ScreenListener {

    /* renamed from: d */
    public static Context f13053d;

    /* renamed from: b */
    public ScreenStateListener f13055b;

    /* renamed from: c */
    public boolean f13056c = false;

    /* renamed from: a */
    public C3001b f13054a = new C3001b();

    public interface ScreenStateListener {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    /* renamed from: com.huawei.android.hicloud.task.backup.ScreenListener$b */
    public class C3001b extends BroadcastReceiver {

        /* renamed from: a */
        public String f13057a;

        public C3001b() {
            this.f13057a = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = new SafeIntent(intent).getAction();
            this.f13057a = action;
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                ScreenListener.this.f13055b.onScreenOn();
            } else if ("android.intent.action.SCREEN_OFF".equals(this.f13057a)) {
                ScreenListener.this.f13055b.onScreenOff();
            } else if ("android.intent.action.USER_PRESENT".equals(this.f13057a)) {
                ScreenListener.this.f13055b.onUserPresent();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.backup.ScreenListener$c */
    public static class C3002c {

        /* renamed from: a */
        public static final ScreenListener f13059a = new ScreenListener();
    }

    /* renamed from: c */
    public static ScreenListener m18023c(Context context) {
        m18024e(context);
        return C3002c.f13059a;
    }

    /* renamed from: e */
    public static void m18024e(Context context) {
        if (f13053d != null || context == null) {
            return;
        }
        f13053d = context.getApplicationContext();
    }

    /* renamed from: b */
    public void m18025b(ScreenStateListener screenStateListener) {
        this.f13055b = screenStateListener;
        m18027f();
        m18026d();
    }

    /* renamed from: d */
    public final void m18026d() {
        if (((PowerManager) f13053d.getSystemService("power")).isScreenOn()) {
            ScreenStateListener screenStateListener = this.f13055b;
            if (screenStateListener != null) {
                screenStateListener.onScreenOn();
                return;
            }
            return;
        }
        ScreenStateListener screenStateListener2 = this.f13055b;
        if (screenStateListener2 != null) {
            screenStateListener2.onScreenOff();
        }
    }

    /* renamed from: f */
    public final void m18027f() {
        IntentFilter intentFilter = new IntentFilter();
        this.f13056c = true;
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        f13053d.registerReceiver(this.f13054a, intentFilter);
    }

    /* renamed from: g */
    public void m18028g() {
        C3001b c3001b;
        try {
            if (!this.f13056c || (c3001b = this.f13054a) == null) {
                return;
            }
            f13053d.unregisterReceiver(c3001b);
            this.f13056c = false;
        } catch (Exception e10) {
            C11839m.m70687e("ScreenListener", "unregisterListener exception: " + e10.toString());
        }
    }
}
