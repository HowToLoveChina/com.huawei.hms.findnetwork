package com.huawei.hicloud.request.opengw.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class Objects {
    private List<ObjectAttribute> attributes;
    private String bucket;
    private List<String> objectKeys;
    private long sliceSize;
    private List<String> synckeys;
    private String time;

    public List<ObjectAttribute> getAttributes() {
        return this.attributes;
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<String> getObjectKeys() {
        return this.objectKeys;
    }

    public long getSliceSize() {
        return this.sliceSize;
    }

    public List<String> getSynckeys() {
        return this.synckeys;
    }

    public String getTime() {
        return this.time;
    }

    public void setAttributes(List<ObjectAttribute> list) {
        this.attributes = list;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setObjectKeys(List<String> list) {
        this.objectKeys = list;
    }

    public void setSliceSize(long j10) {
        this.sliceSize = j10;
    }

    public void setSynckeys(List<String> list) {
        this.synckeys = list;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "Objects{time='" + this.time + "', bucket='" + this.bucket + "', objectKeys=" + this.objectKeys + ", sliceSize=" + this.sliceSize + ", synckeys=" + this.synckeys + ", attributes=" + this.attributes + '}';
    }
}
