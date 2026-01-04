package com.huawei.android.hicloud.drive.clouddisk.expand;

import android.content.Context;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.drive.clouddisk.model.Asset;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchFilesRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchFilesResponse;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.ObjectStorageAddress;
import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.cloud.services.drive.model.FileList;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import fk.C9721b;
import java.io.IOException;
import p340hi.C10209a;
import p579qi.InterfaceC12362c;

/* loaded from: classes3.dex */
public class DriveExpand extends Drive {
    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String TAG = "DriveExpand";

    public class BatchUpdate extends DriveRequest<BatchFilesResponse> {
        private static final String REST_PATH = "batchUpdate";

        public BatchUpdate(BatchFilesRequest batchFilesRequest) {
            super(DriveExpand.this, "POST", REST_PATH, batchFilesRequest, BatchFilesResponse.class);
        }

        public BatchUpdate addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public DriveRequest<BatchFilesResponse> setFields2(String str) {
            super.setFields2(str);
            return this;
        }
    }

    public class Revisions {

        public class Get extends DriveRequest<Asset> {
            private static final String REST_PATH = "files/{fileId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String mode;

            @InterfaceC4648p
            private String versionId;

            public Get(Drive drive, String str, String str2, String str3, String str4) throws IOException {
                super(drive, "GET", REST_PATH, null, Asset.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str3, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str4, "Required parameter fields must be specified."));
            }

            public Get addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getMode() {
                return this.mode;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public Get setAssetId(String str) {
                this.assetId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setMode(String str) {
                this.mode = str;
                return this;
            }

            public Get setVersionId(String str) {
                this.versionId = str;
                return this;
            }
        }

        public Revisions() {
        }

        public Get get(String str, String str2, String str3, String str4) throws IOException {
            Get get = new Get(DriveExpand.this, str, str2, str3, str4);
            DriveExpand.this.initialize(get);
            return get;
        }
    }

    public DriveExpand(Builder builder) {
        super(builder);
    }

    public BatchUpdate batchUpdate(BatchFilesRequest batchFilesRequest) throws IOException {
        BatchUpdate batchUpdate = new BatchUpdate(batchFilesRequest);
        initialize(batchUpdate);
        return batchUpdate;
    }

    public FilesExpand filesExpand() {
        return new FilesExpand();
    }

    public Objects objects() {
        return new Objects();
    }

    public Revisions revisions() {
        return new Revisions();
    }

