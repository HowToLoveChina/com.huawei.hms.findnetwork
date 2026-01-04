package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.hquic.HQUICManager;
import com.huawei.hms.network.NetworkKit;
import com.huawei.openalliance.p169ad.net.http.C7502e;
import com.huawei.openalliance.p169ad.net.http.C7508k;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.huawei.openalliance.ad.jx */
/* loaded from: classes8.dex */
public class C7350jx {

    /* renamed from: f */
    private static C7350jx f34279f;

    /* renamed from: h */
    private static final byte[] f34280h = new byte[0];

    /* renamed from: a */
    private Context f34281a;

    /* renamed from: b */
    private volatile boolean f34282b;

    /* renamed from: c */
    private volatile boolean f34283c;

    /* renamed from: d */
    private volatile boolean f34284d;

    /* renamed from: e */
    private final byte[] f34285e = new byte[0];

    /* renamed from: g */
    private InterfaceC7146gc f34286g;

    /* renamed from: com.huawei.openalliance.ad.jx$a */
    public static class a implements HQUICManager.HQUICInitCallback {
        private a() {
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onFail(Exception exc) {
            Log.i("QuicNetworkKit", "HQUICManager.asyncInit failed.");
            AbstractC7185ho.m43820b("QuicNetworkKit", "HQUICManager.asyncInit failed.");
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onSuccess() {
            Log.i("QuicNetworkKit", "HQUICManager.asyncInit success");
            AbstractC7185ho.m43820b("QuicNetworkKit", "HQUICManager.asyncInit success");
        }
    }

    private C7350jx(Context context) {
        this.f34281a = context.getApplicationContext();
        this.f34286g = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public static C7350jx m45424a(Context context) {
        C7350jx c7350jx;
        synchronized (f34280h) {
            try {
                if (f34279f == null) {
                    f34279f = new C7350jx(context);
                }
                c7350jx = f34279f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7350jx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m45428d() {
        if (!this.f34282b) {
            AbstractC7185ho.m43820b("QuicNetworkKit", "configureQuicHint isNetworkKitEnable:" + this.f34282b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("adxServer");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strMo43324a = this.f34286g.mo43324a(this.f34281a, (String) it.next());
            if (!TextUtils.isEmpty(strMo43324a)) {
                arrayList2.add(strMo43324a);
                AbstractC7185ho.m43818a("QuicNetworkKit", "get quic url: %s", strMo43324a);
            }
        }
        if (arrayList2.size() <= 0 || this.f34284d) {
            AbstractC7185ho.m43821b("QuicNetworkKit", "add quic url, quicUrlList is empty or hasAddQuicHint: %s", Boolean.valueOf(this.f34284d));
        } else {
            NetworkKit.getInstance().addQuicHint(true, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            this.f34284d = true;
            AbstractC7185ho.m43820b("QuicNetworkKit", "add quic success.");
        }
        m45429e();
    }

    /* renamed from: e */
    private void m45429e() {
        new C7508k(this.f34281a).m46085a(new C7502e.a(this.f34281a).m46067c(2).m46068c(this.f34283c).m46063a());
    }

    /* renamed from: c */
    public void m45432c() {
        final int iMo43042T;
        synchronized (this.f34285e) {
            try {
                try {
                    Log.i("QuicNetworkKit", "setUp");
                    iMo43042T = this.f34286g.mo43042T();
                    Log.i("QuicNetworkKit", "networkkit configure:" + iMo43042T);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("QuicNetworkKit", "setUp network kit err, %s", th2.getClass().getSimpleName());
                }
                if (C7775bv.m47825a() && (iMo43042T == 1 || iMo43042T == 2)) {
                    if (this.f34282b) {
                        if (iMo43042T == 2) {
                            m45428d();
                        } else {
                            AbstractC7185ho.m43820b("QuicNetworkKit", "if quic open, can not close quic until app restart.");
                        }
                        AbstractC7185ho.m43820b("QuicNetworkKit", "network kit has been init");
                    } else {
                        if (iMo43042T == 2 && C7775bv.m47827b()) {
                            this.f34283c = true;
                            HQUICManager.asyncInit(this.f34281a.getApplicationContext(), "huawei_module_quic_pro", new a());
                        }
                        AbstractC7185ho.m43820b("QuicNetworkKit", "init network kit");
                        NetworkKit.init(this.f34281a, new NetworkKit.Callback() { // from class: com.huawei.openalliance.ad.jx.1
                            @Override // com.huawei.hms.network.NetworkKit.Callback
                            public void onResult(boolean z10) {
                                Log.i("QuicNetworkKit", "network kit init result:" + z10);
                                AbstractC7185ho.m43820b("QuicNetworkKit", "network kit init result:" + z10);
                                C7350jx.this.f34282b = z10;
                                if (C7350jx.this.f34282b && iMo43042T == 2) {
                                    C7350jx.this.m45428d();
                                }
                            }
                        });
                    }
                    return;
                }
                this.f34282b = false;
                AbstractC7185ho.m43820b("QuicNetworkKit", "not support network kit");
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: a */
    public boolean m45430a() {
        return this.f34282b;
    }

    /* renamed from: b */
    public boolean m45431b() {
        return this.f34283c;
    }
}
