package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BatchResponse extends C11707b {

    @InterfaceC4648p
    private List<SingleResponse> batchRes;

    public static class SingleResponse extends C11707b {

        @InterfaceC4648p
        private C11707b httpBody;

        @InterfaceC4648p
        private String httpCode;

        @InterfaceC4648p
        private C4609l httpHeader;

        public C11707b getHttpBody() {
            return this.httpBody;
        }

        public String getHttpCode() {
            return this.httpCode;
        }

        public C4609l getHttpHeader() {
            return this.httpHeader;
        }

        public SingleResponse setHttpBody(C11707b c11707b) {
            this.httpBody = c11707b;
            return this;
        }

        public SingleResponse setHttpCode(String str) {
            this.httpCode = str;
            return this;
        }

        public SingleResponse setHttpHeader(C4609l c4609l) {
            this.httpHeader = c4609l;
            return this;
        }
    }

    public List<SingleResponse> getBatchRes() {
        return this.batchRes;
    }

    public BatchResponse setBatchRes(List<SingleResponse> list) {
        this.batchRes = list;
        return this;
    }
}
