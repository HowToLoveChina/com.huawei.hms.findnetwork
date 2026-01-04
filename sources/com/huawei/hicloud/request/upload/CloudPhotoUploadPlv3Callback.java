package com.huawei.hicloud.request.upload;

import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hms.network.base.common.trans.FileBinary;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import p022ay.InterfaceC1055e;
import p336he.C10160k;
import p514o9.C11839m;
import p549p9.C12122a;

/* loaded from: classes6.dex */
public class CloudPhotoUploadPlv3Callback extends UploadCallback {
    private static final String TAG = "CloudPhotoUploadPlv3Callback";

    public CloudPhotoUploadPlv3Callback(String str, Map<String, String> map, C12122a c12122a) {
        super(str, map, c12122a);
    }

    @Override // com.huawei.hicloud.request.upload.UploadCallback, com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() {
        return new AbstractC11920f0() { // from class: com.huawei.hicloud.request.upload.CloudPhotoUploadPlv3Callback.1
            @Override // okhttp3.AbstractC11920f0
            public long contentLength() {
                return CloudPhotoUploadPlv3Callback.this.length;
            }

            @Override // okhttp3.AbstractC11920f0
            public C11910a0 contentType() {
                return C11910a0.m71445d(FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
            }

            @Override // okhttp3.AbstractC11920f0
            public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                if (CloudPhotoUploadPlv3Callback.this.sliceItems.isEmpty()) {
                    return;
                }
                for (SliceItem<File> sliceItem : CloudPhotoUploadPlv3Callback.this.sliceItems) {
                    long length = sliceItem.getLength();
                    RandomAccessFile randomAccessFileM63448n = null;
                    try {
                        try {
                            randomAccessFileM63448n = C10278a.m63448n(sliceItem.getObject(), "r");
                            randomAccessFileM63448n.seek(sliceItem.getOffset());
                            CloudPhotoUploadPlv3Callback.this.progress.mo17784f(sliceItem.getOffset());
                            byte[] bArr = new byte[(int) (length > 1048576 ? 1048576L : length)];
                            int i10 = randomAccessFileM63448n.read(bArr);
                            boolean zMo17782d = CloudPhotoUploadPlv3Callback.this.progress.mo17782d();
                            long j10 = 0;
                            while (j10 < length && i10 != -1 && !zMo17782d) {
                                long j11 = i10;
                                j10 += j11;
                                interfaceC1055e.write(bArr, 0, i10);
                                CloudPhotoUploadPlv3Callback.this.progress.m72686c(j11);
                                long j12 = length - j10;
                                if (j12 > 1048576) {
                                    j12 = 1048576;
                                }
                                bArr = new byte[(int) j12];
                                i10 = randomAccessFileM63448n.read(bArr);
                                zMo17782d = CloudPhotoUploadPlv3Callback.this.progress.mo17782d();
                            }
                            if (zMo17782d) {
                                CloudPhotoUploadPlv3Callback.this.cancel();
                                throw new C9721b(1002, "net disable or canceled by user", "upload");
                            }
                            try {
                                randomAccessFileM63448n.close();
                            } catch (IOException e10) {
                                C11839m.m70689w(CloudPhotoUploadPlv3Callback.TAG, "RandomAccessFile close error." + e10.toString());
                            }
                        } catch (C9721b e11) {
                            C11839m.m70687e(CloudPhotoUploadPlv3Callback.TAG, e11.toString());
                            throw new InterruptedIOException(e11.getMessage());
                        }
                    } finally {
                    }
                }
            }
        };
    }

    @Override // com.huawei.hicloud.request.upload.UploadCallback, com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) {
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.m71578e(entry.getKey(), entry.getValue());
            }
        }
        aVar.m71578e("x-hw-unique-trace-id", C10160k.m63341b("04015"));
    }

    public CloudPhotoUploadPlv3Callback(String str, Map<String, String> map, SliceItem<File> sliceItem, long j10, C12122a c12122a) {
        super(str, map, sliceItem, j10, c12122a);
    }
}
