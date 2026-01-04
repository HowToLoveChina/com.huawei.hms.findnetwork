package p583qm;

import com.huawei.cloud.base.http.AbstractC4622y;
import com.huawei.cloud.base.http.AbstractC4623z;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;
import p022ay.InterfaceC1055e;
import tm.C13040c;

/* renamed from: qm.c */
/* loaded from: classes6.dex */
public class C12375c extends AbstractC4622y {

    /* renamed from: k */
    public static final C4650r f57183k = C4650r.m28485f("RestClientRequest");

    /* renamed from: g */
    public String f57184g;

    /* renamed from: h */
    public C11912b0 f57185h;

    /* renamed from: i */
    public C11918e0.a f57186i;

    /* renamed from: j */
    public InterfaceC11919f f57187j;

    /* renamed from: qm.c$a */
    public class a extends AbstractC11920f0 {

        /* renamed from: a */
        public final /* synthetic */ String f57188a;

        /* renamed from: b */
        public final /* synthetic */ long f57189b;

        public a(String str, long j10) {
            this.f57188a = str;
            this.f57189b = j10;
        }

        @Override // okhttp3.AbstractC11920f0
        public long contentLength() {
            return this.f57189b;
        }

        @Override // okhttp3.AbstractC11920f0
        public C11910a0 contentType() {
            String str = this.f57188a;
            if (str == null) {
                str = "";
            }
            return C11910a0.m71445d(str);
        }

        @Override // okhttp3.AbstractC11920f0
        public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
            OutputStream outputStreamMo6312A0 = interfaceC1055e.mo6312A0();
            try {
                try {
                    C12375c.this.m28344h().mo28157a(outputStreamMo6312A0);
                } catch (Exception e10) {
                    C12375c.f57183k.m28488c("RequestBody write error:" + e10.toString(), false);
                }
            } finally {
                C12375c.m74436u(outputStreamMo6312A0);
            }
        }
    }

    /* renamed from: qm.c$b */
    public class b implements DnsKprUtil.InterfaceC4895e {
        public b() {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public void run(C11918e0.a aVar, InterfaceC11921g interfaceC11921g) {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public C11922g0 run(C11918e0.a aVar, String str) throws IOException {
            C12375c c12375c = C12375c.this;
            c12375c.f57187j = c12375c.f57185h.m71495z(aVar.m71575b());
            return C12375c.this.f57187j.execute();
        }
    }

    public C12375c(C11912b0 c11912b0, String str, String str2) {
        this.f57185h = c11912b0;
        this.f57184g = str;
        C11918e0.a aVar = new C11918e0.a();
        this.f57186i = aVar;
        aVar.m71586m(str2);
    }

    /* renamed from: u */
    public static void m74436u(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                f57183k.m28492j("closeQuietly error:" + e10.toString());
            }
        }
    }

    /* renamed from: w */
    public static void m74437w(String str, boolean z10, boolean z11) {
        if (z10) {
            return;
        }
        if (z11) {
            C13040c.m78609F().m78660m0(str);
        } else {
            C13040c.m78609F().m78658l0(str);
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: a */
    public void mo28242a(String str, String str2) {
        this.f57186i.m71578e(str, str2);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: b */
    public void mo28339b() {
        InterfaceC11919f interfaceC11919f = this.f57187j;
        if (interfaceC11919f != null) {
            interfaceC11919f.cancel();
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: c */
    public AbstractC4623z mo28243c() throws IOException {
        m74438v();
        return m74439x();
    }

    /* renamed from: v */
    public final void m74438v() {
        String strM28341e;
        long jM28340d;
        String str;
        if (m28344h() == null) {
            this.f57186i.m71580g(this.f57184g, null);
        }
        strM28341e = m28341e();
        if (strM28341e != null) {
            mo28242a("Content-Type", strM28341e);
        }
        jM28340d = m28340d();
        if (jM28340d >= 0) {
            this.f57186i.m71578e("Content-Length", Long.toString(jM28340d));
        }
        str = this.f57184g;
        str.hashCode();
        switch (str) {
            case "PUT":
            case "POST":
            case "PATCH":
            case "DELETE":
                this.f57186i.m71580g(this.f57184g, new a(strM28341e, jM28340d));
                break;
            default:
                C4627a0.m28390c(jM28340d == 0, "%s with non-zero content length is not supported", str);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:8:0x0045, B:11:0x004c, B:19:0x0076, B:30:0x008f, B:32:0x0093, B:35:0x0098, B:36:0x0099, B:38:0x00a3, B:40:0x00c8, B:50:0x00de, B:52:0x00e4, B:53:0x00fb, B:54:0x00fc, B:55:0x0116, B:17:0x0062), top: B:64:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fc A[SYNTHETIC] */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.cloud.base.http.AbstractC4623z m74439x() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p583qm.C12375c.m74439x():com.huawei.cloud.base.http.z");
    }
}
