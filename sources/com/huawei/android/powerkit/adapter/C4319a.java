package com.huawei.android.powerkit.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Log;
import com.huawei.android.powerkit.adapter.IPowerKitApi;
import com.huawei.android.powerkit.adapter.IStateSink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import pe.InterfaceC12133b;
import pe.InterfaceC12134c;

/* renamed from: com.huawei.android.powerkit.adapter.a */
/* loaded from: classes.dex */
public class C4319a implements IBinder.DeathRecipient {

    /* renamed from: f */
    public Context f19711f;

    /* renamed from: g */
    public C4319a f19712g;

    /* renamed from: h */
    public InterfaceC12133b f19713h;

    /* renamed from: a */
    public final HashSet<InterfaceC12134c> f19706a = new HashSet<>();

    /* renamed from: b */
    public final ArrayList<Integer> f19707b = new ArrayList<>();

    /* renamed from: c */
    public final HashMap<InterfaceC12134c, ArrayList<Integer>> f19708c = new HashMap<>();

    /* renamed from: d */
    public final b f19709d = new b(this, null);

    /* renamed from: e */
    public final Object f19710e = new Object();

    /* renamed from: i */
    public IPowerKitApi f19714i = null;

    /* renamed from: j */
    public ServiceConnection f19715j = new a();

