package p694v;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: v.h */
/* loaded from: classes.dex */
public final class C13306h {

    /* renamed from: d */
    public static String f60038d;

    /* renamed from: g */
    public static c f60041g;

    /* renamed from: a */
    public final Context f60042a;

    /* renamed from: b */
    public final NotificationManager f60043b;

    /* renamed from: c */
    public static final Object f60037c = new Object();

    /* renamed from: e */
    public static Set<String> f60039e = new HashSet();

    /* renamed from: f */
    public static final Object f60040f = new Object();

    /* renamed from: v.h$a */
    public static class a implements d {

        /* renamed from: a */
        public final String f60044a;

        /* renamed from: b */
        public final int f60045b;

        /* renamed from: c */
        public final String f60046c;

        /* renamed from: d */
        public final Notification f60047d;

        public a(String str, int i10, String str2, Notification notification) {
            this.f60044a = str;
            this.f60045b = i10;
            this.f60046c = str2;
            this.f60047d = notification;
        }

        @Override // p694v.C13306h.d
        /* renamed from: a */
        public void mo79790a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f60044a, this.f60045b, this.f60046c, this.f60047d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f60044a + ", id:" + this.f60045b + ", tag:" + this.f60046c + "]";
        }
    }

    /* renamed from: v.h$b */
    public static class b {

        /* renamed from: a */
        public final ComponentName f60048a;

        /* renamed from: b */
        public final IBinder f60049b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.f60048a = componentName;
            this.f60049b = iBinder;
        }
    }

    /* renamed from: v.h$c */
    public static class c implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        public final Context f60050a;

        /* renamed from: b */
        public final HandlerThread f60051b;

        /* renamed from: c */
        public final Handler f60052c;

        /* renamed from: d */
        public final Map<ComponentName, a> f60053d = new HashMap();

        /* renamed from: e */
        public Set<String> f60054e = new HashSet();

        /* renamed from: v.h$c$a */
        public static class a {

            /* renamed from: a */
            public final ComponentName f60055a;

            /* renamed from: c */
            public INotificationSideChannel f60057c;

            /* renamed from: b */
            public boolean f60056b = false;

            /* renamed from: d */
            public ArrayDeque<d> f60058d = new ArrayDeque<>();

            /* renamed from: e */
            public int f60059e = 0;

            public a(ComponentName componentName) {
                this.f60055a = componentName;
            }
        }

        public c(Context context) {
            this.f60050a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f60051b = handlerThread;
            handlerThread.start();
            this.f60052c = new Handler(handlerThread.getLooper(), this);
        }

        /* renamed from: a */
        public final boolean m79791a(a aVar) {
            if (aVar.f60056b) {
                return true;
            }
            boolean zBindService = this.f60050a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f60055a), this, 33);
            aVar.f60056b = zBindService;
            if (zBindService) {
                aVar.f60059e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f60055a);
                this.f60050a.unbindService(this);
            }
            return aVar.f60056b;
        }

        /* renamed from: b */
        public final void m79792b(a aVar) {
            if (aVar.f60056b) {
                this.f60050a.unbindService(this);
                aVar.f60056b = false;
            }
            aVar.f60057c = null;
        }

        /* renamed from: c */
        public final void m79793c(d dVar) {
            m79800j();
            for (a aVar : this.f60053d.values()) {
                aVar.f60058d.add(dVar);
                m79797g(aVar);
            }
        }

        /* renamed from: d */
        public final void m79794d(ComponentName componentName) {
            a aVar = this.f60053d.get(componentName);
            if (aVar != null) {
                m79797g(aVar);
            }
        }

        /* renamed from: e */
        public final void m79795e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f60053d.get(componentName);
            if (aVar != null) {
                aVar.f60057c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f60059e = 0;
                m79797g(aVar);
            }
        }

        /* renamed from: f */
        public final void m79796f(ComponentName componentName) {
            a aVar = this.f60053d.get(componentName);
            if (aVar != null) {
                m79792b(aVar);
            }
        }

        /* renamed from: g */
        public final void m79797g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f60055a + ", " + aVar.f60058d.size() + " queued tasks");
            }
            if (aVar.f60058d.isEmpty()) {
                return;
            }
            if (!m79791a(aVar) || aVar.f60057c == null) {
                m79799i(aVar);
                return;
            }
            while (true) {
                d dVarPeek = aVar.f60058d.peek();
                if (dVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + dVarPeek);
                    }
                    dVarPeek.mo79790a(aVar.f60057c);
                    aVar.f60058d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f60055a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f60055a, e10);
                }
            }
            if (aVar.f60058d.isEmpty()) {
                return;
            }
            m79799i(aVar);
        }

        /* renamed from: h */
        public void m79798h(d dVar) {
            this.f60052c.obtainMessage(0, dVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                m79793c((d) message.obj);
                return true;
            }
            if (i10 == 1) {
                b bVar = (b) message.obj;
                m79795e(bVar.f60048a, bVar.f60049b);
                return true;
            }
            if (i10 == 2) {
                m79796f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            m79794d((ComponentName) message.obj);
            return true;
        }

        /* renamed from: i */
        public final void m79799i(a aVar) {
            if (this.f60052c.hasMessages(3, aVar.f60055a)) {
                return;
            }
            int i10 = aVar.f60059e;
            int i11 = i10 + 1;
            aVar.f60059e = i11;
            if (i11 <= 6) {
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f60052c.sendMessageDelayed(this.f60052c.obtainMessage(3, aVar.f60055a), i12);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f60058d.size() + " tasks to " + aVar.f60055a + " after " + aVar.f60059e + " retries");
            aVar.f60058d.clear();
        }

        /* renamed from: j */
        public final void m79800j() {
            Set<String> setM79782e = C13306h.m79782e(this.f60050a);
            if (setM79782e.equals(this.f60054e)) {
                return;
            }
            this.f60054e = setM79782e;
            List<ResolveInfo> listQueryIntentServices = this.f60050a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setM79782e.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f60053d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f60053d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f60053d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    m79792b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f60052c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f60052c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* renamed from: v.h$d */
    public interface d {
        /* renamed from: a */
        void mo79790a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public C13306h(Context context) {
        this.f60042a = context;
        this.f60043b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: d */
    public static C13306h m79781d(Context context) {
        return new C13306h(context);
    }

    /* renamed from: e */
    public static Set<String> m79782e(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f60037c) {
            if (string != null) {
                try {
                    if (!string.equals(f60038d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f60039e = hashSet;
                        f60038d = string;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            set = f60039e;
        }
        return set;
    }

    /* renamed from: i */
    public static boolean m79783i(Notification notification) {
        Bundle bundleM3796a = NotificationCompat.m3796a(notification);
        return bundleM3796a != null && bundleM3796a.getBoolean("android.support.useSideChannel");
    }

    /* renamed from: a */
    public boolean m79784a() {
        return this.f60043b.areNotificationsEnabled();
    }

    /* renamed from: b */
    public void m79785b(int i10) {
        m79786c(null, i10);
    }

    /* renamed from: c */
    public void m79786c(String str, int i10) {
        this.f60043b.cancel(str, i10);
    }

    /* renamed from: f */
    public void m79787f(int i10, Notification notification) {
        m79788g(null, i10, notification);
    }

    /* renamed from: g */
    public void m79788g(String str, int i10, Notification notification) {
        if (!m79783i(notification)) {
            this.f60043b.notify(str, i10, notification);
        } else {
            m79789h(new a(this.f60042a.getPackageName(), i10, str, notification));
            this.f60043b.cancel(str, i10);
        }
    }

    /* renamed from: h */
    public final void m79789h(d dVar) {
        synchronized (f60040f) {
            try {
                if (f60041g == null) {
                    f60041g = new c(this.f60042a.getApplicationContext());
                }
                f60041g.m79798h(dVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
