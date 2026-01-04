package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.MessageList;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Messages {
    private Drive drive;

    public static class List extends AbstractC13930g<MessageList> {
        private static final String REST_PATH = "cloudPhoto/v1/message";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private String orderBy;

        @InterfaceC4648p
        private Integer pageSize;

        /* renamed from: q */
        @InterfaceC4648p
        private String f12226q;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, MessageList.class);
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getOrderBy() {
            return this.orderBy;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public String getQ() {
            return this.f12226q;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public void setOrderBy(String str) {
            this.orderBy = str;
        }

        public void setPageSize(Integer num) {
            this.pageSize = num;
        }

        public void setQ(String str) {
            this.f12226q = str;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            return (List) super.setFields2(str);
        }
    }

    public Messages(Drive drive) {
        this.drive = drive;
    }

    public List list() throws IOException {
        return new List(this.drive);
    }
}
