package com.huawei.openalliance.p169ad.beans.inner;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.HashMap;
import java.util.Map;
import okhttp3.InterfaceC11944k;

/* loaded from: classes8.dex */
public class HttpConnection {
    private String connectionInfo;
    private Map<String, String> headers;
    private String host;
    private String ipAddress;

    public HttpConnection() {
    }

    public HttpConnection(InterfaceC11944k interfaceC11944k) {
        try {
            this.connectionInfo = interfaceC11944k.toString();
            this.host = interfaceC11944k.mo71709a().m71638a().m71461n().m71904l();
            this.ipAddress = interfaceC11944k.mo71709a().m71641d().getAddress().getHostAddress();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String m39402a() {
        return this.connectionInfo;
    }

    /* renamed from: b */
    public String m39405b() {
        return this.host;
    }

    /* renamed from: c */
    public String m39406c() {
        return this.ipAddress;
    }

    /* renamed from: a */
    public String m39403a(String str) {
        if (C7765bl.m47802a(this.headers) || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.headers.get(str);
    }

    /* renamed from: a */
    public void m39404a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.put(str, str2);
    }
}
