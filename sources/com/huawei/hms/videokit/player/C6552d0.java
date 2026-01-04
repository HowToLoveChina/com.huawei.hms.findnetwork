package com.huawei.hms.videokit.player;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.videokit.player.d0 */
/* loaded from: classes8.dex */
public final class C6552d0 extends C6544b0 {

    /* renamed from: A */
    private int f30362A;

    /* renamed from: B */
    private long f30363B;

    /* renamed from: C */
    private long f30364C;

    /* renamed from: D */
    private long f30365D;

    /* renamed from: E */
    private long f30366E;

    /* renamed from: F */
    private long f30367F;

    /* renamed from: G */
    private String f30368G;

    /* renamed from: H */
    private long f30369H;

    /* renamed from: I */
    private List<String> f30370I;

    /* renamed from: J */
    private String f30371J;

    /* renamed from: K */
    private String f30372K;

    /* renamed from: L */
    private long f30373L;

    /* renamed from: M */
    private long f30374M;

    /* renamed from: N */
    private long f30375N;

    /* renamed from: O */
    private long f30376O;

    /* renamed from: P */
    private long f30377P;

    /* renamed from: Q */
    private long f30378Q;

    /* renamed from: R */
    private long f30379R;

    /* renamed from: S */
    private String f30380S;

    /* renamed from: T */
    private long f30381T;

    /* renamed from: U */
    private int f30382U;

    /* renamed from: V */
    private int f30383V;

    /* renamed from: W */
    private int f30384W;

    /* renamed from: X */
    private int f30385X;

    /* renamed from: Y */
    private long f30386Y;

    /* renamed from: Z */
    private int f30387Z;

    /* renamed from: a0 */
    private final Object f30388a0;

    /* renamed from: b */
    private Context f30389b;

    /* renamed from: b0 */
    private String f30390b0;

    /* renamed from: c */
    private int f30391c;

    /* renamed from: c0 */
    private long f30392c0;

    /* renamed from: d */
    private int f30393d;

    /* renamed from: d0 */
    private boolean f30394d0;

    /* renamed from: e */
    private String f30395e;

    /* renamed from: e0 */
    private long f30396e0;

    /* renamed from: f */
    private String f30397f;

    /* renamed from: f0 */
    private long f30398f0;

    /* renamed from: g */
    private String f30399g;

    /* renamed from: g0 */
    private int f30400g0;

    /* renamed from: h */
    private int f30401h;

    /* renamed from: h0 */
    private long f30402h0;

    /* renamed from: i */
    private int f30403i;

    /* renamed from: i0 */
    private long f30404i0;

    /* renamed from: j */
    private long f30405j;

    /* renamed from: j0 */
    private long f30406j0;

    /* renamed from: k */
    private long f30407k;

    /* renamed from: k0 */
    private long f30408k0;

    /* renamed from: l */
    private long f30409l;

    /* renamed from: l0 */
    private long f30410l0;

    /* renamed from: m */
    private long f30411m;

    /* renamed from: m0 */
    private long f30412m0;

    /* renamed from: n */
    private String f30413n;

    /* renamed from: n0 */
    private String f30414n0;

    /* renamed from: o */
    private long f30415o;

    /* renamed from: o0 */
    private long f30416o0;

    /* renamed from: p */
    private long f30417p;

    /* renamed from: p0 */
    private long f30418p0;

    /* renamed from: q */
    private long f30419q;

    /* renamed from: q0 */
    private long f30420q0;

    /* renamed from: r */
    private long f30421r;

    /* renamed from: r0 */
    private AtomicBoolean f30422r0;

    /* renamed from: s */
    private long f30423s;

    /* renamed from: s0 */
    private AtomicBoolean f30424s0;

    /* renamed from: t */
    private long f30425t;

    /* renamed from: t0 */
    private AtomicInteger f30426t0;

    /* renamed from: u */
    private long f30427u;

    /* renamed from: u0 */
    C6609y f30428u0;

    /* renamed from: v */
    private String f30429v;

    /* renamed from: w */
    private int f30430w;

    /* renamed from: x */
    private int f30431x;

    /* renamed from: y */
    private int f30432y;

    /* renamed from: z */
    private int f30433z;

