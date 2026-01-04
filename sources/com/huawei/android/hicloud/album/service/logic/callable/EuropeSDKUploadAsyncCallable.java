package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.CloudPhotoUploadProgress;
import com.huawei.android.p069cg.request.callable.CloudPhotoUploadV2Progress;
import com.huawei.android.p069cg.request.callable.EuropeUploadAsyncCallable;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;
import p031b7.C1136q;
import p365ic.C10466a;
import p511o6.C11820b;
import p511o6.C11821c;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p704v9.C13387c;
import p709vj.C13452e;
import p783xp.AbstractC13844b;
import p801y7.C13915c;
import p801y7.C13916d;

/* loaded from: classes2.dex */
public class EuropeSDKUploadAsyncCallable extends EuropeUploadAsyncCallable {
    private static final String TAG = "EuropeSDKUploadAsyncCallable";
    private String lockToken;

    public EuropeSDKUploadAsyncCallable(Context context, Object obj, String str, String str2, CallbackHandler callbackHandler) {
        super(context, obj);
        this.context = context;
        this.preFileInfo = (FileInfo) obj;
        this.lockToken = str;
        this.traceId = str2;
        this.callbackHandler = callbackHandler;
        this.uploadService = new C12478a(EnumC12999a.CLOUD_ALBUM, str2);
    }

    private void notifyUploadError(Context context, FileInfo fileInfo, String str) {
        C1120a.m6677i(TAG, "notifyUploadError fileUpType:" + str);
        C13916d.m83389A(context, null, null);
    }

    @Override // com.huawei.android.p069cg.request.callable.EuropeUploadAsyncCallable, com.huawei.android.p069cg.request.callable.BaseUploadCallable, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        C1120a.m6677i(TAG, "come into upload thread fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()));
        if (!checkFileType()) {
            C1120a.m6676e(TAG, "check file type error");
            return 101;
        }
        if (!isCloudSyncAllowed()) {
            C11821c.m70420j("0");
            return 101;
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
            C1120a.m6676e(TAG, "user space not enough");
            return 122;
        }
        if ("8".equals(strCheckUserSpaceEnough)) {
            return Integer.valueOf(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED);
        }
        C1120a.m6675d(TAG, "upload path: " + this.preFileInfo.getFileUploadType());
        int iUploadFromLocal = uploadFromLocal();
        if ("3".equals(String.valueOf(iUploadFromLocal)) || "1".equals(String.valueOf(iUploadFromLocal))) {
            C1120a.m6676e(TAG, "upload failed: " + iUploadFromLocal);
        } else if ("0".equals(String.valueOf(iUploadFromLocal))) {
            C1120a.m6675d(TAG, "clear retry count");
            C1136q.b.m7047c(this.context);
        }
        return Integer.valueOf(iUploadFromLocal);
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public int checkFileInvalid(FileInfo fileInfo) {
        if (SyncSessionManager.m15153t().m15155B("cloudphoto.file.create", this.traceId, fileInfo.getAlbumId())) {
            C1120a.m6676e(TAG, "checkFileInvalid albumID error too much");
            return 8;
        }
        if (!checkFileExists(fileInfo.getLocalRealPath())) {
            C1120a.m6676e(TAG, "org file not exists, path: " + fileInfo.getLocalRealPath());
            return 116;
        }
        if (!checkFileExists(fileInfo.getLocalThumbPath())) {
            C1120a.m6676e(TAG, "thumb file not exists, path: " + fileInfo.getLocalThumbPath());
            return 116;
        }
        if (checkFileExists(fileInfo.getLocalBigThumbPath())) {
            return super.checkFileInvalid(fileInfo);
        }
        C1120a.m6676e(TAG, "LCD file not exists, path: " + fileInfo.getLocalBigThumbPath());
        return 116;
    }

