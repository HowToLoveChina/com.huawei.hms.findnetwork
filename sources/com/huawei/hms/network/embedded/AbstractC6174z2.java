package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.z2 */
/* loaded from: classes8.dex */
public abstract class AbstractC6174z2 {
    public static final int ALL_LISTENER_FINISH = 3;
    public static final int NET_LIB_LISTENER_FINISH = 1;
    public static final AbstractC6174z2 NONE = new a();
    public static final int RCEVENT_LISTENER_FINISH = 2;

    /* renamed from: com.huawei.hms.network.embedded.z2$a */
    public class a extends AbstractC6174z2 {
    }

    /* renamed from: com.huawei.hms.network.embedded.z2$b */
    public class b implements c {
        public b() {
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6174z2.c
        public AbstractC6174z2 create(Submit submit) {
            return AbstractC6174z2.this;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.z2$c */
    public interface c {
        AbstractC6174z2 create(Submit submit);
    }

    public static c factory(AbstractC6174z2 abstractC6174z2) {
        return abstractC6174z2.new b();
    }

    public void acquireClient(C5844a1 c5844a1) {
    }

    public void acquireRequestEnd(C5939h1.d dVar) {
    }

    public void acquireRequestStart() {
    }

    public void callEnd(Response response) {
    }

    public void callFailed(Exception exc) {
    }

    public void callFinishAtNetLib(int i10) {
    }

    public void callStart() {
    }

    public void cancel() {
    }

    public void convertGrsEnd(String str) {
    }

    public void convertGrsStart(String str) {
    }

    public void cpApplicationInterceptorReqEnd() {
    }

    public void cpApplicationInterceptorResEnd() {
    }

    public void cpApplicationInterceptorResStart() {
    }

    public void cpNetworkInterceptorReqEnd() {
    }

    public void cpNetworkInterceptorReqStart() {
    }

    public void cpNetworkInterceptorResEnd() {
    }

    public void cpNetworkInterceptorResStart() {
    }

    public void rcNetworkInterceptorReqEnd(C5939h1.d dVar) {
    }

    public void rcNetworkInterceptorResStart() {
    }

    public void recordCpApplicationInterceptorNums(int i10) {
    }

    public void recordCpNetworkInterceptorNums(int i10) {
    }

    public void responseBodyEnd() {
    }

    public void responseFailed() {
    }

    public void retryInterceptorEnd(Response response, C5844a1 c5844a1) {
    }

    public void retryInterceptorFailed(IOException iOException) {
    }

    public void retryInterceptorStart(Request request, InterfaceC5886d1 interfaceC5886d1, long j10) {
    }

    public void traceResponseNetworkKitInEvent(String str, String str2) {
    }

    public void traceResponseNetworkKitOutEvent(String str) {
    }
}
