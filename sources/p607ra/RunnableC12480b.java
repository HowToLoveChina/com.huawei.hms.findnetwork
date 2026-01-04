package p607ra;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.drive.clouddisk.expand.CloudDriveMediaDownloader;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.MediaDownloader;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import gu.C10048b;
import hk.C10278a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p015ak.C0228m0;
import p035bk.C1248a;
import p363ia.C10463a;
import p373iu.C10617e;
import p373iu.C10618f;
import p429kk.C11058a;
import p514o9.C11839m;
import p514o9.C11842p;
import p653ta.C13000a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p734wa.C13578b;
import p734wa.C13579c;
import pa.C12123a;
import qa.C12296a;
import sa.C12766a;
import ua.C13143b;
import va.C13391c;

/* renamed from: ra.b */
/* loaded from: classes3.dex */
public class RunnableC12480b implements Runnable {

    /* renamed from: a */
    public String f57458a;

    /* renamed from: b */
    public String f57459b;

    /* renamed from: c */
    public String f57460c;

    /* renamed from: d */
    public Handler f57461d;

    /* renamed from: e */
    public boolean f57462e = false;

    /* renamed from: f */
    public int f57463f;

    /* renamed from: g */
    public CloudDriveMediaDownloader f57464g;

    /* renamed from: h */
    public MediaDownloader f57465h;

    /* renamed from: i */
    public FileExpand f57466i;

    /* renamed from: j */
    public String f57467j;

    /* renamed from: k */
    public C12123a f57468k;

    /* renamed from: l */
    public FileModel f57469l;

    public RunnableC12480b(FileModel fileModel, Handler handler, int i10) {
        this.f57458a = fileModel.getFileId();
        String fileName = fileModel.getFileName();
        this.f57459b = fileName;
        this.f57469l = fileModel;
        this.f57461d = handler;
        this.f57463f = i10;
        this.f57460c = C13391c.m80474b(fileName);
        this.f57468k = new C12123a();
        this.f57467j = C11058a.m66627b("09003");
    }

    /* renamed from: a */
    public void m74930a() {
        C11839m.m70688i("BitmapTask", "onCancelTask: Cancel Task");
        this.f57462e = true;
        CloudDriveMediaDownloader cloudDriveMediaDownloader = this.f57464g;
        if (cloudDriveMediaDownloader != null) {
            cloudDriveMediaDownloader.cancel();
        }
        MediaDownloader mediaDownloader = this.f57465h;
        if (mediaDownloader != null) {
            mediaDownloader.cancel();
        }
    }

    /* renamed from: c */
    public final boolean m74931c(String str) {
        if (str == null) {
            return false;
        }
        return C10278a.m63442h(str).exists();
    }

