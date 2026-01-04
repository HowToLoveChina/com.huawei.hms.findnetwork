package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import java.io.IOException;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class About {
    private CloudBackupV3Server client;

    public static class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.About> {
        private static final String REST_PATH = "about";

        public Get(CloudBackupV3Server cloudBackupV3Server) throws IOException {
            super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.About.class);
            String strM80790C = C13452e.m80781L().m80790C();
            if (TextUtils.isEmpty(strM80790C)) {
                return;
            }
            getHeaders().set("x-hw-grade", strM80790C);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.About$Get] */
        public Get setBackupAction(String str) {
            return setHeader("backupAction", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.About$Get] */
        public Get setChannel(Integer num) {
            return num == null ? this : setHeader("x-hw-channel", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.About$Get] */
        public Get setForce2V3(Boolean bool) {
            return setHeader("x-hw-force2v3", (Object) bool);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.About> setFields(String str) {
            return (Get) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.About> setForm(String str) {
            return (Get) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.About> setHeader(String str, Object obj) {
            return (Get) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.About> setTraceId(String str) {
            return (Get) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public About(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Get get() throws IOException {
        return new Get(this.client);
    }
}
