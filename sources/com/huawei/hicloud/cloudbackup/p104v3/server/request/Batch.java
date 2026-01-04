package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BatchResponse;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Batch {
    private CloudBackupV3Server client;

    public static class BatchRequest extends CloudBackupV3Request<BatchResponse> {
        private static final String REST_PATH = "cloudbackup/v3/batch";

        public BatchRequest(CloudBackupV3Server cloudBackupV3Server, com.huawei.hicloud.cloudbackup.p104v3.server.model.BatchRequest batchRequest) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, batchRequest, BatchResponse.class);
        }

        @Override // p579qi.AbstractC12361b
        public C4604g buildHttpRequestUrl() {
            return new C4604g(C4597b0.m28167b(getAbstractClient().getRootUrl(), getUriTemplate(), this, true));
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BatchResponse> setFields(String str) {
            return (BatchRequest) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BatchResponse> setForm(String str) {
            return (BatchRequest) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BatchResponse> setTraceId(String str) {
            return (BatchRequest) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public BatchRequest set(String str, Object obj) {
            return (BatchRequest) super.set(str, obj);
        }
    }

    public Batch(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public BatchRequest batch(com.huawei.hicloud.cloudbackup.p104v3.server.model.BatchRequest batchRequest) throws IOException {
        return new BatchRequest(this.client, batchRequest);
    }
}
