package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.Channel;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Channels {
    private Drive drive;

    public static class Stop extends AbstractC9455k<Void> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/channels/stop";

        @InterfaceC4648p
        String database;

        public Stop(Drive drive, String str, Channel channel) throws IOException {
            super(drive, "POST", REST_PATH, channel, Void.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }
    }

    public Channels(Drive drive) {
        this.drive = drive;
    }

    public Stop stop(String str, Channel channel) throws IOException {
        return new Stop(this.drive, str, channel);
    }
}
