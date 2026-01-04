package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p130a.C6191g;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Submit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.network.file.core.task.k */
/* loaded from: classes8.dex */
public abstract class AbstractC6240k<R extends Request> implements InterfaceC6234e<R> {

    /* renamed from: a */
    private R f29465a;

    /* renamed from: b */
    private long f29466b;

    /* renamed from: c */
    private volatile String f29467c;

    /* renamed from: d */
    volatile ITaskResult f29468d;

    /* renamed from: e */
    private volatile int f29469e;

    /* renamed from: f */
    private String f29470f;

    /* renamed from: g */
    private String f29471g;

    /* renamed from: h */
    private String f29472h;

    /* renamed from: i */
    private String f29473i;

    /* renamed from: j */
    private int f29474j;

    /* renamed from: k */
    private RequestFinishedInfo f29475k;

    /* renamed from: l */
    volatile boolean f29476l;

    /* renamed from: m */
    volatile boolean f29477m;

    /* renamed from: n */
    volatile Submit f29478n;

    /* renamed from: o */
    private int f29479o;

    /* renamed from: p */
    private boolean f29480p;

    /* renamed from: q */
    protected long f29481q;

    /* renamed from: r */
    protected volatile long f29482r;

    /* renamed from: s */
    volatile boolean f29483s;

    /* renamed from: t */
    protected int f29484t;

    /* renamed from: u */
    private Future<?> f29485u;

    public AbstractC6240k(R r10, long j10) {
        this(r10, j10, Utils.getLongId());
    }

    /* renamed from: a */
    public static AbstractC6240k m36317a(List<? extends AbstractC6240k> list) {
        if (Utils.isEmpty(list)) {
            return null;
        }
        for (AbstractC6240k abstractC6240k : list) {
            if (abstractC6240k != null && abstractC6240k.m36348w()) {
                return abstractC6240k;
            }
        }
        return list.get(0);
    }

