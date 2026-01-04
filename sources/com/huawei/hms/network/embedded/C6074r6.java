package com.huawei.hms.network.embedded;

import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C5998l8;
import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.embedded.C6127v7;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.huawei.hms.network.embedded.r6 */
/* loaded from: classes8.dex */
public final class C6074r6 implements Closeable, Flushable {

    /* renamed from: h */
    public static final int f28059h = 201105;

    /* renamed from: i */
    public static final int f28060i = 0;

    /* renamed from: j */
    public static final int f28061j = 1;

    /* renamed from: k */
    public static final int f28062k = 2;

    /* renamed from: a */
    public final InterfaceC6024n8 f28063a;

    /* renamed from: b */
    public final C5998l8 f28064b;

    /* renamed from: c */
    public int f28065c;

    /* renamed from: d */
    public int f28066d;

    /* renamed from: e */
    public int f28067e;

    /* renamed from: f */
    public int f28068f;

    /* renamed from: g */
    public int f28069g;

    /* renamed from: com.huawei.hms.network.embedded.r6$a */
    public class a implements InterfaceC6024n8 {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: a */
        public InterfaceC5972j8 mo34897a(C6127v7 c6127v7) throws IOException {
            return C6074r6.this.m35208a(c6127v7);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: b */
        public void mo34902b(C6101t7 c6101t7) throws IOException {
            C6074r6.this.m35212b(c6101t7);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: a */
        public C6127v7 mo34898a(C6101t7 c6101t7) throws IOException {
            return C6074r6.this.m35209a(c6101t7);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: a */
        public void mo34899a() {
            C6074r6.this.m35204C();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: a */
        public void mo34900a(C5985k8 c5985k8) {
            C6074r6.this.m35210a(c5985k8);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6024n8
        /* renamed from: a */
        public void mo34901a(C6127v7 c6127v7, C6127v7 c6127v72) {
            C6074r6.this.m35211a(c6127v7, c6127v72);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.r6$b */
    public class b implements Iterator<String> {

        /* renamed from: a */
        public final Iterator<C5998l8.f> f28071a;

        /* renamed from: b */
        public String f28072b;

        /* renamed from: c */
        public boolean f28073c;

        public b() throws IOException {
            this.f28071a = C6074r6.this.f28064b.m34677B();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f28072b != null) {
                return true;
            }
            this.f28073c = false;
            while (this.f28071a.hasNext()) {
                try {
                    C5998l8.f next = this.f28071a.next();
                    try {
                        continue;
                        this.f28072b = C6040ob.m34934a(next.m34707e(0)).mo33978n();
                        next.close();
                        return true;
                    } finally {
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f28073c) {
                throw new IllegalStateException("remove() before next()");
            }
            this.f28071a.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f28072b;
            this.f28072b = null;
            this.f28073c = true;
            return str;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.r6$c */
    public final class c implements InterfaceC5972j8 {

        /* renamed from: a */
        public final C5998l8.d f28075a;

        /* renamed from: b */
        public InterfaceC6170yb f28076b;

        /* renamed from: c */
        public InterfaceC6170yb f28077c;

        /* renamed from: d */
        public boolean f28078d;

        /* renamed from: com.huawei.hms.network.embedded.r6$c$a */
        public class a extends AbstractC5936gb {

            /* renamed from: b */
            public final /* synthetic */ C6074r6 f28080b;

            /* renamed from: c */
            public final /* synthetic */ C5998l8.d f28081c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC6170yb interfaceC6170yb, C6074r6 c6074r6, C5998l8.d dVar) {
                super(interfaceC6170yb);
                this.f28080b = c6074r6;
                this.f28081c = dVar;
            }

            @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                synchronized (C6074r6.this) {
                    try {
                        c cVar = c.this;
                        if (cVar.f28078d) {
                            return;
                        }
                        cVar.f28078d = true;
                        C6074r6.this.f28065c++;
                        super.close();
                        this.f28081c.m34699c();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public c(C5998l8.d dVar) {
            this.f28075a = dVar;
            InterfaceC6170yb interfaceC6170ybM34695a = dVar.m34695a(1);
            this.f28076b = interfaceC6170ybM34695a;
            this.f28077c = new a(interfaceC6170ybM34695a, C6074r6.this, dVar);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5972j8
        /* renamed from: a */
        public InterfaceC6170yb mo34544a() {
            return this.f28077c;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5972j8
        public void abort() throws IOException {
            synchronized (C6074r6.this) {
                try {
                    if (this.f28078d) {
                        return;
                    }
                    this.f28078d = true;
                    C6074r6.this.f28066d++;
                    C5920f8.m34248a(this.f28076b);
                    try {
                        this.f28075a.m34696a();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.r6$d */
    public static class d extends AbstractC6140w7 {

        /* renamed from: b */
        public final C5998l8.f f28083b;

        /* renamed from: c */
        public final InterfaceC5896db f28084c;

        /* renamed from: d */
        public final String f28085d;

        /* renamed from: e */
        public final String f28086e;

        /* renamed from: com.huawei.hms.network.embedded.r6$d$a */
        public class a extends AbstractC5949hb {

            /* renamed from: b */
            public final /* synthetic */ C5998l8.f f28087b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC6183zb interfaceC6183zb, C5998l8.f fVar) {
                super(interfaceC6183zb);
                this.f28087b = fVar;
            }

            @Override // com.huawei.hms.network.embedded.AbstractC5949hb, com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
            public void close() throws IOException {
                this.f28087b.close();
                super.close();
            }
        }

        public d(C5998l8.f fVar, String str, String str2) {
            this.f28083b = fVar;
            this.f28085d = str;
            this.f28086e = str2;
            this.f28084c = C6040ob.m34934a(new a(fVar.m34707e(1), fVar));
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: v */
        public long mo34710v() {
            try {
                String str = this.f28086e;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: w */
        public C6036o7 mo34711w() {
            String str = this.f28085d;
            if (str != null) {
                return C6036o7.m34923b(str);
            }
            return null;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: x */
        public InterfaceC5896db mo34712x() {
            return this.f28084c;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.r6$e */
    public static final class e {

        /* renamed from: k */
        public static final String f28089k = C6013ma.m34863f().m34867a() + "-Sent-Millis";

        /* renamed from: l */
        public static final String f28090l = C6013ma.m34863f().m34867a() + "-Received-Millis";

        /* renamed from: a */
        public final String f28091a;

        /* renamed from: b */
        public final C5971j7 f28092b;

        /* renamed from: c */
        public final String f28093c;

        /* renamed from: d */
        public final EnumC6075r7 f28094d;

        /* renamed from: e */
        public final int f28095e;

        /* renamed from: f */
        public final String f28096f;

        /* renamed from: g */
        public final C5971j7 f28097g;

        /* renamed from: h */
        public final C5958i7 f28098h;

        /* renamed from: i */
        public final long f28099i;

        /* renamed from: j */
        public final long f28100j;

        public e(C6127v7 c6127v7) {
            this.f28091a = c6127v7.m35578H().m35423k().toString();
            this.f28092b = C5960i9.m34420e(c6127v7);
            this.f28093c = c6127v7.m35578H().m35420h();
            this.f28094d = c6127v7.m35576F();
            this.f28095e = c6127v7.m35589w();
            this.f28096f = c6127v7.m35572B();
            this.f28097g = c6127v7.m35591y();
            this.f28098h = c6127v7.m35590x();
            this.f28099i = c6127v7.m35579I();
            this.f28100j = c6127v7.m35577G();
        }

        /* renamed from: a */
        public C6127v7 m35224a(C5998l8.f fVar) {
            String strM34521a = this.f28097g.m34521a("Content-Type");
            String strM34521a2 = this.f28097g.m34521a("Content-Length");
            return new C6127v7.a().m35600a(new C6101t7.a().m35443c(this.f28091a).m35431a(this.f28093c, (AbstractC6114u7) null).m35424a(this.f28092b).m35436a()).m35599a(this.f28094d).m35595a(this.f28095e).m35603a(this.f28096f).m35598a(this.f28097g).m35602a(new d(fVar, strM34521a, strM34521a2)).m35597a(this.f28098h).m35607b(this.f28099i).m35596a(this.f28100j).m35605a();
        }

        public e(InterfaceC6183zb interfaceC6183zb) throws IOException {
            try {
                InterfaceC5896db interfaceC5896dbM34934a = C6040ob.m34934a(interfaceC6183zb);
                this.f28091a = interfaceC5896dbM34934a.mo33978n();
                this.f28093c = interfaceC5896dbM34934a.mo33978n();
                C5971j7.a aVar = new C5971j7.a();
                int iM35199a = C6074r6.m35199a(interfaceC5896dbM34934a);
                for (int i10 = 0; i10 < iM35199a; i10++) {
                    aVar.m34536b(interfaceC5896dbM34934a.mo33978n());
                }
                this.f28092b = aVar.m34535a();
                C6038o9 c6038o9M34931a = C6038o9.m34931a(interfaceC5896dbM34934a.mo33978n());
                this.f28094d = c6038o9M34931a.f27628a;
                this.f28095e = c6038o9M34931a.f27629b;
                this.f28096f = c6038o9M34931a.f27630c;
                C5971j7.a aVar2 = new C5971j7.a();
                int iM35199a2 = C6074r6.m35199a(interfaceC5896dbM34934a);
                for (int i11 = 0; i11 < iM35199a2; i11++) {
                    aVar2.m34536b(interfaceC5896dbM34934a.mo33978n());
                }
                String str = f28089k;
                String strM34541c = aVar2.m34541c(str);
                String str2 = f28090l;
                String strM34541c2 = aVar2.m34541c(str2);
                aVar2.m34542d(str);
                aVar2.m34542d(str2);
                this.f28099i = strM34541c != null ? Long.parseLong(strM34541c) : 0L;
                this.f28100j = strM34541c2 != null ? Long.parseLong(strM34541c2) : 0L;
                this.f28097g = aVar2.m34535a();
                if (m35223a()) {
                    String strMo33978n = interfaceC5896dbM34934a.mo33978n();
                    if (strMo33978n.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strMo33978n + "\"");
                    }
                    this.f28098h = C5958i7.m34385a(!interfaceC5896dbM34934a.mo33971i() ? EnumC6166y7.m35840a(interfaceC5896dbM34934a.mo33978n()) : EnumC6166y7.SSL_3_0, C6152x6.m35782a(interfaceC5896dbM34934a.mo33978n()), m35221a(interfaceC5896dbM34934a), m35221a(interfaceC5896dbM34934a));
                } else {
                    this.f28098h = null;
                }
                interfaceC6183zb.close();
            } catch (Throwable th2) {
                interfaceC6183zb.close();
                throw th2;
            }
        }

        /* renamed from: a */
        private List<Certificate> m35221a(InterfaceC5896db interfaceC5896db) throws IOException, CertificateException {
            int iM35199a = C6074r6.m35199a(interfaceC5896db);
            if (iM35199a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(C5335e.f24726b);
                ArrayList arrayList = new ArrayList(iM35199a);
                for (int i10 = 0; i10 < iM35199a; i10++) {
                    String strMo33978n = interfaceC5896db.mo33978n();
                    C5868bb c5868bb = new C5868bb();
                    c5868bb.mo33928a(C5910eb.m34148a(strMo33978n));
                    arrayList.add(certificateFactory.generateCertificate(c5868bb.mo33977m()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        /* renamed from: a */
        private void m35222a(InterfaceC5882cb interfaceC5882cb, List<Certificate> list) throws IOException {
            try {
                interfaceC5882cb.mo33926a(list.size()).writeByte(10);
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    interfaceC5882cb.mo33934a(C5910eb.m34158e(list.get(i10).getEncoded()).mo34175b()).writeByte(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        /* renamed from: a */
        public void m35225a(C5998l8.d dVar) throws IOException {
            InterfaceC5882cb interfaceC5882cbM34933a = C6040ob.m34933a(dVar.m34695a(0));
            interfaceC5882cbM34933a.mo33934a(this.f28091a).writeByte(10);
            interfaceC5882cbM34933a.mo33934a(this.f28093c).writeByte(10);
            interfaceC5882cbM34933a.mo33926a(this.f28092b.m34527d()).writeByte(10);
            int iM34527d = this.f28092b.m34527d();
            for (int i10 = 0; i10 < iM34527d; i10++) {
                interfaceC5882cbM34933a.mo33934a(this.f28092b.m34520a(i10)).mo33934a(": ").mo33934a(this.f28092b.m34522b(i10)).writeByte(10);
            }
            interfaceC5882cbM34933a.mo33934a(new C6038o9(this.f28094d, this.f28095e, this.f28096f).toString()).writeByte(10);
            interfaceC5882cbM34933a.mo33926a(this.f28097g.m34527d() + 2).writeByte(10);
            int iM34527d2 = this.f28097g.m34527d();
            for (int i11 = 0; i11 < iM34527d2; i11++) {
                interfaceC5882cbM34933a.mo33934a(this.f28097g.m34520a(i11)).mo33934a(": ").mo33934a(this.f28097g.m34522b(i11)).writeByte(10);
            }
            interfaceC5882cbM34933a.mo33934a(f28089k).mo33934a(": ").mo33926a(this.f28099i).writeByte(10);
            interfaceC5882cbM34933a.mo33934a(f28090l).mo33934a(": ").mo33926a(this.f28100j).writeByte(10);
            if (m35223a()) {
                interfaceC5882cbM34933a.writeByte(10);
                interfaceC5882cbM34933a.mo33934a(this.f28098h.m34388a().m35786a()).writeByte(10);
                m35222a(interfaceC5882cbM34933a, this.f28098h.m34391d());
                m35222a(interfaceC5882cbM34933a, this.f28098h.m34389b());
                interfaceC5882cbM34933a.mo33934a(this.f28098h.m34393f().m35842a()).writeByte(10);
            }
            interfaceC5882cbM34933a.close();
        }

        /* renamed from: a */
        private boolean m35223a() {
            return this.f28091a.startsWith("https://");
        }

        /* renamed from: a */
        public boolean m35226a(C6101t7 c6101t7, C6127v7 c6127v7) {
            return this.f28091a.equals(c6101t7.m35423k().toString()) && this.f28093c.equals(c6101t7.m35420h()) && C5960i9.m34411a(c6127v7, this.f28092b, c6101t7);
        }
    }

    public C6074r6(File file, long j10) {
        this(file, j10, InterfaceC5909ea.f26708a);
    }

    /* renamed from: a */
    public static int m35199a(InterfaceC5896db interfaceC5896db) throws IOException {
        try {
            long jMo33980p = interfaceC5896db.mo33980p();
            String strMo33978n = interfaceC5896db.mo33978n();
            if (jMo33980p >= 0 && jMo33980p <= 2147483647L && strMo33978n.isEmpty()) {
                return (int) jMo33980p;
            }
            throw new IOException("expected an int but was \"" + jMo33980p + strMo33978n + "\"");
        } catch (NumberFormatException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    /* renamed from: A */
    public synchronized int m35202A() {
        return this.f28069g;
    }

    /* renamed from: B */
    public long m35203B() throws IOException {
        return this.f28064b.m34676A();
    }

    /* renamed from: C */
    public synchronized void m35204C() {
        this.f28068f++;
    }

    /* renamed from: D */
    public Iterator<String> m35205D() throws IOException {
        return new b();
    }

    /* renamed from: E */
    public synchronized int m35206E() {
        return this.f28066d;
    }

    /* renamed from: F */
    public synchronized int m35207F() {
        return this.f28065c;
    }

    /* renamed from: b */
    public void m35212b(C6101t7 c6101t7) throws IOException {
        this.f28064b.m34684d(m35200a(c6101t7.m35423k()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28064b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f28064b.flush();
    }

    /* renamed from: s */
    public void m35213s() throws IOException {
        this.f28064b.m34686s();
    }

    /* renamed from: t */
    public File m35214t() {
        return this.f28064b.m34688u();
    }

    /* renamed from: u */
    public void m35215u() throws IOException {
        this.f28064b.m34687t();
    }

    /* renamed from: v */
    public synchronized int m35216v() {
        return this.f28068f;
    }

    /* renamed from: w */
    public void m35217w() throws IOException {
        this.f28064b.m34690w();
    }

    /* renamed from: x */
    public boolean m35218x() {
        return this.f28064b.m34691x();
    }

    /* renamed from: y */
    public long m35219y() {
        return this.f28064b.m34689v();
    }

    /* renamed from: z */
    public synchronized int m35220z() {
        return this.f28067e;
    }

    public C6074r6(File file, long j10, InterfaceC5909ea interfaceC5909ea) {
        this.f28063a = new a();
        this.f28064b = C5998l8.m34673a(interfaceC5909ea, file, f28059h, 2, j10);
    }

    /* renamed from: a */
    public InterfaceC5972j8 m35208a(C6127v7 c6127v7) {
        C5998l8.d dVarM34682b;
        String strM35420h = c6127v7.m35578H().m35420h();
        if (C5973j9.m34545a(c6127v7.m35578H().m35420h())) {
            try {
                m35212b(c6127v7.m35578H());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strM35420h.equals("GET") || C5960i9.m34418c(c6127v7)) {
            return null;
        }
        e eVar = new e(c6127v7);
        try {
            dVarM34682b = this.f28064b.m34682b(m35200a(c6127v7.m35578H().m35423k()));
            if (dVarM34682b == null) {
                return null;
            }
            try {
                eVar.m35225a(dVarM34682b);
                return new c(dVarM34682b);
            } catch (IOException unused2) {
                m35201a(dVarM34682b);
                return null;
            }
        } catch (IOException unused3) {
            dVarM34682b = null;
        }
    }

    /* renamed from: a */
    public C6127v7 m35209a(C6101t7 c6101t7) throws IOException {
        try {
            C5998l8.f fVarM34683c = this.f28064b.m34683c(m35200a(c6101t7.m35423k()));
            if (fVarM34683c == null) {
                return null;
            }
            try {
                e eVar = new e(fVarM34683c.m34707e(0));
                C6127v7 c6127v7M35224a = eVar.m35224a(fVarM34683c);
                if (eVar.m35226a(c6101t7, c6127v7M35224a)) {
                    return c6127v7M35224a;
                }
                C5920f8.m34248a(c6127v7M35224a.m35585s());
                return null;
            } catch (IOException unused) {
                C5920f8.m34248a(fVarM34683c);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    /* renamed from: a */
    public static String m35200a(C6010m7 c6010m7) {
        return C5910eb.m34157d(c6010m7.toString()).mo34186f().mo34181d();
    }

    /* renamed from: a */
    public synchronized void m35210a(C5985k8 c5985k8) {
        try {
            this.f28069g++;
            if (c5985k8.f27298a != null) {
                this.f28067e++;
            } else if (c5985k8.f27299b != null) {
                this.f28068f++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private void m35201a(C5998l8.d dVar) {
        if (dVar != null) {
            try {
                dVar.m34696a();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public void m35211a(C6127v7 c6127v7, C6127v7 c6127v72) {
        C5998l8.d dVarM34708s;
        e eVar = new e(c6127v72);
        try {
            dVarM34708s = ((d) c6127v7.m35585s()).f28083b.m34708s();
            if (dVarM34708s != null) {
                try {
                    eVar.m35225a(dVarM34708s);
                    dVarM34708s.m34699c();
                } catch (IOException unused) {
                    m35201a(dVarM34708s);
                }
            }
        } catch (IOException unused2) {
            dVarM34708s = null;
        }
    }
}
