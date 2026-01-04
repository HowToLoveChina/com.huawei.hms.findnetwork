package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.config.NetworkConfig;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.huawei.hms.network.ai.l */
/* loaded from: classes8.dex */
public class C5808l {

    /* renamed from: d */
    public static final String f25959d = "WrappedRequest";

    /* renamed from: a */
    public Request f25960a;

    /* renamed from: b */
    public long f25961b = System.currentTimeMillis();

    /* renamed from: c */
    public String f25962c;

    public C5808l(Request request) {
        this.f25960a = request;
        this.f25962c = m33419a(request);
    }

    /* renamed from: a */
    public String m33420a() {
        return this.f25962c;
    }

    /* renamed from: b */
    public long m33421b() {
        return this.f25961b;
    }

    /* renamed from: c */
    public boolean m33422c() {
        return new NetworkConfig(this.f25960a.getOptions()).enableInnerConnectEmptyBody();
    }

    /* renamed from: a */
    private String m33419a(Request request) {
        try {
            return new URL(request.getUrl()).getHost();
        } catch (MalformedURLException e10) {
            Logger.m32143v(f25959d, "get host fail :" + e10);
            return C5788b.f25737g;
        }
    }
}
