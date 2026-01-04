package com.huawei.hicloud.request.okhttp.callback;

import fk.C9721b;
import java.io.IOException;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;

/* renamed from: com.huawei.hicloud.request.okhttp.callback.a */
/* loaded from: classes6.dex */
public abstract class AbstractC4992a<T> {
    public static final String DELETE = "DELETE";
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

    public C11922g0 execute(InterfaceC11919f interfaceC11919f) throws IOException {
        this.call = interfaceC11919f;
        return interfaceC11919f.execute();
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public String method() {
        return this.method;
    }

    public abstract T onResponse(C11922g0 c11922g0) throws C9721b, IOException;

    public abstract void prepare(C11918e0.a aVar) throws C9721b, IOException;
}
