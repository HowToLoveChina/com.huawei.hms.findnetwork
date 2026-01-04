package com.huawei.hicloud.base.slice;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class Slices<T> {
    private List<Slice<T>> slices = new ArrayList();
    private long total;

    public List<Slice<T>> getSlices() {
        return this.slices;
    }

    public long getTotal() {
        return this.total;
    }

    public void increase(Slice<T> slice) {
        if (slice.getLength() == 0) {
            return;
        }
        this.slices.add(slice);
        this.total += slice.getLength();
    }
}
