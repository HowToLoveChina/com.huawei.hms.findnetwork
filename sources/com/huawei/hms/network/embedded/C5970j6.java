package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.FormBody;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.base.util.HttpUtils;
import com.huawei.hms.network.embedded.C5872c1;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.config.NetworkConfig;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.j6 */
/* loaded from: classes8.dex */
public final class C5970j6 {

    /* renamed from: l */
    public static final String f27117l = "RequestBuilder";

    /* renamed from: m */
    public static final Pattern f27118m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: n */
    public static final char[] f27119n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: o */
    public static final char[] f27120o = {'\t', '\n', '\f', '\r'};

    /* renamed from: p */
    public static final String f27121p = " \"'<>#&=";

    /* renamed from: q */
    public static final String f27122q = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    /* renamed from: r */
    public static Method f27123r;

    /* renamed from: a */
    public final Request.Builder f27124a;

    /* renamed from: b */
    public String f27125b;

    /* renamed from: c */
    public String f27126c;

    /* renamed from: d */
    public C5888d3 f27127d;

    /* renamed from: e */
    public String f27128e;

    /* renamed from: f */
    public Map<String, List<String>> f27129f;

    /* renamed from: g */
    public boolean f27130g;

    /* renamed from: h */
    public FormBody.Builder f27131h;

    /* renamed from: i */
    public RequestBody f27132i;

    /* renamed from: j */
    public boolean f27133j;

    /* renamed from: k */
    public NetworkConfig f27134k = new NetworkConfig(null);

    /* renamed from: com.huawei.hms.network.embedded.j6$a */
    public static class a extends RequestBody {

        /* renamed from: a */
        public final RequestBody f27135a;

        /* renamed from: b */
        public final String f27136b;

