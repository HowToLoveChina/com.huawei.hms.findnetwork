package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.CloudPhotoUploadV2Progress;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import hk.C10278a;
import java.io.File;
import p031b7.C1120a;
import p031b7.C1122c;
import p511o6.C11820b;
import p701v6.C13361h;
import p801y7.C13915c;

/* loaded from: classes2.dex */
public class SDKUploadShareAsyncCallable extends SDKUploadAsyncBaseCallable {
    private static final String TAG = "SDKUploadShareAsyncCallable";

    public SDKUploadShareAsyncCallable(Context context, Object obj, String str, CallbackHandler callbackHandler) {
        super(obj);
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.preFileInfo = (FileInfo) obj;
        this.traceId = str;
    }

    private String checkShareSpaceEnough(String str) {
        QueryUserSpaceResponse queryUserSpaceResponseM80113o;
        int code;
        String shareId = this.preFileInfo.getShareId();
        String resource = this.preFileInfo.getResource();
        C1120a.m6677i(TAG, "checkShareSpaceEnough resource: " + resource);
        if (TextUtils.isEmpty(resource)) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough resource is null or empty");
            return "7";
        }
        try {
            queryUserSpaceResponseM80113o = new C13361h(this.context, str, resource, shareId, this.traceId, false).m80113o(QueryUserSpaceResponse.class);
            code = queryUserSpaceResponseM80113o.getCode();
            C1120a.m6677i(TAG, "checkShareSpaceEnough bapi.dbank.queryspace: " + code);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough error: " + e10.toString());
        }
        if (code == 401) {
            this.callbackHandler.stInvalid(true);
            C1120a.m6676e(TAG, "checkShareSpaceEnough auth error");
            return "7";
        }
        if (code != 0) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough error: " + code + ",info: " + queryUserSpaceResponseM80113o.getInfo());
            return "7";
        }
        long useSpaceSize = queryUserSpaceResponseM80113o.getUseSpaceSize();
        long totalSpaceSize = queryUserSpaceResponseM80113o.getTotalSpaceSize();
        File fileM63442h = C10278a.m63442h(this.preFileInfo.getLocalRealPath());
        if (totalSpaceSize > useSpaceSize && fileM63442h.length() <= totalSpaceSize - useSpaceSize) {
            return "0";
        }
        C1120a.m6678w(TAG, "checkShareSpace too low, total: " + totalSpaceSize + ", used: " + useSpaceSize + ", upload size: " + fileM63442h.length());
        return "5";
    }

    private String checkSpaceEnough() {
        String createrId = this.preFileInfo.getCreaterId();
        String userID = this.preFileInfo.getUserID();
        if (TextUtils.isEmpty(createrId) || TextUtils.isEmpty(userID)) {
            C1120a.m6676e(TAG, "upload sharePhoto userId or createrId illegal");
            return "1";
        }
        C1120a.m6675d(TAG, "upload share info userId: " + this.preFileInfo.getUserID() + ", createId: " + this.preFileInfo.getCreaterId() + ", Source: " + this.preFileInfo.getSource() + ", ShareId: " + this.preFileInfo.getShareId());
        return createrId.equals(userID) ? checkUserSpaceEnough() : checkShareSpaceEnough(userID);
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        C1120a.m6675d(TAG, "come into upload thread,upload fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()) + ", fileHash: " + this.preFileInfo.getHash() + ", fileShareId: " + this.preFileInfo.getShareId() + ", fileStatus: 1");
        if (!isCloudSyncAllowed()) {
            return 1;
        }
        int iCheckFileInvalid = checkFileInvalid(this.preFileInfo);
        if (iCheckFileInvalid != 0) {
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(iCheckFileInvalid), true), "check file invalid", "04005", "checkFileInvalid", this.traceId, true);
            return Integer.valueOf(iCheckFileInvalid);
        }
        FileInfo fileInfo = this.preFileInfo;
        fileInfo.setShareId(fileInfo.getAlbumId());
        String strCheckSpaceEnough = checkSpaceEnough();
        if ("7".equals(strCheckSpaceEnough)) {
            return 121;
        }
        if ("5".equals(strCheckSpaceEnough)) {
            return 122;
        }
        return "8".equals(strCheckSpaceEnough) ? Integer.valueOf(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED) : Integer.valueOf(uploadFromLocal());
    }

    @Override // com.huawei.android.hicloud.album.service.logic.callable.SDKUploadAsyncBaseCallable, com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public int checkFileInvalid(FileInfo fileInfo) {
        if (!TextUtils.isEmpty(fileInfo.getHash()) && ((!TextUtils.isEmpty(fileInfo.getShareId()) || !TextUtils.isEmpty(fileInfo.getAlbumId())) && !TextUtils.isEmpty(fileInfo.getUserID()))) {
            return super.checkFileInvalid(fileInfo);
        }
        C1120a.m6676e(TAG, "share file params error, fileName: " + C1122c.m6818p0(fileInfo.getFileName()));
        return 119;
    }

    @Override // com.huawei.android.hicloud.album.service.logic.callable.SDKUploadAsyncBaseCallable
    public int uploadFileDataToCloud() throws Throwable {
        int iCheckSum = checkSum();
        if (iCheckSum != 0) {
            return iCheckSum;
        }
        this.preFileInfo.setFileId(this.resMap.get("orgFileId"));
        this.preFileInfo.setVideoThumbId(this.resMap.get("videoThumbId"));
        this.preFileInfo.setSource(Build.MODEL);
        this.preFileInfo.setExpand(C11820b.m70400e(this.context, this.preFileInfo, null));
        this.preFileInfo.setOversion(0L);
        this.preFileInfo.setAlbumId(this.preFileInfo.getShareId());
        C13915c c13915c = new C13915c();
        c13915c.m83387j(new CloudPhotoUploadV2Progress(this, this.preFileInfo));
        return c13915c.m83379b(this.context, this.preFileInfo, null, this.resMap.get("orgChecksum"), null, false, this.traceId, this.callbackHandler);
    }
}
