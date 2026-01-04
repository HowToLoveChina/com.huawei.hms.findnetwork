package p811yi;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.drive.C5201bf;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.C5290l;
import com.huawei.hms.drive.C5291m;
import com.huawei.hms.drive.C5298t;
import com.huawei.hms.framework.common.Logger;
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
import p776xi.AbstractRunnableC13815a;
import p776xi.C13816b;

/* renamed from: yi.c */
/* loaded from: classes.dex */
public class C13988c {

    /* renamed from: c */
    public static long f62683c;

    /* renamed from: a */
    public static final Map<String, String> f62681a = new a();

    /* renamed from: b */
    public static boolean f62682b = true;

    /* renamed from: d */
    public static Map<String, c> f62684d = new HashMap();

    /* renamed from: e */
    public static long f62685e = 300000;

    /* renamed from: yi.c$a */
    public class a extends HashMap<String, String> {
        public a() {
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

    /* renamed from: yi.c$b */
    public class b extends AbstractRunnableC13815a {

        /* renamed from: d */
        public final /* synthetic */ Context f62686d;

        public b(Context context) {
            this.f62686d = context;
        }

        @Override // p776xi.AbstractRunnableC13815a
        /* renamed from: a */
        public void mo72848a() {
            C5290l.m31730a().m31748a(this.f62686d);
        }
    }

    /* renamed from: yi.c$c */
    public static class c {

        /* renamed from: a */
        public String f62687a;

        /* renamed from: b */
        public long f62688b;

        public c(String str, long j10) {
            this.f62687a = str;
            this.f62688b = j10;
        }

        /* renamed from: a */
        public String m84016a() {
            return this.f62687a;
        }

        /* renamed from: b */
        public long m84017b() {
            return this.f62688b;
        }
    }

    /* renamed from: yi.c$d */
    public interface d {
        /* renamed from: a */
        C5203bh mo81825a(C5201bf.a aVar) throws IOException;
    }

    /* renamed from: a */
    public static String m84006a(Exception exc) {
        if (exc != null) {
            String string = exc.getClass().toString();
            Map<String, String> map = f62681a;
            if (map.containsKey(exc.getClass().toString())) {
                return map.get(string);
            }
        }
        return "9";
    }

    /* renamed from: b */
    public static IOException m84007b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("1")) {
            return str.equals("2") ? new PortUnreachableException() : str.equals("3") ? new ConnectException() : str.equals("4") ? new SocketTimeoutException() : str.equals("5") ? new UnknownHostException() : str.equals("6") ? new NoRouteToHostException() : str.equals("7") ? new UnknownServiceException() : new SocketException();
        }
        return new SocketException();
    }

    /* renamed from: c */
    public static List<String> m84008c(String str, String str2) {
        C5298t c5298tM31747a;
        List<C5298t.a> listM31803b;
        C5290l c5290lM31730a;
        ArrayList arrayList = new ArrayList();
        try {
            c5290lM31730a = C5290l.m31730a();
        } catch (Exception e10) {
            Logger.m32138e("DnsKprUtil", "getAvailableIpList error: " + e10.toString());
            c5298tM31747a = null;
        }
        if (!c5290lM31730a.m31751b()) {
            return arrayList;
        }
        C5291m c5291m = new C5291m(str);
        c5291m.m31759b(str2);
        c5291m.m31755a(10000L);
        c5298tM31747a = c5290lM31730a.m31747a(c5291m);
        if (c5298tM31747a != null && (listM31803b = c5298tM31747a.m31803b()) != null && !listM31803b.isEmpty()) {
            for (int i10 = 0; i10 < listM31803b.size(); i10++) {
                C5298t.a aVar = listM31803b.get(i10);
                if ("A".equals(aVar.m31807a())) {
                    arrayList.add(aVar.m31808b());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static String m84009d(String str) {
        if (!f62684d.containsKey(str)) {
            return "";
        }
        String strM84016a = f62684d.get(str).m84016a();
        if (System.currentTimeMillis() - f62684d.get(str).m84017b() <= f62685e) {
            return strM84016a;
        }
        if (!C5290l.m31730a().m31751b()) {
            return "";
        }
        C5290l.m31730a().m31750a(str);
        return "";
    }

    /* renamed from: e */
    public static void m84010e(Context context) {
        C13816b.m82856c().m82858b(new b(context));
    }

    /* renamed from: f */
    public static C5201bf.a m84011f(String str, String str2, String str3, C5201bf.a aVar) {
        if (!TextUtils.isEmpty(str3)) {
            Logger.m32141i("DnsKprUtil", "ipOkHttpBuild host:" + str2 + " ip:" + str3);
            aVar.m31120a(str.replace(str2, str3));
            aVar.m31122a(FeedbackWebConstants.HOST, str2);
        }
        return aVar;
    }

    /* renamed from: g */
    public static boolean m84012g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f62683c <= f62685e) {
            return true;
        }
        f62683c = jCurrentTimeMillis;
        return false;
    }

    /* renamed from: h */
    public static boolean m84013h(String str, String str2, int i10) {
        if (!f62682b) {
            return false;
        }
        if (TextUtils.isEmpty(m84009d(str))) {
            return i10 >= 2 && !TextUtils.isEmpty(str2);
        }
        return true;
    }

    /* renamed from: i */
    public static void m84014i(String str, String str2) {
        f62684d.put(str, new c(str2, System.currentTimeMillis()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        r2 = r12.mo81825a(m84011f(r7, r8, r3, r11));
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.drive.C5203bh m84015j(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.io.IOException r10, com.huawei.hms.drive.C5201bf.a r11, p811yi.C13988c.d r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p811yi.C13988c.m84015j(java.lang.String, java.lang.String, java.lang.String, java.io.IOException, com.huawei.hms.drive.bf$a, yi.c$d):com.huawei.hms.drive.bh");
    }
}
