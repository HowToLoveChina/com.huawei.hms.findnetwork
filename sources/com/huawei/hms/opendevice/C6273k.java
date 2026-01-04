package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.opendevice.k */
/* loaded from: classes8.dex */
public class C6273k {

    /* renamed from: a */
    private ServiceConnection f29587a;

    /* renamed from: b */
    private Messenger f29588b = null;

    /* renamed from: com.huawei.hms.opendevice.k$a */
    public class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f29589a;

        /* renamed from: b */
        final /* synthetic */ Context f29590b;

        public a(Bundle bundle, Context context) {
            this.f29589a = bundle;
            this.f29590b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            HMSLog.m36988i("RemoteService", "remote service onConnected");
            C6273k.this.f29588b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.f29589a);
            try {
                C6273k.this.f29588b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.m36988i("RemoteService", "remote service message send failed");
            }
            HMSLog.m36988i("RemoteService", "remote service unbindservice");
            this.f29590b.unbindService(C6273k.this.f29587a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m36988i("RemoteService", "remote service onDisconnected");
            C6273k.this.f29588b = null;
        }
    }

    /* renamed from: a */
    public boolean m36445a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f29587a = new a(bundle, applicationContext);
        HMSLog.m36988i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f29587a, 1);
    }
}
