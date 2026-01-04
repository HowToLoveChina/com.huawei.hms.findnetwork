package p588qr;

import android.text.TextUtils;
import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigResponseData;
import com.huawei.location.lite.common.http.HttpClientEx;
import es.C9540e;
import es.C9542g;
import es.C9549n;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p235ds.C9302c;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import p785xr.C13853c;

/* renamed from: qr.b */
/* loaded from: classes8.dex */
public class C12390b {

    /* renamed from: a */
    public AtomicInteger f57219a;

    /* renamed from: b */
    public long f57220b;

    /* renamed from: c */
    public HashMap<String, String> f57221c;

    /* renamed from: qr.b$a */
    public static class a {

        /* renamed from: a */
        public static final C12390b f57222a = new C12390b();
    }

    public C12390b() {
        this.f57219a = new AtomicInteger(0);
    }

    /* renamed from: g */
    public static C12390b m74456g() {
        return a.f57222a;
    }

    /* renamed from: i */
    public static /* synthetic */ String m74457i() throws Exception {
        StringBuilder sb2;
        String strM79632d;
        String string;
        try {
            C13853c.a aVarM83159d = new C13853c.a().m83159d("groupName", "liteSDK");
            return C9542g.m59588a().toJson(((ConfigResponseData) new HttpClientEx().m38437a(new C13851a.a("/networklocation/v1/configurations").m83146p(new C13852b(String.valueOf(UUID.randomUUID()))).m83144n(aVarM83159d.m83160e()).m83141k()).mo38439b(ConfigResponseData.class)).getData());
        } catch (Exception unused) {
            string = "OnException:";
            C1016d.m6183c(C5963j.f27039h, string);
            return null;
        } catch (C13244d e10) {
            sb2 = new StringBuilder("OnErrorException:code:");
            sb2.append(e10.m79628b().f59923a);
            sb2.append(",apiCode:");
            sb2.append(e10.m79631c());
            sb2.append(",apiMsg:");
            strM79632d = e10.m79632d();
            sb2.append(strM79632d);
            string = sb2.toString();
            C1016d.m6183c(C5963j.f27039h, string);
            return null;
        } catch (C13245e e11) {
            sb2 = new StringBuilder("OnFailureException:");
            sb2.append(e11.m79628b().f59923a);
            sb2.append(",");
            strM79632d = e11.m79628b().f59924b;
            sb2.append(strM79632d);
            string = sb2.toString();
            C1016d.m6183c(C5963j.f27039h, string);
            return null;
        }
    }

    /* renamed from: b */
    public final boolean m74458b(C9549n c9549n) {
        long jM59623a = c9549n.m59623a("KEY_CACHE_TIME");
        return jM59623a == -1 || System.currentTimeMillis() > jM59623a + 86400000;
    }

    /* renamed from: c */
    public final void m74459c() {
        C9549n c9549n = new C9549n("com.huawei.hms.location.config");
        if (m74458b(c9549n)) {
            this.f57221c = null;
        } else {
            m74464j(c9549n);
            if (this.f57221c != null) {
                return;
            } else {
                C1016d.m6183c(C5963j.f27039h, "load cache config fail ,reload config from network");
            }
        }
        m74466l();
    }

    /* renamed from: d */
    public synchronized <T extends ConfigBaseResponse> T m74460d(String str, Class<T> cls) {
        String str2;
        String str3;
        C1016d.m6186f(C5963j.f27039h, Thread.currentThread().getName() + ",request itemName:" + str);
        m74459c();
        HashMap<String, String> map = this.f57221c;
        if (map == null) {
            return null;
        }
        String str4 = map.get(str);
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        try {
            return (T) C9542g.m59588a().fromJson(str4, (Class) cls);
        } catch (JsonSyntaxException unused) {
            str2 = C5963j.f27039h;
            str3 = "getConfig failed";
            C1016d.m6183c(str2, str3);
            return null;
        } catch (Exception unused2) {
            str2 = C5963j.f27039h;
            str3 = "getConfig Exception";
            C1016d.m6183c(str2, str3);
            return null;
        }
    }

