package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.InformCreateRequest;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Risks {
    private Drive drive;

    public static class InformCreate extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/risks/kinds/{kind}/inform";

        @InterfaceC4648p
        private String kind;

        public InformCreate(Drive drive, InformCreateRequest informCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, informCreateRequest, Void.class);
        }

        public String getKind() {
            return this.kind;
        }

        public InformCreate setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        public InformCreate setKind(String str) {
            this.kind = str;
            return this;
        }
    }

    public Risks(Drive drive) {
        this.drive = drive;
    }

    public InformCreate informCreate(InformCreateRequest informCreateRequest) throws IOException {
        return new InformCreate(this.drive, informCreateRequest);
    }
}
