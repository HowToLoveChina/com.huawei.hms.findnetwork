package com.huawei.hicloud.cloudbackup.server.callback;

import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import fk.C9721b;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Map;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p514o9.C11839m;
import p549p9.C12122a;

/* loaded from: classes6.dex */
public class DownloadCallback extends AbstractC4992a<Void> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "DownloadCallback";
    private File file;
    private Map<String, String> headers;
    private long position;
    private C12122a progress;
    private long range;

    public DownloadCallback(File file, long j10, long j11, Map<String, String> map, C12122a c12122a) {
        this.file = file;
        this.position = j10;
        this.range = j11;
        this.method = "GET";
        this.headers = map;
        this.progress = c12122a;
    }

    private void closeable(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C11839m.m70689w(TAG, "closeable close exception.");
            }
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) {
        C11839m.m70686d(TAG, "position = " + this.position + ", range =" + this.range);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bytes=");
        sb2.append(this.range);
        sb2.append("-");
        aVar.m71578e("Range", sb2.toString());
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.m71578e(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) throws Throwable {
        RandomAccessFile randomAccessFileM63448n;
        Throwable th2;
        InputStream inputStreamM71632s = HttpResponseBuilder.m71595s().m71632s();
        try {
            randomAccessFileM63448n = C10278a.m63448n(this.file, "rw");
        } catch (Throwable th3) {
            randomAccessFileM63448n = null;
            th2 = th3;
        }
        try {
            randomAccessFileM63448n.seek(this.position);
            this.progress.mo17784f(this.position);
            byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
            boolean zMo17782d = this.progress.mo17782d();
            int i10 = inputStreamM71632s.read(bArr);
            while (i10 != -1 && !zMo17782d) {
                randomAccessFileM63448n.write(bArr, 0, i10);
                this.progress.m72686c(i10);
                i10 = inputStreamM71632s.read(bArr);
                zMo17782d = this.progress.mo17782d();
            }
            this.progress.mo17783e(true);
            if (zMo17782d) {
                cancel();
                throw new C9721b(1002, "net disable or canceled by user", "download");
            }
            closeable(inputStreamM71632s);
            closeable(randomAccessFileM63448n);
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            closeable(inputStreamM71632s);
            closeable(randomAccessFileM63448n);
            throw th2;
        }
    }
}
