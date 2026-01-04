package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchGetRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchGetResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchUpdateResponse;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class CloudPhotos {
    private Drive drive;

    public static class BatchGet extends AbstractC13930g<MediaBatchGetResponse> {
        private static final String REST_PATH = "cloudPhoto/v1/media/batchGet";

        public BatchGet(Drive drive, MediaBatchGetRequest mediaBatchGetRequest, String str) throws IOException {
            super(drive, "POST", REST_PATH, mediaBatchGetRequest, MediaBatchGetResponse.class);
            setFields2((String) C4627a0.m28392e(str, "Required parameter fields must be specified."));
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchGet setFields2(String str) {
            return (BatchGet) super.setFields2(str);
        }
    }

    public static class BatchUpdate extends AbstractC13930g<MediaBatchUpdateResponse> {
        private static final String REST_PATH = "cloudPhoto/v1/media/batchUpdate";

        public BatchUpdate(Drive drive, MediaBatchUpdateRequest mediaBatchUpdateRequest, String str) throws IOException {
            super(drive, "POST", REST_PATH, mediaBatchUpdateRequest, MediaBatchUpdateResponse.class);
            setFields2((String) C4627a0.m28392e(str, "Required parameter fields must be specified."));
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchUpdate setFields2(String str) {
            return (BatchUpdate) super.setFields2(str);
        }
    }

    public CloudPhotos(Drive drive) {
        this.drive = drive;
    }

    public BatchGet batchGet(MediaBatchGetRequest mediaBatchGetRequest, String str) throws IOException {
        return new BatchGet(this.drive, mediaBatchGetRequest, str);
    }

    public BatchUpdate batchUpdate(MediaBatchUpdateRequest mediaBatchUpdateRequest, String str) throws IOException {
        return new BatchUpdate(this.drive, mediaBatchUpdateRequest, str);
    }
}
