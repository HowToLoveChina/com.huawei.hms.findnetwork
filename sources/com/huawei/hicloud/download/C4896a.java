package com.huawei.hicloud.download;

import ck.C1443a;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.okhttp.callback.AbstractC4975a;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p399jk.AbstractC10896a;
import p616rk.C12515a;
import p681uj.C13191h;
import p813yk.C13994a;
import tn.C13046d;

/* renamed from: com.huawei.hicloud.download.a */
/* loaded from: classes6.dex */
public class C4896a extends AbstractC4975a<Void> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "DownloadFileToLocalPathCallback";
    private long marked;
    private String path;
    private String url;

    public C4896a(String str, long j10) {
        this.path = str;
        this.marked = j10;
    }

    private void closeStream(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                AbstractC10896a.m65887i(TAG, "stream close exception.");
            }
        }
    }

    public String getUrl() {
        return C13994a.m84032a(this.url);
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) {
        String str = C1443a.f6213a;
        aVar.addHeader("version", str);
        aVar.addHeader("ip", str);
        aVar.addHeader("x-hw-app-version", str);
        boolean zM79249b = C13191h.m79248a().m79249b("enableDownloadOMConfigFileCompress");
        boolean zM79252e = C13191h.m79248a().m79252e();
        AbstractC10896a.m65887i(TAG, "DownloadFileToLocalPathCallback isGrayOpen: " + zM79249b + " isDefaultGzip: " + zM79252e);
        if (!zM79249b) {
            aVar.addHeader("Range", "bytes=" + this.marked + "-");
        } else if (zM79252e) {
            aVar.addHeader(C5966j2.f27080v, Constants.GZIP);
        } else {
            aVar.addHeader(C5966j2.f27080v, "gzip, br");
        }
        String strM71565e = aVar.m71575b().m71565e(C5966j2.f27080v);
        AbstractC10896a.m65887i(TAG, "Accept-Encoding: " + strM71565e);
        C12515a.m75110o().m75175e(new C13046d(strM71565e), false);
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) throws Throwable {
        InputStream inputStreamM71632s = HttpResponseBuilder.m71595s().m71632s();
        Closeable closeable = null;
        try {
            try {
                File file = new File(this.path);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
                    AbstractC10896a.m65886e(TAG, "local parent create success.");
                }
                if (file.exists() && !file.delete()) {
                    AbstractC10896a.m65886e(TAG, "onResponse delete file failed");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.path), "rw");
                try {
                    randomAccessFile.seek(this.marked);
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (true) {
                        int i10 = inputStreamM71632s.read(bArr);
                        if (i10 == -1) {
                            closeStream(inputStreamM71632s);
                            closeStream(randomAccessFile);
                            closeStream(HttpResponseBuilder);
                            return null;
                        }
                        randomAccessFile.write(bArr, 0, i10);
                    }
                } catch (Exception e10) {
                    e = e10;
                    closeable = randomAccessFile;
                    AbstractC10896a.m65887i(TAG, e.toString());
                    throw new C9721b(4000, e.toString());
                } catch (Throwable th2) {
                    th = th2;
                    closeable = randomAccessFile;
                    closeStream(inputStreamM71632s);
                    closeStream(closeable);
                    closeStream(HttpResponseBuilder);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public C4896a(String str, String str2, long j10) {
        this.path = str2;
        this.marked = j10;
        this.url = str;
    }
}
