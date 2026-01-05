package com.huawei.hicloud.request.upload;

import android.os.Build;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p022ay.InterfaceC1055e;
import p336he.C10160k;
import p514o9.C11829c;
import p514o9.C11839m;
import p549p9.C12122a;

/* loaded from: classes6.dex */
public class UploadPCallback extends AbstractC4994a {
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final long BUFFSIZE = 1048576;
    private static final String LINEND = "\r\n";
    private static final String PREFIX = "--";
    private static final String TAG = "UploadPCallback";
    private SliceItem<File> item;
    private Map<String, String> params;
    private C12122a progress;

    public UploadPCallback(Map<String, String> map, SliceItem<File> sliceItem, String str, C12122a c12122a) {
        super("BLK", str, "POST");
        this.params = map;
        this.item = sliceItem;
        this.progress = c12122a;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            sb2.append(PREFIX);
            sb2.append(BOUNDARY);
            sb2.append(LINEND);
            sb2.append("Content-Disposition: form-data; name=\"");
            sb2.append(entry.getKey());
            sb2.append("\"");
            sb2.append(LINEND);
            sb2.append(LINEND);
            sb2.append(entry.getValue());
            sb2.append(LINEND);
        }
        sb2.append(PREFIX);
        String str = BOUNDARY;
        sb2.append(str);
        sb2.append(LINEND);
        sb2.append("Content-Disposition: form-data; name=\"file\"; filename=\"");
        sb2.append(URLEncoder.encode(this.item.getObject().getName(), "utf-8"));
        sb2.append("\"");
        sb2.append(LINEND);
        sb2.append("Content-Type: application/octet-stream \r\n");
        sb2.append(LINEND);
        final String string = sb2.toString();
        final String str2 = "\r\n--" + str + PREFIX + LINEND;
        final long length = string.getBytes("utf-8").length + this.item.getLength() + str2.getBytes("utf-8").length;
        return new AbstractC11920f0() { // from class: com.huawei.hicloud.request.upload.UploadPCallback.1
            @Override // okhttp3.AbstractC11920f0
            public long contentLength() {
                return length;
            }

            @Override // okhttp3.AbstractC11920f0
            public MimeClass contentType() {
                return MimeClass.m71445d("multipart/form-data; boundary=" + UploadPCallback.BOUNDARY);
            }

            @Override // okhttp3.AbstractC11920f0
            public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                RandomAccessFile randomAccessFile = null;
                try {
                    try {
                        interfaceC1055e.write(string.getBytes("utf-8"));
                        long length2 = UploadPCallback.this.item.getLength();
                        RandomAccessFile randomAccessFileM63448n = C10278a.m63448n((File) UploadPCallback.this.item.getObject(), "r");
                        randomAccessFileM63448n.seek(UploadPCallback.this.item.getOffset());
                        UploadPCallback.this.progress.mo17784f(UploadPCallback.this.item.getOffset());
                        byte[] bArr = new byte[(int) (length2 > 1048576 ? 1048576L : length2)];
                        int i10 = randomAccessFileM63448n.read(bArr);
                        boolean zMo17782d = UploadPCallback.this.progress.mo17782d();
                        long j10 = 0;
                        while (j10 < length2 && i10 != -1 && !zMo17782d) {
                            long j11 = i10;
                            j10 += j11;
                            interfaceC1055e.write(bArr, 0, i10);
                            UploadPCallback.this.progress.m72686c(j11);
                            long j12 = length2 - j10;
                            if (j12 > 1048576) {
                                j12 = 1048576;
                            }
                            byte[] bArr2 = new byte[(int) j12];
                            int i11 = randomAccessFileM63448n.read(bArr2);
                            zMo17782d = UploadPCallback.this.progress.mo17782d();
                            bArr = bArr2;
                            i10 = i11;
                        }
                        if (zMo17782d) {
                            UploadPCallback.this.cancel();
                            throw new C9721b(1002, "net disable or canceled by user");
                        }
                        interfaceC1055e.write(str2.getBytes("utf-8"));
                        try {
                            randomAccessFileM63448n.close();
                        } catch (IOException unused) {
                            C11839m.m70689w(UploadPCallback.TAG, "RandomAccessFile close exception.");
                        }
                    } catch (C9721b e10) {
                        C11839m.m70687e(UploadPCallback.TAG, e10.toString());
                        throw new InterruptedIOException(e10.getMessage());
                    }
                } catch (Throwable th2) {
                    if (0 != 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                            C11839m.m70689w(UploadPCallback.TAG, "RandomAccessFile close exception.");
                        }
                    }
                    throw th2;
                }
            }
        };
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader("User-Agent", "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)");
        aVar.m71578e("x-hw-unique-trace-id", C10160k.m63341b("04015"));
        if (this.item == null) {
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "doOutput item is null.");
        }
    }
}
