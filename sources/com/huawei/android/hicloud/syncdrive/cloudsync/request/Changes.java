package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.ChangeList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.ChangesNotifyRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Cursor;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.Channel;
import com.huawei.hicloud.base.drive.model.ChannelSubscribeRequest;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Changes {
    private Drive drive;

    public static class GetStartCursor extends AbstractC9455k<Cursor> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/getStartCursor";

        @InterfaceC4648p
        private String database;

        public GetStartCursor(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, Cursor.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        @Override // p255ed.AbstractC9455k
        public GetStartCursor addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public GetStartCursor setFields2(String str) {
            return (GetStartCursor) super.setFields2(str);
        }
    }

    public static class List extends AbstractC9455k<ChangeList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/changes";

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
            this.cursor = (String) C4627a0.m28392e(str3, "Required parameter database must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKinds() {
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

    public static class Notify extends AbstractC9455k<Void> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/changes/notify";

        @InterfaceC4648p
        private String database;

        public Notify(Drive drive, String str, ChangesNotifyRequest changesNotifyRequest) throws IOException {
            super(drive, "POST", REST_PATH, changesNotifyRequest, Void.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }
    }

    public static class Subscribe extends AbstractC9455k<Channel> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/changes/subscribe";

        @InterfaceC4648p
        private String database;

        public Subscribe(Drive drive, String str, ChannelSubscribeRequest channelSubscribeRequest) throws IOException {
            super(drive, "POST", REST_PATH, channelSubscribeRequest, Channel.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        @Override // p255ed.AbstractC9455k
        public Subscribe addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public Changes(Drive drive) {
        this.drive = drive;
    }

    public GetStartCursor getStartCursor(String str) throws IOException {
        return new GetStartCursor(this.drive, str);
    }

    public List list(String str, String str2, String str3) throws IOException {
        return new List(this.drive, str, str2, str3);
    }

    public Notify notify(String str, ChangesNotifyRequest changesNotifyRequest) throws IOException {
        return new Notify(this.drive, str, changesNotifyRequest);
    }

    public Subscribe subscribe(String str, ChannelSubscribeRequest channelSubscribeRequest) throws IOException {
        return new Subscribe(this.drive, str, channelSubscribeRequest);
    }
}
