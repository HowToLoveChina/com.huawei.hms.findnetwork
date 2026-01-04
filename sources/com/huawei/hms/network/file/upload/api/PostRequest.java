package com.huawei.hms.network.file.upload.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class PostRequest extends BodyRequest {

    public static final class Builder extends BodyRequest.Builder<Builder> {
        public Builder() {
        }

        @Override // com.huawei.hms.network.file.upload.api.BodyRequest.Builder
        public /* bridge */ /* synthetic */ Request.Builder fileParams(String str, List list) {
            return fileParams(str, (List<FileEntity>) list);
        }

        public Builder(PostRequest postRequest) {
            super(postRequest);
        }

        @Override // com.huawei.hms.network.file.api.Request.Builder
        public PostRequest build() {
            return new PostRequest(this);
        }

        @Override // com.huawei.hms.network.file.upload.api.BodyRequest.Builder
        public Builder fileParams(String str, List<FileEntity> list) {
            return (Builder) super.fileParams(str, list);
        }

        @Override // com.huawei.hms.network.file.upload.api.BodyRequest.Builder
        public Builder fileParams(String str, FileEntity... fileEntityArr) {
            return (Builder) super.fileParams(str, fileEntityArr);
        }
    }

    public PostRequest(Builder builder) {
        super(builder);
    }

    @Override // com.huawei.hms.network.file.upload.api.BodyRequest
    public Map<String, List<FileEntity>> getFileEntityMap() {
        return super.getFileEntityMap();
    }

    @Override // com.huawei.hms.network.file.api.Request
    public Builder newBuilder() {
        return new Builder(this);
    }
}
