package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class CBSResource {

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private SliceObject[] objects;
    private String sha256;
    private int state;
    private int type;

    public static class SliceObject {
        private long length;
        private int number;

        @SerializedName("md5")
        private String sliceMd5;

        @SerializedName("sha256")
        private String sliceSha256;
        private long start;

        private SliceObject() {
        }

        public long getLength() {
            return this.length;
        }

        public int getNumber() {
            return this.number;
        }

        public String getSliceMd5() {
            return this.sliceMd5;
        }

        public String getSliceSha256() {
            return this.sliceSha256;
        }

        public long getStart() {
            return this.start;
        }

        public SliceObject setLength(long j10) {
            this.length = j10;
            return this;
        }

        public SliceObject setNumber(int i10) {
            this.number = i10;
            return this;
        }

        public SliceObject setSliceMd5(String str) {
            this.sliceMd5 = str;
            return this;
        }

        public SliceObject setSliceSha256(String str) {
            this.sliceSha256 = str;
            return this;
        }

        public SliceObject setStart(long j10) {
            this.start = j10;
            return this;
        }
    }

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

    public CBSResource setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public CBSResource setHash(String str) {
        this.hash = str;
        return this;
    }

    public CBSResource setLength(long j10) {
        this.length = j10;
        return this;
    }

    public CBSResource setObjects(SliceObject[] sliceObjectArr) {
        this.objects = sliceObjectArr;
        return this;
    }

    public CBSResource setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public CBSResource setState(int i10) {
        this.state = i10;
        return this;
    }

    public CBSResource setType(int i10) {
        this.type = i10;
        return this;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
