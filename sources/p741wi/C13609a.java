package p741wi;

import android.content.Context;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4622y;
import com.huawei.cloud.base.http.AbstractC4623z;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hms.drive.AbstractC5202bg;
import com.huawei.hms.drive.AbstractC5287i;
import com.huawei.hms.drive.C5197bb;
import com.huawei.hms.drive.C5198bc;
import com.huawei.hms.drive.C5201bf;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.C5210bo;
import com.huawei.hms.drive.InterfaceC5177aj;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import p022ay.InterfaceC1055e;
import p811yi.C13988c;
import p811yi.C13989d;
import vi.C13446a;

/* renamed from: wi.a */
/* loaded from: classes.dex */
public final class C13609a extends AbstractC4622y {

    /* renamed from: l */
    public static final C4650r f61215l = C4650r.m28485f("OkHttpRequest");

    /* renamed from: g */
    public C5198bc f61216g;

    /* renamed from: h */
    public C5201bf.a f61217h;

    /* renamed from: i */
    public String f61218i;

    /* renamed from: j */
    public Context f61219j;

    /* renamed from: k */
    public InterfaceC5177aj f61220k;

    /* renamed from: wi.a$a */
    public class a extends AbstractC5202bg {

        /* renamed from: e */
        public final /* synthetic */ String f61221e;

        /* renamed from: f */
        public final /* synthetic */ long f61222f;

        public a(String str, long j10) {
            this.f61221e = str;
            this.f61222f = j10;
        }

        @Override // com.huawei.hms.drive.AbstractC5202bg
        public long contentLength() {
            return this.f61222f;
        }

        @Override // com.huawei.hms.drive.AbstractC5202bg
        public C5197bb contentType() {
            String str = this.f61221e;
            if (str == null) {
                str = "";
            }
            return C5197bb.m31037b(str);
        }

