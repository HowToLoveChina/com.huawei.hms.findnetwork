package p693ux;

import java.io.IOException;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.internal.connection.C11935i;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: ux.c */
/* loaded from: classes9.dex */
public interface InterfaceC13278c {
    /* renamed from: a */
    void mo79701a() throws IOException;

    /* renamed from: b */
    void mo79702b(HttpRequestBuilder HttpRequestBuilder) throws IOException;

    /* renamed from: c */
    InterfaceC1076z mo79703c(HttpResponseBuilder HttpResponseBuilder) throws IOException;

    void cancel();

    /* renamed from: d */
    HttpResponseBuilder.a mo79704d(boolean z10) throws IOException;

    /* renamed from: e */
    C11935i mo79705e();

    /* renamed from: f */
    void mo79706f() throws IOException;

    /* renamed from: g */
    long mo79707g(HttpResponseBuilder HttpResponseBuilder) throws IOException;

    /* renamed from: h */
    InterfaceC1074x mo79708h(HttpRequestBuilder HttpRequestBuilder, long j10) throws IOException;
}
