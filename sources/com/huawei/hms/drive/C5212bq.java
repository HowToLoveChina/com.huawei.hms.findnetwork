package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.C5214bs;
import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p022ay.C1050a0;
import p022ay.C1054d;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.bq */
/* loaded from: classes8.dex */
public final class C5212bq implements InterfaceC5196ba {

    /* renamed from: a */
    final InterfaceC5216bu f24000a;

    /* renamed from: com.huawei.hms.drive.bq$1 */
    public class AnonymousClass1 implements InterfaceC1076z {

        /* renamed from: a */
        boolean f24001a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1056f f24002b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC5213br f24003c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC1055e f24004d;

        public AnonymousClass1(InterfaceC1056f interfaceC1056f, InterfaceC5213br interfaceC5213br, InterfaceC1055e interfaceC1055e) {
            interfaceC1056f = interfaceC1056f;
            interfaceC5213br = interfaceC5213br;
            interfaceC1055e = interfaceC1055e;
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f24001a && !C5210bo.m31194a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f24001a = true;
                interfaceC5213br.m31218b();
            }
            interfaceC1056f.close();
        }

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            try {
                long j11 = interfaceC1056f.read(c1054d, j10);
                if (j11 != -1) {
                    c1054d.m6356w(interfaceC1055e.mo6323K(), c1054d.m6322J() - j11, j11);
                    interfaceC1055e.mo6326N();
                    return j11;
                }
                if (!this.f24001a) {
                    this.f24001a = true;
                    interfaceC1055e.close();
                }
                return -1L;
            } catch (IOException e10) {
                if (!this.f24001a) {
                    this.f24001a = true;
                    interfaceC5213br.m31218b();
                }
                throw e10;
            }
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return interfaceC1056f.timeout();
        }
    }

    public C5212bq(InterfaceC5216bu interfaceC5216bu) {
        this.f24000a = interfaceC5216bu;
    }

    /* renamed from: b */
    public static boolean m31216b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        InterfaceC5216bu interfaceC5216bu = this.f24000a;
        C5203bh c5203bhM31235a = interfaceC5216bu != null ? interfaceC5216bu.m31235a(aVar.mo31031a()) : null;
        C5214bs c5214bsM31225a = new C5214bs.a(System.currentTimeMillis(), aVar.mo31031a(), c5203bhM31235a).m31225a();
        C5201bf c5201bf = c5214bsM31225a.f24006a;
        C5203bh c5203bh = c5214bsM31225a.f24007b;
        InterfaceC5216bu interfaceC5216bu2 = this.f24000a;
        if (interfaceC5216bu2 != null) {
            interfaceC5216bu2.m31239a(c5214bsM31225a);
        }
        if (c5203bhM31235a != null && c5203bh == null) {
            C5210bo.m31191a(c5203bhM31235a.m31133f());
        }
        if (c5201bf == null && c5203bh == null) {
            return new C5203bh.a().m31146a(aVar.mo31031a()).m31145a(EnumC5199bd.HTTP_1_1).m31141a(504).m31149a("Unsatisfiable Request (only-if-cached)").m31148a(C5210bo.f23991d).m31142a(-1L).m31153b(System.currentTimeMillis()).m31151a();
        }
        if (c5201bf == null) {
            return c5203bh.m31134g().m31154b(m31213a(c5203bh)).m31151a();
        }
        try {
            C5203bh c5203bhMo31032a = aVar.mo31032a(c5201bf);
            if (c5203bhMo31032a == null && c5203bhM31235a != null) {
            }
            if (c5203bh != null) {
                if (c5203bhMo31032a.m31129b() == 304) {
                    C5203bh c5203bhM31151a = c5203bh.m31134g().m31144a(m31212a(c5203bh.m31132e(), c5203bhMo31032a.m31132e())).m31142a(c5203bhMo31032a.m31137j()).m31153b(c5203bhMo31032a.m31138k()).m31154b(m31213a(c5203bh)).m31147a(m31213a(c5203bhMo31032a)).m31151a();
                    c5203bhMo31032a.m31133f().close();
                    this.f24000a.m31237a();
                    this.f24000a.m31238a(c5203bh, c5203bhM31151a);
                    return c5203bhM31151a;
                }
                C5210bo.m31191a(c5203bh.m31133f());
            }
            C5203bh c5203bhM31151a2 = c5203bhMo31032a.m31134g().m31154b(m31213a(c5203bh)).m31147a(m31213a(c5203bhMo31032a)).m31151a();
            if (this.f24000a != null) {
                if (C5237cn.m31415b(c5203bhM31151a2) && C5214bs.m31219a(c5203bhM31151a2, c5201bf)) {
                    return m31214a(this.f24000a.m31236a(c5203bhM31151a2), c5203bhM31151a2);
                }
                if (C5238co.m31416a(c5201bf.m31109b())) {
                    try {
                        this.f24000a.m31240b(c5201bf);
                    } catch (IOException unused) {
                    }
                }
            }
            return c5203bhM31151a2;
        } finally {
            if (c5203bhM31235a != null) {
                C5210bo.m31191a(c5203bhM31235a.m31133f());
            }
        }
    }

    /* renamed from: a */
    private static C5203bh m31213a(C5203bh c5203bh) {
        return (c5203bh == null || c5203bh.m31133f() == null) ? c5203bh : c5203bh.m31134g().m31148a((AbstractC5204bi) null).m31151a();
    }

    /* renamed from: a */
    private C5203bh m31214a(InterfaceC5213br interfaceC5213br, C5203bh c5203bh) throws IOException {
        InterfaceC1074x interfaceC1074xM31217a;
        if (interfaceC5213br == null || (interfaceC1074xM31217a = interfaceC5213br.m31217a()) == null) {
            return c5203bh;
        }
        return c5203bh.m31134g().m31148a(new C5240cq(c5203bh.m31127a("Content-Type"), c5203bh.m31133f().mo31159a(), C1064n.m6403b(new InterfaceC1076z() { // from class: com.huawei.hms.drive.bq.1

            /* renamed from: a */
            boolean f24001a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC1056f f24002b;

            /* renamed from: c */
            final /* synthetic */ InterfaceC5213br f24003c;

            /* renamed from: d */
            final /* synthetic */ InterfaceC1055e f24004d;

            public AnonymousClass1(InterfaceC1056f interfaceC1056f, InterfaceC5213br interfaceC5213br2, InterfaceC1055e interfaceC1055e) {
                interfaceC1056f = interfaceC1056f;
                interfaceC5213br = interfaceC5213br2;
                interfaceC1055e = interfaceC1055e;
            }

            @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f24001a && !C5210bo.m31194a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f24001a = true;
                    interfaceC5213br.m31218b();
                }
                interfaceC1056f.close();
            }

            @Override // p022ay.InterfaceC1076z
            public long read(C1054d c1054d, long j10) throws IOException {
                try {
                    long j11 = interfaceC1056f.read(c1054d, j10);
                    if (j11 != -1) {
                        c1054d.m6356w(interfaceC1055e.mo6323K(), c1054d.m6322J() - j11, j11);
                        interfaceC1055e.mo6326N();
                        return j11;
                    }
                    if (!this.f24001a) {
                        this.f24001a = true;
                        interfaceC1055e.close();
                    }
                    return -1L;
                } catch (IOException e10) {
                    if (!this.f24001a) {
                        this.f24001a = true;
                        interfaceC5213br.m31218b();
                    }
                    throw e10;
                }
            }

            @Override // p022ay.InterfaceC1076z
            public C1050a0 timeout() {
                return interfaceC1056f.timeout();
            }
        }))).m31151a();
    }

    /* renamed from: a */
    private static C5190aw m31212a(C5190aw c5190aw, C5190aw c5190aw2) {
        C5190aw.a aVar = new C5190aw.a();
        int iM30921a = c5190aw.m30921a();
        for (int i10 = 0; i10 < iM30921a; i10++) {
            String strM30922a = c5190aw.m30922a(i10);
            String strM30925b = c5190aw.m30925b(i10);
            if ((!"Warning".equalsIgnoreCase(strM30922a) || !strM30925b.startsWith("1")) && (m31216b(strM30922a) || !m31215a(strM30922a) || c5190aw2.m30923a(strM30922a) == null)) {
                AbstractC5207bl.f23983a.mo31077a(aVar, strM30922a, strM30925b);
            }
        }
        int iM30921a2 = c5190aw2.m30921a();
        for (int i11 = 0; i11 < iM30921a2; i11++) {
            String strM30922a2 = c5190aw2.m30922a(i11);
            if (!m31216b(strM30922a2) && m31215a(strM30922a2)) {
                AbstractC5207bl.f23983a.mo31077a(aVar, strM30922a2, c5190aw2.m30925b(i11));
            }
        }
        return aVar.m30930a();
    }

    /* renamed from: a */
    public static boolean m31215a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
