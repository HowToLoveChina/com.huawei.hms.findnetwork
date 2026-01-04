package com.huawei.fastengine.fastview.download.download;

import android.content.Context;
import com.huawei.fastengine.fastview.HttpsSetting;
import com.huawei.fastengine.fastview.download.download.bean.DownLoadResponse;
import com.huawei.fastengine.fastview.download.download.bean.DownloadRequest;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.HEX;
import com.huawei.fastengine.fastview.download.utils.IoUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.util.ThreadUtil;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11921g;
import p373iu.C10616d;
import p373iu.C10617e;

/* loaded from: classes5.dex */
public class DownloadManager {
    private static final String TAG = "DownloadManager";
    private static final int TIMEOUT = 80000;
    private static DownloadManager instance = new DownloadManager();
    private boolean isDownload = true;

    /* renamed from: com.huawei.fastengine.fastview.download.download.DownloadManager$1 */
    public class RunnableC47001 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ DownloadListener val$listener;
        final /* synthetic */ DownloadRequest val$request;

        public RunnableC47001(DownloadRequest downloadRequest, Context context, DownloadListener downloadListener) {
            downloadRequest = downloadRequest;
            context = context;
            downloadListener = downloadListener;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            InputStream inputStream;
            File file;
            SecureRandom secureRandom;
            FastViewLogUtils.m28726i(DownloadManager.TAG, "downloadAsync");
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConn = DownloadManager.this.openConn(downloadRequest.getUrl(), context, downloadRequest.getTimeOut());
                    int responseCode = httpURLConnectionOpenConn.getResponseCode();
                    if (responseCode != 200) {
                        FastViewLogUtils.m28724e(DownloadManager.TAG, "server response code is not 200,code is " + responseCode);
                        downloadListener.failure(1);
                        IoUtils.closeStream(null);
                        IoUtils.closeStream(null);
                        return;
                    }
                    int size = downloadRequest.getSize();
                    if (size == -1) {
                        try {
                            size = Integer.parseInt(httpURLConnectionOpenConn.getHeaderField("Content-Length"));
                        } catch (NumberFormatException unused) {
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "get download content-length NumberFormatException.");
                        }
                    }
                    inputStream = httpURLConnectionOpenConn.getInputStream();
                    try {
                        if (downloadRequest.getOutFile() != null) {
                            if (downloadRequest.getOutFile().exists()) {
                                if (!downloadRequest.isNeedCheck()) {
                                    downloadListener.success(downloadRequest.getOutFile());
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(null);
                                    return;
                                } else if (DownloadManager.this.checkRpkValid(downloadRequest.getOutFile(), downloadRequest.getHash())) {
                                    downloadListener.success(downloadRequest.getOutFile());
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(null);
                                    return;
                                }
                            }
                            try {
                                secureRandom = SecureRandom.getInstanceStrong();
                            } catch (NoSuchAlgorithmException unused2) {
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "SecureRandom.getInstanceStrong fail");
                                secureRandom = null;
                            }
                            if (secureRandom == null) {
                                secureRandom = new SecureRandom();
                            }
                            file = new File(downloadRequest.getOutFile().getCanonicalPath() + "_tmp_" + System.currentTimeMillis() + "_" + secureRandom.nextInt(10000) + "_" + secureRandom.nextInt(10000));
                            try {
                                if (!file.createNewFile()) {
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "create tmp file failed ");
                                    downloadListener.failure(2);
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(null);
                                    return;
                                }
                            } catch (IOException unused3) {
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                                DownloadManager.deleteFile(file);
                                downloadListener.failure(3);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream);
                            } catch (SecurityException unused4) {
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                                DownloadManager.deleteFile(file);
                                downloadListener.failure(2);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream);
                            }
                        } else {
                            file = new File(context.getFilesDir(), System.currentTimeMillis() + ".apk");
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[2048];
                            int i10 = inputStream.read(bArr);
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "isDownload:" + DownloadManager.this.isDownload);
                            int i11 = 0;
                            int i12 = 0;
                            while (i10 != -1 && DownloadManager.this.isDownload) {
                                i11++;
                                fileOutputStream2.write(bArr, 0, i10);
                                i10 = inputStream.read(bArr);
                                i12 += i10;
                                if (i11 % 200 == 0 || i12 == size) {
                                    downloadListener.progress(i12, size);
                                }
                            }
                            if (!DownloadManager.this.isDownload) {
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "!isDownload" + DownloadManager.this.isDownload);
                                DownloadManager.deleteFile(file);
                                downloadListener.failure(4);
                                DownloadManager.this.isDownload = true;
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream2);
                                return;
                            }
                            downloadListener.progress(size, size);
                            if (downloadRequest.isNeedCheck()) {
                                if (!DownloadManager.this.checkRpkValid(file, downloadRequest.getHash())) {
                                    DownloadManager.deleteFile(file);
                                    downloadListener.failure(2);
                                } else if (downloadRequest.getOutFile() == null) {
                                    DownloadManager.this.setFileReadable(file);
                                    downloadListener.success(file);
                                } else {
                                    if (downloadRequest.getOutFile().exists() && DownloadManager.this.checkRpkValid(downloadRequest.getOutFile(), downloadRequest.getHash())) {
                                        downloadListener.success(downloadRequest.getOutFile());
                                        DownloadManager.deleteFile(file);
                                        IoUtils.closeStream(inputStream);
                                        IoUtils.closeStream(fileOutputStream2);
                                        return;
                                    }
                                    synchronized (DownloadManager.class) {
                                        try {
                                            if (file.renameTo(downloadRequest.getOutFile())) {
                                                DownloadManager.this.setFileReadable(downloadRequest.getOutFile());
                                                downloadListener.success(downloadRequest.getOutFile());
                                            } else {
                                                FastViewLogUtils.m28724e(DownloadManager.TAG, "downloadAsync rename to failed");
                                                DownloadManager.deleteFile(file);
                                                downloadListener.failure(2);
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            } else if (downloadRequest.getOutFile() == null) {
                                DownloadManager.this.setFileReadable(file);
                                downloadListener.success(file);
                            } else {
                                if (downloadRequest.getOutFile().exists()) {
                                    downloadListener.success(downloadRequest.getOutFile());
                                    DownloadManager.deleteFile(file);
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(fileOutputStream2);
                                    return;
                                }
                                synchronized (DownloadManager.class) {
                                    try {
                                        if (file.renameTo(downloadRequest.getOutFile())) {
                                            DownloadManager.this.setFileReadable(downloadRequest.getOutFile());
                                            downloadListener.success(downloadRequest.getOutFile());
                                        } else {
                                            FastViewLogUtils.m28724e(DownloadManager.TAG, "rename to failed");
                                            DownloadManager.deleteFile(file);
                                            downloadListener.failure(2);
                                        }
                                    } finally {
                                    }
                                }
                            }
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream2);
                        } catch (IOException unused5) {
                            fileOutputStream = fileOutputStream2;
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                            DownloadManager.deleteFile(file);
                            downloadListener.failure(3);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                        } catch (SecurityException unused6) {
                            fileOutputStream = fileOutputStream2;
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                            DownloadManager.deleteFile(file);
                            downloadListener.failure(2);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused7) {
                        file = null;
                        FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                        DownloadManager.deleteFile(file);
                        downloadListener.failure(3);
                        IoUtils.closeStream(inputStream);
                        IoUtils.closeStream(fileOutputStream);
                    } catch (SecurityException unused8) {
                        file = null;
                        FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                        DownloadManager.deleteFile(file);
                        downloadListener.failure(2);
                        IoUtils.closeStream(inputStream);
                        IoUtils.closeStream(fileOutputStream);
                    }
                } catch (IOException unused9) {
                    inputStream = null;
                } catch (SecurityException unused10) {
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.download.download.DownloadManager$2 */
    public class C47012 implements InterfaceC11921g {
        final /* synthetic */ Context val$context;
        final /* synthetic */ DownloadListener val$listener;
        final /* synthetic */ DownloadRequest val$request;

        public C47012(DownloadListener downloadListener, DownloadRequest downloadRequest, Context context) {
            downloadListener = downloadListener;
            downloadRequest = downloadRequest;
            context = context;
        }

        @Override // okhttp3.InterfaceC11921g
        public void onFailure(InterfaceC11919f interfaceC11919f, IOException iOException) {
            downloadListener.failure(1);
            FastViewLogUtils.m28724e(DownloadManager.TAG, " call failure ");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [okhttp3.g0] */
        /* JADX WARN: Type inference failed for: r13v10, types: [java.io.Closeable, java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r13v11 */
        /* JADX WARN: Type inference failed for: r13v12 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r13v5 */
        /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r13v8, types: [java.io.Closeable] */
        @Override // okhttp3.InterfaceC11921g
        public void onResponse(InterfaceC11919f interfaceC11919f, C11922g0 c11922g0) throws Throwable {
            FileOutputStream fileOutputStream;
            File file;
            FileOutputStream fileOutputStream2;
            byte[] bArr;
            if (c11922g0 == 0 || c11922g0.m71595s() == null) {
                FastViewLogUtils.m28724e(DownloadManager.TAG, " onResponse empty ");
                downloadListener.failure(1);
                return;
            }
            FastViewLogUtils.m28726i(DownloadManager.TAG, " response.code() " + c11922g0.m71597u());
            int size = downloadRequest.getSize();
            if (size == -1) {
                try {
                    size = (int) c11922g0.m71595s().mo71634u();
                } catch (NumberFormatException unused) {
                    FastViewLogUtils.m28724e(DownloadManager.TAG, "get download content-length failure.");
                    downloadListener.failure(1);
                    return;
                }
            }
            if (c11922g0.m71597u() == 404) {
                downloadListener.failure(1);
                return;
            }
            FileOutputStream fileOutputStream3 = null;
            fileOutputStream = null;
            FileOutputStream fileOutputStream4 = null;
            fileOutputStream3 = null;
            try {
                try {
                    c11922g0 = c11922g0.m71595s().m71632s();
                    try {
                        file = new File(context.getFilesDir(), System.currentTimeMillis() + ".apk");
                        fileOutputStream2 = new FileOutputStream(file);
                        try {
                            bArr = new byte[2048];
                            int i10 = c11922g0.read(bArr);
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "isDownload" + DownloadManager.this.isDownload);
                            int i11 = 0;
                            int i12 = 0;
                            while (i10 != -1 && DownloadManager.this.isDownload) {
                                i11++;
                                fileOutputStream2.write(bArr, 0, i10);
                                i10 = c11922g0.read(bArr);
                                i12 += i10;
                                if (i11 % 200 == 0 || i12 == size) {
                                    downloadListener.progress(i12, size);
                                }
                            }
                        } catch (IOException unused2) {
                            fileOutputStream4 = fileOutputStream2;
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "IOException");
                            downloadListener.failure(1);
                            fileOutputStream = fileOutputStream4;
                            fileOutputStream3 = fileOutputStream4;
                            c11922g0 = c11922g0;
                            IoUtils.closeStream(c11922g0);
                            IoUtils.closeStream(fileOutputStream);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream3 = fileOutputStream2;
                            IoUtils.closeStream(c11922g0);
                            IoUtils.closeStream(fileOutputStream3);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    c11922g0 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    c11922g0 = 0;
                }
                if (!DownloadManager.this.isDownload) {
                    FastViewLogUtils.m28724e(DownloadManager.TAG, "!isDownload" + DownloadManager.this.isDownload);
                    DownloadManager.deleteFile(file);
                    downloadListener.failure(4);
                    DownloadManager.this.isDownload = true;
                    IoUtils.closeStream(c11922g0);
                    IoUtils.closeStream(fileOutputStream2);
                    return;
                }
                downloadListener.progress(size, size);
                if (!downloadRequest.isNeedCheck()) {
                    DownloadManager.this.setFileReadable(file);
                    downloadListener.success(file);
                    fileOutputStream3 = bArr;
                    fileOutputStream = fileOutputStream2;
                    c11922g0 = c11922g0;
                    IoUtils.closeStream(c11922g0);
                    IoUtils.closeStream(fileOutputStream);
                    return;
                }
                if (DownloadManager.this.checkRpkValid(file, downloadRequest.getHash())) {
                    DownloadManager.this.setFileReadable(file);
                    downloadListener.success(file);
                    IoUtils.closeStream(c11922g0);
                    IoUtils.closeStream(fileOutputStream2);
                    return;
                }
                DownloadManager.deleteFile(file);
                downloadListener.failure(2);
                IoUtils.closeStream(c11922g0);
                IoUtils.closeStream(fileOutputStream2);
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public boolean checkRpkValid(File file, String str) throws Throwable {
        byte[] bArrDigestSha2 = HashUtils.digestSha2(file);
        if (bArrDigestSha2 != null) {
            return HEX.encodeHexString(bArrDigestSha2, true).equalsIgnoreCase(str);
        }
        return false;
    }

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static DownloadManager getInstance() {
        return instance;
    }

    private static C10617e getSSLFactory(Context context) throws IllegalAccessException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        return C10617e.m65071b(context);
    }

    private static SecureX509TrustManager getTrustManager(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        return new SecureX509TrustManager(context);
    }

    public HttpURLConnection openConn(String str, Context context, int i10) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) CommonUtils.cast(new URL(str).openConnection(), HttpURLConnection.class, false);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsSetting.initHttpsURLConnection((HttpsURLConnection) httpURLConnection, context.getApplicationContext());
        }
        if (i10 > 0) {
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
        } else {
            httpURLConnection.setConnectTimeout(TIMEOUT);
            httpURLConnection.setReadTimeout(TIMEOUT);
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    public void setFileReadable(File file) {
        if (file.setReadable(true, false)) {
            return;
        }
        FastViewLogUtils.m28724e(TAG, "can not set readable to apk");
    }

    public void downloadAsync(DownloadRequest downloadRequest, Context context, DownloadListener downloadListener) {
        ThreadUtil.INST.excute(new Runnable() { // from class: com.huawei.fastengine.fastview.download.download.DownloadManager.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ DownloadListener val$listener;
            final /* synthetic */ DownloadRequest val$request;

            public RunnableC47001(DownloadRequest downloadRequest2, Context context2, DownloadListener downloadListener2) {
                downloadRequest = downloadRequest2;
                context = context2;
                downloadListener = downloadListener2;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                InputStream inputStream;
                File file;
                SecureRandom secureRandom;
                FastViewLogUtils.m28726i(DownloadManager.TAG, "downloadAsync");
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        HttpURLConnection httpURLConnectionOpenConn = DownloadManager.this.openConn(downloadRequest.getUrl(), context, downloadRequest.getTimeOut());
                        int responseCode = httpURLConnectionOpenConn.getResponseCode();
                        if (responseCode != 200) {
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "server response code is not 200,code is " + responseCode);
                            downloadListener.failure(1);
                            IoUtils.closeStream(null);
                            IoUtils.closeStream(null);
                            return;
                        }
                        int size = downloadRequest.getSize();
                        if (size == -1) {
                            try {
                                size = Integer.parseInt(httpURLConnectionOpenConn.getHeaderField("Content-Length"));
                            } catch (NumberFormatException unused) {
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "get download content-length NumberFormatException.");
                            }
                        }
                        inputStream = httpURLConnectionOpenConn.getInputStream();
                        try {
                            if (downloadRequest.getOutFile() != null) {
                                if (downloadRequest.getOutFile().exists()) {
                                    if (!downloadRequest.isNeedCheck()) {
                                        downloadListener.success(downloadRequest.getOutFile());
                                        IoUtils.closeStream(inputStream);
                                        IoUtils.closeStream(null);
                                        return;
                                    } else if (DownloadManager.this.checkRpkValid(downloadRequest.getOutFile(), downloadRequest.getHash())) {
                                        downloadListener.success(downloadRequest.getOutFile());
                                        IoUtils.closeStream(inputStream);
                                        IoUtils.closeStream(null);
                                        return;
                                    }
                                }
                                try {
                                    secureRandom = SecureRandom.getInstanceStrong();
                                } catch (NoSuchAlgorithmException unused2) {
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "SecureRandom.getInstanceStrong fail");
                                    secureRandom = null;
                                }
                                if (secureRandom == null) {
                                    secureRandom = new SecureRandom();
                                }
                                file = new File(downloadRequest.getOutFile().getCanonicalPath() + "_tmp_" + System.currentTimeMillis() + "_" + secureRandom.nextInt(10000) + "_" + secureRandom.nextInt(10000));
                                try {
                                    if (!file.createNewFile()) {
                                        FastViewLogUtils.m28724e(DownloadManager.TAG, "create tmp file failed ");
                                        downloadListener.failure(2);
                                        IoUtils.closeStream(inputStream);
                                        IoUtils.closeStream(null);
                                        return;
                                    }
                                } catch (IOException unused3) {
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                                    DownloadManager.deleteFile(file);
                                    downloadListener.failure(3);
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(fileOutputStream);
                                } catch (SecurityException unused4) {
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                                    DownloadManager.deleteFile(file);
                                    downloadListener.failure(2);
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(fileOutputStream);
                                }
                            } else {
                                file = new File(context.getFilesDir(), System.currentTimeMillis() + ".apk");
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[2048];
                                int i10 = inputStream.read(bArr);
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "isDownload:" + DownloadManager.this.isDownload);
                                int i11 = 0;
                                int i12 = 0;
                                while (i10 != -1 && DownloadManager.this.isDownload) {
                                    i11++;
                                    fileOutputStream2.write(bArr, 0, i10);
                                    i10 = inputStream.read(bArr);
                                    i12 += i10;
                                    if (i11 % 200 == 0 || i12 == size) {
                                        downloadListener.progress(i12, size);
                                    }
                                }
                                if (!DownloadManager.this.isDownload) {
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "!isDownload" + DownloadManager.this.isDownload);
                                    DownloadManager.deleteFile(file);
                                    downloadListener.failure(4);
                                    DownloadManager.this.isDownload = true;
                                    IoUtils.closeStream(inputStream);
                                    IoUtils.closeStream(fileOutputStream2);
                                    return;
                                }
                                downloadListener.progress(size, size);
                                if (downloadRequest.isNeedCheck()) {
                                    if (!DownloadManager.this.checkRpkValid(file, downloadRequest.getHash())) {
                                        DownloadManager.deleteFile(file);
                                        downloadListener.failure(2);
                                    } else if (downloadRequest.getOutFile() == null) {
                                        DownloadManager.this.setFileReadable(file);
                                        downloadListener.success(file);
                                    } else {
                                        if (downloadRequest.getOutFile().exists() && DownloadManager.this.checkRpkValid(downloadRequest.getOutFile(), downloadRequest.getHash())) {
                                            downloadListener.success(downloadRequest.getOutFile());
                                            DownloadManager.deleteFile(file);
                                            IoUtils.closeStream(inputStream);
                                            IoUtils.closeStream(fileOutputStream2);
                                            return;
                                        }
                                        synchronized (DownloadManager.class) {
                                            try {
                                                if (file.renameTo(downloadRequest.getOutFile())) {
                                                    DownloadManager.this.setFileReadable(downloadRequest.getOutFile());
                                                    downloadListener.success(downloadRequest.getOutFile());
                                                } else {
                                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "downloadAsync rename to failed");
                                                    DownloadManager.deleteFile(file);
                                                    downloadListener.failure(2);
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                } else if (downloadRequest.getOutFile() == null) {
                                    DownloadManager.this.setFileReadable(file);
                                    downloadListener.success(file);
                                } else {
                                    if (downloadRequest.getOutFile().exists()) {
                                        downloadListener.success(downloadRequest.getOutFile());
                                        DownloadManager.deleteFile(file);
                                        IoUtils.closeStream(inputStream);
                                        IoUtils.closeStream(fileOutputStream2);
                                        return;
                                    }
                                    synchronized (DownloadManager.class) {
                                        try {
                                            if (file.renameTo(downloadRequest.getOutFile())) {
                                                DownloadManager.this.setFileReadable(downloadRequest.getOutFile());
                                                downloadListener.success(downloadRequest.getOutFile());
                                            } else {
                                                FastViewLogUtils.m28724e(DownloadManager.TAG, "rename to failed");
                                                DownloadManager.deleteFile(file);
                                                downloadListener.failure(2);
                                            }
                                        } finally {
                                        }
                                    }
                                }
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream2);
                            } catch (IOException unused5) {
                                fileOutputStream = fileOutputStream2;
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                                DownloadManager.deleteFile(file);
                                downloadListener.failure(3);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream);
                            } catch (SecurityException unused6) {
                                fileOutputStream = fileOutputStream2;
                                FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                                DownloadManager.deleteFile(file);
                                downloadListener.failure(2);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException unused7) {
                            file = null;
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is ioexception ");
                            DownloadManager.deleteFile(file);
                            downloadListener.failure(3);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                        } catch (SecurityException unused8) {
                            file = null;
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "download error, error is SecurityException ");
                            DownloadManager.deleteFile(file);
                            downloadListener.failure(2);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                        }
                    } catch (IOException unused9) {
                        inputStream = null;
                    } catch (SecurityException unused10) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        });
    }

    public void downloadAsyncOKHttp(DownloadRequest downloadRequest, Context context, DownloadListener downloadListener) {
        String str;
        try {
            C11912b0.c cVar = new C11912b0.c();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C11912b0.c cVarM71521r = cVar.m71507d(10L, timeUnit).m71519p(10L, timeUnit).m71522s(10L, timeUnit).m71514k(true).m71521r(getSSLFactory(context), getTrustManager(context));
            C11918e0 c11918e0M71575b = new C11918e0.a().m71586m(downloadRequest.getUrl()).m71575b();
            cVarM71521r.m71515l(C10616d.f51032h);
            cVarM71521r.m71505b().m71495z(c11918e0M71575b).mo71532e(new InterfaceC11921g() { // from class: com.huawei.fastengine.fastview.download.download.DownloadManager.2
                final /* synthetic */ Context val$context;
                final /* synthetic */ DownloadListener val$listener;
                final /* synthetic */ DownloadRequest val$request;

                public C47012(DownloadListener downloadListener2, DownloadRequest downloadRequest2, Context context2) {
                    downloadListener = downloadListener2;
                    downloadRequest = downloadRequest2;
                    context = context2;
                }

                @Override // okhttp3.InterfaceC11921g
                public void onFailure(InterfaceC11919f interfaceC11919f, IOException iOException) {
                    downloadListener.failure(1);
                    FastViewLogUtils.m28724e(DownloadManager.TAG, " call failure ");
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r13v0, types: [okhttp3.g0] */
                /* JADX WARN: Type inference failed for: r13v10, types: [java.io.Closeable, java.io.InputStream] */
                /* JADX WARN: Type inference failed for: r13v11 */
                /* JADX WARN: Type inference failed for: r13v12 */
                /* JADX WARN: Type inference failed for: r13v3 */
                /* JADX WARN: Type inference failed for: r13v4 */
                /* JADX WARN: Type inference failed for: r13v5 */
                /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
                /* JADX WARN: Type inference failed for: r13v7 */
                /* JADX WARN: Type inference failed for: r13v8, types: [java.io.Closeable] */
                @Override // okhttp3.InterfaceC11921g
                public void onResponse(InterfaceC11919f interfaceC11919f, C11922g0 c11922g0) throws Throwable {
                    FileOutputStream fileOutputStream;
                    File file;
                    FileOutputStream fileOutputStream2;
                    byte[] bArr;
                    if (c11922g0 == 0 || c11922g0.m71595s() == null) {
                        FastViewLogUtils.m28724e(DownloadManager.TAG, " onResponse empty ");
                        downloadListener.failure(1);
                        return;
                    }
                    FastViewLogUtils.m28726i(DownloadManager.TAG, " response.code() " + c11922g0.m71597u());
                    int size = downloadRequest.getSize();
                    if (size == -1) {
                        try {
                            size = (int) c11922g0.m71595s().mo71634u();
                        } catch (NumberFormatException unused) {
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "get download content-length failure.");
                            downloadListener.failure(1);
                            return;
                        }
                    }
                    if (c11922g0.m71597u() == 404) {
                        downloadListener.failure(1);
                        return;
                    }
                    FileOutputStream fileOutputStream3 = null;
                    fileOutputStream4 = null;
                    FileOutputStream fileOutputStream4 = null;
                    fileOutputStream3 = null;
                    try {
                        try {
                            c11922g0 = c11922g0.m71595s().m71632s();
                            try {
                                file = new File(context.getFilesDir(), System.currentTimeMillis() + ".apk");
                                fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    bArr = new byte[2048];
                                    int i10 = c11922g0.read(bArr);
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "isDownload" + DownloadManager.this.isDownload);
                                    int i11 = 0;
                                    int i12 = 0;
                                    while (i10 != -1 && DownloadManager.this.isDownload) {
                                        i11++;
                                        fileOutputStream2.write(bArr, 0, i10);
                                        i10 = c11922g0.read(bArr);
                                        i12 += i10;
                                        if (i11 % 200 == 0 || i12 == size) {
                                            downloadListener.progress(i12, size);
                                        }
                                    }
                                } catch (IOException unused2) {
                                    fileOutputStream4 = fileOutputStream2;
                                    FastViewLogUtils.m28724e(DownloadManager.TAG, "IOException");
                                    downloadListener.failure(1);
                                    fileOutputStream = fileOutputStream4;
                                    fileOutputStream3 = fileOutputStream4;
                                    c11922g0 = c11922g0;
                                    IoUtils.closeStream(c11922g0);
                                    IoUtils.closeStream(fileOutputStream);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream3 = fileOutputStream2;
                                    IoUtils.closeStream(c11922g0);
                                    IoUtils.closeStream(fileOutputStream3);
                                    throw th;
                                }
                            } catch (IOException unused3) {
                            }
                        } catch (IOException unused4) {
                            c11922g0 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            c11922g0 = 0;
                        }
                        if (!DownloadManager.this.isDownload) {
                            FastViewLogUtils.m28724e(DownloadManager.TAG, "!isDownload" + DownloadManager.this.isDownload);
                            DownloadManager.deleteFile(file);
                            downloadListener.failure(4);
                            DownloadManager.this.isDownload = true;
                            IoUtils.closeStream(c11922g0);
                            IoUtils.closeStream(fileOutputStream2);
                            return;
                        }
                        downloadListener.progress(size, size);
                        if (!downloadRequest.isNeedCheck()) {
                            DownloadManager.this.setFileReadable(file);
                            downloadListener.success(file);
                            fileOutputStream3 = bArr;
                            fileOutputStream = fileOutputStream2;
                            c11922g0 = c11922g0;
                            IoUtils.closeStream(c11922g0);
                            IoUtils.closeStream(fileOutputStream);
                            return;
                        }
                        if (DownloadManager.this.checkRpkValid(file, downloadRequest.getHash())) {
                            DownloadManager.this.setFileReadable(file);
                            downloadListener.success(file);
                            IoUtils.closeStream(c11922g0);
                            IoUtils.closeStream(fileOutputStream2);
                            return;
                        }
                        DownloadManager.deleteFile(file);
                        downloadListener.failure(2);
                        IoUtils.closeStream(c11922g0);
                        IoUtils.closeStream(fileOutputStream2);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            });
        } catch (IOException unused) {
            str = "IOException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (IllegalAccessException unused2) {
            str = "IllegalAccessException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (KeyManagementException unused3) {
            str = "KeyManagementException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (KeyStoreException unused4) {
            str = "KeyStoreException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (NoSuchAlgorithmException unused5) {
            str = "NoSuchAlgorithmException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (UnrecoverableKeyException unused6) {
            str = "UnrecoverableKeyException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        } catch (CertificateException unused7) {
            str = "CertificateException";
            FastViewLogUtils.m28724e(TAG, str);
            downloadListener2.failure(1);
        }
    }

    public DownLoadResponse downloadSync(DownloadRequest downloadRequest, Context context) throws Throwable {
        InputStream inputStream;
        File file;
        DownLoadResponse downLoadResponse = new DownLoadResponse();
        FileOutputStream fileOutputStream = null;
        try {
            HttpURLConnection httpURLConnectionOpenConn = openConn(downloadRequest.getUrl(), context, downloadRequest.getTimeOut());
            int responseCode = httpURLConnectionOpenConn.getResponseCode();
            if (responseCode != 200) {
                FastViewLogUtils.m28724e(TAG, "server response code is not 200,code is " + responseCode);
                downLoadResponse.setErrorCode(1);
                IoUtils.closeStream(null);
                IoUtils.closeStream(null);
                return downLoadResponse;
            }
            inputStream = httpURLConnectionOpenConn.getInputStream();
            try {
                try {
                    file = new File(context.getFilesDir(), System.currentTimeMillis() + ".apk");
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i10 = inputStream.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i10);
                            }
                            if (!downloadRequest.isNeedCheck()) {
                                downLoadResponse.setErrorCode(0);
                                downLoadResponse.setDownloadFile(file);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream2);
                                return downLoadResponse;
                            }
                            if (checkRpkValid(file, downloadRequest.getHash())) {
                                downLoadResponse.setErrorCode(0);
                                downLoadResponse.setDownloadFile(file);
                                IoUtils.closeStream(inputStream);
                                IoUtils.closeStream(fileOutputStream2);
                                return downLoadResponse;
                            }
                            deleteFile(file);
                            downLoadResponse.setErrorCode(2);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream2);
                            return downLoadResponse;
                        } catch (IOException unused) {
                            fileOutputStream = fileOutputStream2;
                            FastViewLogUtils.m28724e(TAG, "download error, error is ioexception");
                            deleteFile(file);
                            downLoadResponse.setErrorCode(3);
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                            return downLoadResponse;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            IoUtils.closeStream(inputStream);
                            IoUtils.closeStream(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException unused3) {
                file = null;
                FastViewLogUtils.m28724e(TAG, "download error, error is ioexception");
                deleteFile(file);
                downLoadResponse.setErrorCode(3);
                IoUtils.closeStream(inputStream);
                IoUtils.closeStream(fileOutputStream);
                return downLoadResponse;
            }
        } catch (IOException unused4) {
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public void resetDownload() {
        FastViewLogUtils.m28726i(TAG, "resetDownload");
        this.isDownload = true;
    }

    public void stopDownload() {
        FastViewLogUtils.m28726i(TAG, "stopDownload");
        this.isDownload = false;
    }
}
