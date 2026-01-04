package vn;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13230i;
import vn.C13471c;

/* renamed from: vn.a */
/* loaded from: classes6.dex */
public class C13469a {

    /* renamed from: vn.a$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public String f60665a;

        /* renamed from: b */
        public String f60666b;

        /* renamed from: c */
        public String f60667c;

        /* renamed from: d */
        public String f60668d;

        /* renamed from: e */
        public LinkedHashMap<String, String> f60669e = new LinkedHashMap<>();

        /* renamed from: f */
        public boolean f60670f;

        /* renamed from: g */
        public boolean f60671g;

        /* renamed from: h */
        public boolean f60672h;

        public b(String str, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap, boolean z10, boolean z11, boolean z12) {
            this.f60665a = str;
            this.f60666b = str2;
            this.f60667c = str3;
            this.f60668d = str4;
            if (linkedHashMap != null) {
                try {
                    if (linkedHashMap.size() > 0) {
                        this.f60669e.putAll(linkedHashMap);
                    }
                } catch (Exception e10) {
                    AbstractC10896a.m65886e("AnalyzeCache", "putAll exception: " + e10.toString());
                }
            }
            this.f60670f = z10;
            this.f60671g = z11;
            this.f60672h = z12;
        }

        /* renamed from: c */
        public final JSONObject m81121c() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("e", this.f60665a);
                jSONObject.put("t", System.currentTimeMillis());
                jSONObject2.put("u", this.f60666b);
                if (!TextUtils.isEmpty(this.f60667c)) {
                    jSONObject2.put("tp", this.f60667c);
                }
                if (!TextUtils.isEmpty(this.f60668d)) {
                    jSONObject2.put("chl", this.f60668d);
                }
                LinkedHashMap<String, String> linkedHashMap = this.f60669e;
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    jSONObject2.put("ex", new JSONObject(this.f60669e));
                }
                jSONObject.put(Constants.MULTIPLE_SIGN, jSONObject2);
            } catch (Exception e10) {
                BaseLogger.m28733i("AnalyzeCache", "generateJSONObject exception: " + e10.toString());
            }
            return jSONObject;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            m81122d(m81121c());
        }

        /* JADX WARN: Removed duplicated region for block: B:168:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:174:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:186:? A[SYNTHETIC] */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m81122d(org.json.JSONObject r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 394
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: vn.C13469a.b.m81122d(org.json.JSONObject):void");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ANALYZE_CACHE;
        }
    }

    /* renamed from: vn.a$c */
    public static class c {

        /* renamed from: a */
        public static C13469a f60673a = new C13469a();
    }

    /* renamed from: vn.a$d */
    public static class d extends AbstractC12367d {

        /* renamed from: a */
        public boolean f60674a;

        /* renamed from: b */
        public boolean f60675b;

        /* renamed from: c */
        public boolean f60676c;

        public d(boolean z10, boolean z11, boolean z12) {
            this.f60674a = z10;
            this.f60675b = z11;
            this.f60676c = z12;
        }

        private void report() throws Throwable {
            Throwable th2;
            Exception exc;
            StringBuilder sb2;
            JSONObject jSONObject;
            String str;
            String str2 = "ex";
            BufferedReader bufferedReader = null;
            try {
                try {
                    String strM81117e = C13469a.m81112f().m81117e(this.f60674a, this.f60675b, this.f60676c);
                    if (TextUtils.isEmpty(strM81117e)) {
                        return;
                    }
                    File file = new File(C0213f.m1378b().getFilesDir() + strM81117e);
                    if (!file.exists()) {
                        AbstractC10896a.m65886e("AnalyzeCache", "cache file not exist");
                        return;
                    }
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (Exception e10) {
                                    exc = e10;
                                    sb2 = new StringBuilder();
                                    sb2.append("report close bufferedReader exception: ");
                                    sb2.append(exc.toString());
                                    AbstractC10896a.m65886e("AnalyzeCache", sb2.toString());
                                    return;
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject(line);
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(Constants.MULTIPLE_SIGN);
                            String string = jSONObject3.getString("u");
                            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                            if (!jSONObject3.isNull(str2) && (jSONObject = jSONObject3.getJSONObject(str2)) != null) {
                                Iterator<String> itKeys = jSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    if (TextUtils.isEmpty(next)) {
                                        str = str2;
                                    } else {
                                        str = str2;
                                        linkedHashMap.put(next, jSONObject.getString(next));
                                    }
                                    str2 = str;
                                }
                            }
                            String str3 = str2;
                            if (this.f60674a) {
                                C13230i.m79504I().m79567R(string, linkedHashMap);
                            } else if (this.f60675b) {
                                C13230i.m79504I().m79573U(string, linkedHashMap);
                            } else if (this.f60676c) {
                                UBAAnalyze.m29953N(!jSONObject2.isNull("e") ? jSONObject2.getString("e") : "", !jSONObject2.isNull("t") ? jSONObject2.getLong("t") : 0L, string, !jSONObject3.isNull("tp") ? jSONObject3.getString("tp") : "", !jSONObject3.isNull("chl") ? jSONObject3.getString("chl") : "", linkedHashMap);
                            }
                            str2 = str3;
                        } catch (Exception e11) {
                            e = e11;
                            bufferedReader = bufferedReader2;
                            AbstractC10896a.m65886e("AnalyzeCache", "report exception: " + e.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (Exception e12) {
                                    exc = e12;
                                    sb2 = new StringBuilder();
                                    sb2.append("report close bufferedReader exception: ");
                                    sb2.append(exc.toString());
                                    AbstractC10896a.m65886e("AnalyzeCache", sb2.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            th2 = th3;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader == null) {
                                throw th2;
                            }
                            try {
                                bufferedReader.close();
                                throw th2;
                            } catch (Exception e13) {
                                AbstractC10896a.m65886e("AnalyzeCache", "report close bufferedReader exception: " + e13.toString());
                                throw th2;
                            }
                        }
                    }
                } catch (Exception e14) {
                    e = e14;
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
        }

        /* renamed from: c */
        public final void m81124c(boolean z10, boolean z11, boolean z12) {
            try {
                String strM81117e = C13469a.m81112f().m81117e(z10, z11, z12);
                if (TextUtils.isEmpty(strM81117e)) {
                    return;
                }
                File file = new File(C0213f.m1378b().getFilesDir() + strM81117e);
                if (file.exists() && !file.delete()) {
                    AbstractC10896a.m65886e("AnalyzeCache", "clean, delete cache file error");
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("AnalyzeCache", "clean, exception: " + e10.toString());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            report();
            m81124c(this.f60674a, this.f60675b, this.f60676c);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ANALYZE_CACHE;
        }
    }

    public /* synthetic */ C13469a(a aVar) {
        this();
    }

    /* renamed from: f */
    public static C13469a m81112f() {
        return c.f60673a;
    }

    /* renamed from: a */
    public void m81113a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C12515a.m75110o().m75175e(new b("", str, "", "", linkedHashMap, true, false, false), false);
    }

    /* renamed from: b */
    public void m81114b(String str, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        C12515a.m75110o().m75175e(new b(str, str2, str3, str4, linkedHashMap, false, false, true), false);
    }

    /* renamed from: c */
    public final void m81115c(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                AbstractC10896a.m65886e("AnalyzeCache", "clean, delete cache file error");
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("AnalyzeCache", "clean, exception: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void m81116d() {
        try {
            Context contextM1378b = C0213f.m1378b();
            m81115c(contextM1378b.getFilesDir() + C13471c.g.f60691a);
            m81115c(contextM1378b.getFilesDir() + C13471c.g.f60692b);
            m81115c(contextM1378b.getFilesDir() + C13471c.g.f60693c);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("AnalyzeCache", "clean, exception: " + e10.toString());
        }
    }

    /* renamed from: e */
    public String m81117e(boolean z10, boolean z11, boolean z12) {
        return z10 ? C13471c.g.f60691a : z11 ? C13471c.g.f60692b : z12 ? C13471c.g.f60693c : "";
    }

    /* renamed from: g */
    public void m81118g() {
        BaseLogger.m28733i("AnalyzeCache", "reportBI");
        C12515a.m75110o().m75175e(new d(true, false, false), false);
    }

    /* renamed from: h */
    public void m81119h() {
        BaseLogger.m28733i("AnalyzeCache", "reportOM");
        C12515a.m75110o().m75175e(new d(false, true, false), false);
    }

    /* renamed from: i */
    public void m81120i() {
        BaseLogger.m28733i("AnalyzeCache", "reportUBA");
        C12515a.m75110o().m75175e(new d(false, false, true), false);
    }

    public C13469a() {
    }
}
