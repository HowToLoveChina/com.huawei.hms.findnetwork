package com.hihonor.android.powerkit.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Log;
import com.hihonor.android.powerkit.adapter.IPowerKitApi;
import com.hihonor.android.powerkit.adapter.IStateSink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import p046c4.InterfaceC1384b;
import p046c4.InterfaceC1385c;

/* renamed from: com.hihonor.android.powerkit.adapter.a */
/* loaded from: classes.dex */
public class C2088a implements IBinder.DeathRecipient {

    /* renamed from: f */
    public Context f9466f;

    /* renamed from: g */
    public C2088a f9467g;

    /* renamed from: h */
    public InterfaceC1384b f9468h;

    /* renamed from: a */
    public final HashSet<InterfaceC1385c> f9461a = new HashSet<>();

    /* renamed from: b */
    public final ArrayList<Integer> f9462b = new ArrayList<>();

    /* renamed from: c */
    public final HashMap<InterfaceC1385c, ArrayList<Integer>> f9463c = new HashMap<>();

    /* renamed from: d */
    public final b f9464d = new b(this, null);

    /* renamed from: e */
    public final Object f9465e = new Object();

    /* renamed from: i */
    public IPowerKitApi f9469i = null;

    /* renamed from: j */
    public ServiceConnection f9470j = new a();

