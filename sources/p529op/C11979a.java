package p529op;

import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.iaware.IAwareSdkEx;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0224k0;
import p399jk.AbstractC10896a;
import p529op.C11979a;

/* renamed from: op.a */
/* loaded from: classes8.dex */
public class C11979a {

    /* renamed from: a */
    public e f55753a;

    /* renamed from: b */
    public final Map<Integer, Set<c>> f55754b;

    /* renamed from: c */
    public volatile b f55755c;

    /* renamed from: d */
    public volatile b f55756d;

    /* renamed from: e */
    public CountDownLatch f55757e;

    /* renamed from: f */
    public boolean f55758f;

    /* renamed from: g */
    public boolean f55759g;

    /* renamed from: h */
    public int f55760h;

    /* renamed from: i */
    public int f55761i;

    /* renamed from: op.a$b */
    public class b extends Binder implements IBinder.DeathRecipient {

        /* renamed from: a */
        public IBinder f55762a;

        /* renamed from: b */
        public int f55763b;

        public b(int i10) {
            this.f55763b = i10;
        }

        /* renamed from: e */
        public static /* synthetic */ boolean m72115e(Set set) {
            return (set == null || set.isEmpty()) ? false : true;
        }

        /* renamed from: g */
        public static /* synthetic */ void m72117g(final int i10, final int i11, Set set) {
            set.forEach(new Consumer() { // from class: op.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((C11979a.c) obj).mo471a(i10, i11);
                }
            });
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f55762a = null;
            AbstractC10896a.m65887i("LoadControlManager", "IAwareSdkService died.");
            C11979a.this.f55753a.sendMessageDelayed(C11979a.this.f55753a.obtainMessage(101), 5000L);
            if (C11979a.this.f55757e != null) {
                C11979a.this.f55757e.countDown();
            }
        }

