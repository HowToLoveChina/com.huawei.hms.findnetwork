package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.FileData;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class FileQueryResponse extends BaseResponse {
    private String cursor;
    private FileData[] fileList;
    private boolean hasMore;
    private String incCursor;
    private long latestVersion = -1;
    private int total;

    public String getCursor() {
        return this.cursor;
    }

    public FileData[] getFileList() {
        return this.fileList;
    }

    public String getIncCursor() {
        return this.incCursor;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setFileList(FileData[] fileDataArr) {
        this.fileList = fileDataArr;
    }

    public void setHasMore(boolean z10) {
        this.hasMore = z10;
    }

    public void setIncCursor(String str) {
        this.incCursor = str;
    }

    public void setLatestVersion(long j10) {
        this.latestVersion = j10;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }

    public String toString() {
        return "FileQueryResponse{cursor='" + this.cursor + "', hasMore=" + this.hasMore + ", incCursor='" + this.incCursor + "', latestVersion=" + this.latestVersion + ", total=" + this.total + ", fileList=" + Arrays.toString(this.fileList) + '}';
    }
}
