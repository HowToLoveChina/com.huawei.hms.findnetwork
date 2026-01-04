package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ChannelStop;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Channels {
    private CloudBackupV3Server client;

    public static class Stop extends CloudBackupV3Request<Void> {
        private static final String REST_PATH = "changes/subscribe";

        public Stop(CloudBackupV3Server cloudBackupV3Server, ChannelStop channelStop) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, channelStop, Void.class);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Void> setFields(String str) {
            return (Stop) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Void> setTraceId(String str) {
            return (Stop) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Stop set(String str, Object obj) {
            return (Stop) super.set(str, obj);
        }
    }

    public Channels(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Stop stop(ChannelStop channelStop) throws IOException {
        return new Stop(this.client, channelStop);
    }
}
