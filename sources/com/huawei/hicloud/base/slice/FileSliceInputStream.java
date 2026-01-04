package com.huawei.hicloud.base.slice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class FileSliceInputStream extends InputStream {
    private int index = 0;
    private List<LimitedInputStream> insList;

    public FileSliceInputStream(List<SliceItem<File>> list) throws IOException {
        this.insList = new ArrayList(list.size());
        for (SliceItem<File> sliceItem : list) {
            this.insList.add(new LimitedInputStream(new FileInputStream(sliceItem.getObject()), sliceItem.getOffset(), sliceItem.getLength()));
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<LimitedInputStream> it = this.insList.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.index = 0;
        Iterator<LimitedInputStream> it = this.insList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        int i12 = -1;
        while (this.index < this.insList.size() && (i12 = this.insList.get(this.index).read(bArr, i10, i11)) == -1) {
            this.index++;
        }
        return i12;
    }
}
