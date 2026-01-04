package com.huawei.hms.network.p129ai;

import android.text.TextUtils;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hms.network.inner.api.RequestContext;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.ai.f0 */
/* loaded from: classes8.dex */
public class C5797f0 implements InterfaceC5802i {

    /* renamed from: k */
    public static final String f25843k = "ipsort";

    /* renamed from: l */
    public static final int f25844l = 500;

    /* renamed from: m */
    public static final int f25845m = 1000;

    /* renamed from: a */
    public long f25846a;

    /* renamed from: d */
    public C5799g0 f25849d;

    /* renamed from: b */
    public int f25847b = 20;

    /* renamed from: c */
    public long f25848c = System.currentTimeMillis();

    /* renamed from: h */
    public SecureRandom f25853h = new SecureRandom();

    /* renamed from: i */
    public float f25854i = 0.62f;

    /* renamed from: j */
    public int f25855j = 3;

    /* renamed from: e */
    public Map<String, int[]> f25850e = new ConcurrentHashMap();

    /* renamed from: f */
    public Map<String, AbstractMap.SimpleEntry<String, Integer>> f25851f = new ConcurrentHashMap();

    /* renamed from: g */
    public Map<String, Integer> f25852g = new ConcurrentHashMap();

    /* renamed from: com.huawei.hms.network.ai.f0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5797f0 c5797f0 = C5797f0.this;
            c5797f0.f25850e = (Map) c5797f0.f25849d.mo33245b();
            C5797f0 c5797f02 = C5797f0.this;
            c5797f02.f25851f = c5797f02.f25849d.m33338f();
            C5797f0 c5797f03 = C5797f0.this;
            c5797f03.f25852g = c5797f03.f25849d.m33339g();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.f0$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ RequestContext f25857a;

        public b(RequestContext requestContext) {
            this.f25857a = requestContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5797f0.this.m33325c(this.f25857a);
        }
    }

    /* renamed from: com.huawei.hms.network.ai.f0$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f25859a;

        /* renamed from: b */
        public final /* synthetic */ boolean f25860b;

        /* renamed from: c */
        public final /* synthetic */ List f25861c;

        /* renamed from: d */
        public final /* synthetic */ List f25862d;

