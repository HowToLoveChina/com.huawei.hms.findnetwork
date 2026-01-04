package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.download.InterfaceC7032a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.ds */
/* loaded from: classes8.dex */
public class C7075ds implements InterfaceC7032a<C7077du> {

    /* renamed from: a */
    private Map<String, Set<InterfaceC7032a<C7077du>>> f32577a = new ConcurrentHashMap();

    /* renamed from: b */
    private C6927h f32578b;

    /* renamed from: com.huawei.openalliance.ad.ds$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7077du f32579a;

        /* renamed from: b */
        final /* synthetic */ String f32580b;

        /* renamed from: c */
        final /* synthetic */ long f32581c;

        public AnonymousClass1(C7077du c7077du, String str, long j10) {
            c7077du = c7077du;
            str = str;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7075ds.this.f32578b.m39179a(c7077du, str, j);
        }
    }

    public C7075ds(Context context) {
        this.f32578b = new C6927h(context);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: d */
    public void onDownloadProgress(C7077du c7077du) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().onDownloadProgress(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: e */
    public void onDownloadSuccess(C7077du c7077du) {
        m42653a("5", c7077du);
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().onDownloadSuccess(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: f */
    public void mo42101b(C7077du c7077du) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().mo42101b(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: g */
    public void onDownloadFail(C7077du c7077du) {
        m42653a("2", c7077du);
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().onDownloadFail(c7077du);
            }
        }
    }

    /* renamed from: a */
    private synchronized Set<InterfaceC7032a<C7077du>> m42652a(String str) {
        return this.f32577a.get(str);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: c */
    public void onDownloadStart(C7077du c7077du) {
        c7077du.m42699a(Long.valueOf(AbstractC7741ao.m47566c()));
        m42653a("72", c7077du);
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().onDownloadStart(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b */
    public void mo42099a(C7077du c7077du) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().mo42099a(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: c */
    public void mo42103c(C7077du c7077du, boolean z10) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().mo42103c(c7077du, z10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b */
    public void mo42102b(C7077du c7077du, boolean z10) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().mo42102b(c7077du, z10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a */
    public void onDownloadWaiting(C7077du c7077du) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().onDownloadWaiting(c7077du);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a */
    public void mo42100a(C7077du c7077du, boolean z10) {
        Set<InterfaceC7032a<C7077du>> setM42652a = m42652a(c7077du.mo42082n());
        if (setM42652a != null) {
            Iterator<InterfaceC7032a<C7077du>> it = setM42652a.iterator();
            while (it.hasNext()) {
                it.next().mo42100a(c7077du, z10);
            }
        }
    }

    /* renamed from: a */
    private void m42653a(String str, C7077du c7077du) {
        if (this.f32578b != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ds.1

                /* renamed from: a */
                final /* synthetic */ C7077du f32579a;

                /* renamed from: b */
                final /* synthetic */ String f32580b;

                /* renamed from: c */
                final /* synthetic */ long f32581c;

                public AnonymousClass1(C7077du c7077du2, String str2, long j10) {
                    c7077du = c7077du2;
                    str = str2;
                    j = j10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7075ds.this.f32578b.m39179a(c7077du, str, j);
                }
            });
        }
    }
}
