package com.huawei.android.remotecontrol.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bf.C1175a;
import com.huawei.secure.android.common.activity.SafeService;
import com.huawei.secure.android.common.intent.SafeIntent;
import p520of.C11860j;
import p575qe.C12347f;
import p809yg.C13981a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class FindDeviceService extends SafeService {
    /* renamed from: a */
    public final void m26528a() {
        C13981a.m83989i("FindDeviceService", "updatePk");
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            applicationContext = C12347f.m74285n().m74301m();
        }
        Context context = applicationContext;
        if (C1175a.m7389k(context)) {
            C11860j.m71058h1(1, null);
        } else {
            C13981a.m83989i("FindDeviceService", "register pk, closed");
            new C12797b().m76784j(context, "FindDeviceService", "01063", "register pk:finder closed", null, "01063", null, "hotaRegisterPk", true);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C13981a.m83989i("FindDeviceService", "onBind");
        return null;
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public void onCreate() {
        super.onCreate();
        C13981a.m83989i("FindDeviceService", "onCreate");
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("FindDeviceService", "onDestroy");
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        String action = new SafeIntent(intent).getAction();
        C13981a.m83989i("FindDeviceService", "onStartCommand action:" + action);
        if ("com.huawei.android.remotecontrol.action.REGISTER_PK".equals(action)) {
            m26528a();
            stopSelf();
        }
        new C12797b().m76784j(getApplicationContext(), "FindDeviceService", "hotaRegisterPk", "start FindDeviceService:" + action, null, "01063", null, "hotaRegisterPk", true);
        return 2;
    }
}
