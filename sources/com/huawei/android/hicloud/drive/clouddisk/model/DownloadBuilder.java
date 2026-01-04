package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.android.hicloud.drive.clouddisk.expand.p085db.Status;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DownloadBuilder {
    public String data1;
    public String data2;
    public String data3;
    public String hmac;
    public int num;
    public String object;
    public long offset;
    public String path;
    public int status;
    public String synckey;
    public long taskId = -1;
    public String uuid;

    public DownloadBuilder(String str) {
        this.hmac = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DownloadBuilder downloadBuilder = (DownloadBuilder) obj;
        boolean z10 = this.num == downloadBuilder.num && Objects.equals(this.hmac, downloadBuilder.hmac) && Objects.equals(this.path, downloadBuilder.path) && Objects.equals(this.object, downloadBuilder.object);
        if (z10) {
            setStatus(downloadBuilder.status).setTaskId(downloadBuilder.taskId).setUuid(downloadBuilder.uuid);
        }
        return z10;
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public String getData3() {
        return this.data3;
    }

    public String getHmac() {
        return this.hmac;
    }

    public int getNum() {
        return this.num;
    }

    public String getObject() {
        return this.object;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getPath() {
        return this.path;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSynckey() {
        return this.synckey;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return Objects.hash(this.hmac, this.path, Integer.valueOf(this.num), this.object);
    }

    public void reset() {
        this.taskId = -1L;
        this.status = Status.DEFAULT.value();
    }

    public DownloadBuilder setData1(String str) {
        this.data1 = str;
        return this;
    }

    public DownloadBuilder setData2(String str) {
        this.data2 = str;
        return this;
    }

    public DownloadBuilder setData3(String str) {
        this.data3 = str;
        return this;
    }

    public DownloadBuilder setHmac(String str) {
        this.hmac = str;
        return this;
    }

    public DownloadBuilder setNum(int i10) {
        this.num = i10;
        return this;
    }

    public DownloadBuilder setObject(String str) {
        this.object = str;
        return this;
    }

    public DownloadBuilder setOffset(long j10) {
        this.offset = j10;
        return this;
    }

    public DownloadBuilder setPath(String str) {
        this.path = str;
        return this;
    }

    public DownloadBuilder setStatus(int i10) {
        this.status = i10;
        return this;
    }

    public DownloadBuilder setSynckey(String str) {
        this.synckey = str;
        return this;
    }

    public DownloadBuilder setTaskId(long j10) {
        this.taskId = j10;
        return this;
    }

    public DownloadBuilder setUuid(String str) {
        this.uuid = str;
        return this;
    }
}
