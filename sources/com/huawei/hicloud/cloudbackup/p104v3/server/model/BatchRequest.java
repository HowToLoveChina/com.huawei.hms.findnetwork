package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BatchRequest extends C11707b {

    @InterfaceC4648p
    private List<SingleRequest> batchReq;

    public static class SingleRequest<T> extends C11707b {

        @InterfaceC4648p
        private T httpBody;

        @InterfaceC4648p
        private Map<String, List> httpHeader;

        @InterfaceC4648p
        private String httpMethod;

        @InterfaceC4648p
        private String url;

        public T getHttpBody() {
            return this.httpBody;
        }

        public Map<String, List> getHttpHeader() {
            return this.httpHeader;
        }

        public String getHttpMethod() {
            return this.httpMethod;
        }

        public String getUrl() {
            return this.url;
        }

        public SingleRequest<T> setHttpBody(T t10) {
            this.httpBody = t10;
            return this;
        }

        public SingleRequest<T> setHttpHeader(Map<String, List> map) {
            this.httpHeader = map;
            return this;
        }

        public SingleRequest<T> setHttpMethod(String str) {
            this.httpMethod = str;
            return this;
        }

        public SingleRequest<T> setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public List<SingleRequest> getBatchReq() {
        return this.batchReq;
    }

    public BatchRequest setBatchReq(List<SingleRequest> list) {
        this.batchReq = list;
        return this;
    }
}