        /* renamed from: d */
        public final void m72118d(final int i10, final int i11) {
            AbstractC10896a.m65887i("LoadControlManager", "doIAwareSdkCallbackData enter,notify level : " + i10 + ", resType: " + i11);
            if (C11979a.this.f55754b == null || C11979a.this.f55754b.isEmpty()) {
                AbstractC10896a.m65887i("LoadControlManager", "loadCallbackMap is empty");
            } else {
                C11979a.this.f55754b.values().stream().filter(new Predicate() { // from class: op.b
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C11979a.b.m72115e((Set) obj);
                    }
                }).forEach(new Consumer() { // from class: op.c
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C11979a.b.m72117g(i10, i11, (Set) obj);
                    }
                });
            }
        }

        /* renamed from: h */
        public void m72119h() throws RemoteException {
            if (this.f55762a != null) {
                return;
            }
            try {
                IBinder iBinderM1560o = C0224k0.m1560o("IAwareSdkService");
                this.f55762a = iBinderM1560o;
                if (iBinderM1560o != null) {
                    iBinderM1560o.linkToDeath(this, 0);
                } else {
                    AbstractC10896a.m65886e("LoadControlManager", "linkToSdkService, failed to get IAwareSdkService.");
                }
            } catch (RemoteException e10) {
                AbstractC10896a.m65886e("LoadControlManager", "linkToSdkService, RemoteException: " + e10.getMessage());
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (C11979a.this.f55757e != null) {
                    C11979a.this.f55757e.countDown();
                }
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            AbstractC10896a.m65887i("LoadControlManager", "onTransact callback,scheduleType is:" + this.f55763b);
            if (this.f55763b == 2) {
                parcel.enforceInterface("com.huawei.iaware.sdk.uniSchedulerCallback");
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                if (i13 == 1 || i13 == 17) {
                    C11979a.this.f55760h = i12;
                } else if (i13 == 16) {
                    C11979a.this.f55761i = i12;
                }
                m72118d(i12, i13);
            } else {
                parcel.enforceInterface("com.huawei.iaware.sdk.ThermalCallback");
                C11979a.this.f55760h = parcel.readInt();
                m72118d(C11979a.this.f55760h, 1);
            }
            if (C11979a.this.f55757e != null) {
                C11979a.this.f55757e.countDown();
            }
            parcel2.writeNoException();
            AbstractC10896a.m65885d("LoadControlManager", "onTransact: " + C11979a.this.f55760h);
            return true;
        }
    }

    /* renamed from: op.a$c */
    public interface c {
        /* renamed from: a */
        void mo471a(int i10, int i11);
    }

    /* renamed from: op.a$d */
    public static class d {

        /* renamed from: a */
        public static final C11979a f55765a = new C11979a();
    }

    /* renamed from: op.a$e */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 101) {
                C11979a.this.m72103h();
                return;
            }
            AbstractC10896a.m65888w("LoadControlManager", "unknown msg: " + message.what);
        }
    }

    /* renamed from: l */
    public static final C11979a m72102l() {
        return d.f55765a;
    }

    /* renamed from: h */
    public final void m72103h() {
        this.f55758f = true;
        this.f55759g = true;
        Map<Integer, Set<c>> map = this.f55754b;
        if (map == null || map.isEmpty()) {
            AbstractC10896a.m65887i("LoadControlManager", "loadCallbackMap is empty");
            return;
        }
        if (C0224k0.m1560o("IAwareSdkService") == null) {
            this.f55753a.sendMessageDelayed(this.f55753a.obtainMessage(101), 5000L);
        } else {
            AbstractC10896a.m65886e("LoadControlManager", "IAwareSdkService on");
            m72109o();
            m72110p();
        }
    }

    /* renamed from: i */
    public int m72104i() {
        if (this.f55756d != null && !this.f55759g) {
            return this.f55761i;
        }
        m72110p();
        return this.f55761i;
    }

    /* renamed from: j */
    public int m72105j() {
        AbstractC10896a.m65887i("LoadControlManager", "enter getCurrentLevel.");
        if (this.f55755c == null || this.f55758f) {
            m72109o();
            return this.f55760h;
        }
        AbstractC10896a.m65887i("LoadControlManager", "mThermalCallback is not null,return level:" + this.f55760h);
        return this.f55760h;
    }

    /* renamed from: k */
    public final String m72106k(String str, int i10) {
        return str + ',' + i10 + ",-1,-1,-1";
    }

    /* renamed from: m */
    public boolean m72107m() {
        return C0209d.m1261h1();
    }

    /* renamed from: n */
    public void m72108n(int i10, int i11, c cVar) {
        AbstractC10896a.m65887i("LoadControlManager", "registerLoadCallback enter,module is:" + i10 + ",scheduleType is:" + i11);
        Set<c> hashSet = this.f55754b.get(Integer.valueOf(i10));
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(cVar);
        this.f55754b.put(Integer.valueOf(i10), hashSet);
        if (i11 == 1) {
            m72109o();
        } else if (i11 != 2) {
            AbstractC10896a.m65887i("LoadControlManager", "scheduleType is invalid.");
        } else {
            m72110p();
        }
    }

    /* renamed from: o */
    public final synchronized void m72109o() {
        if (this.f55755c != null && !this.f55758f) {
            AbstractC10896a.m65887i("LoadControlManager", "registerThermalCallback, registerThermalCallback already");
            return;
        }
        AbstractC10896a.m65887i("LoadControlManager", "registerThermalCallback, registerThermalCallback start");
        this.f55758f = false;
        this.f55760h = -1;
        this.f55757e = new CountDownLatch(1);
        this.f55755c = new b(1);
        this.f55755c.m72119h();
        IAwareSdkEx.registerCallback(3034, "com.huawei.hidisk", this.f55755c);
        try {
            if (!this.f55757e.await(1L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65888w("LoadControlManager", "registerThermalCallback, registerThermalCallback await false");
            }
        } catch (InterruptedException e10) {
            AbstractC10896a.m65886e("LoadControlManager", "registerThermalCallback, registerThermalCallback countdown error: " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public final synchronized void m72110p() {
        if (this.f55756d != null && !this.f55759g) {
            AbstractC10896a.m65887i("LoadControlManager", "register mUniScheduleCallback already");
            return;
        }
        if (!m72107m()) {
            AbstractC10896a.m65887i("LoadControlManager", "no need to register uni-schedule callback,current system is below harmonyS version");
            return;
        }
        AbstractC10896a.m65887i("LoadControlManager", "registerUniScheduleCallback start");
        this.f55759g = false;
        this.f55761i = -1;
        this.f55757e = new CountDownLatch(1);
        this.f55756d = new b(2);
        this.f55756d.m72119h();
        IAwareSdkEx.registerCallback(3054, m72106k("com.huawei.hidisk.cpuload", 16), this.f55756d);
        try {
            if (!this.f55757e.await(1L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65888w("LoadControlManager", "registerUniScheduleCallback await false");
            }
        } catch (InterruptedException e10) {
            AbstractC10896a.m65886e("LoadControlManager", "registerUniScheduleCallback countdown error: " + e10.getMessage());
        }
    }

    /* renamed from: q */
    public void m72111q(int i10) {
        AbstractC10896a.m65887i("LoadControlManager", "unRegisterThermalCallback , module is:" + i10);
        this.f55754b.remove(Integer.valueOf(i10));
    }

    public C11979a() {
        this.f55753a = new e(Looper.getMainLooper());
        this.f55754b = new ConcurrentHashMap();
        this.f55755c = null;
        this.f55756d = null;
        this.f55760h = -1;
        this.f55761i = -1;
    }
}
