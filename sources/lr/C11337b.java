package lr;

import as.C1016d;
import com.huawei.location.sdm.InterfaceC6822i;
import com.huawei.location.sdm.Sdm;

/* renamed from: lr.b */
/* loaded from: classes8.dex */
public final class C11337b {

    /* renamed from: a */
    public InterfaceC6822i f53035a = null;

    /* renamed from: b */
    public Sdm f53036b;

    /* renamed from: lr.b$a */
    public interface a {
    }

    public C11337b() {
        this.f53036b = null;
        this.f53036b = new Sdm();
    }

    /* renamed from: a */
    public final void m68119a() {
        InterfaceC6822i interfaceC6822i = this.f53035a;
        if (interfaceC6822i == null) {
            C1016d.m6186f("SdmWrapper", "no need stop");
            return;
        }
        Sdm sdm = this.f53036b;
        if (sdm == null) {
            C1016d.m6183c("SdmWrapper", "no sdm to stop");
            return;
        }
        sdm.m38521l(interfaceC6822i);
        this.f53035a = null;
        C1016d.m6186f("SdmWrapper", "sdm stop success");
    }

    /* renamed from: b */
    public final void m68120b(C11339d c11339d) {
        m68119a();
        Sdm sdm = this.f53036b;
        if (sdm == null) {
            C1016d.m6183c("SdmWrapper", "no sdm to start");
            return;
        }
        C11336a c11336a = new C11336a(c11339d);
        this.f53035a = c11336a;
        sdm.m38522m(c11336a);
        C1016d.m6186f("SdmWrapper", "sdm start success");
    }

    /* renamed from: c */
    public final boolean m68121c(long j10, float f10) {
        Sdm sdm = this.f53036b;
        if (sdm == null) {
            return false;
        }
        return sdm.support(j10, f10);
    }
}
