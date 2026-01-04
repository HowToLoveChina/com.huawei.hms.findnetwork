package p553pi;

import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4613p;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4634e;
import com.huawei.cloud.base.util.C4650r;
import gi.C9946a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p523oi.C11903a;

/* renamed from: pi.a */
/* loaded from: classes.dex */
public final class C12143a {

    /* renamed from: j */
    public static final C4650r f56289j = C4650r.m28485f("MediaHttpDownloader");

    /* renamed from: a */
    public final C4613p f56290a;

    /* renamed from: b */
    public final AbstractC4619v f56291b;

    /* renamed from: e */
    public long f56294e;

    /* renamed from: g */
    public long f56296g;

    /* renamed from: i */
    public long f56298i;

    /* renamed from: c */
    public boolean f56292c = false;

    /* renamed from: d */
    public int f56293d = 33554432;

    /* renamed from: f */
    public a f56295f = a.NOT_STARTED;

    /* renamed from: h */
    public long f56297h = -1;

    /* renamed from: pi.a$a */
    public enum a {
        NOT_STARTED,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public C12143a(AbstractC4619v abstractC4619v, InterfaceC4614q interfaceC4614q) {
        this.f56291b = (AbstractC4619v) C4627a0.m28391d(abstractC4619v);
        this.f56290a = interfaceC4614q == null ? abstractC4619v.createRequestFactory() : abstractC4619v.createRequestFactory(interfaceC4614q);
    }

    /* renamed from: a */
    public void m72791a(C4604g c4604g, C4609l c4609l, OutputStream outputStream) throws IOException {
        C4627a0.m28388a(this.f56295f == a.NOT_STARTED);
        if (c4609l == null) {
            c4609l = new C4609l();
        }
        c4604g.put("form", "content");
        new C9946a(this.f56290a.m28301e()).m61629a(c4604g);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m72792b(c4604g, c4609l, outputStream);
        } finally {
            this.f56298i = System.currentTimeMillis() - jCurrentTimeMillis;
        }
    }

    /* renamed from: b */
    public final void m72792b(C4604g c4604g, C4609l c4609l, OutputStream outputStream) throws IOException {
        if (this.f56292c) {
            m72796f(a.MEDIA_IN_PROGRESS);
            long jLongValue = m72793c(this.f56297h, c4604g, c4609l, outputStream).m28308e().m28234s().longValue();
            this.f56294e = jLongValue;
            this.f56296g = jLongValue;
            m72796f(a.MEDIA_COMPLETE);
            return;
        }
        while (true) {
            long j10 = (this.f56296g + this.f56293d) - 1;
            long j11 = this.f56297h;
            String strM28235t = m72793c(j11 != -1 ? Math.min(j11, j10) : -1L, c4604g, c4609l, outputStream).m28308e().m28235t();
            long jM72794d = m72794d(strM28235t);
            m72795e(strM28235t);
            long j12 = this.f56294e;
            if (jM72794d >= j12) {
                this.f56296g = j12;
                m72796f(a.MEDIA_COMPLETE);
                return;
            }
            long j13 = this.f56297h;
            if (jM72794d >= j13) {
                this.f56296g = j13;
                m72796f(a.MEDIA_COMPLETE);
                return;
            } else {
                this.f56296g = jM72794d;
                m72796f(a.MEDIA_IN_PROGRESS);
            }
        }
    }

    /* renamed from: c */
    public final C4615r m72793c(long j10, C4604g c4604g, C4609l c4609l, OutputStream outputStream) throws Throwable {
        C4612o c4612oM28297a = this.f56290a.m28297a(c4604g);
        c4612oM28297a.m28262C(C11903a.m71435l().m69829b());
        if (c4609l != null) {
            c4612oM28297a.m28277i().putAll(c4609l);
        }
        if (this.f56296g != 0 || j10 != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bytes=");
            sb2.append(this.f56296g);
            sb2.append("-");
            if (j10 != -1) {
                sb2.append(j10);
            }
            c4612oM28297a.m28277i().m28227S(sb2.toString());
        }
        C4615r c4615rM28272d = c4612oM28297a.m28272d();
        InputStream inputStreamM28306c = c4615rM28272d.m28306c();
        try {
            c4615rM28272d.m28308e().m28219K(Long.valueOf(C4634e.m28406a(inputStreamM28306c, outputStream)));
            return c4615rM28272d;
        } finally {
            inputStreamM28306c.close();
            c4615rM28272d.m28304a();
        }
    }

    /* renamed from: d */
    public final long m72794d(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1, str.indexOf(47))) + 1;
    }

    /* renamed from: e */
    public final void m72795e(String str) {
        if (str != null && this.f56294e == 0) {
            this.f56294e = Long.parseLong(str.substring(str.indexOf(47) + 1));
        }
    }

    /* renamed from: f */
    public final void m72796f(a aVar) throws IOException {
        this.f56295f = aVar;
    }
}