    /* renamed from: com.hihonor.android.powerkit.adapter.a$a */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (C2088a.this.f9465e) {
                C2088a.this.f9469i = IPowerKitApi.AbstractBinderC2085a.m12423a(iBinder);
                try {
                    C2088a.this.f9469i.asBinder().linkToDeath(C2088a.this.f9467g, 0);
                } catch (Exception unused) {
                    Log.w("PowerKitApi", "power kit linkToDeath failed ! calling pid: " + Binder.getCallingPid());
                }
            }
            Log.v("PowerKitApi", "Power kit service connected");
            C2088a.this.f9468h.mo7940b();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.v("PowerKitApi", "Power kit service disconnected");
            C2088a.this.f9468h.mo7939a();
        }
    }

    /* renamed from: com.hihonor.android.powerkit.adapter.a$b */
    public final class b extends IStateSink.AbstractBinderC2086a {
        public b() {
        }

        @Override // com.hihonor.android.powerkit.adapter.IStateSink
        public void onPowerOverUsing(String str, int i10, long j10, long j11, String str2) {
            Log.i("PowerKitApi", "onPowerOverUsing moudle:" + str + " resource:" + i10 + " duration:" + j10 + " time:" + j11 + " extend:" + str2);
            synchronized (C2088a.this.f9465e) {
                try {
                    if (C2088a.this.f9461a.isEmpty()) {
                        return;
                    }
                    Iterator it = C2088a.this.f9461a.iterator();
                    while (it.hasNext()) {
                        InterfaceC1385c interfaceC1385c = (InterfaceC1385c) it.next();
                        ArrayList arrayList = (ArrayList) C2088a.this.f9463c.get(interfaceC1385c);
                        if (arrayList != null && arrayList.contains(50)) {
                            interfaceC1385c.onPowerOverUsing(str, i10, j10, j11, str2);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.hihonor.android.powerkit.adapter.IStateSink
        public void onStateChanged(int i10, int i11, int i12, String str, int i13) {
            Log.i("PowerKitApi", "stateType:" + i10 + " eventType:" + i11 + " pid:" + i12 + " pkg:" + str + " uid:" + i13);
            synchronized (C2088a.this.f9465e) {
                try {
                    if (C2088a.this.f9461a.isEmpty()) {
                        return;
                    }
                    Iterator it = C2088a.this.f9461a.iterator();
                    while (it.hasNext()) {
                        InterfaceC1385c interfaceC1385c = (InterfaceC1385c) it.next();
                        ArrayList arrayList = (ArrayList) C2088a.this.f9463c.get(interfaceC1385c);
                        if (arrayList != null && arrayList.contains(Integer.valueOf(i10))) {
                            interfaceC1385c.onStateChanged(i10, i11, i12, str, i13);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public /* synthetic */ b(C2088a c2088a, a aVar) {
            this();
        }
    }

    public C2088a(Context context, InterfaceC1384b interfaceC1384b) {
        this.f9466f = null;
        this.f9467g = null;
        this.f9468h = null;
        this.f9467g = this;
        this.f9468h = interfaceC1384b;
        this.f9466f = context;
        m12435i();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Log.e("PowerKitApi", "powerkit process binder was died and connecting ...");
        synchronized (this.f9465e) {
            this.f9469i = null;
        }
        int i10 = 5;
        while (i10 > 0) {
            i10--;
            SystemClock.sleep(new Random().nextInt(2001) + 1000);
            if (m12435i()) {
                return;
            }
        }
    }

    /* renamed from: h */
    public boolean m12434h(Context context, boolean z10, String str, int i10, long j10, String str2) throws RemoteException {
        boolean zApplyForResourceUse;
        synchronized (this.f9465e) {
            try {
                IPowerKitApi iPowerKitApi = this.f9469i;
                if (iPowerKitApi == null) {
                    throw new RemoteException("PowerKit server is not found");
                }
                zApplyForResourceUse = iPowerKitApi.applyForResourceUse(context.getPackageName(), z10, str, i10, j10, str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zApplyForResourceUse;
    }

    /* renamed from: i */
    public final boolean m12435i() {
        boolean zBindService = false;
        if (!((UserManager) this.f9466f.getSystemService("user")).isSystemUser()) {
            Log.v("PowerKitApi", "not owner, power kit service not support");
            return false;
        }
        try {
            zBindService = this.f9466f.getApplicationContext().bindService(m12436j(this.f9466f, new Intent("com.hihonor.android.powerkit.PowerKitService")), this.f9470j, 1);
            Log.v("PowerKitApi", "bind power kit service, state: " + zBindService);
            return zBindService;
        } catch (Exception unused) {
            Log.w("PowerKitApi", "bind power kit service exception!");
            return zBindService;
        }
    }

    /* renamed from: j */
    public final Intent m12436j(Context context, Intent intent) {
        String str;
        String str2;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            Log.w("PowerKitApi", "not only one match for intent: " + intent);
            str = "com.hihonor.powergenie";
            str2 = "com.hihonor.android.powerkit.PowerKitService";
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            str = serviceInfo.packageName;
            str2 = serviceInfo.name;
        }
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    /* renamed from: k */
    public boolean m12437k(InterfaceC1385c interfaceC1385c, int i10) throws RemoteException {
        boolean zDisableStateEvent;
        synchronized (this.f9465e) {
            try {
                if (this.f9469i == null) {
                    throw new RemoteException("PowerKit server is not found");
                }
                ArrayList<Integer> arrayList = this.f9463c.get(interfaceC1385c);
                if (arrayList != null) {
                    arrayList.remove(Integer.valueOf(i10));
                    if (arrayList.size() == 0) {
                        this.f9463c.remove(interfaceC1385c);
                        m12442p(interfaceC1385c);
                    }
                }
                this.f9462b.remove(Integer.valueOf(i10));
                Log.i("PowerKitApi", "Disable state event, stateType: " + i10);
                zDisableStateEvent = this.f9469i.disableStateEvent(i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zDisableStateEvent;
    }

    /* renamed from: l */
    public boolean m12438l(InterfaceC1385c interfaceC1385c, int i10) throws RemoteException {
        synchronized (this.f9465e) {
            try {
                if (this.f9469i == null) {
                    throw new RemoteException("PowerKit server is not found");
                }
                if (!m12439m(interfaceC1385c)) {
                    return false;
                }
                Log.i("PowerKitApi", "registerSink return true");
                ArrayList<Integer> arrayList = this.f9463c.get(interfaceC1385c);
                if (arrayList == null) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    arrayList2.add(Integer.valueOf(i10));
                    this.f9463c.put(interfaceC1385c, arrayList2);
                } else {
                    arrayList.add(Integer.valueOf(i10));
                }
                this.f9462b.add(Integer.valueOf(i10));
                return this.f9469i.enableStateEvent(i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public final boolean m12439m(InterfaceC1385c interfaceC1385c) {
        if (interfaceC1385c == null) {
            Log.e("PowerKitApi", "registerSink a null sink fail.");
            return false;
        }
        if (!this.f9461a.contains(interfaceC1385c)) {
            this.f9461a.add(interfaceC1385c);
            if (this.f9461a.size() == 1) {
                m12440n();
            }
        }
        return true;
    }

    /* renamed from: n */
    public final void m12440n() {
        try {
            this.f9469i.registerSink(this.f9464d);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "register sink transport fail.");
        }
    }

    /* renamed from: o */
    public final void m12441o() {
        try {
            this.f9469i.unregisterSink(this.f9464d);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "unregister sink transport fail.");
        }
    }

    /* renamed from: p */
    public final void m12442p(InterfaceC1385c interfaceC1385c) {
        this.f9461a.remove(interfaceC1385c);
        if (this.f9461a.size() == 0) {
            m12441o();
        }
    }
}
