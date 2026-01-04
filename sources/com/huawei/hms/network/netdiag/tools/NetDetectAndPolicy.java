package com.huawei.hms.network.netdiag.tools;

import android.net.NetworkInfo;
import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.LimitQueue;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.SettingUtil;
import com.huawei.hms.network.embedded.AbstractC6125v5;
import com.huawei.hms.network.embedded.AbstractC6176z4;
import com.huawei.hms.network.embedded.C5848a5;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.network.embedded.C5969j5;
import com.huawei.hms.network.embedded.C5982k5;
import com.huawei.hms.network.embedded.C5995l5;
import com.huawei.hms.network.embedded.C6085s4;
import com.huawei.hms.network.embedded.C6098t4;
import com.huawei.hms.network.embedded.C6111u4;
import com.huawei.hms.network.embedded.C6112u5;
import com.huawei.hms.network.embedded.C6164y5;
import com.huawei.hms.network.embedded.InterfaceC6163y4;
import com.huawei.hms.network.netdiag.cache.SignalInfoCache;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class NetDetectAndPolicy {

    /* renamed from: l */
    public static final String f29547l = "Netdiag";

    /* renamed from: i */
    public C5995l5 f29556i;

    /* renamed from: d */
    public int f29551d = 2;

    /* renamed from: e */
    public int f29552e = 3;

    /* renamed from: f */
    public int f29553f = -1;

    /* renamed from: g */
    public long f29554g = 0;

    /* renamed from: h */
    public boolean f29555h = true;

    /* renamed from: j */
    public int f29557j = 0;

    /* renamed from: k */
    public CountDownLatch f29558k = null;

    /* renamed from: a */
    public ExecutorService f29548a = ExecutorsUtils.newSingleThreadExecutor("netdiag");

    /* renamed from: b */
    public ExecutorService f29549b = ExecutorsUtils.newSingleThreadExecutor("netdiag_execute_task");

    /* renamed from: c */
    public LimitQueue<Boolean> f29550c = new LimitQueue<>(Math.max(this.f29551d, this.f29552e) + 1, false);

    /* renamed from: com.huawei.hms.network.netdiag.tools.NetDetectAndPolicy$a */
    public class RunnableC6261a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Object f29559a;

        public RunnableC6261a(Object obj) {
            this.f29559a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetDetectAndPolicy.this.m36387a((NetDetectAndPolicy) this.f29559a);
        }
    }

    public NetDetectAndPolicy(C5995l5 c5995l5) {
        this.f29556i = c5995l5;
    }

    /* renamed from: a */
    private void m36386a(int i10, ExecutorService executorService) {
        AbstractC6125v5 abstractC6125v5M35558a;
        Logger.m32143v(f29547l, "the time detect model is : " + i10);
        if (i10 == 0) {
            Logger.m32143v(f29547l, "this time will do nothing!");
            return;
        }
        this.f29558k = new CountDownLatch(1);
        C6112u5 c6112u5 = new C6112u5(executorService);
        c6112u5.m35559a(new C5969j5(this.f29556i));
        if (i10 == 2) {
            abstractC6125v5M35558a = c6112u5.m35558a();
        } else {
            if (i10 != 3) {
                Logger.m32141i(f29547l, "the policy model has error! and the model = " + i10);
                this.f29558k.countDown();
            }
            C6164y5 c6164y5 = new C6164y5(executorService);
            c6164y5.m35559a(new C5982k5(this.f29556i));
            abstractC6125v5M35558a = c6164y5.m35558a().m35560a(c6112u5);
        }
        this.f29555h = abstractC6125v5M35558a.f28643a.m35722a();
        this.f29558k.countDown();
    }

    /* renamed from: b */
    private void m36390b(long j10) {
        Logger.m32144v(f29547l, "the time the date is : nowTime = %s, lastDetectTime = %s", Long.valueOf(j10), Long.valueOf(this.f29554g));
        if (m36388a() || j10 - this.f29554g > C5863b6.g.f26453g || m36393c()) {
            Logger.m32141i(f29547l, "the time count will reset!");
            m36397f();
        }
    }

    /* renamed from: c */
    private int m36392c(long j10) {
        Logger.m32143v(f29547l, "this time the initiativing ...");
        if (!this.f29555h) {
            Logger.m32143v(f29547l, "the appid is error! pls check it");
            return 0;
        }
        long j11 = this.f29554g;
        if (j10 - j11 > 300000) {
            this.f29557j = 0;
        }
        int i10 = this.f29557j;
        if (i10 >= 3 || j10 - j11 <= 60000) {
            return 0;
        }
        this.f29554g = j10;
        this.f29557j = i10 + 1;
        return 2;
    }

    /* renamed from: d */
    private int m36394d(long j10) {
        String str;
        int i10;
        m36390b(j10);
        if (!this.f29555h) {
            str = "the appId is available";
        } else if (m36391b() || m36389a(j10)) {
            str = "inhibition this time and return it";
        } else {
            if (m36395d()) {
                if (NetworkUtil.getCurrentNetworkType() == 1) {
                    Logger.m32143v(f29547l, "the http will detected ping and http");
                    i10 = 3;
                } else {
                    i10 = 2;
                }
                this.f29554g = j10;
                this.f29553f++;
                Logger.m32144v(f29547l, "the time the date is : lastDetectTime = %s, detectCount = %s，selectDetectMode = %d", Long.valueOf(j10), Integer.valueOf(this.f29553f), Integer.valueOf(i10));
                return i10;
            }
            str = "the detect shouldn't be detected";
        }
        Logger.m32143v(f29547l, str);
        return 0;
    }

    /* renamed from: e */
    private boolean m36396e() {
        List<InterfaceC6163y4> listMo35553a = C6085s4.getInstance().getPeekLastInfo().mo35553a(1);
        return (listMo35553a == null || listMo35553a.isEmpty() || listMo35553a.get(listMo35553a.size() - 1).mo35778c() != 204) ? false : true;
    }

    /* renamed from: f */
    private void m36397f() {
        this.f29554g = 0L;
        this.f29553f = -1;
    }

    public static int obtainNetworkChanged(long j10, long j11) {
        int iObtainNetworkQuality = C6098t4.getInstance().obtainNetworkQuality(j10, j11);
        return iObtainNetworkQuality == 0 ? SignalInfoCache.getInstance().obtainNetworkQuality(j10, j11) : iObtainNetworkQuality;
    }

    public <T> Future<?> executeDetectPolicy(T t10) {
        String str;
        try {
            return this.f29548a.submit(new RunnableC6261a(t10));
        } catch (RejectedExecutionException e10) {
            e = e10;
            str = "the taskExecutor has error! and reject";
            Logger.m32146w(f29547l, str, e);
            return null;
        } catch (Exception e11) {
            e = e11;
            str = "the taskExecutor has error! and other exception";
            Logger.m32146w(f29547l, str, e);
            return null;
        }
    }

    public AbstractC6176z4 netDetDiagInfo(long j10, long j11) throws InterruptedException {
        Logger.m32143v(f29547l, "obtain the info time:" + j10 + "/" + j11);
        C5848a5 c5848a5 = new C5848a5();
        c5848a5.m33783a(C6111u4.getInstance().getPeekLastInfo());
        c5848a5.m33788b(SignalInfoCache.getInstance().getPeekLastInfo());
        c5848a5.m33785a(SignalInfoCache.getInstance().getLastInfo());
        c5848a5.m33782a(C6098t4.getInstance().getPeekLastInfo());
        if (ContextHolder.getResourceContext() != null) {
            c5848a5.m33781a(SettingUtil.getSecureInt(ContextHolder.getResourceContext().getContentResolver(), "adb_enabled", 0));
        }
        c5848a5.m33787b(obtainNetworkChanged(j10, j11));
        try {
            CountDownLatch countDownLatch = this.f29558k;
            if (countDownLatch != null) {
                Logger.m32141i(f29547l, "the netdiag has collected;and the timeout = " + countDownLatch.await(10L, TimeUnit.SECONDS));
            }
            c5848a5.m33784a(C6085s4.getInstance().getPeekLastInfo());
        } catch (InterruptedException unused) {
            Logger.m32145w(f29547l, "the wait has timeout! and exit it!");
        }
        return c5848a5;
    }

    public boolean networkUnavailable(long j10, long j11) {
        int currentNetworkType = NetworkUtil.getCurrentNetworkType();
        int iObtainNetworkChanged = obtainNetworkChanged(j10, j11);
        Logger.m32142i(f29547l, "current_network_change : %d ,current_network_type: %d", Integer.valueOf(iObtainNetworkChanged), Integer.valueOf(currentNetworkType));
        return iObtainNetworkChanged != 0 || currentNetworkType == -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> void m36387a(T t10) {
        int iM36392c;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (t10 instanceof Boolean) {
            this.f29550c.add((Boolean) t10);
            iM36392c = m36394d(jElapsedRealtime);
        } else {
            iM36392c = m36392c(jElapsedRealtime);
        }
        m36386a(iM36392c, this.f29549b);
    }

    /* renamed from: b */
    private boolean m36391b() {
        NetworkInfo.DetailedState detailedStateNetworkStatus = NetworkUtil.networkStatus(ContextHolder.getResourceContext());
        int currentNetworkType = NetworkUtil.getCurrentNetworkType();
        return detailedStateNetworkStatus != NetworkInfo.DetailedState.CONNECTED || currentNetworkType == 2 || currentNetworkType == 3;
    }

    /* renamed from: c */
    private boolean m36393c() {
        int size;
        if (this.f29550c.isEmpty() || (size = this.f29550c.size()) < this.f29552e + 1) {
            return false;
        }
        for (int i10 = size - 1; i10 >= size - this.f29552e; i10--) {
            if (!this.f29550c.get(i10).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m36395d() {
        String str;
        int size = this.f29550c.size();
        if (size == 1) {
            return false;
        }
        int i10 = size - 1;
        if (this.f29550c.get(size - 2) != this.f29550c.get(i10)) {
            str = "last two requests is different";
        } else {
            if (size < this.f29551d) {
                Logger.m32143v(f29547l, "request times is not enough");
                return false;
            }
            while (i10 >= size - this.f29551d) {
                if (this.f29550c.get(i10).booleanValue()) {
                    return false;
                }
                i10--;
            }
            str = "meet bad threshold";
        }
        Logger.m32143v(f29547l, str);
        return true;
    }

    public boolean executeDetectPolicy() throws ExecutionException, InterruptedException {
        String str;
        try {
            Future<?> futureExecuteDetectPolicy = executeDetectPolicy("default");
            if (futureExecuteDetectPolicy != null) {
                futureExecuteDetectPolicy.get();
            }
            return m36396e();
        } catch (InterruptedException e10) {
            e = e10;
            str = "the InterruptedException has occur";
            Logger.m32146w(f29547l, str, e);
            return false;
        } catch (ExecutionException e11) {
            e = e11;
            str = "the executionException has occur";
            Logger.m32146w(f29547l, str, e);
            return false;
        } catch (Exception e12) {
            e = e12;
            str = "the other Exception has occur";
            Logger.m32146w(f29547l, str, e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m36388a() {
        return C6098t4.getInstance().getPeekLastInfo().mo33859b() > this.f29554g;
    }

    /* renamed from: a */
    private boolean m36389a(long j10) {
        return j10 - this.f29554g < (((long) this.f29553f) * 600000) + 300000;
    }
}
