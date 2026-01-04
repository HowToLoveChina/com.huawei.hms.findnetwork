package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetCreateRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Assets {
    private Drive client;

    public static class Create extends AbstractC9455k<Asset> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String recordId;

        @InterfaceC4648p
        private String usage;

        public Create(Drive drive) throws IOException {
            super(drive, "POST", REST_PATH, null, Asset.class);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public String getUsage() {
            return this.usage;
        }

        public void setDatabase(String str) {
            this.database = str;
        }

        public void setKind(String str) {
            this.kind = str;
        }

        public void setRecordId(String str) {
            this.recordId = str;
        }

        public void setUsage(String str) {
            this.usage = str;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return "Create{database='" + this.database + "', kind='" + this.kind + "', recordId='" + this.recordId + "', usage='" + this.usage + "'}";
        }

        public Create(Drive drive, String str, String str2, String str3, String str4, String str5, Asset asset) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, asset, Asset.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            this.usage = (String) C4627a0.m28392e(str4, "Required parameter usage must be specified.");
            setFields2((String) C4627a0.m28392e(str5, "Required parameter fields must be specified."));
        }
    }

    public static class Delete extends AbstractC9455k<AssetList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets/{assetId}";

        @InterfaceC4648p
        private String assetId;

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String recordId;

        public Delete(Drive drive) throws IOException {
            super(drive, "DELETE", REST_PATH, null, AssetList.class);
        }

        public String getAssetId() {
            return this.assetId;
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public void setAssetId(String str) {
            this.assetId = str;
        }

        public void setDatabase(String str) {
            this.database = str;
        }

        public void setKind(String str) {
            this.kind = str;
        }

        public void setRecordId(String str) {
            this.recordId = str;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return "List{database='" + this.database + "', kind='" + this.kind + "', recordId='" + this.recordId + "', assetId='" + this.assetId + "'}";
        }

        public Delete(Drive drive, String str, String str2, String str3, String str4) throws IOException {
            super(drive, str, str2, "DELETE", REST_PATH, null, AssetList.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            this.assetId = (String) C4627a0.m28392e(str4, "Required parameter assetId must be specified.");
        }
    }

    public static class List extends AbstractC9455k<AssetList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private Integer pageSize;

        @InterfaceC4648p
        private String queryParam;

        @InterfaceC4648p
        private String recordId;

        @InterfaceC4648p
        private String usage;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, AssetList.class);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public String getQueryParam() {
            return this.queryParam;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public String getUsage() {
            return this.usage;
        }

        public void setDatabase(String str) {
            this.database = str;
        }

        public void setKind(String str) {
            this.kind = str;
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        public List setQueryParam(String str) {
            this.queryParam = str;
            return this;
        }

        public void setRecordId(String str) {
            this.recordId = str;
        }

        public void setUsage(String str) {
            this.usage = str;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return "List{database='" + this.database + "', kind='" + this.kind + "', recordId='" + this.recordId + "', usage='" + this.usage + "', pageSize=" + this.pageSize + ", queryParam='" + this.queryParam + "'}";
        }

        public List(Drive drive, String str, String str2, String str3, String str4, String str5) throws IOException {
            super(drive, str, str2, "GET", REST_PATH, null, AssetList.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            this.usage = (String) C4627a0.m28392e(str4, "Required parameter usage must be specified.");
            setFields2((String) C4627a0.m28392e(str5, "Required parameter fields must be specified."));
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

    public static class Revisions {
        private Drive client;

        public static class Create extends AbstractC9455k<Asset> {
            private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets/{assetId}/revisions";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String database;

            @InterfaceC4648p
            private String kind;

            @InterfaceC4648p
            private String recordId;

            public Create(Drive drive, Asset asset) throws IOException {
                super(drive, "POST", REST_PATH, asset, Asset.class);
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getDatabase() {
                return this.database;
            }

            public String getKind() {
                return this.kind;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public void setAssetId(String str) {
                this.assetId = str;
            }

            public void setDatabase(String str) {
                this.database = str;
            }

            public void setKind(String str) {
                this.kind = str;
            }

            public void setRecordId(String str) {
                this.recordId = str;
            }

            @Override // java.util.AbstractMap
            public String toString() {
                return "Create{database=" + this.database + ", kind='" + this.kind + "', recordId='" + this.recordId + "', assetId='" + this.assetId + "'}";
            }

            public Create(Drive drive, String str, String str2, String str3, String str4, String str5, Asset asset) throws IOException {
                super(drive, str, str2, "POST", REST_PATH, asset, Asset.class);
                this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
                this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
                this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str4, "Required parameter assetId must be specified.");
                setFields2((String) C4627a0.m28392e(str5, "Required parameter fields must be specified."));
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public Create setFields2(String str) {
                super.setFields2(str);
                return this;
            }
        }

        public static class Get extends AbstractC9455k<Asset> {
            private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String database;

            @InterfaceC4648p
            private String kind;

            @InterfaceC4648p
            private String recordId;

            @InterfaceC4648p
            private String versionId;

            public Get(Drive drive) throws IOException {
                super(drive, "GET", REST_PATH, null, Asset.class);
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getDatabase() {
                return this.database;
            }

            public String getKind() {
                return this.kind;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public void setAssetId(String str) {
                this.assetId = str;
            }

            public void setDatabase(String str) {
                this.database = str;
            }

            public void setKind(String str) {
                this.kind = str;
            }

            public void setRecordId(String str) {
                this.recordId = str;
            }

            public void setVersionId(String str) {
                this.versionId = str;
            }

            @Override // java.util.AbstractMap
            public String toString() {
                return "Get{database=" + this.database + ", kind='" + this.kind + "', recordId='" + this.recordId + "', assetId='" + this.assetId + "', versionId='" + this.versionId + "'}";
            }

            public Get(Drive drive, String str, String str2, String str3, String str4, String str5, String str6) throws IOException {
                super(drive, str, str2, "GET", REST_PATH, null, Asset.class);
                this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
                this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
                this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str4, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str5, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str6, "Required parameter fields must be specified."));
            }

            @Override // p255ed.AbstractC9455k
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

        public static class Update extends AbstractC9455k<Asset> {
            private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/records/{recordId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String database;

            @InterfaceC4648p
            private String kind;

            @InterfaceC4648p
            private String recordId;

            @InterfaceC4648p
            private String versionId;

            public Update(Drive drive, AssetCreateRequest assetCreateRequest) throws IOException {
                super(drive, "POST", REST_PATH, assetCreateRequest, Asset.class);
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getDatabase() {
                return this.database;
            }

            public String getKind() {
                return this.kind;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public void setAssetId(String str) {
                this.assetId = str;
            }

            public void setDatabase(String str) {
                this.database = str;
            }

            public void setKind(String str) {
                this.kind = str;
            }

            public void setRecordId(String str) {
                this.recordId = str;
            }

            public void setVersionId(String str) {
                this.versionId = str;
            }

            @Override // java.util.AbstractMap
            public String toString() {
                return "Update{database=" + this.database + ", kind='" + this.kind + "', recordId='" + this.recordId + "', assetId='" + this.assetId + "', versionId='" + this.versionId + "'}";
            }

            public Update(Drive drive, String str, String str2, String str3, String str4, String str5, String str6, Asset asset) throws IOException {
                super(drive, str, str2, "POST", REST_PATH, asset, Asset.class);
                this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
                this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
                this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str4, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str5, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str6, "Required parameter fields must be specified."));
            }

            @Override // p255ed.AbstractC9455k
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

        public Create create(Asset asset) throws IOException {
            return new Create(this.client, asset);
        }

        public Get get() throws IOException {
            return new Get(this.client);
        }

        public Update update(AssetCreateRequest assetCreateRequest) throws IOException {
            return new Update(this.client, assetCreateRequest);
        }

        public Create create(String str, String str2, String str3, String str4, String str5, Asset asset) throws IOException {
            return new Create(this.client, str, str2, str3, str4, str5, asset);
        }

        public Get get(String str, String str2, String str3, String str4, String str5, String str6) throws IOException {
            return new Get(this.client, str, str2, str3, str4, str5, str6);
        }

        public Update update(String str, String str2, String str3, String str4, String str5, String str6, Asset asset) throws IOException {
            return new Update(this.client, str, str2, str3, str4, str5, str6, asset);
        }
    }

    public Assets(Drive drive) {
        this.client = drive;
    }

    public Create create() throws IOException {
        return new Create(this.client);
    }

    public Delete delete() throws IOException {
        return new Delete(this.client);
    }

    public List list() throws IOException {
        return new List(this.client);
    }

    public Revisions revisions() {
        return new Revisions(this.client);
    }

    public Create create(String str, String str2, String str3, String str4, String str5, Asset asset) throws IOException {
        return new Create(this.client, str, str2, str3, str4, str5, asset);
    }

    public Delete delete(String str, String str2, String str3, String str4) throws IOException {
        return new Delete(this.client, str, str2, str3, str4);
    }

    public List list(String str, String str2, String str3, String str4, String str5) throws IOException {
        return new List(this.client, str, str2, str3, str4, str5);
    }
}
