package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Build;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.CloudPhotoUploadV2Progress;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import p031b7.C1120a;
import p031b7.C1122c;
import p511o6.C11820b;
import p709vj.C13452e;
import p801y7.C13915c;

/* loaded from: classes2.dex */
public class SDKUploadAsyncCallable extends SDKUploadAsyncBaseCallable {
    private static final String TAG = "SDKUploadAsyncCallable";
    private String lockToken;

    public SDKUploadAsyncCallable(Context context, Object obj, String str, String str2, CallbackHandler callbackHandler) {
        super(obj);
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.preFileInfo = (FileInfo) obj;
        this.lockToken = str;
        this.traceId = str2;
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        C1120a.m6675d(TAG, "come into upload thread");
        if (!isCloudSyncAllowed()) {
            return 1;
        }
        int iCheckFileInvalid = checkFileInvalid(this.preFileInfo);
        if (iCheckFileInvalid != 0) {
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(iCheckFileInvalid), true), "check file invalid", "04005", "checkFileInvalid", this.traceId, true);
            return Integer.valueOf(iCheckFileInvalid);
        }
        String strCheckUserSpaceEnough = checkUserSpaceEnough();
        if ("7".equals(strCheckUserSpaceEnough)) {
            C1120a.m6676e(TAG, "check space error");
            C1122c.m6750X1(this.context, C1122c.m6713L0("3025", true), "check space error", "04005", "checkUserSpaceEnough", this.traceId, true);
            return 121;
        }
        if ("5".equals(strCheckUserSpaceEnough)) {
            SyncSessionManager.m15153t().m15173T(true);
            C1120a.m6676e(TAG, "user space not enough");
            return 122;
        }
        if ("8".equals(strCheckUserSpaceEnough)) {
            return Integer.valueOf(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED);
        }
        int iUploadFromLocal = uploadFromLocal();
        if (iUploadFromLocal == 0) {
            C1120a.m6675d(TAG, "clear fail count");
        }
        return Integer.valueOf(iUploadFromLocal);
    }

    @Override // com.huawei.android.hicloud.album.service.logic.callable.SDKUploadAsyncBaseCallable
    public int uploadFileDataToCloud() throws Throwable {
        C1120a.m6677i(TAG, "uploadFileDataToCloud begin");
        int iCheckSum = checkSum();
        if (iCheckSum != 0) {
            return iCheckSum;
        }
        this.preFileInfo.setFileId(this.resMap.get("orgFileId"));
        this.preFileInfo.setVideoThumbId(this.resMap.get("videoThumbId"));
        this.preFileInfo.setSource(Build.MODEL);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80900d = C13452e.m80781L().m80900d();
        this.preFileInfo.setUserID(strM80971t0);
        this.preFileInfo.setCreaterId(strM80971t0);
        this.preFileInfo.setCreaterAccount(strM80900d);
        this.preFileInfo.setBatchId(0);
        this.preFileInfo.setBatchCtime(0L);
        this.preFileInfo.setExpand(C11820b.m70400e(this.context, this.preFileInfo, null));
        this.preFileInfo.setOversion(0L);
        this.preFileInfo.setIsNew(0);
        this.preFileInfo.setAlbumId(this.preFileInfo.getAlbumId());
        this.preFileInfo.setShareId("");
        C13915c c13915c = new C13915c();
        c13915c.m83387j(new CloudPhotoUploadV2Progress(this, this.preFileInfo));
        return c13915c.m83379b(this.context, this.preFileInfo, this.lockToken, this.resMap.get("orgChecksum"), null, false, this.traceId, this.callbackHandler);
    }
}
