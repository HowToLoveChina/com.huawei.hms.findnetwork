package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.w9 */
/* loaded from: classes8.dex */
public final class C6142w9 implements InterfaceC5934g9 {

    /* renamed from: i */
    public static final String f28868i = "host";

    /* renamed from: b */
    public final InterfaceC6023n7.a f28877b;

    /* renamed from: c */
    public final C6167y8 f28878c;

    /* renamed from: d */
    public final C6129v9 f28879d;

    /* renamed from: e */
    public volatile C6168y9 f28880e;

    /* renamed from: f */
    public final EnumC6075r7 f28881f;

    /* renamed from: g */
    public volatile boolean f28882g;

    /* renamed from: h */
    public static final String f28867h = "connection";

    /* renamed from: j */
    public static final String f28869j = "keep-alive";

    /* renamed from: k */
    public static final String f28870k = "proxy-connection";

    /* renamed from: m */
    public static final String f28872m = "te";

    /* renamed from: l */
    public static final String f28871l = "transfer-encoding";

    /* renamed from: n */
    public static final String f28873n = "encoding";

    /* renamed from: o */
    public static final String f28874o = "upgrade";

    /* renamed from: p */
    public static final List<String> f28875p = C5920f8.m34243a(f28867h, "host", f28869j, f28870k, f28872m, f28871l, f28873n, f28874o, C6090s9.f28234f, C6090s9.f28235g, C6090s9.f28236h, C6090s9.f28237i);

    /* renamed from: q */
    public static final List<String> f28876q = C5920f8.m34243a(f28867h, "host", f28869j, f28870k, f28872m, f28871l, f28873n, f28874o);

    public C6142w9(C6062q7 c6062q7, C6167y8 c6167y8, InterfaceC6023n7.a aVar, C6129v9 c6129v9) {
        this.f28878c = c6167y8;
        this.f28877b = aVar;
        this.f28879d = c6129v9;
        List<EnumC6075r7> listM35098v = c6062q7.m35098v();
        EnumC6075r7 enumC6075r7 = EnumC6075r7.H2_PRIOR_KNOWLEDGE;
        this.f28881f = listM35098v.contains(enumC6075r7) ? enumC6075r7 : EnumC6075r7.HTTP_2;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public long mo34315a(C6127v7 c6127v7) {
        return C5960i9.m34403a(c6127v7);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: b */
    public C5971j7 mo34320b() throws IOException {
        return this.f28880e.m35885l();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: c */
    public void mo34322c() throws IOException {
        this.f28880e.m35879f().close();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    public void cancel() {
        this.f28882g = true;
        if (this.f28880e != null) {
            this.f28880e.m35871a(EnumC6077r9.CANCEL);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: d */
    public void mo34323d() throws IOException {
        this.f28879d.flush();
    }

    /* renamed from: a */
    public static C6127v7.a m35750a(C5971j7 c5971j7, EnumC6075r7 enumC6075r7) throws NumberFormatException, IOException {
        C5971j7.a aVar = new C5971j7.a();
        int iM34527d = c5971j7.m34527d();
        C6038o9 c6038o9M34931a = null;
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String strM34520a = c5971j7.m34520a(i10);
            String strM34522b = c5971j7.m34522b(i10);
            if (strM34520a.equals(C6090s9.f28233e)) {
                c6038o9M34931a = C6038o9.m34931a("HTTP/1.1 " + strM34522b);
            } else if (!f28876q.contains(strM34520a)) {
                AbstractC5879c8.f26567a.mo34048a(aVar, strM34520a, strM34522b);
            }
        }
        if (c6038o9M34931a != null) {
            return new C6127v7.a().m35599a(enumC6075r7).m35595a(c6038o9M34931a.f27629b).m35603a(c6038o9M34931a.f27630c).m35598a(aVar.m34535a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: b */
    public InterfaceC6183zb mo34321b(C6127v7 c6127v7) {
        return this.f28880e.m35880g();
    }

    /* renamed from: b */
    public static List<C6090s9> m35751b(C6101t7 c6101t7) {
        C5971j7 c5971j7M35417e = c6101t7.m35417e();
        ArrayList arrayList = new ArrayList(c5971j7M35417e.m34527d() + 4);
        arrayList.add(new C6090s9(C6090s9.f28239k, c6101t7.m35420h()));
        arrayList.add(new C6090s9(C6090s9.f28240l, C6012m9.m34854a(c6101t7.m35423k())));
        String strM35411a = c6101t7.m35411a(FeedbackWebConstants.HOST);
        if (strM35411a != null) {
            arrayList.add(new C6090s9(C6090s9.f28242n, strM35411a));
        }
        arrayList.add(new C6090s9(C6090s9.f28241m, c6101t7.m35423k().m34808s()));
        int iM34527d = c5971j7M35417e.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String lowerCase = c5971j7M35417e.m34520a(i10).toLowerCase(Locale.US);
            if (!f28875p.contains(lowerCase) || (lowerCase.equals(f28872m) && c5971j7M35417e.m34522b(i10).equals("trailers"))) {
                arrayList.add(new C6090s9(lowerCase, c5971j7M35417e.m34522b(i10)));
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public C6127v7.a mo34316a(boolean z10) throws NumberFormatException, IOException {
        C6127v7.a aVarM35750a = m35750a(this.f28880e.m35884k(), this.f28881f);
        if (z10 && AbstractC5879c8.f26567a.mo34042a(aVarM35750a) == 100) {
            return null;
        }
        return aVarM35750a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public C6167y8 mo34317a() {
        return this.f28878c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public InterfaceC6170yb mo34318a(C6101t7 c6101t7, long j10) {
        return this.f28880e.m35879f();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public void mo34319a(C6101t7 c6101t7) throws IOException {
        if (this.f28880e != null) {
            return;
        }
        this.f28880e = this.f28879d.m35648a(m35751b(c6101t7), c6101t7.m35413b() != null);
        if (this.f28882g) {
            this.f28880e.m35871a(EnumC6077r9.CANCEL);
            throw new IOException("Canceled");
        }
        C5855ac c5855acM35883j = this.f28880e.m35883j();
        long jMo34625c = this.f28877b.mo34625c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c5855acM35883j.timeout(jMo34625c, timeUnit);
        this.f28880e.m35887n().timeout(this.f28877b.mo34623b(), timeUnit);
    }
}
