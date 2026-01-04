package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.connect.progress.ICloudAlbumCallback;
import com.huawei.android.p069cg.p072vo.FileInfo;
import p009a8.C0070h;
import p031b7.C1120a;
import p281f8.C9674k;

/* loaded from: classes2.dex */
public class CloudPhotoUploadProgress implements ICloudAlbumCallback {
    private static final String TAG = "CloudPhotoUploadProgress";
    private CallbackHandler callbackHandler;
    private Context context;
    private FileInfo fileInfo;
    private String stopReason;
    private BaseUploadCallable uploadCallable;

    public CloudPhotoUploadProgress(Context context, BaseUploadCallable baseUploadCallable, FileInfo fileInfo, CallbackHandler callbackHandler) {
        this.context = context;
        this.uploadCallable = baseUploadCallable;
        this.fileInfo = fileInfo;
        this.callbackHandler = callbackHandler;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:141:0x00cd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public com.huawei.hicloud.request.upload.GetUploadUrlPlv3Response onGetUploadUrlPlv3(java.lang.String r19, java.util.HashMap<java.lang.String, java.lang.String> r20, java.util.HashMap<java.lang.String, java.lang.String> r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.request.callable.CloudPhotoUploadProgress.onGetUploadUrlPlv3(java.lang.String, java.util.HashMap, java.util.HashMap, java.lang.String, java.lang.String, java.lang.String):com.huawei.hicloud.request.upload.GetUploadUrlPlv3Response");
    }

    public boolean onPause() {
        return false;
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public void onProgress(long j10, long j11) {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null && TextUtils.isEmpty(fileInfo.getShareId())) {
            C0070h.m527v().m556c0(j10, this.fileInfo.getAlbumId() + "_" + this.fileInfo.getFileName() + "_" + this.fileInfo.getHash());
            C0070h.m527v().m563h();
        }
        FileInfo fileInfo2 = this.fileInfo;
        C1120a.m6675d(TAG, (fileInfo2 == null ? "" : fileInfo2.getFileName()) + " total:" + j11 + ",value:" + j10);
        C1120a.m6675d(TAG, "upload update BusinessExecuteTime");
        SyncSessionManager.m15153t().m15164K(1);
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public boolean onStop() {
        C9674k syncStrategy = this.uploadCallable.callbackHandler.getSyncStrategy();
        if (syncStrategy == null) {
            C1120a.m6678w(TAG, "onStop syncStrategy is null");
            return false;
        }
        if (syncStrategy.m60421k(false, 3) != C9674k.c.CAN_START_SYNC) {
            this.stopReason = syncStrategy.m60416f(syncStrategy.m60414d());
            return true;
        }
        if (!this.uploadCallable.isCancel()) {
            return false;
        }
        this.stopReason = "upload canceled";
        return true;
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICloudAlbumCallback
    public String onStopCancelCode() {
        return "001_" + this.uploadCallable.getCancelCode();
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICloudAlbumCallback
    public String onStopReason() {
        return this.stopReason;
    }
}
