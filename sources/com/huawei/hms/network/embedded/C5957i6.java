package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.i6 */
/* loaded from: classes8.dex */
public class C5957i6<T> extends Submit<T> {

    /* renamed from: g */
    public static final String f27017g = "RealSubmit";

    /* renamed from: a */
    public final C5983k6<T, ?> f27018a;

    /* renamed from: b */
    public final Object[] f27019b;

    /* renamed from: c */
    public Submit.Factory f27020c;

    /* renamed from: d */
    public C5939h1.h<T> f27021d;

    /* renamed from: e */
    public volatile boolean f27022e;

    /* renamed from: f */
    public boolean f27023f;

    /* renamed from: com.huawei.hms.network.embedded.i6$a */
    public class a extends Callback<T> {

        /* renamed from: a */
        public final /* synthetic */ Callback f27024a;

        public a(Callback callback) {
            this.f27024a = callback;
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onFailure(Submit<T> submit, Throwable th2) {
            this.f27024a.onFailure(submit, th2);
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onResponse(Submit<T> submit, Response<T> response) {
            try {
                this.f27024a.onResponse(submit, C5957i6.this.m34384a(response));
            } catch (Exception e10) {
                this.f27024a.onFailure(submit, e10);
            }
        }
    }

    public C5957i6(Submit.Factory factory, C5983k6<T, ?> c5983k6, Object[] objArr) {
        this.f27020c = factory;
        this.f27018a = c5983k6;
        this.f27019b = objArr;
    }

    /* renamed from: a */
    private C5939h1.h<T> m34382a() throws IOException {
        Submit.Factory factory = this.f27020c;
        Submit<ResponseBody> submitNewSubmit = factory.newSubmit(this.f27018a.m34564a(factory, this.f27019b));
        if (submitNewSubmit != null) {
            return submitNewSubmit instanceof C5939h1.h ? (C5939h1.h) submitNewSubmit : new C5939h1.h<>(submitNewSubmit);
        }
        throw new IOException("create submit error");
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public void cancel() {
        this.f27022e = true;
        C5939h1.h<T> hVar = this.f27021d;
        if (hVar != null) {
            hVar.cancel();
        }
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    /* renamed from: clone */
    public Submit<T> mo85656clone() {
        return new C5957i6(this.f27020c, this.f27018a, this.f27019b);
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public void enqueue(Callback<T> callback) throws IOException {
        if (callback == null) {
            throw new NullPointerException("callback cannot be null");
        }
        synchronized (this) {
            if (this.f27023f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f27023f = true;
        }
        try {
            if (this.f27022e) {
                throw C6094t0.m35373a("Canceled");
            }
            if (this.f27021d == null) {
                this.f27021d = m34382a();
            }
            this.f27021d.enqueue(new a(callback));
        } catch (Exception e10) {
            callback.onFailure(this, e10);
        }
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public Response<T> execute() throws IOException {
        synchronized (this) {
            if (this.f27023f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f27023f = true;
        }
        if (this.f27022e) {
            throw C6094t0.m35373a("Canceled");
        }
        if (this.f27021d == null) {
            this.f27021d = m34382a();
        }
        return m34384a(this.f27021d.execute());
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public RequestFinishedInfo getRequestFinishedInfo() {
        C5939h1.h<T> hVar = this.f27021d;
        if (hVar == null) {
            return null;
        }
        return hVar.getRequestFinishedInfo();
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public boolean isCanceled() {
        C5939h1.h<T> hVar;
        return this.f27022e || ((hVar = this.f27021d) != null && hVar.isCanceled());
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public synchronized boolean isExecuted() {
        return this.f27023f;
    }

    @Override // com.huawei.hms.network.httpclient.Submit
    public synchronized Request request() throws IOException {
        try {
            if (this.f27021d == null) {
                this.f27021d = m34382a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f27021d.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Response<T> m34384a(Response<ResponseBody> response) throws IOException {
        C6107u0.b bVar = new C6107u0.b();
        bVar.headers(response.getHeaders());
        bVar.code(response.getCode());
        bVar.message(response.getMessage());
        bVar.url(response.getUrl());
        bVar.errorBody(response.getErrorBody());
        if (response.getBody() != null) {
            C5983k6<T, ?> c5983k6 = this.f27018a;
            bVar.body(c5983k6 != null ? c5983k6.m34565a(response.getBody()) : null);
        }
        return bVar.build();
    }
}
