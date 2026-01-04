package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.Channel;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Channels {
    private Drive drive;

    public static class Stop extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/channels/stop";

        public Stop(Drive drive, Channel channel) throws IOException {
            super(drive, "POST", REST_PATH, channel, Void.class);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Stop setFields2(String str) {
            return (Stop) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Stop setForm2(String str) {
            return (Stop) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Stop setPrettyPrint2(Boolean bool) {
            return (Stop) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Stop setQuotaId2(String str) {
            return (Stop) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Stop set(String str, Object obj) {
            return (Stop) super.set(str, obj);
        }
    }

    public Channels(Drive drive) {
        this.drive = drive;
    }

    public Stop stop(Channel channel) throws IOException {
        return new Stop(this.drive, channel);
    }
}
