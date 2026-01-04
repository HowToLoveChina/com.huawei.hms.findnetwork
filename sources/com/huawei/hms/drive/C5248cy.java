package com.huawei.hms.drive;

import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.hms.network.embedded.C6142w9;
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
import p022ay.C1054d;
import p022ay.C1057g;
import p022ay.C1064n;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.cy */
/* loaded from: classes8.dex */
final class C5248cy {

    /* renamed from: a */
    static final C5247cx[] f24277a;

    /* renamed from: b */
    static final Map<C1057g, Integer> f24278b;

    /* renamed from: com.huawei.hms.drive.cy$a */
    public static final class a {

        /* renamed from: a */
        C5247cx[] f24279a;

        /* renamed from: b */
        int f24280b;

        /* renamed from: c */
        int f24281c;

        /* renamed from: d */
        int f24282d;

        /* renamed from: e */
        private final List<C5247cx> f24283e;

        /* renamed from: f */
        private final InterfaceC1056f f24284f;

        /* renamed from: g */
        private final int f24285g;

        /* renamed from: h */
        private int f24286h;

        public a(int i10, InterfaceC1076z interfaceC1076z) {
            this(i10, i10, interfaceC1076z);
        }

        /* renamed from: a */
        private int m31458a(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f24279a.length;
                while (true) {
                    length--;
                    i11 = this.f24280b;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f24279a[length].f24276i;
                    i10 -= i13;
                    this.f24282d -= i13;
                    this.f24281c--;
                    i12++;
                }
                C5247cx[] c5247cxArr = this.f24279a;
                System.arraycopy(c5247cxArr, i11 + 1, c5247cxArr, i11 + 1 + i12, this.f24281c);
                this.f24280b += i12;
            }
            return i12;
        }

        /* renamed from: c */
        private int m31461c(int i10) {
            return this.f24280b + 1 + i10;
        }

        /* renamed from: d */
        private void m31462d() {
            int i10 = this.f24286h;
            int i11 = this.f24282d;
            if (i10 < i11) {
                if (i10 == 0) {
                    m31464e();
                } else {
                    m31458a(i11 - i10);
                }
            }
        }

        /* renamed from: e */
        private void m31464e() {
            Arrays.fill(this.f24279a, (Object) null);
            this.f24280b = this.f24279a.length - 1;
            this.f24281c = 0;
            this.f24282d = 0;
        }

        /* renamed from: f */
        private void m31467f() throws IOException {
            this.f24283e.add(new C5247cx(C5248cy.m31456a(m31474c()), m31474c()));
        }

        /* renamed from: g */
        private void m31468g() throws IOException {
            m31459a(-1, new C5247cx(C5248cy.m31456a(m31474c()), m31474c()));
        }

        /* renamed from: h */
        private int m31470h() throws IOException {
            return this.f24284f.readByte() & 255;
        }

        /* renamed from: b */
        public List<C5247cx> m31473b() {
            ArrayList arrayList = new ArrayList(this.f24283e);
            this.f24283e.clear();
            return arrayList;
        }

        public a(int i10, int i11, InterfaceC1076z interfaceC1076z) {
            this.f24283e = new ArrayList();
            this.f24279a = new C5247cx[8];
            this.f24280b = r0.length - 1;
            this.f24281c = 0;
            this.f24282d = 0;
            this.f24285g = i10;
            this.f24286h = i11;
            this.f24284f = C1064n.m6403b(interfaceC1076z);
        }

        /* renamed from: c */
        public C1057g m31474c() throws IOException {
            int iM31470h = m31470h();
            boolean z10 = (iM31470h & 128) == 128;
            int iM31471a = m31471a(iM31470h, 127);
            return z10 ? C1057g.m6365x(C5257df.m31620a().m31625a(this.f24284f.mo6346l0(iM31471a))) : this.f24284f.mo6345l(iM31471a);
        }

