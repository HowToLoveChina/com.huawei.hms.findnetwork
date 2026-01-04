package p553pi;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4596b;
import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.C4595a0;
import com.huawei.cloud.base.http.C4598c;
import com.huawei.cloud.base.http.C4600d;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4603f;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4613p;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.C4621x;
import com.huawei.cloud.base.http.InterfaceC4605h;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4634e;
import com.huawei.cloud.base.util.C4636f;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.InterfaceC4629b0;
import com.huawei.cloud.services.drive.model.ResumeResBody;
import com.huawei.hms.drive.C5282f;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.network.embedded.C5976k;
import gi.C9946a;
import gi.C9947b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import li.C11277a;
import p523oi.C11903a;
import p776xi.AbstractRunnableC13815a;
import p776xi.C13816b;
import p811yi.C13990e;
import vi.C13447b;

/* renamed from: pi.b */
/* loaded from: classes.dex */
public final class C12144b {

    /* renamed from: x */
    public static final C4650r f56303x = C4650r.m28485f("MediaHttpUploader");

    /* renamed from: c */
    public final AbstractC4596b f56306c;

    /* renamed from: d */
    public final C4613p f56307d;

    /* renamed from: e */
    public final AbstractC4619v f56308e;

    /* renamed from: f */
    public InterfaceC4605h f56309f;

    /* renamed from: g */
    public long f56310g;

    /* renamed from: h */
    public boolean f56311h;

    /* renamed from: k */
    public boolean f56314k;

    /* renamed from: m */
    public long f56316m;

    /* renamed from: o */
    public boolean f56318o;

    /* renamed from: p */
    public long f56319p;

    /* renamed from: r */
    public volatile List<String> f56321r;

    /* renamed from: s */
    public volatile C4615r f56322s;

    /* renamed from: t */
    public volatile ResumeResBody f56323t;

    /* renamed from: u */
    public volatile boolean f56324u;

    /* renamed from: v */
    public volatile boolean f56325v;

    /* renamed from: a */
    public c f56304a = c.NOT_STARTED;

    /* renamed from: b */
    public volatile IOException f56305b = null;

    /* renamed from: i */
    public String f56312i = "POST";

    /* renamed from: j */
    public C4609l f56313j = new C4609l();

    /* renamed from: l */
    public String f56315l = "*";

    /* renamed from: n */
    public int f56317n = C5976k.e.f27211b;

    /* renamed from: q */
    public List<AbstractRunnableC13815a> f56320q = new ArrayList();

    /* renamed from: w */
    public ReentrantLock f56326w = new ReentrantLock();

    /* renamed from: pi.b$a */
    public class a implements C4612o.a {
        public a() {
        }

        @Override // com.huawei.cloud.base.http.C4612o.a
        /* renamed from: a */
        public void mo28295a() {
            C12144b.f56303x.m28487b("directUpload onErrorCallback.");
        }

        @Override // com.huawei.cloud.base.http.C4612o.a
        /* renamed from: b */
        public void mo28296b(long j10) {
            try {
                C12144b.this.f56316m = j10;
                C12144b.this.m72843V(c.MEDIA_IN_PROGRESS);
                C12144b.f56303x.m28488c("directUpload onProgress: " + j10, false);
            } catch (IOException e10) {
                C12144b.f56303x.m28492j("directUpload HttpRequest ProgressListener onProgress IOException: " + e10.toString());
            }
        }
    }

    /* renamed from: pi.b$b */
    public class b extends AbstractRunnableC13815a {

        /* renamed from: d */
        public long f56328d;

        /* renamed from: e */
        public long f56329e;

        /* renamed from: f */
        public long f56330f;

        /* renamed from: g */
        public InputStream f56331g;

        /* renamed from: h */
        public C4612o f56332h;

        /* renamed from: i */
        public AbstractC4596b f56333i;

        /* renamed from: j */
        public C4604g f56334j;

        /* renamed from: k */
        public Semaphore f56335k;

        /* renamed from: pi.b$b$a */
        public class a implements C4612o.a {
            public a() {
            }

            @Override // com.huawei.cloud.base.http.C4612o.a
            /* renamed from: a */
            public void mo28295a() throws IOException {
                C12144b.f56303x.m28487b("executeUpload onErrorCallback: + " + b.this.m82854d());
                if (b.this.m82854d()) {
                    throw new InterruptedIOException("upload task is cancel.");
                }
                b.this.m72853j();
            }

