package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.httpclient.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import org.chromium.net.BidirectionalStream;

/* renamed from: com.huawei.hms.network.embedded.b2 */
/* loaded from: classes8.dex */
public class C5859b2 extends OutputStream {

    /* renamed from: d */
    public static final String f26403d = "CronetOutputStream";

    /* renamed from: a */
    public final BidirectionalStream f26404a;

    /* renamed from: b */
    public final RequestBody f26405b;

    /* renamed from: c */
    public LinkedBlockingQueue<Object> f26406c;

    public C5859b2(BidirectionalStream bidirectionalStream, RequestBody requestBody, LinkedBlockingQueue<Object> linkedBlockingQueue) {
        this.f26404a = bidirectionalStream;
        this.f26405b = requestBody;
        this.f26406c = linkedBlockingQueue;
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
        try {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i11);
            byteBufferAllocateDirect.put(bArr, i10, i11).flip();
            this.f26404a.write(byteBufferAllocateDirect, this.f26405b.endOfStream());
            this.f26404a.flush();
            this.f26406c.put(Integer.valueOf(i11));
        } catch (IllegalArgumentException | InterruptedException unused) {
            Logger.m32145w("CronetOutputStream", "stream writing exception or queue put exception");
        }
    }
}
