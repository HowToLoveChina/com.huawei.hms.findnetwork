package p716vr;

import as.C1016d;
import java.io.IOException;
import p531or.C11991a;
import p688ur.C13241a;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p820yr.C14038b;
import p853zr.C14371a;
import p857zv.C14387a;
import p857zv.C14389c;
import tr.C13065i;
import tr.InterfaceC13062f;

/* renamed from: vr.f */
/* loaded from: classes8.dex */
public class C13485f extends AbstractC13481b {

    /* renamed from: a */
    public int f60716a = 0;

    @Override // tr.InterfaceC13062f
    /* renamed from: a */
    public C13065i mo78788a(InterfaceC13062f.a aVar) throws C13245e, C13244d, IOException {
        return aVar.mo78789a(m81164b(aVar.request()));
    }

    @Override // p716vr.AbstractC13481b
    /* renamed from: c */
    public C13851a mo81165c(C13851a c13851a, C14038b c14038b) throws IOException {
        try {
            String strM85566h = C14371a.m85559b().m85566h(C11991a.m72145a(), c14038b);
            C1016d.m6181a("UcsAuthInterceptor", "X_REQUEST_ID:" + c13851a.m83125e().m83150c("X-Request-ID"));
            C1016d.m6181a("UcsAuthInterceptor", "auth:" + strM85566h);
            return c13851a.m83129i().m83139i("authorization", strM85566h).m83141k();
        } catch (C14387a e10) {
            C1016d.m6183c("UcsAuthInterceptor", "UcsCryptoException:" + e10.getMessage());
            if (this.m81171d(e10.m85618b())) {
                return this.mo81165c(c13851a, c14038b);
            }
            C1016d.m6183c("UcsAuthInterceptor", "AuthException:10550");
            throw new C13241a(C13243c.m79629a(10550));
        } catch (C14389c e11) {
            C1016d.m6183c("UcsAuthInterceptor", "UcsException:errorCode:" + e11.m85620b() + ",message:" + e11.getMessage());
            if (this.m81171d(e11.m85620b())) {
                return this.mo81165c(c13851a, c14038b);
            }
            C1016d.m6183c("UcsAuthInterceptor", "AuthException:10550");
            throw new C13241a(C13243c.m79629a(10550));
        }
    }

    /* renamed from: d */
    public final boolean m81171d(long j10) {
        if (j10 != 1020) {
            return false;
        }
        int i10 = this.f60716a + 1;
        this.f60716a = i10;
        if (i10 > 3) {
            return false;
        }
        C14371a.m85559b().m85564f();
        return true;
    }
}