        /* renamed from: b */
        private void m31460b(int i10) throws IOException {
            if (m31469g(i10)) {
                this.f24283e.add(C5248cy.f24277a[i10]);
                return;
            }
            int iM31461c = m31461c(i10 - C5248cy.f24277a.length);
            if (iM31461c >= 0) {
                C5247cx[] c5247cxArr = this.f24279a;
                if (iM31461c < c5247cxArr.length) {
                    this.f24283e.add(c5247cxArr[iM31461c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        /* renamed from: d */
        private void m31463d(int i10) throws IOException {
            this.f24283e.add(new C5247cx(m31466f(i10), m31474c()));
        }

        /* renamed from: f */
        private C1057g m31466f(int i10) throws IOException {
            if (m31469g(i10)) {
                return C5248cy.f24277a[i10].f24274g;
            }
            int iM31461c = m31461c(i10 - C5248cy.f24277a.length);
            if (iM31461c >= 0) {
                C5247cx[] c5247cxArr = this.f24279a;
                if (iM31461c < c5247cxArr.length) {
                    return c5247cxArr[iM31461c].f24274g;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        /* renamed from: g */
        private boolean m31469g(int i10) {
            return i10 >= 0 && i10 <= C5248cy.f24277a.length - 1;
        }

        /* renamed from: e */
        private void m31465e(int i10) throws IOException {
            m31459a(-1, new C5247cx(m31466f(i10), m31474c()));
        }

        /* renamed from: a */
        public void m31472a() throws IOException {
            while (!this.f24284f.mo6325M()) {
                byte b10 = this.f24284f.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b10 & 128) == 128) {
                    m31460b(m31471a(i10, 127) - 1);
                } else if (i10 == 64) {
                    m31468g();
                } else if ((b10 & 64) == 64) {
                    m31465e(m31471a(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int iM31471a = m31471a(i10, 31);
                    this.f24286h = iM31471a;
                    if (iM31471a >= 0 && iM31471a <= this.f24285g) {
                        m31462d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f24286h);
                    }
                } else if (i10 != 16 && i10 != 0) {
                    m31463d(m31471a(i10, 15) - 1);
                } else {
                    m31467f();
                }
            }
        }

        /* renamed from: a */
        private void m31459a(int i10, C5247cx c5247cx) {
            this.f24283e.add(c5247cx);
            int i11 = c5247cx.f24276i;
            if (i10 != -1) {
                i11 -= this.f24279a[m31461c(i10)].f24276i;
            }
            int i12 = this.f24286h;
            if (i11 > i12) {
                m31464e();
                return;
            }
            int iM31458a = m31458a((this.f24282d + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f24281c + 1;
                C5247cx[] c5247cxArr = this.f24279a;
                if (i13 > c5247cxArr.length) {
                    C5247cx[] c5247cxArr2 = new C5247cx[c5247cxArr.length * 2];
                    System.arraycopy(c5247cxArr, 0, c5247cxArr2, c5247cxArr.length, c5247cxArr.length);
                    this.f24280b = this.f24279a.length - 1;
                    this.f24279a = c5247cxArr2;
                }
                int i14 = this.f24280b;
                this.f24280b = i14 - 1;
                this.f24279a[i14] = c5247cx;
                this.f24281c++;
            } else {
                this.f24279a[i10 + m31461c(i10) + iM31458a] = c5247cx;
            }
            this.f24282d += i11;
        }

        /* renamed from: a */
        public int m31471a(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iM31470h = m31470h();
                if ((iM31470h & 128) == 0) {
                    return i11 + (iM31470h << i13);
                }
                i11 += (iM31470h & 127) << i13;
                i13 += 7;
            }
        }
    }

    static {
        C5247cx c5247cx = new C5247cx(C5247cx.f24273f, "");
        C1057g c1057g = C5247cx.f24270c;
        C5247cx c5247cx2 = new C5247cx(c1057g, "GET");
        C5247cx c5247cx3 = new C5247cx(c1057g, "POST");
        C1057g c1057g2 = C5247cx.f24271d;
        C5247cx c5247cx4 = new C5247cx(c1057g2, "/");
        C5247cx c5247cx5 = new C5247cx(c1057g2, "/index.html");
        C1057g c1057g3 = C5247cx.f24272e;
        C5247cx c5247cx6 = new C5247cx(c1057g3, "http");
        C5247cx c5247cx7 = new C5247cx(c1057g3, "https");
        C1057g c1057g4 = C5247cx.f24269b;
        f24277a = new C5247cx[]{c5247cx, c5247cx2, c5247cx3, c5247cx4, c5247cx5, c5247cx6, c5247cx7, new C5247cx(c1057g4, "200"), new C5247cx(c1057g4, "204"), new C5247cx(c1057g4, "206"), new C5247cx(c1057g4, "304"), new C5247cx(c1057g4, "400"), new C5247cx(c1057g4, "404"), new C5247cx(c1057g4, "500"), new C5247cx("accept-charset", ""), new C5247cx("accept-encoding", "gzip, deflate"), new C5247cx("accept-language", ""), new C5247cx("accept-ranges", ""), new C5247cx("accept", ""), new C5247cx("access-control-allow-origin", ""), new C5247cx("age", ""), new C5247cx("allow", ""), new C5247cx("authorization", ""), new C5247cx("cache-control", ""), new C5247cx("content-disposition", ""), new C5247cx("content-encoding", ""), new C5247cx("content-language", ""), new C5247cx(C5966j2.f27081w, ""), new C5247cx("content-location", ""), new C5247cx("content-range", ""), new C5247cx("content-type", ""), new C5247cx("cookie", ""), new C5247cx(CallLogCons.DATE, ""), new C5247cx(SyncProtocol.Constant.ETAG, ""), new C5247cx("expect", ""), new C5247cx("expires", ""), new C5247cx(RemoteMessageConst.FROM, ""), new C5247cx("host", ""), new C5247cx("if-match", ""), new C5247cx("if-modified-since", ""), new C5247cx("if-none-match", ""), new C5247cx("if-range", ""), new C5247cx("if-unmodified-since", ""), new C5247cx("last-modified", ""), new C5247cx("link", ""), new C5247cx(JsbMapKeyNames.H5_LOC, ""), new C5247cx("max-forwards", ""), new C5247cx("proxy-authenticate", ""), new C5247cx("proxy-authorization", ""), new C5247cx("range", ""), new C5247cx("referer", ""), new C5247cx("refresh", ""), new C5247cx("retry-after", ""), new C5247cx("server", ""), new C5247cx("set-cookie", ""), new C5247cx("strict-transport-security", ""), new C5247cx(C6142w9.f28871l, ""), new C5247cx(FeedbackWebConstants.USER_AGENT, ""), new C5247cx("vary", ""), new C5247cx("via", ""), new C5247cx("www-authenticate", "")};
        f24278b = m31457a();
    }

    /* renamed from: a */
    private static Map<C1057g, Integer> m31457a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f24277a.length);
        int i10 = 0;
        while (true) {
            C5247cx[] c5247cxArr = f24277a;
            if (i10 >= c5247cxArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(c5247cxArr[i10].f24274g)) {
                linkedHashMap.put(c5247cxArr[i10].f24274g, Integer.valueOf(i10));
            }
            i10++;
        }
    }

    /* renamed from: com.huawei.hms.drive.cy$b */
    public static final class b {

        /* renamed from: a */
        int f24287a;

        /* renamed from: b */
        int f24288b;

        /* renamed from: c */
        C5247cx[] f24289c;

        /* renamed from: d */
        int f24290d;

        /* renamed from: e */
        int f24291e;

        /* renamed from: f */
        int f24292f;

        /* renamed from: g */
        private final C1054d f24293g;

        /* renamed from: h */
        private final boolean f24294h;

        /* renamed from: i */
        private int f24295i;

        /* renamed from: j */
        private boolean f24296j;

        public b(C1054d c1054d) {
            this(4096, true, c1054d);
        }

        /* renamed from: a */
        private void m31475a() {
            Arrays.fill(this.f24289c, (Object) null);
            this.f24290d = this.f24289c.length - 1;
            this.f24291e = 0;
            this.f24292f = 0;
        }

        /* renamed from: b */
        private int m31477b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f24289c.length;
                while (true) {
                    length--;
                    i11 = this.f24290d;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f24289c[length].f24276i;
                    i10 -= i13;
                    this.f24292f -= i13;
                    this.f24291e--;
                    i12++;
                }
                C5247cx[] c5247cxArr = this.f24289c;
                System.arraycopy(c5247cxArr, i11 + 1, c5247cxArr, i11 + 1 + i12, this.f24291e);
                C5247cx[] c5247cxArr2 = this.f24289c;
                int i14 = this.f24290d;
                Arrays.fill(c5247cxArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f24290d += i12;
            }
            return i12;
        }

        public b(int i10, boolean z10, C1054d c1054d) {
            this.f24295i = Integer.MAX_VALUE;
            this.f24289c = new C5247cx[8];
            this.f24290d = r0.length - 1;
            this.f24291e = 0;
            this.f24292f = 0;
            this.f24287a = i10;
            this.f24288b = i10;
            this.f24294h = z10;
            this.f24293g = c1054d;
        }

        /* renamed from: a */
        private void m31476a(C5247cx c5247cx) {
            int i10 = c5247cx.f24276i;
            int i11 = this.f24288b;
            if (i10 > i11) {
                m31475a();
                return;
            }
            m31477b((this.f24292f + i10) - i11);
            int i12 = this.f24291e + 1;
            C5247cx[] c5247cxArr = this.f24289c;
            if (i12 > c5247cxArr.length) {
                C5247cx[] c5247cxArr2 = new C5247cx[c5247cxArr.length * 2];
                System.arraycopy(c5247cxArr, 0, c5247cxArr2, c5247cxArr.length, c5247cxArr.length);
                this.f24290d = this.f24289c.length - 1;
                this.f24289c = c5247cxArr2;
            }
            int i13 = this.f24290d;
            this.f24290d = i13 - 1;
            this.f24289c[i13] = c5247cx;
            this.f24291e++;
            this.f24292f += i10;
        }

        /* renamed from: b */
        private void m31478b() {
            int i10 = this.f24288b;
            int i11 = this.f24292f;
            if (i10 < i11) {
                if (i10 == 0) {
                    m31475a();
                } else {
                    m31477b(i11 - i10);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m31482a(java.util.List<com.huawei.hms.drive.C5247cx> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5248cy.b.m31482a(java.util.List):void");
        }

        /* renamed from: a */
        public void m31480a(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f24293g.writeByte(i10 | i12);
                return;
            }
            this.f24293g.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f24293g.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f24293g.writeByte(i13);
        }

        /* renamed from: a */
        public void m31481a(C1057g c1057g) throws IOException {
            if (this.f24294h && C5257df.m31620a().m31623a(c1057g) < c1057g.m6370E()) {
                C1054d c1054d = new C1054d();
                C5257df.m31620a().m31624a(c1057g, c1054d);
                C1057g c1057gM6313B = c1054d.m6313B();
                m31480a(c1057gM6313B.m6370E(), 127, 128);
                this.f24293g.mo6337a(c1057gM6313B);
                return;
            }
            m31480a(c1057g.m6370E(), 127, 0);
            this.f24293g.mo6337a(c1057g);
        }

        /* renamed from: a */
        public void m31479a(int i10) {
            this.f24287a = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f24288b;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f24295i = Math.min(this.f24295i, iMin);
            }
            this.f24296j = true;
            this.f24288b = iMin;
            m31478b();
        }
    }

    /* renamed from: a */
    public static C1057g m31456a(C1057g c1057g) throws IOException {
        int iM6370E = c1057g.m6370E();
        for (int i10 = 0; i10 < iM6370E; i10++) {
            byte bM6379p = c1057g.m6379p(i10);
            if (bM6379p >= 65 && bM6379p <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c1057g.m6374I());
            }
        }
        return c1057g;
    }
}
