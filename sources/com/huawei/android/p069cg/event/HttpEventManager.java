package com.huawei.android.p069cg.event;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ni.C11707b;

/* loaded from: classes2.dex */
public class HttpEventManager {

    /* renamed from: a */
    public final Map<String, HttpEvent> f10968a;

    public static class HttpEvent extends C11707b {

        @InterfaceC4648p
        private List<String> callEnd;

        @InterfaceC4648p
        private List<String> callFailed;

        @InterfaceC4648p
        private List<String> callStart;

        @InterfaceC4648p
        private List<String> connectEnd;

        @InterfaceC4648p
        private List<String> connectFailed;

        @InterfaceC4648p
        private List<String> connectStart;

        @InterfaceC4648p
        private List<String> connectionAcquired;

        @InterfaceC4648p
        private List<String> connectionReleased;

        @InterfaceC4648p
        private List<String> dnsEnd;

        @InterfaceC4648p
        private List<String> dnsStart;

        @InterfaceC4648p
        private List<String> requestBodyEnd;

        @InterfaceC4648p
        private List<String> requestBodyStart;

        @InterfaceC4648p
        private List<String> requestFailed;

        @InterfaceC4648p
        private List<String> requestHeadersEnd;

        @InterfaceC4648p
        private List<String> requestHeadersStart;

        @InterfaceC4648p
        private List<String> responseBodyEnd;

        @InterfaceC4648p
        private List<String> responseBodyStart;

        @InterfaceC4648p
        private List<String> responseFailed;

        @InterfaceC4648p
        private List<String> responseHeadersEnd;

        @InterfaceC4648p
        private List<String> responseHeadersStart;

        @InterfaceC4648p
        private List<String> secureConnectEnd;

        @InterfaceC4648p
        private List<String> secureConnectStart;

        public List<String> getCallEnd() {
            if (this.callEnd == null) {
                this.callEnd = new ArrayList();
            }
            return this.callEnd;
        }

        public List<String> getCallFailed() {
            if (this.callFailed == null) {
                this.callFailed = new ArrayList();
            }
            return this.callFailed;
        }

        public List<String> getCallStart() {
            if (this.callStart == null) {
                this.callStart = new ArrayList();
            }
            return this.callStart;
        }

        public List<String> getConnectEnd() {
            if (this.connectEnd == null) {
                this.connectEnd = new ArrayList();
            }
            return this.connectEnd;
        }

        public List<String> getConnectFailed() {
            if (this.connectFailed == null) {
                this.connectFailed = new ArrayList();
            }
            return this.connectFailed;
        }

        public List<String> getConnectStart() {
            if (this.connectStart == null) {
                this.connectStart = new ArrayList();
            }
            return this.connectStart;
        }

        public List<String> getConnectionAcquired() {
            if (this.connectionAcquired == null) {
                this.connectionAcquired = new ArrayList();
            }
            return this.connectionAcquired;
        }

        public List<String> getConnectionReleased() {
            if (this.connectionReleased == null) {
                this.connectionReleased = new ArrayList();
            }
            return this.connectionReleased;
        }

        public List<String> getDnsEnd() {
            if (this.dnsEnd == null) {
                this.dnsEnd = new ArrayList();
            }
            return this.dnsEnd;
        }

        public List<String> getDnsStart() {
            if (this.dnsStart == null) {
                this.dnsStart = new ArrayList();
            }
            return this.dnsStart;
        }

        public List<String> getRequestBodyEnd() {
            if (this.requestBodyEnd == null) {
                this.requestBodyEnd = new ArrayList();
            }
            return this.requestBodyEnd;
        }

        public List<String> getRequestBodyStart() {
            if (this.requestBodyStart == null) {
                this.requestBodyStart = new ArrayList();
            }
            return this.requestBodyStart;
        }

        public List<String> getRequestFailed() {
            if (this.requestFailed == null) {
                this.requestFailed = new ArrayList();
            }
            return this.requestFailed;
        }

        public List<String> getRequestHeadersEnd() {
            if (this.requestHeadersEnd == null) {
                this.requestHeadersEnd = new ArrayList();
            }
            return this.requestHeadersEnd;
        }

        public List<String> getRequestHeadersStart() {
            if (this.requestHeadersStart == null) {
                this.requestHeadersStart = new ArrayList();
            }
            return this.requestHeadersStart;
        }

        public List<String> getResponseBodyEnd() {
            if (this.responseBodyEnd == null) {
                this.responseBodyEnd = new ArrayList();
            }
            return this.responseBodyEnd;
        }