    /* renamed from: b */
    public static List<AbstractC6240k> m36319b(List<AbstractC6240k> list) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AbstractC6240k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mo36030x());
        }
        return arrayList;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: c */
    public long mo36239c() {
        return this.f29482r;
    }

    /* renamed from: d */
    public void m36333d(String str) {
        this.f29471g = str;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: e */
    public Future<?> mo36240e() {
        return this.f29485u;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: f */
    public long mo36241f() {
        return this.f29466b;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: g */
    public Submit mo36242g() {
        return this.f29478n;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: h */
    public boolean mo36243h() {
        return this.f29483s;
    }

    /* renamed from: i */
    public String m36335i() {
        if (!this.f29476l) {
            m36325a(this.f29475k);
        }
        return this.f29473i;
    }

    /* renamed from: j */
    public int m36336j() {
        return this.f29469e;
    }

    /* renamed from: k */
    public int m36337k() {
        return this.f29479o;
    }

    /* renamed from: l */
    public int m36338l() {
        if (!this.f29476l) {
            m36325a(this.f29475k);
        }
        return this.f29474j;
    }

    /* renamed from: m */
    public abstract C6191g mo36029m();

    /* renamed from: n */
    public String m36339n() {
        if (!this.f29476l) {
            m36325a(this.f29475k);
        }
        return this.f29472h;
    }

    /* renamed from: o */
    public String m36340o() {
        if (!this.f29476l) {
            m36325a(this.f29475k);
        }
        return this.f29471g;
    }

    /* renamed from: p */
    public R m36341p() {
        return this.f29465a;
    }

    /* renamed from: q */
    public long m36342q() {
        return this.f29481q;
    }

    /* renamed from: r */
    public RequestFinishedInfo m36343r() {
        return this.f29475k;
    }

    /* renamed from: s */
    public String m36344s() {
        if (!this.f29476l) {
            m36325a(this.f29475k);
        }
        return this.f29470f;
    }

    /* renamed from: t */
    public int m36345t() {
        return this.f29484t;
    }

    public String toString() {
        return "Task{id = '" + this.f29466b + "', totalSize = " + mo36022a() + ", finishedSize = " + this.f29482r + ", isCanceled = " + this.f29483s + '}';
    }

    /* renamed from: u */
    public ITaskResult m36346u() {
        return this.f29468d;
    }

    /* renamed from: v */
    public String m36347v() {
        return this.f29467c;
    }

    /* renamed from: w */
    public boolean m36348w() {
        return this.f29480p;
    }

    /* renamed from: x */
    public abstract AbstractC6240k mo36030x();

    public AbstractC6240k(R r10, long j10, long j11) {
        this.f29470f = "unknown";
        this.f29471g = "unknown";
        this.f29472h = "unknown";
        this.f29473i = "unknown";
        this.f29476l = false;
        this.f29477m = false;
        this.f29480p = false;
        this.f29483s = false;
        this.f29484t = 1;
        this.f29485u = null;
        this.f29465a = r10;
        this.f29466b = j11;
        this.f29482r = j10;
    }

    /* renamed from: d */
    public static boolean m36320d(int i10) {
        return i10 > InterfaceC6234e.a.PAUSE.ordinal();
    }

    /* renamed from: a */
    public void m36321a(int i10) {
        this.f29469e = i10;
    }

    /* renamed from: b */
    public void m36327b(int i10) {
        this.f29479o = i10;
    }

    /* renamed from: c */
    public void m36330c(int i10) {
        this.f29474j = i10;
    }

    /* renamed from: e */
    public void m36334e(String str) {
        this.f29470f = str;
    }

    /* renamed from: a */
    public void m36322a(long j10) {
        this.f29482r = j10;
    }

    /* renamed from: b */
    public void m36328b(RequestFinishedInfo requestFinishedInfo) {
        this.f29475k = requestFinishedInfo;
    }

    /* renamed from: c */
    public void m36331c(String str) {
        this.f29472h = str;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public void mo36233a(R r10) {
        this.f29465a = r10;
    }

    /* renamed from: b */
    public void m36329b(String str) {
        this.f29473i = str;
    }

    /* renamed from: c */
    public void m36332c(boolean z10) {
        this.f29480p = z10;
    }

    /* renamed from: a */
    public void m36323a(ITaskResult iTaskResult) {
        this.f29468d = iTaskResult;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: b */
    public void mo36237b(boolean z10) {
        this.f29483s = z10;
    }

    /* renamed from: a */
    public void m36324a(RequestFinishedInfo.MetricsTime metricsTime) {
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: b */
    public boolean mo36238b() {
        return this.f29477m;
    }

    /* renamed from: a */
    public void m36325a(RequestFinishedInfo requestFinishedInfo) {
        FLogger.m36354v("Task", "CheckoutFromRequestFinishedInfo");
        if (requestFinishedInfo == null) {
            FLogger.m36355w("Task", "checkoutFromRequestFinishedInfo, but requestFinishedInfo is null", new Object[0]);
            return;
        }
        m36333d(requestFinishedInfo.getNetworkSdkType());
        RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
        if (metrics != null) {
            m36334e(metrics.getSuccessIp());
            m36331c(metrics.getProtocol());
            m36329b(metrics.getCongestionControlType());
            m36330c(metrics.getMultipathAlgorithm());
        }
        m36324a(requestFinishedInfo.getMetricsTime());
        this.f29476l = true;
    }

    /* renamed from: a */
    public void m36326a(Submit submit) {
        this.f29478n = submit;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public void mo36234a(String str) {
        this.f29467c = str;
    }

    /* renamed from: a */
    public static void m36318a(List<? extends AbstractC6240k> list, RequestFinishedInfo requestFinishedInfo) {
        FLogger.m36354v("Task", "checkRequestFinishedInfo");
        AbstractC6240k abstractC6240kM36317a = m36317a(list);
        if (abstractC6240kM36317a.m36343r() == null) {
            FLogger.m36355w("Task", "requestFinishedInfo is null", new Object[0]);
            abstractC6240kM36317a.m36328b(requestFinishedInfo);
        }
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public void mo36235a(Future<?> future) {
        this.f29485u = future;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public void mo36236a(boolean z10) {
        this.f29477m = z10;
    }
}
