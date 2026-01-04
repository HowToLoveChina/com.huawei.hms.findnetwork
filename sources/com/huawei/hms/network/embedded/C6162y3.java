package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.huawei.hms.network.embedded.y3 */
/* loaded from: classes8.dex */
public class C6162y3 extends OutputStream {
    public static final double DEFAULT_BUFFER_SIZE = 16375.0d;

    /* renamed from: b */
    public static final String f29131b = "CronetOutputStream";

    /* renamed from: a */
    public final LinkedBlockingQueue<Object> f29132a;

    public C6162y3(LinkedBlockingQueue<Object> linkedBlockingQueue) {
        this.f29132a = linkedBlockingQueue;
    }

    /* renamed from: a */
    private void m35831a(byte[] bArr, int i10, int i11) throws InterruptedException {
        int i12 = i11 - i10;
        try {
            int iCeil = (int) Math.ceil(i12 / 16375.0d);
            byte[][] bArr2 = new byte[iCeil][];
            for (int i13 = 0; i13 < iCeil; i13++) {
                int i14 = (int) (i13 * 16375.0d);
                int i15 = (int) (i14 + 16375.0d);
                if (i15 > i12) {
                    i15 = i12;
                }
                bArr2[i13] = Arrays.copyOfRange(bArr, i14, i15);
                Logger.m32136d("CronetOutputStream", "wirte into linkedBlockingQueue");
                this.f29132a.put(bArr2[i13]);
            }
        } catch (InterruptedException unused) {
            Logger.m32145w("CronetOutputStream", "An error occurred when cronet upload data or split byte.");
        }
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws InterruptedException, IOException {
        write(StringUtils.getBytes(String.valueOf(i10)));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws InterruptedException, IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws InterruptedException, IOException {
        m35831a(bArr, i10, i11);
    }
}
