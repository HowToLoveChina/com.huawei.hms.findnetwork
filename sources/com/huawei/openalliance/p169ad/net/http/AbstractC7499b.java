package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7081dy;
import com.huawei.openalliance.p169ad.InterfaceC7382lb;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.net.http.C7503f;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7836o;
import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.net.http.b */
/* loaded from: classes2.dex */
public abstract class AbstractC7499b implements InterfaceC7505h {

    /* renamed from: a */
    protected Context f34826a;

    public AbstractC7499b(Context context) {
        this.f34826a = context;
    }

    /* renamed from: a */
    public long m46043a(C7502e c7502e, C7498a c7498a, int i10, InputStream inputStream, long j10, Response response) {
        if (m46045a(c7498a)) {
            byte[] bArrM48144b = AbstractC7805cy.m48144b(inputStream);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("BaseCaller", "contentLength: %s, rsp fb data: %s", Long.valueOf(j10), new String(bArrM48144b, Constants.UTF_8));
                AbstractC7185ho.m43818a("BaseCaller", "content base64: %s", AbstractC7836o.m48492a(bArrM48144b));
            }
            response.m45983a((Response) C7081dy.m42806a(bArrM48144b));
            response.m45996d(c7498a.f34804l);
            return jCurrentTimeMillis;
        }
        InterfaceC7382lb interfaceC7382lbM45466a = c7498a.f34805m;
        if (interfaceC7382lbM45466a == null) {
            interfaceC7382lbM45466a = InterfaceC7382lb.a.m45466a(c7498a.f34794b);
        }
        response.m45983a((Response) interfaceC7382lbM45466a.mo45460a(i10, inputStream, j10, c7502e.f34834f));
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("BaseCaller", "normal rsp: %s", AbstractC7758be.m47742b(response));
        }
        return interfaceC7382lbM45466a.mo45459a();
    }

    /* renamed from: b */
    public String m46046b(C7498a c7498a) {
        return (c7498a != null && c7498a.f34804l == 2) ? "fb" : "json";
    }

    /* renamed from: c */
    public String m46047c(C7498a c7498a) {
        if (c7498a == null) {
            return null;
        }
        return m46045a(c7498a) ? FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM : c7498a.f34799g;
    }

    /* renamed from: a */
    public String m46044a(C7502e c7502e, C7498a c7498a) {
        return c7498a.m46016a() ? c7498a.m46017b() : new C7503f.a().m46072a(c7502e.f34836h, c7498a.m46018c()).m46073a(c7498a.f34801i).m46074a().m46071c();
    }

    /* renamed from: a */
    public boolean m46045a(C7498a c7498a) {
        if (c7498a == null) {
            return false;
        }
        int i10 = c7498a.f34804l;
        return i10 == 1 || i10 == 2;
    }
}
