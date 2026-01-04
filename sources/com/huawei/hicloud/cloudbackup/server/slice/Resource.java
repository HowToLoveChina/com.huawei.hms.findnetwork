package com.huawei.hicloud.cloudbackup.server.slice;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class Resource {

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private SliceObject[] objects;
    private String sha256;
    private int state;
    private int type;

    public String getFileKey() {
        return this.fileKey;
    }

    public String getHash() {
        return this.hash;
    }

    public long getLength() {
        return this.length;
    }

    public SliceObject[] getObjects() {
        return this.objects;
    }

    public String getSha256() {
        return this.sha256;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public Resource setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public Resource setHash(String str) {
        this.hash = str;
        return this;
    }

    public Resource setLength(long j10) {
        this.length = j10;
        return this;
    }

    public Resource setObjects(SliceObject[] sliceObjectArr) {
        this.objects = sliceObjectArr;
        return this;
    }

    public Resource setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public Resource setState(int i10) {
        this.state = i10;
        return this;
    }

    public Resource setType(int i10) {
        this.type = i10;
        return this;
    }
}
