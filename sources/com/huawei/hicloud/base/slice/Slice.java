package com.huawei.hicloud.base.slice;

import java.util.List;

/* loaded from: classes6.dex */
public class Slice<T> {
    private long length;
    private List<SliceItem<T>> sliceItems;

    public Slice(List<SliceItem<T>> list, long j10) {
        this.sliceItems = list;
        this.length = j10;
    }

    public long getLength() {
        return this.length;
    }

    public List<SliceItem<T>> getSliceItems() {
        return this.sliceItems;
    }

    public String toString() {
        return "Slice{sliceItems=" + this.sliceItems + ", length=" + this.length + '}';
    }
}
