package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.drive.cloudphoto.model.IdList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Medias {
    private Drive drive;

    public static class Copy extends AbstractC13930g<Media> {
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/copy";

        @InterfaceC4648p
        private String mediaId;

        public Copy(Drive drive, String str, Media media) throws IOException {
            super(drive, "POST", REST_PATH, media, Media.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
        }

        public String getMediaId() {
            return this.mediaId;
        }

        public void setMediaId(String str) {
            this.mediaId = str;
        }

        @Override // p804ya.AbstractC13930g
        public Copy addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Copy setFields2(String str) {
            super.setFields2(str);
            return this;
        }
    }

    public static class Create extends AbstractC13930g<Media> {
        private static final String INTERFACE = "Media.create.metadata";
        private static final String REST_PATH = "cloudPhoto/v1/media";

        @InterfaceC4648p
        private Boolean autoRename;

        @InterfaceC4648p
        private String mode;

        public Create(Drive drive, Media media) throws IOException {
            super(drive, "POST", REST_PATH, media, Media.class);
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        public Boolean getAutoRename() {
            return this.autoRename;
        }

        public String getMode() {
            return this.mode;
        }

        public Create setAutoRename(Boolean bool) {
            this.autoRename = bool;
            return this;
        }

        public Create setMode(String str) {
            this.mode = str;
            return this;
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
    }

    public static class Delete extends AbstractC13930g<Void> {
        private static final String INTERFACE = "Media.delete";
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}";

        @InterfaceC4648p
        private String mediaId;

        public Delete(Drive drive, String str) throws IOException {
            super(drive, "DELETE", REST_PATH, null, Void.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        public String getMediaId() {
            return this.mediaId;
        }

        @Override // p804ya.AbstractC13930g
        public Delete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class EmptyRecycle extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/media/recycle";

        public EmptyRecycle(Drive drive) throws IOException {
            super(drive, "DELETE", REST_PATH, null, Void.class);
        }
    }

    public static class GenerateIds extends AbstractC13930g<IdList> {
        private static final String REST_PATH = "cloudPhoto/v1/media/generateIds";

        public GenerateIds(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, IdList.class);
        }
    }

    public static class Get extends AbstractC13930g<Media> {
        private static final String INTERFACE = "Media.get.metadata";
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}";

        @InterfaceC4648p
        private Boolean acknowledgeDownloadRisk;

        @InterfaceC4648p
        private String mediaId;

        @InterfaceC4648p
        boolean thumbnailInfo;

        public Get(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, Media.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", "3");
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        public Boolean getAcknowledgeDownloadRisk() {
            return this.acknowledgeDownloadRisk;
        }

        public String getMediaId() {
            return this.mediaId;
        }

        public boolean isThumbnailInfo() {
            return this.thumbnailInfo;
        }

        public void setAcknowledgeDownloadRisk(Boolean bool) {
            this.acknowledgeDownloadRisk = bool;
        }

        public void setMediaId(String str) {
            this.mediaId = str;
        }

        public void setThumbnailInfo(boolean z10) {
            this.thumbnailInfo = z10;
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

    public static class List extends AbstractC13930g<MediaList> {
        private static final String INTERFACE = "Media.list";
        private static final String REST_PATH = "cloudPhoto/v1/media";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private String orderBy;

        @InterfaceC4648p
        private Integer pageSize;

        @InterfaceC4648p
        private String queryParam;

        public List(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, MediaList.class);
            getHeaders().set("x-hw-client-cipher-cap", "3");
            getHeaders().set("x-hw-interface", INTERFACE);
            getHeaders().set("x-hw-sync-ptype", str);
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

        public String getQueryParam() {
            return this.queryParam;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public List setOrderBy(String str) {
            this.orderBy = str;
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
    }

    public static class Update extends AbstractC13930g<Media> {
        private static final String INTERFACE = "Media.update.patchmetadata";
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}";

        @InterfaceC4648p
        private Boolean autoRename;

        @InterfaceC4648p
        private Integer baseVersion;

        @InterfaceC4648p
        private String mediaId;

        @InterfaceC4648p
        private Boolean mergeStrategy;

        @InterfaceC4648p
        private String mode;

        public Update(Drive drive, String str, Media media) throws IOException {
            super(drive, RequestMethod.PATCH, REST_PATH, media, Media.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", "3");
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        public Boolean getAutoRename() {
            return this.autoRename;
        }

        public Integer getBaseVersion() {
            return this.baseVersion;
        }

        public String getMediaId() {
            return this.mediaId;
        }

        public Boolean getMergeStrategy() {
            return this.mergeStrategy;
        }

        public String getMode() {
            return this.mode;
        }

        public Update setAutoRename(Boolean bool) {
            this.autoRename = bool;
            return this;
        }

        public Update setBaseVersion(Integer num) {
            this.baseVersion = num;
            return this;
        }

        public void setMediaId(String str) {
            this.mediaId = str;
        }

        public Update setMergeStrategy(Boolean bool) {
            this.mergeStrategy = bool;
            return this;
        }

        public Update setMode(String str) {
            this.mode = str;
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
    }

    public Medias(Drive drive) {
        this.drive = drive;
    }

    public Copy copy(String str, Media media) throws IOException {
        return new Copy(this.drive, str, media);
    }

    public Create create(Media media) throws IOException {
        return new Create(this.drive, media);
    }

    public Delete delete(String str) throws IOException {
        return new Delete(this.drive, str);
    }

    public EmptyRecycle emptyRecycle() throws IOException {
        return new EmptyRecycle(this.drive);
    }

    public GenerateIds generateIds() throws IOException {
        return new GenerateIds(this.drive);
    }

    public Get get(String str) throws IOException {
        return new Get(this.drive, str);
    }

    public List list(String str) throws IOException {
        return new List(this.drive, str);
    }

    public Update update(String str, Media media) throws IOException {
        return new Update(this.drive, str, media);
    }
}
