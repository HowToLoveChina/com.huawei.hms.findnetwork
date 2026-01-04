package com.huawei.hms.push;

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

/* renamed from: com.huawei.hms.push.r */
/* loaded from: classes8.dex */
public class C6299r {

    /* renamed from: a */
    private ServiceConnection f29714a;

    /* renamed from: b */
    private Messenger f29715b = null;

    /* renamed from: com.huawei.hms.push.r$a */
    public class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f29716a;

        /* renamed from: b */
        final /* synthetic */ Context f29717b;

        public a(Bundle bundle, Context context) {
            this.f29716a = bundle;
            this.f29717b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            HMSLog.m36988i("RemoteService", "remote service onConnected");
            C6299r.this.f29715b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.f29716a);
            try {
                C6299r.this.f29715b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.m36988i("RemoteService", "remote service message send failed");
            }
            HMSLog.m36988i("RemoteService", "remote service unbindservice");
            this.f29717b.unbindService(C6299r.this.f29714a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m36988i("RemoteService", "remote service onDisconnected");
            C6299r.this.f29715b = null;
        }
    }

    /* renamed from: a */
    public boolean m36598a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f29714a = new a(bundle, applicationContext);
        HMSLog.m36988i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f29714a, 1);
    }
}
