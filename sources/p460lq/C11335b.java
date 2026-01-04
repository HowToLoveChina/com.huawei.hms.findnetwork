package p460lq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwidauth.datatype.SiteDefaultInfo;
import com.huawei.hwidauth.datatype.SiteListInfo;
import com.huawei.hwidauth.utils.globalcfg.CountryInfoForCFG;
import com.huawei.hwidauth.utils.globalcfg.SiteInfoForCFG;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParserException;
import p530oq.C11990c;
import p557pq.C12206d;
import p640sq.C12824c;
import p640sq.C12831j;
import p640sq.C12835n;
import p640sq.C12836o;
import p687uq.C13236a;
import p715vq.C13479a;

/* renamed from: lq.b */
/* loaded from: classes8.dex */
public final class C11335b {

    /* renamed from: d */
    public static C11335b f53027d;

    /* renamed from: a */
    public SiteDefaultInfo f53028a = new SiteDefaultInfo();

    /* renamed from: b */
    public ArrayList<String> f53029b = new ArrayList<>();

    /* renamed from: c */
    public ArrayList<SiteListInfo> f53030c = new ArrayList<>();

    /* renamed from: lq.b$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f53031a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f53032b;

        public a(Context context, CountDownLatch countDownLatch) {
            this.f53031a = context;
            this.f53032b = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // java.lang.Runnable
        public void run() {
            C12836o.m77097b("SiteCountryDataManager", "start thread innerInit", true);
            try {
                try {
                    C11335b.this.f53029b.clear();
                    C11335b.this.f53030c.clear();
                    C12835n.m77091d(this.f53031a, C11335b.this.f53028a, C11335b.this.f53029b, C11335b.this.f53030c);
                } catch (IOException e10) {
                    C12836o.m77099d("SiteCountryDataManager", "IOException = " + e10.getClass().getSimpleName(), true);
                } catch (XmlPullParserException e11) {
                    C12836o.m77099d("SiteCountryDataManager", "XmlPullParserException = " + e11.getClass().getSimpleName(), true);
                } catch (Exception e12) {
                    C12836o.m77099d("SiteCountryDataManager", "Exception = " + e12.getClass().getSimpleName(), true);
                }
            } finally {
                C12836o.m77099d("SiteCountryDataManager", "finish thread innerInit", true);
                this.f53032b.countDown();
            }
        }
    }

    /* renamed from: g */
    public static synchronized C11335b m68098g() {
        try {
            if (f53027d == null) {
                f53027d = new C11335b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f53027d;
    }

    /* renamed from: a */
    public final synchronized CountryInfoForCFG m68101a(String str, List<CountryInfoForCFG> list) {
        CountryInfoForCFG next;
        Iterator<CountryInfoForCFG> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equalsIgnoreCase(next.m38257d())) {
                break;
            }
        }
        return next;
    }

    /* renamed from: b */
    public synchronized String m68102b(Context context, int i10) {
        return "https://" + m68108j(context, i10);
    }

    /* renamed from: c */
    public final synchronized String m68103c(Context context, String str, String str2, List<CountryInfoForCFG> list, List<SiteInfoForCFG> list2, boolean z10) {
        SiteInfoForCFG siteInfoForCFGM68107i = m68107i(str2, list2);
        if (siteInfoForCFGM68107i == null) {
            C12836o.m77099d("SiteCountryDataManager", "not found the site info by site", true);
            return "";
        }
        if ("1".equals(siteInfoForCFGM68107i.m38271d())) {
            return str;
        }
        if (!z10) {
            return "";
        }
        return m68109k(context, str, list, list2);
    }

