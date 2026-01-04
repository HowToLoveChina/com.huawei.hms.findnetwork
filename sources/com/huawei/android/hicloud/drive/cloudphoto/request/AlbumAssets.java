package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.AssetList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class AlbumAssets {
    private Drive client;

    public static class Create extends AbstractC13930g<Asset> {
        private static final String REST_PATH = "cloudPhoto/v1/album/{albumId}/assets";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private String usage;

        public Create(Drive drive, String str, String str2, String str3, Asset asset) throws IOException {
            super(drive, "POST", REST_PATH, asset, Asset.class);
            this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
            setFields2((String) C4627a0.m28392e(str2, "Required parameter fields must be specified."));
            this.usage = (String) C4627a0.m28392e(str3, "Required parameter usage must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getUsage() {
            return this.usage;
        }

        public Create setAlbumId(String str) {
            this.albumId = str;
            return this;
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
        private static final String REST_PATH = "cloudPhoto/v1/album/{albumId}/assets";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private String usage;

        public List(Drive drive, String str, String str2, String str3) throws IOException {
            super(drive, "GET", REST_PATH, null, AssetList.class);
            this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
            setFields2((String) C4627a0.m28392e(str2, "Required parameter fields must be specified."));
            this.usage = (String) C4627a0.m28392e(str3, "Required parameter usage must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getUsage() {
            return this.usage;
        }

        public List setAlbumId(String str) {
            this.albumId = str;
            return this;
        }

        public List setUsage(String str) {
            this.usage = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class Revisions {
        private Drive client;

        public static class Create extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/album/{albumId}/assets/{assetId}/revisions";

            @InterfaceC4648p
            private String albumId;

            @InterfaceC4648p
            private Boolean antiMdr;

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String quotaUser;

            public Create(Drive drive, String str, String str2, String str3, Asset asset) throws IOException {
                super(drive, "POST", REST_PATH, asset, Asset.class);
                this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                setFields2((String) C4627a0.m28392e(str3, "Required parameter fields must be specified."));
            }

            public String getAlbumId() {
                return this.albumId;
            }

            public Boolean getAntiMdr() {
                return this.antiMdr;
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getQuotaUser() {
                return this.quotaUser;
            }

            public Create setAlbumId(String str) {
                this.albumId = str;
                return this;
            }

            public Create setAntiMdr(Boolean bool) {
                this.antiMdr = bool;
                return this;
            }

            public Create setAssetId(String str) {
                this.assetId = str;
                return this;
            }

            public Create setQuotaUser(String str) {
                this.quotaUser = str;
                return this;
            }

            @Override // p804ya.AbstractC13930g
            public Create addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }
        }

        public static class Get extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/album/{albumId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String albumId;

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String mode;

            @InterfaceC4648p
            private String quotaUser;

            @InterfaceC4648p
            private String versionId;

            public Get(Drive drive, String str, String str2, String str3, String str4) throws IOException {
                super(drive, "GET", REST_PATH, null, Asset.class);
                this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str3, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str4, "Required parameter fields must be specified."));
            }

            public String getAlbumId() {
                return this.albumId;
            }

            public String getAssetId() {
                return this.assetId;
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

            public Get setAlbumId(String str) {
                this.albumId = str;
                return this;
            }

            public Get setAssetId(String str) {
                this.assetId = str;
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

            @Override // p804ya.AbstractC13930g
            public Get addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }
        }

        public static class Update extends AbstractC13930g<Asset> {
            private static final String REST_PATH = "cloudPhoto/v1/album/{albumId}/assets/{assetId}/revisions/{versionId}";

            @InterfaceC4648p
            private String albumId;

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String quotaUser;

            @InterfaceC4648p
            private String versionId;

            public Update(Drive drive, String str, String str2, String str3, String str4, Asset asset) throws IOException {
                super(drive, "POST", REST_PATH, asset, Asset.class);
                this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
                this.assetId = (String) C4627a0.m28392e(str2, "Required parameter assetId must be specified.");
                this.versionId = (String) C4627a0.m28392e(str3, "Required parameter versionId must be specified.");
                setFields2((String) C4627a0.m28392e(str4, "Required parameter fields must be specified."));
            }

            public String getAlbumId() {
                return this.albumId;
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getQuotaUser() {
                return this.quotaUser;
            }

            public String getVersionId() {
                return this.versionId;
            }

            public Update setAlbumId(String str) {
                this.albumId = str;
                return this;
            }

            public Update setAssetId(String str) {
                this.assetId = str;
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

            @Override // p804ya.AbstractC13930g
            public Update addHeader(String str, Object obj) {
                getHeaders().set(str, obj);
                return this;
            }
        }

        public Revisions(Drive drive) {
            this.client = drive;
        }

        public Create create(String str, String str2, String str3, Asset asset) throws IOException {
            return new Create(this.client, str, str2, str3, asset);
        }

        public Get get(String str, String str2, String str3, String str4) throws IOException {
            return new Get(this.client, str, str2, str3, str4);
        }

        public Update update(String str, String str2, String str3, String str4, Asset asset) throws IOException {
            return new Update(this.client, str, str2, str3, str4, asset);
        }
    }

    public AlbumAssets(Drive drive) {
        this.client = drive;
    }

    public Create create(String str, String str2, String str3, Asset asset) throws IOException {
        return new Create(this.client, str, str2, str3, asset);
    }

    public List list(String str, String str2, String str3) throws IOException {
        return new List(this.client, str, str2, str3);
    }

    public Revisions revisions() {
        return new Revisions(this.client);
    }
}
