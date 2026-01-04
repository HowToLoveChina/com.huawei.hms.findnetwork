package com.huawei.openalliance.p169ad.download;

import android.content.Context;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.net.http.C7509l;
import com.huawei.openalliance.p169ad.net.http.HttpCallerFactory;
import com.huawei.openalliance.p169ad.net.http.HttpsConfig;
import com.huawei.openalliance.p169ad.net.http.InterfaceC7506i;
import com.huawei.openalliance.p169ad.utils.C7729ac;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.AbstractC11924h0;
import okhttp3.C11912b0;
import okhttp3.C11917e;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11945l;
import okhttp3.EnumC11914c0;

/* renamed from: com.huawei.openalliance.ad.download.j */
/* loaded from: classes2.dex */
public class C7067j extends AbstractC7060c {

    /* renamed from: a */
    private static C11912b0 f32543a;

    /* renamed from: b */
    private static C11912b0 f32544b;

    /* renamed from: c */
    private static InterfaceC7506i f32545c;

    /* renamed from: d */
    private static final byte[] f32546d = new byte[0];

    /* renamed from: e */
    private C11922g0 f32547e;

    /* renamed from: f */
    private C11918e0 f32548f;

    /* renamed from: g */
    private AbstractC11924h0 f32549g;

    /* renamed from: h */
    private Context f32550h;

    public C7067j(Context context, String str, long j10) {
        this.f32550h = context;
        C11918e0.a aVarM71586m = new C11918e0.a().m71586m(str);
        if (j10 > 0) {
            aVarM71586m.m71578e("Range", "bytes=" + j10 + "-");
        }
        aVarM71586m.m71578e(C5966j2.f27080v, "identity");
        aVarM71586m.m71576c(C11917e.f55246n);
        C11918e0 c11918e0M71575b = aVarM71586m.m71575b();
        this.f32548f = c11918e0M71575b;
        if (m42625a(c11918e0M71575b, false)) {
            m42625a(c11918e0M71575b, true);
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: a */
    public InputStream mo42576a() throws IOException {
        AbstractC11924h0 abstractC11924h0 = this.f32549g;
        if (abstractC11924h0 != null) {
            return abstractC11924h0.m71632s();
        }
        throw new IOException("get input stream error");
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: b */
    public int mo42578b() throws IOException {
        C11922g0 c11922g0 = this.f32547e;
        if (c11922g0 != null) {
            return c11922g0.m71597u();
        }
        throw new IOException("get response code error");
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: c */
    public int mo42579c() {
        AbstractC11924h0 abstractC11924h0 = this.f32549g;
        if (abstractC11924h0 == null) {
            return -1;
        }
        return (int) abstractC11924h0.mo71634u();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C11922g0 c11922g0 = this.f32547e;
        if (c11922g0 == null) {
            throw new IOException("close stream error");
        }
        c11922g0.close();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: d */
    public HttpConnection mo42580d() {
        InterfaceC7506i interfaceC7506i = f32545c;
        return interfaceC7506i != null ? interfaceC7506i.mo46052a(this.f32548f) : new HttpConnection();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: a */
    public String mo42577a(String str) {
        C11922g0 c11922g0 = this.f32547e;
        return c11922g0 == null ? "" : c11922g0.m71599w(str);
    }

    /* renamed from: a */
    private static C11912b0 m42624a(Context context, boolean z10) {
        C11912b0 c11912b0;
        synchronized (f32546d) {
            try {
                if (f32543a == null || f32544b == null || f32545c == null) {
                    C11912b0.c cVarM71508e = new C11912b0.c().m71508e(new C11945l(8, 10L, TimeUnit.MINUTES));
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    C11912b0.c cVarM71507d = cVarM71508e.m71519p(10000L, timeUnit).m71507d(10000L, timeUnit);
                    EnumC11914c0 enumC11914c0 = EnumC11914c0.HTTP_2;
                    C11912b0.c cVarM71517n = cVarM71507d.m71517n(Collections.unmodifiableList(Arrays.asList(enumC11914c0, EnumC11914c0.HTTP_1_1)));
                    InterfaceC7506i interfaceC7506iM45962a = HttpCallerFactory.m45962a();
                    f32545c = interfaceC7506iM45962a;
                    interfaceC7506iM45962a.mo46053a(cVarM71517n);
                    HttpsConfig.m45967a(cVarM71517n, false, false);
                    try {
                        cVarM71517n.m71510g(cVarM71517n.m71509f(enumC11914c0));
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43823c("OkHttpNetworkConnection", "create dispatcher error, " + th2.getClass().getSimpleName());
                    }
                    f32543a = cVarM71517n.m71505b();
                    f32544b = cVarM71517n.m71511h(new C7509l(context, true)).m71505b();
                }
                c11912b0 = z10 ? f32544b : f32543a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return c11912b0;
    }

    /* renamed from: a */
    private boolean m42625a(C11918e0 c11918e0, boolean z10) {
        try {
            C11922g0 c11922g0Execute = m42624a(this.f32550h, z10).m71495z(c11918e0).execute();
            this.f32547e = c11922g0Execute;
            z = 8 == C7729ac.m47431a(c11922g0Execute.m71597u());
            this.f32549g = this.f32547e.m71595s();
        } catch (IOException e10) {
            AbstractC7185ho.m43823c("OkHttpNetworkConnection", "http execute encounter IOException:" + e10.getClass().getSimpleName());
            if (C7729ac.m47432a(e10)) {
                return true;
            }
        }
        return z;
    }
}
