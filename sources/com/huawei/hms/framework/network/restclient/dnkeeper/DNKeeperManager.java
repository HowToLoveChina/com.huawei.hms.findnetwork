package com.huawei.hms.framework.network.restclient.dnkeeper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.HttpClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class DNKeeperManager {

    /* renamed from: m */
    private static final String f25022m = "DNKeeperManager";

    /* renamed from: n */
    private static final String f25023n = "DNKeeperManager";

    /* renamed from: o */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile DNKeeperManager f25024o = new DNKeeperManager();

    /* renamed from: p */
    private static final int f25025p = 8;

    /* renamed from: q */
    private static final String f25026q = ":";

    /* renamed from: r */
    public static final /* synthetic */ int f25027r = 0;

    /* renamed from: a */
    private volatile HttpClient f25028a;

    /* renamed from: e */
    private String f25032e;

    /* renamed from: f */
    private int f25033f;

    /* renamed from: h */
    private PLSharedPreferences f25035h;

    /* renamed from: k */
    private String f25038k;

    /* renamed from: l */
    private List<String> f25039l;

    /* renamed from: b */
    private volatile boolean f25029b = false;

    /* renamed from: c */
    private volatile boolean f25030c = false;

    /* renamed from: d */
    private volatile int f25031d = 60000;

    /* renamed from: g */
    private ConcurrentHashMap<String, C5487h> f25034g = new ConcurrentHashMap<>();

    /* renamed from: i */
    private final ExecutorService f25036i = new ThreadPoolExcutorEnhance(8, 16, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), ExecutorsUtils.createThreadFactory("DNKeeperManager"));

    /* renamed from: j */
    private final Object f25037j = new Object();

    /* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager$a */
    public class RunnableC5475a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f25040a;

        public RunnableC5475a(Context context) {
            this.f25040a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            DNKeeperManager.this.f25035h = new PLSharedPreferences(this.f25040a, InterfaceC5483d.f25087m);
            String string = DNKeeperManager.this.f25035h.getString(InterfaceC5483d.f25088n);
            if (!TextUtils.isEmpty(string)) {
                DNKeeperManager.this.f25039l = Arrays.asList(string.split("&"));
            }
            DNKeeperManager dNKeeperManager = DNKeeperManager.this;
            dNKeeperManager.f25028a = dNKeeperManager.getHttpClient();
        }
    }

    /* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager$b */
    public class CallableC5476b implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ DNSCallback f25042a;

        /* renamed from: b */
        final /* synthetic */ RequestHost f25043b;

        public CallableC5476b(DNSCallback dNSCallback, RequestHost requestHost) {
            this.f25042a = dNSCallback;
            this.f25043b = requestHost;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            this.f25042a.onResult(DNKeeperManager.this.queryIpsSync(this.f25043b));
            return null;
        }
    }

    /* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager$c */
    public class RunnableC5477c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f25045a;

        public RunnableC5477c(String str) {
            this.f25045a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            boolean zM32397a = C5485f.m32397a(DNKeeperManager.this.f25035h, this.f25045a);
            Logger.m32143v("DNKeeperManager", "checkDNKeeperIP " + zM32397a);
            if (zM32397a) {
                RequestHost requestHost = new RequestHost(this.f25045a);
                requestHost.enableAccelerate(true);
                C5484e c5484e = new C5484e();
                c5484e.put("trigger_type", "dns_init");
                DNKeeperManager.this.m32375b(requestHost, this.f25045a, c5484e);
            }
        }
    }

    /* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager$d */
    public class CallableC5478d implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ DNSBatchCallback f25047a;

        /* renamed from: b */
        final /* synthetic */ HashSet f25048b;

        public CallableC5478d(DNSBatchCallback dNSBatchCallback, HashSet hashSet) {
            this.f25047a = dNSBatchCallback;
            this.f25048b = hashSet;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            this.f25047a.onResult(DNKeeperManager.this.batchQueryIpsSync(this.f25048b));
            return null;
        }
    }

    private DNKeeperManager() {
    }

    /* renamed from: a */
    private C5487h m32365a(String str) {
        C5487h c5487hPutIfAbsent;
        synchronized (this.f25037j) {
            try {
                C5487h c5487h = this.f25034g.get(str);
                if (c5487h != null || (c5487hPutIfAbsent = this.f25034g.putIfAbsent(str, (c5487h = new C5487h()))) == null) {
                    c5487hPutIfAbsent = c5487h;
                }
            } finally {
            }
        }
        return c5487hPutIfAbsent;
    }

    /* renamed from: b */
    private HashMap<String, C5487h> m32374b(Set<String> set) {
        C5487h c5487hPutIfAbsent;
        HashMap<String, C5487h> map = new HashMap<>();
        if (set != null) {
            for (String str : set) {
                C5487h c5487h = this.f25034g.get(str);
                if (c5487h != null || (c5487hPutIfAbsent = this.f25034g.putIfAbsent(str, (c5487h = new C5487h()))) == null) {
                    c5487hPutIfAbsent = c5487h;
                }
                map.put(str, c5487hPutIfAbsent);
            }
        }
        return map;
    }

    public static DNKeeperManager getInstance() {
        return f25024o;
    }

    public void batchQueryIpsAsync(HashSet<RequestHost> hashSet, DNSBatchCallback dNSBatchCallback) {
        if (dNSBatchCallback == null) {
            return;
        }
        Logger.m32143v("DNKeeperManager", "batchQueryIpsAsync future = " + this.f25036i.submit(new CallableC5478d(dNSBatchCallback, hashSet)));
    }

    public HashMap<String, DnsResult> batchQueryIpsSync(HashSet<RequestHost> hashSet) throws ExecutionException, InterruptedException, TimeoutException {
        HashMap map;
        C5484e c5484e = new C5484e();
        HashMap<String, DnsResult> map2 = new HashMap<>();
        HashSet<RequestHost> hashSet2 = new HashSet<>();
        HashSet<RequestHost> hashSet3 = new HashSet<>();
        String domainName = getDomainName();
        if (hashSet != null && ContextHolder.getAppContext() != null && !TextUtils.isEmpty(domainName)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<RequestHost> it = hashSet.iterator();
            while (true) {
                map = null;
                if (!it.hasNext()) {
                    break;
                }
                RequestHost next = it.next();
                String domainName2 = next.getDomainName();
                if (!TextUtils.isEmpty(domainName2)) {
                    String strSubstring = StringUtils.substring(domainName2, domainName2.lastIndexOf(".", domainName2.lastIndexOf(".") - 1) + 1);
                    List<String> list = this.f25039l;
                    if (list != null && !list.contains(strSubstring) && !this.f25039l.isEmpty()) {
                        Logger.m32141i("DNKeeperManager", domainName2 + " is not included in allowlist");
                    } else if (domainName2.equals(domainName)) {
                        Logger.m32141i("DNKeeperManager", "DNKeeper domainName queryIps from SharePreference");
                        PLSharedPreferences pLSharedPreferences = this.f25035h;
                        DnsResult dnsResultM32389a = pLSharedPreferences != null ? C5485f.m32389a(pLSharedPreferences.getString(domainName2)) : null;
                        if (C5485f.m32398a(dnsResultM32389a)) {
                            dnsResultM32389a = C5485f.m32388a(dnsResultM32389a, this.f25038k);
                        }
                        map2.put(domainName2, dnsResultM32389a);
                    } else {
                        C5487h c5487h = this.f25034g.get(domainName2);
                        if (c5487h != null) {
                            DnsResult dnsResultM32401a = c5487h.m32401a();
                            if (!C5485f.m32398a(dnsResultM32401a)) {
                                if (c5487h.m32408d() && jCurrentTimeMillis - dnsResultM32401a.getCreateTime() > 60000) {
                                    hashSet3.add(next);
                                }
                                map2.put(domainName2, dnsResultM32401a);
                            }
                        }
                        hashSet2.add(next);
                    }
                }
            }
            if (hashSet2.isEmpty()) {
                if (!hashSet3.isEmpty()) {
                    Logger.m32143v("DNKeeperManager", "lazyUpdate domains: " + hashSet3);
                    c5484e.put("trigger_type", "dns_lazy_update");
                    m32367a(hashSet3, domainName, c5484e);
                }
                Logger.m32141i("DNKeeperManager", map2.keySet().toString() + " queryIps from Map");
                return map2;
            }
            hashSet2.addAll(hashSet3);
            c5484e.put("trigger_type", "dns_sync_query");
            HashSet<Future> hashSetM32367a = m32367a(hashSet2, domainName, c5484e);
            if (hashSetM32367a != null && !hashSetM32367a.isEmpty()) {
                if (hashSetM32367a.size() != 1) {
                    Logger.m32141i("DNKeeperManager", "queryIps from futureSet");
                    try {
                        Iterator<Future> it2 = hashSetM32367a.iterator();
                        while (it2.hasNext()) {
                            it2.next().get(this.f25033f, TimeUnit.MILLISECONDS);
                        }
                    } catch (Exception e10) {
                        Logger.m32146w("DNKeeperManager", "queryIpsSync failed ", e10);
                    }
                    Iterator<RequestHost> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        String domainName3 = it3.next().getDomainName();
                        C5487h c5487h2 = this.f25034g.get(domainName3);
                        if (c5487h2 != null) {
                            map2.put(domainName3, c5487h2.m32401a());
                        }
                    }
                    Logger.m32143v("DNKeeperManager", map2.toString());
                    return map2;
                }
                try {
                    map = (HashMap) hashSetM32367a.iterator().next().get(this.f25033f, TimeUnit.MILLISECONDS);
                } catch (Exception e11) {
                    Logger.m32146w("DNKeeperManager", "queryIpsSync failed ", e11);
                }
                if (map != null) {
                    Iterator it4 = map.entrySet().iterator();
                    while (it4.hasNext()) {
                        if (C5485f.m32398a((DnsResult) ((Map.Entry) it4.next()).getValue())) {
                            it4.remove();
                        }
                    }
                    map2.putAll(map);
                    Logger.m32141i("DNKeeperManager", map2.keySet().toString() + " queryIps from dnkeeper service");
                    return map2;
                }
                Logger.m32141i("DNKeeperManager", "dnsResults is null");
            }
            Logger.m32141i("DNKeeperManager", "queryIps from SharePreference");
            if (this.f25035h != null) {
                Iterator<RequestHost> it5 = hashSet2.iterator();
                while (it5.hasNext()) {
                    RequestHost next2 = it5.next();
                    map2.put(next2.getDomainName(), C5485f.m32389a(this.f25035h.getString(next2.getDomainName())));
                }
            }
        }
        return map2;
    }

    public String getDomainName() {
        String strSynGetGrsUrl = new GrsClient(ContextHolder.getResourceContext(), new GrsBaseInfo()).synGetGrsUrl(InterfaceC5483d.f25085k, "ROOT");
        Logger.m32143v("DNKeeperManager", "getDomainName: " + strSynGetGrsUrl);
        if (!TextUtils.isEmpty(strSynGetGrsUrl) && strSynGetGrsUrl.contains(":")) {
            String[] strArrSplit = strSynGetGrsUrl.split(":");
            if (strArrSplit.length == 3) {
                strSynGetGrsUrl = strArrSplit[0] + ":" + strArrSplit[1];
                this.f25038k = strArrSplit[2];
            }
        }
        if (TextUtils.isEmpty(NetworkUtil.getHost(strSynGetGrsUrl))) {
            PLSharedPreferences pLSharedPreferences = this.f25035h;
            if (pLSharedPreferences != null) {
                strSynGetGrsUrl = pLSharedPreferences.getString(InterfaceC5483d.f25079e);
            }
            if (TextUtils.isEmpty(NetworkUtil.getHost(strSynGetGrsUrl))) {
                strSynGetGrsUrl = this.f25032e;
            }
        }
        return NetworkUtil.getHost(strSynGetGrsUrl);
    }

    public HttpClient getHttpClient() {
        if (this.f25028a == null) {
            synchronized (this.f25037j) {
                try {
                    if (this.f25028a == null) {
                        this.f25028a = new HttpClient.Builder().build();
                    }
                } finally {
                }
            }
        }
        return this.f25028a;
    }

    public C5487h getRequestRecord(String str) {
        return this.f25034g.get(str);
    }

    public void init(Context context) {
        init(context, 10000);
    }

    public boolean isInit() {
        return this.f25029b;
    }

    public void queryIpsAsync(RequestHost requestHost, DNSCallback dNSCallback) {
        if (dNSCallback == null) {
            return;
        }
        Logger.m32143v("DNKeeperManager", "queryIpsAsync future = " + this.f25036i.submit(new CallableC5476b(dNSCallback, requestHost)));
    }

    public DnsResult queryIpsFromCache(String str) {
        DnsResult dnsResult = new DnsResult();
        if (TextUtils.isEmpty(str)) {
            Logger.m32143v("DNKeeperManager", "queryIpsFromCache domain is null");
            return dnsResult;
        }
        C5487h c5487h = this.f25034g.get(str);
        if (c5487h != null) {
            dnsResult = c5487h.m32401a();
        }
        if (C5485f.m32398a(dnsResult)) {
            Logger.m32144v("DNKeeperManager", "no local data = %s", str);
        }
        dnsResult.setCache(1);
        return dnsResult;
    }

    public DnsResult queryIpsFromSp(String str) throws JSONException {
        Logger.m32144v("DNKeeperManager", "queryIps from SharePreference: %s", str);
        PLSharedPreferences pLSharedPreferences = this.f25035h;
        if (pLSharedPreferences == null) {
            return null;
        }
        DnsResult dnsResultM32389a = C5485f.m32389a(pLSharedPreferences.getString(str));
        dnsResultM32389a.setCache(1);
        return dnsResultM32389a;
    }

    public DnsResult queryIpsSync(RequestHost requestHost) throws JSONException {
        DnsResult dnsResult = new DnsResult();
        if (requestHost == null) {
            return dnsResult;
        }
        String domainName = requestHost.getDomainName();
        Logger.m32141i("DNKeeperManager", domainName + " query mode is single");
        C5484e c5484e = new C5484e();
        if (!TextUtils.isEmpty(domainName) && ContextHolder.getAppContext() != null) {
            String strSubstring = StringUtils.substring(domainName, domainName.lastIndexOf(".", domainName.lastIndexOf(".") - 1) + 1);
            List<String> list = this.f25039l;
            if (list != null && !list.contains(strSubstring) && !this.f25039l.isEmpty()) {
                return dnsResult;
            }
            C5487h c5487h = this.f25034g.get(domainName);
            if (c5487h != null) {
                dnsResult = c5487h.m32401a();
                if (!C5485f.m32398a(dnsResult)) {
                    Logger.m32141i("DNKeeperManager", domainName + " queryIps from Map");
                    if (c5487h.m32408d() && System.currentTimeMillis() - dnsResult.getCreateTime() > 60000) {
                        Logger.m32141i("DNKeeperManager", "lazyUpdate domain: " + domainName);
                        m32372a(requestHost, domainName, c5484e);
                    }
                    dnsResult.setCache(1);
                    return dnsResult;
                }
            }
            PLSharedPreferences pLSharedPreferences = this.f25035h;
            if (pLSharedPreferences != null) {
                dnsResult = C5485f.m32389a(pLSharedPreferences.getString(domainName));
                int status = dnsResult.getStatus();
                if (!C5485f.m32398a(dnsResult) && status != 2) {
                    dnsResult.setCache(1);
                    Logger.m32141i("DNKeeperManager", domainName + " queryIps from SharePreference");
                    if (status == 1) {
                        m32372a(requestHost, domainName, c5484e);
                    }
                    return dnsResult;
                }
            }
            String domainName2 = getDomainName();
            if (TextUtils.isEmpty(domainName2)) {
                return dnsResult;
            }
            if (domainName.equals(domainName2)) {
                return m32366a(dnsResult, domainName);
            }
            m32376b(domainName2);
            Future futureM32370a = m32370a(requestHost, domainName2);
            if (futureM32370a != null) {
                try {
                    dnsResult = (DnsResult) futureM32370a.get(this.f25033f, TimeUnit.MILLISECONDS);
                } catch (Exception e10) {
                    Logger.m32146w("DNKeeperManager", "queryIpsSync failed ", e10);
                }
                if (!C5485f.m32398a(dnsResult)) {
                    dnsResult.setCache(0);
                    Logger.m32141i("DNKeeperManager", domainName + " queryIps from dnkeeper service");
                }
            }
        }
        return dnsResult;
    }

    public boolean removeCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Logger.m32143v("DNKeeperManager", "removeCache host: " + str);
        C5487h c5487h = this.f25034g.get(str);
        if (c5487h != null) {
            c5487h.m32405a(true);
        }
        return true;
    }

    public void setRequestIntervalFailed(int i10) {
        if (i10 >= 30000 && i10 < 600000) {
            this.f25031d = i10;
            return;
        }
        Logger.m32145w("DNKeeperManager", "the setRequestIntervalFailed, set to default:" + i10);
    }

    /* renamed from: a */
    private DnsResult m32366a(DnsResult dnsResult, String str) throws JSONException {
        PLSharedPreferences pLSharedPreferences = this.f25035h;
        if (pLSharedPreferences != null) {
            dnsResult = C5485f.m32389a(pLSharedPreferences.getString(str));
        }
        if (C5485f.m32398a(dnsResult)) {
            dnsResult = C5485f.m32388a(dnsResult, this.f25038k);
        }
        dnsResult.setCache(1);
        return dnsResult;
    }

    /* renamed from: b */
    public void m32375b(RequestHost requestHost, String str, C5484e c5484e) {
        String domainName = requestHost.getDomainName();
        C5487h c5487hM32365a = m32365a(domainName);
        if (m32373a(c5487hM32365a)) {
            return;
        }
        Set<String> setM32369a = m32369a();
        HashSet<RequestHost> hashSetM32368a = m32368a(setM32369a);
        HashMap<String, C5487h> mapM32374b = m32374b(setM32369a);
        mapM32374b.put(domainName, c5487hM32365a);
        hashSetM32368a.add(requestHost);
        synchronized (this.f25037j) {
            Future futureM32406b = c5487hM32365a.m32406b();
            if (futureM32406b == null) {
                futureM32406b = m32371a(hashSetM32368a, str, mapM32374b, c5484e);
                Logger.m32141i("DNKeeperManager", "future == null");
                c5487hM32365a.m32402a(0L);
                c5487hM32365a.m32404a(futureM32406b);
            }
            Logger.m32143v("DNKeeperManager", "submitLazyRequest future = " + futureM32406b);
        }
    }

    public void init(Context context, int i10) {
        CheckParamUtils.checkNotNull(context, "context == null");
        Context applicationContext = context.getApplicationContext();
        NetworkKit.init(applicationContext, null);
        try {
            this.f25032e = ContextHolder.getResourceContext().getString(C5479R.string.networkkit_dnkeeper_domain);
        } catch (Throwable th2) {
            Logger.m32143v("DNKeeperManager", "DEFAULT_DOMAIN_NAME failed: " + th2);
        }
        Logger.m32143v("DNKeeperManager", "defaultDomain " + this.f25032e);
        if (i10 < 0 || i10 > 10000) {
            Logger.m32145w("DNKeeperManager", "maybe you need set a time between 0-10000");
            i10 = 10000;
        }
        this.f25033f = i10;
        if (this.f25029b) {
            return;
        }
        this.f25029b = true;
        this.f25036i.execute(new RunnableC5475a(applicationContext));
    }

    /* renamed from: a */
    private HashSet<Future> m32367a(HashSet<RequestHost> hashSet, String str, C5484e c5484e) {
        HashSet<Future> hashSet2 = new HashSet<>();
        HashMap<String, C5487h> map = new HashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Logger.m32143v("DNKeeperManager", "requestHosts: " + Arrays.toString(hashSet.toArray()));
        Iterator<RequestHost> it = hashSet.iterator();
        boolean z10 = true;
        boolean z11 = true;
        while (it.hasNext()) {
            String domainName = it.next().getDomainName();
            C5487h c5487hM32365a = m32365a(domainName);
            map.put(domainName, c5487hM32365a);
            long jM32407c = jCurrentTimeMillis - c5487hM32365a.m32407c();
            if (jM32407c < this.f25031d) {
                Logger.m32143v("DNKeeperManager", "now - time = " + jM32407c);
            } else {
                z10 = false;
            }
            if (c5487hM32365a.m32406b() == null) {
                z11 = false;
            } else {
                hashSet2.add(c5487hM32365a.m32406b());
            }
        }
        if (z10) {
            Logger.m32141i("DNKeeperManager", "request needSuppressed");
            return null;
        }
        if (!z11) {
            Logger.m32141i("DNKeeperManager", "request use NewFuture instead of ExistedFuture");
            Future futureM32371a = m32371a(hashSet, str, map, c5484e);
            hashSet2.clear();
            hashSet2.add(futureM32371a);
            for (C5487h c5487h : map.values()) {
                c5487h.m32402a(0L);
                c5487h.m32404a(futureM32371a);
            }
        }
        return hashSet2;
    }

    /* renamed from: b */
    private void m32376b(String str) {
        if (this.f25030c) {
            return;
        }
        synchronized (DNKeeperManager.class) {
            try {
                if (this.f25030c) {
                    return;
                }
                this.f25030c = true;
                this.f25036i.execute(new RunnableC5477c(str));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private HashSet<RequestHost> m32368a(Set<String> set) {
        HashSet<RequestHost> hashSet = new HashSet<>();
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                RequestHost requestHost = new RequestHost(it.next());
                requestHost.enableAccelerate(true);
                requestHost.setDnsFailType("lazyUpdate");
                hashSet.add(requestHost);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private Set<String> m32369a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f25035h;
        Set<String> setKeySet = (pLSharedPreferences == null || (all = pLSharedPreferences.getAll()) == null) ? null : all.keySet();
        if (setKeySet != null) {
            setKeySet.remove(InterfaceC5483d.f25088n);
            setKeySet.remove(InterfaceC5483d.f25079e);
        }
        return setKeySet;
    }

    /* renamed from: a */
    private Future m32370a(RequestHost requestHost, String str) {
        Future futureM32406b;
        C5487h c5487hM32365a = m32365a(requestHost.getDomainName());
        if (m32373a(c5487hM32365a)) {
            return null;
        }
        synchronized (this.f25037j) {
            futureM32406b = c5487hM32365a.m32406b();
            if (futureM32406b == null) {
                Logger.m32141i("DNKeeperManager", "future == null");
                futureM32406b = this.f25036i.submit(new CallableC5482c(requestHost, str, c5487hM32365a, this.f25035h));
                c5487hM32365a.m32402a(0L);
                c5487hM32365a.m32404a(futureM32406b);
            }
            Logger.m32143v("DNKeeperManager", "submitRequest future = " + futureM32406b);
        }
        return futureM32406b;
    }

    /* renamed from: a */
    private Future m32371a(HashSet<RequestHost> hashSet, String str, HashMap<String, C5487h> map, C5484e c5484e) {
        return this.f25036i.submit(new CallableC5481b(hashSet, str, map, this.f25035h, c5484e));
    }

    /* renamed from: a */
    private void m32372a(RequestHost requestHost, String str, C5484e c5484e) {
        String domainName = getDomainName();
        if (TextUtils.isEmpty(domainName) || str.equals(domainName)) {
            return;
        }
        c5484e.put("trigger_type", "dns_lazy_update");
        m32375b(requestHost, domainName, c5484e);
    }

    /* renamed from: a */
    private boolean m32373a(C5487h c5487h) {
        long jCurrentTimeMillis = System.currentTimeMillis() - c5487h.m32407c();
        if (jCurrentTimeMillis >= this.f25031d) {
            return false;
        }
        Logger.m32141i("DNKeeperManager", "now - time = " + jCurrentTimeMillis);
        return true;
    }
}
