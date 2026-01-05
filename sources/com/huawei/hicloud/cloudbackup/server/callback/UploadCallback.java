package com.huawei.hicloud.cloudbackup.server.callback;

import com.huawei.hicloud.cloudbackup.server.slice.BaseSliceStatus;
import com.huawei.hicloud.cloudbackup.server.slice.SliceObject;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4993b;
import com.huawei.hms.network.base.common.trans.FileBinary;
import fk.C9721b;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p022ay.InterfaceC1055e;
import p514o9.C11839m;
import p549p9.C12122a;
import p846zj.C14306d;

/* loaded from: classes6.dex */
public class UploadCallback extends AbstractC4993b<BaseSliceStatus> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long BUFFSIZE = 1048576;
    private static final String TAG = "UploadCallBack";
    private File file;
    private Map<String, String> headers;
    private long length;
    private long offset;
    private C12122a progress;

    public UploadCallback(File file, SliceObject sliceObject, C12122a c12122a) {
        this.file = file;
        this.offset = sliceObject.getStart();
        this.length = sliceObject.getLength();
        this.method = sliceObject.getUploadUrl().getMethod();
        this.headers = sliceObject.getUploadUrl().getHeaders();
        this.progress = c12122a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeable(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C11839m.m70689w(TAG, "closeable close exception.");
            }
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() {
        return new AbstractC11920f0() { // from class: com.huawei.hicloud.cloudbackup.server.callback.UploadCallback.1
            @Override // okhttp3.AbstractC11920f0
            public long contentLength() {
                return UploadCallback.this.length;
            }

            @Override // okhttp3.AbstractC11920f0
            public MimeClass contentType() {
                String str;
                if (UploadCallback.this.headers == null || UploadCallback.this.headers.isEmpty() || (str = (String) UploadCallback.this.headers.get("Content-Type")) == null || str.isEmpty()) {
                    str = FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
                }
                return MimeClass.m71445d(str);
            }

            @Override // okhttp3.AbstractC11920f0
            public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                RandomAccessFile randomAccessFileM63448n = null;
                try {
                    try {
                        randomAccessFileM63448n = C10278a.m63448n(UploadCallback.this.file, "r");
                        randomAccessFileM63448n.seek(UploadCallback.this.offset);
                        byte[] bArr = new byte[(int) (UploadCallback.this.length > 1048576 ? 1048576L : UploadCallback.this.length)];
                        int i10 = randomAccessFileM63448n.read(bArr);
                        boolean zMo17782d = UploadCallback.this.progress.mo17782d();
                        long j10 = 0;
                        while (j10 < UploadCallback.this.length && i10 != -1 && !zMo17782d) {
                            j10 += i10;
                            interfaceC1055e.write(bArr, 0, i10);
                            bArr = new byte[(int) (UploadCallback.this.length - j10 > 1048576 ? 1048576L : UploadCallback.this.length - j10)];
                            i10 = randomAccessFileM63448n.read(bArr);
                            zMo17782d = UploadCallback.this.progress.mo17782d();
                        }
                        if (zMo17782d) {
                            UploadCallback.this.cancel();
                            throw new C9721b(1002, "net disable or canceled by user", "download");
                        }
                    } catch (C9721b e10) {
                        C11839m.m70687e(UploadCallback.TAG, e10.toString());
                        throw new InterruptedIOException(e10.getMessage());
                    }
                } finally {
                    UploadCallback.this.closeable(randomAccessFileM63448n);
                }
            }
        };
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.m71578e(entry.getKey(), entry.getValue());
            }
        }
        C14306d.m85213n(aVar);
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public BaseSliceStatus onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException {
        BaseSliceStatus baseSliceStatus = new BaseSliceStatus();
        baseSliceStatus.setStatus(HttpResponseBuilder.m71597u()).setBody(HttpResponseBuilder.m71595s().m71637z()).setHeaders(HttpResponseBuilder.m71601y().m71858k());
        return baseSliceStatus;
    }
}
