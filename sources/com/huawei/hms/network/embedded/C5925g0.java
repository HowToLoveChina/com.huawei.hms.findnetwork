package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.AbstractRunnableC5912f0;
import com.huawei.hms.network.embedded.C6093t;
import com.huawei.hms.network.inner.DomainManager;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.network.embedded.g0 */
/* loaded from: classes8.dex */
public class C5925g0 {

    /* renamed from: a */
    public static final String f26787a = "DNResolverManager";

    /* renamed from: b */
    public static Set<String> f26788b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c */
    public static final C6068r0 f26789c = C6068r0.m35165a();

    /* renamed from: com.huawei.hms.network.embedded.g0$a */
    public static class a implements AbstractRunnableC5912f0.a {
        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0.a
        /* renamed from: a */
        public void mo34200a(String str, C6003m0 c6003m0) {
            Logger.m32143v(C5925g0.f26787a, "lazyUpdateCallback onRespone : " + c6003m0);
            C5843a0.m33736a(str, c6003m0);
            C5925g0.f26788b.remove(str);
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0.a
        /* renamed from: a */
        public void mo34201a(String str, Throwable th2) {
            Logger.m32143v(C5925g0.f26787a, "lazyUpdateCallback onFailure");
            C5925g0.f26788b.remove(str);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g0$b */
    public static class b extends AbstractRunnableC5912f0 {
        public b(String str, int i10, String str2) {
            super(str, i10, str2);
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0
        /* renamed from: c */
        public C6003m0 mo34108c() {
            C6003m0 c6003m0M35169b = C5925g0.f26789c.m35169b(this.f26718a);
            C5925g0.f26788b.remove(this.f26718a);
            return c6003m0M35169b;
        }
    }

    /* renamed from: a */
    public static C6003m0 m34275a(AbstractRunnableC5912f0 abstractRunnableC5912f0) {
        abstractRunnableC5912f0.run();
        return abstractRunnableC5912f0.m34197a();
    }

    /* renamed from: a */
    public static C6003m0 m34276a(String str, @C6093t.l int i10) throws UnknownHostException {
        C6003m0 c6003m0M35166a = i10 != 1 ? f26789c.m35166a(str) : InterfaceC5938h0.f26898c.lookup(str);
        Logger.m32141i(f26787a, str + " from server result is: " + c6003m0M35166a);
        return c6003m0M35166a;
    }

    /* renamed from: a */
    public static void m34278a(String str, @C6093t.k String str2, @C6093t.l int i10) {
        if (DomainManager.getInstance().isExcludePrefetch(str)) {
            Logger.m32143v(f26787a, "exclude dnsLazyUpdate");
        } else {
            if (TextUtils.isEmpty(str) || f26788b.contains(str)) {
                return;
            }
            f26788b.add(str);
            Logger.m32142i(f26787a, "enter Dns lazy update flow, domain: %s, trigger type: %s, source: %s", str, str2, C6093t.m35329m().m35333a(i10));
            f26789c.m35168a(i10 == 3 ? new b(str, i10, str2) : new C5977k0(str, str2, new a()));
        }
    }
}