        public c(boolean z10, boolean z11, List list, List list2) {
            this.f25859a = z10;
            this.f25860b = z11;
            this.f25861c = list;
            this.f25862d = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            if (this.f25859a || this.f25860b || C5797f0.this.f25850e == null || (list = this.f25861c) == null || list.size() <= 0) {
                return;
            }
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            while (true) {
                if (i10 >= this.f25861c.size()) {
                    break;
                }
                String hostAddress = ((InetAddress) this.f25861c.get(i10)).getHostAddress();
                String hostAddress2 = ((InetAddress) this.f25862d.get(i10)).getHostAddress();
                if (!z10 && hostAddress != null && !hostAddress.equals(hostAddress2)) {
                    z10 = true;
                }
                int i12 = ((int[]) C5797f0.this.f25850e.get(hostAddress))[0] - ((int[]) C5797f0.this.f25850e.get(hostAddress2))[0];
                if (i12 == 0) {
                    if (hostAddress != null && !hostAddress.equals(hostAddress2)) {
                        i11 = i12;
                        break;
                    } else {
                        i10++;
                        i11 = i12;
                    }
                } else {
                    i11 = i12 + (i10 * 1000);
                    break;
                }
            }
            if (z10) {
                HashMap map = new HashMap();
                map.put(C5804j.f25911h, C5788b.f25734d);
                map.put(C5804j.f25916m, C5797f0.this.m33331b(this.f25862d));
                map.put(C5804j.f25917n, String.valueOf(i11));
                C5804j.m33379a(map);
            }
        }
    }

    public C5797f0(C5799g0 c5799g0) {
        this.f25849d = c5799g0;
    }

    /* renamed from: d */
    private void m33326d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f25848c < this.f25846a) {
            return;
        }
        this.f25848c = jCurrentTimeMillis;
        this.f25849d.mo33242a(this.f25850e);
        this.f25849d.m33334a(this.f25851f);
    }

    /* renamed from: e */
    private void m33328e(RequestContext requestContext) {
        String successIp = requestContext.requestFinishedInfo().getMetrics().getSuccessIp();
        if (TextUtils.isEmpty(successIp)) {
            return;
        }
        List<String> connectIps = requestContext.requestFinishedInfo().getMetrics().getConnectIps();
        if (connectIps.isEmpty()) {
            return;
        }
        long connectEndTime = requestContext.requestFinishedInfo().getMetricsTime().getConnectEndTime() - requestContext.requestFinishedInfo().getMetricsTime().getConnectStartTime();
        if (connectIps.get(0).equals(successIp)) {
            m33317a(successIp, connectEndTime);
            return;
        }
        for (String str : connectIps) {
            if (str.equals(successIp) || connectEndTime <= 500) {
                break;
            }
            m33317a(str, connectEndTime);
            connectEndTime -= 500;
        }
        if (connectEndTime > 500) {
            connectEndTime = 500;
        }
        m33317a(successIp, connectEndTime);
    }

    /* renamed from: a */
    public int m33329a(InetAddress inetAddress, InetAddress inetAddress2) {
        if (this.f25850e.containsKey(inetAddress.getHostAddress()) && this.f25850e.containsKey(inetAddress2.getHostAddress())) {
            return this.f25850e.get(inetAddress.getHostAddress())[0] - this.f25850e.get(inetAddress2.getHostAddress())[0] < 0 ? 1 : 0;
        }
        return -1;
    }

    /* renamed from: c */
    public List<InetAddress> m33332c(List<InetAddress> list) {
        List<InetAddress> linkedList = new LinkedList<>();
        List<InetAddress> linkedList2 = new LinkedList<>();
        boolean z10 = false;
        for (InetAddress inetAddress : list) {
            if (!this.f25850e.containsKey(inetAddress.getHostAddress()) || this.f25850e.get(inetAddress.getHostAddress())[1] < this.f25855j) {
                m33318a(inetAddress, linkedList);
                z10 = true;
            } else {
                m33322b(inetAddress, linkedList2);
            }
        }
        linkedList.addAll(linkedList2);
        m33319a(list, linkedList, m33330a(linkedList), z10);
        return linkedList;
    }

    /* renamed from: d */
    private void m33327d(RequestContext requestContext) {
        String host = requestContext.requestFinishedInfo().getHost();
        String successIp = requestContext.requestFinishedInfo().getMetrics().getSuccessIp();
        if (!this.f25851f.containsKey(host)) {
            this.f25851f.put(host, new AbstractMap.SimpleEntry<>(successIp, 1));
            this.f25852g.put(successIp, 1);
        } else {
            int iMin = this.f25851f.get(host).getKey().equals(successIp) ? Math.min(this.f25851f.get(host).getValue().intValue() + 1, Integer.MAX_VALUE) : 1;
            int i10 = (iMin <= this.f25847b || this.f25852g.get(successIp) == null || this.f25852g.get(successIp).intValue() != 1) ? iMin : 1;
            this.f25851f.put(host, new AbstractMap.SimpleEntry<>(successIp, Integer.valueOf(i10)));
            this.f25852g.put(successIp, Integer.valueOf(i10));
        }
    }

    /* renamed from: b */
    public String m33331b(List<InetAddress> list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<InetAddress> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getHostAddress());
            stringBuffer.append(";");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33325c(RequestContext requestContext) {
        if (m33323b(requestContext)) {
            return;
        }
        m33327d(requestContext);
        m33328e(requestContext);
        m33326d();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        this.f25848c = System.currentTimeMillis();
        this.f25846a = PreConnectManager.CONNECT_SUCCESS_INTERNAL;
        this.f25847b = 20;
        C5794e.m33310a().m33312b(new a());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
    }

    /* renamed from: b */
    private void m33322b(InetAddress inetAddress, List<InetAddress> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (this.f25850e.get(inetAddress.getHostAddress())[0] < this.f25850e.get(list.get(i10).getHostAddress())[0]) {
                list.add(i10, inetAddress);
                return;
            }
        }
        list.add(inetAddress);
    }

    /* renamed from: b */
    private boolean m33323b(RequestContext requestContext) {
        long connectEndTime = requestContext.requestFinishedInfo().getMetricsTime().getConnectEndTime() - requestContext.requestFinishedInfo().getMetricsTime().getConnectStartTime();
        return connectEndTime <= 0 || connectEndTime > 2147483647L;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
        if (requestContext.throwable() != null) {
            return;
        }
        C5794e.m33310a().m33311a(new b(requestContext));
    }

    /* renamed from: a */
    private void m33317a(String str, long j10) {
        if (!this.f25850e.containsKey(str)) {
            this.f25850e.put(str, new int[]{(int) j10, 1});
            return;
        }
        this.f25850e.put(str, new int[]{(int) ((this.f25854i * this.f25850e.get(str)[0]) + ((1.0f - this.f25854i) * j10)), this.f25850e.get(str)[1] + 1});
    }

    /* renamed from: a */
    private void m33318a(InetAddress inetAddress, List<InetAddress> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            int i11 = this.f25850e.containsKey(inetAddress.getHostAddress()) ? this.f25850e.get(inetAddress.getHostAddress())[1] : 0;
            if (this.f25850e.containsKey(list.get(i10).getHostAddress()) && i11 < this.f25850e.get(list.get(i10).getHostAddress())[1]) {
                list.add(i10, inetAddress);
                return;
            }
        }
        list.add(inetAddress);
    }

    /* renamed from: a */
    private void m33319a(List<InetAddress> list, List<InetAddress> list2, boolean z10, boolean z11) {
        C5794e.m33310a().m33311a(new c(z10, z11, list, list2));
    }

    /* renamed from: a */
    public boolean m33330a(List<InetAddress> list) {
        String hostAddress = list.get(0).getHostAddress();
        if ((this.f25852g.containsKey(hostAddress) ? this.f25852g.get(hostAddress).intValue() : 0) < this.f25847b) {
            return false;
        }
        if (list.size() > 1) {
            InetAddress inetAddress = list.get(0);
            list.remove(0);
            list.add(inetAddress);
        }
        if (list.size() > 2) {
            int iNextInt = this.f25853h.nextInt(list.size() - 1);
            InetAddress inetAddress2 = list.get(iNextInt);
            list.remove(iNextInt);
            list.add(0, inetAddress2);
        }
        this.f25852g.put(hostAddress, 1);
        return true;
    }
}
