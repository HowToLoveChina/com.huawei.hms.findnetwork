package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.v0 */
/* loaded from: classes8.dex */
public class C6120v0 extends Submit<ResponseBody> {

    /* renamed from: c */
    public static final String f28608c = "BuildInSubmit";

    /* renamed from: a */
    public final C6044p2 f28609a;

    /* renamed from: b */
    public boolean f28610b;

    /* renamed from: com.huawei.hms.network.embedded.v0$a */
    public class a implements Runnable {

        /* renamed from: a */
        public Callback<ResponseBody> f28611a;

        public a(Callback<ResponseBody> callback) {
            this.f28611a = callback;
        }

        public Submit<ResponseBody> get() {
            return C6120v0.this;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            AutoCloseable autoCloseable = null;
            try {
                Response<ResponseBody> responseExecute = C6120v0.this.f28609a.execute();
                if (C6120v0.this.isCanceled()) {
                    throw C6094t0.m35373a("Canceled");
                }
                this.f28611a.onResponse(get(), responseExecute);
            } catch (IOException e10) {
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (IOException unused) {
                        Logger.m32146w(C6120v0.f28608c, "close response catch IOException", e10);
                    }
                }
                if (0 != 0) {
                    Logger.m32146w(C6120v0.f28608c, "catch Exception", e10);
                } else {
                    this.f28611a.onFailure(get(), e10);
                }
            }
        }
    }

    public C6120v0(C5844a1 c5844a1, C5939h1.d dVar, WebSocket webSocket) {
        this.f28609a = new C6044p2(this, c5844a1, dVar, webSocket);
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public void cancel() {
        this.f28609a.cancel();
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    /* renamed from: clone */
    public Submit<ResponseBody> mo85656clone() {
        return new C6120v0(this.f28609a.getClient(), this.f28609a.request(), this.f28609a.getWebSocket());
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public void enqueue(Callback<ResponseBody> callback) {
        if (callback == null) {
            throw new NullPointerException("callback cannot be null");
        }
        synchronized (this) {
            if (this.f28610b) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28610b = true;
        }
        C5900e1.getInstance().execute(new a(new C5939h1.a(callback)));
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public Response<ResponseBody> execute() throws IOException {
        synchronized (this) {
            if (this.f28610b) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28610b = true;
        }
        return this.f28609a.execute();
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.f28609a.getFinishedInfo();
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public boolean isCanceled() {
        return this.f28609a.isCanceled();
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public synchronized boolean isExecuted() {
        return this.f28610b;
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public C5939h1.d request() {
        return this.f28609a.request();
    }
}
