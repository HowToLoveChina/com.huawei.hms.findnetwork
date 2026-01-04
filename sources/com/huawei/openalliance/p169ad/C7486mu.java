package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hms.ppskit.InterfaceC4311b;
import com.huawei.android.hms.ppskit.InterfaceC4312c;
import com.huawei.android.hms.ppskit.RemoteInstallReq;
import com.huawei.openalliance.p169ad.ipc.AbstractC7315b;
import com.huawei.openalliance.p169ad.ipc.C7314a;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.mu */
/* loaded from: classes8.dex */
public class C7486mu extends AbstractC7315b<InterfaceC4311b> {

    /* renamed from: d */
    private static C7486mu f34710d;

    /* renamed from: e */
    private static final byte[] f34711e = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.mu$a */
    public static abstract class a implements InterfaceC4312c {
        /* renamed from: a */
        public abstract void mo45875a(String str);

        @Override // com.huawei.android.hms.ppskit.InterfaceC4312c
        /* renamed from: a */
        public abstract /* synthetic */ void mo25937a(boolean z10, int i10);

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mu$b */
    public static class b extends InterfaceC4312c.a {

        /* renamed from: a */
        private a f34712a;

        public b(a aVar) {
            this.f34712a = aVar;
        }

        @Override // com.huawei.android.hms.ppskit.InterfaceC4312c
        /* renamed from: a */
        public void mo25937a(boolean z10, int i10) {
            a aVar = this.f34712a;
            if (aVar != null) {
                aVar.mo25937a(z10, i10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mu$c */
    public static class c extends AbstractC7315b.a<InterfaceC4311b> {

        /* renamed from: a */
        private a f34713a;

        /* renamed from: b */
        private RemoteInstallReq f34714b;

        /* renamed from: c */
        private Uri f34715c;

        public c(a aVar, RemoteInstallReq remoteInstallReq, Uri uri) {
            this.f34713a = aVar;
            this.f34714b = remoteInstallReq;
            this.f34715c = uri;
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo45090a(InterfaceC4311b interfaceC4311b) {
            try {
                AbstractC7185ho.m43820b("PPSInstallServiceManager", "call install service");
                interfaceC4311b.mo25934a(this.f34714b, this.f34715c, new b(this.f34713a));
            } catch (RemoteException e10) {
                AbstractC7185ho.m43823c("PPSInstallServiceManager", "pkg install RemoteException");
                a aVar = this.f34713a;
                if (aVar != null) {
                    aVar.mo45875a("pkg install RemoteException: " + e10.getClass().getSimpleName());
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a */
        public void mo45092a(String str) {
            a aVar = this.f34713a;
            if (aVar != null) {
                aVar.mo45875a(str);
            }
        }
    }

    private C7486mu(Context context) {
        super(context);
        this.f33998c = new C7314a(context, mo45082b(), this);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC4311b mo45080a(IBinder iBinder) {
        return InterfaceC4311b.a.m25936h(iBinder);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: c */
    public String mo45083c() {
        return "com.huawei.openalliance.ad.INSTALL_SERVICE";
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: d */
    public String mo45084d() {
        return C7830i.m48434e(this.f33996a);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: f */
    public boolean mo45086f() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: g */
    public String mo45087g() {
        return "44";
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: h */
    public String mo45088h() {
        return "com.huawei.android.hms.ppskit.PpsInstallationService";
    }

    /* renamed from: a */
    public static C7486mu m45871a(Context context) {
        C7486mu c7486mu;
        synchronized (f34711e) {
            try {
                if (f34710d == null) {
                    f34710d = new C7486mu(context);
                }
                c7486mu = f34710d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7486mu;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b */
    public final String mo45082b() {
        return "PPSInstallServiceManager";
    }

    /* renamed from: a */
    public void m45872a(RemoteInstallReq remoteInstallReq, Uri uri, a aVar) {
        m45873a(remoteInstallReq, uri, aVar, 3000L);
    }

    /* renamed from: a */
    public void m45873a(RemoteInstallReq remoteInstallReq, Uri uri, a aVar, long j10) {
        if (aVar == null) {
            return;
        }
        m45081a(new c(aVar, remoteInstallReq, uri), j10);
    }
}
