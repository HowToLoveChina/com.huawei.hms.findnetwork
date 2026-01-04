package com.huawei.secure.android.common.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10342a;
import p787xt.C13865a;

/* loaded from: classes5.dex */
public abstract class SafeService extends Service {

    /* renamed from: a */
    public static final String f40662a = "SafeService";

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i10) {
        try {
            return super.bindService(intent, serviceConnection, i10);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "bindService: " + e10.getMessage(), true);
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onCreate: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onDestroy: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        try {
            super.onRebind(new SafeIntent(intent));
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onRebind: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Service
    @Deprecated
    public void onStart(Intent intent, int i10) {
        if (C10342a.m63675a(intent)) {
            C13865a.m83189c(f40662a, "onStart : hasIntentBomb");
        }
        try {
            super.onStart(new SafeIntent(intent), i10);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onStart: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (C10342a.m63675a(intent)) {
            C13865a.m83189c(f40662a, "onStartCommand : hasIntentBomb");
        }
        try {
            return super.onStartCommand(new SafeIntent(intent), i10, i11);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onStartCommand: " + e10.getMessage(), true);
            return 0;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        try {
            return super.onUnbind(new SafeIntent(intent));
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "onUnbind: " + e10.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "startActivities: " + e10.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "startActivity: " + e10.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        try {
            return super.startForegroundService(new SafeIntent(intent));
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "startForegroundService: " + e10.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        try {
            return super.startService(intent);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "startService: " + e10.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        try {
            return super.stopService(intent);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "stopService: " + e10.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "unbindService: " + e10.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Exception e10) {
            C13865a.m83191e(f40662a, "unregisterReceiver: " + e10.getMessage(), true);
        }
    }
}