            @Override // com.huawei.cloud.base.http.C4612o.a
            /* renamed from: b */
            public void mo28296b(long j10) {
                C12144b.f56303x.m28487b("executeUpload onProgress: + " + b.this.m82854d());
                b.this.m72852i(j10);
            }
        }

        public b(long j10, long j11, InputStream inputStream, C4604g c4604g, Semaphore semaphore) {
            this.f56328d = j10;
            this.f56329e = j11;
            this.f56331g = inputStream;
            this.f56334j = c4604g;
            this.f56335k = semaphore;
        }

        @Override // p776xi.AbstractRunnableC13815a
        /* renamed from: a */
        public void mo72848a() throws NumberFormatException, IOException {
            C4650r c4650r;
            StringBuilder sb2;
            C12144b.f56303x.m28490g("SliceUploadTask start: + " + m82854d());
            m72856m(C12144b.this.f56321r);
            try {
                try {
                    try {
                        m72851h();
                    } catch (Exception e10) {
                        C12144b.f56303x.m28489d("task execute failed, Exception: " + e10.toString());
                        if (C12144b.this.f56305b == null) {
                            C12144b.this.f56305b = new IOException(e10.getMessage());
                        }
                        C12144b.this.f56325v = true;
                        C12144b.this.m72825D();
                        try {
                            this.f56331g.close();
                        } catch (IOException e11) {
                            e = e11;
                            c4650r = C12144b.f56303x;
                            sb2 = new StringBuilder();
                            sb2.append("contentInputStream close failed, IOException: ");
                            sb2.append(e.toString());
                            c4650r.m28489d(sb2.toString());
                            this.f56335k.release();
                        }
                    }
                    try {
                        this.f56331g.close();
                    } catch (IOException e12) {
                        e = e12;
                        c4650r = C12144b.f56303x;
                        sb2 = new StringBuilder();
                        sb2.append("contentInputStream close failed, IOException: ");
                        sb2.append(e.toString());
                        c4650r.m28489d(sb2.toString());
                        this.f56335k.release();
                    }
                } catch (IOException e13) {
                    C12144b.f56303x.m28489d("task execute failed, IOException: " + e13.toString());
                    if (C12144b.this.f56305b == null) {
                        C12144b.this.f56305b = e13;
                    }
                    C12144b.this.f56325v = true;
                    C12144b.this.m72825D();
                    try {
                        this.f56331g.close();
                    } catch (IOException e14) {
                        e = e14;
                        c4650r = C12144b.f56303x;
                        sb2 = new StringBuilder();
                        sb2.append("contentInputStream close failed, IOException: ");
                        sb2.append(e.toString());
                        c4650r.m28489d(sb2.toString());
                        this.f56335k.release();
                    }
                }
                this.f56335k.release();
            } catch (Throwable th2) {
                try {
                    this.f56331g.close();
                } catch (IOException e15) {
                    C12144b.f56303x.m28489d("contentInputStream close failed, IOException: " + e15.toString());
                }
                this.f56335k.release();
                throw th2;
            }
        }

        @Override // p776xi.AbstractRunnableC13815a
        /* renamed from: c */
        public boolean mo72849c() {
            C4612o c4612o = this.f56332h;
            if (c4612o != null) {
                c4612o.m28269a();
            }
            this.f56335k.release();
            return super.mo72849c();
        }

        /* renamed from: g */
        public final void m72850g(long j10) throws IOException {
            long j11 = this.f56328d;
            if (j10 < j11) {
                long j12 = this.f56330f - (j11 - j10);
                if (j12 >= 0) {
                    C12144b.f56303x.m28492j("retransmissionSize: " + j12);
                } else {
                    C12144b.this.f56326w.lock();
                    C12144b.m72799c(C12144b.this, 0 - j12);
                    C12144b.this.f56326w.unlock();
                }
                this.f56331g.skip(this.f56328d - j10);
            }
        }

