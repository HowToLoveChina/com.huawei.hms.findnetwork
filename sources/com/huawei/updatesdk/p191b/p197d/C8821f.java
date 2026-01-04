package com.huawei.updatesdk.p191b.p197d;

import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.InterfaceC8798a;
import com.huawei.updatesdk.p191b.p198e.C8826e;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import com.huawei.updatesdk.service.appmgr.bean.C8842a;
import com.huawei.updatesdk.service.appmgr.bean.C8843b;
import com.huawei.updatesdk.service.appmgr.bean.C8844c;
import com.huawei.updatesdk.service.otaupdate.C8871f;
import com.huawei.updatesdk.service.otaupdate.InterfaceC8867b;

/* renamed from: com.huawei.updatesdk.b.d.f */
/* loaded from: classes9.dex */
public class C8821f {

    /* renamed from: a */
    private static InterfaceC8867b f45159a;

    /* renamed from: com.huawei.updatesdk.b.d.f$a */
    public static class a implements InterfaceC8798a {

        /* renamed from: a */
        private final boolean f45160a;

        public a(boolean z10) {
            this.f45160a = z10;
        }

        @Override // com.huawei.updatesdk.p177a.p186b.p189c.p190c.InterfaceC8798a
        /* renamed from: a */
        public void mo56164a(C8800c c8800c, C8801d c8801d) {
        }

        @Override // com.huawei.updatesdk.p177a.p186b.p189c.p190c.InterfaceC8798a
        /* renamed from: b */
        public void mo56165b(C8800c c8800c, C8801d c8801d) {
            if (C8821f.f45159a == null) {
                return;
            }
            if (!(c8801d instanceof C8843b)) {
                C8821f.f45159a.mo56435a(c8801d.m56182d());
                return;
            }
            C8843b c8843b = (C8843b) c8801d;
            if (!c8843b.m56183e()) {
                C8821f.f45159a.mo56437b(c8801d.m56182d());
                return;
            }
            C8844c c8844cM56367f = c8843b.m56367f();
            if (c8844cM56367f == null) {
                C8821f.f45159a.mo56435a(c8801d.m56182d());
                return;
            }
            if (!this.f45160a) {
                C8826e.m56286a(false).mo56276a(c8844cM56367f.m56371d());
            }
            C8821f.f45159a.mo56436a(c8844cM56367f);
        }
    }

    /* renamed from: a */
    public static void m56267a(InterfaceC8867b interfaceC8867b) {
        f45159a = interfaceC8867b;
    }

    /* renamed from: a */
    public static void m56268a(boolean z10) {
        C8831b.m56297a(new C8842a(z10 ? C8871f.m56464e().m56469c() : null), new a(z10));
    }
}
