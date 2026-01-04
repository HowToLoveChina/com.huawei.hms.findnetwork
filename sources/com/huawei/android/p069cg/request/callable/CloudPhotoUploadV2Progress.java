package com.huawei.android.p069cg.request.callable;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.p069cg.p072vo.FileInfo;
import hk.C10278a;
import p009a8.C0068f;
import p009a8.C0070h;
import p031b7.C1120a;
import p031b7.C1122c;
import p281f8.C9674k;
import p804ya.C13928e;

/* loaded from: classes2.dex */
public class CloudPhotoUploadV2Progress implements CloudPhotoMediaUploaderProgressListener {
    private static final String TAG = "CloudPhotoUploadV2Progress";
    private FileInfo fileInfo;
    private BaseUploadCallable uploadCallable;

    public CloudPhotoUploadV2Progress(BaseUploadCallable baseUploadCallable, FileInfo fileInfo) {
        this.uploadCallable = baseUploadCallable;
        this.fileInfo = fileInfo;
    }

    @Override // com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener
    public void progressChanged(C13928e c13928e) {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null && TextUtils.isEmpty(fileInfo.getShareId())) {
            C0070h.m527v().m556c0(c13928e.m83635w(), this.fileInfo.getAlbumId() + "_" + this.fileInfo.getFileName() + "_" + this.fileInfo.getHash());
            C0070h.m527v().m563h();
        }
        FileInfo fileInfo2 = this.fileInfo;
        C1120a.m6675d(TAG, C1122c.m6818p0(fileInfo2 == null ? "" : fileInfo2.getFileName()) + " progress:" + c13928e.m83632t());
        C9674k syncStrategy = this.uploadCallable.callbackHandler.getSyncStrategy();
        if (syncStrategy == null) {
            C1120a.m6678w(TAG, "onStop syncStrategy is null");
            return;
        }
        if (C0070h.m527v().m546S()) {
            C1120a.m6678w(TAG, "upload canceled caused by:weak network");
            c13928e.m83619c(107, "weak network");
            return;
        }
        if (syncStrategy.m60421k(false, 3) != C9674k.c.CAN_START_SYNC) {
            String strM60416f = syncStrategy.m60416f(syncStrategy.m60414d());
            C1120a.m6678w(TAG, "upload canceled caused by:" + strM60416f);
            c13928e.m83619c(syncStrategy.m60414d(), strM60416f);
            return;
        }
        if (this.uploadCallable.isCancel()) {
            c13928e.m83619c(this.uploadCallable.getCancelCode(), "upload canceled");
            C1120a.m6678w(TAG, "canceled");
            return;
        }
        FileInfo fileInfo3 = this.fileInfo;
        if (!C10278a.m63442h(fileInfo3 != null ? fileInfo3.getLocalRealPath() : "").exists()) {
            c13928e.m83619c(this.uploadCallable.getCancelCode(), "file has been deleted");
        } else {
            SyncSessionManager.m15153t().m15164K(1);
            C0068f.m459d().m468l();
        }
    }
}
