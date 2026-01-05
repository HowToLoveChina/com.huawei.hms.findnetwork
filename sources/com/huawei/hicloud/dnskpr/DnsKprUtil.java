package com.huawei.hicloud.dnskpr;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager;
import com.huawei.hms.framework.network.restclient.dnkeeper.RequestHost;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class DnsKprUtil {

    /* renamed from: a */
    public static long f22600a;

    /* renamed from: b */
    public static final Map<String, String> f22601b = new C4891a();

    /* renamed from: c */
    public static boolean f22602c = true;

    /* renamed from: d */
    public static Map<String, C4893c> f22603d = new HashMap();

    public static class DnsInitTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f22604a;

        public DnsInitTask(Context context) {
            this.f22604a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AbstractC10896a.m65887i("DnsKprUtil", "init");
            DNKeeperManager.getInstance().init(this.f22604a);
        }
    }

    /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$a */
    public class C4891a extends HashMap<String, String> {
        public C4891a() {
            put(SocketException.class.toString(), "1");
            put(PortUnreachableException.class.toString(), "2");
            put(ConnectException.class.toString(), "3");
            put(BindException.class.toString(), "3");
            put(HttpRetryException.class.toString(), "3");
            put(SocketTimeoutException.class.toString(), "4");
            put(UnknownHostException.class.toString(), "5");
            put(NoRouteToHostException.class.toString(), "6");
            put(UnknownServiceException.class.toString(), "7");
        }
    }

    /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$b */
    public class C4892b implements InterfaceC11921g {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC11921g f22605a;

        public C4892b(InterfaceC11921g interfaceC11921g) {
            this.f22605a = interfaceC11921g;
        }

        @Override // okhttp3.InterfaceC11921g
        public void onFailure(InterfaceC11919f interfaceC11919f, IOException iOException) {
            this.f22605a.onFailure(interfaceC11919f, iOException);
        }

        @Override // okhttp3.InterfaceC11921g
        public void onResponse(InterfaceC11919f interfaceC11919f, HttpResponseBuilder HttpResponseBuilder) throws IOException {
            this.f22605a.onResponse(interfaceC11919f, HttpResponseBuilder);
        }
    }

    /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$c */
    public static class C4893c {

        /* renamed from: a */
        public String f22606a;

        /* renamed from: b */
        public long f22607b;

        public C4893c(String str, long j10) {
            this.f22606a = str;
            this.f22607b = j10;
        }

        /* renamed from: a */
        public String m29903a() {
            return this.f22606a;
        }

        /* renamed from: b */
        public long m29904b() {
            return this.f22607b;
        }
    }

    /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$d */
    public static class C4894d {

        /* renamed from: a */
        public String f22608a;

        /* renamed from: b */
        public String f22609b;

        /* renamed from: c */
        public String f22610c;

        /* renamed from: d */
        public String f22611d;

        /* renamed from: e */
        public List<String> f22612e;

        /* renamed from: h */
        public HttpRequestBuilder.a f22615h;

        /* renamed from: i */
        public InterfaceC4895e f22616i;

        /* renamed from: j */
        public InterfaceC11921g f22617j;

        /* renamed from: g */
        public int f22614g = 2;

        /* renamed from: f */
        public int f22613f = 0 - 2;

        /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$d$a */
        public class a implements InterfaceC11921g {
            public a() {
            }

            @Override // okhttp3.InterfaceC11921g
            public void onFailure(InterfaceC11919f interfaceC11919f, IOException iOException) {
                AbstractC10896a.m65886e("DnsKprUtil", C4894d.this.f22610c + " ipOkHttpBuild IOException url " + C4894d.this.f22608a + " enqueueRun:" + iOException.getClass().toString() + ":" + iOException.getMessage());
                C4894d.this.f22611d = DnsKprUtil.m29892a(iOException);
                C4894d c4894d = C4894d.this;
                if (c4894d.f22612e != null && c4894d.f22613f >= C4894d.this.f22612e.size() - 1) {
                    C4894d.this.f22617j.onFailure(interfaceC11919f, iOException);
                } else {
                    C4894d.m29909e(C4894d.this);
                    C4894d.this.m29911g();
                }
            }

            @Override // okhttp3.InterfaceC11921g
            public void onResponse(InterfaceC11919f interfaceC11919f, HttpResponseBuilder HttpResponseBuilder) throws IOException {
                if (!TextUtils.isEmpty(C4894d.this.f22610c)) {
                    DnsKprUtil.m29900i(C4894d.this.f22609b, C4894d.this.f22610c);
                }
                C4894d.this.f22617j.onResponse(interfaceC11919f, HttpResponseBuilder);
            }
        }

        public C4894d(String str, String str2, String str3, HttpRequestBuilder.a aVar, InterfaceC4895e interfaceC4895e, InterfaceC11921g interfaceC11921g) {
            this.f22608a = str;
            this.f22609b = str2;
            this.f22616i = interfaceC4895e;
            this.f22617j = interfaceC11921g;
            this.f22611d = str3;
            this.f22615h = aVar;
        }

        /* renamed from: e */
        public static /* synthetic */ int m29909e(C4894d c4894d) {
            int i10 = c4894d.f22613f;
            c4894d.f22613f = i10 + 1;
            return i10;
        }

        /* renamed from: g */
        public void m29911g() {
            this.f22610c = "";
            if (this.f22613f == 0) {
                if (this.f22612e == null) {
                    this.f22612e = DnsKprUtil.m29894c(this.f22609b, this.f22611d);
                    AbstractC10896a.m65887i("DnsKprUtil", "get " + this.f22609b + " dnskpr available ip:" + this.f22612e.toString());
                }
                int size = this.f22612e.size();
                int i10 = this.f22613f;
                if (size > i10) {
                    this.f22610c = this.f22612e.get(i10);
                }
            }
            DnsKprUtil.m29897f(this.f22608a, this.f22609b, this.f22610c, this.f22615h);
            this.f22616i.run(this.f22615h, new a());
        }
    }

    /* renamed from: com.huawei.hicloud.dnskpr.DnsKprUtil$e */
    public interface InterfaceC4895e {
        HttpResponseBuilder run(HttpRequestBuilder.a aVar, String str) throws IOException;

        void run(HttpRequestBuilder.a aVar, InterfaceC11921g interfaceC11921g);
    }

    /* renamed from: a */
    public static String m29892a(Exception exc) {
        if (exc != null) {
            String string = exc.getClass().toString();
            Map<String, String> map = f22601b;
            if (map.containsKey(exc.getClass().toString())) {
                return map.get(string);
            }
        }
        return "9";
    }

    /* renamed from: b */
    public static IOException m29893b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("1")) {
            return str.equals("2") ? new PortUnreachableException() : str.equals("3") ? new ConnectException() : str.equals("4") ? new SocketTimeoutException() : str.equals("5") ? new UnknownHostException() : str.equals("6") ? new NoRouteToHostException() : str.equals("7") ? new UnknownServiceException() : new SocketException();
        }
        return new SocketException();
    }

    /* renamed from: c */
    public static List<String> m29894c(String str, String str2) {
        DnsResult dnsResultQueryIpsSync;
        List<DnsResult.Address> addressList;
        DNKeeperManager dNKeeperManager;
        ArrayList arrayList = new ArrayList();
        try {
            dNKeeperManager = DNKeeperManager.getInstance();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("DnsKprUtil", "getAvailableIpList error: " + e10.toString());
            dnsResultQueryIpsSync = null;
        }
        if (!dNKeeperManager.isInit()) {
            return arrayList;
        }
        RequestHost requestHost = new RequestHost(str);
        requestHost.setDnsFailType(str2);
        requestHost.setTime(10000L);
        dnsResultQueryIpsSync = dNKeeperManager.queryIpsSync(requestHost);
        if (dnsResultQueryIpsSync != null && (addressList = dnsResultQueryIpsSync.getAddressList()) != null && !addressList.isEmpty()) {
            for (int i10 = 0; i10 < addressList.size(); i10++) {
                DnsResult.Address address = addressList.get(i10);
                if ("A".equals(address.getType())) {
                    arrayList.add(address.getValue());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static String m29895d(String str) {
        if (!f22603d.containsKey(str)) {
            return "";
        }
        String strM29903a = f22603d.get(str).m29903a();
        if (System.currentTimeMillis() - f22603d.get(str).m29904b() <= 300000) {
            return strM29903a;
        }
        if (!DNKeeperManager.getInstance().isInit()) {
            return "";
        }
        DNKeeperManager.getInstance().removeCache(str);
        return "";
    }

    /* renamed from: e */
    public static void m29896e(Context context) {
        C12515a.m75110o().m75172d(new DnsInitTask(context));
    }

    /* renamed from: f */
    public static HttpRequestBuilder.a m29897f(String str, String str2, String str3, HttpRequestBuilder.a aVar) {
        if (!TextUtils.isEmpty(str3)) {
            AbstractC10896a.m65887i("DnsKprUtil", "ipOkHttpBuild host:" + str2 + " ip:" + str3);
            aVar.m71586m(str.replace(str2, str3));
            aVar.m71578e(FeedbackWebConstants.HOST, str2);
        }
        return aVar;
    }

    /* renamed from: g */
    public static boolean m29898g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f22600a <= 300000) {
            return true;
        }
        f22600a = jCurrentTimeMillis;
        return false;
    }

    /* renamed from: h */
    public static boolean m29899h(String str, String str2, int i10) {
        if (!f22602c) {
            return false;
        }
        if (TextUtils.isEmpty(m29895d(str))) {
            return i10 >= 2 && !TextUtils.isEmpty(str2);
        }
        return true;
    }

    /* renamed from: i */
    public static void m29900i(String str, String str2) {
        f22603d.put(str, new C4893c(str2, System.currentTimeMillis()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        r2 = r12.run(m29897f(r7, r8, r3, r11), r3);
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okhttp3.HttpResponseBuilder m29901j(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.io.IOException r10, okhttp3.HttpRequestBuilder.a r11, com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.dnskpr.DnsKprUtil.m29901j(java.lang.String, java.lang.String, java.lang.String, java.io.IOException, okhttp3.e0$a, com.huawei.hicloud.dnskpr.DnsKprUtil$e):okhttp3.g0");
    }

    /* renamed from: k */
    public static void m29902k(String str, String str2, String str3, HttpRequestBuilder.a aVar, InterfaceC4895e interfaceC4895e, InterfaceC11921g interfaceC11921g) {
        AbstractC10896a.m65885d("DnsKprUtil", "tryConnectByDNSKpr hostString:" + str2 + " errorCode:" + str3);
        String strM29895d = m29895d(str2);
        if (TextUtils.isEmpty(strM29895d)) {
            new C4894d(str, str2, str3, aVar, interfaceC4895e, interfaceC11921g).m29911g();
        } else {
            interfaceC4895e.run(m29897f(str, str2, strM29895d, aVar), new C4892b(interfaceC11921g));
        }
    }
}
