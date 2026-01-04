package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.drive.cloudphoto.model.Batch;
import com.huawei.android.hicloud.drive.cloudphoto.model.BatchesCreateRequest;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Batches {
    private Drive client;

    public static class Create extends AbstractC13930g<Batch> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/batches";

        @InterfaceC4648p
        private String albumId;

        public Create(Drive drive, BatchesCreateRequest batchesCreateRequest, String str) throws IOException {
            super(drive, "POST", REST_PATH, batchesCreateRequest, Batch.class);
            this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public void setAlbumId(String str) {
            this.albumId = str;
        }
    }

    public static class Update extends AbstractC13930g<Batch> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/batches/{batchId}";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private String batchId;

        public Update(Drive drive, BatchesCreateRequest batchesCreateRequest, String str, String str2) throws IOException {
            super(drive, RequestMethod.PATCH, REST_PATH, batchesCreateRequest, Batch.class);
            this.albumId = (String) C4627a0.m28392e(str, "Required parameter albumId must be specified.");
            this.batchId = (String) C4627a0.m28392e(str2, "Required parameter batchId must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getBatchId() {
            return this.batchId;
        }

        public void setAlbumId(String str) {
            this.albumId = str;
        }

        public void setBatchId(String str) {
            this.batchId = str;
        }
    }

    public Batches(Drive drive) {
        this.client = drive;
    }

    public Create create(BatchesCreateRequest batchesCreateRequest, String str) throws IOException {
        return new Create(this.client, batchesCreateRequest, str);
    }

    public Update update(BatchesCreateRequest batchesCreateRequest, String str, String str2) throws IOException {
        return new Update(this.client, batchesCreateRequest, str, str2);
    }
}
