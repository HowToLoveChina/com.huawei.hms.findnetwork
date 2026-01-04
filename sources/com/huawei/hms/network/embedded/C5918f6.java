package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.util.TypeUtils;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.hms.network.restclient.SubmitAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hms.network.embedded.f6 */
/* loaded from: classes8.dex */
public class C5918f6 extends SubmitAdapter.Factory {

    /* renamed from: a */
    public Executor f26753a;

    /* renamed from: com.huawei.hms.network.embedded.f6$a */
    public class a extends SubmitAdapter<Object, Object> {

        /* renamed from: a */
        public final /* synthetic */ Type f26754a;

        public a(Type type) {
            this.f26754a = type;
        }

        @Override // com.huawei.hms.network.restclient.SubmitAdapter
        /* renamed from: adapt */
        public Object adapt2(Submit<Object> submit) {
            C5918f6 c5918f6 = C5918f6.this;
            return c5918f6.new b(submit, c5918f6.f26753a);
        }

        @Override // com.huawei.hms.network.restclient.SubmitAdapter
        public Type responseType() {
            return this.f26754a;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.f6$b */
    public class b<T> extends Submit<T> {

        /* renamed from: d */
        public static final String f26756d = "ExecutorSubmit";

        /* renamed from: a */
        public Submit<T> f26757a;

        /* renamed from: b */
        public Executor f26758b;

        /* renamed from: com.huawei.hms.network.embedded.f6$b$a */
        public class a extends Callback<T> {

            /* renamed from: a */
            public final /* synthetic */ Callback f26760a;

            /* renamed from: com.huawei.hms.network.embedded.f6$b$a$a, reason: collision with other inner class name */
            public class RunnableC14440a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ Submit f26762a;

                /* renamed from: b */
                public final /* synthetic */ Response f26763b;

                public RunnableC14440a(Submit submit, Response response) {
                    this.f26762a = submit;
                    this.f26763b = response;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.isCanceled()) {
                        a.this.f26760a.onFailure(this.f26762a, C6094t0.m35373a("Canceled"));
                        return;
                    }
                    try {
                        a.this.f26760a.onResponse(this.f26762a, this.f26763b);
                    } catch (IOException unused) {
                        Logger.m32145w(b.f26756d, "ExecutorSubmit callback onResponse catch IOException");
                    }
                }
            }

            /* renamed from: com.huawei.hms.network.embedded.f6$b$a$b, reason: collision with other inner class name */
            public class RunnableC14441b implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ Submit f26765a;

                /* renamed from: b */
                public final /* synthetic */ Throwable f26766b;

                public RunnableC14441b(Submit submit, Throwable th2) {
                    this.f26765a = submit;
                    this.f26766b = th2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f26760a.onFailure(this.f26765a, this.f26766b);
                }
            }

            public a(Callback callback) {
                this.f26760a = callback;
            }

            @Override // com.huawei.hms.network.httpclient.Callback
            public void onFailure(Submit<T> submit, Throwable th2) {
                b.this.f26758b.execute(new RunnableC14441b(submit, th2));
            }

            @Override // com.huawei.hms.network.httpclient.Callback
            public void onResponse(Submit<T> submit, Response<T> response) {
                b.this.f26758b.execute(new RunnableC14440a(submit, response));
            }
        }

        public b(Submit<T> submit, Executor executor) {
            this.f26757a = submit;
            this.f26758b = executor;
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public void cancel() {
            this.f26757a.cancel();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        /* renamed from: clone */
        public Submit mo85656clone() {
            return C5918f6.this.new b(this.f26757a, this.f26758b);
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public void enqueue(Callback<T> callback) {
            this.f26757a.enqueue(new a(callback));
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public Response<T> execute() throws IOException {
            return this.f26757a.execute();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public RequestFinishedInfo getRequestFinishedInfo() {
            return this.f26757a.getRequestFinishedInfo();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public boolean isCanceled() {
            return this.f26757a.isCanceled();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public boolean isExecuted() {
            return this.f26757a.isExecuted();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public Request request() throws IOException {
            return this.f26757a.request();
        }
    }

    public C5918f6(Executor executor) {
        this.f26753a = executor;
    }

    @Override // com.huawei.hms.network.restclient.SubmitAdapter.Factory
    public SubmitAdapter<?, ?> get(Type type, Annotation[] annotationArr, RestClient restClient) {
        return new a(TypeUtils.getSubmitResponseType(type));
    }
}
