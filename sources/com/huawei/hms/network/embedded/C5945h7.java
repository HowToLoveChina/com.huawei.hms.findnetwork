package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.h7 */
/* loaded from: classes8.dex */
public final class C5945h7 extends AbstractC6114u7 {

    /* renamed from: c */
    public static final C6036o7 f26954c = C6036o7.m34922a(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED);

    /* renamed from: a */
    public final List<String> f26955a;

    /* renamed from: b */
    public final List<String> f26956b;

    /* renamed from: com.huawei.hms.network.embedded.h7$a */
    public static final class a {

        /* renamed from: a */
        public final List<String> f26957a;

        /* renamed from: b */
        public final List<String> f26958b;

        /* renamed from: c */
        public final Charset f26959c;

        public a() {
            this(null);
        }

        /* renamed from: a */
        public a m34362a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f26957a.add(C6010m7.m34772a(str, C6010m7.f27505s, false, false, true, true, this.f26959c));
            this.f26958b.add(C6010m7.m34772a(str2, C6010m7.f27505s, false, false, true, true, this.f26959c));
            return this;
        }

        /* renamed from: b */
        public a m34364b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f26957a.add(C6010m7.m34772a(str, C6010m7.f27505s, true, false, true, true, this.f26959c));
            this.f26958b.add(C6010m7.m34772a(str2, C6010m7.f27505s, true, false, true, true, this.f26959c));
            return this;
        }

        public a(Charset charset) {
            this.f26957a = new ArrayList();
            this.f26958b = new ArrayList();
            this.f26959c = charset;
        }

        /* renamed from: a */
        public C5945h7 m34363a() {
            return new C5945h7(this.f26957a, this.f26958b);
        }
    }

    public C5945h7(List<String> list, List<String> list2) {
        this.f26955a = C5920f8.m34242a(list);
        this.f26956b = C5920f8.m34242a(list2);
    }

    /* renamed from: a */
    public int m34357a() {
        return this.f26955a.size();
    }

    /* renamed from: b */
    public String m34359b(int i10) {
        return this.f26956b.get(i10);
    }

    /* renamed from: c */
    public String m34360c(int i10) {
        return C6010m7.m34773a(m34358a(i10), true);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public long contentLength() {
        return m34356a(null, true);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public C6036o7 contentType() {
        return f26954c;
    }

    /* renamed from: d */
    public String m34361d(int i10) {
        return C6010m7.m34773a(m34359b(i10), true);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
        m34356a(interfaceC5882cb, false);
    }

    /* renamed from: a */
    private long m34356a(InterfaceC5882cb interfaceC5882cb, boolean z10) {
        C5868bb c5868bb = z10 ? new C5868bb() : interfaceC5882cb.mo33924a();
        int size = this.f26955a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                c5868bb.writeByte(38);
            }
            c5868bb.mo33934a(this.f26955a.get(i10));
            c5868bb.writeByte(61);
            c5868bb.mo33934a(this.f26956b.get(i10));
        }
        if (!z10) {
            return 0L;
        }
        long jM33913B = c5868bb.m33913B();
        c5868bb.m33983s();
        return jM33913B;
    }

    /* renamed from: a */
    public String m34358a(int i10) {
        return this.f26955a.get(i10);
    }
}
