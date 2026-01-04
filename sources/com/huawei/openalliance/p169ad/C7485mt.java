package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hms.ppskit.InterfaceC4310a;
import com.huawei.openalliance.p169ad.ipc.AbstractC7315b;
import com.huawei.openalliance.p169ad.ipc.C7314a;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.mt */
/* loaded from: classes8.dex */
public class C7485mt extends AbstractC7315b<InterfaceC4310a> {

    /* renamed from: d */
    private static C7485mt f34703d;

    /* renamed from: e */
    private static final byte[] f34704e = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.mt$a */
    public interface a {
        /* renamed from: a */
        void mo42339a(String str, String str2);
    }

    /* renamed from: com.huawei.openalliance.ad.mt$b */
    public static class b extends AbstractC7315b.a<InterfaceC4310a> {

        /* renamed from: a */
        private String f34705a;

        /* renamed from: b */
        private a f34706b;

        public b(String str, a aVar) {
            this.f34705a = str;
            this.f34706b = aVar;
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo45090a(InterfaceC4310a interfaceC4310a) {
            try {
                String strMo25930a = interfaceC4310a.mo25930a(this.f34705a);
                a aVar = this.f34706b;
                if (aVar != null) {
                    aVar.mo42339a(this.f34705a, strMo25930a);
                }
            } catch (RemoteException unused) {
                AbstractC7185ho.m43823c("ChannelInfoService", "QueryChannelInfo RemoteException");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mt$c */
    public static class c extends AbstractC7315b.a<InterfaceC4310a> {

        /* renamed from: a */
        private String f34707a;

        /* renamed from: b */
        private String f34708b;

        /* renamed from: c */
        private int f34709c;

        public c(String str, String str2, int i10) {
            this.f34707a = str;
            this.f34708b = str2;
            this.f34709c = i10;
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo45090a(InterfaceC4310a interfaceC4310a) {
            try {
                interfaceC4310a.mo25931a(this.f34707a, this.f34708b, this.f34709c);
            } catch (RemoteException unused) {
                AbstractC7185ho.m43823c("ChannelInfoService", "setInstallSource RemoteException");
            }
        }
    }

    private C7485mt(Context context) {
        super(context);
        this.f33998c = new C7314a(context, mo45082b(), this);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC4310a mo45080a(IBinder iBinder) {
        return InterfaceC4310a.a.m25932a(iBinder);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: c */
    public String mo45083c() {
        return "com.huawei.android.hms.CHANNEL_SERVICE";
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: d */
    public String mo45084d() {
        return C7830i.m48434e(this.f33996a);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: e */
    public boolean mo45085e() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: f */
    public boolean mo45086f() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: g */
    public String mo45087g() {
        return "42";
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: h */
    public String mo45088h() {
        return "com.huawei.android.hms.ppskit.PpsChannelInfoService";
    }

    /* renamed from: a */
    public static C7485mt m45865a(Context context) {
        C7485mt c7485mt;
        synchronized (f34704e) {
            try {
                if (f34703d == null) {
                    f34703d = new C7485mt(context);
                }
                c7485mt = f34703d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7485mt;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b */
    public final String mo45082b() {
        return "ChannelInfoService";
    }

    /* renamed from: a */
    public void m45866a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("ChannelInfoService", " pkgName is empty");
        } else {
            m45081a(new b(str, aVar), 3000L);
        }
    }

    /* renamed from: a */
    public void m45867a(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        m45081a(new c(str, str2, i10), 3000L);
    }
}
