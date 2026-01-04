package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.network.embedded.C5971j7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.network.embedded.p7 */
/* loaded from: classes8.dex */
public final class C6049p7 extends AbstractC6114u7 {

    /* renamed from: f */
    public static final C6036o7 f27720f = C6036o7.m34922a("multipart/mixed");

    /* renamed from: g */
    public static final C6036o7 f27721g = C6036o7.m34922a("multipart/alternative");

    /* renamed from: h */
    public static final C6036o7 f27722h = C6036o7.m34922a("multipart/digest");

    /* renamed from: i */
    public static final C6036o7 f27723i = C6036o7.m34922a("multipart/parallel");

    /* renamed from: j */
    public static final C6036o7 f27724j = C6036o7.m34922a(RequestBody.HEAD_VALUE_CONTENT_TYPE_FORM_DATA);

    /* renamed from: k */
    public static final byte[] f27725k = {58, 32};

    /* renamed from: l */
    public static final byte[] f27726l = {13, 10};

    /* renamed from: m */
    public static final byte[] f27727m = {45, 45};

    /* renamed from: a */
    public final C5910eb f27728a;

    /* renamed from: b */
    public final C6036o7 f27729b;

    /* renamed from: c */
    public final C6036o7 f27730c;

    /* renamed from: d */
    public final List<b> f27731d;

    /* renamed from: e */
    public long f27732e = -1;

    /* renamed from: com.huawei.hms.network.embedded.p7$a */
    public static final class a {

        /* renamed from: a */
        public final C5910eb f27733a;

        /* renamed from: b */
        public C6036o7 f27734b;

        /* renamed from: c */
        public final List<b> f27735c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        /* renamed from: a */
        public a m34998a(C5971j7 c5971j7, AbstractC6114u7 abstractC6114u7) {
            return m35000a(b.m35005a(c5971j7, abstractC6114u7));
        }

        public a(String str) {
            this.f27734b = C6049p7.f27720f;
            this.f27735c = new ArrayList();
            this.f27733a = C5910eb.m34157d(str);
        }

        /* renamed from: a */
        public a m34999a(C6036o7 c6036o7) {
            if (c6036o7 == null) {
                throw new NullPointerException("type == null");
            }
            if (c6036o7.m34927c().equals("multipart")) {
                this.f27734b = c6036o7;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + c6036o7);
        }

        /* renamed from: a */
        public a m35000a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f27735c.add(bVar);
            return this;
        }

        /* renamed from: a */
        public a m35001a(AbstractC6114u7 abstractC6114u7) {
            return m35000a(b.m35006a(abstractC6114u7));
        }

        /* renamed from: a */
        public a m35002a(String str, String str2) {
            return m35000a(b.m35007a(str, str2));
        }

        /* renamed from: a */
        public a m35003a(String str, String str2, AbstractC6114u7 abstractC6114u7) {
            return m35000a(b.m35008a(str, str2, abstractC6114u7));
        }