        /* renamed from: h */
        public final void m72851h() throws Throwable {
            this.f56331g.skip(this.f56328d);
            ResumeResBody resumeResBody = null;
            while (!Thread.currentThread().isInterrupted()) {
                C12144b.f56303x.m28490g("executeUpload executeUpload: + " + m82854d());
                if (m82854d()) {
                    throw new InterruptedIOException("upload task is cancel.");
                }
                this.f56330f = 0L;
                if (this.f56329e < this.f56328d) {
                    return;
                }
                C4612o c4612oM28299c = C12144b.this.f56307d.m28299c(this.f56334j, null);
                this.f56332h = c4612oM28299c;
                c4612oM28299c.m28277i().putAll(C12144b.this.f56313j);
                m72855l();
                new C12145c(this, this.f56332h);
                C4615r c4615rM72829H = C12144b.this.m72829H(this.f56332h, new a());
                boolean z10 = false;
                try {
                } catch (Throwable th2) {
                    th = th2;
                }
                if (c4615rM72829H.m28315l()) {
                    C12144b c12144b = C12144b.this;
                    c12144b.f56316m = c12144b.m72832K();
                    C12144b.this.f56324u = true;
                    C12144b.this.f56322s = c4615rM72829H;
                    this.f56335k.release(C12144b.this.f56320q.size());
                    C12144b.this.m72843V(c.MEDIA_COMPLETE);
                    if (C12144b.this.f56324u || C12144b.this.f56325v) {
                        return;
                    }
                    C12144b.this.f56322s = c4615rM72829H;
                    C12144b.this.f56323t = resumeResBody;
                    return;
                }
                if (c4615rM72829H.m28311h() != 308) {
                    C12144b.this.f56325v = true;
                    C12144b.this.f56322s = c4615rM72829H;
                    try {
                        C12144b.this.m72825D();
                        if (C12144b.this.f56324u || C12144b.this.f56325v) {
                            return;
                        }
                        C12144b.this.f56322s = c4615rM72829H;
                        C12144b.this.f56323t = resumeResBody;
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = true;
                    }
                } else {
                    String strM28239x = c4615rM72829H.m28308e().m28239x();
                    if (strM28239x != null) {
                        this.f56334j = new C4604g(strM28239x);
                    }
                    ResumeResBody resumeResBody2 = (ResumeResBody) c4615rM72829H.m28316m(ResumeResBody.class);
                    try {
                        C12144b.this.f56321r = resumeResBody2.getRangeList();
                        long jM72856m = m72856m(C12144b.this.f56321r);
                        this.f56331g.reset();
                        m72850g(jM72856m);
                        if (C12144b.this.f56316m != C12144b.this.f56310g && C12144b.this.f56316m != 0 && !C12144b.this.f56324u && !C12144b.this.f56325v) {
                            C12144b.this.m72843V(c.MEDIA_IN_PROGRESS);
                        }
                        c4615rM72829H.m28304a();
                        if (!C12144b.this.f56324u && !C12144b.this.f56325v) {
                            C12144b.this.f56322s = c4615rM72829H;
                            C12144b.this.f56323t = resumeResBody2;
                        }
                        resumeResBody = resumeResBody2;
                    } catch (Throwable th4) {
                        th = th4;
                        resumeResBody = resumeResBody2;
                    }
                }
                if (!z10) {
                    c4615rM72829H.m28304a();
                }
                if (!C12144b.this.f56324u && !C12144b.this.f56325v) {
                    C12144b.this.f56322s = c4615rM72829H;
                    C12144b.this.f56323t = resumeResBody;
                }
                throw th;
            }
        }

        /* renamed from: i */
        public final void m72852i(long j10) {
            C12144b.f56303x.m28488c("executeCurrentRequestWithoutGZip onProgress: " + j10, false);
            C12144b.this.f56326w.lock();
            C12144b.m72799c(C12144b.this, j10 - this.f56330f);
            C12144b.this.f56326w.unlock();
            this.f56330f = j10;
            try {
                if (C12144b.this.f56325v) {
                    return;
                }
                C12144b.this.m72843V(c.MEDIA_IN_PROGRESS);
            } catch (IOException e10) {
                C12144b.f56303x.m28489d("updateStateAndNotifyListener ex: " + e10.toString());
            }
        }

        /* renamed from: j */
        public void m72853j() throws IOException {
            C4627a0.m28392e(this.f56332h, "The current request should not be null");
            AbstractC4596b abstractC4596b = this.f56333i;
            if (abstractC4596b != null) {
                abstractC4596b.mo28163c().reset();
            }
        }

