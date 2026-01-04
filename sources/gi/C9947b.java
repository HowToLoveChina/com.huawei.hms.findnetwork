package gi;

import com.huawei.cloud.base.http.C4599c0;
import com.huawei.cloud.base.http.C4600d;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.InterfaceC4608k;
import com.huawei.cloud.base.http.InterfaceC4614q;
import java.io.IOException;

/* renamed from: gi.b */
/* loaded from: classes.dex */
public final class C9947b implements InterfaceC4608k, InterfaceC4614q {

    /* renamed from: a */
    public final boolean f48716a;

    public C9947b() {
        this(false);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4614q
    /* renamed from: a */
    public void mo28303a(C4612o c4612o) {
        c4612o.m28261B(this);
    }

    /* renamed from: b */
    public final boolean m61630b(C4612o c4612o) throws IOException {
        String strM28282n = c4612o.m28282n();
        if (strM28282n.equals("POST")) {
            return false;
        }
        if (!strM28282n.equals("GET") ? this.f48716a : c4612o.m28288t().m28198p().length() > 2048) {
            return !c4612o.m28286r().supportsMethod(strM28282n);
        }
        return true;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4608k
    /* renamed from: c */
    public void mo28207c(C4612o c4612o) throws IOException {
        if (m61630b(c4612o)) {
            String strM28282n = c4612o.m28282n();
            c4612o.m28264E("POST");
            c4612o.m28277i().set("X-HTTP-Method-Override", strM28282n);
            if (strM28282n.equals("GET")) {
                c4612o.m28292x(new C4599c0(c4612o.m28288t().clone()));
                c4612o.m28288t().clear();
            } else if (c4612o.m28274f() == null) {
                c4612o.m28292x(new C4600d());
            }
        }
    }

    public C9947b(boolean z10) {
        this.f48716a = z10;
    }
}