        @Override // com.huawei.hms.drive.AbstractC5202bg
        public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
            C13609a.this.m81824s(interfaceC1055e);
        }
    }

    /* renamed from: wi.a$b */
    public class b implements C13988c.d {
        public b() {
        }

        @Override // p811yi.C13988c.d
        /* renamed from: a */
        public C5203bh mo81825a(C5201bf.a aVar) throws IOException {
            C13609a c13609a = C13609a.this;
            c13609a.f61220k = c13609a.f61216g.m31044a(aVar.m31123a());
            return C13609a.this.f61220k.mo30836a();
        }
    }

    /* renamed from: wi.a$c */
    public class c extends AbstractC5287i {

        /* renamed from: b */
        public long f61225b;

        /* renamed from: c */
        public long f61226c;

        /* renamed from: d */
        public C4612o.a f61227d;

        public c(OutputStream outputStream, C4612o.a aVar) {
            super(outputStream);
            this.f61225b = 0L;
            this.f61226c = 0L;
            this.f61227d = aVar;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            delegate().write(i10);
            long j10 = this.f61226c + 1;
            this.f61226c = j10;
            if (j10 > 5242880) {
                long j11 = this.f61225b + j10;
                this.f61225b = j11;
                this.f61226c = 0L;
                this.f61227d.mo28296b(j11);
            }
        }
    }

    public C13609a(Context context, C5198bc c5198bc, String str, String str2) {
        this.f61219j = context;
        this.f61216g = c5198bc;
        this.f61218i = str;
        C5201bf.a aVar = new C5201bf.a();
        this.f61217h = aVar;
        aVar.m31120a(str2);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: a */
    public void mo28242a(String str, String str2) {
        this.f61217h.m31125b(str, str2);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: b */
    public void mo28339b() {
        InterfaceC5177aj interfaceC5177aj = this.f61220k;
        if (interfaceC5177aj != null) {
            interfaceC5177aj.mo30837b();
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: c */
    public AbstractC4623z mo28243c() throws IOException {
        if (m28344h() != null) {
            String strM28341e = m28341e();
            if (strM28341e != null) {
                mo28242a("Content-Type", strM28341e);
            }
            long jM28340d = m28340d();
            if (jM28340d >= 0) {
                this.f61217h.m31122a("Content-Length", Long.toString(jM28340d));
            }
            String str = this.f61218i;
            if ("POST".equals(str) || "PUT".equals(str) || RequestMethod.PATCH.equals(str)) {
                this.f61217h.m31121a(this.f61218i, new a(strM28341e, jM28340d));
            } else {
                C4627a0.m28390c(jM28340d == 0, "%s with non-zero content length is not supported", str);
            }
        } else {
            this.f61217h.m31121a(this.f61218i, (AbstractC5202bg) null);
        }
        return m81823p();
    }

    @Override // com.huawei.cloud.base.http.AbstractC4622y
    /* renamed from: o */
    public void mo28351o(int i10, int i11) {
    }

    /* renamed from: p */
    public final AbstractC4623z m81823p() throws IOException {
        int i10;
        boolean z10;
        String strM30970f = this.f61217h.m31123a().m31107a().m30970f();
        String string = this.f61217h.m31123a().m31107a().toString();
        C4612o.a aVarM28343g = m28343g();
        IOException iOException = null;
        C5203bh c5203bhMo30836a = null;
        int i11 = 3;
        String strM84006a = "";
        while (true) {
            boolean z11 = false;
            try {
                try {
                    if (C13988c.m84013h(strM30970f, strM84006a, 3 - i11)) {
                        z10 = true;
                        try {
                            C13989d.m84020c(this.f61219j, strM30970f, m28342f());
                            c5203bhMo30836a = C13988c.m84015j(string, strM30970f, strM84006a, iOException, this.f61217h, new b());
                        } catch (IOException e10) {
                            iOException = e10;
                            z11 = z10;
                            String str = strM30970f + iOException.toString();
                            C4650r c4650r = f61215l;
                            c4650r.m28489d("OkHttpRequest:[" + i11 + "]" + str);
                            if ((iOException instanceof InterruptedIOException) && !(iOException instanceof SocketTimeoutException)) {
                                throw iOException;
                            }
                            strM84006a = C13988c.m84006a(iOException);
                            if ((iOException instanceof NoRouteToHostException) || (iOException instanceof UnknownHostException)) {
                                i11--;
                            }
                            i10 = i11 - 1;
                            if (i11 <= 0) {
                                if (!z11 || C13988c.m84012g()) {
                                    throw iOException;
                                }
                                c4650r.m28489d("OkHttpRequest:the request is dns, throw exceptions to the upper layer.");
                                throw new C13446a(iOException.getMessage());
                            }
                            if (aVarM28343g != null) {
                                try {
                                    aVarM28343g.mo28295a();
                                } catch (IOException e11) {
                                    throw e11;
                                }
                            }
                            if (c5203bhMo30836a != null) {
                                c5203bhMo30836a.close();
                            }
                            i11 = i10;
                        }
                    } else {
                        InterfaceC5177aj interfaceC5177ajM31044a = this.f61216g.m31044a(this.f61217h.m31123a());
                        this.f61220k = interfaceC5177ajM31044a;
                        c5203bhMo30836a = interfaceC5177ajM31044a.mo30836a();
                        C13989d.m84018a();
                        z10 = false;
                    }
                    f61215l.m28488c("OkHttpRequest:sendRequest response.", false);
                    return new C13610b(c5203bhMo30836a);
                } catch (Throwable th2) {
                    if (c5203bhMo30836a != null) {
                        c5203bhMo30836a.close();
                    }
                    throw th2;
                }
            } catch (IOException e12) {
                iOException = e12;
            }
            i11 = i10;
        }
    }

    /* renamed from: s */
    public final void m81824s(InterfaceC1055e interfaceC1055e) throws IOException {
        OutputStream outputStreamMo6312A0 = interfaceC1055e.mo6312A0();
        try {
            try {
                C4612o.a aVarM28343g = m28343g();
                if (aVarM28343g == null) {
                    m28344h().mo28157a(outputStreamMo6312A0);
                } else {
                    m28344h().mo28157a(new c(outputStreamMo6312A0, aVarM28343g));
                }
                C5210bo.m31191a(outputStreamMo6312A0);
            } catch (Exception e10) {
                f61215l.m28488c("RequestBody write error:" + e10.toString(), false);
                C4612o.a aVarM28343g2 = m28343g();
                if (aVarM28343g2 != null) {
                    aVarM28343g2.mo28295a();
                }
                throw e10;
            }
        } catch (Throwable th2) {
            C5210bo.m31191a(outputStreamMo6312A0);
            throw th2;
        }
    }
}
