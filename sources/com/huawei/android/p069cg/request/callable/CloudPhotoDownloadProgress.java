package com.huawei.android.p069cg.request.callable;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadProgress;
import com.huawei.android.p069cg.p072vo.FileInfo;
import p031b7.C1120a;
import p031b7.C1122c;

/* loaded from: classes2.dex */
public class CloudPhotoDownloadProgress {
    private static final String TAG = "CloudPhotoDownloadProgress";
    private CallbackHandler callbackHandler;
    private FileInfo fileInfo;
    private int thumbType;
    private long tempSize = 0;
    private long startDownloadTime = 0;

    public CloudPhotoDownloadProgress(int i10, FileInfo fileInfo) {
        this.thumbType = i10;
        this.fileInfo = fileInfo;
    }

    private void sendSdkProgress(long j10, long j11) {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.startDownloadTime < 500) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("download total: ");
        sb2.append(j11);
        sb2.append(", current: ");
        sb2.append(j10);
        sb2.append(",tempSize: ");
        sb2.append(this.tempSize);
        if (this.fileInfo != null) {
            str = " ;fileName is:" + C1122c.m6818p0(this.fileInfo.getFileName());
        } else {
            str = "fileInfo is null";
        }
        sb2.append(str);
        C1120a.m6675d(TAG, sb2.toString());
        long j12 = this.tempSize;
        if (j12 > j10) {
            j10 = j12;
        } else {
            this.tempSize = j10;
        }
        if (this.fileInfo == null) {
            C1120a.m6676e(TAG, "fileInfo is null");
            return;
        }
        SyncSessionManager.m15153t().m15164K(2);
        Bundle bundle = new Bundle();
        FileDownloadProgress fileDownloadProgress = new FileDownloadProgress();
        fileDownloadProgress.setUniqueId(this.fileInfo.getUniqueId());
        fileDownloadProgress.setFileId(this.fileInfo.getFileId());
        fileDownloadProgress.setFileSizeByte(j11);
        fileDownloadProgress.setFileLoadSizeByte(j10);
        fileDownloadProgress.setResolutionType(this.thumbType);
        fileDownloadProgress.setLocalRealPath(this.fileInfo.getLocalRealPath());
        this.fileInfo.setSizeProgress(j10);
        bundle.putParcelable("FileLoadProgress", fileDownloadProgress);
        if (this.callbackHandler != null) {
            if (TextUtils.isEmpty(this.fileInfo.getShareId())) {
                this.callbackHandler.sendMessage(9042, bundle);
            } else {
                this.callbackHandler.sendMessage(9052, bundle);
            }
        }
        this.startDownloadTime = jCurrentTimeMillis;
    }

    public CallbackHandler getCallbackHandler() {
        return this.callbackHandler;
    }

    public void onProgress(long j10, long j11) {
        sendSdkProgress(j10, j11);
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
}
