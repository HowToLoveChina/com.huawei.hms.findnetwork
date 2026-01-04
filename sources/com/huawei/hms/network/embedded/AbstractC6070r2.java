package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.huawei.hms.network.embedded.r2 */
/* loaded from: classes8.dex */
public abstract class AbstractC6070r2 extends RequestFinishedInfo {

    /* renamed from: f */
    public static final String f28004f = "BaseRequestFinishedInfo";

    /* renamed from: a */
    public String f28005a;

    /* renamed from: b */
    public String f28006b;

    /* renamed from: c */
    public Exception f28007c;

    /* renamed from: d */
    public Response f28008d;

    /* renamed from: e */
    public String f28009e;

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public Exception getException() {
        return this.f28007c;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getHost() {
        return this.f28005a;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getNetMsgId() {
        return this.f28009e;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public long getPingInterval() {
        return 0L;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public Response getResponse() {
        return this.f28008d;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getUrl() {
        return this.f28006b;
    }

    public void setException(Exception exc) {
        this.f28007c = exc;
    }

    public void setNetMsgId(String str) {
        this.f28009e = str;
    }

    public void setResponse(Response response) {
        this.f28008d = response;
    }

    public void setUrl(String str) {
        this.f28006b = str;
        try {
            this.f28005a = new URL(str).getHost();
        } catch (MalformedURLException unused) {
            Logger.m32141i(f28004f, "fail to get hostname from url");
        }
    }
}
