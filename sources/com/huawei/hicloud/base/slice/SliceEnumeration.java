package com.huawei.hicloud.base.slice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SliceEnumeration<T> {
    private LengthGetter<T> lengthGetter;
    private List<T> sliceObjects;
    private int index = 0;
    private long position = 0;
    private long offset = 0;

    public SliceEnumeration(List<T> list, LengthGetter<T> lengthGetter) {
        this.sliceObjects = list;
        this.lengthGetter = lengthGetter;
    }

    private long getELength(long j10) {
        return ((j10 / 16) * 16) + 16;
    }

    public boolean hasMoreSlices() {
        int size = this.sliceObjects.size() - 1;
        int i10 = this.index;
        if (i10 >= size) {
            return i10 == size && this.position < this.lengthGetter.getLength(i10, this.sliceObjects.get(size));
        }
        return true;
    }

    public Slice<T> nextSlice(long j10) {
        return nextSlice(j10, true);
    }

    public Slice<T> nextSlice(long j10, boolean z10) {
        int i10;
        ArrayList<SliceItem> arrayList = new ArrayList();
        long eLength = 0;
        long j11 = 0;
        while (true) {
            if (this.index >= this.sliceObjects.size()) {
                break;
            }
            T t10 = this.sliceObjects.get(this.index);
            long length = this.lengthGetter.getLength(this.index, t10) - this.position;
            long j12 = j10 - j11;
            if (j12 > length) {
                if (length != 0) {
                    j11 += length;
                    if (!(t10 instanceof File)) {
                        length = getELength(length);
                    }
                    arrayList.add(new SliceItem(t10, this.index, this.offset, length));
                }
                this.position = 0L;
                this.offset = 0L;
                if (z10 && (t10 instanceof File) && (i10 = this.index) == 0) {
                    this.index = i10 + 1;
                    break;
                }
                this.index++;
            } else {
                long eLength2 = !(t10 instanceof File) ? getELength(j12) : j12;
                arrayList.add(new SliceItem(t10, this.index, this.offset, eLength2));
                this.position += j12;
                this.offset += eLength2;
            }
        }
        for (SliceItem sliceItem : arrayList) {
            eLength += sliceItem.getObject() instanceof File ? getELength(sliceItem.getLength()) : sliceItem.getLength();
        }
        return new Slice<>(arrayList, eLength);
    }
}
