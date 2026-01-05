package no;

import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import fk.C9721b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.AbstractC11924h0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p514o9.C11839m;

/* renamed from: no.c */
/* loaded from: classes6.dex */
public class C11740c extends AbstractC4992a<Void> {

    /* renamed from: a */
    public String f54297a;

    public C11740c(String str) {
        this.f54297a = str;
    }

    /* renamed from: a */
    private void m70045a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C11839m.m70688i("DownloadFileCallback", "stream close exception.");
            }
        }
    }

    /* renamed from: b */
    public final void m70046b(long j10) {
        if (TextUtils.isEmpty(this.f54297a)) {
            return;
        }
        File file = new File(this.f54297a);
        if (j10 < 0 || file.length() < j10) {
            C11839m.m70689w("DownloadFileCallback", "length not match, delete file");
            if (file.delete()) {
                return;
            }
            C11839m.m70687e("DownloadFileCallback", "length not match, delete file failed");
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) {
        String str = C1443a.f6213a;
        aVar.addHeader("version", str);
        aVar.addHeader("ip", str);
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) throws Throwable {
        AbstractC11924h0 abstractC11924h0M71595s = HttpResponseBuilder.m71595s();
        long jMo71634u = abstractC11924h0M71595s.mo71634u();
        InputStream inputStreamM71632s = abstractC11924h0M71595s.m71632s();
        Closeable closeable = null;
        try {
            try {
                File file = new File(this.f54297a);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
                    C11839m.m70687e("DownloadFileCallback", "local parent create success.");
                }
                if (file.exists() && !file.delete()) {
                    C11839m.m70687e("DownloadFileCallback", "onResponse delete file failed");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f54297a), "rw");
                try {
                    randomAccessFile.seek(0L);
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (true) {
                        int i10 = inputStreamM71632s.read(bArr);
                        if (i10 == -1) {
                            m70045a(inputStreamM71632s);
                            m70045a(randomAccessFile);
                            m70045a(HttpResponseBuilder);
                            m70046b(jMo71634u);
                            return null;
                        }
                        randomAccessFile.write(bArr, 0, i10);
                    }
                } catch (Exception e10) {
                    e = e10;
                    closeable = randomAccessFile;
                    C11839m.m70688i("DownloadFileCallback", e.toString());
                    throw new C9721b(4000, e.toString());
                } catch (Throwable th2) {
                    th = th2;
                    closeable = randomAccessFile;
                    m70045a(inputStreamM71632s);
                    m70045a(closeable);
                    m70045a(HttpResponseBuilder);
                    m70046b(jMo71634u);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
