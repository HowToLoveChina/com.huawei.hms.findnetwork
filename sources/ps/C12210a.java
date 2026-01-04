package ps;

import as.C1016d;
import kr.C11144a;
import p404js.C10913b;
import p819yq.C14035a;

/* renamed from: ps.a */
/* loaded from: classes8.dex */
public final class C12210a {

    /* renamed from: a */
    public C11144a f56600a = new C11144a();

    /* renamed from: a */
    public final void m73380a(C14035a c14035a) {
        if (c14035a.m84186f() == null) {
            C1016d.m6186f("NLPProvider", "locationRequest is invalid");
            return;
        }
        C1016d.m6186f("NLPProvider", "requestLocation, LocationRequest is " + c14035a.m84184d().toString());
        this.f56600a.m67050a(c14035a.m84186f(), c14035a.m84187g());
    }

    /* renamed from: b */
    public final void m73381b(C14035a c14035a) {
        if (c14035a.m84187g() != null) {
            this.f56600a.m67052c(c14035a.m84187g());
        }
        if (c14035a.m84186f() != null) {
            C10913b.m65957f().m65966h(c14035a.m84186f());
        }
    }
}
