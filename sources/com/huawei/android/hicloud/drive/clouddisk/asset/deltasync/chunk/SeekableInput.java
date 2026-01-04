package com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface SeekableInput extends Closeable {
    void read(byte[] bArr, int i10, int i11) throws IOException;

    void seek(long j10) throws IOException;
}
