package com.huawei.android.hicloud.album.service.logic.callable;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.BaseUploadCallable;
import hk.C10278a;
import java.io.File;
import java.util.HashMap;
import p009a8.C0076n;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;
import p031b7.C1136q;

/* loaded from: classes2.dex */
public abstract class SDKUploadAsyncBaseCallable extends BaseUploadCallable {
    protected static final String STR_LCD_CHECKSUM = "lcdChecksum";
    protected static final String STR_LCD_FILEID = "lcdFileId";
    protected static final String STR_ORG_CHECKSUM = "orgChecksum";
    protected static final String STR_ORG_FILEID = "orgFileId";
    protected static final String STR_ORG_MD5 = "md5";
    protected static final String STR_ORG_SIZE = "size";
    protected static final String STR_THUMB_CHECKSUM = "thumbChecksum";
    protected static final String STR_THUMB_FILEID = "thumbFileId";
    protected static final String STR_VIDEO_THUMB_ID = "videoThumbId";
    protected static final String TAG = "SDKUploadAsyncBaseCallable";
    protected HashMap<String, String> resMap;

    public SDKUploadAsyncBaseCallable(Object obj) {
        super(obj);
        this.resMap = new HashMap<>();
    }

    private String getUploadAttachFileId() {
        int fileType = this.preFileInfo.getFileType();
        if (fileType == -1 || fileType == 0) {
            fileType = C1125f.m6892m(this.preFileInfo.getLocalRealPath());
        }
        if (fileType == -1) {
            C1120a.m6676e(TAG, "fileType is unkown");
            return null;
        }
        String str = fileType == 4 ? this.resMap.get(STR_LCD_FILEID) : "";
        this.resMap.put(STR_VIDEO_THUMB_ID, str);
        return str;
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public int checkFileInvalid(FileInfo fileInfo) {
        if (!checkFileExists(fileInfo.getLocalThumbPath())) {
            C1120a.m6676e(TAG, "thumb file not exists, path: " + fileInfo.getLocalThumbPath());
            return 116;
        }
        if (checkFileExists(fileInfo.getLocalBigThumbPath())) {
            if (!SyncSessionManager.m15153t().m15155B("cloudphoto.file.create", this.traceId, fileInfo.getAlbumId())) {
                return super.checkFileInvalid(fileInfo);
            }
            C1120a.m6676e(TAG, "checkFileInvalid albumID error too much");
            return 8;
        }
        C1120a.m6676e(TAG, "LCD file not exists, path: " + fileInfo.getLocalBigThumbPath());
        return 116;
    }

    public int checkSum() {
        String str = this.resMap.get(STR_ORG_MD5);
        if (!TextUtils.isEmpty(str) && !str.equals(this.preFileInfo.getHash())) {
            C1120a.m6678w(TAG, "md5Vfs is " + str + " not equals " + this.preFileInfo.getHash());
            return SyncType.RISK_MANAGEMENT_MANUALLY;
        }
        String str2 = this.resMap.get(STR_ORG_SIZE);
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (str2.equals("" + this.preFileInfo.getSize())) {
            return 0;
        }
        C1120a.m6678w(TAG, "sizeVfs is " + str2 + " not equals " + this.preFileInfo.getSize());
        return SyncType.AUTO_SYNC_PHONE_MANAGER;
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public void handleHttpError(boolean z10, String str) {
        if (z10) {
            this.isCancel = true;
        }
    }

    public int uploadFileDataToCloud() {
        return 0;
    }

    public int uploadFilesToServer() throws Throwable {
        int iUploadOneFileToCloud = uploadOneFileToCloud(this.preFileInfo.getLocalRealPath(), 0);
        if (iUploadOneFileToCloud != 0) {
            return iUploadOneFileToCloud;
        }
        int iUploadOneFileToCloud2 = uploadOneFileToCloud(this.preFileInfo.getLocalBigThumbPath(), 1);
        if (iUploadOneFileToCloud2 != 0) {
            return iUploadOneFileToCloud2;
        }
        int iUploadOneFileToCloud3 = uploadOneFileToCloud(this.preFileInfo.getLocalThumbPath(), 2);
        if (iUploadOneFileToCloud3 != 0) {
            return iUploadOneFileToCloud3;
        }
        if (getUploadAttachFileId() == null) {
            return 101;
        }
        return uploadFileDataToCloud();
    }

    public int uploadFromLocal() throws Throwable {
        if (this.preFileInfo.isMigratedData()) {
            return uploadFileDataToCloud();
        }
        int iUploadFilesToServer = uploadFilesToServer();
        return iUploadFilesToServer == 805 ? uploadFilesToServer() : iUploadFilesToServer;
    }

    public int uploadOneFileToCloud(String str, int i10) throws Throwable {
        File fileM63442h;
        HashMap<String, String> mapCloudPhotoUpload;
        C1120a.m6677i(TAG, "begin upload fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()) + " thumbType: " + i10);
        setThumbType(i10);
        int i11 = 101;
        try {
            fileM63442h = C10278a.m63442h(str);
            mapCloudPhotoUpload = cloudPhotoUpload(this.context, fileM63442h, fileM63442h.getName());
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "autoUploadFromLocal exception:" + e10.toString());
        }
        if (mapCloudPhotoUpload.get("fileId") != null && mapCloudPhotoUpload.get("checksum") != null) {
            C1120a.m6677i(TAG, "upload success fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()) + " thumbType: " + i10);
            i11 = 0;
            if (i10 == 0) {
                this.resMap.put(STR_ORG_FILEID, mapCloudPhotoUpload.get("fileId"));
                this.resMap.put(STR_ORG_CHECKSUM, mapCloudPhotoUpload.get("checksum"));
                this.resMap.put(STR_ORG_MD5, mapCloudPhotoUpload.get(STR_ORG_MD5));
                this.resMap.put(STR_ORG_SIZE, mapCloudPhotoUpload.get(STR_ORG_SIZE));
                this.preFileInfo.setFileId(mapCloudPhotoUpload.get("fileId"));
            } else if (i10 == 1) {
                this.resMap.put(STR_LCD_FILEID, mapCloudPhotoUpload.get("fileId"));
                this.resMap.put(STR_LCD_CHECKSUM, mapCloudPhotoUpload.get("checksum"));
                this.preFileInfo.setLcdFileId(mapCloudPhotoUpload.get("fileId"));
            } else if (i10 == 2) {
                this.resMap.put(STR_THUMB_FILEID, mapCloudPhotoUpload.get("fileId"));
                this.resMap.put(STR_THUMB_CHECKSUM, mapCloudPhotoUpload.get("checksum"));
                this.preFileInfo.setThumbFileId(mapCloudPhotoUpload.get("fileId"));
            }
            return i11;
        }
        C1120a.m6676e(TAG, "return fileid or checksum is null, fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()) + " type: " + i10);
        String str2 = mapCloudPhotoUpload.get("vfs_error_code");
        if (String.valueOf(507).equals(str2)) {
            C0076n.m619a().m627i(fileM63442h.length() + C1136q.b.m7089q(this.context, "userCapacityUsed"));
            C1120a.m6678w(TAG, "checkUserLocalSpaceEnough low space from vfs");
            return 122;
        }
        if (!String.valueOf(500).equals(str2) && !String.valueOf(3306).equals(str2) && !String.valueOf(3308).equals(str2)) {
            return 121;
        }
        C1120a.m6678w(TAG, "uploadOneFileToCloud  vfs return 500");
        return 1009;
    }
}
