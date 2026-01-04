package com.huawei.android.hicloud.drive.clouddisk.expand;

import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public abstract class CloudDriveRequest<T> extends DriveRequest<T> {
    private static final String DEFAULT_SERVICE_PATH = "drive/v1/";
    private C11707b requestBody;
    private String uriTemplate;

    public CloudDriveRequest(Drive drive, String str, String str2, C11707b c11707b, Class<T> cls) {
        super(drive, str, str2, c11707b, cls);
        this.uriTemplate = str2;
        this.requestBody = c11707b;
    }

    public Map<String, Object> getRequestBody() {
        return this.requestBody;
    }

    public String getRequestUrl() {
        return "/" + C4597b0.m28167b("", DEFAULT_SERVICE_PATH + this.uriTemplate, this, true);
    }

    public void queue(CloudDriveAtomicBatch cloudDriveAtomicBatch, CloudDriveJsonBatchCallback<T> cloudDriveJsonBatchCallback) {
        cloudDriveAtomicBatch.queue(this, getResponseClass(), ErrorResp.class, cloudDriveJsonBatchCallback);
    }
}
