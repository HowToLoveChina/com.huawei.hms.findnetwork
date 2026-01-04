package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.UpsertStatusRequest;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Status {
    private static final String REST_PATH = "cloudPhoto/v1/status";
    private Drive client;

    public static class Upsert extends AbstractC13930g<Void> {
        public Upsert(Drive drive, UpsertStatusRequest upsertStatusRequest) throws IOException {
            super(drive, "POST", Status.REST_PATH, upsertStatusRequest, Void.class);
        }
    }

    public Status(Drive drive) {
        this.client = drive;
    }

    public Upsert upsert(UpsertStatusRequest upsertStatusRequest) throws IOException {
        return new Upsert(this.client, upsertStatusRequest);
    }
}
