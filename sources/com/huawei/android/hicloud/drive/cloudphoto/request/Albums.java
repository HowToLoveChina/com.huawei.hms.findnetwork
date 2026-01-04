package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumBatchId;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumsList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p765x7.C13719a;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Albums {
    private Drive drive;

    public static class BatchIds extends AbstractC13930g<AlbumBatchId> {
        private static final String REST_PATH = "/cloudPhoto/v1/albums/{albumId}/batchId";

        @InterfaceC4648p
        private String albumId;

        public BatchIds(Drive drive) throws IOException {
            super(drive, "POST", REST_PATH, null, AlbumBatchId.class);
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public BatchIds setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public BatchIds setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class Create extends AbstractC13930g<Album> {
        private static final String REST_PATH = "cloudPhoto/v1/albums";

        public Create(Drive drive, Album album, String str) throws IOException {
            super(drive, "POST", REST_PATH, album, Album.class);
            setFields2((String) C4627a0.m28392e(str, "Required parameter fields must be specified."));
        }

        @Override // p804ya.AbstractC13930g
        public Create addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Create setFields2(String str) {
            return (Create) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Create setForm2(String str) {
            return (Create) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Create setPrettyPrint2(Boolean bool) {
            return (Create) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Create setQuotaId2(String str) {
            return (Create) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Create set(String str, Object obj) {
            return (Create) super.set(str, obj);
        }
    }

    public static class Delete extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}";

        @InterfaceC4648p
        private String albumId;

        public Delete(Drive drive, String str) throws IOException {
            super(drive, "DELETE", REST_PATH, null, Void.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public Delete setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Delete setDeleteMode(boolean z10) {
            getHeaders().set("x-hw-delete-mode", z10 ? "delete" : "recycle");
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Delete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Delete setFields2(String str) {
            return (Delete) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Delete setForm2(String str) {
            return (Delete) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Delete setPrettyPrint2(Boolean bool) {
            return (Delete) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Delete setQuotaId2(String str) {
            return (Delete) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Delete set(String str, Object obj) {
            return (Delete) super.set(str, obj);
        }
    }

    public static class Get extends AbstractC13930g<Album> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private Integer albumType;

        @InterfaceC4648p
        private Boolean includeDeleted;

        public Get(Drive drive, String str, String str2) throws IOException {
            super(drive, "GET", REST_PATH, null, Album.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
            setFields2((String) C4627a0.m28392e(str2, "Required parameter fields must be specified."));
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public Integer getAlbumType() {
            return this.albumType;
        }

        public Boolean getIncludeDeleted() {
            return this.includeDeleted;
        }

        public Get setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Get setAlbumType(Integer num) {
            this.albumType = num;
            return this;
        }

        public Get setIncludeDeleted(Boolean bool) {
            this.includeDeleted = bool;
            return this;
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

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Get setForm2(String str) {
            return (Get) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Get setPrettyPrint2(Boolean bool) {
            return (Get) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Get setQuotaId2(String str) {
            return (Get) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public static class List extends AbstractC13930g<AlbumsList> {
        private static final String REST_PATH = "cloudPhoto/v1/albums";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private Boolean includeDeleted;

        @InterfaceC4648p
        private String orderBy;

        @InterfaceC4648p
        private String queryParam;

        public List(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, AlbumsList.class);
            setFields2((String) C4627a0.m28392e(str, "Required parameter fields must be specified."));
        }

        public String getCursor() {
            return this.cursor;
        }

        public Boolean getIncludeDeleted() {
            return this.includeDeleted;
        }

        public String getOrderBy() {
            return this.orderBy;
        }

        public String getQueryParam() {
            return this.queryParam;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public List setIncludeDeleted(Boolean bool) {
            this.includeDeleted = bool;
            return this;
        }

        public List setOrderBy(String str) {
            this.orderBy = str;
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

    public static class Update extends AbstractC13930g<Album> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private boolean autoRename;

        @InterfaceC4648p
        private Integer baseVersion;

        @InterfaceC4648p
        private String mergeStrategy;

        public Update(Drive drive, String str, Album album) throws IOException {
            super(drive, RequestMethod.PATCH, REST_PATH, album, Album.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
            C4627a0.m28392e(album, "Required parameter albumUpdateRequest must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public Integer getBaseVersion() {
            return this.baseVersion;
        }

        public String getMergeStrategy() {
            return this.mergeStrategy;
        }

        public boolean isAutoRename() {
            return this.autoRename;
        }

        public Update setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Update setAutoRename(boolean z10) {
            this.autoRename = z10;
            return this;
        }

        public Update setBaseVersion(Integer num) {
            this.baseVersion = num;
            return this;
        }

        public Update setMergeStrategy(String str) {
            this.mergeStrategy = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Update addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Update setFields2(String str) {
            return (Update) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Update setForm2(String str) {
            return (Update) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Update setPrettyPrint2(Boolean bool) {
            return (Update) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Update setQuotaId2(String str) {
            return (Update) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Update set(String str, Object obj) {
            return (Update) super.set(str, obj);
        }
    }

    public Albums(Drive drive) {
        this.drive = drive;
    }

    public BatchIds batchIds() throws IOException {
        return new BatchIds(this.drive);
    }

    public Create create(Album album, String str) throws IOException {
        return new Create(this.drive, album, str);
    }

    public Delete delete(String str) throws IOException {
        return new Delete(this.drive, str);
    }

    public Get get(String str, String str2) throws IOException {
        return new Get(this.drive, str, str2);
    }

    public List list(String str) throws IOException {
        return new List(this.drive, str);
    }

    public Update update(String str, Album album) throws IOException {
        return new Update(this.drive, str, album);
    }
}
