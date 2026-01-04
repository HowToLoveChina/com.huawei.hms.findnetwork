package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.AbstractMap;
import ni.C11707b;

/* loaded from: classes3.dex */
public class SingleRequest<T> extends C11707b {

    @InterfaceC4648p
    private T httpBody;

    @InterfaceC4648p
    private AbstractMap<String, Object> httpHeader;

    @InterfaceC4648p
    private String httpMethod;

    @InterfaceC4648p
    private String url;

    public T getHttpBody() {
        return this.httpBody;
    }

    public AbstractMap<String, Object> getHttpHeader() {
        return this.httpHeader;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHttpBody(T t10) {
        this.httpBody = t10;
    }

    public void setHttpHeader(AbstractMap<String, Object> abstractMap) {
        this.httpHeader = abstractMap;
    }

    public void setHttpMethod(String str) {
        this.httpMethod = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
