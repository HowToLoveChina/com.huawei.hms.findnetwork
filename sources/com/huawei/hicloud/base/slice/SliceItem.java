package com.huawei.hicloud.base.slice;

/* loaded from: classes6.dex */
public class SliceItem<T> {
    private int index;
    private long length;
    private T object;
    private long offset;

    public SliceItem(T t10, int i10, long j10, long j11) {
        this.object = t10;
        this.index = i10;
        this.offset = j10;
        this.length = j11;
    }

    public int getIndex() {
        return this.index;
    }

    public long getLength() {
        return this.length;
    }

    public T getObject() {
        return this.object;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setLength(long j10) {
        this.length = j10;
    }

    public void setObject(T t10) {
        this.object = t10;
    }

    public void setOffset(long j10) {
        this.offset = j10;
    }

    public String toString() {
        return "SliceItem{object=" + this.object + ", offset=" + this.offset + ", length=" + this.length + '}';
    }
}
