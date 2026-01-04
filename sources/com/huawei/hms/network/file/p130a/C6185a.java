package com.huawei.hms.network.file.p130a;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6231b;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.util.C6252b;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.file.a.a */
/* loaded from: classes8.dex */
public class C6185a implements InterfaceC6231b<GetRequest, C6188d> {

    /* renamed from: d */
    private C6188d f29259d;

    /* renamed from: e */
    private HttpClient f29260e;

    /* renamed from: f */
    Submit<ResponseBody> f29261f;

    /* renamed from: k */
    private GlobalRequestConfig f29266k;

    /* renamed from: l */
    C6193i f29267l;

    /* renamed from: a */
    private String f29256a = "";

    /* renamed from: b */
    private String f29257b = "";

    /* renamed from: c */
    String f29258c = "";

    /* renamed from: g */
    long f29262g = 0;

    /* renamed from: h */
    private int f29263h = 0;

    /* renamed from: i */
    private int f29264i = 0;

    /* renamed from: j */
    private InterfaceC6235f f29265j = null;

    public C6185a(GlobalRequestConfig globalRequestConfig, HttpClient httpClient) {
        this.f29260e = httpClient;
        this.f29266k = globalRequestConfig;
    }

    /* renamed from: b */
    private StringBuilder m35972b(String str, Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (str.indexOf(38) > 0 || str.indexOf(63) > 0) {
            sb2.append("&");
        } else {
            sb2.append(Constants.QUESTION_STR);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strEncode = URLEncoder.encode(entry.getValue(), Constants.UTF_8);
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(strEncode);
            sb2.append("&");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2;
    }

    /* renamed from: a */
    private int m35962a(int i10) {
        C6193i c6193i = this.f29267l;
        return c6193i != null ? c6193i.m36058a(i10) : i10;
    }

    /* renamed from: b */
    private boolean m35973b(IOException iOException) {
        return C6252b.m36360a((Throwable) iOException) && this.f29264i <= this.f29263h;
    }

    /* renamed from: a */
    private int m35963a(RandomAccessFile randomAccessFile, byte[] bArr, int i10) throws IOException {
        randomAccessFile.write(bArr, 0, i10);
        C6188d c6188d = this.f29259d;
        long j10 = i10;
        c6188d.m36322a(c6188d.mo36239c() + j10);
        this.f29262g += j10;
        m35968a();
        return 0;
    }

    /* renamed from: a */
    private Response<ResponseBody> m35965a(String str, long j10, long j11, C6188d c6188d) throws Throwable {
        Request.Builder builderNewRequest = this.f29260e.newRequest();
        builderNewRequest.options(Utils.convertToJsonString(this.f29266k));
        builderNewRequest.url(str);
        if (c6188d.m36021C()) {
            FLogger.m36353i("DownloadImpl", "getDownloadResult needAddRangHeader for start:" + j10 + ",end:" + j11, new Object[0]);
            String str2 = (j10 < 0 || j11 < j10) ? "" : "bytes=" + j10 + "-" + j11;
            if (j11 == -1 && j10 > 0) {
                str2 = "bytes=" + j10 + "-";
            }
            if (!Utils.isBlank(str2)) {
                FLogger.m36353i("DownloadImpl", "getDownloadResult add range for slice", new Object[0]);
                builderNewRequest.addHeader("Range", str2);
            }
        }
        Map<String, String> headers = c6188d.m36341p().getHeaders();
        if (!headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builderNewRequest.addHeader(entry.getKey(), entry.getValue());
            }
        }
        HashMap map = new HashMap();
        if (!c6188d.m36341p().getReportInfos().isEmpty()) {
            map.putAll(c6188d.m36341p().getReportInfos());
        }
        if (!map.containsKey("trace_id")) {
            map.put("trace_id", String.valueOf(c6188d.m36341p().getId()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (map.containsKey("trace_id")) {
                jSONObject.put("trace_id", map.get("trace_id"));
            }
            if (map.containsKey(C6148x2.DEVICE_ID)) {
                jSONObject.put(C6148x2.DEVICE_ID, map.get(C6148x2.DEVICE_ID));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("metrics_data", jSONObject);
            builderNewRequest.options(jSONObject2.toString());
        } catch (JSONException unused) {
            FLogger.m36351e("DownloadImpl", "getDownloadResult requestBuilder.options exception");
        }
        this.f29261f = this.f29260e.newSubmit(builderNewRequest.build());
        if (c6188d.mo36243h()) {
            this.f29261f.cancel();
        }
        c6188d.m36326a(this.f29261f);
        final Throwable[] thArr = new Throwable[1];
        Future futureSubmit = ExecutorsUtils.newSingleThreadExecutor("DownloadImpl").submit(new Callable() { // from class: com.huawei.hms.network.file.a.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f29300a.m35966a(thArr);
            }
        });
        Response<ResponseBody> response = (futureSubmit.isCancelled() || c6188d.mo36243h()) ? null : (Response) futureSubmit.get(2L, TimeUnit.MINUTES);
        Throwable th2 = thArr[0];
        if (th2 == null) {
            return response;
        }
        throw th2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Response m35966a(Throwable[] thArr) {
        try {
            return this.f29261f.execute();
        } catch (IOException e10) {
            FLogger.m36351e("DownloadImpl", "execute ioexception");
            thArr[0] = e10;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x027e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0242 A[Catch: all -> 0x01c2, FileManagerException -> 0x01c9, IOException -> 0x01d0, TryCatch #21 {FileManagerException -> 0x01c9, IOException -> 0x01d0, all -> 0x01c2, blocks: (B:17:0x00ef, B:19:0x0133, B:23:0x0178, B:25:0x0182, B:27:0x018a, B:29:0x0194, B:31:0x019e, B:33:0x01bc, B:49:0x023a, B:51:0x0242, B:53:0x024e, B:54:0x025b, B:40:0x01d6, B:41:0x01d8, B:48:0x0237, B:42:0x01dd, B:43:0x0202, B:47:0x0212, B:111:0x0377, B:112:0x0383), top: B:169:0x00ef }] */
    @Override // com.huawei.hms.network.file.core.task.InterfaceC6231b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.Closeable mo35975a(com.huawei.hms.network.file.p130a.C6188d r23, com.huawei.hms.network.file.core.task.InterfaceC6235f r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1051
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.p130a.C6185a.mo35975a(com.huawei.hms.network.file.a.d, com.huawei.hms.network.file.core.task.f):java.io.Closeable");
    }

    /* renamed from: a */
    private String m35967a(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                return m35972b(str, map).toString();
            } catch (UnsupportedEncodingException e10) {
                FLogger.m36352e("DownloadImpl", "createUrlWithParams errorr:", e10);
            }
        }
        return str;
    }

    /* renamed from: a */
    private void m35968a() {
        this.f29265j.mo36245a((InterfaceC6235f) this.f29259d);
    }

    /* renamed from: a */
    private void m35969a(int i10, long j10, long j11) {
        String str = "[responseCode=" + i10 + ", hostStr=" + this.f29257b + "]";
        if (i10 == -1) {
            throw new FileManagerException(Constants.ErrorCode.SERVER_EXCEPTION, str + " download failed,response null, hostStr=" + this.f29257b);
        }
        if (i10 != 416) {
            if (i10 != 200 && i10 != 206 && i10 != 304) {
                throw new FileManagerException(i10, str);
            }
            return;
        }
        String str2 = str + " package= " + this.f29259d.mo36241f() + ", storeSize=" + this.f29259d.mo36022a() + ", rangeStart=" + j10 + ", rangeEnd=" + j11;
        FLogger.m36355w("DownloadImpl", "httpErrorcode:" + i10, new Object[0]);
        throw new FileManagerException(i10, str2);
    }

    /* renamed from: a */
    public void m35976a(Submit<ResponseBody> submit, AbstractC6240k<GetRequest> abstractC6240k) {
        if (submit != null) {
            try {
                if (submit.getRequestFinishedInfo() != null) {
                    abstractC6240k.m36328b(submit.getRequestFinishedInfo());
                }
            } catch (RuntimeException e10) {
                FLogger.m36355w("DownloadImpl", "collectFinishedInfo RuntimeException", e10);
            } catch (Exception e11) {
                FLogger.m36355w("DownloadImpl", "collectFinishedInfo exception", e11);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m35970a(java.io.BufferedInputStream r24, java.io.RandomAccessFile r25, java.lang.String r26, long r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.p130a.C6185a.m35970a(java.io.BufferedInputStream, java.io.RandomAccessFile, java.lang.String, long):void");
    }

    /* renamed from: a */
    private void m35971a(IOException iOException) {
        String message = !Utils.isBlank(iOException.getMessage()) ? iOException.getMessage() : "IO exception";
        this.f29264i++;
        int iM36358a = C6252b.m36358a(iOException);
        if (m35973b(iOException)) {
            return;
        }
        FLogger.m36351e("DownloadImpl", "doWithIOException failed, retrycount=" + this.f29264i + ", code=" + iM36358a);
        throw new FileManagerException(iM36358a, message, iOException);
    }

    /* renamed from: a */
    public boolean m35977a(String str) {
        File file = new File(str);
        if (file.exists() || file.getParentFile() == null) {
            return false;
        }
        return file.getParentFile().mkdirs();
    }
}
