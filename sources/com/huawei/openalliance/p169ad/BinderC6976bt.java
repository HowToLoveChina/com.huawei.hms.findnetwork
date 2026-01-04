package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.uiengine.InterfaceC5106a;
import com.huawei.hms.ads.uiengine.InterfaceC5107b;
import com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.bt */
/* loaded from: classes8.dex */
public class BinderC6976bt extends InterfaceC5107b.a {

    /* renamed from: a */
    private static BinderC6976bt f32038a;

    /* renamed from: b */
    private static final byte[] f32039b = new byte[0];

    /* renamed from: c */
    private Context f32040c;

    /* renamed from: d */
    private IMultiMediaPlayingManager f32041d;

    /* renamed from: e */
    private final Map<Long, C6975bs> f32042e = new HashMap();

    private BinderC6976bt(Context context) {
        this.f32040c = context;
    }

    /* renamed from: a */
    public static BinderC6976bt m41068a(Context context) {
        return m41069b(context);
    }

    /* renamed from: b */
    private static BinderC6976bt m41069b(Context context) {
        BinderC6976bt binderC6976bt;
        synchronized (f32039b) {
            try {
                if (f32038a == null) {
                    f32038a = new BinderC6976bt(context);
                }
                binderC6976bt = f32038a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return binderC6976bt;
    }

    /* renamed from: c */
    private Long m41070c(InterfaceC5106a interfaceC5106a) {
        if (interfaceC5106a == null) {
            return null;
        }
        try {
            return Long.valueOf(interfaceC5106a.mo30465a());
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "get id err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: d */
    private C6975bs m41071d(InterfaceC5106a interfaceC5106a) {
        C6975bs c6975bs;
        try {
            long jMo30465a = interfaceC5106a.mo30465a();
            if (this.f32042e.containsKey(Long.valueOf(jMo30465a))) {
                c6975bs = this.f32042e.get(Long.valueOf(jMo30465a));
            } else {
                C6975bs c6975bs2 = new C6975bs(this.f32040c, interfaceC5106a);
                this.f32042e.put(Long.valueOf(jMo30465a), c6975bs2);
                c6975bs = c6975bs2;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("MultiMPlayingManagerPro", "getProxy = %s, proxy = %s", Long.valueOf(jMo30465a), c6975bs);
            }
            return c6975bs;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "getProxy err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: a */
    public void mo30476a(InterfaceC5106a interfaceC5106a) {
        Long lM41070c = m41070c(interfaceC5106a);
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "removeAgent %s", lM41070c);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.removeMediaPlayerAgent(m41071d(interfaceC5106a));
        }
        if (lM41070c != null) {
            this.f32042e.remove(lM41070c);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: b */
    public void mo30478b(InterfaceC5106a interfaceC5106a) {
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "removeListeners %s", m41070c(interfaceC5106a));
        C6975bs c6975bsM41071d = m41071d(interfaceC5106a);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.removeListenersForMediaPlayerAgent(c6975bsM41071d);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: c */
    public void mo30480c(String str, InterfaceC5106a interfaceC5106a) {
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "stop %s", m41070c(interfaceC5106a));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.stop(str, m41071d(interfaceC5106a));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: d */
    public void mo30481d(String str, InterfaceC5106a interfaceC5106a) {
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "pause %s", m41070c(interfaceC5106a));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.pause(str, m41071d(interfaceC5106a));
        }
    }

    /* renamed from: a */
    public void m41072a(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.f32041d = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: b */
    public void mo30479b(String str, InterfaceC5106a interfaceC5106a) {
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "manualPlay %s", m41070c(interfaceC5106a));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.manualPlay(str, m41071d(interfaceC5106a));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
    /* renamed from: a */
    public void mo30477a(String str, InterfaceC5106a interfaceC5106a) {
        AbstractC7185ho.m43821b("MultiMPlayingManagerPro", "autoPlay %s", m41070c(interfaceC5106a));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f32041d;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.autoPlay(str, m41071d(interfaceC5106a));
        }
    }
}