    /* renamed from: d */
    public final void m74932d(HttpsURLConnection httpsURLConnection, InputStream inputStream) throws IOException {
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl: close inputStream failed " + e10.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m74933e(Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th2;
        IOException e10;
        StringBuilder sb2;
        Bitmap.CompressFormat compressFormat;
        if (C13391c.m80473a(this.f57460c)) {
            File file = new File(this.f57460c);
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            try {
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                th2 = th3;
            }
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        compressFormat = Bitmap.CompressFormat.PNG;
                        bitmap.compress(compressFormat, 100, fileOutputStream);
                        fileOutputStream.flush();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream2 = fileOutputStream;
                        C11839m.m70687e("BitmapTask", "creatLocalThumbnailFile fail");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e11) {
                                e = e11;
                                sb2 = new StringBuilder();
                                sb2.append("creatLocalThumbnailFile failed, ");
                                sb2.append(e.toString());
                                C11839m.m70687e("BitmapTask", sb2.toString());
                            }
                        }
                    } catch (IOException e12) {
                        e10 = e12;
                        String str = "creatLocalThumbnailFile failed, " + e10.toString();
                        C11839m.m70687e("BitmapTask", str);
                        fileOutputStream2 = str;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                fileOutputStream2 = str;
                            } catch (IOException e13) {
                                e = e13;
                                sb2 = new StringBuilder();
                                sb2.append("creatLocalThumbnailFile failed, ");
                                sb2.append(e.toString());
                                C11839m.m70687e("BitmapTask", sb2.toString());
                            }
                        }
                    }
                } catch (FileNotFoundException unused2) {
                } catch (IOException e14) {
                    fileOutputStream = null;
                    e10 = e14;
                }
                try {
                    fileOutputStream.close();
                    fileOutputStream2 = compressFormat;
                } catch (IOException e15) {
                    e = e15;
                    sb2 = new StringBuilder();
                    sb2.append("creatLocalThumbnailFile failed, ");
                    sb2.append(e.toString());
                    C11839m.m70687e("BitmapTask", sb2.toString());
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e16) {
                        C11839m.m70687e("BitmapTask", "creatLocalThumbnailFile failed, " + e16.toString());
                    }
                }
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final void m74934f() {
        C11839m.m70688i("BitmapTask", "flow error, file name is: " + this.f57459b);
        long jM76614c = C12766a.m76614c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C12766a.m76618g(jCurrentTimeMillis);
        if (jCurrentTimeMillis - jM76614c > 120000) {
            C11839m.m70686d("BitmapTask", "flow error reset pool size");
            int iM73902d = C12296a.m73898e().m73902d();
            if (iM73902d > 5) {
                C11839m.m70688i("BitmapTask", "flow error reset pool size to 5");
                C12296a.m73898e().m73906i(5);
            } else if (iM73902d > 3) {
                C11839m.m70688i("BitmapTask", "flow error reset pool size to 3");
                C12296a.m73898e().m73906i(3);
            }
            C11839m.m70686d("BitmapTask", "flow error send msg.");
            C13143b.m79047d().m79048c();
        }
    }

    /* renamed from: g */
    public final void m74935g(Exception exc) {
        C11839m.m70688i("BitmapTask", "dealNoThumbnail");
        m74948t("4044_" + System.currentTimeMillis());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ContentResource.FILE_NAME, this.f57459b);
        C13000a.m78150e(3, exc.toString(), C11058a.m66627b("09003"), "no_thumbnail", linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap m74936h(java.io.File r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r5 = "IOException"
            java.lang.String r0 = "BitmapTask"
            r1 = 0
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L35 java.lang.OutOfMemoryError -> L3a java.io.FileNotFoundException -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.OutOfMemoryError -> L3a java.io.FileNotFoundException -> L3c
            r3 = 1
            r2.inSampleSize = r3     // Catch: java.lang.Throwable -> L35 java.lang.OutOfMemoryError -> L3a java.io.FileNotFoundException -> L3c
            java.io.FileInputStream r6 = hk.C10278a.m63444j(r6)     // Catch: java.lang.Throwable -> L35 java.lang.OutOfMemoryError -> L3a java.io.FileNotFoundException -> L3c
            android.graphics.Bitmap r1 = p035bk.C1248a.m7476g(r6, r1, r2)     // Catch: java.lang.Throwable -> L33 java.lang.OutOfMemoryError -> L3e java.io.FileNotFoundException -> L61
            if (r6 == 0) goto L32
            r6.close()     // Catch: java.io.IOException -> L1b
            goto L32
        L1b:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r5 = r6.toString()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            p514o9.C11839m.m70687e(r0, r5)
        L32:
            return r1
        L33:
            r1 = move-exception
            goto L74
        L35:
            r6 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L74
        L3a:
            r6 = r1
            goto L3e
        L3c:
            r6 = r1
            goto L61
        L3e:
            java.lang.String r2 = "OutOfMemoryError"
            p514o9.C11839m.m70687e(r0, r2)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L73
            r6.close()     // Catch: java.io.IOException -> L49
            goto L73
        L49:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L4f:
            r2.append(r5)
            java.lang.String r5 = r6.toString()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            p514o9.C11839m.m70687e(r0, r5)
            goto L73
        L61:
            java.lang.String r2 = "FileNotFoundException"
            p514o9.C11839m.m70687e(r0, r2)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L73
            r6.close()     // Catch: java.io.IOException -> L6c
            goto L73
        L6c:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L4f
        L73:
            return r1
        L74:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.io.IOException -> L7a
            goto L91
        L7a:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r5 = r6.toString()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            p514o9.C11839m.m70687e(r0, r5)
        L91:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p607ra.RunnableC12480b.m74936h(java.io.File):android.graphics.Bitmap");
    }

    /* renamed from: i */
    public final void m74937i() throws Throwable {
        if (this.f57462e) {
            C11839m.m70689w("BitmapTask", "bitmap task is cancel");
            return;
        }
        FileExpand fileExpand = this.f57466i;
        if (fileExpand == null) {
            C11839m.m70689w("BitmapTask", "fileContent is null");
            return;
        }
        try {
            m74943o(fileExpand);
            m74948t(this.f57460c);
            m74946r();
        } catch (C9721b e10) {
            C11839m.m70687e("BitmapTask", "downloadFail run CException: " + e10.toString());
            if ("4291".equals(e10.m60660d())) {
                m74934f();
            } else if (C12766a.m76615d(404, "4044", e10)) {
                m74935g(e10);
            }
        } catch (Exception e11) {
            C11839m.m70687e("BitmapTask", "downloadFail exception: " + e11.toString());
        }
    }

    /* renamed from: j */
    public final void m74938j() {
        String strM72698n = this.f57468k.m72698n(this.f57463f, this.f57458a);
        if (!m74931c(strM72698n)) {
            m74948t(this.f57460c);
            return;
        }
        C11839m.m70688i("BitmapTask", "smallThumbnail exist, return");
        if (TextUtils.isEmpty(this.f57460c)) {
            return;
        }
        File fileM63442h = C10278a.m63442h(this.f57460c);
        if (fileM63442h.exists()) {
            fileM63442h.delete();
        }
        this.f57460c = strM72698n;
    }

    /* renamed from: k */
    public Bitmap m74939k(String str) throws Throwable {
        byte[] bArrM74945q = m74945q(str);
        if (bArrM74945q.length == 0) {
            return null;
        }
        return C1248a.m7470a(bArrM74945q, 0, bArrM74945q.length);
    }

    /* renamed from: l */
    public final Bitmap m74940l(String str) {
        File fileM63442h = C10278a.m63442h(str);
        return (!fileM63442h.exists() || (fileM63442h.length() <= 1048576 && fileM63442h.length() != 0)) ? m74936h(fileM63442h) : C0224k0.m1548c(str, 3);
    }

    /* renamed from: m */
    public final String m74941m(HttpsURLConnection httpsURLConnection) throws IOException {
        InputStream errorStream = httpsURLConnection.getErrorStream();
        try {
            if (errorStream == null) {
                return "";
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = errorStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), Constants.UTF_8);
                try {
                    errorStream.close();
                } catch (IOException e10) {
                    C11839m.m70687e("BitmapTask", "isFlowError close errorStream failed: " + e10.toString());
                }
                return str;
            } catch (Exception e11) {
                C11839m.m70687e("BitmapTask", "isFlowError Exception: " + e11.toString());
                try {
                    errorStream.close();
                } catch (IOException e12) {
                    C11839m.m70687e("BitmapTask", "isFlowError close errorStream failed: " + e12.toString());
                }
                return "";
            }
        } catch (Throwable th2) {
            try {
                errorStream.close();
            } catch (IOException e13) {
                C11839m.m70687e("BitmapTask", "isFlowError close errorStream failed: " + e13.toString());
            }
            throw th2;
        }
    }

    /* renamed from: n */
    public final void m74942n(DriveExpand driveExpand, FileExpand fileExpand) throws C9721b {
        fileExpand.setId(this.f57458a);
        DriveExpand.FilesExpand.DownloadProcess downloadProcess = driveExpand.filesExpand().downloadProcess(fileExpand, "small", this.f57467j, null);
        this.f57465h = downloadProcess.getMediaDownloader();
        if (this.f57462e) {
            throw new CancellationException("user cancel");
        }
        downloadProcess.executeContentAndDownloadTo(new C4602e("", C10278a.m63442h(this.f57460c)), false, false);
    }

    /* renamed from: o */
    public final void m74943o(FileExpand fileExpand) throws Throwable {
        String smallThumbnailDownloadLink = fileExpand.getSmallThumbnailDownloadLink();
        if (smallThumbnailDownloadLink == null) {
            throw new C9721b(4316, "download url is null");
        }
        Bitmap bitmapM74939k = m74939k(smallThumbnailDownloadLink);
        if (bitmapM74939k == null) {
            throw new C9721b(4001, "decode bitmap is null");
        }
        m74933e(bitmapM74939k);
    }

    /* renamed from: p */
    public String m74944p(int i10) {
        return this.f57458a + "small" + i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: q */
    public final byte[] m74945q(String str) throws Throwable {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    try {
                        httpsURLConnection2.setSSLSocketFactory(C10618f.m65076c(C0213f.m1377a(), C10048b.m62471c()));
                        httpsURLConnection2.setHostnameVerifier(C10617e.f51042j);
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection = httpsURLConnection2;
                        inputStream = null;
                        m74932d(httpsURLConnection, inputStream);
                        throw th;
                    }
                } catch (Exception e10) {
                    try {
                        C11839m.m70688i("BitmapTask", "getThumbnailDataFromUrl SSLSocketFactory error:" + e10.getMessage());
                    } catch (C9721b e11) {
                        e = e11;
                        C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl cexception code = " + e.m60659c() + ", msg = " + e.getMessage());
                        throw e;
                    } catch (MalformedURLException e12) {
                        e = e12;
                        C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl MalformedURLException: " + e.toString());
                        throw new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, NotifyErr.NOTIFY_MALFORMEDURL, e.toString());
                    } catch (IOException e13) {
                        e = e13;
                        C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl IOException: " + e.toString());
                        throw new C9721b(3208, 3208, e.toString());
                    } catch (C13194k e14) {
                        e = e14;
                        C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl HmsException: " + e.toString());
                        throw new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, e.m79269b(), e.toString());
                    } catch (C13199p e15) {
                        e = e15;
                        C11839m.m70687e("BitmapTask", "getThumbnailDataFromUrl HmsSTInvalidException stInvalid begin: " + e.toString());
                        throw new C9721b(3100, e.m79390b(), e.toString());
                    }
                }
                httpsURLConnection2.setConnectTimeout(5000);
                httpsURLConnection2.setRequestMethod("GET");
                httpsURLConnection2.setRequestProperty("version", "5.2.0.100");
                httpsURLConnection2.setRequestProperty("x-hw-app-version", C1443a.f6213a);
                httpsURLConnection2.addRequestProperty(FeedbackWebConstants.AUTHORIZATION, "Bearer " + C13195l.m79272J().m79290C("com.huawei.hidisk.foldersync", "Bitmap", ""));
                httpsURLConnection2.addRequestProperty("content-type", FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
                httpsURLConnection2.addRequestProperty(C5966j2.f27080v, "identity");
                httpsURLConnection2.addRequestProperty("x-hw-trace-id", this.f57467j);
                httpsURLConnection2.addRequestProperty("x-hw-device-id", C13452e.m80781L().m80954p());
                httpsURLConnection2.addRequestProperty("x-hw-device-type", C13452e.m80781L().m80970t());
                httpsURLConnection2.addRequestProperty("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
                httpsURLConnection2.addRequestProperty("x-hw-os-brand", C0209d.m1276l0());
                C11839m.m70688i("BitmapTask", "x-hw-os-brand: " + C0209d.m1276l0());
                httpsURLConnection2.addRequestProperty("x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
                httpsURLConnection2.connect();
                C11839m.m70686d("BitmapTask", "download bitmap x-hw-trace-id = " + this.f57467j);
                C11839m.m70686d("BitmapTask", "download bitmap request body: " + httpsURLConnection2.toString());
                int responseCode = httpsURLConnection2.getResponseCode();
                C11839m.m70686d("BitmapTask", "responseCode: " + responseCode + ", responseMessage: " + httpsURLConnection2.getResponseMessage());
                if (responseCode / 100 != 2) {
                    String strM74941m = m74941m(httpsURLConnection2);
                    if (responseCode == 429 && m74947s(strM74941m)) {
                        throw new C9721b(3207, responseCode, strM74941m, "downloadThumbnail", "4291");
                    }
                    throw new C9721b(3207, responseCode, strM74941m);
                }
                InputStream inputStream2 = httpsURLConnection2.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = inputStream2.read(bArr);
                    if (i10 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        m74932d(httpsURLConnection2, inputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (C9721b e16) {
                e = e16;
            } catch (MalformedURLException e17) {
                e = e17;
            } catch (IOException e18) {
                e = e18;
            } catch (C13194k e19) {
                e = e19;
            } catch (C13199p e20) {
                e = e20;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = str;
        }
    }

    /* renamed from: r */
    public final void m74946r() {
        if (this.f57458a == null) {
            return;
        }
        Bitmap bitmapM74940l = m74940l(this.f57460c);
        C13579c c13579c = new C13579c(bitmapM74940l);
        if (bitmapM74940l == null || bitmapM74940l.isRecycled()) {
            return;
        }
        C13578b.m81574f().m81575a(c13579c, this.f57458a);
        Handler handler = this.f57461d;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.obj = c13579c;
            this.f57461d.sendMessage(messageObtainMessage);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        C11839m.m70686d("BitmapTask", "bitmap task run, thread name: " + Thread.currentThread().getName() + ", file name is: " + this.f57459b);
        String strM72698n = this.f57468k.m72698n(this.f57463f, this.f57458a);
        if (m74931c(strM72698n)) {
            C11839m.m70688i("BitmapTask", "smallThumbnail exist, return");
            this.f57460c = strM72698n;
            this.f57469l.setThumbnailPath(strM72698n);
            m74946r();
            return;
        }
        try {
            DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
            if (driveExpandM64282d == null) {
                C11839m.m70687e("BitmapTask", "DriveExpand is NULL.");
                return;
            }
            this.f57464g = new CloudDriveMediaDownloader(this.f57467j, "small", driveExpandM64282d);
            if (C10028c.m62182c0().m62329g0()) {
                this.f57466i = this.f57464g.initAsset(this.f57458a, true, false);
                if (this.f57464g.isSupportV2()) {
                    this.f57464g.download(C10278a.m63442h(this.f57460c), this.f57458a, false);
                } else {
                    m74943o(this.f57466i);
                }
            } else {
                FileExpand fileExpand = (FileExpand) new SyncDriveRequest(driveExpandM64282d.filesExpand().getDownloadAddress(this.f57458a)).execute();
                this.f57466i = fileExpand;
                if (fileExpand.getObjectInfoList() == null) {
                    m74943o(this.f57466i);
                } else {
                    m74942n(driveExpandM64282d, this.f57466i);
                }
            }
            m74938j();
            this.f57469l.setThumbnailPath(this.f57460c);
            m74946r();
            C11839m.m70686d("BitmapTask", "bitmap task run, handleSuccess file name: " + this.f57460c);
        } catch (C9721b e10) {
            C11839m.m70687e("BitmapTask", "BitmapTask run CException: " + e10.toString());
            if ("4291".equals(e10.m60660d())) {
                m74934f();
            }
            if (e10.m60659c() == 4310 || e10.m60659c() == 4316) {
                m74935g(e10);
            }
            m74937i();
        } catch (Exception e11) {
            C11839m.m70687e("BitmapTask", "BitmapTask run Exception: " + e11.toString());
            if (C12766a.m76616e(404, "4041", e11)) {
                m74935g(e11);
            }
            m74937i();
        }
    }

    /* renamed from: s */
    public final boolean m74947s(String str) throws JSONException {
        JSONArray jSONArray;
        try {
        } catch (Exception e10) {
            C11839m.m70687e("BitmapTask", "isFlowError Exception: " + e10.toString());
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getJSONObject(VastAttribute.ERROR) != null && (jSONArray = jSONObject.getJSONObject(VastAttribute.ERROR).getJSONArray("errorDetail")) != null && jSONArray.length() > 0) {
            String string = ((JSONObject) jSONArray.get(0)).getString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            if (string.length() > 4) {
                string = string.substring(string.length() - 4);
            }
            C11839m.m70688i("BitmapTask", "isFlowError errorCode: " + string);
            if ("4291".equals(string)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: t */
    public final void m74948t(String str) {
        try {
            m74949u(this.f57458a, str, this.f57463f);
        } catch (Exception e10) {
            C11839m.m70687e("BitmapTask", "updateThumbnailPath error: " + e10.toString());
        }
    }

    /* renamed from: u */
    public void m74949u(String str, String str2, int i10) throws Exception {
        if (str == null || str2 == null) {
            C11839m.m70689w("BitmapTask", "updateThumbnailPath thunbnailPath or fileId is null");
            return;
        }
        String[] strArr = {str2, str};
        if (i10 == 1) {
            this.f57468k.m72694j("UPDATE diskDuplicateFile SET thumbnailPath = ? WHERE fileId = ?", strArr);
        } else {
            this.f57468k.m72694j("UPDATE diskBigFile SET thumbnailPath = ? WHERE fileId = ?", strArr);
        }
    }
}