    @Override // com.huawei.android.p069cg.request.callable.EuropeUploadAsyncCallable
    public boolean checkFileType() {
        int fileType = this.preFileInfo.getFileType();
        if (-1 == fileType) {
            fileType = C1125f.m6892m(this.preFileInfo.getLocalRealPath());
            C1120a.m6677i(TAG, "checkFileType FILE_TYPE_UNKONWN(-1) recheck to " + fileType);
            this.preFileInfo.setFileType(fileType);
        }
        return -1 != fileType;
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public void handleHttpError(boolean z10, String str) {
        if (z10) {
            C11821c.m70421k(this.preFileInfo);
        }
        notifyUploadError(this.context, this.preFileInfo, str);
    }

    public int uploadFileDataToCloudV2() throws Throwable {
        String strM70399d;
        String str;
        C1120a.m6677i(TAG, "uploadFileDataToCloud begin");
        this.preFileInfo.setFileId("NMD");
        this.preFileInfo.setSource(Build.MODEL);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80900d = C13452e.m80781L().m80900d();
        this.preFileInfo.setUserID(strM80971t0);
        this.preFileInfo.setCreaterId(strM80971t0);
        this.preFileInfo.setCreaterAccount(strM80900d);
        this.preFileInfo.setBatchId(0);
        this.preFileInfo.setBatchCtime(0L);
        if (this.preFileInfo.isMigratedData()) {
            strM70399d = C11820b.m70400e(this.context, this.preFileInfo, null);
            str = "";
        } else {
            try {
                String strM83106b = AbstractC13844b.m83106b();
                DataEncryptReq dataEncryptReq = new DataEncryptReq();
                dataEncryptReq.setDek(strM83106b);
                dataEncryptReq.setSrcData(strM80900d);
                try {
                    EncryptedData encryptedDataM64323n = C10466a.m64323n(dataEncryptReq);
                    String data = encryptedDataM64323n.getData();
                    this.preFileInfo.setCreaterAccount(data);
                    strM70399d = C11820b.m70399d(this.preFileInfo, encryptedDataM64323n.getEdek(), strM83106b);
                    String keyGuid = encryptedDataM64323n.getKeyGuid();
                    if (!TextUtils.isEmpty(this.unstrGuid) && !this.unstrGuid.equals(keyGuid)) {
                        C1120a.m6676e(TAG, "guid is not equal");
                        return 708;
                    }
                    str = keyGuid;
                    strM80900d = data;
                } catch (C9721b e10) {
                    C1120a.m6676e(TAG, "encrypt data error: " + e10.getMessage());
                    return 1002;
                }
            } catch (NoSuchAlgorithmException e11) {
                C1120a.m6676e(TAG, "getChallenge exception: " + e11.toString());
                return 101;
            }
        }
        this.preFileInfo.setExpand(strM70399d);
        this.preFileInfo.setCreaterAccount(strM80900d);
        this.preFileInfo.setBatchId(0);
        this.preFileInfo.setBatchCtime(0L);
        this.preFileInfo.setOversion(0L);
        this.preFileInfo.setIsNew(0);
        C13915c c13915c = new C13915c();
        c13915c.m83387j(new CloudPhotoUploadV2Progress(this, this.preFileInfo));
        return c13915c.m83379b(this.context, this.preFileInfo, this.lockToken, null, str, false, this.traceId, this.callbackHandler);
    }

    public int uploadFromLocal() throws Throwable {
        C13387c backupStatus;
        C1120a.m6675d(TAG, "autoUploadFromLocal");
        if (this.preFileInfo.isMigratedData()) {
            return uploadFileDataToCloudV2();
        }
        UploadReq uploadReq = new UploadReq();
        HashMap map = new HashMap();
        String albumId = TextUtils.isEmpty(this.preFileInfo.getShareId()) ? this.preFileInfo.getAlbumId() : this.preFileInfo.getShareId();
        map.put("thumbType", "" + getThumbType());
        map.put("fileUnique", "" + albumId + "_" + this.preFileInfo.getLpath());
        map.put("battery", C1122c.m6748X(this.context));
        map.put("fileType", String.valueOf(this.preFileInfo.getFileType()));
        uploadReq.setExtraStatKeyValues(map);
        try {
            File fileM63442h = C10278a.m63442h(this.preFileInfo.getLocalThumbPath());
            File fileM63442h2 = C10278a.m63442h(this.preFileInfo.getLocalBigThumbPath());
            File fileM63442h3 = C10278a.m63442h(this.preFileInfo.getLocalRealPath());
            Thumbnail[] thumbnailArr = {new Thumbnail("small", fileM63442h), new Thumbnail("large", fileM63442h2)};
            C1120a.m6677i(TAG, "upload file: " + C1122c.m6818p0(this.preFileInfo.getLocalRealPath()));
            String str = "/GallerySync/" + this.preFileInfo.getAlbumId() + "/" + this.preFileInfo.getFileName();
            uploadReq.setFile(fileM63442h3);
            uploadReq.setServer(str);
            uploadReq.setThumbnails(thumbnailArr);
            Map<String, Object> treeMap = new TreeMap<>();
            treeMap.put("merge", Boolean.FALSE);
            uploadReq.setCallback(new CloudPhotoUploadProgress(this.context, this, this.preFileInfo, this.callbackHandler));
            uploadReq.setAttribute(treeMap);
            this.uploadService.m74908d(uploadReq);
            backupStatus = uploadReq.getBackupStatus();
            C1120a.m6675d(TAG, "isTimeout: " + this.isTimeout);
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "normalUpload exception:" + e10.toString());
            C13387c backupStatus2 = uploadReq.getBackupStatus();
            if (e10.m60663g() != 301) {
                return e10.m60663g() == 9009 ? 9009 : 101;
            }
            if (!isEquals(uploadReq, backupStatus2)) {
                return 6;
            }
            backupStatus = backupStatus2;
        }
        this.unstrGuid = backupStatus.m80419d();
        int iUploadFileDataToCloudV2 = uploadFileDataToCloudV2();
        if (iUploadFileDataToCloudV2 != 708) {
            return iUploadFileDataToCloudV2;
        }
        if (resetUserKeyAndMakefile(uploadReq)) {
            return uploadFileDataToCloudV2();
        }
        return 101;
    }
}
