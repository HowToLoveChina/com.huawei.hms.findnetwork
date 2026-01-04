package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.openalliance.ad.ig */
/* loaded from: classes8.dex */
public class C7213ig {

    /* renamed from: a */
    private static final Pattern f33192a = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: b */
    private static final Pattern f33193b = Pattern.compile("Range: (.*)");

    /* renamed from: c */
    private static final Pattern f33194c = Pattern.compile("bytes=(\\d+)");

    /* renamed from: d */
    private String f33195d;

    /* renamed from: e */
    private String f33196e;

    /* renamed from: f */
    private String f33197f;

    /* renamed from: g */
    private String f33198g;

    /* renamed from: h */
    private int f33199h = 0;

    private C7213ig(String str) {
        AbstractC7185ho.m43818a("HttpGetRequest", "Media Player request header: %s", str);
        this.f33196e = m43931c(str);
        String strM43930b = m43930b(str);
        if (AbstractC7806cz.m48165b(strM43930b)) {
            AbstractC7185ho.m43826d("HttpGetRequest", "parse uri failed, source is empty");
            return;
        }
        int iIndexOf = strM43930b.indexOf(Constants.QUESTION_STR);
        try {
            this.f33195d = URLDecoder.decode(strM43930b.substring(0, iIndexOf == -1 ? strM43930b.length() : iIndexOf), Constants.UTF_8);
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("HttpGetRequest", "decode failed error: %s", th2.getClass().getSimpleName());
        }
        if (iIndexOf != -1) {
            m43929a(strM43930b.substring(iIndexOf + 1));
            AbstractC7185ho.m43818a("HttpGetRequest", "url: %s, nonsense: %s", this.f33195d, this.f33197f);
        }
    }

    /* renamed from: a */
    public static C7213ig m43928a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.UTF_8));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (AbstractC7806cz.m48165b(line)) {
                return new C7213ig(sb2.toString());
            }
            sb2.append(line);
            sb2.append('\n');
        }
    }

    /* renamed from: b */
    public String m43933b() {
        return this.f33195d;
    }

    /* renamed from: c */
    public String m43934c() {
        return this.f33197f;
    }

    /* renamed from: d */
    public Long m43935d() {
        Matcher matcher = f33194c.matcher(m43932a());
        if (!matcher.find()) {
            return 0L;
        }
        AbstractC7185ho.m43820b("HttpGetRequest", "request Range bytes:" + matcher.group(1));
        return Long.valueOf(matcher.group(1));
    }

    /* renamed from: e */
    public String m43936e() {
        return this.f33198g;
    }

    /* renamed from: f */
    public int m43937f() {
        return this.f33199h;
    }

    /* renamed from: b */
    private String m43930b(String str) {
        Matcher matcher = f33192a.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request, url not found");
    }

    /* renamed from: c */
    private String m43931c(String str) {
        Matcher matcher = f33193b.matcher(str);
        if (!matcher.find()) {
            AbstractC7185ho.m43820b("HttpGetRequest", "request header not have range");
            return "";
        }
        AbstractC7185ho.m43820b("HttpGetRequest", "request Range:" + matcher.group(1));
        return matcher.group(1);
    }

    /* renamed from: a */
    public String m43932a() {
        return this.f33196e;
    }

    /* renamed from: a */
    private void m43929a(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length >= 2) {
                String str3 = strArrSplit[0];
                String str4 = strArrSplit[1];
                try {
                    map.put(str3, URLDecoder.decode(str4, Constants.UTF_8));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43827d("HttpGetRequest", "decode failed error: %s for key = %s ,rawValue = %s", th2.getClass().getSimpleName(), str3, str4);
                }
            }
        }
        this.f33197f = (String) map.get("nonsense");
        this.f33198g = (String) map.get("sha256");
        this.f33199h = AbstractC7806cz.m48145a((String) map.get("checkFlag"), 0);
    }
}
