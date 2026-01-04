package p265ep;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import com.huawei.hms.support.api.safetydetect.SafetyDetect;
import com.huawei.hms.support.api.safetydetect.SafetyDetectClient;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p399jk.AbstractC10896a;

/* renamed from: ep.a */
/* loaded from: classes.dex */
public class C9530a {

    /* renamed from: a */
    public static SafetyDetectClient f47368a = null;

    /* renamed from: b */
    public static String f47369b = "";

    /* renamed from: ep.a$a */
    public static class a implements InterfaceC8937e<Void> {

        /* renamed from: a */
        public final CountDownLatch f47370a;

        public a(CountDownLatch countDownLatch) {
            this.f47370a = countDownLatch;
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<Void> task) {
            AbstractC10896a.m65887i("SafetyDetectManager", "intiAntiFraud onComplete");
            this.f47370a.countDown();
        }
    }

    /* renamed from: ep.a$b */
    public static class b implements InterfaceC8938f {

        /* renamed from: a */
        public final Map<String, String> f47371a;

        /* renamed from: b */
        public final boolean[] f47372b;

        /* renamed from: c */
        public final CountDownLatch f47373c;

        public b(Map<String, String> map, boolean[] zArr, CountDownLatch countDownLatch) {
            this.f47371a = map;
            this.f47372b = zArr;
            this.f47373c = countDownLatch;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            this.f47371a.put("getRiskTokenResult", "fail");
            if (exc instanceof ApiException) {
                ApiException apiException = (ApiException) exc;
                if (apiException.getStatusCode() == 19830) {
                    this.f47372b[0] = false;
                } else {
                    this.f47372b[0] = true;
                }
                this.f47371a.put("failCode", String.valueOf(apiException.getStatusCode()));
                this.f47371a.put("failReason", apiException.getMessage());
            } else {
                this.f47372b[0] = true;
                this.f47371a.put("failCode", String.valueOf(-1));
                this.f47371a.put("failReason", exc.getMessage());
            }
            AbstractC10896a.m65887i("SafetyDetectManager", "getRiskToken error " + exc.getMessage() + ", isGetTokenDone = " + this.f47372b[0]);
            this.f47373c.countDown();
        }
    }

    /* renamed from: ep.a$c */
    public static class c implements InterfaceC8939g<RiskTokenResponse> {

        /* renamed from: a */
        public final boolean[] f47374a;

        /* renamed from: b */
        public final Map<String, String> f47375b;

        /* renamed from: c */
        public final CountDownLatch f47376c;

        public c(boolean[] zArr, Map<String, String> map, CountDownLatch countDownLatch) {
            this.f47374a = zArr;
            this.f47375b = map;
            this.f47376c = countDownLatch;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(RiskTokenResponse riskTokenResponse) {
            AbstractC10896a.m65887i("SafetyDetectManager", "getRiskToken success, isGetTokenDone = true");
            String unused = C9530a.f47369b = riskTokenResponse.getRiskToken();
            this.f47374a[0] = true;
            this.f47375b.put("getRiskTokenResult", "success");
            this.f47376c.countDown();
        }
    }

    /* renamed from: ep.a$d */
    public static class d {

        /* renamed from: a */
        public static C9530a f47377a = new C9530a();
    }

    /* renamed from: b */
    public static C9530a m59524b() {
        return d.f47377a;
    }

    /* renamed from: g */
    public static void m59525g() {
        SafetyDetectClient safetyDetectClient = f47368a;
        if (safetyDetectClient != null) {
            safetyDetectClient.releaseAntiFraud();
            f47368a = null;
        }
    }

    /* renamed from: c */
    public final boolean m59526c(Map<String, String> map) {
        if (f47368a == null) {
            AbstractC10896a.m65888w("SafetyDetectManager", "getRiskToken client is null, return");
            return true;
        }
        AbstractC10896a.m65887i("SafetyDetectManager", "getRiskToken begin");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = new boolean[1];
        f47368a.getRiskToken().addOnSuccessListener(new c(zArr, map, countDownLatch)).addOnFailureListener(new b(map, zArr, countDownLatch));
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65885d("SafetyDetectManager", "wait not finish");
            }
        } catch (InterruptedException unused) {
            AbstractC10896a.m65888w("SafetyDetectManager", "syncLock wait catch InterruptedException.");
        }
        return zArr[0];
    }

    /* renamed from: d */
    public synchronized String m59527d(Map<String, String> map) {
        m59529f();
        m59528e(map);
        m59525g();
        return f47369b;
    }

    /* renamed from: e */
    public final void m59528e(Map<String, String> map) {
        for (int i10 = 0; i10 < 2; i10++) {
            map.put("getRiskTokenTimes", String.valueOf(i10));
            if (m59526c(map)) {
                return;
            }
        }
    }

    /* renamed from: f */
    public final void m59529f() {
        if (f47368a != null) {
            AbstractC10896a.m65887i("SafetyDetectManager", "intiAntiFraud has been init");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        f47368a = SafetyDetect.getClient(C0213f.m1377a());
        f47368a.initAntiFraud("10055832").addOnCompleteListener(new a(countDownLatch));
        try {
            if (countDownLatch.await(5L, TimeUnit.SECONDS)) {
                return;
            }
            AbstractC10896a.m65885d("SafetyDetectManager", "wait not finish");
        } catch (InterruptedException unused) {
            AbstractC10896a.m65888w("SafetyDetectManager", "syncLock wait catch InterruptedException.");
        }
    }
}
