package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.Quota;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Quotas {
    private Drive drive;

    public static class Get extends AbstractC13930g<Quota> {
        private static final String REST_PATH = "cloudPhoto/v1/quota";

        @InterfaceC4648p
        private Boolean albumOwner;

        public Get(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, Quota.class);
        }

        public Boolean getAlbumOwner() {
            return this.albumOwner;
        }

        public Get setAlbumOwner(Boolean bool) {
            this.albumOwner = bool;
            return this;
        }
    }

    public Quotas(Drive drive) {
        this.drive = drive;
    }

    public Get get() throws IOException {
        return new Get(this.drive);
    }
}