    public static final class Builder extends Drive.Builder {
        public Builder(C10209a c10209a, Context context) {
            super(c10209a, context);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public DriveExpand build() {
            return new DriveExpand(this);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setBaseRequestInitializer(InterfaceC12362c interfaceC12362c) {
            return (Builder) super.setBaseRequestInitializer(interfaceC12362c);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setHttpRequestInitializer(InterfaceC4614q interfaceC4614q) {
            return (Builder) super.setHttpRequestInitializer(interfaceC4614q);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setIgnoreRequiredParameterVerify(boolean z10) {
            return (Builder) super.setIgnoreRequiredParameterVerify(z10);
        }
    }

    public class FilesExpand extends Drive.Files {

        public class DownloadProcess extends C4646n {
            private MediaDownloader mediaDownloader;

            public DownloadProcess(FileExpand fileExpand, String str, String str2, String str3) {
                this.mediaDownloader = new MediaDownloader(DriveExpand.this, fileExpand, str, str2, str3);
            }

            public void executeContentAndDownloadTo(C4602e c4602e, boolean z10, boolean z11) throws C9721b {
                if (!z10) {
                    this.mediaDownloader.setFileContent(c4602e);
                    this.mediaDownloader.download(z11);
                    return;
                }
                Retry retry = new Retry(2);
                do {
                    try {
                        this.mediaDownloader.setFileContent(c4602e);
                        this.mediaDownloader.download(z11);
                        return;
                    } catch (C9721b e10) {
                        retry.m16238g(e10.m60663g());
                        if (1001 == e10.m60659c() || 401 == e10.m60663g() || 1007 == e10.m60659c()) {
                            break;
                        }
                        throw e10;
                    }
                } while (retry.m16232a());
                throw e10;
            }

            public MediaDownloader getMediaDownloader() {
                return this.mediaDownloader;
            }
        }

        public class GetEx extends DriveRequest<FileExpand> {
            private static final String REST_PATH = "files/{fileId}";

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String usage;

            public GetEx(String str) {
                super(DriveExpand.this, "GET", REST_PATH, null, FileExpand.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public GetEx addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getUsage() {
                return this.usage;
            }

            public GetEx setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public GetEx setUsage(String str) {
                this.usage = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<FileExpand> setFields2(String str) {
                return (GetEx) super.setFields2(str);
            }
        }

        public FilesExpand() {
            super();
        }

        public DownloadProcess downloadProcess(FileExpand fileExpand, String str, String str2, String str3) {
            return new DownloadProcess(fileExpand, str, str2, str3);
        }

        public GenerateIds generateIds() throws IOException {
            return new GenerateIds();
        }

        public GetDownloadAddress getDownloadAddress(String str) throws IOException {
            GetDownloadAddress getDownloadAddress = new GetDownloadAddress(str);
            DriveExpand.this.initialize(getDownloadAddress);
            return getDownloadAddress;
        }

        public GetEx getEx(String str) throws IOException {
            GetEx getEx = new GetEx(str);
            DriveExpand.this.initialize(getEx);
            return getEx;
        }

        public ListDuplicate listDuplicate() throws IOException {
            ListDuplicate listDuplicate = new ListDuplicate();
            DriveExpand.this.initialize(listDuplicate);
            return listDuplicate;
        }

        public class GenerateIds extends DriveRequest<FileExpand> {
            private static final String REST_PATH = "files/generateIds";

            public GenerateIds() {
                super(DriveExpand.this, "GET", REST_PATH, null, FileExpand.class);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public GenerateIds set(String str, Object obj) {
                return (GenerateIds) super.set(str, obj);
            }
        }

        public class GetDownloadAddress extends DriveRequest<FileExpand> {
            private static final String REST_PATH = "files/{fileId}/downloadAddress";

            @InterfaceC4648p
            private String fileId;

            public GetDownloadAddress(String str) {
                super(DriveExpand.this, "GET", REST_PATH, null, FileExpand.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public GetDownloadAddress setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public GetDownloadAddress set(String str, Object obj) {
                return (GetDownloadAddress) super.set(str, obj);
            }
        }

        public class ListDuplicate extends DriveRequest<FileList> {
            private static final String REST_PATH = "files/duplicate";

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Long minLength;

            @InterfaceC4648p
            private Integer pageSize;

            public ListDuplicate() {
                super(DriveExpand.this, "GET", REST_PATH, null, FileList.class);
            }

            public Long getMinLength() {
                return this.minLength;
            }

            public ListDuplicate setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public ListDuplicate setMinLength(Long l10) {
                this.minLength = l10;
                return this;
            }

            public ListDuplicate setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public ListDuplicate set(String str, Object obj) {
                return (ListDuplicate) super.set(str, obj);
            }
        }
    }

    public class Objects {

        public class GetUser extends DriveRequest<User> {
            private static final String REST_PATH = "HiCloudUserInformationService/v1/users";

            public GetUser() throws IOException {
                super(DriveExpand.this, "GET", REST_PATH, null, User.class);
            }

            public GetUser addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }

            @Override // p579qi.AbstractC12361b
            public C4604g buildHttpRequestUrl() {
                return new C4604g(C4597b0.m28167b(DriveExpand.this.getRootUrl() + "", REST_PATH, this, true));
            }
        }

        public Objects() {
        }

        public GetObsAddress getObsAddress() throws IOException {
            GetObsAddress getObsAddress = new GetObsAddress();
            DriveExpand.this.initialize(getObsAddress);
            return getObsAddress;
        }

        public GetUser getUser() throws IOException {
            GetUser getUser = new GetUser();
            DriveExpand.this.getBaseRequestInitializer().initialize(getUser);
            return getUser;
        }

        public class GetObsAddress extends DriveRequest<ObjectStorageAddress> {
            private static final String REST_PATH = "objects/{objectId}/obsAddress";

            @InterfaceC4648p
            private String contentMd5;

            @InterfaceC4648p
            private String contentSha256;

            @InterfaceC4648p
            private String loadType;

            @InterfaceC4648p
            private String objectBucketId;

            @InterfaceC4648p
            private String objectId;

            @InterfaceC4648p
            private Long objectSize;

            @InterfaceC4648p
            private String recordCursor;

            @InterfaceC4648p("syncKey")
            private String synckey;

            @InterfaceC4648p
            private String timeStamp;

            public GetObsAddress() {
                super(DriveExpand.this, "GET", REST_PATH, null, ObjectStorageAddress.class);
            }

            public String getContentMd5() {
                return this.contentMd5;
            }

            public String getContentSha256() {
                return this.contentSha256;
            }

            public String getLoadType() {
                return this.loadType;
            }

            public String getObjectBucketId() {
                return this.objectBucketId;
            }

            public String getObjectId() {
                return this.objectId;
            }

            public Long getObjectSize() {
                return this.objectSize;
            }

            public String getRecordCursor() {
                return this.recordCursor;
            }

            public String getSynckey() {
                return this.synckey;
            }

            public String getTimeStamp() {
                return this.timeStamp;
            }

            public GetObsAddress setContentMd5(String str) {
                this.contentMd5 = str;
                return this;
            }

            public GetObsAddress setContentSha256(String str) {
                this.contentSha256 = str;
                return this;
            }

            public GetObsAddress setLoadType(String str) {
                this.loadType = str;
                return this;
            }

            public GetObsAddress setObjectBucketId(String str) {
                this.objectBucketId = str;
                return this;
            }

            public GetObsAddress setObjectId(String str) {
                this.objectId = str;
                return this;
            }

            public GetObsAddress setObjectSize(Long l10) {
                this.objectSize = l10;
                return this;
            }

            public void setRecordCursor(String str) {
                this.recordCursor = str;
            }

            public void setSiteId(String str) {
                super.getHeaders().set(HwPayConstant.KEY_SITE_ID, str);
            }

            public GetObsAddress setSynckey(String str) {
                this.synckey = str;
                return this;
            }

            public GetObsAddress setTimeStamp(String str) {
                this.timeStamp = str;
                return this;
            }

            public void setVia(String str) {
                super.getHeaders().set("via", str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public GetObsAddress set(String str, Object obj) {
                return (GetObsAddress) super.set(str, obj);
            }
        }
    }
}
