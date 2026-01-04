package p755wx;

import com.huawei.hms.network.embedded.C6090s9;
import com.huawei.hms.network.embedded.C6142w9;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11955v;
import okhttp3.EnumC11914c0;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11935i;
import p022ay.C1050a0;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;
import p693ux.C13280e;
import p693ux.C13284i;
import p693ux.C13286k;
import p693ux.InterfaceC13278c;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: wx.g */
/* loaded from: classes9.dex */
public final class C13658g implements InterfaceC13278c {

    /* renamed from: g */
    public static final List<String> f61480g = C12875e.m77264u(C6142w9.f28867h, "host", C6142w9.f28869j, C6142w9.f28870k, C6142w9.f28872m, C6142w9.f28871l, C6142w9.f28873n, C6142w9.f28874o, C6090s9.f28234f, C6090s9.f28235g, C6090s9.f28236h, C6090s9.f28237i);

    /* renamed from: h */
    public static final List<String> f61481h = C12875e.m77264u(C6142w9.f28867h, "host", C6142w9.f28869j, C6142w9.f28870k, C6142w9.f28872m, C6142w9.f28871l, C6142w9.f28873n, C6142w9.f28874o);

    /* renamed from: a */
    public final InterfaceC11959z.a f61482a;

    /* renamed from: b */
    public final C11935i f61483b;

    /* renamed from: c */
    public final C13657f f61484c;

    /* renamed from: d */
    public volatile C13660i f61485d;

    /* renamed from: e */
    public final EnumC11914c0 f61486e;

    /* renamed from: f */
    public volatile boolean f61487f;

    public C13658g(C11912b0 c11912b0, C11935i c11935i, InterfaceC11959z.a aVar, C13657f c13657f) {
        this.f61483b = c11935i;
        this.f61482a = aVar;
        this.f61484c = c13657f;
        List<EnumC11914c0> listM71464C = c11912b0.m71464C();
        EnumC11914c0 enumC11914c0 = EnumC11914c0.H2_PRIOR_KNOWLEDGE;
        this.f61486e = listM71464C.contains(enumC11914c0) ? enumC11914c0 : EnumC11914c0.HTTP_2;
    }

    /* renamed from: i */
    public static List<C13654c> m82123i(C11918e0 c11918e0) {
        C11955v c11955vM71566f = c11918e0.m71566f();
        ArrayList arrayList = new ArrayList(c11955vM71566f.m71857j() + 4);
        arrayList.add(new C13654c(C13654c.f61379f, c11918e0.m71569i()));
        arrayList.add(new C13654c(C13654c.f61380g, C13284i.m79729c(c11918e0.m71573m())));
        String strM71565e = c11918e0.m71565e(FeedbackWebConstants.HOST);
        if (strM71565e != null) {
            arrayList.add(new C13654c(C13654c.f61382i, strM71565e));
        }
        arrayList.add(new C13654c(C13654c.f61381h, c11918e0.m71573m().m71896B()));
        int iM71857j = c11955vM71566f.m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            String lowerCase = c11955vM71566f.m71854e(i10).toLowerCase(Locale.US);
            if (!f61480g.contains(lowerCase) || (lowerCase.equals(C6142w9.f28872m) && c11955vM71566f.m71859l(i10).equals("trailers"))) {
                arrayList.add(new C13654c(lowerCase, c11955vM71566f.m71859l(i10)));
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public static C11922g0.a m82124j(C11955v c11955v, EnumC11914c0 enumC11914c0) throws NumberFormatException, IOException {
        C11955v.a aVar = new C11955v.a();
        int iM71857j = c11955v.m71857j();
        C13286k c13286kM79735a = null;
        for (int i10 = 0; i10 < iM71857j; i10++) {
            String strM71854e = c11955v.m71854e(i10);
            String strM71859l = c11955v.m71859l(i10);
            if (strM71854e.equals(C6090s9.f28233e)) {
                c13286kM79735a = C13286k.m79735a("HTTP/1.1 " + strM71859l);
            } else if (!f61481h.contains(strM71854e)) {
                AbstractC12871a.f58633a.mo71497b(aVar, strM71854e, strM71859l);
            }
        }
        if (c13286kM79735a != null) {
            return new C11922g0.a().m71617o(enumC11914c0).m71609g(c13286kM79735a.f60003b).m71614l(c13286kM79735a.f60004c).m71612j(aVar.m71864d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: a */
    public void mo79701a() throws IOException {
        this.f61485d.m82148h().close();
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: b */
    public void mo79702b(C11918e0 c11918e0) throws IOException {
        if (this.f61485d != null) {
            return;
        }
        this.f61485d = this.f61484c.m82085C(m82123i(c11918e0), c11918e0.m71562b() != null);
        if (this.f61487f) {
            this.f61485d.m82146f(EnumC13653b.CANCEL);
            throw new IOException("Canceled");
        }
        C1050a0 c1050a0M82152l = this.f61485d.m82152l();
        long jMo71932a = this.f61482a.mo71932a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c1050a0M82152l.timeout(jMo71932a, timeUnit);
        this.f61485d.m82158r().timeout(this.f61482a.mo71933b(), timeUnit);
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: c */
    public InterfaceC1076z mo79703c(C11922g0 c11922g0) {
        return this.f61485d.m82149i();
    }

    @Override // p693ux.InterfaceC13278c
    public void cancel() {
        this.f61487f = true;
        if (this.f61485d != null) {
            this.f61485d.m82146f(EnumC13653b.CANCEL);
        }
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: d */
    public C11922g0.a mo79704d(boolean z10) throws NumberFormatException, IOException {
        C11922g0.a aVarM82124j = m82124j(this.f61485d.m82156p(), this.f61486e);
        if (z10 && AbstractC12871a.f58633a.mo71499d(aVarM82124j) == 100) {
            return null;
        }
        return aVarM82124j;
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: e */
    public C11935i mo79705e() {
        return this.f61483b;
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: f */
    public void mo79706f() throws IOException {
        this.f61484c.flush();
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: g */
    public long mo79707g(C11922g0 c11922g0) {
        return C13280e.m79713b(c11922g0);
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: h */
    public InterfaceC1074x mo79708h(C11918e0 c11918e0, long j10) {
        return this.f61485d.m82148h();
    }
}
