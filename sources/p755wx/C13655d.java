package p755wx;

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

/* renamed from: wx.d */
/* loaded from: classes9.dex */
public final class C13655d {

    /* renamed from: a */
    public static final C13654c[] f61386a;

    /* renamed from: b */
    public static final Map<C1057g, Integer> f61387b;

    /* renamed from: wx.d$a */
    public static final class a {

        /* renamed from: a */
        public final List<C13654c> f61388a;

        /* renamed from: b */
        public final InterfaceC1056f f61389b;

        /* renamed from: c */
        public final int f61390c;

        /* renamed from: d */
        public int f61391d;

        /* renamed from: e */
        public C13654c[] f61392e;

        /* renamed from: f */
        public int f61393f;

        /* renamed from: g */
        public int f61394g;

        /* renamed from: h */
        public int f61395h;

        public a(int i10, InterfaceC1076z interfaceC1076z) {
            this(i10, i10, interfaceC1076z);
        }

        /* renamed from: a */
        public final void m82043a() {
            int i10 = this.f61391d;
            int i11 = this.f61395h;
            if (i10 < i11) {
                if (i10 == 0) {
                    m82044b();
                } else {
                    m82046d(i11 - i10);
                }
            }
        }

        /* renamed from: b */
        public final void m82044b() {
            Arrays.fill(this.f61392e, (Object) null);
            this.f61393f = this.f61392e.length - 1;
            this.f61394g = 0;
            this.f61395h = 0;
        }

        /* renamed from: c */
        public final int m82045c(int i10) {
            return this.f61393f + 1 + i10;
        }

