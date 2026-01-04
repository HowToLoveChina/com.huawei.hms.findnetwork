package com.huawei.openalliance.p169ad.opendeviceidentifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7001cr;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7777bx;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@OuterVisible
/* loaded from: classes2.dex */
public class OAIDServiceManager {

    /* renamed from: a */
    private static OAIDServiceManager f35113a;

    /* renamed from: b */
    private static final byte[] f35114b = new byte[0];

    /* renamed from: c */
    private static final byte[] f35115c = new byte[0];

    /* renamed from: d */
    private InterfaceC7001cr f35116d;

    /* renamed from: e */
    private Context f35117e;

    /* renamed from: k */
    private C6922c f35123k;

    /* renamed from: l */
    private int f35124l;

    /* renamed from: f */
    private Set<OaidResultCallback> f35118f = new HashSet();

    /* renamed from: g */
    private boolean f35119g = false;

    /* renamed from: h */
    private final byte[] f35120h = new byte[0];

    /* renamed from: i */
    private final String f35121i = "oaid_timeout_task" + hashCode();

    /* renamed from: j */
    private long f35122j = -1;

    /* renamed from: m */
    private ServiceConnection f35125m = new ServiceConnection() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.5

        /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$5$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ InterfaceC7001cr f35139a;

            public AnonymousClass1(InterfaceC7001cr interfaceC7001cr) {
                interfaceC7001cr = interfaceC7001cr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set;
                if (interfaceC7001cr == null) {
                    OAIDServiceManager.this.m46394e();
                    return;
                }
                synchronized (OAIDServiceManager.f35115c) {
                    try {
                        String strMo41228a = interfaceC7001cr.mo41228a();
                        boolean zMo41229b = interfaceC7001cr.mo41229b();
                        Iterator it = OAIDServiceManager.this.f35118f.iterator();
                        while (it.hasNext()) {
                            ((OaidResultCallback) it.next()).mo44092a(strMo41228a, zMo41229b);
                        }
                        set = OAIDServiceManager.this.f35118f;
                    } catch (Throwable th2) {
                        try {
                            AbstractC7185ho.m43823c("OAIDServiceManager", "get oaid Exception: " + th2.getClass().getSimpleName());
                            OAIDServiceManager.this.m46394e();
                            set = OAIDServiceManager.this.f35118f;
                        } catch (Throwable th3) {
                            OAIDServiceManager.this.f35118f.clear();
                            throw th3;
                        }
                    }
                    set.clear();
                }
            }
        }

        public ServiceConnectionC75535() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                OAIDServiceManager.this.m46382a((String) null, (String) null);
                AbstractC7817dj.m48366a(OAIDServiceManager.this.f35121i);
                AbstractC7185ho.m43820b("OAIDServiceManager", "OAID service connected " + System.currentTimeMillis());
                OAIDServiceManager.this.m46375a(InterfaceC7001cr.a.m41230a(iBinder));
                if (OAIDServiceManager.this.m46388b()) {
                    AbstractC7185ho.m43823c("OAIDServiceManager", "oaid require is already timeout");
                } else {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.5.1

                        /* renamed from: a */
                        final /* synthetic */ InterfaceC7001cr f35139a;

                        public AnonymousClass1(InterfaceC7001cr interfaceC7001cr) {
                            interfaceC7001cr = interfaceC7001cr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Set set;
                            if (interfaceC7001cr == null) {
                                OAIDServiceManager.this.m46394e();
                                return;
                            }
                            synchronized (OAIDServiceManager.f35115c) {
                                try {
                                    String strMo41228a = interfaceC7001cr.mo41228a();
                                    boolean zMo41229b = interfaceC7001cr.mo41229b();
                                    Iterator it = OAIDServiceManager.this.f35118f.iterator();
                                    while (it.hasNext()) {
                                        ((OaidResultCallback) it.next()).mo44092a(strMo41228a, zMo41229b);
                                    }
                                    set = OAIDServiceManager.this.f35118f;
                                } catch (Throwable th2) {
                                    try {
                                        AbstractC7185ho.m43823c("OAIDServiceManager", "get oaid Exception: " + th2.getClass().getSimpleName());
                                        OAIDServiceManager.this.m46394e();
                                        set = OAIDServiceManager.this.f35118f;
                                    } catch (Throwable th3) {
                                        OAIDServiceManager.this.f35118f.clear();
                                        throw th3;
                                    }
                                }
                                set.clear();
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("OAIDServiceManager", "Oaid Service, service error: %s", th2.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC7185ho.m43820b("OAIDServiceManager", "OAID service disconnected");
            OAIDServiceManager.this.m46375a((InterfaceC7001cr) null);
        }
    };

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$1 */
    public class RunnableC75491 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ OaidResultCallback f35126a;

        /* renamed from: b */
        final /* synthetic */ long f35127b;

        public RunnableC75491(OaidResultCallback oaidResultCallback, long j10) {
            oaidResultCallback = oaidResultCallback;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OAIDServiceManager.this.m46376a(oaidResultCallback, j);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$2 */
    public class RunnableC75502 implements Runnable {

        /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("OAIDServiceManager", "bind timeout " + System.currentTimeMillis());
                OAIDServiceManager.this.m46383a(true);
                OAIDServiceManager.this.m46394e();
            }
        }

        public RunnableC75502() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b("OAIDServiceManager", "bind timeout " + System.currentTimeMillis());
                    OAIDServiceManager.this.m46383a(true);
                    OAIDServiceManager.this.m46394e();
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$3 */
    public class RunnableC75513 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ OaidResultCallback f35131a;

        public RunnableC75513(OaidResultCallback oaidResultCallback) {
            oaidResultCallback = oaidResultCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            oaidResultCallback.mo44091a();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$4 */
    public class RunnableC75524 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f35133a;

        /* renamed from: b */
        final /* synthetic */ String f35134b;

        /* renamed from: c */
        final /* synthetic */ String f35135c;

        /* renamed from: d */
        final /* synthetic */ int f35136d;

        public RunnableC75524(long j10, String str, String str2, int i10) {
            j = j10;
            str = str;
            str = str2;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OAIDServiceManager.this.f35123k.m39096a("43", j, str, str, i);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$5 */
    public class ServiceConnectionC75535 implements ServiceConnection {

        /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$5$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ InterfaceC7001cr f35139a;

            public AnonymousClass1(InterfaceC7001cr interfaceC7001cr) {
                interfaceC7001cr = interfaceC7001cr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set;
                if (interfaceC7001cr == null) {
                    OAIDServiceManager.this.m46394e();
                    return;
                }
                synchronized (OAIDServiceManager.f35115c) {
                    try {
                        String strMo41228a = interfaceC7001cr.mo41228a();
                        boolean zMo41229b = interfaceC7001cr.mo41229b();
                        Iterator it = OAIDServiceManager.this.f35118f.iterator();
                        while (it.hasNext()) {
                            ((OaidResultCallback) it.next()).mo44092a(strMo41228a, zMo41229b);
                        }
                        set = OAIDServiceManager.this.f35118f;
                    } catch (Throwable th2) {
                        try {
                            AbstractC7185ho.m43823c("OAIDServiceManager", "get oaid Exception: " + th2.getClass().getSimpleName());
                            OAIDServiceManager.this.m46394e();
                            set = OAIDServiceManager.this.f35118f;
                        } catch (Throwable th3) {
                            OAIDServiceManager.this.f35118f.clear();
                            throw th3;
                        }
                    }
                    set.clear();
                }
            }
        }

        public ServiceConnectionC75535() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                OAIDServiceManager.this.m46382a((String) null, (String) null);
                AbstractC7817dj.m48366a(OAIDServiceManager.this.f35121i);
                AbstractC7185ho.m43820b("OAIDServiceManager", "OAID service connected " + System.currentTimeMillis());
                OAIDServiceManager.this.m46375a(InterfaceC7001cr.a.m41230a(iBinder));
                if (OAIDServiceManager.this.m46388b()) {
                    AbstractC7185ho.m43823c("OAIDServiceManager", "oaid require is already timeout");
                } else {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.5.1

                        /* renamed from: a */
                        final /* synthetic */ InterfaceC7001cr f35139a;

                        public AnonymousClass1(InterfaceC7001cr interfaceC7001cr) {
                            interfaceC7001cr = interfaceC7001cr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Set set;
                            if (interfaceC7001cr == null) {
                                OAIDServiceManager.this.m46394e();
                                return;
                            }
                            synchronized (OAIDServiceManager.f35115c) {
                                try {
                                    String strMo41228a = interfaceC7001cr.mo41228a();
                                    boolean zMo41229b = interfaceC7001cr.mo41229b();
                                    Iterator it = OAIDServiceManager.this.f35118f.iterator();
                                    while (it.hasNext()) {
                                        ((OaidResultCallback) it.next()).mo44092a(strMo41228a, zMo41229b);
                                    }
                                    set = OAIDServiceManager.this.f35118f;
                                } catch (Throwable th2) {
                                    try {
                                        AbstractC7185ho.m43823c("OAIDServiceManager", "get oaid Exception: " + th2.getClass().getSimpleName());
                                        OAIDServiceManager.this.m46394e();
                                        set = OAIDServiceManager.this.f35118f;
                                    } catch (Throwable th3) {
                                        OAIDServiceManager.this.f35118f.clear();
                                        throw th3;
                                    }
                                }
                                set.clear();
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("OAIDServiceManager", "Oaid Service, service error: %s", th2.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC7185ho.m43820b("OAIDServiceManager", "OAID service disconnected");
            OAIDServiceManager.this.m46375a((InterfaceC7001cr) null);
        }
    }

    @OuterVisible
    public static abstract class OaidResultCallback {
        /* renamed from: a */
        public abstract void mo44091a();

        /* renamed from: a */
        public abstract void mo44092a(String str, boolean z10);

        /* renamed from: b */
        public int mo44093b() {
            return -1;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$a */
    public static class RunnableC7554a implements Runnable {

        /* renamed from: a */
        private OaidResultCallback f35141a;

        /* renamed from: b */
        private InterfaceC7001cr f35142b;

        public RunnableC7554a(OaidResultCallback oaidResultCallback, InterfaceC7001cr interfaceC7001cr) {
            this.f35141a = oaidResultCallback;
            this.f35142b = interfaceC7001cr;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                this.f35141a.mo44092a(this.f35142b.mo41228a(), this.f35142b.mo41229b());
            } catch (RemoteException unused) {
                str = "requireOaid RemoteException";
                AbstractC7185ho.m43823c("OAIDServiceManager", str);
                this.f35141a.mo44091a();
            } catch (Exception unused2) {
                str = "requireOaid exception";
                AbstractC7185ho.m43823c("OAIDServiceManager", str);
                this.f35141a.mo44091a();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$b */
    public static class RunnableC7555b implements Runnable {

        /* renamed from: a */
        private WeakReference<OAIDServiceManager> f35143a;

        public RunnableC7555b(OAIDServiceManager oAIDServiceManager) {
            this.f35143a = new WeakReference<>(oAIDServiceManager);
        }

        @Override // java.lang.Runnable
        public void run() {
            OAIDServiceManager oAIDServiceManager = this.f35143a.get();
            AbstractC7185ho.m43817a("OAIDServiceManager", "provider timeout");
            if (oAIDServiceManager != null) {
                oAIDServiceManager.m46394e();
                oAIDServiceManager.m46383a(true);
            }
        }
    }

    private OAIDServiceManager(Context context) {
        this.f35117e = context.getApplicationContext();
        this.f35123k = new C6922c(context);
    }

    /* renamed from: a */
    private void m46374a(long j10) {
        AbstractC7817dj.m48366a(this.f35121i);
        m46383a(false);
        AbstractC7817dj.m48365a(new RunnableC7555b(this), this.f35121i, j10);
    }

    /* renamed from: c */
    public synchronized InterfaceC7001cr m46389c() {
        return this.f35116d;
    }

    /* renamed from: d */
    private boolean m46391d() {
        try {
            AbstractC7185ho.m43820b("OAIDServiceManager", "bindService " + System.currentTimeMillis());
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            String strM48434e = C7830i.m48434e(this.f35117e);
            intent.setPackage(strM48434e);
            if (!C6982bz.m41152b(this.f35117e)) {
                String strM48435e = C7830i.m48435e(this.f35117e, strM48434e);
                boolean zIsEmpty = TextUtils.isEmpty(strM48435e);
                AbstractC7185ho.m43821b("OAIDServiceManager", "is sign empty: %s", Boolean.valueOf(zIsEmpty));
                if (!zIsEmpty && !WhiteListPkgList.isTrustApp(this.f35117e, strM48434e, strM48435e)) {
                    return false;
                }
            }
            boolean zBindService = this.f35117e.bindService(intent, this.f35125m, 1);
            AbstractC7185ho.m43821b("OAIDServiceManager", "bind service result: %s", Boolean.valueOf(zBindService));
            if (!zBindService) {
                m46394e();
                m46382a((String) null, "bind result false");
            }
            return zBindService;
        } catch (SecurityException e10) {
            AbstractC7185ho.m43823c("OAIDServiceManager", "bindService SecurityException");
            m46394e();
            m46382a(e10.getClass().getSimpleName(), e10.getMessage());
            return false;
        } catch (Exception e11) {
            AbstractC7185ho.m43823c("OAIDServiceManager", "bindService " + e11.getClass().getSimpleName());
            m46394e();
            m46382a(e11.getClass().getSimpleName(), e11.getMessage());
            return false;
        }
    }

    @OuterVisible
    public static OAIDServiceManager getInstance(Context context) {
        OAIDServiceManager oAIDServiceManager;
        synchronized (f35114b) {
            try {
                if (f35113a == null) {
                    f35113a = new OAIDServiceManager(context);
                }
                oAIDServiceManager = f35113a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return oAIDServiceManager;
    }

    @OuterVisible
    public void requireOaid(OaidResultCallback oaidResultCallback) {
        requireOaid(oaidResultCallback, 400L);
    }

    /* renamed from: a */
    public synchronized void m46375a(InterfaceC7001cr interfaceC7001cr) {
        this.f35116d = interfaceC7001cr;
    }

    /* renamed from: b */
    private void m46386b(long j10) {
        AbstractC7817dj.m48366a(this.f35121i);
        m46383a(false);
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.2

            /* renamed from: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager$2$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b("OAIDServiceManager", "bind timeout " + System.currentTimeMillis());
                    OAIDServiceManager.this.m46383a(true);
                    OAIDServiceManager.this.m46394e();
                }
            }

            public RunnableC75502() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC7185ho.m43820b("OAIDServiceManager", "bind timeout " + System.currentTimeMillis());
                        OAIDServiceManager.this.m46383a(true);
                        OAIDServiceManager.this.m46394e();
                    }
                });
            }
        }, this.f35121i, j10);
    }

    /* renamed from: e */
    public void m46394e() {
        Set<OaidResultCallback> set;
        synchronized (f35115c) {
            try {
                try {
                    Iterator<OaidResultCallback> it = this.f35118f.iterator();
                    while (it.hasNext()) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.3

                            /* renamed from: a */
                            final /* synthetic */ OaidResultCallback f35131a;

                            public RunnableC75513(OaidResultCallback oaidResultCallback) {
                                oaidResultCallback = oaidResultCallback;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                oaidResultCallback.mo44091a();
                            }
                        });
                    }
                    set = this.f35118f;
                } catch (RuntimeException e10) {
                    AbstractC7185ho.m43823c("OAIDServiceManager", "notifyOaidAcquireFail RuntimeException " + e10.getClass().getSimpleName());
                    set = this.f35118f;
                } catch (Exception e11) {
                    AbstractC7185ho.m43823c("OAIDServiceManager", "notifyOaidAcquireFail " + e11.getClass().getSimpleName());
                    set = this.f35118f;
                }
                set.clear();
            } catch (Throwable th2) {
                this.f35118f.clear();
                throw th2;
            }
        }
    }

    @OuterVisible
    public void requireOaid(OaidResultCallback oaidResultCallback, long j10) {
        if (oaidResultCallback == null) {
            return;
        }
        if (C7124fh.m43316b(this.f35117e).mo43061ai() == 0 && C7777bx.m47843b(this.f35117e)) {
            AbstractC7185ho.m43820b("OAIDServiceManager", "requireOaid via provider");
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.1

                /* renamed from: a */
                final /* synthetic */ OaidResultCallback f35126a;

                /* renamed from: b */
                final /* synthetic */ long f35127b;

                public RunnableC75491(OaidResultCallback oaidResultCallback2, long j102) {
                    oaidResultCallback = oaidResultCallback2;
                    j = j102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OAIDServiceManager.this.m46376a(oaidResultCallback, j);
                }
            });
        } else {
            AbstractC7185ho.m43820b("OAIDServiceManager", "requireOaid via aidl");
            m46387b(oaidResultCallback2, j102);
        }
    }

    /* renamed from: a */
    public void m46376a(OaidResultCallback oaidResultCallback, long j10) {
        m46374a(j10);
        synchronized (f35115c) {
            this.f35118f.add(oaidResultCallback);
        }
        Pair<String, Boolean> pairM47840a = C7777bx.m47840a(this.f35117e);
        AbstractC7817dj.m48366a(this.f35121i);
        if (m46388b()) {
            AbstractC7185ho.m43823c("OAIDServiceManager", "provider timeout");
        } else {
            oaidResultCallback.mo44092a((String) pairM47840a.first, ((Boolean) pairM47840a.second).booleanValue());
        }
    }

    /* renamed from: b */
    private void m46387b(OaidResultCallback oaidResultCallback, long j10) {
        InterfaceC7001cr interfaceC7001crM46389c = m46389c();
        if (interfaceC7001crM46389c != null) {
            AbstractC7834m.m48480a(new RunnableC7554a(oaidResultCallback, interfaceC7001crM46389c), AbstractC7834m.a.CALCULATION, false);
            return;
        }
        if (this.f35122j < 0) {
            this.f35122j = AbstractC7741ao.m47566c();
            this.f35124l = oaidResultCallback.mo44093b();
        }
        synchronized (f35115c) {
            this.f35118f.add(oaidResultCallback);
        }
        if (m46391d()) {
            m46386b(j10);
        }
    }

    /* renamed from: b */
    public boolean m46388b() {
        boolean z10;
        synchronized (this.f35120h) {
            z10 = this.f35119g;
        }
        return z10;
    }

    /* renamed from: a */
    public void m46382a(String str, String str2) {
        long jM47566c = AbstractC7741ao.m47566c() - this.f35122j;
        if (jM47566c > 100000) {
            return;
        }
        int i10 = this.f35124l;
        AbstractC7185ho.m43818a("OAIDServiceManager", "aidl bind duration: %d msg: %s", Long.valueOf(jM47566c), str2);
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.4

            /* renamed from: a */
            final /* synthetic */ long f35133a;

            /* renamed from: b */
            final /* synthetic */ String f35134b;

            /* renamed from: c */
            final /* synthetic */ String f35135c;

            /* renamed from: d */
            final /* synthetic */ int f35136d;

            public RunnableC75524(long jM47566c2, String str3, String str22, int i102) {
                j = jM47566c2;
                str = str3;
                str = str22;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                OAIDServiceManager.this.f35123k.m39096a("43", j, str, str, i);
            }
        });
        this.f35122j = -1L;
        this.f35124l = -1;
    }

    /* renamed from: a */
    public void m46383a(boolean z10) {
        synchronized (this.f35120h) {
            this.f35119g = z10;
        }
    }
}
