package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.InterfaceC5196ba;
import com.huawei.hms.network.embedded.C6090s9;
import com.huawei.hms.network.embedded.C6142w9;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p022ay.C1050a0;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.db */
/* loaded from: classes8.dex */
public final class C5253db implements InterfaceC5235cl {

    /* renamed from: a */
    private static final List<String> f24385a = C5210bo.m31186a(C6142w9.f28867h, "host", C6142w9.f28869j, C6142w9.f28870k, C6142w9.f28872m, C6142w9.f28871l, C6142w9.f28873n, C6142w9.f28874o, C6090s9.f28234f, C6090s9.f28235g, C6090s9.f28236h, C6090s9.f28237i);

    /* renamed from: b */
    private static final List<String> f24386b = C5210bo.m31186a(C6142w9.f28867h, "host", C6142w9.f28869j, C6142w9.f28870k, C6142w9.f28872m, C6142w9.f28871l, C6142w9.f28873n, C6142w9.f28874o);

    /* renamed from: c */
    private final InterfaceC5196ba.a f24387c;

    /* renamed from: d */
    private final C5227cd f24388d;

    /* renamed from: e */
    private final C5252da f24389e;

    /* renamed from: f */
    private volatile C5255dd f24390f;

    /* renamed from: g */
    private final EnumC5199bd f24391g;

    /* renamed from: h */
    private volatile boolean f24392h;

    public C5253db(C5198bc c5198bc, C5227cd c5227cd, InterfaceC5196ba.a aVar, C5252da c5252da) {
        this.f24388d = c5227cd;
        this.f24387c = aVar;
        this.f24389e = c5252da;
        List<EnumC5199bd> listM31068w = c5198bc.m31068w();
        EnumC5199bd enumC5199bd = EnumC5199bd.H2_PRIOR_KNOWLEDGE;
        this.f24391g = listM31068w.contains(enumC5199bd) ? enumC5199bd : EnumC5199bd.HTTP_2;
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public C5227cd mo31399a() {
        return this.f24388d;
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: b */
    public void mo31402b() throws IOException {
        this.f24389e.m31541b();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: c */
    public void mo31403c() throws IOException {
        this.f24390f.m31595h().close();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: d */
    public void mo31404d() {
        this.f24392h = true;
        if (this.f24390f != null) {
            this.f24390f.m31586a(EnumC5246cw.CANCEL);
        }
    }

    /* renamed from: b */
    public static List<C5247cx> m31564b(C5201bf c5201bf) {
        C5190aw c5190awM31110c = c5201bf.m31110c();
        ArrayList arrayList = new ArrayList(c5190awM31110c.m30921a() + 4);
        arrayList.add(new C5247cx(C5247cx.f24270c, c5201bf.m31109b()));
        arrayList.add(new C5247cx(C5247cx.f24271d, C5241cr.m31424a(c5201bf.m31107a())));
        String strM31108a = c5201bf.m31108a(FeedbackWebConstants.HOST);
        if (strM31108a != null) {
            arrayList.add(new C5247cx(C5247cx.f24273f, strM31108a));
        }
        arrayList.add(new C5247cx(C5247cx.f24272e, c5201bf.m31107a().m30964b()));
        int iM30921a = c5190awM31110c.m30921a();
        for (int i10 = 0; i10 < iM30921a; i10++) {
            String lowerCase = c5190awM31110c.m30922a(i10).toLowerCase(Locale.US);
            if (!f24385a.contains(lowerCase) || (lowerCase.equals(C6142w9.f28872m) && c5190awM31110c.m30925b(i10).equals("trailers"))) {
                arrayList.add(new C5247cx(lowerCase, c5190awM31110c.m30925b(i10)));
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public InterfaceC1074x mo31397a(C5201bf c5201bf, long j10) {
        return this.f24390f.m31595h();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public void mo31400a(C5201bf c5201bf) throws IOException {
        if (this.f24390f != null) {
            return;
        }
        this.f24390f = this.f24389e.m31527a(m31564b(c5201bf), c5201bf.m31111d() != null);
        if (!this.f24392h) {
            C1050a0 c1050a0M31592e = this.f24390f.m31592e();
            long jMo31034c = this.f24387c.mo31034c();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            c1050a0M31592e.timeout(jMo31034c, timeUnit);
            this.f24390f.m31593f().timeout(this.f24387c.mo31035d(), timeUnit);
            return;
        }
        this.f24390f.m31586a(EnumC5246cw.CANCEL);
        throw new IOException("Canceled");
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public C5203bh.a mo31398a(boolean z10) throws NumberFormatException, IOException {
        C5203bh.a aVarM31563a = m31563a(this.f24390f.m31591d(), this.f24391g);
        if (z10 && AbstractC5207bl.f23983a.mo31072a(aVarM31563a) == 100) {
            return null;
        }
        return aVarM31563a;
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: b */
    public InterfaceC1076z mo31401b(C5203bh c5203bh) {
        return this.f24390f.m31594g();
    }

    /* renamed from: a */
    public static C5203bh.a m31563a(C5190aw c5190aw, EnumC5199bd enumC5199bd) throws NumberFormatException, IOException {
        C5190aw.a aVar = new C5190aw.a();
        int iM30921a = c5190aw.m30921a();
        C5243ct c5243ctM31432a = null;
        for (int i10 = 0; i10 < iM30921a; i10++) {
            String strM30922a = c5190aw.m30922a(i10);
            String strM30925b = c5190aw.m30925b(i10);
            if (strM30922a.equals(C6090s9.f28233e)) {
                c5243ctM31432a = C5243ct.m31432a("HTTP/1.1 " + strM30925b);
            } else if (!f24386b.contains(strM30922a)) {
                AbstractC5207bl.f23983a.mo31077a(aVar, strM30922a, strM30925b);
            }
        }
        if (c5243ctM31432a != null) {
            return new C5203bh.a().m31145a(enumC5199bd).m31141a(c5243ctM31432a.f24229b).m31149a(c5243ctM31432a.f24230c).m31144a(aVar.m30930a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public long mo31396a(C5203bh c5203bh) {
        return C5237cn.m31411a(c5203bh);
    }
}
