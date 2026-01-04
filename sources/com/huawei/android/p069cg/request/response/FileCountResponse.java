package com.huawei.android.p069cg.request.response;

/* loaded from: classes2.dex */
public class FileCountResponse extends BaseResponse {
    private Result result;

    public static class Result {
        private long pictureCount;
        private long videoCount;

        public long getPictureCount() {
            return this.pictureCount;
        }

        public long getVideoCount() {
            return this.videoCount;
        }

        public void setPictureCount(long j10) {
            this.pictureCount = j10;
        }

        public void setVideoCount(long j10) {
            this.videoCount = j10;
        }
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
