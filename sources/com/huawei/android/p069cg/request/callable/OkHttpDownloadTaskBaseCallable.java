package com.huawei.android.p069cg.request.callable;

import android.media.MediaScannerConnection;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import javax.net.ssl.SSLException;
import okhttp3.C11912b0;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11919f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p511o6.C11821c;
import p511o6.C11822d;

/* loaded from: classes2.dex */
public abstract class OkHttpDownloadTaskBaseCallable extends DownloadTaskBaseCallable {
    protected static final int BUFFER_SIZE_DOWNLOAD_WRITE = 8192;
    protected static final int OPER_TYPE_DELETE = 2;
    private static final String TAG = "OkHttpDownloadTaskBaseCallable";
    protected long breakPointSize;
    protected InterfaceC11919f callCloneable;
    protected long fileSize;
    protected boolean isPriority;
    protected boolean isShare;
    protected C11912b0 mOkHttpClient;

    public OkHttpDownloadTaskBaseCallable(Object obj, int i10) {
        super(obj, i10);
        this.callCloneable = null;
        this.mOkHttpClient = null;
        this.fileSize = 0L;
        this.breakPointSize = 0L;
        this.isShare = false;
        this.isPriority = false;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public boolean cancel() {
        boolean zCancel = super.cancel();
        new Thread(new Runnable() { // from class: com.huawei.android.cg.request.callable.OkHttpDownloadTaskBaseCallable.1
            @Override // java.lang.Runnable
            public void run() {
                OkHttpDownloadTaskBaseCallable.this.closeConnect();
            }
        }).start();
        this.isCancel = true;
        return zCancel;
    }

    public String checkDownloadPath() {
        String str = this.savePath;
        if (str == null) {
            return "1";
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && fileM63442h.isFile()) {
            return "0";
        }
        long jM6698G0 = C1122c.m6698G0(C1124e.m6871o(this.context));
        if (!isSpaceTooLow(((DownloadTaskBaseCallable) this).thumbType, jM6698G0)) {
            return null;
        }
        C11822d.m70439c(this.context, ((DownloadTaskBaseCallable) this).thumbType, 126);
        try {
            C11822d.m70437a();
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "cancelAll exception: " + e10.toString());
        }
        C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
        this.conditionInfo = "LocalSpaceTooLow, availSize:" + jM6698G0;
        this.conditionCode = "3014";
        return "10";
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void closeConnect() {
        InterfaceC11919f interfaceC11919f = this.callCloneable;
        if (interfaceC11919f != null) {
            interfaceC11919f.cancel();
        }
    }

    public String downloadCondition() {
        if (DownloadPhotoBase.m14407b(this.fileInfoKey) != null) {
            if (C11821c.m70428r(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, true)) {
                this.res.put("DownloadFailReason", 149);
                this.conditionInfo = "TaskExecing";
                this.conditionCode = "3012";
                return "10";
            }
            if (C11821c.m70409C(this.fileInfoKey, this.isPriority)) {
                this.res.put("DownloadFailReason", 149);
                this.conditionInfo = "TaskInCalls";
                this.conditionCode = "3013";
                return "12";
            }
        }
        return checkDownloadPath();
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public String downloadFinishRename(String str) {
        if (C10278a.m63442h(this.savePath).exists()) {
            C1122c.m6694F(this.savePath);
        }
        C1120a.m6675d(TAG, "downloadCachePath: " + str);
        C1122c.m6735S1(str, this.savePath);
        if (!C10278a.m63442h(this.savePath).exists()) {
            return "1";
        }
        if (((DownloadTaskBaseCallable) this).thumbType != 0) {
            return "0";
        }
        MediaScannerConnection.scanFile(this.context, new String[]{this.savePath}, null, null);
        return "0";
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public long getDownloadFinishSize(long j10) {
        File fileM63442h = C10278a.m63442h(this.tempFilePath);
        if (!fileM63442h.exists()) {
            return 0L;
        }
        long length = fileM63442h.length();
        if (j10 != -1 && fileM63442h.length() != j10) {
            C1120a.m6676e(TAG, "download file error:size not equal!file name:" + fileM63442h.getName() + ";download total file size is:" + j10 + ";download real file size is:" + fileM63442h.length());
        }
        return length;
    }

    public String getErrorMessage(HttpResponseBuilder HttpResponseBuilder) {
        if (HttpResponseBuilder == null) {
            return "";
        }
        String strM71602z = HttpResponseBuilder.m71602z();
        try {
            return HttpResponseBuilder.m71595s() != null ? HttpResponseBuilder.m71595s().m71637z() : strM71602z;
        } catch (IOException e10) {
            C1120a.m6676e(TAG, "getErrorMessage: " + e10.getMessage());
            return strM71602z;
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public boolean getNeedAT() {
        return false;
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleAuthFailed() {
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleCloseExecuting() throws Exception {
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleDownloadWrite(InputStream inputStream, OutputStream outputStream) throws IOException {
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleProgressWhileExecuting(FileInfo fileInfo, long j10, String str, int i10, boolean z10) throws Exception {
    }

    public boolean isSpaceTooLow(int i10, long j10) {
        return C1122c.m6852z1(i10, j10);
    }

    public int processReportCode(Exception exc) {
        try {
            return Integer.parseInt(exc instanceof SocketTimeoutException ? "1006" : exc instanceof NoRouteToHostException ? FaqConstants.CHANNEL_HICARE : exc instanceof UnknownHostException ? "1003" : exc instanceof MalformedURLException ? "1002" : exc instanceof ConnectException ? "1001" : exc instanceof SocketException ? "1008" : exc instanceof SSLException ? "1009" : exc instanceof ProtocolException ? "1005" : exc instanceof InterruptedIOException ? "1011" : "1000");
        } catch (NumberFormatException unused) {
            C1120a.m6676e(TAG, "String trans to Integer error");
            return 2000;
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void reportOperationData(HashMap<String, String> map, long j10, int i10, String str, FileInfo fileInfo, String str2) {
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void updateRestoreSuccessFile(FileInfo fileInfo) {
    }
}
