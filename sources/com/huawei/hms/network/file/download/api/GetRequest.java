package com.huawei.hms.network.file.download.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.p130a.C6190f;

/* loaded from: classes8.dex */
public final class GetRequest extends Request {
    private final boolean enableSlice;
    private final String filePath;
    private final long fileSize;
    private final long offset;
    private final String sha256;

    public static final class Builder extends Request.Builder<Builder> {
        private boolean enableSlice;
        private String filePath;
        private long fileSize;
        private long offset;
        private String sha256;

        public Builder() {
            this.converter = new C6190f();
            this.enableSlice = true;
        }

        public Builder enableSlice(boolean z10) {
            this.enableSlice = z10;
            return this;
        }

        public Builder filePath(String str) {
            this.filePath = str;
            return this;
        }

        public Builder fileSize(long j10) {
            this.fileSize = j10;
            return this;
        }

        public Builder offset(long j10) {
            this.offset = j10;
            return this;
        }

        public Builder sha256(String str) {
            this.sha256 = str;
            return this;
        }

        public Builder(GetRequest getRequest) {
            super(getRequest);
            this.offset = getRequest.offset;
            this.fileSize = getRequest.fileSize;
            this.sha256 = getRequest.sha256;
            this.filePath = getRequest.filePath;
            this.enableSlice = getRequest.enableSlice;
        }

        @Override // com.huawei.hms.network.file.api.Request.Builder
        public GetRequest build() {
            return new GetRequest(this);
        }
    }

    public GetRequest(Builder builder) {
        super(builder);
        this.offset = builder.offset;
        this.fileSize = builder.fileSize;
        this.sha256 = builder.sha256;
        this.filePath = builder.filePath;
        this.enableSlice = builder.enableSlice;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getSha256() {
        return this.sha256;
    }

    public boolean isEnableSlice() {
        return this.enableSlice;
    }

    @Override // com.huawei.hms.network.file.api.Request
    public String toString() {
        return "GetRequest{offset=" + this.offset + ", fileSize=" + this.fileSize + ", config=" + this.config + ", name='" + this.name + "', id=" + this.f29341id + ", enableSlice=" + this.enableSlice + '}';
    }

    @Override // com.huawei.hms.network.file.api.Request
    public Builder newBuilder() {
        return new Builder(this);
    }
}
