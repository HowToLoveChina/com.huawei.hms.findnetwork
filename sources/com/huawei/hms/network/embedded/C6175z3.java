package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5939h1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* renamed from: com.huawei.hms.network.embedded.z3 */
/* loaded from: classes8.dex */
public class C6175z3 extends UploadDataProvider {

    /* renamed from: f */
    public static final String f29225f = "CronetUploadDataProvide";

    /* renamed from: i */
    public static final int f29228i = 22;

    /* renamed from: a */
    public final LinkedBlockingQueue<Object> f29230a = new LinkedBlockingQueue<>(22);

    /* renamed from: b */
    public C5939h1.d f29231b;

    /* renamed from: c */
    public C5939h1.e f29232c;

    /* renamed from: d */
    public ByteBuffer f29233d;

    /* renamed from: e */
    public ExecutorC5992l2 f29234e;

    /* renamed from: h */
    public static final byte[] f29227h = new byte[0];

    /* renamed from: g */
    public static final String f29226g = "cronet_upload_task";

    /* renamed from: j */
    public static ExecutorService f29229j = ExecutorsUtils.newCachedThreadPool(f29226g);

    /* renamed from: com.huawei.hms.network.embedded.z3$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                C6175z3.this.f29232c.writeTo(new C6162y3(C6175z3.this.f29230a));
            } catch (FileNotFoundException unused) {
                Logger.m32145w(C6175z3.f29225f, "An IOException occurs during stream writing.");
                try {
                    C6175z3.this.f29230a.put(C6175z3.f29227h);
                } catch (InterruptedException e10) {
                    Logger.m32146w(C6175z3.f29225f, "An IOException occurs during stream writing.", e10);
                }
            } catch (IOException | Exception e11) {
                Logger.m32146w(C6175z3.f29225f, "An IOException occurs during stream writing.", e11);
                C6175z3.this.f29230a.put(C6175z3.f29227h);
            }
        }
    }

    public C6175z3(C5939h1.d dVar, ExecutorC5992l2 executorC5992l2) {
        this.f29231b = dVar;
        this.f29234e = executorC5992l2;
        this.f29232c = dVar.getBody();
        f29229j.execute(new a());
    }

    /* renamed from: t */
    private int m35903t() {
        return this.f29231b.getNetConfig().getWriteTimeout();
    }

    @Override // org.chromium.net.UploadDataProvider
    public long getLength() throws IOException {
        if (this.f29232c.contentLength() == 0) {
            Logger.m32145w(f29225f, "maybe the requestBody's contentLength be not override");
        }
        return this.f29232c.contentLength();
    }

    @Override // org.chromium.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws InterruptedException, IOException {
        int iMin = Math.min(this.f29230a.size(), (int) Math.floor(byteBuffer.capacity() / 16375.0d));
        Logger.m32136d(f29225f, "cronet try to read, times : " + iMin + " capacity : " + byteBuffer.capacity());
        int i10 = 1;
        do {
            try {
                Logger.m32136d(f29225f, "linkedBlockingQueue poll");
                Object objPoll = this.f29230a.poll(m35903t(), TimeUnit.MILLISECONDS);
                if (f29227h.equals(objPoll)) {
                    throw new IOException("An exception occurred when writing the request body.");
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap((byte[]) objPoll);
                this.f29233d = byteBufferWrap;
                byteBuffer.put(byteBufferWrap);
                i10++;
            } catch (InterruptedException e10) {
                Logger.m32145w(f29225f, "An Interrupted exception occurs when read interrupted in updaloadDataProvider.");
                throw new IOException("An exception occurs when read interrupted in updaloadDataProvider", e10);
            } catch (RuntimeException e11) {
                Logger.m32146w(f29225f, "An Runtime exception occurs when read in updaloadDataProvider.", e11);
                throw new IOException("An exception occurs when read in updaloadDataProvider", e11);
            } catch (Exception e12) {
                Logger.m32146w(f29225f, "Exception occurs when read in updaloadDataProvider.", e12);
                throw new IOException("Exception occurs when read in updaloadDataProvider", e12);
            }
        } while (i10 <= iMin);
        this.f29234e.updateLoopTimer(m35903t());
        Logger.m32136d(f29225f, "uploadDataSink read success");
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) throws IOException {
        Logger.m32145w(f29225f, "not support rewind");
        uploadDataSink.onRewindError(new HttpRetryException("Cannot rewind the RequestBody", -1));
    }
}
