package com.huawei.hicloud.cloudbackup.server.slice;

import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.net.URLDecoder;
import java.util.Map;

/* loaded from: classes6.dex */
public class EndpointURL {
    private String bucketId;
    private Map<String, String> headers;
    private String method;
    private String url;

    private String decode(String str) throws C9721b {
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (Exception unused) {
            throw new C9721b(3107, "url decode error.");
        }
    }

    public String getBucketID() {
        return this.bucketId;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() throws C9721b {
        return decode(this.url);
    }

    public EndpointURL setBucketID(String str) {
        this.bucketId = str;
        return this;
    }

    public EndpointURL setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public EndpointURL setMethod(String str) {
        this.method = str;
        return this;
    }

    public EndpointURL setUrl(String str) {
        this.url = str;
        return this;
    }
}