    public C6552d0(Context context) {
        super(context);
        this.f30391c = 1;
        this.f30393d = 0;
        this.f30395e = "";
        this.f30397f = "";
        this.f30399g = "";
        this.f30401h = 0;
        this.f30403i = 0;
        this.f30405j = 0L;
        this.f30407k = 0L;
        this.f30409l = 0L;
        this.f30411m = 0L;
        this.f30413n = "";
        this.f30415o = 0L;
        this.f30417p = 0L;
        this.f30419q = 0L;
        this.f30421r = 0L;
        this.f30423s = 0L;
        this.f30425t = 0L;
        this.f30427u = 0L;
        this.f30429v = "";
        this.f30430w = -1;
        this.f30431x = -1;
        this.f30432y = 0;
        this.f30433z = 0;
        this.f30362A = 0;
        this.f30363B = 0L;
        this.f30364C = 0L;
        this.f30365D = 0L;
        this.f30366E = 0L;
        this.f30367F = 0L;
        this.f30370I = new ArrayList();
        this.f30371J = "";
        this.f30372K = "";
        this.f30373L = 0L;
        this.f30374M = 0L;
        this.f30377P = 0L;
        this.f30378Q = 0L;
        this.f30380S = "";
        this.f30381T = 0L;
        this.f30382U = 0;
        this.f30383V = 0;
        this.f30384W = 0;
        this.f30387Z = 0;
        this.f30388a0 = new Object();
        this.f30390b0 = "";
        this.f30392c0 = 0L;
        this.f30394d0 = false;
        this.f30396e0 = 0L;
        this.f30398f0 = 0L;
        this.f30400g0 = 0;
        this.f30402h0 = 0L;
        this.f30404i0 = 0L;
        this.f30406j0 = 0L;
        this.f30408k0 = 0L;
        this.f30410l0 = 0L;
        this.f30412m0 = 0L;
        this.f30414n0 = "";
        this.f30416o0 = 0L;
        this.f30418p0 = 0L;
        this.f30420q0 = 0L;
        this.f30422r0 = new AtomicBoolean(false);
        this.f30424s0 = new AtomicBoolean(false);
        this.f30426t0 = new AtomicInteger(0);
        this.f30428u0 = C6609y.m37724b();
        this.f30389b = context;
    }