    /* renamed from: com.huawei.android.powerkit.adapter.a$a */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (C4319a.this.f19710e) {
                C4319a.this.f19714i = IPowerKitApi.AbstractBinderC4316a.m25949a(iBinder);
                try {
                    C4319a.this.f19714i.asBinder().linkToDeath(C4319a.this.f19712g, 0);
                } catch (Exception unused) {
                    Log.w("PowerKitApi", "power kit linkToDeath failed ! calling pid: " + Binder.getCallingPid());
                }
            }
            Log.v("PowerKitApi", "Power kit service connected");
            C4319a.this.f19713h.mo7940b();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.v("PowerKitApi", "Power kit service disconnected");
            C4319a.this.f19713h.mo7939a();
        }
    }

    /* renamed from: com.huawei.android.powerkit.adapter.a$b */
    public final class b extends IStateSink.AbstractBinderC4317a {
        public b() {
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onPowerBaseLineUsing(String str, String str2, long j10, int i10, String str3) {
            Log.i("PowerKitApi", "onPowerBaseLineUsing callingPkg:" + str + " appAndGroup:" + str2 + " usage duration:" + j10 + " usage Count:" + i10 + " extend:" + str3);
            synchronized (C4319a.this.f19710e) {
                try {
                    if (C4319a.this.f19706a.isEmpty()) {
                        return;
                    }
                    Iterator it = C4319a.this.f19706a.iterator();
                    while (it.hasNext()) {
                        InterfaceC12134c interfaceC12134c = (InterfaceC12134c) it.next();
                        ArrayList arrayList = (ArrayList) C4319a.this.f19708c.get(interfaceC12134c);
                        if (arrayList != null && arrayList.contains(51)) {
                            interfaceC12134c.onPowerBaseLineUsing(str, str2, j10, i10, str3);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onPowerOverUsing(String str, int i10, long j10, long j11, String str2) {
            Log.i("PowerKitApi", "onPowerOverUsing moudle:" + str + " resource:" + i10 + " duration:" + j10 + " time:" + j11 + " extend:" + str2);
            synchronized (C4319a.this.f19710e) {
                try {
                    if (C4319a.this.f19706a.isEmpty()) {
                        return;
                    }
                    Iterator it = C4319a.this.f19706a.iterator();
                    while (it.hasNext()) {
                        InterfaceC12134c interfaceC12134c = (InterfaceC12134c) it.next();
                        ArrayList arrayList = (ArrayList) C4319a.this.f19708c.get(interfaceC12134c);
                        if (arrayList != null && arrayList.contains(50)) {
                            interfaceC12134c.onPowerOverUsing(str, i10, j10, j11, str2);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onStateChanged(int i10, int i11, int i12, String str, int i13) {
            Log.i("PowerKitApi", "stateType:" + i10 + " eventType:" + i11 + " pid:" + i12 + " pkg:" + str + " uid:" + i13);
            synchronized (C4319a.this.f19710e) {
                try {
                    if (C4319a.this.f19706a.isEmpty()) {
                        return;
                    }
                    Iterator it = C4319a.this.f19706a.iterator();
                    while (it.hasNext()) {
                        InterfaceC12134c interfaceC12134c = (InterfaceC12134c) it.next();
                        ArrayList arrayList = (ArrayList) C4319a.this.f19708c.get(interfaceC12134c);
                        if (arrayList != null && arrayList.contains(Integer.valueOf(i10))) {
                            interfaceC12134c.onStateChanged(i10, i11, i12, str, i13);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public /* synthetic */ b(C4319a c4319a, a aVar) {
            this();
        }
    }

    public C4319a(Context context, InterfaceC12133b interfaceC12133b) {
        this.f19711f = null;
        this.f19712g = null;
        this.f19713h = null;
        this.f19712g = this;
        this.f19713h = interfaceC12133b;
        this.f19711f = context;
        m25960i();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Log.e("PowerKitApi", "powerkit process binder was died and connecting ...");
        synchronized (this.f19710e) {
            this.f19714i = null;
        }
        int i10 = 5;
        while (i10 > 0) {
            i10--;
            SystemClock.sleep(new Random().nextInt(2001) + 1000);
            if (m25960i()) {
                return;
            }
        }
    }

    /* renamed from: h */
    public boolean m25959h(Context context, boolean z10, String str, int i10, long j10, String str2) throws RemoteException {
        boolean zApplyForResourceUse;
        synchronized (this.f19710e) {
            try {
                IPowerKitApi iPowerKitApi = this.f19714i;
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
    public final boolean m25960i() {
        boolean zBindService = false;
        if (!((UserManager) this.f19711f.getSystemService("user")).isSystemUser()) {
            Log.v("PowerKitApi", "not owner, power kit service not support");
            return false;
        }
        try {
            zBindService = this.f19711f.getApplicationContext().bindService(m25961j(this.f19711f, new Intent("com.huawei.android.powerkit.PowerKitService")), this.f19715j, 1);
            Log.v("PowerKitApi", "bind power kit service, state: " + zBindService);
            return zBindService;
        } catch (Exception unused) {
            Log.w("PowerKitApi", "bind power kit service exception!");
            return zBindService;
        }
    }

    /* renamed from: j */
    public final Intent m25961j(Context context, Intent intent) {
        context.getPackageManager().queryIntentServices(intent, 0);
        ComponentName componentName = new ComponentName("com.huawei.powergenie", "com.huawei.android.powerkit.PowerKitService");
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    /* renamed from: k */
    public boolean m25962k(InterfaceC12134c interfaceC12134c, int i10) throws RemoteException {
        boolean zDisableStateEvent;
        synchronized (this.f19710e) {
            try {
                if (this.f19714i == null) {
                    throw new RemoteException("PowerKit server is not found");
                }
                ArrayList<Integer> arrayList = this.f19708c.get(interfaceC12134c);
                if (arrayList != null) {
                    arrayList.remove(Integer.valueOf(i10));
                    if (arrayList.size() == 0) {
                        this.f19708c.remove(interfaceC12134c);
                        m25968q(interfaceC12134c);
                    }
                }
                this.f19707b.remove(Integer.valueOf(i10));
                Log.i("PowerKitApi", "Disable state event, stateType: " + i10);
                zDisableStateEvent = this.f19714i.disableStateEvent(i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zDisableStateEvent;
    }

    /* renamed from: l */
    public boolean m25963l(InterfaceC12134c interfaceC12134c, int i10) throws RemoteException {
        synchronized (this.f19710e) {
            try {
                IPowerKitApi iPowerKitApi = this.f19714i;
                if (iPowerKitApi == null) {
                    throw new RemoteException("PowerKit server is not found");
                }
                if (m25964m(iPowerKitApi.getPowerKitVersion(this.f19711f.getPackageName()), "10.0.0.305") && i10 == 51) {
                    Log.i("PowerKitApi", "System PowerKit version is low, don't support application using baseline remaining");
                    return false;
                }
                if (!m25965n(interfaceC12134c)) {
                    return false;
                }
                Log.i("PowerKitApi", "registerSink return true");
                ArrayList<Integer> arrayList = this.f19708c.get(interfaceC12134c);
                if (arrayList == null) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    arrayList2.add(Integer.valueOf(i10));
                    this.f19708c.put(interfaceC12134c, arrayList2);
                } else {
                    arrayList.add(Integer.valueOf(i10));
                }
                this.f19707b.add(Integer.valueOf(i10));
                return this.f19714i.enableStateEvent(i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public final boolean m25964m(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i10 = 0; i10 < strArrSplit2.length; i10++) {
            if (Integer.parseInt(strArrSplit[i10]) > Integer.parseInt(strArrSplit2[i10])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public final boolean m25965n(InterfaceC12134c interfaceC12134c) {
        if (interfaceC12134c == null) {
            Log.e("PowerKitApi", "registerSink a null sink fail.");
            return false;
        }
        if (!this.f19706a.contains(interfaceC12134c)) {
            this.f19706a.add(interfaceC12134c);
            if (this.f19706a.size() == 1) {
                m25966o();
            }
        }
        return true;
    }

    /* renamed from: o */
    public final void m25966o() {
        try {
            this.f19714i.registerSink(this.f19709d);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "register sink transport fail.");
        }
    }

    /* renamed from: p */
    public final void m25967p() {
        try {
            this.f19714i.unregisterSink(this.f19709d);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "unregister sink transport fail.");
        }
    }

    /* renamed from: q */
    public final void m25968q(InterfaceC12134c interfaceC12134c) {
        this.f19706a.remove(interfaceC12134c);
        if (this.f19706a.size() == 0) {
            m25967p();
        }
    }
}
