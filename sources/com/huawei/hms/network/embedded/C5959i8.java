package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C5985k8;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.i8 */
/* loaded from: classes8.dex */
public final class C5959i8 implements InterfaceC6023n7 {

    /* renamed from: a */
    public final InterfaceC6024n8 f27030a;

    /* renamed from: com.huawei.hms.network.embedded.i8$a */
    public class a implements InterfaceC6183zb {

        /* renamed from: a */
        public boolean f27031a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC5896db f27032b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC5972j8 f27033c;

        /* renamed from: d */
        public final /* synthetic */ InterfaceC5882cb f27034d;

        public a(InterfaceC5896db interfaceC5896db, InterfaceC5972j8 interfaceC5972j8, InterfaceC5882cb interfaceC5882cb) {
            this.f27032b = interfaceC5896db;
            this.f27033c = interfaceC5972j8;
            this.f27034d = interfaceC5882cb;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (!this.f27031a && !C5920f8.m34253a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f27031a = true;
                this.f27033c.abort();
            }
            this.f27032b.close();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            try {
                long j11 = this.f27032b.read(c5868bb, j10);
                if (j11 != -1) {
                    c5868bb.m33927a(this.f27034d.mo33924a(), c5868bb.m33913B() - j11, j11);
                    this.f27034d.mo33955d();
                    return j11;
                }
                if (!this.f27031a) {
                    this.f27031a = true;
                    this.f27034d.close();
                }
                return -1L;
            } catch (IOException e10) {
                if (!this.f27031a) {
                    this.f27031a = true;
                    this.f27033c.abort();
                }
                throw e10;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27032b.timeout();
        }
    }

    public C5959i8(InterfaceC6024n8 interfaceC6024n8) {
        this.f27030a = interfaceC6024n8;
    }

    /* renamed from: a */
    public static C5971j7 m34394a(C5971j7 c5971j7, C5971j7 c5971j72) {
        C5971j7.a aVar = new C5971j7.a();
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String strM34520a = c5971j7.m34520a(i10);
            String strM34522b = c5971j7.m34522b(i10);
            if ((!"Warning".equalsIgnoreCase(strM34520a) || !strM34522b.startsWith("1")) && (m34397a(strM34520a) || !m34398b(strM34520a) || c5971j72.m34521a(strM34520a) == null)) {
                AbstractC5879c8.f26567a.mo34048a(aVar, strM34520a, strM34522b);
            }
        }
        int iM34527d2 = c5971j72.m34527d();
        for (int i11 = 0; i11 < iM34527d2; i11++) {
            String strM34520a2 = c5971j72.m34520a(i11);
            if (!m34397a(strM34520a2) && m34398b(strM34520a2)) {
                AbstractC5879c8.f26567a.mo34048a(aVar, strM34520a2, c5971j72.m34522b(i11));
            }
        }
        return aVar.m34535a();
    }

    /* renamed from: b */
    public static boolean m34398b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        InterfaceC6024n8 interfaceC6024n8 = this.f27030a;
        C6127v7 c6127v7Mo34898a = interfaceC6024n8 != null ? interfaceC6024n8.mo34898a(aVar.request()) : null;
        C5985k8 c5985k8M34618a = new C5985k8.a(System.currentTimeMillis(), aVar.request(), c6127v7Mo34898a).m34618a();
        C6101t7 c6101t7 = c5985k8M34618a.f27298a;
        C6127v7 c6127v7 = c5985k8M34618a.f27299b;
        InterfaceC6024n8 interfaceC6024n82 = this.f27030a;
        if (interfaceC6024n82 != null) {
            interfaceC6024n82.mo34900a(c5985k8M34618a);
        }
        if (c6127v7Mo34898a != null && c6127v7 == null) {
            C5920f8.m34248a(c6127v7Mo34898a.m35585s());
        }
        if (c6101t7 == null && c6127v7 == null) {
            return new C6127v7.a().m35600a(aVar.request()).m35599a(EnumC6075r7.HTTP_1_1).m35595a(504).m35603a("Unsatisfiable Request (only-if-cached)").m35602a(C5920f8.f26772d).m35607b(-1L).m35596a(System.currentTimeMillis()).m35605a();
        }
        if (c6101t7 == null) {
            return c6127v7.m35574D().m35601a(m34396a(c6127v7)).m35605a();
        }
        try {
            C6127v7 c6127v7Mo34620a = aVar.mo34620a(c6101t7);
            if (c6127v7Mo34620a == null && c6127v7Mo34898a != null) {
            }
            if (c6127v7 != null) {
                if (c6127v7Mo34620a.m35589w() == 304) {
                    C6127v7 c6127v7M35605a = c6127v7.m35574D().m35598a(m34394a(c6127v7.m35591y(), c6127v7Mo34620a.m35591y())).m35607b(c6127v7Mo34620a.m35579I()).m35596a(c6127v7Mo34620a.m35577G()).m35601a(m34396a(c6127v7)).m35608b(m34396a(c6127v7Mo34620a)).m35605a();
                    c6127v7Mo34620a.m35585s().close();
                    this.f27030a.mo34899a();
                    this.f27030a.mo34901a(c6127v7, c6127v7M35605a);
                    return c6127v7M35605a;
                }
                C5920f8.m34248a(c6127v7.m35585s());
            }
            C6127v7 c6127v7M35605a2 = c6127v7Mo34620a.m35574D().m35601a(m34396a(c6127v7)).m35608b(m34396a(c6127v7Mo34620a)).m35605a();
            if (this.f27030a != null) {
                if (C5960i9.m34415b(c6127v7M35605a2) && C5985k8.m34612a(c6127v7M35605a2, c6101t7)) {
                    return m34395a(this.f27030a.mo34897a(c6127v7M35605a2), c6127v7M35605a2);
                }
                if (C5973j9.m34545a(c6101t7.m35420h())) {
                    try {
                        this.f27030a.mo34902b(c6101t7);
                    } catch (IOException unused) {
                    }
                }
            }
            return c6127v7M35605a2;
        } finally {
            if (c6127v7Mo34898a != null) {
                C5920f8.m34248a(c6127v7Mo34898a.m35585s());
            }
        }
    }

    /* renamed from: a */
    private C6127v7 m34395a(InterfaceC5972j8 interfaceC5972j8, C6127v7 c6127v7) throws IOException {
        InterfaceC6170yb interfaceC6170ybMo34544a;
        if (interfaceC5972j8 == null || (interfaceC6170ybMo34544a = interfaceC5972j8.mo34544a()) == null) {
            return c6127v7;
        }
        return c6127v7.m35574D().m35602a(new C5999l9(c6127v7.m35582b("Content-Type"), c6127v7.m35585s().mo34710v(), C6040ob.m34934a(new a(c6127v7.m35585s().mo34712x(), interfaceC5972j8, C6040ob.m34933a(interfaceC6170ybMo34544a))))).m35605a();
    }

    /* renamed from: a */
    public static C6127v7 m34396a(C6127v7 c6127v7) {
        return (c6127v7 == null || c6127v7.m35585s() == null) ? c6127v7 : c6127v7.m35574D().m35602a((AbstractC6140w7) null).m35605a();
    }

    /* renamed from: a */
    public static boolean m34397a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
