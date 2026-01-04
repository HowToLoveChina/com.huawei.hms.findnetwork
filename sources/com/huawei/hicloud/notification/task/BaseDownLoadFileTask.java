package com.huawei.hicloud.notification.task;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import java.io.File;
import p015ak.C0227m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class BaseDownLoadFileTask extends AbstractC12367d {
    public static final int MSG_FAIL = 2;
    public static final int MSG_SUCCESS = 1;
    private static final String TAG = "BaseDownLoadFileTask";
    private static final String TEMP_PATH_SUFFIX = "_tmp";
    protected String mDestPath;
    protected String mFileSha256Str;
    protected Handler mHandler;
    protected String mUrl;

    public BaseDownLoadFileTask(String str, String str2, String str3, Handler handler) {
        this.mUrl = str;
        this.mDestPath = str2;
        this.mFileSha256Str = str3;
        this.mHandler = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        if (TextUtils.isEmpty(this.mUrl)) {
            NotifyLogger.m29914e(TAG, "download url is null, return");
            return;
        }
        if (TextUtils.isEmpty(this.mDestPath)) {
            NotifyLogger.m29914e(TAG, "dest path is null, download url.");
            return;
        }
        if (!forceDownload() && diskCacheExist(this.mDestPath, this.mFileSha256Str)) {
            NotifyLogger.m29913d(TAG, "load file from disk, destPath:" + this.mDestPath);
            sendDownloadFileSuccess();
            return;
        }
        NotifyLogger.m29913d(TAG, "download start, destPath:" + this.mDestPath);
        String str = this.mDestPath + TEMP_PATH_SUFFIX;
        C4896a c4896a = new C4896a(this.mUrl, str, 0L);
        NotifyUtil.downloadFileToPathSilent(str, c4896a.getUrl(), c4896a);
        File file = new File(str);
        if (!file.exists()) {
            NotifyLogger.m29914e(TAG, "download file to local temp failed. destPath = " + this.mDestPath);
            sendDownloadFileFail();
            return;
        }
        if (!TextUtils.isEmpty(this.mFileSha256Str)) {
            try {
                if (!this.mFileSha256Str.equals(C0227m.m1591d(str))) {
                    NotifyLogger.m29914e(TAG, "hash not equal, delete tmp file, destPath:" + this.mDestPath);
                    if (!file.delete()) {
                        NotifyLogger.m29914e(TAG, "hash not equal, delete tmp file failed, destPath:" + this.mDestPath);
                    }
                    sendDownloadFileFail();
                    return;
                }
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "get file hash exception, destPath:" + this.mDestPath + ", exception: " + e10.toString());
                sendDownloadFileFail();
                return;
            }
        }
        File file2 = new File(this.mDestPath);
        if (file2.exists()) {
            NotifyLogger.m29913d(TAG, "destFile exist, delete it, destPath:" + this.mDestPath);
            if (!file2.delete()) {
                NotifyLogger.m29914e(TAG, "destFile delete failed, destPath:" + this.mDestPath);
            }
        }
        if (file.renameTo(file2)) {
            sendDownloadFileSuccess();
            NotifyLogger.m29913d(TAG, "download success, destPath:" + this.mDestPath);
            return;
        }
        NotifyLogger.m29914e(TAG, "rename file failed, destPath:" + this.mDestPath);
        sendDownloadFileFail();
    }

    public boolean diskCacheExist(String str, String str2) throws Throwable {
        String strM1591d;
        if (!new File(str).exists()) {
            return false;
        }
        try {
            strM1591d = C0227m.m1591d(str);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "get fileHash exception: " + e10.toString());
            strM1591d = null;
        }
        return (strM1591d == null || TextUtils.isEmpty(strM1591d) || !strM1591d.equals(str2)) ? false : true;
    }

    public boolean forceDownload() {
        return false;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.PPS_ICON_DOWNLOAD;
    }

    public void sendDownloadFileFail() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    public void sendDownloadFileSuccess() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(1).sendToTarget();
        }
    }
}
