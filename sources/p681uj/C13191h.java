package p681uj;

import com.huawei.feedback.log.BaseLogger;

/* renamed from: uj.h */
/* loaded from: classes5.dex */
public class C13191h {

    /* renamed from: a */
    public InterfaceC13190g f59721a;

    /* renamed from: uj.h$b */
    public static class b {

        /* renamed from: a */
        public static C13191h f59722a = new C13191h();
    }

    /* renamed from: a */
    public static C13191h m79248a() {
        return b.f59722a;
    }

    /* renamed from: b */
    public boolean m79249b(String str) {
        InterfaceC13190g interfaceC13190g = this.f59721a;
        if (interfaceC13190g != null) {
            return interfaceC13190g.mo60738d(str);
        }
        BaseLogger.m28731e("HiCloudSysParamManagerInvokerImpl", "isFeatureSwitchOpenWithAccount hiCloudSysParamMapInvoker is null");
        return false;
    }

    /* renamed from: c */
    public boolean m79250c(String str) {
        InterfaceC13190g interfaceC13190g = this.f59721a;
        if (interfaceC13190g != null) {
            return interfaceC13190g.mo60734b(str);
        }
        BaseLogger.m28735w("HiCloudSysParamManagerInvokerImpl", "isFreeUser hiCloudSysParamMapInvoker is null");
        return false;
    }

    /* renamed from: d */
    public boolean m79251d() {
        InterfaceC13190g interfaceC13190g = this.f59721a;
        if (interfaceC13190g != null) {
            return interfaceC13190g.mo60736c();
        }
        BaseLogger.m28731e("HiCloudSysParamManagerInvokerImpl", "isOMUseDefaultFlowControl hiCloudSysParamMapInvoker is null");
        return false;
    }

    /* renamed from: e */
    public boolean m79252e() {
        InterfaceC13190g interfaceC13190g = this.f59721a;
        if (interfaceC13190g != null) {
            return interfaceC13190g.mo60732a();
        }
        BaseLogger.m28731e("HiCloudSysParamManagerInvokerImpl", "isOMUseDefaultGzip hiCloudSysParamMapInvoker is null");
        return false;
    }

    /* renamed from: f */
    public void m79253f(InterfaceC13190g interfaceC13190g) {
        this.f59721a = interfaceC13190g;
    }

    public C13191h() {
    }
}
