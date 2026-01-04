package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangesNotifyRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cursor;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.Channel;
import com.huawei.hicloud.base.drive.model.ChannelSubscribeRequest;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Changes {
    private Drive drive;

    public static class GetStartCursor extends AbstractC13930g<Cursor> {
        private static final String REST_PATH = "cloudPhoto/v1/changes/getStartCursor";

        public GetStartCursor(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, Cursor.class);
        }

        public GetStartCursor addHeader(String str, String str2) {
            getHeaders().set(str, str2);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public GetStartCursor setFields2(String str) {
            return (GetStartCursor) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public GetStartCursor setForm2(String str) {
            return (GetStartCursor) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public GetStartCursor setPrettyPrint2(Boolean bool) {
            return (GetStartCursor) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public GetStartCursor setQuotaId2(String str) {
            return (GetStartCursor) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public GetStartCursor set(String str, Object obj) {
            return (GetStartCursor) super.set(str, obj);
        }
    }

    public static class List extends AbstractC13930g<ChangeList> {
        private static final String REST_PATH = "cloudPhoto/v1/changes";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private String kinds;

        @InterfaceC4648p
        private Integer pageSize;

        @InterfaceC4648p
        private String queryParam;

        public List(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, ChangeList.class);
            this.cursor = (String) C4627a0.m28392e(str, "Required parameter cursor must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", "3");
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getKinds() {
            return this.kinds;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public String getQueryParam() {
            return this.queryParam;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public List setKinds(String str) {
            this.kinds = str;
            return this;
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        public List setQueryParam(String str) {
            this.queryParam = str;
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

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public List setForm2(String str) {
            return (List) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public List setPrettyPrint2(Boolean bool) {
            return (List) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public List setQuotaId2(String str) {
            return (List) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public static class Notify extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/changes/notify";

        @InterfaceC4648p
        private String containers;

        public Notify(Drive drive, ChangesNotifyRequest changesNotifyRequest) throws IOException {
            super(drive, "POST", REST_PATH, changesNotifyRequest, Void.class);
        }

        public String getContainers() {
            return this.containers;
        }

        public Notify setContainers(String str) {
            this.containers = str;
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Notify setFields2(String str) {
            return (Notify) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Notify setForm2(String str) {
            return (Notify) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Notify setPrettyPrint2(Boolean bool) {
            return (Notify) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Notify setQuotaId2(String str) {
            return (Notify) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Notify set(String str, Object obj) {
            return (Notify) super.set(str, obj);
        }
    }

    public static class Subscribe extends AbstractC13930g<Channel> {
        private static final String REST_PATH = "cloudPhoto/v1/changes/subscribe";

        @InterfaceC4648p
        private String containers;

        @InterfaceC4648p
        private String cursor;

        public Subscribe(Drive drive, String str, ChannelSubscribeRequest channelSubscribeRequest) throws IOException {
            super(drive, "POST", REST_PATH, channelSubscribeRequest, Channel.class);
            this.cursor = (String) C4627a0.m28392e(str, "Required parameter cursor must be specified.");
        }

        public String getContainers() {
            return this.containers;
        }

        public String getCursor() {
            return this.cursor;
        }

        public Subscribe setContainers(String str) {
            this.containers = str;
            return this;
        }

        public Subscribe setCursor(String str) {
            this.cursor = str;
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Subscribe setFields2(String str) {
            return (Subscribe) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Subscribe setForm2(String str) {
            return (Subscribe) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Subscribe setPrettyPrint2(Boolean bool) {
            return (Subscribe) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Subscribe setQuotaId2(String str) {
            return (Subscribe) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Subscribe set(String str, Object obj) {
            return (Subscribe) super.set(str, obj);
        }
    }

    public Changes(Drive drive) {
        this.drive = drive;
    }

    public GetStartCursor getStartCursor() throws IOException {
        return new GetStartCursor(this.drive);
    }

    public List list(String str) throws IOException {
        return new List(this.drive, str);
    }

    public Notify notify(ChangesNotifyRequest changesNotifyRequest) throws IOException {
        return new Notify(this.drive, changesNotifyRequest);
    }

    public Subscribe subscribe(String str, ChannelSubscribeRequest channelSubscribeRequest) throws IOException {
        return new Subscribe(this.drive, str, channelSubscribeRequest);
    }
}
