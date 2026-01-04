package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.security.SecureRandom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.i1 */
/* loaded from: classes8.dex */
public class C5952i1 {

    /* renamed from: a */
    public static final String f26995a = "TrafficController";

    /* renamed from: b */
    public static final long f26996b = 1000;

    /* renamed from: c */
    public static final double f26997c = 2.0d;

    /* renamed from: d */
    public static final double f26998d = 0.5d;

    public static long enableRetryIntervalBackoff(Request request, int i10) throws InterruptedException {
        int maxRetryWaitingTime;
        if (!(request instanceof C5939h1.d) || (maxRetryWaitingTime = ((C5939h1.d) request).getNetConfig().getMaxRetryWaitingTime()) <= 0) {
            return 0L;
        }
        long waitingInterval = getWaitingInterval(i10, maxRetryWaitingTime);
        waiting(waitingInterval);
        return waitingInterval;
    }

    public static long enableTrafficControlWith429(Request request, Response<ResponseBody> response) throws InterruptedException {
        if (!(request instanceof C5939h1.d)) {
            return 0L;
        }
        long jStringToLong = StringUtils.stringToLong(Headers.m33636of(response.getHeaders()).get(C6055q0.f27799f), 0L);
        long retryAfterTime = ((C5939h1.d) request).getNetConfig().getRetryAfterTime();
        if (retryAfterTime <= 0 || jStringToLong <= 0) {
            return 0L;
        }
        long jMin = Math.min(retryAfterTime, jStringToLong);
        waiting(jMin);
        return jMin;
    }

    public static long getWaitingInterval(int i10, long j10) {
        return Math.min((long) (Math.pow(2.0d, i10) * 1000.0d * ((((new SecureRandom().nextDouble() * (-2.0d)) + 1.0d) * 0.5d) + 1.0d)), j10);
    }

    public static long requestDiscreteControl(Request request) throws InterruptedException {
        if (!(request instanceof C5939h1.d)) {
            return 0L;
        }
        long maxRequestDiscreteTime = ((C5939h1.d) request).getNetConfig().getMaxRequestDiscreteTime();
        if (maxRequestDiscreteTime <= 0) {
            return 0L;
        }
        long jNextDouble = (long) (new SecureRandom().nextDouble() * maxRequestDiscreteTime);
        waiting(jNextDouble);
        return jNextDouble;
    }

    public static void waiting(long j10) throws InterruptedException {
        try {
            Logger.m32143v(f26995a, "is await success: " + new CountDownLatch(1).await(j10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            Logger.m32145w(f26995a, "countDownLatch await interruptedException");
        }
    }
}
