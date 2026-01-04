package no;

import ck.C1443a;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import fk.C9721b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p514o9.C11839m;
import p813yk.C13994a;

/* renamed from: no.b */
/* loaded from: classes6.dex */
public class C11739b extends AbstractC4992a<Void> {

    /* renamed from: a */
    public String f54294a;

    /* renamed from: b */
    public long f54295b;

    /* renamed from: c */
    public String f54296c;

    public C11739b(String str, long j10) {
        this.f54294a = str;
        this.f54295b = j10;
    }

    /* renamed from: a */
    public final void m70043a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C11839m.m70688i("DownloadFileCallback", "stream close exception.");
            }
        }
    }

    /* renamed from: b */
    public String m70044b() {
        return C13994a.m84032a(this.f54296c);
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) {
        String str = C1443a.f6213a;
        aVar.m71574a("version", str);
        aVar.m71574a("ip", str);
        aVar.m71574a("Range", "bytes=" + this.f54295b + "-");
        aVar.m71574a("x-hw-app-version", str);
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public Void onResponse(C11922g0 c11922g0) throws Throwable {
        InputStream inputStreamM71632s = c11922g0.m71595s().m71632s();
        Closeable closeable = null;
        try {
            try {
                File file = new File(this.f54294a);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
                    C11839m.m70687e("DownloadFileCallback", "local parent create success.");
                }
                if (file.exists() && !file.delete()) {
                    C11839m.m70687e("DownloadFileCallback", "onResponse delete file failed");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f54294a), "rw");
                try {
                    randomAccessFile.seek(this.f54295b);
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (true) {
                        int i10 = inputStreamM71632s.read(bArr);
                        if (i10 == -1) {
                            m70043a(inputStreamM71632s);
                            m70043a(randomAccessFile);
                            m70043a(c11922g0);
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
                    m70043a(inputStreamM71632s);
                    m70043a(closeable);
                    m70043a(c11922g0);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public C11739b(String str, String str2, long j10) {
        this.f54294a = str2;
        this.f54295b = j10;
        this.f54296c = str;
    }
}