        /* renamed from: d */
        public final int m82046d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f61392e.length;
                while (true) {
                    length--;
                    i11 = this.f61393f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f61392e[length].f61385c;
                    i10 -= i13;
                    this.f61395h -= i13;
                    this.f61394g--;
                    i12++;
                }
                C13654c[] c13654cArr = this.f61392e;
                System.arraycopy(c13654cArr, i11 + 1, c13654cArr, i11 + 1 + i12, this.f61394g);
                this.f61393f += i12;
            }
            return i12;
        }

        /* renamed from: e */
        public List<C13654c> m82047e() {
            ArrayList arrayList = new ArrayList(this.f61388a);
            this.f61388a.clear();
            return arrayList;
        }

        /* renamed from: f */
        public final C1057g m82048f(int i10) throws IOException {
            if (m82050h(i10)) {
                return C13655d.f61386a[i10].f61383a;
            }
            int iM82045c = m82045c(i10 - C13655d.f61386a.length);
            if (iM82045c >= 0) {
                C13654c[] c13654cArr = this.f61392e;
                if (iM82045c < c13654cArr.length) {
                    return c13654cArr[iM82045c].f61383a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        /* renamed from: g */
        public final void m82049g(int i10, C13654c c13654c) {
            this.f61388a.add(c13654c);
            int i11 = c13654c.f61385c;
            if (i10 != -1) {
                i11 -= this.f61392e[m82045c(i10)].f61385c;
            }
            int i12 = this.f61391d;
            if (i11 > i12) {
                m82044b();
                return;
            }
            int iM82046d = m82046d((this.f61395h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f61394g + 1;
                C13654c[] c13654cArr = this.f61392e;
                if (i13 > c13654cArr.length) {
                    C13654c[] c13654cArr2 = new C13654c[c13654cArr.length * 2];
                    System.arraycopy(c13654cArr, 0, c13654cArr2, c13654cArr.length, c13654cArr.length);
                    this.f61393f = this.f61392e.length - 1;
                    this.f61392e = c13654cArr2;
                }
                int i14 = this.f61393f;
                this.f61393f = i14 - 1;
                this.f61392e[i14] = c13654c;
                this.f61394g++;
            } else {
                this.f61392e[i10 + m82045c(i10) + iM82046d] = c13654c;
            }
            this.f61395h += i11;
        }

        /* renamed from: h */
        public final boolean m82050h(int i10) {
            return i10 >= 0 && i10 <= C13655d.f61386a.length - 1;
        }

        /* renamed from: i */
        public final int m82051i() throws IOException {
            return this.f61389b.readByte() & 255;
        }

        /* renamed from: j */
        public C1057g m82052j() throws IOException {
            int iM82051i = m82051i();
            boolean z10 = (iM82051i & 128) == 128;
            int iM82055m = m82055m(iM82051i, 127);
            return z10 ? C1057g.m6365x(C13662k.m82179f().m82182c(this.f61389b.mo6346l0(iM82055m))) : this.f61389b.mo6345l(iM82055m);
        }

        /* renamed from: k */
        public void m82053k() throws IOException {
            while (!this.f61389b.mo6325M()) {
                byte b10 = this.f61389b.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b10 & 128) == 128) {
                    m82054l(m82055m(i10, 127) - 1);
                } else if (i10 == 64) {
                    m82057o();
                } else if ((b10 & 64) == 64) {
                    m82056n(m82055m(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int iM82055m = m82055m(i10, 31);
                    this.f61391d = iM82055m;
                    if (iM82055m < 0 || iM82055m > this.f61390c) {
                        throw new IOException("Invalid dynamic table size update " + this.f61391d);
                    }
                    m82043a();
                } else if (i10 == 16 || i10 == 0) {
                    m82059q();
                } else {
                    m82058p(m82055m(i10, 15) - 1);
                }
            }
        }

        /* renamed from: l */
        public final void m82054l(int i10) throws IOException {
            if (m82050h(i10)) {
                this.f61388a.add(C13655d.f61386a[i10]);
                return;
            }
            int iM82045c = m82045c(i10 - C13655d.f61386a.length);
            if (iM82045c >= 0) {
                C13654c[] c13654cArr = this.f61392e;
                if (iM82045c < c13654cArr.length) {
                    this.f61388a.add(c13654cArr[iM82045c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        /* renamed from: m */
        public int m82055m(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iM82051i = m82051i();
                if ((iM82051i & 128) == 0) {
                    return i11 + (iM82051i << i13);
                }
                i11 += (iM82051i & 127) << i13;
                i13 += 7;
            }
        }

        /* renamed from: n */
        public final void m82056n(int i10) throws IOException {
            m82049g(-1, new C13654c(m82048f(i10), m82052j()));
        }

        /* renamed from: o */
        public final void m82057o() throws IOException {
            m82049g(-1, new C13654c(C13655d.m82041a(m82052j()), m82052j()));
        }

        /* renamed from: p */
        public final void m82058p(int i10) throws IOException {
            this.f61388a.add(new C13654c(m82048f(i10), m82052j()));
        }

        /* renamed from: q */
        public final void m82059q() throws IOException {
            this.f61388a.add(new C13654c(C13655d.m82041a(m82052j()), m82052j()));
        }

        public a(int i10, int i11, InterfaceC1076z interfaceC1076z) {
            this.f61388a = new ArrayList();
            this.f61392e = new C13654c[8];
            this.f61393f = r0.length - 1;
            this.f61394g = 0;
            this.f61395h = 0;
            this.f61390c = i10;
            this.f61391d = i11;
            this.f61389b = C1064n.m6403b(interfaceC1076z);
        }
    }

    static {
        C13654c c13654c = new C13654c(C13654c.f61382i, "");
        C1057g c1057g = C13654c.f61379f;
        C13654c c13654c2 = new C13654c(c1057g, "GET");
        C13654c c13654c3 = new C13654c(c1057g, "POST");
        C1057g c1057g2 = C13654c.f61380g;
        C13654c c13654c4 = new C13654c(c1057g2, "/");
        C13654c c13654c5 = new C13654c(c1057g2, "/index.html");
        C1057g c1057g3 = C13654c.f61381h;
        C13654c c13654c6 = new C13654c(c1057g3, "http");
        C13654c c13654c7 = new C13654c(c1057g3, "https");
        C1057g c1057g4 = C13654c.f61378e;
        f61386a = new C13654c[]{c13654c, c13654c2, c13654c3, c13654c4, c13654c5, c13654c6, c13654c7, new C13654c(c1057g4, "200"), new C13654c(c1057g4, "204"), new C13654c(c1057g4, "206"), new C13654c(c1057g4, "304"), new C13654c(c1057g4, "400"), new C13654c(c1057g4, "404"), new C13654c(c1057g4, "500"), new C13654c("accept-charset", ""), new C13654c("accept-encoding", "gzip, deflate"), new C13654c("accept-language", ""), new C13654c("accept-ranges", ""), new C13654c("accept", ""), new C13654c("access-control-allow-origin", ""), new C13654c("age", ""), new C13654c("allow", ""), new C13654c("authorization", ""), new C13654c("cache-control", ""), new C13654c("content-disposition", ""), new C13654c("content-encoding", ""), new C13654c("content-language", ""), new C13654c(C5966j2.f27081w, ""), new C13654c("content-location", ""), new C13654c("content-range", ""), new C13654c("content-type", ""), new C13654c("cookie", ""), new C13654c(CallLogCons.DATE, ""), new C13654c(SyncProtocol.Constant.ETAG, ""), new C13654c("expect", ""), new C13654c("expires", ""), new C13654c(RemoteMessageConst.FROM, ""), new C13654c("host", ""), new C13654c("if-match", ""), new C13654c("if-modified-since", ""), new C13654c("if-none-match", ""), new C13654c("if-range", ""), new C13654c("if-unmodified-since", ""), new C13654c("last-modified", ""), new C13654c("link", ""), new C13654c(JsbMapKeyNames.H5_LOC, ""), new C13654c("max-forwards", ""), new C13654c("proxy-authenticate", ""), new C13654c("proxy-authorization", ""), new C13654c("range", ""), new C13654c("referer", ""), new C13654c("refresh", ""), new C13654c("retry-after", ""), new C13654c("server", ""), new C13654c("set-cookie", ""), new C13654c("strict-transport-security", ""), new C13654c(C6142w9.f28871l, ""), new C13654c(FeedbackWebConstants.USER_AGENT, ""), new C13654c("vary", ""), new C13654c("via", ""), new C13654c("www-authenticate", "")};
        f61387b = m82042b();
    }

    /* renamed from: a */
    public static C1057g m82041a(C1057g c1057g) throws IOException {
        int iM6370E = c1057g.m6370E();
        for (int i10 = 0; i10 < iM6370E; i10++) {
            byte bM6379p = c1057g.m6379p(i10);
            if (bM6379p >= 65 && bM6379p <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c1057g.m6374I());
            }
        }
        return c1057g;
    }

    /* renamed from: b */
    public static Map<C1057g, Integer> m82042b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f61386a.length);
        int i10 = 0;
        while (true) {
            C13654c[] c13654cArr = f61386a;
            if (i10 >= c13654cArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(c13654cArr[i10].f61383a)) {
                linkedHashMap.put(c13654cArr[i10].f61383a, Integer.valueOf(i10));
            }
            i10++;
        }
    }

    /* renamed from: wx.d$b */
    public static final class b {

        /* renamed from: a */
        public final C1054d f61396a;

        /* renamed from: b */
        public final boolean f61397b;

        /* renamed from: c */
        public int f61398c;

        /* renamed from: d */
        public boolean f61399d;

        /* renamed from: e */
        public int f61400e;

        /* renamed from: f */
        public int f61401f;

        /* renamed from: g */
        public C13654c[] f61402g;

        /* renamed from: h */
        public int f61403h;

        /* renamed from: i */
        public int f61404i;

        /* renamed from: j */
        public int f61405j;

        public b(C1054d c1054d) {
            this(4096, true, c1054d);
        }

        /* renamed from: a */
        public final void m82060a() {
            int i10 = this.f61401f;
            int i11 = this.f61405j;
            if (i10 < i11) {
                if (i10 == 0) {
                    m82061b();
                } else {
                    m82062c(i11 - i10);
                }
            }
        }

        /* renamed from: b */
        public final void m82061b() {
            Arrays.fill(this.f61402g, (Object) null);
            this.f61403h = this.f61402g.length - 1;
            this.f61404i = 0;
            this.f61405j = 0;
        }

        /* renamed from: c */
        public final int m82062c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f61402g.length;
                while (true) {
                    length--;
                    i11 = this.f61403h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f61402g[length].f61385c;
                    i10 -= i13;
                    this.f61405j -= i13;
                    this.f61404i--;
                    i12++;
                }
                C13654c[] c13654cArr = this.f61402g;
                System.arraycopy(c13654cArr, i11 + 1, c13654cArr, i11 + 1 + i12, this.f61404i);
                C13654c[] c13654cArr2 = this.f61402g;
                int i14 = this.f61403h;
                Arrays.fill(c13654cArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f61403h += i12;
            }
            return i12;
        }

        /* renamed from: d */
        public final void m82063d(C13654c c13654c) {
            int i10 = c13654c.f61385c;
            int i11 = this.f61401f;
            if (i10 > i11) {
                m82061b();
                return;
            }
            m82062c((this.f61405j + i10) - i11);
            int i12 = this.f61404i + 1;
            C13654c[] c13654cArr = this.f61402g;
            if (i12 > c13654cArr.length) {
                C13654c[] c13654cArr2 = new C13654c[c13654cArr.length * 2];
                System.arraycopy(c13654cArr, 0, c13654cArr2, c13654cArr.length, c13654cArr.length);
                this.f61403h = this.f61402g.length - 1;
                this.f61402g = c13654cArr2;
            }
            int i13 = this.f61403h;
            this.f61403h = i13 - 1;
            this.f61402g[i13] = c13654c;
            this.f61404i++;
            this.f61405j += i10;
        }

        /* renamed from: e */
        public void m82064e(int i10) {
            this.f61400e = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f61401f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f61398c = Math.min(this.f61398c, iMin);
            }
            this.f61399d = true;
            this.f61401f = iMin;
            m82060a();
        }

        /* renamed from: f */
        public void m82065f(C1057g c1057g) throws IOException {
            if (!this.f61397b || C13662k.m82179f().m82184e(c1057g) >= c1057g.m6370E()) {
                m82067h(c1057g.m6370E(), 127, 0);
                this.f61396a.mo6337a(c1057g);
                return;
            }
            C1054d c1054d = new C1054d();
            C13662k.m82179f().m82183d(c1057g, c1054d);
            C1057g c1057gM6313B = c1054d.m6313B();
            m82067h(c1057gM6313B.m6370E(), 127, 128);
            this.f61396a.mo6337a(c1057gM6313B);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m82066g(java.util.List<p755wx.C13654c> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p755wx.C13655d.b.m82066g(java.util.List):void");
        }

        /* renamed from: h */
        public void m82067h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f61396a.writeByte(i10 | i12);
                return;
            }
            this.f61396a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f61396a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f61396a.writeByte(i13);
        }

        public b(int i10, boolean z10, C1054d c1054d) {
            this.f61398c = Integer.MAX_VALUE;
            this.f61402g = new C13654c[8];
            this.f61403h = r0.length - 1;
            this.f61404i = 0;
            this.f61405j = 0;
            this.f61400e = i10;
            this.f61401f = i10;
            this.f61397b = z10;
            this.f61396a = c1054d;
        }
    }
}
