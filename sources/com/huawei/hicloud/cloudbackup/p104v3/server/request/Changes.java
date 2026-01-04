package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Channel;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ChannelSubscribe;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Changes {
    private CloudBackupV3Server client;

    public static class Subscribe extends CloudBackupV3Request<Channel> {
        private static final String REST_PATH = "changes/subscribe";

        public Subscribe(CloudBackupV3Server cloudBackupV3Server, ChannelSubscribe channelSubscribe) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, channelSubscribe, Channel.class);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Channel> setFields(String str) {
            return (Subscribe) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Channel> setTraceId(String str) {
            return (Subscribe) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Subscribe set(String str, Object obj) {
            return (Subscribe) super.set(str, obj);
        }
    }

    public Changes(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Subscribe subscribe(ChannelSubscribe channelSubscribe) throws IOException {
        return new Subscribe(this.client, channelSubscribe);
    }
}
