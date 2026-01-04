package is;

import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import es.C9545j;

/* renamed from: is.d */
/* loaded from: classes8.dex */
public final class C10607d implements InterfaceC10605b {

    /* renamed from: b */
    public static final byte[] f50991b = new byte[0];

    /* renamed from: c */
    public static volatile C10607d f50992c;

    /* renamed from: a */
    public C10611h f50993a = C10611h.m65045f();

    public C10607d() {
        C9545j.m59606g();
    }

    /* renamed from: a */
    public static InterfaceC10605b m65027a() {
        if (f50992c == null) {
            synchronized (f50991b) {
                try {
                    if (f50992c == null) {
                        f50992c = new C10607d();
                    }
                } finally {
                }
            }
        }
        return f50992c;
    }

    /* renamed from: b */
    public final void m65028b(long j10, ARCallback aRCallback, ClientInfo clientInfo) {
        C1016d.m6186f("HwActivityRecognitionManager", "requestActivityUpdates begin.");
        this.f50993a.m65046g(j10, aRCallback, clientInfo);
    }

    /* renamed from: c */
    public final void m65029c(ARCallback aRCallback, ClientInfo clientInfo) {
        C1016d.m6186f("HwActivityRecognitionManager", "removeActivityUpdates begin.");
        this.f50993a.m65048i(aRCallback, clientInfo);
    }

    /* renamed from: d */
    public final void m65030d(String str, ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        this.f50993a.m65047h(activityTransitionRequest, aTCallback, clientInfo);
    }

    /* renamed from: e */
    public final void m65031e(String str, ATCallback aTCallback, ClientInfo clientInfo) {
        this.f50993a.m65049j(aTCallback, clientInfo);
    }
}
