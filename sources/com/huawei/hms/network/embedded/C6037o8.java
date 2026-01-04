package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* renamed from: com.huawei.hms.network.embedded.o8 */
/* loaded from: classes8.dex */
public final class C6037o8 {

    /* renamed from: a */
    public final FileChannel f27624a;

    public C6037o8(FileChannel fileChannel) {
        this.f27624a = fileChannel;
    }

    /* renamed from: a */
    public void m34928a(long j10, C5868bb c5868bb, long j11) throws IOException {
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long jTransferTo = this.f27624a.transferTo(j10, j11, c5868bb);
            j10 += jTransferTo;
            j11 -= jTransferTo;
        }
    }

    /* renamed from: b */
    public void m34929b(long j10, C5868bb c5868bb, long j11) throws IOException {
        if (j11 < 0 || j11 > c5868bb.m33913B()) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long jTransferFrom = this.f27624a.transferFrom(c5868bb, j10, j11);
            j10 += jTransferFrom;
            j11 -= jTransferFrom;
        }
    }
}