        public a(RequestBody requestBody, String str) {
            this.f27135a = requestBody;
            this.f27136b = str;
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public long contentLength() throws IOException {
            return this.f27135a.contentLength();
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public String contentType() {
            return this.f27136b;
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public void writeTo(OutputStream outputStream) throws IOException {
            this.f27135a.writeTo(outputStream);
        }
    }

    public C5970j6(Submit.Factory factory, String str, C5888d3 c5888d3, String str2, Headers headers, String str3, boolean z10, boolean z11, boolean z12) {
        this.f27126c = str;
        this.f27127d = c5888d3;
        this.f27128e = str2;
        this.f27125b = str3;
        this.f27130g = z10;
        this.f27133j = z12;
        this.f27124a = factory instanceof HttpClient ? ((HttpClient) factory).newRequest() : new C5872c1.b();
        if (headers != null) {
            for (int i10 = 0; i10 < headers.size(); i10++) {
                this.f27124a.addHeader(headers.name(i10), headers.value(i10));
            }
        }
        if (z11) {
            this.f27131h = new FormBody.Builder();
        }
    }

    /* renamed from: b */
    private String m34505b() {
        StringBuilder sb2 = new StringBuilder();
        Map<String, List<String>> map = this.f27129f;
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, List<String>>> it = this.f27129f.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<String>> next = it.next();
                List<String> value = next.getValue();
                for (int i10 = 0; i10 < value.size(); i10++) {
                    sb2.append(next.getKey());
                    sb2.append("=");
                    sb2.append(value.get(i10));
                    if (i10 != value.size() - 1) {
                        sb2.append("&");
                    }
                }
                if (it.hasNext()) {
                    sb2.append("&");
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public Request m34507a() throws JSONException, IOException {
        RequestBody aVar = this.f27132i;
        if (aVar == null) {
            FormBody.Builder builder = this.f27131h;
            if (builder != null) {
                aVar = builder.build();
            } else if (hasBody()) {
                aVar = RequestBodyProviders.create((String) null, new byte[0]);
            }
        }
        String str = this.f27125b;
        if (str != null) {
            if (aVar != null) {
                aVar = new a(aVar, str);
            } else {
                this.f27124a.addHeader("Content-Type", str);
            }
        }
        this.f27124a.url(getRequestUrl().getUrl()).method(this.f27126c).requestBody(aVar);
        if (this.f27133j) {
            this.f27134k.setValue("core_connect_empty_body", true);
        }
        this.f27124a.options(this.f27134k.toString());
        return this.f27124a.build();
    }

    /* renamed from: c */
    public void m34513c(String str, String str2) {
        String str3 = this.f27128e;
        if (str3 == null) {
            throw new AssertionError();
        }
        String strReplace = str3.replace("{" + str + "}", str2);
        if (!f27118m.matcher(strReplace).matches()) {
            this.f27128e = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public String getMethod() {
        return this.f27126c;
    }

    public String getRelativeUrl() {
        return this.f27128e;
    }

    public C5888d3 getRequestUrl() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (!HttpUtils.isHttpOrGrsUrl(this.f27128e)) {
            C5888d3 c5888d3 = this.f27127d;
            if (c5888d3 == null) {
                throw new IOException("baseUrl == null", new NullPointerException("baseUrl == null"));
            }
            sb2.append(c5888d3.getUrl());
        }
        sb2.append(this.f27128e);
        String strM34505b = m34505b();
        if (!strM34505b.isEmpty()) {
            String str = Constants.QUESTION_STR;
            int iLastIndexOf = sb2.lastIndexOf(Constants.QUESTION_STR);
            int length = sb2.length();
            if (iLastIndexOf >= 0) {
                if (iLastIndexOf != length - 1) {
                    str = "&";
                    sb2.append(str);
                }
                sb2.append(strM34505b);
            } else {
                sb2.append(str);
                sb2.append(strM34505b);
            }
        }
        return new C5888d3(sb2.toString());
    }

    public boolean hasBody() {
        return this.f27130g;
    }

    public void setMetricsData(String str) {
        this.f27134k.setOption(str);
    }

    public void setNetworkParameters(String str) {
        this.f27134k.setOption(str);
    }

    /* renamed from: a */
    private String m34501a(String str, int i10, int i11, String str2, boolean z10) throws EOFException {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (m34504a(iCodePointAt, str2, z10) || iCodePointAt == 43) {
                C5868bb c5868bb = new C5868bb();
                c5868bb.mo33935a(str, i10, iCharCount);
                m34502a(c5868bb, str, iCharCount, i11, str2, z10);
                return c5868bb.mo33979o();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i10, i11);
    }

    /* renamed from: b */
    private String m34506b(String str, String str2, boolean z10) {
        try {
            return m34501a(str, 0, str.length(), str2, z10);
        } catch (EOFException e10) {
            Logger.m32146w(f27117l, "EOFException queryParamEncode err", e10);
            return str;
        }
    }

    /* renamed from: a */
    private void m34502a(C5868bb c5868bb, String str, int i10, int i11, String str2, boolean z10) throws EOFException {
        C5868bb c5868bb2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || !m34503a(iCodePointAt)) {
                if (iCodePointAt == 43) {
                    c5868bb.mo33934a(z10 ? "+" : "%2B");
                } else if (m34504a(iCodePointAt, str2, z10)) {
                    if (c5868bb2 == null) {
                        c5868bb2 = new C5868bb();
                    }
                    c5868bb2.mo33952c(iCodePointAt);
                    while (!c5868bb2.mo33971i()) {
                        byte b10 = c5868bb2.readByte();
                        c5868bb.writeByte(37);
                        char[] cArr = f27119n;
                        c5868bb.writeByte((int) cArr[((b10 & 255) >> 4) & 15]);
                        c5868bb.writeByte((int) cArr[b10 & BaseType.Obj]);
                    }
                } else {
                    c5868bb.mo33952c(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    /* renamed from: b */
    public void m34512b(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            this.f27125b = str2;
        } else {
            this.f27124a.addHeader(str, str2);
        }
    }

    /* renamed from: a */
    public void m34508a(RequestBody requestBody) {
        this.f27132i = requestBody;
    }

    /* renamed from: a */
    public void m34509a(String str) {
        this.f27128e = str;
    }

    /* renamed from: a */
    public void m34510a(String str, String str2) {
        FormBody.Builder builder = this.f27131h;
        if (builder != null) {
            builder.add(str, str2);
        }
    }

    /* renamed from: a */
    public void m34511a(String str, String str2, boolean z10) {
        if (this.f27129f == null) {
            this.f27129f = new HashMap();
        }
        String str3 = z10 ? " \"'<>#&=" : " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
        String strM34506b = m34506b(str, str3, z10);
        String strM34506b2 = str2 != null ? m34506b(str2, str3, z10) : null;
        if (this.f27129f.containsKey(strM34506b)) {
            this.f27129f.get(strM34506b).add(strM34506b2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strM34506b2);
        this.f27129f.put(strM34506b, arrayList);
    }

    /* renamed from: a */
    private boolean m34503a(int i10) {
        for (char c10 : f27120o) {
            if (i10 == c10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m34504a(int i10, String str, boolean z10) {
        if (i10 < 32 || i10 == 127 || i10 >= 128 || str.indexOf(i10) != -1) {
            return true;
        }
        return i10 == 37 && !z10;
    }
}
