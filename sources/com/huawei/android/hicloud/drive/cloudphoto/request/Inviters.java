package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.InviterCreateRequest;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Inviters {
    private Drive drive;

    public static class Create extends AbstractC13930g<Inviter> {
        private static final String REST_PATH = "cloudPhoto/v1/inviter";

        public Create(Drive drive, InviterCreateRequest inviterCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, inviterCreateRequest, Inviter.class);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Create setFields2(String str) {
            return (Create) super.setFields2(str);
        }
    }

    public static class Get extends AbstractC13930g<Inviter> {
        private static final String REST_PATH = "cloudPhoto/v1/inviter";

        public Get(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, Inviter.class);
        }

        @Override // p804ya.AbstractC13930g
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Get setFields2(String str) {
            return (Get) super.setFields2(str);
        }
    }

    public Inviters(Drive drive) {
        this.drive = drive;
    }

    public Create create(InviterCreateRequest inviterCreateRequest) throws IOException {
        return new Create(this.drive, inviterCreateRequest);
    }

    public Get get() throws IOException {
        return new Get(this.drive);
    }
}
