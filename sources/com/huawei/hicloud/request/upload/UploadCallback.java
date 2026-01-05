package com.huawei.hicloud.request.upload;

import android.os.Build;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p022ay.InterfaceC1055e;
import p514o9.C11829c;
import p514o9.C11839m;
import p549p9.C12122a;

/* loaded from: classes6.dex */
public class UploadCallback extends AbstractC4994a {
    static final long BUFFSIZE = 1048576;
    private static final String TAG = "UploadCallBack";
    Map<String, String> headers;
    long length;
    C12122a progress;
    List<SliceItem<File>> sliceItems;

    public UploadCallback(String str, Map<String, String> map, C12122a c12122a) {
        super("dl", str, "PUT");
        this.sliceItems = new ArrayList();
        this.headers = map;
        this.progress = c12122a;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() {
        return new AbstractC11920f0() { // from class: com.huawei.hicloud.request.upload.UploadCallback.1
            @Override // okhttp3.AbstractC11920f0
            public long contentLength() {
                return UploadCallback.this.length;
            }

            @Override // okhttp3.AbstractC11920f0
            public MimeClass contentType() {
                return MimeClass.m71445d("application/x-www-form-urlencoded; charset=utf-8");
            }

            @Override // okhttp3.AbstractC11920f0
            public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                if (UploadCallback.this.sliceItems.isEmpty()) {
                    return;
                }
                for (SliceItem<File> sliceItem : UploadCallback.this.sliceItems) {
                    long length = sliceItem.getLength();
                    RandomAccessFile randomAccessFileM63448n = null;
                    try {
                        try {
                            randomAccessFileM63448n = C10278a.m63448n(sliceItem.getObject(), "r");
                            randomAccessFileM63448n.seek(sliceItem.getOffset());
                            UploadCallback.this.progress.mo17784f(sliceItem.getOffset());
                            byte[] bArr = new byte[(int) (length > 1048576 ? 1048576L : length)];
                            int i10 = randomAccessFileM63448n.read(bArr);
                            boolean zMo17782d = UploadCallback.this.progress.mo17782d();
                            long j10 = 0;
                            while (j10 < length && i10 != -1 && !zMo17782d) {
                                long j11 = i10;
                                j10 += j11;
                                interfaceC1055e.write(bArr, 0, i10);
                                UploadCallback.this.progress.m72686c(j11);
                                long j12 = length - j10;
                                if (j12 > 1048576) {
                                    j12 = 1048576;
                                }
                                bArr = new byte[(int) j12];
                                i10 = randomAccessFileM63448n.read(bArr);
                                zMo17782d = UploadCallback.this.progress.mo17782d();
                            }
                            if (zMo17782d) {
                                UploadCallback.this.cancel();
                                throw new C9721b(1002, "net disable or canceled by user", "download");
                            }
                            try {
                                randomAccessFileM63448n.close();
                            } catch (IOException e10) {
                                C11839m.m70689w(UploadCallback.TAG, "RandomAccessFile close error." + e10.toString());
                            }
                        } catch (C9721b e11) {
                            C11839m.m70687e(UploadCallback.TAG, e11.toString());
                            throw new InterruptedIOException(e11.getMessage());
                        }
                    } finally {
                    }
                }
            }
        };
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        if (C10028c.m62182c0().m62420y1()) {
            aVar.addHeader("User-Agent", "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)");
            aVar.addHeader("Expect", "100-continue");
        }
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.addHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    public UploadCallback(String str, Map<String, String> map, SliceItem<File> sliceItem, long j10, C12122a c12122a) {
        super("dl", str, "PUT");
        ArrayList arrayList = new ArrayList();
        this.sliceItems = arrayList;
        this.headers = map;
        this.progress = c12122a;
        arrayList.add(sliceItem);
        this.length = j10;
    }

    public UploadCallback(String str, Map<String, String> map, List<SliceItem<File>> list, long j10, C12122a c12122a) {
        super("dl", str, "PUT");
        ArrayList arrayList = new ArrayList();
        this.sliceItems = arrayList;
        this.headers = map;
        arrayList.addAll(list);
        this.length = j10;
        this.progress = c12122a;
    }
}