        public List<String> getResponseBodyStart() {
            if (this.responseBodyStart == null) {
                this.responseBodyStart = new ArrayList();
            }
            return this.responseBodyStart;
        }

        public List<String> getResponseFailed() {
            if (this.responseFailed == null) {
                this.responseFailed = new ArrayList();
            }
            return this.responseFailed;
        }

        public List<String> getResponseHeadersEnd() {
            if (this.responseHeadersEnd == null) {
                this.responseHeadersEnd = new ArrayList();
            }
            return this.responseHeadersEnd;
        }

        public List<String> getResponseHeadersStart() {
            if (this.responseHeadersStart == null) {
                this.responseHeadersStart = new ArrayList();
            }
            return this.responseHeadersStart;
        }

        public List<String> getSecureConnectEnd() {
            if (this.secureConnectEnd == null) {
                this.secureConnectEnd = new ArrayList();
            }
            return this.secureConnectEnd;
        }

        public List<String> getSecureConnectStart() {
            if (this.secureConnectStart == null) {
                this.secureConnectStart = new ArrayList();
            }
            return this.secureConnectStart;
        }

        public HttpEvent setCallEnd(List<String> list) {
            this.callEnd = list;
            return this;
        }

        public HttpEvent setCallFailed(List<String> list) {
            this.callFailed = list;
            return this;
        }

        public HttpEvent setCallStart(List<String> list) {
            this.callStart = list;
            return this;
        }

        public HttpEvent setConnectEnd(List<String> list) {
            this.connectEnd = list;
            return this;
        }

        public HttpEvent setConnectFailed(List<String> list) {
            this.connectFailed = list;
            return this;
        }

        public HttpEvent setConnectStart(List<String> list) {
            this.connectStart = list;
            return this;
        }

        public HttpEvent setConnectionAcquired(List<String> list) {
            this.connectionAcquired = list;
            return this;
        }

        public HttpEvent setConnectionReleased(List<String> list) {
            this.connectionReleased = list;
            return this;
        }

        public HttpEvent setDnsEnd(List<String> list) {
            this.dnsEnd = list;
            return this;
        }

        public HttpEvent setDnsStart(List<String> list) {
            this.dnsStart = list;
            return this;
        }

        public HttpEvent setRequestBodyEnd(List<String> list) {
            this.requestBodyEnd = list;
            return this;
        }

        public HttpEvent setRequestBodyStart(List<String> list) {
            this.requestBodyStart = list;
            return this;
        }

        public HttpEvent setRequestFailed(List<String> list) {
            this.requestFailed = list;
            return this;
        }

        public HttpEvent setRequestHeadersEnd(List<String> list) {
            this.requestHeadersEnd = list;
            return this;
        }

        public HttpEvent setRequestHeadersStart(List<String> list) {
            this.requestHeadersStart = list;
            return this;
        }

        public HttpEvent setResponseBodyEnd(List<String> list) {
            this.responseBodyEnd = list;
            return this;
        }

        public HttpEvent setResponseBodyStart(List<String> list) {
            this.responseBodyStart = list;
            return this;
        }

        public HttpEvent setResponseFailed(List<String> list) {
            this.responseFailed = list;
            return this;
        }

        public HttpEvent setResponseHeadersEnd(List<String> list) {
            this.responseHeadersEnd = list;
            return this;
        }

        public HttpEvent setResponseHeadersStart(List<String> list) {
            this.responseHeadersStart = list;
            return this;
        }

        public HttpEvent setSecureConnectEnd(List<String> list) {
            this.secureConnectEnd = list;
            return this;
        }

        public HttpEvent setSecureConnectStart(List<String> list) {
            this.secureConnectStart = list;
            return this;
        }
    }

    /* renamed from: com.huawei.android.cg.event.HttpEventManager$b */
    public static class C2276b {

        /* renamed from: a */
        public static final HttpEventManager f10969a = new HttpEventManager();
    }

    /* renamed from: b */
    public static HttpEventManager m14396b() {
        return C2276b.f10969a;
    }

    /* renamed from: a */
    public HttpEvent m14397a(String str) {
        HttpEvent httpEvent = this.f10968a.get(str);
        if (httpEvent != null) {
            return httpEvent;
        }
        HttpEvent httpEvent2 = new HttpEvent();
        this.f10968a.put(str, httpEvent2);
        return httpEvent2;
    }

    /* renamed from: c */
    public HttpEvent m14398c(String str) {
        return this.f10968a.remove(str);
    }

    public HttpEventManager() {
        this.f10968a = new ConcurrentHashMap();
    }
}
