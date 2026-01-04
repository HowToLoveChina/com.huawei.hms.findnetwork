package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.AssetList;
import com.huawei.android.hicloud.drive.cloudphoto.model.RevisionCreateRequest;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Assets {
    private Drive client;

    public static class Create extends AbstractC13930g<Asset> {
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/assets";

        @InterfaceC4648p
        private String mediaId;

        @InterfaceC4648p
        private String usage;

        public Create(Drive drive, String str, String str2, RevisionCreateRequest revisionCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, revisionCreateRequest, Asset.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
            setFields2((String) C4627a0.m28392e(str2, "Required parameter fields must be specified."));
        }

        public String getMediaId() {
            return this.mediaId;
        }

        public String getUsage() {
            return this.usage;
        }

        public void setMediaId(String str) {
            this.mediaId = str;
        }

        public Create setUsage(String str) {
            this.usage = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Create addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class List extends AbstractC13930g<AssetList> {
        private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/assets";

        @InterfaceC4648p
        private String mediaId;

        @InterfaceC4648p
        private String usage;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, AssetList.class);
        }

        public String getMediaId() {
            return this.mediaId;
        }

        public String getUsage() {
            return this.usage;
        }

        public List setMediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public List setUsage(String str) {
            this.usage = str;
            return this;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return "List{mediaId='" + this.mediaId + "', usage='" + this.usage + "'}";
        }

        public List(Drive drive, String str, String str2, String str3) throws IOException {
            super(drive, "GET", REST_PATH, null, AssetList.class);
            this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
            setFields2((String) C4627a0.m28392e(str2, "Required parameter mediaId must be specified."));
            this.usage = str3;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            super.setFields2(str);
            return this;
        }
    }

    public static class Revisions {
        private Drive client;

        public static class Create extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/assets/{assetId}/revisions";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String mediaId;

            @InterfaceC4648p("xhwattachmentUsage")
            private String usage;

            public Create(Drive drive, String str, String str2, String str3, RevisionCreateRequest revisionCreateRequest) throws IOException {
                super(drive, "POST", REST_PATH, revisionCreateRequest, Asset.class);
                this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                setFields2((String) C4627a0.m28392e(str3, "Required parameter fields must be specified."));
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getMediaId() {
                return this.mediaId;
            }

            public String getUsage() {
                return this.usage;
            }

            public void setAssetId(String str) {
                this.assetId = str;
            }

            public void setMediaId(String str) {
                this.mediaId = str;
            }

            public Create setUsage(String str) {
                this.usage = str;
                return this;
            }

            @Override // p804ya.AbstractC13930g
            public Create addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }
        }

        public static class Get extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String mediaId;

            @InterfaceC4648p
            private String mode;

            @InterfaceC4648p
            private String quotaUser;

            @InterfaceC4648p
            private String versionId;

            public Get(Drive drive) throws IOException {
                super(drive, "GET", REST_PATH, null, Asset.class);
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getMediaId() {
                return this.mediaId;
            }

            public String getMode() {
                return this.mode;
            }

            public String getQuotaUser() {
                return this.quotaUser;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public Get setAssetId(String str) {
                this.assetId = str;
                return this;
            }

            public Get setMediaId(String str) {
                this.mediaId = str;
                return this;
            }

            public Get setMode(String str) {
                this.mode = str;
                return this;
            }

            public Get setQuotaUser(String str) {
                this.quotaUser = str;
                return this;
            }

            public Get setVersionId(String str) {
                this.versionId = str;
                return this;
            }

            @Override // java.util.AbstractMap
            public String toString() {
                return "Get{mediaId='" + this.mediaId + "', assetId='" + this.assetId + "', versionId='" + this.versionId + "', mode='" + this.mode + "', quotaUser='" + this.quotaUser + "'}";
            }

            public Get(Drive drive, String str, String str2, String str3, String str4) throws IOException {
                super(drive, "GET", REST_PATH, null, Asset.class);
                this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str3, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str4, "Required parameter fields must be specified."));
            }

            @Override // p804ya.AbstractC13930g
            public Get addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public Get setFields2(String str) {
                super.setFields2(str);
                return this;
            }
        }

        public static class Update extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/media/{mediaId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String mediaId;

            @InterfaceC4648p
            private String quotaUser;

            @InterfaceC4648p
            private String versionId;

            public Update(Drive drive, String str, String str2, String str3, String str4, Asset asset) throws IOException {
                super(drive, "POST", REST_PATH, asset, Asset.class);
                this.mediaId = (String) C4627a0.m28392e(str, "Required parameter mediaId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str3, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str4, "Required parameter fields must be specified."));
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getMediaId() {
                return this.mediaId;
            }

            public String getQuotaUser() {
                return this.quotaUser;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public Update setAssetId(String str) {
                this.assetId = str;
                return this;
            }

            public Update setMediaId(String str) {
                this.mediaId = str;
                return this;
            }

            public Update setQuotaUser(String str) {
                this.quotaUser = str;
                return this;
            }

            public Update setVersionId(String str) {
                this.versionId = str;
                return this;
            }

            @Override // java.util.AbstractMap
            public String toString() {
                return "Update{mediaId='" + this.mediaId + "', assetId='" + this.assetId + "', versionId='" + this.versionId + "', quotaUser='" + this.quotaUser + "'}";
            }

            @Override // p804ya.AbstractC13930g
            public Update addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public Update setFields2(String str) {
                super.setFields2(str);
                return this;
            }
        }

        public Revisions(Drive drive) {
            this.client = drive;
        }

        public Create create(String str, String str2, String str3, RevisionCreateRequest revisionCreateRequest) throws IOException {
            return new Create(this.client, str, str2, str3, revisionCreateRequest);
        }

        public Get get() throws IOException {
            return new Get(this.client);
        }

        public Update update(String str, String str2, String str3, String str4, Asset asset) throws IOException {
            return new Update(this.client, str, str2, str3, str4, asset);
        }

        public Get get(String str, String str2, String str3, String str4) throws IOException {
            return new Get(this.client, str, str2, str3, str4);
        }
    }

    public Assets(Drive drive) {
        this.client = drive;
    }

    public Create create(String str, String str2, RevisionCreateRequest revisionCreateRequest) throws IOException {
        return new Create(this.client, str, str2, revisionCreateRequest);
    }

    public List list() throws IOException {
        return new List(this.client);
    }

    public Revisions revisions() {
        return new Revisions(this.client);
    }

    public List list(String str, String str2, String str3) throws IOException {
        return new List(this.client, str, str2, str3);
    }
}
