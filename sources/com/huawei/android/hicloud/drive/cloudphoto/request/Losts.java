package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Losts {
    private Drive drive;

    public static class List extends AbstractC13930g<ChangeList> {
        private static final String REST_PATH = "cloudPhoto/v1/losts";

        @InterfaceC4648p
        private String cursor;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, ChangeList.class);
        }

        public String getCursor() {
            return this.cursor;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            return (List) super.setFields2(str);
        }
    }

    public Losts(Drive drive) {
        this.drive = drive;
    }

    public List list() throws IOException {
        return new List(this.drive);
    }
}
