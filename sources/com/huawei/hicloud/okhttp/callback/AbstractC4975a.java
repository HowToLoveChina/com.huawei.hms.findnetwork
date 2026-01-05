package com.huawei.hicloud.okhttp.callback;

import fk.C9721b;
import java.io.IOException;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;

/* renamed from: com.huawei.hicloud.okhttp.callback.a */
/* loaded from: classes6.dex */
public abstract class AbstractC4975a<T> {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    private InterfaceC11919f call;
    protected String method = "GET";
    private boolean isCanceled = false;

    public void cancel() {
        this.isCanceled = true;
        InterfaceC11919f interfaceC11919f = this.call;
        if (interfaceC11919f != null) {
            interfaceC11919f.cancel();
        }
    }

    public void enqueue(InterfaceC11919f interfaceC11919f, InterfaceC11921g interfaceC11921g) {
        this.call = interfaceC11919f;
        interfaceC11919f.mo71532e(interfaceC11921g);
    }

    public HttpResponseBuilder execute(InterfaceC11919f interfaceC11919f) throws IOException {
        this.call = interfaceC11919f;
        return interfaceC11919f.execute();
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public String method() {
        return this.method;
    }

    public abstract T onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException;

    public abstract void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException;
}
