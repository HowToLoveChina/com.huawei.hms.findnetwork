package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C6093t;

/* renamed from: com.huawei.hms.network.embedded.f0 */
/* loaded from: classes8.dex */
public abstract class AbstractRunnableC5912f0 implements Runnable {

    /* renamed from: g */
    public static final String f26717g = "DnRsv";

    /* renamed from: a */
    public final String f26718a;

    /* renamed from: b */
    @C6093t.l
    public final int f26719b;

    /* renamed from: c */
    public C6003m0 f26720c;

    /* renamed from: d */
    public a f26721d;

    /* renamed from: e */
    public AbstractC6081s0 f26722e;

    /* renamed from: f */
    @C6093t.k
    public String f26723f;

    /* renamed from: com.huawei.hms.network.embedded.f0$a */
    public interface a {
        /* renamed from: a */
        void mo34200a(String str, C6003m0 c6003m0);

        /* renamed from: a */
        void mo34201a(String str, Throwable th2);
    }

    /* renamed from: com.huawei.hms.network.embedded.f0$b */
    public static final class b implements a {
        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0.a
        /* renamed from: a */
        public void mo34200a(String str, C6003m0 c6003m0) {
            C5843a0.m33736a(str, c6003m0);
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0.a
        /* renamed from: a */
        public void mo34201a(String str, Throwable th2) {
        }
    }

    public AbstractRunnableC5912f0(String str, @C6093t.l int i10, @C6093t.k String str2) {
        this.f26718a = str;
        this.f26719b = i10;
        this.f26723f = str2;
        this.f26721d = null;
        this.f26722e = C6093t.m35329m().m35353d().mo35247a(this);
    }

    /* renamed from: a */
    public C6003m0 m34197a() {
        return this.f26720c;
    }

    /* renamed from: b */
    public String m34199b() {
        return this.f26723f;
    }

    /* renamed from: c */
    public abstract C6003m0 mo34108c();

    @Override // java.lang.Runnable
    public void run() {
        this.f26722e.m35244a();
        if (TextUtils.isEmpty(this.f26718a)) {
            this.f26722e.m35246a(new Exception("domain == null"));
            return;
        }
        m34198a(mo34108c());
        if (!C6158y.m35829b(this.f26720c)) {
            this.f26722e.m35245a(this.f26720c);
            a aVar = this.f26721d;
            if (aVar != null) {
                aVar.mo34200a(this.f26718a, this.f26720c);
                return;
            }
            return;
        }
        Logger.m32141i(f26717g, C6093t.m35329m().m35333a(this.f26719b) + " query failed, dnsResult is null, domain:" + this.f26718a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("query failed, dnsResult is null, domain:");
        sb2.append(this.f26718a);
        Exception exc = new Exception(sb2.toString());
        this.f26722e.m35246a(exc);
        a aVar2 = this.f26721d;
        if (aVar2 != null) {
            aVar2.mo34201a(this.f26718a, exc);
        }
    }

    public AbstractRunnableC5912f0(String str, @C6093t.l int i10, @C6093t.k String str2, a aVar) {
        this.f26718a = str;
        this.f26719b = i10;
        this.f26723f = str2;
        this.f26722e = C6093t.m35329m().m35353d().mo35247a(this);
        this.f26721d = aVar;
    }

    /* renamed from: a */
    public void m34198a(C6003m0 c6003m0) {
        this.f26720c = c6003m0;
    }
}
