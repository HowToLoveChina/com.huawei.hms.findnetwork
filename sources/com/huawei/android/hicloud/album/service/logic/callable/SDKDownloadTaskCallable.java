package com.huawei.android.hicloud.album.service.logic.callable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadProgress;
import com.huawei.android.hicloud.album.service.report.DownloadOpsReport;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.hicloud.album.service.utils.CompressUtil;
import com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.logic.app.C2290i;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.CloudPhotoDownloadProgress;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import ga.C9899b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p009a8.C0066d;
import p009a8.C0067e;
import p009a8.C0068f;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1123d;
import p031b7.C1124e;
import p220d8.C9049c;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11820b;
import p511o6.C11821c;
import p511o6.C11822d;
import p709vj.C13452e;
import p746wn.C13622a;
import p801y7.C13914b;
import p804ya.C13927d;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class SDKDownloadTaskCallable extends DownloadTaskBaseCallable {
    public static final Timer DOWNPROGRESSTIMER = new Timer();
    private static final String TAG = "SDKDownloadTaskCallable";
    private CallbackHandler callbackHandler;
    SDKDownloadProgressTask sdkDownProgressTask;

    /* renamed from: com.huawei.android.hicloud.album.service.logic.callable.SDKDownloadTaskCallable$1 */
    public class C24281 implements AssetDownloaderProgressListener {
        final /* synthetic */ CloudPhotoDownloadProgress val$progress;

        public C24281(CloudPhotoDownloadProgress cloudPhotoDownloadProgress) {
            cloudPhotoDownloadProgress = cloudPhotoDownloadProgress;
        }

        @Override // com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener
        public void progressChanged(C9899b c9899b) {
            if (((DownloadTaskBaseCallable) SDKDownloadTaskCallable.this).isNeedDownProgress && !((AbstractCallableC2320a) SDKDownloadTaskCallable.this).isCancel) {
                cloudPhotoDownloadProgress.onProgress(c9899b.m61454S(), c9899b.m61458W());
            }
            if (((AbstractCallableC2320a) SDKDownloadTaskCallable.this).isCancel) {
                return;
            }
            C0068f.m459d().m468l();
        }
    }

    public static class SDKDownloadProgressTask extends TimerTask {
        private static final String TAG = "SDKDownloadProgressTask";
        private CallbackHandler callbackHandler;
        private SDKDownloadTaskCallable downloadTask;
        private FileInfo fileInfo;
        private boolean is3DPhoto;
        private String tempFilePath;
        private int thumbType;
        private long totalSize;

        public SDKDownloadProgressTask(CallbackHandler callbackHandler, SDKDownloadTaskCallable sDKDownloadTaskCallable, FileInfo fileInfo, long j10, String str, int i10, boolean z10) {
            this.is3DPhoto = z10;
            this.callbackHandler = callbackHandler;
            this.downloadTask = sDKDownloadTaskCallable;
            this.tempFilePath = str;
            this.fileInfo = fileInfo;
            this.totalSize = j10;
            this.thumbType = i10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            long currentSize = this.downloadTask.getCurrentSize(this.tempFilePath, this.is3DPhoto);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("currentSize is :");
            sb2.append(currentSize);
            sb2.append(";totalSize is:");
            sb2.append(this.totalSize);
            if (this.fileInfo != null) {
                str = ";fileName is:" + C1122c.m6818p0(this.fileInfo.getFileName());
            } else {
                str = "fileInfo is null";
            }
            sb2.append(str);
            C1120a.m6675d(TAG, sb2.toString());
            if (currentSize == -1 || currentSize > this.totalSize) {
                C1120a.m6677i(TAG, "currentSize>totalSize,download finish");
                super.cancel();
                this.downloadTask.cancel(128);
                C1122c.m6694F(this.tempFilePath);
                return;
            }
            if (this.downloadTask.isCancel() || this.fileInfo == null) {
                super.cancel();
                return;
            }
            Bundle bundle = new Bundle();
            FileDownloadProgress fileDownloadProgress = new FileDownloadProgress();
            fileDownloadProgress.setFileSizeByte(this.totalSize);
            fileDownloadProgress.setFileId(this.fileInfo.getFileId());
            fileDownloadProgress.setUniqueId(this.fileInfo.getUniqueId());
            fileDownloadProgress.setFileLoadSizeByte(currentSize);
            fileDownloadProgress.setResolutionType(this.thumbType);
            SyncSessionManager.m15153t().m15164K(2);
            bundle.putParcelable("FileLoadProgress", fileDownloadProgress);
            if (TextUtils.isEmpty(this.fileInfo.getShareId())) {
                this.callbackHandler.sendMessage(9042, bundle);
            } else {
                this.callbackHandler.sendMessage(9052, bundle);
            }
        }
    }

    public SDKDownloadTaskCallable(Context context, CallbackHandler callbackHandler, String str, String str2, Object obj, String str3, int i10, String str4) {
        super(obj);
        this.sdkDownProgressTask = null;
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.savePath = str;
        this.downloadURL = str2;
        this.saveCachePath = str3;
        this.curRetryTimes = i10;
        this.traceId = str4;
    }

    private void cancelDownloadAndCallBack(int i10, int i11) {
        if (this.fileInfo == null) {
            return;
        }
        C1120a.m6677i(TAG, "cancelDownloadAndCallBack fileName: " + C1122c.m6818p0(this.fileInfo.getFileName()));
        boolean zIsEmpty = TextUtils.isEmpty(this.fileInfo.getShareId()) ^ true;
        C13914b c13914b = new C13914b(this.context, this.callbackHandler);
        C13914b.m83362u(this.callbackHandler, this.taskType, this.fileInfoKey, 2, null, zIsEmpty);
        c13914b.m83368M(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, i11);
        c13914b.m83365F(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, i10, zIsEmpty);
    }

    private void checkCompressFile(File file, HashMap<String, String> map) {
        long length = file.length();
        C1120a.m6675d(TAG, "compress size metadata size:" + this.fileInfo.getSize() + " resource size:" + length);
        String strM63452a = C10279b.m63452a(file);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM63452a);
        sb2.append("_uncompressd");
        String string = sb2.toString();
        int iM15282d = CompressUtil.m15282d(strM63452a, string);
        C1120a.m6677i(TAG, "deCompressJPEG return " + iM15282d);
        map.put("decompress size", String.valueOf(length));
        map.put("deCompressCode", String.valueOf(iM15282d));
        if (iM15282d == 0) {
            C1120a.m6677i(TAG, "delete downloadCacheFile isSuccess = " + file.delete());
            File fileM63442h = C10278a.m63442h(string);
            boolean zRenameTo = fileM63442h.renameTo(new File(strM63452a));
            map.put("decompress end size", String.valueOf(fileM63442h.length()));
            C1120a.m6677i(TAG, "rename downloadDecompressFile isSuccess = " + zRenameTo);
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "download_deCompress", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("117_0:1");
        c11060cM66626a.m66635A("decompress");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
    }

    private String checkDownloadCondition() {
        FileInfo fileInfo = this.fileInfo;
        return downloadCondition(fileInfo != null ? !TextUtils.isEmpty(fileInfo.getShareId()) ? this.fileInfo.getShareId() : this.fileInfo.getAlbumId() : null);
    }

    private String checkDownloadPath() {
        String str = this.savePath;
        if (str == null) {
            this.res.put("DownloadFailReason", 124);
            return "1";
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && fileM63442h.isFile()) {
            FileInfo fileInfo = this.fileInfo;
            if (fileInfo == null || ((DownloadTaskBaseCallable) this).thumbType != 0 || fileInfo.getFileType() != 7 || new C2290i().m14446g(this.context, this.savePath)) {
                return "0";
            }
            return null;
        }
        long jM6698G0 = C1122c.m6698G0(getSavePathDownload());
        int i10 = ((DownloadTaskBaseCallable) this).thumbType;
        FileInfo fileInfo2 = this.fileInfo;
        if (!C1122c.m6681A1(i10, jM6698G0, fileInfo2 == null ? 0L : fileInfo2.getSize())) {
            return null;
        }
        this.res.put("DownloadFailReason", 126);
        C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
        this.conditionInfo = "LocalSpaceTooLow, availSize:" + jM6698G0;
        this.conditionCode = "3014";
        C13914b.m83348B(((DownloadTaskBaseCallable) this).thumbType);
        C11822d.m70439c(this.context, ((DownloadTaskBaseCallable) this).thumbType, 126);
        return "10";
    }

    private void checkOrgCachePath() {
        if (((DownloadTaskBaseCallable) this).thumbType != 0) {
            return;
        }
        String lpath = this.fileInfo.getLpath();
        if (TextUtils.isEmpty(this.savePath)) {
            C1120a.m6676e(TAG, "org save path is null:" + C1122c.m6818p0(this.fileInfo.getFileName()));
            return;
        }
        try {
            if (TextUtils.isEmpty(lpath)) {
                int iIndexOf = this.savePath.indexOf(this.fileInfo.getFileName());
                if (iIndexOf < 0 || C10278a.m63442h(this.savePath.substring(0, iIndexOf - 1)).exists()) {
                    return;
                }
                C1120a.m6677i(TAG, "root path is not exist and lpath is null:" + C1122c.m6818p0(this.fileInfo.getFileName()));
                this.savePath = C1124e.m6866j() + "/" + this.fileInfo.getFileName();
                this.saveCachePath = C1124e.m6866j() + "/Pictures/hiddenAlbum/.tmp/" + this.fileInfo.getAlbumId() + "/" + this.fileInfo.getFileName();
            } else {
                int iIndexOf2 = this.savePath.indexOf(lpath);
                if (iIndexOf2 < 0 || C10278a.m63442h(this.savePath.substring(0, iIndexOf2)).exists()) {
                    return;
                }
                C1120a.m6677i(TAG, "root path is not exist:" + C1122c.m6818p0(this.fileInfo.getFileName()));
                this.savePath = C1124e.m6866j() + lpath + "/" + this.fileInfo.getFileName();
                this.saveCachePath = C1124e.m6866j() + "/Pictures/hiddenAlbum/.tmp/" + this.fileInfo.getAlbumId() + "/" + this.fileInfo.getFileName();
            }
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "check org cache error:" + e10.getMessage());
        }
    }

    private String downloadCondition(String str) {
        FileInfo fileInfo = this.fileInfo;
        String uniqueId = fileInfo != null ? TextUtils.isEmpty(fileInfo.getShareId()) ? this.fileInfo.getUniqueId() : this.fileInfo.getHash() : null;
        if (this.taskType != 1) {
            int i10 = ((DownloadTaskBaseCallable) this).thumbType;
            if (i10 == 1 && C11821c.m70428r(this.fileInfo, i10, false)) {
                this.res.put("DownloadFailReason", 149);
                this.conditionInfo = "TaskExecuting";
                this.conditionCode = "3012";
                return "10";
            }
        } else if (DownloadPhotoBase.m14407b(C11820b.m70401f(str, uniqueId, ((DownloadTaskBaseCallable) this).thumbType)) != null && C11821c.m70428r(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, true)) {
            this.res.put("DownloadFailReason", 149);
            this.conditionInfo = "TaskExecuting";
            this.conditionCode = "3012";
            return "10";
        }
        return checkDownloadPath();
    }

    private Object getDownloadUrlFail(int i10) {
        int iM6855a = C1123d.m6855a(this.context);
        C1120a.m6676e(TAG, "checkDownloadUrl fail: " + i10 + " netType: " + iM6855a + " fileName: " + C1122c.m6818p0(this.fileInfo.getFileName()));
        if (iM6855a == 0) {
            this.res.put("DownloadFailReason", 107);
            cancelDownloadAndCallBack(107, 4);
        } else {
            this.res.put("DownloadFailReason", Integer.valueOf(i10));
        }
        this.res.put("code", "1");
        C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(i10), false), "checkDownloadUrl error", "04004", "checkDownloadUrl", this.traceId, true);
        return this.res;
    }

    private String getSavePathDownload() {
        FileInfo fileInfo;
        String strM6871o = C1124e.m6871o(this.context);
        return (((DownloadTaskBaseCallable) this).thumbType != 0 || (fileInfo = this.fileInfo) == null) ? strM6871o : C1124e.m6862f(this.context, fileInfo.getAlbumId(), this.fileInfo.getSize());
    }

    private void reportStartDownload(String str) {
        String strValueOf;
        String str2;
        try {
            C1120a.m6677i(TAG, "reportStartDownload " + str);
            if (this.fileInfo == null) {
                return;
            }
            HashMap map = new HashMap();
            map.put("thumbType", String.valueOf(((DownloadTaskBaseCallable) this).thumbType));
            map.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
            map.put("isForceDownload", String.valueOf(this.isForceDownload ? 1 : 0));
            if (CloudAlbumSettings.m14363h().m14386v()) {
                map.put("galleryNetworkSwitch", String.valueOf(CloudAlbumSettings.m14363h().m14379o() ? 1 : 0));
            }
            C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "reportStartDownload", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            c11060cM66626a.m66635A(str);
            Asset asset = this.asset;
            if (asset != null) {
                String id2 = asset.getId();
                strValueOf = "";
                if (this.asset.getResource() != null) {
                    String id3 = this.asset.getResource().getId();
                    strValueOf = this.asset.getResource().getType() != null ? String.valueOf(this.asset.getResource().getType()) : "";
                    List<SliceObject> objects = this.asset.getResource().getObjects();
                    if (objects != null && objects.size() != 0) {
                        SliceObject sliceObject = objects.get(0);
                        StringBuilder sb2 = new StringBuilder();
                        if (sliceObject.getAccelerateDownloadUrl() != null) {
                            sb2.append(" accelerateDownloadUrl=");
                            sb2.append(sliceObject.getAccelerateDownloadUrl().getUrl());
                        }
                        if (sliceObject.getDownloadUrl() != null) {
                            sb2.append(" downloadUrl=");
                            sb2.append(sliceObject.getDownloadUrl().getUrl());
                        }
                        c11060cM66626a.m66667w(sb2.toString());
                    }
                    String str3 = strValueOf;
                    strValueOf = id3;
                    str2 = str3;
                } else {
                    str2 = "";
                }
                c11060cM66626a.m66638D(id2 + "_" + this.fileInfo.getFileId() + "_" + strValueOf + "_" + str2);
            } else {
                c11060cM66626a.m66638D(this.fileInfo.getFileId());
            }
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "reportStartDownload error:" + e10);
        }
    }

    private void sendMsgUpdateFileStatus(FileInfo fileInfo, int i10, boolean z10, int i11) {
        new C13914b(this.context, this.callbackHandler).m83364E(fileInfo, i10, z10, i11);
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable, com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    @Deprecated
    public Object call() throws Exception {
        String strDownloadResult;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("come into download thread: ");
        FileInfo fileInfo = this.fileInfo;
        sb2.append(fileInfo != null ? C1122c.m6818p0(fileInfo.getFileName()) : "download avatar");
        C1120a.m6677i(TAG, sb2.toString());
        if (((DownloadTaskBaseCallable) this).thumbType == 0) {
            if (this.fileInfo == null) {
                C1120a.m6676e(TAG, "fileInfo is null");
                this.res.put("DownloadFailReason", "fileInfo is null");
                this.res.put("code", "1");
                this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
                return this.res;
            }
            C1120a.m6675d(TAG, "origin fileName: " + C1122c.m6818p0(this.fileInfo.getFileName()));
            if (TextUtils.isEmpty(this.fileInfo.getShareId())) {
                sendMsgUpdateFileStatus(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, false, 1);
            } else {
                sendMsgUpdateFileStatus(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, true, 1);
            }
        }
        if (!isCloudSyncAllowed()) {
            this.res.put("code", "1");
            this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
            return this.res;
        }
        FileInfo fileInfo2 = this.fileInfo;
        if (fileInfo2 != null) {
            boolean z10 = !TextUtils.isEmpty(fileInfo2.getShareId());
            FileInfo fileInfo3 = this.fileInfo;
            String shareId = z10 ? fileInfo3.getShareId() : fileInfo3.getAlbumId();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(shareId);
            sb3.append("_");
            sb3.append(!z10 ? this.fileInfo.getUniqueId() : this.fileInfo.getHash());
            sb3.append("_");
            sb3.append(((DownloadTaskBaseCallable) this).thumbType);
            sb3.append("_");
            this.fileInfoKey = sb3.toString();
            if (C0067e.m443e().m452j(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType)) {
                this.res.put("code", "1");
                this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
                this.res.put("DownloadFailReason", 111);
                C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH), false), "download error not allowed retry " + this.fileInfoKey, "04004", "repeat_download_error", this.traceId, true);
                return this.res;
            }
        }
        String strCheckDownloadCondition = checkDownloadCondition();
        if (strCheckDownloadCondition != null) {
            this.res.put("code", strCheckDownloadCondition);
            this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
            if ("10".equals(strCheckDownloadCondition)) {
                C1122c.m6750X1(this.context, TextUtils.isEmpty(this.conditionCode) ? "001_3002:1" : C1122c.m6713L0(this.conditionCode, true), TextUtils.isEmpty(this.conditionInfo) ? "condition invalid" : this.conditionInfo, "04004", "checkDownloadCondition", this.traceId, true);
            }
            return this.res;
        }
        int iCheckDownloadUrl = checkDownloadUrl();
        if (iCheckDownloadUrl != 0) {
            return getDownloadUrlFail(iCheckDownloadUrl);
        }
        checkOrgCachePath();
        boolean zCheckDir = checkDir(this.savePath, ((DownloadTaskBaseCallable) this).thumbType != 0);
        boolean zCheckDir2 = checkDir(this.saveCachePath, true);
        if (zCheckDir && zCheckDir2) {
            if (this.asset != null) {
                reportStartDownload("downloadV2");
                strDownloadResult = downloadAsset();
            } else {
                reportStartDownload("downloadV1");
                HashMap<String, Long> mapCheckFileBreakSize = checkFileBreakSize();
                strDownloadResult = downloadResult(this.context, mapCheckFileBreakSize.get("fileSize").longValue(), mapCheckFileBreakSize.get("breakPointSize").longValue());
                C0068f.m459d().m469m(System.currentTimeMillis() - jCurrentTimeMillis);
            }
            this.res.put("code", strDownloadResult);
            this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
            C1120a.m6675d(TAG, "End SDKDownload");
            return this.res;
        }
        this.res.put("code", "1");
        this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
        this.res.put("DownloadFailReason", 124);
        String str = "mkdir error, checkSavePath=" + zCheckDir + ", checkCachePath=" + zCheckDir2 + ", thumbType=" + ((DownloadTaskBaseCallable) this).thumbType + ", " + C1122c.m6754Z(((DownloadTaskBaseCallable) this).thumbType) + ", " + C1122c.m6758a0();
        C1120a.m6676e(TAG, str);
        C1122c.m6750X1(this.context, C1122c.m6713L0("3016", true), str, "04004", "checkDir", this.traceId, true);
        return this.res;
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public int checkDownloadUrl() {
        if (!TextUtils.isEmpty(this.downloadURL) || this.asset != null) {
            return 0;
        }
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return 125;
        }
        if (this.isCancel) {
            closeConnect();
            return 115;
        }
        if (!fileInfo.isMigratedData() && TextUtils.isEmpty(this.fileInfo.getShareId()) && CloudAlbumSettings.m14363h().m14376l()) {
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(141), false), "getDownloadUrl error original:" + this.fileInfo.getFileId() + " thumbType:" + ((DownloadTaskBaseCallable) this).thumbType, "04004", OpsReport.m15253b("cloudphoto.file.geturl"), this.traceId, true);
            return 125;
        }
        int iM57058s = C9049c.m57058s(this.context, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, !TextUtils.isEmpty(r12.getShareId()), this.traceId, this.isAlbumClient);
        if (iM57058s == 0) {
            int i10 = ((DownloadTaskBaseCallable) this).thumbType;
            if (i10 == 0) {
                if (TextUtils.isEmpty(this.fileInfo.getFileUrl())) {
                    this.asset = this.fileInfo.getAsset();
                } else {
                    this.downloadURL = this.fileInfo.getFileUrl();
                }
            } else if (i10 == 1 || i10 == 2) {
                if (TextUtils.isEmpty(this.fileInfo.getThumbUrl())) {
                    this.asset = this.fileInfo.getAsset();
                } else {
                    this.downloadURL = this.fileInfo.getThumbUrl();
                }
            }
            if (TextUtils.isEmpty(this.downloadURL) && this.asset == null) {
                return 125;
            }
        }
        return iM57058s;
    }

    public String downloadAsset() throws Throwable {
        try {
            C13927d c13927d = new C13927d(this.traceId);
            HashMap<String, String> map = new HashMap<>();
            map.put("fileSize", String.valueOf(this.fileInfo.getSize()));
            map.put("thumbType", "" + getThumbType());
            map.put("videoThumbId", "" + this.fileInfo.getVideoThumbId());
            map.put("fileType", String.valueOf(this.fileInfo.getFileType()));
            map.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
            map.put("migrate", this.asset.getProperties() != null ? this.asset.getProperties().get("migrate") : "");
            map.put("fileUnique", this.fileInfo.getUploadTime());
            CloudPhotoDownloadProgress cloudPhotoDownloadProgress = new CloudPhotoDownloadProgress(getThumbType(), this.fileInfo);
            cloudPhotoDownloadProgress.setCallbackHandler(this.callbackHandler);
            c13927d.m83591t(new AssetDownloaderProgressListener() { // from class: com.huawei.android.hicloud.album.service.logic.callable.SDKDownloadTaskCallable.1
                final /* synthetic */ CloudPhotoDownloadProgress val$progress;

                public C24281(CloudPhotoDownloadProgress cloudPhotoDownloadProgress2) {
                    cloudPhotoDownloadProgress = cloudPhotoDownloadProgress2;
                }

                @Override // com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener
                public void progressChanged(C9899b c9899b) {
                    if (((DownloadTaskBaseCallable) SDKDownloadTaskCallable.this).isNeedDownProgress && !((AbstractCallableC2320a) SDKDownloadTaskCallable.this).isCancel) {
                        cloudPhotoDownloadProgress.onProgress(c9899b.m61454S(), c9899b.m61458W());
                    }
                    if (((AbstractCallableC2320a) SDKDownloadTaskCallable.this).isCancel) {
                        return;
                    }
                    C0068f.m459d().m468l();
                }
            });
            c13927d.m83592u(this.fileInfo.getUserID());
            c13927d.m83587p(this.isAlbumClient);
            c13927d.m83578g(C10278a.m63442h(this.saveCachePath), C1122c.m6814o0(this.fileInfo), this.asset, ((DownloadTaskBaseCallable) this).thumbType, map, this.fileInfo);
            C1120a.m6677i(TAG, "download file end");
            Resource resource = this.asset.getResource();
            if (((DownloadTaskBaseCallable) this).thumbType == 0 && resource.getType().intValue() == 6 && CloudAlbumSettings.m14363h().m14375k()) {
                checkCompressFile(C10278a.m63442h(this.saveCachePath), map);
            }
            if (C0066d.m437a(this.saveCachePath, this.asset, ((DownloadTaskBaseCallable) this).thumbType, C1122c.m6814o0(this.fileInfo), this.traceId)) {
                return downloadFinishRename(this.saveCachePath);
            }
            C1120a.m6676e(TAG, "different size delete file isSuccess = " + C1122c.m6694F(this.saveCachePath));
            return "1";
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "downloadAsset Exception:" + e10.toString());
            return "1";
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public String downloadFinishRename(String str) {
        C1120a.m6675d(TAG, "downloadCachePath: " + str);
        File fileM63442h = C10278a.m63442h(this.savePath);
        if (!str.equals(this.savePath)) {
            if (fileM63442h.exists()) {
                C1122c.m6694F(this.savePath);
            }
            C1120a.m6675d(TAG, "downloadCachePath: " + str);
            C1122c.m6735S1(str, this.savePath);
            if (!C10278a.m63442h(this.savePath).exists()) {
                this.res.put("DownloadFailReason", 127);
                return "1";
            }
        }
        if (((DownloadTaskBaseCallable) this).thumbType != 0) {
            return "0";
        }
        MediaScannerConnection.scanFile(this.context, new String[]{this.savePath}, null, null);
        return "0";
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public boolean getNeedAT() {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return false;
        }
        return fileInfo.isNeedAT();
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleAuthFailed() {
        this.callbackHandler.stInvalid(true);
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleCloseExecuting() {
        C1120a.m6675d(TAG, "handleCloseExecuting start");
        SDKDownloadProgressTask sDKDownloadProgressTask = this.sdkDownProgressTask;
        if (sDKDownloadProgressTask != null) {
            try {
                sDKDownloadProgressTask.cancel();
            } catch (RuntimeException e10) {
                C1120a.m6676e(TAG, "handleCloseExecuting cancel error!error message:" + e10.getMessage());
            }
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleDownloadWrite(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.writecount = 0L;
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                break;
            }
            this.writecount += i10;
            boolean z10 = this.isForceDownload;
            int i11 = ((DownloadTaskBaseCallable) this).thumbType;
            if (this.fileInfo == null) {
                i11 = 0;
                z10 = true;
            }
            if (!this.callbackHandler.canStartDownloading(z10, i11)) {
                C1120a.m6676e(TAG, "SyncStrategy not allow, break!");
                this.cancelCode = this.callbackHandler.getSyncStrategy().m60414d();
                this.isCancel = true;
                break;
            } else if (this.isCancel) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cancel break ");
                FileInfo fileInfo = this.fileInfo;
                sb2.append(C1122c.m6818p0(fileInfo != null ? fileInfo.getFileName() : ""));
                C1120a.m6677i(TAG, sb2.toString());
            } else {
                outputStream.write(bArr, 0, i10);
                outputStream.flush();
            }
        }
        C1120a.m6675d(TAG, "downloadFile write count:" + this.writecount + ", thumbType:" + ((DownloadTaskBaseCallable) this).thumbType);
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void handleProgressWhileExecuting(FileInfo fileInfo, long j10, String str, int i10, boolean z10) throws Exception {
        SDKDownloadProgressTask sDKDownloadProgressTask = new SDKDownloadProgressTask(this.callbackHandler, this, fileInfo, j10, str, i10, z10);
        this.sdkDownProgressTask = sDKDownloadProgressTask;
        DOWNPROGRESSTIMER.schedule(sDKDownloadProgressTask, 300L, 500L);
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public boolean isLostData() {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return false;
        }
        return fileInfo.isLostData();
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void reportOperationData(HashMap<String, String> map, long j10, int i10, String str, FileInfo fileInfo, String str2) {
        if (fileInfo != null) {
            new DownloadOpsReport(this.context).m15219E(map.get("S-U-SERVERIP"), map.get("S-U-TIME"), this.writecount, i10, str, fileInfo, str2, this.traceId, this.contentLength, ((DownloadTaskBaseCallable) this).thumbType, map.containsKey("S-U-ERRORCODE") ? String.valueOf(map.get("S-U-ERRORCODE")) : "", map.containsKey("S-U-ERRORMSG") ? String.valueOf(map.get("S-U-ERRORMSG")) : "", ((DownloadTaskBaseCallable) this).thumbType != 0 ? map.get("key_error_second_code") : null, isPriority() ? "0" : "1", this.isForceDownload);
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public void updateRestoreSuccessFile(FileInfo fileInfo) {
        if (fileInfo == null) {
            return;
        }
        new C13914b(this.context, this.callbackHandler).m83367L(fileInfo, 0);
    }

    public SDKDownloadTaskCallable(Context context, CallbackHandler callbackHandler, String str, String str2, Object obj, String str3, boolean z10, int i10, String str4, int i11, int i12, boolean z11, String str5, boolean z12) {
        super(obj, i10);
        this.sdkDownProgressTask = null;
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.savePath = str;
        this.downloadURL = str2;
        FileInfo fileInfo = (FileInfo) obj;
        this.fileInfo = fileInfo;
        this.saveCachePath = str3;
        this.isNeedDownProgress = z10;
        ((DownloadTaskBaseCallable) this).thumbType = i10;
        this.resource = str4;
        this.taskType = i11;
        this.curRetryTimes = i12;
        this.isForceDownload = z11;
        this.traceId = str5;
        this.asset = fileInfo.getAsset();
        this.isAlbumClient = z12;
    }
}
