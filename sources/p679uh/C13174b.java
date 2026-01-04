package p679uh;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import p373iu.C10617e;
import p613rh.C12510a;
import th.C13012a;

/* renamed from: uh.b */
/* loaded from: classes4.dex */
public final class C13174b {

    /* renamed from: a */
    public URLConnection f59698a;

    /* renamed from: a */
    public final void m79215a(Closeable closeable) throws IOException {
        StringBuilder sb2;
        String str;
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str = "close IO IOException:";
                sb2.append(str);
                sb2.append(e.toString());
                C13012a.m78317c("IoUtils", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                str = "close IO execption:";
                sb2.append(str);
                sb2.append(e.toString());
                C13012a.m78317c("IoUtils", sb2.toString());
            }
        }
    }

    /* renamed from: b */
    public final void m79216b(URLConnection uRLConnection, InputStream inputStream, C12510a c12510a) throws IOException {
        byte[] bArr;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                String contentEncoding = uRLConnection.getContentEncoding();
                C13012a.m78315a("HTTPUtil", "parseHttpResponse contentType =" + contentEncoding);
                bufferedInputStream = (Constants.GZIP.equals(contentEncoding) || "z".equals(contentEncoding)) ? new BufferedInputStream(new GZIPInputStream(inputStream)) : new BufferedInputStream(inputStream);
                bArr = new byte[65536];
            } catch (Throwable th2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e10) {
                        C13012a.m78316b("HTTPUtil", "close error", e10);
                    }
                }
                throw th2;
            }
        } catch (IOException e11) {
            C13012a.m78316b("HTTPUtil", "parseHttpResponse error!", e11);
            if (bufferedInputStream == null) {
                return;
            }
        }
        do {
            int i10 = bufferedInputStream.read(bArr);
            if (i10 != -1) {
                c12510a.m75105c(bArr, i10);
            }
            try {
                bufferedInputStream.close();
                return;
            } catch (IOException e12) {
                C13012a.m78316b("HTTPUtil", "close error", e12);
                return;
            }
        } while (c12510a.m75107e() <= 4194304);
        c12510a.m75104b();
        C13012a.m78317c("HTTPUtil", "File being unzipped is too big.");
        try {
            bufferedInputStream.close();
        } catch (IOException e13) {
            C13012a.m78316b("HTTPUtil", "close error", e13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [uh.b] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    /* renamed from: c */
    public byte[] m79217c(Context context, String str, String str2, String str3) throws Exception {
        ?? r72;
        OutputStream outputStream;
        C12510a c12510a = new C12510a();
        InputStream inputStream = null;
        try {
            try {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                this.f59698a = uRLConnectionOpenConnection;
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("POST");
                }
                URLConnection uRLConnection = this.f59698a;
                if (uRLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                    httpsURLConnection.setSSLSocketFactory(C10617e.m65071b(context));
                    httpsURLConnection.setHostnameVerifier(C10617e.f51042j);
                }
                this.f59698a.setConnectTimeout(5000);
                this.f59698a.setDoInput(true);
                this.f59698a.setDoOutput(true);
                this.f59698a.setReadTimeout(10000);
                this.f59698a.setDefaultUseCaches(false);
                this.f59698a.setUseCaches(false);
                this.f59698a.setRequestProperty("Content-Type", "application/x-gzip");
                this.f59698a.setRequestProperty("Content-Encoding", Constants.GZIP);
                this.f59698a.setRequestProperty("User-Agent", C13176d.m79224b(context));
                outputStream = this.f59698a.getOutputStream();
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw e11;
            } catch (Throwable th2) {
                th = th2;
                r72 = 0;
            }
            try {
                outputStream.write(AbstractC13173a.m79214a(str2.getBytes(str3)));
                outputStream.flush();
                if (this.f59698a instanceof HttpURLConnection) {
                    C13012a.m78318d("HTTPUtil", "ResponseCode:" + ((HttpURLConnection) this.f59698a).getResponseCode());
                }
                inputStream = this.f59698a.getInputStream();
                m79216b(this.f59698a, inputStream, c12510a);
                if (inputStream != null) {
                    m79215a(inputStream);
                }
                m79215a(outputStream);
                URLConnection uRLConnection2 = this.f59698a;
                if (uRLConnection2 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection2).disconnect();
                }
                return c12510a.m75106d();
            } catch (IOException e12) {
                throw e12;
            } catch (Exception e13) {
                throw e13;
            } catch (Throwable th3) {
                r72 = outputStream;
                th = th3;
                if (inputStream != null) {
                    m79215a(inputStream);
                }
                if (r72 != 0) {
                    m79215a(r72);
                }
                URLConnection uRLConnection3 = this.f59698a;
                if (uRLConnection3 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection3).disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r72 = str;
        }
    }
}