    /* renamed from: e */
    public synchronized String m74461e(String str) {
        C1016d.m6186f(C5963j.f27039h, Thread.currentThread().getName() + ",request itemName:" + str);
        m74459c();
        HashMap<String, String> map = this.f57221c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: f */
    public synchronized String m74462f(String str, String str2) {
        String str3;
        String str4;
        m74459c();
        HashMap<String, String> map = this.f57221c;
        String strValueOf = null;
        if (map == null) {
            return null;
        }
        String str5 = map.get(str);
        if (TextUtils.isEmpty(str5)) {
            return null;
        }
        try {
            strValueOf = String.valueOf(new JSONObject(str5).get(str2));
        } catch (JSONException unused) {
            str3 = C5963j.f27039h;
            str4 = "json parse failed";
            C1016d.m6183c(str3, str4);
            C1016d.m6181a(C5963j.f27039h, "key=" + str2 + ",value=" + strValueOf);
            return strValueOf;
        } catch (Exception unused2) {
            str3 = C5963j.f27039h;
            str4 = "json parse Exception";
            C1016d.m6183c(str3, str4);
            C1016d.m6181a(C5963j.f27039h, "key=" + str2 + ",value=" + strValueOf);
            return strValueOf;
        }
        C1016d.m6181a(C5963j.f27039h, "key=" + str2 + ",value=" + strValueOf);
        return strValueOf;
    }

    /* renamed from: h */
    public final void m74463h(String str) throws JSONException {
        String str2;
        JSONArray jSONArray = new JSONArray(str);
        this.f57221c = new HashMap<>();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                C12391c c12391c = (C12391c) C9542g.m59588a().fromJson(jSONArray.getString(i10), C12391c.class);
                this.f57221c.put(c12391c.m74469a(), c12391c.m74470b());
            } catch (JsonSyntaxException unused) {
                str2 = "jsonArray2Map failed";
                C1016d.m6183c(C5963j.f27039h, str2);
            } catch (Exception unused2) {
                str2 = "jsonArray2Map Exception";
                C1016d.m6183c(C5963j.f27039h, str2);
            }
        }
    }

    /* renamed from: j */
    public final void m74464j(C9549n c9549n) {
        String str;
        String str2;
        if (this.f57221c != null) {
            return;
        }
        String strM59624b = c9549n.m59624b("KEY_CONFIG_DATA");
        if (TextUtils.isEmpty(strM59624b)) {
            str2 = "load cache config empty";
        } else {
            String strMo38472a = new C9302c(3).mo38472a(strM59624b, "LOCATION_LITE_SDK");
            if (!TextUtils.isEmpty(strMo38472a)) {
                try {
                    this.f57221c = (HashMap) C9542g.m59588a().fromJson(strMo38472a, HashMap.class);
                    return;
                } catch (JsonSyntaxException unused) {
                    str = "load config jsonSyntax failed";
                    C1016d.m6183c(C5963j.f27039h, str);
                    return;
                } catch (Exception unused2) {
                    str = "load config Exception";
                    C1016d.m6183c(C5963j.f27039h, str);
                    return;
                }
            }
            str2 = "load config decrypt failed";
        }
        C1016d.m6183c(C5963j.f27039h, str2);
    }

    /* renamed from: k */
    public String m74465k() {
        String str;
        FutureTask futureTask = new FutureTask(new Callable() { // from class: qr.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C12390b.m74457i();
            }
        });
        C9540e.m59581d().m59583b(futureTask);
        try {
            return (String) futureTask.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            str = "task get response failed by interrupt";
            C1016d.m6183c(C5963j.f27039h, str);
            return null;
        } catch (ExecutionException unused2) {
            str = "task get response failed by execution";
            C1016d.m6183c(C5963j.f27039h, str);
            return null;
        } catch (TimeoutException unused3) {
            futureTask.cancel(true);
            str = "task get response failed by timeOut";
            C1016d.m6183c(C5963j.f27039h, str);
            return null;
        }
    }

    /* renamed from: l */
    public synchronized void m74466l() {
        C1016d.m6181a(C5963j.f27039h, "requestConfigSync start");
        if (System.currentTimeMillis() - this.f57220b < C5863b6.g.f26453g && this.f57219a.get() >= 3) {
            C1016d.m6181a(C5963j.f27039h, "requestConfigSync failed max count");
            return;
        }
        if (this.f57219a.get() == 3) {
            this.f57219a.set(0);
        }
        if (this.f57221c != null) {
            C1016d.m6183c(C5963j.f27039h, "configCache is init");
            return;
        }
        try {
            String strM74465k = m74465k();
            if (!TextUtils.isEmpty(strM74465k)) {
                m74463h(strM74465k);
                m74467m(C9542g.m59588a().toJson(this.f57221c));
                this.f57219a.set(0);
                this.f57220b = 0L;
            } else if (this.f57219a.incrementAndGet() == 1) {
                this.f57220b = System.currentTimeMillis();
            }
        } catch (JSONException unused) {
            C1016d.m6183c(C5963j.f27039h, "JSONException");
            this.f57219a.incrementAndGet();
            if (this.f57220b == 0) {
                this.f57220b = System.currentTimeMillis();
            }
        } catch (Exception unused2) {
            C1016d.m6183c(C5963j.f27039h, "requestConfigSync Exception");
            this.f57219a.incrementAndGet();
            if (this.f57220b == 0) {
                this.f57220b = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: m */
    public final void m74467m(String str) {
        String strMo38473b = new C9302c(3).mo38473b(str, "LOCATION_LITE_SDK");
        if (TextUtils.isEmpty(strMo38473b)) {
            C1016d.m6183c(C5963j.f27039h, "save config to storage fail");
            return;
        }
        C9549n c9549n = new C9549n("com.huawei.hms.location.config");
        c9549n.m59627e("KEY_CONFIG_DATA", strMo38473b);
        c9549n.m59626d("KEY_CACHE_TIME", System.currentTimeMillis());
        C1016d.m6186f(C5963j.f27039h, "save config to storage end");
    }

    public /* synthetic */ C12390b(b bVar) {
        this();
    }
}
