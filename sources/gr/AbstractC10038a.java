package gr;

import android.net.Uri;
import as.C1016d;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: gr.a */
/* loaded from: classes8.dex */
public abstract class AbstractC10038a {

    /* renamed from: a */
    public final String f49001a;

    /* renamed from: b */
    public final String f49002b;

    /* renamed from: c */
    public final TreeMap f49003c = new TreeMap();

    /* renamed from: d */
    public final TreeMap f49004d = new TreeMap();

    /* renamed from: e */
    public final int f49005e = 2;

    public AbstractC10038a(String str) {
        if (str.contains(SplitAppUtil.SPLIT_APP_SUFFIX) || str.contains("\\.") || str.contains("\\\\.") || str.contains("\\")) {
            this.f49001a = "";
            this.f49002b = "";
            C1016d.m6183c("HttpsRequest", "url is not correct");
            return;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.toLowerCase(Locale.ENGLISH).equals("https")) {
            this.f49001a = "";
            this.f49002b = "";
            C1016d.m6183c("HttpsRequest", "not https");
            return;
        }
        String authority = uri.getAuthority();
        String host = uri.getHost();
        String path = uri.getPath();
        if (host == null) {
            C1016d.m6183c("HttpsRequest", "uri host is undefined");
        }
        authority = authority == null ? "" : authority;
        String str2 = path != null ? path : "";
        this.f49001a = authority;
        this.f49002b = str2;
        m62440l(uri);
    }

    /* renamed from: i */
    public static String m62429i(String str) {
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C1016d.m6183c("HttpsRequest", "not support UTF-8");
            return "";
        }
    }

    /* renamed from: j */
    public static String m62430j(SortedMap<String, String> sortedMap) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public final String m62431a() {
        return this.f49002b;
    }

    /* renamed from: b */
    public abstract InputStream mo62432b();

    /* renamed from: c */
    public final String m62433c() {
        return C10040c.m62446b(this.f49005e);
    }

    /* renamed from: d */
    public final void m62434d(String str, String str2) {
        String strM62429i = m62429i(str);
        String strM62429i2 = m62429i(str2);
        if (strM62429i.isEmpty() || strM62429i2.isEmpty()) {
            return;
        }
        this.f49004d.put(strM62429i, strM62429i2);
    }

    /* renamed from: e */
    public boolean mo62435e() {
        String str;
        if (this.f49001a.isEmpty()) {
            str = "domain empty";
        } else {
            if (!this.f49002b.isEmpty()) {
                return true;
            }
            str = "path empty";
        }
        C1016d.m6183c("HttpsRequest", str);
        C1016d.m6183c("HttpsRequest", "valid failed");
        return false;
    }

    /* renamed from: f */
    public final AbstractC10038a m62436f(String str, String str2) {
        if (str.isEmpty()) {
            return this;
        }
        this.f49003c.put(str, str2);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010a  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R extends gr.C10042e> R m62437g(java.lang.Class<? extends R> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gr.AbstractC10038a.m62437g(java.lang.Class):gr.e");
    }

    /* renamed from: h */
    public final String m62438h() {
        return m62430j(this.f49004d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
    
        if (1 != 0) goto L87;
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m62439k(javax.net.ssl.HttpsURLConnection r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gr.AbstractC10038a.m62439k(javax.net.ssl.HttpsURLConnection):java.lang.String");
    }

    /* renamed from: l */
    public final void m62440l(Uri uri) {
        try {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (queryParameter == null) {
                    C1016d.m6183c("HttpsRequest", "arg value null.");
                    C1016d.m6181a("HttpsRequest", "arg value null. arg name:" + str);
                } else {
                    m62434d(str, queryParameter);
                }
            }
        } catch (UnsupportedOperationException unused) {
            C1016d.m6183c("HttpsRequest", "url not support");
        }
    }

    public AbstractC10038a(String str, String str2) {
        this.f49001a = str;
        this.f49002b = str2;
    }
}