        /* renamed from: a */
        public C6049p7 m35004a() {
            if (this.f27735c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new C6049p7(this.f27733a, this.f27734b, this.f27735c);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p7$b */
    public static final class b {

        /* renamed from: a */
        public final C5971j7 f27736a;

        /* renamed from: b */
        public final AbstractC6114u7 f27737b;

        public b(C5971j7 c5971j7, AbstractC6114u7 abstractC6114u7) {
            this.f27736a = c5971j7;
            this.f27737b = abstractC6114u7;
        }

        /* renamed from: a */
        public static b m35005a(C5971j7 c5971j7, AbstractC6114u7 abstractC6114u7) {
            if (abstractC6114u7 == null) {
                throw new NullPointerException("body == null");
            }
            if (c5971j7 != null && c5971j7.m34521a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (c5971j7 == null || c5971j7.m34521a("Content-Length") == null) {
                return new b(c5971j7, abstractC6114u7);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        /* renamed from: b */
        public C5971j7 m35010b() {
            return this.f27736a;
        }

        /* renamed from: a */
        public static b m35006a(AbstractC6114u7 abstractC6114u7) {
            return m35005a((C5971j7) null, abstractC6114u7);
        }

        /* renamed from: a */
        public static b m35007a(String str, String str2) {
            return m35008a(str, null, AbstractC6114u7.create((C6036o7) null, str2));
        }

        /* renamed from: a */
        public static b m35008a(String str, String str2, AbstractC6114u7 abstractC6114u7) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb2 = new StringBuilder("form-data; name=");
            C6049p7.m34992a(sb2, str);
            if (str2 != null) {
                sb2.append("; filename=");
                C6049p7.m34992a(sb2, str2);
            }
            return m35005a(new C5971j7.a().m34540c("Content-Disposition", sb2.toString()).m34535a(), abstractC6114u7);
        }

        /* renamed from: a */
        public AbstractC6114u7 m35009a() {
            return this.f27737b;
        }
    }

    public C6049p7(C5910eb c5910eb, C6036o7 c6036o7, List<b> list) {
        this.f27728a = c5910eb;
        this.f27729b = c6036o7;
        this.f27730c = C6036o7.m34922a(c6036o7 + "; boundary=" + c5910eb.mo34196n());
        this.f27731d = C5920f8.m34242a(list);
    }

    /* renamed from: a */
    private long m34991a(InterfaceC5882cb interfaceC5882cb, boolean z10) throws IOException {
        InterfaceC5882cb interfaceC5882cb2;
        C5868bb c5868bb;
        if (z10) {
            c5868bb = new C5868bb();
            interfaceC5882cb2 = c5868bb;
        } else {
            interfaceC5882cb2 = interfaceC5882cb;
            c5868bb = null;
        }
        int size = this.f27731d.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f27731d.get(i10);
            C5971j7 c5971j7 = bVar.f27736a;
            AbstractC6114u7 abstractC6114u7 = bVar.f27737b;
            interfaceC5882cb2.write(f27727m);
            interfaceC5882cb2.mo33928a(this.f27728a);
            interfaceC5882cb2.write(f27726l);
            if (c5971j7 != null) {
                int iM34527d = c5971j7.m34527d();
                for (int i11 = 0; i11 < iM34527d; i11++) {
                    interfaceC5882cb2.mo33934a(c5971j7.m34520a(i11)).write(f27725k).mo33934a(c5971j7.m34522b(i11)).write(f27726l);
                }
            }
            C6036o7 c6036o7ContentType = abstractC6114u7.contentType();
            if (c6036o7ContentType != null) {
                interfaceC5882cb2.mo33934a("Content-Type: ").mo33934a(c6036o7ContentType.toString()).write(f27726l);
            }
            long jContentLength = abstractC6114u7.contentLength();
            if (jContentLength != -1) {
                interfaceC5882cb2.mo33934a("Content-Length: ").mo33926a(jContentLength).write(f27726l);
            } else if (z10) {
                c5868bb.m33983s();
                return -1L;
            }
            byte[] bArr = f27726l;
            interfaceC5882cb2.write(bArr);
            if (z10) {
                j10 += jContentLength;
            } else {
                abstractC6114u7.writeTo(interfaceC5882cb2);
            }
            interfaceC5882cb2.write(bArr);
        }
        byte[] bArr2 = f27727m;
        interfaceC5882cb2.write(bArr2);
        interfaceC5882cb2.mo33928a(this.f27728a);
        interfaceC5882cb2.write(bArr2);
        interfaceC5882cb2.write(f27726l);
        if (!z10) {
            return j10;
        }
        long jM33913B = j10 + c5868bb.m33913B();
        c5868bb.m33983s();
        return jM33913B;
    }

    /* renamed from: b */
    public List<b> m34995b() {
        return this.f27731d;
    }

    /* renamed from: c */
    public int m34996c() {
        return this.f27731d.size();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public long contentLength() throws IOException {
        long j10 = this.f27732e;
        if (j10 != -1) {
            return j10;
        }
        long jM34991a = m34991a((InterfaceC5882cb) null, true);
        this.f27732e = jM34991a;
        return jM34991a;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public C6036o7 contentType() {
        return this.f27730c;
    }

    /* renamed from: d */
    public C6036o7 m34997d() {
        return this.f27729b;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
        m34991a(interfaceC5882cb, false);
    }

    /* renamed from: a */
    public b m34993a(int i10) {
        return this.f27731d.get(i10);
    }

    /* renamed from: a */
    public String m34994a() {
        return this.f27728a.mo34196n();
    }

    /* renamed from: a */
    public static void m34992a(StringBuilder sb2, String str) {
        String str2;
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\n') {
                str2 = "%0A";
            } else if (cCharAt == '\r') {
                str2 = "%0D";
            } else if (cCharAt != '\"') {
                sb2.append(cCharAt);
            } else {
                str2 = "%22";
            }
            sb2.append(str2);
        }
        sb2.append('\"');
    }
}
