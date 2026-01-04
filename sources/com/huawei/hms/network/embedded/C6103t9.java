package com.huawei.hms.network.embedded;

import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.t9 */
/* loaded from: classes8.dex */
public final class C6103t9 {

    /* renamed from: a */
    public static final int f28411a = 15;

    /* renamed from: b */
    public static final int f28412b = 31;

    /* renamed from: c */
    public static final int f28413c = 63;

    /* renamed from: d */
    public static final int f28414d = 127;

    /* renamed from: e */
    public static final C6090s9[] f28415e;

    /* renamed from: f */
    public static final Map<C5910eb, Integer> f28416f;

    /* renamed from: com.huawei.hms.network.embedded.t9$a */
    public static final class a {

        /* renamed from: a */
        public final List<C6090s9> f28417a;

        /* renamed from: b */
        public final InterfaceC5896db f28418b;

        /* renamed from: c */
        public final int f28419c;

        /* renamed from: d */
        public int f28420d;

        /* renamed from: e */
        public C6090s9[] f28421e;

        /* renamed from: f */
        public int f28422f;

        /* renamed from: g */
        public int f28423g;

        /* renamed from: h */
        public int f28424h;

        public a(int i10, int i11, InterfaceC6183zb interfaceC6183zb) {
            this.f28417a = new ArrayList();
            this.f28421e = new C6090s9[8];
            this.f28422f = r0.length - 1;
            this.f28423g = 0;
            this.f28424h = 0;
            this.f28419c = i10;
            this.f28420d = i11;
            this.f28418b = C6040ob.m34934a(interfaceC6183zb);
        }

        /* renamed from: a */
        private int m35448a(int i10) {
            return this.f28422f + 1 + i10;
        }

        /* renamed from: e */
        private void m35453e() {
            int i10 = this.f28420d;
            int i11 = this.f28424h;
            if (i10 < i11) {
                if (i10 == 0) {
                    m35455f();
                } else {
                    m35450b(i11 - i10);
                }
            }
        }

        /* renamed from: f */
        private void m35455f() {
            Arrays.fill(this.f28421e, (Object) null);
            this.f28422f = this.f28421e.length - 1;
            this.f28423g = 0;
            this.f28424h = 0;
        }

        /* renamed from: g */
        private int m35457g() throws IOException {
            return this.f28418b.readByte() & 255;
        }

        /* renamed from: h */
        private void m35459h() throws IOException {
            m35449a(-1, new C6090s9(C6103t9.m35446a(m35464c()), m35464c()));
        }

        /* renamed from: i */
        private void m35460i() throws IOException {
            this.f28417a.add(new C6090s9(C6103t9.m35446a(m35464c()), m35464c()));
        }

        /* renamed from: b */
        public int m35463b() {
            return this.f28420d;
        }

        /* renamed from: c */
        public C5910eb m35464c() throws IOException {
            int iM35457g = m35457g();
            boolean z10 = (iM35457g & 128) == 128;
            int iM35461a = m35461a(iM35457g, 127);
            return z10 ? C5910eb.m34158e(C5853aa.m33832b().m33835a(this.f28418b.mo33967g(iM35461a))) : this.f28418b.mo33957d(iM35461a);
        }

        /* renamed from: d */
        public void m35465d() throws IOException {
            while (!this.f28418b.mo33971i()) {
                byte b10 = this.f28418b.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b10 & 128) == 128) {
                    m35454e(m35461a(i10, 127) - 1);
                } else if (i10 == 64) {
                    m35459h();
                } else if ((b10 & 64) == 64) {
                    m35456f(m35461a(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int iM35461a = m35461a(i10, 31);
                    this.f28420d = iM35461a;
                    if (iM35461a < 0 || iM35461a > this.f28419c) {
                        throw new IOException("Invalid dynamic table size update " + this.f28420d);
                    }
                    m35453e();
                } else if (i10 == 16 || i10 == 0) {
                    m35460i();
                } else {
                    m35458g(m35461a(i10, 15) - 1);
                }
            }
        }

        public a(int i10, InterfaceC6183zb interfaceC6183zb) {
            this(i10, i10, interfaceC6183zb);
        }

