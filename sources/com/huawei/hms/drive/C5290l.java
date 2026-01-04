package com.huawei.hms.drive;

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
import com.huawei.hms.framework.network.restclient.dnkeeper.C5479R;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.HttpClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* renamed from: com.huawei.hms.drive.l */
/* loaded from: classes8.dex */
public class C5290l {

    /* renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile C5290l f24516a = new C5290l();

    /* renamed from: b */
    private volatile HttpClient f24517b;

    /* renamed from: f */
    private String f24521f;

    /* renamed from: g */
    private int f24522g;

    /* renamed from: i */
    private PLSharedPreferences f24524i;

    /* renamed from: l */
    private String f24527l;

    /* renamed from: m */
    private List<String> f24528m;

    /* renamed from: c */
    private volatile boolean f24518c = false;

    /* renamed from: d */
    private volatile boolean f24519d = false;

    /* renamed from: e */
    private volatile int f24520e = 60000;

    /* renamed from: h */
    private ConcurrentHashMap<String, C5297s> f24523h = new ConcurrentHashMap<>();

    /* renamed from: j */
    private final ExecutorService f24525j = new ThreadPoolExcutorEnhance(8, 16, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), ExecutorsUtils.createThreadFactory("DNKeeperManager"));

    /* renamed from: k */
    private final Object f24526k = new Object();

    /* renamed from: com.huawei.hms.drive.l$a */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24529a;

        public a(Context context) {
            this.f24529a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5290l.this.f24524i = new PLSharedPreferences(this.f24529a, InterfaceC5483d.f25087m);
            String string = C5290l.this.f24524i.getString(InterfaceC5483d.f25088n);
            if (!TextUtils.isEmpty(string)) {
                C5290l.this.f24528m = Arrays.asList(string.split("&"));
            }
            C5290l c5290l = C5290l.this;
            c5290l.f24517b = c5290l.m31753d();
        }
    }

    /* renamed from: com.huawei.hms.drive.l$b */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f24531a;

        public b(String str) {
            this.f24531a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            boolean zM31787a = C5295q.m31787a(C5290l.this.f24524i, this.f24531a);
            Logger.m32143v("DNKeeperManager", "checkDNKeeperIP " + zM31787a);
            if (zM31787a) {
                C5291m c5291m = new C5291m(this.f24531a);
                c5291m.m31757a(true);
                C5294p c5294p = new C5294p();
                c5294p.put("trigger_type", "dns_init");
                C5290l.this.m31743b(c5291m, this.f24531a, c5294p);
            }
        }
    }

    private C5290l() {
    }

    /* renamed from: a */
    public static C5290l m31730a() {
        return f24516a;
    }

    /* renamed from: b */
    private HashMap<String, C5297s> m31742b(Set<String> set) {
        C5297s c5297sPutIfAbsent;
        HashMap<String, C5297s> map = new HashMap<>();
        if (set != null) {
            for (String str : set) {
                C5297s c5297s = this.f24523h.get(str);
                if (c5297s != null || (c5297sPutIfAbsent = this.f24523h.putIfAbsent(str, (c5297s = new C5297s()))) == null) {
                    c5297sPutIfAbsent = c5297s;
                }
                map.put(str, c5297sPutIfAbsent);
            }
        }
        return map;
    }

    /* renamed from: c */
    private C5297s m31745c(String str) {
        C5297s c5297sPutIfAbsent;
        synchronized (this.f24526k) {
            try {
                C5297s c5297s = this.f24523h.get(str);
                if (c5297s != null || (c5297sPutIfAbsent = this.f24523h.putIfAbsent(str, (c5297s = new C5297s()))) == null) {
                    c5297sPutIfAbsent = c5297s;
                }
            } finally {
            }
        }
        return c5297sPutIfAbsent;
    }

    /* renamed from: e */
    private Set<String> m31746e() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f24524i;
        Set<String> setKeySet = (pLSharedPreferences == null || (all = pLSharedPreferences.getAll()) == null) ? null : all.keySet();
        if (setKeySet != null) {
            setKeySet.remove(InterfaceC5483d.f25088n);
            setKeySet.remove(InterfaceC5483d.f25079e);
        }
        return setKeySet;
    }

    /* renamed from: d */
    public HttpClient m31753d() {
        if (this.f24517b == null) {
            synchronized (this.f24526k) {
                try {
                    if (this.f24517b == null) {
                        this.f24517b = new HttpClient.Builder().build();
                    }
                } finally {
                }
            }
        }
        return this.f24517b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m31743b(C5291m c5291m, String str, C5294p c5294p) {
        String strM31754a = c5291m.m31754a();
        C5297s c5297sM31745c = m31745c(strM31754a);
        if (m31741a(c5297sM31745c)) {
            return;
        }
        Set<String> setM31746e = m31746e();
        HashSet<C5291m> hashSetM31735a = m31735a(setM31746e);
        HashMap<String, C5297s> mapM31742b = m31742b(setM31746e);
        mapM31742b.put(strM31754a, c5297sM31745c);
        hashSetM31735a.add(c5291m);
        synchronized (this.f24526k) {
            Future futureM31796c = c5297sM31745c.m31796c();
            if (futureM31796c == null) {
                futureM31796c = m31738a(hashSetM31735a, str, mapM31742b, c5294p);
                Logger.m32141i("DNKeeperManager", "future == null");
                c5297sM31745c.m31790a(0L);
                c5297sM31745c.m31792a(futureM31796c);
            }
            Logger.m32143v("DNKeeperManager", "submitLazyRequest future = " + futureM31796c);
        }
    }

    /* renamed from: a */
    public C5298t m31747a(C5291m c5291m) throws JSONException {
        C5298t c5298t = new C5298t();
        if (c5291m == null) {
            return c5298t;
        }
        String strM31754a = c5291m.m31754a();
        Logger.m32141i("DNKeeperManager", strM31754a + " query mode is single");
        C5294p c5294p = new C5294p();
        if (!TextUtils.isEmpty(strM31754a) && ContextHolder.getAppContext() != null) {
            String strSubstring = StringUtils.substring(strM31754a, strM31754a.lastIndexOf(".", strM31754a.lastIndexOf(".") - 1) + 1);
            List<String> list = this.f24528m;
            if (list != null && !list.contains(strSubstring) && !this.f24528m.isEmpty()) {
                return c5298t;
            }
            C5297s c5297s = this.f24523h.get(strM31754a);
            if (c5297s != null) {
                c5298t = c5297s.m31797d();
                if (!C5295q.m31786a(c5298t)) {
                    Logger.m32141i("DNKeeperManager", strM31754a + " queryIps from Map");
                    if (c5297s.m31794a() && System.currentTimeMillis() - c5298t.m31804c() > 60000) {
                        Logger.m32141i("DNKeeperManager", "lazyUpdate domain: " + strM31754a);
                        m31740a(c5291m, strM31754a, c5294p);
                    }
                    c5298t.m31799a(1);
                    return c5298t;
                }
            }
            PLSharedPreferences pLSharedPreferences = this.f24524i;
            if (pLSharedPreferences != null) {
                c5298t = C5295q.m31778a(pLSharedPreferences.getString(strM31754a));
                int iM31806e = c5298t.m31806e();
                if (!C5295q.m31786a(c5298t) && iM31806e != 2) {
                    c5298t.m31799a(1);
                    Logger.m32141i("DNKeeperManager", strM31754a + " queryIps from SharePreference");
                    if (iM31806e == 1) {
                        m31740a(c5291m, strM31754a, c5294p);
                    }
                    return c5298t;
                }
            }
            String strM31752c = m31752c();
            if (TextUtils.isEmpty(strM31752c)) {
                return c5298t;
            }
            if (strM31754a.equals(strM31752c)) {
                return m31731a(c5298t, strM31754a);
            }
            m31744b(strM31752c);
            Future futureM31737a = m31737a(c5291m, strM31752c);
            if (futureM31737a != null) {
                try {
                    c5298t = (C5298t) futureM31737a.get(this.f24522g, TimeUnit.MILLISECONDS);
                } catch (Exception e10) {
                    Logger.m32146w("DNKeeperManager", "queryIpsSync failed ", e10);
                }
                if (!C5295q.m31786a(c5298t)) {
                    c5298t.m31799a(0);
                    Logger.m32141i("DNKeeperManager", strM31754a + " queryIps from dnkeeper service");
                }
            }
        }
        return c5298t;
    }

    /* renamed from: c */
    public String m31752c() {
        String strSynGetGrsUrl = new GrsClient(ContextHolder.getResourceContext(), new GrsBaseInfo()).synGetGrsUrl(InterfaceC5483d.f25085k, "ROOT");
        Logger.m32143v("DNKeeperManager", "getDomainName: " + strSynGetGrsUrl);
        if (!TextUtils.isEmpty(strSynGetGrsUrl) && strSynGetGrsUrl.contains(":")) {
            String[] strArrSplit = strSynGetGrsUrl.split(":");
            if (strArrSplit.length == 3) {
                strSynGetGrsUrl = strArrSplit[0] + ":" + strArrSplit[1];
                this.f24527l = strArrSplit[2];
            }
        }
        if (TextUtils.isEmpty(NetworkUtil.getHost(strSynGetGrsUrl))) {
            PLSharedPreferences pLSharedPreferences = this.f24524i;
            if (pLSharedPreferences != null) {
                strSynGetGrsUrl = pLSharedPreferences.getString(InterfaceC5483d.f25079e);
            }
            if (TextUtils.isEmpty(NetworkUtil.getHost(strSynGetGrsUrl))) {
                strSynGetGrsUrl = this.f24521f;
            }
        }
        return NetworkUtil.getHost(strSynGetGrsUrl);
    }

    /* renamed from: a */
    private C5298t m31731a(C5298t c5298t, String str) throws JSONException {
        PLSharedPreferences pLSharedPreferences = this.f24524i;
        if (pLSharedPreferences != null) {
            c5298t = C5295q.m31778a(pLSharedPreferences.getString(str));
        }
        if (C5295q.m31786a(c5298t)) {
            c5298t = C5295q.m31777a(c5298t, this.f24527l);
        }
        c5298t.m31799a(1);
        return c5298t;
    }

    /* renamed from: b */
    private void m31744b(String str) {
        if (this.f24519d) {
            return;
        }
        synchronized (C5290l.class) {
            try {
                if (this.f24519d) {
                    return;
                }
                this.f24519d = true;
                this.f24525j.execute(new b(str));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public boolean m31751b() {
        return this.f24518c;
    }

    /* renamed from: a */
    private HashSet<C5291m> m31735a(Set<String> set) {
        HashSet<C5291m> hashSet = new HashSet<>();
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                C5291m c5291m = new C5291m(it.next());
                c5291m.m31757a(true);
                c5291m.m31759b("lazyUpdate");
                hashSet.add(c5291m);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private Future m31737a(C5291m c5291m, String str) {
        Future futureM31796c;
        C5297s c5297sM31745c = m31745c(c5291m.m31754a());
        if (m31741a(c5297sM31745c)) {
            return null;
        }
        synchronized (this.f24526k) {
            futureM31796c = c5297sM31745c.m31796c();
            if (futureM31796c == null) {
                Logger.m32141i("DNKeeperManager", "future == null");
                futureM31796c = this.f24525j.submit(new CallableC5293o(c5291m, str, c5297sM31745c, this.f24524i));
                c5297sM31745c.m31790a(0L);
                c5297sM31745c.m31792a(futureM31796c);
            }
            Logger.m32143v("DNKeeperManager", "submitRequest future = " + futureM31796c);
        }
        return futureM31796c;
    }

    /* renamed from: a */
    private Future m31738a(HashSet<C5291m> hashSet, String str, HashMap<String, C5297s> map, C5294p c5294p) {
        return this.f24525j.submit(new CallableC5292n(hashSet, str, map, this.f24524i, c5294p));
    }

    /* renamed from: a */
    public void m31748a(Context context) {
        m31749a(context, 10000);
    }

    /* renamed from: a */
    public void m31749a(Context context, int i10) {
        CheckParamUtils.checkNotNull(context, "context == null");
        Context applicationContext = context.getApplicationContext();
        NetworkKit.init(applicationContext, null);
        try {
            this.f24521f = ContextHolder.getResourceContext().getString(C5479R.string.networkkit_dnkeeper_domain);
        } catch (Throwable th2) {
            Logger.m32143v("DNKeeperManager", "DEFAULT_DOMAIN_NAME failed: " + th2);
        }
        Logger.m32143v("DNKeeperManager", "defaultDomain " + this.f24521f);
        if (i10 < 0 || i10 > 10000) {
            Logger.m32145w("DNKeeperManager", "maybe you need set a time between 0-10000");
            i10 = 10000;
        }
        this.f24522g = i10;
        if (this.f24518c) {
            return;
        }
        this.f24518c = true;
        this.f24525j.execute(new a(applicationContext));
    }

    /* renamed from: a */
    private void m31740a(C5291m c5291m, String str, C5294p c5294p) {
        String strM31752c = m31752c();
        if (TextUtils.isEmpty(strM31752c) || str.equals(strM31752c)) {
            return;
        }
        c5294p.put("trigger_type", "dns_lazy_update");
        m31743b(c5291m, strM31752c, c5294p);
    }

    /* renamed from: a */
    private boolean m31741a(C5297s c5297s) {
        long jCurrentTimeMillis = System.currentTimeMillis() - c5297s.m31795b();
        if (jCurrentTimeMillis >= this.f24520e) {
            return false;
        }
        Logger.m32141i("DNKeeperManager", "now - time = " + jCurrentTimeMillis);
        return true;
    }

    /* renamed from: a */
    public boolean m31750a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Logger.m32143v("DNKeeperManager", "removeCache host: " + str);
        C5297s c5297s = this.f24523h.get(str);
        if (c5297s != null) {
            c5297s.m31793a(true);
        }
        return true;
    }
}