    /* renamed from: d */
    public final String m68104d(Context context, String str, List<CountryInfoForCFG> list, List<SiteInfoForCFG> list2) {
        String strM79609a = C13236a.m79608b().m79609a(context);
        if (C11334a.m68093a().m68094b() && !TextUtils.isEmpty(C11334a.m68093a().m68096d())) {
            strM79609a = C11334a.m68093a().m68096d();
        }
        C12836o.m77096a("SiteCountryDataManager", "sim card root MCC is " + strM79609a, false);
        CountryInfoForCFG countryInfoForCFGM68111o = m68111o(strM79609a, list);
        if (countryInfoForCFGM68111o == null) {
            C12836o.m77099d("SiteCountryDataManager", "not found the country by mcc:", true);
            return "";
        }
        String strM38261h = countryInfoForCFGM68111o.m38261h();
        return "1".equals(strM38261h) ? countryInfoForCFGM68111o.m38257d() : TextUtils.isEmpty(strM38261h) ? m68103c(context, countryInfoForCFGM68111o.m38257d(), countryInfoForCFGM68111o.m38255a(), list, list2, false) : "";
    }

    /* renamed from: f */
    public final List<CountryInfoForCFG> m68105f(List<CountryInfoForCFG> list, List<CountryInfoForCFG> list2) {
        ArrayList arrayList = new ArrayList();
        for (CountryInfoForCFG countryInfoForCFG : list) {
            Iterator<CountryInfoForCFG> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList.add(countryInfoForCFG);
                    break;
                }
                CountryInfoForCFG next = it.next();
                if (!TextUtils.isEmpty(countryInfoForCFG.m38257d()) && countryInfoForCFG.m38257d().equals(next.m38257d())) {
                    arrayList.add(next);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public synchronized void m68106h(Context context) {
        boolean zAwait;
        C12836o.m77097b("SiteCountryDataManager", "start countDownLatch innerInit", true);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12206d.m73365d().execute(new a(context, countDownLatch));
        try {
            zAwait = countDownLatch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C12836o.m77099d("SiteCountryDataManager", "InterruptedException", true);
            zAwait = false;
        }
        C12836o.m77097b("SiteCountryDataManager", "end countDownLatch innerInit awaitValue:" + zAwait, true);
    }

    /* renamed from: i */
    public final synchronized SiteInfoForCFG m68107i(String str, List<SiteInfoForCFG> list) {
        SiteInfoForCFG next;
        Iterator<SiteInfoForCFG> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equals(next.m38269a())) {
                break;
            }
        }
        return next;
    }

