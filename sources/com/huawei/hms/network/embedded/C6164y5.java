package com.huawei.hms.network.embedded;

import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.networkkit.embedded.C6262R;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.network.embedded.y5 */
/* loaded from: classes8.dex */
public class C6164y5 extends AbstractC6125v5 {

    /* renamed from: g */
    public static final String f29133g = "PingDetectQuery";

    /* renamed from: h */
    public static final int f29134h = 6000;

    /* renamed from: e */
    public int f29135e = 3;

    /* renamed from: f */
    public int f29136f = 30;

    /* renamed from: com.huawei.hms.network.embedded.y5$a */
    public class a implements Callable<C5849a6> {

        /* renamed from: a */
        public final /* synthetic */ String f29137a;

        public a(String str) {
            this.f29137a = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C5849a6 call() {
            return new C6177z5().m35908a(this.f29137a, C6164y5.this.f29135e, C6164y5.this.f29136f, new StringBuffer());
        }
    }

    public C6164y5(ExecutorService executorService) {
        this.f28644b = executorService;
    }

    /* renamed from: a */
    private boolean m35833a(String str) {
        return str.equals(ContextHolder.getResourceContext().getString(C6262R.string.spec_ip_0)) || str.equals(ContextHolder.getResourceContext().getString(C6262R.string.spec_ip_1)) || str.equals(ContextHolder.getResourceContext().getString(C6262R.string.spec_ip_2));
    }

    /* renamed from: b */
    private long m35835b(String str) {
        return (long) (Float.parseFloat(str.replace("ms", "").trim()) + 0.5f);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6125v5
    /* renamed from: b */
    public C6138w5 mo35507b(AbstractC5956i5 abstractC5956i5) {
        C5849a6 c5849a6;
        int i10;
        abstractC5956i5.mo34380b(0);
        if (NetworkUtil.getCurrentNetworkType() != 1) {
            return this.f28643a;
        }
        String wifiGatewayIp = NetworkUtil.getWifiGatewayIp(ContextHolder.getResourceContext());
        if (!CheckParamUtils.isIpV4(wifiGatewayIp) && !CheckParamUtils.isIpV6(wifiGatewayIp)) {
            i10 = C5863b6.d.f26437d;
        } else {
            if (!m35833a(wifiGatewayIp)) {
                Future futureSubmit = this.f28644b.submit(new a(wifiGatewayIp));
                try {
                    try {
                        c5849a6 = (C5849a6) futureSubmit.get(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                        abstractC5956i5.m34375a(C5863b6.d.f26434a);
                        c5849a6 = null;
                    }
                    if (c5849a6 == null || !c5849a6.m33811h()) {
                        Logger.m32143v(f29133g, "the ping is failed,and exit detect this time");
                        abstractC5956i5.m34375a(C5863b6.d.f26434a);
                    } else {
                        abstractC5956i5.m34375a(204);
                        if (c5849a6.m33808e() != null) {
                            if (m35835b(c5849a6.m33808e()) > this.f29136f) {
                                abstractC5956i5.m34375a(C5863b6.d.f26439f);
                            } else {
                                this.f28643a.m35724b(true);
                            }
                        }
                    }
                    return this.f28643a;
                } finally {
                    futureSubmit.cancel(true);
                }
            }
            i10 = C5863b6.d.f26438e;
        }
        abstractC5956i5.m34375a(i10);
        return this.f28643a;
    }
}