        /* renamed from: k */
        public final void m72854k(AbstractC4596b abstractC4596b, int i10) throws IOException {
            this.f56333i = abstractC4596b;
            abstractC4596b.mo28163c().mark(i10);
            this.f56332h.m28292x(abstractC4596b);
            this.f56332h.m28277i().m28220L("bytes " + this.f56328d + "-" + this.f56329e + "/" + C12144b.this.f56315l);
        }

        /* renamed from: l */
        public final void m72855l() throws IOException {
            int i10 = (int) ((this.f56329e - this.f56328d) + 1);
            this.f56331g.mark(i10);
            long j10 = i10;
            m72854k(new C4621x(C12144b.this.f56306c.getType(), C4634e.m28407b(this.f56331g, j10)).m28337h(true).m28336g(j10).m28335f(false), i10);
        }

        /* renamed from: m */
        public final long m72856m(List<String> list) throws NumberFormatException {
            if (list == null) {
                list = new ArrayList<>();
            }
            long j10 = this.f56328d;
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String[] strArrSplit = it.next().split("-");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    long j11 = Long.parseLong(strArrSplit[0]);
                    long j12 = Long.parseLong(strArrSplit[1]);
                    long j13 = this.f56328d;
                    if (j13 >= j11 && j13 <= j12) {
                        long j14 = this.f56329e;
                        if (j14 <= j12) {
                            this.f56329e = j13 - 1;
                            this.f56328d = j14 + 1;
                        } else {
                            this.f56328d = j12 + 1;
                        }
                    }
                }
            }
            return j10;
        }
    }

    /* renamed from: pi.b$c */
    public enum c {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public C12144b(AbstractC4596b abstractC4596b, AbstractC4619v abstractC4619v, InterfaceC4614q interfaceC4614q) {
        this.f56306c = (AbstractC4596b) C4627a0.m28391d(abstractC4596b);
        this.f56308e = (AbstractC4619v) C4627a0.m28391d(abstractC4619v);
        this.f56307d = interfaceC4614q == null ? abstractC4619v.createRequestFactory() : abstractC4619v.createRequestFactory(interfaceC4614q);
    }

    /* renamed from: c */
    public static /* synthetic */ long m72799c(C12144b c12144b, long j10) {
        long j11 = c12144b.f56316m + j10;
        c12144b.f56316m = j11;
        return j11;
    }

    /* renamed from: A */
    public final void m72822A() throws NumberFormatException {
        if (this.f56321r == null) {
            this.f56316m = 0L;
            return;
        }
        Iterator<String> it = this.f56321r.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split("-");
            if (strArrSplit != null && strArrSplit.length == 2) {
                this.f56316m += (Long.parseLong(strArrSplit[1]) - Long.parseLong(strArrSplit[0])) + 1;
            }
        }
    }

    /* renamed from: B */
    public final int m72823B(long j10, long j11) {
        if (j11 > j10) {
            j11 = (long) Math.floor(j10 / 4);
        }
        if (j11 < 2097152) {
            j11 = 2097152;
        }
        return (int) j11;
    }

    /* renamed from: C */
    public final String m72824C(String str, InterfaceC4605h interfaceC4605h, C4602e c4602e) throws Throwable {
        Object objM84025e;
        try {
            String strM84024d = C13990e.m84024d(c4602e.m28187f());
            if (interfaceC4605h != null) {
                m72846z((C11277a) interfaceC4605h, strM84024d);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                interfaceC4605h.mo28157a(byteArrayOutputStream);
                objM84025e = C13990e.m84025e(byteArrayOutputStream.toByteArray());
            } else {
                objM84025e = null;
            }
            Object objM84025e2 = str != null ? C13990e.m84025e(str.getBytes(C4636f.f21271a)) : null;
            StringBuilder sb2 = new StringBuilder();
            if (objM84025e2 == null) {
                objM84025e2 = 0;
            }
            sb2.append(objM84025e2);
            sb2.append("_");
            if (objM84025e == null) {
                objM84025e = 0;
            }
            sb2.append(objM84025e);
            sb2.append("_");
            sb2.append(strM84024d);
            return sb2.toString();
        } catch (C13447b e10) {
            f56303x.m28492j("calcLocalID IOException: " + e10.toString());
            return null;
        }
    }

    /* renamed from: D */
    public final synchronized void m72825D() {
        try {
            Iterator<AbstractRunnableC13815a> it = this.f56320q.iterator();
            while (it.hasNext()) {
                it.next().mo72849c();
            }
            this.f56320q.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: E */
    public final void m72826E(String str) {
        try {
            C5282f.m31719b("UploadID", str);
        } catch (IOException e10) {
            f56303x.m28492j("saveGenericUrlToLocal IOException: " + e10.toString());
        }
    }

    /* renamed from: F */
    public final C4615r m72827F(C4604g c4604g) throws Throwable {
        m72843V(c.MEDIA_IN_PROGRESS);
        InterfaceC4605h interfaceC4605hM28160i = this.f56306c;
        if (this.f56309f != null) {
            interfaceC4605hM28160i = new C4595a0().m28160i(Arrays.asList(this.f56309f, this.f56306c));
            c4604g.put("uploadType", "multipart");
            AbstractC4596b abstractC4596b = this.f56306c;
            if (abstractC4596b instanceof C4602e) {
                try {
                    String strM84024d = C13990e.m84024d(((C4602e) abstractC4596b).m28187f());
                    InterfaceC4605h interfaceC4605h = this.f56309f;
                    if (interfaceC4605h != null) {
                        m72846z((C11277a) interfaceC4605h, strM84024d);
                    }
                } catch (Exception e10) {
                    f56303x.m28492j("directUpload addCheckHashToMetadata IOException: " + e10.toString());
                }
            }
        } else {
            c4604g.put("uploadType", "content");
        }
        C4612o c4612oM28300d = this.f56307d.m28300d(this.f56312i, c4604g, interfaceC4605hM28160i);
        c4612oM28300d.m28277i().putAll(this.f56313j);
        C4615r c4615rM72828G = m72828G(c4612oM28300d, new a());
        try {
            if (m72835N()) {
                this.f56316m = m72832K();
            }
            m72843V(c.MEDIA_COMPLETE);
            return c4615rM72828G;
        } catch (Throwable th2) {
            c4615rM72828G.m28304a();
            throw th2;
        }
    }

    /* renamed from: G */
    public final C4615r m72828G(C4612o c4612o, C4612o.a aVar) throws IOException {
        if (!this.f56318o && !(c4612o.m28274f() instanceof C4600d)) {
            c4612o.m28293y(new C4603f());
        }
        return m72829H(c4612o, aVar);
    }

    /* renamed from: H */
    public final C4615r m72829H(C4612o c4612o, C4612o.a aVar) throws IOException {
        new C9947b().mo28207c(c4612o);
        c4612o.m28266G(false);
        c4612o.m28262C(C11903a.m71435l().m69829b());
        c4612o.m28263D(aVar);
        return c4612o.m28272d();
    }

    /* renamed from: I */
    public final C4615r m72830I(C4604g c4604g) throws IOException {
        m72843V(c.INITIATION_STARTED);
        c4604g.put("uploadType", "resume");
        InterfaceC4605h c4600d = this.f56309f;
        if (c4600d == null) {
            c4600d = new C4600d();
        }
        C4612o c4612oM28300d = this.f56307d.m28300d(this.f56312i, c4604g, c4600d);
        this.f56313j.set("X-Upload-Content-Type", this.f56306c.getType());
        if (m72835N()) {
            this.f56313j.set("X-Upload-Content-Length", Long.valueOf(m72832K()));
        }
        c4612oM28300d.m28277i().putAll(this.f56313j);
        C4615r c4615rM72828G = m72828G(c4612oM28300d, null);
        try {
            m72843V(c.INITIATION_COMPLETE);
            return c4615rM72828G;
        } catch (Throwable th2) {
            c4615rM72828G.m28304a();
            throw th2;
        }
    }

    /* renamed from: J */
    public final C4604g m72831J(String str) {
        try {
            C12146d c12146d = (C12146d) C5282f.m31714a("UploadID", str);
            if (c12146d == null) {
                return null;
            }
            if (!c12146d.isExpired()) {
                return new C4604g(c12146d.m72859c());
            }
            C5282f.m31719b("UploadID", str);
            return null;
        } catch (IOException e10) {
            f56303x.m28492j("getGenericUrlFromLocal IOException: " + e10.toString());
            return null;
        }
    }

    /* renamed from: K */
    public final long m72832K() throws IOException {
        if (!this.f56311h) {
            this.f56310g = this.f56306c.getLength();
            this.f56311h = true;
        }
        return this.f56310g;
    }

    /* renamed from: L */
    public double m72833L() throws IOException {
        C4627a0.m28389b(m72835N(), "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead.");
        if (m72832K() == 0) {
            return 0.0d;
        }
        return Math.min(this.f56316m, m72832K()) / m72832K();
    }

    /* renamed from: M */
    public final void m72834M() throws IOException {
        ResumeResBody resumeResBody = (ResumeResBody) this.f56322s.m28316m(ResumeResBody.class);
        this.f56323t = resumeResBody;
        this.f56321r = resumeResBody.getRangeList();
        if (resumeResBody.getSliceSize() != null) {
            this.f56317n = m72823B(m72832K(), r0.intValue());
        }
        f56303x.m28487b("use chunkSize: " + this.f56317n);
    }

    /* renamed from: N */
    public final boolean m72835N() throws IOException {
        return m72832K() >= 0;
    }

    /* renamed from: O */
    public final C4615r m72836O(C4604g c4604g) throws Throwable {
        String strM72824C;
        C4604g c4604gM72831J;
        boolean z10;
        int i10 = 0;
        if (this.f56306c instanceof C4602e) {
            strM72824C = m72824C(c4604g.toString(), this.f56309f, (C4602e) this.f56306c);
            c4604gM72831J = m72831J(strM72824C);
            z10 = true;
        } else {
            strM72824C = "";
            c4604gM72831J = null;
            z10 = false;
        }
        if (c4604gM72831J == null) {
            C4615r c4615rM72830I = m72830I(c4604g);
            if (!c4615rM72830I.m28315l()) {
                return c4615rM72830I;
            }
            try {
                String strM28239x = c4615rM72830I.m28308e().m28239x();
                C4604g c4604g2 = new C4604g(strM28239x);
                if (z10) {
                    m72837P(strM72824C, strM28239x);
                }
                c4615rM72830I.m28304a();
                c4604gM72831J = c4604g2;
            } catch (Throwable th2) {
                c4615rM72830I.m28304a();
                throw th2;
            }
        }
        long jM72832K = m72832K();
        this.f56315l = String.valueOf(jM72832K);
        C4612o c4612oM28299c = this.f56307d.m28299c(c4604gM72831J, null);
        c4612oM28299c.m28277i().putAll(this.f56313j);
        c4612oM28299c.m28292x(new C4598c(InterfaceC5483d.f25084j, new byte[0]));
        c4612oM28299c.m28277i().m28220L("bytes */" + this.f56315l);
        this.f56322s = m72829H(c4612oM28299c, null);
        m72834M();
        m72822A();
        m72843V(c.MEDIA_IN_PROGRESS);
        m72842U(c4604gM72831J, jM72832K);
        while (this.f56322s.m28311h() == 308) {
            int i11 = i10 + 1;
            if (i10 >= 10) {
                break;
            }
            f56303x.m28487b("wait server retryTime: " + i11);
            Integer processTime = this.f56323t.getProcessTime();
            if (processTime == null) {
                processTime = 1000;
            }
            try {
                InterfaceC4629b0.f21264a.mo28401a(processTime.intValue());
                m72845X(c4604gM72831J);
                i10 = i11;
            } catch (InterruptedException e10) {
                f56303x.m28489d("sleep interrupted, ex: " + e10.toString());
                throw new InterruptedIOException(e10.toString());
            }
        }
        if (!C12145c.m72857c(this.f56322s) && this.f56322s.m28311h() != 308) {
            m72826E(strM72824C);
        }
        if (this.f56322s.m28311h() == 200) {
            this.f56316m = m72832K();
            m72826E(strM72824C);
            m72843V(c.MEDIA_COMPLETE);
        }
        return this.f56322s;
    }

    /* renamed from: P */
    public final void m72837P(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            C12146d c12146d = new C12146d();
            c12146d.m72861e(str);
            c12146d.m72863g(str2);
            c12146d.m72862f(System.currentTimeMillis());
            C5282f.m31715a("UploadID", str, c12146d);
        } catch (IOException e10) {
            f56303x.m28492j("saveGenericUrlToLocal IOException: " + e10.toString());
        }
    }

    /* renamed from: Q */
    public C12144b m72838Q(boolean z10) {
        this.f56318o = z10;
        return this;
    }

    /* renamed from: R */
    public C12144b m72839R(C4609l c4609l) {
        this.f56313j = c4609l;
        return this;
    }

    /* renamed from: S */
    public C12144b m72840S(String str) {
        C4627a0.m28388a(str.equals("POST") || str.equals("PUT") || str.equals(RequestMethod.PATCH));
        this.f56312i = str;
        return this;
    }

    /* renamed from: T */
    public C12144b m72841T(InterfaceC4605h interfaceC4605h) {
        this.f56309f = interfaceC4605h;
        return this;
    }

    /* renamed from: U */
    public final void m72842U(C4604g c4604g, long j10) throws InterruptedException, IOException {
        this.f56305b = null;
        int i10 = this.f56317n;
        int i11 = j10 % ((long) i10) == 0 ? (int) (j10 / i10) : ((int) (j10 / i10)) + 1;
        Semaphore semaphore = new Semaphore((i11 * (-1)) + 1);
        for (long j11 = 0; j11 < i11; j11++) {
            int i12 = this.f56317n;
            long j12 = j11 * i12;
            long j13 = ((i12 * j11) + i12) - 1;
            long j14 = j10 - 1;
            if (j13 > j14) {
                j13 = j14;
            }
            InputStream inputStreamMo28163c = this.f56306c.mo28163c();
            b bVar = new b(j12, j13, (inputStreamMo28163c.markSupported() || !m72835N()) ? inputStreamMo28163c : new BufferedInputStream(inputStreamMo28163c), c4604g, semaphore);
            this.f56320q.add(bVar);
            C13816b.m82856c().m82857a(bVar);
        }
        try {
            semaphore.acquire();
            if (this.f56305b != null) {
                throw this.f56305b;
            }
            f56303x.m28487b("semaphore end");
        } catch (InterruptedException e10) {
            f56303x.m28489d("semaphore wait failed: " + e10.toString());
            m72825D();
            throw new InterruptedIOException(e10.toString());
        }
    }

    /* renamed from: V */
    public final void m72843V(c cVar) throws IOException {
        f56303x.m28487b("updateStateAndNotifyListener: " + this.f56316m + " uploadState: " + cVar.name() + " progress " + m72833L());
        this.f56304a = cVar;
    }

    /* renamed from: W */
    public C4615r m72844W(C4604g c4604g) throws IOException {
        C4615r c4615rM72836O;
        StringBuilder sb2;
        C4627a0.m28388a(this.f56304a == c.NOT_STARTED);
        new C9946a(this.f56307d.m28301e()).m61629a(c4604g);
        C4650r c4650r = f56303x;
        c4650r.m28487b("begin upload");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f56314k) {
                c4615rM72836O = m72827F(c4604g);
                this.f56319p = System.currentTimeMillis() - jCurrentTimeMillis;
                sb2 = new StringBuilder();
            } else {
                c4615rM72836O = m72836O(c4604g);
                this.f56319p = System.currentTimeMillis() - jCurrentTimeMillis;
                sb2 = new StringBuilder();
            }
            sb2.append("end upload, totalTimeRequired:");
            sb2.append(this.f56319p);
            c4650r.m28487b(sb2.toString());
            return c4615rM72836O;
        } catch (Throwable th2) {
            this.f56319p = System.currentTimeMillis() - jCurrentTimeMillis;
            f56303x.m28487b("end upload, totalTimeRequired:" + this.f56319p);
            throw th2;
        }
    }

    /* renamed from: X */
    public final void m72845X(C4604g c4604g) throws IOException {
        C4612o c4612oM28299c = this.f56307d.m28299c(c4604g, null);
        c4612oM28299c.m28277i().putAll(this.f56313j);
        c4612oM28299c.m28292x(new C4598c(InterfaceC5483d.f25084j, new byte[0]));
        c4612oM28299c.m28277i().m28220L("bytes */" + this.f56315l);
        this.f56322s = m72829H(c4612oM28299c, null);
        if (this.f56322s.m28311h() == 308) {
            this.f56323t = (ResumeResBody) this.f56322s.m28316m(ResumeResBody.class);
        }
    }

    /* renamed from: z */
    public final void m72846z(C11277a c11277a, String str) {
        ((C4646n) c11277a.m67681g()).set("sha256", str);
    }
}
