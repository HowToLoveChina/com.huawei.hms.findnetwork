package p640sq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.embedded.C6132w;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.webview.SafeWebView;
import hu.C10343b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mq.C11504a;
import mq.C11505b;
import mu.C11526c;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p432kq.C11129a;
import p432kq.C11142n;
import p432kq.C11143o;
import p530oq.C11988a;
import p557pq.C12203a;
import p557pq.C12205c;
import p587qq.AbstractC12388f;
import p587qq.C12385c;
import p621rq.C12617c;

/* renamed from: sq.f */
/* loaded from: classes8.dex */
public class C12827f {

    /* renamed from: e */
    @SuppressLint({"StaticFieldLeak"})
    public static C12827f f58556e;

    /* renamed from: a */
    public Context f58557a;

    /* renamed from: b */
    public String f58558b = "";

    /* renamed from: c */
    public boolean f58559c = false;

    /* renamed from: d */
    public ArrayList<C11504a> f58560d = new ArrayList<>();

    /* renamed from: sq.f$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f58561a;

        public a(String str) {
            this.f58561a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            C12830i.m77071e(C12827f.this.f58557a.getFilesDir().getAbsolutePath() + "/", "configuration.xml", C12824c.m77005h(this.f58561a));
        }
    }

    /* renamed from: sq.f$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C12827f.this.m77044o(null);
        }
    }

    /* renamed from: sq.f$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12388f.d f58564a;

        /* renamed from: sq.f$c$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ CountDownLatch f58566a;

            public a(CountDownLatch countDownLatch) {
                this.f58566a = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM77052x;
                try {
                    strM77052x = C12827f.this.m77052x();
                } catch (Exception e10) {
                    C12836o.m77099d(C5963j.f27039h, "Exception:" + e10.getClass().getSimpleName(), true);
                }
                if (TextUtils.isEmpty(strM77052x)) {
                    C12836o.m77099d(C5963j.f27039h, "getConfigurationData readConfigurationFile is failed.", true);
                    this.f58566a.countDown();
                } else {
                    C12827f.this.m77037d(C11143o.m67047a(strM77052x.getBytes(Constants.UTF_8)));
                    this.f58566a.countDown();
                }
            }
        }

        public c(AbstractC12388f.d dVar) {
            this.f58564a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C12205c.m73363d().execute(new a(countDownLatch));
            try {
                boolean zAwait = countDownLatch.await(3L, TimeUnit.SECONDS);
                C12836o.m77097b(C5963j.f27039h, "getConfigurationData awaitValue:" + zAwait, true);
                if (zAwait && this.f58564a != null && !C12825d.m77024a(C12827f.this.f58560d).booleanValue()) {
                    C12827f.this.m77048t(this.f58564a);
                    return;
                }
                AbstractC12388f.d dVar = this.f58564a;
                if (dVar != null) {
                    C12827f.this.m77040g(dVar, 2015, "read file timeout or config data list empty.");
                }
            } catch (InterruptedException unused) {
                C12836o.m77099d(C5963j.f27039h, "getConfigurationData InterruptedException.", true);
                AbstractC12388f.d dVar2 = this.f58564a;
                if (dVar2 != null) {
                    C12827f.this.m77040g(dVar2, 2015, "read file exception.");
                }
            }
        }
    }

    /* renamed from: sq.f$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12388f.d f58568a;

        public d(AbstractC12388f.d dVar) {
            this.f58568a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f58568a.mo38164a(new C10343b());
        }
    }

    /* renamed from: sq.f$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12388f.d f58570a;

        /* renamed from: b */
        public final /* synthetic */ int f58571b;

        /* renamed from: c */
        public final /* synthetic */ String f58572c;

