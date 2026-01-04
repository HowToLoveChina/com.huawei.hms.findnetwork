package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class FileRetryList extends C11707b {

    @InterfaceC4648p
    private List<FileRetry> fileRetryList;

    public static class FileRetry extends C11707b {

        @InterfaceC4648p
        private String fileKey;

        @InterfaceC4648p
        private Long lastTime;

        public String getFileKey() {
            return this.fileKey;
        }

        public Long getLastTime() {
            Long l10 = this.lastTime;
            if (l10 == null) {
                return 0L;
            }
            return l10;
        }

        public FileRetry setFileKey(String str) {
            this.fileKey = str;
            return this;
        }

        public FileRetry setLastTime(Long l10) {
            this.lastTime = l10;
            return this;
        }
    }

    public List<FileRetry> getFileRetryList() {
        return this.fileRetryList;
    }

    public void setFileRetryList(List<FileRetry> list) {
        this.fileRetryList = list;
    }
}
