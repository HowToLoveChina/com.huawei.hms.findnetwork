package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.core.C6224b;
import com.huawei.hms.network.file.core.util.FLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.file.a.h */
/* loaded from: classes8.dex */
public class C6192h {

    /* renamed from: c */
    private static final C6192h f29288c = new C6192h();

    /* renamed from: a */
    public Map<String, b> f29289a = new HashMap();

    /* renamed from: b */
    public Map<String, b> f29290b = new HashMap();

    /* renamed from: com.huawei.hms.network.file.a.h$a */
    public class a {

        /* renamed from: a */
        long f29291a;

        /* renamed from: b */
        long f29292b;

        public a(C6192h c6192h, long j10, long j11) {
            this.f29291a = j10;
            this.f29292b = j11;
        }

        public String toString() {
            return "FileSize{minFileSize=" + this.f29291a + ", maxFileSize=" + this.f29292b + '}';
        }
    }

    /* renamed from: com.huawei.hms.network.file.a.h$b */
    public class b {

        /* renamed from: a */
        int f29293a;

        /* renamed from: b */
        a[] f29294b;

        public b(int i10) {
            this.f29293a = i10;
            this.f29294b = new a[i10];
        }

        /* renamed from: a */
        public void m36057a(int i10, long j10, long j11) {
            this.f29294b[i10] = new a(C6192h.this, j10, j11);
        }
    }

    private C6192h() {
    }

    /* renamed from: f */
    public static C6192h m36048f() {
        return f29288c;
    }

    /* renamed from: a */
    public String m36049a(int i10, long j10) {
        if (i10 == 0) {
            for (String str : this.f29289a.keySet()) {
                if (m36046a(i10, j10, str)) {
                    return str;
                }
            }
            return "";
        }
        for (String str2 : this.f29290b.keySet()) {
            if (m36046a(i10, j10, str2)) {
                return str2;
            }
        }
        return "";
    }

    /* renamed from: b */
    public boolean m36053b() {
        return this.f29289a.containsKey("h2") || this.f29290b.containsKey("h2");
    }

    /* renamed from: c */
    public boolean m36054c() {
        return this.f29289a.containsKey("h3_pcc_multipath") || this.f29290b.containsKey("h3_pcc_multipath");
    }

    /* renamed from: d */
    public boolean m36055d() {
        return this.f29289a.containsKey("h3_pcc") || this.f29290b.containsKey("h3_pcc");
    }

    /* renamed from: e */
    public void m36056e() {
        try {
            JSONObject jSONObject = new JSONObject(C6224b.m36178a("file_manager|filemanager_protocol_policy"));
            if (jSONObject.has("filesize")) {
                m36050a(jSONObject.getString("filesize"), this.f29289a);
            }
            if (jSONObject.has("upload_filesize")) {
                m36050a(jSONObject.getString("upload_filesize"), this.f29290b);
            }
        } catch (JSONException e10) {
            FLogger.m36355w("DownloadProtocolChoose", e10.getMessage(), new Object[0]);
        }
    }

    /* renamed from: a */
    public void m36050a(String str, Map<String, b> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String[] strArrSplit = jSONObject.getString(next).split(";");
                b bVar = new b(strArrSplit.length);
                int i10 = 0;
                while (true) {
                    if (i10 < strArrSplit.length) {
                        if (!m36047a(next, strArrSplit[i10], bVar, i10)) {
                            break;
                        } else {
                            i10++;
                        }
                    } else if (bVar.f29293a > 0) {
                        map.put(next, bVar);
                    }
                }
            }
        } catch (Exception e10) {
            FLogger.m36355w("DownloadProtocolChoose", e10.getMessage(), new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean m36051a() {
        return this.f29289a.containsKey("h1") || this.f29290b.containsKey("h1");
    }

    /* renamed from: a */
    public boolean m36052a(int i10) {
        return !(i10 == 0 ? this.f29289a : this.f29290b).isEmpty();
    }

    /* renamed from: a */
    private boolean m36046a(int i10, long j10, String str) {
        if (i10 == 0) {
            a[] aVarArr = this.f29289a.get(str).f29294b;
            for (a aVar : aVarArr) {
                if (j10 > aVar.f29291a && j10 <= aVar.f29292b) {
                    return true;
                }
            }
            return false;
        }
        a[] aVarArr2 = this.f29290b.get(str).f29294b;
        for (a aVar2 : aVarArr2) {
            if (j10 > aVar2.f29291a && j10 <= aVar2.f29292b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m36047a(String str, String str2, b bVar, int i10) {
        String[] strArrSplit = str2.split("-");
        if (strArrSplit.length != 2) {
            FLogger.m36351e("DownloadProtocolChoose", "invalid config:" + str);
            return false;
        }
        FLogger.m36350d("DownloadProtocolChoose", str + strArrSplit[0] + "-" + strArrSplit[1], new Object[0]);
        bVar.m36057a(i10, Long.parseLong(strArrSplit[0]), Long.parseLong(strArrSplit[1]));
        return true;
    }
}
