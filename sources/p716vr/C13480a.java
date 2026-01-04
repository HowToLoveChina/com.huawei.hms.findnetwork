package p716vr;

import java.io.IOException;
import mr.C11506a;
import mr.C11507b;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import tr.C13065i;
import tr.InterfaceC13062f;

/* renamed from: vr.a */
/* loaded from: classes8.dex */
public class C13480a implements InterfaceC13062f {
    @Override // tr.InterfaceC13062f
    /* renamed from: a */
    public C13065i mo78788a(InterfaceC13062f.a aVar) throws C13245e, C13244d, IOException {
        return aVar.mo78789a(m81163b(aVar.request()));
    }

    /* renamed from: b */
    public final C13851a m81163b(C13851a c13851a) {
        C11507b c11507bM68685c = C11506a.m68682e().m68685c();
        return c11507bM68685c == null ? c13851a : c13851a.m83129i().m83139i("expireTime", String.valueOf(c11507bM68685c.m68690b())).m83139i("token", c11507bM68685c.m68689a()).m83141k();
    }
}