    /* renamed from: g */
    private String m37271g() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f30370I != null) {
            m37279z();
            for (int i10 = 0; i10 < this.f30370I.size(); i10++) {
                sb2.append(this.f30370I.get(i10));
                if (i10 != this.f30370I.size() - 1) {
                    sb2.append(";");
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: h */
    private String m37272h() {
        return C6589n0.m37566b(this.f30389b);
    }

    /* renamed from: i */
    private void m37273i() {
        if (this.f30428u0 == null) {
            this.f30428u0 = C6609y.m37724b();
        }
        if (this.f30422r0.get()) {
            return;
        }
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37591a("appId", this.f30399g);
        c6592p.m37590a("videoType", this.f30393d);
        c6592p.m37590a("dataSourceType", this.f30391c);
        c6592p.m37591a("playParam", this.f30397f);
        c6592p.m37590a("MATCH_PRELOAD", this.f30401h);
        c6592p.m37591a("ContentUrl", this.f30395e);
        c6592p.m37591a("NET", m37272h());
        c6592p.m37591a("CDNURL", this.f30413n);
        long j10 = this.f30405j;
        long j11 = 0;
        if (j10 == 0) {
            j10 = this.f30409l;
        }
        c6592p.m37590a("STARTTS", j10);
        c6592p.m37590a("ENDTS", this.f30365D);
        c6592p.m37590a("ERRORCODE", this.f30432y);
        c6592p.m37590a("EXTRACODE", this.f30433z);
        c6592p.m37591a("errorMessage", this.f30390b0);
        c6592p.m37590a("playResult", this.f30431x);
        c6592p.m37590a("DELAY", this.f30421r);
        c6592p.m37590a("EPG_DELAY", this.f30415o);
        c6592p.m37590a("ACCESS_DELAY", this.f30423s);
        c6592p.m37590a("INIT_BUFFER_DELAY", this.f30419q);
        c6592p.m37590a("DURATION", this.f30366E);
        c6592p.m37590a("STALLING_COUNT", this.f30362A);
        c6592p.m37591a("CDN_TRACK", m37271g());
        c6592p.m37591a("BITRATE_TRACK", this.f30372K);
        c6592p.m37590a("STALLING_TIME", this.f30363B);
        c6592p.m37591a("X-TRACEID", this.f30429v);
        c6592p.m37590a("playScene", this.f30387Z);
        c6592p.m37591a("playEventId", this.f30368G);
        c6592p.m37590a("prePlayEngine", this.f30384W);
        c6592p.m37590a("playEngine", this.f30383V);
        if (this.f30383V == 0) {
            c6592p.m37590a("useProxy", 0L);
        } else {
            c6592p.m37590a("useProxy", C6580j.m37450f());
            j11 = this.f30420q0;
        }
        c6592p.m37590a("suspendTime", j11);
        c6592p.m37590a("preconnectType", this.f30400g0);
        c6592p.m37590a("httpInitTime", this.f30402h0);
        c6592p.m37590a("httpEndTime", this.f30412m0);
        c6592p.m37590a("getResponseTime", this.f30404i0);
        c6592p.m37590a("realReadyTime", this.f30406j0);
        c6592p.m37590a("accessTime", this.f30410l0);
        c6592p.m37590a("onReadyTime", this.f30408k0);
        c6592p.m37590a("startPlayEndTime", this.f30425t);
        c6592p.m37591a("spId", this.f30414n0);
        c6592p.m37590a("firstBufferEndTime", this.f30416o0);
        c6592p.m37590a("establishLinkTime", this.f30418p0);
        this.f30428u0.m37725a(1, "VideoKitOM103", c6592p);
        this.f30422r0.set(true);
        if (this.f30426t0.get() == 3) {
            this.f30368G = "";
        }
    }

    /* renamed from: k */
    private void m37274k() {
        if (this.f30426t0.get() < 1) {
            this.f30369H = 0L;
            m37325t();
            m37289b(5);
            m37269b("VideoKitOP100", 0L);
            this.f30426t0.set(1);
        }
    }

    /* renamed from: l */
    private void m37275l() {
        if (this.f30426t0.get() < 2) {
            m37274k();
            m37325t();
            m37289b(1);
            m37329x();
            m37269b("VideoKitOP100", 0L);
            this.f30426t0.set(2);
        }
    }

    /* renamed from: m */
    private void m37276m() {
        if (this.f30426t0.get() < 3) {
            m37275l();
            m37325t();
            m37289b(4);
            m37269b("VideoKitOP100", this.f30366E);
            this.f30426t0.set(3);
            if (this.f30422r0.get()) {
                this.f30368G = "";
            }
        }
    }

    /* renamed from: n */
    private void m37277n() {
        this.f30417p = 0L;
        this.f30423s = 0L;
        this.f30407k = 0L;
        this.f30405j = 0L;
        this.f30411m = 0L;
        this.f30409l = 0L;
        this.f30415o = 0L;
        this.f30427u = 0L;
        this.f30425t = 0L;
        this.f30419q = 0L;
        this.f30421r = 0L;
        this.f30420q0 = 0L;
        this.f30416o0 = 0L;
        this.f30418p0 = 0L;
        m37278s();
    }

    /* renamed from: s */
    private void m37278s() {
        this.f30402h0 = 0L;
        this.f30404i0 = 0L;
        this.f30406j0 = 0L;
        this.f30408k0 = 0L;
        this.f30410l0 = 0L;
        this.f30412m0 = 0L;
    }

    /* renamed from: z */
    private void m37279z() {
        if (this.f30370I.size() > 0) {
            String str = this.f30370I.get(r0.size() - 1);
            if (TextUtils.isEmpty(this.f30380S)) {
                this.f30380S = this.f30381T + "," + this.f30382U;
            }
            long j10 = this.f30375N;
            long j11 = 0;
            if (j10 == 0) {
                C6550c1.m37264c("HiAnalyticsDataManager", "count total time is 0");
            } else {
                j11 = this.f30376O / j10;
            }
            String str2 = str + "," + j11 + "," + this.f30374M + "," + this.f30380S;
            this.f30370I.set(r1.size() - 1, str2);
            m37321o();
        }
    }

    /* renamed from: a */
    public void m37280a(int i10) {
        if (!C6609y.m37724b().m37727c()) {
            C6550c1.m37256a("HiAnalyticsDataManager", "VideoPlayer reporting channel is off");
            return;
        }
        if (TextUtils.isEmpty(this.f30368G)) {
            m37328w();
        }
        if (this.f30428u0 == null) {
            this.f30428u0 = C6609y.m37724b();
        }
        if (i10 == 1) {
            m37275l();
            return;
        }
        if (i10 == 4) {
            m37276m();
            return;
        }
        if (i10 == 5) {
            m37274k();
            return;
        }
        C6550c1.m37256a("HiAnalyticsDataManager", "current set action type is not supported :" + i10);
    }

    /* renamed from: b */
    public void m37289b(int i10) {
        this.f30385X = i10;
    }

    /* renamed from: c */
    public void m37294c(int i10) {
        this.f30391c = i10;
    }

    /* renamed from: d */
    public void m37299d(int i10) {
        this.f30383V = i10;
    }

    /* renamed from: e */
    public void m37303e(int i10) {
        this.f30387Z = i10;
    }

    /* renamed from: f */
    public void m37307f(int i10) {
        this.f30384W = i10;
    }

    /* renamed from: j */
    public void m37316j() {
        if (!C6609y.m37724b().m37727c()) {
            C6550c1.m37256a("HiAnalyticsDataManager", "VideoPlayer reporting channel is off");
            return;
        }
        if (this.f30424s0.get()) {
            return;
        }
        if (this.f30430w == -1) {
            if (this.f30432y == 0) {
                this.f30430w = 2;
            } else {
                this.f30430w = 1;
            }
        }
        if (TextUtils.isEmpty(this.f30368G)) {
            m37328w();
        }
        if (this.f30428u0 == null) {
            this.f30428u0 = C6609y.m37724b();
        }
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37590a("videoType", this.f30393d);
        c6592p.m37591a("ContentUrl", this.f30395e);
        c6592p.m37591a("CDNURL", this.f30413n);
        c6592p.m37590a("dataSourceType", this.f30391c);
        c6592p.m37591a("playParam", this.f30397f);
        c6592p.m37591a("appId", this.f30399g);
        long j10 = this.f30405j;
        if (j10 == 0) {
            j10 = this.f30409l;
        }
        c6592p.m37590a("STARTTS", j10);
        c6592p.m37590a("ENDTS", this.f30425t);
        c6592p.m37591a("X-TRACEID", this.f30429v);
        c6592p.m37591a("NET", m37272h());
        c6592p.m37590a("startResult", this.f30430w);
        c6592p.m37590a("playScene", this.f30387Z);
        c6592p.m37591a("playEventId", this.f30368G);
        c6592p.m37590a("playEngine", this.f30383V);
        c6592p.m37590a("ERRORCODE", this.f30432y);
        c6592p.m37590a("EXTRACODE", this.f30433z);
        c6592p.m37590a("MATCH_AUTH_CACHE", this.f30403i);
        this.f30428u0.m37725a(1, "VideoKitOM105", c6592p);
        this.f30424s0.set(true);
    }

    /* renamed from: o */
    public void m37321o() {
        this.f30374M = 0L;
        this.f30380S = "";
        this.f30376O = 0L;
        this.f30375N = 0L;
        if (this.f30381T > 0) {
            this.f30382U = 0;
            this.f30381T = 0L;
        }
    }

    /* renamed from: p */
    public void m37322p() {
        C6550c1.m37256a("HiAnalyticsDataManager", "resetReportedReadyStatus()");
        this.f30426t0.set(1);
    }

    /* renamed from: q */
    public void m37323q() {
        C6550c1.m37256a("HiAnalyticsDataManager", "resetReportedStatus()");
        this.f30426t0.set(0);
    }

    /* renamed from: r */
    public void m37324r() {
        this.f30367F = 0L;
    }

    /* renamed from: t */
    public void m37325t() {
        this.f30386Y = C6600t0.m37688f();
    }

    /* renamed from: u */
    public void m37326u() {
        this.f30403i = 1;
    }

    /* renamed from: v */
    public void m37327v() {
        this.f30401h = 1;
    }

    /* renamed from: w */
    public void m37328w() {
        this.f30368G = C6598s0.m37644a(this.f30389b);
    }

    /* renamed from: x */
    public void m37329x() {
        if (this.f30385X == 1) {
            C6550c1.m37256a("HiAnalyticsDataManager", "set play start time");
            this.f30369H = this.f30386Y;
        }
    }

    /* renamed from: y */
    public void m37330y() {
        this.f30366E = 0L;
        this.f30362A = 0;
        this.f30363B = 0L;
        this.f30367F = 0L;
        this.f30401h = 0;
        this.f30403i = 0;
        this.f30372K = "";
        this.f30430w = -1;
        this.f30390b0 = "";
        this.f30432y = 0;
        this.f30433z = 0;
        this.f30392c0 = 0L;
        this.f30396e0 = 0L;
        this.f30398f0 = 0L;
        this.f30373L = 0L;
        this.f30374M = 0L;
        this.f30382U = 0;
        this.f30364C = 0L;
        this.f30365D = 0L;
        this.f30394d0 = false;
        this.f30370I.clear();
        m37277n();
        this.f30424s0.set(false);
        this.f30422r0.set(false);
        this.f30420q0 = 0L;
        this.f30416o0 = 0L;
        this.f30418p0 = 0L;
        m37322p();
    }

    /* renamed from: a */
    public void m37281a(int i10, int i11, int i12, String str) {
        this.f30432y = i11;
        this.f30433z = i12;
        this.f30431x = i10;
        if (i11 == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        this.f30390b0 = str;
    }

    /* renamed from: b */
    public void m37290b(long j10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set http end time : " + j10);
        if (this.f30412m0 == 0) {
            this.f30412m0 = j10;
        }
    }

    /* renamed from: c */
    public void m37295c(long j10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set http init time : " + j10);
        if (this.f30402h0 == 0) {
            this.f30402h0 = j10;
        }
    }

    /* renamed from: d */
    public void m37300d(long j10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set onReady time : " + j10);
        if (this.f30408k0 == 0) {
            this.f30408k0 = j10;
        }
    }

    /* renamed from: e */
    public void m37304e(long j10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set parse response time : " + j10);
        if (this.f30404i0 == 0) {
            this.f30404i0 = j10;
        }
    }

    /* renamed from: f */
    public void m37308f(long j10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set real ready time : " + j10);
        if (this.f30406j0 == 0) {
            this.f30406j0 = j10;
        }
    }

    /* renamed from: g */
    public void m37310g(int i10) {
        if (i10 >= 0) {
            this.f30400g0 = i10;
        }
    }

    /* renamed from: h */
    public void m37312h(int i10) {
        this.f30430w = i10;
    }

    /* renamed from: i */
    public void m37314i(int i10) {
        this.f30393d = i10;
    }

    /* renamed from: j */
    public void m37317j(long j10) {
        long j11 = this.f30364C;
        if (j11 != 0) {
            this.f30366E = (j10 - j11) + this.f30366E;
            C6550c1.m37256a("HiAnalyticsDataManager", "updatePlayDuration time:" + j10 + ",duration:" + this.f30366E);
            this.f30364C = 0L;
        }
        m37270f(j10, 0L);
    }

    /* renamed from: k */
    public void m37318k(long j10) {
        this.f30364C = j10;
        this.f30373L = j10;
    }

    /* renamed from: l */
    public void m37319l(long j10) {
        synchronized (this.f30388a0) {
            long j11 = this.f30367F;
            if (j11 != 0) {
                long j12 = j10 - j11;
                if (j12 > 200) {
                    this.f30363B += j12;
                    this.f30362A++;
                    this.f30381T += j12;
                    this.f30382U++;
                }
                C6550c1.m37256a("HiAnalyticsDataManager", "stallingCount:" + this.f30362A + ", stallingDuration:" + this.f30363B);
                this.f30367F = 0L;
            }
        }
    }

    /* renamed from: m */
    public void m37320m(long j10) {
        if (this.f30367F == 0) {
            this.f30367F = j10;
        }
    }

    /* renamed from: f */
    private void m37270f(long j10, long j11) {
        long j12 = this.f30373L;
        if (j12 != 0) {
            this.f30374M = (j10 - j12) + this.f30374M;
            C6550c1.m37256a("HiAnalyticsDataManager", "update cdn play duration time:" + j10 + ",duration:" + this.f30374M + ", initStartTime:" + j11);
            this.f30373L = j11;
        }
    }

    /* renamed from: a */
    public void m37282a(int i10, Object obj) {
        C6550c1.m37264c("HiAnalyticsDataManager", "setProperties: " + i10);
        if (i10 == 0) {
            if (obj instanceof Long) {
                this.f30416o0 = ((Long) obj).longValue();
            }
        } else if (i10 != 1) {
            C6550c1.m37264c("HiAnalyticsDataManager", "invalid key, do nothing");
        } else if ((obj instanceof Long) && this.f30418p0 == 0) {
            this.f30418p0 = ((Long) obj).longValue();
        }
    }

    /* renamed from: b */
    public void m37291b(long j10, long j11) {
        this.f30365D = j10;
        if (this.f30427u == 0) {
            this.f30425t = j10;
            this.f30427u = j11;
        }
    }

    /* renamed from: c */
    public void m37296c(long j10, long j11) {
        if (this.f30411m != 0) {
            return;
        }
        this.f30411m = j11;
        this.f30409l = j10;
        long j12 = this.f30407k;
        if (j12 != 0 && j11 >= j12) {
            this.f30415o = j11 - j12;
        }
        if (this.f30392c0 != 0) {
            this.f30392c0 = j11;
        }
    }

    /* renamed from: d */
    public void m37301d(long j10, long j11) {
        this.f30405j = j10;
        this.f30407k = j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[PHI: r2
  0x0057: PHI (r2v3 long) = (r2v2 long), (r2v1 long) binds: [B:18:0x0055, B:13:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m37305e(long r9, long r11) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setStartEndTime:suspend duration is:"
            r0.append(r1)
            long r1 = r8.f30396e0
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HiAnalyticsDataManager"
            com.huawei.hms.videokit.player.C6550c1.m37256a(r1, r0)
            long r2 = r8.f30427u
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L21
            return
        L21:
            r8.f30425t = r9
            r8.f30427u = r11
            long r9 = r8.f30417p
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L3a
            long r2 = r8.f30396e0
            long r6 = r9 + r2
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 < 0) goto L3a
            long r9 = r11 - r9
            long r9 = r9 - r2
            r8.f30419q = r9
            r8.f30396e0 = r4
        L3a:
            long r9 = r8.f30398f0
            r8.f30420q0 = r9
            long r2 = r8.f30407k
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L4b
            long r6 = r2 + r9
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 < 0) goto L4b
            goto L57
        L4b:
            long r2 = r8.f30411m
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L5c
            long r6 = r2 + r9
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 < 0) goto L5c
        L57:
            long r11 = r11 - r2
            long r11 = r11 - r9
            r8.f30421r = r11
            goto L61
        L5c:
            java.lang.String r9 = "set start time fail"
            com.huawei.hms.videokit.player.C6550c1.m37256a(r1, r9)
        L61:
            r8.f30398f0 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6552d0.m37305e(long, long):void");
    }

    /* renamed from: g */
    public void m37311g(long j10) {
        this.f30394d0 = false;
        long j11 = this.f30392c0;
        if (j11 != 0) {
            if (this.f30411m == 0 && this.f30407k == 0) {
                return;
            }
            long j12 = j10 - j11;
            this.f30396e0 += j12;
            this.f30398f0 = j12 + this.f30398f0;
            C6550c1.m37256a("HiAnalyticsDataManager", "current suspend delay is " + this.f30398f0);
            if (this.f30430w != 0) {
                this.f30420q0 = this.f30398f0;
            }
            this.f30392c0 = 0L;
        }
    }

    /* renamed from: h */
    public void m37313h(long j10) {
        this.f30394d0 = true;
        if (this.f30392c0 == 0) {
            this.f30392c0 = j10;
        }
    }

    /* renamed from: i */
    public void m37315i(long j10) {
        synchronized (this.f30388a0) {
            try {
                long j11 = this.f30367F;
                if (j11 != 0) {
                    long j12 = j10 - j11;
                    if (j12 > 200) {
                        this.f30381T += j12;
                        this.f30382U++;
                        this.f30380S = this.f30381T + "," + this.f30382U;
                        this.f30382U = 0;
                        this.f30381T = -j12;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m37283a(long j10) {
        if (!C6609y.m37724b().m37727c()) {
            C6550c1.m37256a("HiAnalyticsDataManager", "VideoPlayer reporting channel is off");
            return;
        }
        m37311g(j10);
        m37316j();
        m37273i();
    }

    /* renamed from: b */
    public void m37292b(String str) {
        C6550c1.m37256a("HiAnalyticsDataManager", "setBitrateRecord bitrateRecord:" + str);
        this.f30372K = str;
    }

    /* renamed from: c */
    public void m37297c(String str) {
        if (str == null) {
            return;
        }
        this.f30413n = str;
    }

    /* renamed from: d */
    public void m37302d(String str) {
        if (str == null) {
            return;
        }
        this.f30397f = str;
        this.f30414n0 = C6600t0.m37672a(str);
    }

    /* renamed from: e */
    public void m37306e(String str) {
        if (str == null) {
            return;
        }
        this.f30395e = str;
    }

    /* renamed from: f */
    public void m37309f(String str) {
        if (str == null) {
            return;
        }
        this.f30429v = str;
    }

    /* renamed from: b */
    private void m37269b(String str, long j10) {
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37590a("dataSourceType", this.f30391c);
        c6592p.m37591a("playParam", this.f30397f);
        c6592p.m37590a("videoType", this.f30393d);
        c6592p.m37591a("appId", this.f30399g);
        c6592p.m37591a("NET", m37272h());
        c6592p.m37590a("actionTime", this.f30386Y);
        c6592p.m37591a("X-TRACEID", this.f30429v);
        c6592p.m37591a("playEventId", this.f30368G);
        c6592p.m37590a(Constants.CONTENT_SERVER_REALM, this.f30385X);
        c6592p.m37590a("duration", j10);
        c6592p.m37590a("playStartTime", this.f30369H);
        c6592p.m37590a("playScene", this.f30387Z);
        this.f30428u0.m37725a(0, str, c6592p);
    }

    /* renamed from: a */
    public void m37284a(long j10, long j11) {
        C6550c1.m37256a("HiAnalyticsDataManager", "setAccessTime:suspend duration is:" + this.f30396e0);
        if (this.f30417p != 0) {
            return;
        }
        this.f30410l0 = j10;
        this.f30417p = j11;
        long j12 = this.f30411m;
        if (j12 != 0) {
            long j13 = this.f30396e0;
            if (j11 >= j12 + j13) {
                this.f30423s = (j11 - j12) - j13;
                this.f30396e0 = 0L;
                if (this.f30392c0 != 0) {
                    this.f30392c0 = j11;
                }
            }
        }
    }

    /* renamed from: c */
    public void m37298c(boolean z10) {
        C6550c1.m37256a("HiAnalyticsDataManager", "set buffering status " + z10);
        long j10 = this.f30392c0;
        if (j10 == 0 || !z10) {
            if (this.f30394d0 && !z10 && j10 == 0) {
                this.f30392c0 = C6600t0.m37681c();
                return;
            } else {
                C6550c1.m37256a("HiAnalyticsDataManager", "set buffering status does not affect the results");
                return;
            }
        }
        this.f30396e0 = (C6600t0.m37681c() - this.f30392c0) + this.f30396e0;
        long jM37681c = (C6600t0.m37681c() - this.f30392c0) + this.f30398f0;
        this.f30398f0 = jM37681c;
        if (this.f30430w != 0) {
            this.f30420q0 = jM37681c;
        }
        this.f30392c0 = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m37285a(long r12, boolean r14) {
        /*
            r11 = this;
            long r0 = r11.f30377P
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            r1 = 0
            if (r0 < 0) goto Lb
            r11.f30378Q = r1
            return
        Lb:
            long r3 = com.huawei.hms.videokit.player.C6600t0.m37681c()
            java.lang.String r0 = "HiAnalyticsDataManager"
            r5 = 8
            if (r14 == 0) goto L49
            long r7 = r11.f30379R
            int r14 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r14 <= 0) goto L49
            long r7 = r3 - r7
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            int r14 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r14 != 0) goto L25
            return
        L25:
            long r1 = r11.f30375N
            long r1 = r1 + r7
            r11.f30375N = r1
            long r1 = r11.f30377P
            long r1 = r12 - r1
            long r1 = r1 * r5
            long r1 = r1 / r7
            r11.f30378Q = r1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "addDownloadSpeed localTime speed:"
        L39:
            r14.append(r1)
            long r1 = r11.f30378Q
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.huawei.hms.videokit.player.C6550c1.m37256a(r0, r14)
            goto L5f
        L49:
            long r1 = r11.f30375N
            r7 = 1
            long r1 = r1 + r7
            r11.f30375N = r1
            long r1 = r11.f30377P
            long r1 = r12 - r1
            long r1 = r1 * r5
            r11.f30378Q = r1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "addDownloadSpeed speed:"
            goto L39
        L5f:
            long r0 = r11.f30376O
            long r5 = r11.f30378Q
            long r0 = r0 + r5
            r11.f30376O = r0
            r11.f30377P = r12
            r11.f30379R = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6552d0.m37285a(long, boolean):void");
    }

    /* renamed from: b */
    public void m37293b(boolean z10) {
        m37278s();
        this.f30417p = 0L;
        this.f30423s = 0L;
        this.f30395e = "";
        this.f30413n = "";
        this.f30407k = 0L;
        this.f30405j = 0L;
        this.f30411m = 0L;
        this.f30409l = 0L;
        this.f30415o = 0L;
        this.f30427u = 0L;
        this.f30425t = 0L;
        this.f30397f = "";
        this.f30414n0 = "";
        this.f30399g = "";
        this.f30419q = 0L;
        this.f30421r = 0L;
        this.f30420q0 = 0L;
        this.f30416o0 = 0L;
        this.f30418p0 = 0L;
        this.f30429v = "";
        this.f30430w = -1;
        this.f30401h = 0;
        this.f30403i = 0;
        this.f30393d = 0;
        if (z10) {
            this.f30424s0.set(false);
        }
        this.f30391c = 1;
        m37288a(false, z10);
        this.f30369H = 0L;
        this.f30377P = 0L;
        this.f30371J = "";
        this.f30392c0 = 0L;
        this.f30396e0 = 0L;
        this.f30398f0 = 0L;
        this.f30400g0 = 0;
        m37323q();
        m37321o();
    }

    /* renamed from: a */
    public void m37286a(String str) {
        if (str == null) {
            return;
        }
        this.f30399g = str;
    }

    /* renamed from: a */
    public void m37287a(String str, long j10) {
        this.f30371J = str;
        m37270f(j10, j10);
        List<String> list = this.f30370I;
        if (list != null) {
            if (list.size() >= 10) {
                this.f30370I.remove(0);
            }
            m37279z();
            this.f30370I.add(this.f30371J);
        }
    }

    /* renamed from: a */
    private void m37268a(boolean z10) {
        if (this.f30370I.size() > 0) {
            this.f30370I.clear();
            if (z10) {
                this.f30370I.add(this.f30371J);
            }
        }
    }

    /* renamed from: a */
    public void m37288a(boolean z10, boolean z11) {
        this.f30431x = -1;
        this.f30432y = 0;
        this.f30433z = 0;
        this.f30364C = 0L;
        this.f30365D = 0L;
        this.f30366E = 0L;
        this.f30362A = 0;
        this.f30363B = 0L;
        this.f30367F = 0L;
        this.f30390b0 = "";
        this.f30373L = 0L;
        this.f30374M = 0L;
        this.f30382U = 0;
        this.f30372K = "";
        this.f30394d0 = false;
        m37268a(z10);
        if (z11) {
            this.f30422r0.set(false);
            m37322p();
        }
    }
}
