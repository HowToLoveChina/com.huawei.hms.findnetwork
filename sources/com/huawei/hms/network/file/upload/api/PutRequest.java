package com.huawei.hms.network.file.upload.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import java.util.List;

/* loaded from: classes8.dex */
public final class PutRequest extends BodyRequest {

    public static final class Builder extends BodyRequest.Builder<Builder> {
        public Builder() {
        }

        @Override // com.huawei.hms.network.file.upload.api.BodyRequest.Builder
        public /* bridge */ /* synthetic */ Request.Builder fileParams(List list) {
            return fileParams((List<FileEntity>) list);
        }

        public Builder(BodyRequest bodyRequest) {
            super(bodyRequest);
        }

        @Override // com.huawei.hms.network.file.api.Request.Builder
        public PutRequest build() {
            return new PutRequest(this);
        }

        @Override // com.huawei.hms.network.file.upload.api.BodyRequest.Builder
        public Builder fileParams(List<FileEntity> list) {
            return (Builder) super.fileParams(list);
        }
    }

    public PutRequest(Builder builder) {
        super(builder);
    }

    @Override // com.huawei.hms.network.file.upload.api.BodyRequest
    public List<FileEntity> getFileEntityList() {
        return super.getFileEntityList();
    }

    @Override // com.huawei.hms.network.file.api.Request
    public Builder newBuilder() {
        return new Builder(this);
    }
}
