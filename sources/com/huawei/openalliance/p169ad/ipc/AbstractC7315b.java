package com.huawei.openalliance.p169ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.ipc.C7314a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.huawei.openalliance.ad.ipc.b */
/* loaded from: classes2.dex */
public abstract class AbstractC7315b<SERVICE extends IInterface> implements C7314a.a {

    /* renamed from: a */
    protected Context f33996a;

    /* renamed from: b */
    protected C6922c f33997b;

    /* renamed from: c */
    protected C7314a f33998c;

    /* renamed from: e */
    private SERVICE f34000e;

    /* renamed from: d */
    private final String f33999d = "install_service_timeout_task" + hashCode();

    /* renamed from: f */
    private boolean f34001f = false;

    /* renamed from: g */
    private final byte[] f34002g = new byte[0];

    /* renamed from: h */
    private Set<a> f34003h = new CopyOnWriteArraySet();

    /* renamed from: i */
    private long f34004i = -1;

    /* renamed from: j */
    private ServiceConnection f34005j = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.b.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!AbstractC7315b.this.mo45088h().equalsIgnoreCase(componentName.getClassName())) {
                    AbstractC7315b.this.m45072a("pps remote service name not match, disconnect service.");
                    AbstractC7315b.this.m45067a((AbstractC7315b) null);
                    return;
                }
                AbstractC7315b.this.m45073a((String) null, (String) null);
                if (AbstractC7315b.this.mo45085e()) {
                    AbstractC7817dj.m48366a(AbstractC7315b.this.f33999d);
                }
                AbstractC7185ho.m43820b(AbstractC7315b.this.mo45082b(), "PPS remote service connected " + System.currentTimeMillis());
                final IInterface iInterfaceMo45080a = AbstractC7315b.this.mo45080a(iBinder);
                AbstractC7315b.this.m45067a((AbstractC7315b) iInterfaceMo45080a);
                if (AbstractC7315b.this.m45077i() && AbstractC7315b.this.mo45085e()) {
                    AbstractC7185ho.m43823c(AbstractC7315b.this.mo45082b(), "install request is already timeout");
                } else {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.b.3.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iInterfaceMo45080a != null) {
                                ArrayList arrayList = new ArrayList(AbstractC7315b.this.f34003h);
                                AbstractC7315b.this.f34003h.clear();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((a) it.next()).mo45090a((a) iInterfaceMo45080a);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(AbstractC7315b.this.mo45082b(), "BaseASM Service, service error: %s", th2.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC7185ho.m43820b(AbstractC7315b.this.mo45082b(), "PPS remote service disconnected");
            AbstractC7315b.this.m45067a((AbstractC7315b) null);
        }
    };

    /* renamed from: com.huawei.openalliance.ad.ipc.b$a */
    public static abstract class a<SERVICE extends IInterface> {

        /* renamed from: a */
        private C7314a f34014a;

        /* renamed from: a */
        public abstract void mo45090a(SERVICE service);

        public void finalize() {
            try {
                super.finalize();
                AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f34014a != null) {
                            a.this.f34014a.m45063b();
                        }
                    }
                });
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("BaseAidlSer", "finalize err: %s", th2.getClass().getSimpleName());
            }
        }

        /* renamed from: a */
        public void m45091a(C7314a c7314a) {
            this.f34014a = c7314a;
        }

        /* renamed from: a */
        public void mo45092a(String str) {
        }
    }

    public AbstractC7315b(Context context) {
        this.f33996a = context.getApplicationContext();
        this.f33997b = new C6922c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m45077i() {
        boolean z10;
        synchronized (this.f34002g) {
            z10 = this.f34001f;
        }
        return z10;
    }

    /* renamed from: j */
    private boolean m45078j() {
        try {
            AbstractC7185ho.m43820b(mo45082b(), "bindService " + System.currentTimeMillis());
            Intent intent = new Intent(mo45083c());
            String strMo45084d = mo45084d();
            intent.setPackage(strMo45084d);
            if (!C6982bz.m41152b(this.f33996a) && C7830i.m48423a(strMo45084d)) {
                String strM48435e = C7830i.m48435e(this.f33996a, strMo45084d);
                boolean zIsEmpty = TextUtils.isEmpty(strM48435e);
                AbstractC7185ho.m43821b(mo45082b(), "is sign empty: %s", Boolean.valueOf(zIsEmpty));
                if (!zIsEmpty && !WhiteListPkgList.isTrustApp(this.f33996a, strMo45084d, strM48435e)) {
                    return false;
                }
            }
            boolean zBindService = this.f33996a.bindService(intent, this.f34005j, 1);
            AbstractC7185ho.m43821b(mo45082b(), "bind service result: %s", Boolean.valueOf(zBindService));
            if (!zBindService) {
                m45072a("bind service failed");
                m45073a((String) null, "bind result false");
            }
            return zBindService;
        } catch (SecurityException e10) {
            AbstractC7185ho.m43823c(mo45082b(), "bindService SecurityException");
            m45072a("bindService SecurityException");
            m45073a(e10.getClass().getSimpleName(), e10.getMessage());
            return false;
        } catch (Exception e11) {
            AbstractC7185ho.m43823c(mo45082b(), "bindService " + e11.getClass().getSimpleName());
            m45072a("bindService " + e11.getClass().getSimpleName());
            m45073a(e11.getClass().getSimpleName(), e11.getMessage());
            return false;
        }
    }

    /* renamed from: k */
    private synchronized SERVICE m45079k() {
        return this.f34000e;
    }

    /* renamed from: a */
    public abstract SERVICE mo45080a(IBinder iBinder);

    /* renamed from: b */
    public String mo45082b() {
        return "";
    }

    /* renamed from: c */
    public abstract String mo45083c();

    /* renamed from: d */
    public abstract String mo45084d();

    /* renamed from: e */
    public boolean mo45085e() {
        return true;
    }

    /* renamed from: f */
    public abstract boolean mo45086f();

    /* renamed from: g */
    public abstract String mo45087g();

    /* renamed from: h */
    public abstract String mo45088h();

    @Override // com.huawei.openalliance.p169ad.ipc.C7314a.a
    /* renamed from: a */
    public synchronized void mo45064a() {
        this.f33996a.unbindService(this.f34005j);
        this.f34000e = null;
    }

    /* renamed from: a */
    private void m45066a(long j10) {
        AbstractC7817dj.m48366a(this.f33999d);
        m45074a(false);
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.b.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b(AbstractC7315b.this.mo45082b(), "bind timeout " + System.currentTimeMillis());
                AbstractC7315b.this.m45074a(true);
                AbstractC7315b.this.m45072a("service bind timeout");
            }
        }, this.f33999d, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m45067a(SERVICE service) {
        this.f34000e = service;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m45081a(a aVar, long j10) {
        AbstractC7185ho.m43817a(mo45082b(), "handleTask");
        aVar.m45091a(this.f33998c);
        this.f33998c.m45062a();
        IInterface iInterfaceM45079k = m45079k();
        if (iInterfaceM45079k != null) {
            aVar.mo45090a((a) iInterfaceM45079k);
            return;
        }
        if (this.f34004i < 0) {
            this.f34004i = AbstractC7741ao.m47566c();
        }
        this.f34003h.add(aVar);
        if (m45078j() && mo45085e()) {
            m45066a(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45072a(String str) {
        try {
            ArrayList arrayList = new ArrayList(this.f34003h);
            this.f34003h.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).mo45092a(str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45073a(final String str, final String str2) {
        if (mo45086f()) {
            final long jM47566c = AbstractC7741ao.m47566c() - this.f34004i;
            AbstractC7185ho.m43818a(mo45082b(), "aidl bind duration: %d msg: %s", Long.valueOf(jM47566c), str2);
            AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.b.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7315b abstractC7315b = AbstractC7315b.this;
                    abstractC7315b.f33997b.m39096a(abstractC7315b.mo45087g(), jM47566c, str, str2, -1);
                }
            });
            this.f34004i = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45074a(boolean z10) {
        synchronized (this.f34002g) {
            this.f34001f = z10;
        }
    }
}
