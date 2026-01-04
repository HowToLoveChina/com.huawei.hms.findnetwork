package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.ChangeList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Losts {
    private Drive drive;

    public static class List extends AbstractC9455k<ChangeList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/losts";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kinds;

        @InterfaceC4648p
        private Integer pageSize;

        public List(Drive drive, String str, String str2, String str3) throws IOException {
            super(drive, "GET", REST_PATH, null, ChangeList.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kinds = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.cursor = (String) C4627a0.m28392e(str3, "Required parameter cursor must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kinds;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            return (List) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public Losts(Drive drive) {
        this.drive = drive;
    }

    public List list(String str, String str2, String str3) throws IOException {
        return new List(this.drive, str, str2, str3);
    }
}
