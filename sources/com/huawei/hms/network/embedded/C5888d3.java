package com.huawei.hms.network.embedded;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.d3 */
/* loaded from: classes8.dex */
public class C5888d3 {

    /* renamed from: a */
    public String f26634a;

    /* renamed from: b */
    public URL f26635b;

    /* renamed from: c */
    public MalformedURLException f26636c;

    /* renamed from: d */
    public List<String> f26637d = new ArrayList();

    public C5888d3(String str) {
        m34101a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.network.embedded.C5888d3 m34101a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "url == null"
            com.huawei.hms.framework.common.CheckParamUtils.checkNotNull(r8, r0)
            r5 = 0
            r6 = 3
            r2 = 1
            r3 = 0
            java.lang.String r4 = "ws:"
            r1 = r8
            boolean r0 = r1.regionMatches(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L2a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "http:"
            r0.append(r1)
            r1 = 3
        L1e:
            java.lang.String r8 = r8.substring(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L44
        L2a:
            r4 = 0
            r5 = 4
            r1 = 1
            r2 = 0
            java.lang.String r3 = "wss:"
            r0 = r8
            boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L44
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "https:"
            r0.append(r1)
            r1 = 4
            goto L1e
        L44:
            boolean r0 = com.huawei.hms.network.base.util.HttpUtils.isHttpOrGrsUrl(r8)
            if (r0 == 0) goto L5e
            r7.f26634a = r8
            boolean r0 = com.huawei.hms.network.base.util.HttpUtils.isHttpUrl(r8)
            if (r0 == 0) goto L5d
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> L5a
            r0.<init>(r8)     // Catch: java.net.MalformedURLException -> L5a
            r7.f26635b = r0     // Catch: java.net.MalformedURLException -> L5a
            goto L5d
        L5a:
            r8 = move-exception
            r7.f26636c = r8
        L5d:
            return r7
        L5e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "url not valid must be http://;https://;grs://"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5888d3.m34101a(java.lang.String):com.huawei.hms.network.embedded.d3");
    }

    public C5888d3 addIp(String str) {
        this.f26637d.add(str);
        return this;
    }

    public String getHost() {
        URL url = this.f26635b;
        return url == null ? "" : url.getHost();
    }

    public List<String> getIps() {
        return this.f26637d;
    }

    public int getPort() {
        URL url = this.f26635b;
        if (url == null) {
            return -1;
        }
        return url.getPort();
    }

    public URL getURL() throws MalformedURLException {
        URL url = this.f26635b;
        if (url != null) {
            return url;
        }
        throw this.f26636c;
    }

    public String getUrl() {
        return this.f26634a;
    }

    public C5888d3 setIps(List<String> list) {
        this.f26637d = list;
        return this;
    }

    public String toString() {
        return super.toString();
    }
}