        public e(AbstractC12388f.d dVar, int i10, String str) {
            this.f58570a = dVar;
            this.f58571b = i10;
            this.f58572c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f58570a.mo38163a(this.f58571b, this.f58572c);
        }
    }

    public C12827f(Context context) {
        this.f58557a = context;
    }

    /* renamed from: c */
    public static C12827f m77030c(Context context) {
        if (f58556e == null) {
            f58556e = new C12827f(context);
        }
        return f58556e;
    }

    /* renamed from: b */
    public synchronized String m77036b(String str) {
        if (!C12825d.m77024a(this.f58560d).booleanValue()) {
            String strM77043m = m77043m(str);
            return TextUtils.isEmpty(strM77043m) ? "ERROR" : strM77043m;
        }
        this.f58558b = "";
        C12836o.m77099d(C5963j.f27039h, "mConfigDataList is empty.", true);
        return "ERROR";
    }

    /* renamed from: d */
    public final void m77037d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType == 2) {
                if ("dataVer".equals(name)) {
                    this.f58558b = xmlPullParser.nextText();
                    C12836o.m77097b(C5963j.f27039h, "Response mResponseTimestamp = " + this.f58558b, true);
                } else if ("Country".equals(name)) {
                    m77047s(xmlPullParser.getAttributeValue(null, "name"));
                } else if ("Config".equals(name)) {
                    if (C11142n.m67046a(xmlPullParser.getAttributeValue(null, "size")) > 0) {
                        this.f58559c = true;
                    }
                } else if (this.f58559c) {
                    if (C12825d.m77024a(this.f58560d).booleanValue()) {
                        C12836o.m77099d(C5963j.f27039h, "arrConfigData is empty", true);
                    } else {
                        this.f58560d.get(0).m68677b(new C11505b(xmlPullParser.getName(), xmlPullParser.nextText()));
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: e */
    public synchronized void m77038e(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        C12836o.m77099d(C5963j.f27039h, "saveConfigurationFromServer.", true);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C12205c.m73363d().execute(new a(str));
        m77037d(xmlPullParser);
    }

    /* renamed from: f */
    public void m77039f(AbstractC12388f.d dVar) {
        C12203a.m73358d().execute(new c(dVar));
    }

    /* renamed from: g */
    public final void m77040g(AbstractC12388f.d dVar, int i10, String str) {
        new Handler(this.f58557a.getMainLooper()).post(new e(dVar, i10, str));
    }

    /* renamed from: k */
    public boolean m77041k() {
        return !C12825d.m77024a(this.f58560d).booleanValue();
    }

    /* renamed from: l */
    public synchronized boolean m77042l(String str, String str2, SafeWebView safeWebView) {
        String[] whitelistNotMatchSubDomain;
        boolean zM68808e;
        try {
            String strM77036b = m77036b("sceneOfJS");
            String strM77036b2 = m77036b("webviewWhiteListForJS");
            boolean z10 = TextUtils.isEmpty(strM77036b2) || strM77036b2.equals(C6132w.f28814j) || strM77036b2.equals("ERROR");
            boolean z11 = TextUtils.isEmpty(strM77036b) || strM77036b.equals(C6132w.f28814j) || strM77036b.equals("ERROR");
            boolean z12 = !m77030c(this.f58557a).m77045p();
            if (z10 || z11 || z12) {
                C12836o.m77097b(C5963j.f27039h, "sceneOfJS is: " + strM77036b + ", webviewAllowListForJS is: " + strM77036b2, true);
                whitelistNotMatchSubDomain = safeWebView.getWhitelistNotMatchSubDomain();
                if (whitelistNotMatchSubDomain == null) {
                    C12836o.m77097b(C5963j.f27039h, str + " get allowlist failed, match result: false", true);
                    return false;
                }
                zM68808e = C11526c.m68808e(str2, whitelistNotMatchSubDomain);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(strM77036b);
                    JSONObject jSONObject2 = new JSONObject(strM77036b2);
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray((String) jSONArray.get(i10));
                        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                            arrayList.add((String) jSONArray2.get(i11));
                        }
                    }
                    whitelistNotMatchSubDomain = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    if (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) {
                        C12836o.m77097b(C5963j.f27039h, str + " second allowlist is null, match by first allowlist.", true);
                        whitelistNotMatchSubDomain = safeWebView.getWhitelistNotMatchSubDomain();
                        zM68808e = C11526c.m68808e(str2, whitelistNotMatchSubDomain);
                    } else {
                        List listAsList = Arrays.asList(str2.split("//")[1].split("/"));
                        zM68808e = C11526c.m68806c(((String) listAsList.get(0)) + "/" + ((String) listAsList.get(1)), whitelistNotMatchSubDomain);
                    }
                } catch (Exception e10) {
                    C12836o.m77099d(C5963j.f27039h, "Exception:" + e10.getClass().getSimpleName(), true);
                    return false;
                }
            }
            C12836o.m77097b(C5963j.f27039h, "allowlist size: " + whitelistNotMatchSubDomain.length, true);
            C12836o.m77097b(C5963j.f27039h, "allowlist: " + Arrays.toString(whitelistNotMatchSubDomain), false);
            C12836o.m77097b(C5963j.f27039h, str + " allowlist match result: " + zM68808e, true);
            return zM68808e;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: m */
    public final String m77043m(String str) {
        if (!C12825d.m77024a(this.f58560d).booleanValue() && !TextUtils.isEmpty(str)) {
            Iterator<C11504a> it = this.f58560d.iterator();
            while (it.hasNext()) {
                C11504a next = it.next();
                if (next != null && C6132w.f28814j.equalsIgnoreCase(next.m68676a())) {
                    Iterator<C11505b> it2 = next.m68678c().iterator();
                    while (it2.hasNext()) {
                        C11505b next2 = it2.next();
                        if (next2 != null && str.equalsIgnoreCase(next2.m68680a())) {
                            return next2.m68681b();
                        }
                    }
                }
            }
        }
        return "";
    }

    /* renamed from: o */
    public void m77044o(AbstractC12388f.d dVar) {
        String strM76133q = C12617c.m76132p().m76133q();
        if (TextUtils.isEmpty(strM76133q)) {
            C12836o.m77099d(C5963j.f27039h, "getResourceUrl is null.", true);
            if (dVar != null) {
                dVar.mo38163a(2015, "getResourceUrl is null.");
                return;
            }
            return;
        }
        C11129a c11129a = new C11129a(C6132w.f28814j, "", m77049u(), this.f58557a);
        new C12385c(c11129a, this.f58557a, strM76133q + c11129a.mo38002d(), new f(dVar)).m74452a();
    }

    /* renamed from: p */
    public boolean m77045p() {
        return C12830i.m77073g(this.f58557a.getFilesDir().getAbsolutePath() + "/configuration.xml");
    }

    /* renamed from: r */
    public synchronized void m77046r() {
        C12836o.m77097b(C5963j.f27039h, "Enter saveConfigurationTimestamp", true);
        C11988a.m72133k(this.f58557a).m72141h("configurationLastUpdate", System.currentTimeMillis());
    }

    /* renamed from: s */
    public final void m77047s(String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b(C5963j.f27039h, "countryCode is empty", true);
        } else {
            m77053y();
            this.f58560d.add(new C11504a(str));
        }
    }

    /* renamed from: t */
    public final void m77048t(AbstractC12388f.d dVar) {
        new Handler(this.f58557a.getMainLooper()).post(new d(dVar));
    }

    /* renamed from: u */
    public synchronized String m77049u() {
        try {
            if (C12825d.m77024a(this.f58560d).booleanValue()) {
                this.f58558b = "";
                m77039f(null);
            }
            C12836o.m77097b(C5963j.f27039h, "getConfigurationTimeStampFromServer Timestamp:" + this.f58558b, false);
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f58558b;
    }

    /* renamed from: v */
    public void m77050v() {
        if (m77051w()) {
            C12836o.m77097b(C5963j.f27039h, "over one day, then update configuration.xml from server.", true);
            C12203a.m73358d().execute(new b());
        }
    }

    /* renamed from: w */
    public final boolean m77051w() {
        if (AccountPickerUtil.isPhoneStillInLockMode(this.f58557a)) {
            return false;
        }
        if (m77045p()) {
            return Math.abs(System.currentTimeMillis() - C11988a.m72133k(this.f58557a).m72135b("configurationLastUpdate", 0L)) > (((long) C12842u.m77122a().nextInt(1000)) * 3600) + 86400000;
        }
        return true;
    }

    /* renamed from: x */
    public final String m77052x() throws IOException {
        return C12830i.m77074h(this.f58557a.getFilesDir().getCanonicalPath() + "/configuration.xml");
    }

    /* renamed from: y */
    public final void m77053y() {
        if (C12825d.m77025b(this.f58560d).booleanValue()) {
            for (int i10 = 0; i10 < this.f58560d.size(); i10++) {
                C11504a c11504a = this.f58560d.get(i10);
                if (c11504a != null) {
                    c11504a.m68679d();
                }
            }
        }
        ArrayList<C11504a> arrayList = this.f58560d;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: sq.f$f */
    public class f implements AbstractC12388f.d {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12388f.d f58574a;

        public f(AbstractC12388f.d dVar) {
            this.f58574a = dVar;
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38164a(C10343b c10343b) {
            AbstractC12388f.d dVar = this.f58574a;
            if (dVar != null) {
                dVar.mo38164a(c10343b);
            }
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38163a(int i10, String str) {
            AbstractC12388f.d dVar = this.f58574a;
            if (dVar != null) {
                dVar.mo38163a(i10, str);
            }
        }
    }
}
