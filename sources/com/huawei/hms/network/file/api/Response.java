package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.api.Request;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public class Response<R extends Request, C, T extends Closeable> {
    int code;
    C content;
    Map<String, Object> extraInfo;
    String message;
    T rawResponse;
    private R request;
    Map<String, List<String>> responseHeader;

    public Response(int i10, R r10, T t10, C c10) {
        this(i10, "", r10, t10, c10);
    }

    private void initHeader() {
        T t10 = this.rawResponse;
        if (t10 == null || !(t10 instanceof com.huawei.hms.network.httpclient.Response)) {
            return;
        }
        Map<String, List<String>> headers = ((com.huawei.hms.network.httpclient.Response) t10).getHeaders();
        this.responseHeader = new HashMap();
        if (headers == null || headers.isEmpty()) {
            return;
        }
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            this.responseHeader.put(entry.getKey().toLowerCase(Locale.ROOT), entry.getValue());
        }
    }

    public int getCode() {
        return this.code;
    }

    public C getContent() {
        return this.content;
    }

    public Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public String getMessage() {
        return this.message;
    }

    public T getRawResponse() {
        return this.rawResponse;
    }

    public R getRequest() {
        return this.request;
    }

    public Map<String, List<String>> getResponseHeader() {
        return this.responseHeader;
    }

    public Response(int i10, String str, R r10, T t10, C c10) {
        this.extraInfo = new HashMap();
        this.code = i10;
        this.message = str;
        this.request = r10;
        this.rawResponse = t10;
        this.content = c10;
        initHeader();
    }
}