        /* renamed from: b */
        private int m35450b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f28421e.length;
                while (true) {
                    length--;
                    i11 = this.f28422f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f28421e[length].f28245c;
                    i10 -= i13;
                    this.f28424h -= i13;
                    this.f28423g--;
                    i12++;
                }
                C6090s9[] c6090s9Arr = this.f28421e;
                int i14 = i11 + 1;
                System.arraycopy(c6090s9Arr, i14, c6090s9Arr, i14 + i12, this.f28423g);
                this.f28422f += i12;
            }
            return i12;
        }

        /* renamed from: c */
        private C5910eb m35451c(int i10) throws IOException {
            C6090s9 c6090s9;
            if (!m35452d(i10)) {
                int iM35448a = m35448a(i10 - C6103t9.f28415e.length);
                if (iM35448a >= 0) {
                    C6090s9[] c6090s9Arr = this.f28421e;
                    if (iM35448a < c6090s9Arr.length) {
                        c6090s9 = c6090s9Arr[iM35448a];
                    }
                }
                throw new IOException("Header index too large " + (i10 + 1));
            }
            c6090s9 = C6103t9.f28415e[i10];
            return c6090s9.f28243a;
        }

        /* renamed from: d */
        private boolean m35452d(int i10) {
            return i10 >= 0 && i10 <= C6103t9.f28415e.length - 1;
        }

        /* renamed from: e */
        private void m35454e(int i10) throws IOException {
            List<C6090s9> list;
            C6090s9 c6090s9;
            if (!m35452d(i10)) {
                int iM35448a = m35448a(i10 - C6103t9.f28415e.length);
                if (iM35448a >= 0) {
                    C6090s9[] c6090s9Arr = this.f28421e;
                    if (iM35448a < c6090s9Arr.length) {
                        list = this.f28417a;
                        c6090s9 = c6090s9Arr[iM35448a];
                    }
                }
                throw new IOException("Header index too large " + (i10 + 1));
            }
            c6090s9 = C6103t9.f28415e[i10];
            list = this.f28417a;
            list.add(c6090s9);
        }

        /* renamed from: f */
        private void m35456f(int i10) throws IOException {
            m35449a(-1, new C6090s9(m35451c(i10), m35464c()));
        }

        /* renamed from: g */
        private void m35458g(int i10) throws IOException {
            this.f28417a.add(new C6090s9(m35451c(i10), m35464c()));
        }

        /* renamed from: a */
        public int m35461a(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iM35457g = m35457g();
                if ((iM35457g & 128) == 0) {
                    return i11 + (iM35457g << i13);
                }
                i11 += (iM35457g & 127) << i13;
                i13 += 7;
            }
        }

        /* renamed from: a */
        public List<C6090s9> m35462a() {
            ArrayList arrayList = new ArrayList(this.f28417a);
            this.f28417a.clear();
            return arrayList;
        }

        /* renamed from: a */
        private void m35449a(int i10, C6090s9 c6090s9) {
            this.f28417a.add(c6090s9);
            int i11 = c6090s9.f28245c;
            if (i10 != -1) {
                i11 -= this.f28421e[m35448a(i10)].f28245c;
            }
            int i12 = this.f28420d;
            if (i11 > i12) {
                m35455f();
                return;
            }
            int iM35450b = m35450b((this.f28424h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f28423g + 1;
                C6090s9[] c6090s9Arr = this.f28421e;
                if (i13 > c6090s9Arr.length) {
                    C6090s9[] c6090s9Arr2 = new C6090s9[c6090s9Arr.length * 2];
                    System.arraycopy(c6090s9Arr, 0, c6090s9Arr2, c6090s9Arr.length, c6090s9Arr.length);
                    this.f28422f = this.f28421e.length - 1;
                    this.f28421e = c6090s9Arr2;
                }
                int i14 = this.f28422f;
                this.f28422f = i14 - 1;
                this.f28421e[i14] = c6090s9;
                this.f28423g++;
            } else {
                this.f28421e[i10 + m35448a(i10) + iM35450b] = c6090s9;
            }
            this.f28424h += i11;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t9$b */
    public static final class b {

        /* renamed from: k */
        public static final int f28425k = 4096;

        /* renamed from: l */
        public static final int f28426l = 16384;

        /* renamed from: a */
        public final C5868bb f28427a;

        /* renamed from: b */
        public final boolean f28428b;

        /* renamed from: c */
        public int f28429c;

        /* renamed from: d */
        public boolean f28430d;

        /* renamed from: e */
        public int f28431e;

        /* renamed from: f */
        public int f28432f;

        /* renamed from: g */
        public C6090s9[] f28433g;

        /* renamed from: h */
        public int f28434h;

        /* renamed from: i */
        public int f28435i;

        /* renamed from: j */
        public int f28436j;

        public b(int i10, boolean z10, C5868bb c5868bb) {
            this.f28429c = Integer.MAX_VALUE;
            this.f28433g = new C6090s9[8];
            this.f28434h = r0.length - 1;
            this.f28435i = 0;
            this.f28436j = 0;
            this.f28431e = i10;
            this.f28432f = i10;
            this.f28428b = z10;
            this.f28427a = c5868bb;
        }

        /* renamed from: a */
        private void m35466a() {
            int i10 = this.f28432f;
            int i11 = this.f28436j;
            if (i10 < i11) {
                if (i10 == 0) {
                    m35469b();
                } else {
                    m35468b(i11 - i10);
                }
            }
        }

        /* renamed from: b */
        private int m35468b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f28433g.length;
                while (true) {
                    length--;
                    i11 = this.f28434h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f28433g[length].f28245c;
                    i10 -= i13;
                    this.f28436j -= i13;
                    this.f28435i--;
                    i12++;
                }
                C6090s9[] c6090s9Arr = this.f28433g;
                int i14 = i11 + 1;
                System.arraycopy(c6090s9Arr, i14, c6090s9Arr, i14 + i12, this.f28435i);
                C6090s9[] c6090s9Arr2 = this.f28433g;
                int i15 = this.f28434h + 1;
                Arrays.fill(c6090s9Arr2, i15, i15 + i12, (Object) null);
                this.f28434h += i12;
            }
            return i12;
        }

        public b(C5868bb c5868bb) {
            this(4096, true, c5868bb);
        }

        /* renamed from: b */
        private void m35469b() {
            Arrays.fill(this.f28433g, (Object) null);
            this.f28434h = this.f28433g.length - 1;
            this.f28435i = 0;
            this.f28436j = 0;
        }

        /* renamed from: a */
        public void m35470a(int i10) {
            this.f28431e = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f28432f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f28429c = Math.min(this.f28429c, iMin);
            }
            this.f28430d = true;
            this.f28432f = iMin;
            m35466a();
        }

        /* renamed from: a */
        public void m35471a(int i10, int i11, int i12) {
            int i13;
            C5868bb c5868bb;
            if (i10 < i11) {
                c5868bb = this.f28427a;
                i13 = i10 | i12;
            } else {
                this.f28427a.writeByte(i12 | i11);
                i13 = i10 - i11;
                while (i13 >= 128) {
                    this.f28427a.writeByte(128 | (i13 & 127));
                    i13 >>>= 7;
                }
                c5868bb = this.f28427a;
            }
            c5868bb.writeByte(i13);
        }

        /* renamed from: a */
        public void m35472a(C5910eb c5910eb) throws IOException {
            int iMo34192j;
            int i10;
            if (!this.f28428b || C5853aa.m33832b().m33833a(c5910eb) >= c5910eb.mo34192j()) {
                iMo34192j = c5910eb.mo34192j();
                i10 = 0;
            } else {
                C5868bb c5868bb = new C5868bb();
                C5853aa.m33832b().m33834a(c5910eb, c5868bb);
                c5910eb = c5868bb.mo33982r();
                iMo34192j = c5910eb.mo34192j();
                i10 = 128;
            }
            m35471a(iMo34192j, 127, i10);
            this.f28427a.mo33928a(c5910eb);
        }

        /* renamed from: a */
        private void m35467a(C6090s9 c6090s9) {
            int i10 = c6090s9.f28245c;
            int i11 = this.f28432f;
            if (i10 > i11) {
                m35469b();
                return;
            }
            m35468b((this.f28436j + i10) - i11);
            int i12 = this.f28435i + 1;
            C6090s9[] c6090s9Arr = this.f28433g;
            if (i12 > c6090s9Arr.length) {
                C6090s9[] c6090s9Arr2 = new C6090s9[c6090s9Arr.length * 2];
                System.arraycopy(c6090s9Arr, 0, c6090s9Arr2, c6090s9Arr.length, c6090s9Arr.length);
                this.f28434h = this.f28433g.length - 1;
                this.f28433g = c6090s9Arr2;
            }
            int i13 = this.f28434h;
            this.f28434h = i13 - 1;
            this.f28433g[i13] = c6090s9;
            this.f28435i++;
            this.f28436j += i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m35473a(java.util.List<com.huawei.hms.network.embedded.C6090s9> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 231
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6103t9.b.m35473a(java.util.List):void");
        }
    }

    static {
        C6090s9 c6090s9 = new C6090s9(C6090s9.f28242n, "");
        C5910eb c5910eb = C6090s9.f28239k;
        C6090s9 c6090s92 = new C6090s9(c5910eb, "GET");
        C6090s9 c6090s93 = new C6090s9(c5910eb, "POST");
        C5910eb c5910eb2 = C6090s9.f28240l;
        C6090s9 c6090s94 = new C6090s9(c5910eb2, "/");
        C6090s9 c6090s95 = new C6090s9(c5910eb2, "/index.html");
        C5910eb c5910eb3 = C6090s9.f28241m;
        C6090s9 c6090s96 = new C6090s9(c5910eb3, "http");
        C6090s9 c6090s97 = new C6090s9(c5910eb3, "https");
        C5910eb c5910eb4 = C6090s9.f28238j;
        f28415e = new C6090s9[]{c6090s9, c6090s92, c6090s93, c6090s94, c6090s95, c6090s96, c6090s97, new C6090s9(c5910eb4, "200"), new C6090s9(c5910eb4, "204"), new C6090s9(c5910eb4, "206"), new C6090s9(c5910eb4, "304"), new C6090s9(c5910eb4, "400"), new C6090s9(c5910eb4, "404"), new C6090s9(c5910eb4, "500"), new C6090s9("accept-charset", ""), new C6090s9("accept-encoding", "gzip, deflate"), new C6090s9("accept-language", ""), new C6090s9("accept-ranges", ""), new C6090s9("accept", ""), new C6090s9("access-control-allow-origin", ""), new C6090s9("age", ""), new C6090s9("allow", ""), new C6090s9("authorization", ""), new C6090s9("cache-control", ""), new C6090s9("content-disposition", ""), new C6090s9("content-encoding", ""), new C6090s9("content-language", ""), new C6090s9(C5966j2.f27081w, ""), new C6090s9("content-location", ""), new C6090s9("content-range", ""), new C6090s9("content-type", ""), new C6090s9("cookie", ""), new C6090s9(CallLogCons.DATE, ""), new C6090s9(SyncProtocol.Constant.ETAG, ""), new C6090s9("expect", ""), new C6090s9("expires", ""), new C6090s9(RemoteMessageConst.FROM, ""), new C6090s9("host", ""), new C6090s9("if-match", ""), new C6090s9("if-modified-since", ""), new C6090s9("if-none-match", ""), new C6090s9("if-range", ""), new C6090s9("if-unmodified-since", ""), new C6090s9("last-modified", ""), new C6090s9("link", ""), new C6090s9(JsbMapKeyNames.H5_LOC, ""), new C6090s9("max-forwards", ""), new C6090s9("proxy-authenticate", ""), new C6090s9("proxy-authorization", ""), new C6090s9("range", ""), new C6090s9("referer", ""), new C6090s9("refresh", ""), new C6090s9("retry-after", ""), new C6090s9("server", ""), new C6090s9("set-cookie", ""), new C6090s9("strict-transport-security", ""), new C6090s9(C6142w9.f28871l, ""), new C6090s9(FeedbackWebConstants.USER_AGENT, ""), new C6090s9("vary", ""), new C6090s9("via", ""), new C6090s9("www-authenticate", "")};
        f28416f = m35447a();
    }

    /* renamed from: a */
    public static C5910eb m35446a(C5910eb c5910eb) throws IOException {
        int iMo34192j = c5910eb.mo34192j();
        for (int i10 = 0; i10 < iMo34192j; i10++) {
            byte bMo34159a = c5910eb.mo34159a(i10);
            if (bMo34159a >= 65 && bMo34159a <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c5910eb.mo34196n());
            }
        }
        return c5910eb;
    }

    /* renamed from: a */
    public static Map<C5910eb, Integer> m35447a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f28415e.length);
        int i10 = 0;
        while (true) {
            C6090s9[] c6090s9Arr = f28415e;
            if (i10 >= c6090s9Arr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(c6090s9Arr[i10].f28243a)) {
                linkedHashMap.put(c6090s9Arr[i10].f28243a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