    /* renamed from: j */
    public final synchronized String m68108j(Context context, int i10) {
        String strM38032j;
        try {
            m68118v(context);
            strM38032j = "";
            if (i10 > 0) {
                Iterator<SiteListInfo> it = this.f53030c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SiteListInfo next = it.next();
                    if (next.m38045a() == i10) {
                        strM38032j = next.m38049l();
                        C12836o.m77097b("SiteCountryDataManager", "find the site id " + i10, true);
                        break;
                    }
                }
                if (TextUtils.isEmpty(strM38032j)) {
                    strM38032j = "";
                    C12831j.m77077a(context);
                }
            } else if (TextUtils.isEmpty("")) {
                strM38032j = this.f53028a.m38032j();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return strM38032j;
    }

    /* renamed from: k */
    public final String m68109k(Context context, String str, List<CountryInfoForCFG> list, List<SiteInfoForCFG> list2) {
        String strM79609a = C13236a.m79608b().m79609a(context);
        if (C11334a.m68093a().m68094b() && !TextUtils.isEmpty(C11334a.m68093a().m68096d())) {
            strM79609a = C11334a.m68093a().m68096d();
        }
        C12836o.m77096a("SiteCountryDataManager", "sim card root MCC is " + strM79609a, false);
        CountryInfoForCFG countryInfoForCFGM68111o = m68111o(strM79609a, list);
        if (countryInfoForCFGM68111o != null) {
            String strM38261h = countryInfoForCFGM68111o.m38261h();
            return "1".equals(strM38261h) ? countryInfoForCFGM68111o.m38257d() : TextUtils.isEmpty(strM38261h) ? m68103c(context, countryInfoForCFGM68111o.m38257d(), countryInfoForCFGM68111o.m38255a(), list, list2, false) : "";
        }
        C12836o.m77099d("SiteCountryDataManager", "not found the country by mcc:" + str, false);
        return "";
    }

    /* renamed from: l */
    public synchronized ArrayList<String> m68110l(Context context) {
        m68118v(context);
        C12836o.m77097b("SiteCountryDataManager", "get allow list from file.", true);
        return this.f53029b;
    }

    /* renamed from: o */
    public final synchronized CountryInfoForCFG m68111o(String str, List<CountryInfoForCFG> list) {
        CountryInfoForCFG next;
        Iterator<CountryInfoForCFG> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equalsIgnoreCase(next.m38259f())) {
                break;
            }
        }
        return next;
    }

    /* renamed from: p */
    public ArrayList<String> m68112p(Context context) {
        ArrayList<String> arrayListM68110l = m68110l(context);
        return arrayListM68110l == null ? new ArrayList<>(0) : arrayListM68110l;
    }

    /* renamed from: q */
    public synchronized String m68113q(Context context) {
        m68118v(context);
        String strM38028a = this.f53028a.m38028a();
        C12836o.m77097b("SiteCountryDataManager", "getLogOutUrl::=" + strM38028a, false);
        if (TextUtils.isEmpty(strM38028a)) {
            return "";
        }
        return "https://" + strM38028a + "/logout";
    }

    /* renamed from: r */
    public synchronized String m68114r(Context context) {
        String str;
        try {
            m68118v(context);
            int iM72134a = C11990c.m72144k(context).m72134a("siteID", -1);
            String strM68108j = iM72134a != -1 ? m68108j(context, iM72134a) : this.f53028a.m38032j();
            if (TextUtils.isEmpty(strM68108j)) {
                str = "";
            } else {
                str = "https://" + strM68108j + "/AMW/mobile/delUser.html";
            }
        } finally {
        }
        return str;
    }

    /* renamed from: s */
    public synchronized String m68115s(Context context) {
        String str;
        try {
            m68118v(context);
            int iM72134a = C11990c.m72144k(context).m72134a("siteID", -1);
            String strM68108j = iM72134a != -1 ? m68108j(context, iM72134a) : this.f53028a.m38032j();
            if (TextUtils.isEmpty(strM68108j)) {
                str = "";
            } else {
                str = "https://" + strM68108j + "/AMW/mobile/appealSelf/bindNewFinish.html";
            }
        } finally {
        }
        return str;
    }

    /* renamed from: t */
    public synchronized String m68116t(Context context) {
        m68118v(context);
        String strM38030g = this.f53028a.m38030g();
        C12836o.m77097b("SiteCountryDataManager", "getQrAuthUrl::=" + strM38030g, false);
        if (TextUtils.isEmpty(strM38030g)) {
            return "";
        }
        return "https://" + strM38030g + "/CAS/mobile/loginHmsSuccess.html";
    }

    /* renamed from: u */
    public synchronized String m68117u(Context context) {
        try {
            String strM77000c = C12824c.m77000c(context);
            if (C11334a.m68093a().m68094b() && !TextUtils.isEmpty(C11334a.m68093a().m68095c())) {
                strM77000c = C11334a.m68093a().m68095c();
            }
            String str = strM77000c;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            C13479a.m81158b().m81159a(context, arrayList, arrayList2, arrayList3);
            List<CountryInfoForCFG> listM68105f = m68105f(arrayList, arrayList2);
            CountryInfoForCFG countryInfoForCFGM68101a = m68101a(str, listM68105f);
            if (countryInfoForCFGM68101a == null) {
                return m68104d(context, str, listM68105f, arrayList3);
            }
            String strM38261h = countryInfoForCFGM68101a.m38261h();
            if ("1".equals(strM38261h)) {
                return str;
            }
            if (TextUtils.isEmpty(strM38261h)) {
                return m68103c(context, str, countryInfoForCFGM68101a.m38255a(), listM68105f, arrayList3, true);
            }
            return m68109k(context, str, listM68105f, arrayList3);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: v */
    public final synchronized void m68118v(Context context) {
        if (this.f53029b.isEmpty()) {
            C12836o.m77097b("SiteCountryDataManager", "inner update.", true);
            m68106h(context);
        }
    }
}
