package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ExtLogger;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.Version;
import com.huawei.hms.network.api.advance.WrapperLogger;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.config.NetworkConfig;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.httpclient.websocket.WebSocketListener;
import com.huawei.hms.network.inner.api.RequestContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.h1 */
/* loaded from: classes8.dex */
public class C5939h1 {

    /* renamed from: a */
    public static final String f26900a = "SafeApi";

    /* renamed from: com.huawei.hms.network.embedded.h1$a */
    public static final class a<T> extends Callback<T> {

        /* renamed from: a */
        public final Callback<T> f26901a;

        public a(Callback<T> callback) {
            CheckParamUtils.checkNotNull(callback, "SafeCallback<T> callback == null");
            this.f26901a = callback;
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onFailure(Submit<T> submit, Throwable th2) {
            this.f26901a.onFailure(submit, th2);
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onResponse(Submit<T> submit, Response<T> response) throws IOException {
            this.f26901a.onResponse(submit, response);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$b */
    public static final class b extends Interceptor.Chain {

        /* renamed from: a */
        public final Interceptor.Chain f26902a;

        public b(Interceptor.Chain chain) {
            CheckParamUtils.checkNotNull(chain, "SafeChain chain == null");
            this.f26902a = chain;
        }

        public AbstractC6174z2 getRCEventListener() {
            return ((C5858b1) this.f26902a).getRCEventListener();
        }

        public C5844a1 getRealHttpclient() {
            return (C5844a1) ((C5858b1) this.f26902a).getClient();
        }

        public InterfaceC5886d1 getRequestTask() {
            return ((C5858b1) this.f26902a).getRequestTask();
        }

        @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
        public Response<ResponseBody> proceed(Request request) throws IOException {
            return this.f26902a.proceed(request);
        }

        @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
        public d request() {
            return (d) this.f26902a.request();
        }

        @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
        public RequestFinishedInfo requestFinishedInfo() {
            InterfaceC5886d1 requestTask;
            if (!C5939h1.apiAvailable(5) || (requestTask = ((C5858b1) this.f26902a).getRequestTask()) == null) {
                return null;
            }
            return requestTask.getRequestFinishedInfo();
        }

        public Response<ResponseBody> proceed(RequestContext requestContext, InterfaceC5886d1 interfaceC5886d1) throws IOException {
            return ((C5858b1) this.f26902a).m33854a(requestContext, interfaceC5886d1);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$c */
    public static final class c extends Interceptor {

        /* renamed from: a */
        public final Interceptor f26903a;

        public c(Interceptor interceptor) {
            CheckParamUtils.checkNotNull(interceptor, "SafeInterceptor interceptor == null");
            this.f26903a = interceptor;
        }

        @Override // com.huawei.hms.network.httpclient.Interceptor
        public Response<ResponseBody> intercept(Interceptor.Chain chain) throws IOException {
            return this.f26903a.intercept(chain);
        }

        public String toString() {
            return "SafeInterceptor{interceptor=" + this.f26903a.getClass().getName() + '}';
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$d */
    public static final class d extends Request {

        /* renamed from: a */
        public final Request f26904a;

        /* renamed from: b */
        public e f26905b;

        /* renamed from: c */
        public NetworkConfig f26906c;

        public d(Request request) {
            CheckParamUtils.checkNotNull(request, "SafeRequest request == null");
            this.f26904a = request;
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public e getBody() {
            e eVar = this.f26905b;
            if (eVar != null) {
                return eVar;
            }
            RequestBody body = this.f26904a.getBody();
            if (body == null || (body instanceof e)) {
                this.f26905b = (e) body;
            } else {
                this.f26905b = new e(body);
            }
            return this.f26905b;
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public Map<String, List<String>> getHeaders() {
            return this.f26904a.getHeaders();
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public String getMethod() {
            return this.f26904a.getMethod();
        }

        public NetworkConfig getNetConfig() {
            NetworkConfig networkConfig = this.f26906c;
            if (networkConfig != null) {
                return networkConfig;
            }
            NetworkConfig networkConfig2 = new NetworkConfig(getOptions());
            this.f26906c = networkConfig2;
            return networkConfig2;
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public String getOptions() {
            return this.f26904a.getOptions();
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public Object getTag() {
            return this.f26904a.getTag();
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public String getUrl() {
            return this.f26904a.getUrl();
        }

        @Override // com.huawei.hms.network.httpclient.Request
        public Request.Builder newBuilder() {
            return this.f26904a.newBuilder();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$e */
    public static final class e extends RequestBody {

        /* renamed from: a */
        public final RequestBody f26907a;

        public e(RequestBody requestBody) {
            CheckParamUtils.checkNotNull(requestBody, "SafeRequestBody requestBody == null");
            this.f26907a = requestBody;
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public long contentLength() throws IOException {
            return this.f26907a.contentLength();
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public String contentType() {
            return this.f26907a.contentType();
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public boolean endOfStream() {
            return this.f26907a.endOfStream();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            return this.f26907a.equals(((e) obj).f26907a);
        }

        public int hashCode() {
            return this.f26907a.hashCode();
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public boolean isDuplex() {
            if (C5939h1.apiAvailable(5)) {
                return this.f26907a.isDuplex();
            }
            return false;
        }

        @Override // com.huawei.hms.network.httpclient.RequestBody
        public void writeTo(OutputStream outputStream) throws IOException {
            this.f26907a.writeTo(outputStream);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$f */
    public static final class f<T> extends Response<T> {

        /* renamed from: a */
        public final Response<T> f26908a;

        public f(Response<T> response) {
            CheckParamUtils.checkNotNull(response, "SafeResponse<T> response == null");
            this.f26908a = response;
        }

        @Override // com.huawei.hms.network.httpclient.Response, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f26908a.close();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public Response.Builder createBuilder() {
            return this.f26908a.createBuilder();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public T getBody() {
            return this.f26908a.getBody();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public int getCode() {
            return this.f26908a.getCode();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public ResponseBody getErrorBody() {
            return this.f26908a.getErrorBody();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public Map<String, List<String>> getHeaders() {
            return this.f26908a.getHeaders();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public String getMessage() {
            return this.f26908a.getMessage();
        }

        @Override // com.huawei.hms.network.httpclient.Response
        public String getUrl() {
            return this.f26908a.getUrl();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$g */
    public static final class g extends ResponseBody {

        /* renamed from: a */
        public final ResponseBody f26909a;

        public g(ResponseBody responseBody) {
            CheckParamUtils.checkNotNull(responseBody, "SafeResponseBody responseBody == null");
            this.f26909a = responseBody;
        }

        @Override // com.huawei.hms.network.httpclient.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f26909a.close();
        }

        @Override // com.huawei.hms.network.httpclient.ResponseBody
        public long getContentLength() {
            return this.f26909a.getContentLength();
        }

        @Override // com.huawei.hms.network.httpclient.ResponseBody
        public String getContentType() {
            return this.f26909a.getContentType();
        }

        @Override // com.huawei.hms.network.httpclient.ResponseBody
        public InputStream getInputStream() {
            return this.f26909a.getInputStream();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$h */
    public static final class h<T> extends Submit<T> {

        /* renamed from: a */
        public final Submit<T> f26910a;

        public h(Submit<T> submit) {
            CheckParamUtils.checkNotNull(submit, "SafeSubmit<T> submit == null");
            this.f26910a = submit;
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public void cancel() {
            this.f26910a.cancel();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        /* renamed from: clone */
        public Submit<T> mo85656clone() {
            return this.f26910a.mo85656clone();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public void enqueue(Callback<T> callback) {
            this.f26910a.enqueue(callback);
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public Response<T> execute() throws IOException {
            return this.f26910a.execute();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public RequestFinishedInfo getRequestFinishedInfo() {
            return this.f26910a.getRequestFinishedInfo();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public boolean isCanceled() {
            return this.f26910a.isCanceled();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public boolean isExecuted() {
            return this.f26910a.isExecuted();
        }

        @Override // com.huawei.hms.network.httpclient.Submit
        public Request request() throws IOException {
            return this.f26910a.request();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$i */
    public static final class i extends WebSocket {

        /* renamed from: a */
        public final WebSocket f26911a;

        public i(WebSocket webSocket) {
            CheckParamUtils.checkNotNull(webSocket, "SafeWebSocket webSocket == null");
            this.f26911a = webSocket;
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public void cancel() {
            this.f26911a.cancel();
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public boolean close(int i10, String str) {
            return this.f26911a.close(i10, str);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public boolean enableDynamicPing(int i10) {
            return this.f26911a.enableDynamicPing(i10);
        }

        public WebSocket getWebSocket() {
            return this.f26911a;
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public long queueSize() {
            return this.f26911a.queueSize();
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public Request request() {
            return this.f26911a.request();
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public void resetPingInterval(long j10) {
            this.f26911a.resetPingInterval(j10);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public boolean send(String str) {
            return this.f26911a.send(str);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
        public boolean send(byte[] bArr) {
            return this.f26911a.send(bArr);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$j */
    public static class j extends WebSocketListener {

        /* renamed from: a */
        public final WebSocketListener f26912a;

        public j(WebSocketListener webSocketListener) {
            CheckParamUtils.checkNotNull(webSocketListener, "SafeWebSocketListener listener == null");
            this.f26912a = webSocketListener;
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onClosed(WebSocket webSocket, int i10, String str) {
            this.f26912a.onClosed(webSocket, i10, str);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onClosing(WebSocket webSocket, int i10, String str) {
            this.f26912a.onClosing(webSocket, i10, str);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th2, Response<ResponseBody> response) {
            this.f26912a.onFailure(webSocket, th2, response);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            this.f26912a.onMessage(webSocket, str);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onOpen(WebSocket webSocket, Response<ResponseBody> response) {
            this.f26912a.onOpen(webSocket, response);
        }

        @Override // com.huawei.hms.network.httpclient.websocket.WebSocketListener
        public void onMessage(WebSocket webSocket, byte[] bArr) {
            this.f26912a.onMessage(webSocket, bArr);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h1$k */
    public static class k extends ExtLogger {

        /* renamed from: a */
        public final WrapperLogger f26913a;

        public k(WrapperLogger wrapperLogger) {
            CheckParamUtils.checkNotNull(wrapperLogger, "SafeWrapperLogger wrapperLogger == null");
            this.f26913a = wrapperLogger;
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: d */
        public void mo32129d(String str, String str2) {
            this.f26913a.mo32409d(str, str2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: e */
        public void mo32130e(String str, String str2) {
            this.f26913a.mo32410e(str, str2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: i */
        public void mo32132i(String str, String str2) {
            this.f26913a.mo32412i(str, str2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: v */
        public void mo32133v(String str, String str2) {
            this.f26913a.mo32413v(str, str2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: w */
        public void mo32134w(String str, String str2) {
            this.f26913a.mo32414w(str, str2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: e */
        public void mo32131e(String str, String str2, Throwable th2) {
            this.f26913a.mo32411e(str, str2, th2);
        }

        @Override // com.huawei.hms.framework.common.ExtLogger
        /* renamed from: w */
        public void mo32135w(String str, String str2, Throwable th2) {
            this.f26913a.mo32415w(str, str2, th2);
        }
    }

    public static boolean apiAvailable(int i10) {
        Logger.m32143v(f26900a, "Version.getApi = " + Version.getApi());
        return i10 <= Version.getApi();
    }
}
