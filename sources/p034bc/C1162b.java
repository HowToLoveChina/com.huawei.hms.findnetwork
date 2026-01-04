package p034bc;

import android.app.Activity;
import android.content.Context;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13455h;
import p709vj.InterfaceC13456i;

/* renamed from: bc.b */
/* loaded from: classes3.dex */
public class C1162b {

    /* renamed from: b */
    public static final C1162b f5461b = new C1162b();

    /* renamed from: a */
    public InterfaceC13455h f5462a;

    /* renamed from: a */
    public static C1162b m7257a() {
        return f5461b;
    }

    /* renamed from: b */
    public void m7258b(Context context, InterfaceC13456i interfaceC13456i) {
        InterfaceC13455h interfaceC13455h = this.f5462a;
        if (interfaceC13455h != null) {
            interfaceC13455h.mo80999a(context, interfaceC13456i);
        }
    }

    /* renamed from: c */
    public boolean m7259c() {
        InterfaceC13455h interfaceC13455h = this.f5462a;
        if (interfaceC13455h != null) {
            return interfaceC13455h.isLogin();
        }
        return false;
    }

    /* renamed from: d */
    public void m7260d(Activity activity, InterfaceC13449b interfaceC13449b) {
        InterfaceC13455h interfaceC13455h = this.f5462a;
        if (interfaceC13455h != null) {
            interfaceC13455h.mo81001c(activity, interfaceC13449b);
        }
    }

    /* renamed from: e */
    public void m7261e(InterfaceC13455h interfaceC13455h) {
        this.f5462a = interfaceC13455h;
    }
}
