package p681uj;

import com.huawei.feedback.log.BaseLogger;

/* renamed from: uj.b */
/* loaded from: classes5.dex */
public class C13185b {

    /* renamed from: a */
    public InterfaceC13184a f59712a;

    /* renamed from: uj.b$b */
    public static class b {

        /* renamed from: a */
        public static C13185b f59713a = new C13185b();
    }

    /* renamed from: a */
    public static C13185b m79233a() {
        return b.f59713a;
    }

    /* renamed from: b */
    public void m79234b() throws C13194k {
        InterfaceC13184a interfaceC13184a = this.f59712a;
        if (interfaceC13184a == null) {
            BaseLogger.m28731e("ATSuppressionInvokerImpl", "atSuppressionInvoker is null");
        } else {
            interfaceC13184a.mo60682a();
        }
    }

    /* renamed from: c */
    public void m79235c(InterfaceC13184a interfaceC13184a) {
        this.f59712a = interfaceC13184a;
    }

    public C13185b() {
    }
}
