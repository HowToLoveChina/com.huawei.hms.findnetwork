package p740wh;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import com.huawei.appgallery.marketinstallerservice.p094a.p095e.C4570a;
import com.huawei.hms.network.embedded.C5966j2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import mh.C11469b;
import org.apache.http.conn.ssl.SSLSocketFactory;
import p373iu.C10617e;
import p492nh.C11705a;
import ph.C12141a;
import sh.C12798a;
import th.C13012a;

/* renamed from: wh.a */
/* loaded from: classes4.dex */
public class AsyncTaskC13606a extends AsyncTask<Void, Integer, Void> {

    /* renamed from: a */
    public a f61198a;

    /* renamed from: b */
    public MarketInfo f61199b;

    /* renamed from: c */
    public String f61200c;

    /* renamed from: d */
    public String f61201d;

    /* renamed from: e */
    public String f61202e;

    /* renamed from: f */
    public String f61203f = null;

    /* renamed from: g */
    public int f61204g = 0;

    /* renamed from: h */
    public int f61205h = 0;

    /* renamed from: wh.a$a */
    public interface a {
        /* renamed from: a */
        void mo81806a(int i10, int i11);

        /* renamed from: b */
        Context mo81807b();

        /* renamed from: d */
        void mo81808d(MarketInfo marketInfo, int i10, int i11);
    }

