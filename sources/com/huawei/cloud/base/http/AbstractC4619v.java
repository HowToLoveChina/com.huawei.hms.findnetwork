package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4650r;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.huawei.cloud.base.http.v */
/* loaded from: classes.dex */
public abstract class AbstractC4619v {
    static final C4650r LOGGER = C4650r.m28485f("HttpTransport");
    private static final String[] SUPPORTED_METHODS;

    static {
        String[] strArr = {"DELETE", "GET", "POST", "PUT"};
        SUPPORTED_METHODS = strArr;
        Arrays.sort(strArr);
    }

    public C4612o buildRequest() {
        return new C4612o(this, null);
    }

    public abstract AbstractC4622y buildRequest(String str, String str2) throws IOException;

    public final C4613p createRequestFactory() {
        return createRequestFactory(null);
    }

    public void shutdown() throws IOException {
    }

    public boolean supportsMethod(String str) throws IOException {
        return Arrays.binarySearch(SUPPORTED_METHODS, str) >= 0;
    }

    public final C4613p createRequestFactory(InterfaceC4614q interfaceC4614q) {
        return new C4613p(this, interfaceC4614q);
    }
}
