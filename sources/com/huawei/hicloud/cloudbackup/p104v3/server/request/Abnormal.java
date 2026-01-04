package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Abnormal {
    private CloudBackupV3Server client;

    public class Data {

        public class ScanLost extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "abnormal/data/scanLost";
            private static final String SERVER_PATH = "cloudbackup/v3/";

            public ScanLost(CloudBackupV3Server cloudBackupV3Server, com.huawei.hicloud.cloudbackup.p104v3.server.model.ScanLost scanLost) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, scanLost, Void.class);
            }

            @Override // p579qi.AbstractC12361b
            public C4604g buildHttpRequestUrl() {
                return new C4604g(C4597b0.m28167b(getAbstractClient().getRootUrl() + SERVER_PATH, getUriTemplate(), this, true));
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public String getRequestUrl() {
                return C4597b0.m28167b(SERVER_PATH, getUriTemplate(), this, true);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setFields(String str) {
                return (ScanLost) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setForm(String str) {
                return (ScanLost) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                return (ScanLost) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setTraceId(String str) {
                return (ScanLost) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public ScanLost set(String str, Object obj) {
                return (ScanLost) super.set(str, obj);
            }
        }

        public Data() {
        }

        public ScanLost scanLost(com.huawei.hicloud.cloudbackup.p104v3.server.model.ScanLost scanLost) throws IOException {
            return new ScanLost(Abnormal.this.client, scanLost);
        }
    }

    public Abnormal(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Data data() {
        return new Data();
    }
}