    public AsyncTaskC13606a(a aVar, InstallParamSpec installParamSpec) {
        this.f61200c = null;
        this.f61201d = null;
        this.f61202e = null;
        this.f61198a = aVar;
        this.f61199b = installParamSpec.getMarketInfo();
        this.f61200c = installParamSpec.getServerUrl();
        this.f61201d = installParamSpec.getSubsystem();
        this.f61202e = installParamSpec.getMarketPkg();
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws IOException {
        if (this.f61198a == null) {
            C13012a.m78317c("MarketDownloadTask", "the callback is null error!");
            return null;
        }
        if (this.f61199b == null) {
            C13012a.m78318d("MarketDownloadTask", "start getMarketInfo");
            C4570a c4570aNewInstance = C4570a.newInstance(this.f61198a.mo81807b());
            c4570aNewInstance.setServiceUrl(this.f61200c);
            c4570aNewInstance.setSubsystem(this.f61201d);
            c4570aNewInstance.setMarketPkg(this.f61202e);
            ResponseBean responseBeanM72778a = C12141a.m72778a(c4570aNewInstance);
            if (!(responseBeanM72778a instanceof C11705a)) {
                C13012a.m78317c("MarketDownloadTask", "getMarketInfo error response is null!");
                this.f61204g = -1;
                publishProgress(0, 0);
                return null;
            }
            this.f61204g = responseBeanM72778a.getResponseCode();
            int rtnCode = responseBeanM72778a.getRtnCode();
            this.f61205h = rtnCode;
            if (this.f61204g == 0 && rtnCode == 0) {
                C11705a c11705a = (C11705a) responseBeanM72778a;
                if (c11705a.getHiAppInfo() != null) {
                    this.f61199b = c11705a.getHiAppInfo();
                    publishProgress(0, 0);
                }
            }
            C13012a.m78317c("MarketDownloadTask", "getMarketInfo error: responseCode:" + this.f61204g + ", returnCode:" + this.f61204g);
            publishProgress(0, 0);
            return null;
        }
        C13012a.m78318d("MarketDownloadTask", "allready has marketinfo!");
        publishProgress(0, 0);
        if (TextUtils.isEmpty(this.f61199b.getPkgName()) || this.f61199b.getFileSize() == 0 || TextUtils.isEmpty(this.f61199b.getSha256()) || TextUtils.isEmpty(this.f61199b.getDownUrl())) {
            C13012a.m78317c("MarketDownloadTask", "getMarketInfo content is error!");
            publishProgress(4, 0);
            return null;
        }
        this.f61203f = C11469b.m68596a(this.f61198a.mo81807b());
        if (m81804g()) {
            m81805h();
            return null;
        }
        publishProgress(2, 0);
        return null;
    }

    /* renamed from: b */
    public final HttpURLConnection m81799b(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(C5966j2.f27080v, "identity");
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(C10617e.m65071b(this.f61198a.mo81807b()));
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        return httpURLConnection;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (numArr.length < 2) {
            return;
        }
        int iIntValue = numArr[0].intValue();
        int iIntValue2 = numArr[1].intValue();
        if (iIntValue == 0) {
            this.f61198a.mo81808d(this.f61199b, this.f61204g, this.f61205h);
            return;
        }
        if (iIntValue == 1 || iIntValue == 2 || iIntValue == 3 || iIntValue == 4 || iIntValue == 5) {
            this.f61198a.mo81806a(iIntValue, iIntValue2);
        }
    }

    /* renamed from: d */
    public final boolean m81801d() throws Throwable {
        String strM76787b = C12798a.m76787b(this.f61203f, "SHA-256");
        if (strM76787b != null) {
            return strM76787b.equalsIgnoreCase(this.f61199b.getSha256());
        }
        C13012a.m78319e("MarketDownloadTask", "checkDownloadedFile: file hash is null");
        return false;
    }

    /* renamed from: e */
    public final boolean m81802e(HttpURLConnection httpURLConnection) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(this.f61203f)));
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (IOException unused) {
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (IOException unused2) {
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            long j10 = 0;
            int i10 = 0;
            while (true) {
                int i11 = bufferedInputStream.read(bArr);
                if (i11 == -1) {
                    C12798a.m76788c(bufferedInputStream);
                    C12798a.m76788c(bufferedOutputStream);
                    return true;
                }
                bufferedOutputStream.write(bArr, 0, i11);
                j10 += i11;
                int fileSize = (int) ((100 * j10) / this.f61199b.getFileSize());
                if (fileSize != i10) {
                    publishProgress(1, Integer.valueOf(fileSize));
                    i10 = fileSize;
                }
            }
        } catch (IOException unused3) {
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                C13012a.m78319e("MarketDownloadTask", "AppDownloadTask readStream exception IOException!");
                C12798a.m76788c(bufferedInputStream);
                C12798a.m76788c(bufferedOutputStream2);
                return false;
            } catch (Throwable th4) {
                th = th4;
                C12798a.m76788c(bufferedInputStream);
                C12798a.m76788c(bufferedOutputStream2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream2 = bufferedOutputStream;
            C12798a.m76788c(bufferedInputStream);
            C12798a.m76788c(bufferedOutputStream2);
            throw th;
        }
    }

    /* renamed from: f */
    public final HttpURLConnection m81803f() throws IOException {
        String str;
        try {
            HttpURLConnection httpURLConnectionM81799b = m81799b(this.f61199b.getDownUrl());
            httpURLConnectionM81799b.connect();
            int responseCode = httpURLConnectionM81799b.getResponseCode();
            if (responseCode == 200) {
                return httpURLConnectionM81799b;
            }
            C13012a.m78319e("MarketDownloadTask", "AppDownloadTask responseCode error:" + responseCode);
            return null;
        } catch (IOException unused) {
            str = "AppDownloadTask connect IOException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        } catch (IllegalAccessException unused2) {
            str = "AppDownloadTask connect IllegalAccessException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        } catch (KeyManagementException unused3) {
            str = "AppDownloadTask connect KeyManagementException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        } catch (KeyStoreException unused4) {
            str = "AppDownloadTask connect KeyStoreException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        } catch (NoSuchAlgorithmException unused5) {
            str = "AppDownloadTask connect NoSuchAlgorithmException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        } catch (CertificateException unused6) {
            str = "AppDownloadTask connect CertificateException!";
            C13012a.m78319e("MarketDownloadTask", str);
            return null;
        }
    }

    /* renamed from: g */
    public final boolean m81804g() {
        File file = new File(this.f61203f);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            C13012a.m78317c("MarketDownloadTask", "createDownloadFile failed");
            return false;
        }
        if (!file.exists() || file.delete()) {
            return true;
        }
        C13012a.m78317c("MarketDownloadTask", "createDownloadFile failed");
        return false;
    }

    /* renamed from: h */
    public final void m81805h() throws IOException {
        HttpURLConnection httpURLConnectionM81803f = m81803f();
        if (httpURLConnectionM81803f == null) {
            publishProgress(2, 0);
            return;
        }
        if (!m81802e(httpURLConnectionM81803f)) {
            publishProgress(2, 0);
        } else if (m81801d()) {
            publishProgress(3, 0);
        } else {
            C13012a.m78319e("MarketDownloadTask", "checkDownloadedFile failed");
            publishProgress(5, 0);
        }
    }
}
